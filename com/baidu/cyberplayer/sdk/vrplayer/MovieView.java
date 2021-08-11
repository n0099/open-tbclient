package com.baidu.cyberplayer.sdk.vrplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.MediaStreamTrack;
@Keep
/* loaded from: classes5.dex */
public class MovieView extends FrameLayout implements ICyberVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g A;
    public CyberPlayerManager.OnVideoSizeChangedListener B;
    public CyberPlayerManager.OnErrorListener C;
    public c D;
    public View.OnTouchListener E;
    public d F;
    public h G;
    public h H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public i T;
    public String U;
    public boolean V;
    public int W;

    /* renamed from: a  reason: collision with root package name */
    public int f39039a;
    public int aa;
    public int ab;
    public boolean ac;
    public float ad;
    public HashMap<String, String> ae;

    /* renamed from: b  reason: collision with root package name */
    public Context f39040b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f39041c;

    /* renamed from: d  reason: collision with root package name */
    public View f39042d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39043e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39044f;

    /* renamed from: g  reason: collision with root package name */
    public String f39045g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayer f39046h;

    /* renamed from: i  reason: collision with root package name */
    public int f39047i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f39048j;
    public String k;
    public String l;
    public Uri m;
    public Uri n;
    public Map<String, String> o;
    public boolean p;
    public String q;
    public CyberPlayerManager.OnCompletionListener r;
    public CyberPlayerManager.OnPreparedListener s;
    public CyberPlayerManager.OnBufferingUpdateListener t;
    public f u;
    public CyberPlayerManager.OnSeekCompleteListener v;
    public CyberPlayerManager.OnInfoListener w;
    public b x;
    public a y;
    public e z;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface c {
    }

    /* loaded from: classes5.dex */
    public interface d {
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final h f39056a;

        /* renamed from: b  reason: collision with root package name */
        public static final h f39057b;

        /* renamed from: c  reason: collision with root package name */
        public static final h f39058c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f39059d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f39060e;

        /* renamed from: f  reason: collision with root package name */
        public static final h f39061f;

        /* renamed from: g  reason: collision with root package name */
        public static final h f39062g;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ h[] f39063h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-328914308, "Lcom/baidu/cyberplayer/sdk/vrplayer/MovieView$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-328914308, "Lcom/baidu/cyberplayer/sdk/vrplayer/MovieView$h;");
                    return;
                }
            }
            f39056a = new h("ERROR", 0);
            f39057b = new h("IDLE", 1);
            f39058c = new h("PREPARING", 2);
            f39059d = new h("PREPARED", 3);
            f39060e = new h("PLAYING", 4);
            f39061f = new h("PAUSED", 5);
            h hVar = new h("PLAYBACK_COMPLETED", 6);
            f39062g = hVar;
            f39063h = new h[]{f39056a, f39057b, f39058c, f39059d, f39060e, f39061f, hVar};
        }

        public h(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static h valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (h) Enum.valueOf(h.class, str) : (h) invokeL.objValue;
        }

        public static h[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) f39063h.clone() : (h[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final i f39064a;

        /* renamed from: b  reason: collision with root package name */
        public static final i f39065b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ i[] f39066c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-328914277, "Lcom/baidu/cyberplayer/sdk/vrplayer/MovieView$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-328914277, "Lcom/baidu/cyberplayer/sdk/vrplayer/MovieView$i;");
                    return;
                }
            }
            f39064a = new i("PAUSED", 0);
            i iVar = new i("RESUMED", 1);
            f39065b = iVar;
            f39066c = new i[]{f39064a, iVar};
        }

        public i(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static i valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (i) Enum.valueOf(i.class, str) : (i) invokeL.objValue;
        }

        public static i[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (i[]) f39066c.clone() : (i[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39043e = true;
        this.f39044f = false;
        this.f39047i = 0;
        this.f39048j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f39039a = 0;
        this.U = "0.0.0.0";
        this.V = true;
        this.W = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = false;
        this.ad = 1.0f;
        this.ae = new HashMap<>();
        h hVar = h.f39057b;
        this.G = hVar;
        this.H = hVar;
        this.K = false;
        this.T = i.f39064a;
        if (isInEditMode()) {
            return;
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39043e = true;
        this.f39044f = false;
        this.f39047i = 0;
        this.f39048j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f39039a = 0;
        this.U = "0.0.0.0";
        this.V = true;
        this.W = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = false;
        this.ad = 1.0f;
        this.ae = new HashMap<>();
        h hVar = h.f39057b;
        this.G = hVar;
        this.H = hVar;
        this.K = false;
        this.T = i.f39064a;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f39043e = true;
        this.f39044f = false;
        this.f39047i = 0;
        this.f39048j = true;
        this.m = null;
        this.n = null;
        this.p = false;
        this.f39039a = 0;
        this.U = "0.0.0.0";
        this.V = true;
        this.W = 0;
        this.aa = 0;
        this.ab = 0;
        this.ac = false;
        this.ad = 1.0f;
        this.ae = new HashMap<>();
        h hVar = h.f39057b;
        this.G = hVar;
        this.H = hVar;
        this.K = false;
        this.T = i.f39064a;
        a(context);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            setCurPlayerState(h.f39056a);
            this.H = h.f39056a;
            CyberPlayerManager.OnErrorListener onErrorListener = this.C;
            if (onErrorListener != null) {
                onErrorListener.onError(i2, i3, null);
            }
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) || i2 == 0 || i3 == 0 || this.f39042d == null) {
            return;
        }
        a(1, "on23DVideoSizeChanged w:" + i2 + " h:" + i3);
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            if (context != null) {
                this.f39040b = context.getApplicationContext();
            } else {
                CyberLog.e("VrMovieView", "Context not be null");
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            a(z, true);
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer != null) {
                cyberPlayer.setDisplay(null);
                this.f39046h.release();
                this.f39046h = null;
            }
            setCurPlayerState(h.f39057b);
            if (z2) {
                this.H = h.f39057b;
            }
            ((AudioManager) this.f39040b.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(null);
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            f();
            a(i2);
            Object[] objArr = new Object[1];
            View view = this.f39042d;
            objArr[0] = Integer.valueOf(view == null ? 0 : view.hashCode());
            a(1, String.format("rendView hashCode = %d", objArr));
            setFocusable(true);
            setFocusableInTouchMode(true);
        }
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            if (!isInPlaybackState()) {
                this.I = i2;
                this.J = i3;
                return;
            }
            this.f39046h.seekTo(i2, i3);
            this.I = 0;
            this.J = 3;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39044f : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.I = 0;
            this.J = 3;
            this.L = false;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            a(this.n != null, false);
            ((AudioManager) this.f39040b.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).requestAudioFocus(null, 3, 1);
            this.f39046h = d(i2);
            HashMap<String, String> hashMap = this.ae;
            if (hashMap != null) {
                for (String str : hashMap.keySet()) {
                    this.f39046h.setOption(str, this.ae.get(str));
                }
            }
            Surface surface = this.f39041c;
            if (surface != null) {
                this.f39046h.setSurface(surface);
            }
            this.f39046h.setOnPreparedListener(new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39049a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39049a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
                public void onPrepared() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39049a.a(1, "onPrepared");
                        this.f39049a.setCurPlayerState(h.f39059d);
                        MovieView movieView = this.f39049a;
                        movieView.f39046h.setLooping(movieView.K);
                        CyberPlayerManager.OnPreparedListener onPreparedListener = this.f39049a.s;
                        if (onPreparedListener != null) {
                            onPreparedListener.onPrepared();
                        }
                        MovieView movieView2 = this.f39049a;
                        int i3 = movieView2.I;
                        if (i3 != 0) {
                            movieView2.seekTo(i3, movieView2.J);
                        }
                        MovieView movieView3 = this.f39049a;
                        if (movieView3.H == h.f39060e) {
                            movieView3.start();
                        } else if (movieView3.L) {
                            movieView3.pauseBuffering();
                        }
                    }
                }
            });
            this.f39046h.setOnVideoSizeChangedListener(new CyberPlayerManager.OnVideoSizeChangedListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39050a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39050a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
                public void onVideoSizeChanged(int i3, int i4, int i5, int i6) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIII(1048576, this, i3, i4, i5, i6) == null) {
                        this.f39050a.a(1, String.format("onVideoSizeChanged,w=%d,h=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                        if (i3 == 0 || i4 == 0) {
                            return;
                        }
                        this.f39050a.a(i3, i4, i5, i6);
                        this.f39050a.requestLayout();
                        this.f39050a.aa = i3;
                        this.f39050a.ab = i4;
                        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f39050a.B;
                        if (onVideoSizeChangedListener != null) {
                            onVideoSizeChangedListener.onVideoSizeChanged(i3, i4, i5, i6);
                        }
                    }
                }
            });
            this.f39046h.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39051a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39051a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
                public void onCompletion() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39051a.a(1, "onCompletion");
                        this.f39051a.setCurPlayerState(h.f39062g);
                        MovieView movieView = this.f39051a;
                        movieView.H = h.f39062g;
                        CyberPlayerManager.OnCompletionListener onCompletionListener = movieView.r;
                        if (onCompletionListener != null) {
                            onCompletionListener.onCompletion();
                        }
                    }
                }
            });
            this.f39046h.setOnErrorListener(new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39052a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39052a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
                public boolean onError(int i3, int i4, Object obj) {
                    InterceptResult invokeIIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i3, i4, obj)) == null) {
                        this.f39052a.a(1, String.format("onError:err=%d,detail=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                        if (i3 == -10000 && (i4 == 11 || i4 == 101 || i4 == -110 || i4 == -5)) {
                            i4 = 300;
                        }
                        this.f39052a.a(i3, i4);
                        return true;
                    }
                    return invokeIIL.booleanValue;
                }
            });
            this.f39046h.setOnInfoListener(new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39053a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39053a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i3, int i4, Object obj) {
                    InterceptResult invokeIIL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i3, i4, obj)) == null) {
                        this.f39053a.a(1, String.format("onInfo:what=%d,extra=%d", Integer.valueOf(i3), Integer.valueOf(i4)));
                        CyberPlayerManager.OnInfoListener onInfoListener = this.f39053a.w;
                        if (onInfoListener != null) {
                            onInfoListener.onInfo(i3, i4, null);
                        }
                        if (i3 == 701) {
                            this.f39053a.a(2, "onBufferingStart");
                            b bVar = this.f39053a.x;
                            if (bVar != null) {
                                bVar.a();
                            }
                        } else if (i3 == 702) {
                            this.f39053a.a(2, "onBufferingEnd");
                            a aVar = this.f39053a.y;
                            if (aVar != null) {
                                aVar.a();
                            }
                        } else if (i3 == 3) {
                            this.f39053a.a(1, "onRenderStart");
                            e eVar = this.f39053a.z;
                            if (eVar != null) {
                                eVar.a();
                            }
                        }
                        return true;
                    }
                    return invokeIIL.booleanValue;
                }
            });
            this.f39046h.setOnBufferingUpdateListener(new CyberPlayerManager.OnBufferingUpdateListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39054a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39054a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
                public void onBufferingUpdate(int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                        this.f39054a.a(2, String.format("onBufferingUpdate:percent=%d", Integer.valueOf(i3)));
                        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.f39054a.t;
                        if (onBufferingUpdateListener != null) {
                            onBufferingUpdateListener.onBufferingUpdate(i3);
                        }
                    }
                }
            });
            this.f39046h.setOnSeekCompleteListener(new CyberPlayerManager.OnSeekCompleteListener(this) { // from class: com.baidu.cyberplayer.sdk.vrplayer.MovieView.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ MovieView f39055a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39055a = this;
                }

                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
                public void onSeekComplete() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39055a.a(1, "onSeekComplete");
                        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f39055a.v;
                        if (onSeekCompleteListener != null) {
                            onSeekCompleteListener.onSeekComplete();
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && this.f39046h != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.ae;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f39046h.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f39046h.changeProxyDynamic(str, true);
            }
            this.f39046h.seekTo(getCurrentPosition() - 500);
            HashMap<String, String> hashMap2 = this.ae;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    public CyberPlayer d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            int i3 = this.W;
            if (i3 == 3 || i3 < 0 || i3 > 4) {
                this.W = 0;
            }
            a(1, "createplayer : " + i2);
            return new CyberPlayer(this.W, null);
        }
        return (CyberPlayer) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (this.f39044f || this.f39041c == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            destroy();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a(1, "destroy");
            HashMap<String, String> hashMap = this.ae;
            if (hashMap != null) {
                hashMap.clear();
            }
            a(false);
            f();
            destroyRender();
            this.f39041c = null;
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
        }
    }

    public void destroyRender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.m != null && d()) {
            a(1, String.format("uri:%s ", this.m));
            c(this.f39047i);
            c();
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    this.f39046h.setDataSource(this.f39040b, this.m, this.o);
                } else {
                    this.f39046h.setDataSource(this.m.toString());
                }
                if (this.f39044f) {
                    a(1, "video is 2d");
                } else {
                    this.f39046h.setSurface(this.f39041c);
                }
                this.f39046h.prepareAsync();
                if (this.ac) {
                    muteOrUnmuteAudio(this.ac);
                }
                setCurPlayerState(h.f39058c);
            } catch (Exception unused) {
                a(1, 0);
            }
            requestLayout();
            invalidate();
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (isInPlaybackState()) {
                this.f39046h.seekTo(i2);
                i2 = 0;
            }
            this.I = i2;
        }
    }

    public void enableCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f39045g = str;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer != null) {
                cyberPlayer.setDisplay(null);
            }
            View view = this.f39042d;
            if (view != null) {
                removeView(view);
                this.f39042d = null;
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (isInPlaybackState() && (this.f39046h.isPlaying() || this.G == h.f39059d)) {
                a(1, "pausePlayer");
                this.f39046h.pause();
                setCurPlayerState(h.f39061f);
            }
            this.H = h.f39061f;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (isInPlaybackState()) {
                return this.f39046h.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.W : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (isInPlaybackState()) {
                return this.f39046h.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer == null || (hVar = this.G) == h.f39057b || hVar == h.f39058c) {
                return -1L;
            }
            return cyberPlayer.getPlayedTime();
        }
        return invokeV.longValue;
    }

    public int getPlayerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f39047i : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.ab : invokeV.intValue;
    }

    public Uri getVideoUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.m : (Uri) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.aa : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getViewType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.P : invokeV.intValue;
    }

    public boolean init2D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            this.f39044f = true;
            if (this.f39047i == 0) {
                this.f39047i = 1;
            }
            if (this.P == 0) {
                this.P = 1;
            }
            a(1, String.format("playerType:" + this.f39047i + " interactiveMode:" + this.M + " displayMode:" + this.N + " sourceType:" + this.Q + " viewType:" + this.P, new Object[0]));
            b(this.P);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isAllReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? (this.f39042d == null || this.f39046h == null || !b()) ? false : true : invokeV.booleanValue;
    }

    public boolean isEnableDetachedSurfaceTextureView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f39043e : invokeV.booleanValue;
    }

    public boolean isEnableMediaCodec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f39048j : invokeV.booleanValue;
    }

    public boolean isInPlaybackState() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (this.f39046h == null || (hVar = this.G) == h.f39056a || hVar == h.f39057b || hVar == h.f39058c) ? false : true : invokeV.booleanValue;
    }

    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public boolean isPlayerIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f39046h != null && this.G == h.f39057b : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? isInPlaybackState() && this.f39046h.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.ac = z;
            a(1, "muteOrUnmuteAudio flag:" + z);
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer != null) {
                cyberPlayer.muteOrUnmuteAudio(z);
            } else {
                a(1, "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            a(1, "pause");
            g();
        }
    }

    public void pauseBuffering() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            a(1, "pauseBuffering");
            if (isInPlaybackState()) {
                a(1, "current state is in playback state ");
            } else {
                this.L = true;
            }
        }
    }

    public void pauseRender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void reStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.p = true;
            setVideoName(this.k);
            setVideoURI(this.m);
            start();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.ac = false;
            this.ad = 1.0f;
            resetPlayer();
        }
    }

    public void resetPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer != null) {
                cyberPlayer.reset();
                this.f39046h.setSurface(this.f39041c);
            }
            setCurPlayerState(h.f39057b);
            this.H = h.f39057b;
            this.aa = 0;
            this.ab = 0;
        }
    }

    public void resumeRender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || i2 < 0 || getDuration() == 0) {
            return;
        }
        a(1, "seekTo");
        f fVar = this.u;
        if (fVar != null) {
            fVar.a();
        }
        e(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048626, this, i2, i3) == null) || i2 < 0 || getDuration() == 0) {
            return;
        }
        a(1, "seekTo");
        f fVar = this.u;
        if (fVar != null) {
            fVar.a();
        }
        b(i2, i3);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
        }
    }

    public void setCurPlayerState(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, hVar) == null) {
            this.G = hVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.W = i2;
        }
    }

    public void setEnableDetachedSurfaceTextureView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.f39043e = z;
        }
    }

    public void setEnableMediaCodec(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.f39048j = z;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048632, this, str, obj) == null) || TextUtils.isEmpty(str) || (cyberPlayer = this.f39046h) == null) {
            return;
        }
        cyberPlayer.setExternalInfo(str, obj);
    }

    public void setHttpProxy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer != null && this.G != h.f39056a) {
                cyberPlayer.setLooping(z);
            }
            this.K = z;
        }
    }

    public void setOnBufferingEndListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, aVar) == null) {
            this.y = aVar;
        }
    }

    public void setOnBufferingStartListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bVar) == null) {
            this.x = bVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onBufferingUpdateListener) == null) {
            this.t = onBufferingUpdateListener;
        }
    }

    public void setOnClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, cVar) == null) {
            this.D = cVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onCompletionListener) == null) {
            this.r = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onErrorListener) == null) {
            this.C = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onInfoListener) == null) {
            this.w = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onMediaSourceChangedListener) == null) {
        }
    }

    public void setOnPitchYawRollListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, dVar) == null) {
            this.F = dVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, onPreparedListener) == null) {
            this.s = onPreparedListener;
        }
    }

    public void setOnRenderStartListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, eVar) == null) {
            this.z = eVar;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, onSeekCompleteListener) == null) {
            this.v = onSeekCompleteListener;
        }
    }

    public void setOnSeekStartListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public void setOnSurfaceReadyListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, gVar) == null) {
            this.A = gVar;
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, onTouchListener) == null) {
            super.setOnTouchListener(onTouchListener);
            this.E = onTouchListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, onVideoSizeChangedListener) == null) {
            this.B = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, str, str2) == null) {
            if (this.G != h.f39057b) {
                a(1, "Do not set option when the video player playing");
                return;
            }
            HashMap<String, String> hashMap = this.ae;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.f39046h != null) {
                if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                    this.f39046h.setOption(str, str2);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, str) == null) || (cyberPlayer = this.f39046h) == null) {
            return;
        }
        cyberPlayer.setPlayJson(str);
    }

    public void setPlayerType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            this.f39047i = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.V = z;
        }
    }

    public void setScaleType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            this.f39039a = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048656, this, f2) == null) {
            a(1, "setSpeed()");
            this.ad = f2;
            CyberPlayer cyberPlayer = this.f39046h;
            if (cyberPlayer != null) {
                cyberPlayer.setSpeed(f2);
            } else {
                a(1, "setSpeed must call after setVideoPath or setVideoURI");
            }
        }
    }

    public void setVideoName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            a(1, "videoName:" + str);
            this.l = this.k;
            this.k = str;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            setVideoURI(Uri.parse(str));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, uri) == null) {
            setVideoURI(uri, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048662, this, uri, map) == null) {
            a(1, "videoURI:" + uri.toString());
            this.n = this.m;
            this.m = uri;
            this.o = map;
            e();
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i2) == null) {
            this.P = i2;
        }
    }

    public void setVolume(float f2) {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048664, this, f2) == null) || (cyberPlayer = this.f39046h) == null) {
            return;
        }
        cyberPlayer.setVolume(f2, f2);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            a(1, "start");
            startPlayer();
            resumeRender();
        }
    }

    public void startPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            if (isInPlaybackState()) {
                this.f39046h.start();
                setCurPlayerState(h.f39060e);
            }
            this.H = h.f39060e;
            a(1, "startPlayer");
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            a(1, IntentConfig.STOP);
            a(false);
            pauseRender();
            HashMap<String, String> hashMap = this.ae;
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            stop();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i2) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, onSnapShotCompleteListener)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048671, this, new Object[]{onSnapShotCompleteListener, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
