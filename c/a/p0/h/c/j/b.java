package c.a.p0.h.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.h.c.f;
import c.a.p0.h.c.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11092g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f11093h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.h.c.i.b f11094a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f11095b;

    /* renamed from: c  reason: collision with root package name */
    public String f11096c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f11097d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f11098e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f11099f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11100e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11100e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11100e.f11099f = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        }
    }

    /* renamed from: c.a.p0.h.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0560b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11101e;

        public RunnableC0560b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11101e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11101e.f11099f.pauseAll();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11102e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11102e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11102e.f11099f.resume();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1208175142, "Lc/a/p0/h/c/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1208175142, "Lc/a/p0/h/c/j/b;");
                return;
            }
        }
        f11092g = k.f7085a;
        c.a.p0.a.h2.d.b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11095b = new HashMap<>();
        this.f11096c = f.g();
        this.f11094a = new c.a.p0.h.c.i.b(this.f11096c);
        c();
        e().post(new a(this));
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f11093h == null) {
                synchronized (b.class) {
                    if (f11093h == null) {
                        f11093h = new b();
                    }
                }
            }
            return f11093h;
        }
        return (b) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f11097d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f11097d = handlerThread;
            handlerThread.start();
            this.f11098e = new Handler(this.f11097d.getLooper());
        }
    }

    public synchronized c.a.p0.h.c.j.c d(String str, boolean z) {
        InterceptResult invokeLZ;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            synchronized (this) {
                if (f11092g) {
                    String str2 = "create media player src = " + str;
                }
                dVar = new d();
            }
            return dVar;
        }
        return (c.a.p0.h.c.j.c) invokeLZ.objValue;
    }

    public Handler e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11098e : (Handler) invokeV.objValue;
    }

    public long f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.f11095b.containsKey(str)) {
                return this.f11095b.get(str).longValue();
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    mediaMetadataRetriever.release();
                    this.f11095b.put(str, Long.valueOf(parseLong));
                    return parseLong;
                } catch (Exception e2) {
                    if (f11092g) {
                        e2.printStackTrace();
                    }
                    mediaMetadataRetriever.release();
                    return 0L;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        return invokeL.longValue;
    }

    public String g(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.f11096c + f.d(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SwanAudioPlayer swanAudioPlayer = this.f11099f;
            if (swanAudioPlayer != null) {
                swanAudioPlayer.isAudioPlayer();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(String str, c.a.p0.h.c.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.f11094a.e(str, aVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f11099f == null) {
            return;
        }
        e().post(new c(this));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f11099f == null) {
            return;
        }
        e().postDelayed(new RunnableC0560b(this), 50L);
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jsArrayBuffer, bVar) == null) {
            c.a.p0.h.c.j.a.f().h(jsArrayBuffer, bVar);
        }
    }
}
