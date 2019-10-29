package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.s;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class ALALevelView extends LinearLayout {
    private int arA;
    private int arB;
    private TextView arC;
    private TextView arD;
    private TextView arE;
    private TextView arF;
    private ImageView arG;
    private int arH;
    private int arI;

    public ALALevelView(Context context) {
        super(context);
        this.arA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.arB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.arB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.arB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(s sVar) {
        if (sVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.arH = 0;
        this.arI = 0;
        removeAllViews();
        if (TextUtils.isEmpty(sVar.third_app_id)) {
            setupLevelIcon(sVar.level_id);
            setupOfficialIcon(sVar.is_official == 1);
            setupAdminIcon(sVar.is_live_admin == 1);
            return;
        }
        ww();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.arH = 0;
        this.arI = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.OO);
            setupAdminIcon(aVar.OP);
            p(aVar.tagName, aVar.OQ);
            return;
        }
        ww();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.arH = 0;
        this.arI = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.arC == null) {
            this.arC = new TextView(getContext());
            this.arC.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.arC.setGravity(49);
            this.arC.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.arC.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.arC.getParent() == null) {
            addView(this.arC, 0);
        }
        this.arC.setText(i + "");
        this.arC.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.arC.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.arC.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.arC.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.arC.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.arC.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.arH++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.arD == null) {
                this.arD = new TextView(getContext());
                this.arD.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.arD.setGravity(17);
                this.arD.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.arD.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.arD.setText(a.i.sdk_official);
            }
            if (this.arD.getParent() == null) {
                addView(this.arD, g(false, false));
                this.arH++;
            }
        } else if (this.arD != null && this.arD.getParent() != null) {
            ((ViewGroup) this.arD.getParent()).removeView(this.arD);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.arE == null) {
                this.arE = new TextView(getContext());
                this.arE.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.arE.setGravity(17);
                this.arE.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.arE.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.arE.setText(a.i.sdk_admin);
            }
            if (this.arE.getParent() == null) {
                addView(this.arE, g(false, false));
                this.arH++;
            }
        } else if (this.arE != null && this.arE.getParent() != null) {
            ((ViewGroup) this.arE.getParent()).removeView(this.arE);
        }
    }

    private void p(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.arF == null) {
                this.arF = new TextView(getContext());
                this.arF.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.arF.setGravity(17);
                this.arF.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            }
            switch (i) {
                case 1:
                    i2 = a.f.sdk_bg_ala_user_type_1;
                    break;
                case 2:
                    i2 = a.f.sdk_bg_ala_user_type_2;
                    break;
                case 3:
                    i2 = a.f.sdk_bg_ala_user_type_3;
                    break;
                default:
                    if (this.arF != null && this.arF.getParent() != null) {
                        this.arF.setBackgroundDrawable(null);
                        ((ViewGroup) this.arF.getParent()).removeView(this.arF);
                        return;
                    }
                    return;
            }
            if (this.arF.getParent() == null) {
                this.arF.setText(str);
                this.arF.setBackgroundResource(i2);
                this.arF.setPadding(this.arB, 0, this.arB, 6);
                addView(this.arF, g(false, true));
                this.arI = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams g(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.arA, this.arA);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void ww() {
        if (this.arG == null) {
            this.arG = new ImageView(getContext());
            this.arG.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.arG.getParent() == null) {
            addView(this.arG, g(true, false));
            this.arH++;
        }
    }

    public void d(int i, float f) {
        this.arC.setTextColor(getResources().getColor(i));
        this.arC.setAlpha(f);
    }

    public int getIconCount() {
        return this.arH;
    }

    public int getUserTypeTxtCount() {
        return this.arI;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.arC != null) {
            this.arC.setPadding(i, i2, i3, i4);
        }
    }
}
