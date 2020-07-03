package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ae;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes3.dex */
public class ALALevelView extends LinearLayout {
    private TextView bmA;
    private TbImageView bmB;
    private TbImageView bmC;
    private TextView bmD;
    private ImageView bmE;
    private int bmF;
    private int bmG;
    private AlaLiveMarkData bmH;
    private int bmv;
    private int bmw;
    private FrameLayout bmx;
    private ImageView bmy;
    private TextView bmz;

    public ALALevelView(Context context) {
        super(context);
        this.bmv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bmw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bmw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bmw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ae aeVar) {
        if (aeVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bmF = 0;
        this.bmG = 0;
        T(aeVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(aeVar.third_app_id)) {
            setupLevelIcon(aeVar.level_id);
            setupOfficialIcon(aeVar.is_official == 1);
            Kw();
            return;
        }
        Kx();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bmF = 0;
        this.bmG = 0;
        T(aVar.awD);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.awA);
            Kw();
            E(aVar.tagName, aVar.awC);
            return;
        }
        Kx();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bmF = 0;
        this.bmG = 0;
        T(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Kw();
    }

    public void T(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bmH = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 2) {
                i2 = i + 1;
            } else {
                this.bmH = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bmH = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bmz == null) {
            this.bmz = new TextView(getContext());
            this.bmz.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bmz.setGravity(49);
            this.bmz.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bmz.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bmz.getParent() == null) {
            addView(this.bmz, 0);
        }
        this.bmz.setText(i + "");
        this.bmz.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bmz.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bmz.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bmz.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bmz.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bmz.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bmF++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bmx == null) {
            this.bmx = new FrameLayout(getContext());
            this.bmx.setBackgroundColor(0);
        }
        if (this.bmy == null) {
            this.bmy = new ImageView(getContext());
            this.bmy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bmy.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bmx.addView(this.bmy, layoutParams);
        }
        if (this.bmz == null) {
            this.bmz = new TextView(getContext());
            this.bmz.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bmz.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bmz.setGravity(17);
            this.bmz.getPaint().setFakeBoldText(true);
        }
        if (this.bmz.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bmx.addView(this.bmz, layoutParams2);
        }
        if (this.bmx.getParent() == null) {
            addView(this.bmx, 0);
        }
        if (i <= 10) {
            this.bmy.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bmy.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bmy.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bmy.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bmy.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bmz.setText(i + "");
        this.bmF++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bmA == null) {
                this.bmA = new TextView(getContext());
                this.bmA.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bmA.setGravity(17);
                this.bmA.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bmA.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bmA.setText(a.i.sdk_official);
            }
            if (this.bmA.getParent() == null) {
                addView(this.bmA, i(false, false));
                this.bmF++;
            }
        } else if (this.bmA != null && this.bmA.getParent() != null) {
            ((ViewGroup) this.bmA.getParent()).removeView(this.bmA);
        }
    }

    private void Kw() {
        if (this.bmH == null || this.bmH.type != 2) {
            a(this.bmB);
        } else if (TextUtils.isEmpty(this.bmH.mark_pic)) {
            a(this.bmB);
        } else {
            if (this.bmB == null) {
                this.bmB = new TbImageView(getContext());
                this.bmB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bmB.stopLoad();
            }
            this.bmB.startLoad(this.bmH.mark_pic, 10, false);
            if (this.bmB.getParent() == null) {
                addView(this.bmB, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bmF++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String cv = com.baidu.live.guardclub.g.Ch().cv(i);
        if (TextUtils.isEmpty(cv)) {
            a(this.bmC);
            return;
        }
        if (this.bmC == null) {
            this.bmC = new TbImageView(getContext());
            this.bmC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bmC.stopLoad();
        }
        this.bmC.startLoad(cv, 10, false);
        if (this.bmC.getParent() == null) {
            addView(this.bmC, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bmF++;
        }
    }

    private void E(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bmD == null) {
                this.bmD = new TextView(getContext());
                this.bmD.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bmD.setGravity(17);
                this.bmD.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bmD != null && this.bmD.getParent() != null) {
                        this.bmD.setBackgroundDrawable(null);
                        ((ViewGroup) this.bmD.getParent()).removeView(this.bmD);
                        return;
                    }
                    return;
            }
            if (this.bmD.getParent() == null) {
                this.bmD.setText(str);
                this.bmD.setBackgroundResource(i2);
                this.bmD.setPadding(this.bmw, 0, this.bmw, 6);
                addView(this.bmD, i(false, true));
                this.bmG = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams i(boolean z, boolean z2) {
        return b(z, z2, this.bmv);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bmv);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Kx() {
        if (this.bmE == null) {
            this.bmE = new ImageView(getContext());
            this.bmE.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bmE.getParent() == null) {
            addView(this.bmE, i(true, false));
            this.bmF++;
        }
    }

    public void b(int i, float f) {
        this.bmz.setTextColor(getResources().getColor(i));
        this.bmz.setAlpha(f);
    }

    public int getIconCount() {
        return this.bmF;
    }

    public int getUserTypeTxtCount() {
        return this.bmG;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bmz != null) {
            this.bmz.setPadding(i, i2, i3, i4);
        }
    }
}
