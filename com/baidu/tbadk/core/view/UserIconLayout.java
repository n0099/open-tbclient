package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private be abb;
    public TextView aeS;
    private UserIconBox aeT;
    private UserIconBox aeU;
    public boolean aeV;
    private View.OnClickListener aeW;
    private boolean aeX;
    private int aeY;
    private View.OnClickListener aeZ;
    private View.OnClickListener afa;
    private View.OnClickListener afb;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aeV = false;
        this.aeX = false;
        this.aeY = 0;
        this.aeZ = new am(this);
        this.afa = new an(this);
        this.afb = new ao(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeV = false;
        this.aeX = false;
        this.aeY = 0;
        this.aeZ = new am(this);
        this.afa = new an(this);
        this.afb = new ao(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aeS.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.aeT = new UserIconBox(this.mContext);
        this.aeU = new UserIconBox(this.mContext);
        this.aeS = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds10), com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds2), 0, 0);
        this.aeS.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.fontsize24));
        if (!this.aeX) {
            this.aeS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aeT.setLayoutParams(layoutParams);
        this.aeU.setLayoutParams(layoutParams2);
        this.aeS.setLayoutParams(layoutParams3);
        this.aeS.setId(u.g.user_name);
        this.aeU.vy();
        addView(this.aeT);
        addView(this.aeS);
        addView(this.aeU);
    }

    public void setData(be beVar) {
        if (beVar != null && beVar.getAuthor() != null) {
            this.abb = beVar;
            this.aeT.setOnClickListener(this.afa);
            this.aeU.setOnClickListener(this.aeZ);
            this.aeS.setOnClickListener(this.afb);
            if (StringUtils.isNull(this.abb.getAuthor().getName_show())) {
                this.aeS.setVisibility(8);
            } else {
                this.aeS.setVisibility(0);
                String name_show = this.abb.getAuthor().getName_show();
                if (this.aeX) {
                    this.aeS.setText(com.baidu.tbadk.util.v.I(name_show, 20));
                } else {
                    this.aeS.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = beVar.getAuthor().getIconInfo();
            if (this.aeV && com.baidu.tbadk.core.util.y.s(iconInfo) != 0) {
                this.aeU.setVisibility(0);
                this.aeU.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(u.e.ds30), this.mContext.getResources().getDimensionPixelSize(u.e.ds30), this.mContext.getResources().getDimensionPixelSize(u.e.ds10), true);
            } else {
                this.aeU.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = beVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0) {
                this.aeT.setVisibility(0);
                this.aeT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(u.e.ds36), this.mContext.getResources().getDimensionPixelSize(u.e.ds36), this.mContext.getResources().getDimensionPixelSize(u.e.ds8), true);
            } else {
                this.aeT.setVisibility(8);
            }
            vC();
        }
    }

    private void vC() {
        if (this.abb != null && this.abb.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.y.t(this.abb.getAuthor().getTShowInfoNew())) {
                av.j((View) this.aeS, u.d.cp_cont_h);
            } else {
                av.j((View) this.aeS, u.d.cp_cont_b);
            }
        }
    }

    public void sd() {
        vC();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aeW = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aeX = z;
    }

    public void setPageName(int i) {
        this.aeY = i;
    }
}
