package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ALALevelView extends LinearLayout {
    private int aDU;
    private int aDV;
    private TextView aDW;
    private TextView aDX;
    private TextView aDY;
    private TextView aDZ;
    private ImageView aEa;
    private int aEb;
    private int aEc;

    public ALALevelView(Context context) {
        super(context);
        this.aDU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aDV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aDV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aDV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(x xVar) {
        if (xVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aEb = 0;
        this.aEc = 0;
        removeAllViews();
        if (TextUtils.isEmpty(xVar.third_app_id)) {
            setupLevelIcon(xVar.level_id);
            setupOfficialIcon(xVar.is_official == 1);
            setupAdminIcon(xVar.is_live_admin == 1);
            return;
        }
        Bg();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.aEb = 0;
        this.aEc = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.Xi);
            setupAdminIcon(aVar.Xj);
            t(aVar.tagName, aVar.Xk);
            return;
        }
        Bg();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aEb = 0;
        this.aEc = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.aDW == null) {
            this.aDW = new TextView(getContext());
            this.aDW.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.aDW.setGravity(49);
            this.aDW.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.aDW.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.aDW.getParent() == null) {
            addView(this.aDW, 0);
        }
        this.aDW.setText(i + "");
        this.aDW.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.aDW.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aDW.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aDW.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aDW.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aDW.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.aEb++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.aDX == null) {
                this.aDX = new TextView(getContext());
                this.aDX.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aDX.setGravity(17);
                this.aDX.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aDX.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aDX.setText(a.i.sdk_official);
            }
            if (this.aDX.getParent() == null) {
                addView(this.aDX, h(false, false));
                this.aEb++;
            }
        } else if (this.aDX != null && this.aDX.getParent() != null) {
            ((ViewGroup) this.aDX.getParent()).removeView(this.aDX);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.aDY == null) {
                this.aDY = new TextView(getContext());
                this.aDY.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aDY.setGravity(17);
                this.aDY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aDY.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aDY.setText(a.i.sdk_admin);
            }
            if (this.aDY.getParent() == null) {
                addView(this.aDY, h(false, false));
                this.aEb++;
            }
        } else if (this.aDY != null && this.aDY.getParent() != null) {
            ((ViewGroup) this.aDY.getParent()).removeView(this.aDY);
        }
    }

    private void t(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.aDZ == null) {
                this.aDZ = new TextView(getContext());
                this.aDZ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aDZ.setGravity(17);
                this.aDZ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.aDZ != null && this.aDZ.getParent() != null) {
                        this.aDZ.setBackgroundDrawable(null);
                        ((ViewGroup) this.aDZ.getParent()).removeView(this.aDZ);
                        return;
                    }
                    return;
            }
            if (this.aDZ.getParent() == null) {
                this.aDZ.setText(str);
                this.aDZ.setBackgroundResource(i2);
                this.aDZ.setPadding(this.aDV, 0, this.aDV, 6);
                addView(this.aDZ, h(false, true));
                this.aEc = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams h(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.aDU, this.aDU);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Bg() {
        if (this.aEa == null) {
            this.aEa = new ImageView(getContext());
            this.aEa.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.aEa.getParent() == null) {
            addView(this.aEa, h(true, false));
            this.aEb++;
        }
    }

    public void d(int i, float f) {
        this.aDW.setTextColor(getResources().getColor(i));
        this.aDW.setAlpha(f);
    }

    public int getIconCount() {
        return this.aEb;
    }

    public int getUserTypeTxtCount() {
        return this.aEc;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.aDW != null) {
            this.aDW.setPadding(i, i2, i3, i4);
        }
    }
}
