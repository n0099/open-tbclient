package com.baidu.searchbox.download.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.support.appcompat.storage.MediaFileProcessor;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.StorageUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.PathUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.ioc.DownloadRuntime;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.nx;
import com.baidu.tieba.px;
import com.baidu.tieba.tw;
import com.kuaishou.weapon.p0.g;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes3.dex */
public final class DownloadHelper {
    public static final int ASCII_FIRST_COUNT_127 = 127;
    public static final boolean CHECK_MIME_TYPE = false;
    public static final String DOWNLOAD_GOTO_SETTING_DIALOG_SHOW = "download_goto_setting_dialog_show";
    public static final int DOWNLOAD_MAX_FILE_NAME_LENGTH = 60;
    public static final int DOWNLOAD_MAX_FILE_NAME_LENGTH_WITHOUT_EXTENSION = 50;
    public static final String DOWNLOAD_PATH = "download_path";
    public static final String FILE_CUT_OFF_DOT = "...";
    public static final String FILE_SUFFIX_DOT = ".";
    public static final int INITIAL_MAX_BTYE_LENGTH = 16;
    public static final String KEY_DOWNLOADCENTER_PATH = "downloadcenter_path";
    public static final int MAX_FILE_NAME_LENGTH = 250;
    public static final String PERMISSION_SOURCE_DOWNLOAD_EXTERNALSTORAGE = "checkExternalStorageDownload";
    public static final int REQUEST_EXTERNAL_STORAGE_CODE = 10000;
    public static final String TAG = "DownloadHelper";
    public static final int TOTAL_BEFORE_END_SORT = 2;
    public static final int TOTAL_MAX_BTYE_LENGTH = 20;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final Random RANDOM = new Random(SystemClock.uptimeMillis());
    public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);

    public static void checkCanHandleDownload(Context context, String str, int i, boolean z) throws GenerateSaveFileError {
        if (z) {
        }
    }

    public static boolean isFilenameValid(String str) {
        return true;
    }

    /* renamed from: com.baidu.searchbox.download.util.DownloadHelper$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$download$model$Downloads$DestinationMode;

        static {
            int[] iArr = new int[Downloads.DestinationMode.values().length];
            $SwitchMap$com$baidu$searchbox$download$model$Downloads$DestinationMode = iArr;
            try {
                iArr[Downloads.DestinationMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$Downloads$DestinationMode[Downloads.DestinationMode.INTERNAL_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$Downloads$DestinationMode[Downloads.DestinationMode.EXTERNAL_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$Downloads$DestinationMode[Downloads.DestinationMode.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class GenerateSaveFileError extends Exception {
        public String mMessage;
        public int mStatus;

        public GenerateSaveFileError(int i, String str) {
            this.mStatus = i;
            this.mMessage = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class Lexer {
        public static final int TOKEN_AND_OR = 3;
        public static final int TOKEN_CLOSE_PAREN = 2;
        public static final int TOKEN_COLUMN = 4;
        public static final int TOKEN_COMPARE = 5;
        public static final int TOKEN_END = 9;
        public static final int TOKEN_IS = 7;
        public static final int TOKEN_NULL = 8;
        public static final int TOKEN_OPEN_PAREN = 1;
        public static final int TOKEN_START = 0;
        public static final int TOKEN_VALUE = 6;
        public final Set<String> mAllowedColumns;
        public final char[] mChars;
        public final String mSelection;
        public int mOffset = 0;
        public int mCurrentToken = 0;

        public static boolean isIdentifierChar(char c) {
            return c == '_' || (c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
        }

        public static boolean isIdentifierStart(char c) {
            return c == '_' || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }

        public Lexer(String str, Set<String> set) {
            this.mSelection = str;
            this.mAllowedColumns = set;
            char[] cArr = new char[str.length()];
            this.mChars = cArr;
            this.mSelection.getChars(0, cArr.length, cArr, 0);
            advance();
        }

        public void advance() {
            char[] cArr = this.mChars;
            while (true) {
                int i = this.mOffset;
                if (i >= cArr.length || cArr[i] != ' ') {
                    break;
                }
                this.mOffset = i + 1;
            }
            int i2 = this.mOffset;
            if (i2 == cArr.length) {
                this.mCurrentToken = 9;
            } else if (cArr[i2] == '(') {
                this.mOffset = i2 + 1;
                this.mCurrentToken = 1;
            } else if (cArr[i2] == ')') {
                this.mOffset = i2 + 1;
                this.mCurrentToken = 2;
            } else if (cArr[i2] == '?') {
                this.mOffset = i2 + 1;
                this.mCurrentToken = 6;
            } else if (cArr[i2] == '=') {
                int i3 = i2 + 1;
                this.mOffset = i3;
                this.mCurrentToken = 5;
                if (i3 < cArr.length && cArr[i3] == '=') {
                    this.mOffset = i3 + 1;
                }
            } else if (cArr[i2] == '>') {
                int i4 = i2 + 1;
                this.mOffset = i4;
                this.mCurrentToken = 5;
                if (i4 < cArr.length && cArr[i4] == '=') {
                    this.mOffset = i4 + 1;
                }
            } else if (cArr[i2] == '<') {
                int i5 = i2 + 1;
                this.mOffset = i5;
                this.mCurrentToken = 5;
                if (i5 < cArr.length) {
                    if (cArr[i5] == '=' || cArr[i5] == '>') {
                        this.mOffset++;
                    }
                }
            } else if (cArr[i2] == '!') {
                int i6 = i2 + 1;
                this.mOffset = i6;
                this.mCurrentToken = 5;
                if (i6 < cArr.length && cArr[i6] == '=') {
                    this.mOffset = i6 + 1;
                    return;
                }
                throw new IllegalArgumentException("Unexpected character after !");
            } else if (isIdentifierStart(cArr[i2])) {
                int i7 = this.mOffset;
                this.mOffset = i7 + 1;
                while (true) {
                    int i8 = this.mOffset;
                    if (i8 >= cArr.length || !isIdentifierChar(cArr[i8])) {
                        break;
                    }
                    this.mOffset++;
                }
                String substring = this.mSelection.substring(i7, this.mOffset);
                if (this.mOffset - i7 <= 4) {
                    if (substring.equals("IS")) {
                        this.mCurrentToken = 7;
                        return;
                    } else if (!substring.equals("OR") && !substring.equals("AND")) {
                        if (substring.equals("NULL")) {
                            this.mCurrentToken = 8;
                            return;
                        }
                    } else {
                        this.mCurrentToken = 3;
                        return;
                    }
                }
                if (this.mAllowedColumns.contains(substring)) {
                    this.mCurrentToken = 4;
                    return;
                }
                throw new IllegalArgumentException("unrecognized column or keyword");
            } else {
                int i9 = this.mOffset;
                if (cArr[i9] == '\'') {
                    this.mOffset = i9 + 1;
                    while (true) {
                        int i10 = this.mOffset;
                        if (i10 >= cArr.length) {
                            break;
                        }
                        if (cArr[i10] == '\'') {
                            if (i10 + 1 >= cArr.length || cArr[i10 + 1] != '\'') {
                                break;
                            }
                            this.mOffset = i10 + 1;
                        }
                        this.mOffset++;
                    }
                    int i11 = this.mOffset;
                    if (i11 != cArr.length) {
                        this.mOffset = i11 + 1;
                        this.mCurrentToken = 6;
                        return;
                    }
                    throw new IllegalArgumentException("unterminated string");
                }
                throw new IllegalArgumentException("illegal character: " + cArr[this.mOffset]);
            }
        }

        public int currentToken() {
            return this.mCurrentToken;
        }
    }

    public static boolean checkTeenagerStyleAndTip() {
        if (tw.a.e()) {
            UniversalToast.makeText(AppRuntime.getAppContext(), (int) R.string.obfuscated_res_0x7f0f167e).show();
            return true;
        }
        return false;
    }

    public static File getDownloadDirectoryUserSet() {
        if (DownloadMediaHelper.isOpenScopedStorage()) {
            return null;
        }
        String string = PreferenceUtils.getString("downloadcenter_path", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new File(string);
    }

    public static boolean isExternaSdcardMounted() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean isStoragePermissionGranted() {
        return DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", g.i});
    }

    public static String buildExternalPublicFullPath(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, long j) throws GenerateSaveFileError {
        String str7;
        String chooseFilename = chooseFilename(str, str2, str3, str4, str5, i);
        File downloadDirectoryReal = getDownloadDirectoryReal(chooseFilename, str6);
        if (!downloadDirectoryReal.exists() && !downloadDirectoryReal.mkdirs()) {
            throw new GenerateSaveFileError(499, "file cannot create");
        }
        if (isExternaSdcardMounted()) {
            if (isStoragePermissionGranted()) {
                if (getAvailableBytes(downloadDirectoryReal) >= j) {
                    int lastIndexOf = chooseFilename.lastIndexOf(46);
                    if (lastIndexOf < 0) {
                        str7 = chooseExtensionFromMimeType(str6, true);
                    } else {
                        String chooseExtensionFromFilename = chooseExtensionFromFilename(str6, i, chooseFilename, lastIndexOf);
                        chooseFilename = chooseFilename.substring(0, lastIndexOf);
                        str7 = chooseExtensionFromFilename;
                    }
                    boolean equalsIgnoreCase = Constants.RECOVERY_DIRECTORY.equalsIgnoreCase(chooseFilename + str7);
                    return chooseUniqueFilename(i, downloadDirectoryReal.getPath() + File.separator + chooseFilename, str7, equalsIgnoreCase);
                }
                throw new GenerateSaveFileError(498, context.getString(R.string.obfuscated_res_0x7f0f05f0));
            }
            throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_6, "no sdcard write permission");
        }
        throw new GenerateSaveFileError(499, "external media not mounted");
    }

    @SuppressLint({"WorldReadableFiles", "WorldWriteableFiles"})
    public static String chooseFullPath(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, long j) throws GenerateSaveFileError {
        String str7;
        File locateDestinationDirectory = locateDestinationDirectory(context, str6, i, j);
        String chooseFilename = chooseFilename(str, str2, str3, str4, str5, i);
        int lastIndexOf = chooseFilename.lastIndexOf(46);
        if (lastIndexOf < 0) {
            str7 = chooseExtensionFromMimeType(str6, true);
        } else {
            String chooseExtensionFromFilename = chooseExtensionFromFilename(str6, i, chooseFilename, lastIndexOf);
            chooseFilename = chooseFilename.substring(0, lastIndexOf);
            str7 = chooseExtensionFromFilename;
        }
        boolean equalsIgnoreCase = Constants.RECOVERY_DIRECTORY.equalsIgnoreCase(chooseFilename + str7);
        String str8 = locateDestinationDirectory.getPath() + File.separator + chooseFilename;
        if (DEBUG) {
            Log.v("DownloadManager", "target file: " + str8 + str7);
        }
        String chooseUniqueFilename = chooseUniqueFilename(i, str8, str7, equalsIgnoreCase);
        if (chooseUniqueFilename.startsWith(context.getFilesDir().getAbsolutePath())) {
            try {
                context.openFileOutput(new File(chooseUniqueFilename).getName(), 3).close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chooseUniqueFilename;
    }

    public static String[] buildWhereArgsForIds(List<Long> list) {
        if (list != null && list.size() != 0) {
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = String.valueOf(list.get(i));
            }
            return strArr;
        }
        return new String[0];
    }

    public static boolean checkFileAvailable(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static long getAvailableBytes(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
            return 1L;
        }
    }

    public static String getDisplayString(Object obj) {
        if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            return obj.toString();
        }
        return "null.";
    }

    public static String getFileNameWithoutSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static long getIdFromUri(Uri uri) {
        if (uri != null) {
            try {
                return ContentUris.parseId(uri);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return -1L;
    }

    public static String getMediaFileDefaultPath(MediaFileProcessor.UriSource uriSource) {
        return DownloadMediaHelper.getMediaFileDefaultPath(uriSource);
    }

    public static String getTitleCutOff(String str) {
        return getTitleCutOff(str, false);
    }

    public static boolean isNetworkAvailable(ISystemFacade iSystemFacade) {
        if (iSystemFacade.getActiveNetworkType() != null) {
            return true;
        }
        return false;
    }

    public static long[] listToArrayForLong(List<Long> list) {
        if (list != null && list.size() != 0) {
            long[] jArr = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                jArr[i] = list.get(i).longValue();
            }
            return jArr;
        }
        return new long[0];
    }

    public static void parseExpression(Lexer lexer) {
        while (true) {
            if (lexer.currentToken() == 1) {
                lexer.advance();
                parseExpression(lexer);
                if (lexer.currentToken() == 2) {
                    lexer.advance();
                } else {
                    throw new IllegalArgumentException("syntax error, unmatched parenthese");
                }
            } else {
                parseStatement(lexer);
            }
            if (lexer.currentToken() != 3) {
                return;
            }
            lexer.advance();
        }
    }

    public static void requestExternalStoragePermission(final ExternalStorageCallBack externalStorageCallBack) {
        new WeakReference(BdBoxActivityManager.getTopActivity());
        DangerousPermissionUtils.requestPermissions(PERMISSION_SOURCE_DOWNLOAD_EXTERNALSTORAGE, AppRuntime.getAppContext(), new String[]{g.i, "android.permission.WRITE_EXTERNAL_STORAGE"}, 10000, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.download.util.DownloadHelper.3
            @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
            public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                boolean z;
                if (i == 10000) {
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (iArr[i2] != 0) {
                                z = false;
                                break;
                            }
                            i2++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        ExternalStorageCallBack externalStorageCallBack2 = ExternalStorageCallBack.this;
                        if (externalStorageCallBack2 != null) {
                            externalStorageCallBack2.onResult(true);
                            return;
                        }
                        return;
                    }
                    ExternalStorageCallBack externalStorageCallBack3 = ExternalStorageCallBack.this;
                    if (externalStorageCallBack3 != null) {
                        externalStorageCallBack3.onResult(false);
                    }
                    if (PreferenceUtils.getBoolean(DownloadHelper.DOWNLOAD_GOTO_SETTING_DIALOG_SHOW, false)) {
                        nx.i();
                    } else {
                        PreferenceUtils.setBoolean(DownloadHelper.DOWNLOAD_GOTO_SETTING_DIALOG_SHOW, true);
                    }
                }
            }
        });
    }

    public static String sanitizeMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            int indexOf = lowerCase.indexOf(59);
            if (indexOf != -1) {
                lowerCase = lowerCase.substring(0, indexOf);
            }
            return lowerCase;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static String buildWhereClauseForIds(List<Long> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder("(");
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append("OR ");
                }
                sb.append("_id");
                sb.append(" = ? ");
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return "";
    }

    @Nullable
    @Deprecated
    public static File getDownloadDirectory(Context context) {
        try {
            File externalFilesDir = context.getExternalFilesDir("downloads");
            if (externalFilesDir == null) {
                externalFilesDir = new File(context.getFilesDir(), "downloads");
            }
            createDownloadDirectory(externalFilesDir);
            return externalFilesDir;
        } catch (Throwable th) {
            File file = new File(context.getFilesDir(), "downloads");
            createDownloadDirectory(file);
            if (!DEBUG) {
                return file;
            }
            throw new DebugException("DownloadHelpergetDownloadDirectory()" + th);
        }
    }

    public static String getFileNameCutOff(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return str;
        }
        int i = 0;
        int i2 = 0;
        while (i < lastIndexOf) {
            char charAt = str.charAt(i);
            int i3 = 2;
            if (charAt >= 0 && charAt <= 127) {
                i3 = 1;
            }
            i2 += i3;
            if (i2 > 250) {
                break;
            }
            i++;
        }
        String substring = str.substring(0, i);
        return substring + str.substring(lastIndexOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002a A[RETURN] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File getTranscodeResultDirectory(Context context) {
        File file;
        File downloadDirectory = getDownloadDirectory(context);
        if (downloadDirectory == null) {
            return null;
        }
        boolean z = false;
        try {
            file = new File(downloadDirectory, Constants.TRANSCODE_RESULT_SUB_DIR_NAME);
            try {
                if (!file.exists()) {
                    z = file.mkdirs();
                } else {
                    z = true;
                }
            } catch (Exception e) {
                e = e;
                if (DEBUG) {
                    throw new DebugException("DownloadHelpergetTranscodeResultDirectory()" + e);
                }
                if (z) {
                }
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        }
        if (z) {
            return null;
        }
        return file;
    }

    public static boolean isExternalStorageAndNoPermission(String str) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(str)) {
            str = getDownloadPrivateFile().getAbsolutePath();
            z = true;
        } else {
            z = false;
        }
        z2 = (isStoragePrivatePath(str) || isStoragePermissionGranted()) ? false : false;
        if (z2 && !z && DEBUG) {
            throw new DebugException(str + "Download does not have external storage permission. Please apply for external storage permission before downloading.\n ");
        }
        return z2;
    }

    public static boolean isStoragePrivatePath(String str) {
        File externalFilesDir;
        if (TextUtils.isEmpty(str) || (externalFilesDir = AppRuntime.getAppContext().getExternalFilesDir("downloads")) == null) {
            return false;
        }
        String parent = externalFilesDir.getParentFile().getParent();
        String parent2 = AppRuntime.getAppContext().getFilesDir().getParent();
        if (!str.contains(parent) && !str.contains(parent2)) {
            return false;
        }
        return true;
    }

    public static void checkExternalStorage(ContentValues contentValues, ExternalStorageCallBack externalStorageCallBack) {
        String str;
        boolean z;
        int intValue;
        boolean z2 = true;
        if (isStoragePermissionGranted()) {
            if (externalStorageCallBack != null) {
                externalStorageCallBack.onResult(true);
            }
        } else if (contentValues.containsKey("destination") && ((intValue = contentValues.getAsInteger("destination").intValue()) == 1 || intValue == 2 || intValue == 3)) {
            if (externalStorageCallBack != null) {
                externalStorageCallBack.onResult(true);
            }
        } else {
            if (contentValues.containsKey("hint")) {
                str = contentValues.getAsString("hint");
                if (str != null && str.startsWith("file://")) {
                    if (!TextUtils.isEmpty(str) && !isExternalStorageAndNoPermission(str)) {
                        if (externalStorageCallBack != null) {
                            externalStorageCallBack.onResult(true);
                            return;
                        }
                        return;
                    }
                } else {
                    str = null;
                }
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str) && contentValues.containsKey("_data")) {
                str = contentValues.getAsString("_data");
                if (!TextUtils.isEmpty(str) && !isExternalStorageAndNoPermission(str)) {
                    if (externalStorageCallBack != null) {
                        externalStorageCallBack.onResult(true);
                        return;
                    }
                    return;
                }
            }
            if (TextUtils.isEmpty(str) && !needRequestPermissionBeforeDownloadDefaultDirectory()) {
                if (externalStorageCallBack != null) {
                    externalStorageCallBack.onResult(true);
                    return;
                }
                return;
            }
            if (contentValues.containsKey("visibility") && 2 == contentValues.getAsInteger("visibility").intValue()) {
                z = false;
            } else {
                z = true;
            }
            if (contentValues.containsKey(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI)) {
                z2 = contentValues.getAsBoolean(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI).booleanValue();
            }
            if (!z && !z2) {
                if (externalStorageCallBack != null) {
                    externalStorageCallBack.onResult(false);
                    return;
                }
                return;
            }
            requestExternalStoragePermission(externalStorageCallBack);
        }
    }

    public static void checkExternalStorage(String str, boolean z, ExternalStorageCallBack externalStorageCallBack) {
        if (!isExternalStorageAndNoPermission(str)) {
            if (externalStorageCallBack != null) {
                externalStorageCallBack.onResult(true);
            }
        } else if (!z) {
            if (externalStorageCallBack != null) {
                externalStorageCallBack.onResult(false);
            }
        } else {
            requestExternalStoragePermission(externalStorageCallBack);
        }
    }

    public static String getBeforeString(String str, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            if (str.charAt(i4) <= 127) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            i5 += i3;
            if (i5 > 16 - i2) {
                break;
            }
            i4++;
        }
        return str.substring(0, i4);
    }

    public static String getEndString(String str, int i, boolean z) {
        int i2;
        int i3;
        int i4 = i - 1;
        int i5 = 0;
        if (z) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        while (i4 > 0) {
            if (str.charAt(i4) <= 127) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            i5 += i3;
            if (i5 > 4 - i2) {
                break;
            }
            i4--;
        }
        return str.substring(i4 + 1);
    }

    public static String getVariableLengthTitleCutOff(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f05e2);
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return subVariableLengthTitle(str, i, z);
        }
        return subVariableLengthTitle(str, lastIndexOf, i, z);
    }

    public static String subTitle(String str, int i, boolean z) {
        String substring = str.substring(0, i);
        if (titleNotTooLong(str, i)) {
            return str;
        }
        return getBeforeString(substring, i, z) + "..." + getEndString(substring, i, z) + str.substring(i);
    }

    public static String subVariableLengthTitle(String str, int i, boolean z) {
        int length = str.length();
        if (titleNotTooLong(str, length)) {
            return str;
        }
        return getBeforeStringVariableLength(str, length, i, z) + "..." + getEndString(str, length, z) + str.substring(length);
    }

    public static void checkExternalStorage(String str, boolean z, ExternalStorageCallBack externalStorageCallBack, boolean z2) {
        if (z2) {
            if (TextUtils.isEmpty(str)) {
                str = getDownloadPrivateFile().getAbsolutePath();
            }
            if (!isStoragePrivatePath(str) && !isStoragePermissionGranted()) {
                if (!z) {
                    if (externalStorageCallBack != null) {
                        externalStorageCallBack.onResult(false);
                        return;
                    }
                    return;
                }
                requestExternalStoragePermission(externalStorageCallBack);
                return;
            } else if (externalStorageCallBack != null) {
                externalStorageCallBack.onResult(true);
                return;
            } else {
                return;
            }
        }
        checkExternalStorage(str, z, externalStorageCallBack);
    }

    public static String chooseExtensionFromFilename(String str, int i, String str2, int i2) {
        String str3;
        String guessMimeTypeFromExtension;
        if (str != null && ((guessMimeTypeFromExtension = FileClassifyHelper.guessMimeTypeFromExtension(str2.substring(str2.lastIndexOf(46) + 1))) == null || !guessMimeTypeFromExtension.equalsIgnoreCase(str))) {
            str3 = chooseExtensionFromMimeType(str, false);
            if (str3 != null) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "substituting extension from type");
                }
            } else if (Constants.LOGVV) {
                Log.v("DownloadManager", "couldn't find extension for " + str);
            }
        } else {
            str3 = null;
        }
        if (str3 == null) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "keeping extension");
            }
            return str2.substring(i2);
        }
        return str3;
    }

    public static String chooseUniqueFilename(int i, String str, String str2, boolean z) throws GenerateSaveFileError {
        String str3 = str + str2;
        if (!new File(str3).exists() && (!z || (i != 1 && i != 2 && i != 3))) {
            if (FileDownloader.isFilePathRepeat(str3)) {
                return str + "-" + System.currentTimeMillis() + str2;
            }
            return str3;
        }
        return makeUniqueFilename(str, str2);
    }

    public static void setDownloadPath(ContentValues contentValues, String str, String str2, boolean z) {
        if (contentValues != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!DownloadMediaHelper.checkDownloadSpecifiedDirectoryValid(str)) {
                str = getDownloadPrivateFile().getAbsolutePath();
                if (DEBUG) {
                    Log.e(TAG, "Download directory does not meet Android 10 partition storage specifications.");
                }
            }
            contentValues.put("destination", (Integer) 4);
            contentValues.put("hint", "file://" + str + File.separator + str2);
            contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(z));
        }
    }

    public static String chooseExtensionFromMimeType(String str, boolean z) {
        String str2;
        if (str != null) {
            str2 = FileClassifyHelper.guessExtensionFromMimeType(str);
            if (str2 != null) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "adding extension from type");
                }
                str2 = "." + str2;
            } else if (Constants.LOGVV) {
                Log.v("DownloadManager", "couldn't find extension for " + str);
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            if (str != null && str.toLowerCase(Locale.getDefault()).startsWith("text/")) {
                if (str.equalsIgnoreCase(SapiWebView.DATA_MIME_TYPE)) {
                    if (Constants.LOGVV) {
                        Log.v("DownloadManager", "adding default html extension");
                    }
                    return ".html";
                } else if (z) {
                    if (Constants.LOGVV) {
                        Log.v("DownloadManager", "adding default text extension");
                    }
                    return ".txt";
                } else {
                    return str2;
                }
            } else if (z) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "adding default binary extension");
                }
                return ".bin";
            } else {
                return str2;
            }
        }
        return str2;
    }

    public static File getDownloadDirectoryDefault(String str, String str2) {
        if (DownloadMediaHelper.isOpenScopedStorage()) {
            if (TextUtils.isEmpty(str2)) {
                String mediaFileDefaultPath = DownloadMediaHelper.getMediaFileDefaultPath(MediaFileProcessor.UriSource.DOWNLOAD);
                return new File(mediaFileDefaultPath + Constants.DEFAULT_DL_SUBDIR);
            }
            String fileSuffix = FileClassifyHelper.getFileSuffix(str);
            if (FileClassifyHelper.isNeedReplaceMimetype(str2, fileSuffix)) {
                str2 = FileClassifyHelper.guessMimeTypeFromExtension(fileSuffix);
            }
            String mediaFileDefaultPath2 = DownloadMediaHelper.getMediaFileDefaultPath(DownloadMediaHelper.getMediaFileUriSource("", str2));
            return new File(mediaFileDefaultPath2 + Constants.DEFAULT_DL_SUBDIR);
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        return new File(externalStorageDirectory.getPath() + Constants.DEFAULT_DL_SUBDIR);
    }

    public static String getFileTypeString(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = str.toLowerCase(Locale.getDefault());
        } else {
            str3 = "";
        }
        String fileSuffix = FileClassifyHelper.getFileSuffix(str3);
        int category = FileClassifyHelper.getCategory(fileSuffix, str2);
        if (category == 0) {
            return "video";
        }
        if (category == 1) {
            return "music";
        }
        if (category == 2) {
            return "image";
        }
        if (category == 3) {
            return "app";
        }
        if (category == 6) {
            return "novel";
        }
        if (category == 8) {
            return "zip";
        }
        if (category == 11) {
            return DownloadStatisticConstants.UBC_VALUE_OFFLINE_WEB;
        }
        if (category == 12) {
            return "downloading";
        }
        if (category == 13) {
            return "file";
        }
        if (category == 4) {
            DocClassifyHelper.DocCategroy docDetailType = DocClassifyHelper.getDocDetailType(fileSuffix, str2);
            if (docDetailType == DocClassifyHelper.DocCategroy.PDF) {
                return "pdf";
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.PPT) {
                return "ppt";
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.WORD) {
                return DownloadStatisticConstants.UBC_VALUE_WORD;
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.EXCEL) {
                return DownloadStatisticConstants.UBC_VALUE_EXCEL;
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.TEXT) {
                return "text";
            }
        }
        return "other";
    }

    public static int getIconId(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = str.toLowerCase(Locale.getDefault());
        } else {
            str3 = "";
        }
        String fileSuffix = FileClassifyHelper.getFileSuffix(str3);
        int category = FileClassifyHelper.getCategory(fileSuffix, str2);
        if (category == 0) {
            return R.drawable.obfuscated_res_0x7f0805e3;
        }
        if (category == 1) {
            return R.drawable.obfuscated_res_0x7f0805dc;
        }
        if (category == 2) {
            return R.drawable.obfuscated_res_0x7f0805db;
        }
        if (category == 3) {
            return R.drawable.obfuscated_res_0x7f0805d9;
        }
        if (category == 6) {
            return R.drawable.obfuscated_res_0x7f0805dd;
        }
        if (category == 8) {
            return R.drawable.obfuscated_res_0x7f0805e5;
        }
        if (category == 4) {
            DocClassifyHelper.DocCategroy docDetailType = DocClassifyHelper.getDocDetailType(fileSuffix, str2);
            if (docDetailType == DocClassifyHelper.DocCategroy.PDF) {
                return R.drawable.obfuscated_res_0x7f0805e0;
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.PPT) {
                return R.drawable.obfuscated_res_0x7f0805e1;
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.WORD) {
                return R.drawable.obfuscated_res_0x7f0805e4;
            }
            if (docDetailType == DocClassifyHelper.DocCategroy.EXCEL) {
                return R.drawable.obfuscated_res_0x7f0805da;
            }
            if (docDetailType != DocClassifyHelper.DocCategroy.TEXT) {
                return R.drawable.obfuscated_res_0x7f0805df;
            }
            return R.drawable.obfuscated_res_0x7f0805e2;
        } else if (category != 11) {
            return R.drawable.obfuscated_res_0x7f0805df;
        } else {
            return R.drawable.obfuscated_res_0x7f0805de;
        }
    }

    public static String makeUniqueFilename(String str, String str2) throws GenerateSaveFileError {
        String str3 = str + str2;
        String str4 = str + "-";
        int i = 1;
        for (int i2 = 1; i2 < 1000000000; i2 *= 10) {
            for (int i3 = 0; i3 < 9; i3++) {
                String str5 = str4 + i + str2;
                if (!new File(str5).exists() && !FileDownloader.isFilePathRepeat(str5)) {
                    return str5;
                }
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "file with sequence number " + i + " exists");
                }
                i += RANDOM.nextInt(i2) + 1;
            }
        }
        throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_8, "failed to generate an unused filename on internal download storage");
    }

    public static String chooseFilename(String str, String str2, String str3, String str4, String str5, int i) {
        int lastIndexOf;
        int lastIndexOf2;
        String decode;
        if (str3 != null && !str3.endsWith("/")) {
            if (DEBUG) {
                Log.v("DownloadManager", "getting filename from hint");
            }
            int lastIndexOf3 = str3.lastIndexOf(47) + 1;
            if (lastIndexOf3 > 0) {
                str3 = str3.substring(lastIndexOf3);
            }
        } else {
            str3 = null;
        }
        if (str3 == null && str4 != null) {
            str3 = parseContentDisposition(str4);
            if (!TextUtils.isEmpty(str3)) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "getting filename from content-disposition");
                }
                int lastIndexOf4 = str3.lastIndexOf(47) + 1;
                if (lastIndexOf4 > 0) {
                    str3 = str3.substring(lastIndexOf4);
                }
            }
        }
        if (str3 == null && str5 != null && (decode = Uri.decode(str5)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "getting filename from content-location");
            }
            int lastIndexOf5 = decode.lastIndexOf(47) + 1;
            if (lastIndexOf5 > 0) {
                str3 = decode.substring(lastIndexOf5);
            } else {
                str3 = decode;
            }
        }
        if (str3 == null && str2 != null) {
            int indexOf = str2.indexOf(63);
            if (indexOf < 0) {
                indexOf = str2.length();
            }
            String decode2 = Uri.decode(str2.substring(0, indexOf));
            if (decode2 != null && !decode2.endsWith("/") && decode2.indexOf(63) < 0 && (lastIndexOf2 = decode2.lastIndexOf(47) + 1) > 0) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "getting filename from request uri");
                }
                str3 = decode2.substring(lastIndexOf2);
            }
        }
        if (str3 == null && str != null) {
            int indexOf2 = str.indexOf(63);
            if (indexOf2 < 0) {
                indexOf2 = str.length();
            }
            String decode3 = Uri.decode(str.substring(0, indexOf2));
            if (decode3 != null && !decode3.endsWith("/") && decode3.indexOf(63) < 0 && (lastIndexOf = decode3.lastIndexOf(47) + 1) > 0) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "getting filename from original uri");
                }
                str3 = decode3.substring(lastIndexOf);
            }
        }
        if (str3 == null) {
            if (DEBUG) {
                Log.v("DownloadManager", "using default filename");
            }
            str3 = "downloadfile";
        }
        String replaceAll = str3.replaceAll("[()（）,：:\\|^$#_，。：=、/+《》<>*?？‘“”''\"\"]", "_");
        try {
            replaceAll = URLDecoder.decode(replaceAll, "UTF-8");
        } catch (Exception unused) {
        }
        int lastIndexOf6 = replaceAll.lastIndexOf(46);
        if (lastIndexOf6 > 0) {
            String substring = replaceAll.substring(lastIndexOf6);
            String substring2 = replaceAll.substring(0, lastIndexOf6);
            return getDownloadFileNameCutOff(substring2, 50) + substring;
        }
        return getDownloadFileNameCutOff(replaceAll, 60);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:4:0x0003, B:11:0x0018, B:13:0x0020, B:7:0x000c, B:9:0x0012), top: B:22:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void createDownloadDirectory(File file) {
        boolean z;
        DebugException debugException;
        if (file != null) {
            boolean z2 = false;
            try {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        deleteDownloadDirectory(file);
                    }
                    if (!z2) {
                        boolean mkdirs = file.mkdirs();
                        if (DEBUG) {
                            Log.d(TAG, "createDownloadDirectory(),  create download directory, succeed = " + mkdirs + ",  directory = " + file);
                            return;
                        }
                        return;
                    }
                    return;
                }
                z2 = true;
                if (!z2) {
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    @Deprecated
    public static boolean deleteDownloadDirectory(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            File file2 = new File(absolutePath);
            long currentTimeMillis = System.currentTimeMillis();
            File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
            file2.renameTo(file3);
            return file3.delete();
        } catch (Throwable th) {
            if (!DEBUG) {
                return false;
            }
            throw new DebugException("DownloadHelperdeleteFile() : " + th);
        }
    }

    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (Pattern.compile("[|\\\\]").matcher(str).find()) {
            try {
                URL url = new URL(str);
                return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL().toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static void parseStatement(Lexer lexer) {
        if (lexer.currentToken() == 4) {
            lexer.advance();
            if (lexer.currentToken() == 5) {
                lexer.advance();
                if (lexer.currentToken() == 6) {
                    lexer.advance();
                    return;
                }
                throw new IllegalArgumentException("syntax error, expected quoted string");
            } else if (lexer.currentToken() == 7) {
                lexer.advance();
                if (lexer.currentToken() == 8) {
                    lexer.advance();
                    return;
                }
                throw new IllegalArgumentException("syntax error, expected NULL");
            } else {
                throw new IllegalArgumentException("syntax error after column name");
            }
        }
        throw new IllegalArgumentException("syntax error, expected column name");
    }

    public static void deleteFile(ContentResolver contentResolver, long j, String str, String str2, int i) {
        try {
            if (!DownloadMediaHelper.deleteMediaFile(AppRuntime.getAppContext(), str, str2) && DownloadRuntime.GLOBAL_DEBUG) {
                Log.w("DownloadManager", "deleteFile failed");
            }
        } catch (Exception e) {
            Log.w("DownloadManager", "file: '" + str + "' couldn't be deleted", e);
        }
        if (i == 2) {
            contentResolver.delete(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, "_id = ? ", new String[]{String.valueOf(j)});
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean discardPurgeableFiles(Context context, long j) {
        long j2;
        Cursor query;
        Cursor cursor = null;
        try {
            query = context.getContentResolver().query(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, null, "( status = '200' AND destination = '2' )", null, "lastmod");
        } catch (SQLiteFullException unused) {
            j2 = 0;
        } catch (Throwable th) {
            th = th;
        }
        if (query == null) {
            Closeables.closeSafely(query);
            return false;
        }
        try {
            try {
                query.moveToFirst();
                j2 = 0;
                while (!query.isAfterLast() && j2 < j) {
                    try {
                        File file = new File(query.getString(query.getColumnIndex("_data")));
                        if (Constants.LOGVV) {
                            Log.v("DownloadManager", "purging " + file.getAbsolutePath() + " for " + file.length() + " bytes");
                        }
                        j2 += file.length();
                        if (!file.delete() && DownloadRuntime.GLOBAL_DEBUG) {
                            Log.v("DownloadManager", "delete file failed.");
                        }
                        context.getContentResolver().delete(ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, query.getLong(query.getColumnIndex("_id"))), null, null);
                        query.moveToNext();
                    } catch (SQLiteFullException unused2) {
                        cursor = query;
                        Closeables.closeSafely(cursor);
                        if (Constants.LOGV) {
                            Log.v("DownloadManager", "Purged files, freed " + j2 + " for " + j + " requested");
                        }
                        if (j2 > 0) {
                        }
                    }
                }
                Closeables.closeSafely(query);
            } catch (SQLiteFullException unused3) {
                j2 = 0;
            }
            if (Constants.LOGV && j2 > 0) {
                Log.v("DownloadManager", "Purged files, freed " + j2 + " for " + j + " requested");
            }
            if (j2 > 0) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            Closeables.closeSafely(cursor);
            throw th;
        }
    }

    public static String generateSaveFile(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, long j, boolean z) throws GenerateSaveFileError {
        checkCanHandleDownload(context, str6, i, z);
        try {
            if (i == 4) {
                return getPathForFileUri(context, str, str2, str3, str4, str5, str6, i, j);
            }
            if (i == 5) {
                return buildExternalPublicFullPath(context, str, str2, str3, str4, str5, str6, i, j);
            }
            return chooseFullPath(context, str, str2, str3, str4, str5, str6, i, j);
        } catch (Throwable th) {
            String str7 = " generateSaveFile() : (Exception e) : \n context = " + getDisplayString(context) + "\n originalUrl = " + getDisplayString(str) + "\n requestUrl = " + getDisplayString(str2) + "\n hint = " + getDisplayString(str3) + "\n contentDisposition = " + getDisplayString(str4) + "\n mimeType = " + getDisplayString(str6) + "\n destination = " + getDisplayString(Integer.valueOf(i)) + "\n contentLength = " + getDisplayString(Long.valueOf(j)) + "\n isPublicApi = " + getDisplayString(Boolean.valueOf(z)) + "\n";
            if (DEBUG) {
                Log.e(TAG, str7 + th);
            }
            throw new GenerateSaveFileError(492, "DownloadHelper : generateSaveFile() : (Exception e)  : \n " + th);
        }
    }

    public static String getBeforeStringVariableLength(String str, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            if (str.charAt(i5) <= 127) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            i6 += i4;
            if (i6 > i2 - i3) {
                break;
            }
            i5++;
        }
        return str.substring(0, i5);
    }

    public static File locateDestinationDirectory(Context context, String str, int i, long j) throws GenerateSaveFileError {
        if (i != 1 && i != 2 && i != 3 && !Constants.MIMETYPE_DRM_MESSAGE.equalsIgnoreCase(str)) {
            return getDestination(context, j);
        }
        return getCacheDestination(context, j);
    }

    public static void requestExternalStoragePermission(Context context, final String str, final EventCallback eventCallback, final ExternalStorageCallBack externalStorageCallBack) {
        final Activity realTopActivity;
        if (context instanceof Activity) {
            realTopActivity = (Activity) context;
        } else {
            realTopActivity = BdBoxActivityManager.getRealTopActivity();
        }
        DangerousPermissionUtils.requestPermissions(PERMISSION_SOURCE_DOWNLOAD_EXTERNALSTORAGE, realTopActivity, new String[]{g.i, "android.permission.WRITE_EXTERNAL_STORAGE"}, 10000, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.download.util.DownloadHelper.2
            @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
            public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                boolean z;
                if (i == 10000) {
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (iArr[i2] != 0) {
                                z = false;
                                break;
                            }
                            i2++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        ExternalStorageCallBack externalStorageCallBack2 = ExternalStorageCallBack.this;
                        if (externalStorageCallBack2 != null) {
                            externalStorageCallBack2.onResult(true);
                        }
                        EventCallback eventCallback2 = eventCallback;
                        if (eventCallback2 != null) {
                            eventCallback2.callBack(3, new EventCallback.EventBackInfo(EventCallback.Info.INFO_PERMISSION_SYSTEM_GRANTED));
                        }
                        px.t(str, true);
                        return;
                    }
                    ExternalStorageCallBack externalStorageCallBack3 = ExternalStorageCallBack.this;
                    if (externalStorageCallBack3 != null) {
                        externalStorageCallBack3.onResult(false);
                    }
                    EventCallback eventCallback3 = eventCallback;
                    if (eventCallback3 != null) {
                        eventCallback3.callBack(2, new EventCallback.EventBackInfo(110));
                    }
                    px.t(str, false);
                    nx.k(realTopActivity, str, eventCallback);
                }
            }
        });
    }

    public static String subVariableLengthTitle(String str, int i, int i2, boolean z) {
        String substring = str.substring(0, i);
        if (titleNotTooLong(str, i)) {
            return str;
        }
        return getBeforeStringVariableLength(substring, i, i2, z) + "..." + getEndString(substring, i, z) + str.substring(i);
    }

    public static File getCacheDestination(Context context, long j) throws GenerateSaveFileError {
        File cacheDir = context.getCacheDir();
        for (long availableBytes = getAvailableBytes(cacheDir); availableBytes < j; availableBytes = getAvailableBytes(cacheDir)) {
            if (!discardPurgeableFiles(context, j - availableBytes)) {
                throw new GenerateSaveFileError(498, context.getString(R.string.obfuscated_res_0x7f0f05f0));
            }
        }
        return cacheDir;
    }

    public static File getDownloadDirectoryReal(String str, String str2) {
        File downloadDirectoryUserSet = getDownloadDirectoryUserSet();
        if (downloadDirectoryUserSet == null) {
            return getDownloadDirectoryDefault(str, str2);
        }
        return downloadDirectoryUserSet;
    }

    public static String getDownloadFileNameCutOff(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() > i) {
            return str.substring(0, i);
        }
        return str;
    }

    public static String getMediaFileDefaultPathFromFile(String str, String str2) {
        return DownloadMediaHelper.getMediaFileDefaultPathFromFile(str, str2);
    }

    public static String getMimeTypeFromFilename(String str, String str2) {
        String guessMimeTypeFromExtension;
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf > 0 && (guessMimeTypeFromExtension = FileClassifyHelper.guessMimeTypeFromExtension(str2.substring(lastIndexOf + 1))) != null && !guessMimeTypeFromExtension.equalsIgnoreCase(str) && chooseExtensionFromMimeType(str, false) == null) {
            return guessMimeTypeFromExtension;
        }
        return str;
    }

    public static String getTitleCutOff(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f05e2);
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return subTitle(str, z);
        }
        return subTitle(str, lastIndexOf, z);
    }

    public static String getVariableLengthTitleCutOff(String str, int i) {
        return getVariableLengthTitleCutOff(str, i, false);
    }

    public static void showMsg(Context context, final int i) {
        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.download.util.DownloadHelper.1
            @Override // java.lang.Runnable
            public void run() {
                UniversalToast.makeText(AppRuntime.getAppContext(), i).showToast();
            }
        });
    }

    public static String subTitle(String str, boolean z) {
        int length = str.length();
        if (titleNotTooLong(str, length)) {
            return str;
        }
        return getBeforeString(str, length, z) + "..." + getEndString(str, length, z) + str.substring(length);
    }

    public static boolean titleNotTooLong(String str, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i2 >= i) {
                break;
            }
            if (str.charAt(i2) > 127) {
                i4 = 2;
            }
            i3 += i4;
            i2++;
        }
        if (i3 >= 20) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Incorrect finally slice size: {[GOTO] complete}, expected: {[GOTO, IF, INSTANCE_OF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, INSTANCE_OF, IF, SGET] complete} */
    /* JADX WARN: Finally extract failed */
    public static File getDestination(Context context, long j) throws GenerateSaveFileError {
        File filesDir;
        if (DEBUG) {
            Log.d("DownloadManager", "Download destination mode is: " + Downloads.getDestinationMode().name());
            Log.d("DownloadManager", "Download destination dir is: " + Downloads.getDestinationDir());
        }
        File downloadPrivateFile = getDownloadPrivateFile();
        if (DEBUG) {
            Log.d(TAG, " getDestination() : if(!isStoragePermissionGranted()) : \n base = " + getDisplayString(downloadPrivateFile) + "\n");
        }
        String str = "";
        if (getAvailableBytes(downloadPrivateFile) < j && isStoragePermissionGranted() && !DownloadMediaHelper.isOpenScopedStorage()) {
            try {
                if (DEBUG) {
                    Log.d(TAG, " getDestination() : if((getAvailableBytes(base) < contentLength) && isStoragePermissionGranted()) : \n Downloads.getDestinationMode() = " + getDisplayString(Downloads.getDestinationMode()) + "\n");
                }
                int i = AnonymousClass4.$SwitchMap$com$baidu$searchbox$download$model$Downloads$DestinationMode[Downloads.getDestinationMode().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                filesDir = new File(Downloads.getDestinationDir());
                            }
                        } else if (isExternalMediaMounted()) {
                            File externalStorageDirectory = Environment.getExternalStorageDirectory();
                            downloadPrivateFile = new File(externalStorageDirectory.getPath() + Constants.DEFAULT_DL_SUBDIR);
                        } else {
                            throw new GenerateSaveFileError(499, "external media not mounted");
                        }
                    } else {
                        filesDir = context.getFilesDir();
                    }
                } else {
                    if (isExternalMediaMounted() && getAvailableBytes(Environment.getExternalStorageDirectory()) > j) {
                        String string = PreferenceUtils.getString("downloadcenter_path", "");
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                File file = new File(string);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                downloadPrivateFile = file;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            downloadPrivateFile = getDownloadDirectory(context);
                        }
                        if (DEBUG) {
                            Log.d("DownloadManager", "Common ExternalStorage path =======" + downloadPrivateFile);
                        }
                    } else {
                        Object[] volumeList = StorageUtils.getVolumeList();
                        if (volumeList != null) {
                            int length = volumeList.length;
                            if (DEBUG) {
                                Log.d("DownloadManager", "TotalvolumeCount=" + length);
                            }
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length) {
                                    break;
                                }
                                String volumePath = StorageUtils.getVolumePath(volumeList[i2]);
                                if (DEBUG) {
                                    Log.d("DownloadManager", "invoke path[" + i2 + "]===========" + volumePath);
                                }
                                if (StorageUtils.getVolumeState(volumePath).equals("mounted") && getAvailableBytes(new File(volumePath)) > j) {
                                    downloadPrivateFile = new File(volumePath + Constants.DEFAULT_DL_SUBDIR);
                                    if (DEBUG) {
                                        Log.d("DownloadManager", "Other Volume path =======" + volumePath + Constants.DEFAULT_DL_SUBDIR);
                                    }
                                } else {
                                    i2++;
                                }
                            }
                        }
                    }
                    if (downloadPrivateFile == null) {
                        if (isExternalMediaMounted()) {
                            showMsg(context, R.string.obfuscated_res_0x7f0f05da);
                        } else {
                            showMsg(context, R.string.obfuscated_res_0x7f0f05eb);
                        }
                        filesDir = context.getFilesDir();
                    }
                }
                downloadPrivateFile = filesDir;
            } catch (Throwable th) {
                downloadPrivateFile = getDownloadPrivateFile();
                if (DEBUG) {
                    Log.e(TAG, (" getDestination() : (Exception e) : \n base = " + getDisplayString(downloadPrivateFile) + "\n") + th);
                }
            }
        }
        if (downloadPrivateFile != null) {
            try {
            } catch (Throwable th2) {
                if (DEBUG) {
                    Log.e(TAG, (" getDestination() : (Exception e) : \n base = " + getDisplayString(downloadPrivateFile) + "\n") + th2);
                }
                if (th2 instanceof GenerateSaveFileError) {
                    throw th2;
                }
            }
            if (downloadPrivateFile.isDirectory() || downloadPrivateFile.mkdirs()) {
                long availableBytes = getAvailableBytes(downloadPrivateFile);
                if (DEBUG) {
                    Log.d("DownloadManager", "download dir is: " + downloadPrivateFile.getAbsolutePath());
                    Log.d("DownloadManager", "available space is: " + availableBytes);
                }
                if (availableBytes < j) {
                    if (DownloadRuntime.GLOBAL_DEBUG) {
                        Log.d("DownloadManager", "download aborted - not enough free space");
                    }
                    throw new GenerateSaveFileError(498, context.getString(R.string.obfuscated_res_0x7f0f05f0));
                }
                return downloadPrivateFile;
            }
        }
        if (downloadPrivateFile != null) {
            str = downloadPrivateFile.getPath();
        }
        throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_7, "unable to create downloads directory " + str);
    }

    @Nullable
    public static File getDownloadPrivateFile() {
        File file;
        String str = "";
        try {
            str = PreferenceUtils.getString("downloadcenter_path", "");
            if (!TextUtils.isEmpty(str) && !DownloadMediaHelper.isOpenScopedStorage()) {
                file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                file = getDownloadDirectory(AppRuntime.getAppContext());
            }
        } catch (Exception e) {
            File downloadDirectory = getDownloadDirectory(AppRuntime.getAppContext());
            if (DEBUG) {
                Log.e(TAG, (" getDestination() : \n filePath = " + getDisplayString(str) + "\n downloadPrivateFile = " + getDisplayString(downloadDirectory) + "\n") + e);
            }
            file = downloadDirectory;
        }
        if (DEBUG) {
            Log.e(TAG, " getDestination() : \n filePath = " + getDisplayString(str) + "\n downloadPrivateFile = " + getDisplayString(file) + "\n");
        }
        return file;
    }

    public static String getFileSuffix(String str, String str2) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 != -1 && lastIndexOf2 < str.length() - 1) {
            return str.substring(lastIndexOf2 + 1);
        }
        if (TextUtils.isEmpty(str2) || (lastIndexOf = str2.lastIndexOf(".")) == -1 || lastIndexOf >= str2.length() - 1) {
            return "";
        }
        return str2.substring(lastIndexOf + 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int getFileTypeIntByString(String str) {
        char c;
        switch (str.hashCode()) {
            case -1211129254:
                if (str.equals("downloading")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 96801:
                if (str.equals("app")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 110834:
                if (str.equals("pdf")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 111220:
                if (str.equals("ppt")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 120609:
                if (str.equals("zip")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3143036:
                if (str.equals("file")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 3655434:
                if (str.equals(DownloadStatisticConstants.UBC_VALUE_WORD)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 96948919:
                if (str.equals(DownloadStatisticConstants.UBC_VALUE_EXCEL)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 100313435:
                if (str.equals("image")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 104263205:
                if (str.equals("music")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 105010748:
                if (str.equals("novel")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1834995345:
                if (str.equals(DownloadStatisticConstants.UBC_VALUE_OFFLINE_WEB)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 11;
            case 7:
                return 12;
            case '\b':
                return 13;
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
                return 4;
            default:
                return 5;
        }
    }

    public static File getFilesystemRoot(String str) {
        try {
            File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
            if (!str.startsWith(downloadCacheDirectory.getPath()) && !str.startsWith(Environment.getDataDirectory().toString())) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (str.startsWith(externalStorageDirectory.getPath())) {
                    return externalStorageDirectory;
                }
                List<StorageUtils.StorageInfo> storageList = StorageUtils.getStorageList();
                if (storageList != null) {
                    for (StorageUtils.StorageInfo storageInfo : storageList) {
                        if (str.startsWith(storageInfo.mPath)) {
                            return new File(storageInfo.mPath);
                        }
                    }
                }
                throw new DebugException("DownloadHelper getFilesystemRoot() : Cannot determine filesystem root for " + str);
            }
            return downloadCacheDirectory;
        } catch (Exception unused) {
            throw new DebugException("DownloadHelper getFilesystemRoot() : Cannot determine filesystem root for " + str);
        }
    }

    public static boolean needRequestPermissionBeforeDownloadSpecifiedDirectory(String str) {
        boolean z;
        if (TextUtils.isEmpty(str) && DEBUG) {
            throw new DebugException("needRequestPermissionBeforeDownloadDefaultDirectory(downloadPath)\n downloadPath = " + getDisplayString(str) + "\n The specified downloadPath check cannot be empty!");
        }
        if (!DownloadMediaHelper.isOpenScopedStorage() && !isStoragePrivatePath(str) && !isStoragePermissionGranted()) {
            z = true;
        } else {
            z = false;
        }
        if (DEBUG) {
            Log.e(TAG, " needRequestPermissionBeforeDownloadSpecifiedDirectory() : \n downloadPath = " + getDisplayString(str) + "\n needRequest = " + getDisplayString(Boolean.valueOf(z)) + "\n");
        }
        return z;
    }

    public static String parseContentDisposition(String str) {
        String decode;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replaceAll = str.replaceAll(" ", "");
        String[] split = replaceAll.split(ParamableElem.DIVIDE_PARAM);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str3 = split[i];
            if (!TextUtils.isEmpty(str3) && str3.contains("filename*")) {
                String[] split2 = str3.split("'");
                if (split2.length > 0) {
                    try {
                        String[] split3 = split2[0].split("=");
                        if (split3.length > 0) {
                            decode = URLDecoder.decode(split2[split2.length - 1], split3[split3.length - 1]);
                        } else {
                            decode = URLDecoder.decode(split2[split2.length - 1], "utf-8");
                        }
                        str2 = decode;
                    } catch (Exception unused) {
                    }
                }
            } else {
                i++;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                Matcher matcher = CONTENT_DISPOSITION_PATTERN.matcher(replaceAll);
                if (matcher.find()) {
                    return matcher.group(2);
                }
            } catch (IllegalStateException e) {
                Log.w(TAG, e);
            }
        }
        return str2;
    }

    public static String getPathForFileUri(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, long j) throws GenerateSaveFileError {
        String substring;
        String makeUniqueFilename;
        String chooseExtensionFromFilename;
        try {
            try {
                if (!TextUtils.isEmpty(str3)) {
                    String encodedPath = Uri.parse(str3).getEncodedPath();
                    if (!TextUtils.isEmpty(encodedPath)) {
                        boolean z = true;
                        if (encodedPath.endsWith("/")) {
                            String chooseFilename = chooseFilename(str, str2, str3, str4, str5, i);
                            int lastIndexOf = chooseFilename.lastIndexOf(46);
                            if (lastIndexOf < 0) {
                                chooseExtensionFromFilename = chooseExtensionFromMimeType(str6, true);
                            } else {
                                chooseExtensionFromFilename = chooseExtensionFromFilename(str6, i, chooseFilename, lastIndexOf);
                                chooseFilename = chooseFilename.substring(0, lastIndexOf);
                            }
                            encodedPath = encodedPath + chooseFilename + chooseExtensionFromFilename;
                        }
                        if (!new File(encodedPath).exists()) {
                            if (!FileDownloader.isFilePathRepeat(encodedPath)) {
                                return encodedPath;
                            }
                        } else {
                            z = false;
                        }
                        if (needRequestPermissionBeforeDownloadSpecifiedDirectory(encodedPath)) {
                            String str7 = " generateSaveFile() : (Exception e) : \n context = " + getDisplayString(context) + "\n hint = " + getDisplayString(str3) + "\n contentLength = " + getDisplayString(Long.valueOf(j)) + "\n path = " + getDisplayString(encodedPath) + "\n Download does not have external storage permission. Please apply for external storage permission before downloading.\n ";
                            if (DEBUG) {
                                Log.e(TAG, str7);
                            }
                            throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_3, "DownloadHelper : getPathForFileUri() : throw new GenerateSaveFileError  : \n " + str7);
                        } else if (!DownloadMediaHelper.checkDownloadSpecifiedDirectoryValid(encodedPath)) {
                            String str8 = " generateSaveFile() : (Exception e) : \n context = " + getDisplayString(context) + "\n hint = " + getDisplayString(str3) + "\n contentLength = " + getDisplayString(Long.valueOf(j)) + "\n path = " + getDisplayString(encodedPath) + "\n Download directory does not meet Android 10 partition storage specifications\n ";
                            if (DEBUG) {
                                Log.e(TAG, str8);
                            }
                            throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_4, "DownloadHelper : getPathForFileUri() : throw new GenerateSaveFileError  : \n " + str8);
                        } else {
                            int lastIndexOf2 = encodedPath.lastIndexOf(46);
                            if (lastIndexOf2 == -1) {
                                substring = "";
                            } else {
                                String substring2 = encodedPath.substring(0, lastIndexOf2);
                                substring = encodedPath.substring(lastIndexOf2);
                                encodedPath = substring2;
                            }
                            if (z) {
                                makeUniqueFilename = encodedPath + "-" + System.currentTimeMillis() + substring;
                            } else {
                                makeUniqueFilename = makeUniqueFilename(encodedPath, substring);
                            }
                            if (!new File(makeUniqueFilename).exists()) {
                                if (getAvailableBytes(getFilesystemRoot(makeUniqueFilename)) >= j) {
                                    return makeUniqueFilename;
                                }
                                throw new GenerateSaveFileError(498, context.getString(R.string.obfuscated_res_0x7f0f05f0));
                            }
                            throw new GenerateSaveFileError(488, "requested destination file already exists");
                        }
                    }
                    throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_2, "requested destination is null");
                }
                throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_1, "requested destination is null");
            } catch (Throwable th) {
                th = th;
                String str9 = " getPathForFileUri(Context context, String hint, long contentLength) : \n context = " + getDisplayString(context) + "\n hint = " + getDisplayString(str3) + "\n contentLength = " + getDisplayString(Long.valueOf(j)) + "\n";
                if (DEBUG) {
                    Log.e(TAG, str9 + th);
                }
                throw new GenerateSaveFileError(Downloads.Impl.STATUS_FILE_ERROR_5, TAG + str9 + th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getTitleCutOffWithSuffix(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f05e2);
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            String fileSuffix = getFileSuffix(str, str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (TextUtils.isEmpty(fileSuffix)) {
                str3 = "";
            } else {
                str3 = "." + fileSuffix;
            }
            sb.append(str3);
            str = sb.toString();
            lastIndexOf = str.lastIndexOf(".");
        }
        if (lastIndexOf == -1) {
            return subTitle(str, false);
        }
        return subTitle(str, lastIndexOf, false);
    }

    public static void validateSelection(String str, Set<String> set) {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Lexer lexer = new Lexer(str, set);
                    parseExpression(lexer);
                    if (lexer.currentToken() == 9) {
                        return;
                    }
                    throw new IllegalArgumentException("syntax error");
                }
            } catch (RuntimeException e) {
                if (Constants.LOGV) {
                    Log.d("DownloadManager", "invalid selection [" + str + "] triggered " + e);
                } else {
                    Log.d("DownloadManager", "invalid selection triggered " + e);
                }
                throw e;
            }
        }
    }

    public static String getVariableLengthTitleCutOffWithSuffix(String str, String str2, int i) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f05e2);
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            String fileSuffix = getFileSuffix(str, str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (TextUtils.isEmpty(fileSuffix)) {
                str3 = "";
            } else {
                str3 = "." + fileSuffix;
            }
            sb.append(str3);
            str = sb.toString();
            lastIndexOf = str.lastIndexOf(".");
        }
        if (lastIndexOf == -1) {
            return subVariableLengthTitle(str, i, false);
        }
        return subVariableLengthTitle(str, lastIndexOf, i, false);
    }

    public static boolean isExternalMediaMounted() {
        boolean z;
        try {
            z = PathUtils.isExternalStorageWritable();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, (" isExternalMediaMounted() : (Exception e) : \n isExternalMediaMounted = " + getDisplayString(Boolean.FALSE) + "\n") + e);
            }
            z = false;
        }
        if (DEBUG) {
            Log.d(TAG, " isExternalMediaMounted() : \n isExternalMediaMounted = " + getDisplayString(Boolean.valueOf(z)) + "\n");
        }
        return z;
    }

    public static boolean needRequestPermissionBeforeDownloadDefaultDirectory() {
        boolean z;
        if (!isStoragePrivatePath(getDownloadPrivateFile().getAbsolutePath()) && !isStoragePermissionGranted()) {
            z = true;
        } else {
            z = false;
        }
        if (DEBUG) {
            Log.e(TAG, " needRequestPermissionBeforeDownloadDefaultDirectory() : \n getDownloadPrivateFile().getAbsolutePath() = " + getDisplayString(getDownloadPrivateFile().getAbsolutePath()) + "\n needRequest = " + getDisplayString(Boolean.valueOf(z)) + "\n");
        }
        return z;
    }
}
