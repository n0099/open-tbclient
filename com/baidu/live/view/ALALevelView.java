package com.baidu.live.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ax;
import com.baidu.live.data.df;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes10.dex */
public class ALALevelView extends LinearLayout {
    private int bTG;
    private int bTH;
    private FrameLayout bTI;
    private TbImageView bTJ;
    private TextView bTK;
    private TextView bTL;
    private TbImageView bTM;
    private TbImageView bTN;
    private TbImageView bTO;
    private TextView bTP;
    private ImageView bTQ;
    private int bTR;
    private int bTS;
    private AlaLiveMarkData bTT;
    private AlaLiveMarkData bTU;
    private AlaLiveMarkData bTV;
    private TbImageView bTW;

    public ALALevelView(Context context) {
        super(context);
        this.bTG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bTH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bTH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bTH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ax axVar) {
        if (axVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTR = 0;
        this.bTS = 0;
        ao(axVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(axVar.third_app_id)) {
            setupLevelIcon(axVar.level_id);
            setupOfficialIcon(axVar.is_official == 1);
            Xn();
            Xo();
            return;
        }
        Xq();
    }

    public void setData(j.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTR = 0;
        this.bTS = 0;
        ao(bVar.live_mark_info_new);
        an(bVar.live_mark_info_new);
        removeAllViews();
        Xp();
        setupLevelIcon(bVar.level_id);
        Xn();
        Xo();
    }

    public void an(List<AlaLiveMarkData> list) {
        int i;
        this.bTV = null;
        if (list != null) {
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
                    this.bTV = alaLiveMarkData;
                    break;
                }
            }
            if (i >= list.size()) {
                this.bTV = null;
            }
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bTR = 0;
        this.bTS = 0;
        ao(aVar.aHz);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aHw);
            Xn();
            Xo();
            L(aVar.tagName, aVar.aHy);
            return;
        }
        Xq();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bTR = 0;
            this.bTS = 0;
            ao(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            b(alaLiveUserInfoData.clubMemberLevel, alaLiveUserInfoData.clubGuardName, alaLiveUserInfoData.isGold(), alaLiveUserInfoData.guardGoldenType);
            Xn();
            Xo();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTR = 0;
        this.bTS = 0;
        ao(alaLiveUserInfoData.live_mark_info_new);
        an(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Xp();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Xn();
    }

    public void setData4Yuyin(df dfVar) {
        if (dfVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTR = 0;
        this.bTS = 0;
        ao(dfVar.live_mark_info_new);
        an(dfVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(dfVar.live_mark_info_new, dfVar.level_id);
        Xp();
        Xn();
    }

    public void ao(List<AlaLiveMarkData> list) {
        this.bTU = null;
        this.bTT = null;
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    AlaLiveMarkData alaLiveMarkData = list.get(i2);
                    if (alaLiveMarkData.type == 2) {
                        this.bTU = alaLiveMarkData;
                    } else if (alaLiveMarkData.type == 106) {
                        this.bTT = alaLiveMarkData;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void setupLevelIcon(List<AlaLiveMarkData> list, int i) {
        setupLevelIconImage(list, i);
    }

    public void setupLevelIcon(int i) {
        if (this.bTK == null) {
            this.bTK = new TextView(getContext());
            this.bTK.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bTK.setGravity(49);
            this.bTK.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bTK.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bTK.getParent() == null) {
            addView(this.bTK, 0);
        }
        this.bTK.setText(i + "");
        this.bTK.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bTK.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bTK.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bTK.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bTK.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bTK.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bTR++;
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
                if (this.bTJ == null) {
                    this.bTJ = new TbImageView(getContext());
                    this.bTJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bTJ.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bTJ.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bTJ.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bTJ.setLayoutParams(layoutParams);
                if (this.bTI == null) {
                    this.bTI = new FrameLayout(getContext());
                    this.bTI.setBackgroundColor(0);
                }
                if (this.bTJ.getParent() == null) {
                    this.bTI.addView(this.bTJ);
                }
                this.bTJ.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bTI.getParent() == null) {
                    addView(this.bTI, 0);
                }
                this.bTR++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bTL == null) {
                this.bTL = new TextView(getContext());
                this.bTL.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bTL.setGravity(17);
                this.bTL.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bTL.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bTL.setText(a.h.sdk_official);
            }
            if (this.bTL.getParent() == null) {
                addView(this.bTL, k(false, false));
                this.bTR++;
            }
        } else if (this.bTL != null && this.bTL.getParent() != null) {
            ((ViewGroup) this.bTL.getParent()).removeView(this.bTL);
        }
    }

    private void Xn() {
        if (this.bTU == null || this.bTU.type != 2) {
            a(this.bTN);
        } else if (TextUtils.isEmpty(this.bTU.mark_pic)) {
            a(this.bTN);
        } else {
            if (this.bTN == null) {
                this.bTN = new TbImageView(getContext());
                this.bTN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTN.stopLoad();
            }
            this.bTN.startLoad(this.bTU.mark_pic, 10, false);
            if (this.bTN.getParent() == null) {
                addView(this.bTN, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bTR++;
            }
        }
    }

    private void Xo() {
        LinearLayout.LayoutParams layoutParams;
        if (this.bTT == null || this.bTT.type != 106) {
            a(this.bTM);
        } else if (TextUtils.isEmpty(this.bTT.mark_pic)) {
            a(this.bTM);
        } else {
            if (this.bTM == null) {
                this.bTM = new TbImageView(getContext());
                this.bTM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTM.stopLoad();
            }
            this.bTM.startLoad(this.bTT.mark_pic, 10, false);
            if (this.bTM.getParent() == null) {
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i = (this.bTT.width <= 0 || this.bTT.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bTT.width) / this.bTT.height) * dimensionPixelSize);
                if (this.bTM.getLayoutParams() == null) {
                    layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (LinearLayout.LayoutParams) this.bTM.getLayoutParams();
                    layoutParams.width = i;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bTM.setLayoutParams(layoutParams);
                addView(this.bTM);
                this.bTR++;
            }
        }
    }

    private void Xp() {
        if (this.bTV == null || this.bTV.type != 105) {
            a(this.bTW);
        } else if (TextUtils.isEmpty(this.bTV.mark_pic)) {
            a(this.bTW);
        } else {
            if (this.bTW == null) {
                this.bTW = new TbImageView(getContext());
                this.bTW.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTW.stopLoad();
            }
            this.bTW.startLoad(this.bTV.mark_pic, 10, false);
            if (this.bTW.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bTW, layoutParams);
                this.bTR++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void b(int i, String str, boolean z, int i2) {
        Bitmap a2 = com.baidu.live.aj.b.a(getContext(), str, i, z, i2);
        if (a2 != null) {
            if (this.bTO == null) {
                this.bTO = new TbImageView(getContext());
                this.bTO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
            this.bTO.setImageBitmap(a2);
            if (this.bTO.getParent() == null) {
                addView(this.bTO, c(false, true, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
                this.bTR++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String dr = com.baidu.live.guardclub.g.IW().dr(i);
        if (TextUtils.isEmpty(dr)) {
            a(this.bTO);
            return;
        }
        if (this.bTO == null) {
            this.bTO = new TbImageView(getContext());
            this.bTO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bTO.stopLoad();
        }
        this.bTO.startLoad(dr, 10, false);
        if (this.bTO.getParent() == null) {
            addView(this.bTO, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bTR++;
        }
    }

    private void L(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bTP == null) {
                this.bTP = new TextView(getContext());
                this.bTP.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bTP.setGravity(17);
                this.bTP.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
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
                    if (this.bTP != null && this.bTP.getParent() != null) {
                        this.bTP.setBackgroundDrawable(null);
                        ((ViewGroup) this.bTP.getParent()).removeView(this.bTP);
                        return;
                    }
                    return;
            }
            if (this.bTP.getParent() == null) {
                this.bTP.setText(str);
                this.bTP.setBackgroundResource(i2);
                this.bTP.setPadding(this.bTH, 0, this.bTH, 6);
                addView(this.bTP, k(false, true));
                this.bTS = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams k(boolean z, boolean z2) {
        return c(z, z2, this.bTG);
    }

    private ViewGroup.LayoutParams c(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bTG);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Xq() {
        if (this.bTQ == null) {
            this.bTQ = new ImageView(getContext());
            this.bTQ.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bTQ.getParent() == null) {
            addView(this.bTQ, k(true, false));
            this.bTR++;
        }
    }

    public void b(int i, float f) {
        this.bTK.setTextColor(getResources().getColor(i));
        this.bTK.setAlpha(f);
    }

    public int getIconCount() {
        return this.bTR;
    }

    public int getUserTypeTxtCount() {
        return this.bTS;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bTK != null) {
            this.bTK.setPadding(i, i2, i3, i4);
        }
    }
}
