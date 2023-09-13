package com.baidu.searchbox.download.manager;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.DownloadCallBack;
import com.baidu.searchbox.download.component.DownloadProvider;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.statistics.ApkCloudStatisticsUtils;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.ExternalStorageCallBack;
import com.baidu.searchbox.downloads.DSUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.b20;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes3.dex */
public class DownloadManager {
    public static final String ACTION_DOWNLOAD_COMPLETE = "com.baidu.searchbox.intent.action.DOWNLOAD_COMPLETE";
    public static final String ACTION_NOTIFICATION_CLICKED = "com.baidu.searchbox.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
    public static final String ACTION_VIEW_DOWNLOADS = "com.baidu.searchbox.intent.action.VIEW_DOWNLOADS";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
    public static final String COLUMN_REASON = "reason";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TOTAL_SIZE_BYTES = "total_bytes";
    public static final String COLUMN_URI = "uri";
    public static final int ERROR_CANNOT_RESUME = 1008;
    public static final int ERROR_DEVICE_NOT_FOUND = 1007;
    public static final int ERROR_FILE_ALREADY_EXISTS = 1009;
    public static final int ERROR_FILE_ERROR = 1001;
    public static final int ERROR_HTTP_DATA_ERROR = 1004;
    public static final int ERROR_INSUFFICIENT_SPACE = 1006;
    public static final int ERROR_TOO_MANY_REDIRECTS = 1005;
    public static final int ERROR_UNHANDLED_HTTP_CODE = 1002;
    public static final int ERROR_UNKNOWN = 1000;
    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final int PAUSED_QUEUED_FOR_WIFI = 3;
    public static final int PAUSED_UNKNOWN = 4;
    public static final int PAUSED_WAITING_FOR_NETWORK = 2;
    public static final int PAUSED_WAITING_TO_RETRY = 1;
    public static final int RESUME_DOWNLOAD_PART_SIZE = 20;
    public static final int SQLDB_OPERATION_FAILED = 0;
    public static final int SQLDB_OPERATION_SUCCESS = 1;
    public static final int STATUS_FAILED = 16;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_RUNNING = 2;
    public static final int STATUS_SUCCESSFUL = 8;
    public static final String TAG = "DownloadManager";
    public Uri mBaseUri = Downloads.Impl.CONTENT_URI;
    public String mPackageName;
    public ContentResolver mResolver;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String COLUMN_MEDIA_TYPE = "media_type";
    public static final String COLUMN_LOCAL_URI = "local_uri";
    public static final String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
    public static final String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    public static final String[] COLUMNS = {"_id", "mediaprovider_uri", "title", "description", "uri", COLUMN_MEDIA_TYPE, "total_bytes", COLUMN_LOCAL_URI, "status", "reason", COLUMN_BYTES_DOWNLOADED_SO_FAR, COLUMN_LAST_MODIFIED_TIMESTAMP, "notificationpackage", "notificationclass", Downloads.Impl.COLUMN_IS_PUBLIC_API, "extra_info", "_data", "hint", "deleted", "mimetype", "lastmod", "business_type", "business_id", "progress", Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO, "source", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "create_time", Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ};
    public static final String[] UNDERLYING_COLUMNS = {"_id", "mediaprovider_uri", "title", "description", "uri", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "destination", "hint", "notificationpackage", "notificationclass", Downloads.Impl.COLUMN_IS_PUBLIC_API, "_data", "business_type", "business_id", "progress", "extra_info", "source", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "create_time", Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ};
    public static final String[] DOWNLOADED_COLUMNS = {"_id", "mediaprovider_uri", "title", "description", "uri", "mimetype", "total_bytes", "status", "current_bytes", "lastmod", "destination", "hint", "notificationpackage", "notificationclass", Downloads.Impl.COLUMN_IS_PUBLIC_API, "extra_info", "_data", "create_time", Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ, "business_type"};
    public static final Set<String> LONG_COLUMNS = new HashSet(Arrays.asList("_id", "total_bytes", "status", "reason", COLUMN_BYTES_DOWNLOADED_SO_FAR, COLUMN_LAST_MODIFIED_TIMESTAMP, "lastmod", "deleted", "business_type", "progress", Downloads.Impl.COLUMN_OPEN_TIME, Downloads.Impl.COLUMN_OPEN_READ, "create_time"));

