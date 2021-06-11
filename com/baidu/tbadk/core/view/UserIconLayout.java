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
import d.a.c.a.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
import d.a.n0.z.m;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UserIconLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12492e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12493f;

    /* renamed from: g  reason: collision with root package name */
    public View f12494g;

    /* renamed from: h  reason: collision with root package name */
    public UserIconBox f12495h;

    /* renamed from: i  reason: collision with root package name */
    public UserIconBox f12496i;
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
            d.a.m0.l.a.o(UserIconLayout.this.f12492e.getApplicationContext(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + UserIconLayout.this.k.T().getUserId(), true, true, true);
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
            if (!ViewHelper.checkUpIsLogin(UserIconLayout.this.f12492e) || UserIconLayout.this.k == null || UserIconLayout.this.k.T() == null || UserIconLayout.this.k.T().getTShowInfoNew() == null) {
                return;
            }
            ArrayList<IconData> tShowInfoNew = UserIconLayout.this.k.T().getTShowInfoNew();
            if (ListUtils.getCount(tShowInfoNew) == 0 || ListUtils.getItem(tShowInfoNew, 0) == null || (url = UserIconLayout.this.k.T().getTShowInfoNew().get(0).getUrl()) == null || !(j.a(UserIconLayout.this.f12492e) instanceof TbPageContext)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) j.a(UserIconLayout.this.f12492e), new String[]{url});
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(UserIconLayout.this.f12492e, UserIconLayout.this.k.T().getUserId(), UserIconLayout.this.k.T().getName_show(), UserIconLayout.this.k.i0(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
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
        this.f12492e = context;
        f();
    }

    private void setUserTextColor(a2 a2Var) {
        a2 a2Var2 = this.k;
        if (a2Var2 == null || a2Var2.T() == null) {
            return;
        }
        if (ListUtils.isEmpty(this.k.T().getTShowInfoNew()) && !this.k.T().isBigV()) {
            SkinManager.setViewTextColor(this.f12493f, R.color.CAM_X0105);
            return;
        }
        SkinManager.setViewTextColor(this.f12493f, R.color.CAM_X0301);
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
        return m.h(this.f12492e, str2, arrayList, true);
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
        this.f12495h = new UserIconBox(this.f12492e);
        this.f12496i = new UserIconBox(this.f12492e);
        this.f12493f = new TextView(this.f12492e);
        View a2 = d.a.m0.d.c.b().a(this.f12492e, 1);
        this.f12494g = a2;
        if (a2 != null) {
            a2.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, l.g(this.f12492e, R.dimen.ds10), l.g(this.f12492e, R.dimen.ds4));
        layoutParams2.setMargins(l.g(this.f12492e, R.dimen.ds14), -l.g(this.f12492e, R.dimen.ds1), 0, 0);
        layoutParams3.setMargins(0, l.g(this.f12492e, R.dimen.ds2), 0, 0);
        layoutParams4.setMargins(l.g(this.f12492e, R.dimen.ds8), l.g(this.f12492e, R.dimen.ds3), 0, 0);
        this.f12493f.setTextSize(0, l.g(this.f12492e, R.dimen.fontsize24));
        if (!this.m) {
            this.f12493f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.f12495h.setLayoutParams(layoutParams);
        this.f12496i.setLayoutParams(layoutParams2);
        this.f12493f.setLayoutParams(layoutParams3);
        addView(this.f12495h);
        addView(this.f12493f);
        View view = this.f12494g;
        if (view != null) {
            addView(view);
        }
        addView(this.f12496i);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(a2 a2Var) {
        int i2;
        ArrayList<IconData> tShowInfoNew;
        if (a2Var == null || a2Var.T() == null) {
            return;
        }
        this.k = a2Var;
        this.f12495h.setOnClickListener(this.q);
        this.f12496i.setOnClickListener(this.p);
        this.f12493f.setOnClickListener(this.r);
        if (a2Var.T() != null && a2Var.T().getAlaUserData() != null) {
            AlaUserInfoData alaUserData = a2Var.T().getAlaUserData();
            if (this.f12494g != null) {
                d.a.m0.d.b bVar = new d.a.m0.d.b();
                bVar.f52936a = alaUserData;
                bVar.f52937b = 1;
                this.f12494g.setTag(bVar);
            }
        }
        if (StringUtils.isNull(this.k.T().getName_show())) {
            this.f12493f.setVisibility(8);
        } else {
            this.f12493f.setVisibility(0);
            String name_show = this.k.T().getName_show();
            if (this.m) {
                if (this.o) {
                    this.f12493f.setText(e(this.k.T().getSealPrefix(), i0.j(name_show, 20)));
                    int byteLength = k.byteLength(name_show);
                    i2 = byteLength < 20 ? byteLength >= 16 ? 2 : 4 : 1;
                    ArrayList<IconData> iconInfo = a2Var.T().getIconInfo();
                    if (!this.j && ListUtils.getCount(iconInfo) != 0) {
                        this.f12496i.setVisibility(0);
                        this.f12496i.h(iconInfo, i2, this.f12492e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f12492e.getResources().getDimensionPixelSize(R.dimen.ds30), this.f12492e.getResources().getDimensionPixelSize(R.dimen.ds10), true);
                    } else {
                        this.f12496i.setVisibility(8);
                    }
                    tShowInfoNew = a2Var.T().getTShowInfoNew();
                    if (ListUtils.getCount(tShowInfoNew) == 0) {
                        this.f12495h.setVisibility(0);
                        this.f12495h.h(tShowInfoNew, 2, this.f12492e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f12492e.getResources().getDimensionPixelSize(R.dimen.ds36), this.f12492e.getResources().getDimensionPixelSize(R.dimen.ds8), true);
                    } else {
                        this.f12495h.setVisibility(8);
                    }
                    setUserTextColor(a2Var);
                }
                this.f12493f.setText(i0.j(name_show, 20));
            } else if (this.o) {
                this.f12493f.setText(e(this.k.T().getSealPrefix(), name_show));
            } else {
                this.f12493f.setText(name_show);
            }
        }
        i2 = 4;
        ArrayList<IconData> iconInfo2 = a2Var.T().getIconInfo();
        if (!this.j) {
        }
        this.f12496i.setVisibility(8);
        tShowInfoNew = a2Var.T().getTShowInfoNew();
        if (ListUtils.getCount(tShowInfoNew) == 0) {
        }
        setUserTextColor(a2Var);
    }

    public void setEntelechyEnabled(boolean z) {
        this.m = z;
    }

    public void setPageName(int i2) {
        this.n = i2;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public void setUserNameTextSizeRid(int i2) {
        this.f12493f.setTextSize(0, l.g(this.f12492e, i2));
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
        this.f12492e = context;
        f();
    }
}
