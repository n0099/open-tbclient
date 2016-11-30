package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.an;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bk aeu;
    public TextView ahV;
    private UserIconBox ahW;
    private UserIconBox ahX;
    public boolean ahY;
    private View.OnClickListener ahZ;
    private boolean aia;
    private int aib;
    private boolean aic;
    private View.OnClickListener aid;
    private View.OnClickListener aie;
    private View.OnClickListener aif;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ahY = false;
        this.aia = false;
        this.aib = 0;
        this.aic = false;
        this.aid = new am(this);
        this.aie = new an(this);
        this.aif = new ao(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahY = false;
        this.aia = false;
        this.aib = 0;
        this.aic = false;
        this.aid = new am(this);
        this.aie = new an(this);
        this.aif = new ao(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ahV.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public void aN(boolean z) {
        this.aic = z;
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.ahW = new UserIconBox(this.mContext);
        this.ahX = new UserIconBox(this.mContext);
        this.ahV = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds10), com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2), 0, 0);
        this.ahV.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.fontsize24));
        if (!this.aia) {
            this.ahV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ahW.setLayoutParams(layoutParams);
        this.ahX.setLayoutParams(layoutParams2);
        this.ahV.setLayoutParams(layoutParams3);
        this.ahX.wQ();
        addView(this.ahW);
        addView(this.ahV);
        addView(this.ahX);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.getAuthor() != null) {
            this.aeu = bkVar;
            this.ahW.setOnClickListener(this.aie);
            this.ahX.setOnClickListener(this.aid);
            this.ahV.setOnClickListener(this.aif);
            int i = 3;
            if (StringUtils.isNull(this.aeu.getAuthor().getName_show())) {
                this.ahV.setVisibility(8);
            } else {
                this.ahV.setVisibility(0);
                String name_show = this.aeu.getAuthor().getName_show();
                if (this.aia) {
                    if (this.aic) {
                        this.ahV.setText(ag(this.aeu.getAuthor().getSealPrefix(), com.baidu.tbadk.util.u.G(name_show, 20)));
                        int aR = com.baidu.adp.lib.util.j.aR(name_show);
                        if (aR >= 20) {
                            i = 1;
                        } else if (aR >= 16) {
                            i = 2;
                        }
                    } else {
                        this.ahV.setText(com.baidu.tbadk.util.u.G(name_show, 20));
                    }
                } else if (this.aic) {
                    this.ahV.setText(ag(this.aeu.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.ahV.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bkVar.getAuthor().getIconInfo();
            if (this.ahY && com.baidu.tbadk.core.util.x.s(iconInfo) != 0) {
                this.ahX.setVisibility(0);
                this.ahX.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(r.e.ds24), this.mContext.getResources().getDimensionPixelSize(r.e.ds24), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            } else {
                this.ahX.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bkVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.s(tShowInfoNew) != 0) {
                this.ahW.setVisibility(0);
                this.ahW.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(r.e.ds36), this.mContext.getResources().getDimensionPixelSize(r.e.ds36), this.mContext.getResources().getDimensionPixelSize(r.e.ds8), true);
            } else {
                this.ahW.setVisibility(8);
            }
            wT();
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new an.a(str, r.f.pic_smalldot_title));
            return com.baidu.tieba.card.an.a(this.mContext, str2, (ArrayList<an.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void wT() {
        if (this.aeu != null && this.aeu.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.t(this.aeu.getAuthor().getTShowInfoNew())) {
                at.j((View) this.ahV, r.d.cp_cont_h);
            } else {
                at.j((View) this.ahV, r.d.cp_cont_c);
            }
        }
    }

    public void tB() {
        wT();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahZ = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.aia = z;
    }

    public void setPageName(int i) {
        this.aib = i;
    }
}
