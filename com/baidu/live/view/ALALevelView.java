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
    private int ari;
    private int arj;
    private TextView ark;
    private TextView arl;
    private TextView arm;
    private TextView arn;
    private ImageView aro;
    private int arp;
    private int arq;

    public ALALevelView(Context context) {
        super(context);
        this.ari = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.arj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ari = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.arj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ari = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.arj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
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
        this.arp = 0;
        this.arq = 0;
        removeAllViews();
        if (TextUtils.isEmpty(sVar.third_app_id)) {
            setupLevelIcon(sVar.level_id);
            setupOfficialIcon(sVar.is_official == 1);
            setupAdminIcon(sVar.is_live_admin == 1);
            return;
        }
        wx();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.arp = 0;
        this.arq = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.Om);
            setupAdminIcon(aVar.On);
            p(aVar.tagName, aVar.Oo);
            return;
        }
        wx();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.arp = 0;
        this.arq = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.ark == null) {
            this.ark = new TextView(getContext());
            this.ark.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.ark.setGravity(49);
            this.ark.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.ark.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.ark.getParent() == null) {
            addView(this.ark, 0);
        }
        this.ark.setText(i + "");
        this.ark.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.ark.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.ark.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.ark.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.ark.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.ark.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.arp++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.arl == null) {
                this.arl = new TextView(getContext());
                this.arl.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.arl.setGravity(17);
                this.arl.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.arl.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.arl.setText(a.i.sdk_official);
            }
            if (this.arl.getParent() == null) {
                addView(this.arl, g(false, false));
                this.arp++;
            }
        } else if (this.arl != null && this.arl.getParent() != null) {
            ((ViewGroup) this.arl.getParent()).removeView(this.arl);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.arm == null) {
                this.arm = new TextView(getContext());
                this.arm.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.arm.setGravity(17);
                this.arm.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.arm.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.arm.setText(a.i.sdk_admin);
            }
            if (this.arm.getParent() == null) {
                addView(this.arm, g(false, false));
                this.arp++;
            }
        } else if (this.arm != null && this.arm.getParent() != null) {
            ((ViewGroup) this.arm.getParent()).removeView(this.arm);
        }
    }

    private void p(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.arn == null) {
                this.arn = new TextView(getContext());
                this.arn.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.arn.setGravity(17);
                this.arn.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.arn != null && this.arn.getParent() != null) {
                        this.arn.setBackgroundDrawable(null);
                        ((ViewGroup) this.arn.getParent()).removeView(this.arn);
                        return;
                    }
                    return;
            }
            if (this.arn.getParent() == null) {
                this.arn.setText(str);
                this.arn.setBackgroundResource(i2);
                this.arn.setPadding(this.arj, 0, this.arj, 6);
                addView(this.arn, g(false, true));
                this.arq = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams g(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.ari, this.ari);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void wx() {
        if (this.aro == null) {
            this.aro = new ImageView(getContext());
            this.aro.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.aro.getParent() == null) {
            addView(this.aro, g(true, false));
            this.arp++;
        }
    }

    public void d(int i, float f) {
        this.ark.setTextColor(getResources().getColor(i));
        this.ark.setAlpha(f);
    }

    public int getIconCount() {
        return this.arp;
    }

    public int getUserTypeTxtCount() {
        return this.arq;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.ark != null) {
            this.ark.setPadding(i, i2, i3, i4);
        }
    }
}
