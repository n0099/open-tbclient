package com.baidu.media.videodownload;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.cyberplayer.sdk.videodownload.VideoDownloadBean;
import com.baidu.cyberplayer.sdk.videodownload.VideoSourceBean;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.duplayer.Utils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class VideoDownloader {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CyberVideoDownloader.DownloadListener f42759a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f42760b;

    /* renamed from: c  reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f42761c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-869580176, "Lcom/baidu/media/videodownload/VideoDownloader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-869580176, "Lcom/baidu/media/videodownload/VideoDownloader;");
                return;
            }
        }
        f42760b = new Object();
        f42761c = new ConcurrentHashMap<>();
    }

    public VideoDownloader() {
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

    public static VideoDownloadBean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bundle)) == null) {
            VideoDownloadBean videoDownloadBean = new VideoDownloadBean();
            if (bundle != null) {
                CyberLog.i("VideoDownloader", "BundleToVideoDownloadBean bundle=" + bundle.toString());
                String string = bundle.getString("url");
                int i2 = bundle.getInt("status");
                int i3 = bundle.getInt("progress");
                long j2 = bundle.getLong("downloaded_size");
                long j3 = bundle.getLong("create_timestamp");
                long j4 = bundle.getLong("video_size");
                int i4 = bundle.getInt("download_speed");
                String string2 = bundle.getString(PackageTable.MD5);
                String string3 = bundle.getString("play_url");
                String string4 = bundle.getString("mime_type");
                videoDownloadBean.url = string;
                videoDownloadBean.taskId = string;
                videoDownloadBean.status = i2;
                videoDownloadBean.progress = i3;
                videoDownloadBean.receivedBytes = j2;
                videoDownloadBean.createTimestamp = String.valueOf(j3);
                videoDownloadBean.totalBytes = j4;
                videoDownloadBean.speed = i4;
                videoDownloadBean.md5 = string2;
                videoDownloadBean.playUrl = string3;
                videoDownloadBean.mimeType = string4;
                videoDownloadBean.passthroughJsonStr = m(string);
            }
            return videoDownloadBean;
        }
        return (VideoDownloadBean) invokeL.objValue;
    }

    public static String b(String str, VideoSourceBean videoSourceBean) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, videoSourceBean)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str5 = "";
            if (videoSourceBean != null) {
                String d2 = d(videoSourceBean.headers, "User-Agent");
                String c2 = c(videoSourceBean.headers);
                String str6 = videoSourceBean.passthroughJsonStr;
                if (str6 == null) {
                    str6 = "";
                }
                g(str, videoSourceBean.passthroughJsonStr);
                str2 = d2;
                str3 = c2;
                str4 = str6;
            } else {
                str2 = "";
                str3 = str2;
                str4 = str3;
            }
            String j2 = Utils.j();
            if (j2 != null) {
                str5 = "http://" + j2;
            }
            nativeStartDownload(str, str2, str3, str5, "", str4);
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Map<String, String> map) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) {
            if (map == null || map.isEmpty()) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        sb.append(key);
                        sb.append(": ");
                        sb.append(value);
                        sb.append(Part.CRLF);
                    }
                }
                str = sb.toString();
            }
            return str != null ? str : "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, map, str)) == null) {
            if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = map.get(str);
                map.remove(str);
            }
            return str2 != null ? str2 : "";
        }
        return (String) invokeLL.objValue;
    }

    public static void e(CyberVideoDownloader.DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, downloadListener) == null) {
            synchronized (f42760b) {
                f42759a = downloadListener;
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            nativeSetWorkDir(str);
        }
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f42761c.put(str, str2);
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            nativePauseDownload(str);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            nativeCancelDownload(str);
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            nativeResumeDownload(str);
        }
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            nativeDeleteDownload(str);
        }
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = f42761c.get(str);
            f42761c.remove(str);
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f42761c.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static native void nativeCancelDownload(String str);

    public static native void nativeDeleteDownload(String str);

    public static native void nativePauseDownload(String str);

    public static native void nativeResumeDownload(String str);

    public static native void nativeSetWorkDir(String str);

    public static native void nativeStartDownload(String str, String str2, String str3, String str4, String str5, String str6);

    @Keep
    public static void operationCallback(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65557, null, str, i2, i3) == null) {
            CyberLog.i("VideoDownloader", "operationCallback url=" + str + " operationType=" + i2 + " result=" + i3);
            synchronized (f42760b) {
                if (f42759a != null) {
                    f42759a.operationCallback(str, i2, i3);
                }
            }
        }
    }

    @Keep
    public static void progressCallback(Bundle bundle) {
        VideoDownloadBean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, bundle) == null) || (a2 = a(bundle)) == null) {
            return;
        }
        synchronized (f42760b) {
            if (f42759a != null && a2 != null) {
                f42759a.onDataTransfer(a2.url, a2);
            }
        }
        int i2 = a2.status;
        if (i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8) {
            l(a2.url);
        }
    }

    @Keep
    public static void resultCallback(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, bundle) == null) || bundle == null || bundle.isEmpty()) {
            return;
        }
        CyberLog.i("VideoDownloader", "resultCallback bundle=" + bundle.toString());
    }

    @Keep
    public static void statusChangedCallback(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, bundle) == null) {
            VideoDownloadBean a2 = a(bundle);
            synchronized (f42760b) {
                if (f42759a != null && a2 != null) {
                    f42759a.onDataTransfer(a2.url, a2);
                }
            }
        }
    }
}
