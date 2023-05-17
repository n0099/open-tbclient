package com.baidu.searchbox.bddownload.core;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStoreOnCache;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.connection.DownloadUrlConnection;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class Util {
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_TYPE = "Content-TYPE";
    public static final String ETAG = "Etag";
    public static final String IF_MATCH = "If-Match";
    public static final String METHOD_HEAD = "HEAD";
    public static final String RANGE = "Range";
    public static final int RANGE_NOT_SATISFIABLE = 416;
    public static final String SCHEME_HTTP = "http";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String USER_AGENT = "User-Agent";
    public static final String VALUE_CHUNKED = "chunked";
    public static Logger logger = new EmptyLogger();

    /* loaded from: classes3.dex */
    public static class EmptyLogger implements Logger {
        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void d(String str, String str2) {
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void e(String str, String str2, Exception exc) {
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void i(String str, String str2) {
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void w(String str, String str2) {
        }
    }

    /* loaded from: classes3.dex */
    public interface Logger {
        void d(String str, String str2);

        void e(String str, String str2, Exception exc);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static boolean isCorrectFull(long j, long j2) {
        return j == j2;
    }

    public static void enableConsoleLog() {
        logger = null;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void addDefaultUserAgent(@NonNull DownloadConnection downloadConnection) {
        downloadConnection.addHeader("User-Agent", "BdDownload/");
    }

    public static boolean checkPermission(String str) {
        int i;
        if (BdDownload.with().context() != null) {
            i = BdDownload.with().context().checkCallingOrSelfPermission(str);
        } else {
            i = -1;
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static DownloadStore createDefaultDatabase(Context context) {
        try {
            return (DownloadStore) Class.forName("com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointStoreOnSQLite").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new BreakpointStoreOnCache();
        }
    }

    @NonNull
    public static DownloadStore createRemitDatabase(@NonNull DownloadStore downloadStore) {
        try {
            downloadStore = (DownloadStore) downloadStore.getClass().getMethod("createRemitSelf", new Class[0]).invoke(downloadStore, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        d("Util", "Get final download store is " + downloadStore);
        return downloadStore;
    }

    @Nullable
    public static String getFilenameFromContentUri(@NonNull Uri uri) {
        Cursor query = BdDownload.with().context().getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                return query.getString(query.getColumnIndex("_display_name"));
            } finally {
                query.close();
            }
        }
        return null;
    }

    public static long getFreeSpaceBytes(@NonNull StatFs statFs) {
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes();
        }
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    @NonNull
    public static File getParentFile(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return new File("/");
        }
        return parentFile;
    }

    public static long getSizeFromContentUri(@NonNull Uri uri) {
        Cursor query = BdDownload.with().context().getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                return query.getLong(query.getColumnIndex("_size"));
            } finally {
                query.close();
            }
        }
        return 0L;
    }

    public static void inspectUserHeader(@NonNull Map<String, List<String>> map) throws IOException {
        if (!map.containsKey(IF_MATCH) && !map.containsKey("Range")) {
            return;
        }
        throw new IOException("If-Match and Range only can be handle by internal!");
    }

    public static boolean isEmpty(@Nullable CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isInvalidUrl(@NonNull String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("http")) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            w("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkNotOnWifiType(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            w("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return true;
        }
        return false;
    }

    public static boolean isUriContentScheme(@NonNull Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static boolean isUriFileScheme(@NonNull Uri uri) {
        return uri.getScheme().equals("file");
    }

    public static long parseContentLength(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            d("Util", "parseContentLength failed parse for '" + str + "'");
            return -1L;
        }
    }

    public static void setLogger(@Nullable Logger logger2) {
        logger = logger2;
    }

    public static void addRequestHeaderFields(@NonNull Map<String, List<String>> map, @NonNull DownloadConnection downloadConnection) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            for (String str : entry.getValue()) {
                downloadConnection.addHeader(key, str);
            }
        }
    }

    public static void addUserRequestHeaderField(@NonNull Map<String, List<String>> map, @NonNull DownloadConnection downloadConnection) throws IOException {
        inspectUserHeader(map);
        addRequestHeaderFields(map, downloadConnection);
    }

    public static void d(String str, String str2) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.baidu.searchbox.bddownload.core.Util.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static void w(String str, String str2) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void assembleBlock(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, long j, boolean z) {
        int i;
        if (BdDownload.with().downloadStrategy().isUseMultiBlock(z)) {
            i = BdDownload.with().downloadStrategy().determineBlockCount(downloadTask, j);
        } else {
            i = 1;
        }
        breakpointInfo.resetBlockInfos();
        long j2 = i;
        long j3 = j / j2;
        long j4 = 0;
        long j5 = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j4 += j5;
            if (i2 == 0) {
                j5 = (j % j2) + j3;
            } else {
                j5 = j3;
            }
            breakpointInfo.addBlock(new BlockInfo(j4, j5));
        }
    }

    @NonNull
    public static DownloadConnection.Factory createDefaultConnectionFactory() {
        try {
            return (DownloadConnection.Factory) Class.forName("com.baidu.searchbox.bddownload.core.connection.DownloadOkHttp3Connection$Factory").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return new DownloadUrlConnection.Factory();
        }
    }

    @NonNull
    public static DownloadConnection.Factory createHttpManagerConnectionFactory() {
        try {
            return (DownloadConnection.Factory) Class.forName("com.baidu.searchbox.bddownload.core.connection.DownloadHttpManagerConnection$Factory").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return new DownloadUrlConnection.Factory();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return new DownloadUrlConnection.Factory();
        }
    }

    public static void e(String str, String str2, Exception exc) {
        Logger logger2 = logger;
        if (logger2 != null) {
            logger2.e(str, str2, exc);
        } else {
            Log.e(str, str2, exc);
        }
    }

    public static String humanReadableBytes(long j, boolean z) {
        int i;
        String str;
        String str2;
        if (z) {
            i = 1000;
        } else {
            i = 1024;
        }
        if (j < i) {
            return j + " B";
        }
        double d = j;
        double d2 = i;
        int log = (int) (Math.log(d) / Math.log(d2));
        StringBuilder sb = new StringBuilder();
        if (z) {
            str = "kMGTPE";
        } else {
            str = "KMGTPE";
        }
        sb.append(str.charAt(log - 1));
        if (z) {
            str2 = "";
        } else {
            str2 = "i";
        }
        sb.append(str2);
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d / Math.pow(d2, log)), sb.toString());
    }

    @Nullable
    public static String md5(String str) {
        byte[] bArr;
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append(TransactionIdCreater.FILL_BYTE);
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static void resetBlockIfDirty(BlockInfo blockInfo) {
        boolean z = true;
        if (blockInfo.getCurrentOffset() >= 0 && blockInfo.getCurrentOffset() <= blockInfo.getContentLength()) {
            z = false;
        }
        if (z) {
            w("resetBlockIfDirty", "block is dirty so have to reset: " + blockInfo);
            blockInfo.resetBlock();
        }
    }

    public static long parseContentLengthFromContentRange(@Nullable String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e) {
                w("Util", "parse content-length from content-range failed " + e);
            }
        }
        return -1L;
    }
}
