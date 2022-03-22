package c.a.n0.y.e.a.c;

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
import c.a.n0.a.o0.d;
import c.a.n0.a.o0.k.g.a;
import c.a.n0.a.p2.d0;
import c.a.n0.a.p2.q0;
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
/* loaded from: classes2.dex */
public abstract class a implements c.a.n0.a.o0.k.g.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public static boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f9530b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9531c;

    /* renamed from: d  reason: collision with root package name */
    public ZeusPluginFactory.Invoker f9532d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayer f9533e;

    /* renamed from: f  reason: collision with root package name */
    public String f9534f;

    /* renamed from: g  reason: collision with root package name */
    public AudioManager f9535g;

    /* renamed from: h  reason: collision with root package name */
    public String f9536h;
    public a.InterfaceC0396a i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public c.a.n0.y.f.a.c.a o;
    public final CyberPlayerManager.OnPreparedListener p;
    public final CyberPlayerManager.OnErrorListener q;
    public final CyberPlayerManager.OnCompletionListener r;
    public final CyberPlayerManager.OnInfoListener s;
    public final CyberPlayerManager.OnBufferingUpdateListener t;
    public final CyberPlayerManager.OnSeekCompleteListener u;
    public final CyberPlayerManager.OnVideoSizeChangedListener v;
    public final AudioManager.OnAudioFocusChangeListener w;

    /* renamed from: c.a.n0.y.e.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0770a implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0770a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onSeekComplete()");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CyberPlayerManager.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onVideoSizeChanged(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i4 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.a.o.f9548e = i;
                this.a.o.f9549f = i2;
                if (i3 == 0 || i4 == 0) {
                    this.a.m = 1;
                    this.a.n = 1;
                } else {
                    this.a.m = i3;
                    this.a.n = i4;
                }
                a.InterfaceC0396a interfaceC0396a = this.a.i;
                if (interfaceC0396a != null) {
                    interfaceC0396a.f();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (a.x) {
                    Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange " + i);
                }
                if (i == -1 && a.x) {
                    Log.i("SwanInlineCyberWidget", "onAudioFocusChange: focusChange = AudioManager.AUDIOFOCUS_LOSS");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar2;
        }

        @Override // c.a.n0.y.e.a.c.a.m
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.a(z);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a.n0.a.p2.g1.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f9537b;

        public e(a aVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9537b = aVar;
            this.a = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f9537b.x0().setDataSource(this.f9537b.f9531c, Uri.parse(str), this.a);
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
                if (a.x) {
                    Log.i("【CyberCallback】", "CyberPlayer播放内核安装失败");
                }
                boolean unused = a.y = false;
                m mVar = this.a;
                if (mVar != null) {
                    mVar.a(false);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallProgress(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.InstallListener
        public void onInstallSuccess(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
                if (a.x) {
                    Log.i("【CyberCallback】", "CyberPlayer播放内核安装成功");
                }
                boolean unused = a.y = false;
                m mVar = this.a;
                if (mVar != null) {
                    mVar.a(true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public g(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.n0.a.t1.e L;
            SwanAppActivity x;
            Window window;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (L = c.a.n0.a.t1.e.L()) == null || (x = L.x()) == null || (window = x.getWindow()) == null) {
                return;
            }
            try {
                if (this.a) {
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
                Log.d("SwanInlineCyberWidget", "setKeepScreenOn: " + this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onPrepared()");
                }
                this.a.o.f9548e = this.a.getVideoWidth();
                this.a.o.f9549f = this.a.getVideoHeight();
                a.InterfaceC0396a interfaceC0396a = this.a.i;
                if (interfaceC0396a != null) {
                    interfaceC0396a.onPrepared();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onError(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.a.o0();
                this.a.A0(i);
                int i3 = i == -10000 ? 0 : i;
                a.InterfaceC0396a interfaceC0396a = this.a.i;
                if (interfaceC0396a != null) {
                    interfaceC0396a.onError(i3);
                }
                this.a.C0(i, i2, obj2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class j implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public j(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = this.a.getDuration() != 0 && this.a.getCurrentPosition() >= this.a.getDuration();
                if (a.x) {
                    Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onCompletion:(" + z + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.a.o0();
                a aVar = this.a;
                a.InterfaceC0396a interfaceC0396a = aVar.i;
                if (interfaceC0396a != null) {
                    if (z) {
                        interfaceC0396a.onEnded();
                    } else {
                        interfaceC0396a.c(aVar.c());
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                if (a.x) {
                    String obj2 = obj != null ? obj.toString() : StringUtil.NULL_STRING;
                    Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onInfo(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj2 + SmallTailInfo.EMOTION_SUFFIX);
                }
                switch (i) {
                    case CyberPlayerManager.MEDIA_INFO_AUDIO_BITRATE /* 938 */:
                        this.a.o.f9545b = i2;
                        break;
                    case CyberPlayerManager.MEDIA_INFO_VIDEO_BITRATE /* 939 */:
                        this.a.o.a = i2;
                        break;
                    case CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE /* 940 */:
                        this.a.o.f9546c = i2;
                        break;
                }
                this.a.A0(i);
                this.a.i.b(i);
                if (i == 904) {
                    this.a.D0();
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class l implements CyberPlayerManager.OnBufferingUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public l(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
        public void onBufferingUpdate(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && a.x) {
                Log.d("【CyberCallback】", "CyberPlayer" + this.a.hashCode() + " - onBufferingUpdate(" + i + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface m {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-941085477, "Lc/a/n0/y/e/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-941085477, "Lc/a/n0/y/e/a/c/a;");
                return;
            }
        }
        x = c.a.n0.a.a.a;
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
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = 1;
        this.n = 1;
        this.o = new c.a.n0.y.f.a.c.a();
        this.p = new h(this);
        this.q = new i(this);
        this.r = new j(this);
        this.s = new k(this);
        this.t = new l(this);
        this.u = new C0770a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.f9532d = invoker;
        if (invoker != null) {
            Object obj = invoker.get("id");
            if (obj instanceof String) {
                this.f9534f = (String) obj;
            }
        }
        this.f9531c = c.a.n0.a.s0.a.c();
        this.f9536h = str;
    }

    public static String B0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            return (!c.a.n0.a.e2.b.E(str) || L == null) ? str : c.a.n0.a.e2.b.H(str, L);
        }
        return (String) invokeL.objValue;
    }

    public static void I0(@NonNull Context context, @Nullable m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, mVar) == null) {
            if (y) {
                if (x) {
                    Log.i("【CyberCallback】", "CyberPlayer播放内核开始安装 " + context.getApplicationContext());
                }
                try {
                    CyberPlayerManager.install(context.getApplicationContext(), c.a.n0.a.s0.a.h0().i(context), (String) null, 7, (Class<?>) null, (Map<String, String>) null, new f(mVar));
                    return;
                } catch (Exception e2) {
                    c.a.n0.a.u.d.o("SwanInlineCyberWidget", "CyberPlayer Install failed by catch e=" + e2 + " :> " + Log.getStackTraceString(e2));
                    if (mVar != null) {
                        mVar.a(false);
                        return;
                    }
                    return;
                }
            }
            if (x) {
                Log.v("【CyberCallback】", "CyberPlayer播放内核已安装，无需重复安装");
            }
            if (mVar != null) {
                mVar.a(true);
            }
        }
    }

    @Override // c.a.n0.a.o0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            I0(c.a.n0.a.s0.a.c(), new d(this, aVar));
        }
    }

    public final void A0(int i2) {
        a.InterfaceC0396a interfaceC0396a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            int b2 = c.a.n0.y.f.a.b.a.b(i2);
            if (x) {
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onStateChange(what " + i2 + ", statusCode " + b2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            if (b2 != 100) {
                if (b2 == 2101 && (interfaceC0396a = this.i) != null) {
                    interfaceC0396a.a(2102);
                }
                a.InterfaceC0396a interfaceC0396a2 = this.i;
                if (interfaceC0396a2 != null) {
                    interfaceC0396a2.a(b2);
                }
            }
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                ZeusPluginFactory.Invoker invoker = this.f9532d;
                if (invoker != null) {
                    x0().changeProxyDynamic((String) invoker.get("Proxy"), true);
                    return;
                }
                return;
            }
            x0().changeProxyDynamic(null, false);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
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
            if (this.k) {
                if (x) {
                    Log.i("SwanInlineCyberWidget", "requestAudioFocus: abandon request audio focus. Muted video.");
                    return;
                }
                return;
            }
            if (this.f9535g == null) {
                this.f9535g = (AudioManager) this.f9531c.getSystemService("audio");
            }
            AudioManager audioManager = this.f9535g;
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
            c.a.n0.a.s0.a.l().b(getContext(), str, new e(this, hashMap));
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void G(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && x) {
            Log.d("SwanInlineCyberWidget", "setMinCache (ignore) : " + i2);
        }
    }

    public final void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            q0.a0(new g(this, z));
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.j = z;
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void L(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public boolean O(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", "setDataSource: " + str + " ;userAgent: " + str3 + " ;cookies: " + str2);
            }
            this.l = true;
            this.f9530b = str;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.startsWith(ImageSource.FILE_SCHEME)) {
                str = str.substring(8);
            }
            String B0 = B0(str);
            ZeusPluginFactory.Invoker invoker = this.f9532d;
            if (invoker != null) {
                String str4 = (String) invoker.get("Proxy");
                if (!TextUtils.isEmpty(str4)) {
                    x0().setOption(CyberPlayerManager.OPT_HTTP_PROXY, str4);
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
                    Log.d("SwanInlineCyberWidget", "set referer for InlineVideo; referer is " + b2);
                }
                hashMap.put("Referer", b2);
            }
            if (c.a.n0.a.e2.b.s(B0) == PathType.CLOUD) {
                F0(B0, hashMap);
            } else {
                x0().setDataSource(this.f9531c, Uri.parse(B0), hashMap);
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public a.InterfaceC0396a Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : (a.InterfaceC0396a) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void T(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            x0().setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, map);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
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

    @Override // c.a.n0.a.o0.k.g.a
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f9536h : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            c.a.n0.a.o0.k.f.b.b().a(c(), str);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.f9534f + "-" + hashCode();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
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

    @Override // c.a.n0.a.o0.k.g.a
    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i2) == null) && x) {
            Log.d("SwanInlineCyberWidget", "setMaxCache (ignore) : " + i2);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f9531c : (Context) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? x0().getCurrentPosition() : invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? x0().getDuration() : invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? x0().getVideoHeight() : invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public int getVideoSarDen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public int getVideoSarNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? x0().getVideoWidth() : invokeV.intValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void h0(@NonNull a.InterfaceC0396a interfaceC0396a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, interfaceC0396a) == null) {
            this.i = interfaceC0396a;
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? x0().isPlaying() : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.o0.d
    @Nullable
    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f9534f : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            if (x) {
                Log.i("SwanInlineCyberWidget", "setMuted: " + z);
            }
            this.k = z;
            if (z) {
                o0();
            } else {
                E0();
            }
            x0().muteOrUnmuteAudio(z);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.f9535g == null) {
                this.f9535g = (AudioManager) this.f9531c.getSystemService("audio");
            }
            AudioManager audioManager = this.f9535g;
            if (audioManager == null) {
                return;
            }
            audioManager.abandonAudioFocus(this.w);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", this.f9534f + "-" + hashCode() + " pause()");
            }
            x0().pause();
            G0(false);
            H0(false);
            a.InterfaceC0396a interfaceC0396a = this.i;
            if (interfaceC0396a != null) {
                interfaceC0396a.c(c());
            }
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
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

    @Override // c.a.n0.a.o0.k.g.a
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", this.f9534f + " release()");
            }
            a.InterfaceC0396a interfaceC0396a = this.i;
            if (interfaceC0396a != null) {
                interfaceC0396a.onRelease(c());
            }
            o0();
            c.a.n0.a.k.e.n.l.e().r(c());
            x0().release();
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            x0().seekTo(i2);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048619, this, f2) == null) {
            x0().setSpeed(f2);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, surface) == null) {
            x0().setSurface(surface);
        }
    }

    @Override // c.a.n0.a.o0.k.g.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (x) {
                Log.d("SwanInlineCyberWidget", this.f9534f + "-" + hashCode() + " start()");
            }
            if (y0()) {
                if (x) {
                    Log.e("SwanInlineCyberWidget", this.f9534f + "-" + hashCode() + " start ignored, widget is in background");
                }
                H0(true);
                a.InterfaceC0396a interfaceC0396a = this.i;
                if (interfaceC0396a != null) {
                    interfaceC0396a.c(c());
                    return;
                }
                return;
            }
            E0();
            x0().start();
            G0(true);
            a.InterfaceC0396a interfaceC0396a2 = this.i;
            if (interfaceC0396a2 != null) {
                interfaceC0396a2.e(c());
            }
        }
    }

    public final boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final synchronized CyberPlayer x0() {
        InterceptResult invokeV;
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            synchronized (this) {
                if (this.f9533e == null) {
                    if (c.a.n0.a.s0.a.g0().C()) {
                        if (x) {
                            Log.d("SwanInlineCyberWidget", "getPlayer: same process");
                        }
                        this.f9533e = new CyberPlayer(0);
                    } else {
                        if (x) {
                            Log.d("SwanInlineCyberWidget", "getPlayer: self process");
                        }
                        this.f9533e = new CyberPlayer(0);
                    }
                    this.f9533e.setOnPreparedListener(this.p);
                    this.f9533e.setOnVideoSizeChangedListener(this.v);
                    this.f9533e.setOnCompletionListener(this.r);
                    this.f9533e.setOnErrorListener(this.q);
                    this.f9533e.setOnInfoListener(this.s);
                    this.f9533e.setOnBufferingUpdateListener(this.t);
                    this.f9533e.setOnSeekCompleteListener(this.u);
                    if (x) {
                        Log.d("SwanInlineCyberWidget", "create " + this.f9533e.hashCode() + " player");
                    }
                }
                cyberPlayer = this.f9533e;
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
                SwanAppActivity x2 = c.a.n0.a.t1.d.J().x();
                if (x2 == null) {
                    if (x) {
                        Log.v("SwanInlineCyberWidget", "check background by activity null, background ? true");
                    }
                    return true;
                }
                c.a.n0.a.j0.c frame = x2.getFrame();
                if (frame == null) {
                    if (x) {
                        Log.v("SwanInlineCyberWidget", "check background by frame null, background ? true");
                    }
                    return true;
                }
                if (x) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("check background by frame lifeState, background ? ");
                    sb.append(!frame.a0().hasStarted());
                    Log.v("SwanInlineCyberWidget", sb.toString());
                }
                return !frame.a0().hasStarted();
            }
            if (x) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("check background by kernel state, background ? ");
                sb2.append(this.a == 0);
                Log.v("SwanInlineCyberWidget", sb2.toString());
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
                Log.d("【CyberCallback】", "CyberPlayer" + hashCode() + " - send onNetStatus(" + a + SmallTailInfo.EMOTION_SUFFIX);
            }
            a.InterfaceC0396a interfaceC0396a = this.i;
            if (interfaceC0396a != null) {
                interfaceC0396a.d(a);
            }
        }
    }
}
