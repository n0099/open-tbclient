package com.baidu.media.transcoder.cyber;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.z.f.c;
import c.a.z.f.d;
import c.a.z.f.e;
import c.a.z.f.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MediaTranscoder extends d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.z.f.f.a f42749f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f42750g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f42751h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f42752i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f42753a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f42754b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f42755c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f42756d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f42757e;
    public long mNativeTranscoder;

    /* loaded from: classes5.dex */
    public static class a implements c.a.z.f.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // c.a.z.f.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                System.loadLibrary(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final MediaTranscoder f42758a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MediaTranscoder mediaTranscoder, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaTranscoder, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42758a = mediaTranscoder;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                MediaTranscoder mediaTranscoder = this.f42758a;
                if (mediaTranscoder == null) {
                    e.d("MediaTranscoder", "MediaTranscoder went away with unhandled events.");
                    return;
                }
                e.a("MediaTranscoder", "handleMessage() msg.what:" + message.what);
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 == 1) {
                        e.c("MediaTranscoder", "MEDIA_PREPARED (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.b();
                    } else if (i2 == 2) {
                        e.c("MediaTranscoder", "MEDIA_TRANSCODER_COMPLETE (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.c();
                    } else if (i2 == 3) {
                        e.c("MediaTranscoder", "MEDIA_TRANSCODER_TERMINAL (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.d();
                    } else if (i2 == 100) {
                        e.c("MediaTranscoder", "MEDIA_ERROR (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                        mediaTranscoder.a(message.arg1, message.arg2);
                    } else if (i2 != 200) {
                        e.e("MediaTranscoder", "Unknown message type " + message.what);
                    } else {
                        e.c("MediaTranscoder", "MEDIA_INFO (" + message.arg1 + "," + message.arg2 + message.obj + SmallTailInfo.EMOTION_SUFFIX);
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
        f42749f = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaTranscoder() {
        this(f42749f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((c.a.z.f.f.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e.c("MediaTranscoder", "Software decoder mode. SDK Version:" + getSDKVersion() + " Core Version:" + getCoreVersion());
    }

    public MediaTranscoder(c.a.z.f.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42754b = new ArrayList<>();
        this.f42755c = new ArrayList<>();
        this.f42756d = new ArrayList<>();
        this.f42757e = new ArrayList<>();
        b(aVar);
    }

    private native String _getNativeVersion();

    private native int _getProgress();

    private native void _pause();

    private native void _prepareAsync();

    private native void _release();

    private native void _reset();

    private native void _start();

    private native void _stop();

    public static void a(c.a.z.f.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            synchronized (MediaTranscoder.class) {
                if (!f42750g) {
                    if (aVar == null) {
                        aVar = f42749f;
                    }
                    e.c("MediaTranscoder", "loadLibrariesOnce ....");
                    aVar.a("cbffmpeg");
                    aVar.a("sdl");
                    aVar.a("transcoder");
                    f42750g = true;
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

    private void b(c.a.z.f.f.a aVar) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, aVar) == null) {
            a(aVar);
            f();
            e();
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                bVar = new b(this, myLooper);
            } else {
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == null) {
                    this.f42753a = null;
                    native_setup(this);
                }
                bVar = new b(this, mainLooper);
            }
            this.f42753a = bVar;
            native_setup(this);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            synchronized (MediaTranscoder.class) {
                if (!f42752i) {
                    Context a2 = c.a();
                    PackageManager packageManager = a2.getPackageManager();
                    String packageName = a2.getPackageName();
                    String str = XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT;
                    String e2 = c.a.z.f.i.a.e(a2);
                    String c2 = c.c();
                    String c3 = h.c(a2);
                    if (packageManager != null) {
                        try {
                            str = packageManager.getPackageInfo(packageName, 0).versionName;
                        } catch (PackageManager.NameNotFoundException e3) {
                            e3.printStackTrace();
                        }
                    }
                    nativeStatisticInit(packageName, str, c2, c2, c3, c.b(), e2, null);
                    nativeSetInfo(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                    nativeSetInfo("model", Build.MODEL);
                    nativeSetInfo(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                    nativeSetInfo("os_type", "Android");
                    f42752i = true;
                }
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            synchronized (MediaTranscoder.class) {
                if (!f42751h) {
                    native_init();
                    f42751h = true;
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
            c.a.z.f.i.b.g().h(str, "sailor_monitor", i2);
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
                    if (mediaTranscoder.f42753a != null) {
                        e.a("MediaTranscoder", "postEventFromNative message type:" + i2 + ", arg1:" + i3 + ", arg2:" + i4 + ", obj:" + obj2);
                        mediaTranscoder.f42753a.sendMessage(mediaTranscoder.f42753a.obtainMessage(i2, i3, i4, obj2));
                        return;
                    }
                    return;
                }
                str = "postEventFromNative weakThiz reference is null";
            }
            e.e("MediaTranscoder", str);
        }
    }

    public void a(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            this.f42757e.clear();
            if (arrayList != null) {
                this.f42757e.addAll(arrayList);
            }
        }
    }

    public String getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f42750g) {
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
            e.c("MediaTranscoder", "getCurrentPosition: " + i2);
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
            if (this.f42757e.size() == 0) {
                for (int i2 = 0; i2 < this.f42754b.size(); i2++) {
                    this.f42757e.add("-i");
                    this.f42757e.add(this.f42754b.get(i2));
                }
                for (int i3 = 0; i3 < this.f42756d.size(); i3 += 2) {
                    ArrayList<String> arrayList = this.f42757e;
                    arrayList.add("-" + this.f42756d.get(i3));
                    this.f42757e.add(this.f42756d.get(i3 + 1));
                }
                for (int i4 = 0; i4 < this.f42755c.size(); i4++) {
                    this.f42757e.add(this.f42755c.get(i4));
                }
            }
            ArrayList<String> arrayList2 = this.f42757e;
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
            this.f42754b.add(str);
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
            this.f42756d.add(str);
            this.f42756d.add(str2);
        }
    }

    public void setOutputFile(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f42755c.add(str);
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
