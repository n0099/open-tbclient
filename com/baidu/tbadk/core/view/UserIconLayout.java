package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private com.baidu.tbadk.core.data.as aeC;
    public TextView ahM;
    private UserIconBox ahN;
    private UserIconBox ahO;
    public boolean ahP;
    private View.OnClickListener ahQ;
    private View.OnClickListener ahR;
    private View.OnClickListener ahS;
    private View.OnClickListener ahT;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ahP = false;
        this.ahR = new ak(this);
        this.ahS = new al(this);
        this.ahT = new am(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahP = false;
        this.ahR = new ak(this);
        this.ahS = new al(this);
        this.ahT = new am(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ahM.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.ahN = new UserIconBox(this.mContext);
        this.ahO = new UserIconBox(this.mContext);
        this.ahM = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds10), com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds2), 0, 0);
        this.ahM.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.fontsize24));
        this.ahM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        this.ahN.setLayoutParams(layoutParams);
        this.ahO.setLayoutParams(layoutParams2);
        this.ahM.setLayoutParams(layoutParams3);
        this.ahM.setId(t.g.user_name);
        addView(this.ahN);
        addView(this.ahM);
        addView(this.ahO);
    }

    public void setData(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null && asVar.getAuthor() != null) {
            this.aeC = asVar;
            this.ahN.setOnClickListener(this.ahS);
            this.ahO.setOnClickListener(this.ahR);
            this.ahM.setOnClickListener(this.ahT);
            if (StringUtils.isNull(this.aeC.getAuthor().getName_show())) {
                this.ahM.setVisibility(8);
            } else {
                this.ahM.setVisibility(0);
                this.ahM.setText(this.aeC.getAuthor().getName_show());
            }
            ArrayList<IconData> iconInfo = asVar.getAuthor().getIconInfo();
            if (this.ahP && com.baidu.tbadk.core.util.y.p(iconInfo) != 0) {
                this.ahO.setVisibility(0);
                this.ahO.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.ahO.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.p(tShowInfoNew) != 0) {
                this.ahN.setVisibility(0);
                this.ahN.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
            } else {
                this.ahN.setVisibility(8);
            }
            xJ();
        }
    }

    private void xJ() {
        if (this.aeC != null && this.aeC.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = this.aeC.getAuthor().getTShowInfoNew();
            ArrayList<IconData> iconInfo = this.aeC.getAuthor().getIconInfo();
            if (this.ahP) {
                if (!com.baidu.tbadk.core.util.y.q(tShowInfoNew) || !com.baidu.tbadk.core.util.y.q(iconInfo)) {
                    at.j((View) this.ahM, t.d.cp_cont_h);
                } else {
                    at.j((View) this.ahM, t.d.cp_cont_b);
                }
            } else if (!com.baidu.tbadk.core.util.y.q(tShowInfoNew)) {
                at.j((View) this.ahM, t.d.cp_cont_h);
            } else {
                at.j((View) this.ahM, t.d.cp_cont_b);
            }
        }
    }

    public void uA() {
        xJ();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahQ = onClickListener;
    }
}
