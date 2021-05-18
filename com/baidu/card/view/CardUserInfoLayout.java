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
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.i.q;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import tbclient.AppPosInfo;
/* loaded from: classes.dex */
public class CardUserInfoLayout extends LinearLayout implements q {
    public static final int I = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds2);
    public View A;
    public a2 B;
    public ImageView C;
    public int D;
    public Runnable E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public View.OnClickListener H;

    /* renamed from: e  reason: collision with root package name */
    public Context f4358e;

    /* renamed from: f  reason: collision with root package name */
    public int f4359f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantClickableView f4360g;

    /* renamed from: h  reason: collision with root package name */
    public TBLottieAnimationView f4361h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4362i;
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
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CardUserInfoLayout.this.f();
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            if (!ViewHelper.checkUpIsLogin(CardUserInfoLayout.this.f4358e) || CardUserInfoLayout.this.B == null || CardUserInfoLayout.this.B.T() == null || CardUserInfoLayout.this.B.T().getTShowInfoNew() == null || ListUtils.getItem(CardUserInfoLayout.this.B.T().getTShowInfoNew(), 0) == null || (url = CardUserInfoLayout.this.B.T().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(CardUserInfoLayout.this.f4358e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(CardUserInfoLayout.this.f4358e), new String[]{url});
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CardUserInfoLayout.this.B == null || CardUserInfoLayout.this.B.T() == null || StringUtils.isNull(CardUserInfoLayout.this.B.T().getName_show()) || StringUtils.isNull(CardUserInfoLayout.this.B.T().getUserId()) || CardUserInfoLayout.this.B.i0() == null) {
                return;
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str) && ViewHelper.checkUpIsLogin(CardUserInfoLayout.this.getContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                    return;
                }
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(CardUserInfoLayout.this.f4358e, CardUserInfoLayout.this.B.T().getUserId(), CardUserInfoLayout.this.B.T().getName_show(), CardUserInfoLayout.this.B.i0(), AddFriendActivityConfig.TYPE_FRS_HEAD);
            personInfoActivityConfig.setSourceTid(CardUserInfoLayout.this.B.x1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (CardUserInfoLayout.this.x != null) {
                CardUserInfoLayout.this.x.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CardUserInfoLayout.this.B == null || CardUserInfoLayout.this.B.T() == null) {
                return;
            }
            d.a.j0.l.a.o(CardUserInfoLayout.this.f4358e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + CardUserInfoLayout.this.B.T().getUserId(), true, true, true);
            if (CardUserInfoLayout.this.y != null) {
                CardUserInfoLayout.this.x.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CardUserInfoLayout.this.x != null) {
                CardUserInfoLayout.this.x.onClick(view);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CardUserInfoLayout.this.f4361h.playAnimation();
        }
    }

    public CardUserInfoLayout(Context context) {
        this(context, null);
    }

    public void f() {
        int width;
        int i2;
        int i3;
        if (k(512)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f4362i.getMeasuredHeight());
            layoutParams.setMargins(l.g(this.f4358e, R.dimen.tbds10), l.g(this.f4358e, R.dimen.tbds_5), 0, 0);
            this.p.setLayoutParams(layoutParams);
        }
        TextPaint paint = this.f4362i.getPaint();
        int i4 = l.p(this.f4358e)[0];
        if (i4 > 0 && (width = (getWidth() - ((i4 * 31) / 108)) - l.g(this.f4358e, R.dimen.tbds107)) > 0) {
            int t = l.t(paint, l(this.B.T().getName_show(), 12)) + this.f4362i.getPaddingLeft() + this.f4362i.getPaddingRight();
            int t2 = l.t(paint, l(this.B.T().getName_show(), 10)) + this.f4362i.getPaddingLeft() + this.f4362i.getPaddingRight();
            int measuredWidth = this.l.getMeasuredWidth();
            int measuredWidth2 = this.f4362i.getMeasuredWidth();
            int measuredWidth3 = this.p.getMeasuredWidth();
            int measuredWidth4 = this.j.getMeasuredWidth();
            int measuredWidth5 = this.k.getMeasuredWidth();
            if (width < measuredWidth2 + measuredWidth + measuredWidth3 + measuredWidth4 + measuredWidth5) {
                String charSequence = this.f4362i.getText().toString();
                int i5 = measuredWidth + measuredWidth3;
                int i6 = measuredWidth4 + i5;
                int i7 = measuredWidth5 + i6;
                int i8 = t + i7;
                if (width > i8) {
                    this.f4362i.setText(l(charSequence, 12));
                } else if (width < i8) {
                    this.f4362i.setText(l(charSequence, 10));
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
                a2 a2Var = this.B;
                if (a2Var != null && a2Var.T() != null && this.B.T().isBaijiahaoUser()) {
                    i9 = (i4 - this.s) - this.v;
                    if (!this.B.T().hadConcerned()) {
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

    public final void g() {
        this.l.setVisibility(k(1) ? 0 : 8);
        this.f4362i.setVisibility(k(4) ? 0 : 8);
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

    public HeadPendantClickableView getAvatar() {
        return this.f4360g;
    }

    public RelativeLayout getSuffixContainer() {
        return this.q;
    }

    public View getUserName() {
        return this.f4362i;
    }

    public final void h() {
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) findViewById(R.id.user_avatar);
        this.f4360g = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.f4360g.getHeadView().setIsRound(true);
        this.f4360g.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f4360g.getHeadView().setDefaultResource(17170445);
        this.f4360g.getHeadView().setPlaceHolder(1);
        this.f4360g.setAfterClickListener(new e());
        this.f4361h = (TBLottieAnimationView) findViewById(R.id.user_living_lottie);
        this.C = (ImageView) findViewById(R.id.img_official_v);
        UserIconBox userIconBox = (UserIconBox) findViewById(R.id.user_tshow_icon);
        this.l = userIconBox;
        userIconBox.setOnClickListener(this.F);
        TextView textView = (TextView) findViewById(R.id.user_name);
        this.f4362i = textView;
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

    public final void i() {
        this.f4358e = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(0);
        setGravity(16);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.user_info_layout, (ViewGroup) this, true);
        h();
        l.g(this.f4358e, R.dimen.tbds40);
        this.s = l.g(this.f4358e, R.dimen.tbds164);
        this.t = l.g(this.f4358e, R.dimen.tbds156);
        this.u = l.g(this.f4358e, R.dimen.tbds148);
        this.v = l.g(this.f4358e, R.dimen.tbds118);
        this.w = l.g(this.f4358e, R.dimen.tbds580);
    }

    public final boolean j(a2 a2Var) {
        return (a2Var == null || a2Var.T() == null || !a2Var.U1 || !d.a.j0.b.d.h() || a2Var.T().hadConcerned() || ThreadCardUtils.isSelf(a2Var)) ? false : true;
    }

    public final boolean k(int i2) {
        return (i2 & this.D) > 0;
    }

    public String l(String str, int i2) {
        return StringHelper.cutChineseAndEnglishWithSuffix(str, i2, StringHelper.STRING_MORE);
    }

    public final void m() {
        a2 a2Var = this.B;
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        a2 a2Var2 = this.B;
        if (a2Var2.p1 > 0 && a2Var2.q1 == 0) {
            SkinManager.setViewTextColor(this.f4362i, R.color.CAM_X0106);
            d.a.j0.b.g.b.e(this.f4362i);
        } else if (ListUtils.isEmpty(this.B.T().getTShowInfoNew()) && !this.B.o2()) {
            SkinManager.setViewTextColor(this.f4362i, R.color.CAM_X0106);
            d.a.j0.b.g.b.e(this.f4362i);
        } else {
            SkinManager.setViewTextColor(this.f4362i, R.color.CAM_X0301);
        }
    }

    public final void n(a2 a2Var) {
        if (!k(32768)) {
            this.f4361h.setVisibility(8);
            if (this.f4361h.isAnimating()) {
                this.f4361h.cancelAnimation();
            }
            this.f4360g.setIsclearmode(false);
            this.C.setVisibility(8);
            return;
        }
        boolean z = (a2Var == null || a2Var.T() == null || a2Var.T().getAlaUserData() == null || a2Var.T().getAlaUserData().live_status != 1) ? false : true;
        boolean z2 = (a2Var == null || a2Var.q1() == null || a2Var.q1().friendRoomStatus != 2) ? false : true;
        if (!z && !z2) {
            this.f4361h.setVisibility(8);
            this.f4361h.cancelAnimation();
            this.f4360g.setIsclearmode(false);
            this.C.setVisibility(8);
            return;
        }
        this.f4360g.setIsclearmode(true);
        if (a2Var != null && a2Var.T() != null && a2Var.T().isOfficial()) {
            this.C.setVisibility(0);
            SkinManager.setImageResource(this.C, R.drawable.ic_icon_mask_shang22_n);
        }
        this.D &= -257;
        x(a2Var);
        this.f4361h.setSpeed(0.8f);
        this.f4361h.setVisibility(0);
        this.f4361h.loop(true);
        this.f4361h.post(new f());
    }

    public final void o(String str) {
        boolean z = !StringUtils.isNull(str);
        this.n.setVisibility(z ? 0 : 8);
        this.o.setVisibility(z ? 0 : 8);
        if (z) {
            this.o.setText(str);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.n, R.drawable.icon_pure_post_location_n_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        }
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (i2 != this.f4359f) {
            this.f4359f = i2;
            this.f4360g.getHeadView().setPlaceHolder(1);
            TBLottieAnimationView tBLottieAnimationView = this.f4361h;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            if (this.C.getVisibility() == 0) {
                WebPManager.setMaskDrawable(this.C, R.drawable.ic_icon_mask_shang22_n, null);
            }
        }
    }

    public final void p(a2 a2Var) {
        String str = "";
        o("");
        if (a2Var == null) {
            return;
        }
        if ((a2Var.getType() != a2.g3 && a2Var.getType() != a2.j3) || a2Var.q1() == null || a2Var.q1().openRecomLocation == 0) {
            return;
        }
        String C0 = a2Var.C0();
        String I0 = a2Var.I0();
        boolean z = true;
        boolean z2 = UtilHelper.isDecimal(C0) && UtilHelper.isDecimal(I0);
        boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
        if (z2 && isSystemLocationProviderEnabled) {
            AppPosInfo c2 = d.a.k0.s2.g0.a.e().c();
            String str2 = c2.latitude;
            String str3 = c2.longitude;
            if ((UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3)) ? false : false) {
                double a2 = l.a(d.a.c.e.m.b.b(str2, 0.0d), d.a.c.e.m.b.b(str3, 0.0d), d.a.c.e.m.b.b(C0, 0.0d), d.a.c.e.m.b.b(I0, 0.0d));
                if (a2 <= 50.0d) {
                    str = StringHelper.formatDistanceNum(a2);
                } else {
                    str = a2Var.K();
                }
            }
        } else if (z2) {
            str = a2Var.K();
        }
        o(str);
    }

    public final void q(a2 a2Var) {
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        if (a2Var.p()) {
            this.D |= 4096;
        } else {
            this.D &= -4097;
        }
        if (!a2Var.s2() && !(a2Var instanceof AdvertAppInfo) && ((a2Var.T1 && !a2Var.A2() && !a2Var.o2() && a2Var.getType() != a2.g3 && a2Var.getType() != a2.j3) || (a2Var.T1 && d.a.j0.b.d.U() && a2Var.getType() != a2.g3 && a2Var.getType() != a2.j3))) {
            this.D &= -129;
        } else {
            this.D |= 128;
        }
        setShowFlag(this.D);
    }

    public final void r(a2 a2Var) {
        if (this.m == null) {
            return;
        }
        if (a2Var != null && !TextUtils.isEmpty(a2Var.r1())) {
            if (a2Var.T() != null && a2Var.T().isBaijiahaoUser()) {
                this.m.setLines(1);
                this.m.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.m.setMaxLines(Integer.MAX_VALUE);
                this.m.setEllipsize(null);
            }
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
            this.m.setText(a2Var.r1());
            this.m.setVisibility(k(128) ? 0 : 8);
            return;
        }
        this.m.setVisibility(8);
    }

    public final void s(a2 a2Var) {
        if (this.f4360g == null || a2Var == null || this.B.T() == null) {
            return;
        }
        this.f4360g.setBigVDimenSize(R.dimen.tbds32);
        if (UtilHelper.showHeadBjhBigVIcon(this.f4360g, this.B.T(), 0)) {
            return;
        }
        this.f4360g.setIsHomePage(a2Var.T1);
        a2 a2Var2 = this.B;
        if (a2Var2.p1 > 0 && a2Var2.q1 == 0) {
            this.f4360g.g(false);
        } else {
            this.f4360g.i(this.B.T(), 0);
        }
    }

    public void setData(a2 a2Var) {
        if (a2Var == null) {
            setVisibility(8);
        } else if (j(a2Var)) {
            setVisibility(4);
        } else {
            this.B = a2Var;
            q(a2Var);
            x(a2Var);
            w(a2Var);
            u(a2Var);
            z(a2Var);
            y(a2Var);
            s(a2Var);
            r(a2Var);
            p(a2Var);
            v(a2Var);
            n(a2Var);
            t(a2Var);
            setVisibility(0);
            if (!k(128) || a2Var.T1 || a2Var.Z1()) {
                return;
            }
            this.z.post(this.E);
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        HeadPendantClickableView headPendantClickableView = this.f4360g;
        if (headPendantClickableView != null) {
            headPendantClickableView.setPageId(bdUniqueId);
        }
    }

    public void setShowFlag(int i2) {
        this.D = i2;
        g();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void setUserIconAfterClickListener(View.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public final void t(a2 a2Var) {
        ImageView imageView;
        if (!k(4096) || a2Var == null || (imageView = this.r) == null) {
            return;
        }
        if (a2Var.P1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void u(a2 a2Var) {
        if (this.j == null || a2Var == null || a2Var.T() == null || !k(16)) {
            return;
        }
        MetaData T = a2Var.T();
        if (this.j.getLayoutParams() != null) {
            this.j.getLayoutParams().width = -2;
        }
        this.j.setOnClickListener(null);
        if (T.getIs_bawu() == 1) {
            d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.j);
            d2.q(R.color.CAM_X0101);
            d2.e(R.string.A_X04);
            d2.k(R.string.J_X04);
            d2.f(R.color.CAM_X0302);
            if (a2Var.D1) {
                this.j.setVisibility(0);
                this.j.setText(R.string.brand_official);
                return;
            } else if ("manager".equals(T.getBawu_type())) {
                this.j.setVisibility(0);
                this.j.setText(R.string.bawu_member_bazhu_tip);
                return;
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(T.getBawu_type())) {
                this.j.setText(R.string.bawu_member_xbazhu_tip);
                this.j.setVisibility(0);
                return;
            } else if ("pri_content_assist".equals(T.getBawu_type())) {
                this.j.setText(R.string.bawu_content_assist_tip);
                this.j.setVisibility(0);
                return;
            } else if ("pri_manage_assist".equals(T.getBawu_type())) {
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

    public void v(a2 a2Var) {
        if (this.p == null) {
            return;
        }
        if (a2Var != null && (k(8) || k(512))) {
            if (this.B.getType() == a2.B3) {
                this.p.setVisibility(0);
                this.p.getPaint().setFakeBoldText(true);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
                return;
            } else if (k(8)) {
                if (StringUtils.isNull(a2Var.V0())) {
                    this.p.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    this.p.setLayoutParams(layoutParams);
                }
                this.p.setText(a2Var.V0());
                this.p.setVisibility(0);
                return;
            } else if (StringUtils.isNull(this.B.f1())) {
                this.p.setVisibility(8);
                return;
            } else {
                this.p.setVisibility(0);
                this.p.setText(this.B.f1());
                return;
            }
        }
        this.p.setVisibility(8);
    }

    public final void w(a2 a2Var) {
        if (this.l == null || a2Var == null || a2Var.T() == null || !k(1)) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = a2Var.T().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) != 0) {
            this.l.setVisibility(0);
            this.l.h(tShowInfoNew, 2, this.f4358e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f4358e.getResources().getDimensionPixelSize(R.dimen.tbds48), this.f4358e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
            return;
        }
        this.l.setVisibility(8);
    }

    public final void x(a2 a2Var) {
        if (a2Var.T() == null) {
            this.f4360g.setVisibility(8);
            return;
        }
        MetaData T = a2Var.T();
        if (!k(256)) {
            T.setPendantData(null);
        }
        this.f4360g.setData(a2Var);
    }

    public final void y(a2 a2Var) {
        if (this.k == null) {
            return;
        }
        if (!k(32)) {
            this.k.setVisibility(8);
        } else if (a2Var != null && a2Var.T() != null && (a2Var.p1 <= 0 || a2Var.q1 != 0)) {
            ArrayList<IconData> iconInfo = a2Var.T().getIconInfo();
            if (ListUtils.getCount(iconInfo) != 0) {
                this.k.setVisibility(0);
                this.k.h(iconInfo, 4, this.f4358e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f4358e.getResources().getDimensionPixelSize(R.dimen.tbds40), this.f4358e.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
                return;
            }
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(8);
        }
    }

    public final void z(a2 a2Var) {
        if (this.f4362i == null || a2Var == null) {
            return;
        }
        if (!a2Var.T1 && !a2Var.Z1()) {
            if (!StringUtils.isNull(this.B.F0())) {
                this.f4362i.setText(this.B.F0());
            } else {
                this.f4362i.setText(R.string.user_name_default_txt);
            }
        } else {
            ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
            layoutParams.width = this.w;
            this.z.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.A.getLayoutParams();
            layoutParams2.width = -1;
            this.A.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.f4362i.getLayoutParams();
            layoutParams3.width = -1;
            this.f4362i.setLayoutParams(layoutParams3);
            this.f4362i.setEllipsize(TextUtils.TruncateAt.END);
            if (a2Var.T() != null && !StringUtils.isNull(a2Var.T().getName_show())) {
                this.f4362i.setText(a2Var.T().getName_show());
            } else {
                this.f4362i.setText(R.string.user_name_default_txt);
            }
        }
        d.a.j0.b.g.b.d(this.f4362i);
        m();
    }

    public CardUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4359f = 3;
        this.D = 34053;
        this.E = new a();
        this.F = new b();
        this.G = new c();
        this.H = new d();
        i();
    }
}
