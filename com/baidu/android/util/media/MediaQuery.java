package com.baidu.android.util.media;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.media.model.MediaClassMetadata;
import com.baidu.android.util.media.model.MediaInfo;
import com.baidu.android.util.media.reflect.ConstructorConstructor;
import com.baidu.android.util.media.reflect.MediaAnnotationParser;
import com.baidu.android.util.media.reflect.ObjectConstructor;
import com.baidu.down.request.db.DownloadDataConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes12.dex */
public class MediaQuery {
    private Context context;
    private String selection;
    private String[] selectionArgs;
    private String sortOrder;
    private Uri uri;

    private MediaQuery() {
    }

    public static MediaQueryBuilder with(@NonNull Context context, @NonNull Uri uri) {
        return new MediaQueryBuilder(context, uri);
    }

    public <T extends MediaInfo> List<T> query(@NonNull Class<T> cls) {
        return queryInternal(this.context, this.uri, this.selection, this.selectionArgs, this.sortOrder, cls);
    }

    /* loaded from: classes12.dex */
    public static final class MediaQueryBuilder {
        private Context context;
        private String selection;
        private String[] selectionArgs;
        private String sortOrder;
        private Uri uri;

        public MediaQueryBuilder(Context context, Uri uri) {
            this.context = context;
            this.uri = uri;
        }

        public MediaQueryBuilder selection(String str) {
            this.selection = str;
            return this;
        }

        public MediaQueryBuilder selectionArgs(String[] strArr) {
            this.selectionArgs = strArr;
            return this;
        }

        public MediaQueryBuilder sortOrder(String str) {
            this.sortOrder = str;
            return this;
        }

        public MediaQuery build() {
            MediaQuery mediaQuery = new MediaQuery();
            mediaQuery.context = this.context;
            mediaQuery.uri = this.uri;
            mediaQuery.selection = this.selection;
            mediaQuery.selectionArgs = this.selectionArgs;
            mediaQuery.sortOrder = this.sortOrder;
            return mediaQuery;
        }
    }

    private <T extends MediaInfo> List<T> queryInternal(Context context, @NonNull Uri uri, @Nullable String str, @Nullable String[] strArr, @Nullable String str2, @NonNull Class<T> cls) {
        Cursor cursor;
        if (context == null || uri == null || cls == null) {
            LogUtil.e("context", context, DownloadDataConstants.Columns.COLUMN_URI, uri, "tClass", cls);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList arrayList = new ArrayList();
        ObjectConstructor objectConstructor = new ConstructorConstructor().get(cls);
        if (objectConstructor == null) {
            LogUtil.e("cannot get constructor, please check your mediainfo class", cls);
            return arrayList;
        }
        MediaClassMetadata metaData = new MediaAnnotationParser().getMetaData(cls);
        if (metaData == null) {
            LogUtil.e("cannnot get metadata from ", cls);
            return arrayList;
        }
        try {
            cursor = contentResolver.query(uri, metaData.getProjection(), TextUtils.isEmpty(str) ? metaData.select : str, (strArr == null || strArr.length < 1) ? metaData.selectArgs : strArr, TextUtils.isEmpty(str2) ? metaData.sort : str2);
            while (cursor.moveToNext()) {
                try {
                    try {
                        MediaInfo mediaInfo = (MediaInfo) objectConstructor.construct();
                        mediaInfo.setContentUri(ContentUris.withAppendedId(uri, cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID))));
                        arrayList.add((MediaInfo) parseValue(cursor, mediaInfo, metaData.fieldDatas));
                    } catch (Exception e) {
                        e = e;
                        LogUtil.d("query failed, exception", e);
                        Closeables.closeSafely(cursor);
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            }
            Closeables.closeSafely(cursor);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            Closeables.closeSafely(cursor);
            throw th;
        }
        return arrayList;
    }

    private <T> T parseValue(Cursor cursor, T t, Map<String, Field> map) throws IllegalAccessException {
        Object blob;
        if (cursor == null || t == null || map == null) {
            LogUtil.e("cusor", cursor, "instance", t, "fieldMap", map);
        } else {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    Field field = map.get(next);
                    if (!IMConstants.MSG_ROW_ID.equals(next) && field != null) {
                        int columnIndex = cursor.getColumnIndex(next);
                        if (columnIndex == -1) {
                            LogUtil.e("columnName error, columnName", next);
                        } else {
                            switch (cursor.getType(columnIndex)) {
                                case 0:
                                    break;
                                case 1:
                                    blob = Integer.valueOf(cursor.getInt(columnIndex));
                                    break;
                                case 2:
                                    blob = Float.valueOf(cursor.getFloat(columnIndex));
                                    break;
                                case 3:
                                    blob = cursor.getString(columnIndex);
                                    break;
                                case 4:
                                    blob = cursor.getBlob(columnIndex);
                                    break;
                                default:
                                    blob = cursor.getString(columnIndex);
                                    break;
                            }
                            field.setAccessible(true);
                            field.set(t, blob);
                        }
                    }
                }
            }
        }
        return t;
    }
}
