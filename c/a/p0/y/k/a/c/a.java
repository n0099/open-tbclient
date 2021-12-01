package c.a.p0.y.k.a.c;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.y0.d;
import c.a.p0.a.y0.k.g.a;
import c.a.p0.a.z2.d0;
import c.a.p0.a.z2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.davemorrissey.labs.subscaleview.ImageSource;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public abstract class a implements c.a.p0.a.y0.k.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public static boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f11174b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11175c;

    /* renamed from: d  reason: collision with root package name */
    public ZeusPluginFactory.Invoker f11176d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayer f11177e;

    /* renamed from: f  reason: collision with root package name */
    public String f11178f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f11179g;

    /* renamed from: h  reason: collision with root package name */
    public String f11180h;

    /* renamed from: i  reason: collision with root package name */
    public a.InterfaceC0538a f11181i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f11182j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11183k;
    public boolean l;
    public int m;
    public int n;
    public c.a.p0.y.l.a.c.a o;
    public final CyberPlayerManager.OnPreparedListener p;
    public final CyberPlayerManager.OnErrorListener q;
    public final CyberPlayerManager.OnCompletionListener r;
    public final CyberPlayerManager.OnInfoListener s;
    public final CyberPlayerManager.OnBufferingUpdateListener t;
    public final CyberPlayerManager.OnSeekCompleteListener u;
    public final CyberPlayerManager.OnVideoSizeChangedListener v;
    public final AudioManager.OnAudioFocusChangeListener w;

    /* renamed from: c.a.p0.y.k.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0716a implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11184e;

        public C0716a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11184e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && a.x) {
                String str = "CyberPlayer" + this.f11184e.hashCode() + " - onSeekComplete()";
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CyberPlayerManager.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11185e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11185e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                if (a.x) {
                    String str = "CyberPlayer" + this.f11185e.hashCode() + " - onVideoSizeChanged(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f11185e.o.f11206e = i2;
                this.f11185e.o.f11207f = i3;
                if (i4 == 0 || i5 == 0) {
                    this.f11185e.m = 1;
                    this.f11185e.n = 1;
                } else {
                    this.f11185e.m = i4;
                    this.f11185e.n = i5;
                }
                a.InterfaceC0538a interfaceC0538a = this.f11185e.f11181i;
                if (interfaceC0538a != null) {
                    interfaceC0538a.f();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a.x) {
                    String str = "onAudioFocusChange: focusChange " + i2;
                }
                if (i2 == -1) {
                    boolean z = a.x;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.a a;

        public d(a aVar, d.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar2;
        }

        @Override // c.a.p0.y.k.a.c.a.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.a(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.p0.a.z2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f11186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11187f;

        public e(a aVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11187f = aVar;
            this.f11186e = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11187f.x0().setDataSource(this.f11187f.f11175c, Uri.parse(str), this.f11186e);
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements CyberPlayerManager.InstallListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        public f(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                boolean z = a.x;
                boolean unused = a.y = false;
                m mVar = this.a;
                if (mVar != null) {
                    mVar.a(false);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                boolean z = a.x;
                boolean unused = a.y = false;
                m mVar = this.a;
                if (mVar != null) {
                    mVar.a(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f11188e;

        public g(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11188e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.p0.a.d2.e L;
            SwanAppActivity x;
            Window window;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (L = c.a.p0.a.d2.e.L()) == null || (x = L.x()) == null || (window = x.getWindow()) == null) {
                return;
            }
            try {
                if (this.f11188e) {
                    window.addFlags(128);
                } else {
                    window.clearFlags(128);
                }
            } catch (Exception e2) {
                if (a.x) {
                    throw new RuntimeException("inline video set screenOn/Off in wrong thread", e2);
                }
            }
            if (a.x) {
                String str = "setKeepScreenOn: " + this.f11188e;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11189e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11189e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.x) {
                    String str = "CyberPlayer" + this.f11189e.hashCode() + " - onPrepared()";
                }
                this.f11189e.o.f11206e = this.f11189e.getVideoWidth();
                this.f11189e.o.f11207f = this.f11189e.getVideoHeight();
                a.InterfaceC0538a interfaceC0538a = this.f11189e.f11181i;
                if (interfaceC0538a != null) {
                    interfaceC0538a.onPrepared();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11190e;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11190e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                if (a.x) {
                    String str = "CyberPlayer" + this.f11190e.hashCode() + " - onError(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f11190e.o0();
                this.f11190e.A0(i2);
                int i4 = i2 == -10000 ? 0 : i2;
                a.InterfaceC0538a interfaceC0538a = this.f11190e.f11181i;
                if (interfaceC0538a != null) {
                    interfaceC0538a.onError(i4);
                }
                this.f11190e.C0(i2, i3, obj2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11191e;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11191e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = this.f11191e.getDuration() != 0 && this.f11191e.getCurrentPosition() >= this.f11191e.getDuration();
                if (a.x) {
                    String str = "CyberPlayer" + this.f11191e.hashCode() + " - onCompletion:(" + z + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f11191e.o0();
                a aVar = this.f11191e;
                a.InterfaceC0538a interfaceC0538a = aVar.f11181i;
                if (interfaceC0538a != null) {
                    if (z) {
                        interfaceC0538a.onEnded();
                    } else {
                        interfaceC0538a.c(aVar.c());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11192e;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11192e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (a.x) {
                    String str = "CyberPlayer" + this.f11192e.hashCode() + " - onInfo(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + (obj != null ? obj.toString() : StringUtil.NULL_STRING) + SmallTailInfo.EMOTION_SUFFIX;
                }
                switch (i2) {
                    case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                        this.f11192e.o.f11203b = i3;
                        break;
                    case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                        this.f11192e.o.a = i3;
                        break;
                    case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                        this.f11192e.o.f11204c = i3;
                        break;
                }
                this.f11192e.A0(i2);
                this.f11192e.f11181i.b(i2);
                if (i2 == 904) {
                    this.f11192e.D0();
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements CyberPlayerManager.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11193e;

        public l(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11193e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && a.x) {
                String str = "CyberPlayer" + this.f11193e.hashCode() + " - onBufferingUpdate(" + i2 + SmallTailInfo.EMOTION_SUFFIX;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface m {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339035927, "Lc/a/p0/y/k/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339035927, "Lc/a/p0/y/k/a/c/a;");
                return;
            }
        }
        x = c.a.p0.a.k.a;
        y = true;
    }

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.f11182j = false;
        this.f11183k = false;
        this.l = false;
        this.m = 1;
        this.n = 1;
        this.o = new c.a.p0.y.l.a.c.a();
        this.p = new h(this);
        this.q = new i(this);
        this.r = new j(this);
        this.s = new k(this);
        this.t = new l(this);
        this.u = new C0716a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.f11176d = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.f11178f = (String) obj;
            }
        }
        this.f11175c = c.a.p0.a.c1.a.c();
        this.f11180h = str;
    }

    public static String B0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.p0.a.d2.e L = c.a.p0.a.d2.e.L();
            return (!c.a.p0.a.o2.b.E(str) || L == null) ? str : c.a.p0.a.o2.b.H(str, L);
        }
        return (String) invokeL.objValue;
    }

    public static void I0(@NonNull Context context, @Nullable m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, mVar) == null) {
            if (y) {
                if (x) {
                    String str = "CyberPlayer播放内核开始安装 " + context.getApplicationContext();
                }
                try {
                    CyberPlayerManager.install(context.getApplicationContext(), c.a.p0.a.c1.a.h0().i(context), (String) null, 7, (Class<?>) null, (Map<String, String>) null, new f(mVar));
                    return;
                } catch (Exception e2) {
                    c.a.p0.a.e0.d.o("SwanInlineCyberWidget", "CyberPlayer Install failed by catch e=" + e2 + " :> " + Log.getStackTraceString(e2));
                    if (mVar != null) {
                        mVar.a(false);
                        return;
                    }
                    return;
                }
            }
            boolean z = x;
            if (mVar != null) {
                mVar.a(true);
            }
        }
    }

    @Override // c.a.p0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            I0(c.a.p0.a.c1.a.c(), new d(this, aVar));
        }
    }

    public final void A0(int i2) {
        a.InterfaceC0538a interfaceC0538a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            int b2 = c.a.p0.y.l.a.b.a.b(i2);
            if (x) {
                String str = "CyberPlayer" + hashCode() + " - send onStateChange(what " + i2 + ", statusCode " + b2 + SmallTailInfo.EMOTION_SUFFIX;
            }
            if (b2 != 100) {
                if (b2 == 2101 && (interfaceC0538a = this.f11181i) != null) {
                    interfaceC0538a.a(2102);
                }
                a.InterfaceC0538a interfaceC0538a2 = this.f11181i;
                if (interfaceC0538a2 != null) {
                    interfaceC0538a2.a(b2);
                }
            }
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                ZeusPluginFactory.Invoker invoker = this.f11176d;
                if (invoker != null) {
                    x0().changeProxyDynamic((String) invoker.get("Proxy"), true);
                    return;
                }
                return;
            }
            x0().changeProxyDynamic(null, false);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public abstract void C0(int i2, int i3, String str);

    public abstract void D0();

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f11183k) {
                boolean z = x;
                return;
            }
            if (this.f11179g == null) {
                this.f11179g = (AudioManager) this.f11175c.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f11179g;
            if (audioManager == null) {
                return;
            }
            try {
                audioManager.requestAudioFocus(this.w, 3, 1);
            } catch (Exception e2) {
                if (x) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void F0(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, hashMap) == null) {
            c.a.p0.a.c1.a.l().b(getContext(), str, new e(this, hashMap));
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void G(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && x) {
            String str = "setMinCache (ignore) : " + i2;
        }
    }

    public final void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            q0.a0(new g(this, z));
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f11182j = z;
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void L(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public boolean O(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (x) {
                String str4 = "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2;
            }
            this.l = true;
            this.f11174b = str;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith(ImageSource.FILE_SCHEME)) {
                str = str.substring(8);
            }
            String B0 = B0(str);
            ZeusPluginFactory.Invoker invoker = this.f11176d;
            if (invoker != null) {
                String str5 = (String) invoker.get("Proxy");
                if (!TextUtils.isEmpty(str5)) {
                    x0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str5);
                    x0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "true");
                } else {
                    x0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, "");
                    x0().setOption(CyberPlayerManager.OPT_NEED_T5_AUTH, "false");
                }
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("Cookie", str2);
            }
            if (z) {
                hashMap.put("x-hide-urls-from-log", "true");
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("User-Agent", str3);
            }
            String b2 = d0.b();
            if (!TextUtils.isEmpty(b2) && d0.c(B0)) {
                if (x) {
                    String str6 = "set referer for InlineVideo; referer is " + b2;
                }
                hashMap.put("Referer", b2);
            }
            if (c.a.p0.a.o2.b.s(B0) == PathType.CLOUD) {
                F0(B0, hashMap);
            } else {
                x0().setDataSource(this.f11175c, Uri.parse(B0), hashMap);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public a.InterfaceC0538a Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f11181i : (a.InterfaceC0538a) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void T(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            x0().setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, map);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    @CallSuper
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a = 0;
            boolean isPlaying = isPlaying();
            pause();
            if (isPlaying) {
                H0(true);
            }
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f11180h : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            c.a.p0.a.y0.k.f.b.b().a(c(), str);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.f11178f + "-" + hashCode();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    @CallSuper
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.a = 1;
            if (isPlaying() || !w0()) {
                return;
            }
            H0(false);
            start();
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && x) {
            String str = "setMaxCache (ignore) : " + i2;
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f11175c : (Context) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? x0().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? x0().getDuration() : invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? x0().getVideoHeight() : invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? x0().getVideoWidth() : invokeV.intValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void h0(@NonNull a.InterfaceC0538a interfaceC0538a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, interfaceC0538a) == null) {
            this.f11181i = interfaceC0538a;
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? x0().isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f11183k : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.y0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f11178f : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            if (x) {
                String str = "setMuted: " + z;
            }
            this.f11183k = z;
            if (z) {
                o0();
            } else {
                E0();
            }
            x0().muteOrUnmuteAudio(z);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.f11179g == null) {
                this.f11179g = (AudioManager) this.f11175c.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f11179g;
            if (audioManager == null) {
                return;
            }
            audioManager.abandonAudioFocus(this.w);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (x) {
                String str = this.f11178f + "-" + hashCode() + " pause()";
            }
            x0().pause();
            G0(false);
            H0(false);
            a.InterfaceC0538a interfaceC0538a = this.f11181i;
            if (interfaceC0538a != null) {
                interfaceC0538a.c(c());
            }
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            E0();
            x0().prepareAsync();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (x) {
                String str = this.f11178f + " release()";
            }
            a.InterfaceC0538a interfaceC0538a = this.f11181i;
            if (interfaceC0538a != null) {
                interfaceC0538a.onRelease(c());
            }
            o0();
            c.a.p0.a.u.e.n.l.e().r(c());
            x0().release();
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            x0().seekTo(i2);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            x0().setSpeed(f2);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, surface) == null) {
            x0().setSurface(surface);
        }
    }

    @Override // c.a.p0.a.y0.k.g.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (x) {
                String str = this.f11178f + "-" + hashCode() + " start()";
            }
            if (y0()) {
                if (x) {
                    String str2 = this.f11178f + "-" + hashCode() + " start ignored, widget is in background";
                }
                H0(true);
                a.InterfaceC0538a interfaceC0538a = this.f11181i;
                if (interfaceC0538a != null) {
                    interfaceC0538a.c(c());
                    return;
                }
                return;
            }
            E0();
            x0().start();
            G0(true);
            a.InterfaceC0538a interfaceC0538a2 = this.f11181i;
            if (interfaceC0538a2 != null) {
                interfaceC0538a2.e(c());
            }
        }
    }

    public final boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f11182j : invokeV.booleanValue;
    }

    public final synchronized CyberPlayer x0() {
        InterceptResult invokeV;
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            synchronized (this) {
                if (this.f11177e == null) {
                    if (c.a.p0.a.c1.a.g0().C()) {
                        boolean z = x;
                        this.f11177e = new CyberPlayer(0);
                    } else {
                        boolean z2 = x;
                        this.f11177e = new CyberPlayer(0);
                    }
                    this.f11177e.setOnPreparedListener(this.p);
                    this.f11177e.setOnVideoSizeChangedListener(this.v);
                    this.f11177e.setOnCompletionListener(this.r);
                    this.f11177e.setOnErrorListener(this.q);
                    this.f11177e.setOnInfoListener(this.s);
                    this.f11177e.setOnBufferingUpdateListener(this.t);
                    this.f11177e.setOnSeekCompleteListener(this.u);
                    if (x) {
                        String str = "create " + this.f11177e.hashCode() + " player";
                    }
                }
                cyberPlayer = this.f11177e;
            }
            return cyberPlayer;
        }
        return (CyberPlayer) invokeV.objValue;
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.a == -1) {
                SwanAppActivity x2 = c.a.p0.a.d2.d.J().x();
                if (x2 == null) {
                    boolean z = x;
                    return true;
                }
                c.a.p0.a.t0.c frame = x2.getFrame();
                if (frame == null) {
                    boolean z2 = x;
                    return true;
                }
                if (x) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("check background by frame lifeState, background ? ");
                    sb.append(!frame.a0().hasStarted());
                    sb.toString();
                }
                return !frame.a0().hasStarted();
            }
            if (x) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("check background by kernel state, background ? ");
                sb2.append(this.a == 0);
                sb2.toString();
            }
            return this.a == 0;
        }
        return invokeV.booleanValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            String a = this.o.a();
            if (TextUtils.isEmpty(a)) {
                return;
            }
            if (x) {
                String str = "CyberPlayer" + hashCode() + " - send onNetStatus(" + a + SmallTailInfo.EMOTION_SUFFIX;
            }
            a.InterfaceC0538a interfaceC0538a = this.f11181i;
            if (interfaceC0538a != null) {
                interfaceC0538a.d(a);
            }
        }
    }
}
