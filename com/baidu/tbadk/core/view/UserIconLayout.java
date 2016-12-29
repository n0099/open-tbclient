package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bg adN;
    private View.OnClickListener ahA;
    private boolean ahB;
    private int ahC;
    private boolean ahD;
    private View.OnClickListener ahE;
    private View.OnClickListener ahF;
    private View.OnClickListener ahG;
    public TextView ahw;
    private UserIconBox ahx;
    private UserIconBox ahy;
    public boolean ahz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.ahz = false;
        this.ahB = false;
        this.ahC = 0;
        this.ahD = false;
        this.ahE = new ao(this);
        this.ahF = new ap(this);
        this.ahG = new aq(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahz = false;
        this.ahB = false;
        this.ahC = 0;
        this.ahD = false;
        this.ahE = new ao(this);
        this.ahF = new ap(this);
        this.ahG = new aq(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.ahw.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public void aO(boolean z) {
        this.ahD = z;
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        this.ahx = new UserIconBox(this.mContext);
        this.ahy = new UserIconBox(this.mContext);
        this.ahw = new TextView(this.mContext);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds10), com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds14), 0, 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2), 0, 0);
        this.ahw.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.fontsize24));
        if (!this.ahB) {
            this.ahw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ahx.setLayoutParams(layoutParams);
        this.ahy.setLayoutParams(layoutParams2);
        this.ahw.setLayoutParams(layoutParams3);
        this.ahy.wD();
        addView(this.ahx);
        addView(this.ahw);
        addView(this.ahy);
    }

    public void setData(bg bgVar) {
        if (bgVar != null && bgVar.getAuthor() != null) {
            this.adN = bgVar;
            this.ahx.setOnClickListener(this.ahF);
            this.ahy.setOnClickListener(this.ahE);
            this.ahw.setOnClickListener(this.ahG);
            int i = 3;
            if (StringUtils.isNull(this.adN.getAuthor().getName_show())) {
                this.ahw.setVisibility(8);
            } else {
                this.ahw.setVisibility(0);
                String name_show = this.adN.getAuthor().getName_show();
                if (this.ahB) {
                    if (this.ahD) {
                        this.ahw.setText(ag(this.adN.getAuthor().getSealPrefix(), com.baidu.tbadk.util.u.G(name_show, 20)));
                        int aR = com.baidu.adp.lib.util.j.aR(name_show);
                        if (aR >= 20) {
                            i = 1;
                        } else if (aR >= 16) {
                            i = 2;
                        }
                    } else {
                        this.ahw.setText(com.baidu.tbadk.util.u.G(name_show, 20));
                    }
                } else if (this.ahD) {
                    this.ahw.setText(ag(this.adN.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.ahw.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bgVar.getAuthor().getIconInfo();
            if (this.ahz && com.baidu.tbadk.core.util.x.s(iconInfo) != 0) {
                this.ahy.setVisibility(0);
                this.ahy.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(r.e.ds24), this.mContext.getResources().getDimensionPixelSize(r.e.ds24), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            } else {
                this.ahy.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bgVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.s(tShowInfoNew) != 0) {
                this.ahx.setVisibility(0);
                this.ahx.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(r.e.ds36), this.mContext.getResources().getDimensionPixelSize(r.e.ds36), this.mContext.getResources().getDimensionPixelSize(r.e.ds8), true);
            } else {
                this.ahx.setVisibility(8);
            }
            wG();
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str, r.f.pic_smalldot_title));
            return com.baidu.tieba.card.ap.a(this.mContext, str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void wG() {
        if (this.adN != null && this.adN.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.t(this.adN.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.ar.j((View) this.ahw, r.d.cp_cont_h);
            } else {
                com.baidu.tbadk.core.util.ar.j((View) this.ahw, r.d.cp_cont_c);
            }
        }
    }

    public void tm() {
        wG();
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ahA = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.ahB = z;
    }

    public void setPageName(int i) {
        this.ahC = i;
    }
}
