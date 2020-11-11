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
import com.baidu.live.data.aq;
import com.baidu.live.data.cv;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private int bKR;
    private int bKS;
    private FrameLayout bKT;
    private TbImageView bKU;
    private TextView bKV;
    private TextView bKW;
    private TbImageView bKX;
    private TbImageView bKY;
    private TextView bKZ;
    private ImageView bLa;
    private int bLb;
    private int bLc;
    private AlaLiveMarkData bLd;
    private AlaLiveMarkData bLe;
    private TbImageView bLf;

    public ALALevelView(Context context) {
        super(context);
        this.bKR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bKS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bKR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bKS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bKS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(aq aqVar) {
        if (aqVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bLb = 0;
        this.bLc = 0;
        ak(aqVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(aqVar.third_app_id)) {
            setupLevelIcon(aqVar.level_id);
            setupOfficialIcon(aqVar.is_official == 1);
            Wu();
            return;
        }
        Ww();
    }

    public void setData(i.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bLb = 0;
        this.bLc = 0;
        ak(bVar.live_mark_info_new);
        aj(bVar.live_mark_info_new);
        removeAllViews();
        Wv();
        setupLevelIcon(bVar.level_id);
        Wu();
    }

    public void aj(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bLe = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 105) {
                i2 = i + 1;
            } else {
                this.bLe = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bLe = null;
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bLb = 0;
        this.bLc = 0;
        ak(aVar.aHG);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aHD);
            Wu();
            H(aVar.tagName, aVar.aHF);
            return;
        }
        Ww();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bLb = 0;
            this.bLc = 0;
            ak(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
            Wu();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bLb = 0;
        this.bLc = 0;
        ak(alaLiveUserInfoData.live_mark_info_new);
        aj(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Wv();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Wu();
    }

    public void setData4Yuyin(cv cvVar) {
        if (cvVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bLb = 0;
        this.bLc = 0;
        ak(cvVar.live_mark_info_new);
        aj(cvVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(cvVar.live_mark_info_new, cvVar.level_id);
        Wv();
        Wu();
    }

    public void ak(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bLd = null;
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
                this.bLd = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bLd = null;
        }
    }

    public void setupLevelIcon(List<AlaLiveMarkData> list, int i) {
        setupLevelIconImage(list, i);
    }

    public void setupLevelIcon(int i) {
        if (this.bKV == null) {
            this.bKV = new TextView(getContext());
            this.bKV.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bKV.setGravity(49);
            this.bKV.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bKV.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bKV.getParent() == null) {
            addView(this.bKV, 0);
        }
        this.bKV.setText(i + "");
        this.bKV.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bKV.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bKV.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bKV.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bKV.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bKV.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bLb++;
    }

    public void setupLevelIconImage(List<AlaLiveMarkData> list, int i) {
        AlaLiveMarkData alaLiveMarkData;
        FrameLayout.LayoutParams layoutParams;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    alaLiveMarkData = null;
                    break;
                }
                AlaLiveMarkData alaLiveMarkData2 = list.get(i2);
                if (alaLiveMarkData2.type == 1) {
                    alaLiveMarkData = alaLiveMarkData2;
                    break;
                }
                i2++;
            }
            if (alaLiveMarkData != null) {
                alaLiveMarkData.userLevel = i;
                alaLiveMarkData.setupNewLevelMark();
                if (this.bKU == null) {
                    this.bKU = new TbImageView(getContext());
                    this.bKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bKU.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bKU.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bKU.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bKU.setLayoutParams(layoutParams);
                if (this.bKT == null) {
                    this.bKT = new FrameLayout(getContext());
                    this.bKT.setBackgroundColor(0);
                }
                if (this.bKU.getParent() == null) {
                    this.bKT.addView(this.bKU);
                }
                this.bKU.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bKT.getParent() == null) {
                    addView(this.bKT, 0);
                }
                this.bLb++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bKW == null) {
                this.bKW = new TextView(getContext());
                this.bKW.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bKW.setGravity(17);
                this.bKW.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bKW.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bKW.setText(a.h.sdk_official);
            }
            if (this.bKW.getParent() == null) {
                addView(this.bKW, j(false, false));
                this.bLb++;
            }
        } else if (this.bKW != null && this.bKW.getParent() != null) {
            ((ViewGroup) this.bKW.getParent()).removeView(this.bKW);
        }
    }

    private void Wu() {
        if (this.bLd == null || this.bLd.type != 2) {
            a(this.bKX);
        } else if (TextUtils.isEmpty(this.bLd.mark_pic)) {
            a(this.bKX);
        } else {
            if (this.bKX == null) {
                this.bKX = new TbImageView(getContext());
                this.bKX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bKX.stopLoad();
            }
            this.bKX.startLoad(this.bLd.mark_pic, 10, false);
            if (this.bKX.getParent() == null) {
                addView(this.bKX, b(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bLb++;
            }
        }
    }

    private void Wv() {
        if (this.bLe == null || this.bLe.type != 105) {
            a(this.bLf);
        } else if (TextUtils.isEmpty(this.bLe.mark_pic)) {
            a(this.bLf);
        } else {
            if (this.bLf == null) {
                this.bLf = new TbImageView(getContext());
                this.bLf.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bLf.stopLoad();
            }
            this.bLf.startLoad(this.bLe.mark_pic, 10, false);
            if (this.bLf.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bLf, layoutParams);
                this.bLb++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void setupClubIcon(int i) {
        String eB = com.baidu.live.guardclub.g.KF().eB(i);
        if (TextUtils.isEmpty(eB)) {
            a(this.bKY);
            return;
        }
        if (this.bKY == null) {
            this.bKY = new TbImageView(getContext());
            this.bKY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bKY.stopLoad();
        }
        this.bKY.startLoad(eB, 10, false);
        if (this.bKY.getParent() == null) {
            addView(this.bKY, b(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bLb++;
        }
    }

    private void H(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bKZ == null) {
                this.bKZ = new TextView(getContext());
                this.bKZ.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bKZ.setGravity(17);
                this.bKZ.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
            }
            switch (i) {
                case 1:
                    i2 = a.e.sdk_bg_ala_user_type_1;
                    break;
                case 2:
                    i2 = a.e.sdk_bg_ala_user_type_2;
                    break;
                case 3:
                    i2 = a.e.sdk_bg_ala_user_type_3;
                    break;
                default:
                    if (this.bKZ != null && this.bKZ.getParent() != null) {
                        this.bKZ.setBackgroundDrawable(null);
                        ((ViewGroup) this.bKZ.getParent()).removeView(this.bKZ);
                        return;
                    }
                    return;
            }
            if (this.bKZ.getParent() == null) {
                this.bKZ.setText(str);
                this.bKZ.setBackgroundResource(i2);
                this.bKZ.setPadding(this.bKS, 0, this.bKS, 6);
                addView(this.bKZ, j(false, true));
                this.bLc = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bKR);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bKR);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Ww() {
        if (this.bLa == null) {
            this.bLa = new ImageView(getContext());
            this.bLa.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bLa.getParent() == null) {
            addView(this.bLa, j(true, false));
            this.bLb++;
        }
    }

    public void b(int i, float f) {
        this.bKV.setTextColor(getResources().getColor(i));
        this.bKV.setAlpha(f);
    }

    public int getIconCount() {
        return this.bLb;
    }

    public int getUserTypeTxtCount() {
        return this.bLc;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bKV != null) {
            this.bKV.setPadding(i, i2, i3, i4);
        }
    }
}
