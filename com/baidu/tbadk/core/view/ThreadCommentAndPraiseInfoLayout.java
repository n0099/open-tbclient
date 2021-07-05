package com.baidu.tbadk.core.view;

import android.content.Context;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.s0.a0.c0;
import d.a.s0.a0.m;
import d.a.s0.u0.l0;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes4.dex */
public class ThreadCommentAndPraiseInfoLayout extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView A;
    public ImageView B;
    public EMTextView C;
    public LinearLayout D;
    public b2 E;
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
    public int P;
    public int Q;
    public int R;
    public String S;
    public int T;
    public String U;
    public String V;
    public String W;
    public View.OnClickListener a0;
    public int b0;
    public View c0;

    /* renamed from: e  reason: collision with root package name */
    public int f12534e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12535f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12536g;

    /* renamed from: h  reason: collision with root package name */
    public AgreeView f12537h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f12538i;
    public MaskView i0;
    public ImageView j;
    public j j0;
    public EMTextView k;
    public LinearLayout k0;
    public View l;
    public i l0;
    public EMTextView m;
    public boolean m0;
    public ImageView n;
    public CustomMessageListener n0;
    public View o;
    public CustomMessageListener o0;
    public FrameLayout p;
    public ImageView q;
    public EMTextView r;
    public ImageView s;
    public View t;
    public c0 u;
    public LinearLayout v;
    public ImageView w;
    public EMTextView x;
    public LinearLayout y;
    public ImageView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12539e;

        public a(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12539e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f12539e.a0 != null) {
                    this.f12539e.a0.onClick(view);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f12539e;
                threadCommentAndPraiseInfoLayout.g(view, threadCommentAndPraiseInfoLayout.E);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12540e;

        public b(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12540e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f12540e.B.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12541e;

        public c(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12541e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12541e.B.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12542e;

        public d(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12542e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12542e.B.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12543e;

        public e(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12543e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f12543e.B.onTouchEvent(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12544e;

        public f(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12544e = threadCommentAndPraiseInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12544e.B.performClick();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12545a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i2)};
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
            this.f12545a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof b2)) {
                return;
            }
            b2 b2Var = (b2) customResponsedMessage.getData();
            if (this.f12545a.E == null || b2Var == null) {
                return;
            }
            String str = b2Var.J() != null ? b2Var.J().oriUgcNid : "";
            String str2 = this.f12545a.E.J() != null ? this.f12545a.E.J().oriUgcNid : "";
            if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                if (str.equals(str2)) {
                    this.f12545a.E.R3(b2Var.P0());
                    this.f12545a.L(b2Var);
                    return;
                }
                return;
            }
            String c0 = b2Var.c0();
            String c02 = this.f12545a.E.c0();
            if ("0".equals(c02) || TextUtils.isEmpty(c02) || !c02.equals(c0)) {
                return;
            }
            this.f12545a.E.R3(b2Var.P0());
            this.f12545a.L(b2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadCommentAndPraiseInfoLayout f12546a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCommentAndPraiseInfoLayout, Integer.valueOf(i2)};
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
            this.f12546a = threadCommentAndPraiseInfoLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str) || (b2Var = this.f12546a.E) == null || "0".equals(b2Var.c0()) || !str.equals(this.f12546a.E.c0())) {
                return;
            }
            if ((this.f12546a.E.Y1() || this.f12546a.E.g2()) && this.f12546a.E.g1() != null) {
                if (this.f12546a.E.g1() != null && this.f12546a.E.g1().share_info != null) {
                    this.f12546a.E.g1().share_info.share_count++;
                }
            } else {
                b2 b2Var2 = this.f12546a.E;
                b2Var2.W3(b2Var2.W0() + 1);
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.f12546a;
            threadCommentAndPraiseInfoLayout.O(threadCommentAndPraiseInfoLayout.E);
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(IntentConfig intentConfig);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(boolean z);
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
        l.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f12534e = 11;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.P = 2;
        this.Q = 1;
        this.b0 = 3;
        this.j0 = null;
        this.m0 = true;
        this.n0 = new g(this, 2921416);
        this.o0 = new h(this, 2921417);
        n(context);
    }

    private BdUniqueId getPageUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            TbPageContext tbPageContext = this.G;
            if (tbPageContext != null) {
                return tbPageContext.getUniqueId();
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    private int getShareObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            int i2 = this.Q;
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
            return i2 == 11 ? 24 : 0;
        }
        return invokeV.intValue;
    }

    private int getThreadSourceForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int i2 = this.P;
            if (i2 == 4 || i2 == 9) {
                return 1;
            }
            if (i2 == 1) {
                return 2;
            }
            return (i2 == 8 || i2 == 13) ? 3 : 0;
        }
        return invokeV.intValue;
    }

    private int getThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            b2 b2Var = this.E;
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.v1) {
                return 4;
            }
            if (b2Var.j1() == 49 || this.E.j1() == 69) {
                return 5;
            }
            if (this.E.l1() != null) {
                return 1;
            }
            if (this.E.getType() == b2.O2 || this.E.getType() == b2.k3) {
                return ListUtils.getCount(this.E.x1()) > 0 ? 3 : 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private int getThreadTypeForDynamicAndBjh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            b2 b2Var = this.E;
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.E1()) {
                return 1;
            }
            if (this.E.H1()) {
                return 2;
            }
            if (this.E.F1()) {
                return 3;
            }
            return this.E.G1() ? 4 : 0;
        }
        return invokeV.intValue;
    }

    public void A(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if ((ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.F)) && this.E != null) {
                B();
                g(view, this.E);
                if (AntiHelper.e(getContext(), this.E)) {
                    return;
                }
                F();
                View.OnClickListener onClickListener = this.a0;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.E == null) {
            return;
        }
        StatisticItem e2 = e();
        e2.param("thread_type", this.E.j1());
        TiebaStatic.log(e2);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F() {
        b2 b2Var;
        String n1;
        String str;
        boolean z;
        Uri parse;
        String h2;
        String format;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (b2Var = this.E) == null || this.F == null) {
            return;
        }
        String valueOf = String.valueOf(b2Var.Q());
        String W = this.E.W();
        OriginalForumInfo originalForumInfo = this.E.F1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            W = originalForumInfo.ori_fname;
        }
        String str2 = W;
        String str3 = valueOf;
        String title = this.E.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = this.E.h();
        }
        String str4 = title;
        if (this.E.p2()) {
            n1 = this.E.J().oriUgcTid;
            str = "?share=9105&fr=dshare&dtype=" + this.E.J().oriUgcType + "&dvid=" + this.E.J().oriUgcVid + "&nid=" + this.E.J().oriUgcNid;
        } else {
            n1 = this.E.n1();
            str = "?share=9105&fr=share";
        }
        String str5 = str;
        String str6 = n1;
        String str7 = "http://tieba.baidu.com/p/" + str6 + (str5 + "&share_from=post");
        if (this.E.g1() != null && this.E.g1().user_info != null) {
            try {
                str7 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(this.E.g1().user_info.user_name, "utf-8");
                z = false;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            if (this.E.g1() != null && this.E.g1().isLegalYYLiveData()) {
                str7 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.E.g1().mYyExtData.mSid + "&livessid=" + this.E.g1().mYyExtData.mSsid + "&uid=" + this.E.g1().mYyExtData.mYyUid;
                z = false;
            }
            String j2 = j(this.E);
            parse = j2 != null ? null : Uri.parse(j2);
            h2 = this.E.h();
            String string = getResources().getString(R.string.share_content_tpl);
            String string2 = getResources().getString(R.string.default_share_content_tpl);
            if (!this.E.p2() && this.E.H() != null) {
                format = (TextUtils.isEmpty(this.E.getTitle()) || TextUtils.isEmpty(h2)) ? MessageFormat.format(string2, this.E.H().getName_show(), getResources().getString(R.string.default_share_content_tpl_suffix)) : h2;
            } else {
                format = MessageFormat.format(string, str4, h2);
            }
            String cutString = k.cutString(str4, 100);
            String cutString2 = k.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            int l = l(this.E);
            if (!this.E.p2()) {
                shareItem.R = -1L;
                shareItem.D = cutString2;
            } else {
                if (l == 2 && this.E.l1() != null) {
                    shareItem.R = this.E.l1().play_count.intValue();
                } else if (l == 1) {
                    shareItem.R = this.E.w1();
                }
                shareItem.D = h2;
            }
            shareItem.t = str7;
            shareItem.q = str6;
            shareItem.J = str3;
            shareItem.p = str2;
            shareItem.K = str6;
            shareItem.f12826f = true;
            shareItem.o = this.Q;
            shareItem.E = getShareObjSource();
            shareItem.M = l;
            shareItem.F = 3;
            shareItem.G = k(this.E);
            if (parse != null) {
                shareItem.v = parse;
            }
            if (this.E.p2()) {
                z = false;
            }
            shareItem.f0 = z;
            if (z) {
                shareItem.e0 = this.E.U0();
            }
            f();
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.E);
            if (this.P != 13) {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.E, 2);
            } else {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.E);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            if (shareItem.o == 11) {
                bundle.putInt("source", 14);
            }
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.F, shareItem, true, true);
            shareDialogConfig.setIsAlaLive(this.E.j1() != 49 || this.E.j1() == 60 || this.E.j1() == 69);
            c(shareDialogConfig);
            d.a.s0.e0.f.b().k(shareDialogConfig);
        }
        z = true;
        if (this.E.g1() != null) {
            str7 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + this.E.g1().mYyExtData.mSid + "&livessid=" + this.E.g1().mYyExtData.mSsid + "&uid=" + this.E.g1().mYyExtData.mYyUid;
            z = false;
        }
        String j22 = j(this.E);
        if (j22 != null) {
        }
        h2 = this.E.h();
        String string3 = getResources().getString(R.string.share_content_tpl);
        String string22 = getResources().getString(R.string.default_share_content_tpl);
        if (!this.E.p2()) {
        }
        format = MessageFormat.format(string3, str4, h2);
        String cutString3 = k.cutString(str4, 100);
        String cutString22 = k.cutString(format, 100);
        shareItem = new ShareItem();
        shareItem.r = cutString3;
        shareItem.s = cutString22;
        int l2 = l(this.E);
        if (!this.E.p2()) {
        }
        shareItem.t = str7;
        shareItem.q = str6;
        shareItem.J = str3;
        shareItem.p = str2;
        shareItem.K = str6;
        shareItem.f12826f = true;
        shareItem.o = this.Q;
        shareItem.E = getShareObjSource();
        shareItem.M = l2;
        shareItem.F = 3;
        shareItem.G = k(this.E);
        if (parse != null) {
        }
        if (this.E.p2()) {
        }
        shareItem.f0 = z;
        if (z) {
        }
        f();
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.E);
        if (this.P != 13) {
        }
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("obj_param1", shareItem.F);
        bundle2.putInt("obj_type", shareItem.M);
        bundle2.putString("fid", shareItem.J);
        bundle2.putString("tid", shareItem.K);
        bundle2.putInt("obj_source", shareItem.o);
        if (shareItem.o == 11) {
        }
        shareItem.k(bundle2);
        ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(this.F, shareItem, true, true);
        shareDialogConfig2.setIsAlaLive(this.E.j1() != 49 || this.E.j1() == 60 || this.E.j1() == 69);
        c(shareDialogConfig2);
        d.a.s0.e0.f.b().k(shareDialogConfig2);
    }

    public void G(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            this.f12535f.setVisibility(8);
        }
    }

    public void H(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) {
            EMTextView eMTextView = this.A;
            if (eMTextView != null) {
                int i2 = b2Var.J2;
                if (i2 <= 0) {
                    eMTextView.setText(R.string.mark);
                } else {
                    eMTextView.setText(StringHelper.numFormatOverWanNa(i2));
                }
            }
            updateCollectStateUI(b2Var);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void J(b2 b2Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, b2Var) == null) || this.t == null || b2Var == null) {
            return;
        }
        this.N = r(4);
        if (b2Var.F1 != null) {
            this.N = false;
        }
        if (this.N && ((linearLayout = this.D) == null || linearLayout.getVisibility() == 8)) {
            this.t.setVisibility(0);
            String string = this.F.getString(R.string.manage);
            this.r.setText(string);
            this.r.setContentDescription(string);
            this.H = true;
        } else {
            this.t.setVisibility(r(64) ? 4 : 8);
        }
        updateManagerUI();
    }

    public void K(b2 b2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, b2Var) == null) && b2Var != null && this.P == 13) {
            showOperationMaskView(b2Var.H2 == 1);
        }
    }

    public void L(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b2Var) == null) || this.f12538i == null || b2Var == null) {
            return;
        }
        if (this.L) {
            this.l.setVisibility(0);
            if (b2Var.P0() > 0) {
                this.f12538i.setVisibility(0);
                String numFormatOverWan = StringHelper.numFormatOverWan(b2Var.P0());
                if (this.K) {
                    updateReplyStateUI();
                    this.f12538i.setText(numFormatOverWan);
                } else {
                    this.f12538i.setText(String.format(this.F.getString(R.string.reply_num_tip), numFormatOverWan));
                }
                EMTextView eMTextView = this.f12538i;
                eMTextView.setContentDescription(this.F.getString(R.string.reply_num) + numFormatOverWan);
                this.H = true;
                return;
            } else if (this.K) {
                updateReplyStateUI();
                this.f12538i.setText(this.F.getString(R.string.action_comment_default));
                this.f12538i.setVisibility(0);
                this.H = true;
                return;
            } else {
                this.f12538i.setVisibility(8);
                return;
            }
        }
        this.l.setVisibility(8);
    }

    public final void M(b2 b2Var) {
        String N0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, b2Var) == null) || this.f12536g == null || b2Var == null) {
            return;
        }
        if (b2Var.q0() > 0 && this.I) {
            this.f12536g.setVisibility(0);
            if (this.P == 3) {
                N0 = b2Var.O0();
            } else {
                N0 = b2Var.N0();
            }
            this.f12536g.setText(N0);
            this.H = true;
            return;
        }
        this.f12536g.setVisibility(8);
    }

    public void N(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, b2Var) == null) || this.D == null || this.B == null || this.C == null || b2Var == null) {
            return;
        }
        if (!this.m0) {
            View view = this.c0;
            if (view != null) {
                view.setVisibility(8);
            }
            this.D.setVisibility(8);
        } else if (this.O && !r(128) && (d.a.s0.u0.b.e().g() || d.a.s0.u0.a.h().j())) {
            if (this.c0 == null) {
                View view2 = new View(getContext());
                this.c0 = view2;
                SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
                addView(this.c0);
                this.c0.setAlpha(0.5f);
                this.c0.setOnTouchListener(new e(this));
                this.c0.setOnClickListener(new f(this));
            }
            int k = l.k(getContext());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c0.getLayoutParams();
            if (layoutParams == null) {
                this.c0.setLayoutParams(new FrameLayout.LayoutParams(k, -1));
            } else {
                layoutParams.width = k;
                requestLayout();
            }
            if (!this.E.Z1() && !this.E.a2()) {
                d.a.r0.r.u.c.d(this.C).v(R.color.CAM_X0107);
                WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
            }
            this.c0.setVisibility(0);
            this.D.setVisibility(8);
        } else {
            View view3 = this.c0;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.D.setVisibility(8);
        }
    }

    public void O(b2 b2Var) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, b2Var) == null) || (view = this.o) == null || this.m == null || b2Var == null) {
            return;
        }
        if (this.M) {
            view.setVisibility(0);
            long W0 = b2Var.W0();
            if ((b2Var.Y1() || b2Var.g2()) && b2Var.g1() != null && b2Var.g1().share_info != null) {
                W0 = b2Var.g1().share_info.share_count;
            }
            String string = this.F.getString(R.string.share);
            if (W0 > 0) {
                string = StringHelper.numFormatOverWan(W0);
            }
            this.m.setText(string);
            this.H = true;
            updateShareStateUI(b2Var);
            return;
        }
        view.setVisibility(8);
    }

    public void addPraiseStats(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (this.E != null || i2 >= 0) {
                StatisticItem d2 = d(i2);
                d2.param("thread_type", this.E.j1());
                TiebaStatic.log(d2);
            }
        }
    }

    public final void c(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, shareDialogConfig) == null) {
            int i2 = this.P;
            if (i2 == 1) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
            } else if (i2 == 2) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
            } else if (i2 == 4) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            } else if (i2 == 16) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
            } else if (i2 == 7) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
            } else if (i2 == 8) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            } else if (i2 == 9) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
            } else if (i2 == 12) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
            } else if (i2 != 13) {
                shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
            } else {
                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
            }
        }
    }

    public void changeSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            onClick(this.B);
        }
    }

    public final StatisticItem d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (this.E != null || i2 >= 0) {
                StatisticItem statisticItem = new StatisticItem("c12003");
                statisticItem.param("tid", this.E.n1());
                if (this.E.j1() == 40) {
                    statisticItem.param("obj_param1", "2");
                } else if (this.E.j1() == 0) {
                    statisticItem.param("obj_param1", "1");
                }
                statisticItem.param("obj_source", "1");
                statisticItem.param("fid", this.E.Q());
                statisticItem.param("obj_locate", this.P);
                statisticItem.param("obj_id", i2);
                if (!k.isEmpty(this.S)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.S);
                }
                if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getTaskId());
                }
                statisticItem.param("nid", this.E.A0());
                statisticItem.param("card_type", this.E.L0());
                statisticItem.param("recom_source", this.E.T0);
                statisticItem.param("ab_tag", this.E.V0);
                statisticItem.param("weight", this.E.U0);
                statisticItem.param("extra", this.E.W0);
                if (this.E.J() != null && !k.isEmpty(this.E.J().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.E.J().oriUgcVid);
                }
                d.a.r0.i0.c f2 = TbPageExtraHelper.f(this);
                if (f2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                }
                if (TbPageExtraHelper.m() != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                }
                return statisticItem;
            }
            return null;
        }
        return (StatisticItem) invokeI.objValue;
    }

    public final StatisticItem e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.E == null) {
                return null;
            }
            int i2 = 0;
            int i3 = this.Q;
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
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("fid", this.E.Q());
            statisticItem.param("tid", this.E.n1());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.T);
            if (!k.isEmpty(this.S)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.S);
            }
            if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (this.E.g1() != null && this.E.g1().user_info != null && this.E.g1().user_info.is_official == 2) {
                statisticItem.param(TiebaStatic.Params.IS_OFFICIAL, this.E.g1().user_info.is_official);
            }
            statisticItem.param("card_type", this.E.L0()).param("ab_tag", this.E.V0).param("recom_source", this.E.T0).param("weight", this.E.U0).param("extra", this.E.W0);
            if (this.E.E1()) {
                statisticItem.param("obj_type", 10);
            } else if (this.E.H1()) {
                statisticItem.param("obj_type", 9);
            } else if (this.E.G1()) {
                statisticItem.param("obj_type", 8);
            } else if (this.E.F1()) {
                statisticItem.param("obj_type", 7);
            } else {
                b2 b2Var = this.E;
                if (b2Var.v1) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i4 = b2Var.Z;
                    if (i4 == 0) {
                        statisticItem.param("obj_type", 1);
                    } else if (i4 == 40) {
                        statisticItem.param("obj_type", 2);
                    } else if (i4 == 49 || i4 == 69) {
                        statisticItem.param("obj_type", 3);
                    } else if (i4 == 54) {
                        statisticItem.param("obj_type", 4);
                    } else {
                        statisticItem.param("obj_type", 5);
                    }
                }
            }
            int i5 = this.P;
            if (i5 == 1 || i5 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a002");
            }
            if (this.P == 18) {
                statisticItem.param(TiebaStatic.Params.OBJ_TAB, "a099");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.U);
            }
            if (this.E.J() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.E.J().oriUgcNid);
                if (this.E.H1() || this.E.G1()) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.E.J().oriUgcVid);
                }
            }
            if (this.E.J1()) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (!this.E.E1() && !this.E.H1()) {
                int i6 = this.E.Z;
                if (i6 == 0 || i6 == 40) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                }
            } else {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
            TbPageContext tbPageContext = this.G;
            if (tbPageContext != null) {
                d.a.r0.j0.c.b(tbPageContext.getPageActivity(), statisticItem);
            }
            statisticItem.param("nid", this.E.A0());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public final void f() {
        b2 b2Var;
        ItemInfo itemInfo;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Context context = this.F;
            if ((context instanceof l0) && ((l0) context).isInScoreTab() && (b2Var = this.E) != null && b2Var.n0() == null && (itemInfo = ((l0) this.F).getItemInfo()) != null) {
                Item.Builder builder = new Item.Builder();
                builder.item_id = Long.valueOf(itemInfo.id.longValue());
                builder.item_name = itemInfo.name;
                builder.icon_size = itemInfo.icon_size;
                builder.icon_url = itemInfo.icon_url;
                builder.tags = itemInfo.tags;
                ItemTable itemTable = itemInfo.score;
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
                this.E.F3(itemData);
            }
        }
    }

    public final void g(View view, b2 b2Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, view, b2Var) == null) || b2Var == null) {
            return;
        }
        int id = view.getId();
        int i3 = 3;
        if (id == R.id.thread_info_commont_container) {
            i2 = 3;
        } else if (id == R.id.share_num_container) {
            i2 = 4;
        } else if (id == R.id.img_agree) {
            i2 = 1;
        } else {
            i2 = id == R.id.img_disagree ? 2 : 0;
        }
        int i4 = this.P;
        if (i4 == 1) {
            i3 = 1;
        } else if (i4 == 2) {
            i3 = 2;
        } else if (i4 != 4) {
            if (i4 == 8) {
                i3 = 4;
            } else if (i4 != 9) {
                i3 = 0;
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        TiebaStatic.log(d.a.s0.g3.a.o("c13694", b2Var, i3, i2));
    }

    public TextView getBarNameTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f12535f : (TextView) invokeV.objValue;
    }

    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public View getCommentNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f12538i : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            int threadSourceForDynamicAndBjh = getThreadSourceForDynamicAndBjh();
            int threadTypeForDynamicAndBjh = getThreadTypeForDynamicAndBjh();
            if (threadSourceForDynamicAndBjh <= 0 || threadTypeForDynamicAndBjh <= 0) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
            statisticItem.param("obj_source", threadSourceForDynamicAndBjh);
            statisticItem.param("obj_type", threadTypeForDynamicAndBjh);
            TiebaStatic.log(statisticItem);
        }
    }

    public void hideDisagree() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f12537h.setAgreeAlone(true);
        }
    }

    public void hideShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.M = false;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.leftMargin = 0;
            this.j.setLayoutParams(layoutParams);
        }
    }

    public View i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, context)) == null) ? LayoutInflater.from(context).inflate(R.layout.new_thread_comment_and_praise_info_layout, (ViewGroup) this, true) : (View) invokeL.objValue;
    }

    public boolean isInFrsAllThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.m0 : invokeV.booleanValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public final String j(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, b2Var)) == null) {
            String str = null;
            if (b2Var == null) {
                return null;
            }
            if (b2Var.g1() != null && !TextUtils.isEmpty(b2Var.g1().cover)) {
                return b2Var.g1().cover;
            }
            if (b2Var.z0() == null) {
                return null;
            }
            ArrayList<MediaData> z0 = b2Var.z0();
            int size = z0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = z0.get(i2);
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
            return (str != null || b2Var.l1() == null || TextUtils.isEmpty(b2Var.l1().thumbnail_url)) ? str : b2Var.l1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public final int k(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, b2Var)) == null) {
            if (b2Var == null) {
                return 0;
            }
            if (b2Var.E1()) {
                return 10;
            }
            if (b2Var.H1()) {
                return 9;
            }
            if (b2Var.G1()) {
                return 8;
            }
            if (b2Var.F1()) {
                return 7;
            }
            if (b2Var.v1) {
                return 6;
            }
            int i2 = b2Var.Z;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 40) {
                return 2;
            }
            if (i2 == 49 || i2 == 69) {
                return 3;
            }
            return i2 == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public final int l(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, b2Var)) == null) {
            if (b2Var != null) {
                if (b2Var.e2()) {
                    return 4;
                }
                if (b2Var.g0() == 1) {
                    return 3;
                }
                if (b2Var.E1()) {
                    return 5;
                }
                if (b2Var.H1()) {
                    return 6;
                }
                if (b2Var.F1()) {
                    return 7;
                }
                if (b2Var.G1()) {
                    return 8;
                }
                if (!b2Var.v1 || b2Var.u1 == null) {
                    return b2Var.f2() ? 2 : 1;
                }
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.o.setVisibility(r(1) ? 0 : 8);
            this.l.setVisibility(r(2) ? 0 : 8);
            View view = this.t;
            int i2 = 4;
            if (r(4)) {
                i2 = 0;
            } else if (!r(64)) {
                i2 = 8;
            }
            view.setVisibility(i2);
            this.f12537h.setVisibility(r(8) ? 0 : 8);
            this.f12537h.setAgreeAlone(r(32));
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            this.F = context;
            if (context instanceof BaseActivity) {
                this.G = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                this.G = ((BaseFragmentActivity) context).getPageContext();
            }
            l.g(this.F, R.dimen.tbds84);
            o();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            p(i(this.F));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.n0);
            MessageManager.getInstance().registerListener(this.o0);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.b0 == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.b0 = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0201);
        MaskView maskView = this.i0;
        if (maskView != null) {
            maskView.c();
        }
        SkinManager.setViewTextColor(this.f12535f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f12536g, R.color.CAM_X0107);
        updateReplyStateUI();
        updateCollectStateUI(this.E);
        updateShareStateUI(this.E);
        updateManagerUI();
        c0 c0Var = this.u;
        if (c0Var != null) {
            c0Var.W();
        }
        AgreeView agreeView = this.f12537h;
        if (agreeView != null) {
            agreeView.t(this.b0);
            AgreeView agreeView2 = this.f12537h;
            b2 b2Var = this.E;
            agreeView2.setAlpha((b2Var == null || b2Var.getType() != b2.E3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view) == null) {
            b2 b2Var = this.E;
            if (b2Var == null || b2Var.getType() != b2.E3) {
                if (view == this.f12535f) {
                    s(view);
                } else if (view == this.l) {
                    u(view);
                } else if (view == this.o) {
                    A(view);
                } else if (view == this.q) {
                    x(view);
                } else if (view == this.t) {
                    w(view);
                } else if (view == this.B) {
                    z(view);
                } else if (view == this.v) {
                    y(view);
                } else if (view == this.y) {
                    t(view);
                }
            }
        }
    }

    public void onDestroy() {
        c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (c0Var = this.u) == null) {
            return;
        }
        c0Var.O();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.n0);
            MessageManager.getInstance().unRegisterListener(this.o0);
        }
    }

    public void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view) == null) {
            this.f12535f = (TextView) view.findViewById(R.id.thread_info_bar_name);
            this.f12536g = (TextView) view.findViewById(R.id.thread_info_reply_time);
            this.k0 = (LinearLayout) view.findViewById(R.id.thread_comment_layout_root);
            EMTextView eMTextView = (EMTextView) view.findViewById(R.id.thread_info_commont_num);
            this.f12538i = eMTextView;
            d.a.r0.r.u.c.d(eMTextView).y(R.string.F_X01);
            this.j = (ImageView) view.findViewById(R.id.thread_info_commont_img);
            this.k = (EMTextView) view.findViewById(R.id.thread_info_commont_grab_sofa);
            this.l = view.findViewById(R.id.thread_info_commont_container);
            EMTextView eMTextView2 = (EMTextView) view.findViewById(R.id.share_num);
            this.m = eMTextView2;
            d.a.r0.r.u.c.d(eMTextView2).y(R.string.F_X01);
            this.n = (ImageView) view.findViewById(R.id.share_num_img);
            this.o = view.findViewById(R.id.share_num_container);
            this.p = (FrameLayout) view.findViewById(R.id.btn_card_bottom_op_more_container);
            this.q = (ImageView) view.findViewById(R.id.btn_card_bottom_op_more);
            View findViewById = view.findViewById(R.id.new_agree_view);
            if (findViewById != null) {
                AgreeView agreeView = (AgreeView) findViewById;
                this.f12537h = agreeView;
                agreeView.setAfterClickListener(new a(this));
            }
            this.t = view.findViewById(R.id.manage_view_container);
            EMTextView eMTextView3 = (EMTextView) view.findViewById(R.id.thread_info_manage_text);
            this.r = eMTextView3;
            d.a.r0.r.u.c.d(eMTextView3).y(R.string.F_X01);
            this.s = (ImageView) view.findViewById(R.id.thread_info_manage_img);
            this.B = (ImageView) view.findViewById(R.id.manage_select_img);
            EMTextView eMTextView4 = (EMTextView) view.findViewById(R.id.manage_select_text);
            this.C = eMTextView4;
            d.a.r0.r.u.c.d(eMTextView4).y(R.string.F_X01);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manage_select_container);
            this.D = linearLayout;
            linearLayout.setOnTouchListener(new b(this));
            this.C.setOnClickListener(new c(this));
            this.v = (LinearLayout) view.findViewById(R.id.qq_share_container);
            this.w = (ImageView) view.findViewById(R.id.qq_share_image);
            EMTextView eMTextView5 = (EMTextView) view.findViewById(R.id.qq_share_text);
            this.x = eMTextView5;
            if (eMTextView5 != null) {
                d.a.r0.r.u.c.d(eMTextView5).y(R.string.F_X01);
            }
            this.y = (LinearLayout) view.findViewById(R.id.collect_num_container);
            this.z = (ImageView) view.findViewById(R.id.collect_num_image);
            EMTextView eMTextView6 = (EMTextView) view.findViewById(R.id.collect_num_text);
            this.A = eMTextView6;
            if (eMTextView6 != null) {
                d.a.r0.r.u.c.d(eMTextView6).y(R.string.F_X01);
            }
            this.D.setOnClickListener(new d(this));
            this.l.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.B.setOnClickListener(this);
            LinearLayout linearLayout2 = this.v;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(this);
            }
            LinearLayout linearLayout3 = this.y;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(this);
            }
        }
    }

    public final boolean q(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, b2Var)) == null) ? (b2Var == null || !b2Var.q2() || b2Var.l1() == null) ? false : true : invokeL.booleanValue;
    }

    public final boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) ? (i2 & this.f12534e) > 0 : invokeI.booleanValue;
    }

    public void resetShareContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.M = true;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.leftMargin = this.F.getResources().getDimensionPixelSize(R.dimen.tbds78);
            this.j.setLayoutParams(layoutParams);
        }
    }

    public final void s(View view) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, view) == null) || (b2Var = this.E) == null || StringUtils.isNull(b2Var.W())) {
            return;
        }
        if (!StringUtils.isNull(this.V) && !StringUtils.isNull(this.W)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.F).createCfgForpersonalized(this.E.W(), this.V, this.W)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.F).createNormalCfg(this.E.W(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
        }
        View.OnClickListener onClickListener = this.a0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAgreeClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
        }
    }

    public void setAgreeStatisticData(d.a.r0.r.q.f fVar) {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, fVar) == null) || (agreeView = this.f12537h) == null) {
            return;
        }
        agreeView.setStatisticData(fVar);
    }

    public void setAgreeViewType(b2 b2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, b2Var) == null) && b2Var != null && b2Var.p2()) {
            this.f12537h.setAgreeAlone(true);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.J = z;
            TextView textView = this.f12535f;
            if (textView != null) {
                textView.setClickable(z);
            }
        }
    }

    public void setCollectVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (linearLayout = this.y) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    public void setCommentClickable(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048627, this, z) == null) || (view = this.l) == null) {
            return;
        }
        view.setClickable(z);
        this.j.setEnabled(z);
        this.f12538i.setEnabled(z);
    }

    public void setCommentNumEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
        }
    }

    public boolean setData(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, b2Var)) == null) {
            if (b2Var == null) {
                setVisibility(8);
                return false;
            }
            this.E = b2Var;
            I();
            G(b2Var);
            M(b2Var);
            L(b2Var);
            H(b2Var);
            O(b2Var);
            updatePraiseNum(b2Var);
            N(b2Var);
            J(b2Var);
            setVisibility(this.H ? 0 : 8);
            K(b2Var);
            v();
            return this.H;
        }
        return invokeL.booleanValue;
    }

    public void setDisPraiseFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.a0 = onClickListener;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.P = i2;
            AgreeView agreeView = this.f12537h;
            if (agreeView != null) {
                agreeView.setFrom(i2);
            }
        }
    }

    public void setGameId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.T = i2;
            AgreeView agreeView = this.f12537h;
            if (agreeView != null) {
                agreeView.setGameId(i2);
            }
        }
    }

    public void setInFrsAllThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.m0 = z;
        }
    }

    public void setIsBarViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
        }
    }

    public void setLiveShareEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
        }
    }

    public void setManageVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.N = z;
        }
    }

    public void setMultiForumCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
        }
    }

    public void setNeedAddPraiseIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
        }
    }

    public void setNeedAddReplyIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.K = z;
        }
    }

    public void setOnCommentClickCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, iVar) == null) {
            this.l0 = iVar;
        }
    }

    public void setOnSelectStatusChangeListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, jVar) == null) {
            this.j0 = jVar;
        }
    }

    public void setQQShareVisible(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || (linearLayout = this.v) == null) {
            return;
        }
        if (z) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
    }

    public void setReplyTimeVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.I = z;
        }
    }

    public void setSelectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.O = z;
        }
    }

    public void setShareClickable(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z) == null) || (view = this.o) == null) {
            return;
        }
        view.setClickable(z);
        this.n.setEnabled(z);
        this.m.setEnabled(z);
    }

    public void setShareReportFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            this.Q = i2;
        }
    }

    public void setShareVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
        }
    }

    public void setShowCommonView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            setReplyTimeVisible(false);
            setIsBarViewVisible(false);
            setShowPraiseNum(true);
            setNeedAddPraiseIcon(true);
            setNeedAddReplyIcon(true);
            setShareVisible(true);
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            this.f12534e = i2;
            m();
        }
    }

    public void setShowPraiseNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.V = str;
        }
    }

    public void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.U = str;
            AgreeView agreeView = this.f12537h;
            if (agreeView != null) {
                agreeView.setTabName(str);
            }
        }
    }

    public void setYuelaouLocate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.W = str;
        }
    }

    public void showOperationMaskView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            if (z && this.i0 == null) {
                MaskView maskView = new MaskView(getContext());
                this.i0 = maskView;
                addView(maskView);
            }
            MaskView maskView2 = this.i0;
            if (maskView2 != null) {
                maskView2.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void t(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, view) == null) {
        }
    }

    public void u(View view) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048658, this, view) == null) || (b2Var = this.E) == null || this.F == null) {
            return;
        }
        m.a(b2Var.n1());
        StatisticItem statisticItem = new StatisticItem("c12942");
        statisticItem.param("obj_locate", this.P);
        statisticItem.param("obj_type", getThreadType());
        statisticItem.param("tid", this.E.n1());
        statisticItem.param("nid", this.E.A0());
        if (this.P == 18) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.E.Q());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.U);
        }
        d.a.r0.i0.c f2 = TbPageExtraHelper.f(this);
        if (f2 != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
        }
        if (TbPageExtraHelper.m() != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
        }
        TiebaStatic.log(statisticItem);
        PbActivityConfig addLocateParam = new PbActivityConfig(this.F).createFromThreadCfg(this.E, null, this.V, 0, true, false, false).addLocateParam("");
        addLocateParam.setForumId(String.valueOf(this.E.Q()));
        addLocateParam.setForumName(this.E.W());
        if (this.E.f0() && this.E.V() != null) {
            addLocateParam.setForumId(this.E.V().i());
            addLocateParam.setForumName(this.E.V().h());
        }
        addLocateParam.setJumpToCommentArea(true);
        i iVar = this.l0;
        if (iVar != null) {
            iVar.a(addLocateParam);
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && q(this.E)) {
            addLocateParam.setNeedPreLoad(true);
            d.a.s0.u0.l.c(this.E);
        }
        if (this.E.T1) {
            addLocateParam.setFromHomePageQuality(true);
        }
        if (this.E.U1() && addLocateParam.getIntent() != null) {
            addLocateParam.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        addLocateParam.setStartFrom(this.R);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, addLocateParam));
        StatisticItem statisticItem2 = new StatisticItem("c12291");
        statisticItem2.param("obj_locate", this.P);
        TiebaStatic.log(statisticItem2);
        h();
        g(view, this.E);
        View.OnClickListener onClickListener = this.a0;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void updateCollectStateUI(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048659, this, b2Var) == null) || this.z == null) {
            return;
        }
        if (b2Var != null && b2Var.h0() != 0) {
            WebPManager.setPureDrawable(this.z, R.drawable.icon_pure_pb_operate_collect26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.z, R.drawable.icon_pure_pb_operate_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void updateManagerUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_card_administration22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            EMTextView eMTextView = this.r;
            b2 b2Var = this.E;
            if (b2Var != null && b2Var.getType() == b2.E3) {
                color = d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
            ImageView imageView = this.s;
            b2 b2Var2 = this.E;
            imageView.setEnabled(b2Var2 == null || b2Var2.getType() != b2.E3);
        }
    }

    public void updatePraiseNum(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, b2Var) == null) {
            setAgreeViewType(b2Var);
            if (b2Var.z() != null) {
                b2Var.z().isInThread = true;
                this.f12537h.setCardType(b2Var.L0());
                this.f12537h.setThreadData(b2Var);
                this.f12537h.setData(b2Var.z());
            }
            AgreeView agreeView = this.f12537h;
            b2 b2Var2 = this.E;
            agreeView.setAlpha((b2Var2 == null || b2Var2.getType() != b2.E3) ? 1.0f : SkinManager.RESOURCE_ALPHA_DISABLE);
        }
    }

    public void updateReplyStateUI() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            if (this.K) {
                WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_card_comment22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            }
            ImageView imageView = this.j;
            b2 b2Var = this.E;
            imageView.setEnabled(b2Var == null || b2Var.getType() != b2.E3);
            EMTextView eMTextView = this.f12538i;
            b2 b2Var2 = this.E;
            if (b2Var2 != null && b2Var2.getType() == b2.E3) {
                color = d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE);
            } else {
                color = SkinManager.getColor(R.color.CAM_X0107);
            }
            eMTextView.setTextColor(color);
        }
    }

    public void updateShareStateUI(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, b2Var) == null) {
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_share22, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
            if (AntiHelper.o(b2Var)) {
                setShareClickable(true);
                this.m.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else if (b2Var != null && b2Var.u1 != null && this.E.u1.m) {
                setShareClickable(false);
                this.m.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
            } else {
                setShareClickable(true);
                d.a.r0.r.u.c.d(this.m).v(R.color.CAM_X0107);
            }
            b2 b2Var2 = this.E;
            if (b2Var2 == null || b2Var2.getType() != b2.E3) {
                return;
            }
            this.n.setEnabled(false);
            this.m.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
        }
    }

    public void w(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, view) == null) {
            if (this.u == null) {
                this.u = new c0(this.G, r(16));
            }
            this.u.Y(this.E);
            this.u.l();
            if (this.E != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_BAR_MANAGE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.E.Q()).param("tid", this.E.c0()));
            }
        }
    }

    public final void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, view) == null) {
        }
    }

    public void y(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, view) == null) {
        }
    }

    public void z(View view) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048668, this, view) == null) || this.B == null || (b2Var = this.E) == null || this.C == null || b2Var.o2()) {
            return;
        }
        boolean z = true;
        if (!this.E.Z1() && d.a.s0.u0.b.e().g()) {
            if (d.a.s0.u0.b.e().a(this.E)) {
                this.E.K3(true);
            }
        } else if (!this.E.a2() && d.a.s0.u0.a.h().j()) {
            if (d.a.s0.u0.a.h().a(this.E)) {
                this.E.L3(true);
            }
        } else {
            d.a.s0.u0.b.e().j(this.E);
            this.E.K3(false);
            d.a.s0.u0.a.h().l(this.E);
            this.E.L3(false);
        }
        if (!this.E.Z1() && !this.E.a2()) {
            d.a.r0.r.u.c.d(this.C).v(R.color.CAM_X0107);
            WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        } else {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0304);
            WebPManager.setPureDrawable(this.B, R.drawable.icon_pure_frs_chosen18, R.color.CAM_X0304, null);
        }
        j jVar = this.j0;
        if (jVar != null) {
            if (!this.E.Z1() && !this.E.a2()) {
                z = false;
            }
            jVar.a(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public LinearLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k0 : (LinearLayout) invokeV.objValue;
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
        l.g(TbadkApplication.getInst(), R.dimen.tbds84);
        this.f12534e = 11;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = false;
        this.O = true;
        this.P = 2;
        this.Q = 1;
        this.b0 = 3;
        this.j0 = null;
        this.m0 = true;
        this.n0 = new g(this, 2921416);
        this.o0 = new h(this, 2921417);
        n(context);
    }
}
