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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointStoreOnCache;
import com.baidu.searchbox.bddownload.core.breakpoint.DownloadStore;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.connection.DownloadUrlConnection;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class Util {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static Logger logger;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class EmptyLogger implements Logger {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EmptyLogger() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void e(String str, String str2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, exc) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void i(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.Util.Logger
        public void w(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface Logger {
        void d(String str, String str2);

        void e(String str, String str2, Exception exc);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-697620588, "Lcom/baidu/searchbox/bddownload/core/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-697620588, "Lcom/baidu/searchbox/bddownload/core/Util;");
                return;
            }
        }
        logger = new EmptyLogger();
    }

    public Util() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addDefaultUserAgent(@NonNull DownloadConnection downloadConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, downloadConnection) == null) {
            downloadConnection.addHeader("User-Agent", "BdDownload/");
        }
    }

    public static void addRequestHeaderFields(@NonNull Map<String, List<String>> map, @NonNull DownloadConnection downloadConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, map, downloadConnection) == null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                for (String str : entry.getValue()) {
                    downloadConnection.addHeader(key, str);
                }
            }
        }
    }

    public static void addUserRequestHeaderField(@NonNull Map<String, List<String>> map, @NonNull DownloadConnection downloadConnection) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, downloadConnection) == null) {
            inspectUserHeader(map);
            addRequestHeaderFields(map, downloadConnection);
        }
    }

    public static void assembleBlock(@NonNull DownloadTask downloadTask, @NonNull BreakpointInfo breakpointInfo, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{downloadTask, breakpointInfo, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            int determineBlockCount = BdDownload.with().downloadStrategy().isUseMultiBlock(z) ? BdDownload.with().downloadStrategy().determineBlockCount(downloadTask, j) : 1;
            breakpointInfo.resetBlockInfos();
            long j2 = determineBlockCount;
            long j3 = j / j2;
            int i2 = 0;
            long j4 = 0;
            long j5 = 0;
            while (i2 < determineBlockCount) {
                j4 += j5;
                j5 = i2 == 0 ? (j % j2) + j3 : j3;
                breakpointInfo.addBlock(new BlockInfo(j4, j5));
                i2++;
            }
        }
    }

    public static boolean checkPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return (BdDownload.with().context() != null ? BdDownload.with().context().checkCallingOrSelfPermission(str) : -1) == 0;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public static DownloadConnection.Factory createDefaultConnectionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                return (DownloadConnection.Factory) Class.forName("com.baidu.searchbox.bddownload.core.connection.DownloadOkHttp3Connection$Factory").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return new DownloadUrlConnection.Factory();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return new DownloadUrlConnection.Factory();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                return new DownloadUrlConnection.Factory();
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return new DownloadUrlConnection.Factory();
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
                return new DownloadUrlConnection.Factory();
            }
        }
        return (DownloadConnection.Factory) invokeV.objValue;
    }

    @NonNull
    public static DownloadStore createDefaultDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return (DownloadStore) Class.forName("com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointStoreOnSQLite").getDeclaredConstructor(Context.class).newInstance(context);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                return new BreakpointStoreOnCache();
            }
        }
        return (DownloadStore) invokeL.objValue;
    }

    @NonNull
    public static DownloadStore createRemitDatabase(@NonNull DownloadStore downloadStore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, downloadStore)) == null) {
            try {
                downloadStore = (DownloadStore) downloadStore.getClass().getMethod("createRemitSelf", new Class[0]).invoke(downloadStore, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            d(com.baidu.android.common.util.Util.f2611b, "Get final download store is " + downloadStore);
            return downloadStore;
        }
        return (DownloadStore) invokeL.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.d(str, str2);
            } else {
                Log.d(str, str2);
            }
        }
    }

    public static void e(String str, String str2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, str2, exc) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.e(str, str2, exc);
            } else {
                Log.e(str, str2, exc);
            }
        }
    }

    public static void enableConsoleLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            logger = null;
        }
    }

    @Nullable
    public static String getFilenameFromContentUri(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, uri)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static long getFreeSpaceBytes(@NonNull StatFs statFs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, statFs)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeL.longValue;
    }

    public static Logger getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? logger : (Logger) invokeV.objValue;
    }

    @NonNull
    public static File getParentFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, file)) == null) {
            File parentFile = file.getParentFile();
            return parentFile == null ? new File("/") : parentFile;
        }
        return (File) invokeL.objValue;
    }

    public static long getSizeFromContentUri(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, uri)) == null) {
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
        return invokeL.longValue;
    }

    public static String humanReadableBytes(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            int i2 = z ? 1000 : 1024;
            if (j < i2) {
                return j + " B";
            }
            double d2 = j;
            double d3 = i2;
            int log = (int) (Math.log(d2) / Math.log(d3));
            StringBuilder sb = new StringBuilder();
            sb.append((z ? "kMGTPE" : "KMGTPE").charAt(log - 1));
            sb.append(z ? "" : "i");
            return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d2 / Math.pow(d3, log)), sb.toString());
        }
        return (String) invokeCommon.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.i(str, str2);
            } else {
                Log.i(str, str2);
            }
        }
    }

    public static void inspectUserHeader(@NonNull Map<String, List<String>> map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, map) == null) {
            if (map.containsKey(IF_MATCH) || map.containsKey("Range")) {
                throw new IOException("If-Match and Range only can be handle by internal!");
            }
        }
    }

    public static boolean isCorrectFull(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j == j2 : invokeCommon.booleanValue;
    }

    public static boolean isEmpty(@Nullable CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, charSequence)) == null) ? charSequence == null || charSequence.length() == 0 : invokeL.booleanValue;
    }

    public static boolean isInvalidUrl(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("http") : invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, connectivityManager)) == null) {
            if (connectivityManager == null) {
                w(com.baidu.android.common.util.Util.f2611b, "failed to get connectivity manager!");
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkNotOnWifiType(ConnectivityManager connectivityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, connectivityManager)) == null) {
            if (connectivityManager == null) {
                w(com.baidu.android.common.util.Util.f2611b, "failed to get connectivity manager!");
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean isUriContentScheme(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, uri)) == null) ? uri.getScheme().equals("content") : invokeL.booleanValue;
    }

    public static boolean isUriFileScheme(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, uri)) == null) ? uri.getScheme().equals("file") : invokeL.booleanValue;
    }

    @Nullable
    public static String md5(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            try {
                bArr = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                bArr = null;
            }
            if (bArr != null) {
                StringBuilder sb = new StringBuilder(bArr.length * 2);
                for (byte b2 : bArr) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append('0');
                    }
                    sb.append(Integer.toHexString(i2));
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static long parseContentLength(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                d(com.baidu.android.common.util.Util.f2611b, "parseContentLength failed parse for '" + str + "'");
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public static long parseContentLengthFromContentRange(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (str != null && str.length() != 0) {
                try {
                    Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                    if (matcher.find()) {
                        return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    }
                } catch (Exception e2) {
                    w(com.baidu.android.common.util.Util.f2611b, "parse content-length from content-range failed " + e2);
                }
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    public static void resetBlockIfDirty(BlockInfo blockInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, blockInfo) == null) {
            boolean z = true;
            if (blockInfo.getCurrentOffset() >= 0 && blockInfo.getCurrentOffset() <= blockInfo.getContentLength()) {
                z = false;
            }
            if (z) {
                w("resetBlockIfDirty", "block is dirty so have to reset: " + blockInfo);
                blockInfo.resetBlock();
            }
        }
    }

    public static void setLogger(@Nullable Logger logger2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, logger2) == null) {
            logger = logger2;
        }
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65569, null, str, z)) == null) ? new ThreadFactory(str, z) { // from class: com.baidu.searchbox.bddownload.core.Util.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean val$daemon;
            public final /* synthetic */ String val$name;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$name = str;
                this.val$daemon = z;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    Thread thread = new Thread(runnable, this.val$name);
                    thread.setDaemon(this.val$daemon);
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        } : (ThreadFactory) invokeLZ.objValue;
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, str, str2) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.w(str, str2);
            } else {
                Log.w(str, str2);
            }
        }
    }
}
