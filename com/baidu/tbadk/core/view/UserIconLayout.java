package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bh acX;
    public TextView agJ;
    private View agK;
    private UserIconBox agL;
    private UserIconBox agM;
    public boolean agN;
    private View.OnClickListener agO;
    private boolean agP;
    private int agQ;
    private boolean agR;
    private View.OnClickListener agS;
    private View.OnClickListener agT;
    private View.OnClickListener agU;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.agN = false;
        this.agP = false;
        this.agQ = 0;
        this.agR = false;
        this.agS = new ap(this);
        this.agT = new aq(this);
        this.agU = new ar(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agN = false;
        this.agP = false;
        this.agQ = 0;
        this.agR = false;
        this.agS = new ap(this);
        this.agT = new aq(this);
        this.agU = new ar(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.agJ.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, i));
    }

    public void aO(boolean z) {
        this.agR = z;
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        layoutParams3.gravity = 16;
        this.agL = new UserIconBox(this.mContext);
        this.agM = new UserIconBox(this.mContext);
        this.agJ = new TextView(this.mContext);
        this.agK = com.baidu.tbadk.ala.c.np().f(this.mContext, 1);
        if (this.agK != null) {
            this.agK.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds10), com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds14), -com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds2), 0, 0);
        this.agJ.setTextSize(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.fontsize24));
        if (!this.agP) {
            this.agJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.agL.setLayoutParams(layoutParams);
        this.agM.setLayoutParams(layoutParams2);
        this.agJ.setLayoutParams(layoutParams3);
        this.agM.wy();
        addView(this.agL);
        addView(this.agJ);
        if (this.agK != null) {
            addView(this.agK);
        }
        addView(this.agM);
    }

    public void setData(bh bhVar) {
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.acX = bhVar;
            this.agL.setOnClickListener(this.agT);
            this.agM.setOnClickListener(this.agS);
            this.agJ.setOnClickListener(this.agU);
            if (bhVar.getAuthor() != null && bhVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bhVar.getAuthor().getAlaUserData();
                if (this.agK != null) {
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.Lv = alaUserData;
                    bVar.type = 1;
                    this.agK.setTag(bVar);
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        this.agK.setVisibility(8);
                    } else {
                        this.agK.setVisibility(0);
                    }
                }
            }
            int i = 3;
            if (this.acX.sz() != null && this.acX.sz().channelId > 0) {
                this.agJ.setText(com.baidu.tbadk.util.u.G(this.acX.sz().channelName, 20));
                this.agM.setVisibility(8);
                this.agL.setVisibility(8);
                com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_b);
                return;
            }
            if (StringUtils.isNull(this.acX.getAuthor().getName_show())) {
                this.agJ.setVisibility(8);
            } else {
                this.agJ.setVisibility(0);
                String name_show = this.acX.getAuthor().getName_show();
                if (this.agP) {
                    if (this.agR) {
                        this.agJ.setText(ag(this.acX.getAuthor().getSealPrefix(), com.baidu.tbadk.util.u.G(name_show, 20)));
                        int aQ = com.baidu.adp.lib.util.j.aQ(name_show);
                        if (aQ >= 20) {
                            i = 1;
                        } else if (aQ >= 16) {
                            i = 2;
                        }
                    } else {
                        this.agJ.setText(com.baidu.tbadk.util.u.G(name_show, 20));
                    }
                } else if (this.agR) {
                    this.agJ.setText(ag(this.acX.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.agJ.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bhVar.getAuthor().getIconInfo();
            if (this.agN && com.baidu.tbadk.core.util.w.r(iconInfo) != 0) {
                this.agM.setVisibility(0);
                this.agM.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(r.f.ds30), this.mContext.getResources().getDimensionPixelSize(r.f.ds30), this.mContext.getResources().getDimensionPixelSize(r.f.ds10), true);
            } else {
                this.agM.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.w.r(tShowInfoNew) != 0) {
                this.agL.setVisibility(0);
                this.agL.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(r.f.ds36), this.mContext.getResources().getDimensionPixelSize(r.f.ds36), this.mContext.getResources().getDimensionPixelSize(r.f.ds8), true);
            } else {
                this.agL.setVisibility(8);
            }
            setUserTextColor(bhVar);
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, r.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a(this.mContext, str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bh bhVar) {
        if (this.acX != null && this.acX.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.w.s(this.acX.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_h);
                if (bhVar.getAuthor() != null && bhVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = bhVar.getAuthor().getAlaUserData();
                    if (this.agK != null) {
                        if (alaUserData.anchor_live != 0 || alaUserData.enter_live != 0) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 16;
                            layoutParams2.gravity = 16;
                            layoutParams3.gravity = 16;
                            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds10), com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds4));
                            layoutParams2.setMargins(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds14), -com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds1), 0, 0);
                            layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds2), 0, 0);
                            this.agL.setLayoutParams(layoutParams);
                            this.agM.setLayoutParams(layoutParams2);
                            this.agJ.setLayoutParams(layoutParams3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_b);
        }
    }

    public void tg() {
        setUserTextColor(this.acX);
        if (this.acX != null && this.acX.sz() != null && this.acX.sz().channelId > 0) {
            com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_b);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.agO = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.agP = z;
    }

    public void setPageName(int i) {
        this.agQ = i;
    }
}
