package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.a26;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ah6;
import com.baidu.tieba.bh6;
import com.baidu.tieba.ej;
import com.baidu.tieba.f46;
import com.baidu.tieba.fj;
import com.baidu.tieba.gr4;
import com.baidu.tieba.gy4;
import com.baidu.tieba.hh;
import com.baidu.tieba.i55;
import com.baidu.tieba.k35;
import com.baidu.tieba.k55;
import com.baidu.tieba.lh6;
import com.baidu.tieba.ni6;
import com.baidu.tieba.nv4;
import com.baidu.tieba.q26;
import com.baidu.tieba.ql8;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tc5;
import com.baidu.tieba.uh5;
import com.baidu.tieba.ux4;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.vl8;
import com.baidu.tieba.wu7;
import com.baidu.tieba.xx4;
import com.baidu.tieba.yc5;
import com.baidu.tieba.zt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
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
    public m f0;
    public ImageView g;
    public LinearLayout g0;
    public EMTextView h;
    public l h0;
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
    public q26 r;
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
    public interface l {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes3.dex */
    public interface m {
        void a(boolean z);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public final void C(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    public void D(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
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

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, view2) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx4 a;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout b;

        /* loaded from: classes3.dex */
        public class a implements i55 {
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

            @Override // com.baidu.tieba.i55
            public void a(List list) {
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
                    d dVar = this.a;
                    dVar.a.k(dVar.b.F.getPageActivity().findViewById(16908290), list, rect);
                }
            }
        }

        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, xx4 xx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, xx4Var};
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
            this.a = xx4Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xx4 xx4Var = this.a;
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.b;
                xx4Var.l(threadCommentAndPraiseInfoLayout.g0, threadCommentAndPraiseInfoLayout.e);
                k55.g().c(new a(this));
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

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(str) && (threadData = this.a.D) != null && !"0".equals(threadData.getId()) && str.equals(this.a.D.getId())) {
                if ((this.a.D.isLiveThread() || this.a.D.isSharedLiveThread()) && this.a.D.getThreadAlaInfo() != null) {
                    if (this.a.D.getThreadAlaInfo() != null && this.a.D.getThreadAlaInfo().share_info != null) {
                        this.a.D.getThreadAlaInfo().share_info.share_count++;
                    }
                } else {
                    ThreadData threadData2 = this.a.D;
                    threadData2.setShareNum(threadData2.getShareNum() + 1);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
                threadCommentAndPraiseInfoLayout.R(threadCommentAndPraiseInfoLayout.D);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements wu7.d {
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

        @Override // com.baidu.tieba.wu7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e.Q();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.e.F()) {
                return;
            }
            if (this.a.b0 != null) {
                this.a.b0.onClick(view2);
            }
            this.a.e(view2);
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.a;
            threadCommentAndPraiseInfoLayout.j(view2, threadCommentAndPraiseInfoLayout.D);
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
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

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ThreadData)) {
                return;
            }
            ThreadData threadData = (ThreadData) customResponsedMessage.getData();
            if (this.a.D != null && threadData != null) {
                String str2 = "";
                if (threadData.getBaijiahaoData() == null) {
                    str = "";
                } else {
                    str = threadData.getBaijiahaoData().oriUgcNid;
                }
                if (this.a.D.getBaijiahaoData() != null) {
                    str2 = this.a.D.getBaijiahaoData().oriUgcNid;
                }
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    if (str.equals(str2)) {
                        this.a.D.setReply_num(threadData.getReply_num());
                        this.a.O(threadData);
                        return;
                    }
                    return;
                }
                String id = threadData.getId();
                String id2 = this.a.D.getId();
                if (!"0".equals(id2) && !TextUtils.isEmpty(id2) && id2.equals(id)) {
                    this.a.D.setReply_num(threadData.getReply_num());
                    this.a.O(threadData);
                }
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
        fj.f(TbadkApplication.getInst(), R.dimen.tbds84);
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
        this.j0 = new h(this);
        this.q0 = new k(this, 2921416);
        this.r0 = new a(this, 2921417);
        q(context);
    }

    public void R(ThreadData threadData) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) && (view2 = this.l) != null && this.j != null && threadData != null) {
            if (this.L) {
                view2.setVisibility(0);
                long shareNum = threadData.getShareNum();
                if ((threadData.isLiveThread() || threadData.isSharedLiveThread()) && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().share_info != null) {
                    shareNum = threadData.getThreadAlaInfo().share_info.share_count;
                }
                String string = this.E.getString(R.string.obfuscated_res_0x7f0f115b);
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

    public final void f(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, shareDialogConfig) == null) {
            int i2 = this.Q;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 != 16) {
                            if (i2 != 7) {
                                if (i2 != 8) {
                                    if (i2 != 9) {
                                        if (i2 != 12) {
                                            if (i2 != 13) {
                                                shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
                                                return;
                                            } else {
                                                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                                                return;
                                            }
                                        }
                                        shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
                                        return;
                                    }
                                    shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
                                    return;
                                }
                                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                                return;
                            }
                            shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
                            return;
                        }
                        shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
                        return;
                    }
                    shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                    return;
                }
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
                return;
            }
            shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
        }
    }

    public final int n(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i2 = threadData.threadType;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 40) {
                return 2;
            }
            if (i2 != 49 && i2 != 69) {
                if (i2 == 54) {
                    return 4;
                }
                return 5;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                return;
            }
            if (view2 == this.b) {
                x(view2);
            } else if (view2 == this.i) {
                z(view2);
                int i2 = this.Q;
                if (i2 == 1 || i2 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.l) {
                F(view2);
                int i3 = this.Q;
                if (i3 == 1 || i3 == 2) {
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            } else if (view2 == this.n) {
                C(view2);
            } else if (view2 == this.q) {
                B(view2);
            } else if (view2 == this.y) {
                E(view2);
            } else if (view2 == this.s) {
                D(view2);
            } else if (view2 == this.v) {
                y(view2);
            }
        }
    }

    public final void x(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, view2) == null) && (threadData = this.D) != null && !StringUtils.isNull(threadData.getForum_name())) {
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
        fj.f(TbadkApplication.getInst(), R.dimen.tbds84);
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
        this.j0 = new h(this);
        this.q0 = new k(this, 2921416);
        this.r0 = new a(this, 2921417);
        q(context);
    }

    public final void o(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048614, this, context, threadData) != null) || threadData == null) {
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
        uh5.e(context, arrayList, str4, z, 0, null, "from_nani_video", "personalize_page", "", str2, str2, true, threadData.isJumpToFrsVideoTabPlay, true, threadData.getFid());
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
        fj.f(TbadkApplication.getInst(), R.dimen.tbds84);
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
        this.j0 = new h(this);
        this.q0 = new k(this, 2921416);
        this.r0 = new a(this, 2921417);
        this.d = z;
        q(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAgreeNumViewIsShow(boolean z) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65548, this, z) == null) && (agreeView = this.e) != null && agreeView.getAgreeNumView() != null) {
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

    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            EMTextView eMTextView = this.x;
            if (eMTextView != null) {
                int i2 = threadData.collectNum;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.obfuscated_res_0x7f0f0ab8);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(threadData);
        }
    }

    public void N(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, threadData) != null) || threadData == null || this.Q != 13) {
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
            if (this.D == null && i2 < 0) {
                return;
            }
            StatisticItem g2 = g(i2);
            g2.param("thread_type", this.D.getThreadType());
            TiebaStatic.log(g2);
        }
    }

    public View l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, context)) == null) {
            return LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0654, (ViewGroup) this, true);
        }
        return (View) invokeL.objValue;
    }

    public void setAgreeStatisticData(gr4 gr4Var) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, gr4Var) == null) && (agreeView = this.e) != null) {
            agreeView.setStatisticData(gr4Var);
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
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.b0 = onClickListener;
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.Q = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.U = i2;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.i0 = z;
        }
    }

    public void setIsPbFirst(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.O = z;
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.M = z;
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.J = z;
        }
    }

    public void setNeedMatchStrategy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.P = z;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setNeedMatchStrategy(z);
            }
        }
    }

    public void setOnCommentClickCallback(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, lVar) == null) {
            this.h0 = lVar;
        }
    }

    public void setOnSelectStatusChangeListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, mVar) == null) {
            this.f0 = mVar;
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
            this.H = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.N = z;
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
            this.R = i2;
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.a = i2;
            p();
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            this.W = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.V = str;
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.a0 = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
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

    public final boolean v(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, threadData)) == null) {
            if (threadData != null && threadData.isVideoThreadType() && threadData.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i2)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
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

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.D == null) {
            return;
        }
        StatisticItem h2 = h();
        h2.param("thread_type", this.D.getThreadType());
        TiebaStatic.log(h2);
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            gy4.b(this.g0);
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            onClick(this.y);
        }
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.e.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.L = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.g.setLayoutParams(layoutParams);
        }
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
            MessageManager.getInstance().registerListener(this.q0);
            MessageManager.getInstance().registerListener(this.r0);
        }
    }

    public void onDestroy() {
        q26 q26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (q26Var = this.r) != null) {
            q26Var.S();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.r0);
        }
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.L = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.leftMargin = this.E.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.g.setLayoutParams(layoutParams);
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

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            u(l(this.E));
        }
    }

    private int getShareObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i2 = this.R;
            if (i2 == 1) {
                return 5;
            }
            if (i2 == 3) {
                return 3;
            }
            if (i2 == 4) {
                return 4;
            }
            if (i2 == 6) {
                return 8;
            }
            if (i2 == 10) {
                return 16;
            }
            if (i2 == 11) {
                return 24;
            }
            if (i2 == 12) {
                return 20;
            }
            if (i2 == 13) {
                return 30;
            }
            if (i2 == 15) {
                return 33;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
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

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.B = new TBLottieAnimationView(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fj.f(this.E, R.dimen.tbds715), fj.f(this.E, R.dimen.tbds110));
            layoutParams.setMargins(0, 0, fj.k(this.E) / 6, 0);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.B, layoutParams);
            s();
            this.B.setVisibility(8);
        }
    }

    public void updateManagerUI() {
        int color;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f08092f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.o;
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                color = vl8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
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
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            if (this.J) {
                WebPManager.setPureDrawable(this.g, R.drawable.obfuscated_res_0x7f080933, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.g;
            ThreadData threadData = this.D;
            if (threadData != null && threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                z = false;
            } else {
                z = true;
            }
            imageView.setEnabled(z);
            gy4.a(this.g, R.drawable.obfuscated_res_0x7f080932);
            gy4.e(this.f);
            ThreadData threadData2 = this.D;
            if (threadData2 != null && threadData2.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.f.setTextColor(vl8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
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

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && this.B != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img");
            } else {
                this.B.setImageAssetsFolder("lottie_reactions_guide_right_img_dark");
            }
            SkinManager.setLottieAnimation(this.B, R.raw.obfuscated_res_0x7f11004d);
        }
    }

    public void B(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            if (this.r == null) {
                this.r = new q26(this.F, w(16));
            }
            this.r.e0(this.D);
            this.r.k();
            if (this.D != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.D.getFid()).param("tid", this.D.getId()));
            }
        }
    }

    public void M(ThreadData threadData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, threadData) == null) && this.q != null && threadData != null) {
            int i2 = 4;
            this.M = w(4);
            if (threadData.mOriginalForumInfo != null) {
                this.M = false;
            }
            if (this.M && ((linearLayout = this.A) == null || linearLayout.getVisibility() == 8)) {
                this.q.setVisibility(0);
                String string = this.E.getString(R.string.obfuscated_res_0x7f0f0aae);
                this.o.setText(string);
                this.o.setContentDescription(string);
                this.G = true;
            } else {
                View view2 = this.q;
                if (!w(64)) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            int i2 = 0;
            if (threadData == null) {
                setVisibility(8);
                return false;
            }
            this.D = threadData;
            L();
            I(threadData);
            P(threadData);
            O(threadData);
            K(threadData);
            R(threadData);
            updatePraiseNum(threadData);
            Q(threadData);
            M(threadData);
            if (!this.G) {
                i2 = 8;
            }
            setVisibility(i2);
            N(threadData);
            A();
            return this.G;
        }
        return invokeL.booleanValue;
    }

    public void E(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && this.y != null && (threadData = this.D) != null && this.z != null && !threadData.isTransportThread()) {
            boolean z = true;
            if (!this.D.isMarkToDel() && bh6.f().i()) {
                if (bh6.f().a(this.D)) {
                    this.D.setMarkToDel(true);
                }
            } else if (!this.D.isMarkToMove() && ah6.h().j()) {
                if (ah6.h().a(this.D)) {
                    this.D.setMarkToMove(true);
                }
            } else {
                bh6.f().l(this.D);
                this.D.setMarkToDel(false);
                ah6.h().l(this.D);
                this.D.setMarkToMove(false);
            }
            if (!this.D.isMarkToDel() && !this.D.isMarkToMove()) {
                nv4.d(this.z).x(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f080957, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f080953, R.color.CAM_X0304, null);
            }
            m mVar = this.f0;
            if (mVar != null) {
                if (!this.D.isMarkToDel() && !this.D.isMarkToMove()) {
                    z = false;
                }
                mVar.a(z);
            }
        }
    }

    public void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) && this.A != null && this.y != null && this.z != null && threadData != null) {
            if (!this.i0) {
                View view2 = this.d0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                this.A.setVisibility(8);
            } else if (this.N && !w(128) && (bh6.f().i() || ah6.h().j())) {
                if (this.d0 == null) {
                    View view3 = new View(getContext());
                    this.d0 = view3;
                    SkinManager.setBackgroundColor(view3, R.color.CAM_X0201);
                    addView(this.d0);
                    this.d0.setAlpha(0.5f);
                    this.d0.setOnTouchListener(new i(this));
                    this.d0.setOnClickListener(new j(this));
                }
                int k2 = fj.k(getContext());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d0.getLayoutParams();
                if (layoutParams == null) {
                    this.d0.setLayoutParams(new RelativeLayout.LayoutParams(k2, -1));
                } else {
                    layoutParams.width = k2;
                    requestLayout();
                }
                if (!this.D.isMarkToDel() && !this.D.isMarkToMove()) {
                    nv4.d(this.z).x(R.color.CAM_X0107);
                    WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f080957, R.color.CAM_X0107, null);
                } else {
                    SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0304);
                    WebPManager.setPureDrawable(this.y, R.drawable.obfuscated_res_0x7f080953, R.color.CAM_X0304, null);
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

    public void e(View view2) {
        TbPageContext tbPageContext;
        int f2;
        int f3;
        int width;
        int f4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && this.e.getData() != null && this.e.getData().hasAgree && (tbPageContext = this.F) != null && tbPageContext.getPageActivity() != null && this.e.getImgAgree() != null) {
            if (!this.O || (this.e.getAgreeFlag() && !this.e.G())) {
                wu7 wu7Var = new wu7(getContext());
                int[] iArr = new int[2];
                this.e.getImgAgree().getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                if (this.O) {
                    f2 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
                } else {
                    f2 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds600);
                }
                if (this.O) {
                    f3 = fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
                } else {
                    f3 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds1080);
                }
                int i4 = (int) ((f3 * 1) / 1.45d);
                if (i2 > i4) {
                    width = ((i2 - i4) + (this.e.getImgAgree().getWidth() / 2)) - 10;
                } else {
                    width = (i2 - i4) + (this.e.getImgAgree().getWidth() / 2);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
                layoutParams.leftMargin = width;
                if (this.O) {
                    f4 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds36);
                } else {
                    f4 = fj.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
                }
                layoutParams.topMargin = f4;
                wu7Var.k(f2);
                wu7Var.j(layoutParams);
                wu7Var.i(false);
                wu7Var.n(this.P, this.F.getPageActivity().findViewById(16908290), 0, i3 - 10, this.D.getTid(), String.valueOf(this.D.getFid()));
                wu7Var.l(new b(this));
            }
        }
    }

    public final StatisticItem g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
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
            if (!ej.isEmpty(this.T)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.T);
            }
            if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
            }
            statisticItem.param("nid", this.D.getNid());
            statisticItem.param("card_type", this.D.getRecomCardType());
            statisticItem.param("recom_source", this.D.mRecomSource);
            statisticItem.param("ab_tag", this.D.mRecomAbTag);
            statisticItem.param("weight", this.D.mRecomWeight);
            statisticItem.param("extra", this.D.mRecomExtra);
            if (this.D.getBaijiahaoData() != null && !ej.isEmpty(this.D.getBaijiahaoData().oriUgcVid)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.D.getBaijiahaoData().oriUgcVid);
            }
            tc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
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

    public void F(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if ((!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.E)) || this.D == null) {
                return;
            }
            G();
            j(view2, this.D);
            if (AntiHelper.e(getContext(), this.D)) {
                return;
            }
            H();
            View.OnClickListener onClickListener = this.b0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, context) == null) {
            this.E = context;
            if (context instanceof BaseActivity) {
                this.F = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.F = ((BaseFragmentActivity) context).getPageContext();
            }
            fj.f(this.E, R.dimen.tbds84);
            t();
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
        if ((interceptable == null || interceptable.invokeL(1048668, this, threadData) == null) && this.w != null) {
            if (threadData != null && threadData.getIsMarked() != 0) {
                WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f080987, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.w, R.drawable.obfuscated_res_0x7f080986, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0345  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H() {
        ThreadData threadData;
        String tid;
        String str;
        String str2;
        boolean z;
        boolean z2;
        String m2;
        Uri parse;
        String format;
        ShareItem shareItem;
        OriginalThreadInfo.ShareInfo generateShareInfo;
        ThreadData threadData2;
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (threadData = this.D) != null && this.E != null) {
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = this.D.getForum_name();
            OriginalForumInfo originalForumInfo = this.D.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                forum_name = originalForumInfo.ori_fname;
            }
            String str3 = forum_name;
            String str4 = valueOf;
            String title = this.D.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.D.getAbstract();
            }
            String str5 = title;
            if (this.D.isUgcThreadType()) {
                tid = this.D.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + this.D.getBaijiahaoData().oriUgcType + "&dvid=" + this.D.getBaijiahaoData().oriUgcVid + "&nid=" + this.D.getBaijiahaoData().oriUgcNid;
            } else {
                tid = this.D.getTid();
                str = "?share=9105&fr=sharewise";
            }
            String str6 = str;
            String str7 = tid;
            String str8 = str6 + "&share_from=post";
            if (this.D.getVoiceRoomData() != null && this.D.getVoiceRoomData().room_id.longValue() > 0) {
                str2 = String.format(TbConfig.TIEBA_ADDRESS + "mo/q/wise-main-share/shareVoiceRoom?room_id=%s", String.valueOf(this.D.getVoiceRoomData().room_id));
                z = true;
            } else {
                str2 = TbConfig.HTTPS_PB_PREFIX + str7 + str8;
                z = false;
            }
            if (this.D.getThreadAlaInfo() != null && this.D.getThreadAlaInfo().user_info != null) {
                try {
                    str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.D.getThreadAlaInfo().user_info.user_name, IMAudioTransRequest.CHARSET);
                    z2 = false;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                if (this.D.getThreadAlaInfo() != null && this.D.getThreadAlaInfo().isLegalYYLiveData()) {
                    str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.D.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + this.D.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + this.D.getThreadAlaInfo().mYyExtData.mYyUid;
                    z2 = false;
                }
                m2 = m(this.D);
                if (m2 != null) {
                    parse = null;
                } else {
                    parse = Uri.parse(m2);
                }
                String str9 = this.D.getAbstract();
                String string = getResources().getString(R.string.obfuscated_res_0x7f0f1163);
                String string2 = getResources().getString(R.string.obfuscated_res_0x7f0f04a4);
                if (!this.D.isUgcThreadType() && this.D.getAuthor() != null) {
                    if (!TextUtils.isEmpty(this.D.getTitle()) && !TextUtils.isEmpty(str9)) {
                        format = str9;
                    } else {
                        format = MessageFormat.format(string2, this.D.getAuthor().getName_show(), getResources().getString(R.string.obfuscated_res_0x7f0f04a5));
                    }
                } else if (!z) {
                    StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15b2));
                    if (this.D.getForumData() != null && !StringUtils.isNull(this.D.getForumData().b)) {
                        sb.insert(0, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f15b3), this.D.getForumData().b));
                    }
                    format = sb.toString();
                } else {
                    format = MessageFormat.format(string, str5, str9);
                }
                int j2 = k35.j(this.D);
                String cutString = ej.cutString(str5, 100);
                String cutString2 = ej.cutString(format, 100);
                shareItem = new ShareItem();
                shareItem.v = cutString;
                shareItem.w = cutString2;
                if (!this.D.isUgcThreadType()) {
                    shareItem.V = -1L;
                    shareItem.H = cutString2;
                } else {
                    if (j2 == 2 && this.D.getThreadVideoInfo() != null) {
                        shareItem.V = this.D.getThreadVideoInfo().play_count.intValue();
                    } else if (j2 == 1) {
                        shareItem.V = this.D.getView_num();
                    }
                    shareItem.H = str9;
                }
                shareItem.x = str2;
                shareItem.u = str7;
                shareItem.N = str4;
                shareItem.t = str3;
                shareItem.O = str7;
                shareItem.f = true;
                shareItem.s = this.R;
                shareItem.I = getShareObjSource();
                shareItem.Q = j2;
                shareItem.J = 3;
                shareItem.K = n(this.D);
                if (parse != null) {
                    shareItem.z = parse;
                }
                if (this.D.isUgcThreadType()) {
                    z2 = false;
                }
                shareItem.s0 = z2;
                if (z2) {
                    shareItem.q0 = this.D.getShareImageUrl();
                }
                i();
                generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.D);
                shareItem.X = generateShareInfo;
                if (StringUtils.isNull(generateShareInfo.showText, true)) {
                    if (StringUtils.isNull(this.D.getTitle(), true)) {
                        OriginalThreadInfo originalThreadInfo = this.D.originalThreadData;
                        if (originalThreadInfo != null) {
                            shareItem.X.showText = originalThreadInfo.g;
                        }
                    } else {
                        shareItem.X.showText = this.D.getTitle();
                    }
                }
                if (StringUtils.isNull(shareItem.X.showText, true)) {
                    shareItem.X.showText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d44);
                }
                if (this.Q != 13) {
                    shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(this.D, 2);
                } else {
                    shareItem.a0 = ShareItem.ForwardInfo.generateForwardInfo(this.D);
                }
                threadData2 = shareItem.X.threadData;
                if (threadData2 != null && threadData2.getForumData() == null) {
                    zt4 zt4Var = new zt4();
                    zt4Var.j(this.D.getForum_name());
                    zt4Var.a = String.valueOf(this.D.getFid());
                    zt4Var.c = this.D.getForumAvatar();
                    shareItem.X.threadData.setForumData(zt4Var);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.J);
                bundle.putInt("obj_type", shareItem.Q);
                bundle.putString("fid", shareItem.N);
                bundle.putString("tid", shareItem.O);
                bundle.putInt("obj_source", shareItem.s);
                if (shareItem.s == 11) {
                    bundle.putInt("source", 14);
                }
                if (shareItem.s == 12) {
                    bundle.putInt("source", 15);
                }
                shareItem.k(bundle);
                shareItem.G0 = k35.i(this.D, j2);
                shareItem.H0 = k35.h(this.D, j2, str3, shareItem.V, "", "");
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.E, shareItem, true, true);
                if (this.D.getThreadType() == 49 && this.D.getThreadType() != 60 && this.D.getThreadType() != 69) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                shareDialogConfig.mIsVoiceRoom = z;
                shareDialogConfig.setIsAlaLive(z3);
                f(shareDialogConfig);
                f46.c().l(shareDialogConfig);
            }
            z2 = true;
            if (this.D.getThreadAlaInfo() != null) {
                str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.D.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + this.D.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + this.D.getThreadAlaInfo().mYyExtData.mYyUid;
                z2 = false;
            }
            m2 = m(this.D);
            if (m2 != null) {
            }
            String str92 = this.D.getAbstract();
            String string3 = getResources().getString(R.string.obfuscated_res_0x7f0f1163);
            String string22 = getResources().getString(R.string.obfuscated_res_0x7f0f04a4);
            if (!this.D.isUgcThreadType()) {
            }
            if (!z) {
            }
            int j22 = k35.j(this.D);
            String cutString3 = ej.cutString(str5, 100);
            String cutString22 = ej.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.v = cutString3;
            shareItem.w = cutString22;
            if (!this.D.isUgcThreadType()) {
            }
            shareItem.x = str2;
            shareItem.u = str7;
            shareItem.N = str4;
            shareItem.t = str3;
            shareItem.O = str7;
            shareItem.f = true;
            shareItem.s = this.R;
            shareItem.I = getShareObjSource();
            shareItem.Q = j22;
            shareItem.J = 3;
            shareItem.K = n(this.D);
            if (parse != null) {
            }
            if (this.D.isUgcThreadType()) {
            }
            shareItem.s0 = z2;
            if (z2) {
            }
            i();
            generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(this.D);
            shareItem.X = generateShareInfo;
            if (StringUtils.isNull(generateShareInfo.showText, true)) {
            }
            if (StringUtils.isNull(shareItem.X.showText, true)) {
            }
            if (this.Q != 13) {
            }
            threadData2 = shareItem.X.threadData;
            if (threadData2 != null) {
                zt4 zt4Var2 = new zt4();
                zt4Var2.j(this.D.getForum_name());
                zt4Var2.a = String.valueOf(this.D.getFid());
                zt4Var2.c = this.D.getForumAvatar();
                shareItem.X.threadData.setForumData(zt4Var2);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.J);
            bundle2.putInt("obj_type", shareItem.Q);
            bundle2.putString("fid", shareItem.N);
            bundle2.putString("tid", shareItem.O);
            bundle2.putInt("obj_source", shareItem.s);
            if (shareItem.s == 11) {
            }
            if (shareItem.s == 12) {
            }
            shareItem.k(bundle2);
            shareItem.G0 = k35.i(this.D, j22);
            shareItem.H0 = k35.h(this.D, j22, str3, shareItem.V, "", "");
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.E, shareItem, true, true);
            if (this.D.getThreadType() == 49) {
            }
            z3 = true;
            shareDialogConfig2.mIsVoiceRoom = z;
            shareDialogConfig2.setIsAlaLive(z3);
            f(shareDialogConfig2);
            f46.c().l(shareDialogConfig2);
        }
    }

    public void O(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) && this.f != null && threadData != null) {
            if (this.K) {
                this.i.setVisibility(0);
                if (threadData.getReply_num() > 0) {
                    this.f.setVisibility(0);
                    String numFormatOverWan = StringHelper.numFormatOverWan(threadData.getReply_num());
                    if (this.J) {
                        updateReplyStateUI();
                        this.f.setText(numFormatOverWan);
                    } else {
                        this.f.setText(String.format(this.E.getString(R.string.obfuscated_res_0x7f0f1018), numFormatOverWan));
                    }
                    EMTextView eMTextView = this.f;
                    eMTextView.setContentDescription(this.E.getString(R.string.obfuscated_res_0x7f0f1017) + numFormatOverWan);
                    this.G = true;
                    return;
                } else if (this.J) {
                    updateReplyStateUI();
                    this.f.setText(this.E.getString(R.string.obfuscated_res_0x7f0f0086));
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

    public final String m(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, threadData)) == null) {
            String str = null;
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !TextUtils.isEmpty(threadData.getThreadAlaInfo().cover)) {
                return threadData.getThreadAlaInfo().cover;
            }
            if (threadData.getVoiceRoomData() != null && threadData.getVoiceRoomData().room_id.longValue() > 0) {
                if (threadData.getForumData() == null) {
                    return null;
                }
                return threadData.getForumData().c;
            } else if (threadData.getMedias() == null) {
                return null;
            } else {
                ArrayList<MediaData> medias = threadData.getMedias();
                int size = medias.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    MediaData mediaData = medias.get(i2);
                    if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                        if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                            str = mediaData.getThumbnails_url();
                            break;
                        } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                            str = mediaData.getPicUrl();
                            break;
                        }
                    }
                    i2++;
                }
                if (str == null && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) {
                    return threadData.getThreadVideoInfo().thumbnail_url;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public void updatePraiseNum(ThreadData threadData) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, threadData) == null) {
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
            if (!this.e.E() && this.B.getVisibility() != 0) {
                s();
                String o = ux4.o("key_reaction_guide_show_number_pb");
                if (this.e.getTbPageContext() != null && this.e.getTbPageContext().getPageActivity() != null && this.e.getTbPageContext().getPageActivity().getIntent() != null && this.e.getTbPageContext().getPageActivity().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.C && ux4.k().l(o, 0) == 2) {
                    this.C = true;
                    this.B.setVisibility(0);
                    this.B.playAnimation();
                    hh.a().postDelayed(this.j0, 4000L);
                }
            }
        }
    }

    public void updateShareStateUI(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, threadData) == null) {
            WebPManager.setPureDrawable(this.k, R.drawable.obfuscated_res_0x7f080937, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(threadData)) {
                setShareClickable(true);
                this.j.setTextColor(vl8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                if (threadData != null && threadData.originalThreadData != null) {
                    ThreadData threadData2 = this.D;
                    if (threadData2.originalThreadData.m || threadData2.shouldShowBlockedState()) {
                        setShareClickable(false);
                        this.j.setTextColor(vl8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
                setShareClickable(true);
                nv4.d(this.j).x(R.color.CAM_X0107);
            }
            gy4.a(this.k, R.drawable.obfuscated_res_0x7f080936);
            gy4.e(this.j);
            ThreadData threadData3 = this.D;
            if (threadData3 != null && threadData3.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                this.k.setEnabled(false);
                this.j.setTextColor(vl8.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.g0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final StatisticItem h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
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
            if (!ej.isEmpty(this.T)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.T);
            }
            if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.V);
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
                yc5.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.D.getNid());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void i() {
        ThreadData threadData;
        ItemInfo j0;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            Context context = this.E;
            if (!(context instanceof ni6) || !((ni6) context).v() || (threadData = this.D) == null || threadData.getItem() != null || (j0 = ((ni6) this.E).j0()) == null) {
                return;
            }
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(j0.id.longValue());
            builder.item_name = j0.name;
            builder.icon_size = j0.icon_size;
            builder.icon_url = j0.icon_url;
            builder.tags = j0.tags;
            ItemTable itemTable = j0.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                Iterator<ItemPoint> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ItemPoint next = it.next();
                    if (next.time_intval.equals("all")) {
                        Double d2 = next.point;
                        builder.score = d2;
                        builder.star = Integer.valueOf((int) (d2.doubleValue() / 2.0d));
                        break;
                    }
                }
            }
            Item build = builder.build(false);
            ItemData itemData = new ItemData();
            itemData.parseProto(build);
            this.D.setItemData(itemData);
        }
    }

    public final void j(View view2, ThreadData threadData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048609, this, view2, threadData) != null) || threadData == null) {
            return;
        }
        int id = view2.getId();
        int i3 = 3;
        if (id == R.id.obfuscated_res_0x7f092191) {
            i2 = 3;
        } else if (id == R.id.obfuscated_res_0x7f091e97) {
            i2 = 4;
        } else if (id == R.id.obfuscated_res_0x7f090eba) {
            i2 = 1;
        } else if (id == R.id.obfuscated_res_0x7f090ed3) {
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
            TiebaStatic.log(ql8.l("c13694", threadData, i3, i2));
        }
    }

    public void onChangeSkinType() {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && this.c0 != TbadkCoreApplication.getInst().getSkinType()) {
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
            q26 q26Var = this.r;
            if (q26Var != null) {
                q26Var.c0();
            }
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.L(this.c0);
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

    public final void p() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            View view2 = this.l;
            int i4 = 0;
            if (w(1)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            View view3 = this.i;
            if (w(2)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view3.setVisibility(i3);
            View view4 = this.q;
            int i5 = 4;
            if (w(4)) {
                i5 = 0;
            } else if (!w(64)) {
                i5 = 8;
            }
            view4.setVisibility(i5);
            AgreeView agreeView = this.e;
            if (!w(8)) {
                i4 = 8;
            }
            agreeView.setVisibility(i4);
            this.e.setAgreeAlone(w(32));
        }
    }

    public void u(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, view2) == null) {
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092190);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09219a);
            this.g0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092184);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092194);
            this.f = eMTextView;
            nv4.d(eMTextView).A(R.string.F_X01);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092193);
            this.h = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092192);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f092191);
            EMTextView eMTextView2 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091e96);
            this.j = eMTextView2;
            nv4.d(eMTextView2).A(R.string.F_X01);
            this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e98);
            this.l = view2.findViewById(R.id.obfuscated_res_0x7f091e97);
            this.m = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090437);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090436);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091678);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.e = agreeView;
                agreeView.setIsAgreeNumClick(true);
                this.e.setAfterClickListener(new c(this));
                this.e.setUseLikeDefaultRes(this.d);
                this.e.setAgreeLongClickListener(new d(this, new xx4(this.F)));
            }
            this.q = view2.findViewById(R.id.obfuscated_res_0x7f091490);
            EMTextView eMTextView3 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092197);
            this.o = eMTextView3;
            nv4.d(eMTextView3).A(R.string.F_X01);
            this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092196);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09148d);
            EMTextView eMTextView4 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09148e);
            this.z = eMTextView4;
            nv4.d(eMTextView4).A(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09148c);
            this.A = linearLayout;
            linearLayout.setOnTouchListener(new e(this));
            this.z.setOnClickListener(new f(this));
            this.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b21);
            this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b22);
            EMTextView eMTextView5 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091b23);
            this.u = eMTextView5;
            if (eMTextView5 != null) {
                nv4.d(eMTextView5).A(R.string.F_X01);
            }
            this.v = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090679);
            this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09067a);
            EMTextView eMTextView6 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09067b);
            this.x = eMTextView6;
            if (eMTextView6 != null) {
                nv4.d(eMTextView6).A(R.string.F_X01);
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
            r();
        }
    }

    public void z(View view2) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048677, this, view2) == null) && (threadData = this.D) != null && this.E != null) {
            a26.a(threadData.getTid());
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", this.Q);
            statisticItem.param("obj_type", getThreadType());
            statisticItem.param("tid", this.D.getTid());
            statisticItem.param("nid", this.D.getNid());
            if (this.Q == 18) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.D.getFid());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.V);
            }
            tc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(this);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
            if (this.D.getVoiceRoomData() != null && this.D.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(this.D.getVoiceRoomData().room_name)) {
                ((aa5) ServiceManager.getService(aa5.a.a())).a(this.F, this.D.getVoiceRoomData().room_id.longValue());
            } else if (this.D.getThreadVideoInfo() != null && !TextUtils.isEmpty(this.D.getThreadVideoInfo().video_url)) {
                o(this.E, this.D);
                l lVar = this.h0;
                if (lVar != null) {
                    lVar.a(null);
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
                l lVar2 = this.h0;
                if (lVar2 != null) {
                    lVar2.a(addLocateParam);
                }
                if (TbSingleton.getInstance().isPbPreloadSwitchOn() && v(this.D)) {
                    addLocateParam.setNeedPreLoad(true);
                    lh6.update(this.D);
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
            k();
            j(view2, this.D);
            View.OnClickListener onClickListener = this.b0;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }
}
