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
import com.baidu.tieba.ah;
import com.baidu.tieba.bs4;
import com.baidu.tieba.cz4;
import com.baidu.tieba.dk6;
import com.baidu.tieba.i56;
import com.baidu.tieba.j65;
import com.baidu.tieba.kz7;
import com.baidu.tieba.l65;
import com.baidu.tieba.mq8;
import com.baidu.tieba.ob5;
import com.baidu.tieba.pe5;
import com.baidu.tieba.q45;
import com.baidu.tieba.rq8;
import com.baidu.tieba.rw4;
import com.baidu.tieba.ry4;
import com.baidu.tieba.s46;
import com.baidu.tieba.sj5;
import com.baidu.tieba.sj6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tj6;
import com.baidu.tieba.ty4;
import com.baidu.tieba.ue5;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadCommentAndPraiseInfoLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public TBLottieAnimationView B;
    public boolean C;
    public ThreadData D;
    public Context E;
    public TbPageContext F;
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
    public String T;
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
    public l f0;
    public ImageView g;
    public LinearLayout g0;
    public EMTextView h;
    public k h0;
    public View i;
    public boolean i0;
    public EMTextView j;
    public Runnable j0;
    public ImageView k;
    public View l;
    public FrameLayout m;
    public ImageView n;
    public EMTextView o;
    public ImageView p;
    public View q;
    public CustomMessageListener q0;
    public i56 r;
    public CustomMessageListener r0;
    public LinearLayout s;
    public ImageView t;
    public EMTextView u;
    public LinearLayout v;
    public ImageView w;
    public EMTextView x;
    public ImageView y;
    public EMTextView z;

    /* loaded from: classes3.dex */
    public interface k {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes3.dex */
    public interface l {
        void a(boolean z);
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
        }
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
        }
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
        }
    }

    public void u(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
        }
    }

    public final void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, view2) == null) {
        }
    }

    public void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, view2) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AgreeView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty4 a;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* loaded from: classes3.dex */
        public class a implements j65 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.j65
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, list) != null) {
                    return;
                }
                this.a.b.setAgreeNumViewIsShow(false);
                Rect rect = new Rect();
                this.a.b.e.getImgAgree().getGlobalVisibleRect(rect);
                this.a.a.j(false);
                TbPageContext tbPageContext = this.a.b.F;
                if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                    b bVar = this.a;
                    bVar.a.k(bVar.b.F.getPageActivity().findViewById(16908290), list, rect);
                }
            }
        }

        public b(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, ty4 ty4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, ty4Var};
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
            this.a = ty4Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.g
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ty4 ty4Var = this.a;
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.b;
                ty4Var.l(threadCommentAndPraiseInfoLayout.g0, threadCommentAndPraiseInfoLayout.e);
                l65.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.g
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

    /* loaded from: classes3.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !PraiseSwitch.isOn() || this.a.e.H()) {
                return;
            }
            if (this.a.b0 != null) {
                this.a.b0.onClick(view2);
            }
            if (!WindowGreySwitch.getIsOnNew()) {
                this.a.e(view2);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.h(view2, threadCommentAndPraiseInfoLayout.D);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
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

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class f implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.B != null) {
                this.a.B.setVisibility(8);
                this.a.B.pauseAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
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

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements kz7.d {
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

        @Override // com.baidu.tieba.kz7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.S();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (threadCommentAndPraiseInfoLayout.D != null && threadData != null) {
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (threadCommentAndPraiseInfoLayout.D.getBaijiahaoData() != null) {
                    str2 = threadCommentAndPraiseInfoLayout.D.getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        threadCommentAndPraiseInfoLayout.D.setReply_num(threadData.getReply_num());
                        threadCommentAndPraiseInfoLayout.J(threadData);
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = threadCommentAndPraiseInfoLayout.D.getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    threadCommentAndPraiseInfoLayout.D.setReply_num(threadData.getReply_num());
                    threadCommentAndPraiseInfoLayout.J(threadData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ThreadCommentAndPraiseInfoLayout> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
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
            if (!TextUtils.isEmpty(str) && (threadData = threadCommentAndPraiseInfoLayout.D) != null && !"0".equals(threadData.getId()) && str.equals(threadCommentAndPraiseInfoLayout.D.getId())) {
                if ((threadCommentAndPraiseInfoLayout.D.isLiveThread() || threadCommentAndPraiseInfoLayout.D.isSharedLiveThread()) && threadCommentAndPraiseInfoLayout.D.getThreadAlaInfo() != null) {
                    if (threadCommentAndPraiseInfoLayout.D.getThreadAlaInfo() != null && threadCommentAndPraiseInfoLayout.D.getThreadAlaInfo().share_info != null) {
                        threadCommentAndPraiseInfoLayout.D.getThreadAlaInfo().share_info.share_count++;
                    }
                } else {
                    ThreadData threadData2 = threadCommentAndPraiseInfoLayout.D;
                    threadData2.setShareNum(threadData2.getShareNum() + 1);
                }
                threadCommentAndPraiseInfoLayout.M(threadCommentAndPraiseInfoLayout.D);
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
        yi.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.C = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = 2;
        this.R = 1;
        this.c0 = 3;
        this.f0 = null;
        this.i0 = true;
        this.j0 = new f(this);
        this.q0 = new j(this);
        this.r0 = new m(this);
        m(context);
    }

    public void M(ThreadData threadData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) && (view2 = this.l) != null && this.j != null && threadData != null) {
            if (this.L) {
                view2.setVisibility(0);
                long shareNum = threadData.getShareNum();
                if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                    shareNum = threadData.getThreadAlaInfo().share_info.share_count;
                }
                String string = this.E.getString(R.string.obfuscated_res_0x7f0f11b7);
                if (shareNum > 0) {
                    string = StringHelper.numFormatOverWan(shareNum);
                }
                this.j.setText(string);
                this.G = true;
                updateShareStateUI(threadData);
                return;
            }
            view2.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                return;
            }
            if (view2 == this.b) {
                t(view2);
            } else if (view2 == this.i) {
                v(view2);
                int i2 = this.Q;
                if (i2 == 1 || i2 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.l) {
                B(view2);
                int i3 = this.Q;
                if (i3 == 1 || i3 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.n) {
                y(view2);
            } else if (view2 == this.q) {
                x(view2);
            } else if (view2 == this.y) {
                A(view2);
            } else if (view2 == this.s) {
                z(view2);
            } else if (view2 == this.v) {
                u(view2);
            }
        }
    }

    public final void t(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, view2) == null) && (threadData = this.D) != null && !StringUtils.isNull(threadData.getForum_name())) {
            if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.a0)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.E).createCfgForpersonalized(this.D.getForum_name(), this.W, this.a0)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.E).createNormalCfg(this.D.getForum_name(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
            View.OnClickListener onClickListener = this.b0;
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
        yi.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.C = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = 2;
        this.R = 1;
        this.c0 = 3;
        this.f0 = null;
        this.i0 = true;
        this.j0 = new f(this);
        this.q0 = new j(this);
        this.r0 = new m(this);
        m(context);
    }

    public final void k(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048605, this, context, threadData) != null) || threadData == null) {
            return;
        }
        VideoItemData videoItemData = new VideoItemData();
        ArrayList arrayList = new ArrayList();
        int i2 = this.Q;
        boolean z = true;
        if (i2 == 2) {
            str = "frs";
        } else if (i2 != 4 && i2 != 9 && i2 != 1) {
            str = "";
        } else {
            str = "index";
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
        sj5.e(context, arrayList, str4, z, 0, null, "from_nani_video", "personalize_page", "", str2, str2, true, threadData.isJumpToFrsVideoTabPlay, true, threadData.getFid());
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
        yi.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.a = 11;
        this.d = true;
        this.C = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = true;
        this.P = true;
        this.Q = 2;
        this.R = 1;
        this.c0 = 3;
        this.f0 = null;
        this.i0 = true;
        this.j0 = new f(this);
        this.q0 = new j(this);
        this.r0 = new m(this);
        this.d = z;
        m(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgreeNumViewIsShow(boolean z) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65547, this, z) == null) && (agreeView = this.e) != null && agreeView.getAgreeNumView() != null) {
            if (z) {
                this.e.getAgreeNumView().setVisibility(0);
            } else {
                this.e.getAgreeNumView().setVisibility(4);
            }
        }
    }

    public void D(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            this.b.setVisibility(8);
        }
    }

    public void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            EMTextView eMTextView = this.x;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0afc);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void H(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, threadData) != null) || threadData == null || this.Q != 13) {
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
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.D == null && i2 < 0) {
                return;
            }
            StatisticItem f2 = f(i2);
            f2.param("thread_type", this.D.getThreadType());
            TiebaStatic.log(f2);
        }
    }

    public View j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, context)) == null) {
            return LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        }
        return (View) invokeL.objValue;
    }

    public void manualPraise(Animator.AnimatorListener animatorListener) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, animatorListener) == null) && (agreeView = this.e) != null && agreeView.getImgAgree() != null) {
            this.e.setAgreeAnimationListenOnce(true);
            this.e.setAgreeAnimationListener(animatorListener);
            this.e.getImgAgree().performClick();
        }
    }

    public final boolean r(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, threadData)) == null) {
            if (threadData != null && threadData.isVideoThreadType() && threadData.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            if ((i2 & this.a) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setAgreeStatisticData(bs4 bs4Var) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, bs4Var) == null) && (agreeView = this.e) != null) {
            agreeView.setStatisticData(bs4Var);
        }
    }

    public void setAgreeViewType(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, threadData) == null) && threadData != null && threadData.isUgcThreadType()) {
            this.e.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.I = z;
            TextView textView = this.b;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z) == null) && (linearLayout = this.v) != null) {
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
        if ((interceptable == null || interceptable.invokeZ(1048626, this, z) == null) && (view2 = this.i) != null) {
            view2.setClickable(z);
            this.g.setEnabled(z);
            this.f.setEnabled(z);
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, context) == null) {
            this.E = context;
            if (this.F == null) {
                if (context instanceof BaseActivity) {
                    this.F = ((BaseActivity) context).getPageContext();
                } else if (context instanceof BaseFragmentActivity) {
                    this.F = ((BaseFragmentActivity) context).getPageContext();
                }
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.Q = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.U = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.i0 = z;
        }
    }

    public void setIsPbFirst(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.O = z;
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.M = z;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.J = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.P = z;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setNeedMatchStrategy(z);
            }
        }
    }

    public void setOnCommentClickCallback(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, kVar) == null) {
            this.h0 = kVar;
        }
    }

    public void setOnSelectStatusChangeListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, lVar) == null) {
            this.f0 = lVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048646, this, z) == null) && (linearLayout = this.s) != null) {
            if (z) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public void setReplyTimeVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.H = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.N = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048649, this, z) == null) && (view2 = this.l) != null) {
            view2.setClickable(z);
            this.k.setEnabled(z);
            this.j.setEnabled(z);
        }
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.R = i2;
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            this.a = i2;
            l();
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.W = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, str) == null) {
            this.V = str;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.a0 = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
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

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            TbPageContext tbPageContext = this.F;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
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

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.D == null) {
            return;
        }
        StatisticItem g2 = g();
        g2.param("thread_type", this.D.getThreadType());
        TiebaStatic.log(g2);
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            cz4.b(this.g0);
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            onClick(this.y);
        }
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.e.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.L = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
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

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.q0);
            MessageManager.getInstance().registerListener(this.r0);
        }
    }

    public void onDestroy() {
        i56 i56Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (i56Var = this.r) != null) {
            i56Var.S();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.r0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            q(j(this.E));
        }
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.L = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = this.E.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.g.setLayoutParams(layoutParams);
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048657, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeRes();
        }
    }

    public void setUseDynamicLikeResImmediately() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048658, this) == null) && (agreeView = this.e) != null) {
            agreeView.setUseDynamicLikeResImmediately();
        }
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            ThreadData threadData = this.D;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isShareThread) {
                return 4;
            }
            if (threadData.getThreadType() != 49 && this.D.getThreadType() != 69) {
                if (this.D.getThreadVideoInfo() != null) {
                    return 1;
                }
                if (this.D.getType() != ThreadData.TYPE_NORMAL && this.D.getType() != ThreadData.TYPE_GOD_NORMAL) {
                    return 0;
                }
                if (ListUtils.getCount(this.D.getVoice()) > 0) {
                    return 3;
                }
                return 2;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.B = new TBLottieAnimationView(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.g(this.E, R.dimen.tbds715), yi.g(this.E, R.dimen.tbds110));
            layoutParams.setMargins(0, 0, yi.l(this.E) / 6, 0);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.B, layoutParams);
            o();
            this.B.setVisibility(8);
        }
    }

    public void updateManagerUI() {
        int color;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.o;
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = rq8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.p;
            ThreadData threadData2 = this.D;
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
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            if (this.J) {
                WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.g;
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                z = false;
            } else {
                z = true;
            }
            imageView.setEnabled(z);
            cz4.a(this.g, R.drawable.icon_pure_card_comment20);
            cz4.e(this.f);
            ThreadData threadData2 = this.D;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.f.setTextColor(rq8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            ThreadData threadData = this.D;
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (this.D.isBJHVideoThreadType()) {
                return 2;
            }
            if (this.D.isBJHNormalThreadType()) {
                return 3;
            }
            if (!this.D.isBJHVideoDynamicThreadType()) {
                return 0;
            }
            return 4;
        }
        return invokeV.intValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.B != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img");
            } else {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img_dark");
            }
            SkinManager.setLottieAnimation(this.B, R.raw.lottie_reactions_guide_right);
        }
    }

    public void A(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.y != null && (threadData = this.D) != null && this.z != null && !threadData.isTransportThread()) {
            boolean z = true;
            if (!this.D.isMarkToDel() && tj6.f().i()) {
                if (tj6.f().a(this.D)) {
                    this.D.setMarkToDel(true);
                }
            } else if (!this.D.isMarkToMove() && sj6.h().j()) {
                if (sj6.h().a(this.D)) {
                    this.D.setMarkToMove(true);
                }
            } else {
                tj6.f().l(this.D);
                this.D.setMarkToDel(false);
                sj6.h().l(this.D);
                this.D.setMarkToMove(false);
            }
            if (!this.D.isMarkToDel() && !this.D.isMarkToMove()) {
                rw4.d(this.z).x(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.y, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            l lVar = this.f0;
            if (lVar != null) {
                if (!this.D.isMarkToDel() && !this.D.isMarkToMove()) {
                    z = false;
                }
                lVar.a(z);
            }
        }
    }

    public void L(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) && this.A != null && this.y != null && this.z != null && threadData != null) {
            if (!this.i0) {
                View view2 = this.d0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.A.setVisibility(8);
            } else if (this.N && !s(128) && (tj6.f().i() || sj6.h().j())) {
                if (this.d0 == null) {
                    View view3 = new View(getContext());
                    this.d0 = view3;
                    SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                    addView(this.d0);
                    this.d0.setAlpha(0.5f);
                    this.d0.setOnTouchListener(new g(this));
                    this.d0.setOnClickListener(new h(this));
                }
                int l2 = yi.l(getContext());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d0.getLayoutParams();
                if (layoutParams == null) {
                    this.d0.setLayoutParams(new RelativeLayout.LayoutParams(l2, -1));
                } else {
                    layoutParams.width = l2;
                    requestLayout();
                }
                if (!this.D.isMarkToDel() && !this.D.isMarkToMove()) {
                    rw4.d(this.z).x(R.color.CAM_X0107);
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

    public void e(@NonNull View view2) {
        TbPageContext tbPageContext;
        int g2;
        int g3;
        int width;
        int g4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && this.e.getData() != null && this.e.getData().hasAgree && (tbPageContext = this.F) != null && tbPageContext.getPageActivity() != null && this.e.getImgAgree() != null) {
            if (!this.O || (this.e.getAgreeFlag() && !this.e.I())) {
                kz7 kz7Var = new kz7(getContext());
                int[] iArr = new int[2];
                this.e.getImgAgree().getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (this.O) {
                    g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
                } else {
                    g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds600);
                }
                if (this.O) {
                    g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
                } else {
                    g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                }
                int i4 = (int) ((g3 * 1) / 1.45d);
                if (i2 > i4) {
                    width = ((i2 - i4) + (this.e.getImgAgree().getWidth() / 2)) - 10;
                } else {
                    width = (i2 - i4) + (this.e.getImgAgree().getWidth() / 2);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
                layoutParams.leftMargin = width;
                if (this.O) {
                    g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
                } else {
                    g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                layoutParams.topMargin = g4;
                kz7Var.k(g2);
                kz7Var.j(layoutParams);
                kz7Var.i(false);
                kz7Var.n(this.P, this.F.getPageActivity().findViewById(16908290), 0, i3 - 10, this.D.getTid(), String.valueOf(this.D.getFid()));
                kz7Var.l(new i(this));
            }
        }
    }

    public final StatisticItem f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (this.D == null && i2 < 0) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("c12003");
            statisticItem.param("tid", this.D.getTid());
            if (this.D.getThreadType() == 40) {
                statisticItem.param("obj_param1", "2");
            } else if (this.D.getThreadType() == 0) {
                statisticItem.param("obj_param1", "1");
            }
            statisticItem.param("obj_source", "1");
            statisticItem.param("fid", this.D.getFid());
            statisticItem.param("obj_locate", this.Q);
            statisticItem.param("obj_id", i2);
            if (!xi.isEmpty(this.T)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.T);
            }
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            }
            statisticItem.param("nid", this.D.getNid());
            statisticItem.param("card_type", this.D.getRecomCardType());
            statisticItem.param("recom_source", this.D.mRecomSource);
            statisticItem.param("ab_tag", this.D.mRecomAbTag);
            statisticItem.param("weight", this.D.mRecomWeight);
            statisticItem.param("extra", this.D.mRecomExtra);
            if (this.D.getBaijiahaoData() != null && !xi.isEmpty(this.D.getBaijiahaoData().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.D.getBaijiahaoData().oriUgcVid);
            }
            pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
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

    public void B(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.E)) || this.D == null) {
                return;
            }
            C();
            h(view2, this.D);
            if (AntiHelper.e(getContext(), this.D)) {
                return;
            }
            q45.f(this.E, this.D, this.R, this.Q);
            View.OnClickListener onClickListener = this.b0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void G(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) && this.q != null && threadData != null) {
            int i2 = 4;
            this.M = s(4);
            if (threadData.mOriginalForumInfo != null) {
                this.M = false;
            }
            if (this.M && ((linearLayout = this.A) == null || linearLayout.getVisibility() == 8)) {
                this.q.setVisibility(0);
                String string = this.E.getString(R.string.obfuscated_res_0x7f0f0af2);
                this.o.setText(string);
                this.o.setContentDescription(string);
                this.G = true;
            } else {
                View view2 = this.q;
                if (!s(64)) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
            updateManagerUI();
        }
    }

    public final void K(ThreadData threadData) {
        String replyTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) && this.c != null && threadData != null) {
            if (threadData.getLast_time_int() > 0 && this.H) {
                this.c.setVisibility(0);
                if (this.Q == 3) {
                    replyTime = threadData.getReplyTimeForMyThread();
                } else {
                    replyTime = threadData.getReplyTime();
                }
                this.c.setText(replyTime);
                this.G = true;
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public boolean setData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, threadData)) == null) {
            int i2 = 0;
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.D = threadData;
            F();
            D(threadData);
            K(threadData);
            J(threadData);
            E(threadData);
            M(threadData);
            updatePraiseNum(threadData);
            L(threadData);
            G(threadData);
            if (!this.G) {
                i2 = 8;
            }
            setVisibility(i2);
            H(threadData);
            w();
            return this.G;
        }
        return invokeL.booleanValue;
    }

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, view2) == null) {
            if (this.r == null) {
                this.r = new i56(this.F, s(16));
            }
            this.r.e0(this.D);
            this.r.k();
            if (this.D != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.D.getFid()).param("tid", this.D.getId()));
            }
        }
    }

    public void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) && this.f != null && threadData != null) {
            if (this.K) {
                this.i.setVisibility(0);
                if (threadData.getReply_num() > 0) {
                    this.f.setVisibility(0);
                    String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                    if (this.J) {
                        updateReplyStateUI();
                        this.f.setText(numFormatOverWan);
                    } else {
                        this.f.setText(String.format(this.E.getString(R.string.reply_num_tip), numFormatOverWan));
                    }
                    EMTextView eMTextView = this.f;
                    eMTextView.setContentDescription(this.E.getString(R.string.reply_num) + numFormatOverWan);
                    this.G = true;
                    return;
                } else if (this.J) {
                    updateReplyStateUI();
                    this.f.setText(this.E.getString(R.string.action_comment_default));
                    this.f.setVisibility(0);
                    this.G = true;
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
        if (interceptable == null || interceptable.invokeL(1048666, this, threadData) == null) {
            setAgreeViewType(threadData);
            if (threadData.getAgreeData() != null) {
                threadData.getAgreeData().isInThread = true;
                this.e.setCardType(threadData.getRecomCardType());
                this.e.setThreadData(threadData);
                this.e.setData(threadData.getAgreeData());
            }
            AgreeView agreeView = this.e;
            ThreadData threadData2 = this.D;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
            } else {
                f2 = 1.0f;
            }
            agreeView.setAlpha(f2);
            if (!this.e.G() && this.B.getVisibility() != 0) {
                o();
                String p = ry4.p("key_reaction_guide_show_number_pb");
                if (this.e.getTbPageContext() != null && this.e.getTbPageContext().getPageActivity() != null && this.e.getTbPageContext().getPageActivity().getIntent() != null && this.e.getTbPageContext().getPageActivity().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.C && ry4.l().m(p, 0) == 2) {
                    this.C = true;
                    this.B.setVisibility(0);
                    this.B.playAnimation();
                    ah.a().postDelayed(this.j0, 4000L);
                }
            }
        }
    }

    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, threadData) == null) {
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(threadData)) {
                setShareClickable(true);
                this.j.setTextColor(rq8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (threadData != null && threadData.originalThreadData != null) {
                    ThreadData threadData2 = this.D;
                    if (threadData2.originalThreadData.m || threadData2.shouldShowBlockedState()) {
                        setShareClickable(false);
                        this.j.setTextColor(rq8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                rw4.d(this.j).x(R.color.CAM_X0107);
            }
            cz4.a(this.k, R.drawable.icon_pure_card_share20);
            cz4.e(this.j);
            ThreadData threadData3 = this.D;
            if (threadData3 != null && threadData3.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.k.setEnabled(false);
                this.j.setTextColor(rq8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    public final StatisticItem g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.D == null) {
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
                i2 = 13;
            } else if (i3 == 14) {
                i2 = 30;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("fid", this.D.getFid());
            statisticItem.param("tid", this.D.getTid());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.U);
            if (!xi.isEmpty(this.T)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.T);
            }
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.D.getThreadAlaInfo() != null && this.D.getThreadAlaInfo().user_info != null && this.D.getThreadAlaInfo().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.D.getThreadAlaInfo().user_info.is_official);
            }
            statisticItem.param("card_type", this.D.getRecomCardType()).param("ab_tag", this.D.mRecomAbTag).param("recom_source", this.D.mRecomSource).param("weight", this.D.mRecomWeight).param("extra", this.D.mRecomExtra);
            if (this.D.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 10);
            } else if (this.D.isBJHVideoThreadType()) {
                statisticItem.param("obj_type", 9);
            } else if (this.D.isBJHVideoDynamicThreadType()) {
                statisticItem.param("obj_type", 8);
            } else if (this.D.isBJHNormalThreadType()) {
                statisticItem.param("obj_type", 7);
            } else {
                ThreadData threadData = this.D;
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
            if (this.D.getBaijiahaoData() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.D.getBaijiahaoData().oriUgcNid);
                if (this.D.isBJHVideoThreadType() || this.D.isBJHVideoDynamicThreadType()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.D.getBaijiahaoData().oriUgcVid);
                }
            }
            if (this.D.isBjhDynamicThread()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.D.isBJHArticleThreadType() && !this.D.isBJHVideoThreadType()) {
                int i6 = this.D.threadType;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.F;
            if (tbPageContext != null) {
                ue5.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.D.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.g0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void h(View view2, ThreadData threadData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, view2, threadData) != null) || threadData == null) {
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
        int i4 = this.Q;
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
            TiebaStatic.log(mq8.l("c13694", threadData, i3, i2));
        }
    }

    public final void l() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            View view2 = this.l;
            int i4 = 0;
            if (s(1)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            View view3 = this.i;
            if (s(2)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view3.setVisibility(i3);
            View view4 = this.q;
            int i5 = 4;
            if (s(4)) {
                i5 = 0;
            } else if (!s(64)) {
                i5 = 8;
            }
            view4.setVisibility(i5);
            AgreeView agreeView = this.e;
            if (!s(8)) {
                i4 = 8;
            }
            agreeView.setVisibility(i4);
            this.e.setAgreeAlone(s(32));
        }
    }

    public void onChangeSkinType() {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.c0 != TbadkCoreApplication.getInst().getSkinType()) {
            this.c0 = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.d0, R.color.CAM_X0201);
            MaskView maskView = this.e0;
            if (maskView != null) {
                maskView.f();
            }
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            updateReplyStateUI();
            updateCollectStateUI(this.D);
            updateShareStateUI(this.D);
            updateManagerUI();
            i56 i56Var = this.r;
            if (i56Var != null) {
                i56Var.c0();
            }
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.N(this.c0);
                AgreeView agreeView2 = this.e;
                ThreadData threadData = this.D;
                if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                    f2 = SkinManager.RESOURCE_ALPHA_DISABLE;
                } else {
                    f2 = 1.0f;
                }
                agreeView2.setAlpha(f2);
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, context) == null) {
            this.E = context;
            if (context instanceof BaseActivity) {
                this.F = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.F = ((BaseFragmentActivity) context).getPageContext();
            }
            yi.g(this.E, R.dimen.tbds84);
            p();
        }
    }

    public void setWeiXinShareGone(boolean z) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048659, this, z) == null) && (eMTextView = this.j) != null) {
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
        if ((interceptable == null || interceptable.invokeL(1048664, this, threadData) == null) && this.w != null) {
            if (threadData != null && threadData.getIsMarked() != 0) {
                WebPManager.setPureDrawable(this.w, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.w, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void q(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            this.b = (TextView) view2.findViewById(R.id.thread_info_bar_name);
            this.c = (TextView) view2.findViewById(R.id.thread_info_reply_time);
            this.g0 = (LinearLayout) view2.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.thread_info_commont_num);
            this.f = eMTextView;
            rw4.d(eMTextView).A(R.string.F_X01);
            this.g = (ImageView) view2.findViewById(R.id.thread_info_commont_img);
            this.h = (EMTextView) view2.findViewById(R.id.thread_info_commont_grab_sofa);
            this.i = view2.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.share_num);
            this.j = eMTextView2;
            rw4.d(eMTextView2).A(R.string.F_X01);
            this.k = (ImageView) view2.findViewById(R.id.share_num_img);
            this.l = view2.findViewById(R.id.share_num_container);
            this.m = (FrameLayout) view2.findViewById(R.id.btn_card_bottom_op_more_container);
            this.n = (ImageView) view2.findViewById(R.id.btn_card_bottom_op_more);
            View findViewById = view2.findViewById(R.id.new_agree_view);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.e = agreeView;
                agreeView.setIsAgreeNumClick(true);
                this.e.setAfterClickListener(new a(this));
                this.e.setUseLikeDefaultRes(this.d);
                this.e.setAgreeLongClickListener(new b(this, new ty4(this.F)));
            }
            this.q = view2.findViewById(R.id.manage_view_container);
            EMTextView eMTextView3 = (EMTextView) view2.findViewById(R.id.thread_info_manage_text);
            this.o = eMTextView3;
            rw4.d(eMTextView3).A(R.string.F_X01);
            this.p = (ImageView) view2.findViewById(R.id.thread_info_manage_img);
            this.y = (ImageView) view2.findViewById(R.id.manage_select_img);
            EMTextView eMTextView4 = (EMTextView) view2.findViewById(R.id.manage_select_text);
            this.z = eMTextView4;
            rw4.d(eMTextView4).A(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.manage_select_container);
            this.A = linearLayout;
            linearLayout.setOnTouchListener(new c(this));
            this.z.setOnClickListener(new d(this));
            this.s = (LinearLayout) view2.findViewById(R.id.qq_share_container);
            this.t = (ImageView) view2.findViewById(R.id.qq_share_image);
            EMTextView eMTextView5 = (EMTextView) view2.findViewById(R.id.qq_share_text);
            this.u = eMTextView5;
            if (eMTextView5 != null) {
                rw4.d(eMTextView5).A(R.string.F_X01);
            }
            this.v = (LinearLayout) view2.findViewById(R.id.collect_num_container);
            this.w = (ImageView) view2.findViewById(R.id.collect_num_image);
            EMTextView eMTextView6 = (EMTextView) view2.findViewById(R.id.collect_num_text);
            this.x = eMTextView6;
            if (eMTextView6 != null) {
                rw4.d(eMTextView6).A(R.string.F_X01);
            }
            this.A.setOnClickListener(new e(this));
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
            n();
        }
    }

    public void v(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048669, this, view2) == null) && (threadData = this.D) != null && this.E != null) {
            s46.a(threadData.getTid());
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", this.Q);
            statisticItem.param("obj_type", getThreadType());
            statisticItem.param("tid", this.D.getTid());
            statisticItem.param("nid", this.D.getNid());
            if (this.Q == 18) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.D.getFid());
                statisticItem.param("resource_id", this.V);
            }
            pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
            if (this.D.getVoiceRoomData() != null && this.D.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.D.getVoiceRoomData().room_name)) {
                ((ob5) ServiceManager.getService(ob5.a.a())).a(this.F, this.D.getVoiceRoomData().room_id.longValue());
            } else if (this.D.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.D.getThreadVideoInfo().video_url)) {
                k(this.E, this.D);
                k kVar = this.h0;
                if (kVar != null) {
                    kVar.a(null);
                }
            } else {
                PbActivityConfig addLocateParam = new PbActivityConfig(this.E).createFromThreadCfg(this.D, null, this.W, 0, true, false, false).addLocateParam("");
                addLocateParam.setForumId(String.valueOf(this.D.getFid()));
                addLocateParam.setForumName(this.D.getForum_name());
                if (this.D.getIsDailyThread() && this.D.getForumData() != null) {
                    addLocateParam.setForumId(this.D.getForumData().b());
                    addLocateParam.setForumName(this.D.getForumData().d());
                }
                addLocateParam.setJumpToCommentArea(true);
                k kVar2 = this.h0;
                if (kVar2 != null) {
                    kVar2.a(addLocateParam);
                }
                if (TbSingleton.getInstance().isPbPreloadSwitchOn() && r(this.D)) {
                    addLocateParam.setNeedPreLoad(true);
                    dk6.update(this.D);
                }
                if (this.D.isQualityReplyThread) {
                    addLocateParam.setFromHomePageQuality(true);
                }
                if (this.D.isInterviewLiveStyle() && addLocateParam.getIntent() != null) {
                    addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
                }
                addLocateParam.setStartFrom(this.S);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
            }
            StatisticItem statisticItem2 = new StatisticItem("c12291");
            statisticItem2.param("obj_locate", this.Q);
            TiebaStatic.log(statisticItem2);
            i();
            h(view2, this.D);
            View.OnClickListener onClickListener = this.b0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }
}
