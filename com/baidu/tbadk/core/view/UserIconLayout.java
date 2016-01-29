package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private com.baidu.tbadk.core.data.ah afg;
    private TextView ahH;
    private UserIconBox ahI;
    private UserIconBox ahJ;
    public boolean ahK;
    private View.OnClickListener ahL;
    private View.OnClickListener ahM;
    private View.OnClickListener ahN;
    private View.OnClickListener ahO;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ahK = false;
        this.ahM = new ad(this);
        this.ahN = new ae(this);
        this.ahO = new af(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahK = false;
        this.ahM = new ad(this);
        this.ahN = new ae(this);
        this.ahO = new af(this);
        this.mContext = context;
        init();
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.ahI = new UserIconBox(this.mContext);
        this.ahJ = new UserIconBox(this.mContext);
        this.ahH = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds10), com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds14), 0, 0, 0);
        this.ahH.setTextSize(0, com.baidu.adp.lib.util.k.c(this.mContext, t.e.fontsize28));
        this.ahH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        this.ahI.setLayoutParams(layoutParams);
        this.ahJ.setLayoutParams(layoutParams2);
        this.ahH.setLayoutParams(layoutParams3);
        addView(this.ahI);
        addView(this.ahH);
        addView(this.ahJ);
    }

    public void setData(com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar != null && ahVar.getAuthor() != null) {
            this.afg = ahVar;
            this.ahI.setOnClickListener(this.ahN);
            this.ahJ.setOnClickListener(this.ahM);
            this.ahH.setOnClickListener(this.ahO);
            if (StringUtils.isNull(this.afg.getAuthor().getName_show())) {
                this.ahH.setVisibility(8);
            } else {
                this.ahH.setVisibility(0);
                this.ahH.setText(this.afg.getAuthor().getName_show());
            }
            ArrayList<IconData> iconInfo = ahVar.getAuthor().getIconInfo();
            if (this.ahK && com.baidu.tbadk.core.util.x.o(iconInfo) != 0) {
                this.ahJ.setVisibility(0);
                this.ahJ.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds30), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.ahJ.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.o(tShowInfoNew) != 0) {
                ar.j((View) this.ahH, t.d.cp_cont_h);
                this.ahI.setVisibility(0);
                this.ahI.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.ds36), this.mContext.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                return;
            }
            ar.j((View) this.ahH, t.d.cp_cont_b);
            this.ahI.setVisibility(8);
        }
    }

    public void xk() {
        ar.j((View) this.ahH, t.d.cp_cont_b);
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahL = onClickListener;
    }
}
