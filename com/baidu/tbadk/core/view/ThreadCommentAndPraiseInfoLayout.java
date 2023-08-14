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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.bi;
import com.baidu.tieba.br5;
import com.baidu.tieba.c95;
import com.baidu.tieba.dn6;
import com.baidu.tieba.ek5;
import com.baidu.tieba.fc7;
import com.baidu.tieba.gr5;
import com.baidu.tieba.if7;
import com.baidu.tieba.ih5;
import com.baidu.tieba.jg5;
import com.baidu.tieba.k95;
import com.baidu.tieba.kh5;
import com.baidu.tieba.lr6;
import com.baidu.tieba.mf5;
import com.baidu.tieba.om6;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.s9a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.vv5;
import com.baidu.tieba.w05;
import com.baidu.tieba.wb9;
import com.baidu.tieba.xe7;
import com.baidu.tieba.y9a;
import com.baidu.tieba.ye7;
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
    public TBLottieAnimationView D;
    public boolean E;
    public ThreadData F;
    public Context G;
    public TbPageContext H;
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
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public int f1079T;
    public int U;
    public int V;
    public String W;
    public int a;
    public int a0;
    public TextView b;
    public String b0;
    public TextView c;
    public String c0;
    public boolean d;
    public String d0;
    public AgreeView e;
    public View.OnClickListener e0;
    public EMTextView f;
    public int f0;
    public ImageView g;
    public View g0;
    public EMTextView h;
    public MaskView h0;
    public View i;
    public n i0;
    public EMTextView j;
    public LinearLayout j0;
    public ImageView k;
    public View l;
    public FrameLayout m;
    public ImageView n;
    public EMTextView o;
    public ImageView p;
    public View q;
    public dn6 r;
    public m r0;
    public LinearLayout s;
    public boolean s0;
    public ImageView t;
    public boolean t0;
    public EMTextView u;
    public Runnable u0;
    public LinearLayout v;
    public Runnable v0;
    public ImageView w;
    public CustomMessageListener w0;
    public EMTextView x;
    public CustomMessageListener x0;
    public ImageView y;
    public EMTextView z;

    /* loaded from: classes4.dex */
    public interface m {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes4.dex */
    public interface n {
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
    public class d implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c95 a;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* loaded from: classes4.dex */
        public class a implements ih5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.tieba.ih5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.b.setAgreeNumViewIsShow(false);
                Rect rect = new Rect();
                this.a.b.e.getImgAgree().getGlobalVisibleRect(rect);
                this.a.a.j(false);
                TbPageContext tbPageContext = this.a.b.H;
                if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                    d dVar = this.a;
                    dVar.a.k(dVar.b.H.getPageActivity().findViewById(16908290), list, rect);
                }
            }
        }

        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, c95 c95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, c95Var};
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
            this.a = c95Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c95 c95Var = this.a;
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.b;
                c95Var.l(threadCommentAndPraiseInfoLayout.j0, threadCommentAndPraiseInfoLayout.e);
                kh5.g().c(new a(this));
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
    public class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
                threadCommentAndPraiseInfoLayout.R(threadCommentAndPraiseInfoLayout.F);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PbFirstFloorDoubleClickAnimation.d {
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

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.X();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !PraiseSwitch.isOn() || this.a.e.K()) {
                return;
            }
            if (this.a.e0 != null) {
                this.a.e0.onClick(view2);
            }
            if (!WindowGreySwitch.getIsOnNew()) {
                this.a.h(view2);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.k(view2, threadCommentAndPraiseInfoLayout.F);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
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
    public class g implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
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
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.D != null) {
                this.a.D.setVisibility(8);
                this.a.D.pauseAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnTouchListener {
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
    public class k implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (threadCommentAndPraiseInfoLayout.F != null && threadData != null) {
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (threadCommentAndPraiseInfoLayout.F.getBaijiahaoData() != null) {
                    str2 = threadCommentAndPraiseInfoLayout.F.getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        threadCommentAndPraiseInfoLayout.F.setReply_num(threadData.getReply_num());
                        threadCommentAndPraiseInfoLayout.R(threadData);
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = threadCommentAndPraiseInfoLayout.F.getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    threadCommentAndPraiseInfoLayout.F.setReply_num(threadData.getReply_num());
                    if (threadCommentAndPraiseInfoLayout.f1079T != 1 || !threadCommentAndPraiseInfoLayout.F.isVideoThreadType()) {
                        threadCommentAndPraiseInfoLayout.R(threadData);
                    } else {
                        threadCommentAndPraiseInfoLayout.S = true;
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (!TextUtils.isEmpty(str) && (threadData = threadCommentAndPraiseInfoLayout.F) != null && !"0".equals(threadData.getId()) && str.equals(threadCommentAndPraiseInfoLayout.F.getId())) {
                if ((threadCommentAndPraiseInfoLayout.F.isLiveThread() || threadCommentAndPraiseInfoLayout.F.isSharedLiveThread()) && threadCommentAndPraiseInfoLayout.F.getThreadAlaInfo() != null) {
                    if (threadCommentAndPraiseInfoLayout.F.getThreadAlaInfo() != null && threadCommentAndPraiseInfoLayout.F.getThreadAlaInfo().share_info != null) {
                        threadCommentAndPraiseInfoLayout.F.getThreadAlaInfo().share_info.share_count++;
                    }
                } else {
                    ThreadData threadData2 = threadCommentAndPraiseInfoLayout.F;
                    threadData2.setShareNum(threadData2.getShareNum() + 1);
                }
                threadCommentAndPraiseInfoLayout.U(threadCommentAndPraiseInfoLayout.F);
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
        this.C = true;
        this.E = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = true;
        this.R = true;
        this.S = false;
        this.f1079T = 2;
        this.U = 1;
        this.f0 = 3;
        this.i0 = null;
        this.s0 = true;
        this.t0 = false;
        this.u0 = new h(this);
        this.v0 = new i(this);
        this.w0 = new l(this);
        this.x0 = new o(this);
        q(context);
    }

    public final void B(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (threadData = this.F) != null && !StringUtils.isNull(threadData.getForum_name())) {
            if (!StringUtils.isNull(this.c0) && !StringUtils.isNull(this.d0)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.G).createCfgForpersonalized(this.F.getForum_name(), this.c0, this.d0)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.G).createNormalCfg(this.F.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
            View.OnClickListener onClickListener = this.e0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void U(ThreadData threadData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) && (view2 = this.l) != null && this.j != null && threadData != null) {
            if (this.N) {
                view2.setVisibility(0);
                long shareNum = threadData.getShareNum();
                if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                    shareNum = threadData.getThreadAlaInfo().share_info.share_count;
                }
                String string = this.G.getString(R.string.obfuscated_res_0x7f0f137a);
                if (shareNum > 0) {
                    string = StringHelper.numFormatOverWan(shareNum);
                }
                this.j.setText(string);
                this.I = true;
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
            ThreadData threadData = this.F;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                return;
            }
            if (view2 == this.b) {
                B(view2);
            } else if (view2 == this.i) {
                D(view2);
                int i2 = this.f1079T;
                if (i2 == 1 || i2 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.l) {
                J(view2);
                int i3 = this.f1079T;
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
        this.C = true;
        this.E = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = true;
        this.R = true;
        this.S = false;
        this.f1079T = 2;
        this.U = 1;
        this.f0 = 3;
        this.i0 = null;
        this.s0 = true;
        this.t0 = false;
        this.u0 = new h(this);
        this.v0 = new i(this);
        this.w0 = new l(this);
        this.x0 = new o(this);
        q(context);
    }

    public final void p(View view2, jg5 jg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048622, this, view2, jg5Var) == null) && view2 != null && view2.getVisibility() == 0) {
            lr6 lr6Var = new lr6(this.H, view2);
            lr6Var.L(R.drawable.bg_tip_blue_dropdown);
            ThemeColorInfo themeColorInfo = null;
            if (ek5.b().a() != null) {
                themeColorInfo = ek5.b().a().f;
            }
            lr6Var.M(SkinManager.getColorFromServerColor(themeColorInfo, R.color.CAM_X0301));
            lr6Var.J(R.dimen.T_X08);
            lr6Var.l(2);
            lr6Var.o(32);
            lr6Var.x(true);
            lr6Var.Q(0);
            lr6Var.R(BdUtilHelper.getDimens(getContext(), R.dimen.tbds10));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X006);
            lr6Var.E(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds23), dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.tbds40));
            String string = TbadkCoreApplication.getInst().getString(R.string.spring_festival_home_reply);
            if (!TextUtils.isEmpty(jg5Var.e)) {
                string = jg5Var.e;
            }
            lr6Var.T(string, fc7.a("springfestival", "home_reply"));
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
        this.C = true;
        this.E = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = false;
        this.P = true;
        this.R = true;
        this.S = false;
        this.f1079T = 2;
        this.U = 1;
        this.f0 = 3;
        this.i0 = null;
        this.s0 = true;
        this.t0 = false;
        this.u0 = new h(this);
        this.v0 = new i(this);
        this.w0 = new l(this);
        this.x0 = new o(this);
        this.d = z;
        q(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgreeNumViewIsShow(boolean z) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65551, this, z) == null) && (agreeView = this.e) != null && agreeView.getAgreeNumView() != null) {
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

    public void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) {
            this.b.setVisibility(8);
        }
    }

    public void N(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            EMTextView eMTextView = this.x;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, threadData) != null) || threadData == null || this.f1079T != 13) {
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
            if (this.F == null && i2 < 0) {
                return;
            }
            StatisticItem i3 = i(i2);
            i3.param("thread_type", this.F.getThreadType());
            TiebaStatic.log(i3);
        }
    }

    public View m(Context context) {
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

    public void setAgreeStatisticData(w05 w05Var) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, w05Var) == null) && (agreeView = this.e) != null) {
            agreeView.setStatisticData(w05Var);
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
            this.K = z;
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
            this.G = context;
            if (this.H == null) {
                if (context instanceof BaseActivity) {
                    this.H = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.H = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onClickListener) == null) {
            this.e0 = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.f1079T = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.a0 = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.s0 = z;
        }
    }

    public void setIsPbFirst(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.Q = z;
        }
    }

    public void setJumpToVideoFromOuter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.t0 = z;
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.O = z;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.L = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.R = z;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setNeedMatchStrategy(z);
            }
        }
    }

    public void setOnCommentClickCallback(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, mVar) == null) {
            this.r0 = mVar;
        }
    }

    public void setOnSelectStatusChangeListener(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, nVar) == null) {
            this.i0 = nVar;
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
            this.J = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            this.P = z;
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
            this.U = i2;
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            this.a = i2;
            o();
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            this.c0 = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.b0 = str;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.d0 = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            if (z && this.h0 == null) {
                MaskView maskView = new MaskView(getContext());
                this.h0 = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.h0;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.G, R.dimen.tbds715), BdUtilHelper.getDimens(this.G, R.dimen.tbds110));
            layoutParams.setMargins(0, 0, BdUtilHelper.getEquipmentWidth(this.G) / 6, 0);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            ThreadData threadData = this.F;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (this.F.isBJHVideoThreadType()) {
                return 2;
            }
            if (this.F.isBJHNormalThreadType()) {
                return 3;
            }
            if (!this.F.isBJHVideoDynamicThreadType()) {
                return 0;
            }
            return 4;
        }
        return invokeV.intValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && this.D != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.D.setImageAssetsFolder("lottie_friend_bot_guide_right_img_dark");
            } else {
                this.D.setImageAssetsFolder("lottie_friend_bot_guide_right_img");
            }
            SkinManager.setLottieAnimation(this.D, R.raw.lottie_friend_bot_guide_right);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048671, this) == null) && this.B != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img_dark");
            } else {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img");
            }
            SkinManager.setLottieAnimation(this.B, R.raw.lottie_reactions_guide_right);
        }
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            TbPageContext tbPageContext = this.H;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            int i2 = this.f1079T;
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
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.F == null) {
            return;
        }
        StatisticItem j2 = j();
        j2.param("thread_type", this.F.getThreadType());
        TiebaStatic.log(j2);
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            k95.b(this.j0);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.e;
        }
        return (AgreeView) invokeV.objValue;
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.e.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.N = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
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
            MessageManager.getInstance().registerListener(this.w0);
            MessageManager.getInstance().registerListener(this.x0);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            dn6 dn6Var = this.r;
            if (dn6Var != null) {
                dn6Var.T();
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
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.x0);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.G);
            this.D = tBLottieAnimationView;
            addView(tBLottieAnimationView, getGuideLayoutParams());
            s();
            this.D.setVisibility(8);
        }
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.N = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = this.G.getResources().getDimensionPixelSize(R.dimen.tbds78);
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
        jg5 a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && (a2 = ek5.b().a()) != null) {
            p(this.i, a2);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.G);
            this.B = tBLottieAnimationView;
            addView(tBLottieAnimationView, getGuideLayoutParams());
            u();
            this.B.setVisibility(8);
        }
    }

    public void updateReplyNumDelay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048675, this) != null) || !this.S) {
            return;
        }
        this.S = false;
        SafeHandler.getInst().post(new a(this));
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            y(m(this.G));
        }
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            ThreadData threadData = this.F;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isShareThread) {
                return 4;
            }
            if (threadData.getThreadType() != 49 && this.F.getThreadType() != 69) {
                if (this.F.getThreadVideoInfo() != null) {
                    return 1;
                }
                if (this.F.getType() != ThreadData.TYPE_NORMAL && this.F.getType() != ThreadData.TYPE_GOD_NORMAL) {
                    return 0;
                }
                if (ListUtils.getCount(this.F.getVoice()) > 0) {
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
            ThreadData threadData = this.F;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = y9a.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.p;
            ThreadData threadData2 = this.F;
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
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            if (this.L) {
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.g;
            ThreadData threadData = this.F;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                z = false;
            } else {
                z = true;
            }
            imageView.setEnabled(z);
            k95.a(this.g, R.drawable.icon_pure_card_comment20);
            k95.e(this.f);
            ThreadData threadData2 = this.F;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.f.setTextColor(y9a.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    public void D(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.F != null && this.G != null) {
            int i2 = this.f1079T;
            if (i2 == 2 || i2 == 13) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, Long.valueOf(this.F.getFid())));
            }
            om6.a(this.F.getTid());
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", this.f1079T);
            statisticItem.param("obj_type", getThreadType());
            statisticItem.param("tid", this.F.getTid());
            statisticItem.param("nid", this.F.getNid());
            if (this.f1079T == 18) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.F.getFid());
                statisticItem.param("resource_id", this.b0);
            }
            br5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
            if (this.F.getVoiceRoomData() != null && this.F.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.F.getVoiceRoomData().room_name)) {
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(this.H, this.F.getVoiceRoomData().room_id.longValue());
            } else if (this.F.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.F.getThreadVideoInfo().video_url)) {
                n(this.G, this.F);
                m mVar = this.r0;
                if (mVar != null) {
                    mVar.a(null);
                }
            } else {
                PbActivityConfig addLocateParam = new PbActivityConfig(this.G).createFromThreadCfg(this.F, null, this.c0, 0, true, false, false).addLocateParam("");
                addLocateParam.setForumId(String.valueOf(this.F.getFid()));
                addLocateParam.setForumName(this.F.getForum_name());
                if (this.F.getIsDailyThread() && this.F.getForumData() != null) {
                    addLocateParam.setForumId(this.F.getForumData().b());
                    addLocateParam.setForumName(this.F.getForumData().d());
                }
                addLocateParam.setJumpToCommentArea(true);
                m mVar2 = this.r0;
                if (mVar2 != null) {
                    mVar2.a(addLocateParam);
                }
                if (TbSingleton.getInstance().isPbPreloadSwitchOn() && z(this.F)) {
                    addLocateParam.setNeedPreLoad(true);
                    if7.update(this.F);
                }
                if (this.F.isQualityReplyThread) {
                    addLocateParam.setFromHomePageQuality(true);
                }
                if (this.F.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
                    addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
                }
                addLocateParam.setStartFrom(this.V);
                if (this.F.isSimilarPageType()) {
                    addLocateParam.setSimilarFrom(2);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            }
            StatisticItem statisticItem2 = new StatisticItem("c12291");
            statisticItem2.param("obj_locate", this.f1079T);
            TiebaStatic.log(statisticItem2);
            l();
            k(view2, this.F);
            View.OnClickListener onClickListener = this.e0;
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
            this.j0 = (LinearLayout) view2.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.thread_info_commont_num);
            this.f = eMTextView;
            EMManager.from(eMTextView).setTextStyle(R.string.F_X01);
            this.g = (ImageView) view2.findViewById(R.id.thread_info_commont_img);
            this.h = (EMTextView) view2.findViewById(R.id.thread_info_commont_grab_sofa);
            this.i = view2.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.share_num);
            this.j = eMTextView2;
            EMManager.from(eMTextView2).setTextStyle(R.string.F_X01);
            this.k = (ImageView) view2.findViewById(R.id.share_num_img);
            this.l = view2.findViewById(R.id.share_num_container);
            this.m = (FrameLayout) view2.findViewById(R.id.btn_card_bottom_op_more_container);
            this.n = (ImageView) view2.findViewById(R.id.btn_card_bottom_op_more);
            View findViewById = view2.findViewById(R.id.new_agree_view);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.e = agreeView;
                agreeView.setIsAgreeNumClick(true);
                this.e.setAfterClickListener(new c(this));
                this.e.setUseLikeDefaultRes(this.d);
                this.e.setAgreeLongClickListener(new d(this, new c95(this.H)));
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
            linearLayout.setOnTouchListener(new e(this));
            this.z.setOnClickListener(new f(this));
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
            this.A.setOnClickListener(new g(this));
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
            r();
        }
    }

    public void F(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (this.r == null) {
                this.r = new dn6(this.H, A(16));
            }
            this.r.f0(this.F);
            this.r.l();
            if (this.F != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.F.getFid()).param("tid", this.F.getId()));
            }
        }
    }

    public void J(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.G)) || this.F == null) {
                return;
            }
            K();
            k(view2, this.F);
            if (AntiHelper.e(getContext(), this.F)) {
                return;
            }
            mf5.f(this.G, this.F, this.U, this.f1079T);
            View.OnClickListener onClickListener = this.e0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void P(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) && this.q != null && threadData != null) {
            int i2 = 4;
            this.O = A(4);
            if (threadData.mOriginalForumInfo != null) {
                this.O = false;
            }
            if (this.O && ((linearLayout = this.A) == null || linearLayout.getVisibility() == 8)) {
                this.q.setVisibility(0);
                String string = this.G.getString(R.string.obfuscated_res_0x7f0f0c32);
                this.o.setText(string);
                this.o.setContentDescription(string);
                this.I = true;
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

    public final void S(ThreadData threadData) {
        String replyTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) && this.c != null && threadData != null) {
            if (threadData.getLast_time_int() > 0 && this.J) {
                this.c.setVisibility(0);
                if (this.f1079T == 3) {
                    replyTime = threadData.getReplyTimeForMyThread();
                } else {
                    replyTime = threadData.getReplyTime();
                }
                this.c.setText(replyTime);
                this.I = true;
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
            this.F = threadData;
            O();
            M(threadData);
            S(threadData);
            R(threadData);
            N(threadData);
            U(threadData);
            updatePraiseNum(threadData);
            T(threadData);
            P(threadData);
            if (!this.I) {
                i2 = 8;
            }
            setVisibility(i2);
            Q(threadData);
            E();
            return this.I;
        }
        return invokeL.booleanValue;
    }

    public void I(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && this.y != null && (threadData = this.F) != null && this.z != null && !threadData.isTransportThread()) {
            boolean z = true;
            if (!this.F.isMarkToDel() && ye7.f().i()) {
                if (ye7.f().a(this.F)) {
                    this.F.setMarkToDel(true);
                }
            } else if (!this.F.isMarkToMove() && xe7.h().j()) {
                if (xe7.h().a(this.F)) {
                    this.F.setMarkToMove(true);
                }
            } else {
                ye7.f().l(this.F);
                this.F.setMarkToDel(false);
                xe7.h().l(this.F);
                this.F.setMarkToMove(false);
            }
            if (!this.F.isMarkToDel() && !this.F.isMarkToMove()) {
                EMManager.from(this.z).setTextSelectorColor(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            n nVar = this.i0;
            if (nVar != null) {
                if (!this.F.isMarkToDel() && !this.F.isMarkToMove()) {
                    z = false;
                }
                nVar.a(z);
            }
        }
    }

    public void T(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) && this.A != null && this.y != null && this.z != null && threadData != null) {
            if (!this.s0) {
                View view2 = this.g0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.A.setVisibility(8);
            } else if (this.P && !A(128) && (ye7.f().i() || xe7.h().j())) {
                if (this.g0 == null) {
                    View view3 = new View(getContext());
                    this.g0 = view3;
                    SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                    addView(this.g0);
                    this.g0.setAlpha(0.5f);
                    this.g0.setOnTouchListener(new j(this));
                    this.g0.setOnClickListener(new k(this));
                }
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g0.getLayoutParams();
                if (layoutParams == null) {
                    this.g0.setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, -1));
                } else {
                    layoutParams.width = equipmentWidth;
                    requestLayout();
                }
                if (!this.F.isMarkToDel() && !this.F.isMarkToMove()) {
                    EMManager.from(this.z).setTextSelectorColor(R.color.CAM_X0107);
                    WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                    WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
                }
                this.g0.setVisibility(0);
                this.A.setVisibility(8);
            } else {
                View view4 = this.g0;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
                this.A.setVisibility(8);
            }
        }
    }

    public void h(@NonNull View view2) {
        TbPageContext tbPageContext;
        int dimens;
        int dimens2;
        int width;
        int dimens3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, view2) == null) && this.e.getData() != null && this.e.getData().hasAgree && (tbPageContext = this.H) != null && tbPageContext.getPageActivity() != null && this.e.getImgAgree() != null) {
            if (!this.Q || (this.e.getAgreeFlag() && !this.e.L())) {
                PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(getContext());
                int[] iArr = new int[2];
                this.e.getImgAgree().getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (this.Q) {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
                } else {
                    dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds600);
                }
                if (this.Q) {
                    dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708fb);
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
                if (this.Q) {
                    dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
                } else {
                    dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                layoutParams.topMargin = dimens3;
                pbFirstFloorDoubleClickAnimation.setLottieHeight(dimens);
                pbFirstFloorDoubleClickAnimation.setLayoutParmas(layoutParams);
                pbFirstFloorDoubleClickAnimation.setClippingEnable(false);
                pbFirstFloorDoubleClickAnimation.showFireworks(this.R, this.H.getPageActivity().findViewById(16908290), 0, i3 - 10, this.F.getTid(), String.valueOf(this.F.getFid()));
                pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new b(this));
            }
        }
    }

    public final StatisticItem i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            if (this.F == null && i2 < 0) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("c12003");
            statisticItem.param("tid", this.F.getTid());
            if (this.F.getThreadType() == 40) {
                statisticItem.param("obj_param1", "2");
            } else if (this.F.getThreadType() == 0) {
                statisticItem.param("obj_param1", "1");
            }
            statisticItem.param("obj_source", "1");
            statisticItem.param("fid", this.F.getFid());
            statisticItem.param("obj_locate", this.f1079T);
            statisticItem.param("obj_id", i2);
            if (!bi.isEmpty(this.W)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.W);
            }
            if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            }
            statisticItem.param("nid", this.F.getNid());
            statisticItem.param("card_type", this.F.getRecomCardType());
            statisticItem.param("recom_source", this.F.mRecomSource);
            statisticItem.param("ab_tag", this.F.mRecomAbTag);
            statisticItem.param("weight", this.F.mRecomWeight);
            statisticItem.param("extra", this.F.mRecomExtra);
            if (this.F.getBaijiahaoData() != null && !bi.isEmpty(this.F.getBaijiahaoData().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.F.getBaijiahaoData().oriUgcVid);
            }
            br5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
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
        if (interceptable == null || interceptable.invokeL(1048674, this, threadData) == null) {
            setAgreeViewType(threadData);
            if (threadData.getAgreeData() != null) {
                threadData.getAgreeData().isInThread = true;
                this.e.setCardType(threadData.getRecomCardType());
                this.e.setThreadData(threadData);
                this.e.setData(threadData.getAgreeData());
            }
            AgreeView agreeView = this.e;
            ThreadData threadData2 = this.F;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
            } else {
                f2 = 1.0f;
            }
            agreeView.setAlpha(f2);
            if (!this.e.J() && this.e.getFriendBotView() != null && this.D.getVisibility() != 0 && threadData.getCallRobotEntrance() != null && wb9.c()) {
                s();
                this.D.setVisibility(0);
                this.D.playAnimation();
                this.e.getFriendBotView().t();
                SafeHandler.getInst().removeCallbacks(this.v0);
                SafeHandler.getInst().postDelayed(this.v0, 4000L);
            } else if (!this.e.J() && this.B.getVisibility() != 0) {
                u();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb");
                if (this.e.getTbPageContext() != null && this.e.getTbPageContext().getPageActivity() != null && this.e.getTbPageContext().getPageActivity().getIntent() != null && this.e.getTbPageContext().getPageActivity().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.E && SharedPrefHelper.getInstance().getInt(sharedPrefKeyWithAccount, 0) == 2 && this.C) {
                    this.E = true;
                    this.B.setVisibility(0);
                    this.B.playAnimation();
                    SafeHandler.getInst().postDelayed(this.u0, 4000L);
                }
            }
        }
    }

    public void R(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) && this.f != null && threadData != null) {
            if (this.M) {
                this.i.setVisibility(0);
                if (threadData.getReply_num() > 0) {
                    this.f.setVisibility(0);
                    String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                    if (this.L) {
                        updateReplyStateUI();
                        this.f.setText(numFormatOverWan);
                    } else {
                        this.f.setText(String.format(this.G.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    EMTextView eMTextView = this.f;
                    eMTextView.setContentDescription(this.G.getString(R.string.reply_num) + numFormatOverWan);
                    this.I = true;
                    return;
                } else if (this.L) {
                    updateReplyStateUI();
                    this.f.setText(this.G.getString(R.string.action_comment_default));
                    this.f.setVisibility(0);
                    this.I = true;
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
        if (interceptable == null || interceptable.invokeL(1048677, this, threadData) == null) {
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(threadData)) {
                setShareClickable(true);
                this.j.setTextColor(y9a.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (threadData != null && threadData.originalThreadData != null) {
                    ThreadData threadData2 = this.F;
                    if (threadData2.originalThreadData.m || threadData2.shouldShowBlockedState()) {
                        setShareClickable(false);
                        this.j.setTextColor(y9a.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                EMManager.from(this.j).setTextSelectorColor(R.color.CAM_X0107);
            }
            k95.a(this.k, R.drawable.icon_pure_card_share20);
            k95.e(this.j);
            ThreadData threadData3 = this.F;
            if (threadData3 != null && threadData3.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.k.setEnabled(false);
                this.j.setTextColor(y9a.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.j0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final StatisticItem j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.F == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.U;
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
            statisticItem.param("fid", this.F.getFid());
            statisticItem.param("tid", this.F.getTid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.a0);
            if (!bi.isEmpty(this.W)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.W);
            }
            if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.F.getThreadAlaInfo() != null && this.F.getThreadAlaInfo().user_info != null && this.F.getThreadAlaInfo().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.F.getThreadAlaInfo().user_info.is_official);
            }
            statisticItem.param("card_type", this.F.getRecomCardType()).param("ab_tag", this.F.mRecomAbTag).param("recom_source", this.F.mRecomSource).param("weight", this.F.mRecomWeight).param("extra", this.F.mRecomExtra);
            if (this.F.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 10);
            } else if (this.F.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (this.F.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (this.F.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else {
                ThreadData threadData = this.F;
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
            int i5 = this.f1079T;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.f1079T == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param("resource_id", this.b0);
            }
            if (this.F.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.F.getBaijiahaoData().oriUgcNid);
                if (this.F.isBJHVideoThreadType() || this.F.isBJHVideoDynamicThreadType()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.F.getBaijiahaoData().oriUgcVid);
                }
            }
            if (this.F.isBjhDynamicThread()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.F.isBJHArticleThreadType() && !this.F.isBJHVideoThreadType()) {
                int i6 = this.F.threadType;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.H;
            if (tbPageContext != null) {
                gr5.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.F.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void k(View view2, ThreadData threadData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048611, this, view2, threadData) != null) || threadData == null) {
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
        int i4 = this.f1079T;
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
            TiebaStatic.log(s9a.l("c13694", threadData, i3, i2));
        }
    }

    public final void n(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048615, this, context, threadData) != null) || this.t0 || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.f1079T;
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
        vv5.e(context, arrayList, str4, z, 0, null, "from_nani_video", "personalize_page", "", str2, str2, true, threadData.isJumpToFrsVideoTabPlay, true, threadData.getFid());
    }

    public final void o() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
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

    public void onChangeSkinType() {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && this.f0 != TbadkCoreApplication.getInst().getSkinType()) {
            this.f0 = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.g0, R.color.CAM_X0201);
            MaskView maskView = this.h0;
            if (maskView != null) {
                maskView.f();
            }
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            updateReplyStateUI();
            updateCollectStateUI(this.F);
            updateShareStateUI(this.F);
            updateManagerUI();
            dn6 dn6Var = this.r;
            if (dn6Var != null) {
                dn6Var.d0();
            }
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.Q(this.f0);
                AgreeView agreeView2 = this.e;
                ThreadData threadData = this.F;
                if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
                } else {
                    f2 = 1.0f;
                }
                agreeView2.setAlpha(f2);
            }
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, context) == null) {
            this.G = context;
            if (context instanceof BaseActivity) {
                this.H = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.H = ((BaseFragmentActivity) context).getPageContext();
            }
            BdUtilHelper.getDimens(this.G, R.dimen.tbds84);
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
}
