package b.a.r0.x0.x1.g;

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
import b.a.q0.d1.f0;
import b.a.q0.d1.s0;
import b.a.q0.d1.w;
import b.a.q0.s.q.d2;
import b.a.r0.b0.a0;
import b.a.r0.q2.f;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import b.a.r0.x0.z0;
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
public class a extends b.a.r0.b0.b<d2> implements a0, Object {
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
    public b.a.r0.q2.n J;
    public d2 K;
    public View L;
    public TextView M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public String R;
    public b.a.r0.q2.f S;
    public Animation T;
    public b.a.r0.x0.y2.i U;
    public TbImageView V;
    public String W;
    public String X;
    public String Y;
    public View Z;
    public boolean a0;
    public int b0;
    public Handler c0;
    public CyberPlayerManager.OnPreparedListener i0;
    public CyberPlayerManager.OnInfoListener j0;
    public CyberPlayerManager.OnCompletionListener k0;
    public CyberPlayerManager.OnErrorListener l0;
    public ThreadCommentAndPraiseInfoLayout m;
    public VideoLoadingProgressView.c m0;
    public ThreadSourceShareAndPraiseLayout n;
    public String n0;
    public ThreadUserInfoLayout o;
    public TbImageView.g o0;
    public ThreadGodReplyLayout p;
    public ViewTreeObserver.OnGlobalLayoutListener p0;
    public HeadPendantClickableView q;
    public Runnable q0;
    public View r;
    public Runnable r0;
    public TextView s;
    public TbCyberVideoView.h s0;
    public FrameLayout t;
    public View.OnClickListener t0;
    public LinearLayout u;
    public final View.OnClickListener u0;
    public ThreadSkinView v;
    public final View.OnClickListener v0;
    public TextView w;
    public f.b w0;
    public LinearLayout x;
    public Animation.AnimationListener x0;
    public View y;
    public TextView z;

