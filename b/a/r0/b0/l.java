package b.a.r0.b0;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.f.m.d;
import b.a.q0.d1.s0;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.q2.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
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
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class l extends b.a.r0.b0.b<b.a.r0.b0.e0.l> implements View.OnClickListener, b.a.r0.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public ImageView B;
    public TbCyberVideoView C;
    public TextView D;
    public LinearLayout E;
    public TextView F;
    public View G;
    public TextView H;
    public View I;
    public b.a.r0.q2.n J;
    public b.a.r0.b0.e0.l K;
    public View L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public String R;
    public boolean S;
    public b.a.r0.q2.f T;
    public Animation U;
    public int V;
    public TextView W;
    public boolean X;
    public TextView Y;
    public String Z;
    public Handler a0;
    public CyberPlayerManager.OnPreparedListener b0;
    public CyberPlayerManager.OnInfoListener c0;
    public CyberPlayerManager.OnCompletionListener i0;
    public CyberPlayerManager.OnErrorListener j0;
    public VideoLoadingProgressView.c k0;
    public TbImageView.g l0;
    public b.a.f.m.d m;
    public Runnable m0;
    public ThreadCommentAndPraiseInfoLayout n;
    public Runnable n0;
    public View o;
    public CustomMessageListener o0;
    public FrameLayout p;
    public TbCyberVideoView.h p0;
    public ThreadGodReplyLayout q;
    public final View.OnClickListener q0;
    public LinearLayout r;
    public final View.OnClickListener r0;
    public NEGFeedBackView s;
    public CustomMessageListener s0;
    public String t;
    public final View.OnClickListener t0;
    public ThreadSourceShareAndPraiseLayout u;
    public f.b u0;
    public TbPageContext<?> v;
    public Animation.AnimationListener v0;
    public RelativeLayout w;
    public TextView x;
    public ThreadUserInfoLayout y;
    public HeadPendantClickableView z;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14800e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14800e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14800e.C == null || this.f14800e.C.isPlaying()) {
                return;
            }
            this.f14800e.k0(true, 1);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14801e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14801e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14801e.k0(true, 4);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14802e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14802e = lVar;
        }

        @Override // b.a.r0.q2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i3 >= i2) {
                    this.f14802e.m.I(false, false, "NEWINDEX");
                } else if (i2 == 0 || (i3 * 100) / i2 < 80 || i2 <= 15000) {
                } else {
                    l lVar = this.f14802e;
                    lVar.n0(lVar.K);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14803a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l lVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i2)};
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
            this.f14803a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.a.f.m.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b.a.f.m.e.b) || (bVar = (b.a.f.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || this.f14803a.K == null || this.f14803a.K.f14748e == null || !d2.equals(this.f14803a.K.f14748e.f0())) {
                return;
            }
            b.a.f.m.d dVar = this.f14803a.m;
            l lVar = this.f14803a;
            dVar.K(lVar.M(lVar.K, bVar));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14804e;

        public e(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14804e = lVar;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14804e.stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14805e;

        public f(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14805e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14805e.K == null) {
                    if (this.f14805e.f() != null) {
                        this.f14805e.f().a(view, this.f14805e.K);
                        return;
                    }
                    return;
                }
                if (view == this.f14805e.y.getUserName()) {
                    this.f14805e.K.k = 3;
                } else if (view == this.f14805e.y.getHeaderImg()) {
                    this.f14805e.K.k = 4;
                } else {
                    this.f14805e.K.k = 1;
                }
                if (this.f14805e.f() != null) {
                    this.f14805e.f().a(view, this.f14805e.K);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14806e;

        public g(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14806e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f14806e.K != null) {
                    this.f14806e.K.k = 4;
                }
                if (this.f14806e.f() != null) {
                    this.f14806e.f().a(view, this.f14806e.K);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14807a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(l lVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i2)};
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
            this.f14807a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                this.f14807a.S = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14808e;

        public i(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14808e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14808e.K == null) {
                return;
            }
            if (this.f14808e.f() != null) {
                this.f14808e.f().a(view, this.f14808e.K);
            }
            if (this.f14808e.K.f14748e == null) {
                return;
            }
            l lVar = this.f14808e;
            if (view == lVar.u.mForumNameView) {
                return;
            }
            b.a.r0.b0.m.a(lVar.K.f14748e.f0());
            if (this.f14808e.a0()) {
                return;
            }
            b.a.r0.b0.m.l(this.f14808e.x, this.f14808e.K.f14748e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            b.a.r0.b0.m.l(this.f14808e.q.getGodReplyContent(), this.f14808e.K.getThreadData().f0(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14809a;

        public j(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14809a = lVar;
        }

        @Override // b.a.r0.q2.f.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14809a.K == null || this.f14809a.K.f14748e == null || this.f14809a.K.f14748e.q1() == null) {
                return;
            }
            this.f14809a.h0();
        }
    }

    /* loaded from: classes4.dex */
    public class k extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14810a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(l lVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, looper};
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
            this.f14810a = lVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 202) {
                    this.f14810a.U();
                } else if (i2 != 203) {
                } else {
                    this.f14810a.T();
                }
            }
        }
    }

    /* renamed from: b.a.r0.b0.l$l  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC0749l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14811a;

        public animation.Animation$AnimationListenerC0749l(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14811a = lVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f14811a.A == null) {
                return;
            }
            this.f14811a.A.setVisibility(8);
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

    /* loaded from: classes4.dex */
    public class m implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14812e;

        public m(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14812e = lVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f14812e.C != null) {
                    this.f14812e.C.setVolume(0.0f, 0.0f);
                }
                this.f14812e.m0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14813e;

        public n(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14813e = lVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (i2 == 3 || i2 == 904) {
                    this.f14813e.k0(false, 3);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class o implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14814e;

        public o(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14814e = lVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14814e.m.I(false, false, "NEWINDEX")) {
                return;
            }
            this.f14814e.C.start();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f14815e;

        public p(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14815e = lVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f14815e.k0(true, 4);
                this.f14815e.P = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14816a;

        public q(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14816a = lVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14816a.m0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements d.InterfaceC0063d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14817a;

        public r(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14817a = lVar;
        }

        @Override // b.a.f.m.d.InterfaceC0063d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f14817a.X) {
                    this.f14817a.C.start();
                } else {
                    this.f14817a.startPlay();
                }
                this.f14817a.X = false;
            }
        }

        @Override // b.a.f.m.d.InterfaceC0063d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.f.m.d.InterfaceC0063d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // b.a.f.m.d.InterfaceC0063d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class s implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f14818a;

        public s(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14818a = lVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.f14818a.A != null) {
                this.f14818a.A.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t extends b.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(l lVar, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i2), str, str2};
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
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.s = null;
        this.M = 3;
        this.N = 0;
        this.O = 1;
        this.P = false;
        this.Q = true;
        this.V = 100;
        this.X = false;
        this.a0 = new k(this, Looper.getMainLooper());
        this.b0 = new m(this);
        this.c0 = new n(this);
        this.i0 = new o(this);
        this.j0 = new p(this);
        this.k0 = new q(this);
        this.l0 = new s(this);
        this.m0 = new a(this);
        this.n0 = new b(this);
        this.o0 = new d(this, 2921395);
        this.p0 = new e(this);
        this.q0 = new f(this);
        this.r0 = new g(this);
        this.s0 = new h(this, 2016477);
        this.t0 = new i(this);
        this.u0 = new j(this);
        this.v0 = new animation.Animation$AnimationListenerC0749l(this);
        this.v = tbPageContext;
        View i4 = i();
        RelativeLayout relativeLayout = (RelativeLayout) i4.findViewById(R.id.layout_root);
        this.w = relativeLayout;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) relativeLayout.findViewById(R.id.card_home_page_video_user_pendant_header);
        this.z = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.z.getHeadView().setIsRound(true);
            this.z.getHeadView().setDrawBorder(false);
            this.z.getHeadView().setDefaultResource(17170445);
            this.z.getHeadView().setRadius(b.a.e.e.p.l.g(this.v.getPageActivity(), R.dimen.ds70));
            this.z.getHeadView().setPlaceHolder(1);
        }
        this.z.setHasPendantStyle();
        if (this.z.getPendantView() != null) {
            this.z.getPendantView().setIsRound(true);
            this.z.getPendantView().setDrawBorder(false);
        }
        b.a.r0.q2.n nVar = new b.a.r0.q2.n((ViewGroup) i4.findViewById(R.id.auto_video_loading_container));
        this.J = nVar;
        nVar.f(this.k0);
        this.x = (TextView) i4.findViewById(R.id.text_title);
        this.y = (ThreadUserInfoLayout) i4.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.s = new NEGFeedBackView(h());
        int g2 = b.a.e.e.p.l.g(getContext(), R.dimen.tbds120);
        b.a.e.e.p.l.g(getContext(), R.dimen.tbds16);
        this.s.attachToViewUpperRightConner(this.w, g2, 0);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) i4.findViewById(R.id.text_bottom);
        this.n = threadCommentAndPraiseInfoLayout;
        if (threadCommentAndPraiseInfoLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.n.setLayoutParams(layoutParams);
        }
        this.n.setOnClickListener(this);
        this.n.setReplyTimeVisible(false);
        this.n.setShowPraiseNum(true);
        this.n.setNeedAddPraiseIcon(true);
        this.n.setNeedAddReplyIcon(true);
        this.n.setShareVisible(true);
        this.n.setShareReportFrom(3);
        this.n.setForumAfterClickListener(this.t0);
        this.n.setFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i4.findViewById(R.id.text_bottom_threaad);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(this.t0);
        this.o = i4.findViewById(R.id.divider_below_reply_number_layout);
        FrameLayout frameLayout = (FrameLayout) i4.findViewById(R.id.frame_video);
        this.p = frameLayout;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        int k2 = b.a.e.e.p.l.k(this.v.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.width = k2;
        layoutParams2.height = (int) (k2 * 0.5625d);
        this.p.setLayoutParams(layoutParams2);
        TbImageView tbImageView = (TbImageView) i4.findViewById(R.id.image_video);
        this.A = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.A.setGifIconSupport(false);
        this.A.setEvent(this.l0);
        this.A.setRadius(b.a.e.e.p.l.g(this.v.getPageActivity(), R.dimen.tbds10));
        this.A.setConrers(15);
        this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.A.setBorderSurroundContent(true);
        this.A.setDrawBorder(true);
        this.B = (ImageView) i4.findViewById(R.id.image_video_play);
        this.w.setOnClickListener(this);
        TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
        this.C = tbCyberVideoView;
        tbCyberVideoView.setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.p.addView(this.C.getView(), 0);
        this.C.getView().setLayoutParams(layoutParams3);
        this.C.setContinuePlayEnable(true);
        this.C.setOnPreparedListener(this.b0);
        this.C.setOnInfoListener(this.c0);
        this.C.setOnCompletionListener(this.i0);
        this.C.setOnErrorListener(this.j0);
        this.C.setOnSurfaceDestroyedListener(this.p0);
        b.a.r0.q2.f fVar = new b.a.r0.q2.f();
        this.T = fVar;
        fVar.l(this.C);
        this.T.i(this.u0);
        this.D = (TextView) i4.findViewById(R.id.text_video_duration);
        this.E = (LinearLayout) i4.findViewById(R.id.duration_container);
        this.F = (TextView) i4.findViewById(R.id.text_video_play_count);
        this.L = i4.findViewById(R.id.auto_video_black_mask);
        this.H = (TextView) i4.findViewById(R.id.auto_video_error_tips);
        this.I = i4.findViewById(R.id.auto_video_error_background);
        this.r = (LinearLayout) i4.findViewById(R.id.video_card_content_layout);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.v.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.U = loadAnimation;
        loadAnimation.setAnimationListener(this.v0);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) i4.findViewById(R.id.card_god_reply_layout);
        this.q = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        this.G = i4.findViewById(R.id.divider_line);
        this.W = (TextView) i4.findViewById(R.id.txt_video_num_during_playing);
        this.C.getView().setOnClickListener(this);
        this.Y = (TextView) i4.findViewById(R.id.nani_video_icon);
        b.a.f.m.d dVar = new b.a.f.m.d(getContext(), this.p);
        this.m = dVar;
        dVar.G(new r(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b.a.f.m.a M(b.a.r0.b0.e0.l lVar, b.a.f.m.e.b bVar) {
        InterceptResult invokeLL;
        d2 d2Var;
        int i2;
        VideoInfo q1;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lVar, bVar)) == null) {
            if (lVar == null || (d2Var = lVar.f14748e) == null || bVar == null) {
                return null;
            }
            int c2 = bVar.c();
            int b2 = bVar.b();
            int a2 = bVar.a();
            int i5 = -1;
            if (a2 != -1) {
                int i6 = c2 != -1 ? (a2 - c2) - 1 : -1;
                if (b2 != -1) {
                    i5 = i6;
                    i2 = (b2 - a2) - 1;
                    q1 = d2Var.q1();
                    if (q1 == null) {
                        int intValue = q1.video_width.intValue();
                        i4 = q1.video_height.intValue();
                        i3 = intValue;
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", d2Var.f0());
                    hashMap.put("video_title", d2Var.getTitle());
                    hashMap.put("forum_id", String.valueOf(d2Var.T()));
                    hashMap.put("forum_name", d2Var.Z());
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    b.a.f.m.a h2 = b.a.f.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            q1 = d2Var.q1();
            if (q1 == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", d2Var.f0());
            hashMap2.put("video_title", d2Var.getTitle());
            hashMap2.put("forum_id", String.valueOf(d2Var.T()));
            hashMap2.put("forum_name", d2Var.Z());
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            b.a.f.m.a h22 = b.a.f.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (b.a.f.m.a) invokeLL.objValue;
    }

    public int O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? b.a.r0.p.d.c().b(this.t, i2) : invokeI.intValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public final void R(Rect rect) {
        b.a.r0.b0.e0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, rect) == null) || (lVar = this.K) == null || lVar.f14748e == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K.f14748e);
        videoItemData.mRecomExtra = this.K.k();
        videoItemData.mRecomAbTag = this.K.g();
        videoItemData.mRecomSource = this.K.t();
        videoItemData.mRecomWeight = this.K.E();
        arrayList.add(videoItemData);
        b.a.q0.d1.w.d(this.f14737f.getPageActivity(), arrayList, this.K.f14748e.L() != null ? this.K.f14748e.L().oriUgcNid : null, false, 0, rect, "from_nani_video", "personalize_page", this.K.getPbInputLocate(), "index", "", false, false);
    }

    public final void S() {
        b.a.r0.b0.e0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lVar = this.K) == null || (d2Var = lVar.f14748e) == null || d2Var.f0() == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K.f14748e);
        videoSerializeVideoThreadInfo.source = this.K.t();
        videoSerializeVideoThreadInfo.extra = this.K.k();
        videoSerializeVideoThreadInfo.ab_tag = this.K.g();
        videoSerializeVideoThreadInfo.weight = this.K.E();
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (this.r.getX() + Q().getX());
        videoCardViewInfo.cardViewY = (int) (i().getY() + this.r.getY() + Q().getY());
        videoCardViewInfo.cardViewWidth = Q().getWidth();
        videoCardViewInfo.cardViewHeight = Q().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.v.getPageActivity(), (b.a.e.e.p.k.isEmpty(this.Z) || !this.Z.equals("hottopic")) ? "index" : "hottopic", this.K.f14748e.s1(), b.a.r0.b0.m.g(), this.K.getPbInputLocate(), videoSerializeVideoThreadInfo);
        if (this.K.getThreadData() != null && this.K.getThreadData().L() != null) {
            videoMiddlePageActivityConfig.setNid(this.K.getThreadData().L().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (i().getParent() == null) {
                stopPlay();
                return;
            }
            this.a0.removeMessages(203);
            int currentPositionSync = this.C.getCurrentPositionSync();
            if (currentPositionSync != this.N) {
                this.N = currentPositionSync;
                k0(false, 3);
            } else {
                k0(false, 2);
            }
            this.a0.sendEmptyMessageDelayed(203, 3000L);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a0.removeMessages(202);
            if (this.C.getCurrentPositionSync() > this.V) {
                k0(false, 3);
                this.a0.sendEmptyMessageDelayed(203, 3000L);
                return;
            }
            this.a0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public final void V(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (f() != null) {
                f().a(view, this.K);
            }
            if (!b.a.e.e.p.j.z()) {
                b.a.e.e.p.l.L(this.v.getPageActivity(), R.string.no_network_guide);
            } else {
                R(ThreadCardUtils.computeViewArea(this.p));
            }
        }
    }

    public final void W(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            b.a.r0.b0.e0.l lVar = this.K;
            if (lVar != null) {
                lVar.k = 1;
            }
            if (f() != null) {
                f().a(view, this.K);
            }
            b.a.r0.b0.e0.l lVar2 = this.K;
            if (lVar2 == null || lVar2.f14748e == null) {
                return;
            }
            if (!a0()) {
                b.a.r0.b0.m.a(this.K.f14748e.f0());
                b.a.r0.b0.m.l(this.x, this.K.f14748e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.v.getPageActivity()).createFromThreadCfg(this.K.f14748e, null, b.a.r0.b0.m.g(), 18003, true, false, false).addLocateParam(this.K.getPbInputLocate());
            addLocateParam.setVideo_source(this.K.W == 0 ? "index" : "hot_juhe");
            if (this.K.W == 0) {
                addLocateParam.setFrom("from_personalize");
            }
            addLocateParam.setForumId(String.valueOf(this.K.f14748e.T()));
            addLocateParam.setForumName(this.K.f14748e.Z());
            addLocateParam.setStartFrom(this.l);
            if (view == this.q) {
                addLocateParam.setJumpGodReply(true);
            }
            this.v.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void X() {
        b.a.r0.b0.e0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g0();
            f0();
            if (this.A == null || this.p == null || this.C == null) {
                return;
            }
            if (b.a.q0.s.k.c().g() && (lVar = this.K) != null && (d2Var = lVar.f14748e) != null && d2Var.q1() != null) {
                this.A.setPlaceHolder(3);
                this.A.startLoad(this.K.f14748e.q1().thumbnail_url, 10, false);
                this.p.setVisibility(0);
                stopPlay();
                this.R = this.K.f14748e.q1().video_url;
                if (Z()) {
                    this.R = this.K.f14748e.r1().video_url;
                }
                if (StringUtils.isNull(this.K.f14748e.q1().video_url)) {
                    k0(true, 4);
                }
                this.C.setThreadDataForStatistic(this.K.f14748e);
            } else {
                this.p.setVisibility(8);
            }
            this.m.B();
            this.T.j(new c(this));
        }
    }

    public final void Y(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (f() != null) {
                f().a(view, this.K);
            }
            if (!b.a.e.e.p.j.z()) {
                b.a.e.e.p.l.L(this.v.getPageActivity(), R.string.no_network_guide);
            } else {
                S();
            }
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.r0.b0.e0.l lVar = this.K;
            return (lVar == null || (d2Var = lVar.f14748e) == null || d2Var.r1() == null || TextUtils.isEmpty(this.K.f14748e.r1().video_url)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            b.a.r0.b0.e0.l lVar = this.K;
            return lVar.U && !lVar.V;
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.P : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: c0 */
    public void j(b.a.r0.b0.e0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, lVar) == null) {
            this.K = lVar;
            d0();
        }
    }

    public final void d0() {
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.r0.b0.e0.l lVar = this.K;
            if (lVar != null && (d2Var = lVar.f14748e) != null && d2Var.J() != null) {
                this.w.setVisibility(0);
                X();
                if (!a0() && b.a.r0.b0.m.k(this.K.f14748e.f0())) {
                    b.a.r0.b0.m.l(this.x, this.K.f14748e.f0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    b.a.r0.b0.m.l(this.q.getGodReplyContent(), this.K.getThreadData().f0(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.K.getThreadData().c3();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.K.getThreadData().g1());
                if (this.K.getThreadData().i() && !StringUtils.isNull(this.K.getThreadData().s1())) {
                    String str = b.a.q0.s.e0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.getThreadData().s1();
                    spannableStringBuilder.append((CharSequence) this.K.getThreadData().k(new t(this, 2, str, str)));
                }
                this.x.setOnTouchListener(new b.a.r0.c4.h(spannableStringBuilder));
                this.x.setText(spannableStringBuilder);
                this.y.setData(this.K.getThreadData());
                this.y.setUserAfterClickListener(this.q0);
                if (this.y.getHeaderImg() != null) {
                    this.y.getHeaderImg().setAfterClickListener(this.r0);
                    if (this.y.getIsSimpleThread()) {
                        this.y.getHeaderImg().setVisibility(8);
                        this.z.setVisibility(8);
                    } else if (this.K.getThreadData() != null && this.K.getThreadData().J() != null && this.K.getThreadData().J().getPendantData() != null && !StringUtils.isNull(this.K.getThreadData().J().getPendantData().getImgUrl())) {
                        this.y.getHeaderImg().setVisibility(4);
                        this.z.setVisibility(0);
                        this.z.setData(this.K.getThreadData());
                    } else {
                        this.z.setVisibility(8);
                        this.y.getHeaderImg().setVisibility(0);
                        if (this.K.getThreadData().w1 > 0 && this.K.getThreadData().x1 == 0) {
                            this.K.getThreadData().J().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.y.getHeaderImg().setData(this.K.getThreadData(), false);
                        } else {
                            this.y.getHeaderImg().setData(this.K.getThreadData());
                            this.y.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.D.setText(StringHelper.stringForVideoTime(this.K.f14748e.q1().video_duration.intValue() * 1000));
                this.F.setText(String.format(this.v.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.K.f14748e.q1().play_count.intValue())));
                if (this.s != null && this.K.getThreadData() != null) {
                    x0 x0Var = new x0();
                    x0Var.o(this.K.getThreadData().s1());
                    x0Var.k(this.K.getThreadData().T());
                    x0Var.n(this.K.getThreadData().F0());
                    x0Var.j(this.K.feedBackReasonMap);
                    this.s.setData(x0Var);
                    this.s.setFirstRowSingleColumn(true);
                    this.s.setVisibility(this.Q ? 0 : 8);
                }
                this.q.setData(this.K.getThreadData().v1());
                l0(O(1));
                k(this.v, TbadkCoreApplication.getInst().getSkinType());
                if (b.a.r0.b0.m.k(this.K.f14748e.f0())) {
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0105, 1);
                }
                b.a.r0.b0.e0.l lVar2 = this.K;
                if ((lVar2 == null || (d2Var2 = lVar2.f14748e) == null || d2Var2.q1() == null || this.K.f14748e.q1().is_vertical.intValue() != 1) ? false : true) {
                    this.Y.setVisibility(0);
                    if (Z()) {
                        this.Y.setText(String.format("%s | %s", this.v.getResources().getString(R.string.nani_video), this.v.getResources().getString(R.string.video_preview)));
                        return;
                    } else {
                        this.Y.setText(this.v.getString(R.string.nani_video));
                        return;
                    }
                } else if (Z()) {
                    this.Y.setVisibility(0);
                    this.Y.setText(this.v.getString(R.string.video_preview));
                    return;
                } else {
                    this.Y.setVisibility(8);
                    return;
                }
            }
            this.w.setVisibility(8);
        }
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? R.layout.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    public void e0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.s0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.s0);
        this.o0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.o0);
        j0(bdUniqueId);
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a0.removeMessages(202);
            this.a0.removeMessages(203);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.m0);
            b.a.e.e.m.e.a().removeCallbacks(this.n0);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.C;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final void h0() {
        b.a.r0.b0.e0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (lVar = this.K) == null || lVar.f14748e == null) {
            return;
        }
        b.a.r0.q2.p pVar = new b.a.r0.q2.p();
        pVar.f22882a = this.K.W == 0 ? "index" : "hot_juhe";
        pVar.f22884c = this.K.f14748e.s1();
        pVar.f22885d = this.K.f14748e.T() + "";
        pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
        b.a.r0.b0.e0.l lVar2 = this.K;
        d2 d2Var = lVar2.f14748e;
        pVar.f22887f = d2Var.X0;
        String str = d2Var.Z0;
        pVar.l = str;
        pVar.f22888g = str;
        pVar.f22889h = d2Var.Y0;
        pVar.f22890i = "";
        pVar.k = lVar2.k();
        if (this.K.f14748e.q1() != null) {
            pVar.m = this.K.f14748e.q1().video_md5;
        }
        b.a.r0.q2.h.e(this.K.f14748e.q1().video_md5, "", "1", pVar, this.C.getPcdnState());
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.Q = z;
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.C;
            if (tbCyberVideoView == null) {
                return false;
            }
            return tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public final void j0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdUniqueId) == null) {
            ThreadUserInfoLayout threadUserInfoLayout = this.y;
            if (threadUserInfoLayout != null) {
                threadUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            TbImageView tbImageView = this.A;
            if (tbImageView != null) {
                tbImageView.setPageId(bdUniqueId);
            }
            NEGFeedBackView nEGFeedBackView = this.s;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setUniqueId(bdUniqueId);
            }
        }
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048603, this, tbPageContext, i2) == null) || this.M == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.w, R.drawable.addresslist_item_bg);
        SkinManager.setImageResource(this.B, R.drawable.btn_icon_play_video_n);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.D, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.W, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.I, R.color.common_color_10014);
        SkinManager.setBackgroundColor(this.G, R.color.CAM_X0204);
        TextView textView = this.Y;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.Y, R.drawable.video_play_count_bg);
        }
        if (this.H != null) {
            this.H.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.icon_toast_game_error), (Drawable) null, (Drawable) null);
        }
        this.q.onChangeSkinType();
        NEGFeedBackView nEGFeedBackView = this.s;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.onChangeSkinType();
        }
        this.y.onChangeSkinType();
        this.n.onChangeSkinType();
        this.u.onChangeSkinType();
        this.A.setPlaceHolder(3);
        this.z.getHeadView().setPlaceHolder(1);
        this.M = i2;
    }

    public final void k0(boolean z, int i2) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.B == null || this.A == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.O != i2) {
            this.O = i2;
            b.a.e.e.m.e.a().removeCallbacks(this.n0);
            b.a.e.e.m.e.a().removeCallbacks(this.m0);
            if (i2 == 2) {
                this.B.setVisibility(8);
                this.U.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.L.setVisibility(0);
                this.E.setVisibility(0);
                this.W.setVisibility(8);
                this.J.g();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                b.a.e.e.m.e.a().postDelayed(this.n0, 60000L);
            } else if (i2 == 3) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.U);
                this.L.setVisibility(8);
                this.E.setVisibility(8);
                b.a.r0.b0.e0.l lVar = this.K;
                if (lVar != null && lVar.getThreadData() != null && this.K.getThreadData().w1 > 0) {
                    this.W.setVisibility(0);
                }
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                b.a.r0.b0.e0.l lVar2 = this.K;
                if (lVar2 != null && (d2Var = lVar2.f14748e) != null && d2Var.q1() != null) {
                    this.K.f14748e.q1().video_length.intValue();
                    this.K.f14748e.q1().video_duration.intValue();
                    this.K.f14748e.s1();
                }
            } else if (i2 == 4) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.U);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                b.a.e.e.m.e.a().postDelayed(this.m0, 2000L);
            } else {
                this.B.setVisibility(0);
                this.U.cancel();
                this.A.clearAnimation();
                this.A.setVisibility(0);
                this.L.setVisibility(0);
                this.E.setVisibility(0);
                this.J.b();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
            }
            b.a.r0.b0.e0.l lVar3 = this.K;
            if (lVar3 == null || lVar3.getThreadData() == null || this.K.getThreadData().w1 <= 0) {
                return;
            }
            this.E.setVisibility(8);
        }
    }

    public void l0(int i2) {
        b.a.r0.b0.e0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i2) == null) || (lVar = this.K) == null || (d2Var = lVar.f14748e) == null) {
            return;
        }
        if (i2 == 1) {
            if (d2Var.w1 > 0) {
                this.u.mSharePraiseView.setShowPraiseNum(false);
                this.u.mSharePraiseView.setShareVisible(false);
                this.W.setText(StringHelper.numFormatOverWan(this.K.f14748e.w1));
                this.W.setVisibility(0);
            } else {
                this.u.mSharePraiseView.setShowPraiseNum(true);
                this.u.mSharePraiseView.setShareVisible(true);
                this.W.setVisibility(8);
            }
            this.u.setData(this.K.f14748e);
            this.n.setVisibility(8);
            this.y.showForumNameView(false);
            return;
        }
        this.u.setVisibility(8);
        this.y.showForumNameView(true);
        if (this.K.f14748e.w1 > 0) {
            this.n.setShowPraiseNum(false);
            this.n.setShareVisible(false);
            this.W.setText(StringHelper.numFormatOverWan(this.K.f14748e.w1));
            this.W.setVisibility(0);
        } else {
            this.n.setShowPraiseNum(true);
            this.n.setShareVisible(true);
            this.W.setVisibility(8);
        }
        if (this.n.setData(this.K.f14748e)) {
            this.o.setVisibility(8);
        } else {
            this.o.setVisibility(0);
        }
    }

    public final void m0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (tbCyberVideoView = this.C) != null && this.P) {
            try {
                tbCyberVideoView.start();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int c2 = b.a.r0.q2.o.d().c(this.R);
            this.V = (c2 <= 100 || this.C.getDuration() <= c2) ? 100 : 100;
            this.a0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public final void n0(b.a.r0.b0.e0.l lVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, lVar) == null) || lVar == null || (d2Var = lVar.f14748e) == null || d2Var.f0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, d2Var.f0()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d2 d2Var;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view) == null) {
            b.a.r0.b0.e0.l lVar = this.K;
            if (lVar != null && (d2Var2 = lVar.f14748e) != null && d2Var2.w1 > 0) {
                if (f() != null) {
                    f().a(view, this.K);
                }
                this.v.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.v.getPageActivity(), this.K.f14748e.s1(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, b.a.r0.b0.m.g(), this.K.getPbInputLocate())));
                return;
            }
            if (view == this.w || view == this.q) {
                W(view);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view == this.C.getView()) {
                b.a.r0.b0.e0.l lVar2 = this.K;
                if (lVar2 != null) {
                    lVar2.k = 5;
                }
                b.a.r0.b0.e0.l lVar3 = this.K;
                boolean z = false;
                if (lVar3 != null && (d2Var = lVar3.f14748e) != null && d2Var.q1() != null && this.K.f14748e.q1().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    V(this.C.getView());
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    Y(this.C.getView());
                } else {
                    W(i());
                }
            }
        }
    }

    @Override // b.a.r0.b0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.Z = str;
        }
    }

    @Override // b.a.r0.p.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.t = str;
        }
    }

    public void startPlay() {
        b.a.r0.b0.e0.l lVar;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.P || (lVar = this.K) == null || (d2Var = lVar.f14748e) == null || d2Var.q1() == null || this.C == null) {
            return;
        }
        if (this.m.r()) {
            this.m.E();
            this.X = true;
            return;
        }
        this.X = false;
        this.C.stopPlayback();
        if (s0.b(1, this.R)) {
            k0(true, 2);
            if (StringUtils.isNull(this.R)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.K.l));
                this.R = this.K.f14748e.q1().video_url;
            }
            this.P = true;
            this.C.setVideoPath(this.R, this.K.l);
            b.a.r0.q2.f fVar = this.T;
            if (fVar != null) {
                fVar.m();
            }
            h0();
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.X = false;
            g0();
            f0();
            k0(true, 1);
            TbCyberVideoView tbCyberVideoView = this.C;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
                b.a.r0.q2.f fVar = this.T;
                if (fVar != null) {
                    fVar.n();
                }
            }
            this.P = false;
            this.m.L();
        }
    }
}
