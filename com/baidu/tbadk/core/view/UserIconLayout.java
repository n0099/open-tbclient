package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bi adW;
    private boolean ahA;
    private int ahB;
    private View.OnClickListener ahC;
    private View.OnClickListener ahD;
    private View.OnClickListener ahE;
    public TextView ahv;
    private UserIconBox ahw;
    private UserIconBox ahx;
    public boolean ahy;
    private View.OnClickListener ahz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ahy = false;
        this.ahA = false;
        this.ahB = 0;
        this.ahC = new al(this);
        this.ahD = new am(this);
        this.ahE = new an(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahy = false;
        this.ahA = false;
        this.ahB = 0;
        this.ahC = new al(this);
        this.ahD = new am(this);
        this.ahE = new an(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ahv.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.ahw = new UserIconBox(this.mContext);
        this.ahx = new UserIconBox(this.mContext);
        this.ahv = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds10), com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2), 0, 0);
        this.ahv.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.fontsize24));
        if (!this.ahA) {
            this.ahv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ahw.setLayoutParams(layoutParams);
        this.ahx.setLayoutParams(layoutParams2);
        this.ahv.setLayoutParams(layoutParams3);
        this.ahv.setId(r.g.user_name);
        this.ahx.wL();
        addView(this.ahw);
        addView(this.ahv);
        addView(this.ahx);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.adW = biVar;
            this.ahw.setOnClickListener(this.ahD);
            this.ahx.setOnClickListener(this.ahC);
            this.ahv.setOnClickListener(this.ahE);
            if (StringUtils.isNull(this.adW.getAuthor().getName_show())) {
                this.ahv.setVisibility(8);
            } else {
                this.ahv.setVisibility(0);
                String name_show = this.adW.getAuthor().getName_show();
                if (this.ahA) {
                    this.ahv.setText(com.baidu.tbadk.util.v.G(name_show, 20));
                } else {
                    this.ahv.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = biVar.getAuthor().getIconInfo();
            if (this.ahy && com.baidu.tbadk.core.util.y.s(iconInfo) != 0) {
                this.ahx.setVisibility(0);
                this.ahx.a(iconInfo, 3, this.mContext.getResources().getDimensionPixelSize(r.e.ds30), this.mContext.getResources().getDimensionPixelSize(r.e.ds30), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            } else {
                this.ahx.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = biVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.y.s(tShowInfoNew) != 0) {
                this.ahw.setVisibility(0);
                this.ahw.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(r.e.ds36), this.mContext.getResources().getDimensionPixelSize(r.e.ds36), this.mContext.getResources().getDimensionPixelSize(r.e.ds8), true);
            } else {
                this.ahw.setVisibility(8);
            }
            wP();
        }
    }

    private void wP() {
        if (this.adW != null && this.adW.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.y.t(this.adW.getAuthor().getTShowInfoNew())) {
                av.j((View) this.ahv, r.d.cp_cont_h);
            } else {
                av.j((View) this.ahv, r.d.cp_cont_b);
            }
        }
    }

    public void tx() {
        wP();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahz = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.ahA = z;
    }

    public void setPageName(int i) {
        this.ahB = i;
    }
}
