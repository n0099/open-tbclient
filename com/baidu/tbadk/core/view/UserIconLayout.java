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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bi aiB;
    private boolean amA;
    private View.OnClickListener amB;
    private View.OnClickListener amC;
    private View.OnClickListener amD;
    private View.OnClickListener amE;
    public TextView amq;
    private View amr;
    private UserIconBox ams;
    private UserIconBox amt;
    private ImageView amu;
    public boolean amv;
    public boolean amw;
    private View.OnClickListener amx;
    private boolean amy;
    private int amz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.amv = false;
        this.amw = false;
        this.amy = false;
        this.amz = 0;
        this.amA = false;
        this.amB = new aq(this);
        this.amC = new ar(this);
        this.amD = new as(this);
        this.amE = new at(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amv = false;
        this.amw = false;
        this.amy = false;
        this.amz = 0;
        this.amA = false;
        this.amB = new aq(this);
        this.amC = new ar(this);
        this.amD = new as(this);
        this.amE = new at(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.amq.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aP(boolean z) {
        this.amA = z;
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
        this.ams = new UserIconBox(this.mContext);
        this.amt = new UserIconBox(this.mContext);
        this.amq = new TextView(this.mContext);
        this.amr = com.baidu.tbadk.ala.c.oa().h(this.mContext, 1);
        if (this.amr != null) {
            this.amr.setVisibility(8);
        }
        this.amu = new ImageView(this.mContext);
        if (this.amu != null) {
            this.amu.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds3), 0, 0);
        this.amq.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        if (!this.amy) {
            this.amq.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ams.setLayoutParams(layoutParams);
        this.amt.setLayoutParams(layoutParams2);
        this.amq.setLayoutParams(layoutParams3);
        this.amu.setLayoutParams(layoutParams4);
        this.amt.xr();
        addView(this.ams);
        addView(this.amq);
        if (this.amu != null) {
            addView(this.amu);
        }
        if (this.amr != null) {
            addView(this.amr);
        }
        addView(this.amt);
    }

    public void setData(bi biVar) {
        if (biVar != null && biVar.getAuthor() != null) {
            this.aiB = biVar;
            this.ams.setOnClickListener(this.amC);
            this.amt.setOnClickListener(this.amB);
            this.amq.setOnClickListener(this.amD);
            this.amu.setOnClickListener(this.amE);
            if (biVar.getAuthor() != null && biVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = biVar.getAuthor().getAlaUserData();
                if (this.amr != null) {
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.QP = alaUserData;
                    bVar.type = 1;
                    this.amr.setTag(bVar);
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        this.amr.setVisibility(8);
                    } else {
                        this.amr.setVisibility(0);
                    }
                }
            }
            int i = 3;
            if (this.aiB.ts() != null && this.aiB.ts().channelId > 0) {
                this.amq.setText(com.baidu.tbadk.util.u.D(this.aiB.ts().channelName, 20));
                this.amt.setVisibility(8);
                this.ams.setVisibility(8);
                if (this.amw) {
                    this.amu.setVisibility(0);
                } else {
                    this.amu.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_b);
                return;
            }
            this.amu.setVisibility(8);
            if (StringUtils.isNull(this.aiB.getAuthor().getName_show())) {
                this.amq.setVisibility(8);
            } else {
                this.amq.setVisibility(0);
                String name_show = this.aiB.getAuthor().getName_show();
                if (this.amy) {
                    if (this.amA) {
                        this.amq.setText(af(this.aiB.getAuthor().getSealPrefix(), com.baidu.tbadk.util.u.D(name_show, 20)));
                        int aF = com.baidu.adp.lib.util.j.aF(name_show);
                        if (aF >= 20) {
                            i = 1;
                        } else if (aF >= 16) {
                            i = 2;
                        }
                    } else {
                        this.amq.setText(com.baidu.tbadk.util.u.D(name_show, 20));
                    }
                } else if (this.amA) {
                    this.amq.setText(af(this.aiB.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.amq.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = biVar.getAuthor().getIconInfo();
            if (this.amv && com.baidu.tbadk.core.util.x.p(iconInfo) != 0) {
                this.amt.setVisibility(0);
                this.amt.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            } else {
                this.amt.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = biVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.p(tShowInfoNew) != 0) {
                this.ams.setVisibility(0);
                this.ams.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
            } else {
                this.ams.setVisibility(8);
            }
            setUserTextColor(biVar);
        }
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a(this.mContext, str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bi biVar) {
        if (this.aiB != null && this.aiB.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.q(this.aiB.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_h);
                if (biVar.getAuthor() != null && biVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = biVar.getAuthor().getAlaUserData();
                    if (this.amr != null) {
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
                            this.ams.setLayoutParams(layoutParams);
                            this.amt.setLayoutParams(layoutParams2);
                            this.amq.setLayoutParams(layoutParams3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aiB);
        if (this.aiB != null && this.aiB.ts() != null && this.aiB.ts().channelId > 0) {
            com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_b);
        }
        if (this.amu != null) {
            com.baidu.tbadk.core.util.aq.j(this.amu, w.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amx = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.amy = z;
    }

    public void setPageName(int i) {
        this.amz = i;
    }
}
