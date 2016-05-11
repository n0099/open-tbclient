package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private ax aab;
    public TextView adG;
    private UserIconBox adH;
    private UserIconBox adI;
    public boolean adJ;
    private View.OnClickListener adK;
    private boolean adL;
    private int adM;
    private View.OnClickListener adN;
    private View.OnClickListener adO;
    private View.OnClickListener adP;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.adJ = false;
        this.adL = false;
        this.adM = 0;
        this.adN = new am(this);
        this.adO = new an(this);
        this.adP = new ao(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adJ = false;
        this.adL = false;
        this.adM = 0;
        this.adN = new am(this);
        this.adO = new an(this);
        this.adP = new ao(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.adG.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.adH = new UserIconBox(this.mContext);
        this.adI = new UserIconBox(this.mContext);
        this.adG = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds10), com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds2), 0, 0);
        this.adG.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.fontsize24));
        if (!this.adL) {
            this.adG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.adH.setLayoutParams(layoutParams);
        this.adI.setLayoutParams(layoutParams2);
        this.adG.setLayoutParams(layoutParams3);
        this.adG.setId(t.g.user_name);
        this.adI.vv();
        addView(this.adH);
        addView(this.adG);
        addView(this.adI);
    }

    public void setData(ax axVar) {
        if (axVar != null && axVar.getAuthor() != null) {
            this.aab = axVar;
            this.adH.setOnClickListener(this.adO);
            this.adI.setOnClickListener(this.adN);
            this.adG.setOnClickListener(this.adP);
            if (StringUtils.isNull(this.aab.getAuthor().getName_show())) {
                this.adG.setVisibility(8);
            } else {
                this.adG.setVisibility(0);
                String name_show = this.aab.getAuthor().getName_show();
                if (this.adL) {
                    this.adG.setText(com.baidu.tbadk.util.u.G(name_show, 20));
                } else {
                    this.adG.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = axVar.getAuthor().getIconInfo();
            if (this.adJ && com.baidu.tbadk.core.util.y.r(iconInfo) != 0) {
                this.adI.setVisibility(0);
                this.adI.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.adI.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.r(tShowInfoNew) != 0) {
                this.adH.setVisibility(0);
                this.adH.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
            } else {
                this.adH.setVisibility(8);
            }
            vz();
        }
    }

    private void vz() {
        if (this.aab != null && this.aab.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.y.s(this.aab.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.at.j((View) this.adG, t.d.cp_cont_h);
            } else {
                com.baidu.tbadk.core.util.at.j((View) this.adG, t.d.cp_cont_b);
            }
        }
    }

    public void sf() {
        vz();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.adK = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.adL = z;
    }

    public void setPageName(int i) {
        this.adM = i;
    }
}
