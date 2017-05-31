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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bl ahM;
    public boolean amA;
    public boolean amB;
    private boolean amC;
    private int amD;
    private boolean amE;
    private View.OnClickListener amF;
    private View.OnClickListener ama;
    private View.OnClickListener amb;
    private UserIconBox amk;
    private UserIconBox aml;
    private View amn;
    private View.OnClickListener amp;
    private View.OnClickListener amq;
    public TextView amy;
    private ImageView amz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.amA = false;
        this.amB = false;
        this.amC = false;
        this.amD = 0;
        this.amE = false;
        this.amq = new ax(this);
        this.amp = new ay(this);
        this.amb = new az(this);
        this.amF = new ba(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amA = false;
        this.amB = false;
        this.amC = false;
        this.amD = 0;
        this.amE = false;
        this.amq = new ax(this);
        this.amp = new ay(this);
        this.amb = new az(this);
        this.amF = new ba(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.amy.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aN(boolean z) {
        this.amE = z;
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
        this.amk = new UserIconBox(this.mContext);
        this.aml = new UserIconBox(this.mContext);
        this.amy = new TextView(this.mContext);
        this.amn = com.baidu.tbadk.ala.b.nz().h(this.mContext, 1);
        if (this.amn != null) {
            this.amn.setVisibility(8);
        }
        this.amz = new ImageView(this.mContext);
        if (this.amz != null) {
            this.amz.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds3), 0, 0);
        this.amy.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        if (!this.amC) {
            this.amy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.amk.setLayoutParams(layoutParams);
        this.aml.setLayoutParams(layoutParams2);
        this.amy.setLayoutParams(layoutParams3);
        this.amz.setLayoutParams(layoutParams4);
        addView(this.amk);
        addView(this.amy);
        if (this.amz != null) {
            addView(this.amz);
        }
        if (this.amn != null) {
            addView(this.amn);
        }
        addView(this.aml);
    }

    public void setData(bl blVar) {
        if (blVar != null && blVar.getAuthor() != null) {
            this.ahM = blVar;
            this.amk.setOnClickListener(this.amp);
            this.aml.setOnClickListener(this.amq);
            this.amy.setOnClickListener(this.amb);
            this.amz.setOnClickListener(this.amF);
            if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                if (this.amn != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.PW = alaUserData;
                    aVar.type = 1;
                    this.amn.setTag(aVar);
                    if (alaUserData.anchor_live == 0 && alaUserData.enter_live == 0) {
                        this.amn.setVisibility(8);
                    } else {
                        this.amn.setVisibility(0);
                    }
                }
            }
            int i = 3;
            if (this.ahM.sx() != null && this.ahM.sx().channelId > 0) {
                this.amy.setText(com.baidu.tbadk.util.x.t(this.ahM.sx().channelName, 20));
                this.aml.setVisibility(8);
                this.amk.setVisibility(8);
                if (this.amB) {
                    this.amz.setVisibility(0);
                } else {
                    this.amz.setVisibility(8);
                }
                com.baidu.tbadk.core.util.aq.i(this.amy, w.e.cp_cont_b);
                return;
            }
            this.amz.setVisibility(8);
            if (StringUtils.isNull(this.ahM.getAuthor().getName_show())) {
                this.amy.setVisibility(8);
            } else {
                this.amy.setVisibility(0);
                String name_show = this.ahM.getAuthor().getName_show();
                if (this.amC) {
                    if (this.amE) {
                        this.amy.setText(ae(this.ahM.getAuthor().getSealPrefix(), com.baidu.tbadk.util.x.t(name_show, 20)));
                        int aF = com.baidu.adp.lib.util.j.aF(name_show);
                        if (aF >= 20) {
                            i = 1;
                        } else if (aF >= 16) {
                            i = 2;
                        }
                    } else {
                        this.amy.setText(com.baidu.tbadk.util.x.t(name_show, 20));
                    }
                } else if (this.amE) {
                    this.amy.setText(ae(this.ahM.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.amy.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = blVar.getAuthor().getIconInfo();
            if (this.amA && com.baidu.tbadk.core.util.x.q(iconInfo) != 0) {
                this.aml.setVisibility(0);
                this.aml.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            } else {
                this.aml.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.x.q(tShowInfoNew) != 0) {
                this.amk.setVisibility(0);
                this.amk.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
            } else {
                this.amk.setVisibility(8);
            }
            setUserTextColor(blVar);
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

    private void setUserTextColor(bl blVar) {
        if (this.ahM != null && this.ahM.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.x.r(this.ahM.getAuthor().getTShowInfoNew())) {
                com.baidu.tbadk.core.util.aq.i(this.amy, w.e.cp_cont_h);
                if (blVar.getAuthor() != null && blVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = blVar.getAuthor().getAlaUserData();
                    if (this.amn != null) {
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
                            this.amk.setLayoutParams(layoutParams);
                            this.aml.setLayoutParams(layoutParams2);
                            this.amy.setLayoutParams(layoutParams3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq.i(this.amy, w.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.ahM);
        if (this.ahM != null && this.ahM.sx() != null && this.ahM.sx().channelId > 0) {
            com.baidu.tbadk.core.util.aq.i(this.amy, w.e.cp_cont_b);
        }
        if (this.amz != null) {
            com.baidu.tbadk.core.util.aq.j(this.amz, w.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.ama = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.amC = z;
    }

    public void setPageName(int i) {
        this.amD = i;
    }
}
