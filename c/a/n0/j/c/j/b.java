package c.a.n0.j.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.j.c.f;
import c.a.n0.j.c.j.a;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f8651g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f8652h;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.j.c.i.b a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f8653b;

    /* renamed from: c  reason: collision with root package name */
    public String f8654c;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f8655d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f8656e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f8657f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f8657f = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        }
    }

    /* renamed from: c.a.n0.j.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0695b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC0695b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f8657f.pauseAll();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f8657f.resume();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1576380950, "Lc/a/n0/j/c/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1576380950, "Lc/a/n0/j/c/j/b;");
                return;
            }
        }
        f8651g = c.a.n0.a.a.a;
        c.a.n0.a.a2.d.b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8653b = new HashMap<>();
        this.f8654c = f.g();
        this.a = new c.a.n0.j.c.i.b(this.f8654c);
        c();
        e().post(new a(this));
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8652h == null) {
                synchronized (b.class) {
                    if (f8652h == null) {
                        f8652h = new b();
                    }
                }
            }
            return f8652h;
        }
        return (b) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f8655d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f8655d = handlerThread;
            handlerThread.start();
            this.f8656e = new Handler(this.f8655d.getLooper());
        }
    }

    public synchronized c.a.n0.j.c.j.c d(String str, boolean z) {
        InterceptResult invokeLZ;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            synchronized (this) {
                if (f8651g) {
                    Log.e("AudioPlayerManager", "create media player src = " + str);
                }
                dVar = new d();
            }
            return dVar;
        }
        return (c.a.n0.j.c.j.c) invokeLZ.objValue;
    }

    public Handler e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8656e : (Handler) invokeV.objValue;
    }

    public long f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.f8653b.containsKey(str)) {
                return this.f8653b.get(str).longValue();
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    mediaMetadataRetriever.release();
                    this.f8653b.put(str, Long.valueOf(parseLong));
                    return parseLong;
                } catch (Exception e2) {
                    if (f8651g) {
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
            return this.f8654c + f.d(str);
        }
        return (String) invokeL.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SwanAudioPlayer swanAudioPlayer = this.f8657f;
            if (swanAudioPlayer != null) {
                swanAudioPlayer.isAudioPlayer();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j(String str, c.a.n0.j.c.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.a.e(str, aVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f8657f == null) {
            return;
        }
        e().post(new c(this));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f8657f == null) {
            return;
        }
        e().postDelayed(new RunnableC0695b(this), 50L);
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, jsArrayBuffer, bVar) == null) {
            c.a.n0.j.c.j.a.f().h(jsArrayBuffer, bVar);
        }
    }
}
