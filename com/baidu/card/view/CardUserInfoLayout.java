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
import d.a.d.a.j;
import d.a.d.e.p.l;
import d.a.k.q;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public static final int I;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public b2 B;
    public ImageView C;
    public int D;
    public Runnable E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public View.OnClickListener H;

    /* renamed from: e  reason: collision with root package name */
    public Context f4441e;

    /* renamed from: f  reason: collision with root package name */
    public int f4442f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantClickableView f4443g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f4444h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4445i;
    public TextView j;
    public UserIconBox k;
    public UserIconBox l;
    public TextView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public RelativeLayout q;
    public ImageView r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public View z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f4446e;

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
            this.f4446e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4446e.f();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f4447e;

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
            this.f4447e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f4447e.f4441e) || this.f4447e.B == null || this.f4447e.B.H() == null || this.f4447e.B.H().getTShowInfoNew() == null || ListUtils.getItem(this.f4447e.B.H().getTShowInfoNew(), 0) == null || (url = this.f4447e.B.H().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f4447e.f4441e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f4447e.f4441e), new String[]{url});
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f4448e;

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
            this.f4448e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4448e.B == null || this.f4448e.B.H() == null || StringUtils.isNull(this.f4448e.B.H().getName_show()) || StringUtils.isNull(this.f4448e.B.H().getUserId()) || this.f4448e.B.X() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.f4448e.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f4448e.f4441e, this.f4448e.B.H().getUserId(), this.f4448e.B.H().getName_show(), this.f4448e.B.X(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.f4448e.B.o1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f4448e.x != null) {
                this.f4448e.x.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f4449e;

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
            this.f4449e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4449e.B == null || this.f4449e.B.H() == null) {
                return;
            }
            d.a.p0.m.a.o(this.f4449e.f4441e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f4449e.B.H().getUserId(), true, true, true);
            if (this.f4449e.y != null) {
                this.f4449e.x.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f4450e;

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
            this.f4450e = cardUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f4450e.x == null) {
                return;
            }
            this.f4450e.x.onClick(view);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardUserInfoLayout f4451e;

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
            this.f4451e = cardUserInfoLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4451e.f4444h.playAnimation();
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
        I = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
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

    public void f() {
        int width;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (k(512)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f4445i.getMeasuredHeight());
                layoutParams.setMargins(l.g(this.f4441e, R.dimen.tbds10), l.g(this.f4441e, R.dimen.tbds_5), 0, 0);
                this.p.setLayoutParams(layoutParams);
            }
            TextPaint paint = this.f4445i.getPaint();
            int i4 = l.p(this.f4441e)[0];
            if (i4 > 0 && (width = (getWidth() - ((i4 * 31) / 108)) - l.g(this.f4441e, R.dimen.tbds107)) > 0) {
                int t = l.t(paint, l(this.B.H().getName_show(), 12)) + this.f4445i.getPaddingLeft() + this.f4445i.getPaddingRight();
                int t2 = l.t(paint, l(this.B.H().getName_show(), 10)) + this.f4445i.getPaddingLeft() + this.f4445i.getPaddingRight();
                int measuredWidth = this.l.getMeasuredWidth();
                int measuredWidth2 = this.f4445i.getMeasuredWidth();
                int measuredWidth3 = this.p.getMeasuredWidth();
                int measuredWidth4 = this.j.getMeasuredWidth();
                int measuredWidth5 = this.k.getMeasuredWidth();
                if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                    String charSequence = this.f4445i.getText().toString();
                    int i5 = measuredWidth + measuredWidth3;
                    int i6 = measuredWidth4 + i5;
                    int i7 = measuredWidth5 + i6;
                    int i8 = t + i7;
                    if (width > i8) {
                        this.f4445i.setText(l(charSequence, 12));
                    } else if (width < i8) {
                        this.f4445i.setText(l(charSequence, 10));
                    }
                    if (width < i7 + t2) {
                        this.k.setVisibility(8);
                    }
                    if (width < i6 + t2) {
                        this.j.setVisibility(8);
                    }
                    if (width > i5 + t2) {
                        this.l.setVisibility(8);
                    }
                    if (width > measuredWidth3 + t2) {
                        this.p.setVisibility(8);
                    }
                }
                int i9 = Integer.MAX_VALUE;
                if (k(2048)) {
                    i2 = (i4 - this.s) - this.t;
                    i3 = this.u;
                } else {
                    b2 b2Var = this.B;
                    if (b2Var != null && b2Var.H() != null && this.B.H().isBaijiahaoUser()) {
                        i9 = (i4 - this.s) - this.v;
                        if (!this.B.H().hadConcerned()) {
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.setVisibility(k(1) ? 0 : 8);
            this.f4445i.setVisibility(k(4) ? 0 : 8);
            this.j.setVisibility(k(16) ? 0 : 8);
            this.p.setVisibility(k(8) ? 0 : 8);
            this.k.setVisibility(k(32) ? 0 : 8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
            if (k(128)) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            this.z.setLayoutParams(layoutParams);
            this.r.setVisibility(k(4096) ? 0 : 8);
        }
    }

    public HeadPendantClickableView getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4443g : (HeadPendantClickableView) invokeV.objValue;
    }

    public RelativeLayout getSuffixContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (RelativeLayout) invokeV.objValue;
    }

    public View getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4445i : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.user_avatar);
            this.f4443g = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f4443g.getHeadView().setIsRound(true);
            this.f4443g.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f4443g.getHeadView().setDefaultResource(17170445);
            this.f4443g.getHeadView().setPlaceHolder(1);
            this.f4443g.setAfterClickListener(new e(this));
            this.f4444h = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
            this.C = (ImageView) findViewById(R.id.img_official_v);
            UserIconBox userIconBox = (UserIconBox) findViewById(R.id.user_tshow_icon);
            this.l = userIconBox;
            userIconBox.setOnClickListener(this.F);
            TextView textView = (TextView) findViewById(R.id.user_name);
            this.f4445i = textView;
            textView.setOnClickListener(this.G);
            this.j = (TextView) findViewById(R.id.identity_view);
            this.p = (TextView) findViewById(R.id.thread_share_intro);
            UserIconBox userIconBox2 = (UserIconBox) findViewById(R.id.thread_user_icon);
            this.k = userIconBox2;
            userIconBox2.setOnClickListener(this.H);
            this.k.setAutoChangedStyle(false);
            this.m = (TextView) findViewById(R.id.thread_extend_info);
            if (DeviceInfoUtil.isMi5X()) {
                this.m.setPadding(0, -I, 0, 0);
            }
            this.n = (ImageView) findViewById(R.id.ala_location_icon);
            this.o = (TextView) findViewById(R.id.ala_location);
            this.z = findViewById(R.id.user_name_and_reply_time);
            this.A = findViewById(R.id.card_home_page_normal_thread_user_info);
            this.q = (RelativeLayout) findViewById(R.id.suffix_container);
            this.r = (ImageView) findViewById(R.id.frs_head_line_mark);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f4441e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(0);
            setGravity(16);
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
            h();
            l.g(this.f4441e, R.dimen.tbds40);
            this.s = l.g(this.f4441e, R.dimen.tbds164);
            this.t = l.g(this.f4441e, R.dimen.tbds156);
            this.u = l.g(this.f4441e, R.dimen.tbds148);
            this.v = l.g(this.f4441e, R.dimen.tbds118);
            this.w = l.g(this.f4441e, R.dimen.tbds580);
        }
    }

    public final boolean j(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, b2Var)) == null) ? (b2Var == null || b2Var.H() == null || !b2Var.X1 || !d.a.p0.b.d.i() || b2Var.H().hadConcerned() || ThreadCardUtils.isSelf(b2Var)) ? false : true : invokeL.booleanValue;
    }

    public final boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (i2 & this.D) > 0 : invokeI.booleanValue;
    }

    public String l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i2)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE) : (String) invokeLI.objValue;
    }

    public final void m() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (b2Var = this.B) == null || b2Var.H() == null) {
            return;
        }
        b2 b2Var2 = this.B;
        if (b2Var2.s1 > 0 && b2Var2.t1 == 0) {
            SkinManager.setViewTextColor(this.f4445i, R.color.CAM_X0106);
            d.a.p0.b.g.b.g(this.f4445i);
        } else if (ListUtils.isEmpty(this.B.H().getTShowInfoNew()) && !this.B.e2()) {
            SkinManager.setViewTextColor(this.f4445i, R.color.CAM_X0106);
            d.a.p0.b.g.b.g(this.f4445i);
        } else {
            SkinManager.setViewTextColor(this.f4445i, R.color.CAM_X0301);
        }
    }

    public final void n(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b2Var) == null) {
            if (!k(32768)) {
                this.f4444h.setVisibility(8);
                if (this.f4444h.isAnimating()) {
                    this.f4444h.cancelAnimation();
                }
                this.f4443g.setIsclearmode(false);
                this.C.setVisibility(8);
                return;
            }
            boolean z = (b2Var == null || b2Var.H() == null || b2Var.H().getAlaUserData() == null || b2Var.H().getAlaUserData().live_status != 1) ? false : true;
            boolean z2 = (b2Var == null || b2Var.h1() == null || b2Var.h1().friendRoomStatus != 2) ? false : true;
            if (!z && !z2) {
                this.f4444h.setVisibility(8);
                this.f4444h.cancelAnimation();
                this.f4443g.setIsclearmode(false);
                this.C.setVisibility(8);
                return;
            }
            this.f4443g.setIsclearmode(true);
            if (b2Var != null && b2Var.H() != null && b2Var.H().isOfficial()) {
                this.C.setVisibility(0);
                SkinManager.setImageResource(this.C, R.drawable.ic_icon_mask_shang22_n);
            }
            this.D &= -257;
            x(b2Var);
            this.f4444h.setSpeed(0.8f);
            this.f4444h.setVisibility(0);
            this.f4444h.loop(true);
            this.f4444h.post(new f(this));
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
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

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i2) == null) || i2 == this.f4442f) {
            return;
        }
        this.f4442f = i2;
        this.f4443g.getHeadView().setPlaceHolder(1);
        TBLottieAnimationView tBLottieAnimationView = this.f4444h;
        if (tBLottieAnimationView != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
        if (this.C.getVisibility() == 0) {
            WebPManager.setMaskDrawable(this.C, R.drawable.ic_icon_mask_shang22_n, null);
        }
    }

    public final void p(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, b2Var) == null) {
            String str = "";
            o("");
            if (b2Var == null) {
                return;
            }
            if ((b2Var.getType() != b2.s3 && b2Var.getType() != b2.v3) || b2Var.h1() == null || b2Var.h1().openRecomLocation == 0) {
                return;
            }
            String s0 = b2Var.s0();
            String y0 = b2Var.y0();
            boolean z = true;
            boolean z2 = UtilHelper.isDecimal(s0) && UtilHelper.isDecimal(y0);
            boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
            if (z2 && isSystemLocationProviderEnabled) {
                AppPosInfo c2 = d.a.q0.w2.g0.a.e().c();
                String str2 = c2.latitude;
                String str3 = c2.longitude;
                if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                    double a2 = l.a(d.a.d.e.m.b.b(str2, 0.0d), d.a.d.e.m.b.b(str3, 0.0d), d.a.d.e.m.b.b(s0, 0.0d), d.a.d.e.m.b.b(y0, 0.0d));
                    if (a2 <= 50.0d) {
                        str = StringHelper.formatDistanceNum(a2);
                    } else {
                        str = b2Var.y();
                    }
                }
            } else if (z2) {
                str = b2Var.y();
            }
            o(str);
        }
    }

    public final void q(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, b2Var) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        if (b2Var.isFromFrs()) {
            this.D |= 4096;
        } else {
            this.D &= -4097;
        }
        if (!b2Var.i2() && !(b2Var instanceof AdvertAppInfo) && ((b2Var.W1 && !b2Var.r2() && !b2Var.e2() && b2Var.getType() != b2.s3 && b2Var.getType() != b2.v3) || (b2Var.W1 && d.a.p0.b.d.o0() && b2Var.getType() != b2.s3 && b2Var.getType() != b2.v3))) {
            this.D &= -129;
        } else {
            this.D |= 128;
        }
        setShowFlag(this.D);
    }

    public final void r(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, b2Var) == null) || this.m == null) {
            return;
        }
        if (b2Var != null && !TextUtils.isEmpty(b2Var.i1())) {
            if (b2Var.H() != null && b2Var.H().isBaijiahaoUser()) {
                this.m.setLines(1);
                this.m.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.m.setMaxLines(Integer.MAX_VALUE);
                this.m.setEllipsize(null);
            }
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            this.m.setText(b2Var.i1());
            this.m.setVisibility(k(128) ? 0 : 8);
            return;
        }
        this.m.setVisibility(8);
    }

    public final void s(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, b2Var) == null) || this.f4443g == null || b2Var == null || this.B.H() == null) {
            return;
        }
        this.f4443g.setBigVDimenSize(R.dimen.tbds32);
        if (UtilHelper.showHeadBjhBigVIcon(this.f4443g, this.B.H(), 0)) {
            return;
        }
        this.f4443g.setIsHomePage(b2Var.W1);
        b2 b2Var2 = this.B;
        if (b2Var2.s1 > 0 && b2Var2.t1 == 0) {
            this.f4443g.g(false);
        } else {
            this.f4443g.i(this.B.H(), 0);
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, b2Var) == null) {
            if (b2Var == null) {
                setVisibility(8);
            } else if (j(b2Var)) {
                setVisibility(4);
            } else {
                this.B = b2Var;
                q(b2Var);
                x(b2Var);
                w(b2Var);
                u(b2Var);
                z(b2Var);
                y(b2Var);
                s(b2Var);
                r(b2Var);
                p(b2Var);
                v(b2Var);
                n(b2Var);
                t(b2Var);
                setVisibility(0);
                if (!k(128) || b2Var.W1 || b2Var.P1()) {
                    return;
                }
                this.z.post(this.E);
            }
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tbPageContext) == null) {
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) || (headPendantClickableView = this.f4443g) == null) {
            return;
        }
        headPendantClickableView.setPageId(bdUniqueId);
    }

    public void setShowFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.D = i2;
            g();
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public final void t(b2 b2Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, b2Var) == null) || !k(4096) || b2Var == null || (imageView = this.r) == null) {
            return;
        }
        if (b2Var.S1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void u(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, b2Var) == null) || this.j == null || b2Var == null || b2Var.H() == null || !k(16)) {
            return;
        }
        MetaData H = b2Var.H();
        if (this.j.getLayoutParams() != null) {
            this.j.getLayoutParams().width = -2;
        }
        this.j.setOnClickListener(null);
        if (H.getIs_bawu() == 1) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.j);
            d2.t(R.color.CAM_X0101);
            d2.e(R.string.A_X04);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            if (b2Var.G1) {
                this.j.setVisibility(0);
                this.j.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(H.getBawu_type())) {
                this.j.setVisibility(0);
                this.j.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(H.getBawu_type())) {
                this.j.setText(R.string.bawu_member_xbazhu_tip);
                this.j.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(H.getBawu_type())) {
                this.j.setText(R.string.bawu_content_assist_tip);
                this.j.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(H.getBawu_type())) {
                this.j.setText(R.string.bawu_manage_assist_tip);
                this.j.setVisibility(0);
                return;
            } else {
                this.j.setVisibility(8);
                return;
            }
        }
        this.j.setVisibility(8);
    }

    public void v(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, b2Var) == null) || this.p == null) {
            return;
        }
        if (b2Var != null && (k(8) || k(512))) {
            if (this.B.getType() == b2.N3) {
                this.p.setVisibility(0);
                this.p.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
                return;
            } else if (k(8)) {
                if (StringUtils.isNull(b2Var.getRecomReason())) {
                    this.p.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.p.setLayoutParams(layoutParams);
                }
                this.p.setText(b2Var.getRecomReason());
                this.p.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.B.W0())) {
                this.p.setVisibility(8);
                return;
            } else {
                this.p.setVisibility(0);
                this.p.setText(this.B.W0());
                return;
            }
        }
        this.p.setVisibility(8);
    }

    public final void w(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, b2Var) == null) || this.l == null || b2Var == null || b2Var.H() == null || !k(1)) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = b2Var.H().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.l.setVisibility(0);
            this.l.h(tShowInfoNew, 2, this.f4441e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f4441e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f4441e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.l.setVisibility(8);
    }

    public final void x(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, b2Var) == null) {
            if (b2Var.H() == null) {
                this.f4443g.setVisibility(8);
                return;
            }
            MetaData H = b2Var.H();
            if (!k(256)) {
                H.setPendantData(null);
            }
            this.f4443g.setData(b2Var);
        }
    }

    public final void y(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, b2Var) == null) || this.k == null) {
            return;
        }
        if (!k(32)) {
            this.k.setVisibility(8);
        } else if (b2Var != null && b2Var.H() != null && (b2Var.s1 <= 0 || b2Var.t1 != 0)) {
            ArrayList<IconData> iconInfo = b2Var.H().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.k.setVisibility(0);
                this.k.h(iconInfo, 4, this.f4441e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f4441e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f4441e.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
    }

    public final void z(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, b2Var) == null) || this.f4445i == null || b2Var == null) {
            return;
        }
        if (!b2Var.W1 && !b2Var.P1()) {
            if (b2Var.H() != null && !StringUtils.isNull(b2Var.H().getName_show())) {
                this.f4445i.setText(StringHelper.cutChineseAndEnglishWithEmoji(b2Var.H().getName_show(), 12, StringHelper.STRING_MORE));
            } else {
                this.f4445i.setText(R.string.user_name_default_txt);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.width = this.w;
            this.z.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.A.getLayoutParams();
            layoutParams2.width = -1;
            this.A.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.f4445i.getLayoutParams();
            layoutParams3.width = -1;
            this.f4445i.setLayoutParams(layoutParams3);
            this.f4445i.setEllipsize(TextUtils.TruncateAt.END);
            if (b2Var.H() != null && !StringUtils.isNull(b2Var.H().getName_show())) {
                this.f4445i.setText(b2Var.H().getName_show());
            } else {
                this.f4445i.setText(R.string.user_name_default_txt);
            }
        }
        d.a.p0.b.g.b.f(this.f4445i);
        m();
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
        this.f4442f = 3;
        this.D = 34053;
        this.E = new a(this);
        this.F = new b(this);
        this.G = new c(this);
        this.H = new d(this);
        i();
    }
}
