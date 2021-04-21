package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import d.b.c.a.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.z0.i0;
import d.b.j0.x.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UserIconLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13230e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13231f;

    /* renamed from: g  reason: collision with root package name */
    public View f13232g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f13233h;
    public UserIconBox i;
    public boolean j;
    public a2 k;
    public View.OnClickListener l;
    public boolean m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserIconLayout.this.k == null || UserIconLayout.this.k.T() == null) {
                return;
            }
            d.b.i0.l.a.o(UserIconLayout.this.f13230e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.k.T().getUserId(), true, true, true);
            if (UserIconLayout.this.n == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String url;
            if (!ViewHelper.checkUpIsLogin(UserIconLayout.this.f13230e) || UserIconLayout.this.k == null || UserIconLayout.this.k.T() == null || UserIconLayout.this.k.T().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = UserIconLayout.this.k.T().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = UserIconLayout.this.k.T().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(UserIconLayout.this.f13230e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(UserIconLayout.this.f13230e), new String[]{url});
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserIconLayout.this.k == null || UserIconLayout.this.k.T() == null || StringUtils.isNull(UserIconLayout.this.k.T().getName_show()) || StringUtils.isNull(UserIconLayout.this.k.T().getUserId()) || UserIconLayout.this.k.i0() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.f13230e, UserIconLayout.this.k.T().getUserId(), UserIconLayout.this.k.T().getName_show(), UserIconLayout.this.k.i0(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
            if (UserIconLayout.this.l != null) {
                UserIconLayout.this.l.onClick(view);
            }
        }
    }

    public UserIconLayout(Context context) {
        super(context);
        this.j = false;
        this.m = false;
        this.n = 0;
        this.o = false;
        this.p = new a();
        this.q = new b();
        this.r = new c();
        this.f13230e = context;
        f();
    }

    private void setUserTextColor(a2 a2Var) {
        a2 a2Var2 = this.k;
        if (a2Var2 == null || a2Var2.T() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.k.T().getTShowInfoNew()) && !this.k.T().isBigV()) {
            SkinManager.setViewTextColor(this.f13231f, R.color.CAM_X0105);
            return;
        }
        SkinManager.setViewTextColor(this.f13231f, R.color.CAM_X0301);
        if (a2Var.T() == null || a2Var.T().getAlaUserData() == null) {
            return;
        }
        a2Var.T().getAlaUserData();
    }

    public final SpannableStringBuilder e(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == null || str == null) {
            return spannableStringBuilder;
        }
        arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
        return m.h(this.f13230e, str2, arrayList, true);
    }

    public final void f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        layoutParams3.gravity = 16;
        layoutParams4.gravity = 16;
        this.f13233h = new UserIconBox(this.f13230e);
        this.i = new UserIconBox(this.f13230e);
        this.f13231f = new TextView(this.f13230e);
        View a2 = d.b.i0.d.b.b().a(this.f13230e, 1);
        this.f13232g = a2;
        if (a2 != null) {
            a2.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.g(this.f13230e, R.dimen.ds10), l.g(this.f13230e, R.dimen.ds4));
        layoutParams2.setMargins(l.g(this.f13230e, R.dimen.ds14), -l.g(this.f13230e, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, l.g(this.f13230e, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(l.g(this.f13230e, R.dimen.ds8), l.g(this.f13230e, R.dimen.ds3), 0, 0);
        this.f13231f.setTextSize(0, l.g(this.f13230e, R.dimen.fontsize24));
        if (!this.m) {
            this.f13231f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.f13233h.setLayoutParams(layoutParams);
        this.i.setLayoutParams(layoutParams2);
        this.f13231f.setLayoutParams(layoutParams3);
        addView(this.f13233h);
        addView(this.f13231f);
        View view = this.f13232g;
        if (view != null) {
            addView(view);
        }
        addView(this.i);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(a2 a2Var) {
        int i;
        ArrayList<IconData> tShowInfoNew;
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        this.k = a2Var;
        this.f13233h.setOnClickListener(this.q);
        this.i.setOnClickListener(this.p);
        this.f13231f.setOnClickListener(this.r);
        if (a2Var.T() != null && a2Var.T().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = a2Var.T().getAlaUserData();
            if (this.f13232g != null) {
                d.b.i0.d.a aVar = new d.b.i0.d.a();
                aVar.f50815a = alaUserData;
                aVar.f50816b = 1;
                this.f13232g.setTag(aVar);
            }
        }
        if (StringUtils.isNull(this.k.T().getName_show())) {
            this.f13231f.setVisibility(8);
        } else {
            this.f13231f.setVisibility(0);
            String name_show = this.k.T().getName_show();
            if (this.m) {
                if (this.o) {
                    this.f13231f.setText(e(this.k.T().getSealPrefix(), i0.j(name_show, 20)));
                    int byteLength = k.byteLength(name_show);
                    i = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = a2Var.T().getIconInfo();
                    if (!this.j && ListUtils.getCount(iconInfo) != 0) {
                        this.i.setVisibility(0);
                        this.i.h(iconInfo, i, this.f13230e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f13230e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f13230e.getResources().getDimensionPixelSize(R.dimen.ds10), true);
                    } else {
                        this.i.setVisibility(8);
                    }
                    tShowInfoNew = a2Var.T().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.f13233h.setVisibility(0);
                        this.f13233h.h(tShowInfoNew, 2, this.f13230e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f13230e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f13230e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    } else {
                        this.f13233h.setVisibility(8);
                    }
                    setUserTextColor(a2Var);
                }
                this.f13231f.setText(i0.j(name_show, 20));
            } else if (this.o) {
                this.f13231f.setText(e(this.k.T().getSealPrefix(), name_show));
            } else {
                this.f13231f.setText(name_show);
            }
        }
        i = 4;
        ArrayList<IconData> iconInfo2 = a2Var.T().getIconInfo();
        if (!this.j) {
        }
        this.i.setVisibility(8);
        tShowInfoNew = a2Var.T().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) == 0) {
        }
        setUserTextColor(a2Var);
    }

    public void setEntelechyEnabled(boolean z) {
        this.m = z;
    }

    public void setPageName(int i) {
        this.n = i;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setUserNameTextSizeRid(int i) {
        this.f13231f.setTextSize(0, l.g(this.f13230e, i));
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.m = false;
        this.n = 0;
        this.o = false;
        this.p = new a();
        this.q = new b();
        this.r = new c();
        this.f13230e = context;
        f();
    }
}
