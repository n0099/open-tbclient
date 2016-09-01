package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bg adL;
    public TextView ahN;
    private UserIconBox ahO;
    private UserIconBox ahP;
    public boolean ahQ;
    private View.OnClickListener ahR;
    private boolean ahS;
    private int ahT;
    private View.OnClickListener ahU;
    private View.OnClickListener ahV;
    private View.OnClickListener ahW;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ahQ = false;
        this.ahS = false;
        this.ahT = 0;
        this.ahU = new an(this);
        this.ahV = new ao(this);
        this.ahW = new ap(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahQ = false;
        this.ahS = false;
        this.ahT = 0;
        this.ahU = new an(this);
        this.ahV = new ao(this);
        this.ahW = new ap(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ahN.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.ahO = new UserIconBox(this.mContext);
        this.ahP = new UserIconBox(this.mContext);
        this.ahN = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds10), com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds2), 0, 0);
        this.ahN.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.fontsize24));
        if (!this.ahS) {
            this.ahN.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ahO.setLayoutParams(layoutParams);
        this.ahP.setLayoutParams(layoutParams2);
        this.ahN.setLayoutParams(layoutParams3);
        this.ahN.setId(t.g.user_name);
        this.ahP.wC();
        addView(this.ahO);
        addView(this.ahN);
        addView(this.ahP);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.getAuthor() != null) {
            this.adL = bgVar;
            this.ahO.setOnClickListener(this.ahV);
            this.ahP.setOnClickListener(this.ahU);
            this.ahN.setOnClickListener(this.ahW);
            if (StringUtils.isNull(this.adL.getAuthor().getName_show())) {
                this.ahN.setVisibility(8);
            } else {
                this.ahN.setVisibility(0);
                String name_show = this.adL.getAuthor().getName_show();
                if (this.ahS) {
                    this.ahN.setText(com.baidu.tbadk.util.v.H(name_show, 20));
                } else {
                    this.ahN.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bgVar.getAuthor().getIconInfo();
            if (this.ahQ && com.baidu.tbadk.core.util.y.s(iconInfo) != 0) {
                this.ahP.setVisibility(0);
                this.ahP.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.ahP.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0) {
                this.ahO.setVisibility(0);
                this.ahO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.ds8), true);
            } else {
                this.ahO.setVisibility(8);
            }
            wG();
        }
    }

    private void wG() {
        if (this.adL != null && this.adL.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.y.t(this.adL.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.av.j((View) this.ahN, t.d.cp_cont_h);
            } else {
                com.baidu.tbadk.core.util.av.j((View) this.ahN, t.d.cp_cont_b);
            }
        }
    }

    public void ti() {
        wG();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahR = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.ahS = z;
    }

    public void setPageName(int i) {
        this.ahT = i;
    }
}
