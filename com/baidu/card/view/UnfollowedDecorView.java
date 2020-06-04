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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.c.f;
/* loaded from: classes8.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {
    private int aeA;
    private int aeB;
    public f aih;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeA = R.drawable.ic_icon_pure_card_delete_svg;
        this.aeB = R.color.cp_cont_g;
        this.aih = new f(n((Activity) context));
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SvgManager.aUW().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!k.isFastDoubleClick()) {
            this.aih.yy();
            this.aih.showDialog();
        }
    }

    public void r(bk bkVar) {
        this.aih.r(bkVar);
        if (!au.v(bkVar) && bkVar.aSq()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        SvgManager.aUW().a(this, this.aeA, this.aeB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private TbPageContext n(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void setSvgResId(int i, int i2) {
        this.aeA = i;
        this.aeB = i2;
        SvgManager.aUW().a(this, this.aeA, this.aeB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
