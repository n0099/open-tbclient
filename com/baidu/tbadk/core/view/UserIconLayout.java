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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bj ain;
    public TextView amc;
    private View amd;
    private UserIconBox ame;
    private UserIconBox amf;
    private ImageView amg;
    public boolean amh;
    public boolean ami;
    private View.OnClickListener amj;
    private boolean amk;
    private int aml;
    private boolean amm;
    private View.OnClickListener amn;
    private View.OnClickListener amo;
    private View.OnClickListener amp;
    private View.OnClickListener amq;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.amh = false;
        this.ami = false;
        this.amk = false;
        this.aml = 0;
        this.amm = false;
        this.amn = new aq(this);
        this.amo = new ar(this);
        this.amp = new as(this);
        this.amq = new at(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amh = false;
        this.ami = false;
        this.amk = false;
        this.aml = 0;
        this.amm = false;
        this.amn = new aq(this);
        this.amo = new ar(this);
        this.amp = new as(this);
        this.amq = new at(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.amc.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aN(boolean z) {
        this.amm = z;
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
        this.ame = new UserIconBox(this.mContext);
        this.amf = new UserIconBox(this.mContext);
        this.amc = new TextView(this.mContext);
        this.amd = com.baidu.tbadk.ala.c.nD().h(this.mContext, 1);
        if (this.amd != null) {
            this.amd.setVisibility(8);
        }
        this.amg = new ImageView(this.mContext);
        if (this.amg != null) {
            this.amg.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds3), 0, 0);
        this.amc.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        if (!this.amk) {
            this.amc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ame.setLayoutParams(layoutParams);
        this.amf.setLayoutParams(layoutParams2);
        this.amc.setLayoutParams(layoutParams3);
        this.amg.setLayoutParams(layoutParams4);
        this.amf.wV();
        addView(this.ame);
        addView(this.amc);
        if (this.amg != null) {
            addView(this.amg);
        }
        if (this.amd != null) {
            addView(this.amd);
        }
        addView(this.amf);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ain = bjVar;
            this.ame.setOnClickListener(this.amo);
            this.amf.setOnClickListener(this.amn);
            this.amc.setOnClickListener(this.amp);
            this.amg.setOnClickListener(this.amq);
            if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
                if (this.amd != null) {
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.Qx = alaUserData;
                    bVar.type = 1;
                    this.amd.setTag(bVar);
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        this.amd.setVisibility(8);
                    } else {
                        this.amd.setVisibility(0);
                    }
                }
            }
            int i = 3;
            if (this.ain.sU() != null && this.ain.sU().channelId > 0) {
                this.amc.setText(com.baidu.tbadk.util.u.D(this.ain.sU().channelName, 20));
                this.amf.setVisibility(8);
                this.ame.setVisibility(8);
                if (this.ami) {
                    this.amg.setVisibility(0);
                } else {
                    this.amg.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_b);
                return;
            }
            this.amg.setVisibility(8);
            if (StringUtils.isNull(this.ain.getAuthor().getName_show())) {
                this.amc.setVisibility(8);
            } else {
                this.amc.setVisibility(0);
                String name_show = this.ain.getAuthor().getName_show();
                if (this.amk) {
                    if (this.amm) {
                        this.amc.setText(ae(this.ain.getAuthor().getSealPrefix(), com.baidu.tbadk.util.u.D(name_show, 20)));
                        int aK = com.baidu.adp.lib.util.j.aK(name_show);
                        if (aK >= 20) {
                            i = 1;
                        } else if (aK >= 16) {
                            i = 2;
                        }
                    } else {
                        this.amc.setText(com.baidu.tbadk.util.u.D(name_show, 20));
                    }
                } else if (this.amm) {
                    this.amc.setText(ae(this.ain.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.amc.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bjVar.getAuthor().getIconInfo();
            if (this.amh && com.baidu.tbadk.core.util.x.p(iconInfo) != 0) {
                this.amf.setVisibility(0);
                this.amf.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            } else {
                this.amf.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.p(tShowInfoNew) != 0) {
                this.ame.setVisibility(0);
                this.ame.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
            } else {
                this.ame.setVisibility(8);
            }
            setUserTextColor(bjVar);
        }
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a(this.mContext, str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    private void setUserTextColor(bj bjVar) {
        if (this.ain != null && this.ain.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.q(this.ain.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_h);
                if (bjVar.getAuthor() != null && bjVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = bjVar.getAuthor().getAlaUserData();
                    if (this.amd != null) {
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
                            this.ame.setLayoutParams(layoutParams);
                            this.amf.setLayoutParams(layoutParams2);
                            this.amc.setLayoutParams(layoutParams3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_b);
        }
    }

    public void tD() {
        setUserTextColor(this.ain);
        if (this.ain != null && this.ain.sU() != null && this.ain.sU().channelId > 0) {
            com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_b);
        }
        if (this.amg != null) {
            com.baidu.tbadk.core.util.aq.j(this.amg, w.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amj = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.amk = z;
    }

    public void setPageName(int i) {
        this.aml = i;
    }
}
