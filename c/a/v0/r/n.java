package c.a.v0.r;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MediaInfo;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, str)) != null) {
            return invokeL.longValue;
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            if (new File(str).exists()) {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever2.setDataSource(str);
                    long d2 = g.d(mediaMetadataRetriever2.extractMetadata(9), 0L);
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception unused) {
                    }
                    return d2;
                } catch (Exception unused2) {
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused3) {
                        }
                    }
                    return 0L;
                } catch (Throwable th) {
                    th = th;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
            return 0L;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            long j = 0;
            if (FileUtils.isExists(str)) {
                MediaExtractor mediaExtractor = new MediaExtractor();
                try {
                    try {
                        mediaExtractor.setDataSource(str);
                        MediaFormat mediaFormat = null;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= mediaExtractor.getTrackCount()) {
                                break;
                            }
                            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                            if (trackFormat.getString("mime").startsWith(i == 0 ? "audio/" : com.sina.weibo.sdk.utils.FileUtils.VIDEO_FILE_START)) {
                                mediaExtractor.selectTrack(i2);
                                mediaFormat = trackFormat;
                                break;
                            }
                            i2++;
                        }
                        if (mediaFormat != null) {
                            j = mediaFormat.getLong("durationUs");
                        }
                    } catch (Exception e2) {
                        c.e("VideoMuxer", "getMediaDurationMs error:" + e2.getMessage());
                    }
                    return j / 1000;
                } finally {
                    mediaExtractor.release();
                }
            }
            return 0L;
        }
        return invokeLI.longValue;
    }

    public static MediaInfo d(String str) {
        InterceptResult invokeL;
        MediaInfo mediaInfo;
        File file;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (MediaInfo) invokeL.objValue;
        }
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                file = new File(str);
            } catch (Exception e2) {
                e = e2;
                mediaInfo = null;
            }
            if (file.exists() && file.isFile()) {
                mediaInfo = new MediaInfo();
                try {
                    mediaInfo.setVideoPath(str);
                    mediaInfo.setLastModified(file.lastModified());
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    mediaInfo.setDuration(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)));
                    mediaInfo.setMimeType(mediaMetadataRetriever.extractMetadata(12));
                    mediaInfo.setVideoWidth(Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)));
                    mediaInfo.setVideoHeight(Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)));
                    mediaInfo.setRotation(g.c(mediaMetadataRetriever.extractMetadata(24), 0));
                    b.a(mediaMetadataRetriever);
                } catch (Exception e4) {
                    e = e4;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    c.g(e);
                    if (mediaMetadataRetriever2 != null) {
                        b.a(mediaMetadataRetriever2);
                    }
                    return mediaInfo;
                } catch (Throwable th) {
                    th = th;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    if (mediaMetadataRetriever2 != null) {
                        b.a(mediaMetadataRetriever2);
                    }
                    throw th;
                }
                return mediaInfo;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    int c2 = g.c(mediaMetadataRetriever.extractMetadata(20), 0);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return c2;
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, null, str)) != null) {
            return invokeL.intValue;
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            if (new File(str).exists()) {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever2.setDataSource(str);
                    int parseInt = Integer.parseInt(mediaMetadataRetriever2.extractMetadata(9));
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (Exception unused) {
                    }
                    return parseInt;
                } catch (Exception unused2) {
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused3) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            }
            return 0;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @TargetApi(16)
    public static boolean g(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
                if (m.j(mediaExtractor.getTrackFormat(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
