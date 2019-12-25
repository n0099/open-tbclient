package com.baidu.card.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
/* loaded from: classes5.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {
    public f Or;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Or = new f(r((Activity) context));
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SvgManager.aDW().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!k.isFastDoubleClick()) {
            this.Or.wN();
            this.Or.showDialog();
        }
    }

    public void q(bj bjVar) {
        this.Or.q(bjVar);
        if (!au.u(bjVar) && bjVar.aBu()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        SvgManager.aDW().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private TbPageContext r(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
