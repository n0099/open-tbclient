package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadlinesAgreeCardView;
import com.baidu.card.view.HeadlinesCardView;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ar6;
import com.baidu.tieba.be5;
import com.baidu.tieba.de5;
import com.baidu.tieba.ds7;
import com.baidu.tieba.ee7;
import com.baidu.tieba.f55;
import com.baidu.tieba.iw4;
import com.baidu.tieba.jm6;
import com.baidu.tieba.nua;
import com.baidu.tieba.o55;
import com.baidu.tieba.oq6;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.rd;
import com.baidu.tieba.rh5;
import com.baidu.tieba.sr7;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tl6;
import com.baidu.tieba.to5;
import com.baidu.tieba.tr7;
import com.baidu.tieba.ub5;
import com.baidu.tieba.uc5;
import com.baidu.tieba.ut5;
import com.baidu.tieba.uua;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.xq6;
import com.baidu.tieba.xt9;
import com.baidu.tieba.yo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class ThreadCommentAndPraiseInfoLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public TBLottieAnimationView B;
    public ThreadData C;
    public Context D;
    public TbPageContext E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public String f1076T;
    public int U;
    public String V;
    public String W;
    public int a;
    public String a0;
    public TextView b;
    public View.OnClickListener b0;
    public TextView c;
    public int c0;
    public boolean d;
    public View d0;
    public AgreeView e;
    public MaskView e0;
    public EMTextView f;
    public o f0;
    public ImageView g;
    public LinearLayout g0;
    public EMTextView h;
    public n h0;
    public View i;
    public boolean i0;
    public EMTextView j;
    public boolean j0;
    public ImageView k;
    public View l;
    public FrameLayout m;
    public ImageView n;
    public EMTextView o;
    public ImageView p;
    public View q;
    public jm6 r;
    public final ar6<HeadlinesAgreeCardView.c> r0;
    public LinearLayout s;
    public final ar6<HeadlinesCardView.e> s0;
    public ImageView t;
    public Runnable t0;
    public EMTextView u;
    public CustomMessageListener u0;
    public LinearLayout v;
    public CustomMessageListener v0;
    public ImageView w;
    public EMTextView x;
    public ImageView y;
    public EMTextView z;

    /* loaded from: classes4.dex */
    public interface n {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes4.dex */
    public interface o {
        void a(boolean z);
    }

    public void C(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void G(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
        }
    }

    public void H(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
        }
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
        }
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
        }
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements AgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f55 a;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* loaded from: classes4.dex */
        public class a implements be5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.be5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.b.setAgreeNumViewIsShow(false);
                Rect rect = new Rect();
                this.a.b.e.getImgAgree().getGlobalVisibleRect(rect);
                this.a.a.i(false);
                TbPageContext tbPageContext = this.a.b.E;
                if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                    g gVar = this.a;
                    gVar.a.j(gVar.b.E.getPageActivity().findViewById(16908290), list, rect);
                }
            }
        }

        public g(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, f55 f55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, f55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = threadCommentAndPraiseInfoLayout;
            this.a = f55Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f55 f55Var = this.a;
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.b;
                f55Var.k(threadCommentAndPraiseInfoLayout.g0, threadCommentAndPraiseInfoLayout.e);
                de5.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.b.setAgreeNumViewIsShow(true);
            this.a.h(this.b.e);
            this.a.l();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public b(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
                threadCommentAndPraiseInfoLayout.Q(threadCommentAndPraiseInfoLayout.C);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public c(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.W();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ar6<HeadlinesAgreeCardView.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(@NonNull HeadlinesAgreeCardView.c cVar) {
            ThreadData threadData;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cVar) != null) || (threadData = this.b.C) == null || !StringHelper.equals(threadData.tid, cVar.b()) || (agreeData = this.b.C.getAgreeData()) == null) {
                return;
            }
            if (agreeData.hasAgree) {
                Animator.AnimatorListener a = cVar.a();
                if (a != null) {
                    a.onAnimationEnd(null);
                    return;
                }
                return;
            }
            this.b.manualPraise(cVar.a());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ar6<HeadlinesCardView.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(@NonNull HeadlinesCardView.e eVar) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && (threadData = (threadCommentAndPraiseInfoLayout = this.b).C) != null && threadCommentAndPraiseInfoLayout.l != null && StringHelper.equals(threadData.tid, eVar.a())) {
                this.b.l.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public f(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !PraiseSwitch.isOn() || this.a.e.J()) {
                return;
            }
            if (this.a.b0 != null) {
                this.a.b0.onClick(view2);
            }
            if (!WindowGreySwitch.getIsOnNew()) {
                this.a.g(view2);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.j(view2, threadCommentAndPraiseInfoLayout.C);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public h(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.y.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public i(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public j(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public k(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B != null) {
                this.a.B.setVisibility(8);
                this.a.B.pauseAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public l(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.y.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            super(2921416);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(threadCommentAndPraiseInfoLayout);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (threadCommentAndPraiseInfoLayout = this.a.get()) == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ThreadData)) {
                return;
            }
            ThreadData threadData = (ThreadData) customResponsedMessage.getData();
            if (threadCommentAndPraiseInfoLayout.C != null && threadData != null) {
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (threadCommentAndPraiseInfoLayout.C.getBaijiahaoData() != null) {
                    str2 = threadCommentAndPraiseInfoLayout.C.getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        threadCommentAndPraiseInfoLayout.C.setReply_num(threadData.getReply_num());
                        threadCommentAndPraiseInfoLayout.Q(threadData);
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = threadCommentAndPraiseInfoLayout.C.getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    threadCommentAndPraiseInfoLayout.C.setReply_num(threadData.getReply_num());
                    if (threadCommentAndPraiseInfoLayout.Q != 1 || !threadCommentAndPraiseInfoLayout.C.isVideoThreadType()) {
                        threadCommentAndPraiseInfoLayout.Q(threadData);
                    } else {
                        threadCommentAndPraiseInfoLayout.P = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            super(2921417);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(threadCommentAndPraiseInfoLayout);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (threadCommentAndPraiseInfoLayout = this.a.get()) == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str) && (threadData = threadCommentAndPraiseInfoLayout.C) != null && !"0".equals(threadData.getId()) && str.equals(threadCommentAndPraiseInfoLayout.C.getId())) {
                if ((threadCommentAndPraiseInfoLayout.C.isLiveThread() || threadCommentAndPraiseInfoLayout.C.isSharedLiveThread()) && threadCommentAndPraiseInfoLayout.C.getThreadAlaInfo() != null) {
                    if (threadCommentAndPraiseInfoLayout.C.getThreadAlaInfo() != null && threadCommentAndPraiseInfoLayout.C.getThreadAlaInfo().share_info != null) {
                        threadCommentAndPraiseInfoLayout.C.getThreadAlaInfo().share_info.share_count++;
                    }
                } else {
                    ThreadData threadData2 = threadCommentAndPraiseInfoLayout.C;
                    threadData2.setShareNum(threadData2.getShareNum() + 1);
                }
                threadCommentAndPraiseInfoLayout.T(threadCommentAndPraiseInfoLayout.C);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCommentAndPraiseInfoLayout(Context context) {
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
        BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.O = true;
        this.P = false;
        this.Q = 2;
        this.R = 1;
        this.c0 = 3;
        this.f0 = null;
        this.i0 = true;
        this.j0 = false;
        this.r0 = new d(this, HeadlinesAgreeCardView.c.class);
        this.s0 = new e(this, HeadlinesCardView.e.class);
        this.t0 = new k(this);
        this.u0 = new m(this);
        this.v0 = new p(this);
        s(context);
    }

    public final void B(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (threadData = this.C) != null && !StringUtils.isNull(threadData.getForum_name())) {
            if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.a0)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.D).createCfgForpersonalized(this.C.getForum_name(), this.W, this.a0)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.D).createNormalCfg(this.C.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
            View.OnClickListener onClickListener = this.b0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void J(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.D)) || this.C == null) {
                return;
            }
            K();
            j(view2, this.C);
            if (this.C.isDisableShare()) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    new BdTopToast(getContext()).setIcon(false).setContent(this.C.getDisableShareToast()).show((ViewGroup) currentActivity.findViewById(16908290));
                }
            } else if (AntiHelper.e(getContext(), this.C)) {
            } else {
                ub5.f(this.D, this.C, this.R, this.Q);
                View.OnClickListener onClickListener = this.b0;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    public void T(ThreadData threadData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) && (view2 = this.l) != null && this.j != null && threadData != null) {
            if (this.K) {
                view2.setVisibility(0);
                long shareNum = threadData.getShareNum();
                if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                    shareNum = threadData.getThreadAlaInfo().share_info.share_count;
                }
                String string = this.D.getString(R.string.obfuscated_res_0x7f0f13d7);
                if (shareNum > 0 && !threadData.isDisableShare()) {
                    string = StringHelper.numFormatOverWan(shareNum);
                }
                this.j.setText(string);
                this.F = true;
                updateShareStateUI(threadData);
                return;
            }
            view2.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            ThreadData threadData = this.C;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                return;
            }
            if (view2 == this.b) {
                B(view2);
            } else if (view2 == this.i) {
                D(view2);
                int i2 = this.Q;
                if (i2 == 1 || i2 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.l) {
                J(view2);
                int i3 = this.Q;
                if (i3 == 1 || i3 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.n) {
                G(view2);
            } else if (view2 == this.q) {
                F(view2);
            } else if (view2 == this.y) {
                I(view2);
            } else if (view2 == this.s) {
                H(view2);
            } else if (view2 == this.v) {
                C(view2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
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
        BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.O = true;
        this.P = false;
        this.Q = 2;
        this.R = 1;
        this.c0 = 3;
        this.f0 = null;
        this.i0 = true;
        this.j0 = false;
        this.r0 = new d(this, HeadlinesAgreeCardView.c.class);
        this.s0 = new e(this, HeadlinesCardView.e.class);
        this.t0 = new k(this);
        this.u0 = new m(this);
        this.v0 = new p(this);
        s(context);
    }

    public final void r(View view2, uc5 uc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048624, this, view2, uc5Var) == null) && view2 != null && view2.getVisibility() == 0) {
            oq6 oq6Var = new oq6(this.E, view2);
            oq6Var.L(R.drawable.bg_tip_blue_dropdown);
            ThemeColorInfo themeColorInfo = null;
            if (rh5.b().a() != null) {
                themeColorInfo = rh5.b().a().f;
            }
            oq6Var.M(SkinManager.getColorFromServerColor(themeColorInfo, R.color.CAM_X0301));
            oq6Var.J(R.dimen.T_X08);
            oq6Var.l(2);
            oq6Var.o(32);
            oq6Var.x(true);
            oq6Var.Q(0);
            oq6Var.R(BdUtilHelper.getDimens(getContext(), R.dimen.tbds10));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            oq6Var.E(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds23), dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds40));
            String string = TbadkCoreApplication.getInst().getString(R.string.spring_festival_home_reply);
            if (!TextUtils.isEmpty(uc5Var.e)) {
                string = uc5Var.e;
            }
            oq6Var.T(string, ee7.a("springfestival", "home_reply"));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCommentAndPraiseInfoLayout(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.O = true;
        this.P = false;
        this.Q = 2;
        this.R = 1;
        this.c0 = 3;
        this.f0 = null;
        this.i0 = true;
        this.j0 = false;
        this.r0 = new d(this, HeadlinesAgreeCardView.c.class);
        this.s0 = new e(this, HeadlinesCardView.e.class);
        this.t0 = new k(this);
        this.u0 = new m(this);
        this.v0 = new p(this);
        this.d = z;
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgreeNumViewIsShow(boolean z) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65550, this, z) == null) && (agreeView = this.e) != null && agreeView.getAgreeNumView() != null) {
            if (z) {
                this.e.getAgreeNumView().setVisibility(0);
            } else {
                this.e.getAgreeNumView().setVisibility(4);
            }
        }
    }

    public final boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if ((i2 & this.a) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void L(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            this.b.setVisibility(8);
        }
    }

    public void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            EMTextView eMTextView = this.x;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0c89);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void P(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, threadData) != null) || threadData == null || this.Q != 13) {
            return;
        }
        boolean z = true;
        if (threadData.isAuthorView != 1) {
            z = false;
        }
        showOperationMaskView(z);
    }

    public void addPraiseStats(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (this.C == null && i2 < 0) {
                return;
            }
            StatisticItem h2 = h(i2);
            h2.param("thread_type", this.C.getThreadType());
            TiebaStatic.log(h2);
        }
    }

    public View l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, context)) == null) {
            return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        }
        return (View) invokeL.objValue;
    }

    public void manualPraise(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public final boolean n(@NonNull ThreadData threadData) {
        InterceptResult invokeL;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, threadData)) == null) {
            if (threadData.getType() != ThreadData.TYPE_FAKE_VIDEO && ((originalThreadInfo = threadData.originalThreadData) == null || (!originalThreadInfo.m && !threadData.shouldShowBlockedState()))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAgreeStatisticData(iw4 iw4Var) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, iw4Var) == null) && (agreeView = this.e) != null) {
            agreeView.setStatisticData(iw4Var);
        }
    }

    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, threadData) == null) && threadData != null && threadData.isUgcThreadType()) {
            this.e.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.H = z;
            TextView textView = this.b;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && (linearLayout = this.v) != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setCommentClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048632, this, z) == null) && (view2 = this.i) != null) {
            view2.setClickable(z);
            this.g.setEnabled(z);
            this.f.setEnabled(z);
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, context) == null) {
            this.D = context;
            if (this.E == null) {
                if (context instanceof BaseActivity) {
                    this.E = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.E = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.Q = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.U = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.i0 = z;
        }
    }

    public void setIsPbFirst(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.N = z;
        }
    }

    public void setJumpToVideoFromOuter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.j0 = z;
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.L = z;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.I = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.O = z;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setNeedMatchStrategy(z);
            }
        }
    }

    public void setOnCommentClickCallback(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, nVar) == null) {
            this.h0 = nVar;
        }
    }

    public void setOnSelectStatusChangeListener(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, oVar) == null) {
            this.f0 = oVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (linearLayout = this.s) != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setReplyTimeVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.G = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            this.M = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048656, this, z) == null) && (view2 = this.l) != null) {
            view2.setClickable(z);
            this.k.setEnabled(z);
            this.j.setEnabled(z);
        }
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.R = i2;
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            this.a = i2;
            q();
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            this.W = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.V = str;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.a0 = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            if (z && this.e0 == null) {
                MaskView maskView = new MaskView(getContext());
                this.e0 = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.e0;
            if (maskView2 != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                maskView2.setVisibility(i2);
            }
        }
    }

    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048677, this, threadData) != null) || threadData == null) {
            return;
        }
        setShareClickable(n(threadData));
        boolean o2 = o(threadData);
        o55.h(this.k, R.drawable.icon_pure_card_share20, o2);
        o55.i(this.j, o2);
    }

    public final boolean z(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048680, this, threadData)) == null) {
            if (threadData != null && threadData.isVideoThreadType() && threadData.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private RelativeLayout.LayoutParams getGuideLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.D, R.dimen.tbds715), BdUtilHelper.getDimens(this.D, R.dimen.tbds110));
            layoutParams.setMargins(0, 0, BdUtilHelper.getEquipmentWidth(this.D) / 6, 0);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ThreadData threadData = this.C;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (this.C.isBJHVideoThreadType()) {
                return 2;
            }
            if (this.C.isBJHNormalThreadType()) {
                return 3;
            }
            if (!this.C.isBJHVideoDynamicThreadType()) {
                return 0;
            }
            return 4;
        }
        return invokeV.intValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
            int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
            if (threadSourceForDynamicAndBjh > 0 && threadTypeForDynamicAndBjh > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                statisticItem.param("obj_source", threadSourceForDynamicAndBjh);
                statisticItem.param("obj_type", threadTypeForDynamicAndBjh);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.u0);
            MessageManager.getInstance().registerListener(this.v0);
            xq6.b().b(this, this.r0);
            xq6.b().b(this, this.s0);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048671, this) == null) && this.B != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.B.setImageAssetsFolder("lottie_friend_bot_guide_right_img_dark");
            } else {
                this.B.setImageAssetsFolder("lottie_friend_bot_guide_right_img");
            }
            SkinManager.setLottieAnimation(this.B, R.raw.lottie_friend_bot_guide_right);
        }
    }

    public void updateReplyStateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            if (this.I) {
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            this.g.setEnabled(!o55.a(this.C));
            o55.b(this.g, R.drawable.icon_pure_card_comment20);
            o55.f(this.f);
            o55.i(this.f, o55.a(this.C));
        }
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            TbPageContext tbPageContext = this.E;
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    private int getThreadSourceForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            int i2 = this.Q;
            if (i2 == 4 || i2 == 9) {
                return 1;
            }
            if (i2 == 1) {
                return 2;
            }
            if (i2 != 8 && i2 != 13) {
                return 0;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.C == null) {
            return;
        }
        StatisticItem i2 = i();
        i2.param("thread_type", this.C.getThreadType());
        TiebaStatic.log(i2);
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            o55.c(this.g0);
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            onClick(this.y);
        }
    }

    public AgreeView getAgreeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.e;
        }
        return (AgreeView) invokeV.objValue;
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.e.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.K = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.F;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            jm6 jm6Var = this.r;
            if (jm6Var != null) {
                jm6Var.T();
            }
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.e.setAfterClickListener(null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            xq6.b().a(this);
        }
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.K = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = this.D.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.g.setLayoutParams(layoutParams);
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setNeedAddReplyIcon(true);
            setShareVisible(true);
        }
    }

    public void setUseDynamicLikeRes() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048664, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeRes();
        }
    }

    public void setUseDynamicLikeResImmediately() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeResImmediately();
        }
    }

    public void showFestivalCommentTip() {
        uc5 a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && (a2 = rh5.b().a()) != null) {
            r(this.i, a2);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.D);
            this.B = tBLottieAnimationView;
            addView(tBLottieAnimationView, getGuideLayoutParams());
            u();
            this.B.setVisibility(8);
        }
    }

    public void updateReplyNumDelay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048675, this) != null) || !this.P) {
            return;
        }
        this.P = false;
        SafeHandler.getInst().post(new b(this));
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            y(l(this.D));
        }
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            ThreadData threadData = this.C;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isShareThread) {
                return 4;
            }
            if (threadData.getThreadType() != 49 && this.C.getThreadType() != 69) {
                if (this.C.getThreadVideoInfo() != null) {
                    return 1;
                }
                if (this.C.getType() != ThreadData.TYPE_NORMAL && this.C.getType() != ThreadData.TYPE_GOD_NORMAL) {
                    return 0;
                }
                if (ListUtils.getCount(this.C.getVoice()) > 0) {
                    return 3;
                }
                return 2;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public void updateManagerUI() {
        int color;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.o;
            ThreadData threadData = this.C;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = uua.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.p;
            ThreadData threadData2 = this.C;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                z = false;
            } else {
                z = true;
            }
            imageView.setEnabled(z);
        }
    }

    public void D(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (threadData = this.C) != null && this.D != null && !threadData.isBusinessMixThread()) {
            int i2 = this.Q;
            if (i2 == 2 || i2 == 13) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(this.C.getFid())));
            }
            tl6.a(this.C.getTid());
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", this.Q);
            statisticItem.param("obj_type", getThreadType());
            statisticItem.param("tid", this.C.getTid());
            statisticItem.param("nid", this.C.getNid());
            if (this.Q == 18) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.C.getFid());
                statisticItem.param("resource_id", this.V);
            }
            to5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
            if (this.C.getVoiceRoomData() != null && this.C.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.C.getVoiceRoomData().room_name)) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(this.E, this.C.getVoiceRoomData().room_id.longValue());
            } else if (this.C.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.C.getThreadVideoInfo().video_url)) {
                p(this.D, this.C);
                n nVar = this.h0;
                if (nVar != null) {
                    nVar.a(null);
                }
            } else {
                PbActivityConfig addLocateParam = new PbActivityConfig(this.D).createFromThreadCfg(this.C, null, this.W, 0, true, false, false).addLocateParam("");
                addLocateParam.setForumId(String.valueOf(this.C.getFid()));
                addLocateParam.setForumName(this.C.getForum_name());
                if (this.C.getIsDailyThread() && this.C.getForumData() != null) {
                    addLocateParam.setForumId(this.C.getForumData().b());
                    addLocateParam.setForumName(this.C.getForumData().d());
                }
                addLocateParam.setJumpToCommentArea(true);
                n nVar2 = this.h0;
                if (nVar2 != null) {
                    nVar2.a(addLocateParam);
                }
                if (TbSingleton.getInstance().isPbPreloadSwitchOn() && z(this.C)) {
                    addLocateParam.setNeedPreLoad(true);
                    ds7.e(this.C);
                }
                if (this.C.isQualityReplyThread) {
                    addLocateParam.setFromHomePageQuality(true);
                }
                if (this.C.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
                    addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
                }
                addLocateParam.setStartFrom(this.S);
                if (this.C.isSimilarPageType()) {
                    addLocateParam.setSimilarFrom(2);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            }
            StatisticItem statisticItem2 = new StatisticItem("c12291");
            statisticItem2.param("obj_locate", this.Q);
            TiebaStatic.log(statisticItem2);
            k();
            j(view2, this.C);
            View.OnClickListener onClickListener = this.b0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, view2) == null) {
            this.b = (TextView) view2.findViewById(R.id.thread_info_bar_name);
            this.c = (TextView) view2.findViewById(R.id.thread_info_reply_time);
            this.g0 = (LinearLayout) view2.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.thread_info_commont_num);
            this.f = eMTextView;
            EMManager.from(eMTextView).setTextStyle(R.string.F_X01);
            this.g = (ImageView) view2.findViewById(R.id.thread_info_commont_img);
            this.h = (EMTextView) view2.findViewById(R.id.thread_info_commont_grab_sofa);
            this.i = view2.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.share_num);
            this.j = eMTextView2;
            EMManager.from(eMTextView2).setTextSize(R.dimen.tbds36).setTextStyle(R.string.F_X01);
            ImageView imageView = (ImageView) view2.findViewById(R.id.share_num_img);
            this.k = imageView;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds52);
                layoutParams.height = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds52);
                this.k.setLayoutParams(layoutParams);
            }
            this.l = view2.findViewById(R.id.share_num_container);
            this.m = (FrameLayout) view2.findViewById(R.id.btn_card_bottom_op_more_container);
            this.n = (ImageView) view2.findViewById(R.id.btn_card_bottom_op_more);
            View findViewById = view2.findViewById(R.id.new_agree_view);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.e = agreeView;
                agreeView.setIsAgreeNumClick(true);
                this.e.setAfterClickListener(new f(this));
                this.e.setUseLikeDefaultRes(this.d);
                this.e.setAgreeLongClickListener(new g(this, new f55(this.D)));
            }
            this.q = view2.findViewById(R.id.manage_view_container);
            EMTextView eMTextView3 = (EMTextView) view2.findViewById(R.id.thread_info_manage_text);
            this.o = eMTextView3;
            EMManager.from(eMTextView3).setTextStyle(R.string.F_X01);
            this.p = (ImageView) view2.findViewById(R.id.thread_info_manage_img);
            this.y = (ImageView) view2.findViewById(R.id.manage_select_img);
            EMTextView eMTextView4 = (EMTextView) view2.findViewById(R.id.manage_select_text);
            this.z = eMTextView4;
            EMManager.from(eMTextView4).setTextStyle(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.manage_select_container);
            this.A = linearLayout;
            linearLayout.setOnTouchListener(new h(this));
            this.z.setOnClickListener(new i(this));
            this.s = (LinearLayout) view2.findViewById(R.id.qq_share_container);
            this.t = (ImageView) view2.findViewById(R.id.qq_share_image);
            EMTextView eMTextView5 = (EMTextView) view2.findViewById(R.id.qq_share_text);
            this.u = eMTextView5;
            if (eMTextView5 != null) {
                EMManager.from(eMTextView5).setTextStyle(R.string.F_X01);
            }
            this.v = (LinearLayout) view2.findViewById(R.id.collect_num_container);
            this.w = (ImageView) view2.findViewById(R.id.collect_num_image);
            EMTextView eMTextView6 = (EMTextView) view2.findViewById(R.id.collect_num_text);
            this.x = eMTextView6;
            if (eMTextView6 != null) {
                EMManager.from(eMTextView6).setTextStyle(R.string.F_X01);
            }
            this.A.setOnClickListener(new j(this));
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.y.setOnClickListener(this);
            LinearLayout linearLayout2 = this.s;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(this);
            }
            LinearLayout linearLayout3 = this.v;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(this);
            }
            t();
        }
    }

    public void F(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (this.r == null) {
                this.r = new jm6(this.E, A(16));
            }
            this.r.f0(this.C);
            this.r.l();
            if (this.C != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.C.getFid()).param("tid", this.C.getId()));
            }
        }
    }

    public void O(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) && this.q != null && threadData != null) {
            int i2 = 4;
            this.L = A(4);
            if (threadData.mOriginalForumInfo != null) {
                this.L = false;
            }
            if (this.L && ((linearLayout = this.A) == null || linearLayout.getVisibility() == 8)) {
                this.q.setVisibility(0);
                this.F = true;
            } else {
                View view2 = this.q;
                if (!A(64)) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
            updateManagerUI();
        }
    }

    public final void R(ThreadData threadData) {
        String replyTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) && this.c != null && threadData != null) {
            if (threadData.getLast_time_int() > 0 && this.G) {
                this.c.setVisibility(0);
                if (this.Q == 3) {
                    replyTime = threadData.getReplyTimeForMyThread();
                } else {
                    replyTime = threadData.getReplyTime();
                }
                this.c.setText(replyTime);
                this.F = true;
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public boolean setData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, threadData)) == null) {
            int i2 = 0;
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.C = threadData;
            N();
            L(threadData);
            R(threadData);
            Q(threadData);
            M(threadData);
            T(threadData);
            updatePraiseNum(threadData);
            S(threadData);
            O(threadData);
            if (!this.F) {
                i2 = 8;
            }
            setVisibility(i2);
            P(threadData);
            E();
            return this.F;
        }
        return invokeL.booleanValue;
    }

    public void I(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && this.y != null && (threadData = this.C) != null && this.z != null && !threadData.isTransportThread()) {
            boolean z = true;
            if (!this.C.isMarkToDel() && tr7.f().i()) {
                if (tr7.f().a(this.C)) {
                    this.C.setMarkToDel(true);
                }
            } else if (!this.C.isMarkToMove() && sr7.h().j()) {
                if (sr7.h().a(this.C)) {
                    this.C.setMarkToMove(true);
                }
            } else {
                tr7.f().l(this.C);
                this.C.setMarkToDel(false);
                sr7.h().l(this.C);
                this.C.setMarkToMove(false);
            }
            if (!this.C.isMarkToDel() && !this.C.isMarkToMove()) {
                EMManager.from(this.z).setTextSelectorColor(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            o oVar = this.f0;
            if (oVar != null) {
                if (!this.C.isMarkToDel() && !this.C.isMarkToMove()) {
                    z = false;
                }
                oVar.a(z);
            }
        }
    }

    public void S(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) && this.A != null && this.y != null && this.z != null && threadData != null) {
            if (!this.i0) {
                View view2 = this.d0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.A.setVisibility(8);
            } else if (this.M && !A(128) && (tr7.f().i() || sr7.h().j())) {
                if (this.d0 == null) {
                    View view3 = new View(getContext());
                    this.d0 = view3;
                    SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                    addView(this.d0);
                    this.d0.setAlpha(0.5f);
                    this.d0.setOnTouchListener(new l(this));
                    this.d0.setOnClickListener(new a(this));
                }
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d0.getLayoutParams();
                if (layoutParams == null) {
                    this.d0.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, -1));
                } else {
                    layoutParams.width = equipmentWidth;
                    requestLayout();
                }
                if (!this.C.isMarkToDel() && !this.C.isMarkToMove()) {
                    EMManager.from(this.z).setTextSelectorColor(R.color.CAM_X0107);
                    WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                    WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                }
                this.d0.setVisibility(0);
                this.A.setVisibility(8);
            } else {
                View view4 = this.d0;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                this.A.setVisibility(8);
            }
        }
    }

    public void g(@NonNull View view2) {
        TbPageContext tbPageContext;
        int dimens;
        int dimens2;
        int width;
        int dimens3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, view2) == null) && this.e.getData() != null && this.e.getData().hasAgree && (tbPageContext = this.E) != null && tbPageContext.getPageActivity() != null && this.e.getImgAgree() != null) {
            if (!this.N || (this.e.getAgreeFlag() && !this.e.K())) {
                PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getContext());
                int[] iArr = new int[2];
                this.e.getImgAgree().getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (this.N) {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
                } else {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds600);
                }
                if (this.N) {
                    dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07090f);
                } else {
                    dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                }
                int i4 = (int) ((dimens2 * 1) / 1.45d);
                if (i2 > i4) {
                    width = ((i2 - i4) + (this.e.getImgAgree().getWidth() / 2)) - 10;
                } else {
                    width = (i2 - i4) + (this.e.getImgAgree().getWidth() / 2);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens);
                layoutParams.leftMargin = width;
                if (this.N) {
                    dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
                } else {
                    dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                layoutParams.topMargin = dimens3;
                pbFirstFloorDoubleClickAnimation.setLottieHeight(dimens);
                pbFirstFloorDoubleClickAnimation.setLayoutParmas(layoutParams);
                pbFirstFloorDoubleClickAnimation.setClippingEnable(false);
                pbFirstFloorDoubleClickAnimation.showFireworks(this.O, this.E.getPageActivity().findViewById(16908290), 0, i3 - 10, this.C.getTid(), String.valueOf(this.C.getFid()));
                pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new c(this));
            }
        }
    }

    public final StatisticItem h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
            if (this.C == null && i2 < 0) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("c12003");
            statisticItem.param("tid", this.C.getTid());
            if (this.C.getThreadType() == 40) {
                statisticItem.param("obj_param1", "2");
            } else if (this.C.getThreadType() == 0) {
                statisticItem.param("obj_param1", "1");
            }
            statisticItem.param("obj_source", "1");
            statisticItem.param("fid", this.C.getFid());
            statisticItem.param("obj_locate", this.Q);
            statisticItem.param("obj_id", i2);
            if (!rd.isEmpty(this.f1076T)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.f1076T);
            }
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            }
            statisticItem.param("nid", this.C.getNid());
            statisticItem.param("card_type", this.C.getRecomCardType());
            statisticItem.param("recom_source", this.C.mRecomSource);
            statisticItem.param("ab_tag", this.C.mRecomAbTag);
            statisticItem.param("weight", this.C.mRecomWeight);
            statisticItem.param("extra", this.C.mRecomExtra);
            if (this.C.getBaijiahaoData() != null && !rd.isEmpty(this.C.getBaijiahaoData().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.C.getBaijiahaoData().oriUgcVid);
            }
            to5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            return statisticItem;
        }
        return (StatisticItem) invokeI.objValue;
    }

    public void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) && this.f != null && threadData != null) {
            if (this.J) {
                this.i.setVisibility(0);
                if (threadData.getReply_num() > 0 && !threadData.isBusinessMixThread()) {
                    this.f.setVisibility(0);
                    String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                    if (this.I) {
                        updateReplyStateUI();
                        this.f.setText(numFormatOverWan);
                    } else {
                        this.f.setText(String.format(this.D.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    EMTextView eMTextView = this.f;
                    eMTextView.setContentDescription(this.D.getString(R.string.reply_num) + numFormatOverWan);
                    this.F = true;
                    return;
                } else if (this.I) {
                    updateReplyStateUI();
                    this.f.setText(this.D.getString(R.string.action_comment_default));
                    this.f.setVisibility(0);
                    this.F = true;
                    return;
                } else {
                    this.f.setVisibility(8);
                    return;
                }
            }
            this.i.setVisibility(8);
        }
    }

    public void updatePraiseNum(ThreadData threadData) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, threadData) == null) {
            setAgreeViewType(threadData);
            if (threadData.getAgreeData() != null) {
                threadData.getAgreeData().isInThread = true;
                this.e.setCardType(threadData.getRecomCardType());
                this.e.setThreadData(threadData);
                this.e.setData(threadData.getAgreeData());
            }
            AgreeView agreeView = this.e;
            ThreadData threadData2 = this.C;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
            } else {
                f2 = 1.0f;
            }
            agreeView.setAlpha(f2);
            if (!this.e.I() && this.e.getFriendBotView() != null && this.B.getVisibility() != 0 && threadData.getCallRobotEntrance() != null && xt9.c()) {
                u();
                this.B.setVisibility(0);
                this.B.playAnimation();
                this.e.getFriendBotView().t();
                SafeHandler.getInst().removeCallbacks(this.t0);
                SafeHandler.getInst().postDelayed(this.t0, 4000L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.g0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final StatisticItem i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.C == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.R;
            if (i3 == 1) {
                i2 = 4;
            } else if (i3 == 2) {
                i2 = 5;
            } else if (i3 == 3) {
                i2 = 3;
            } else if (i3 == 4) {
                i2 = 2;
            } else if (i3 == 6) {
                i2 = 8;
            } else if (i3 == 7) {
                i2 = 9;
            } else if (i3 == 9) {
                i2 = 10;
            } else if (i3 == 10) {
                i2 = 17;
            } else if (i3 == 18) {
                i2 = 20;
            } else if (i3 == 11) {
                i2 = 26;
            } else if (i3 == 12) {
                i2 = 25;
            } else if (i3 == 13) {
                i2 = 27;
            } else if (i3 == 14) {
                i2 = 30;
            } else if (i3 == 15) {
                i2 = 13;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("fid", this.C.getFid());
            statisticItem.param("tid", this.C.getTid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.U);
            if (!rd.isEmpty(this.f1076T)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.f1076T);
            }
            if (!rd.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.C.getThreadAlaInfo() != null && this.C.getThreadAlaInfo().user_info != null && this.C.getThreadAlaInfo().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.C.getThreadAlaInfo().user_info.is_official);
            }
            statisticItem.param("card_type", this.C.getRecomCardType()).param("ab_tag", this.C.mRecomAbTag).param("recom_source", this.C.mRecomSource).param("weight", this.C.mRecomWeight).param("extra", this.C.mRecomExtra);
            if (this.C.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 10);
            } else if (this.C.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (this.C.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (this.C.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else {
                ThreadData threadData = this.C;
                if (threadData.isShareThread) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i4 = threadData.threadType;
                    if (i4 == 0) {
                        statisticItem.param("obj_type", 1);
                    } else if (i4 == 40) {
                        statisticItem.param("obj_type", 2);
                    } else if (i4 != 49 && i4 != 69) {
                        if (i4 == 54) {
                            statisticItem.param("obj_type", 4);
                        } else {
                            statisticItem.param("obj_type", 5);
                        }
                    } else {
                        statisticItem.param("obj_type", 3);
                    }
                }
            }
            int i5 = this.Q;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.Q == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param("resource_id", this.V);
            }
            if (this.C.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.C.getBaijiahaoData().oriUgcNid);
                if (this.C.isBJHVideoThreadType() || this.C.isBJHVideoDynamicThreadType()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.C.getBaijiahaoData().oriUgcVid);
                }
            }
            if (this.C.isBjhDynamicThread()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.C.isBJHArticleThreadType() && !this.C.isBJHVideoThreadType()) {
                int i6 = this.C.threadType;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.E;
            if (tbPageContext != null) {
                yo5.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.C.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void j(View view2, ThreadData threadData) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, view2, threadData) != null) || threadData == null) {
            return;
        }
        int id = view2.getId();
        int i4 = 3;
        if (id == R.id.thread_info_commont_container) {
            i2 = 7;
            i3 = 3;
        } else if (id == R.id.share_num_container) {
            i2 = 6;
            i3 = 4;
        } else if (id == R.id.img_agree) {
            i2 = 8;
            i3 = 1;
        } else if (id == R.id.img_disagree) {
            i2 = 0;
            i3 = 2;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i5 = this.Q;
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 4) {
                    if (i5 != 8) {
                        if (i5 != 9) {
                            i4 = 0;
                        }
                    } else {
                        i4 = 4;
                    }
                }
            } else {
                i4 = 2;
            }
        } else {
            i4 = 1;
        }
        if (i3 > 0 && i4 > 0) {
            TiebaStatic.log(nua.o("c13694", threadData, i4, i3));
        }
        nua.t(CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK, threadData, i2);
    }

    public final void p(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048622, this, context, threadData) != null) || this.j0 || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.Q;
        boolean z = true;
        if (i2 != 2 && i2 != 19) {
            if (i2 != 4 && i2 != 9 && i2 != 1) {
                str = "";
            } else {
                str = "index";
            }
        } else {
            str = "frs";
        }
        String str2 = str;
        videoItemData.buildWithThreadData(threadData);
        arrayList.add(videoItemData);
        String str3 = null;
        if (threadData.getBaijiahaoData() != null) {
            str3 = threadData.getBaijiahaoData().oriUgcNid;
        }
        String str4 = str3;
        if (videoItemData.isVerticalVideo != 1) {
            z = false;
        }
        ut5.e(context, arrayList, str4, z, 0, null, "from_nani_video", "personalize_page", "", str2, str2, true, threadData.isJumpToFrsVideoTabPlay, true, threadData.getFid());
    }

    public final boolean o(@NonNull ThreadData threadData) {
        InterceptResult invokeL;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, threadData)) == null) {
            if (!threadData.isDisableShare() && !AntiHelper.o(threadData) && (((originalThreadInfo = threadData.originalThreadData) == null || (!originalThreadInfo.m && !threadData.shouldShowBlockedState())) && threadData.getType() != ThreadData.TYPE_FAKE_VIDEO)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, context) == null) {
            this.D = context;
            if (context instanceof BaseActivity) {
                this.E = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.E = ((BaseFragmentActivity) context).getPageContext();
            }
            BdUtilHelper.getDimens(this.D, R.dimen.tbds84);
            x();
        }
    }

    public void setWeiXinShareGone(boolean z) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048666, this, z) == null) && (eMTextView = this.j) != null) {
            if (z) {
                eMTextView.setVisibility(8);
                this.l.setVisibility(8);
                this.k.setVisibility(8);
                return;
            }
            eMTextView.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setVisibility(0);
        }
    }

    public void updateCollectStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048672, this, threadData) == null) && this.w != null) {
            if (threadData != null && threadData.getIsMarked() != 0) {
                WebPManager.setPureDrawable(this.w, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.w, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void onChangeSkinType() {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.c0 != TbadkCoreApplication.getInst().getSkinType()) {
            this.c0 = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.d0, R.color.CAM_X0201);
            MaskView maskView = this.e0;
            if (maskView != null) {
                maskView.g();
            }
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            updateReplyStateUI();
            updateCollectStateUI(this.C);
            updateShareStateUI(this.C);
            updateManagerUI();
            jm6 jm6Var = this.r;
            if (jm6Var != null) {
                jm6Var.d0();
            }
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.P(this.c0);
                AgreeView agreeView2 = this.e;
                ThreadData threadData = this.C;
                if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
                } else {
                    f2 = 1.0f;
                }
                agreeView2.setAlpha(f2);
            }
        }
    }

    public final void q() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            View view2 = this.l;
            int i4 = 0;
            if (A(1)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            View view3 = this.i;
            if (A(2)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view3.setVisibility(i3);
            View view4 = this.q;
            int i5 = 4;
            if (A(4)) {
                i5 = 0;
            } else if (!A(64)) {
                i5 = 8;
            }
            view4.setVisibility(i5);
            AgreeView agreeView = this.e;
            if (!A(8)) {
                i4 = 8;
            }
            agreeView.setVisibility(i4);
            this.e.setAgreeAlone(A(32));
        }
    }
}
