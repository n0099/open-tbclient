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
import com.baidu.live.data.at;
import com.baidu.live.data.cz;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes10.dex */
public class ALALevelView extends LinearLayout {
    private ImageView bOA;
    private int bOB;
    private int bOC;
    private AlaLiveMarkData bOD;
    private AlaLiveMarkData bOE;
    private AlaLiveMarkData bOF;
    private TbImageView bOG;
    private int bOq;
    private int bOr;
    private FrameLayout bOs;
    private TbImageView bOt;
    private TextView bOu;
    private TextView bOv;
    private TbImageView bOw;
    private TbImageView bOx;
    private TbImageView bOy;
    private TextView bOz;

    public ALALevelView(Context context) {
        super(context);
        this.bOq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bOr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bOr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bOr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(at atVar) {
        if (atVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOB = 0;
        this.bOC = 0;
        an(atVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(atVar.third_app_id)) {
            setupLevelIcon(atVar.level_id);
            setupOfficialIcon(atVar.is_official == 1);
            VB();
            VC();
            return;
        }
        VE();
    }

    public void setData(j.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOB = 0;
        this.bOC = 0;
        an(bVar.live_mark_info_new);
        am(bVar.live_mark_info_new);
        removeAllViews();
        VD();
        setupLevelIcon(bVar.level_id);
        VB();
        VC();
    }

    public void am(List<AlaLiveMarkData> list) {
        int i;
        this.bOF = null;
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
                    this.bOF = alaLiveMarkData;
                    break;
                }
            }
            if (i >= list.size()) {
                this.bOF = null;
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
        this.bOB = 0;
        this.bOC = 0;
        an(aVar.aEm);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aEj);
            VB();
            VC();
            K(aVar.tagName, aVar.aEl);
            return;
        }
        VE();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bOB = 0;
            this.bOC = 0;
            an(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            a(alaLiveUserInfoData.clubMemberLevel, alaLiveUserInfoData.clubGuardName, alaLiveUserInfoData.isGold(), alaLiveUserInfoData.guardGoldenType);
            VB();
            VC();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOB = 0;
        this.bOC = 0;
        an(alaLiveUserInfoData.live_mark_info_new);
        am(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        VD();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        VB();
    }

    public void setData4Yuyin(cz czVar) {
        if (czVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOB = 0;
        this.bOC = 0;
        an(czVar.live_mark_info_new);
        am(czVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(czVar.live_mark_info_new, czVar.level_id);
        VD();
        VB();
    }

    public void an(List<AlaLiveMarkData> list) {
        this.bOE = null;
        this.bOD = null;
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    AlaLiveMarkData alaLiveMarkData = list.get(i2);
                    if (alaLiveMarkData.type == 2) {
                        this.bOE = alaLiveMarkData;
                    } else if (alaLiveMarkData.type == 106) {
                        this.bOD = alaLiveMarkData;
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
        if (this.bOu == null) {
            this.bOu = new TextView(getContext());
            this.bOu.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bOu.setGravity(49);
            this.bOu.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bOu.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bOu.getParent() == null) {
            addView(this.bOu, 0);
        }
        this.bOu.setText(i + "");
        this.bOu.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bOu.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bOu.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bOu.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bOu.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bOu.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bOB++;
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
                if (this.bOt == null) {
                    this.bOt = new TbImageView(getContext());
                    this.bOt.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bOt.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bOt.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bOt.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bOt.setLayoutParams(layoutParams);
                if (this.bOs == null) {
                    this.bOs = new FrameLayout(getContext());
                    this.bOs.setBackgroundColor(0);
                }
                if (this.bOt.getParent() == null) {
                    this.bOs.addView(this.bOt);
                }
                this.bOt.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bOs.getParent() == null) {
                    addView(this.bOs, 0);
                }
                this.bOB++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bOv == null) {
                this.bOv = new TextView(getContext());
                this.bOv.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bOv.setGravity(17);
                this.bOv.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bOv.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bOv.setText(a.h.sdk_official);
            }
            if (this.bOv.getParent() == null) {
                addView(this.bOv, j(false, false));
                this.bOB++;
            }
        } else if (this.bOv != null && this.bOv.getParent() != null) {
            ((ViewGroup) this.bOv.getParent()).removeView(this.bOv);
        }
    }

    private void VB() {
        if (this.bOE == null || this.bOE.type != 2) {
            a(this.bOx);
        } else if (TextUtils.isEmpty(this.bOE.mark_pic)) {
            a(this.bOx);
        } else {
            if (this.bOx == null) {
                this.bOx = new TbImageView(getContext());
                this.bOx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bOx.stopLoad();
            }
            this.bOx.startLoad(this.bOE.mark_pic, 10, false);
            if (this.bOx.getParent() == null) {
                addView(this.bOx, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bOB++;
            }
        }
    }

    private void VC() {
        LinearLayout.LayoutParams layoutParams;
        if (this.bOD == null || this.bOD.type != 106) {
            a(this.bOw);
        } else if (TextUtils.isEmpty(this.bOD.mark_pic)) {
            a(this.bOw);
        } else {
            if (this.bOw == null) {
                this.bOw = new TbImageView(getContext());
                this.bOw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bOw.stopLoad();
            }
            this.bOw.startLoad(this.bOD.mark_pic, 10, false);
            if (this.bOw.getParent() == null) {
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i = (this.bOD.width <= 0 || this.bOD.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bOD.width) / this.bOD.height) * dimensionPixelSize);
                if (this.bOw.getLayoutParams() == null) {
                    layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (LinearLayout.LayoutParams) this.bOw.getLayoutParams();
                    layoutParams.width = i;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bOw.setLayoutParams(layoutParams);
                addView(this.bOw);
                this.bOB++;
            }
        }
    }

    private void VD() {
        if (this.bOF == null || this.bOF.type != 105) {
            a(this.bOG);
        } else if (TextUtils.isEmpty(this.bOF.mark_pic)) {
            a(this.bOG);
        } else {
            if (this.bOG == null) {
                this.bOG = new TbImageView(getContext());
                this.bOG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bOG.stopLoad();
            }
            this.bOG.startLoad(this.bOF.mark_pic, 10, false);
            if (this.bOG.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bOG, layoutParams);
                this.bOB++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void a(int i, String str, boolean z, int i2) {
        Bitmap a2 = com.baidu.live.al.b.a(getContext(), str, i, z, i2);
        if (a2 != null) {
            if (this.bOy == null) {
                this.bOy = new TbImageView(getContext());
                this.bOy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
            this.bOy.setImageBitmap(a2);
            if (this.bOy.getParent() == null) {
                addView(this.bOy, c(false, true, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
                this.bOB++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String dl = com.baidu.live.guardclub.g.HD().dl(i);
        if (TextUtils.isEmpty(dl)) {
            a(this.bOy);
            return;
        }
        if (this.bOy == null) {
            this.bOy = new TbImageView(getContext());
            this.bOy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bOy.stopLoad();
        }
        this.bOy.startLoad(dl, 10, false);
        if (this.bOy.getParent() == null) {
            addView(this.bOy, c(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bOB++;
        }
    }

    private void K(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bOz == null) {
                this.bOz = new TextView(getContext());
                this.bOz.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bOz.setGravity(17);
                this.bOz.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
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
                    if (this.bOz != null && this.bOz.getParent() != null) {
                        this.bOz.setBackgroundDrawable(null);
                        ((ViewGroup) this.bOz.getParent()).removeView(this.bOz);
                        return;
                    }
                    return;
            }
            if (this.bOz.getParent() == null) {
                this.bOz.setText(str);
                this.bOz.setBackgroundResource(i2);
                this.bOz.setPadding(this.bOr, 0, this.bOr, 6);
                addView(this.bOz, j(false, true));
                this.bOC = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return c(z, z2, this.bOq);
    }

    private ViewGroup.LayoutParams c(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bOq);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void VE() {
        if (this.bOA == null) {
            this.bOA = new ImageView(getContext());
            this.bOA.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bOA.getParent() == null) {
            addView(this.bOA, j(true, false));
            this.bOB++;
        }
    }

    public void b(int i, float f) {
        this.bOu.setTextColor(getResources().getColor(i));
        this.bOu.setAlpha(f);
    }

    public int getIconCount() {
        return this.bOB;
    }

    public int getUserTypeTxtCount() {
        return this.bOC;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bOu != null) {
            this.bOu.setPadding(i, i2, i3, i4);
        }
    }
}