    public static boolean isHttpServerError(int i) {
        return (400 <= i && i < 488) || (500 <= i && i < 600);
    }

    /* loaded from: classes3.dex */
    public static class CursorTranslator extends CursorWrapper {
        public Uri mBaseUri;

        private long getPausedReason(int i) {
            switch (i) {
                case 194:
                    return 1L;
                case 195:
                    return 2L;
                case 196:
                    return 3L;
                default:
                    return 4L;
            }
        }

        private int translateStatus(int i) {
            if (i != 190) {
                if (i != 200) {
                    switch (i) {
                        case 192:
                            return 2;
                        case 193:
                        case 194:
                        case 195:
                        case 196:
                            return 4;
                        default:
                            return 16;
                    }
                }
                return 8;
            }
            return 1;
        }

        public CursorTranslator(Cursor cursor, Uri uri) {
            super(cursor);
            this.mBaseUri = uri;
        }

        private long getErrorCode(int i) {
            if (DownloadManager.isHttpServerError(i)) {
                return i;
            }
            if (i != 488) {
                if (i != 489) {
                    switch (i) {
                        case 492:
                            return 1001L;
                        case 493:
                        case 494:
                            return 1002L;
                        case Downloads.Impl.STATUS_HTTP_DATA_ERROR /* 495 */:
                            return 1004L;
                        default:
                            switch (i) {
                                case 497:
                                    return 1005L;
                                case 498:
                                    return 1006L;
                                case 499:
                                    return 1007L;
                                default:
                                    switch (i) {
                                        case Downloads.Impl.STATUS_FILE_ERROR_1 /* 4921 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_2 /* 4922 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_3 /* 4923 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_4 /* 4924 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_5 /* 4925 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_6 /* 4926 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_7 /* 4927 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_8 /* 4928 */:
                                        case Downloads.Impl.STATUS_FILE_ERROR_9 /* 4929 */:
                                            return 1001L;
                                        default:
                                            switch (i) {
                                                case Downloads.Impl.STATUS_HTTP_DATA_ERROR_1 /* 4951 */:
                                                case Downloads.Impl.STATUS_HTTP_DATA_ERROR_2 /* 4952 */:
                                                case Downloads.Impl.STATUS_HTTP_DATA_ERROR_3 /* 4953 */:
                                                    return 1004L;
                                                default:
                                                    switch (i) {
                                                        case Downloads.Impl.STATUS_FILE_ERROR_10 /* 49210 */:
                                                        case Downloads.Impl.STATUS_FILE_ERROR_11 /* 49211 */:
                                                        case Downloads.Impl.STATUS_FILE_ERROR_12 /* 49212 */:
                                                            return 1001L;
                                                        default:
                                                            return 1000L;
                                                    }
                                            }
                                    }
                            }
                    }
                }
                return 1008L;
            }
            return 1009L;
        }

        private String getLocalUri() {
            long underlyingLong = getUnderlyingLong("destination");
            if (underlyingLong == 4) {
                return getUnderlyingString("hint");
            }
            if (underlyingLong == 0) {
                String underlyingString = getUnderlyingString("_data");
                if (underlyingString == null) {
                    return null;
                }
                return Uri.fromFile(new File(underlyingString)).toString();
            }
            return ContentUris.withAppendedId(this.mBaseUri, getUnderlyingLong("_id")).toString();
        }

        private long getReason(int i) {
            int translateStatus = translateStatus(i);
            if (translateStatus != 4) {
                if (translateStatus != 16) {
                    return 0L;
                }
                return getErrorCode(i);
            }
            return getPausedReason(i);
        }

        private long getUnderlyingLong(String str) {
            return super.getLong(super.getColumnIndex(str));
        }

        private String getUnderlyingString(String str) {
            try {
                return super.getString(super.getColumnIndex(str));
            } catch (Exception unused) {
                return "";
            }
        }

