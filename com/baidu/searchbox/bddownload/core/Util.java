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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
    public interface Logger {
        void d(String str, String str2);

        void e(String str, String str2, Exception exc);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static boolean isCorrectFull(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j == j2 : invokeCommon.booleanValue;
    }

    /* loaded from: classes2.dex */
    public class EmptyLogger implements Logger {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public EmptyLogger() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void enableConsoleLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            logger = null;
        }
    }

    public static Logger getLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return logger;
        }
        return (Logger) invokeV.objValue;
    }

    public static void addDefaultUserAgent(DownloadConnection downloadConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, downloadConnection) == null) {
            downloadConnection.addHeader("User-Agent", "BdDownload/");
        }
    }

    public static boolean checkPermission(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static long getFreeSpaceBytes(StatFs statFs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, statFs)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeL.longValue;
    }

    public static File getParentFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return new File("/");
            }
            return parentFile;
        }
        return (File) invokeL.objValue;
    }

    public static void inspectUserHeader(Map map) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, map) == null) {
            if (!map.containsKey(IF_MATCH) && !map.containsKey("Range")) {
                return;
            }
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, charSequence)) == null) {
            if (charSequence != null && charSequence.length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isInvalidUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("http")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, connectivityManager)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean isNetworkNotOnWifiType(ConnectivityManager connectivityManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, connectivityManager)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean isUriContentScheme(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, uri)) == null) {
            return uri.getScheme().equals("content");
        }
        return invokeL.booleanValue;
    }

    public static boolean isUriFileScheme(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, uri)) == null) {
            return uri.getScheme().equals("file");
        }
        return invokeL.booleanValue;
    }

    public static void setLogger(Logger logger2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, logger2) == null) {
            logger = logger2;
        }
    }

    public static void addRequestHeaderFields(Map map, DownloadConnection downloadConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, map, downloadConnection) == null) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                for (String str2 : (List) entry.getValue()) {
                    downloadConnection.addHeader(str, str2);
                }
            }
        }
    }

    public static void addUserRequestHeaderField(Map map, DownloadConnection downloadConnection) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, downloadConnection) == null) {
            inspectUserHeader(map);
            addRequestHeaderFields(map, downloadConnection);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.d(str, str2);
            } else {
                Log.d(str, str2);
            }
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.i(str, str2);
            } else {
                Log.i(str, str2);
            }
        }
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65570, null, str, z)) == null) {
            return new ThreadFactory(str, z) { // from class: com.baidu.searchbox.bddownload.core.Util.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$name = str;
                    this.val$daemon = z;
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(runnable, this.val$name);
                        thread.setDaemon(this.val$daemon);
                        return thread;
                    }
                    return (Thread) invokeL.objValue;
                }
            };
        }
        return (ThreadFactory) invokeLZ.objValue;
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65571, null, str, str2) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.w(str, str2);
            } else {
                Log.w(str, str2);
            }
        }
    }

    public static void assembleBlock(DownloadTask downloadTask, BreakpointInfo breakpointInfo, long j, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{downloadTask, breakpointInfo, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
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
    }

    public static DownloadConnection.Factory createDefaultConnectionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
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
        return (DownloadConnection.Factory) invokeV.objValue;
    }

    public static DownloadConnection.Factory createHttpManagerConnectionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
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
        return (DownloadConnection.Factory) invokeV.objValue;
    }

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

    public static DownloadStore createRemitDatabase(DownloadStore downloadStore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, downloadStore)) == null) {
            try {
                downloadStore = (DownloadStore) downloadStore.getClass().getMethod("createRemitSelf", new Class[0]).invoke(downloadStore, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            d("Util", "Get final download store is " + downloadStore);
            return downloadStore;
        }
        return (DownloadStore) invokeL.objValue;
    }

    public static String getFilenameFromContentUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, uri)) == null) {
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

    public static long getSizeFromContentUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, uri)) == null) {
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

    public static long parseContentLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
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
        return invokeL.longValue;
    }

    public static void e(String str, String str2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, str2, exc) == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.e(str, str2, exc);
            } else {
                Log.e(str, str2, exc);
            }
        }
    }

    public static String humanReadableBytes(long j, boolean z) {
        InterceptResult invokeCommon;
        int i;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static String md5(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
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
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static long parseContentLengthFromContentRange(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
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
        return invokeL.longValue;
    }

    public static void resetBlockIfDirty(BlockInfo blockInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, blockInfo) == null) {
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
}
