package c.a.t0.g0;

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
import c.a.e.m.d;
import c.a.s0.d1.t0;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import c.a.t0.a3.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoLoadingProgressView;
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
/* loaded from: classes7.dex */
public class l extends c.a.t0.g0.b<c.a.t0.g0.f0.l> implements View.OnClickListener, c.a.t0.t.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public ImageView B;
    public TbVideoViewContainer C;
    public TextView D;
    public LinearLayout E;
    public TextView F;
    public View G;
    public TextView H;
    public View I;
    public c.a.t0.a3.q J;
    public c.a.t0.g0.f0.l K;
    public View L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public String R;
    public boolean S;
    public c.a.t0.a3.h T;
    public Animation U;
    public int V;
    public TextView W;
    public boolean X;
    public TextView Y;
    public String Z;
    public Handler a0;
    public c.a.t0.a3.v.a b0;
    public VideoLoadingProgressView.c c0;
    public TbImageView.g d0;
    public Runnable e0;
    public Runnable f0;
    public CustomMessageListener g0;
    public TbVideoViewContainer.a h0;
    public final View.OnClickListener i0;
    public final View.OnClickListener k0;
    public c.a.e.m.d m;
    public ThreadCommentAndPraiseInfoLayout n;
    public View o;
    public FrameLayout p;
    public ThreadGodReplyLayout q;
    public CustomMessageListener q0;
    public LinearLayout r;
    public final View.OnClickListener r0;
    public NEGFeedBackView s;
    public h.b s0;
    public String t;
    public Animation.AnimationListener t0;
    public ThreadSourceShareAndPraiseLayout u;
    public TbPageContext<?> v;
    public RelativeLayout w;
    public TextView x;
    public ThreadUserInfoLayout y;
    public HeadPendantClickableView z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, int i2) {
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
            this.a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.e.m.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.e.m.e.b) || (bVar = (c.a.e.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || this.a.K == null || this.a.K.f17600e == null || !d2.equals(this.a.K.f17600e.h0())) {
                return;
            }
            c.a.e.m.d dVar = this.a.m;
            l lVar = this.a;
            dVar.K(lVar.H(lVar.K, bVar));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17648e;

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
            this.f17648e = lVar;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17648e.stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17649e;

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
            this.f17649e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17649e.K == null) {
                    if (this.f17649e.g() != null) {
                        this.f17649e.g().a(view, this.f17649e.K);
                        return;
                    }
                    return;
                }
                if (view == this.f17649e.y.getUserName()) {
                    this.f17649e.K.k = 3;
                } else if (view == this.f17649e.y.getHeaderImg()) {
                    this.f17649e.K.k = 4;
                } else {
                    this.f17649e.K.k = 1;
                }
                if (this.f17649e.g() != null) {
                    this.f17649e.g().a(view, this.f17649e.K);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17650e;

        public d(l lVar) {
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
            this.f17650e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f17650e.K != null) {
                    this.f17650e.K.k = 4;
                }
                if (this.f17650e.g() != null) {
                    this.f17650e.g().a(view, this.f17650e.K);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l lVar, int i2) {
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
            this.a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016477) {
                this.a.S = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17651e;

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
            this.f17651e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17651e.K == null) {
                return;
            }
            if (this.f17651e.g() != null) {
                this.f17651e.g().a(view, this.f17651e.K);
            }
            if (this.f17651e.K.f17600e == null) {
                return;
            }
            l lVar = this.f17651e;
            if (view == lVar.u.mForumNameView) {
                return;
            }
            c.a.t0.g0.m.a(lVar.K.f17600e.h0());
            if (this.f17651e.U()) {
                return;
            }
            c.a.t0.g0.m.l(this.f17651e.x, this.f17651e.K.f17600e.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
            c.a.t0.g0.m.l(this.f17651e.q.getGodReplyContent(), this.f17651e.K.getThreadData().h0(), R.color.CAM_X0106, R.color.CAM_X0109);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

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
            this.a = lVar;
        }

        @Override // c.a.t0.a3.h.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.K == null || this.a.K.f17600e == null || this.a.K.f17600e.u1() == null) {
                return;
            }
            this.a.b0();
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public h(l lVar) {
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
            this.a = lVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.A == null) {
                return;
            }
            this.a.A.setVisibility(8);
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

    /* loaded from: classes7.dex */
    public class i extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(l lVar, Looper looper) {
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
            this.a = lVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 202) {
                    this.a.O();
                } else if (i2 != 203) {
                } else {
                    this.a.N();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements c.a.t0.a3.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17652e;

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
            this.f17652e = lVar;
        }

        @Override // c.a.t0.a3.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.t0.a3.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.t0.a3.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.a3.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.a3.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.a3.v.a
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
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f17652e.m.I(false, false, "NEWINDEX")) {
                return;
            }
            this.f17652e.C.getControl().start();
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                this.f17652e.e0(true, 4);
                this.f17652e.P = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                if (i2 == 3 || i2 == 904) {
                    this.f17652e.e0(false, 3);
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                if (this.f17652e.C != null && this.f17652e.C.getControl() != null) {
                    this.f17652e.C.getControl().setVolume(0.0f, 0.0f);
                }
                this.f17652e.g0();
            }
        }

        @Override // c.a.t0.a3.v.a
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

        @Override // c.a.t0.a3.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.t0.a3.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void setStatistic(c.a.t0.a3.t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.t0.a3.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public k(l lVar) {
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
            this.a = lVar;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g0();
            }
        }
    }

    /* renamed from: c.a.t0.g0.l$l  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1112l implements d.InterfaceC0141d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public C1112l(l lVar) {
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
            this.a = lVar;
        }

        @Override // c.a.e.m.d.InterfaceC0141d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.X) {
                    this.a.C.getControl().start();
                } else {
                    this.a.startPlay();
                }
                this.a.X = false;
            }
        }

        @Override // c.a.e.m.d.InterfaceC0141d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.e.m.d.InterfaceC0141d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.e.m.d.InterfaceC0141d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

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
            this.a = lVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.a.A != null) {
                this.a.A.setDefaultBgResource(0);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends c.a.s0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(l lVar, int i2, String str, String str2) {
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

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.m.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "0"));
            }
        }

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17653e;

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
            this.f17653e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17653e.C == null || this.f17653e.C.getControl().isPlaying()) {
                return;
            }
            this.f17653e.e0(true, 1);
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17654e;

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
            this.f17654e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17654e.e0(true, 4);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f17655e;

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
            this.f17655e = lVar;
        }

        @Override // c.a.t0.a3.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i3 >= i2) {
                    this.f17655e.m.I(false, false, "NEWINDEX");
                } else if (i2 == 0 || (i3 * 100) / i2 < 80 || i2 <= 15000) {
                } else {
                    l lVar = this.f17655e;
                    lVar.h0(lVar.K);
                }
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
        this.a0 = new i(this, Looper.getMainLooper());
        this.b0 = new j(this);
        this.c0 = new k(this);
        this.d0 = new m(this);
        this.e0 = new o(this);
        this.f0 = new p(this);
        this.g0 = new a(this, 2921395);
        this.h0 = new b(this);
        this.i0 = new c(this);
        this.k0 = new d(this);
        this.q0 = new e(this, 2016477);
        this.r0 = new f(this);
        this.s0 = new g(this);
        this.t0 = new h(this);
        this.v = tbPageContext;
        View j2 = j();
        RelativeLayout relativeLayout = (RelativeLayout) j2.findViewById(R.id.layout_root);
        this.w = relativeLayout;
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) relativeLayout.findViewById(R.id.card_home_page_video_user_pendant_header);
        this.z = headPendantClickableView;
        if (headPendantClickableView.getHeadView() != null) {
            this.z.getHeadView().setIsRound(true);
            this.z.getHeadView().setDrawBorder(false);
            this.z.getHeadView().setDefaultResource(17170445);
            this.z.getHeadView().setRadius(c.a.d.f.p.n.f(this.v.getPageActivity(), R.dimen.ds70));
            this.z.getHeadView().setPlaceHolder(1);
        }
        this.z.setHasPendantStyle();
        if (this.z.getPendantView() != null) {
            this.z.getPendantView().setIsRound(true);
            this.z.getPendantView().setDrawBorder(false);
        }
        c.a.t0.a3.q qVar = new c.a.t0.a3.q((ViewGroup) j2.findViewById(R.id.auto_video_loading_container));
        this.J = qVar;
        qVar.f(this.c0);
        this.x = (TextView) j2.findViewById(R.id.text_title);
        this.y = (ThreadUserInfoLayout) j2.findViewById(R.id.card_home_page_auto_video_user_info_layout);
        this.s = new NEGFeedBackView(i());
        int f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds120);
        c.a.d.f.p.n.f(getContext(), R.dimen.tbds16);
        this.s.attachToViewUpperRightConner(this.w, f2, 0);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) j2.findViewById(R.id.text_bottom);
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
        this.n.setForumAfterClickListener(this.r0);
        this.n.setFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) j2.findViewById(R.id.text_bottom_threaad);
        this.u = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.mSharePraiseView.setOnClickListener(this);
        this.u.setFrom(1);
        this.u.setShareReportFrom(3);
        this.u.setForumAfterClickListener(this.r0);
        this.o = j2.findViewById(R.id.divider_below_reply_number_layout);
        FrameLayout frameLayout = (FrameLayout) j2.findViewById(R.id.frame_video);
        this.p = frameLayout;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        int k2 = c.a.d.f.p.n.k(this.v.getPageActivity()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
        layoutParams2.width = k2;
        layoutParams2.height = (int) (k2 * 0.5625d);
        this.p.setLayoutParams(layoutParams2);
        TbImageView tbImageView = (TbImageView) j2.findViewById(R.id.image_video);
        this.A = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.A.setGifIconSupport(false);
        this.A.setEvent(this.d0);
        this.A.setRadius(c.a.d.f.p.n.f(this.v.getPageActivity(), R.dimen.tbds10));
        this.A.setConrers(15);
        this.A.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.A.setBorderSurroundContent(true);
        this.A.setDrawBorder(true);
        this.B = (ImageView) j2.findViewById(R.id.image_video_play);
        this.w.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(getContext());
        this.C = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("2001");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        this.p.addView(this.C, 0);
        this.C.setLayoutParams(layoutParams3);
        this.C.getControl().setContinuePlayEnable(true);
        this.C.getControl().setOperableVideoContainer(this.b0);
        this.C.getControl().setOnSurfaceDestroyedListener(this.h0);
        c.a.t0.a3.h hVar = new c.a.t0.a3.h();
        this.T = hVar;
        hVar.l(this.C.getControl());
        this.T.i(this.s0);
        this.D = (TextView) j2.findViewById(R.id.text_video_duration);
        this.E = (LinearLayout) j2.findViewById(R.id.duration_container);
        this.F = (TextView) j2.findViewById(R.id.text_video_play_count);
        this.L = j2.findViewById(R.id.auto_video_black_mask);
        this.H = (TextView) j2.findViewById(R.id.auto_video_error_tips);
        this.I = j2.findViewById(R.id.auto_video_error_background);
        this.r = (LinearLayout) j2.findViewById(R.id.video_card_content_layout);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.v.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_500_accelerate);
        this.U = loadAnimation;
        loadAnimation.setAnimationListener(this.t0);
        ThreadGodReplyLayout threadGodReplyLayout = (ThreadGodReplyLayout) j2.findViewById(R.id.card_god_reply_layout);
        this.q = threadGodReplyLayout;
        threadGodReplyLayout.setOnClickListener(this);
        this.G = j2.findViewById(R.id.divider_line);
        this.W = (TextView) j2.findViewById(R.id.txt_video_num_during_playing);
        this.C.setOnClickListener(this);
        this.Y = (TextView) j2.findViewById(R.id.nani_video_icon);
        c.a.e.m.d dVar = new c.a.e.m.d(getContext(), this.p);
        this.m = dVar;
        dVar.G(new C1112l(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.e.m.a H(c.a.t0.g0.f0.l lVar, c.a.e.m.e.b bVar) {
        InterceptResult invokeLL;
        e2 e2Var;
        int i2;
        VideoInfo u1;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lVar, bVar)) == null) {
            if (lVar == null || (e2Var = lVar.f17600e) == null || bVar == null) {
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
                    u1 = e2Var.u1();
                    if (u1 == null) {
                        int intValue = u1.video_width.intValue();
                        i4 = u1.video_height.intValue();
                        i3 = intValue;
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", e2Var.h0());
                    hashMap.put("video_title", e2Var.getTitle());
                    hashMap.put("forum_id", String.valueOf(e2Var.U()));
                    hashMap.put("forum_name", e2Var.b0());
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    c.a.e.m.a h2 = c.a.e.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            u1 = e2Var.u1();
            if (u1 == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", e2Var.h0());
            hashMap2.put("video_title", e2Var.getTitle());
            hashMap2.put("forum_id", String.valueOf(e2Var.U()));
            hashMap2.put("forum_name", e2Var.b0());
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            c.a.e.m.a h22 = c.a.e.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (c.a.e.m.a) invokeLL.objValue;
    }

    public int I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? c.a.t0.t.d.c().b(this.t, i2) : invokeI.intValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public View K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public final void L(Rect rect) {
        c.a.t0.g0.f0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, rect) == null) || (lVar = this.K) == null || lVar.f17600e == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.buildWithThreadData(this.K.f17600e);
        videoItemData.mRecomExtra = this.K.k();
        videoItemData.mRecomAbTag = this.K.g();
        videoItemData.mRecomSource = this.K.t();
        videoItemData.mRecomWeight = this.K.E();
        arrayList.add(videoItemData);
        c.a.s0.d1.y.d(this.f17589f.getPageActivity(), arrayList, this.K.f17600e.L() != null ? this.K.f17600e.L().oriUgcNid : null, false, 0, rect, "from_nani_video", "personalize_page", this.K.getPbInputLocate(), "index", "", false, false);
    }

    public final void M() {
        c.a.t0.g0.f0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lVar = this.K) == null || (e2Var = lVar.f17600e) == null || e2Var.h0() == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromThreadInfo(this.K.f17600e);
        videoSerializeVideoThreadInfo.source = this.K.t();
        videoSerializeVideoThreadInfo.extra = this.K.k();
        videoSerializeVideoThreadInfo.ab_tag = this.K.g();
        videoSerializeVideoThreadInfo.weight = this.K.E();
        VideoSerializeVideoThreadInfo.VideoCardViewInfo videoCardViewInfo = new VideoSerializeVideoThreadInfo.VideoCardViewInfo();
        videoCardViewInfo.cardViewX = (int) (this.r.getX() + K().getX());
        videoCardViewInfo.cardViewY = (int) (j().getY() + this.r.getY() + K().getY());
        videoCardViewInfo.cardViewWidth = K().getWidth();
        videoCardViewInfo.cardViewHeight = K().getHeight();
        videoSerializeVideoThreadInfo.mVideoCardViewInfo = videoCardViewInfo;
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.v.getPageActivity(), (c.a.d.f.p.m.isEmpty(this.Z) || !this.Z.equals("hottopic")) ? "index" : "hottopic", this.K.f17600e.w1(), c.a.t0.g0.m.g(), this.K.getPbInputLocate(), videoSerializeVideoThreadInfo);
        if (this.K.getThreadData() != null && this.K.getThreadData().L() != null) {
            videoMiddlePageActivityConfig.setNid(this.K.getThreadData().L().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (j().getParent() == null) {
                stopPlay();
                return;
            }
            this.a0.removeMessages(203);
            int currentPositionSync = this.C.getControl().getCurrentPositionSync();
            if (currentPositionSync != this.N) {
                this.N = currentPositionSync;
                e0(false, 3);
            } else {
                e0(false, 2);
            }
            this.a0.sendEmptyMessageDelayed(203, 3000L);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a0.removeMessages(202);
            if (this.C.getControl().getCurrentPositionSync() > this.V) {
                e0(false, 3);
                this.a0.sendEmptyMessageDelayed(203, 3000L);
                return;
            }
            this.a0.sendEmptyMessageDelayed(202, 20L);
        }
    }

    public final void P(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (g() != null) {
                g().a(view, this.K);
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.M(this.v.getPageActivity(), R.string.no_network_guide);
            } else {
                L(ThreadCardUtils.computeViewArea(this.p));
            }
        }
    }

    public final void Q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            c.a.t0.g0.f0.l lVar = this.K;
            if (lVar != null) {
                lVar.k = 1;
            }
            if (g() != null) {
                g().a(view, this.K);
            }
            c.a.t0.g0.f0.l lVar2 = this.K;
            if (lVar2 == null || lVar2.f17600e == null) {
                return;
            }
            if (!U()) {
                c.a.t0.g0.m.a(this.K.f17600e.h0());
                c.a.t0.g0.m.l(this.x, this.K.f17600e.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.v.getPageActivity()).createFromThreadCfg(this.K.f17600e, null, c.a.t0.g0.m.g(), 18003, true, false, false).addLocateParam(this.K.getPbInputLocate());
            addLocateParam.setVideo_source(this.K.Y == 0 ? "index" : "hot_juhe");
            if (this.K.Y == 0) {
                addLocateParam.setFrom("from_personalize");
            }
            addLocateParam.setForumId(String.valueOf(this.K.f17600e.U()));
            addLocateParam.setForumName(this.K.f17600e.b0());
            addLocateParam.setStartFrom(this.l);
            if (view == this.q) {
                addLocateParam.setJumpGodReply(true);
            }
            this.v.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void R() {
        c.a.t0.g0.f0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a0();
            Z();
            if (this.A == null || this.p == null || this.C == null) {
                return;
            }
            if (c.a.s0.s.k.c().g() && (lVar = this.K) != null && (e2Var = lVar.f17600e) != null && e2Var.u1() != null) {
                this.A.setPlaceHolder(3);
                this.A.startLoad(this.K.f17600e.u1().thumbnail_url, 10, false);
                this.p.setVisibility(0);
                stopPlay();
                this.R = this.K.f17600e.u1().video_url;
                if (T()) {
                    this.R = this.K.f17600e.v1().video_url;
                }
                if (StringUtils.isNull(this.K.f17600e.u1().video_url)) {
                    e0(true, 4);
                }
                this.C.getControl().setThreadDataForStatistic(this.K.f17600e);
            } else {
                this.p.setVisibility(8);
            }
            this.m.B();
            this.T.j(new q(this));
        }
    }

    public final void S(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (g() != null) {
                g().a(view, this.K);
            }
            if (!c.a.d.f.p.l.z()) {
                c.a.d.f.p.n.M(this.v.getPageActivity(), R.string.no_network_guide);
            } else {
                M();
            }
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.t0.g0.f0.l lVar = this.K;
            return (lVar == null || (e2Var = lVar.f17600e) == null || e2Var.v1() == null || TextUtils.isEmpty(this.K.f17600e.v1().video_url)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.t0.g0.f0.l lVar = this.K;
            return lVar.W && !lVar.X;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.P : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: W */
    public void k(c.a.t0.g0.f0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, lVar) == null) {
            this.K = lVar;
            X();
        }
    }

    public final void X() {
        e2 e2Var;
        e2 e2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.t0.g0.f0.l lVar = this.K;
            if (lVar != null && (e2Var = lVar.f17600e) != null && e2Var.J() != null) {
                this.w.setVisibility(0);
                R();
                if (!U() && c.a.t0.g0.m.k(this.K.f17600e.h0())) {
                    c.a.t0.g0.m.l(this.x, this.K.f17600e.h0(), R.color.CAM_X0105, R.color.CAM_X0109);
                    c.a.t0.g0.m.l(this.q.getGodReplyContent(), this.K.getThreadData().h0(), R.color.CAM_X0106, R.color.CAM_X0109);
                }
                this.K.getThreadData().h3();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.K.getThreadData().j1());
                if (this.K.getThreadData().i() && !StringUtils.isNull(this.K.getThreadData().w1())) {
                    String str = c.a.s0.s.i0.b.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + this.K.getThreadData().w1();
                    spannableStringBuilder.append((CharSequence) this.K.getThreadData().k(new n(this, 2, str, str)));
                }
                this.x.setOnTouchListener(new c.a.t0.n4.h(spannableStringBuilder));
                this.x.setText(spannableStringBuilder);
                this.y.setData(this.K.getThreadData());
                this.y.setUserAfterClickListener(this.i0);
                if (this.y.getHeaderImg() != null) {
                    this.y.getHeaderImg().setAfterClickListener(this.k0);
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
                        if (this.K.getThreadData().x1 > 0 && this.K.getThreadData().y1 == 0) {
                            this.K.getThreadData().J().setPortrait("http://hiphotos.baidu.com/fex/%70%69%63/item/caef76094b36acafb73a718377d98d1000e99cf3.jpg");
                            this.y.getHeaderImg().setData(this.K.getThreadData(), false);
                        } else {
                            this.y.getHeaderImg().setData(this.K.getThreadData());
                            this.y.getHeaderImg().setOnInterceptClickEventListener(null);
                        }
                    }
                }
                this.D.setText(StringHelper.stringForVideoTime(this.K.f17600e.u1().video_duration.intValue() * 1000));
                this.F.setText(String.format(this.v.getResources().getString(R.string.play_count), StringHelper.numFormatOverWan(this.K.f17600e.u1().play_count.intValue())));
                if (this.s != null && this.K.getThreadData() != null) {
                    x0 x0Var = new x0();
                    x0Var.o(this.K.getThreadData().w1());
                    x0Var.k(this.K.getThreadData().U());
                    x0Var.n(this.K.getThreadData().H0());
                    x0Var.j(this.K.feedBackReasonMap);
                    this.s.setData(x0Var);
                    this.s.setFirstRowSingleColumn(true);
                    this.s.setVisibility(this.Q ? 0 : 8);
                }
                this.q.setData(this.K.getThreadData().z1());
                f0(I(1));
                l(this.v, TbadkCoreApplication.getInst().getSkinType());
                if (c.a.t0.g0.m.k(this.K.f17600e.h0())) {
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(this.x, R.color.CAM_X0105, 1);
                }
                c.a.t0.g0.f0.l lVar2 = this.K;
                if ((lVar2 == null || (e2Var2 = lVar2.f17600e) == null || e2Var2.u1() == null || this.K.f17600e.u1().is_vertical.intValue() != 1) ? false : true) {
                    this.Y.setVisibility(0);
                    if (T()) {
                        this.Y.setText(String.format("%s | %s", this.v.getResources().getString(R.string.nani_video), this.v.getResources().getString(R.string.video_preview)));
                        return;
                    } else {
                        this.Y.setText(this.v.getString(R.string.nani_video));
                        return;
                    }
                } else if (T()) {
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

    public void Y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.q0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.q0);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        d0(bdUniqueId);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.a0.removeMessages(202);
            this.a0.removeMessages(203);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.e0);
            c.a.d.f.m.e.a().removeCallbacks(this.f0);
        }
    }

    public final void b0() {
        c.a.t0.g0.f0.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (lVar = this.K) == null || lVar.f17600e == null) {
            return;
        }
        c.a.t0.a3.t tVar = new c.a.t0.a3.t();
        tVar.a = this.K.Y == 0 ? "index" : "hot_juhe";
        tVar.f15288c = this.K.f17600e.w1();
        tVar.f15289d = this.K.f17600e.U() + "";
        tVar.f15290e = TbadkCoreApplication.getCurrentAccount();
        c.a.t0.g0.f0.l lVar2 = this.K;
        e2 e2Var = lVar2.f17600e;
        tVar.f15291f = e2Var.Z0;
        String str = e2Var.b1;
        tVar.l = str;
        tVar.f15292g = str;
        tVar.f15293h = e2Var.a1;
        tVar.f15294i = "";
        tVar.k = lVar2.k();
        if (this.K.f17600e.u1() != null) {
            tVar.m = this.K.f17600e.u1().video_md5;
        }
        c.a.t0.a3.j.e(this.K.f17600e.u1().video_md5, "", "1", tVar, this.C.getControl().getPcdnState());
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.Q = z;
        }
    }

    @Override // c.a.t0.t.e
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.t = str;
        }
    }

    public final void d0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
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

    public final void e0(boolean z, int i2) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.B == null || this.A == null || this.L == null || this.J == null || this.I == null || this.H == null) {
            return;
        }
        if (z || this.O != i2) {
            this.O = i2;
            c.a.d.f.m.e.a().removeCallbacks(this.f0);
            c.a.d.f.m.e.a().removeCallbacks(this.e0);
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
                c.a.d.f.m.e.a().postDelayed(this.f0, 60000L);
            } else if (i2 == 3) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.U);
                this.L.setVisibility(8);
                this.E.setVisibility(8);
                c.a.t0.g0.f0.l lVar = this.K;
                if (lVar != null && lVar.getThreadData() != null && this.K.getThreadData().x1 > 0) {
                    this.W.setVisibility(0);
                }
                this.J.c();
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                c.a.t0.g0.f0.l lVar2 = this.K;
                if (lVar2 != null && (e2Var = lVar2.f17600e) != null && e2Var.u1() != null) {
                    this.K.f17600e.u1().video_length.intValue();
                    this.K.f17600e.u1().video_duration.intValue();
                    this.K.f17600e.w1();
                }
            } else if (i2 == 4) {
                this.B.setVisibility(8);
                this.A.startAnimation(this.U);
                this.L.setVisibility(8);
                this.J.b();
                this.I.setVisibility(0);
                this.H.setVisibility(0);
                c.a.d.f.m.e.a().postDelayed(this.e0, 2000L);
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
            c.a.t0.g0.f0.l lVar3 = this.K;
            if (lVar3 == null || lVar3.getThreadData() == null || this.K.getThreadData().x1 <= 0) {
                return;
            }
            this.E.setVisibility(8);
        }
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? R.layout.card_home_page_auto_video_view_new : invokeV.intValue;
    }

    public void f0(int i2) {
        c.a.t0.g0.f0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (lVar = this.K) == null || (e2Var = lVar.f17600e) == null) {
            return;
        }
        if (i2 == 1) {
            if (e2Var.x1 > 0) {
                this.u.mSharePraiseView.setShowPraiseNum(false);
                this.u.mSharePraiseView.setShareVisible(false);
                this.W.setText(StringHelper.numFormatOverWan(this.K.f17600e.x1));
                this.W.setVisibility(0);
            } else {
                this.u.mSharePraiseView.setShowPraiseNum(true);
                this.u.mSharePraiseView.setShareVisible(true);
                this.W.setVisibility(8);
            }
            this.u.setData(this.K.f17600e);
            this.n.setVisibility(8);
            this.y.showForumNameView(false);
            return;
        }
        this.u.setVisibility(8);
        this.y.showForumNameView(true);
        if (this.K.f17600e.x1 > 0) {
            this.n.setShowPraiseNum(false);
            this.n.setShareVisible(false);
            this.W.setText(StringHelper.numFormatOverWan(this.K.f17600e.x1));
            this.W.setVisibility(0);
        } else {
            this.n.setShowPraiseNum(true);
            this.n.setShareVisible(true);
            this.W.setVisibility(8);
        }
        if (this.n.setData(this.K.f17600e)) {
            this.o.setVisibility(8);
        } else {
            this.o.setVisibility(0);
        }
    }

    public final void g0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (tbVideoViewContainer = this.C) == null || tbVideoViewContainer.getControl() == null || !this.P) {
            return;
        }
        try {
            this.C.getControl().start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int c2 = c.a.t0.a3.s.d().c(this.R);
        this.V = (c2 <= 100 || this.C.getControl().getDuration() <= c2) ? 100 : 100;
        this.a0.sendEmptyMessageDelayed(202, 20L);
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return 0;
            }
            return this.C.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public final void h0(c.a.t0.g0.f0.l lVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, lVar) == null) || lVar == null || (e2Var = lVar.f17600e) == null || e2Var.h0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, e2Var.h0()));
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer == null) {
                return false;
            }
            return tbVideoViewContainer.getControl().isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048608, this, tbPageContext, i2) == null) || this.M == i2) {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e2 e2Var;
        e2 e2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            c.a.t0.g0.f0.l lVar = this.K;
            if (lVar != null && (e2Var2 = lVar.f17600e) != null && e2Var2.x1 > 0) {
                if (g() != null) {
                    g().a(view, this.K);
                }
                this.v.sendMessage(new CustomMessage(2002001, new VideoAggregationActivityConfig(this.v.getPageActivity(), this.K.f17600e.w1(), VideoAggregationActivityConfig.TYPE_FROM_VIDEO_CARD, c.a.t0.g0.m.g(), this.K.getPbInputLocate())));
                return;
            }
            if (view == this.w || view == this.q) {
                Q(view);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016497, null));
            }
            if (view == this.C) {
                c.a.t0.g0.f0.l lVar2 = this.K;
                if (lVar2 != null) {
                    lVar2.k = 5;
                }
                c.a.t0.g0.f0.l lVar3 = this.K;
                boolean z = false;
                if (lVar3 != null && (e2Var = lVar3.f17600e) != null && e2Var.u1() != null && this.K.f17600e.u1().is_vertical.intValue() == 1) {
                    z = true;
                }
                if (z) {
                    P(this.C);
                } else if (UtilHelper.isGotoVideoMiddlePage()) {
                    S(this.C);
                } else {
                    Q(j());
                }
            }
        }
    }

    @Override // c.a.t0.g0.b
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.Z = str;
        }
    }

    public void startPlay() {
        c.a.t0.g0.f0.l lVar;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.P || (lVar = this.K) == null || (e2Var = lVar.f17600e) == null || e2Var.u1() == null || this.C == null) {
            return;
        }
        if (this.m.r()) {
            this.m.E();
            this.X = true;
            return;
        }
        this.X = false;
        this.C.getControl().stopPlayback();
        if (t0.b(1, this.R)) {
            e0(true, 2);
            if (StringUtils.isNull(this.R)) {
                TiebaStatic.log(new StatisticItem("c12619").param("obj_locate", "index").param("tid", this.K.l));
                this.R = this.K.f17600e.u1().video_url;
            }
            this.P = true;
            this.C.getControl().setVideoPath(this.R, this.K.l);
            c.a.t0.a3.h hVar = this.T;
            if (hVar != null) {
                hVar.m();
            }
            b0();
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.X = false;
            a0();
            Z();
            e0(true, 1);
            TbVideoViewContainer tbVideoViewContainer = this.C;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().stopPlayback();
                c.a.t0.a3.h hVar = this.T;
                if (hVar != null) {
                    hVar.n();
                }
            }
            this.P = false;
            this.m.L();
        }
    }
}
