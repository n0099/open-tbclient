package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private com.baidu.tbadk.core.data.z aeF;
    private TextView agS;
    private UserIconBox agT;
    private UserIconBox agU;
    public boolean agV;
    private View.OnClickListener agW;
    private View.OnClickListener agX;
    private View.OnClickListener agY;
    private View.OnClickListener agZ;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.agV = false;
        this.agX = new ad(this);
        this.agY = new ae(this);
        this.agZ = new af(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agV = false;
        this.agX = new ad(this);
        this.agY = new ae(this);
        this.agZ = new af(this);
        this.mContext = context;
        init();
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.agT = new UserIconBox(this.mContext);
        this.agU = new UserIconBox(this.mContext);
        this.agS = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds10), com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds14), 0, 0, 0);
        this.agS.setTextSize(0, com.baidu.adp.lib.util.k.d(this.mContext, n.e.fontsize28));
        this.agS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        this.agT.setLayoutParams(layoutParams);
        this.agU.setLayoutParams(layoutParams2);
        this.agS.setLayoutParams(layoutParams3);
        addView(this.agT);
        addView(this.agS);
        addView(this.agU);
    }

    public void setData(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null && zVar.getAuthor() != null) {
            this.aeF = zVar;
            this.agT.setOnClickListener(this.agY);
            this.agU.setOnClickListener(this.agX);
            this.agS.setOnClickListener(this.agZ);
            if (StringUtils.isNull(this.aeF.getAuthor().getName_show())) {
                this.agS.setVisibility(8);
            } else {
                this.agS.setVisibility(0);
                this.agS.setText(this.aeF.getAuthor().getName_show());
            }
            ArrayList<IconData> iconInfo = zVar.getAuthor().getIconInfo();
            if (this.agV && com.baidu.tbadk.core.util.y.l(iconInfo) != 0) {
                this.agU.setVisibility(0);
                this.agU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds30), this.mContext.getResources().getDimensionPixelSize(n.e.ds10), true);
            } else {
                this.agU.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.l(tShowInfoNew) != 0) {
                as.h((View) this.agS, n.d.cp_cont_h);
                this.agT.setVisibility(0);
                this.agT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(n.e.ds36), this.mContext.getResources().getDimensionPixelSize(n.e.ds36), this.mContext.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
                return;
            }
            as.h((View) this.agS, n.d.cp_cont_b);
            this.agT.setVisibility(8);
        }
    }

    public void vW() {
        as.h((View) this.agS, n.d.cp_cont_b);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agW = onClickListener;
    }
}
