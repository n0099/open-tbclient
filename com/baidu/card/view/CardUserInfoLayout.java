package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.tieba.dx;
import com.baidu.tieba.ez;
import com.baidu.tieba.fia;
import com.baidu.tieba.jb5;
import com.baidu.tieba.ky5;
import com.baidu.tieba.ly5;
import com.baidu.tieba.m45;
import com.baidu.tieba.m9;
import com.baidu.tieba.my5;
import com.baidu.tieba.nx;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.ux;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.AppPosInfo;
import tbclient.PeiwanInfo;
/* loaded from: classes3.dex */
public class CardUserInfoLayout extends RelativeLayout implements ux {
    public static /* synthetic */ Interceptable $ic;
    public static final int U;
    public static final int V;
    public static final int W;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public ViewGroup D;
    public View E;
    public ThreadData F;
    public ImageView G;
    public FrameLayout H;
    public HeadCustomImageView I;
    public int J;
    public boolean K;
    public int L;
    public String M;
    public int N;
    public Runnable O;
    public View.OnClickListener P;
    public View.OnClickListener Q;
    public View.OnClickListener R;
    public final View.OnClickListener S;

    /* renamed from: T  reason: collision with root package name */
    public final View.OnClickListener f1039T;
    public final int a;
    public final int b;
    public final int c;
    public Context d;
    public int e;
    public HeadPendantClickableView f;
    public TBLottieAnimationView g;
    public TextView h;
    public TextView i;
    public UserIconBox j;
    public TbImageView k;
    public TbLevelView l;
    public UserIconBox m;
    public TextView n;
    public LocationExtendLayout o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public RelativeLayout s;
    public ImageView t;
    public LinearLayout u;
    public VirtualImageStatusTip v;
    public TBLottieAnimationView w;
    public int x;
    public int y;
    public int z;

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, tbPageContext) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public a(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public b(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public c(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public d(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String url;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.d) && this.a.F != null && this.a.F.getAuthor() != null && this.a.F.getAuthor().getTShowInfoNew() != null && ListUtils.getItem(this.a.F.getAuthor().getTShowInfoNew(), 0) != null && (url = this.a.F.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (m9.a(this.a.d) instanceof TbPageContext)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) m9.a(this.a.d), new String[]{url});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public e(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F != null && this.a.F.getAuthor() != null && !StringUtils.isNull(this.a.F.getAuthor().getName_show()) && !StringUtils.isNull(this.a.F.getAuthor().getUserId()) && this.a.F.getForum_name() != null) {
                if (this.a.F.getPeiwanInfo() != null && !TextUtils.isEmpty(this.a.F.getPeiwanInfo().scheme)) {
                    UrlManager.getInstance().dealOneLink(this.a.F.getPeiwanInfo().scheme);
                    CardUserInfoLayout cardUserInfoLayout = this.a;
                    cardUserInfoLayout.cardPeiWanClickStatistic(cardUserInfoLayout.F);
                    return;
                }
                if (view2.getTag(R.id.tag_nick_name_activity) != null && (view2.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                    String str = (String) view2.getTag(R.id.tag_nick_name_activity);
                    if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                        BrowserHelper.startWebActivity(view2.getContext(), (String) null, str, true);
                        return;
                    }
                }
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.d, this.a.F.getAuthor().getUserId(), this.a.F.getAuthor().getName_show(), this.a.F.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                personInfoActivityConfig.setSourceTid(this.a.F.getTid());
                if (this.a.F.getThreadVideoInfo() != null) {
                    z = true;
                } else {
                    z = false;
                }
                personInfoActivityConfig.setIsVideoThread(z);
                if (this.a.F.getResource() == 1) {
                    personInfoActivityConfig.setVideoPersonFrom("home");
                } else if (this.a.F.getResource() == 2) {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                } else if (this.a.F.getResource() == 5) {
                    personInfoActivityConfig.setVideoPersonFrom("topic_detail");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                if (this.a.B != null) {
                    this.a.B.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public f(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F != null && this.a.F.getAuthor() != null) {
                BrowserHelper.startWebActivity(this.a.d.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.F.getAuthor().getUserId() + "&opacity=0", true, true, true);
                if (this.a.C != null) {
                    this.a.B.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public g(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F != null && this.a.F.getAuthor() != null) {
                this.a.frsVirtualImageStatistic(nx.a);
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), this.a.F.getAuthor().getUserId(), this.a.F.getAuthor().getUserName())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public h(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.d == null) {
                return;
            }
            ThreadData threadData = (ThreadData) view2.getTag();
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().getUserGrowthData() != null) {
                int a = threadData.getAuthor().getUserGrowthData().a();
                if (threadData.isFromHomPage) {
                    CommonStatisticUtils.staticNameplateOfUserLevel(2, 2, a);
                } else if (threadData.isFromConcern) {
                    CommonStatisticUtils.staticNameplateOfUserLevel(2, 1, a);
                } else if (threadData.isFromFrs()) {
                    CommonStatisticUtils.staticNameplateOfUserLevel(2, 5, a);
                }
            }
            BrowserHelper.startWebActivity(this.a.d, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public i(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.B != null) {
                this.a.B.onClick(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public j(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ly5.d(String.valueOf(this.a.F.getFid()), this.a.F.getAuthor().getPortrait(), "7", this.a.d.getApplicationContext());
                my5.c("c15281", String.valueOf(this.a.F.getFid()), "7");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardUserInfoLayout a;

        public k(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.playAnimation();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1717332751, "Lcom/baidu/card/view/CardUserInfoLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1717332751, "Lcom/baidu/card/view/CardUserInfoLayout;");
                return;
            }
        }
        U = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        V = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds15);
        W = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    }

    public final void i() {
        HeadPendantClickableView headPendantClickableView;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (headPendantClickableView = this.f) != null && headPendantClickableView.getPendantView() != null) {
            if (q()) {
                i2 = U;
            } else {
                i2 = V;
            }
            if (this.f.getPendantView().getVisibility() != 0 && this.f.getLayerImageView().getVisibility() != 0 && !q()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                i2 = 0;
            }
            setPadding(0, 0, 0, i2);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.w = new TBLottieAnimationView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.d, R.dimen.tbds650), BdUtilHelper.getDimens(this.d, R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(this.d, R.dimen.tbds64), 0, 0, 0);
            addView(this.w, layoutParams);
            m();
            this.w.setVisibility(8);
        }
    }

    public final void r() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (threadData = this.F) != null && threadData.getAuthor() != null) {
            ThreadData threadData2 = this.F;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0106);
                HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.h);
            } else if (ListUtils.isEmpty(this.F.getAuthor().getTShowInfoNew()) && !this.F.isNewGodAuthor()) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0106);
                HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.h);
            } else {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0331);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardUserInfoLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void F(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            if (threadData.getAuthor() == null) {
                this.f.setVisibility(8);
                return;
            }
            MetaData author = threadData.getAuthor();
            if (!p(256)) {
                author.setPendantData(null);
            }
            this.f.setData(threadData);
        }
    }

    public final boolean o(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, threadData) == null) && threadData.getPeiwanInfo() != null) {
            this.J &= -257;
            F(threadData);
            this.g.setSpeed(0.8f);
            this.g.setVisibility(0);
            this.g.setLifecycleEnable(true);
            this.g.loop(true);
            this.g.post(new a(this));
        }
    }

    public final void z(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, threadData) == null) {
            if (threadData.getAuthor() != null && threadData.getAuthor().getLevel_id() > 0) {
                this.l.setLevel(threadData.getAuthor().getLevel_id(), threadData.getAuthor().getLevelName());
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds233);
        this.b = UtilHelper.getDimenPixelSize(R.dimen.tbds180);
        this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds170);
        this.e = 3;
        this.J = 34053;
        this.L = 0;
        this.M = null;
        this.N = 0;
        this.O = new c(this);
        this.P = new d(this);
        this.Q = new e(this);
        this.R = new f(this);
        this.S = new g(this);
        this.f1039T = new h(this);
        n();
    }

    public final void f(m45 m45Var, String str) {
        boolean z;
        String f2;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, m45Var, str) == null) {
            if (str == null) {
                str = "";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            String c2 = m45Var.c();
            spannableStringBuilder.insert(0, (CharSequence) c2);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                z = true;
            } else {
                z = false;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds2);
            jb5.b bVar = new jb5.b();
            bVar.y(m45Var.d());
            if (z) {
                f2 = m45Var.e();
            } else {
                f2 = m45Var.f();
            }
            bVar.D(fia.f(f2));
            if (z) {
                b2 = m45Var.a();
            } else {
                b2 = m45Var.b();
            }
            bVar.q(fia.f(b2));
            bVar.A(dimenPixelSize);
            bVar.x(dimenPixelSize);
            bVar.z(dimenPixelSize);
            bVar.v(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            bVar.E(UtilHelper.getDimenPixelSize(R.dimen.tbds8));
            spannableStringBuilder.setSpan(bVar.p(), 0, c2.length(), 33);
            this.n.setText(spannableStringBuilder);
            this.n.setPadding(0, dimenPixelSize2, 0, dimenPixelSize2);
        }
    }

    public final void B(ThreadData threadData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) && p(4096) && threadData != null && (imageView = this.t) != null) {
            if (threadData.isHeadLinePost) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            if ((i2 & this.J) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setFromScene(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.N = i2;
            HeadPendantClickableView headPendantClickableView = this.f;
            if (headPendantClickableView != null) {
                headPendantClickableView.r = i2;
            }
        }
    }

    public void setHasPlayVirtualImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.K = z;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, bdUniqueId) == null) && (headPendantClickableView = this.f) != null) {
            headPendantClickableView.setPageId(bdUniqueId);
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.J = i2;
            j();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }

    public final void A(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && this.f != null && threadData != null && this.F.getAuthor() != null) {
            this.f.setBigVDimenSize(R.dimen.tbds36);
            this.f.setIsHomePage(threadData.isFromHomPage);
            ThreadData threadData2 = this.F;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                this.f.h(false);
            } else {
                this.f.i(this.F.getAuthor());
            }
        }
    }

    public final void I(ThreadData threadData) {
        TextView textView;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) && (textView = this.h) != null && threadData != null) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.h);
            r();
            if (this.F.getAuthor() != null && !TextUtils.isEmpty(this.F.getAuthor().getName_show())) {
                str = this.F.getAuthor().getName_show();
            } else {
                str = "";
            }
            this.h.setText(str);
        }
    }

    public final void t(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            boolean z = !StringUtils.isNull(str);
            ImageView imageView = this.p;
            int i3 = 0;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            TextView textView = this.q;
            if (!z) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (z) {
                this.q.setText(str);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.p, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            }
        }
    }

    public final void C(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) && this.i != null && threadData != null && threadData.getAuthor() != null && p(16)) {
            MetaData author = threadData.getAuthor();
            if (this.i.getLayoutParams() != null) {
                this.i.getLayoutParams().width = -2;
            }
            this.i.setOnClickListener(null);
            if (author.getIs_bawu() == 1) {
                EMManager.from(this.i).setTextColor(R.color.CAM_X0101).setAlpha(R.string.A_X04).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                if (threadData.isFromBrandForum) {
                    this.i.setVisibility(0);
                    this.i.setText(R.string.brand_official);
                    return;
                } else if ("manager".equals(author.getBawu_type())) {
                    this.i.setVisibility(0);
                    this.i.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(author.getBawu_type())) {
                    this.i.setText(R.string.bawu_member_xbazhu_tip);
                    this.i.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(author.getBawu_type())) {
                    this.i.setText(R.string.bawu_content_assist_tip);
                    this.i.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(author.getBawu_type())) {
                    this.i.setText(R.string.bawu_manage_assist_tip);
                    this.i.setVisibility(0);
                    return;
                } else {
                    this.i.setVisibility(8);
                    return;
                }
            }
            this.i.setVisibility(8);
        }
    }

    public final void J(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) && threadData.getVoiceRoomData() != null && !StringUtils.isNull(threadData.getVoiceRoomData().room_name) && threadData.getVoiceRoomData().room_id.longValue() > 0) {
            if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                marginLayoutParams.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                setLayoutParams(marginLayoutParams);
            }
            if (threadData.getVoiceRoomData().status.intValue() == 1) {
                this.f.setIsclearmode(true);
                if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                    this.G.setVisibility(0);
                    SkinManager.setImageResource(this.G, R.drawable.ic_icon_mask_shang22_n);
                }
                this.J &= -257;
                F(threadData);
                this.g.setSpeed(0.8f);
                this.g.setVisibility(0);
                this.g.setLifecycleEnable(true);
                this.g.loop(true);
                this.g.post(new k(this));
            } else {
                this.g.setVisibility(8);
                this.g.setLifecycleEnable(false);
                this.g.cancelAnimation();
                this.f.setIsclearmode(false);
                this.G.setVisibility(8);
            }
            h();
        }
    }

    public final void s(ThreadData threadData) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, threadData) == null) {
            if (!p(32768)) {
                this.g.setVisibility(8);
                this.g.setLifecycleEnable(false);
                if (this.g.isAnimating()) {
                    this.g.cancelAnimation();
                }
                this.f.setIsclearmode(false);
                this.G.setVisibility(8);
                h();
                return;
            }
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().getAlaUserData() != null && threadData.getAuthor().getAlaUserData().live_status == 1) {
                z = true;
            } else {
                z = false;
            }
            if (threadData != null && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().friendRoomStatus == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && !z2) {
                this.g.setVisibility(8);
                this.g.setLifecycleEnable(false);
                this.g.cancelAnimation();
                this.f.setIsclearmode(false);
                this.G.setVisibility(8);
            } else {
                this.f.setIsclearmode(true);
                if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                    this.G.setVisibility(0);
                    SkinManager.setImageResource(this.G, R.drawable.ic_icon_mask_shang22_n);
                }
                this.J &= -257;
                F(threadData);
                this.g.setSpeed(0.8f);
                this.g.setVisibility(0);
                this.g.setLifecycleEnable(true);
                this.g.loop(true);
                this.g.post(new b(this));
            }
            h();
        }
    }

    public final void y(ThreadData threadData) {
        TextView textView;
        String threadExtendInfo;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048625, this, threadData) != null) || (textView = this.n) == null) {
            return;
        }
        if (threadData == null) {
            textView.setVisibility(8);
            return;
        }
        if (threadData.isPeiWanThread()) {
            if (!threadData.isPeiWanExtensionValid()) {
                this.n.setVisibility(8);
                return;
            }
        } else if (TextUtils.isEmpty(threadData.getThreadExtendInfo()) && !threadData.hasUserLabelInfo()) {
            this.n.setVisibility(8);
            return;
        }
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        int i2 = 0;
        if (UbsABTestHelper.isFeedLiveCardStyleA() && threadData.hasUserLabelInfo()) {
            f(threadData.getThreadAlaInfo().userLabelInfo, threadData.getThreadExtendInfo());
        } else {
            if (threadData.isPeiWanThread()) {
                if (!threadData.isPeiWanExtensionValid()) {
                    this.n.setVisibility(8);
                    return;
                }
            } else if (TextUtils.isEmpty(threadData.getThreadExtendInfo())) {
                this.n.setVisibility(8);
                return;
            }
            if (threadData.isPeiWanThread() && threadData.isPeiWanExtensionValid()) {
                threadExtendInfo = threadData.getPeiwanInfo().extension_info;
            } else {
                threadExtendInfo = threadData.getThreadExtendInfo();
            }
            this.n.setText(threadExtendInfo);
            this.n.setPadding(0, 0, 0, 0);
        }
        if (!p(128) && (!threadData.isPeiWanThread() || !threadData.isPeiWanExtensionValid())) {
            z = false;
        } else {
            z = true;
        }
        TextView textView2 = this.n;
        if (!z) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        if (threadData.isFromLocal) {
            this.o.setLocationAndDistance(threadData.getAddress(), threadData.getDistance());
        } else {
            this.o.setVisibility(8);
        }
    }

    public void D(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, threadData) != null) || this.r == null) {
            return;
        }
        if (threadData != null && (p(8) || p(512))) {
            if (this.F.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                this.r.setVisibility(0);
                this.r.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
                return;
            } else if (p(8)) {
                if (StringUtils.isNull(threadData.getRecomReason())) {
                    this.r.setVisibility(8);
                    return;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.r.getLayoutParams();
                if (marginLayoutParams != null && marginLayoutParams.bottomMargin != 0) {
                    marginLayoutParams.bottomMargin = 0;
                    this.r.setLayoutParams(marginLayoutParams);
                }
                this.r.setText(threadData.getRecomReason());
                this.r.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.F.getShareIntro())) {
                this.r.setVisibility(8);
                return;
            } else {
                this.r.setVisibility(0);
                this.r.setText(this.F.getShareIntro());
                return;
            }
        }
        this.r.setVisibility(8);
    }

    public final void G(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            if (TbSingleton.getInstance().isUserGrowthOpen() && ((!threadData.isFromHomPage || threadData.isVideoThreadType()) && threadData.getAuthor() != null && threadData.getAuthor().getUserGrowthData() != null && threadData.getAuthor().getUserGrowthData().a() >= 0 && threadData.getAuthor().getUserGrowthData().a() <= 10)) {
                int a2 = threadData.getAuthor().getUserGrowthData().a();
                this.k.setImageResource(dx.b(a2));
                this.k.setVisibility(0);
                this.k.setTag(threadData);
                this.k.setOnClickListener(this.f1039T);
                if (threadData.isFromHomPage) {
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 2, a2);
                    return;
                } else if (threadData.isFromConcern) {
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 1, a2);
                    return;
                } else if (threadData.isFromFrs()) {
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 5, a2);
                    return;
                } else {
                    return;
                }
            }
            this.k.setVisibility(8);
        }
    }

    public final void v(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, threadData) == null) {
            if (isVirtualImage()) {
                VirtualImageCustomFigure customFigure = threadData.getCustomFigure();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = -2;
                    setLayoutParams(layoutParams);
                }
                this.I.setHeadImageViewResource(customFigure.getFigureUrl());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType())) {
                    this.I.setHeadImageBackgroundColorResource(customFigure.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(customFigure.getBackGroundType())) {
                    this.I.setHeadImageBackgroundResource(customFigure.getBackgroundValue());
                }
                if (this.F.getResource() == 1) {
                    this.I.setFrom(2);
                } else if (this.F.getResource() == 2) {
                    this.I.setFrom(1);
                }
                this.I.f(threadData.getAuthor());
                this.I.setSmallWidthAndHeight(BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds94), BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds120));
                this.H.setVisibility(8);
                this.I.setVisibility(0);
                frsVirtualImageStatistic(2);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                setLayoutParams(layoutParams2);
            }
            this.H.setVisibility(0);
            this.I.setVisibility(8);
        }
    }

    public final void w(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, threadData) == null) {
            String str = "";
            t("");
            if (threadData == null || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().openRecomLocation == 0) {
                return;
            }
            String latitude = threadData.getLatitude();
            String longtitude = threadData.getLongtitude();
            boolean z2 = true;
            if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude)) {
                z = true;
            } else {
                z = false;
            }
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z && isSystemLocationProviderEnabled) {
                AppPosInfo createRecReqAppPosInfo = LocationCacheData.getInstance().createRecReqAppPosInfo();
                String str2 = createRecReqAppPosInfo.latitude;
                String str3 = createRecReqAppPosInfo.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double distance = BdUtilHelper.getDistance(JavaTypesHelper.toDouble(str2, 0.0d), JavaTypesHelper.toDouble(str3, 0.0d), JavaTypesHelper.toDouble(latitude, 0.0d), JavaTypesHelper.toDouble(longtitude, 0.0d));
                    str = distance <= 50.0d ? StringHelper.formatDistanceNum(distance) : threadData.getAddress();
                }
            } else if (z) {
                str = threadData.getAddress();
            }
            t(str);
        }
    }

    public final void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) && this.m != null && threadData != null && threadData.getAuthor() != null && p(1)) {
            ArrayList<IconData> tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) != 0) {
                this.m.setVisibility(0);
                this.m.h(tShowInfoNew, 2, this.d.getResources().getDimensionPixelSize(R.dimen.tbds48), this.d.getResources().getDimensionPixelSize(R.dimen.tbds48), this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070420), true);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public final void H(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, threadData) != null) || this.j == null) {
            return;
        }
        if (!p(32)) {
            this.j.setVisibility(8);
        } else if (threadData != null && threadData.getAuthor() != null && (threadData.middle_page_num <= 0 || threadData.middle_page_pass_flag != 0)) {
            ArrayList<IconData> iconInfo = threadData.getAuthor().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.j.setVisibility(0);
                this.j.h(iconInfo, 4, this.d.getResources().getDimensionPixelSize(R.dimen.tbds40), this.d.getResources().getDimensionPixelSize(R.dimen.tbds40), this.d.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void cardPeiWanClickStatistic(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) && threadData != null && threadData.getPeiwanInfo() != null) {
            String str2 = null;
            int i2 = this.N;
            if (i2 == 1) {
                str2 = CommonStatisticKey.KEY_HOME_PEI_WAN_CARD_CLICK;
            } else if (i2 == 2) {
                str2 = CommonStatisticKey.KEY_FRS_HOT_PEI_WAN_CARD_CLICK;
            }
            if (StringUtils.isNotNull(str2)) {
                PeiwanInfo peiwanInfo = threadData.getPeiwanInfo();
                StatisticItem statisticItem = new StatisticItem(str2);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.addParam("obj_locate", String.valueOf(threadData.floorPosition));
                statisticItem.addParam(TiebaStatic.Params.OBJ_TO, peiwanInfo.room_id.longValue());
                if (threadData.isFromNet) {
                    str = "1";
                } else {
                    str = "0";
                }
                statisticItem.addParam("obj_param1", str);
                if (this.N == 2) {
                    statisticItem.addParam("fid", threadData.getFid());
                    statisticItem.addParam("fname", threadData.getForum_name());
                }
                statisticItem.eventStat();
            }
        }
    }

    public void frsVirtualImageStatistic(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            VirtualImageCustomState customState = this.F.getCustomState();
            if (customState == null) {
                this.L = nx.f;
            } else {
                this.L = nx.e;
                this.M = this.v.j(customState);
            }
            if (this.F.isFromFrs()) {
                nx.a(i2, this.F.getTid(), nx.b, this.L, this.M, this.F.getAuthorId());
            } else if (this.F.isFromConcern()) {
                nx.a(i2, this.F.getTid(), nx.c, this.L, this.M, this.F.getAuthorId());
            }
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, threadData) == null) {
            if (threadData == null) {
                setVisibility(8);
            } else if (o(threadData)) {
                setVisibility(4);
            } else {
                this.F = threadData;
                x(threadData);
                F(threadData);
                E(threadData);
                C(threadData);
                I(threadData);
                H(threadData);
                A(threadData);
                y(threadData);
                w(threadData);
                D(threadData);
                s(threadData);
                u(threadData);
                B(threadData);
                J(threadData);
                G(threadData);
                z(threadData);
                setVisibility(0);
                v(threadData);
                this.D.post(this.O);
                i();
            }
        }
    }

    public final void x(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, threadData) == null) && threadData != null && threadData.getAuthor() != null) {
            if (threadData.isFromFrs()) {
                this.J |= 4096;
            } else {
                this.J &= -4097;
            }
            if (!threadData.isShowForumAndReply() && !(threadData instanceof AdvertAppInfo) && ((threadData.isFromHomPage && !threadData.isUgcThreadType() && !threadData.isNewGodAuthor() && !threadData.isVocieRoom() && !threadData.isAlaLiveMixThreadType() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE) || (threadData.isFromHomPage && !threadData.isVocieRoom() && !threadData.isAlaLiveMixThreadType() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE))) {
                this.J &= -129;
            } else {
                this.J |= 128;
            }
            setShowFlag(this.J);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (p(512)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.h.getMeasuredHeight());
                layoutParams.setMargins(BdUtilHelper.getDimens(this.d, R.dimen.tbds10), BdUtilHelper.getDimens(this.d, R.dimen.tbds_5), 0, 0);
                this.r.setLayoutParams(layoutParams);
            }
            int i7 = BdUtilHelper.getScreenDimensions(this.d)[0];
            if (i7 <= 0) {
                return;
            }
            int width = getWidth() - this.a;
            if (this.F.getAuthor() != null && this.F.getAuthor().getThemeCard() != null && !di.isEmpty(this.F.getAuthor().getThemeCard().getCardImageUrlAndroid()) && !this.F.isHeadLinePost) {
                i2 = this.b;
            } else {
                if (this.F.showFollowBtn()) {
                    i2 = this.c;
                }
                i3 = width;
                if (i3 > 0) {
                    return;
                }
                String string = this.d.getString(R.string.user_name_default_txt);
                if (this.F.getAuthor() != null && !StringUtils.isNull(this.F.getAuthor().getName_show())) {
                    string = this.F.getAuthor().getName_show();
                }
                this.D.getLayoutParams().width = i3;
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.m);
                arrayList.add(this.i);
                arrayList.add(this.k);
                arrayList.add(this.r);
                ky5.c(i3, string, this.h, this.l, arrayList, this.j);
                ThreadData threadData = this.F;
                if (threadData.isFromConcern) {
                    i4 = 3;
                } else if (!threadData.isFromFrs() && !this.F.isFromFrsTab()) {
                    i4 = 4;
                } else {
                    i4 = 2;
                }
                my5.a(this.h, this.m, this.k, this.l, this.j, i4);
                if (p(128)) {
                    int i8 = Integer.MAX_VALUE;
                    if (p(2048)) {
                        i5 = (i7 - this.x) - this.y;
                        i6 = this.z;
                    } else {
                        ThreadData threadData2 = this.F;
                        if (threadData2 != null && threadData2.getAuthor() != null && this.F.getAuthor().isBaijiahaoUser()) {
                            i8 = (i7 - this.x) - this.A;
                            if (!this.F.getAuthor().hadConcerned()) {
                                i5 = (i7 - this.x) - this.y;
                                i6 = this.z;
                            }
                        }
                        this.n.setMaxWidth(i8);
                        return;
                    }
                    i8 = i5 - i6;
                    this.n.setMaxWidth(i8);
                    return;
                }
                return;
            }
            width -= i2;
            i3 = width;
            if (i3 > 0) {
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.user_avatar);
            this.f = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f.getHeadView().setIsRound(true);
            this.f.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f.getHeadView().setDefaultResource(17170445);
            this.f.getHeadView().setPlaceHolder(1);
            this.f.setAfterClickListener(new i(this));
            this.H = (FrameLayout) findViewById(R.id.user_container);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) findViewById(R.id.user_avatar_virtual_image);
            this.I = headCustomImageView;
            headCustomImageView.setOnClickListener(this.S);
            this.g = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
            this.G = (ImageView) findViewById(R.id.img_official_v);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.user_tshow_icon);
            this.m = userIconBox;
            userIconBox.setOnClickListener(this.P);
            TextView textView = (TextView) findViewById(R.id.user_name);
            this.h = textView;
            textView.setOnClickListener(this.Q);
            this.i = (TextView) findViewById(R.id.identity_view);
            this.r = (TextView) findViewById(R.id.thread_share_intro);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.thread_user_icon);
            this.j = userIconBox2;
            userIconBox2.setOnClickListener(this.R);
            this.j.setAutoChangedStyle(false);
            this.n = (TextView) findViewById(R.id.thread_extend_info);
            if (DeviceInfoUtil.isMi5X()) {
                this.n.setPadding(0, -W, 0, 0);
            }
            this.o = (LocationExtendLayout) findViewById(R.id.channel_location_extend_layout);
            this.p = (ImageView) findViewById(R.id.ala_location_icon);
            this.q = (TextView) findViewById(R.id.ala_location);
            this.D = (ViewGroup) findViewById(R.id.user_name_and_reply_time);
            this.E = findViewById(R.id.card_home_page_normal_thread_user_info);
            this.s = (RelativeLayout) findViewById(R.id.suffix_container);
            this.t = (ImageView) findViewById(R.id.frs_head_line_mark);
            this.u = (LinearLayout) findViewById(R.id.second_line_container);
            VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) findViewById(R.id.virtual_image_status_tip);
            this.v = virtualImageStatusTip;
            virtualImageStatusTip.setOnClickListener(this.S);
            this.k = (TbImageView) findViewById(R.id.user_growth_level);
            TbLevelView tbLevelView = (TbLevelView) findViewById(R.id.forum_level_view);
            this.l = tbLevelView;
            tbLevelView.setOnClickListener(new j(this));
        }
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.s;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public final void h() {
        TBLottieAnimationView tBLottieAnimationView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (tBLottieAnimationView = this.g) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() == 0) {
            i2 = U;
        } else {
            i2 = 0;
        }
        setPadding(0, 0, 0, i2);
    }

    public boolean isHasPlayVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public boolean isVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ThreadData threadData = this.F;
            if (threadData == null || threadData.getCustomFigure() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.g;
            if (tBLottieAnimationView != null && tBLottieAnimationView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void recoverVirtualAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.w.setVisibility(8);
            this.w.pauseAnimation();
        }
    }

    public void recoverVirtualImageAnimate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            ez.a(this.E);
            this.u.setVisibility(0);
            this.v.setVisibility(8);
            this.I.setHeadViewNormalSize();
        }
    }

    public void startVirtualAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.w.setVisibility(0);
            this.w.playAnimation();
        }
    }

    public final void j() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            UserIconBox userIconBox = this.m;
            int i7 = 0;
            if (p(1)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            userIconBox.setVisibility(i2);
            TextView textView = this.h;
            if (p(4)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            TextView textView2 = this.i;
            if (p(16)) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            textView2.setVisibility(i4);
            TextView textView3 = this.r;
            if (p(8)) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textView3.setVisibility(i5);
            UserIconBox userIconBox2 = this.j;
            if (p(32)) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            userIconBox2.setVisibility(i6);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.D.getLayoutParams();
            if (p(128)) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            this.D.setLayoutParams(marginLayoutParams);
            ImageView imageView = this.t;
            if (!p(4096)) {
                i7 = 8;
            }
            imageView.setVisibility(i7);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
            k();
            l();
            this.x = BdUtilHelper.getDimens(this.d, R.dimen.tbds164);
            this.y = BdUtilHelper.getDimens(this.d, R.dimen.tbds156);
            this.z = BdUtilHelper.getDimens(this.d, R.dimen.tbds148);
            this.A = BdUtilHelper.getDimens(this.d, R.dimen.tbds118);
            BdUtilHelper.getDimens(this.d, R.dimen.tbds580);
        }
    }

    public void startVirtualImageAnimate() {
        ThreadData threadData;
        VirtualImageCustomFigure customFigure;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048619, this) != null) || (threadData = this.F) == null || (customFigure = threadData.getCustomFigure()) == null) {
            return;
        }
        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType())) {
            str = customFigure.getBackgroundValue();
        } else {
            str = "#7F66FE";
        }
        VirtualImageCustomState customState = this.F.getCustomState();
        if (customState != null && !TextUtils.isEmpty(customState.getIcon())) {
            this.u.setVisibility(8);
            ez.b(this.E, 400);
            this.v.setVisibility(0);
            this.v.setData(customState, true, str);
            this.v.f();
        } else {
            this.v.setVisibility(8);
        }
        this.I.h(true, 400L);
        m();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.w != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.w.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.w.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.w, R.raw.lottie_reactions_guide_left);
        }
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048603, this, tbPageContext, i2) == null) && i2 != this.e) {
            this.e = i2;
            this.f.getHeadView().setPlaceHolder(1);
            TBLottieAnimationView tBLottieAnimationView = this.g;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            if (this.G.getVisibility() == 0) {
                WebPManager.setMaskDrawable(this.G, R.drawable.ic_icon_mask_shang22_n, null);
            }
            LocationExtendLayout locationExtendLayout = this.o;
            if (locationExtendLayout != null) {
                locationExtendLayout.onChangeSkinType(tbPageContext, i2);
            }
        }
    }
}
