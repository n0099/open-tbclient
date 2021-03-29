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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
import d.b.b.a.j;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ThreadUserInfoLayout extends LinearLayout {
    public View.OnClickListener A;
    public View.OnClickListener B;

    /* renamed from: e  reason: collision with root package name */
    public ClickableHeaderImageView f13540e;

    /* renamed from: f  reason: collision with root package name */
    public UserIconBox f13541f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13542g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13543h;
    public UserIconBox i;
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
    public a2 t;
    public Context u;
    public View.OnClickListener v;
    public int w;
    public boolean x;
    public boolean y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            if (!ViewHelper.checkUpIsLogin(ThreadUserInfoLayout.this.u) || ThreadUserInfoLayout.this.t == null || ThreadUserInfoLayout.this.t.T() == null || ThreadUserInfoLayout.this.t.T().getTShowInfoNew() == null || ListUtils.getItem(ThreadUserInfoLayout.this.t.T().getTShowInfoNew(), 0) == null || (url = ThreadUserInfoLayout.this.t.T().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(ThreadUserInfoLayout.this.u) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(ThreadUserInfoLayout.this.u), new String[]{url});
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadUserInfoLayout.this.t == null || ThreadUserInfoLayout.this.t.T() == null || StringUtils.isNull(ThreadUserInfoLayout.this.t.T().getName_show()) || StringUtils.isNull(ThreadUserInfoLayout.this.t.T().getUserId()) || ThreadUserInfoLayout.this.t.i0() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(ThreadUserInfoLayout.this.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadUserInfoLayout.this.u, ThreadUserInfoLayout.this.t.T().getUserId(), ThreadUserInfoLayout.this.t.T().getName_show(), ThreadUserInfoLayout.this.t.i0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(ThreadUserInfoLayout.this.t.w1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (ThreadUserInfoLayout.this.v != null) {
                ThreadUserInfoLayout.this.v.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadUserInfoLayout.this.t == null || ThreadUserInfoLayout.this.t.T() == null) {
                return;
            }
            d.b.h0.l.a.o(ThreadUserInfoLayout.this.u.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ThreadUserInfoLayout.this.t.T().getUserId(), true, true, true);
            if (ThreadUserInfoLayout.this.w == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    public ThreadUserInfoLayout(Context context) {
        super(context);
        this.q = true;
        this.w = 1;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        f(context);
    }

    public final void e(a2 a2Var) {
        if (this.w != 3) {
            return;
        }
        if (a2Var != null && a2Var.T() != null && a2Var.T().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = a2Var.T().getAlaUserData();
            if (this.o != null) {
                d.b.h0.d.a aVar = new d.b.h0.d.a();
                aVar.f50086a = alaUserData;
                aVar.f50087b = 1;
                this.o.setTag(aVar);
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

    public final void f(Context context) {
        this.u = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_user_info_layout, (ViewGroup) this, true);
        this.f13540e = (ClickableHeaderImageView) inflate.findViewById(R.id.card_home_page_normal_thread_user_header);
        this.f13541f = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_tshow_icon);
        this.f13542g = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_user_name);
        this.f13543h = (TextView) inflate.findViewById(R.id.identity_view);
        this.i = (UserIconBox) inflate.findViewById(R.id.card_home_page_normal_thread_user_icon);
        this.j = (TextView) inflate.findViewById(R.id.thread_info_reply_time);
        this.k = (TextView) inflate.findViewById(R.id.thread_info_address);
        this.l = inflate.findViewById(R.id.divider);
        this.r = findViewById(R.id.divider_forum_name);
        this.s = (TextView) findViewById(R.id.thread_info_forum_name);
        this.m = (TextView) inflate.findViewById(R.id.card_home_page_normal_thread_share_intro);
        this.n = (TextView) inflate.findViewById(R.id.thread_user_info_has_concern_lable);
        this.p = (FrameLayout) inflate.findViewById(R.id.ala_live_info_content_layout);
        View a2 = d.b.h0.d.b.b().a(this.u, 1);
        this.o = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.p.addView(this.o);
        }
        setGravity(16);
        g();
        this.f13541f.setOnClickListener(this.z);
        this.f13542g.setOnClickListener(this.A);
        this.i.setOnClickListener(this.B);
    }

    public final void g() {
        ClickableHeaderImageView clickableHeaderImageView = this.f13540e;
        if (clickableHeaderImageView == null) {
            return;
        }
        clickableHeaderImageView.setDefaultResource(17170445);
        this.f13540e.setPlaceHolder(1);
        this.f13540e.setIsRound(true);
        this.f13540e.setAfterClickListener(this.v);
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.f13540e;
    }

    public boolean getIsSimpleThread() {
        return this.x;
    }

    public TextView getUserName() {
        return this.f13542g;
    }

    public void h() {
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

    public String i(String str) {
        return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public boolean j(a2 a2Var) {
        if (a2Var == null) {
            setVisibility(8);
            return false;
        }
        this.t = a2Var;
        if (a2Var.p1 > 0) {
            if (a2Var.q1 == 0 && a2Var.T() != null) {
                if (!ListUtils.isEmpty(this.t.T().getTShowInfoNew())) {
                    this.t.T().getTShowInfoNew().clear();
                }
                this.t.T().setName_show(getContext().getString(R.string.perfect_selection_video));
            }
            this.f13541f.setOnClickListener(null);
            this.f13542g.setOnClickListener(null);
            this.i.setOnClickListener(null);
            this.f13540e.setClickable(false);
        } else {
            this.f13541f.setOnClickListener(this.z);
            this.f13542g.setOnClickListener(this.A);
            this.i.setOnClickListener(this.B);
            this.f13540e.setClickable(true);
        }
        t(a2Var);
        v(a2Var);
        s(a2Var);
        u(a2Var);
        q(a2Var);
        r(a2Var);
        m(a2Var);
        p(a2Var);
        o(a2Var);
        setVisibility(0);
        n(a2Var);
        e(a2Var);
        return true;
    }

    public final void k() {
        a2 a2Var = this.t;
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        a2 a2Var2 = this.t;
        if (a2Var2.p1 > 0 && a2Var2.q1 == 0) {
            SkinManager.setViewTextColor(this.f13542g, R.color.CAM_X0106);
        } else if (ListUtils.isEmpty(this.t.T().getTShowInfoNew()) && !this.t.T().isBigV()) {
            SkinManager.setViewTextColor(this.f13542g, R.color.CAM_X0106);
        } else {
            SkinManager.setViewTextColor(this.f13542g, R.color.CAM_X0301);
        }
    }

    public void l(boolean z) {
        if (z) {
            o(this.t);
            return;
        }
        this.s.setVisibility(8);
        this.r.setVisibility(8);
    }

    public final void m(a2 a2Var) {
        if (a2Var != null && !StringUtils.isNull(a2Var.K())) {
            this.k.setText(this.t.K());
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.k.setVisibility(8);
        this.l.setVisibility(8);
    }

    public final void n(a2 a2Var) {
        if (this.n == null || a2Var == null || a2Var.T() == null) {
            return;
        }
        if (a2Var.T().hadConcerned()) {
            this.n.setVisibility(0);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.n, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
            return;
        }
        this.n.setVisibility(8);
    }

    public void o(a2 a2Var) {
        String str;
        if (a2Var == null) {
            this.s.setVisibility(8);
            this.r.setVisibility(8);
            return;
        }
        this.t.i0();
        int i = this.w;
        String str2 = (i == 3 || i == 4) ? null : null;
        if (a2Var.w2()) {
            str2 = a2Var.C1.ori_fname;
        }
        if (StringUtils.isNull(str2)) {
            this.s.setVisibility(8);
            this.r.setVisibility(8);
            return;
        }
        a2 a2Var2 = this.t;
        if (a2Var2.p1 > 0 && a2Var2.q1 == 0) {
            str = getContext().getString(R.string.select_video_list);
        } else {
            str = StringHelper.cutChineseAndEnglishWithSuffix(str2, 12, StringHelper.STRING_MORE) + getResources().getString(R.string.forum);
        }
        this.s.setText(str);
        this.s.setVisibility(0);
        this.r.setVisibility(0);
    }

    public final void p(a2 a2Var) {
        if (this.f13540e == null || a2Var == null || this.t.T() == null) {
            return;
        }
        a2 a2Var2 = this.t;
        if (a2Var2.p1 > 0 && a2Var2.q1 == 0) {
            this.f13540e.setShowV(false);
        } else {
            this.f13540e.setShowV(this.t.T().isBigV());
        }
    }

    public final void q(a2 a2Var) {
        if (this.f13543h == null || a2Var == null || a2Var.T() == null) {
            return;
        }
        MetaData T = a2Var.T();
        if (T.getIs_bawu() == 1) {
            int i = a2Var.D1 ? R.drawable.brand_official_btn : R.drawable.user_identity_btn;
            int i2 = a2Var.D1 ? R.color.CAM_X0101 : R.color.CAM_X0107;
            SkinManager.setBackgroundResource(this.f13543h, i);
            SkinManager.setViewTextColor(this.f13543h, i2);
            if (a2Var.D1) {
                this.f13543h.setVisibility(0);
                this.f13543h.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(T.getBawu_type())) {
                this.f13543h.setVisibility(0);
                this.f13543h.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(T.getBawu_type())) {
                this.f13543h.setText(R.string.bawu_member_xbazhu_tip);
                this.f13543h.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(T.getBawu_type())) {
                this.f13543h.setText(R.string.bawu_content_assist_tip);
                this.f13543h.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(T.getBawu_type())) {
                this.f13543h.setText(R.string.bawu_manage_assist_tip);
                this.f13543h.setVisibility(0);
                return;
            } else {
                this.f13543h.setVisibility(8);
                return;
            }
        }
        this.f13543h.setVisibility(8);
    }

    public final void r(a2 a2Var) {
        String formatTime;
        if (this.j == null || a2Var == null) {
            return;
        }
        if (a2Var.B0() <= 0) {
            this.j.setVisibility(4);
            return;
        }
        this.j.setVisibility(0);
        if (this.w == 2) {
            formatTime = StringHelper.getPostTimeInterval(a2Var.B0());
        } else if (a2Var.h2()) {
            formatTime = StringHelper.getFormatTime(a2Var.Z());
        } else {
            formatTime = StringHelper.getFormatTime(a2Var.B0() * 1000);
        }
        this.j.setText(formatTime);
    }

    public void s(a2 a2Var) {
        if (this.m != null && a2Var != null) {
            if (this.y) {
                if (StringUtils.isNull(a2Var.V0())) {
                    this.m.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.m.setLayoutParams(layoutParams);
                }
                this.m.setText(a2Var.V0());
                this.m.setVisibility(0);
                return;
            }
            if (this.t.q1() != null && this.t.q1().share_info != null && this.t.q1().share_info.share_user_count > 0 && this.t.p2()) {
                a2 a2Var2 = this.t;
                if (a2Var2.p1 <= 0 || a2Var2.q1 != 0) {
                    this.m.setVisibility(0);
                    int i = this.t.q1().share_info.share_user_count;
                    if (i == 1) {
                        this.m.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label_simple));
                        return;
                    } else {
                        this.m.setText(TbadkCoreApplication.getInst().getString(R.string.ala_live_share_live_label, new Object[]{StringHelper.numberUniform(i)}));
                        return;
                    }
                }
            }
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(8);
    }

    public void setFrom(int i) {
        this.w = i;
    }

    public void setIsFromConcern(boolean z) {
        this.y = z;
    }

    public void setIsSimpleThread(boolean z) {
        this.x = z;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        ClickableHeaderImageView clickableHeaderImageView = this.f13540e;
        if (clickableHeaderImageView != null) {
            clickableHeaderImageView.setPageId(bdUniqueId);
        }
    }

    public void setTShowVisible(boolean z) {
        this.q = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
        ClickableHeaderImageView clickableHeaderImageView = this.f13540e;
        if (clickableHeaderImageView != null) {
            clickableHeaderImageView.setAfterClickListener(onClickListener);
        }
    }

    public final void t(a2 a2Var) {
        if (this.f13541f == null || a2Var == null || a2Var.T() == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = a2Var.T().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.f13541f.setVisibility(0);
            this.f13541f.h(tShowInfoNew, 2, this.u.getResources().getDimensionPixelSize(R.dimen.tbds48), this.u.getResources().getDimensionPixelSize(R.dimen.tbds48), this.u.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.f13541f.setVisibility(8);
    }

    public final void u(a2 a2Var) {
        UserIconBox userIconBox = this.i;
        if (userIconBox == null) {
            return;
        }
        if (this.y) {
            userIconBox.setVisibility(8);
        } else if (a2Var != null && a2Var.T() != null && ((a2Var.p1 <= 0 || a2Var.q1 != 0) && this.q)) {
            ArrayList<IconData> iconInfo = a2Var.T().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.i.setVisibility(0);
                this.i.h(iconInfo, 4, this.u.getResources().getDimensionPixelSize(R.dimen.tbds40), this.u.getResources().getDimensionPixelSize(R.dimen.tbds40), this.u.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                return;
            }
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(8);
        }
    }

    public final void v(a2 a2Var) {
        if (this.f13542g == null || a2Var == null) {
            return;
        }
        if (!StringUtils.isNull(this.t.T().getName_show())) {
            this.f13542g.setText(i(this.t.T().getName_show()));
        }
        k();
        int i = this.w;
        if (i == 3 || i == 4) {
            String name_show = this.t.T().getName_show();
            String userName = this.t.T().getUserName();
            if (!NickNameActivitySwitch.isOn() || name_show == null || name_show.equals(userName)) {
                return;
            }
            this.f13542g.setText(d.b.i0.c2.c.b(this.u, this.f13542g.getText().toString()));
            this.f13542g.setGravity(16);
            this.f13542g.setTag(R.id.tag_nick_name_activity, d.b.i0.c2.c.a());
            SkinManager.setViewTextColor(this.f13542g, R.color.CAM_X0312, 1);
        }
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = true;
        this.w = 1;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        f(context);
    }

    public ThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = true;
        this.w = 1;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        f(context);
    }
}
