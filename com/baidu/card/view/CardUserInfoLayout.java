package com.baidu.card.view;

import android.content.Context;
import android.text.TextPaint;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
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
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ap8;
import com.baidu.tieba.cx4;
import com.baidu.tieba.gx;
import com.baidu.tieba.hz;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.px;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.vx;
import com.baidu.tieba.y9;
import com.baidu.tieba.yg;
import com.baidu.tieba.yi;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes2.dex */
public class CardUserInfoLayout extends RelativeLayout implements vx {
    public static /* synthetic */ Interceptable $ic;
    public static final int R;
    public static final int S;
    public static final int T;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public ViewGroup B;
    public View C;
    public ThreadData D;
    public ImageView E;
    public FrameLayout F;
    public HeadCustomImageView G;
    public int H;
    public boolean I;
    public int J;
    public String K;
    public Runnable L;
    public View.OnClickListener M;
    public View.OnClickListener N;
    public View.OnClickListener O;
    public final View.OnClickListener P;
    public final View.OnClickListener Q;
    public Context a;
    public int b;
    public HeadPendantClickableView c;
    public TBLottieAnimationView d;
    public TextView e;
    public TextView f;
    public UserIconBox g;
    public TbImageView h;
    public UserIconBox i;
    public TextView j;
    public LocationExtendLayout k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public RelativeLayout o;
    public ImageView p;
    public LinearLayout q;
    public VirtualImageStatusTip r;
    public TBLottieAnimationView s;
    public HeadWorldCupFlagLayout t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public View.OnClickListener z;

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, tbPageContext) == null) {
        }
    }

    /* loaded from: classes2.dex */
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
                this.a.f();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String url;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.a) && this.a.D != null && this.a.D.getAuthor() != null && this.a.D.getAuthor().getTShowInfoNew() != null && ListUtils.getItem(this.a.D.getAuthor().getTShowInfoNew(), 0) != null && (url = this.a.D.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (y9.a(this.a.a) instanceof TbPageContext)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) y9.a(this.a.a), new String[]{url});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D != null && this.a.D.getAuthor() != null && !StringUtils.isNull(this.a.D.getAuthor().getName_show()) && !StringUtils.isNull(this.a.D.getAuthor().getUserId()) && this.a.D.getForum_name() != null) {
                if (view2.getTag(R.id.tag_nick_name_activity) != null && (view2.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                    String str = (String) view2.getTag(R.id.tag_nick_name_activity);
                    if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str, true)));
                        return;
                    }
                }
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.a, this.a.D.getAuthor().getUserId(), this.a.D.getAuthor().getName_show(), this.a.D.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
                personInfoActivityConfig.setSourceTid(this.a.D.getTid());
                if (this.a.D.getThreadVideoInfo() != null) {
                    z = true;
                } else {
                    z = false;
                }
                personInfoActivityConfig.setIsVideoThread(z);
                if (this.a.D.getResource() == 1) {
                    personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
                } else if (this.a.D.getResource() == 2) {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                } else if (this.a.D.getResource() == 5) {
                    personInfoActivityConfig.setVideoPersonFrom("topic_detail");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                if (this.a.z != null) {
                    this.a.z.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D != null && this.a.D.getAuthor() != null) {
                BrowserHelper.t(this.a.a.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.D.getAuthor().getUserId() + "&opacity=0", true, true, true);
                if (this.a.A != null) {
                    this.a.z.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D != null && this.a.D.getAuthor() != null) {
                this.a.frsVirtualImageStatistic(px.a);
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), this.a.D.getAuthor().getUserId(), this.a.D.getAuthor().getUserName())));
            }
        }
    }

    /* loaded from: classes2.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.a == null) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes2.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.z != null) {
                this.a.z.onClick(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.playAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.playAnimation();
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
        R = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        S = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        T = zi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.s = new TBLottieAnimationView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(zi.g(this.a, R.dimen.tbds650), zi.g(this.a, R.dimen.tbds100));
            layoutParams.setMargins(zi.g(this.a, R.dimen.tbds64), 0, 0, 0);
            addView(this.s, layoutParams);
            l();
            this.s.setVisibility(8);
        }
    }

    public final void r() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (threadData = this.D) != null && threadData.getAuthor() != null) {
            ThreadData threadData2 = this.D;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0106);
                HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.e);
            } else if (ListUtils.isEmpty(this.D.getAuthor().getTShowInfoNew()) && !this.D.isNewGodAuthor()) {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0106);
                HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.e);
            } else {
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0331);
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

    public final void D(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            if (threadData.getAuthor() == null) {
                this.c.setVisibility(8);
                return;
            }
            MetaData author = threadData.getAuthor();
            if (!o(256)) {
                author.setPendantData(null);
            }
            this.c.setData(threadData);
        }
    }

    public final boolean n(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
        this.b = 3;
        this.H = 34053;
        this.J = 0;
        this.K = null;
        this.L = new a(this);
        this.M = new b(this);
        this.N = new c(this);
        this.O = new d(this);
        this.P = new e(this);
        this.Q = new f(this);
        m();
    }

    public final boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if ((i2 & this.H) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setHasPlayVirtualImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.I = z;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, bdUniqueId) == null) && (headPendantClickableView = this.c) != null) {
            headPendantClickableView.setPageId(bdUniqueId);
        }
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.H = i2;
            i();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public final void z(ThreadData threadData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, threadData) == null) && o(4096) && threadData != null && (imageView = this.p) != null) {
            if (threadData.isHeadLinePost) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public final void A(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && this.f != null && threadData != null && threadData.getAuthor() != null && o(16)) {
            MetaData author = threadData.getAuthor();
            if (this.f.getLayoutParams() != null) {
                this.f.getLayoutParams().width = -2;
            }
            this.f.setOnClickListener(null);
            if (author.getIs_bawu() == 1) {
                cx4 d2 = cx4.d(this.f);
                d2.v(R.color.CAM_X0101);
                d2.e(R.string.A_X04);
                d2.n(R.string.J_X04);
                d2.f(R.color.CAM_X0302);
                if (threadData.isFromBrandForum) {
                    this.f.setVisibility(0);
                    this.f.setText(R.string.brand_official);
                    return;
                } else if ("manager".equals(author.getBawu_type())) {
                    this.f.setVisibility(0);
                    this.f.setText(R.string.bawu_member_bazhu_tip);
                    return;
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(author.getBawu_type())) {
                    this.f.setText(R.string.bawu_member_xbazhu_tip);
                    this.f.setVisibility(0);
                    return;
                } else if ("pri_content_assist".equals(author.getBawu_type())) {
                    this.f.setText(R.string.bawu_content_assist_tip);
                    this.f.setVisibility(0);
                    return;
                } else if ("pri_manage_assist".equals(author.getBawu_type())) {
                    this.f.setText(R.string.bawu_manage_assist_tip);
                    this.f.setVisibility(0);
                    return;
                } else {
                    this.f.setVisibility(8);
                    return;
                }
            }
            this.f.setVisibility(8);
        }
    }

    public final void s(ThreadData threadData) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, threadData) == null) {
            if (!o(32768)) {
                this.d.setVisibility(8);
                if (this.d.isAnimating()) {
                    this.d.cancelAnimation();
                }
                this.c.setIsclearmode(false);
                this.E.setVisibility(8);
                g();
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
                this.d.setVisibility(8);
                this.d.cancelAnimation();
                this.c.setIsclearmode(false);
                this.E.setVisibility(8);
            } else {
                this.c.setIsclearmode(true);
                if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                    this.E.setVisibility(0);
                    SkinManager.setImageResource(this.E, R.drawable.ic_icon_mask_shang22_n);
                }
                this.H &= -257;
                D(threadData);
                this.d.setSpeed(0.8f);
                this.d.setVisibility(0);
                this.d.loop(true);
                this.d.post(new i(this));
            }
            g();
        }
    }

    public void B(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || this.n == null) {
            return;
        }
        if (threadData != null && (o(8) || o(512))) {
            if (this.D.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                this.n.setVisibility(0);
                this.n.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
                return;
            } else if (o(8)) {
                if (StringUtils.isNull(threadData.getRecomReason())) {
                    this.n.setVisibility(8);
                    return;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.n.getLayoutParams();
                if (marginLayoutParams != null && marginLayoutParams.bottomMargin != 0) {
                    marginLayoutParams.bottomMargin = 0;
                    this.n.setLayoutParams(marginLayoutParams);
                }
                this.n.setText(threadData.getRecomReason());
                this.n.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.D.getShareIntro())) {
                this.n.setVisibility(8);
                return;
            } else {
                this.n.setVisibility(0);
                this.n.setText(this.D.getShareIntro());
                return;
            }
        }
        this.n.setVisibility(8);
    }

    public final void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            if (TbSingleton.getInstance().isUserGrowthOpen() && ((!threadData.isFromHomPage || threadData.isVideoThreadType()) && threadData.getAuthor() != null && threadData.getAuthor().getUserGrowthData() != null && threadData.getAuthor().getUserGrowthData().a() >= 0 && threadData.getAuthor().getUserGrowthData().a() <= 10)) {
                int a2 = threadData.getAuthor().getUserGrowthData().a();
                this.h.setImageResource(gx.b(a2));
                this.h.setVisibility(0);
                this.h.setTag(threadData);
                this.h.setOnClickListener(this.Q);
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
            this.h.setVisibility(8);
        }
    }

    public final void G(ThreadData threadData) {
        String cutChineseAndEnglishWithEmoji;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) && this.e != null && threadData != null) {
            if (!threadData.isFromHomPage && !threadData.isFromConcern() && (!threadData.isFromFeedTab || !"fashion".equals(threadData.mHomePageTopTabTabCode))) {
                if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                    if (threadData.isFromLocal) {
                        cutChineseAndEnglishWithEmoji = threadData.getAuthor().getName_show();
                    } else {
                        cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(threadData.getAuthor().getName_show(), 12, StringHelper.STRING_MORE);
                    }
                    this.e.setText(cutChineseAndEnglishWithEmoji);
                } else {
                    this.e.setText(R.string.user_name_default_txt);
                }
            } else {
                ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
                layoutParams.width = this.y;
                this.B.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
                layoutParams2.width = -1;
                this.C.setLayoutParams(layoutParams2);
                this.e.setEllipsize(TextUtils.TruncateAt.END);
                if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                    this.e.setText(threadData.getAuthor().getName_show());
                } else {
                    this.e.setText(R.string.user_name_default_txt);
                }
            }
            HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.e);
            r();
        }
    }

    public final void H(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) && threadData.getVoiceRoomData() != null && !StringUtils.isNull(threadData.getVoiceRoomData().room_name) && threadData.getVoiceRoomData().room_id.longValue() > 0) {
            if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                marginLayoutParams.bottomMargin = zi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
                setLayoutParams(marginLayoutParams);
            }
            if (threadData.getVoiceRoomData().status.intValue() == 1) {
                this.c.setIsclearmode(true);
                if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                    this.E.setVisibility(0);
                    SkinManager.setImageResource(this.E, R.drawable.ic_icon_mask_shang22_n);
                }
                this.H &= -257;
                D(threadData);
                this.d.setSpeed(0.8f);
                this.d.setVisibility(0);
                this.d.loop(true);
                this.d.post(new h(this));
            } else {
                this.d.setVisibility(8);
                this.d.cancelAnimation();
                this.c.setIsclearmode(false);
                this.E.setVisibility(8);
            }
            g();
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, threadData) == null) {
            if (threadData == null) {
                setVisibility(8);
            } else if (n(threadData)) {
                setVisibility(4);
            } else {
                this.D = threadData;
                w(threadData);
                D(threadData);
                C(threadData);
                A(threadData);
                G(threadData);
                F(threadData);
                y(threadData);
                x(threadData);
                v(threadData);
                B(threadData);
                s(threadData);
                z(threadData);
                H(threadData);
                E(threadData);
                if (WorldCupEnableSwitch.isOn() && ((threadData.isFromConcern || threadData.isFromFrs() || threadData.isFromFrsTab()) && threadData.getAuthor() != null)) {
                    this.t.b(threadData.getAuthor());
                }
                setVisibility(0);
                u(threadData);
                if (o(128) && !threadData.isFromHomPage && !threadData.isFromConcern() && !threadData.isFromLocal && (!threadData.isFromFeedTab || !"fashion".equals(threadData.mHomePageTopTabTabCode))) {
                    this.B.post(this.L);
                }
                h();
            }
        }
    }

    public final void u(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, threadData) == null) {
            if (isVirtualImage()) {
                VirtualImageCustomFigure customFigure = threadData.getCustomFigure();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = -2;
                    setLayoutParams(layoutParams);
                }
                this.G.setHeadImageViewResource(customFigure.getFigureUrl());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType())) {
                    this.G.setHeadImageBackgroundColorResource(customFigure.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(customFigure.getBackGroundType())) {
                    this.G.setHeadImageBackgroundResource(customFigure.getBackgroundValue());
                }
                if (this.D.getResource() == 1) {
                    this.G.setFrom(2);
                } else if (this.D.getResource() == 2) {
                    this.G.setFrom(1);
                }
                this.G.e(threadData.getAuthor());
                this.G.setSmallWidthAndHeight(zi.g(TbadkApplication.getInst(), R.dimen.tbds94), zi.g(TbadkApplication.getInst(), R.dimen.tbds120));
                this.F.setVisibility(8);
                this.G.setVisibility(0);
                frsVirtualImageStatistic(2);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                setLayoutParams(layoutParams2);
            }
            this.F.setVisibility(0);
            this.G.setVisibility(8);
        }
    }

    public final void v(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, threadData) == null) {
            String str = "";
            t("");
            if (threadData == null) {
                return;
            }
            if ((threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM) || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().openRecomLocation == 0) {
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
                AppPosInfo c2 = ap8.e().c();
                String str2 = c2.latitude;
                String str3 = c2.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double h2 = zi.h(yg.c(str2, 0.0d), yg.c(str3, 0.0d), yg.c(latitude, 0.0d), yg.c(longtitude, 0.0d));
                    str = h2 <= 50.0d ? StringHelper.formatDistanceNum(h2) : threadData.getAddress();
                }
            } else if (z) {
                str = threadData.getAddress();
            }
            t(str);
        }
    }

    public final void C(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) && this.i != null && threadData != null && threadData.getAuthor() != null && o(1)) {
            ArrayList<IconData> tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) != 0) {
                this.i.setVisibility(0);
                this.i.h(tShowInfoNew, 2, this.a.getResources().getDimensionPixelSize(R.dimen.tbds48), this.a.getResources().getDimensionPixelSize(R.dimen.tbds48), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302), true);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public final void F(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, threadData) != null) || this.g == null) {
            return;
        }
        if (!o(32)) {
            this.g.setVisibility(8);
        } else if (threadData != null && threadData.getAuthor() != null && (threadData.middle_page_num <= 0 || threadData.middle_page_pass_flag != 0)) {
            ArrayList<IconData> iconInfo = threadData.getAuthor().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.g.setVisibility(0);
                this.g.h(iconInfo, 4, this.a.getResources().getDimensionPixelSize(R.dimen.tbds40), this.a.getResources().getDimensionPixelSize(R.dimen.tbds40), this.a.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(8);
        }
    }

    public void frsVirtualImageStatistic(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            VirtualImageCustomState customState = this.D.getCustomState();
            if (customState == null) {
                this.J = px.f;
            } else {
                this.J = px.e;
                this.K = this.r.j(customState);
            }
            if (this.D.isFromFrs()) {
                px.a(i2, this.D.getTid(), px.b, this.J, this.K, this.D.getAuthorId());
            } else if (this.D.isFromConcern()) {
                px.a(i2, this.D.getTid(), px.c, this.J, this.K, this.D.getAuthorId());
            }
        }
    }

    public final void w(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, threadData) == null) && threadData != null && threadData.getAuthor() != null) {
            if (threadData.isFromFrs()) {
                this.H |= 4096;
            } else {
                this.H &= -4097;
            }
            if (!threadData.isShowForumAndReply() && !(threadData instanceof AdvertAppInfo) && ((threadData.isFromHomPage && !threadData.isUgcThreadType() && !threadData.isNewGodAuthor() && !threadData.isVocieRoom() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM) || (threadData.isFromHomPage && !threadData.isVocieRoom() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM))) {
                this.H &= -129;
            } else {
                this.H |= 128;
            }
            setShowFlag(this.H);
        }
    }

    public final void x(ThreadData threadData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, threadData) != null) || this.j == null) {
            return;
        }
        if (threadData != null && !TextUtils.isEmpty(threadData.getThreadExtendInfo())) {
            if (threadData.getAuthor() != null && threadData.getAuthor().isBaijiahaoUser()) {
                this.j.setLines(1);
                this.j.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.j.setMaxLines(Integer.MAX_VALUE);
                this.j.setEllipsize(null);
            }
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
            this.j.setText(threadData.getThreadExtendInfo());
            TextView textView = this.j;
            if (o(128)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (threadData.isFromLocal) {
                this.k.setLocationAndDistance(threadData.getAddress(), threadData.getDistance());
                return;
            } else {
                this.k.setVisibility(8);
                return;
            }
        }
        this.j.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        int g2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (o(512)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.e.getMeasuredHeight());
                layoutParams.setMargins(zi.g(this.a, R.dimen.tbds10), zi.g(this.a, R.dimen.tbds_5), 0, 0);
                this.n.setLayoutParams(layoutParams);
            }
            TextPaint paint = this.e.getPaint();
            int i4 = zi.s(this.a)[0];
            if (i4 <= 0) {
                return;
            }
            int width = getWidth() - ((i4 * 31) / 108);
            if (this.D.showFollowBtn()) {
                g2 = zi.g(this.a, R.dimen.tbds120);
            } else {
                if (this.D.getAuthor() != null && this.D.getAuthor().getThemeCard() != null && !yi.isEmpty(this.D.getAuthor().getThemeCard().getCardImageUrlAndroid()) && !this.D.isHeadLinePost) {
                    g2 = zi.g(this.a, R.dimen.tbds120);
                }
                if (width > 0) {
                    return;
                }
                int w = zi.w(paint, q(this.D.getAuthor().getName_show(), 12)) + this.e.getPaddingLeft() + this.e.getPaddingRight();
                int w2 = zi.w(paint, q(this.D.getAuthor().getName_show(), 10)) + this.e.getPaddingLeft() + this.e.getPaddingRight();
                int measuredWidth = this.i.getMeasuredWidth();
                int measuredWidth2 = this.e.getMeasuredWidth();
                int measuredWidth3 = this.n.getMeasuredWidth();
                int measuredWidth4 = this.f.getMeasuredWidth();
                int measuredWidth5 = this.g.getMeasuredWidth();
                int measuredWidth6 = this.h.getMeasuredWidth();
                if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5 + measuredWidth6) {
                    String charSequence = this.e.getText().toString();
                    int i5 = measuredWidth + measuredWidth3;
                    int i6 = measuredWidth4 + i5;
                    int i7 = measuredWidth5 + i6;
                    int i8 = w + i7 + measuredWidth6;
                    if (width > i8) {
                        this.e.setText(q(charSequence, 12));
                    } else if (width < i8) {
                        this.e.setText(q(charSequence, 10));
                    }
                    if (width < i7 + w2 + measuredWidth6) {
                        this.g.setVisibility(8);
                    }
                    if (width < i6 + w2 + measuredWidth6) {
                        this.f.setVisibility(8);
                    }
                    if (width < i5 + w2 + measuredWidth6) {
                        this.i.setVisibility(8);
                    }
                    if (width < measuredWidth3 + w2 + measuredWidth6) {
                        this.n.setVisibility(8);
                    }
                }
                int i9 = Integer.MAX_VALUE;
                if (o(2048)) {
                    i2 = (i4 - this.u) - this.v;
                    i3 = this.w;
                } else {
                    ThreadData threadData = this.D;
                    if (threadData != null && threadData.getAuthor() != null && this.D.getAuthor().isBaijiahaoUser()) {
                        i9 = (i4 - this.u) - this.x;
                        if (!this.D.getAuthor().hadConcerned()) {
                            i2 = (i4 - this.u) - this.v;
                            i3 = this.w;
                        }
                    }
                    this.j.setMaxWidth(i9);
                    return;
                }
                i9 = i2 - i3;
                this.j.setMaxWidth(i9);
                return;
            }
            width -= g2;
            if (width > 0) {
            }
        }
    }

    public final void g() {
        TBLottieAnimationView tBLottieAnimationView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (tBLottieAnimationView = this.d) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() == 0) {
            i2 = R;
        } else {
            i2 = 0;
        }
        setPadding(0, 0, 0, i2);
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.o;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public boolean isHasPlayVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public boolean isVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ThreadData threadData = this.D;
            if (threadData == null || threadData.getCustomFigure() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.d;
            if (tBLottieAnimationView != null && tBLottieAnimationView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void recoverVirtualAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.s.setVisibility(8);
            this.s.pauseAnimation();
        }
    }

    public void recoverVirtualImageAnimate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            hz.a(this.C);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.G.setHeadViewNormalSize();
        }
    }

    public void startVirtualAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.s.setVisibility(0);
            this.s.playAnimation();
        }
    }

    public final void h() {
        HeadPendantClickableView headPendantClickableView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (headPendantClickableView = this.c) != null && headPendantClickableView.getPendantView() != null) {
            if (p()) {
                i2 = R;
            } else {
                i2 = S;
            }
            if (this.c.getPendantView().getVisibility() != 0) {
                i2 = 0;
            }
            setPadding(0, 0, 0, i2);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.s != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.s.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.s.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.s, R.raw.lottie_reactions_guide_left);
        }
    }

    public final void i() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            UserIconBox userIconBox = this.i;
            int i7 = 0;
            if (o(1)) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            userIconBox.setVisibility(i2);
            TextView textView = this.e;
            if (o(4)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            TextView textView2 = this.f;
            if (o(16)) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            textView2.setVisibility(i4);
            TextView textView3 = this.n;
            if (o(8)) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            textView3.setVisibility(i5);
            UserIconBox userIconBox2 = this.g;
            if (o(32)) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            userIconBox2.setVisibility(i6);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
            if (o(128)) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.B.setLayoutParams(marginLayoutParams);
            ImageView imageView = this.p;
            if (!o(4096)) {
                i7 = 8;
            }
            imageView.setVisibility(i7);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
            j();
            k();
            zi.g(this.a, R.dimen.tbds40);
            this.u = zi.g(this.a, R.dimen.tbds164);
            this.v = zi.g(this.a, R.dimen.tbds156);
            this.w = zi.g(this.a, R.dimen.tbds148);
            this.x = zi.g(this.a, R.dimen.tbds118);
            this.y = zi.g(this.a, R.dimen.tbds580);
        }
    }

    public void startVirtualImageAnimate() {
        ThreadData threadData;
        VirtualImageCustomFigure customFigure;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || (threadData = this.D) == null || (customFigure = threadData.getCustomFigure()) == null) {
            return;
        }
        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType())) {
            str = customFigure.getBackgroundValue();
        } else {
            str = "#7F66FE";
        }
        VirtualImageCustomState customState = this.D.getCustomState();
        if (customState != null && !TextUtils.isEmpty(customState.getIcon())) {
            this.q.setVisibility(8);
            hz.b(this.C, 400);
            this.r.setVisibility(0);
            this.r.setData(customState, true, str);
            this.r.f();
        } else {
            this.r.setVisibility(8);
        }
        this.G.g(true, 400L);
        l();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.user_avatar);
            this.c = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.c.getHeadView().setIsRound(true);
            this.c.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.getHeadView().setDefaultResource(17170445);
            this.c.getHeadView().setPlaceHolder(1);
            this.c.setAfterClickListener(new g(this));
            this.F = (FrameLayout) findViewById(R.id.user_container);
            this.t = (HeadWorldCupFlagLayout) findViewById(R.id.world_cup_flag);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) findViewById(R.id.user_avatar_virtual_image);
            this.G = headCustomImageView;
            headCustomImageView.setOnClickListener(this.P);
            this.d = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
            this.E = (ImageView) findViewById(R.id.img_official_v);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.user_tshow_icon);
            this.i = userIconBox;
            userIconBox.setOnClickListener(this.M);
            TextView textView = (TextView) findViewById(R.id.user_name);
            this.e = textView;
            textView.setOnClickListener(this.N);
            this.f = (TextView) findViewById(R.id.identity_view);
            this.n = (TextView) findViewById(R.id.thread_share_intro);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.thread_user_icon);
            this.g = userIconBox2;
            userIconBox2.setOnClickListener(this.O);
            this.g.setAutoChangedStyle(false);
            this.j = (TextView) findViewById(R.id.thread_extend_info);
            if (DeviceInfoUtil.isMi5X()) {
                this.j.setPadding(0, -T, 0, 0);
            }
            this.k = (LocationExtendLayout) findViewById(R.id.channel_location_extend_layout);
            this.l = (ImageView) findViewById(R.id.ala_location_icon);
            this.m = (TextView) findViewById(R.id.ala_location);
            this.B = (ViewGroup) findViewById(R.id.user_name_and_reply_time);
            this.C = findViewById(R.id.card_home_page_normal_thread_user_info);
            this.o = (RelativeLayout) findViewById(R.id.suffix_container);
            this.p = (ImageView) findViewById(R.id.frs_head_line_mark);
            this.q = (LinearLayout) findViewById(R.id.second_line_container);
            VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) findViewById(R.id.virtual_image_status_tip);
            this.r = virtualImageStatusTip;
            virtualImageStatusTip.setOnClickListener(this.P);
            this.h = (TbImageView) findViewById(R.id.user_growth_level);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048600, this, tbPageContext, i2) == null) && i2 != this.b) {
            this.b = i2;
            this.c.getHeadView().setPlaceHolder(1);
            TBLottieAnimationView tBLottieAnimationView = this.d;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            if (this.E.getVisibility() == 0) {
                WebPManager.setMaskDrawable(this.E, R.drawable.ic_icon_mask_shang22_n, null);
            }
            LocationExtendLayout locationExtendLayout = this.k;
            if (locationExtendLayout != null) {
                locationExtendLayout.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    public String q(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, str, i2)) == null) {
            return StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
        }
        return (String) invokeLI.objValue;
    }

    public final void t(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            boolean z = !StringUtils.isNull(str);
            ImageView imageView = this.l;
            int i3 = 0;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            TextView textView = this.m;
            if (!z) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (z) {
                this.m.setText(str);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            }
        }
    }

    public final void y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, threadData) == null) && this.c != null && threadData != null && this.D.getAuthor() != null) {
            this.c.setBigVDimenSize(R.dimen.tbds36);
            this.c.setIsHomePage(threadData.isFromHomPage);
            ThreadData threadData2 = this.D;
            if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
                this.c.h(false);
            } else {
                this.c.j(this.D.getAuthor(), 0);
            }
        }
    }
}
