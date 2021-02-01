package com.baidu.card.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.c.g;
/* loaded from: classes.dex */
public class UnfollowedDecorView extends AppCompatImageView implements View.OnClickListener {
    public g amp;
    private int amq;
    private int amr;

    public UnfollowedDecorView(Context context) {
        this(context, null);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnfollowedDecorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amq = R.drawable.icon_pure_card_more22;
        this.amr = R.color.CAM_X0111;
        this.amp = new g(getCurrentActivityPageContext((Activity) context), this);
        setOnClickListener(this);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_more22, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!l.isFastDoubleClick()) {
            this.amp.ctH();
        }
    }

    public void r(cb cbVar) {
        this.amp.r(cbVar);
        if (!az.x(cbVar) && cbVar.bpK()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        setImageDrawable(WebPManager.a(this.amq, ap.getColor(this.amr), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    private TbPageContext getCurrentActivityPageContext(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void setWebPResId(int i, int i2) {
        this.amq = i;
        this.amr = i2;
        setImageDrawable(WebPManager.a(this.amq, ap.getColor(this.amr), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
