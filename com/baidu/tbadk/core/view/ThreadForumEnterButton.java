package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.u.c;
/* loaded from: classes3.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public a2 f13163e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13164f;

    /* renamed from: g  reason: collision with root package name */
    public View f13165g;

    /* renamed from: h  reason: collision with root package name */
    public int f13166h;
    public TextView i;
    public Drawable j;
    public View.OnClickListener k;
    public int l;

    static {
        l.k(TbadkCoreApplication.getInst());
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
    }

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.f13166h = 0;
        this.l = 3;
        c(context);
    }

    public void a(a2 a2Var) {
        this.f13163e = a2Var;
        if (a2Var != null) {
            String i0 = a2Var.i0();
            if (StringUtils.isNull(i0)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            e();
            TextView textView = this.i;
            textView.setText(StringHelper.cutForumNameWithSuffix(i0, 14, StringHelper.STRING_MORE) + this.f13164f.getString(R.string.forum));
            this.i.setVisibility(0);
            d();
            return;
        }
        setVisibility(8);
    }

    public void b(a2 a2Var, int i) {
        this.f13163e = a2Var;
        if (a2Var != null && i > 0) {
            int paddingLeft = this.i.getPaddingLeft();
            String i0 = a2Var.i0();
            if (StringUtils.isNull(i0)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            e();
            float measureText = (i - (paddingLeft * 2)) - this.i.getPaint().measureText(getResources().getString(R.string.forum));
            this.i.setText(((Object) TextUtils.ellipsize(i0, this.i.getPaint(), measureText, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.i.setVisibility(0);
            d();
            return;
        }
        setVisibility(8);
    }

    public final void c(Context context) {
        this.f13164f = context;
        setOnClickListener(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.f13165g = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.forum_name_text);
        this.i = textView;
        textView.setCompoundDrawablePadding(l.g(this.f13164f, R.dimen.M_W_X002));
    }

    public void d() {
        int skinType;
        if (this.f13163e == null || this.l == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            return;
        }
        this.l = skinType;
        c d2 = c.d(this.i);
        d2.v(R.string.F_X01);
        d2.u(R.dimen.T_X09);
        d2.q(R.color.CAM_X0304);
        d2.e(R.string.A_X07);
        d2.k(R.string.J_X01);
        d2.i(R.dimen.L_X02);
        d2.h(R.color.CAM_X0304);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_ba12, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
        this.j = pureDrawable;
        if (pureDrawable != null) {
            int g2 = l.g(this.f13164f, R.dimen.T_X09);
            this.j.setBounds(0, 0, g2, g2);
        }
        e();
    }

    public final void e() {
        this.i.setCompoundDrawables(this.j, null, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13163e.getType() == a2.x3) {
            Context context = this.f13164f;
            BdToast.i(context, context.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
        } else if (StringUtils.isNull(this.f13163e.i0())) {
        } else {
            view.setTag(this.f13163e);
            if (this.f13166h == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f13164f).createNormalCfg(this.f13163e.i0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
            View.OnClickListener onClickListener = this.k;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    public void setFrom(int i) {
        this.f13166h = i;
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13166h = 0;
        this.l = 3;
        c(context);
    }
}
