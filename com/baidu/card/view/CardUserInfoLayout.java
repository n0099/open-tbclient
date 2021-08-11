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
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.l.q;
import c.a.o0.s.q.c2;
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
/* loaded from: classes5.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int H;
    public static final int MAX_USERNAME_LENGTH = 14;
    public transient /* synthetic */ FieldHolder $fh;
    public c2 A;
    public ImageView B;
    public int C;
    public Runnable D;
    public View.OnClickListener E;
    public View.OnClickListener F;
    public View.OnClickListener G;

    /* renamed from: e  reason: collision with root package name */
    public Context f38409e;

    /* renamed from: f  reason: collision with root package name */
    public int f38410f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantClickableView f38411g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f38412h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38413i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38414j;
    public UserIconBox k;
    public UserIconBox l;
    public TextView m;
    public RelativeLayout mSuffixContainer;
    public ImageView n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View y;
    public View z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f38415e;

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
            this.f38415e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38415e.adjustChildWidth();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f38416e;

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
            this.f38416e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f38416e.f38409e) || this.f38416e.A == null || this.f38416e.A.J() == null || this.f38416e.A.J().getTShowInfoNew() == null || ListUtils.getItem(this.f38416e.A.J().getTShowInfoNew(), 0) == null || (url = this.f38416e.A.J().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f38416e.f38409e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f38416e.f38409e), new String[]{url});
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f38417e;

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
            this.f38417e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38417e.A == null || this.f38417e.A.J() == null || StringUtils.isNull(this.f38417e.A.J().getName_show()) || StringUtils.isNull(this.f38417e.A.J().getUserId()) || this.f38417e.A.Z() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.f38417e.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f38417e.f38409e, this.f38417e.A.J().getUserId(), this.f38417e.A.J().getName_show(), this.f38417e.A.Z(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.f38417e.A.q1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f38417e.w != null) {
                this.f38417e.w.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f38418e;

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
            this.f38418e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38418e.A == null || this.f38418e.A.J() == null) {
                return;
            }
            c.a.o0.m.a.o(this.f38418e.f38409e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f38418e.A.J().getUserId(), true, true, true);
            if (this.f38418e.x != null) {
                this.f38418e.w.onClick(view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f38419e;

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
            this.f38419e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38419e.w == null) {
                return;
            }
            this.f38419e.w.onClick(view);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f38420e;

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
            this.f38420e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38420e.f38412h.playAnimation();
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
        H = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f38413i.getMeasuredHeight());
                layoutParams.setMargins(l.g(this.f38409e, R.dimen.tbds10), l.g(this.f38409e, R.dimen.tbds_5), 0, 0);
                this.p.setLayoutParams(layoutParams);
            }
            TextPaint paint = this.f38413i.getPaint();
            int i4 = l.p(this.f38409e)[0];
            if (i4 > 0 && (width = (getWidth() - ((i4 * 31) / 108)) - l.g(this.f38409e, R.dimen.tbds107)) > 0) {
                int t = l.t(paint, processUserName(this.A.J().getName_show(), 12)) + this.f38413i.getPaddingLeft() + this.f38413i.getPaddingRight();
                int t2 = l.t(paint, processUserName(this.A.J().getName_show(), 10)) + this.f38413i.getPaddingLeft() + this.f38413i.getPaddingRight();
                int measuredWidth = this.l.getMeasuredWidth();
                int measuredWidth2 = this.f38413i.getMeasuredWidth();
                int measuredWidth3 = this.p.getMeasuredWidth();
                int measuredWidth4 = this.f38414j.getMeasuredWidth();
                int measuredWidth5 = this.k.getMeasuredWidth();
                if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    String charSequence = this.f38413i.getText().toString();
                    int i5 = measuredWidth + measuredWidth3;
                    int i6 = measuredWidth4 + i5;
                    int i7 = measuredWidth5 + i6;
                    int i8 = t + i7;
                    if (width > i8) {
                        this.f38413i.setText(processUserName(charSequence, 12));
                    } else if (width < i8) {
                        this.f38413i.setText(processUserName(charSequence, 10));
                    }
                    if (width < i7 + t2) {
                        this.k.setVisibility(8);
                    }
                    if (width < i6 + t2) {
                        this.f38414j.setVisibility(8);
                    }
                    if (width > i5 + t2) {
                        this.l.setVisibility(8);
                    }
                    if (width > measuredWidth3 + t2) {
                        this.p.setVisibility(8);
                    }
                }
                int i9 = Integer.MAX_VALUE;
                if (j(2048)) {
                    i2 = (i4 - this.r) - this.s;
                    i3 = this.t;
                } else {
                    c2 c2Var = this.A;
                    if (c2Var != null && c2Var.J() != null && this.A.J().isBaijiahaoUser()) {
                        i9 = (i4 - this.r) - this.u;
                        if (!this.A.J().hadConcerned()) {
                            i2 = (i4 - this.r) - this.s;
                            i3 = this.t;
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
            this.f38413i.setVisibility(j(4) ? 0 : 8);
            this.f38414j.setVisibility(j(16) ? 0 : 8);
            this.p.setVisibility(j(8) ? 0 : 8);
            this.k.setVisibility(j(32) ? 0 : 8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            if (j(128)) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            this.y.setLayoutParams(layoutParams);
            this.q.setVisibility(j(4096) ? 0 : 8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.user_avatar);
            this.f38411g = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f38411g.getHeadView().setIsRound(true);
            this.f38411g.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f38411g.getHeadView().setDefaultResource(17170445);
            this.f38411g.getHeadView().setPlaceHolder(1);
            this.f38411g.setAfterClickListener(new e(this));
            this.f38412h = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
            this.B = (ImageView) findViewById(R.id.img_official_v);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.user_tshow_icon);
            this.l = userIconBox;
            userIconBox.setOnClickListener(this.E);
            TextView textView = (TextView) findViewById(R.id.user_name);
            this.f38413i = textView;
            textView.setOnClickListener(this.F);
            this.f38414j = (TextView) findViewById(R.id.identity_view);
            this.p = (TextView) findViewById(R.id.thread_share_intro);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.thread_user_icon);
            this.k = userIconBox2;
            userIconBox2.setOnClickListener(this.G);
            this.k.setAutoChangedStyle(false);
            this.m = (TextView) findViewById(R.id.thread_extend_info);
            if (DeviceInfoUtil.isMi5X()) {
                this.m.setPadding(0, -H, 0, 0);
            }
            this.n = (ImageView) findViewById(R.id.ala_location_icon);
            this.o = (TextView) findViewById(R.id.ala_location);
            this.y = findViewById(R.id.user_name_and_reply_time);
            this.z = findViewById(R.id.card_home_page_normal_thread_user_info);
            this.mSuffixContainer = (RelativeLayout) findViewById(R.id.suffix_container);
            this.q = (ImageView) findViewById(R.id.frs_head_line_mark);
        }
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38411g : (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSuffixContainer : (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38413i : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f38409e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
            g();
            l.g(this.f38409e, R.dimen.tbds40);
            this.r = l.g(this.f38409e, R.dimen.tbds164);
            this.s = l.g(this.f38409e, R.dimen.tbds156);
            this.t = l.g(this.f38409e, R.dimen.tbds148);
            this.u = l.g(this.f38409e, R.dimen.tbds118);
            this.v = l.g(this.f38409e, R.dimen.tbds580);
        }
    }

    public final boolean i(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, c2Var)) == null) ? (c2Var == null || c2Var.J() == null || !c2Var.Y1 || !c.a.o0.b.d.i() || c2Var.J().hadConcerned() || ThreadCardUtils.isSelf(c2Var)) ? false : true : invokeL.booleanValue;
    }

    public final boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (i2 & this.C) > 0 : invokeI.booleanValue;
    }

    public final void k() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (c2Var = this.A) == null || c2Var.J() == null) {
            return;
        }
        c2 c2Var2 = this.A;
        if (c2Var2.t1 > 0 && c2Var2.u1 == 0) {
            SkinManager.setViewTextColor(this.f38413i, R.color.CAM_X0106);
            c.a.o0.b.g.b.g(this.f38413i);
        } else if (ListUtils.isEmpty(this.A.J().getTShowInfoNew()) && !this.A.j2()) {
            SkinManager.setViewTextColor(this.f38413i, R.color.CAM_X0106);
            c.a.o0.b.g.b.g(this.f38413i);
        } else {
            SkinManager.setViewTextColor(this.f38413i, R.color.CAM_X0301);
        }
    }

    public final void l(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c2Var) == null) {
            if (!j(32768)) {
                this.f38412h.setVisibility(8);
                if (this.f38412h.isAnimating()) {
                    this.f38412h.cancelAnimation();
                }
                this.f38411g.setIsclearmode(false);
                this.B.setVisibility(8);
                return;
            }
            boolean z = (c2Var == null || c2Var.J() == null || c2Var.J().getAlaUserData() == null || c2Var.J().getAlaUserData().live_status != 1) ? false : true;
            boolean z2 = (c2Var == null || c2Var.j1() == null || c2Var.j1().friendRoomStatus != 2) ? false : true;
            if (!z && !z2) {
                this.f38412h.setVisibility(8);
                this.f38412h.cancelAnimation();
                this.f38411g.setIsclearmode(false);
                this.B.setVisibility(8);
                return;
            }
            this.f38411g.setIsclearmode(true);
            if (c2Var != null && c2Var.J() != null && c2Var.J().isOfficial()) {
                this.B.setVisibility(0);
                SkinManager.setImageResource(this.B, R.drawable.ic_icon_mask_shang22_n);
            }
            this.C &= -257;
            u(c2Var);
            this.f38412h.setSpeed(0.8f);
            this.f38412h.setVisibility(0);
            this.f38412h.loop(true);
            this.f38412h.post(new f(this));
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            boolean z = !StringUtils.isNull(str);
            this.n.setVisibility(z ? 0 : 8);
            this.o.setVisibility(z ? 0 : 8);
            if (z) {
                this.o.setText(str);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, null);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            }
        }
    }

    public final void n(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, c2Var) == null) {
            String str = "";
            m("");
            if (c2Var == null) {
                return;
            }
            if ((c2Var.getType() != c2.u3 && c2Var.getType() != c2.x3) || c2Var.j1() == null || c2Var.j1().openRecomLocation == 0) {
                return;
            }
            String u0 = c2Var.u0();
            String A0 = c2Var.A0();
            boolean z = true;
            boolean z2 = UtilHelper.isDecimal(u0) && UtilHelper.isDecimal(A0);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo c2 = c.a.p0.x2.j0.a.e().c();
                String str2 = c2.latitude;
                String str3 = c2.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double a2 = l.a(c.a.e.e.m.b.b(str2, 0.0d), c.a.e.e.m.b.b(str3, 0.0d), c.a.e.e.m.b.b(u0, 0.0d), c.a.e.e.m.b.b(A0, 0.0d));
                    if (a2 <= 50.0d) {
                        str = StringHelper.formatDistanceNum(a2);
                    } else {
                        str = c2Var.A();
                    }
                }
            } else if (z2) {
                str = c2Var.A();
            }
            m(str);
        }
    }

    public final void o(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, c2Var) == null) || c2Var == null || c2Var.J() == null) {
            return;
        }
        if (c2Var.isFromFrs()) {
            this.C |= 4096;
        } else {
            this.C &= -4097;
        }
        if (!c2Var.q2() && !(c2Var instanceof AdvertAppInfo) && ((c2Var.X1 && !c2Var.z2() && !c2Var.j2() && c2Var.getType() != c2.u3 && c2Var.getType() != c2.x3) || (c2Var.X1 && c.a.o0.b.d.r0() && c2Var.getType() != c2.u3 && c2Var.getType() != c2.x3))) {
            this.C &= -129;
        } else {
            this.C |= 128;
        }
        setShowFlag(this.C);
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, tbPageContext, i2) == null) || i2 == this.f38410f) {
            return;
        }
        this.f38410f = i2;
        this.f38411g.getHeadView().setPlaceHolder(1);
        TBLottieAnimationView tBLottieAnimationView = this.f38412h;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
        if (this.B.getVisibility() == 0) {
            WebPManager.setMaskDrawable(this.B, R.drawable.ic_icon_mask_shang22_n, null);
        }
    }

    public final void p(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, c2Var) == null) || this.m == null) {
            return;
        }
        if (c2Var != null && !TextUtils.isEmpty(c2Var.k1())) {
            if (c2Var.J() != null && c2Var.J().isBaijiahaoUser()) {
                this.m.setLines(1);
                this.m.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.m.setMaxLines(Integer.MAX_VALUE);
                this.m.setEllipsize(null);
            }
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            this.m.setText(c2Var.k1());
            this.m.setVisibility(j(128) ? 0 : 8);
            return;
        }
        this.m.setVisibility(8);
    }

    public String processUserName(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i2)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, i2, "...") : (String) invokeLI.objValue;
    }

    public final void q(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, c2Var) == null) || this.f38411g == null || c2Var == null || this.A.J() == null) {
            return;
        }
        this.f38411g.setBigVDimenSize(R.dimen.tbds32);
        if (UtilHelper.showHeadBjhBigVIcon(this.f38411g, this.A.J(), 0)) {
            return;
        }
        this.f38411g.setIsHomePage(c2Var.X1);
        c2 c2Var2 = this.A;
        if (c2Var2.t1 > 0 && c2Var2.u1 == 0) {
            this.f38411g.showBigVIcon(false);
        } else {
            this.f38411g.showHeadPendantAndBigV(this.A.J(), 0);
        }
    }

    public final void r(c2 c2Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, c2Var) == null) || !j(4096) || c2Var == null || (imageView = this.q) == null) {
            return;
        }
        if (c2Var.T1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void s(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, c2Var) == null) || this.f38414j == null || c2Var == null || c2Var.J() == null || !j(16)) {
            return;
        }
        MetaData J = c2Var.J();
        if (this.f38414j.getLayoutParams() != null) {
            this.f38414j.getLayoutParams().width = -2;
        }
        this.f38414j.setOnClickListener(null);
        if (J.getIs_bawu() == 1) {
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.f38414j);
            d2.t(R.color.CAM_X0101);
            d2.e(R.string.A_X04);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            if (c2Var.H1) {
                this.f38414j.setVisibility(0);
                this.f38414j.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(J.getBawu_type())) {
                this.f38414j.setVisibility(0);
                this.f38414j.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(J.getBawu_type())) {
                this.f38414j.setText(R.string.bawu_member_xbazhu_tip);
                this.f38414j.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(J.getBawu_type())) {
                this.f38414j.setText(R.string.bawu_content_assist_tip);
                this.f38414j.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(J.getBawu_type())) {
                this.f38414j.setText(R.string.bawu_manage_assist_tip);
                this.f38414j.setVisibility(0);
                return;
            } else {
                this.f38414j.setVisibility(8);
                return;
            }
        }
        this.f38414j.setVisibility(8);
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, c2Var) == null) {
            if (c2Var == null) {
                setVisibility(8);
            } else if (i(c2Var)) {
                setVisibility(4);
            } else {
                this.A = c2Var;
                o(c2Var);
                u(c2Var);
                t(c2Var);
                s(c2Var);
                w(c2Var);
                v(c2Var);
                q(c2Var);
                p(c2Var);
                n(c2Var);
                updateShareIntro(c2Var);
                l(c2Var);
                r(c2Var);
                setVisibility(0);
                if (!j(128) || c2Var.X1 || c2Var.U1()) {
                    return;
                }
                this.y.post(this.D);
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
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) || (headPendantClickableView = this.f38411g) == null) {
            return;
        }
        headPendantClickableView.setPageId(bdUniqueId);
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.C = i2;
            f();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public final void t(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, c2Var) == null) || this.l == null || c2Var == null || c2Var.J() == null || !j(1)) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = c2Var.J().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.l.setVisibility(0);
            this.l.loadIcon(tShowInfoNew, 2, this.f38409e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f38409e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f38409e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.l.setVisibility(8);
    }

    public final void u(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, c2Var) == null) {
            if (c2Var.J() == null) {
                this.f38411g.setVisibility(8);
                return;
            }
            MetaData J = c2Var.J();
            if (!j(256)) {
                J.setPendantData(null);
            }
            this.f38411g.setData(c2Var);
        }
    }

    public void updateShareIntro(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, c2Var) == null) || this.p == null) {
            return;
        }
        if (c2Var != null && (j(8) || j(512))) {
            if (this.A.getType() == c2.P3) {
                this.p.setVisibility(0);
                this.p.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
                return;
            } else if (j(8)) {
                if (StringUtils.isNull(c2Var.getRecomReason())) {
                    this.p.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.p.setLayoutParams(layoutParams);
                }
                this.p.setText(c2Var.getRecomReason());
                this.p.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.A.Y0())) {
                this.p.setVisibility(8);
                return;
            } else {
                this.p.setVisibility(0);
                this.p.setText(this.A.Y0());
                return;
            }
        }
        this.p.setVisibility(8);
    }

    public final void v(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, c2Var) == null) || this.k == null) {
            return;
        }
        if (!j(32)) {
            this.k.setVisibility(8);
        } else if (c2Var != null && c2Var.J() != null && (c2Var.t1 <= 0 || c2Var.u1 != 0)) {
            ArrayList<IconData> iconInfo = c2Var.J().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.k.setVisibility(0);
                this.k.loadIcon(iconInfo, 4, this.f38409e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f38409e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f38409e.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
    }

    public final void w(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, c2Var) == null) || this.f38413i == null || c2Var == null) {
            return;
        }
        if (!c2Var.X1 && !c2Var.U1()) {
            if (c2Var.J() != null && !StringUtils.isNull(c2Var.J().getName_show())) {
                this.f38413i.setText(StringHelper.cutChineseAndEnglishWithEmoji(c2Var.J().getName_show(), 12, "..."));
            } else {
                this.f38413i.setText(R.string.user_name_default_txt);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            layoutParams.width = this.v;
            this.y.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.z.getLayoutParams();
            layoutParams2.width = -1;
            this.z.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.f38413i.getLayoutParams();
            layoutParams3.width = -1;
            this.f38413i.setLayoutParams(layoutParams3);
            this.f38413i.setEllipsize(TextUtils.TruncateAt.END);
            if (c2Var.J() != null && !StringUtils.isNull(c2Var.J().getName_show())) {
                this.f38413i.setText(c2Var.J().getName_show());
            } else {
                this.f38413i.setText(R.string.user_name_default_txt);
            }
        }
        c.a.o0.b.g.b.f(this.f38413i);
        k();
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
        this.f38410f = 3;
        this.C = 34053;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        h();
    }
}
