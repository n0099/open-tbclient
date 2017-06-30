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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserIconLayout extends LinearLayout {
    private bm aiu;
    private View.OnClickListener amS;
    private View.OnClickListener amT;
    private boolean anA;
    private int anB;
    private boolean anC;
    private View.OnClickListener anD;
    private UserIconBox ani;
    private UserIconBox anj;
    private View anl;
    private View.OnClickListener ann;
    private View.OnClickListener ano;
    public TextView anw;
    private ImageView anx;
    public boolean any;
    public boolean anz;
    private Context mContext;

    public UserIconLayout(Context context) {
        super(context);
        this.any = false;
        this.anz = false;
        this.anA = false;
        this.anB = 0;
        this.anC = false;
        this.ano = new ay(this);
        this.ann = new az(this);
        this.amT = new ba(this);
        this.anD = new bb(this);
        this.mContext = context;
        init();
    }

    public UserIconLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.any = false;
        this.anz = false;
        this.anA = false;
        this.anB = 0;
        this.anC = false;
        this.ano = new ay(this);
        this.ann = new az(this);
        this.amT = new ba(this);
        this.anD = new bb(this);
        this.mContext = context;
        init();
    }

    public void setUserNameTextSizeRid(int i) {
        this.anw.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, i));
    }

    public void aO(boolean z) {
        this.anC = z;
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
        this.ani = new UserIconBox(this.mContext);
        this.anj = new UserIconBox(this.mContext);
        this.anw = new TextView(this.mContext);
        this.anl = com.baidu.tbadk.ala.b.nv().h(this.mContext, 1);
        if (this.anl != null) {
            this.anl.setVisibility(8);
        }
        this.anx = new ImageView(this.mContext);
        if (this.anx != null) {
            this.anx.setVisibility(8);
        }
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
        layoutParams4.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds8), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds3), 0, 0);
        this.anw.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.fontsize24));
        if (!this.anA) {
            this.anw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
        }
        this.ani.setLayoutParams(layoutParams);
        this.anj.setLayoutParams(layoutParams2);
        this.anw.setLayoutParams(layoutParams3);
        this.anx.setLayoutParams(layoutParams4);
        addView(this.ani);
        addView(this.anw);
        if (this.anx != null) {
            addView(this.anx);
        }
        if (this.anl != null) {
            addView(this.anl);
        }
        addView(this.anj);
    }

    public void setData(bm bmVar) {
        if (bmVar != null && bmVar.getAuthor() != null) {
            this.aiu = bmVar;
            this.ani.setOnClickListener(this.ann);
            this.anj.setOnClickListener(this.ano);
            this.anw.setOnClickListener(this.amT);
            this.anx.setOnClickListener(this.anD);
            if (bmVar.getAuthor() != null && bmVar.getAuthor().getAlaUserData() != null) {
                AlaUserInfoData alaUserData = bmVar.getAuthor().getAlaUserData();
                if (this.anl != null) {
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.PQ = alaUserData;
                    aVar.type = 1;
                    this.anl.setTag(aVar);
                    if (alaUserData.anchor_live == 0) {
                        this.anl.setVisibility(8);
                    } else {
                        this.anl.setVisibility(0);
                    }
                }
            }
            int i = 3;
            if (this.aiu.sv() != null && this.aiu.sv().channelId > 0) {
                this.anw.setText(com.baidu.tbadk.util.y.t(this.aiu.sv().channelName, 20));
                this.anj.setVisibility(8);
                this.ani.setVisibility(8);
                if (this.anz) {
                    this.anx.setVisibility(0);
                } else {
                    this.anx.setVisibility(8);
                }
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_b);
                return;
            }
            this.anx.setVisibility(8);
            if (StringUtils.isNull(this.aiu.getAuthor().getName_show())) {
                this.anw.setVisibility(8);
            } else {
                this.anw.setVisibility(0);
                String name_show = this.aiu.getAuthor().getName_show();
                if (this.anA) {
                    if (this.anC) {
                        this.anw.setText(ae(this.aiu.getAuthor().getSealPrefix(), com.baidu.tbadk.util.y.t(name_show, 20)));
                        int aK = com.baidu.adp.lib.util.j.aK(name_show);
                        if (aK >= 20) {
                            i = 1;
                        } else if (aK >= 16) {
                            i = 2;
                        }
                    } else {
                        this.anw.setText(com.baidu.tbadk.util.y.t(name_show, 20));
                    }
                } else if (this.anC) {
                    this.anw.setText(ae(this.aiu.getAuthor().getSealPrefix(), name_show));
                } else {
                    this.anw.setText(name_show);
                }
            }
            ArrayList<IconData> iconInfo = bmVar.getAuthor().getIconInfo();
            if (this.any && com.baidu.tbadk.core.util.z.s(iconInfo) != 0) {
                this.anj.setVisibility(0);
                this.anj.a(iconInfo, i, this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds30), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            } else {
                this.anj.setVisibility(8);
            }
            ArrayList<IconData> tShowInfoNew = bmVar.getAuthor().getTShowInfoNew();
            if (com.baidu.tbadk.core.util.z.s(tShowInfoNew) != 0) {
                this.ani.setVisibility(0);
                this.ani.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds36), this.mContext.getResources().getDimensionPixelSize(w.f.ds8), true);
            } else {
                this.ani.setVisibility(8);
            }
            setUserTextColor(bmVar);
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

    private void setUserTextColor(bm bmVar) {
        if (this.aiu != null && this.aiu.getAuthor() != null) {
            if (!com.baidu.tbadk.core.util.z.t(this.aiu.getAuthor().getTShowInfoNew()) || this.aiu.getAuthor().isBigV()) {
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_h);
                if (bmVar.getAuthor() != null && bmVar.getAuthor().getAlaUserData() != null) {
                    AlaUserInfoData alaUserData = bmVar.getAuthor().getAlaUserData();
                    if (this.anl != null && alaUserData.anchor_live != 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        layoutParams2.gravity = 16;
                        layoutParams3.gravity = 16;
                        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds10), com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds4));
                        layoutParams2.setMargins(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), -com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds1), 0, 0);
                        layoutParams3.setMargins(0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2), 0, 0);
                        this.ani.setLayoutParams(layoutParams);
                        this.anj.setLayoutParams(layoutParams2);
                        this.anw.setLayoutParams(layoutParams3);
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_b);
        }
    }

    public void onChangeSkinType() {
        setUserTextColor(this.aiu);
        if (this.aiu != null && this.aiu.sv() != null && this.aiu.sv().channelId > 0) {
            com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_b);
        }
        if (this.anx != null) {
            com.baidu.tbadk.core.util.as.j(this.anx, w.g.icon_weiba);
        }
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.amS = onClickListener;
    }

    public void setEntelechyEnabled(boolean z) {
        this.anA = z;
    }

    public void setPageName(int i) {
        this.anB = i;
    }
}
