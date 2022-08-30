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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.c25;
import com.baidu.tieba.fx;
import com.baidu.tieba.i9;
import com.baidu.tieba.jx;
import com.baidu.tieba.km4;
import com.baidu.tieba.os4;
import com.baidu.tieba.pd8;
import com.baidu.tieba.pg;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.ry;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.ww;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class CardUserInfoLayout extends LinearLayout implements jx {
    public static /* synthetic */ Interceptable $ic;
    public static final int P;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public ThreadData B;
    public ImageView C;
    public FrameLayout D;
    public HeadCustomImageView E;
    public int F;
    public boolean G;
    public int H;
    public String I;
    public Runnable J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public final View.OnClickListener N;
    public final View.OnClickListener O;
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
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public ViewGroup z;

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !ViewHelper.checkUpIsLogin(this.a.a) || this.a.B == null || this.a.B.getAuthor() == null || this.a.B.getAuthor().getTShowInfoNew() == null || ListUtils.getItem(this.a.B.getAuthor().getTShowInfoNew(), 0) == null || (url = this.a.B.getAuthor().getTShowInfoNew().get(0).getUrl()) == null || !(i9.a(this.a.a) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) i9.a(this.a.a), new String[]{url});
        }
    }

    /* loaded from: classes.dex */
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.B == null || this.a.B.getAuthor() == null || StringUtils.isNull(this.a.B.getAuthor().getName_show()) || StringUtils.isNull(this.a.B.getAuthor().getUserId()) || this.a.B.getForum_name() == null) {
                return;
            }
            if (view2.getTag(R.id.obfuscated_res_0x7f092014) != null && (view2.getTag(R.id.obfuscated_res_0x7f092014) instanceof String)) {
                String str = (String) view2.getTag(R.id.obfuscated_res_0x7f092014);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.a, this.a.B.getAuthor().getUserId(), this.a.B.getAuthor().getName_show(), this.a.B.getForum_name(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.a.B.getTid());
            personInfoActivityConfig.setIsVideoThread(this.a.B.getThreadVideoInfo() != null);
            if (this.a.B.getResource() != 1) {
                if (this.a.B.getResource() != 2) {
                    if (this.a.B.getResource() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.a.x != null) {
                this.a.x.onClick(view2);
            }
        }
    }

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.B == null || this.a.B.getAuthor() == null) {
                return;
            }
            km4.s(this.a.a.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14e9), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.a.B.getAuthor().getUserId() + "&opacity=0", true, true, true);
            if (this.a.y != null) {
                this.a.x.onClick(view2);
            }
        }
    }

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.B == null || this.a.B.getAuthor() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), this.a.B.getAuthor().getUserId(), this.a.B.getAuthor().getUserName())));
            this.a.frsVirtualImageStatistic(fx.a);
        }
    }

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onClick(view2);
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
        P = ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
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

    public final void A(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || this.g == null) {
            return;
        }
        if (!k(32)) {
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

    public final void B(ThreadData threadData) {
        String cutChineseAndEnglishWithEmoji;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || this.e == null || threadData == null) {
            return;
        }
        if (!threadData.isFromHomPage && !threadData.isFromConcern() && (!threadData.isFromFeedTab || !"fashion".equals(threadData.mHomePageTopTabTabCode))) {
            if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                if (threadData.isFromLocal) {
                    cutChineseAndEnglishWithEmoji = threadData.getAuthor().getName_show();
                } else {
                    cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(threadData.getAuthor().getName_show(), 12, StringHelper.STRING_MORE);
                }
                this.e.setText(cutChineseAndEnglishWithEmoji);
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f14f1);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.width = this.w;
            this.z.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.A.getLayoutParams();
            layoutParams2.width = -1;
            this.A.setLayoutParams(layoutParams2);
            this.e.setEllipsize(TextUtils.TruncateAt.END);
            if (threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
                this.e.setText(threadData.getAuthor().getName_show());
            } else {
                this.e.setText(R.string.obfuscated_res_0x7f0f14f1);
            }
        }
        HomeGroupUbsUIHelper.handleHeadSegmentTitleView(this.e);
        m();
    }

    public final void C(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData.getVoiceRoomData() == null || StringUtils.isNull(threadData.getVoiceRoomData().room_name) || threadData.getVoiceRoomData().room_id.longValue() <= 0) {
            return;
        }
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.bottomMargin = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
            setLayoutParams(marginLayoutParams);
        }
        if (threadData.getVoiceRoomData().status.intValue() == 1) {
            this.c.setIsclearmode(true);
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                this.C.setVisibility(0);
                SkinManager.setImageResource(this.C, R.drawable.obfuscated_res_0x7f0805df);
            }
            this.F &= -257;
            y(threadData);
            this.d.setSpeed(0.8f);
            this.d.setVisibility(0);
            this.d.loop(true);
            this.d.post(new h(this));
            return;
        }
        this.d.setVisibility(8);
        this.d.cancelAnimation();
        this.c.setIsclearmode(false);
        this.C.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        int f2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        if (k(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.e.getMeasuredHeight());
            layoutParams.setMargins(ri.f(this.a, R.dimen.tbds10), ri.f(this.a, R.dimen.tbds_5), 0, 0);
            this.n.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.e.getPaint();
        int i4 = ri.q(this.a)[0];
        if (i4 <= 0) {
            return;
        }
        int width = getWidth() - ((i4 * 31) / 108);
        if (this.B.showFollowBtn()) {
            f2 = ri.f(this.a, R.dimen.tbds120);
        } else {
            if (this.B.getAuthor() != null && this.B.getAuthor().getThemeCard() != null && !qi.isEmpty(this.B.getAuthor().getThemeCard().getCardImageUrlAndroid()) && !this.B.isHeadLinePost) {
                f2 = ri.f(this.a, R.dimen.tbds120);
            }
            if (width > 0) {
                return;
            }
            int u = ri.u(paint, l(this.B.getAuthor().getName_show(), 12)) + this.e.getPaddingLeft() + this.e.getPaddingRight();
            int u2 = ri.u(paint, l(this.B.getAuthor().getName_show(), 10)) + this.e.getPaddingLeft() + this.e.getPaddingRight();
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
                int i8 = u + i7 + measuredWidth6;
                if (width > i8) {
                    this.e.setText(l(charSequence, 12));
                } else if (width < i8) {
                    this.e.setText(l(charSequence, 10));
                }
                if (width < i7 + u2 + measuredWidth6) {
                    this.g.setVisibility(8);
                }
                if (width < i6 + u2 + measuredWidth6) {
                    this.f.setVisibility(8);
                }
                if (width < i5 + u2 + measuredWidth6) {
                    this.i.setVisibility(8);
                }
                if (width < measuredWidth3 + u2 + measuredWidth6) {
                    this.n.setVisibility(8);
                }
            }
            int i9 = Integer.MAX_VALUE;
            if (k(2048)) {
                i2 = (i4 - this.s) - this.t;
                i3 = this.u;
            } else {
                ThreadData threadData = this.B;
                if (threadData != null && threadData.getAuthor() != null && this.B.getAuthor().isBaijiahaoUser()) {
                    i9 = (i4 - this.s) - this.v;
                    if (!this.B.getAuthor().hadConcerned()) {
                        i2 = (i4 - this.s) - this.t;
                        i3 = this.u;
                    }
                }
                this.j.setMaxWidth(i9);
                return;
            }
            i9 = i2 - i3;
            this.j.setMaxWidth(i9);
            return;
        }
        width -= f2;
        if (width > 0) {
        }
    }

    public void frsVirtualImageStatistic(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            c25 customState = this.B.getCustomState();
            if (customState == null) {
                this.H = fx.d;
            } else {
                this.H = fx.c;
                this.r.setData(customState.b(), customState.a());
                this.I = this.r.getData();
            }
            fx.a(i2, this.B.getTid(), fx.b, this.H, this.I);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i.setVisibility(k(1) ? 0 : 8);
            this.e.setVisibility(k(4) ? 0 : 8);
            this.f.setVisibility(k(16) ? 0 : 8);
            this.n.setVisibility(k(8) ? 0 : 8);
            this.g.setVisibility(k(32) ? 0 : 8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            if (k(128)) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.z.setLayoutParams(layoutParams);
            this.p.setVisibility(k(4096) ? 0 : 8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.obfuscated_res_0x7f09242b);
            this.c = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.c.getHeadView().setIsRound(true);
            this.c.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.getHeadView().setDefaultResource(17170445);
            this.c.getHeadView().setPlaceHolder(1);
            this.c.setAfterClickListener(new g(this));
            this.D = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092431);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) findViewById(R.id.obfuscated_res_0x7f09242d);
            this.E = headCustomImageView;
            headCustomImageView.setOnClickListener(this.N);
            this.d = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f092457);
            this.C = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ede);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.obfuscated_res_0x7f09247a);
            this.i = userIconBox;
            userIconBox.setOnClickListener(this.K);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092459);
            this.e = textView;
            textView.setOnClickListener(this.L);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090e4b);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09215e);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.obfuscated_res_0x7f092168);
            this.g = userIconBox2;
            userIconBox2.setOnClickListener(this.M);
            this.g.setAutoChangedStyle(false);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09213a);
            if (DeviceInfoUtil.isMi5X()) {
                this.j.setPadding(0, -P, 0, 0);
            }
            this.k = (LocationExtendLayout) findViewById(R.id.obfuscated_res_0x7f0905e5);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090202);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f090201);
            this.z = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09245b);
            this.A = findViewById(R.id.obfuscated_res_0x7f09053d);
            this.o = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091f5f);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b34);
            this.q = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091dd5);
            VirtualImageStatusTip virtualImageStatusTip = (VirtualImageStatusTip) findViewById(R.id.obfuscated_res_0x7f0925a9);
            this.r = virtualImageStatusTip;
            virtualImageStatusTip.setOnClickListener(this.N);
            this.h = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092436);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d089a, (ViewGroup) this, true);
            h();
            ri.f(this.a, R.dimen.tbds40);
            this.s = ri.f(this.a, R.dimen.tbds164);
            this.t = ri.f(this.a, R.dimen.tbds156);
            this.u = ri.f(this.a, R.dimen.tbds148);
            this.v = ri.f(this.a, R.dimen.tbds118);
            this.w = ri.f(this.a, R.dimen.tbds580);
        }
    }

    public boolean isHasPlayVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public boolean isVirtualImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ThreadData threadData = this.B;
            return (threadData == null || threadData.getCustomFigure() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) ? false : true : invokeL.booleanValue;
    }

    public final boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & this.F) > 0 : invokeI.booleanValue;
    }

    public String l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i2)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE) : (String) invokeLI.objValue;
    }

    public final void m() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (threadData = this.B) == null || threadData.getAuthor() == null) {
            return;
        }
        ThreadData threadData2 = this.B;
        if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0106);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.e);
        } else if (ListUtils.isEmpty(this.B.getAuthor().getTShowInfoNew()) && !this.B.isNewGodAuthor()) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0106);
            HomeGroupUbsUIHelper.handleHeadSegmentTitleViewColor(this.e);
        } else {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0331);
        }
    }

    public final void n(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            if (!k(32768)) {
                this.d.setVisibility(8);
                if (this.d.isAnimating()) {
                    this.d.cancelAnimation();
                }
                this.c.setIsclearmode(false);
                this.C.setVisibility(8);
                return;
            }
            boolean z = (threadData == null || threadData.getAuthor() == null || threadData.getAuthor().getAlaUserData() == null || threadData.getAuthor().getAlaUserData().live_status != 1) ? false : true;
            boolean z2 = (threadData == null || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().friendRoomStatus != 2) ? false : true;
            if (!z && !z2) {
                this.d.setVisibility(8);
                this.d.cancelAnimation();
                this.c.setIsclearmode(false);
                this.C.setVisibility(8);
                return;
            }
            this.c.setIsclearmode(true);
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().isOfficial()) {
                this.C.setVisibility(0);
                SkinManager.setImageResource(this.C, R.drawable.obfuscated_res_0x7f0805df);
            }
            this.F &= -257;
            y(threadData);
            this.d.setSpeed(0.8f);
            this.d.setVisibility(0);
            this.d.loop(true);
            this.d.post(new i(this));
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            boolean z = !StringUtils.isNull(str);
            this.l.setVisibility(z ? 0 : 8);
            this.m.setVisibility(z ? 0 : 8);
            if (z) {
                this.m.setText(str);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f0809a5, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            }
        }
    }

    @Override // com.baidu.tieba.jx
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i2) == null) || i2 == this.b) {
            return;
        }
        this.b = i2;
        this.c.getHeadView().setPlaceHolder(1);
        TBLottieAnimationView tBLottieAnimationView = this.d;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
        if (this.C.getVisibility() == 0) {
            WebPManager.setMaskDrawable(this.C, R.drawable.obfuscated_res_0x7f0805df, null);
        }
        LocationExtendLayout locationExtendLayout = this.k;
        if (locationExtendLayout != null) {
            locationExtendLayout.onChangeSkinType(tbPageContext, i2);
        }
    }

    public final void p(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, threadData) == null) {
            if (isVirtualImage()) {
                VirtualImageCustomFigure customFigure = threadData.getCustomFigure();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds110);
                    setLayoutParams(layoutParams);
                }
                this.E.setHeadImageViewResource(customFigure.getFigureUrl());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType())) {
                    this.E.setHeadImageBackgroundColorResource(customFigure.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(customFigure.getBackGroundType())) {
                    this.E.setHeadImageBackgroundResource(customFigure.getBackgroundValue());
                }
                this.E.d(threadData.getAuthor());
                this.E.setSmallWidthAndHeight(ri.f(TbadkApplication.getInst(), R.dimen.tbds94), ri.f(TbadkApplication.getInst(), R.dimen.tbds120));
                this.D.setVisibility(8);
                this.E.setVisibility(0);
                frsVirtualImageStatistic(2);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                setLayoutParams(layoutParams2);
            }
            this.D.setVisibility(0);
            this.E.setVisibility(8);
        }
    }

    public final void q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, threadData) == null) {
            String str = "";
            o("");
            if (threadData == null) {
                return;
            }
            if ((threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM) || threadData.getThreadAlaInfo() == null || threadData.getThreadAlaInfo().openRecomLocation == 0) {
                return;
            }
            String latitude = threadData.getLatitude();
            String longtitude = threadData.getLongtitude();
            boolean z = true;
            boolean z2 = UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo c2 = pd8.e().c();
                String str2 = c2.latitude;
                String str3 = c2.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double g2 = ri.g(pg.c(str2, 0.0d), pg.c(str3, 0.0d), pg.c(latitude, 0.0d), pg.c(longtitude, 0.0d));
                    if (g2 <= 50.0d) {
                        str = StringHelper.formatDistanceNum(g2);
                    } else {
                        str = threadData.getAddress();
                    }
                }
            } else if (z2) {
                str = threadData.getAddress();
            }
            o(str);
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        if (threadData.isFromFrs()) {
            this.F |= 4096;
        } else {
            this.F &= -4097;
        }
        if (!threadData.isShowForumAndReply() && !(threadData instanceof AdvertAppInfo) && ((threadData.isFromHomPage && !threadData.isUgcThreadType() && !threadData.isNewGodAuthor() && !threadData.isVocieRoom() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM) || (threadData.isFromHomPage && UbsABTestHelper.showNewUI() && !threadData.isVocieRoom() && threadData.getType() != ThreadData.TYPE_VIDEO_ALA_ONLIVE && threadData.getType() != ThreadData.TYPE_ALA_FRIEND_ROOM))) {
            this.F &= -129;
        } else {
            this.F |= 128;
        }
        setShowFlag(this.F);
    }

    public void recoverVirtualImageAnimate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            ry.a(this.A);
            this.q.setVisibility(0);
            this.r.setVisibility(8);
            this.E.setHeadViewNormalSize();
        }
    }

    public final void s(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, threadData) == null) || this.j == null) {
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
            this.j.setVisibility(k(128) ? 0 : 8);
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

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, threadData) == null) {
            if (threadData == null) {
                setVisibility(8);
            } else if (j(threadData)) {
                setVisibility(4);
            } else {
                this.B = threadData;
                r(threadData);
                y(threadData);
                x(threadData);
                v(threadData);
                B(threadData);
                A(threadData);
                t(threadData);
                s(threadData);
                q(threadData);
                w(threadData);
                n(threadData);
                u(threadData);
                C(threadData);
                z(threadData);
                setVisibility(0);
                p(threadData);
                if (!k(128) || threadData.isFromHomPage || threadData.isFromConcern() || threadData.isFromLocal) {
                    return;
                }
                if (threadData.isFromFeedTab && "fashion".equals(threadData.mHomePageTopTabTabCode)) {
                    return;
                }
                this.z.post(this.J);
            }
        }
    }

    public void setHasPlayVirtualImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.G = z;
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, tbPageContext) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, bdUniqueId) == null) || (headPendantClickableView = this.c) == null) {
            return;
        }
        headPendantClickableView.setPageId(bdUniqueId);
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.F = i2;
            g();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void startVirtualImageAnimate() {
        ThreadData threadData;
        VirtualImageCustomFigure customFigure;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (threadData = this.B) == null || (customFigure = threadData.getCustomFigure()) == null) {
            return;
        }
        String backgroundValue = VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(customFigure.getBackGroundType()) ? customFigure.getBackgroundValue() : "#7F66FE";
        c25 customState = this.B.getCustomState();
        if (customState != null && !TextUtils.isEmpty(customState.b())) {
            this.q.setVisibility(8);
            ry.b(this.A, 400);
            this.r.setVisibility(0);
            this.r.setData(customState.b(), customState.a(), backgroundValue);
            this.r.f();
        } else {
            this.r.setVisibility(8);
        }
        this.E.f(true, 400L);
    }

    public final void t(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, threadData) == null) || this.c == null || threadData == null || this.B.getAuthor() == null) {
            return;
        }
        this.c.setBigVDimenSize(R.dimen.tbds36);
        this.c.setIsHomePage(threadData.isFromHomPage);
        ThreadData threadData2 = this.B;
        if (threadData2.middle_page_num > 0 && threadData2.middle_page_pass_flag == 0) {
            this.c.h(false);
        } else {
            this.c.j(this.B.getAuthor(), 0);
        }
    }

    public final void u(ThreadData threadData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, threadData) == null) || !k(4096) || threadData == null || (imageView = this.p) == null) {
            return;
        }
        if (threadData.isHeadLinePost) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void v(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, threadData) == null) || this.f == null || threadData == null || threadData.getAuthor() == null || !k(16)) {
            return;
        }
        MetaData author = threadData.getAuthor();
        if (this.f.getLayoutParams() != null) {
            this.f.getLayoutParams().width = -2;
        }
        this.f.setOnClickListener(null);
        if (author.getIs_bawu() == 1) {
            os4 d2 = os4.d(this.f);
            d2.v(R.color.CAM_X0101);
            d2.e(R.string.A_X04);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            if (threadData.isFromBrandForum) {
                this.f.setVisibility(0);
                this.f.setText(R.string.obfuscated_res_0x7f0f0342);
                return;
            } else if ("manager".equals(author.getBawu_type())) {
                this.f.setVisibility(0);
                this.f.setText(R.string.obfuscated_res_0x7f0f02fb);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(author.getBawu_type())) {
                this.f.setText(R.string.obfuscated_res_0x7f0f02fc);
                this.f.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(author.getBawu_type())) {
                this.f.setText(R.string.obfuscated_res_0x7f0f02f8);
                this.f.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(author.getBawu_type())) {
                this.f.setText(R.string.obfuscated_res_0x7f0f02f9);
                this.f.setVisibility(0);
                return;
            } else {
                this.f.setVisibility(8);
                return;
            }
        }
        this.f.setVisibility(8);
    }

    public void w(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, threadData) == null) || this.n == null) {
            return;
        }
        if (threadData != null && (k(8) || k(512))) {
            if (this.B.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                this.n.setVisibility(0);
                this.n.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
                return;
            } else if (k(8)) {
                if (StringUtils.isNull(threadData.getRecomReason())) {
                    this.n.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.n.setLayoutParams(layoutParams);
                }
                this.n.setText(threadData.getRecomReason());
                this.n.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.B.getShareIntro())) {
                this.n.setVisibility(8);
                return;
            } else {
                this.n.setVisibility(0);
                this.n.setText(this.B.getShareIntro());
                return;
            }
        }
        this.n.setVisibility(8);
    }

    public final void x(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, threadData) == null) || this.i == null || threadData == null || threadData.getAuthor() == null || !k(1)) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = threadData.getAuthor().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.i.setVisibility(0);
            this.i.h(tShowInfoNew, 2, this.a.getResources().getDimensionPixelSize(R.dimen.tbds48), this.a.getResources().getDimensionPixelSize(R.dimen.tbds48), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302), true);
            return;
        }
        this.i.setVisibility(8);
    }

    public final void y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, threadData) == null) {
            if (threadData.getAuthor() == null) {
                this.c.setVisibility(8);
                return;
            }
            MetaData author = threadData.getAuthor();
            if (!k(256)) {
                author.setPendantData(null);
            }
            this.c.setData(threadData);
        }
    }

    public final void z(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, threadData) == null) {
            if (TbSingleton.getInstance().isUserGrowthOpen() && ((!threadData.isFromHomPage || threadData.isVideoThreadType()) && threadData.getAuthor() != null && threadData.getAuthor().getUserGrowthData() != null && threadData.getAuthor().getUserGrowthData().a() >= 0 && threadData.getAuthor().getUserGrowthData().a() <= 10)) {
                this.h.K(String.valueOf(ww.b(threadData.getAuthor().getUserGrowthData().a())), 24, false);
                this.h.setVisibility(0);
                this.h.setOnClickListener(this.O);
                return;
            }
            this.h.setVisibility(8);
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
        this.b = 3;
        this.F = 34053;
        this.H = 0;
        this.I = null;
        this.J = new a(this);
        this.K = new b(this);
        this.L = new c(this);
        this.M = new d(this);
        this.N = new e(this);
        this.O = new f(this);
        i();
    }
}
