package c.a.r0.d1.y1.g;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.f0;
import c.a.q0.d1.r0;
import c.a.q0.d1.w;
import c.a.q0.s.q.d2;
import c.a.r0.d1.a1;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import c.a.r0.g0.b0;
import c.a.r0.x2.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends c.a.r0.g0.b<d2> implements b0, Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> A;
    public RelativeLayout B;
    public LinearLayout C;
    public TextView D;
    public TbImageView E;
    public ImageView F;
    public TbCyberVideoView G;
    public TextView H;
    public View I;
    public c.a.r0.x2.n J;
    public d2 K;
    public View L;
    public TextView M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public String R;
    public c.a.r0.x2.f S;
    public Animation T;
    public c.a.r0.d1.z2.i U;
    public TbImageView V;
    public String W;
    public String X;
    public String Y;
    public View Z;
    public boolean a0;
    public int b0;
    public Handler c0;
    public CyberPlayerManager.OnPreparedListener d0;
    public CyberPlayerManager.OnInfoListener e0;
    public CyberPlayerManager.OnCompletionListener f0;
    public CyberPlayerManager.OnErrorListener g0;
    public VideoLoadingProgressView.c h0;
    public String i0;
    public TbImageView.g k0;
    public ThreadCommentAndPraiseInfoLayout m;
    public ThreadSourceShareAndPraiseLayout n;
    public ThreadUserInfoLayout o;
    public ThreadGodReplyLayout p;
    public HeadPendantClickableView q;
    public ViewTreeObserver.OnGlobalLayoutListener q0;
    public View r;
    public Runnable r0;
    public TextView s;
    public Runnable s0;
    public FrameLayout t;
    public TbCyberVideoView.h t0;
    public LinearLayout u;
    public View.OnClickListener u0;
    public ThreadSkinView v;
    public final View.OnClickListener v0;
    public TextView w;
    public final View.OnClickListener w0;
    public LinearLayout x;
    public f.b x0;
    public View y;
    public Animation.AnimationListener y0;
    public TextView z;

    /* renamed from: c.a.r0.d1.y1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0984a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0984a(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.E != null) {
                this.a.E.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16355e;

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
            this.f16355e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = this.f16355e.t) == null || frameLayout.getLayoutParams() == null || this.f16355e.t.getVisibility() == 8) {
                return;
            }
            this.f16355e.t.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.f16355e.t.getLayoutParams();
            if (this.f16355e.t.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (this.f16355e.t.getWidth() * 0.5625d);
            this.f16355e.t.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d2 f16356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16357f;

        public c(a aVar, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, d2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16357f = aVar;
            this.f16356e = d2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16357f.A != null) {
                    this.f16357f.f17233f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f16357f.f17233f.getContext(), "", this.f16356e.D1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends c.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.m.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "2"));
            }
        }

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(c1.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16358e;

        public e(a aVar) {
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
            this.f16358e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16358e.G == null || this.f16358e.G.isPlaying()) {
                return;
            }
            this.f16358e.f0(true, 1);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16359e;

        public f(a aVar) {
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
            this.f16359e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16359e.b0();
                this.f16359e.f0(true, 4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16360e;

        public g(a aVar) {
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
            this.f16360e = aVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16360e.stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16361e;

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
            this.f16361e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16361e.K == null || StringUtils.isNull(this.f16361e.K.a0())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f16361e.A.getPageActivity()).createNormalCfg(this.f16361e.K.a0(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            if (this.f16361e.w0 != null) {
                this.f16361e.w0.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16362e;

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
            this.f16362e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16362e.g() == null) {
                return;
            }
            this.f16362e.g().a(view, this.f16362e.K);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16363e;

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
            this.f16363e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16363e.K == null || this.f16363e.g() == null) {
                return;
            }
            this.f16363e.g().a(view, this.f16363e.K);
        }
    }

    /* loaded from: classes5.dex */
    public class k extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
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
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 202) {
                    this.a.Q();
                } else if (i2 != 203) {
                } else {
                    this.a.O();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements f.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.r0.x2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public m(a aVar) {
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
            this.a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a.P == 3 && this.a.E != null) {
                this.a.E.setVisibility(8);
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

    /* loaded from: classes5.dex */
    public class n implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16364e;

        public n(a aVar) {
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
            this.f16364e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f16364e.G != null) {
                    this.f16364e.G.setVolume(0.0f, 0.0f);
                }
                this.f16364e.j0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16365e;

        public o(a aVar) {
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
            this.f16365e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (i2 == 3) {
                    this.f16365e.f0(false, 3);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16366e;

        public p(a aVar) {
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
            this.f16366e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16366e.G.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16367e;

        public q(a aVar) {
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
            this.f16367e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f16367e.b0();
                this.f16367e.f0(true, 4);
                this.f16367e.Q = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public r(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16368e;

        public s(a aVar) {
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
            this.f16368e = aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (frameLayout = this.f16368e.t) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f16368e.q0);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (frameLayout = this.f16368e.t) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.f16368e.q0);
        }
    }

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16369e;

        public t(a aVar) {
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
            this.f16369e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (threadCommentAndPraiseInfoLayout = this.f16369e.m) == null) {
                return;
            }
            threadCommentAndPraiseInfoLayout.changeSelectStatus();
        }
    }

    /* loaded from: classes5.dex */
    public class u implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public u(a aVar) {
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
            this.a = aVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.Z == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.a.Z, z ? c1.CAM_X0201 : c1.transparent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.N = 3;
        this.O = 0;
        this.P = 1;
        this.Q = false;
        this.c0 = new k(this, Looper.getMainLooper());
        this.d0 = new n(this);
        this.e0 = new o(this);
        this.f0 = new p(this);
        this.g0 = new q(this);
        this.h0 = new r(this);
        this.k0 = new C0984a(this);
        this.q0 = new b(this);
        this.r0 = new e(this);
        this.s0 = new f(this);
        this.t0 = new g(this);
        this.u0 = new h(this);
        this.v0 = new i(this);
        this.w0 = new j(this);
        this.x0 = new l(this);
        this.y0 = new m(this);
        n(bdUniqueId);
        this.l = 3;
        this.A = tbPageContext;
        View j2 = j();
        this.y = j2.findViewById(f1.divider_line);
        this.B = (RelativeLayout) j2.findViewById(f1.layout_root);
        this.V = (TbImageView) j2.findViewById(f1.frs_normal_item_star_view);
        this.C = (LinearLayout) j2.findViewById(f1.video_card_content_layout);
        this.B.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) this.B.findViewById(f1.card_home_page_video_user_pendant_header);
        this.q = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.q.getHeadView().setIsRound(true);
            this.q.getHeadView().setDrawBorder(false);
            this.q.getHeadView().setDefaultResource(17170445);
            this.q.getHeadView().setRadius(c.a.d.f.p.l.f(this.A.getPageActivity(), d1.ds70));
        }
        this.q.setHasPendantStyle();
        if (this.q.getPendantView() != null) {
            this.q.getPendantView().setIsRound(true);
            this.q.getPendantView().setDrawBorder(false);
        }
        TextView textView = (TextView) j2.findViewById(f1.thread_info_bar_name);
        this.s = textView;
        textView.setVisibility(8);
        this.s.setOnClickListener(this.u0);
        c.a.r0.x2.n nVar = new c.a.r0.x2.n((ViewGroup) j2.findViewById(f1.auto_video_loading_container));
        this.J = nVar;
        nVar.f(this.h0);
        this.D = (TextView) j2.findViewById(f1.text_title);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(f1.text_bottom);
        this.m = threadCommentAndPraiseInfoLayout;
        threadCommentAndPraiseInfoLayout.setForumAfterClickListener(this.w0);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) j2.findViewById(f1.card_home_page_auto_video_user_info_layout);
        this.o = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.r = j2.findViewById(f1.divider_below_reply_number_layout);
        if (this.m.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
        }
        this.m.setOnClickListener(this);
        this.m.setReplyTimeVisible(false);
        this.m.setShowPraiseNum(true);
        this.m.setNeedAddPraiseIcon(true);
        this.m.setNeedAddReplyIcon(true);
        this.m.setIsBarViewVisible(false);
        this.m.setShareVisible(true);
        this.m.setShareReportFrom(1);
        this.m.setStType(FrsFragment.STAR_FRS);
        this.m.setFrom(2);
        this.m.sourceFromForPb = 3;
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(f1.text_bottom_threaad);
        this.n = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.n.setFrom(2);
        this.n.setShareReportFrom(1);
        this.n.setSourceFromForPb(3);
        this.n.setStType(FrsFragment.STAR_FRS);
        this.n.setHideBarName(true);
        FrameLayout frameLayout = (FrameLayout) j2.findViewById(f1.frame_video);
        this.t = frameLayout;
        frameLayout.setOnClickListener(this);
        this.t.addOnAttachStateChangeListener(new s(this));
        TbImageView tbImageView = (TbImageView) j2.findViewById(f1.image_video);
        this.E = tbImageView;
        tbImageView.setPageId(h());
        this.E.setDrawCorner(true);
        this.E.setPlaceHolder(3);
        this.E.setEvent(this.k0);
        this.E.setGifIconSupport(false);
        this.F = (ImageView) j2.findViewById(f1.image_video_play);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.G = tbCyberVideoView;
        tbCyberVideoView.setStageType("2003");
        e0();
        this.G.setContinuePlayEnable(true);
        this.G.setOnPreparedListener(this.d0);
        this.G.setOnCompletionListener(this.f0);
        this.G.setOnErrorListener(this.g0);
        this.G.setOnInfoListener(this.e0);
        this.G.setOnSurfaceDestroyedListener(this.t0);
        c.a.r0.x2.f fVar = new c.a.r0.x2.f();
        this.S = fVar;
        fVar.l(this.G);
        this.S.i(this.x0);
        this.L = j2.findViewById(f1.auto_video_black_mask);
        this.H = (TextView) j2.findViewById(f1.auto_video_error_tips);
        this.I = j2.findViewById(f1.auto_video_error_background);
        this.u = (LinearLayout) j2.findViewById(f1.video_card_content_layout);
        this.v = (ThreadSkinView) j2.findViewById(f1.frs_thread_skin);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.A.getPageActivity(), a1.fade_out_video_cover);
        this.T = loadAnimation;
        loadAnimation.setAnimationListener(this.y0);
        this.w = (TextView) j2.findViewById(f1.text_video_duration);
        this.M = (TextView) j2.findViewById(f1.text_video_play_count);
        this.x = (LinearLayout) j2.findViewById(f1.duration_container);
        c.a.r0.d1.z2.i iVar = new c.a.r0.d1.z2.i(tbPageContext, this.B);
        this.U = iVar;
        iVar.d(h());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) j2.findViewById(f1.card_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        View findViewById = j2.findViewById(f1.thread_multi_del_mask_view);
        this.Z = findViewById;
        findViewById.setOnClickListener(new t(this));
        this.m.setOnSelectStatusChangeListener(new u(this));
        this.z = (TextView) j2.findViewById(f1.nani_video_icon);
    }

    public int F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? c.a.r0.t.d.c().b(this.X, i2) : invokeI.intValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public final void L(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, rect) == null) || this.K == null) {
            return;
        }
        String str = this.b0 == 501 ? "frs_tab" : "frs";
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K);
        arrayList.add(videoItemData);
        w.d(this.f17233f.getPageActivity(), arrayList, this.K.L() != null ? this.K.L().oriUgcNid : null, false, 0, rect, "from_nani_video", FrsFragment.STAR_FRS, null, str, "", false, this.K.n);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (j().getX() + K().getX() + this.u.getX());
            videoCardViewInfo.cardViewY = (int) (j().getY() + K().getY() + this.u.getY());
            videoCardViewInfo.cardViewWidth = K().getWidth();
            videoCardViewInfo.cardViewHeight = K().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.A.getPageActivity(), this.b0 == 501 ? "frs_tab" : "frs", this.K.v1(), c.a.r0.g0.m.g(), "", videoSerializeVideoThreadInfo);
            if (this.K.L() != null) {
                videoMiddlePageActivityConfig.setNid(this.K.L().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (j().getParent() == null) {
                stopPlay();
                return;
            }
            this.c0.removeMessages(203);
            int currentPosition = this.G.getCurrentPosition();
            if (currentPosition != this.O) {
                this.O = currentPosition;
                f0(false, 3);
            } else {
                f0(false, 2);
            }
            this.c0.sendEmptyMessageDelayed(203, 3000L);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c0.removeMessages(202);
            if (this.G.getCurrentPosition() > 0) {
                f0(false, 3);
                this.c0.sendEmptyMessageDelayed(203, 3000L);
                return;
            }
            this.c0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public final void S(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (this.K != null) {
                StatisticItem statisticItem = new StatisticItem("c11100");
                statisticItem.param("tid", this.K.g0());
                statisticItem.param("fid", this.K.U() + "");
                TiebaStatic.log(statisticItem);
            }
            if (g() != null) {
                g().a(view, this.K);
            }
            if (view == this.t) {
                if (!c.a.d.f.p.j.z()) {
                    c.a.d.f.p.l.L(this.A.getPageActivity(), i1.no_network_guide);
                } else {
                    M();
                }
            }
        }
    }

    public final void T(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (g() != null) {
                g().a(view, this.K);
            }
            if (!c.a.d.f.p.j.z()) {
                c.a.d.f.p.l.L(this.A.getPageActivity(), i1.no_network_guide);
            } else {
                L(ThreadCardUtils.computeViewArea(this.t));
            }
        }
    }

    public final void V(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            d2 d2Var = this.K;
            if (d2Var != null) {
                if (d2Var.Z1()) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).param("fid", String.valueOf(this.K.U())).param("obj_type", 2));
                } else {
                    StatisticItem statisticItem = new StatisticItem("c11100");
                    statisticItem.param("tid", this.K.g0());
                    statisticItem.param("fid", this.K.U() + "");
                    TiebaStatic.log(statisticItem);
                }
                if (this.K.J() != null && this.K.J().getGodUserData() != null && this.K.J().getGodUserData().getType() == 2) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", this.K.g0()));
                }
            }
            if (g() != null) {
                g().a(view, this.K);
            }
            d2 d2Var2 = this.K;
            if (d2Var2 != null) {
                c.a.r0.g0.m.a(d2Var2.g0());
                SkinManager.setViewTextColor(this.D, c1.CAM_X0109, 1);
                f0.b(this.K.g0());
                String str = null;
                String valueOf = String.valueOf(this.K.U());
                OriginalForumInfo originalForumInfo = this.K.K1;
                if (originalForumInfo != null) {
                    valueOf = originalForumInfo.id;
                    str = valueOf;
                }
                String str2 = "floor5";
                if (this.K.v0() > 0 && c.a.r0.t3.p0.e.c()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.A.getPageActivity()).createHistoryCfg(this.K.v1(), String.valueOf(this.K.v0()), false, true, FrsFragment.STAR_FRS);
                    if (this.b0 == 501) {
                        str2 = "frs_tab";
                    } else if (!this.K.Z1()) {
                        str2 = "frs";
                    }
                    createHistoryCfg.setVideo_source(str2);
                    createHistoryCfg.setFromSmartFrs(this.K.A2());
                    createHistoryCfg.setSmartFrsPosition(this.K.h1());
                    createHistoryCfg.setForumId(valueOf);
                    createHistoryCfg.setFromForumId(str);
                    createHistoryCfg.setStartFrom(this.l);
                    if (view == this.p) {
                        createHistoryCfg.setJumpGodReply(true);
                    }
                    this.A.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.A.getPageActivity()).createFromThreadCfg(this.K, this.i0, FrsFragment.STAR_FRS, 18003, true, false, false);
                if (this.b0 == 501) {
                    str2 = "frs_tab";
                } else if (!this.K.Z1()) {
                    str2 = "frs";
                }
                createFromThreadCfg.setVideo_source(str2);
                createFromThreadCfg.setFromSmartFrs(this.K.A2());
                createFromThreadCfg.setSmartFrsPosition(this.K.h1());
                createFromThreadCfg.setForumId(valueOf);
                createFromThreadCfg.setFromForumId(str);
                createFromThreadCfg.setStartFrom(this.l);
                if (view == this.p) {
                    createFromThreadCfg.setJumpGodReply(true);
                }
                this.A.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            }
        }
    }

    public final void W() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c0();
            b0();
            if (this.E == null || this.t == null || this.G == null) {
                return;
            }
            if (c.a.q0.s.k.c().g() && (d2Var = this.K) != null && d2Var.t1() != null) {
                this.t.setVisibility(0);
                this.E.setPlaceHolder(3);
                this.E.startLoad(this.K.t1().thumbnail_url, 10, false);
                stopPlay();
                String str = this.K.t1().video_url;
                this.R = str;
                if (StringUtils.isNull(str)) {
                    f0(true, 4);
                    TiebaStatic.log(new StatisticItem("c12026").param("tid", this.K.g0()));
                }
                this.G.setThreadDataForStatistic(this.K);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: Y */
    public void k(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d2Var) == null) {
            this.K = d2Var;
            Z();
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d2 d2Var = this.K;
            if (d2Var != null && d2Var.J() != null) {
                this.B.setVisibility(0);
                this.B.setOnClickListener(this);
                W();
                if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.Y)) {
                    this.K.A4(this.W, this.Y);
                }
                boolean z = true;
                this.K.d3(false, true);
                SpannableStringBuilder i1 = this.K.i1();
                if (this.K.i() && !StringUtils.isNull(this.K.v1())) {
                    String str = c.a.q0.s.e0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.v1();
                    i1.append((CharSequence) this.K.k(new d(this, 2, str, str)));
                }
                this.D.setOnTouchListener(new c.a.r0.k4.h(i1));
                this.D.setText(i1);
                this.U.a(this.K);
                i0(this.K);
                this.o.setData(this.K);
                if (this.o.getHeaderImg() != null) {
                    if (this.o.getIsSimpleThread()) {
                        this.o.getHeaderImg().setVisibility(8);
                        this.q.setVisibility(8);
                    } else if (this.K.J() != null && this.K.J().getPendantData() != null && !StringUtils.isNull(this.K.J().getPendantData().getImgUrl())) {
                        this.o.getHeaderImg().setVisibility(4);
                        this.q.setVisibility(0);
                        this.q.setData(this.K);
                    } else {
                        this.q.setVisibility(8);
                        this.o.getHeaderImg().setVisibility(0);
                        this.o.getHeaderImg().setData(this.K);
                    }
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.rightMargin = 0;
                this.m.setLayoutParams(layoutParams);
                this.o.setUserAfterClickListener(this.v0);
                h0(F(1));
                this.w.setText(StringHelper.stringForVideoTime(this.K.t1().video_duration.intValue() * 1000));
                this.M.setText(String.format(this.A.getResources().getString(i1.play_count), StringHelper.numFormatOverWan(this.K.t1().play_count.intValue())));
                this.p.setData(this.K.y1());
                this.p.onChangeSkinType();
                if (c.a.r0.g0.m.k(this.K.g0())) {
                    SkinManager.setViewTextColor(this.D, c1.CAM_X0109, 1);
                    c.a.r0.g0.m.l(this.p.getGodReplyContent(), this.K.g0(), c1.CAM_X0106, c1.CAM_X0109);
                } else {
                    SkinManager.setViewTextColor(this.D, c1.CAM_X0105, 1);
                }
                d2 d2Var2 = this.K;
                if ((d2Var2 == null || d2Var2.t1() == null || this.K.t1().is_vertical.intValue() != 1) ? false : false) {
                    this.z.setVisibility(0);
                } else {
                    this.z.setVisibility(8);
                }
                if ((c.a.r0.d1.b.f().i() || c.a.r0.d1.a.h().j()) && this.m.isInFrsAllThread()) {
                    this.Z.setVisibility(0);
                    if (!this.K.m2() && !this.K.n2() && !this.K.F2()) {
                        this.Z.setBackgroundResource(c1.transparent);
                    } else {
                        SkinManager.setBackgroundColor(this.Z, c1.CAM_X0201);
                    }
                } else {
                    this.Z.setVisibility(8);
                }
                l(this.A, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.B.setVisibility(8);
        }
    }

    @Override // c.a.r0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.i0 = str;
        }
    }

    public void a0(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) || bdUniqueId == null || this.m == null || (threadUserInfoLayout = this.o) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c0.removeMessages(202);
            this.c0.removeMessages(203);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.r0);
            c.a.d.f.m.e.a().removeCallbacks(this.s0);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.X = str;
        }
    }

    public final void d0() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (d2Var = this.K) == null || d2Var.t1() == null) {
            return;
        }
        String str = this.K.Z1() ? "floor5" : "frs";
        if (this.b0 == 501) {
            str = "frs_tab";
        }
        c.a.r0.x2.p pVar = new c.a.r0.x2.p();
        pVar.a = str;
        pVar.f25426c = this.K.v1();
        pVar.f25427d = this.K.U() + "";
        pVar.f25428e = TbadkCoreApplication.getCurrentAccount();
        d2 d2Var2 = this.K;
        pVar.f25429f = d2Var2.Z0;
        String str2 = d2Var2.b1;
        pVar.l = str2;
        pVar.f25430g = str2;
        pVar.f25431h = d2Var2.a1;
        pVar.f25432i = "";
        pVar.m = d2Var2.t1().video_md5;
        c.a.r0.x2.h.e(this.K.t1().video_md5, "", "1", pVar, this.G.getPcdnState());
    }

    public final void e0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (tbCyberVideoView = this.G) != null && tbCyberVideoView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.t.addView(this.G.getView(), 0);
            this.G.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? g1.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    public final void f0(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.F == null || this.E == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.P != i2) {
            this.P = i2;
            c.a.d.f.m.e.a().removeCallbacks(this.s0);
            c.a.d.f.m.e.a().removeCallbacks(this.r0);
            if (i2 == 2) {
                this.F.setVisibility(8);
                this.T.cancel();
                this.E.clearAnimation();
                this.E.setVisibility(0);
                this.L.setVisibility(0);
                this.x.setVisibility(0);
                this.J.g();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(this.s0, 60000L);
            } else if (i2 == 3) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.x.setVisibility(8);
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                d2 d2Var = this.K;
                if (d2Var == null || d2Var.t1() == null) {
                    return;
                }
                this.K.t1().video_length.intValue();
                this.K.t1().video_duration.intValue();
                this.K.v1();
            } else if (i2 == 4) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                c.a.d.f.m.e.a().postDelayed(this.r0, 2000L);
            } else {
                this.F.setVisibility(0);
                this.x.setVisibility(0);
                this.T.cancel();
                this.E.clearAnimation();
                this.E.setVisibility(0);
                this.L.setVisibility(0);
                this.J.b();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
        }
    }

    public void g0(c.a.r0.x2.p pVar) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, pVar) == null) || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.setVideoStatData(pVar);
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public void h0(int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (d2Var = this.K) == null) {
            return;
        }
        if (i2 == 1) {
            this.m.setVisibility(8);
            this.n.setData(this.K);
            this.r.setVisibility(8);
            return;
        }
        this.m.setData(d2Var);
        this.r.setVisibility(8);
        this.n.setVisibility(8);
    }

    public final void i0(d2 d2Var) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, d2Var) == null) || (tbImageView = this.V) == null) {
            return;
        }
        if (d2Var == null) {
            tbImageView.setVisibility(8);
        } else if (!StringUtils.isNull(d2Var.C1)) {
            c.a.r0.d1.z2.i iVar = this.U;
            if (iVar != null && iVar.b() && (this.V.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
                layoutParams.rightMargin = c.a.d.f.p.l.f(this.A.getContext(), d1.tbds106);
                this.V.setLayoutParams(layoutParams);
            }
            this.V.setVisibility(0);
            this.V.setImageDrawable(null);
            this.V.startLoad(d2Var.C1, 10, false);
            this.V.setOnClickListener(new c(this, d2Var));
        } else {
            this.V.setVisibility(8);
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView == null) {
                return false;
            }
            return tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void j0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (tbCyberVideoView = this.G) != null && this.Q) {
            try {
                tbCyberVideoView.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048606, this, tbPageContext, i2) == null) || this.N == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.B, e1.addresslist_item_bg);
        SkinManager.setImageResource(this.F, e1.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.H, c1.CAM_X0101);
        SkinManager.setViewTextColor(this.w, c1.CAM_X0101);
        SkinManager.setViewTextColor(this.M, c1.CAM_X0101);
        SkinManager.setBackgroundColor(this.I, c1.common_color_10014);
        SkinManager.setBackgroundColor(this.y, c1.CAM_X0204);
        if (this.H != null) {
            this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(e1.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.n;
        if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
            this.n.onChangeSkinType();
        }
        this.m.onChangeSkinType();
        this.N = i2;
        this.o.onChangeSkinType();
        HeadPendantClickableView headPendantClickableView = this.q;
        if (headPendantClickableView != null && headPendantClickableView.getHeadView() != null && (this.q.getHeadView() instanceof TbImageView)) {
            this.q.getHeadView().setPlaceHolder(1);
        }
        this.E.setPlaceHolder(3);
        this.U.c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view) == null) {
            if (view != this.B && view != this.m.getCommentNumView() && view != this.C) {
                if (view == this.t) {
                    d2 d2Var = this.K;
                    boolean z = false;
                    if (d2Var != null && d2Var.t1() != null && this.K.t1().is_vertical.intValue() == 1) {
                        z = true;
                    }
                    if (z) {
                        T(view);
                    } else if (UtilHelper.isGotoVideoMiddlePage()) {
                        S(this.t);
                    } else {
                        V(this.t);
                    }
                } else {
                    ThreadGodReplyLayout threadGodReplyLayout = this.p;
                    if (view == threadGodReplyLayout) {
                        V(threadGodReplyLayout);
                    }
                }
            } else {
                V(this.B);
            }
            d2 d2Var2 = this.K;
            if (d2Var2 != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, d2Var2));
            }
        }
    }

    @Override // c.a.r0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.l = i2;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.m;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.sourceFromForPb = i2;
                threadCommentAndPraiseInfoLayout.setFrom(2);
            }
            ThreadUserInfoLayout threadUserInfoLayout = this.o;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setFrom(3);
            }
        }
    }

    public void startPlay() {
        d2 d2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.Q || (d2Var = this.K) == null || d2Var.t1() == null || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        if (r0.e()) {
            if (this.a0 || c.a.q0.s.e0.b.j().k("auto_play_video_frs", 0) == 1) {
                f0(true, 2);
                if (StringUtils.isNull(this.R)) {
                    TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "frs").param("tid", this.K.g0()));
                    this.R = this.K.t1().video_url;
                }
                this.Q = true;
                this.G.setVideoPath(this.R, this.K.g0());
                c.a.r0.x2.f fVar = this.S;
                if (fVar != null) {
                    fVar.m();
                }
                d0();
            }
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            c0();
            b0();
            f0(true, 1);
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                c.a.r0.x2.f fVar = this.S;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.Q = false;
        }
    }
}
