package com.baidu.tbadk.core.view;

import android.animation.Animator;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.fo5;
import com.baidu.tieba.ga7;
import com.baidu.tieba.ho6;
import com.baidu.tieba.jd7;
import com.baidu.tieba.jw9;
import com.baidu.tieba.lk5;
import com.baidu.tieba.mr5;
import com.baidu.tieba.n15;
import com.baidu.tieba.n95;
import com.baidu.tieba.o75;
import com.baidu.tieba.or6;
import com.baidu.tieba.ow9;
import com.baidu.tieba.p95;
import com.baidu.tieba.q29;
import com.baidu.tieba.rh5;
import com.baidu.tieba.rr5;
import com.baidu.tieba.sg5;
import com.baidu.tieba.sn6;
import com.baidu.tieba.sw5;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.th5;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wf5;
import com.baidu.tieba.wg;
import com.baidu.tieba.y95;
import com.baidu.tieba.yc7;
import com.baidu.tieba.zc7;
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
    public boolean C;
    public boolean D;
    public ThreadData E;
    public Context F;
    public TbPageContext G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1078T;
    public int U;
    public String V;
    public int W;
    public int a;
    public String a0;
    public TextView b;
    public String b0;
    public TextView c;
    public String c0;
    public boolean d;
    public View.OnClickListener d0;
    public AgreeView e;
    public int e0;
    public EMTextView f;
    public View f0;
    public ImageView g;
    public MaskView g0;
    public EMTextView h;
    public m h0;
    public View i;
    public LinearLayout i0;
    public EMTextView j;
    public l j0;
    public ImageView k;
    public View l;
    public FrameLayout m;
    public ImageView n;
    public EMTextView o;
    public ImageView p;
    public View q;
    public ho6 r;
    public boolean r0;
    public LinearLayout s;
    public Runnable s0;
    public ImageView t;
    public CustomMessageListener t0;
    public EMTextView u;
    public CustomMessageListener u0;
    public LinearLayout v;
    public ImageView w;
    public EMTextView x;
    public ImageView y;
    public EMTextView z;

    /* loaded from: classes4.dex */
    public interface l {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes4.dex */
    public interface m {
        void a(boolean z);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void D(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public void E(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
        }
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
        }
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
        }
    }

    public void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, view2) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p95 a;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* loaded from: classes4.dex */
        public class a implements rh5 {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.rh5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.b.setAgreeNumViewIsShow(false);
                Rect rect = new Rect();
                this.a.b.e.getImgAgree().getGlobalVisibleRect(rect);
                this.a.a.j(false);
                TbPageContext tbPageContext = this.a.b.G;
                if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                    c cVar = this.a;
                    cVar.a.k(cVar.b.G.getPageActivity().findViewById(16908290), list, rect);
                }
            }
        }

        public c(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, p95 p95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, p95Var};
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
            this.a = p95Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p95 p95Var = this.a;
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.b;
                p95Var.l(threadCommentAndPraiseInfoLayout.i0, threadCommentAndPraiseInfoLayout.e);
                th5.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.b.setAgreeNumViewIsShow(true);
            this.a.i(this.b.e);
            this.a.m();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements q29.d {
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

        @Override // com.baidu.tieba.q29.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.W();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !PraiseSwitch.isOn() || this.a.e.J()) {
                return;
            }
            if (this.a.d0 != null) {
                this.a.d0.onClick(view2);
            }
            if (!WindowGreySwitch.getIsOnNew()) {
                this.a.g(view2);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.j(view2, threadCommentAndPraiseInfoLayout.E);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public e(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        public g(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
                threadCommentAndPraiseInfoLayout.O(threadCommentAndPraiseInfoLayout.E);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (threadCommentAndPraiseInfoLayout.E != null && threadData != null) {
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (threadCommentAndPraiseInfoLayout.E.getBaijiahaoData() != null) {
                    str2 = threadCommentAndPraiseInfoLayout.E.getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        threadCommentAndPraiseInfoLayout.E.setReply_num(threadData.getReply_num());
                        threadCommentAndPraiseInfoLayout.O(threadData);
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = threadCommentAndPraiseInfoLayout.E.getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    threadCommentAndPraiseInfoLayout.E.setReply_num(threadData.getReply_num());
                    if (threadCommentAndPraiseInfoLayout.S != 1 || !threadCommentAndPraiseInfoLayout.E.isVideoThreadType()) {
                        threadCommentAndPraiseInfoLayout.O(threadData);
                    } else {
                        threadCommentAndPraiseInfoLayout.R = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (!TextUtils.isEmpty(str) && (threadData = threadCommentAndPraiseInfoLayout.E) != null && !"0".equals(threadData.getId()) && str.equals(threadCommentAndPraiseInfoLayout.E.getId())) {
                if ((threadCommentAndPraiseInfoLayout.E.isLiveThread() || threadCommentAndPraiseInfoLayout.E.isSharedLiveThread()) && threadCommentAndPraiseInfoLayout.E.getThreadAlaInfo() != null) {
                    if (threadCommentAndPraiseInfoLayout.E.getThreadAlaInfo() != null && threadCommentAndPraiseInfoLayout.E.getThreadAlaInfo().share_info != null) {
                        threadCommentAndPraiseInfoLayout.E.getThreadAlaInfo().share_info.share_count++;
                    }
                } else {
                    ThreadData threadData2 = threadCommentAndPraiseInfoLayout.E;
                    threadData2.setShareNum(threadData2.getShareNum() + 1);
                }
                threadCommentAndPraiseInfoLayout.R(threadCommentAndPraiseInfoLayout.E);
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
        vi.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.C = true;
        this.D = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.Q = true;
        this.R = false;
        this.S = 2;
        this.f1078T = 1;
        this.e0 = 3;
        this.h0 = null;
        this.r0 = true;
        this.s0 = new g(this);
        this.t0 = new k(this);
        this.u0 = new n(this);
        p(context);
    }

    public void R(ThreadData threadData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) && (view2 = this.l) != null && this.j != null && threadData != null) {
            if (this.M) {
                view2.setVisibility(0);
                long shareNum = threadData.getShareNum();
                if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                    shareNum = threadData.getThreadAlaInfo().share_info.share_count;
                }
                String string = this.F.getString(R.string.obfuscated_res_0x7f0f133f);
                if (shareNum > 0) {
                    string = StringHelper.numFormatOverWan(shareNum);
                }
                this.j.setText(string);
                this.H = true;
                updateShareStateUI(threadData);
                return;
            }
            view2.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            ThreadData threadData = this.E;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                return;
            }
            if (view2 == this.b) {
                y(view2);
            } else if (view2 == this.i) {
                A(view2);
                int i2 = this.S;
                if (i2 == 1 || i2 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.l) {
                G(view2);
                int i3 = this.S;
                if (i3 == 1 || i3 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.n) {
                D(view2);
            } else if (view2 == this.q) {
                C(view2);
            } else if (view2 == this.y) {
                F(view2);
            } else if (view2 == this.s) {
                E(view2);
            } else if (view2 == this.v) {
                z(view2);
            }
        }
    }

    public final void y(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048676, this, view2) == null) && (threadData = this.E) != null && !StringUtils.isNull(threadData.getForum_name())) {
            if (!StringUtils.isNull(this.b0) && !StringUtils.isNull(this.c0)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.F).createCfgForpersonalized(this.E.getForum_name(), this.b0, this.c0)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.F).createNormalCfg(this.E.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
            View.OnClickListener onClickListener = this.d0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
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
        vi.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.C = true;
        this.D = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.Q = true;
        this.R = false;
        this.S = 2;
        this.f1078T = 1;
        this.e0 = 3;
        this.h0 = null;
        this.r0 = true;
        this.s0 = new g(this);
        this.t0 = new k(this);
        this.u0 = new n(this);
        p(context);
    }

    public final void m(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, context, threadData) != null) || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.S;
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
        sw5.e(context, arrayList, str4, z, 0, null, "from_nani_video", "personalize_page", "", str2, str2, true, threadData.isJumpToFrsVideoTabPlay, true, threadData.getFid());
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
        vi.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.C = true;
        this.D = false;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.Q = true;
        this.R = false;
        this.S = 2;
        this.f1078T = 1;
        this.e0 = 3;
        this.h0 = null;
        this.r0 = true;
        this.s0 = new g(this);
        this.t0 = new k(this);
        this.u0 = new n(this);
        this.d = z;
        p(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgreeNumViewIsShow(boolean z) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65549, this, z) == null) && (agreeView = this.e) != null && agreeView.getAgreeNumView() != null) {
            if (z) {
                this.e.getAgreeNumView().setVisibility(0);
            } else {
                this.e.getAgreeNumView().setVisibility(4);
            }
        }
    }

    public void I(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            this.b.setVisibility(8);
        }
    }

    public void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            EMTextView eMTextView = this.x;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0c27);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void N(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, threadData) != null) || threadData == null || this.S != 13) {
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
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            if (this.E == null && i2 < 0) {
                return;
            }
            StatisticItem h2 = h(i2);
            h2.param("thread_type", this.E.getThreadType());
            TiebaStatic.log(h2);
        }
    }

    public View l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, context)) == null) {
            return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        }
        return (View) invokeL.objValue;
    }

    public void manualPraise(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public void setAgreeStatisticData(n15 n15Var) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, n15Var) == null) && (agreeView = this.e) != null) {
            agreeView.setStatisticData(n15Var);
        }
    }

    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, threadData) == null) && threadData != null && threadData.isUgcThreadType()) {
            this.e.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.J = z;
            TextView textView = this.b;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && (linearLayout = this.v) != null) {
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
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && (view2 = this.i) != null) {
            view2.setClickable(z);
            this.g.setEnabled(z);
            this.f.setEnabled(z);
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, context) == null) {
            this.F = context;
            if (this.G == null) {
                if (context instanceof BaseActivity) {
                    this.G = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.G = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.d0 = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.S = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.W = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.r0 = z;
        }
    }

    public void setIsPbFirst(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.P = z;
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.N = z;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.K = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.Q = z;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setNeedMatchStrategy(z);
            }
        }
    }

    public void setOnCommentClickCallback(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, lVar) == null) {
            this.j0 = lVar;
        }
    }

    public void setOnSelectStatusChangeListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, mVar) == null) {
            this.h0 = mVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048650, this, z) == null) && (linearLayout = this.s) != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setReplyTimeVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.I = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.O = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048653, this, z) == null) && (view2 = this.l) != null) {
            view2.setClickable(z);
            this.k.setEnabled(z);
            this.j.setEnabled(z);
        }
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.f1078T = i2;
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.a = i2;
            n();
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            this.b0 = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.a0 = str;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.c0 = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
            if (z && this.g0 == null) {
                MaskView maskView = new MaskView(getContext());
                this.g0 = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.g0;
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

    public final boolean u(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, threadData)) == null) {
            if (threadData != null && threadData.isVideoThreadType() && threadData.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048675, this, i2)) == null) {
            if ((i2 & this.a) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            TbPageContext tbPageContext = this.G;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int i2 = this.S;
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

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.E == null) {
            return;
        }
        StatisticItem i2 = i();
        i2.param("thread_type", this.E.getThreadType());
        TiebaStatic.log(i2);
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            y95.b(this.i0);
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            onClick(this.y);
        }
    }

    public AgreeView getAgreeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.e;
        }
        return (AgreeView) invokeV.objValue;
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.e.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.M = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.t0);
            MessageManager.getInstance().registerListener(this.u0);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            ho6 ho6Var = this.r;
            if (ho6Var != null) {
                ho6Var.T();
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
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.t0);
            MessageManager.getInstance().unRegisterListener(this.u0);
        }
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.M = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = this.F.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.g.setLayoutParams(layoutParams);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            t(l(this.F));
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeRes();
        }
    }

    public void setUseDynamicLikeResImmediately() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeResImmediately();
        }
    }

    public void showFestivalCommentTip() {
        sg5 a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (a2 = lk5.b().a()) != null) {
            o(this.i, a2);
        }
    }

    public void updateReplyNumDelay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048672, this) != null) || !this.R) {
            return;
        }
        this.R = false;
        wg.a().post(new j(this));
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ThreadData threadData = this.E;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isShareThread) {
                return 4;
            }
            if (threadData.getThreadType() != 49 && this.E.getThreadType() != 69) {
                if (this.E.getThreadVideoInfo() != null) {
                    return 1;
                }
                if (this.E.getType() != ThreadData.TYPE_NORMAL && this.E.getType() != ThreadData.TYPE_GOD_NORMAL) {
                    return 0;
                }
                if (ListUtils.getCount(this.E.getVoice()) > 0) {
                    return 3;
                }
                return 2;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.B = new TBLottieAnimationView(this.F);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(vi.g(this.F, R.dimen.tbds715), vi.g(this.F, R.dimen.tbds110));
            layoutParams.setMargins(0, 0, vi.l(this.F) / 6, 0);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.B, layoutParams);
            r();
            this.B.setVisibility(8);
        }
    }

    public void updateManagerUI() {
        int color;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.o;
            ThreadData threadData = this.E;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = ow9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.p;
            ThreadData threadData2 = this.E;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                z = false;
            } else {
                z = true;
            }
            imageView.setEnabled(z);
        }
    }

    public void updateReplyStateUI() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            if (this.K) {
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.g;
            ThreadData threadData = this.E;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                z = false;
            } else {
                z = true;
            }
            imageView.setEnabled(z);
            y95.a(this.g, R.drawable.icon_pure_card_comment20);
            y95.e(this.f);
            ThreadData threadData2 = this.E;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.f.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            ThreadData threadData = this.E;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (this.E.isBJHVideoThreadType()) {
                return 2;
            }
            if (this.E.isBJHNormalThreadType()) {
                return 3;
            }
            if (!this.E.isBJHVideoDynamicThreadType()) {
                return 0;
            }
            return 4;
        }
        return invokeV.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.B != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img_dark");
            } else {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img");
            }
            SkinManager.setLottieAnimation(this.B, R.raw.lottie_reactions_guide_right);
        }
    }

    public void A(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.E != null && this.F != null) {
            int i2 = this.S;
            if (i2 == 2 || i2 == 13) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(this.E.getFid())));
            }
            sn6.a(this.E.getTid());
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", this.S);
            statisticItem.param("obj_type", getThreadType());
            statisticItem.param("tid", this.E.getTid());
            statisticItem.param("nid", this.E.getNid());
            if (this.S == 18) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.E.getFid());
                statisticItem.param("resource_id", this.a0);
            }
            mr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
            if (this.E.getVoiceRoomData() != null && this.E.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.E.getVoiceRoomData().room_name)) {
                ((fo5) ServiceManager.getService(fo5.a.a())).b(this.G, this.E.getVoiceRoomData().room_id.longValue());
            } else if (this.E.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.E.getThreadVideoInfo().video_url)) {
                m(this.F, this.E);
                l lVar = this.j0;
                if (lVar != null) {
                    lVar.a(null);
                }
            } else {
                PbActivityConfig addLocateParam = new PbActivityConfig(this.F).createFromThreadCfg(this.E, null, this.b0, 0, true, false, false).addLocateParam("");
                addLocateParam.setForumId(String.valueOf(this.E.getFid()));
                addLocateParam.setForumName(this.E.getForum_name());
                if (this.E.getIsDailyThread() && this.E.getForumData() != null) {
                    addLocateParam.setForumId(this.E.getForumData().b());
                    addLocateParam.setForumName(this.E.getForumData().d());
                }
                addLocateParam.setJumpToCommentArea(true);
                l lVar2 = this.j0;
                if (lVar2 != null) {
                    lVar2.a(addLocateParam);
                }
                if (TbSingleton.getInstance().isPbPreloadSwitchOn() && u(this.E)) {
                    addLocateParam.setNeedPreLoad(true);
                    jd7.update(this.E);
                }
                if (this.E.isQualityReplyThread) {
                    addLocateParam.setFromHomePageQuality(true);
                }
                if (this.E.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
                    addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
                }
                addLocateParam.setStartFrom(this.U);
                if (this.E.isSimilarPageType()) {
                    addLocateParam.setSimilarFrom(2);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            }
            StatisticItem statisticItem2 = new StatisticItem("c12291");
            statisticItem2.param("obj_locate", this.S);
            TiebaStatic.log(statisticItem2);
            k();
            j(view2, this.E);
            View.OnClickListener onClickListener = this.d0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, view2) == null) {
            this.b = (TextView) view2.findViewById(R.id.thread_info_bar_name);
            this.c = (TextView) view2.findViewById(R.id.thread_info_reply_time);
            this.i0 = (LinearLayout) view2.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.thread_info_commont_num);
            this.f = eMTextView;
            o75.d(eMTextView).C(R.string.F_X01);
            this.g = (ImageView) view2.findViewById(R.id.thread_info_commont_img);
            this.h = (EMTextView) view2.findViewById(R.id.thread_info_commont_grab_sofa);
            this.i = view2.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.share_num);
            this.j = eMTextView2;
            o75.d(eMTextView2).C(R.string.F_X01);
            this.k = (ImageView) view2.findViewById(R.id.share_num_img);
            this.l = view2.findViewById(R.id.share_num_container);
            this.m = (FrameLayout) view2.findViewById(R.id.btn_card_bottom_op_more_container);
            this.n = (ImageView) view2.findViewById(R.id.btn_card_bottom_op_more);
            View findViewById = view2.findViewById(R.id.new_agree_view);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.e = agreeView;
                agreeView.setIsAgreeNumClick(true);
                this.e.setAfterClickListener(new b(this));
                this.e.setUseLikeDefaultRes(this.d);
                this.e.setAgreeLongClickListener(new c(this, new p95(this.G)));
            }
            this.q = view2.findViewById(R.id.manage_view_container);
            EMTextView eMTextView3 = (EMTextView) view2.findViewById(R.id.thread_info_manage_text);
            this.o = eMTextView3;
            o75.d(eMTextView3).C(R.string.F_X01);
            this.p = (ImageView) view2.findViewById(R.id.thread_info_manage_img);
            this.y = (ImageView) view2.findViewById(R.id.manage_select_img);
            EMTextView eMTextView4 = (EMTextView) view2.findViewById(R.id.manage_select_text);
            this.z = eMTextView4;
            o75.d(eMTextView4).C(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.manage_select_container);
            this.A = linearLayout;
            linearLayout.setOnTouchListener(new d(this));
            this.z.setOnClickListener(new e(this));
            this.s = (LinearLayout) view2.findViewById(R.id.qq_share_container);
            this.t = (ImageView) view2.findViewById(R.id.qq_share_image);
            EMTextView eMTextView5 = (EMTextView) view2.findViewById(R.id.qq_share_text);
            this.u = eMTextView5;
            if (eMTextView5 != null) {
                o75.d(eMTextView5).C(R.string.F_X01);
            }
            this.v = (LinearLayout) view2.findViewById(R.id.collect_num_container);
            this.w = (ImageView) view2.findViewById(R.id.collect_num_image);
            EMTextView eMTextView6 = (EMTextView) view2.findViewById(R.id.collect_num_text);
            this.x = eMTextView6;
            if (eMTextView6 != null) {
                o75.d(eMTextView6).C(R.string.F_X01);
            }
            this.A.setOnClickListener(new f(this));
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
            q();
        }
    }

    public void C(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (this.r == null) {
                this.r = new ho6(this.G, x(16));
            }
            this.r.f0(this.E);
            this.r.l();
            if (this.E != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.E.getFid()).param("tid", this.E.getId()));
            }
        }
    }

    public void G(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.F)) || this.E == null) {
                return;
            }
            H();
            j(view2, this.E);
            if (AntiHelper.e(getContext(), this.E)) {
                return;
            }
            wf5.f(this.F, this.E, this.f1078T, this.S);
            View.OnClickListener onClickListener = this.d0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void M(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) && this.q != null && threadData != null) {
            int i2 = 4;
            this.N = x(4);
            if (threadData.mOriginalForumInfo != null) {
                this.N = false;
            }
            if (this.N && ((linearLayout = this.A) == null || linearLayout.getVisibility() == 8)) {
                this.q.setVisibility(0);
                String string = this.F.getString(R.string.obfuscated_res_0x7f0f0c1c);
                this.o.setText(string);
                this.o.setContentDescription(string);
                this.H = true;
            } else {
                View view2 = this.q;
                if (!x(64)) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
            updateManagerUI();
        }
    }

    public final void P(ThreadData threadData) {
        String replyTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) && this.c != null && threadData != null) {
            if (threadData.getLast_time_int() > 0 && this.I) {
                this.c.setVisibility(0);
                if (this.S == 3) {
                    replyTime = threadData.getReplyTimeForMyThread();
                } else {
                    replyTime = threadData.getReplyTime();
                }
                this.c.setText(replyTime);
                this.H = true;
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public boolean setData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            int i2 = 0;
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.E = threadData;
            K();
            I(threadData);
            P(threadData);
            O(threadData);
            J(threadData);
            R(threadData);
            updatePraiseNum(threadData);
            Q(threadData);
            M(threadData);
            if (!this.H) {
                i2 = 8;
            }
            setVisibility(i2);
            N(threadData);
            B();
            return this.H;
        }
        return invokeL.booleanValue;
    }

    public void F(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && this.y != null && (threadData = this.E) != null && this.z != null && !threadData.isTransportThread()) {
            boolean z = true;
            if (!this.E.isMarkToDel() && zc7.f().i()) {
                if (zc7.f().a(this.E)) {
                    this.E.setMarkToDel(true);
                }
            } else if (!this.E.isMarkToMove() && yc7.h().j()) {
                if (yc7.h().a(this.E)) {
                    this.E.setMarkToMove(true);
                }
            } else {
                zc7.f().l(this.E);
                this.E.setMarkToDel(false);
                yc7.h().l(this.E);
                this.E.setMarkToMove(false);
            }
            if (!this.E.isMarkToDel() && !this.E.isMarkToMove()) {
                o75.d(this.z).z(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            m mVar = this.h0;
            if (mVar != null) {
                if (!this.E.isMarkToDel() && !this.E.isMarkToMove()) {
                    z = false;
                }
                mVar.a(z);
            }
        }
    }

    public void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) && this.A != null && this.y != null && this.z != null && threadData != null) {
            if (!this.r0) {
                View view2 = this.f0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.A.setVisibility(8);
            } else if (this.O && !x(128) && (zc7.f().i() || yc7.h().j())) {
                if (this.f0 == null) {
                    View view3 = new View(getContext());
                    this.f0 = view3;
                    SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                    addView(this.f0);
                    this.f0.setAlpha(0.5f);
                    this.f0.setOnTouchListener(new h(this));
                    this.f0.setOnClickListener(new i(this));
                }
                int l2 = vi.l(getContext());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f0.getLayoutParams();
                if (layoutParams == null) {
                    this.f0.setLayoutParams(new RelativeLayout.LayoutParams(l2, -1));
                } else {
                    layoutParams.width = l2;
                    requestLayout();
                }
                if (!this.E.isMarkToDel() && !this.E.isMarkToMove()) {
                    o75.d(this.z).z(R.color.CAM_X0107);
                    WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                    WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                }
                this.f0.setVisibility(0);
                this.A.setVisibility(8);
            } else {
                View view4 = this.f0;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                this.A.setVisibility(8);
            }
        }
    }

    public void g(@NonNull View view2) {
        TbPageContext tbPageContext;
        int g2;
        int g3;
        int width;
        int g4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && this.e.getData() != null && this.e.getData().hasAgree && (tbPageContext = this.G) != null && tbPageContext.getPageActivity() != null && this.e.getImgAgree() != null) {
            if (!this.P || (this.e.getAgreeFlag() && !this.e.K())) {
                q29 q29Var = new q29(getContext());
                int[] iArr = new int[2];
                this.e.getImgAgree().getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (this.P) {
                    g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
                } else {
                    g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds600);
                }
                if (this.P) {
                    g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708e4);
                } else {
                    g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                }
                int i4 = (int) ((g3 * 1) / 1.45d);
                if (i2 > i4) {
                    width = ((i2 - i4) + (this.e.getImgAgree().getWidth() / 2)) - 10;
                } else {
                    width = (i2 - i4) + (this.e.getImgAgree().getWidth() / 2);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
                layoutParams.leftMargin = width;
                if (this.P) {
                    g4 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
                } else {
                    g4 = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                layoutParams.topMargin = g4;
                q29Var.k(g2);
                q29Var.j(layoutParams);
                q29Var.i(false);
                q29Var.n(this.Q, this.G.getPageActivity().findViewById(16908290), 0, i3 - 10, this.E.getTid(), String.valueOf(this.E.getFid()));
                q29Var.l(new a(this));
            }
        }
    }

    public final StatisticItem h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            if (this.E == null && i2 < 0) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("c12003");
            statisticItem.param("tid", this.E.getTid());
            if (this.E.getThreadType() == 40) {
                statisticItem.param("obj_param1", "2");
            } else if (this.E.getThreadType() == 0) {
                statisticItem.param("obj_param1", "1");
            }
            statisticItem.param("obj_source", "1");
            statisticItem.param("fid", this.E.getFid());
            statisticItem.param("obj_locate", this.S);
            statisticItem.param("obj_id", i2);
            if (!ui.isEmpty(this.V)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.V);
            }
            if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            }
            statisticItem.param("nid", this.E.getNid());
            statisticItem.param("card_type", this.E.getRecomCardType());
            statisticItem.param("recom_source", this.E.mRecomSource);
            statisticItem.param("ab_tag", this.E.mRecomAbTag);
            statisticItem.param("weight", this.E.mRecomWeight);
            statisticItem.param("extra", this.E.mRecomExtra);
            if (this.E.getBaijiahaoData() != null && !ui.isEmpty(this.E.getBaijiahaoData().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.E.getBaijiahaoData().oriUgcVid);
            }
            mr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
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

    public void updatePraiseNum(ThreadData threadData) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, threadData) == null) {
            setAgreeViewType(threadData);
            if (threadData.getAgreeData() != null) {
                threadData.getAgreeData().isInThread = true;
                this.e.setCardType(threadData.getRecomCardType());
                this.e.setThreadData(threadData);
                this.e.setData(threadData.getAgreeData());
            }
            AgreeView agreeView = this.e;
            ThreadData threadData2 = this.E;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
            } else {
                f2 = 1.0f;
            }
            agreeView.setAlpha(f2);
            if (!this.e.I() && this.B.getVisibility() != 0) {
                r();
                String q = n95.q("key_reaction_guide_show_number_pb");
                if (this.e.getTbPageContext() != null && this.e.getTbPageContext().getPageActivity() != null && this.e.getTbPageContext().getPageActivity().getIntent() != null && this.e.getTbPageContext().getPageActivity().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.D && n95.m().n(q, 0) == 2 && this.C) {
                    this.D = true;
                    this.B.setVisibility(0);
                    this.B.playAnimation();
                    wg.a().postDelayed(this.s0, 4000L);
                }
            }
        }
    }

    public void O(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) && this.f != null && threadData != null) {
            if (this.L) {
                this.i.setVisibility(0);
                if (threadData.getReply_num() > 0) {
                    this.f.setVisibility(0);
                    String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                    if (this.K) {
                        updateReplyStateUI();
                        this.f.setText(numFormatOverWan);
                    } else {
                        this.f.setText(String.format(this.F.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    EMTextView eMTextView = this.f;
                    eMTextView.setContentDescription(this.F.getString(R.string.reply_num) + numFormatOverWan);
                    this.H = true;
                    return;
                } else if (this.K) {
                    updateReplyStateUI();
                    this.f.setText(this.F.getString(R.string.action_comment_default));
                    this.f.setVisibility(0);
                    this.H = true;
                    return;
                } else {
                    this.f.setVisibility(8);
                    return;
                }
            }
            this.i.setVisibility(8);
        }
    }

    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, threadData) == null) {
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(threadData)) {
                setShareClickable(true);
                this.j.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (threadData != null && threadData.originalThreadData != null) {
                    ThreadData threadData2 = this.E;
                    if (threadData2.originalThreadData.m || threadData2.shouldShowBlockedState()) {
                        setShareClickable(false);
                        this.j.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                o75.d(this.j).z(R.color.CAM_X0107);
            }
            y95.a(this.k, R.drawable.icon_pure_card_share20);
            y95.e(this.j);
            ThreadData threadData3 = this.E;
            if (threadData3 != null && threadData3.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.k.setEnabled(false);
                this.j.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.i0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final StatisticItem i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.E == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.f1078T;
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
            statisticItem.param("fid", this.E.getFid());
            statisticItem.param("tid", this.E.getTid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.W);
            if (!ui.isEmpty(this.V)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.V);
            }
            if (!ui.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.E.getThreadAlaInfo() != null && this.E.getThreadAlaInfo().user_info != null && this.E.getThreadAlaInfo().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.E.getThreadAlaInfo().user_info.is_official);
            }
            statisticItem.param("card_type", this.E.getRecomCardType()).param("ab_tag", this.E.mRecomAbTag).param("recom_source", this.E.mRecomSource).param("weight", this.E.mRecomWeight).param("extra", this.E.mRecomExtra);
            if (this.E.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 10);
            } else if (this.E.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (this.E.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (this.E.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else {
                ThreadData threadData = this.E;
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
            int i5 = this.S;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.S == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param("resource_id", this.a0);
            }
            if (this.E.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.E.getBaijiahaoData().oriUgcNid);
                if (this.E.isBJHVideoThreadType() || this.E.isBJHVideoDynamicThreadType()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.E.getBaijiahaoData().oriUgcVid);
                }
            }
            if (this.E.isBjhDynamicThread()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.E.isBJHArticleThreadType() && !this.E.isBJHVideoThreadType()) {
                int i6 = this.E.threadType;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.G;
            if (tbPageContext != null) {
                rr5.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.E.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void j(View view2, ThreadData threadData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048608, this, view2, threadData) != null) || threadData == null) {
            return;
        }
        int id = view2.getId();
        int i3 = 3;
        if (id == R.id.thread_info_commont_container) {
            i2 = 3;
        } else if (id == R.id.share_num_container) {
            i2 = 4;
        } else if (id == R.id.img_agree) {
            i2 = 1;
        } else if (id == R.id.img_disagree) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int i4 = this.S;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 4) {
                    if (i4 != 8) {
                        if (i4 != 9) {
                            i3 = 0;
                        }
                    } else {
                        i3 = 4;
                    }
                }
            } else {
                i3 = 2;
            }
        } else {
            i3 = 1;
        }
        if (i2 > 0 && i3 > 0) {
            TiebaStatic.log(jw9.l("c13694", threadData, i3, i2));
        }
    }

    public final void n() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            View view2 = this.l;
            int i4 = 0;
            if (x(1)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            View view3 = this.i;
            if (x(2)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view3.setVisibility(i3);
            View view4 = this.q;
            int i5 = 4;
            if (x(4)) {
                i5 = 0;
            } else if (!x(64)) {
                i5 = 8;
            }
            view4.setVisibility(i5);
            AgreeView agreeView = this.e;
            if (!x(8)) {
                i4 = 8;
            }
            agreeView.setVisibility(i4);
            this.e.setAgreeAlone(x(32));
        }
    }

    public void onChangeSkinType() {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.e0 != TbadkCoreApplication.getInst().getSkinType()) {
            this.e0 = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f0, R.color.CAM_X0201);
            MaskView maskView = this.g0;
            if (maskView != null) {
                maskView.f();
            }
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            updateReplyStateUI();
            updateCollectStateUI(this.E);
            updateShareStateUI(this.E);
            updateManagerUI();
            ho6 ho6Var = this.r;
            if (ho6Var != null) {
                ho6Var.d0();
            }
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.P(this.e0);
                AgreeView agreeView2 = this.e;
                ThreadData threadData = this.E;
                if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
                } else {
                    f2 = 1.0f;
                }
                agreeView2.setAlpha(f2);
            }
        }
    }

    public final void o(View view2, sg5 sg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048614, this, view2, sg5Var) == null) && view2 != null && view2.getVisibility() == 0) {
            or6 or6Var = new or6(this.G, view2);
            or6Var.L(R.drawable.bg_tip_blue_dropdown);
            ThemeColorInfo themeColorInfo = null;
            if (lk5.b().a() != null) {
                themeColorInfo = lk5.b().a().f;
            }
            or6Var.M(SkinManager.getColorFromServerColor(themeColorInfo, R.color.CAM_X0301));
            or6Var.J(R.dimen.T_X08);
            or6Var.l(2);
            or6Var.o(32);
            or6Var.x(true);
            or6Var.Q(0);
            or6Var.R(vi.g(getContext(), R.dimen.tbds10));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            or6Var.E(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds23), dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds40));
            String string = TbadkCoreApplication.getInst().getString(R.string.spring_festival_home_reply);
            if (!TextUtils.isEmpty(sg5Var.e)) {
                string = sg5Var.e;
            }
            or6Var.T(string, ga7.a("springfestival", "home_reply"));
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, context) == null) {
            this.F = context;
            if (context instanceof BaseActivity) {
                this.G = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.G = ((BaseFragmentActivity) context).getPageContext();
            }
            vi.g(this.F, R.dimen.tbds84);
            s();
        }
    }

    public void setWeiXinShareGone(boolean z) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048663, this, z) == null) && (eMTextView = this.j) != null) {
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
        if ((interceptable == null || interceptable.invokeL(1048669, this, threadData) == null) && this.w != null) {
            if (threadData != null && threadData.getIsMarked() != 0) {
                WebPManager.setPureDrawable(this.w, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.w, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }
}
