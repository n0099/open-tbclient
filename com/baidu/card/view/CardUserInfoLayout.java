package com.baidu.card.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.s0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
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
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes10.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int I;
    public static final int MAX_USERNAME_LENGTH = 14;
    public static final String TAB_CODE_FASHION = "fashion";
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public d2 B;
    public ImageView C;
    public int D;
    public Runnable E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public View.OnClickListener H;

    /* renamed from: e  reason: collision with root package name */
    public Context f34214e;

    /* renamed from: f  reason: collision with root package name */
    public int f34215f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantClickableView f34216g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f34217h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f34218i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f34219j;

    /* renamed from: k  reason: collision with root package name */
    public UserIconBox f34220k;
    public UserIconBox l;
    public TextView m;
    public RelativeLayout mSuffixContainer;
    public LocationExtendLayout n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public View z;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34221e;

        public a(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34221e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34221e.adjustChildWidth();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34222e;

        public b(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34222e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f34222e.f34214e) || this.f34222e.B == null || this.f34222e.B.J() == null || this.f34222e.B.J().getTShowInfoNew() == null || ListUtils.getItem(this.f34222e.B.J().getTShowInfoNew(), 0) == null || (url = this.f34222e.B.J().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f34222e.f34214e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f34222e.f34214e), new String[]{url});
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34223e;

        public c(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34223e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f34223e.B == null || this.f34223e.B.J() == null || StringUtils.isNull(this.f34223e.B.J().getName_show()) || StringUtils.isNull(this.f34223e.B.J().getUserId()) || this.f34223e.B.a0() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.f34223e.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f34223e.f34214e, this.f34223e.B.J().getUserId(), this.f34223e.B.J().getName_show(), this.f34223e.B.a0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.f34223e.B.v1());
            personInfoActivityConfig.setIsVideoThread(this.f34223e.B.t1() != null);
            if (this.f34223e.B.W0() != 1) {
                if (this.f34223e.B.W0() != 2) {
                    if (this.f34223e.B.W0() == 5) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_TOPIC_DETAIL);
                    }
                } else {
                    personInfoActivityConfig.setVideoPersonFrom("frs");
                }
            } else {
                personInfoActivityConfig.setVideoPersonFrom("home");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f34223e.x != null) {
                this.f34223e.x.onClick(view);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34224e;

        public d(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34224e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f34224e.B == null || this.f34224e.B.J() == null) {
                return;
            }
            c.a.s0.m.a.q(this.f34224e.f34214e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f34224e.B.J().getUserId(), true, true, true);
            if (this.f34224e.y != null) {
                this.f34224e.x.onClick(view);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34225e;

        public e(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34225e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f34225e.x == null) {
                return;
            }
            this.f34225e.x.onClick(view);
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34226e;

        public f(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34226e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34226e.f34217h.playAnimation();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f34227e;

        public g(CardUserInfoLayout cardUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34227e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34227e.f34217h.playAnimation();
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
        I = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
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

    public void adjustChildWidth() {
        int width;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (j(512)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f34218i.getMeasuredHeight());
                layoutParams.setMargins(n.f(this.f34214e, R.dimen.tbds10), n.f(this.f34214e, R.dimen.tbds_5), 0, 0);
                this.q.setLayoutParams(layoutParams);
            }
            TextPaint paint = this.f34218i.getPaint();
            int i4 = n.p(this.f34214e)[0];
            if (i4 > 0 && (width = (getWidth() - ((i4 * 31) / 108)) - n.f(this.f34214e, R.dimen.tbds107)) > 0) {
                int t = n.t(paint, processUserName(this.B.J().getName_show(), 12)) + this.f34218i.getPaddingLeft() + this.f34218i.getPaddingRight();
                int t2 = n.t(paint, processUserName(this.B.J().getName_show(), 10)) + this.f34218i.getPaddingLeft() + this.f34218i.getPaddingRight();
                int measuredWidth = this.l.getMeasuredWidth();
                int measuredWidth2 = this.f34218i.getMeasuredWidth();
                int measuredWidth3 = this.q.getMeasuredWidth();
                int measuredWidth4 = this.f34219j.getMeasuredWidth();
                int measuredWidth5 = this.f34220k.getMeasuredWidth();
                if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    String charSequence = this.f34218i.getText().toString();
                    int i5 = measuredWidth + measuredWidth3;
                    int i6 = measuredWidth4 + i5;
                    int i7 = measuredWidth5 + i6;
                    int i8 = t + i7;
                    if (width > i8) {
                        this.f34218i.setText(processUserName(charSequence, 12));
                    } else if (width < i8) {
                        this.f34218i.setText(processUserName(charSequence, 10));
                    }
                    if (width < i7 + t2) {
                        this.f34220k.setVisibility(8);
                    }
                    if (width < i6 + t2) {
                        this.f34219j.setVisibility(8);
                    }
                    if (width > i5 + t2) {
                        this.l.setVisibility(8);
                    }
                    if (width > measuredWidth3 + t2) {
                        this.q.setVisibility(8);
                    }
                }
                int i9 = Integer.MAX_VALUE;
                if (j(2048)) {
                    i2 = (i4 - this.s) - this.t;
                    i3 = this.u;
                } else {
                    d2 d2Var = this.B;
                    if (d2Var != null && d2Var.J() != null && this.B.J().isBaijiahaoUser()) {
                        i9 = (i4 - this.s) - this.v;
                        if (!this.B.J().hadConcerned()) {
                            i2 = (i4 - this.s) - this.t;
                            i3 = this.u;
                        }
                    }
                    this.m.setMaxWidth(i9);
                }
                i9 = i2 - i3;
                this.m.setMaxWidth(i9);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.setVisibility(j(1) ? 0 : 8);
            this.f34218i.setVisibility(j(4) ? 0 : 8);
            this.f34219j.setVisibility(j(16) ? 0 : 8);
            this.q.setVisibility(j(8) ? 0 : 8);
            this.f34220k.setVisibility(j(32) ? 0 : 8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            if (j(128)) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            this.z.setLayoutParams(layoutParams);
            this.r.setVisibility(j(4096) ? 0 : 8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.user_avatar);
            this.f34216g = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f34216g.getHeadView().setIsRound(true);
            this.f34216g.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f34216g.getHeadView().setDefaultResource(17170445);
            this.f34216g.getHeadView().setPlaceHolder(1);
            this.f34216g.setAfterClickListener(new e(this));
            this.f34217h = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
            this.C = (ImageView) findViewById(R.id.img_official_v);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.user_tshow_icon);
            this.l = userIconBox;
            userIconBox.setOnClickListener(this.F);
            TextView textView = (TextView) findViewById(R.id.user_name);
            this.f34218i = textView;
            textView.setOnClickListener(this.G);
            this.f34219j = (TextView) findViewById(R.id.identity_view);
            this.q = (TextView) findViewById(R.id.thread_share_intro);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.thread_user_icon);
            this.f34220k = userIconBox2;
            userIconBox2.setOnClickListener(this.H);
            this.f34220k.setAutoChangedStyle(false);
            this.m = (TextView) findViewById(R.id.thread_extend_info);
            if (DeviceInfoUtil.isMi5X()) {
                this.m.setPadding(0, -I, 0, 0);
            }
            this.n = (LocationExtendLayout) findViewById(R.id.channel_location_extend_layout);
            this.o = (ImageView) findViewById(R.id.ala_location_icon);
            this.p = (TextView) findViewById(R.id.ala_location);
            this.z = findViewById(R.id.user_name_and_reply_time);
            this.A = findViewById(R.id.card_home_page_normal_thread_user_info);
            this.mSuffixContainer = (RelativeLayout) findViewById(R.id.suffix_container);
            this.r = (ImageView) findViewById(R.id.frs_head_line_mark);
        }
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34216g : (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSuffixContainer : (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34218i : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f34214e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
            g();
            n.f(this.f34214e, R.dimen.tbds40);
            this.s = n.f(this.f34214e, R.dimen.tbds164);
            this.t = n.f(this.f34214e, R.dimen.tbds156);
            this.u = n.f(this.f34214e, R.dimen.tbds148);
            this.v = n.f(this.f34214e, R.dimen.tbds118);
            this.w = n.f(this.f34214e, R.dimen.tbds580);
        }
    }

    public final boolean i(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, d2Var)) == null) ? (d2Var == null || d2Var.J() == null || !d2Var.c2 || !c.a.s0.b.d.j() || d2Var.J().hadConcerned() || ThreadCardUtils.isSelf(d2Var)) ? false : true : invokeL.booleanValue;
    }

    public final boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (i2 & this.D) > 0 : invokeI.booleanValue;
    }

    public final void k() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (d2Var = this.B) == null || d2Var.J() == null) {
            return;
        }
        d2 d2Var2 = this.B;
        if (d2Var2.y1 > 0 && d2Var2.z1 == 0) {
            SkinManager.setViewTextColor(this.f34218i, R.color.CAM_X0106);
            c.a.s0.b.g.b.g(this.f34218i);
        } else if (ListUtils.isEmpty(this.B.J().getTShowInfoNew()) && !this.B.q2()) {
            SkinManager.setViewTextColor(this.f34218i, R.color.CAM_X0106);
            c.a.s0.b.g.b.g(this.f34218i);
        } else {
            SkinManager.setViewTextColor(this.f34218i, R.color.CAM_X0331);
        }
    }

    public final void l(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            if (!j(32768)) {
                this.f34217h.setVisibility(8);
                if (this.f34217h.isAnimating()) {
                    this.f34217h.cancelAnimation();
                }
                this.f34216g.setIsclearmode(false);
                this.C.setVisibility(8);
                return;
            }
            boolean z = (d2Var == null || d2Var.J() == null || d2Var.J().getAlaUserData() == null || d2Var.J().getAlaUserData().live_status != 1) ? false : true;
            boolean z2 = (d2Var == null || d2Var.o1() == null || d2Var.o1().friendRoomStatus != 2) ? false : true;
            if (!z && !z2) {
                this.f34217h.setVisibility(8);
                this.f34217h.cancelAnimation();
                this.f34216g.setIsclearmode(false);
                this.C.setVisibility(8);
                return;
            }
            this.f34216g.setIsclearmode(true);
            if (d2Var != null && d2Var.J() != null && d2Var.J().isOfficial()) {
                this.C.setVisibility(0);
                SkinManager.setImageResource(this.C, R.drawable.ic_icon_mask_shang22_n);
            }
            this.D &= -257;
            u(d2Var);
            this.f34217h.setSpeed(0.8f);
            this.f34217h.setVisibility(0);
            this.f34217h.loop(true);
            this.f34217h.post(new g(this));
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            boolean z = !StringUtils.isNull(str);
            this.o.setVisibility(z ? 0 : 8);
            this.p.setVisibility(z ? 0 : 8);
            if (z) {
                this.p.setText(str);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            }
        }
    }

    public final void n(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, d2Var) == null) {
            String str = "";
            m("");
            if (d2Var == null) {
                return;
            }
            if ((d2Var.getType() != d2.H3 && d2Var.getType() != d2.K3) || d2Var.o1() == null || d2Var.o1().openRecomLocation == 0) {
                return;
            }
            String x0 = d2Var.x0();
            String D0 = d2Var.D0();
            boolean z = true;
            boolean z2 = UtilHelper.isDecimal(x0) && UtilHelper.isDecimal(D0);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo c2 = c.a.t0.j3.j0.a.e().c();
                String str2 = c2.latitude;
                String str3 = c2.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double g2 = n.g(c.a.d.f.m.b.c(str2, 0.0d), c.a.d.f.m.b.c(str3, 0.0d), c.a.d.f.m.b.c(x0, 0.0d), c.a.d.f.m.b.c(D0, 0.0d));
                    if (g2 <= 50.0d) {
                        str = StringHelper.formatDistanceNum(g2);
                    } else {
                        str = d2Var.A();
                    }
                }
            } else if (z2) {
                str = d2Var.A();
            }
            m(str);
        }
    }

    public final void o(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, d2Var) == null) || d2Var == null || d2Var.J() == null) {
            return;
        }
        if (d2Var.isFromFrs()) {
            this.D |= 4096;
        } else {
            this.D &= -4097;
        }
        if (!d2Var.x2() && !(d2Var instanceof AdvertAppInfo) && ((d2Var.b2 && !d2Var.G2() && !d2Var.q2() && !d2Var.J2() && d2Var.getType() != d2.H3 && d2Var.getType() != d2.K3) || (d2Var.b2 && c.a.s0.b.d.w0() && !d2Var.J2() && d2Var.getType() != d2.H3 && d2Var.getType() != d2.K3))) {
            this.D &= -129;
        } else {
            this.D |= 128;
        }
        setShowFlag(this.D);
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i2) == null) || i2 == this.f34215f) {
            return;
        }
        this.f34215f = i2;
        this.f34216g.getHeadView().setPlaceHolder(1);
        TBLottieAnimationView tBLottieAnimationView = this.f34217h;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
        if (this.C.getVisibility() == 0) {
            WebPManager.setMaskDrawable(this.C, R.drawable.ic_icon_mask_shang22_n, null);
        }
        LocationExtendLayout locationExtendLayout = this.n;
        if (locationExtendLayout != null) {
            locationExtendLayout.onChangeSkinType(tbPageContext, i2);
        }
    }

    public final void p(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, d2Var) == null) || this.m == null) {
            return;
        }
        if (d2Var != null && !TextUtils.isEmpty(d2Var.p1())) {
            if (d2Var.J() != null && d2Var.J().isBaijiahaoUser()) {
                this.m.setLines(1);
                this.m.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.m.setMaxLines(Integer.MAX_VALUE);
                this.m.setEllipsize(null);
            }
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            this.m.setText(d2Var.p1());
            this.m.setVisibility(j(128) ? 0 : 8);
            if (d2Var.j2) {
                this.n.setLocationAndDistance(d2Var.A(), d2Var.S());
                return;
            } else {
                this.n.setVisibility(8);
                return;
            }
        }
        this.m.setVisibility(8);
    }

    public String processUserName(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i2)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, i2, "...") : (String) invokeLI.objValue;
    }

    public final void q(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, d2Var) == null) || this.f34216g == null || d2Var == null || this.B.J() == null) {
            return;
        }
        this.f34216g.setBigVDimenSize(R.dimen.tbds36);
        this.f34216g.setIsHomePage(d2Var.b2);
        d2 d2Var2 = this.B;
        if (d2Var2.y1 > 0 && d2Var2.z1 == 0) {
            this.f34216g.showBigVIcon(false);
        } else {
            this.f34216g.showHeadPendantAndBigV(this.B.J(), 0);
        }
    }

    public final void r(d2 d2Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, d2Var) == null) || !j(4096) || d2Var == null || (imageView = this.r) == null) {
            return;
        }
        if (d2Var.X1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void s(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, d2Var) == null) || this.f34219j == null || d2Var == null || d2Var.J() == null || !j(16)) {
            return;
        }
        MetaData J = d2Var.J();
        if (this.f34219j.getLayoutParams() != null) {
            this.f34219j.getLayoutParams().width = -2;
        }
        this.f34219j.setOnClickListener(null);
        if (J.getIs_bawu() == 1) {
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f34219j);
            d2.v(R.color.CAM_X0101);
            d2.e(R.string.A_X04);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            if (d2Var.L1) {
                this.f34219j.setVisibility(0);
                this.f34219j.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(J.getBawu_type())) {
                this.f34219j.setVisibility(0);
                this.f34219j.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(J.getBawu_type())) {
                this.f34219j.setText(R.string.bawu_member_xbazhu_tip);
                this.f34219j.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(J.getBawu_type())) {
                this.f34219j.setText(R.string.bawu_content_assist_tip);
                this.f34219j.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(J.getBawu_type())) {
                this.f34219j.setText(R.string.bawu_manage_assist_tip);
                this.f34219j.setVisibility(0);
                return;
            } else {
                this.f34219j.setVisibility(8);
                return;
            }
        }
        this.f34219j.setVisibility(8);
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, d2Var) == null) {
            if (d2Var == null) {
                setVisibility(8);
            } else if (i(d2Var)) {
                setVisibility(4);
            } else {
                this.B = d2Var;
                o(d2Var);
                u(d2Var);
                t(d2Var);
                s(d2Var);
                w(d2Var);
                v(d2Var);
                q(d2Var);
                p(d2Var);
                n(d2Var);
                updateShareIntro(d2Var);
                l(d2Var);
                r(d2Var);
                x(d2Var);
                setVisibility(0);
                if (!j(128) || d2Var.b2 || d2Var.a2() || d2Var.j2) {
                    return;
                }
                if (d2Var.e2 && TAB_CODE_FASHION.equals(d2Var.l2)) {
                    return;
                }
                this.z.post(this.E);
            }
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContext) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) || (headPendantClickableView = this.f34216g) == null) {
            return;
        }
        headPendantClickableView.setPageId(bdUniqueId);
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.D = i2;
            f();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public final void t(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, d2Var) == null) || this.l == null || d2Var == null || d2Var.J() == null || !j(1)) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = d2Var.J().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.l.setVisibility(0);
            this.l.loadIcon(tShowInfoNew, 2, this.f34214e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f34214e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f34214e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.l.setVisibility(8);
    }

    public final void u(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, d2Var) == null) {
            if (d2Var.J() == null) {
                this.f34216g.setVisibility(8);
                return;
            }
            MetaData J = d2Var.J();
            if (!j(256)) {
                J.setPendantData(null);
            }
            this.f34216g.setData(d2Var);
        }
    }

    public void updateShareIntro(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, d2Var) == null) || this.q == null) {
            return;
        }
        if (d2Var != null && (j(8) || j(512))) {
            if (this.B.getType() == d2.b4) {
                this.q.setVisibility(0);
                this.q.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
                return;
            } else if (j(8)) {
                if (StringUtils.isNull(d2Var.getRecomReason())) {
                    this.q.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.q.setLayoutParams(layoutParams);
                }
                this.q.setText(d2Var.getRecomReason());
                this.q.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.B.c1())) {
                this.q.setVisibility(8);
                return;
            } else {
                this.q.setVisibility(0);
                this.q.setText(this.B.c1());
                return;
            }
        }
        this.q.setVisibility(8);
    }

    public final void v(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, d2Var) == null) || this.f34220k == null) {
            return;
        }
        if (!j(32)) {
            this.f34220k.setVisibility(8);
        } else if (d2Var != null && d2Var.J() != null && (d2Var.y1 <= 0 || d2Var.z1 != 0)) {
            ArrayList<IconData> iconInfo = d2Var.J().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.f34220k.setVisibility(0);
                this.f34220k.loadIcon(iconInfo, 4, this.f34214e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f34214e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f34214e.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.f34220k.setVisibility(8);
        } else {
            this.f34220k.setVisibility(8);
        }
    }

    public final void w(d2 d2Var) {
        String cutChineseAndEnglishWithEmoji;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, d2Var) == null) || this.f34218i == null || d2Var == null) {
            return;
        }
        if (!d2Var.b2 && !d2Var.a2() && (!d2Var.e2 || !TAB_CODE_FASHION.equals(d2Var.l2))) {
            if (d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
                if (d2Var.j2) {
                    cutChineseAndEnglishWithEmoji = d2Var.J().getName_show();
                } else {
                    cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(d2Var.J().getName_show(), 12, "...");
                }
                this.f34218i.setText(cutChineseAndEnglishWithEmoji);
            } else {
                this.f34218i.setText(R.string.user_name_default_txt);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.width = this.w;
            this.z.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.A.getLayoutParams();
            layoutParams2.width = -1;
            this.A.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.f34218i.getLayoutParams();
            layoutParams3.width = -1;
            this.f34218i.setLayoutParams(layoutParams3);
            this.f34218i.setEllipsize(TextUtils.TruncateAt.END);
            if (d2Var.J() != null && !StringUtils.isNull(d2Var.J().getName_show())) {
                this.f34218i.setText(d2Var.J().getName_show());
            } else {
                this.f34218i.setText(R.string.user_name_default_txt);
            }
        }
        c.a.s0.b.g.b.f(this.f34218i);
        k();
    }

    public final void x(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, d2Var) == null) || d2Var.G1() == null || StringUtils.isNull(d2Var.G1().room_name) || d2Var.G1().room_id.longValue() <= 0) {
            return;
        }
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.bottomMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
            setLayoutParams(marginLayoutParams);
        }
        if (d2Var.G1().status.intValue() == 1) {
            this.f34216g.setIsclearmode(true);
            if (d2Var != null && d2Var.J() != null && d2Var.J().isOfficial()) {
                this.C.setVisibility(0);
                SkinManager.setImageResource(this.C, R.drawable.ic_icon_mask_shang22_n);
            }
            this.D &= -257;
            u(d2Var);
            this.f34217h.setSpeed(0.8f);
            this.f34217h.setVisibility(0);
            this.f34217h.loop(true);
            this.f34217h.post(new f(this));
            return;
        }
        this.f34217h.setVisibility(8);
        this.f34217h.cancelAnimation();
        this.f34216g.setIsclearmode(false);
        this.C.setVisibility(8);
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
        this.f34215f = 3;
        this.D = 34053;
        this.E = new a(this);
        this.F = new b(this);
        this.G = new c(this);
        this.H = new d(this);
        h();
    }
}
