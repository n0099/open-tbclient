package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.r.u.c;
/* loaded from: classes3.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public a2 f13179e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13180f;

    /* renamed from: g  reason: collision with root package name */
    public View f13181g;

    /* renamed from: h  reason: collision with root package name */
    public int f13182h;
    public TextView i;
    public Drawable j;
    public View.OnClickListener k;
    public int l;

    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        this.f13182h = 0;
        this.l = 3;
        d(context);
    }

    public void a(a2 a2Var) {
        this.f13179e = a2Var;
        if (a2Var != null) {
            String string = getResources().getString(R.string.frs_goods_tip_content);
            if (StringUtils.isNull(string)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            f();
            this.i.setText(string);
            this.i.setVisibility(0);
            e();
            b();
            return;
        }
        setVisibility(8);
    }

    public final void b() {
        int i = this.f13182h;
        if (i == 2) {
            c("c13966", 1);
        } else if (i == 1) {
            c("c13966", 2);
        }
    }

    public final void c(String str, int i) {
        TiebaStatic.log(new StatisticItem(str).param("obj_locate", i).param("fid", this.f13179e.c0()).param("fname", this.f13179e.i0()).param("tid", this.f13179e.w1()));
    }

    public final void d(Context context) {
        this.f13180f = context;
        setOnClickListener(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.f13181g = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
        this.i = textView;
        c d2 = c.d(textView);
        d2.v(R.string.F_X01);
        d2.u(R.dimen.T_X09);
        d2.q(R.color.CAM_X0305);
        d2.e(R.string.A_X07);
        d2.k(R.string.J_X01);
        d2.i(R.dimen.L_X02);
        d2.h(R.color.CAM_X0305);
        this.i.setCompoundDrawablePadding(l.g(this.f13180f, R.dimen.M_W_X002));
    }

    public void e() {
        int skinType;
        if (this.f13179e == null || this.l == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.l = skinType;
        int color = SkinManager.getColor(R.color.CAM_X0305);
        SkinManager.setViewTextColorWithClickState(this.i, color);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.j = pureDrawable;
        if (pureDrawable != null) {
            this.j.setBounds(0, 0, l.g(this.f13180f, R.dimen.T_X09), l.g(this.f13180f, R.dimen.T_X09));
        }
        f();
    }

    public final void f() {
        this.i.setCompoundDrawables(this.j, null, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (StringUtils.isNull(this.f13179e.i0())) {
            return;
        }
        view.setTag(this.f13179e);
        int i = this.f13182h;
        if (i == 0) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f13180f).createNormalCfg(this.f13179e.i0(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        } else if (i == 1) {
            c("c13967", 2);
            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f13180f).createNormalCfg(this.f13179e.i0(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg2.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
        } else if (i == 2) {
            c("c13967", 1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921488));
        }
        View.OnClickListener onClickListener = this.k;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void setFrom(int i) {
        this.f13182h = i;
    }

    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13182h = 0;
        this.l = 3;
        d(context);
    }
}
