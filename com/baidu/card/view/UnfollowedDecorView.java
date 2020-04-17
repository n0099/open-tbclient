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
/* loaded from: classes8.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {
    public f ahA;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahA = new f(n((Activity) context));
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        SvgManager.aOU().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!k.isFastDoubleClick()) {
            this.ahA.xl();
            this.ahA.showDialog();
        }
    }

    public void q(bj bjVar) {
        this.ahA.q(bjVar);
        if (!au.u(bjVar) && bjVar.aMt()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        SvgManager.aOU().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
}
