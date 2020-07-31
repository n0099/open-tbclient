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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
/* loaded from: classes15.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {
    private int aeY;
    private int aeZ;
    public g ajy;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeY = R.drawable.ic_icon_pure_card_delete_svg;
        this.aeZ = R.color.cp_cont_g;
        this.ajy = new g(o((Activity) context));
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SvgManager.baR().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!k.isFastDoubleClick()) {
            this.ajy.zA();
            this.ajy.showDialog();
        }
    }

    public void q(bv bvVar) {
        this.ajy.q(bvVar);
        if (!ax.w(bvVar) && bvVar.aYd()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        SvgManager.baR().a(this, this.aeY, this.aeZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        this.aeY = i;
        this.aeZ = i2;
        SvgManager.baR().a(this, this.aeY, this.aeZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