    /* renamed from: b.a.r0.x0.x1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1310a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26707a;

        public C1310a(a aVar) {
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
            this.f26707a = aVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f26707a.E != null) {
                this.f26707a.E.setDefaultBgResource(0);
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
        public final /* synthetic */ a f26708e;

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
            this.f26708e = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = this.f26708e.t) == null || frameLayout.getLayoutParams() == null || this.f26708e.t.getVisibility() == 8) {
                return;
            }
            this.f26708e.t.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ViewGroup.LayoutParams layoutParams = this.f26708e.t.getLayoutParams();
            if (this.f26708e.t.getWidth() <= 0) {
                return;
            }
            layoutParams.height = (int) (this.f26708e.t.getWidth() * 0.5625d);
            this.f26708e.t.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d2 f26709e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f26710f;

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
            this.f26710f = aVar;
            this.f26709e = d2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f26710f.A != null) {
                    this.f26710f.f14737f.sendMessage(new CustomMessage(2002001, new ShareWebActivityConfig(this.f26710f.f14737f.getContext(), "", this.f26709e.B1, true)));
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_STAR_PIC_CLICK));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends b.a.q0.f1.n.f {
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

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.q0.m.a.u(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "2"));
            }
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(b1.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26711e;

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
            this.f26711e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26711e.G == null || this.f26711e.G.isPlaying()) {
                return;
            }
            this.f26711e.e0(true, 1);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26712e;

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
            this.f26712e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26712e.a0();
                this.f26712e.e0(true, 4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26713e;

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
            this.f26713e = aVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26713e.stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26714e;

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
            this.f26714e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26714e.K == null || StringUtils.isNull(this.f26714e.K.Z())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f26714e.A.getPageActivity()).createNormalCfg(this.f26714e.K.Z(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            if (this.f26714e.v0 != null) {
                this.f26714e.v0.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26715e;

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
            this.f26715e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26715e.f() == null) {
                return;
            }
            this.f26715e.f().a(view, this.f26715e.K);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26716e;

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
            this.f26716e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f26716e.K == null || this.f26716e.f() == null) {
                return;
            }
            this.f26716e.f().a(view, this.f26716e.K);
        }
    }

    /* loaded from: classes5.dex */
    public class k extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26717a;

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
            this.f26717a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 202) {
                    this.f26717a.R();
                } else if (i2 != 203) {
                } else {
                    this.f26717a.Q();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26718a;

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
            this.f26718a = aVar;
        }

        @Override // b.a.r0.q2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26718a.c0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26719a;

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
            this.f26719a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.f26719a.P == 3 && this.f26719a.E != null) {
                this.f26719a.E.setVisibility(8);
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
        public final /* synthetic */ a f26720e;

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
            this.f26720e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f26720e.G != null) {
                    this.f26720e.G.setVolume(0.0f, 0.0f);
                }
                this.f26720e.i0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26721e;

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
            this.f26721e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (i2 == 3) {
                    this.f26721e.e0(false, 3);
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
        public final /* synthetic */ a f26722e;

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
            this.f26722e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26722e.G.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26723e;

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
            this.f26723e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f26723e.a0();
                this.f26723e.e0(true, 4);
                this.f26723e.Q = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class r implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26724a;

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
            this.f26724a = aVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26724a.i0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26725e;

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
            this.f26725e = aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (frameLayout = this.f26725e.t) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.f26725e.p0);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (frameLayout = this.f26725e.t) == null) {
                return;
            }
            frameLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.f26725e.p0);
        }
    }

    /* loaded from: classes5.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26726e;

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
            this.f26726e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (threadCommentAndPraiseInfoLayout = this.f26726e.m) == null) {
                return;
            }
            threadCommentAndPraiseInfoLayout.changeSelectStatus();
        }
    }

    /* loaded from: classes5.dex */
    public class u implements ThreadCommentAndPraiseInfoLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26727a;

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
            this.f26727a = aVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f26727a.Z == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.f26727a.Z, z ? b1.CAM_X0201 : b1.transparent);
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
        this.i0 = new n(this);
        this.j0 = new o(this);
        this.k0 = new p(this);
        this.l0 = new q(this);
        this.m0 = new r(this);
        this.o0 = new C1310a(this);
        this.p0 = new b(this);
        this.q0 = new e(this);
        this.r0 = new f(this);
        this.s0 = new g(this);
        this.t0 = new h(this);
        this.u0 = new i(this);
        this.v0 = new j(this);
        this.w0 = new l(this);
        this.x0 = new m(this);
        m(bdUniqueId);
        this.l = 3;
        this.A = tbPageContext;
        View i4 = i();
        this.y = i4.findViewById(e1.divider_line);
        this.B = (RelativeLayout) i4.findViewById(e1.layout_root);
        this.V = (TbImageView) i4.findViewById(e1.frs_normal_item_star_view);
        this.C = (LinearLayout) i4.findViewById(e1.video_card_content_layout);
        this.B.setOnClickListener(this);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) this.B.findViewById(e1.card_home_page_video_user_pendant_header);
        this.q = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.q.getHeadView().setIsRound(true);
            this.q.getHeadView().setDrawBorder(false);
            this.q.getHeadView().setDefaultResource(17170445);
            this.q.getHeadView().setRadius(b.a.e.e.p.l.g(this.A.getPageActivity(), c1.ds70));
        }
        this.q.setHasPendantStyle();
        if (this.q.getPendantView() != null) {
            this.q.getPendantView().setIsRound(true);
            this.q.getPendantView().setDrawBorder(false);
        }
        TextView textView = (TextView) i4.findViewById(e1.thread_info_bar_name);
        this.s = textView;
        textView.setVisibility(8);
        this.s.setOnClickListener(this.t0);
        b.a.r0.q2.n nVar = new b.a.r0.q2.n((ViewGroup) i4.findViewById(e1.auto_video_loading_container));
        this.J = nVar;
        nVar.f(this.m0);
        this.D = (TextView) i4.findViewById(e1.text_title);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) i4.findViewById(e1.text_bottom);
        this.m = threadCommentAndPraiseInfoLayout;
        threadCommentAndPraiseInfoLayout.setForumAfterClickListener(this.v0);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) i4.findViewById(e1.card_home_page_auto_video_user_info_layout);
        this.o = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.r = i4.findViewById(e1.divider_below_reply_number_layout);
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
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i4.findViewById(e1.text_bottom_threaad);
        this.n = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.n.setFrom(2);
        this.n.setShareReportFrom(1);
        this.n.setSourceFromForPb(3);
        this.n.setStType(FrsFragment.STAR_FRS);
        this.n.setHideBarName(true);
        FrameLayout frameLayout = (FrameLayout) i4.findViewById(e1.frame_video);
        this.t = frameLayout;
        frameLayout.setOnClickListener(this);
        this.t.addOnAttachStateChangeListener(new s(this));
        TbImageView tbImageView = (TbImageView) i4.findViewById(e1.image_video);
        this.E = tbImageView;
        tbImageView.setPageId(g());
        this.E.setDrawCorner(true);
        this.E.setPlaceHolder(3);
        this.E.setEvent(this.o0);
        this.E.setGifIconSupport(false);
        this.F = (ImageView) i4.findViewById(e1.image_video_play);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.G = tbCyberVideoView;
        tbCyberVideoView.setStageType("2003");
        d0();
        this.G.setContinuePlayEnable(true);
        this.G.setOnPreparedListener(this.i0);
        this.G.setOnCompletionListener(this.k0);
        this.G.setOnErrorListener(this.l0);
        this.G.setOnInfoListener(this.j0);
        this.G.setOnSurfaceDestroyedListener(this.s0);
        b.a.r0.q2.f fVar = new b.a.r0.q2.f();
        this.S = fVar;
        fVar.l(this.G);
        this.S.i(this.w0);
        this.L = i4.findViewById(e1.auto_video_black_mask);
        this.H = (TextView) i4.findViewById(e1.auto_video_error_tips);
        this.I = i4.findViewById(e1.auto_video_error_background);
        this.u = (LinearLayout) i4.findViewById(e1.video_card_content_layout);
        this.v = (ThreadSkinView) i4.findViewById(e1.frs_thread_skin);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.A.getPageActivity(), z0.fade_out_video_cover);
        this.T = loadAnimation;
        loadAnimation.setAnimationListener(this.x0);
        this.w = (TextView) i4.findViewById(e1.text_video_duration);
        this.M = (TextView) i4.findViewById(e1.text_video_play_count);
        this.x = (LinearLayout) i4.findViewById(e1.duration_container);
        b.a.r0.x0.y2.i iVar = new b.a.r0.x0.y2.i(tbPageContext, this.B);
        this.U = iVar;
        iVar.d(g());
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) i4.findViewById(e1.card_god_reply_layout);
        this.p = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        View findViewById = i4.findViewById(e1.thread_multi_del_mask_view);
        this.Z = findViewById;
        findViewById.setOnClickListener(new t(this));
        this.m.setOnSelectStatusChangeListener(new u(this));
        this.z = (TextView) i4.findViewById(e1.nani_video_icon);
    }

    public int J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? b.a.r0.p.d.c().b(this.X, i2) : invokeI.intValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public final void O(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, rect) == null) || this.K == null) {
            return;
        }
        String str = this.b0 == 501 ? "frs_tab" : "frs";
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K);
        arrayList.add(videoItemData);
        w.d(this.f14737f.getPageActivity(), arrayList, this.K.L() != null ? this.K.L().oriUgcNid : null, false, 0, rect, "from_nani_video", FrsFragment.STAR_FRS, null, str, "", false, this.K.n);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K);
            VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
            videoCardViewInfo.cardViewX = (int) (i().getX() + M().getX() + this.u.getX());
            videoCardViewInfo.cardViewY = (int) (i().getY() + M().getY() + this.u.getY());
            videoCardViewInfo.cardViewWidth = M().getWidth();
            videoCardViewInfo.cardViewHeight = M().getHeight();
            videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.A.getPageActivity(), this.b0 == 501 ? "frs_tab" : "frs", this.K.s1(), b.a.r0.b0.m.g(), "", videoSerializeVideoThreadInfo);
            if (this.K.L() != null) {
                videoMiddlePageActivityConfig.setNid(this.K.L().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (i().getParent() == null) {
                stopPlay();
                return;
            }
            this.c0.removeMessages(203);
            int currentPosition = this.G.getCurrentPosition();
            if (currentPosition != this.O) {
                this.O = currentPosition;
                e0(false, 3);
            } else {
                e0(false, 2);
            }
            this.c0.sendEmptyMessageDelayed(203, 3000L);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c0.removeMessages(202);
            if (this.G.getCurrentPosition() > 0) {
                e0(false, 3);
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
                statisticItem.param("tid", this.K.f0());
                statisticItem.param("fid", this.K.T() + "");
                TiebaStatic.log(statisticItem);
            }
            if (f() != null) {
                f().a(view, this.K);
            }
            if (view == this.t) {
                if (!b.a.e.e.p.j.z()) {
                    b.a.e.e.p.l.L(this.A.getPageActivity(), h1.no_network_guide);
                } else {
                    P();
                }
            }
        }
    }

    public final void T(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (f() != null) {
                f().a(view, this.K);
            }
            if (!b.a.e.e.p.j.z()) {
                b.a.e.e.p.l.L(this.A.getPageActivity(), h1.no_network_guide);
            } else {
                O(ThreadCardUtils.computeViewArea(this.t));
            }
        }
    }

    public final void U(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            d2 d2Var = this.K;
            if (d2Var != null) {
                if (d2Var.W1()) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM).param("fid", String.valueOf(this.K.T())).param("obj_type", 2));
                } else {
                    StatisticItem statisticItem = new StatisticItem("c11100");
                    statisticItem.param("tid", this.K.f0());
                    statisticItem.param("fid", this.K.T() + "");
                    TiebaStatic.log(statisticItem);
                }
                if (this.K.J() != null && this.K.J().getGodUserData() != null && this.K.J().getGodUserData().getType() == 2) {
                    TiebaStatic.log(new StatisticItem("c10806").param("obj_locate", 3).param("tid", this.K.f0()));
                }
            }
            if (f() != null) {
                f().a(view, this.K);
            }
            d2 d2Var2 = this.K;
            if (d2Var2 != null) {
                b.a.r0.b0.m.a(d2Var2.f0());
                SkinManager.setViewTextColor(this.D, b1.CAM_X0109, 1);
                f0.b(this.K.f0());
                String str = null;
                String valueOf = String.valueOf(this.K.T());
                OriginalForumInfo originalForumInfo = this.K.J1;
                if (originalForumInfo != null) {
                    valueOf = originalForumInfo.id;
                    str = valueOf;
                }
                String str2 = "floor5";
                if (this.K.u0() > 0 && b.a.r0.l3.p0.e.c()) {
                    PbActivityConfig createHistoryCfg = new PbActivityConfig(this.A.getPageActivity()).createHistoryCfg(this.K.s1(), String.valueOf(this.K.u0()), false, true, FrsFragment.STAR_FRS);
                    if (this.b0 == 501) {
                        str2 = "frs_tab";
                    } else if (!this.K.W1()) {
                        str2 = "frs";
                    }
                    createHistoryCfg.setVideo_source(str2);
                    createHistoryCfg.setFromSmartFrs(this.K.x2());
                    createHistoryCfg.setSmartFrsPosition(this.K.f1());
                    createHistoryCfg.setForumId(valueOf);
                    createHistoryCfg.setFromForumId(str);
                    createHistoryCfg.setStartFrom(this.l);
                    if (view == this.p) {
                        createHistoryCfg.setJumpGodReply(true);
                    }
                    this.A.sendMessage(new CustomMessage(2004001, createHistoryCfg));
                    return;
                }
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.A.getPageActivity()).createFromThreadCfg(this.K, this.n0, FrsFragment.STAR_FRS, 18003, true, false, false);
                if (this.b0 == 501) {
                    str2 = "frs_tab";
                } else if (!this.K.W1()) {
                    str2 = "frs";
                }
                createFromThreadCfg.setVideo_source(str2);
                createFromThreadCfg.setFromSmartFrs(this.K.x2());
                createFromThreadCfg.setSmartFrsPosition(this.K.f1());
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

    public final void V() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b0();
            a0();
            if (this.E == null || this.t == null || this.G == null) {
                return;
            }
            if (b.a.q0.s.k.c().g() && (d2Var = this.K) != null && d2Var.q1() != null) {
                this.t.setVisibility(0);
                this.E.setPlaceHolder(3);
                this.E.startLoad(this.K.q1().thumbnail_url, 10, false);
                stopPlay();
                String str = this.K.q1().video_url;
                this.R = str;
                if (StringUtils.isNull(str)) {
                    e0(true, 4);
                    TiebaStatic.log(new StatisticItem("c12026").param("tid", this.K.f0()));
                }
                this.G.setThreadDataForStatistic(this.K);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: X */
    public void j(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d2Var) == null) {
            this.K = d2Var;
            Y();
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d2 d2Var = this.K;
            if (d2Var != null && d2Var.J() != null) {
                this.B.setVisibility(0);
                this.B.setOnClickListener(this);
                V();
                if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.Y)) {
                    this.K.w4(this.W, this.Y);
                }
                boolean z = true;
                this.K.Z2(false, true);
                SpannableStringBuilder g1 = this.K.g1();
                if (this.K.i() && !StringUtils.isNull(this.K.s1())) {
                    String str = b.a.q0.s.e0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.s1();
                    g1.append((CharSequence) this.K.k(new d(this, 2, str, str)));
                }
                this.D.setOnTouchListener(new b.a.r0.c4.h(g1));
                this.D.setText(g1);
                this.U.a(this.K);
                h0(this.K);
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
                this.o.setUserAfterClickListener(this.u0);
                g0(J(1));
                this.w.setText(StringHelper.stringForVideoTime(this.K.q1().video_duration.intValue() * 1000));
                this.M.setText(String.format(this.A.getResources().getString(h1.play_count), StringHelper.numFormatOverWan(this.K.q1().play_count.intValue())));
                this.p.setData(this.K.v1());
                this.p.onChangeSkinType();
                if (b.a.r0.b0.m.k(this.K.f0())) {
                    SkinManager.setViewTextColor(this.D, b1.CAM_X0109, 1);
                    b.a.r0.b0.m.l(this.p.getGodReplyContent(), this.K.f0(), b1.CAM_X0106, b1.CAM_X0109);
                } else {
                    SkinManager.setViewTextColor(this.D, b1.CAM_X0105, 1);
                }
                d2 d2Var2 = this.K;
                if ((d2Var2 == null || d2Var2.q1() == null || this.K.q1().is_vertical.intValue() != 1) ? false : false) {
                    this.z.setVisibility(0);
                } else {
                    this.z.setVisibility(8);
                }
                if ((b.a.r0.x0.b.f().i() || b.a.r0.x0.a.h().j()) && this.m.isInFrsAllThread()) {
                    this.Z.setVisibility(0);
                    if (!this.K.j2() && !this.K.k2() && !this.K.C2()) {
                        this.Z.setBackgroundResource(b1.transparent);
                    } else {
                        SkinManager.setBackgroundColor(this.Z, b1.CAM_X0201);
                    }
                } else {
                    this.Z.setVisibility(8);
                }
                k(this.A, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.B.setVisibility(8);
        }
    }

    public void Z(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || bdUniqueId == null || this.m == null || (threadUserInfoLayout = this.o) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    @Override // b.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.n0 = str;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c0.removeMessages(202);
            this.c0.removeMessages(203);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.q0);
            b.a.e.e.m.e.a().removeCallbacks(this.r0);
        }
    }

    public final void c0() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (d2Var = this.K) == null || d2Var.q1() == null) {
            return;
        }
        String str = this.K.W1() ? "floor5" : "frs";
        if (this.b0 == 501) {
            str = "frs_tab";
        }
        b.a.r0.q2.p pVar = new b.a.r0.q2.p();
        pVar.f22882a = str;
        pVar.f22884c = this.K.s1();
        pVar.f22885d = this.K.T() + "";
        pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
        d2 d2Var2 = this.K;
        pVar.f22887f = d2Var2.X0;
        String str2 = d2Var2.Z0;
        pVar.l = str2;
        pVar.f22888g = str2;
        pVar.f22889h = d2Var2.Y0;
        pVar.f22890i = "";
        pVar.m = d2Var2.q1().video_md5;
        b.a.r0.q2.h.e(this.K.q1().video_md5, "", "1", pVar, this.G.getPcdnState());
    }

    public final void d0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (tbCyberVideoView = this.G) != null && tbCyberVideoView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.t.addView(this.G.getView(), 0);
            this.G.getView().setLayoutParams(layoutParams);
        }
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? f1.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    public final void e0(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.F == null || this.E == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.P != i2) {
            this.P = i2;
            b.a.e.e.m.e.a().removeCallbacks(this.r0);
            b.a.e.e.m.e.a().removeCallbacks(this.q0);
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
                b.a.e.e.m.e.a().postDelayed(this.r0, 60000L);
            } else if (i2 == 3) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.x.setVisibility(8);
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                d2 d2Var = this.K;
                if (d2Var == null || d2Var.q1() == null) {
                    return;
                }
                this.K.q1().video_length.intValue();
                this.K.q1().video_duration.intValue();
                this.K.s1();
            } else if (i2 == 4) {
                this.F.setVisibility(8);
                this.E.startAnimation(this.T);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                b.a.e.e.m.e.a().postDelayed(this.q0, 2000L);
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

    public void f0(b.a.r0.q2.p pVar) {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, pVar) == null) || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.setVideoStatData(pVar);
    }

    public void g0(int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (d2Var = this.K) == null) {
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

    public final void h0(d2 d2Var) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, d2Var) == null) || (tbImageView = this.V) == null) {
            return;
        }
        if (d2Var == null) {
            tbImageView.setVisibility(8);
        } else if (!StringUtils.isNull(d2Var.A1)) {
            b.a.r0.x0.y2.i iVar = this.U;
            if (iVar != null && iVar.b() && (this.V.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
                layoutParams.rightMargin = b.a.e.e.p.l.g(this.A.getContext(), c1.tbds106);
                this.V.setLayoutParams(layoutParams);
            }
            this.V.setVisibility(0);
            this.V.setImageDrawable(null);
            this.V.startLoad(d2Var.A1, 10, false);
            this.V.setOnClickListener(new c(this, d2Var));
        } else {
            this.V.setVisibility(8);
        }
    }

    public final void i0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (tbCyberVideoView = this.G) != null && this.Q) {
            try {
                tbCyberVideoView.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.c0.sendEmptyMessageDelayed(202, 20L);
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

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, tbPageContext, i2) == null) || this.N == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.B, d1.addresslist_item_bg);
        SkinManager.setImageResource(this.F, d1.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.H, b1.CAM_X0101);
        SkinManager.setViewTextColor(this.w, b1.CAM_X0101);
        SkinManager.setViewTextColor(this.M, b1.CAM_X0101);
        SkinManager.setBackgroundColor(this.I, b1.common_color_10014);
        SkinManager.setBackgroundColor(this.y, b1.CAM_X0204);
        if (this.H != null) {
            this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(d1.icon_toast_game_error), (Drawable) null, (Drawable) null);
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
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            if (view != this.B && view != this.m.getCommentNumView() && view != this.C) {
                if (view == this.t) {
                    d2 d2Var = this.K;
                    boolean z = false;
                    if (d2Var != null && d2Var.q1() != null && this.K.q1().is_vertical.intValue() == 1) {
                        z = true;
                    }
                    if (z) {
                        T(view);
                    } else if (UtilHelper.isGotoVideoMiddlePage()) {
                        S(this.t);
                    } else {
                        U(this.t);
                    }
                } else {
                    ThreadGodReplyLayout threadGodReplyLayout = this.p;
                    if (view == threadGodReplyLayout) {
                        U(threadGodReplyLayout);
                    }
                }
            } else {
                U(this.B);
            }
            d2 d2Var2 = this.K;
            if (d2Var2 != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, d2Var2));
            }
        }
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
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

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.X = str;
        }
    }

    public void startPlay() {
        d2 d2Var;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.Q || (d2Var = this.K) == null || d2Var.q1() == null || (tbCyberVideoView = this.G) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        if (s0.e()) {
            if (this.a0 || b.a.q0.s.e0.b.j().k("auto_play_video_frs", 0) == 1) {
                e0(true, 2);
                if (StringUtils.isNull(this.R)) {
                    TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "frs").param("tid", this.K.f0()));
                    this.R = this.K.q1().video_url;
                }
                this.Q = true;
                this.G.setVideoPath(this.R, this.K.f0());
                b.a.r0.q2.f fVar = this.S;
                if (fVar != null) {
                    fVar.m();
                }
                c0();
            }
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            b0();
            a0();
            e0(true, 1);
            TbCyberVideoView tbCyberVideoView = this.G;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                b.a.r0.q2.f fVar = this.S;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.Q = false;
        }
    }
}
