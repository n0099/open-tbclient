package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.w;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class ALALevelView extends LinearLayout {
    private int azE;
    private int azF;
    private TextView azG;
    private TextView azH;
    private TextView azI;
    private TextView azJ;
    private ImageView azK;
    private int azL;
    private int azM;

    public ALALevelView(Context context) {
        super(context);
        this.azE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.azF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.azF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.azF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(w wVar) {
        if (wVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.azL = 0;
        this.azM = 0;
        removeAllViews();
        if (TextUtils.isEmpty(wVar.third_app_id)) {
            setupLevelIcon(wVar.level_id);
            setupOfficialIcon(wVar.is_official == 1);
            setupAdminIcon(wVar.is_live_admin == 1);
            return;
        }
        yQ();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.azL = 0;
        this.azM = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.VC);
            setupAdminIcon(aVar.VD);
            t(aVar.tagName, aVar.VE);
            return;
        }
        yQ();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.azL = 0;
        this.azM = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.azG == null) {
            this.azG = new TextView(getContext());
            this.azG.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.azG.setGravity(49);
            this.azG.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.azG.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.azG.getParent() == null) {
            addView(this.azG, 0);
        }
        this.azG.setText(i + "");
        this.azG.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.azG.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.azG.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.azG.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.azG.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.azG.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.azL++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.azH == null) {
                this.azH = new TextView(getContext());
                this.azH.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.azH.setGravity(17);
                this.azH.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.azH.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.azH.setText(a.i.sdk_official);
            }
            if (this.azH.getParent() == null) {
                addView(this.azH, f(false, false));
                this.azL++;
            }
        } else if (this.azH != null && this.azH.getParent() != null) {
            ((ViewGroup) this.azH.getParent()).removeView(this.azH);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.azI == null) {
                this.azI = new TextView(getContext());
                this.azI.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.azI.setGravity(17);
                this.azI.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.azI.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.azI.setText(a.i.sdk_admin);
            }
            if (this.azI.getParent() == null) {
                addView(this.azI, f(false, false));
                this.azL++;
            }
        } else if (this.azI != null && this.azI.getParent() != null) {
            ((ViewGroup) this.azI.getParent()).removeView(this.azI);
        }
    }

    private void t(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.azJ == null) {
                this.azJ = new TextView(getContext());
                this.azJ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.azJ.setGravity(17);
                this.azJ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.azJ != null && this.azJ.getParent() != null) {
                        this.azJ.setBackgroundDrawable(null);
                        ((ViewGroup) this.azJ.getParent()).removeView(this.azJ);
                        return;
                    }
                    return;
            }
            if (this.azJ.getParent() == null) {
                this.azJ.setText(str);
                this.azJ.setBackgroundResource(i2);
                this.azJ.setPadding(this.azF, 0, this.azF, 6);
                addView(this.azJ, f(false, true));
                this.azM = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams f(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.azE, this.azE);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void yQ() {
        if (this.azK == null) {
            this.azK = new ImageView(getContext());
            this.azK.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.azK.getParent() == null) {
            addView(this.azK, f(true, false));
            this.azL++;
        }
    }

    public void d(int i, float f) {
        this.azG.setTextColor(getResources().getColor(i));
        this.azG.setAlpha(f);
    }

    public int getIconCount() {
        return this.azL;
    }

    public int getUserTypeTxtCount() {
        return this.azM;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.azG != null) {
            this.azG.setPadding(i, i2, i3, i4);
        }
    }
}
