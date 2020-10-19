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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
/* loaded from: classes21.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {
    private int agU;
    private int agV;
    public g alH;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agU = R.drawable.ic_icon_pure_card_delete_svg;
        this.agV = R.color.cp_cont_g;
        this.alH = new g(o((Activity) context));
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SvgManager.bmU().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!l.isFastDoubleClick()) {
            this.alH.Gz();
            this.alH.Pd();
        }
    }

    public void r(bw bwVar) {
        this.alH.r(bwVar);
        if (!ay.x(bwVar) && bwVar.bjZ()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        SvgManager.bmU().a(this, this.agU, this.agV, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private TbPageContext o(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void setSvgResId(int i, int i2) {
        this.agU = i;
        this.agV = i2;
        SvgManager.bmU().a(this, this.agU, this.agV, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
