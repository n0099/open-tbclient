package c.a.r0.z1.o.l;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.t0;
import c.a.q0.r.r.e2;
import c.a.q0.r.t.a;
import c.a.r0.a3.r;
import c.a.r0.a3.t;
import c.a.r0.j3.z;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static int q0;
    public static CallStateReceiver r0;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public boolean B;
    public boolean C;
    public boolean D;
    public Animation E;
    public Animation F;
    public n G;
    public int H;
    public GestureDetector I;
    public WindowManager J;
    public View K;
    public View L;
    public TextView M;
    public SeekBar N;
    public ImageView O;
    public ImageView P;
    public AudioManager Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public String V;
    public String W;
    public c.a.r0.a3.l X;
    public int Y;
    public int Z;
    public TbPageContext<?> a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public SwipeBackLayout.c f25426b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.z1.o.l.n f25427c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f25428d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public View f25429e;
    public WeakReference<Context> e0;

    /* renamed from: f  reason: collision with root package name */
    public TbVideoViewContainer f25430f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public View f25431g;
    public c.a.r0.a3.v.a g0;

    /* renamed from: h  reason: collision with root package name */
    public VideoListMediaControllerView f25432h;
    public Runnable h0;

    /* renamed from: i  reason: collision with root package name */
    public View f25433i;
    public Runnable i0;

    /* renamed from: j  reason: collision with root package name */
    public View f25434j;
    public TbVideoViewContainer.a j0;
    public FrameLayout k;
    public View.OnClickListener k0;
    public FrameLayout.LayoutParams l;
    public boolean l0;
    public ImageView m;
    public Animation.AnimationListener m0;
    public ImageView n;
    public Animation.AnimationListener n0;
    public ImageView o;
    public Runnable o0;
    public View p;
    public CustomMessageListener p0;
    public int q;
    public View r;
    public boolean s;
    public ImageView t;
    public String u;
    public TbImageView v;
    public CyberPlayerManager.OnPreparedListener w;
    public c.a.r0.z1.o.l.l x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.C = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25435e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25435e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25435e.l0();
            }
        }
    }

    /* renamed from: c.a.r0.z1.o.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1553c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1553c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.o0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25436e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25436e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                boolean onTouchEvent = this.f25436e.I.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    c cVar = this.f25436e;
                    if (cVar.s && cVar.B) {
                        if (this.f25436e.R == 1 && this.f25436e.U != 0) {
                            c cVar2 = this.f25436e;
                            cVar2.R(cVar2.U == 1 ? 1000.0f : -1000.0f, false);
                            this.f25436e.U = 0;
                            this.f25436e.T = 0;
                        }
                        if (!this.f25436e.f25430f.getControl().isPlaying() && 8 == this.f25436e.t.getVisibility()) {
                            this.f25436e.t.setVisibility(0);
                        }
                    }
                    this.f25436e.q0();
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.a.r0.a3.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25437e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25437e = cVar;
        }

        @Override // c.a.r0.a3.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.r0.a3.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f25437e.B = false;
                this.f25437e.H = 0;
                c cVar = this.f25437e;
                if (cVar.s) {
                    cVar.q0();
                    this.f25437e.t0();
                    this.f25437e.X();
                } else {
                    cVar.r0();
                }
                if (this.f25437e.x != null) {
                    this.f25437e.x.a(this.f25437e.u);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                this.f25437e.f25434j.setVisibility(0);
                this.f25437e.f25431g.setVisibility(8);
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048587, this) != null) {
                return;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.f25437e.h0);
            c.a.d.f.m.e.a().post(this.f25437e.h0);
            c.a.d.f.m.e.a().removeCallbacks(this.f25437e.i0);
            if (this.f25437e.f25430f == null || this.f25437e.f25430f.getControl() == null || this.f25437e.f25432h == null) {
                return;
            }
            if (!this.f25437e.d0) {
                c cVar = this.f25437e;
                if (!cVar.s) {
                    cVar.f25430f.getControl().setVolume(0.0f, 0.0f);
                    t0.f(this.f25437e.e0, false);
                    this.f25437e.f25432h.initCurTimeAndDuration(this.f25437e.H, this.f25437e.f25430f.getControl().getDuration());
                    if (this.f25437e.H != 0) {
                        this.f25437e.f25430f.getControl().seekTo(this.f25437e.H);
                    }
                    if (this.f25437e.w == null) {
                        this.f25437e.w.onPrepared();
                        return;
                    }
                    return;
                }
            }
            this.f25437e.f25430f.getControl().setVolume(1.0f, 1.0f);
            t0.f(this.f25437e.e0, true);
            this.f25437e.f25432h.initCurTimeAndDuration(this.f25437e.H, this.f25437e.f25430f.getControl().getDuration());
            if (this.f25437e.H != 0) {
            }
            if (this.f25437e.w == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setStatistic(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25438e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25438e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f25438e.f25430f.getControl().getCurrentPositionSync() > 100) {
                    this.f25438e.B = true;
                    this.f25438e.f25433i.setVisibility(8);
                    this.f25438e.f25434j.setVisibility(8);
                    this.f25438e.f25431g.setVisibility(8);
                    this.f25438e.v.setVisibility(8);
                    this.f25438e.U();
                    if (this.f25438e.p != null) {
                        this.f25438e.p.setVisibility(0);
                    }
                    this.f25438e.f25432h.showProgress();
                    return;
                }
                c.a.d.f.m.e.a().postDelayed(this.f25438e.h0, 20L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25439e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25439e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25439e.f25434j.setVisibility(0);
                this.f25439e.f25431g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25440e;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25440e = cVar;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25440e.B = false;
                c.a.d.f.m.e.a().removeCallbacks(this.f25440e.h0);
                c.a.d.f.m.e.a().removeCallbacks(this.f25440e.i0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25441e;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25441e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() != this.f25441e.f25434j.getId()) {
                    if (view.getId() != this.f25441e.t.getId() && view.getId() != this.f25441e.n.getId()) {
                        if (view.getId() != this.f25441e.o.getId()) {
                            if (view.getId() == this.f25441e.y.getId()) {
                                TiebaStatic.log(new StatisticItem("c11713"));
                                this.f25441e.Q0();
                                return;
                            } else if (view.getId() == this.f25441e.f25428d.getId()) {
                                if (this.f25441e.B || this.f25441e.s) {
                                    this.f25441e.X();
                                    return;
                                }
                                return;
                            } else if (view.getId() == this.f25441e.m.getId()) {
                                c cVar = this.f25441e;
                                if (cVar.s) {
                                    return;
                                }
                                if (cVar.d0) {
                                    this.f25441e.f25430f.getControl().setVolume(0.0f, 0.0f);
                                    this.f25441e.m.setImageResource(R.drawable.card_icon_sound_close);
                                    t0.f(this.f25441e.e0, false);
                                    this.f25441e.d0 = false;
                                    return;
                                }
                                this.f25441e.f25430f.getControl().setVolume(1.0f, 1.0f);
                                this.f25441e.m.setImageResource(R.drawable.card_icon_sound_open);
                                t0.f(this.f25441e.e0, true);
                                this.f25441e.d0 = true;
                                return;
                            } else {
                                return;
                            }
                        }
                        c cVar2 = this.f25441e;
                        if (cVar2.s) {
                            SwipeBackLayout.c cVar3 = cVar2.f25426b;
                            if (cVar3 != null) {
                                cVar3.enableSwipeBack();
                            }
                            TiebaStatic.log(new StatisticItem("c11714"));
                        } else {
                            SwipeBackLayout.c cVar4 = cVar2.f25426b;
                            if (cVar4 != null) {
                                cVar4.disableSwipeBack();
                            }
                            TiebaStatic.log(new StatisticItem("c11710"));
                            z.q().l().b(this.f25441e.V, this.f25441e.W);
                        }
                        this.f25441e.Q0();
                        return;
                    } else if (!c.a.d.f.p.l.z()) {
                        c.a.d.f.p.n.K(this.f25441e.a.getPageActivity(), this.f25441e.a.getString(R.string.neterror));
                        return;
                    } else if (!this.f25441e.f25430f.getControl().isPlaying()) {
                        if (this.f25441e.B) {
                            this.f25441e.s0();
                            return;
                        } else {
                            this.f25441e.p0();
                            return;
                        }
                    } else {
                        this.f25441e.o0();
                        return;
                    }
                }
                this.f25441e.p0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25442e;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25442e = cVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f25442e.l0 = true;
                c cVar = this.f25442e;
                cVar.O0(cVar.u);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public l(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.p == null) {
                return;
            }
            this.a.p.setVisibility(8);
            this.a.D = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25443e;

        public m(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25443e = cVar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                c cVar = this.f25443e;
                if (cVar.s && cVar.B) {
                    if (!this.f25443e.f25430f.getControl().isPlaying() && this.f25443e.t.getVisibility() == 0 && this.f25443e.R == 1) {
                        this.f25443e.t.setVisibility(8);
                    }
                    if (this.f25443e.R == 0) {
                        this.f25443e.F0();
                        if (Math.abs(f2) - Math.abs(f3) > 0.0f) {
                            this.f25443e.R = 1;
                            c cVar2 = this.f25443e;
                            cVar2.T = cVar2.f25430f.getControl().getCurrentPositionSync();
                            this.f25443e.R(f2, true);
                        } else {
                            this.f25443e.R = 2;
                            this.f25443e.S(f3);
                        }
                    } else if (this.f25443e.R == 1) {
                        this.f25443e.R(f2, true);
                    } else if (this.f25443e.R == 2) {
                        this.f25443e.S(f3);
                    }
                    return super.onScroll(motionEvent, motionEvent2, f2, f3);
                }
                return super.onScroll(motionEvent, motionEvent2, f2, f3);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ m(c cVar, d dVar) {
            this(cVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface n {
        void a();

        void b();
    }

    public c(TbPageContext<?> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.s = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.H = 0;
        this.R = 0;
        this.T = 0;
        this.U = 0;
        this.a0 = 0;
        this.d0 = false;
        this.e0 = null;
        this.f0 = true;
        this.g0 = new e(this);
        this.h0 = new f(this);
        this.i0 = new g(this);
        this.j0 = new h(this);
        this.k0 = new i(this);
        this.l0 = false;
        this.m0 = new l(this);
        this.n0 = new a(this);
        this.o0 = new b(this);
        this.p0 = new C1553c(this, 2016503);
        this.a = tbPageContext;
        this.e0 = new WeakReference<>(TbadkCoreApplication.getInst());
        View g0 = g0(tbPageContext);
        this.f25428d = g0;
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(g0);
        }
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.f25428d.findViewById(R.id.videoView);
        this.f25430f = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.f25431g = this.f25428d.findViewById(R.id.video_list_layout_loading);
        VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.f25428d.findViewById(R.id.media_controller);
        this.f25432h = videoListMediaControllerView;
        videoListMediaControllerView.setPlayer(this.f25430f.getControl());
        this.f25433i = this.f25428d.findViewById(R.id.black_mask);
        View findViewById = this.f25428d.findViewById(R.id.layout_error);
        this.f25434j = findViewById;
        findViewById.setOnClickListener(this.k0);
        this.k = (FrameLayout) this.f25428d.findViewById(R.id.danmu_container);
        ImageView imageView = (ImageView) this.f25428d.findViewById(R.id.img_play_icon);
        this.n = imageView;
        imageView.setOnClickListener(this.k0);
        ImageView imageView2 = (ImageView) this.f25428d.findViewById(R.id.img_sound_control);
        this.m = imageView2;
        imageView2.setOnClickListener(this.k0);
        ImageView imageView3 = (ImageView) this.f25428d.findViewById(R.id.card_img_full_screen);
        this.o = imageView3;
        imageView3.setOnClickListener(this.k0);
        this.p = this.f25428d.findViewById(R.id.card_layout_media_controller);
        this.f25429e = this.f25428d.findViewById(R.id.rl_control);
        this.f25430f.getControl().setOperableVideoContainer(this.g0);
        this.f25430f.getControl().setOnSurfaceDestroyedListener(this.j0);
        ImageView imageView4 = (ImageView) this.f25428d.findViewById(R.id.img_play);
        this.t = imageView4;
        imageView4.setOnClickListener(this.k0);
        TbImageView tbImageView = (TbImageView) this.f25428d.findViewById(R.id.video_thumbnail);
        this.v = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.Y = c.a.d.f.p.n.k(this.a.getPageActivity());
        this.Z = d0(this.a.getPageActivity());
        ImageView imageView5 = (ImageView) this.f25428d.findViewById(R.id.img_exit);
        this.y = imageView5;
        imageView5.setOnClickListener(this.k0);
        this.z = (TextView) this.f25428d.findViewById(R.id.video_title);
        View findViewById2 = this.f25428d.findViewById(R.id.layout_title);
        this.A = findViewById2;
        findViewById2.setVisibility(8);
        this.E = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.F = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.J = (WindowManager) this.a.getPageActivity().getSystemService("window");
        this.I = new GestureDetector(this.a.getPageActivity(), new m(this, null));
        AudioManager audioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.Q = audioManager;
        this.S = audioManager.getStreamMaxVolume(3);
        this.c0 = this.Q.getStreamVolume(3);
        q0 = 100 / this.S;
        this.f25428d.setOnTouchListener(new d(this));
        c.a.r0.a3.l lVar = new c.a.r0.a3.l(this.a.getPageActivity());
        this.X = lVar;
        lVar.j();
        this.a0 = c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.ds16);
        if (r0 == null) {
            r0 = new CallStateReceiver();
        }
        r0.register(this.a.getPageActivity());
        this.a.registerListener(this.p0);
    }

    public void A0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.r = view;
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n.setImageResource(R.drawable.icon_video_midpause);
            this.f25431g.setVisibility(8);
            this.t.setVisibility(0);
        }
    }

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f0 = z;
        }
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.H = i2;
        }
    }

    public void E0(SwipeBackLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25426b = cVar;
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.f25428d.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.f25428d.setSystemUiVisibility(4);
            } else {
                this.f25428d.setSystemUiVisibility(5894);
            }
        }
    }

    public void G0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.v.startLoad(str, 17, false);
        }
    }

    public void H0(c.a.r0.z1.o.l.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nVar) == null) {
            this.f25427c = nVar;
        }
    }

    public void I0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            StringHelper.numberUniformFormat(j2);
        }
    }

    public void J0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.u = str;
        }
    }

    public void K0(int i2) {
        c.a.r0.z1.o.l.n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (nVar = this.f25427c) == null || i2 == nVar.l()) {
            return;
        }
        this.f25427c.w();
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25428d.setVisibility(0);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25429e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.f25429e.setLayoutParams(layoutParams);
            this.o.setClickable(true);
            this.o.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = false;
                layoutParams2.addRule(11, 0);
                layoutParams2.addRule(0, R.id.card_img_full_screen);
                int dimension = (int) (this.a.getResources().getDimension(R.dimen.ds16) + 0.5f);
                this.m.setPadding((int) (this.a.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.ds16) + 0.5f), dimension);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.f25432h.setVisibility(0);
                this.n.setVisibility(0);
                return;
            }
            this.f25432h.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public void O0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            r rVar = new r();
            rVar.f14935e = "ad_feed";
            rVar.f14934d = rVar.a("ad_feed");
            rVar.f14936f = rVar.c("1");
            this.f25430f.getControl().setVideoModel(rVar);
            this.f25430f.getControl().setVideoPath(str);
            this.f25430f.getControl().start();
            this.f25431g.setVisibility(0);
            this.v.setVisibility(0);
            this.t.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_midplay);
            this.f25434j.setVisibility(8);
            c.a.d.f.m.e.a().removeCallbacks(this.i0);
            c.a.d.f.m.e.a().postDelayed(this.i0, 60000L);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.R;
            if (i2 == 1) {
                if (this.K == null) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                    this.K = inflate;
                    this.M = (TextView) inflate.findViewById(R.id.show_time);
                    this.P = (ImageView) this.K.findViewById(R.id.arrow_icon);
                }
                if (this.K.getParent() == null) {
                    this.J.addView(this.K, Z());
                }
            } else if (i2 == 2) {
                if (this.L == null) {
                    View inflate2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                    this.L = inflate2;
                    this.O = (ImageView) inflate2.findViewById(R.id.arrow_voice_icon);
                    this.N = (SeekBar) this.L.findViewById(R.id.show_voice_seekbar);
                }
                if (this.L.getParent() == null) {
                    this.J.addView(this.L, Z());
                }
            }
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.h0);
            c.a.d.f.m.e.a().removeCallbacks(this.i0);
            this.f25430f.getControl().stopPlayback();
            this.B = false;
            this.H = 0;
            r0();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.r == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25428d.getLayoutParams();
        this.l = layoutParams;
        layoutParams.width = this.r.getWidth();
        this.l.height = this.r.getHeight();
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams2 = this.l;
        layoutParams2.topMargin = iArr[1] - this.q;
        this.f25428d.setLayoutParams(layoutParams2);
    }

    public void Q0() {
        c.a.r0.a3.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (lVar = this.X) == null) {
            return;
        }
        lVar.l();
    }

    public final void R(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (f2 > 0.0f) {
                    this.T -= 1000;
                    this.U = 1;
                } else {
                    this.T += 1000;
                    this.U = 2;
                }
                int i2 = this.T;
                if (i2 < 0) {
                    this.T = 0;
                } else if (i2 > this.f25430f.getControl().getDuration()) {
                    this.T = this.f25430f.getControl().getDuration();
                }
            }
            P();
            String progressTime = this.f25432h.getProgressTime(this.T);
            if (f2 > 0.0f) {
                this.P.setImageResource(R.drawable.icon_kuaitui);
            } else {
                this.P.setImageResource(R.drawable.icon_kuaijin);
            }
            if (!StringUtils.isNull(progressTime)) {
                TextView textView = this.M;
                StringBuilder sb = new StringBuilder();
                sb.append(progressTime);
                sb.append("/");
                sb.append(this.f25432h.getProgressTime(this.f25430f.getControl().getDuration()));
                textView.setText(sb);
            }
            this.f25432h.setCurrentDuration(this.T, !z);
        }
    }

    public void R0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            this.V = str;
            this.W = str2;
        }
    }

    public final void S(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            if (!this.f25430f.getControl().isPlaying()) {
                this.R = 0;
                return;
            }
            P();
            int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i6 > 0 && (i5 = this.b0) < 100) {
                this.b0 = i5 + 1;
            }
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 < 0 && (i4 = this.b0) > 0) {
                this.b0 = i4 - 1;
            }
            if (this.b0 % q0 == 0) {
                if (i6 > 0 && (i3 = this.c0) < this.S) {
                    this.c0 = i3 + 1;
                }
                if (i7 < 0 && (i2 = this.c0) > 0) {
                    this.c0 = i2 - 1;
                }
            }
            if (this.c0 > 0) {
                this.O.setImageResource(R.drawable.icon_shengyin_open);
            } else {
                this.O.setImageResource(R.drawable.icon_shengyin_close);
            }
            this.Q.setStreamVolume(3, this.c0, 0);
            this.N.setProgress(this.b0);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            U();
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.p == null) {
            return;
        }
        c.a.d.f.m.e.a().removeCallbacks(this.o0);
        this.F.setAnimationListener(null);
        this.E.setAnimationListener(null);
        this.p.clearAnimation();
        this.D = false;
        this.C = false;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            P0();
            c.a.d.f.m.e.a().removeCallbacks(this.o0);
            c.a.d.f.m.e.a().removeCallbacks(this.h0);
            c.a.d.f.m.e.a().removeCallbacks(this.i0);
            this.X.k();
            r0.unregister(this.a.getPageActivity());
        }
    }

    public void W() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (view = this.p) == null || this.C) {
            return;
        }
        if (this.D || view.getVisibility() != 0) {
            U();
            this.p.setVisibility(0);
            this.F.setAnimationListener(this.n0);
            this.p.startAnimation(this.F);
            this.C = true;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            W();
            c.a.d.f.m.e.a().removeCallbacks(this.o0);
            if (this.f0) {
                c.a.d.f.m.e.a().postDelayed(this.o0, 3000L);
            }
        }
    }

    public final void Y(BaseFragmentActivity baseFragmentActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, baseFragmentActivity, z) == null) || baseFragmentActivity == null || baseFragmentActivity.getWindow() == null) {
            return;
        }
        if (z) {
            WindowManager.LayoutParams attributes = baseFragmentActivity.getWindow().getAttributes();
            attributes.flags |= 1024;
            baseFragmentActivity.getWindow().setAttributes(attributes);
            baseFragmentActivity.getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = baseFragmentActivity.getWindow().getAttributes();
        attributes2.flags &= -1025;
        baseFragmentActivity.getWindow().setAttributes(attributes2);
        baseFragmentActivity.getWindow().clearFlags(512);
        this.f25431g.getVisibility();
    }

    public final WindowManager.LayoutParams Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public View b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    public int d0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return i2 == 0 ? c.a.d.f.p.n.i(context) : i2;
        }
        return invokeL.intValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? !this.s : invokeV.booleanValue;
    }

    public c.a.r0.a3.g f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f25430f.getControl() : (c.a.r0.a3.g) invokeV.objValue;
    }

    public View g0(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, tbPageContext)) == null) ? LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_float_video_container, (ViewGroup) null) : (View) invokeL.objValue;
    }

    public VideoListMediaControllerView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f25432h : (VideoListMediaControllerView) invokeV.objValue;
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && this.f25430f.getControl().getDuration() - i2 <= 3000 && this.s) {
            U();
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f25428d.setVisibility(8);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25429e.getLayoutParams();
            if (c.a.r0.z1.o.k.e.c(this.a.getPageActivity())) {
                layoutParams.bottomMargin = (int) (this.a.getResources().getDimension(R.dimen.ds40) + 0.5f);
            } else {
                layoutParams.bottomMargin = (int) (this.a.getResources().getDimension(R.dimen.ds30) + 0.5f);
            }
            this.f25429e.setLayoutParams(layoutParams);
            this.o.setClickable(false);
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = true;
                int dimension = (int) (this.a.getResources().getDimension(R.dimen.ds16) + 0.5f);
                this.m.setPadding((int) (this.a.getResources().getDimension(R.dimen.ds22) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.ds16) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.ds38) + 0.5f), dimension);
                layoutParams2.addRule(11);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void l0() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (view = this.p) == null || this.D || view.getVisibility() != 0) {
            return;
        }
        U();
        this.p.setVisibility(0);
        this.E.setAnimationListener(this.m0);
        this.p.startAnimation(this.E);
        this.D = true;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f25428d.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void n0(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, baseFragmentActivity, configuration) == null) {
            if (configuration.orientation == 2) {
                this.s = true;
                this.m.setVisibility(8);
                this.f25430f.getControl().setVolume(1.0f, 1.0f);
                t0.f(this.e0, true);
                this.f25428d.setLayoutParams(new FrameLayout.LayoutParams(this.Z, this.Y));
                Y(baseFragmentActivity, true);
                this.A.setVisibility(0);
                v0(true);
                this.k.setVisibility(8);
                n nVar = this.G;
                if (nVar != null) {
                    nVar.a();
                }
                X();
                this.o.setImageResource(R.drawable.icon_suoxiao);
                w0(this.a0);
                F0();
                return;
            }
            this.s = false;
            this.m.setVisibility(0);
            if (this.d0) {
                this.f25430f.getControl().setVolume(1.0f, 1.0f);
                t0.f(this.e0, true);
            } else {
                this.f25430f.getControl().setVolume(0.0f, 0.0f);
                t0.f(this.e0, false);
            }
            FrameLayout.LayoutParams layoutParams = this.l;
            if (layoutParams != null) {
                this.f25428d.setLayoutParams(layoutParams);
            }
            Y(baseFragmentActivity, false);
            this.A.setVisibility(8);
            v0(false);
            this.k.setVisibility(0);
            n nVar2 = this.G;
            if (nVar2 != null) {
                nVar2.b();
            }
            if (!this.B && (view = this.p) != null) {
                view.clearAnimation();
                this.p.setVisibility(4);
            }
            q0();
            this.o.setImageResource(R.drawable.icon_fangda);
            w0(0);
            this.f25428d.setSystemUiVisibility(0);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.f25430f.getControl().pause();
            B0();
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (c.a.d.f.p.l.x() && !this.l0) {
                c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.a.getPageActivity());
                aVar.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                aVar.setPositiveButton(R.string.confirm, new j(this));
                aVar.setNegativeButton(R.string.cancel, new k(this));
                aVar.create(this.a).show();
                return;
            }
            O0(this.u);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.R == 0) {
            return;
        }
        this.R = 0;
        View view = this.K;
        if (view != null && view.getParent() != null) {
            try {
                this.J.removeView(this.K);
            } catch (IllegalArgumentException unused) {
            }
        }
        View view2 = this.L;
        if (view2 == null || view2.getParent() == null) {
            return;
        }
        try {
            this.J.removeView(this.L);
        } catch (IllegalArgumentException unused2) {
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.p == null) {
            return;
        }
        this.f25433i.setVisibility(0);
        this.t.setVisibility(0);
        this.f25431g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(4);
        this.f25434j.setVisibility(8);
        this.f25432h.resetProgress();
        this.v.setVisibility(0);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f25430f.getControl().start();
            this.n.setImageResource(R.drawable.icon_video_midplay);
            this.v.setVisibility(8);
            this.f25433i.setVisibility(8);
            this.f25431g.setVisibility(8);
            this.f25432h.showProgress();
            this.t.setVisibility(8);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || this.p == null) {
            return;
        }
        this.f25433i.setVisibility(0);
        this.t.setVisibility(0);
        this.f25431g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(0);
        this.f25434j.setVisibility(8);
        this.f25432h.resetProgress();
        this.v.setVisibility(0);
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.q = i2;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            if (z) {
                this.f25428d.setOnClickListener(this.k0);
            } else {
                this.f25428d.setClickable(false);
            }
        }
    }

    public final void w0(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048627, this, i2) == null) && (videoListMediaControllerView = this.f25432h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25432h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f25432h.setLayoutParams(layoutParams);
        }
    }

    public void x0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, nVar) == null) {
            this.G = nVar;
        }
    }

    public void y0(c.a.r0.z1.o.l.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, lVar) == null) {
            this.x = lVar;
        }
    }

    public void z0(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onPreparedListener) == null) {
            this.w = onPreparedListener;
        }
    }
}
