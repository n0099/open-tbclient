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
    private int aEk;
    private int aEl;
    private TextView aEm;
    private TextView aEn;
    private TextView aEo;
    private TextView aEp;
    private ImageView aEq;
    private int aEr;
    private int aEs;

    public ALALevelView(Context context) {
        super(context);
        this.aEk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aEl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aEl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.aEl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
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
        this.aEr = 0;
        this.aEs = 0;
        removeAllViews();
        if (TextUtils.isEmpty(xVar.third_app_id)) {
            setupLevelIcon(xVar.level_id);
            setupOfficialIcon(xVar.is_official == 1);
            setupAdminIcon(xVar.is_live_admin == 1);
            return;
        }
        Bp();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.aEr = 0;
        this.aEs = 0;
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.Xs);
            setupAdminIcon(aVar.Xt);
            t(aVar.tagName, aVar.Xu);
            return;
        }
        Bp();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        boolean z = false;
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aEr = 0;
        this.aEs = 0;
        removeAllViews();
        setupLevelIcon(alaLiveUserInfoData.levelId);
        setupOfficialIcon(alaLiveUserInfoData.isOfficial == 1);
        if (alaLiveUserInfoData.isAdmin == 1 || alaLiveUserInfoData.isAdminOnline == 1) {
            z = true;
        }
        setupAdminIcon(z);
    }

    public void setupLevelIcon(int i) {
        if (this.aEm == null) {
            this.aEm = new TextView(getContext());
            this.aEm.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.aEm.setGravity(49);
            this.aEm.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.aEm.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.aEm.getParent() == null) {
            addView(this.aEm, 0);
        }
        this.aEm.setText(i + "");
        this.aEm.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.aEm.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.aEm.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.aEm.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.aEm.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.aEm.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.aEr++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.aEn == null) {
                this.aEn = new TextView(getContext());
                this.aEn.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aEn.setGravity(17);
                this.aEn.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aEn.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aEn.setText(a.i.sdk_official);
            }
            if (this.aEn.getParent() == null) {
                addView(this.aEn, i(false, false));
                this.aEr++;
            }
        } else if (this.aEn != null && this.aEn.getParent() != null) {
            ((ViewGroup) this.aEn.getParent()).removeView(this.aEn);
        }
    }

    private void setupAdminIcon(boolean z) {
        if (z) {
            if (this.aEo == null) {
                this.aEo = new TextView(getContext());
                this.aEo.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aEo.setGravity(17);
                this.aEo.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.aEo.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.aEo.setText(a.i.sdk_admin);
            }
            if (this.aEo.getParent() == null) {
                addView(this.aEo, i(false, false));
                this.aEr++;
            }
        } else if (this.aEo != null && this.aEo.getParent() != null) {
            ((ViewGroup) this.aEo.getParent()).removeView(this.aEo);
        }
    }

    private void t(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.aEp == null) {
                this.aEp = new TextView(getContext());
                this.aEp.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.aEp.setGravity(17);
                this.aEp.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.aEp != null && this.aEp.getParent() != null) {
                        this.aEp.setBackgroundDrawable(null);
                        ((ViewGroup) this.aEp.getParent()).removeView(this.aEp);
                        return;
                    }
                    return;
            }
            if (this.aEp.getParent() == null) {
                this.aEp.setText(str);
                this.aEp.setBackgroundResource(i2);
                this.aEp.setPadding(this.aEl, 0, this.aEl, 6);
                addView(this.aEp, i(false, true));
                this.aEs = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams i(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z2 ? -2 : this.aEk, this.aEk);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Bp() {
        if (this.aEq == null) {
            this.aEq = new ImageView(getContext());
            this.aEq.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.aEq.getParent() == null) {
            addView(this.aEq, i(true, false));
            this.aEr++;
        }
    }

    public void d(int i, float f) {
        this.aEm.setTextColor(getResources().getColor(i));
        this.aEm.setAlpha(f);
    }

    public int getIconCount() {
        return this.aEr;
    }

    public int getUserTypeTxtCount() {
        return this.aEs;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.aEm != null) {
            this.aEm.setPadding(i, i2, i3, i4);
        }
    }
}
