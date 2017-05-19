package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bk ahV;
    public TextView amB;
    private View amC;
    private ImageView amD;
    public boolean amE;
    public boolean amF;
    private boolean amG;
    private int amH;
    private boolean amI;
    private View.OnClickListener amJ;
    private View.OnClickListener amk;
    private View.OnClickListener aml;
    private UserIconBox amq;
    private UserIconBox amr;
    private View.OnClickListener ams;
    private View.OnClickListener amt;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.amE = false;
        this.amF = false;
        this.amG = false;
        this.amH = 0;
        this.amI = false;
        this.amt = new ax(this);
        this.ams = new ay(this);
        this.aml = new az(this);
        this.amJ = new ba(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amE = false;
        this.amF = false;
        this.amG = false;
        this.amH = 0;
        this.amI = false;
        this.amt = new ax(this);
        this.ams = new ay(this);
        this.aml = new az(this);
        this.amJ = new ba(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.amB.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aP(boolean z) {
        this.amI = z;
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams2.gravity = 16;
        layoutParams3.gravity = 16;
        layoutParams4.gravity = 16;
        this.amq = new UserIconBox(this.mContext);
        this.amr = new UserIconBox(this.mContext);
        this.amB = new TextView(this.mContext);
        this.amC = com.baidu.tbadk.ala.c.nH().h(this.mContext, 1);
        if (this.amC != null) {
            this.amC.setVisibility(8);
        }
        this.amD = new ImageView(this.mContext);
        if (this.amD != null) {
            this.amD.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds3), 0, 0);
        this.amB.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        if (!this.amG) {
            this.amB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.amq.setLayoutParams(layoutParams);
        this.amr.setLayoutParams(layoutParams2);
        this.amB.setLayoutParams(layoutParams3);
        this.amD.setLayoutParams(layoutParams4);
        addView(this.amq);
        addView(this.amB);
        if (this.amD != null) {
            addView(this.amD);
        }
        if (this.amC != null) {
            addView(this.amC);
        }
        addView(this.amr);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.getAuthor() != null) {
            this.ahV = bkVar;
            this.amq.setOnClickListener(this.ams);
            this.amr.setOnClickListener(this.amt);
            this.amB.setOnClickListener(this.aml);
            this.amD.setOnClickListener(this.amJ);
            if (bkVar.getAuthor() != null && bkVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bkVar.getAuthor().getAlaUserData();
                if (this.amC != null) {
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.Qj = alaUserData;
                    bVar.type = 1;
                    this.amC.setTag(bVar);
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        this.amC.setVisibility(8);
                    } else {
                        this.amC.setVisibility(0);
                    }
                }
            }
            int i = 3;
            if (this.ahV.sC() != null && this.ahV.sC().channelId > 0) {
                this.amB.setText(com.baidu.tbadk.util.x.u(this.ahV.sC().channelName, 20));
                this.amr.setVisibility(8);
                this.amq.setVisibility(8);
                if (this.amF) {
                    this.amD.setVisibility(0);
                } else {
                    this.amD.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.i(this.amB, w.e.cp_cont_b);
                return;
            }
            this.amD.setVisibility(8);
            if (StringUtils.isNull(this.ahV.getAuthor().getName_show())) {
                this.amB.setVisibility(8);
            } else {
                this.amB.setVisibility(0);
                String name_show = this.ahV.getAuthor().getName_show();
                if (this.amG) {
                    if (this.amI) {
                        this.amB.setText(af(this.ahV.getAuthor().getSealPrefix(), com.baidu.tbadk.util.x.u(name_show, 20)));
                        int aF = com.baidu.adp.lib.util.j.aF(name_show);
                        if (aF >= 20) {
                            i = 1;
                        } else if (aF >= 16) {
                            i = 2;
                        }
                    } else {
                        this.amB.setText(com.baidu.tbadk.util.x.u(name_show, 20));
                    }
                } else if (this.amI) {
                    this.amB.setText(af(this.ahV.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.amB.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bkVar.getAuthor().getIconInfo();
            if (this.amE && com.baidu.tbadk.core.util.x.q(iconInfo) != 0) {
                this.amr.setVisibility(0);
                this.amr.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            } else {
                this.amr.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bkVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.q(tShowInfoNew) != 0) {
                this.amq.setVisibility(0);
                this.amq.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
            } else {
                this.amq.setVisibility(8);
            }
            setUserTextColor(bkVar);
        }
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new ap.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.ap.a(this.mContext, str2, (ArrayList<ap.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bk bkVar) {
        if (this.ahV != null && this.ahV.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.r(this.ahV.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.aq.i(this.amB, w.e.cp_cont_h);
                if (bkVar.getAuthor() != null && bkVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = bkVar.getAuthor().getAlaUserData();
                    if (this.amC != null) {
                        if (alaUserData.anchor_live != 0 || alaUserData.enter_live != 0) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 16;
                            layoutParams2.gravity = 16;
                            layoutParams3.gravity = 16;
                            layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
                            layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
                            layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
                            this.amq.setLayoutParams(layoutParams);
                            this.amr.setLayoutParams(layoutParams2);
                            this.amB.setLayoutParams(layoutParams3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq.i(this.amB, w.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ahV);
        if (this.ahV != null && this.ahV.sC() != null && this.ahV.sC().channelId > 0) {
            com.baidu.tbadk.core.util.aq.i(this.amB, w.e.cp_cont_b);
        }
        if (this.amD != null) {
            com.baidu.tbadk.core.util.aq.j(this.amD, w.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amk = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.amG = z;
    }

    public void setPageName(int i) {
        this.amH = i;
    }
}
