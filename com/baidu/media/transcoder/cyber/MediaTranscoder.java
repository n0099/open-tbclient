package com.baidu.media.transcoder.cyber;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.pd0;
import com.baidu.tieba.qd0;
import com.baidu.tieba.rd0;
import com.baidu.tieba.sd0;
import com.baidu.tieba.ud0;
import com.baidu.tieba.vd0;
import com.baidu.tieba.wd0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class MediaTranscoder extends qd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final sd0 f;
    public static volatile boolean g;
    public static volatile boolean h;
    public static volatile boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public ArrayList<String> b;
    public ArrayList<String> c;
    public ArrayList<String> d;
    public ArrayList<String> e;
    public long mNativeTranscoder;

    /* loaded from: classes2.dex */
    public static class a implements sd0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.tieba.sd0
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                System.loadLibrary(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaTranscoder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MediaTranscoder mediaTranscoder, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaTranscoder, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaTranscoder;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                MediaTranscoder mediaTranscoder = this.a;
                if (mediaTranscoder == null) {
                    rd0.d("MediaTranscoder", "MediaTranscoder went away with unhandled events.");
                    return;
                }
                rd0.a("MediaTranscoder", "handleMessage() msg.what:" + message.what);
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        rd0.c("MediaTranscoder", "MEDIA_PREPARED (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.b();
                    } else if (i == 2) {
                        rd0.c("MediaTranscoder", "MEDIA_TRANSCODER_COMPLETE (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.c();
                    } else if (i == 3) {
                        rd0.c("MediaTranscoder", "MEDIA_TRANSCODER_TERMINAL (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.d();
                    } else if (i == 100) {
                        rd0.c("MediaTranscoder", "MEDIA_ERROR (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.a(message.arg1, message.arg2);
                    } else if (i != 200) {
                        rd0.e("MediaTranscoder", "Unknown message type " + message.what);
                    } else {
                        rd0.c("MediaTranscoder", "MEDIA_INFO (" + message.arg1 + "," + message.arg2 + message.obj + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.a(message.arg1, message.arg2, message.obj);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421995639, "Lcom/baidu/media/transcoder/cyber/MediaTranscoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421995639, "Lcom/baidu/media/transcoder/cyber/MediaTranscoder;");
                return;
            }
        }
        f = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaTranscoder() {
        this(f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((sd0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        rd0.c("MediaTranscoder", "Software decoder mode. SDK Version:" + getSDKVersion() + " Core Version:" + getCoreVersion());
    }

    public MediaTranscoder(sd0 sd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sd0Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        b(sd0Var);
    }

    private native String _getNativeVersion();

    private native int _getProgress();

    private native void _pause();

    private native void _prepareAsync();

    private native void _release();

    private native void _reset();

    private native void _start();

    private native void _stop();

    public static void a(sd0 sd0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, sd0Var) == null) {
            synchronized (MediaTranscoder.class) {
                if (!g) {
                    if (sd0Var == null) {
                        sd0Var = f;
                    }
                    rd0.c("MediaTranscoder", "loadLibrariesOnce ....");
                    sd0Var.a("cbffmpeg");
                    sd0Var.a("sdl");
                    sd0Var.a("transcoder");
                    g = true;
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split.length == 4 && split2.length == 4 && split[0].equalsIgnoreCase(split2[0]) && split[1].equalsIgnoreCase(split2[1]) && split[2].equalsIgnoreCase(split2[2])) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void b(sd0 sd0Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, sd0Var) == null) {
            a(sd0Var);
            f();
            e();
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                bVar = new b(this, myLooper);
            } else {
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null) {
                    this.a = null;
                    native_setup(this);
                }
                bVar = new b(this, mainLooper);
            }
            this.a = bVar;
            native_setup(this);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            synchronized (MediaTranscoder.class) {
                if (!i) {
                    Context a2 = pd0.a();
                    PackageManager packageManager = a2.getPackageManager();
                    String packageName = a2.getPackageName();
                    String str = "0.0";
                    String e = vd0.e(a2);
                    String c = pd0.c();
                    String c2 = ud0.c(a2);
                    if (packageManager != null) {
                        try {
                            str = packageManager.getPackageInfo(packageName, 0).versionName;
                        } catch (PackageManager.NameNotFoundException e2) {
                            e2.printStackTrace();
                        }
                    }
                    nativeStatisticInit(packageName, str, c, c, c2, pd0.b(), e, null);
                    nativeSetInfo(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                    nativeSetInfo("model", Build.MODEL);
                    nativeSetInfo(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                    nativeSetInfo("os_type", "Android");
                    i = true;
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            synchronized (MediaTranscoder.class) {
                if (!h) {
                    native_init();
                    h = true;
                }
            }
        }
    }

    public static native void nativeSetInfo(String str, String str2);

    private native void nativeSetSource(String[] strArr);

    private native void nativeSetSwTransStat();

    public static native void nativeStatisticInit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    private native void native_finalize();

    public static native void native_init();

    private native void native_setLogLevel(int i2);

    private native void native_setup(Object obj);

    public static void onUploadStatData(Object obj, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65565, null, obj, str, i2) == null) {
            wd0.g().h(str, "sailor_monitor", i2);
        }
    }

    public static void postEventFromNative(Object obj, int i2, int i3, int i4, Object obj2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj2}) == null) {
            if (obj == null) {
                str = "postEventFromNative weakThiz is null";
            } else {
                MediaTranscoder mediaTranscoder = (MediaTranscoder) obj;
                if (mediaTranscoder != null) {
                    if (mediaTranscoder.a != null) {
                        rd0.a("MediaTranscoder", "postEventFromNative message type:" + i2 + ", arg1:" + i3 + ", arg2:" + i4 + ", obj:" + obj2);
                        mediaTranscoder.a.sendMessage(mediaTranscoder.a.obtainMessage(i2, i3, i4, obj2));
                        return;
                    }
                    return;
                }
                str = "postEventFromNative weakThiz reference is null";
            }
            rd0.e("MediaTranscoder", str);
        }
    }

    public void a(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            this.e.clear();
            if (arrayList != null) {
                this.e.addAll(arrayList);
            }
        }
    }

    public String getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (g) {
                return "1.1.8.12";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getCurrentPosition() {
        int i2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                i2 = _getProgress();
            } catch (Exception unused) {
                i2 = 0;
            }
            rd0.c("MediaTranscoder", "getCurrentPosition: " + i2);
            return i2;
        }
        return invokeV.intValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "1.1.8.12" : (String) invokeV.objValue;
    }

    public int getTotalSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            _pause();
        }
    }

    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.e.size() == 0) {
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    this.e.add("-i");
                    this.e.add(this.b.get(i2));
                }
                for (int i3 = 0; i3 < this.d.size(); i3 += 2) {
                    ArrayList<String> arrayList = this.e;
                    arrayList.add("-" + this.d.get(i3));
                    this.e.add(this.d.get(i3 + 1));
                }
                for (int i4 = 0; i4 < this.c.size(); i4++) {
                    this.e.add(this.c.get(i4));
                }
            }
            ArrayList<String> arrayList2 = this.e;
            nativeSetSource((String[]) arrayList2.toArray(new String[arrayList2.size()]));
            _prepareAsync();
            nativeSetSwTransStat();
        }
    }

    public int probe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(getSDKVersion(), getCoreVersion()) ? 90 : 0 : invokeV.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a();
            _release();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            _reset();
        }
    }

    public void setDataSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.b.add(str);
        }
    }

    public void setNativeLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            native_setLogLevel(i2);
        }
    }

    public void setOption(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.d.add(str);
            this.d.add(str2);
        }
    }

    public void setOutputFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.c.add(str);
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            _start();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            _stop();
        }
    }
}
