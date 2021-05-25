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
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.r.u.c;
/* loaded from: classes3.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public a2 f12370e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12371f;

    /* renamed from: g  reason: collision with root package name */
    public View f12372g;

    /* renamed from: h  reason: collision with root package name */
    public int f12373h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12374i;
    public Drawable j;
    public View.OnClickListener k;
    public int l;

    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        this.f12373h = 0;
        this.l = 3;
        d(context);
    }

    public void a(a2 a2Var) {
        this.f12370e = a2Var;
        if (a2Var != null) {
            String string = getResources().getString(R.string.frs_goods_tip_content);
            if (StringUtils.isNull(string)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            f();
            this.f12374i.setText(string);
            this.f12374i.setVisibility(0);
            e();
            b();
            return;
        }
        setVisibility(8);
    }

    public final void b() {
        int i2 = this.f12373h;
        if (i2 == 2) {
            c("c13966", 1);
        } else if (i2 == 1) {
            c("c13966", 2);
        }
    }

    public final void c(String str, int i2) {
        TiebaStatic.log(new StatisticItem(str).param("obj_locate", i2).param("fid", this.f12370e.c0()).param("fname", this.f12370e.i0()).param("tid", this.f12370e.y1()));
    }

    public final void d(Context context) {
        this.f12371f = context;
        setOnClickListener(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.f12372g = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
        this.f12374i = textView;
        c d2 = c.d(textView);
        d2.x(R.string.F_X01);
        d2.w(R.dimen.T_X09);
        d2.s(R.color.CAM_X0305);
        d2.e(R.string.A_X07);
        d2.m(R.string.J_X01);
        d2.k(R.dimen.L_X02);
        d2.j(R.color.CAM_X0305);
        this.f12374i.setCompoundDrawablePadding(l.g(this.f12371f, R.dimen.M_W_X002));
    }

    public void e() {
        int skinType;
        if (this.f12370e == null || this.l == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.l = skinType;
        int color = SkinManager.getColor(R.color.CAM_X0305);
        SkinManager.setViewTextColorWithClickState(this.f12374i, color);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.j = pureDrawable;
        if (pureDrawable != null) {
            this.j.setBounds(0, 0, l.g(this.f12371f, R.dimen.T_X09), l.g(this.f12371f, R.dimen.T_X09));
        }
        f();
    }

    public final void f() {
        this.f12374i.setCompoundDrawables(this.j, null, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (StringUtils.isNull(this.f12370e.i0())) {
            return;
        }
        view.setTag(this.f12370e);
        int i2 = this.f12373h;
        if (i2 == 0) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f12371f).createNormalCfg(this.f12370e.i0(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
        } else if (i2 == 1) {
            c("c13967", 2);
            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f12371f).createNormalCfg(this.f12370e.i0(), FrsActivityConfig.FROM_PB_OR_PERSON);
            createNormalCfg2.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
        } else if (i2 == 2) {
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

    public void setFrom(int i2) {
        this.f12373h = i2;
    }

    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12373h = 0;
        this.l = 3;
        d(context);
    }
}
