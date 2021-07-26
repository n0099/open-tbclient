package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.j;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public View.OnClickListener B;

    /* renamed from: e  reason: collision with root package name */
    public ClickableHeaderImageView f12659e;

    /* renamed from: f  reason: collision with root package name */
    public UserIconBox f12660f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12661g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12662h;

    /* renamed from: i  reason: collision with root package name */
    public UserIconBox f12663i;
    public TextView j;
    public TextView k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public FrameLayout p;
    public boolean q;
    public View r;
    public TextView s;
    public b2 t;
    public Context u;
    public View.OnClickListener v;
    public int w;
    public boolean x;
    public boolean y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadUserInfoLayout f12664e;

        public a(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12664e = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !ViewHelper.checkUpIsLogin(this.f12664e.u) || this.f12664e.t == null || this.f12664e.t.H() == null || this.f12664e.t.H().getTShowInfoNew() == null || ListUtils.getItem(this.f12664e.t.H().getTShowInfoNew(), 0) == null || (url = this.f12664e.t.H().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(this.f12664e.u) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f12664e.u), new String[]{url});
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadUserInfoLayout f12665e;

        public b(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12665e = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12665e.t == null || this.f12665e.t.H() == null || StringUtils.isNull(this.f12665e.t.H().getName_show()) || StringUtils.isNull(this.f12665e.t.H().getUserId()) || this.f12665e.t.X() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(this.f12665e.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f12665e.u, this.f12665e.t.H().getUserId(), this.f12665e.t.H().getName_show(), this.f12665e.t.X(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(this.f12665e.t.o1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f12665e.v != null) {
                this.f12665e.v.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadUserInfoLayout f12666e;

        public c(ThreadUserInfoLayout threadUserInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadUserInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12666e = threadUserInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12666e.t == null || this.f12666e.t.H() == null) {
                return;
            }
            d.a.p0.m.a.o(this.f12666e.u.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + this.f12666e.t.H().getUserId(), true, true, true);
            if (this.f12666e.w == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context) {
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
        this.q = true;
        this.w = 1;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        f(context);
    }

    public final void e(b2 b2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) && this.w == 3) {
            if (b2Var != null && b2Var.H() != null && b2Var.H().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = b2Var.H().getAlaUserData();
                if (this.o != null) {
                    d.a.p0.e.b bVar = new d.a.p0.e.b();
                    bVar.f52498a = alaUserData;
                    bVar.f52499b = 1;
                    this.o.setTag(bVar);
                    if (alaUserData.anchor_live == 0) {
                        this.o.setVisibility(8);
                        return;
                    } else {
                        this.o.setVisibility(0);
                        return;
                    }
                }
                return;
            }
            View view = this.o;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.u = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
            this.f12659e = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
            this.f12660f = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
            this.f12661g = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
            this.f12662h = (TextView) inflate.findViewById(R.id.identity_view);
            this.f12663i = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
            this.j = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
            this.k = (TextView) inflate.findViewById(R.id.thread_info_address);
            this.l = inflate.findViewById(R.id.divider);
            this.r = findViewById(R.id.divider_forum_name);
            this.s = (TextView) findViewById(R.id.thread_info_forum_name);
            this.m = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
            this.n = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
            this.p = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
            View a2 = d.a.p0.e.c.b().a(this.u, 1);
            this.o = a2;
            if (a2 != null) {
                a2.setVisibility(8);
                this.p.addView(this.o);
            }
            setGravity(16);
            g();
            this.f12660f.setOnClickListener(this.z);
            this.f12661g.setOnClickListener(this.A);
            this.f12663i.setOnClickListener(this.B);
        }
    }

    public final void g() {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (clickableHeaderImageView = this.f12659e) == null) {
            return;
        }
        clickableHeaderImageView.setDefaultResource(17170445);
        this.f12659e.setPlaceHolder(1);
        this.f12659e.setIsRound(true);
        this.f12659e.setAfterClickListener(this.v);
    }

    public ClickableHeaderImageView getHeaderImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12659e : (ClickableHeaderImageView) invokeV.objValue;
    }

    public boolean getIsSimpleThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public TextView getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12661g : (TextView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0110);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0110);
            q(this.t);
        }
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public boolean j(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b2Var)) == null) {
            if (b2Var == null) {
                setVisibility(8);
                return false;
            }
            this.t = b2Var;
            if (b2Var.s1 > 0) {
                if (b2Var.t1 == 0 && b2Var.H() != null) {
                    if (!ListUtils.isEmpty(this.t.H().getTShowInfoNew())) {
                        this.t.H().getTShowInfoNew().clear();
                    }
                    this.t.H().setName_show(getContext().getString(R.string.perfect_selection_video));
                }
                this.f12660f.setOnClickListener(null);
                this.f12661g.setOnClickListener(null);
                this.f12663i.setOnClickListener(null);
                this.f12659e.setClickable(false);
            } else {
                this.f12660f.setOnClickListener(this.z);
                this.f12661g.setOnClickListener(this.A);
                this.f12663i.setOnClickListener(this.B);
                this.f12659e.setClickable(true);
            }
            t(b2Var);
            v(b2Var);
            s(b2Var);
            u(b2Var);
            q(b2Var);
            r(b2Var);
            m(b2Var);
            p(b2Var);
            o(b2Var);
            setVisibility(0);
            n(b2Var);
            e(b2Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void k() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (b2Var = this.t) == null || b2Var.H() == null) {
            return;
        }
        b2 b2Var2 = this.t;
        if (b2Var2.s1 > 0 && b2Var2.t1 == 0) {
            SkinManager.setViewTextColor(this.f12661g, R.color.CAM_X0106);
        } else if (ListUtils.isEmpty(this.t.H().getTShowInfoNew()) && !this.t.H().isBigV()) {
            SkinManager.setViewTextColor(this.f12661g, R.color.CAM_X0106);
        } else {
            SkinManager.setViewTextColor(this.f12661g, R.color.CAM_X0301);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                o(this.t);
                return;
            }
            this.s.setVisibility(8);
            this.r.setVisibility(8);
        }
    }

    public final void m(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, b2Var) == null) {
            if (b2Var != null && !StringUtils.isNull(b2Var.y())) {
                this.k.setText(this.t.y());
                this.k.setVisibility(0);
                this.l.setVisibility(0);
                return;
            }
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public final void n(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, b2Var) == null) || this.n == null || b2Var == null || b2Var.H() == null) {
            return;
        }
        if (b2Var.H().hadConcerned()) {
            this.n.setVisibility(0);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.n, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            return;
        }
        this.n.setVisibility(8);
    }

    public void o(b2 b2Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, b2Var) == null) {
            if (b2Var == null) {
                this.s.setVisibility(8);
                this.r.setVisibility(8);
                return;
            }
            this.t.X();
            int i2 = this.w;
            String str2 = (i2 == 3 || i2 == 4) ? null : null;
            if (b2Var.q2()) {
                str2 = b2Var.F1.ori_fname;
            }
            if (StringUtils.isNull(str2)) {
                this.s.setVisibility(8);
                this.r.setVisibility(8);
                return;
            }
            b2 b2Var2 = this.t;
            if (b2Var2.s1 > 0 && b2Var2.t1 == 0) {
                str = getContext().getString(R.string.select_video_list);
            } else {
                str = StringHelper.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
            }
            this.s.setText(str);
            this.s.setVisibility(0);
            this.r.setVisibility(0);
        }
    }

    public final void p(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, b2Var) == null) || this.f12659e == null || b2Var == null || this.t.H() == null) {
            return;
        }
        b2 b2Var2 = this.t;
        if (b2Var2.s1 > 0 && b2Var2.t1 == 0) {
            this.f12659e.setShowV(false);
        } else {
            this.f12659e.setShowV(this.t.H().isBigV());
        }
    }

    public final void q(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, b2Var) == null) || this.f12662h == null || b2Var == null || b2Var.H() == null) {
            return;
        }
        MetaData H = b2Var.H();
        if (H.getIs_bawu() == 1) {
            int i2 = b2Var.G1 ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
            int i3 = b2Var.G1 ? R.color.CAM_X0101 : R.color.CAM_X0107;
            SkinManager.setBackgroundResource(this.f12662h, i2);
            SkinManager.setViewTextColor(this.f12662h, i3);
            if (b2Var.G1) {
                this.f12662h.setVisibility(0);
                this.f12662h.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(H.getBawu_type())) {
                this.f12662h.setVisibility(0);
                this.f12662h.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(H.getBawu_type())) {
                this.f12662h.setText(R.string.bawu_member_xbazhu_tip);
                this.f12662h.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(H.getBawu_type())) {
                this.f12662h.setText(R.string.bawu_content_assist_tip);
                this.f12662h.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(H.getBawu_type())) {
                this.f12662h.setText(R.string.bawu_manage_assist_tip);
                this.f12662h.setVisibility(0);
                return;
            } else {
                this.f12662h.setVisibility(8);
                return;
            }
        }
        this.f12662h.setVisibility(8);
    }

    public final void r(b2 b2Var) {
        String formatTime;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, b2Var) == null) || this.j == null || b2Var == null) {
            return;
        }
        if (b2Var.r0() <= 0) {
            this.j.setVisibility(4);
            return;
        }
        this.j.setVisibility(0);
        if (this.w == 2) {
            formatTime = StringHelper.getPostTimeInterval(b2Var.r0());
        } else if (b2Var.Z1()) {
            formatTime = StringHelper.getFormatTime(b2Var.N());
        } else {
            formatTime = StringHelper.getFormatTime(b2Var.r0() * 1000);
        }
        this.j.setText(formatTime);
    }

    public void s(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, b2Var) == null) {
            if (this.m != null && b2Var != null) {
                if (this.y) {
                    if (StringUtils.isNull(b2Var.getRecomReason())) {
                        this.m.setVisibility(8);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                    if (layoutParams != null && layoutParams.bottomMargin != 0) {
                        layoutParams.bottomMargin = 0;
                        this.m.setLayoutParams(layoutParams);
                    }
                    this.m.setText(b2Var.getRecomReason());
                    this.m.setVisibility(0);
                    return;
                }
                if (this.t.h1() != null && this.t.h1().share_info != null && this.t.h1().share_info.share_user_count > 0 && this.t.h2()) {
                    b2 b2Var2 = this.t;
                    if (b2Var2.s1 <= 0 || b2Var2.t1 != 0) {
                        this.m.setVisibility(0);
                        int i2 = this.t.h1().share_info.share_user_count;
                        if (i2 == 1) {
                            this.m.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
                            return;
                        } else {
                            this.m.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i2)}));
                            return;
                        }
                    }
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void setFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setIsFromConcern(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.y = z;
        }
    }

    public void setIsSimpleThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.x = z;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        ClickableHeaderImageView clickableHeaderImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bdUniqueId) == null) || (clickableHeaderImageView = this.f12659e) == null) {
            return;
        }
        clickableHeaderImageView.setPageId(bdUniqueId);
    }

    public void setTShowVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.q = z;
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.v = onClickListener;
            ClickableHeaderImageView clickableHeaderImageView = this.f12659e;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setAfterClickListener(onClickListener);
            }
        }
    }

    public final void t(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, b2Var) == null) || this.f12660f == null || b2Var == null || b2Var.H() == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = b2Var.H().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.f12660f.setVisibility(0);
            this.f12660f.h(tShowInfoNew, 2, this.u.getResources().getDimensionPixelSize(R.dimen.tbds48), this.u.getResources().getDimensionPixelSize(R.dimen.tbds48), this.u.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.f12660f.setVisibility(8);
    }

    public final void u(b2 b2Var) {
        UserIconBox userIconBox;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, b2Var) == null) || (userIconBox = this.f12663i) == null) {
            return;
        }
        if (this.y) {
            userIconBox.setVisibility(8);
        } else if (b2Var != null && b2Var.H() != null && ((b2Var.s1 <= 0 || b2Var.t1 != 0) && this.q)) {
            ArrayList<IconData> iconInfo = b2Var.H().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.f12663i.setVisibility(0);
                this.f12663i.h(iconInfo, 4, this.u.getResources().getDimensionPixelSize(R.dimen.tbds40), this.u.getResources().getDimensionPixelSize(R.dimen.tbds40), this.u.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.f12663i.setVisibility(8);
        } else {
            this.f12663i.setVisibility(8);
        }
    }

    public final void v(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, b2Var) == null) || this.f12661g == null || b2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.t.H().getName_show())) {
            this.f12661g.setText(i(this.t.H().getName_show()));
        }
        k();
        int i2 = this.w;
        if (i2 == 3 || i2 == 4) {
            String name_show = this.t.H().getName_show();
            String userName = this.t.H().getUserName();
            if (!NickNameActivitySwitch.isOn() || name_show == null || name_show.equals(userName)) {
                return;
            }
            this.f12661g.setText(d.a.q0.h2.c.b(this.u, this.f12661g.getText().toString()));
            this.f12661g.setGravity(16);
            this.f12661g.setTag(R.id.tag_nick_name_activity, d.a.q0.h2.c.a());
            SkinManager.setViewTextColor(this.f12661g, R.color.CAM_X0312, 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
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
        this.q = true;
        this.w = 1;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = true;
        this.w = 1;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this);
        f(context);
    }
}