        private boolean isLongColumn(String str) {
            return DownloadManager.LONG_COLUMNS.contains(str);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public byte[] getBlob(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getColumnIndex(String str) {
            return Arrays.asList(DownloadManager.COLUMNS).indexOf(str);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            int columnIndex = getColumnIndex(str);
            if (columnIndex != -1) {
                return columnIndex;
            }
            throw new IllegalArgumentException("No such column: " + str);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public double getDouble(int i) {
            return getLong(i);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public float getFloat(int i) {
            return (float) getDouble(i);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getInt(int i) {
            return (int) getLong(i);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public long getLong(int i) {
            return translateLong(getColumnName(i));
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public short getShort(int i) {
            return (short) getLong(i);
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public String getString(int i) {
            return translateString(getColumnName(i));
        }

        private long translateLong(String str) {
            if (!isLongColumn(str)) {
                return Long.valueOf(translateString(str)).longValue();
            }
            if (str.equals("_id")) {
                return getUnderlyingLong("_id");
            }
            if (str.equals("total_bytes")) {
                return getUnderlyingLong("total_bytes");
            }
            if (str.equals("status")) {
                return translateStatus((int) getUnderlyingLong("status"));
            }
            if (str.equals("reason")) {
                return getReason((int) getUnderlyingLong("status"));
            }
            if (str.equals(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)) {
                return getUnderlyingLong("current_bytes");
            }
            if (str.equals(Downloads.Impl.COLUMN_OPEN_TIME)) {
                return getUnderlyingLong(Downloads.Impl.COLUMN_OPEN_TIME);
            }
            if (str.equals("lastmod")) {
                return getUnderlyingLong("lastmod");
            }
            if (str.equals("deleted")) {
                return getUnderlyingLong("deleted");
            }
            if (str.equals(Downloads.Impl.COLUMN_OPEN_READ)) {
                return getUnderlyingLong(Downloads.Impl.COLUMN_OPEN_READ);
            }
            if (str.equals("business_type")) {
                return getUnderlyingLong("business_type");
            }
            if (str.equals("progress")) {
                return getUnderlyingLong("progress");
            }
            if (str.equals("create_time")) {
                return getUnderlyingLong("create_time");
            }
            return getUnderlyingLong("lastmod");
        }

        private String translateString(String str) {
            if (isLongColumn(str)) {
                return Long.toString(translateLong(str));
            }
            if (str.equals("_data")) {
                return getUnderlyingString("_data");
            }
            if (str.equals("title")) {
                return getUnderlyingString("title");
            }
            if (str.equals("description")) {
                return getUnderlyingString("description");
            }
            if (str.equals("uri")) {
                return getUnderlyingString("uri");
            }
            if (str.equals(DownloadManager.COLUMN_MEDIA_TYPE)) {
                return getUnderlyingString("mimetype");
            }
            if (str.equals("mediaprovider_uri")) {
                return getUnderlyingString("mediaprovider_uri");
            }
            if (str.equals("notificationpackage")) {
                return getUnderlyingString("notificationpackage");
            }
            if (str.equals("notificationclass")) {
                return getUnderlyingString("notificationclass");
            }
            if (str.equals(Downloads.Impl.COLUMN_IS_PUBLIC_API)) {
                return getUnderlyingString(Downloads.Impl.COLUMN_IS_PUBLIC_API);
            }
            if (str.equals("extra_info")) {
                return getUnderlyingString("extra_info");
            }
            if (str.equals("mimetype")) {
                return getUnderlyingString("mimetype");
            }
            if (str.equals(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO)) {
                return getUnderlyingString(Downloads.Impl.COLUMN_NETDISK_UPLOAD_INFO);
            }
            if (str.equals("business_id")) {
                return getUnderlyingString("business_id");
            }
            if (str.equals("source")) {
                return getUnderlyingString("source");
            }
            if (str.equals(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)) {
                return getUnderlyingString(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI);
            }
            return getLocalUri();
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getColumnCount() {
            return DownloadManager.COLUMNS.length;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public String[] getColumnNames() {
            String[] strArr = new String[DownloadManager.COLUMNS.length];
            System.arraycopy(DownloadManager.COLUMNS, 0, strArr, 0, DownloadManager.COLUMNS.length);
            return strArr;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public String getColumnName(int i) {
            int length = DownloadManager.COLUMNS.length;
            if (i >= 0 && i < length) {
                return DownloadManager.COLUMNS[i];
            }
            throw new IllegalArgumentException("Invalid column index " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + length + " columns exist");
        }
    }

    /* loaded from: classes3.dex */
    public static class Request {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int NETWORK_MOBILE = 1;
        public static final int NETWORK_WIFI = 2;
        public CharSequence mDescription;
        public Uri mDestinationUri;
        public String mMimeType;
        public CharSequence mTitle;
        public Uri mUri;
        public List<Pair<String, String>> mRequestHeaders = new ArrayList();
        public boolean mShowNotification = true;
        public boolean mRoamingAllowed = true;
        public int mAllowedNetworkTypes = -1;
        public boolean mIsVisibleInDownloadsUi = true;

        public Request(Uri uri) {
            if (uri != null) {
                String scheme = uri.getScheme();
                if (scheme != null && scheme.equals("http")) {
                    this.mUri = uri;
                    return;
                }
                throw new IllegalArgumentException("Can only download HTTP URIs: " + uri);
            }
            throw null;
        }

        private void encodeHttpHeaders(ContentValues contentValues) {
            int i = 0;
            for (Pair<String, String> pair : this.mRequestHeaders) {
                contentValues.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + i, ((String) pair.first) + ": " + ((String) pair.second));
                i++;
            }
        }

        private void putIfNonNull(ContentValues contentValues, String str, Object obj) {
            if (obj != null) {
                contentValues.put(str, obj.toString());
            }
        }

        private void setDestinationFromBase(File file, String str) {
            if (str != null) {
                this.mDestinationUri = Uri.withAppendedPath(Uri.fromFile(file), str);
                return;
            }
            throw new NullPointerException("subPath cannot be null");
        }

        public Request addRequestHeader(String str, String str2) {
            if (str != null) {
                if (!str.contains(":")) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.mRequestHeaders.add(Pair.create(str, str2));
                    return this;
                }
                throw new IllegalArgumentException("header may not contain ':'");
            }
            throw new NullPointerException("header cannot be null");
        }

        public Request setDestinationInExternalPublicDir(String str, String str2) {
            setDestinationFromBase(new File(Environment.getExternalStorageDirectory(), str), str2);
            return this;
        }

        public Request setAllowedNetworkTypes(int i) {
            this.mAllowedNetworkTypes = i;
            return this;
        }

        public Request setAllowedOverRoaming(boolean z) {
            this.mRoamingAllowed = z;
            return this;
        }

        public Request setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public Request setDestinationUri(Uri uri) {
            this.mDestinationUri = uri;
            return this;
        }

        public Request setMimeType(String str) {
            this.mMimeType = str;
            return this;
        }

        public Request setShowRunningNotification(boolean z) {
            this.mShowNotification = z;
            return this;
        }

        public Request setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Request setVisibleInDownloadsUi(boolean z) {
            this.mIsVisibleInDownloadsUi = z;
            return this;
        }

        public ContentValues toContentValues(String str) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uri", this.mUri.toString());
            contentValues.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, Boolean.TRUE);
            contentValues.put("notificationpackage", str);
            int i = 2;
            if (this.mDestinationUri != null) {
                contentValues.put("destination", (Integer) 4);
                contentValues.put("hint", this.mDestinationUri.toString());
            } else {
                contentValues.put("destination", (Integer) 2);
            }
            if (!this.mRequestHeaders.isEmpty()) {
                encodeHttpHeaders(contentValues);
            }
            putIfNonNull(contentValues, "title", this.mTitle);
            putIfNonNull(contentValues, "description", this.mDescription);
            putIfNonNull(contentValues, "mimetype", this.mMimeType);
            if (this.mShowNotification) {
                i = 0;
            }
            contentValues.put("visibility", Integer.valueOf(i));
            contentValues.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(this.mAllowedNetworkTypes));
            contentValues.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, Boolean.valueOf(this.mRoamingAllowed));
            contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(this.mIsVisibleInDownloadsUi));
            return contentValues;
        }
    }

    /* loaded from: classes3.dex */
    public static class Query {
        public static final int ORDER_ASCENDING = 1;
        public static final int ORDER_DESCENDING = 2;
        public long[] mIds = null;
        public Integer mStatusFlags = null;
        public String mOrderByColumn = "lastmod";
        public int mOrderDirection = 2;
        public boolean mOnlyIncludeVisibleInDownloadsUi = false;
        public String mExtraSelection = null;
        public int mOffset = 0;
        public int mLimit = Integer.MAX_VALUE;
        public boolean mShowDeleted = false;
        public boolean mOnlyDownloading = false;

        private String joinStrings(String str, Iterable<String> iterable) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str2 : iterable) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
            return sb.toString();
        }

        private String statusClause(String str, int i) {
            return "status" + str + "'" + i + "'";
        }

        public Query orderBy(String str, int i) {
            if (i != 1 && i != 2) {
                throw new IllegalArgumentException("Invalid direction: " + i);
            }
            if (str.equals(DownloadManager.COLUMN_LAST_MODIFIED_TIMESTAMP)) {
                this.mOrderByColumn = "lastmod";
            } else if (str.equals("total_bytes")) {
                this.mOrderByColumn = "total_bytes";
            } else if (str.equals("_id")) {
                this.mOrderByColumn = "_id";
            } else if (str.equals(Downloads.Impl.COLUMN_OPEN_TIME)) {
                this.mOrderByColumn = Downloads.Impl.COLUMN_OPEN_TIME;
            } else if (str.equals("create_time")) {
                this.mOrderByColumn = "create_time";
            } else {
                throw new IllegalArgumentException("Cannot order by " + str);
            }
            this.mOrderDirection = i;
            return this;
        }

        public Cursor runQuery(ContentResolver contentResolver, String[] strArr, Uri uri) {
            String[] strArr2;
            String joinStrings;
            String str;
            ArrayList arrayList = new ArrayList();
            long[] jArr = this.mIds;
            if (jArr != null) {
                arrayList.add(DownloadManager.getWhereClauseForIds(jArr));
                strArr2 = DownloadManager.getWhereArgsForIds(this.mIds);
            } else {
                strArr2 = null;
            }
            String[] strArr3 = strArr2;
            if (this.mOnlyDownloading) {
                joinStrings = "status!='200' AND is_visible_in_downloads_ui != '0'";
            } else {
                if (this.mStatusFlags != null) {
                    ArrayList arrayList2 = new ArrayList();
                    if ((this.mStatusFlags.intValue() & 1) != 0) {
                        arrayList2.add(statusClause("=", 190));
                    }
                    if ((this.mStatusFlags.intValue() & 2) != 0) {
                        arrayList2.add(statusClause("=", 192));
                    }
                    if ((this.mStatusFlags.intValue() & 4) != 0) {
                        arrayList2.add(statusClause("=", 193));
                        arrayList2.add(statusClause("=", 194));
                        arrayList2.add(statusClause("=", 195));
                        arrayList2.add(statusClause("=", 196));
                    }
                    if ((this.mStatusFlags.intValue() & 8) != 0) {
                        arrayList2.add(statusClause("=", 200));
                    }
                    if ((this.mStatusFlags.intValue() & 16) != 0) {
                        arrayList2.add("(" + statusClause(">=", 400) + " AND " + statusClause("<", 600) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    arrayList.add(joinStrings(" OR ", arrayList2));
                }
                if (this.mOnlyIncludeVisibleInDownloadsUi) {
                    arrayList.add("is_visible_in_downloads_ui != '0'");
                }
                if (!this.mShowDeleted) {
                    arrayList.add("deleted != '1'");
                }
                joinStrings = joinStrings(" AND ", arrayList);
            }
            if (!TextUtils.isEmpty(this.mExtraSelection)) {
                joinStrings = joinStrings + this.mExtraSelection;
            }
            String str2 = joinStrings;
            if (this.mOrderDirection != 1) {
                str = "DESC";
            } else {
                str = "ASC";
            }
            return contentResolver.query(uri, strArr, str2, strArr3, this.mOrderByColumn + " " + str + " LIMIT " + this.mLimit + " OFFSET " + this.mOffset);
        }

        public Query setFilterById(long... jArr) {
            this.mIds = jArr;
            return this;
        }

        public Query setFilterBySelection(String str) {
            this.mExtraSelection = str;
            return this;
        }

        public Query setFilterByStatus(int i) {
            this.mStatusFlags = Integer.valueOf(i);
            return this;
        }

        public Query setLimit(int i) {
            this.mLimit = i;
            return this;
        }

        public Query setOffset(int i) {
            this.mOffset = i;
            return this;
        }

        public Query setOnlyDownloading(boolean z) {
            this.mOnlyDownloading = z;
            return this;
        }

        public Query setOnlyIncludeVisibleInDownloadsUi(boolean z) {
            this.mOnlyIncludeVisibleInDownloadsUi = z;
            return this;
        }

        public Query showDeleted(boolean z) {
            this.mShowDeleted = z;
            return this;
        }
    }

    public DownloadManager(ContentResolver contentResolver, String str) {
        this.mResolver = contentResolver;
        this.mPackageName = str;
    }

    public Cursor query(Query query, String[] strArr) {
        Cursor runQuery = query.runQuery(this.mResolver, strArr, this.mBaseUri);
        if (runQuery == null) {
            return null;
        }
        return new CursorTranslator(runQuery, this.mBaseUri);
    }

    public void restartDownload(Context context, long... jArr) {
        restartDownload(context, null, jArr);
    }

    public static String[] getWhereArgsForIds(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            strArr[i] = Long.toString(jArr[i]);
        }
        return strArr;
    }

    public static String getWhereClauseForIds(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        if (jArr != null) {
            sb.append("(");
            for (int i = 0; i < jArr.length; i++) {
                if (i > 0) {
                    sb.append("OR ");
                }
                sb.append("_id");
                sb.append(" = ? ");
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
        }
        return sb.toString();
    }

    public void doCloudResumeStatisticJob(long j) {
        DownloadActionModel downloadActionModel = new DownloadActionModel();
        downloadActionModel.downloadId = j;
        ApkCloudStatisticsUtils.doApkResumeDownloadStatisticJob(downloadActionModel);
    }

    public long enqueue(Request request) {
        return Long.parseLong(this.mResolver.insert(Downloads.CONTENT_URI, request.toContentValues(this.mPackageName)).getLastPathSegment());
    }

    public Uri getDownloadUri(long j) {
        return ContentUris.withAppendedId(this.mBaseUri, j);
    }

    public ParcelFileDescriptor openDownloadedFile(long j) throws FileNotFoundException {
        return this.mResolver.openFileDescriptor(getDownloadUri(j), "r");
    }

    public Cursor query(Query query) {
        Cursor runQuery = query.runQuery(this.mResolver, UNDERLYING_COLUMNS, this.mBaseUri);
        if (runQuery == null) {
            return null;
        }
        return new CursorTranslator(runQuery, this.mBaseUri);
    }

    public Cursor queryDownload(Query query) {
        Cursor runQuery = query.runQuery(this.mResolver, DOWNLOADED_COLUMNS, this.mBaseUri);
        if (runQuery == null) {
            return null;
        }
        return new CursorTranslator(runQuery, this.mBaseUri);
    }

    public Cursor queryNoTranslator(Query query) {
        Cursor runQuery = query.runQuery(this.mResolver, UNDERLYING_COLUMNS, this.mBaseUri);
        if (runQuery == null) {
            return null;
        }
        return runQuery;
    }

    public void resumeDownload(long... jArr) {
        resumeDownload(null, jArr);
    }

    public void setAccessAllDownloads(boolean z) {
        if (z) {
            this.mBaseUri = Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI;
        } else {
            this.mBaseUri = Downloads.Impl.CONTENT_URI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartDownloadReally(Context context, String str, long... jArr) {
        Cursor cursor = null;
        try {
            cursor = query(new Query().setFilterById(jArr));
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int i = cursor.getInt(cursor.getColumnIndex("status"));
                if (i != 8 && i != 16 && i != 4) {
                    if (Constants.LOGV) {
                        Log.v("DownloadManager", "非完成状态，不能重新发起下载。");
                    }
                    return;
                }
                cursor.moveToNext();
            }
            Closeables.closeSafely(cursor);
            ContentValues contentValues = new ContentValues();
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("uri", str);
            }
            contentValues.put("current_bytes", (Integer) 0);
            contentValues.put("total_bytes", (Integer) (-1));
            contentValues.put("status", (Integer) 190);
            contentValues.put("control", (Integer) 0);
            contentValues.put(Constants.MEDIA_SCANNED, (Integer) 0);
            contentValues.put("deleted", (Integer) 0);
            contentValues.put("lastmod", Long.valueOf(System.currentTimeMillis()));
            this.mResolver.update(this.mBaseUri, contentValues, getWhereClauseForIds(jArr), getWhereArgsForIds(jArr));
            DSUtils.startDownloadServices(context);
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeDownloadReally(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            ContentValues contentValues = new ContentValues();
            Cursor cursor = null;
            try {
                try {
                    cursor = query(new Query().setFilterById(jArr));
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        if (cursor.getInt(cursor.getColumnIndex("status")) == 8) {
                            if (Constants.LOGV) {
                                Log.v("DownloadManager", "完成状态，不能继续下载。");
                            }
                            return;
                        }
                        if (ApkCloudStatisticsUtils.enableAppsearchCloudStatic()) {
                            doCloudResumeStatisticJob(cursor.getLong(cursor.getColumnIndex("_id")));
                        }
                        b20.d(cursor.getLong(cursor.getColumnIndex("_id")));
                        cursor.moveToNext();
                    }
                } catch (Exception e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                        throw new DebugException("resumeDownload is failed", e);
                    }
                }
                Closeables.closeSafely(cursor);
                contentValues.put("status", (Integer) 190);
                contentValues.put("control", (Integer) 0);
                long[] jArr2 = new long[20];
                int i = 0;
                for (long j : jArr) {
                    jArr2[i] = j;
                    if (i == 19) {
                        this.mResolver.update(this.mBaseUri, contentValues, getWhereClauseForIds(jArr2), getWhereArgsForIds(jArr2));
                        i = 0;
                    } else {
                        i++;
                    }
                }
                this.mResolver.update(this.mBaseUri, contentValues, getWhereClauseForIds(jArr2), getWhereArgsForIds(jArr2));
                b20.q(jArr);
                if (Constants.LOGV) {
                    Log.i("DownloadManager", "resumeDownload() set status: Downloads.Impl.STATUS_PENDING");
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public int markRowDeleted(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            SQLiteDatabase sQLiteDatabase = null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("deleted", (Integer) 1);
            try {
                sQLiteDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                int length = jArr.length;
                for (int i = 0; i < length; i++) {
                    sQLiteDatabase.update("downloads", contentValues, "_id= ?", new String[]{Long.toString(jArr[i])});
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                return 1;
            } catch (Throwable th) {
                try {
                    if (!AppConfig.isDebug()) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        return 0;
                    }
                    throw new DebugException("markRowDeleted failed! " + th);
                } catch (Throwable th2) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("input param 'ids' can't be null");
    }

    public void pauseDownload(long... jArr) {
        ContentValues contentValues = new ContentValues();
        Cursor cursor = null;
        try {
            try {
                try {
                    cursor = query(new Query().setFilterById(jArr));
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            if (cursor.getInt(cursor.getColumnIndex("status")) == 8) {
                                if (Constants.LOGV) {
                                    Log.v("DownloadManager", "完成状态，不能暂停下载。");
                                }
                                return;
                            }
                            cursor.moveToNext();
                        }
                    }
                } catch (SQLiteBlobTooBigException e) {
                    e.printStackTrace();
                }
            } catch (SQLiteFullException e2) {
                e2.printStackTrace();
            }
            Closeables.closeSafely(cursor);
            contentValues.put("status", (Integer) 193);
            contentValues.put("control", (Integer) 1);
            if (Constants.LOGV) {
                Log.i("DownloadManager", "pauseDownload() set status: Downloads.Impl.CONTROL_PAUSED");
            }
            if (jArr != null) {
                this.mResolver.update(this.mBaseUri, contentValues, getWhereClauseForIds(jArr), getWhereArgsForIds(jArr));
            }
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public int remove(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = DownloadProvider.DatabaseHelper.getInstance(AppRuntime.getAppContext()).getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                int length = jArr.length;
                for (int i = 0; i < length; i++) {
                    sQLiteDatabase.delete("downloads", "_id= ?", new String[]{Long.toString(jArr[i])});
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                return 1;
            } catch (Throwable th) {
                try {
                    if (!AppConfig.isDebug()) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        return 0;
                    }
                    throw new DebugException("remove failed! " + th);
                } catch (Throwable th2) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        }
        throw new IllegalArgumentException("input param 'ids' can't be null");
    }

    public synchronized boolean needRequestExternalStorage(String str) {
        boolean z = false;
        if (DownloadHelper.isStoragePermissionGranted()) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = this.mResolver.query(Downloads.Impl.CONTENT_URI, new String[]{"_data", "visibility", Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI}, "_id= ?", new String[]{str}, null);
            if (cursor != null && cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                int i = cursor.getInt(cursor.getColumnIndex("visibility"));
                int i2 = cursor.getInt(cursor.getColumnIndex(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI));
                if (DEBUG) {
                    Log.d("DownloadManager", str + " visible " + i + " uiVisible " + i2);
                }
                if (DownloadHelper.isExternalStorageAndNoPermission(string) && (i != 2 || i2 != 2)) {
                    z = true;
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new DebugException("needRequestExternalStorage", e);
            }
        }
        Closeables.closeSafely(cursor);
        return z;
    }

    public void restartDownload(final Context context, final String str, long... jArr) {
        if (jArr.length > 1) {
            if (!DownloadHelper.isStoragePermissionGranted()) {
                for (long j : jArr) {
                    if (!needRequestExternalStorage(String.valueOf(j))) {
                        restartDownloadReally(context, str, j);
                    }
                }
                return;
            }
            restartDownloadReally(context, str, jArr);
        } else if (jArr.length == 1) {
            final long j2 = jArr[0];
            if (needRequestExternalStorage(String.valueOf(j2))) {
                DownloadHelper.requestExternalStoragePermission(new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.manager.DownloadManager.1
                    @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                    public void onResult(boolean z) {
                        if (!z) {
                            if (!DownloadManager.DEBUG) {
                                return;
                            }
                            throw new DebugException("Download does not have external storage permission. Please apply for external storage permission before downloading.\n ");
                        }
                        DownloadManager.this.restartDownloadReally(context, str, j2);
                    }
                });
            } else {
                restartDownloadReally(context, str, j2);
            }
        }
    }

    public void resumeDownload(final DownloadCallBack downloadCallBack, long... jArr) {
        if (jArr.length > 1) {
            if (!DownloadHelper.isStoragePermissionGranted()) {
                for (long j : jArr) {
                    if (!needRequestExternalStorage(String.valueOf(j))) {
                        resumeDownloadReally(j);
                    }
                }
                return;
            }
            resumeDownloadReally(jArr);
        } else if (jArr.length == 1) {
            final long j2 = jArr[0];
            if (needRequestExternalStorage(String.valueOf(j2))) {
                DownloadHelper.requestExternalStoragePermission(new ExternalStorageCallBack() { // from class: com.baidu.searchbox.download.manager.DownloadManager.2
                    @Override // com.baidu.searchbox.download.util.ExternalStorageCallBack
                    public void onResult(boolean z) {
                        if (z) {
                            DownloadManager.this.resumeDownloadReally(j2);
                            DownloadCallBack downloadCallBack2 = downloadCallBack;
                            if (downloadCallBack2 != null) {
                                downloadCallBack2.onResult(DownloadManager.this.getDownloadUri(j2));
                                return;
                            }
                            return;
                        }
                        DownloadCallBack downloadCallBack3 = downloadCallBack;
                        if (downloadCallBack3 != null) {
                            downloadCallBack3.onResult(null);
                        }
                    }
                });
                return;
            }
            resumeDownloadReally(j2);
            if (downloadCallBack != null) {
                downloadCallBack.onResult(getDownloadUri(j2));
            }
        }
    }
}
