package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private az aas;
    public TextView aee;
    private UserIconBox aef;
    private UserIconBox aeg;
    public boolean aeh;
    private View.OnClickListener aei;
    private boolean aej;
    private int aek;
    private View.OnClickListener ael;
    private View.OnClickListener aem;
    private View.OnClickListener aen;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.aeh = false;
        this.aej = false;
        this.aek = 0;
        this.ael = new am(this);
        this.aem = new an(this);
        this.aen = new ao(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeh = false;
        this.aej = false;
        this.aek = 0;
        this.ael = new am(this);
        this.aem = new an(this);
        this.aen = new ao(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.aee.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, i));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.aef = new UserIconBox(this.mContext);
        this.aeg = new UserIconBox(this.mContext);
        this.aee = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds10), com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds2), 0, 0);
        this.aee.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, u.e.fontsize24));
        if (!this.aej) {
            this.aee.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.aef.setLayoutParams(layoutParams);
        this.aeg.setLayoutParams(layoutParams2);
        this.aee.setLayoutParams(layoutParams3);
        this.aee.setId(u.g.user_name);
        this.aeg.vy();
        addView(this.aef);
        addView(this.aee);
        addView(this.aeg);
    }

    public void setData(az azVar) {
        if (azVar != null && azVar.getAuthor() != null) {
            this.aas = azVar;
            this.aef.setOnClickListener(this.aem);
            this.aeg.setOnClickListener(this.ael);
            this.aee.setOnClickListener(this.aen);
            if (StringUtils.isNull(this.aas.getAuthor().getName_show())) {
                this.aee.setVisibility(8);
            } else {
                this.aee.setVisibility(0);
                String name_show = this.aas.getAuthor().getName_show();
                if (this.aej) {
                    this.aee.setText(com.baidu.tbadk.util.u.I(name_show, 20));
                } else {
                    this.aee.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = azVar.getAuthor().getIconInfo();
            if (this.aeh && com.baidu.tbadk.core.util.y.s(iconInfo) != 0) {
                this.aeg.setVisibility(0);
                this.aeg.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(u.e.ds30), this.mContext.getResources().getDimensionPixelSize(u.e.ds30), this.mContext.getResources().getDimensionPixelSize(u.e.ds10), true);
            } else {
                this.aeg.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = azVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0) {
                this.aef.setVisibility(0);
                this.aef.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(u.e.ds36), this.mContext.getResources().getDimensionPixelSize(u.e.ds36), this.mContext.getResources().getDimensionPixelSize(u.e.ds8), true);
            } else {
                this.aef.setVisibility(8);
            }
            vC();
        }
    }

    private void vC() {
        if (this.aas != null && this.aas.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.y.t(this.aas.getAuthor().getTShowInfoNew())) {
                av.j((View) this.aee, u.d.cp_cont_h);
            } else {
                av.j((View) this.aee, u.d.cp_cont_b);
            }
        }
    }

    public void se() {
        vC();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aei = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aej = z;
    }

    public void setPageName(int i) {
        this.aek = i;
    }
}
