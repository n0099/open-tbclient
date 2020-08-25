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
import com.baidu.live.data.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes7.dex */
public class ALALevelView extends LinearLayout {
    private TbImageView bsA;
    private TbImageView bsB;
    private TextView bsC;
    private ImageView bsD;
    private int bsE;
    private int bsF;
    private AlaLiveMarkData bsG;
    private int bsu;
    private int bsv;
    private FrameLayout bsw;
    private ImageView bsx;
    private TextView bsy;
    private TextView bsz;

    public ALALevelView(Context context) {
        super(context);
        this.bsu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bsv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bsv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bsv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ah ahVar) {
        if (ahVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bsE = 0;
        this.bsF = 0;
        U(ahVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(ahVar.third_app_id)) {
            setupLevelIcon(ahVar.level_id);
            setupOfficialIcon(ahVar.is_official == 1);
            Qv();
            return;
        }
        Qw();
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bsE = 0;
        this.bsF = 0;
        U(aVar.aCS);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aCP);
            Qv();
            F(aVar.tagName, aVar.aCR);
            return;
        }
        Qw();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bsE = 0;
        this.bsF = 0;
        U(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Qv();
    }

    public void U(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bsG = null;
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
                this.bsG = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bsG = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bsy == null) {
            this.bsy = new TextView(getContext());
            this.bsy.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bsy.setGravity(49);
            this.bsy.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bsy.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bsy.getParent() == null) {
            addView(this.bsy, 0);
        }
        this.bsy.setText(i + "");
        this.bsy.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bsy.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bsy.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bsy.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bsy.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bsy.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bsE++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bsw == null) {
            this.bsw = new FrameLayout(getContext());
            this.bsw.setBackgroundColor(0);
        }
        if (this.bsx == null) {
            this.bsx = new ImageView(getContext());
            this.bsx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bsx.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bsw.addView(this.bsx, layoutParams);
        }
        if (this.bsy == null) {
            this.bsy = new TextView(getContext());
            this.bsy.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bsy.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bsy.setGravity(17);
            this.bsy.getPaint().setFakeBoldText(true);
        }
        if (this.bsy.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bsw.addView(this.bsy, layoutParams2);
        }
        if (this.bsw.getParent() == null) {
            addView(this.bsw, 0);
        }
        if (i <= 10) {
            this.bsx.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bsx.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bsx.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bsx.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bsx.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bsy.setText(i + "");
        this.bsE++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bsz == null) {
                this.bsz = new TextView(getContext());
                this.bsz.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bsz.setGravity(17);
                this.bsz.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bsz.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bsz.setText(a.i.sdk_official);
            }
            if (this.bsz.getParent() == null) {
                addView(this.bsz, j(false, false));
                this.bsE++;
            }
        } else if (this.bsz != null && this.bsz.getParent() != null) {
            ((ViewGroup) this.bsz.getParent()).removeView(this.bsz);
        }
    }

    private void Qv() {
        if (this.bsG == null || this.bsG.type != 2) {
            a(this.bsA);
        } else if (TextUtils.isEmpty(this.bsG.mark_pic)) {
            a(this.bsA);
        } else {
            if (this.bsA == null) {
                this.bsA = new TbImageView(getContext());
                this.bsA.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bsA.stopLoad();
            }
            this.bsA.startLoad(this.bsG.mark_pic, 10, false);
            if (this.bsA.getParent() == null) {
                addView(this.bsA, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bsE++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String er = com.baidu.live.guardclub.g.Im().er(i);
        if (TextUtils.isEmpty(er)) {
            a(this.bsB);
            return;
        }
        if (this.bsB == null) {
            this.bsB = new TbImageView(getContext());
            this.bsB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bsB.stopLoad();
        }
        this.bsB.startLoad(er, 10, false);
        if (this.bsB.getParent() == null) {
            addView(this.bsB, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bsE++;
        }
    }

    private void F(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bsC == null) {
                this.bsC = new TextView(getContext());
                this.bsC.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bsC.setGravity(17);
                this.bsC.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bsC != null && this.bsC.getParent() != null) {
                        this.bsC.setBackgroundDrawable(null);
                        ((ViewGroup) this.bsC.getParent()).removeView(this.bsC);
                        return;
                    }
                    return;
            }
            if (this.bsC.getParent() == null) {
                this.bsC.setText(str);
                this.bsC.setBackgroundResource(i2);
                this.bsC.setPadding(this.bsv, 0, this.bsv, 6);
                addView(this.bsC, j(false, true));
                this.bsF = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bsu);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bsu);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Qw() {
        if (this.bsD == null) {
            this.bsD = new ImageView(getContext());
            this.bsD.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bsD.getParent() == null) {
            addView(this.bsD, j(true, false));
            this.bsE++;
        }
    }

    public void b(int i, float f) {
        this.bsy.setTextColor(getResources().getColor(i));
        this.bsy.setAlpha(f);
    }

    public int getIconCount() {
        return this.bsE;
    }

    public int getUserTypeTxtCount() {
        return this.bsF;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bsy != null) {
            this.bsy.setPadding(i, i2, i3, i4);
        }
    }
}
