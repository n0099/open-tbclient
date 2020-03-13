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
    private int aDW;
    private int aDX;
    private TextView aDY;
    private TextView aDZ;
    private TextView aEa;
    private TextView aEb;
    private ImageView aEc;
    private int aEd;
    private int aEe;

    public ALALevelView(Context context) {
        super(context);
        this.aDW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aDX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aDX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aDX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
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
        this.aEd = 0;
        this.aEe = 0;
        removeAllViews();
        if (TextUtils.isEmpty(xVar.third_app_id)) {
            setupLevelIcon(xVar.level_id);
            setupOfficialIcon(xVar.is_official == 1);
            setupAdminIcon(xVar.is_live_admin == 1);
            return;
        }
        Bi();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.aEd = 0;
        this.aEe = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.Xi);
            setupAdminIcon(aVar.Xj);
            t(aVar.tagName, aVar.Xk);
            return;
        }
        Bi();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aEd = 0;
        this.aEe = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.aDY == null) {
            this.aDY = new TextView(getContext());
            this.aDY.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.aDY.setGravity(49);
            this.aDY.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.aDY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.aDY.getParent() == null) {
            addView(this.aDY, 0);
        }
        this.aDY.setText(i + "");
        this.aDY.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.aDY.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aDY.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aDY.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aDY.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aDY.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.aEd++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.aDZ == null) {
                this.aDZ = new TextView(getContext());
                this.aDZ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aDZ.setGravity(17);
                this.aDZ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aDZ.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aDZ.setText(a.i.sdk_official);
            }
            if (this.aDZ.getParent() == null) {
                addView(this.aDZ, i(false, false));
                this.aEd++;
            }
        } else if (this.aDZ != null && this.aDZ.getParent() != null) {
            ((ViewGroup) this.aDZ.getParent()).removeView(this.aDZ);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.aEa == null) {
                this.aEa = new TextView(getContext());
                this.aEa.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aEa.setGravity(17);
                this.aEa.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aEa.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aEa.setText(a.i.sdk_admin);
            }
            if (this.aEa.getParent() == null) {
                addView(this.aEa, i(false, false));
                this.aEd++;
            }
        } else if (this.aEa != null && this.aEa.getParent() != null) {
            ((ViewGroup) this.aEa.getParent()).removeView(this.aEa);
        }
    }

    private void t(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.aEb == null) {
                this.aEb = new TextView(getContext());
                this.aEb.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aEb.setGravity(17);
                this.aEb.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.aEb != null && this.aEb.getParent() != null) {
                        this.aEb.setBackgroundDrawable(null);
                        ((ViewGroup) this.aEb.getParent()).removeView(this.aEb);
                        return;
                    }
                    return;
            }
            if (this.aEb.getParent() == null) {
                this.aEb.setText(str);
                this.aEb.setBackgroundResource(i2);
                this.aEb.setPadding(this.aDX, 0, this.aDX, 6);
                addView(this.aEb, i(false, true));
                this.aEe = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams i(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.aDW, this.aDW);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Bi() {
        if (this.aEc == null) {
            this.aEc = new ImageView(getContext());
            this.aEc.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.aEc.getParent() == null) {
            addView(this.aEc, i(true, false));
            this.aEd++;
        }
    }

    public void d(int i, float f) {
        this.aDY.setTextColor(getResources().getColor(i));
        this.aDY.setAlpha(f);
    }

    public int getIconCount() {
        return this.aEd;
    }

    public int getUserTypeTxtCount() {
        return this.aEe;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.aDY != null) {
            this.aDY.setPadding(i, i2, i3, i4);
        }
    }
}
