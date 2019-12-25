package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.u;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class ALALevelView extends LinearLayout {
    private int ayT;
    private int ayU;
    private TextView ayV;
    private TextView ayW;
    private TextView ayX;
    private TextView ayY;
    private ImageView ayZ;
    private int aza;
    private int azb;

    public ALALevelView(Context context) {
        super(context);
        this.ayT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.ayU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.ayU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.ayU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(u uVar) {
        if (uVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aza = 0;
        this.azb = 0;
        removeAllViews();
        if (TextUtils.isEmpty(uVar.third_app_id)) {
            setupLevelIcon(uVar.level_id);
            setupOfficialIcon(uVar.is_official == 1);
            setupAdminIcon(uVar.is_live_admin == 1);
            return;
        }
        yx();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.aza = 0;
        this.azb = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.Vm);
            setupAdminIcon(aVar.Vn);
            t(aVar.tagName, aVar.Vo);
            return;
        }
        yx();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aza = 0;
        this.azb = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.ayV == null) {
            this.ayV = new TextView(getContext());
            this.ayV.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.ayV.setGravity(49);
            this.ayV.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.ayV.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.ayV.getParent() == null) {
            addView(this.ayV, 0);
        }
        this.ayV.setText(i + "");
        this.ayV.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.ayV.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.ayV.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.ayV.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.ayV.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.ayV.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.aza++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.ayW == null) {
                this.ayW = new TextView(getContext());
                this.ayW.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.ayW.setGravity(17);
                this.ayW.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.ayW.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.ayW.setText(a.i.sdk_official);
            }
            if (this.ayW.getParent() == null) {
                addView(this.ayW, g(false, false));
                this.aza++;
            }
        } else if (this.ayW != null && this.ayW.getParent() != null) {
            ((ViewGroup) this.ayW.getParent()).removeView(this.ayW);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.ayX == null) {
                this.ayX = new TextView(getContext());
                this.ayX.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.ayX.setGravity(17);
                this.ayX.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.ayX.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.ayX.setText(a.i.sdk_admin);
            }
            if (this.ayX.getParent() == null) {
                addView(this.ayX, g(false, false));
                this.aza++;
            }
        } else if (this.ayX != null && this.ayX.getParent() != null) {
            ((ViewGroup) this.ayX.getParent()).removeView(this.ayX);
        }
    }

    private void t(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.ayY == null) {
                this.ayY = new TextView(getContext());
                this.ayY.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.ayY.setGravity(17);
                this.ayY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.ayY != null && this.ayY.getParent() != null) {
                        this.ayY.setBackgroundDrawable(null);
                        ((ViewGroup) this.ayY.getParent()).removeView(this.ayY);
                        return;
                    }
                    return;
            }
            if (this.ayY.getParent() == null) {
                this.ayY.setText(str);
                this.ayY.setBackgroundResource(i2);
                this.ayY.setPadding(this.ayU, 0, this.ayU, 6);
                addView(this.ayY, g(false, true));
                this.azb = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams g(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.ayT, this.ayT);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void yx() {
        if (this.ayZ == null) {
            this.ayZ = new ImageView(getContext());
            this.ayZ.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.ayZ.getParent() == null) {
            addView(this.ayZ, g(true, false));
            this.aza++;
        }
    }

    public void d(int i, float f) {
        this.ayV.setTextColor(getResources().getColor(i));
        this.ayV.setAlpha(f);
    }

    public int getIconCount() {
        return this.aza;
    }

    public int getUserTypeTxtCount() {
        return this.azb;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.ayV != null) {
            this.ayV.setPadding(i, i2, i3, i4);
        }
    }
}
