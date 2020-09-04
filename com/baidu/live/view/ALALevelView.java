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
    private ImageView bsA;
    private TextView bsB;
    private TextView bsC;
    private TbImageView bsD;
    private TbImageView bsE;
    private TextView bsF;
    private ImageView bsG;
    private int bsH;
    private int bsI;
    private AlaLiveMarkData bsJ;
    private int bsx;
    private int bsy;
    private FrameLayout bsz;

    public ALALevelView(Context context) {
        super(context);
        this.bsx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bsy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bsy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds38);
        this.bsy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds7);
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
        this.bsH = 0;
        this.bsI = 0;
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
        this.bsH = 0;
        this.bsI = 0;
        U(aVar.aCU);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aCR);
            Qv();
            F(aVar.tagName, aVar.aCT);
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
        this.bsH = 0;
        this.bsI = 0;
        U(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Qv();
    }

    public void U(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bsJ = null;
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
                this.bsJ = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bsJ = null;
        }
    }

    public void setupLevelIcon(int i) {
        if (this.bsB == null) {
            this.bsB = new TextView(getContext());
            this.bsB.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize22));
            this.bsB.setGravity(49);
            this.bsB.setPadding(0, getResources().getDimensionPixelSize(a.e.sdk_tbds4), 0, 0);
            this.bsB.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
        }
        if (this.bsB.getParent() == null) {
            addView(this.bsB, 0);
        }
        this.bsB.setText(i + "");
        this.bsB.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bsB.setBackgroundResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bsB.setBackgroundResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bsB.setBackgroundResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bsB.setBackgroundResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bsB.setBackgroundResource(a.f.sdk_icon_live_im_level5);
        }
        this.bsH++;
    }

    public void setupLevelIconImage(int i) {
        if (this.bsz == null) {
            this.bsz = new FrameLayout(getContext());
            this.bsz.setBackgroundColor(0);
        }
        if (this.bsA == null) {
            this.bsA = new ImageView(getContext());
            this.bsA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bsA.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_ds26), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
            layoutParams.gravity = 17;
            this.bsz.addView(this.bsA, layoutParams);
        }
        if (this.bsB == null) {
            this.bsB = new TextView(getContext());
            this.bsB.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bsB.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bsB.setGravity(17);
            this.bsB.getPaint().setFakeBoldText(true);
        }
        if (this.bsB.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bsz.addView(this.bsB, layoutParams2);
        }
        if (this.bsz.getParent() == null) {
            addView(this.bsz, 0);
        }
        if (i <= 10) {
            this.bsA.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bsA.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bsA.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bsA.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bsA.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bsB.setText(i + "");
        this.bsH++;
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bsC == null) {
                this.bsC = new TextView(getContext());
                this.bsC.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bsC.setGravity(17);
                this.bsC.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.bsC.setBackgroundResource(a.f.sdk_bg_ala_official);
                this.bsC.setText(a.i.sdk_official);
            }
            if (this.bsC.getParent() == null) {
                addView(this.bsC, j(false, false));
                this.bsH++;
            }
        } else if (this.bsC != null && this.bsC.getParent() != null) {
            ((ViewGroup) this.bsC.getParent()).removeView(this.bsC);
        }
    }

    private void Qv() {
        if (this.bsJ == null || this.bsJ.type != 2) {
            a(this.bsD);
        } else if (TextUtils.isEmpty(this.bsJ.mark_pic)) {
            a(this.bsD);
        } else {
            if (this.bsD == null) {
                this.bsD = new TbImageView(getContext());
                this.bsD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bsD.stopLoad();
            }
            this.bsD.startLoad(this.bsJ.mark_pic, 10, false);
            if (this.bsD.getParent() == null) {
                addView(this.bsD, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds54)));
                this.bsH++;
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
            a(this.bsE);
            return;
        }
        if (this.bsE == null) {
            this.bsE = new TbImageView(getContext());
            this.bsE.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bsE.stopLoad();
        }
        this.bsE.startLoad(er, 10, false);
        if (this.bsE.getParent() == null) {
            addView(this.bsE, b(false, false, getResources().getDimensionPixelOffset(a.e.sdk_tbds62)));
            this.bsH++;
        }
    }

    private void F(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bsF == null) {
                this.bsF = new TextView(getContext());
                this.bsF.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_tbfontsize26));
                this.bsF.setGravity(17);
                this.bsF.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
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
                    if (this.bsF != null && this.bsF.getParent() != null) {
                        this.bsF.setBackgroundDrawable(null);
                        ((ViewGroup) this.bsF.getParent()).removeView(this.bsF);
                        return;
                    }
                    return;
            }
            if (this.bsF.getParent() == null) {
                this.bsF.setText(str);
                this.bsF.setBackgroundResource(i2);
                this.bsF.setPadding(this.bsy, 0, this.bsy, 6);
                addView(this.bsF, j(false, true));
                this.bsI = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bsx);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bsx);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.e.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Qw() {
        if (this.bsG == null) {
            this.bsG = new ImageView(getContext());
            this.bsG.setImageResource(a.f.sdk_icon_live_im_visitors_14);
        }
        if (this.bsG.getParent() == null) {
            addView(this.bsG, j(true, false));
            this.bsH++;
        }
    }

    public void b(int i, float f) {
        this.bsB.setTextColor(getResources().getColor(i));
        this.bsB.setAlpha(f);
    }

    public int getIconCount() {
        return this.bsH;
    }

    public int getUserTypeTxtCount() {
        return this.bsI;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bsB != null) {
            this.bsB.setPadding(i, i2, i3, i4);
        }
    }
}
