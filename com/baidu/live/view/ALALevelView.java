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
import com.baidu.live.data.ar;
import com.baidu.live.data.cx;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ALALevelView extends LinearLayout {
    private AlaLiveMarkData bOA;
    private AlaLiveMarkData bOB;
    private TbImageView bOC;
    private int bOo;
    private int bOp;
    private FrameLayout bOq;
    private TbImageView bOr;
    private TextView bOs;
    private TextView bOt;
    private TbImageView bOu;
    private TbImageView bOv;
    private TextView bOw;
    private ImageView bOx;
    private int bOy;
    private int bOz;

    public ALALevelView(Context context) {
        super(context);
        this.bOo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bOp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bOp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    public ALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds38);
        this.bOp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
    }

    public void setData(ar arVar) {
        if (arVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOy = 0;
        this.bOz = 0;
        am(arVar.live_mark_info_new);
        removeAllViews();
        if (TextUtils.isEmpty(arVar.third_app_id)) {
            setupLevelIcon(arVar.level_id);
            setupOfficialIcon(arVar.is_official == 1);
            Yl();
            return;
        }
        Yn();
    }

    public void setData(i.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOy = 0;
        this.bOz = 0;
        am(bVar.live_mark_info_new);
        al(bVar.live_mark_info_new);
        removeAllViews();
        Ym();
        setupLevelIcon(bVar.level_id);
        Yl();
    }

    public void al(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bOB = null;
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
                this.bOB = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bOB = null;
        }
    }

    public void setData(com.baidu.live.data.a aVar) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        removeAllViews();
        this.bOy = 0;
        this.bOz = 0;
        am(aVar.aID);
        if (TextUtils.isEmpty(aVar.appId)) {
            setupLevelIcon(aVar.level_id);
            setupOfficialIcon(aVar.aIA);
            Yl();
            I(aVar.tagName, aVar.aIC);
            return;
        }
        Yn();
    }

    public void setData(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData.isPrivacy != 0) {
            setVisibility(8);
        } else if (alaLiveUserInfoData == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.bOy = 0;
            this.bOz = 0;
            am(alaLiveUserInfoData.live_mark_info_new);
            removeAllViews();
            setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
            a(alaLiveUserInfoData.clubMemberLevel, alaLiveUserInfoData.clubGuardName, alaLiveUserInfoData.isGold(), alaLiveUserInfoData.guardGoldenType);
            Yl();
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOy = 0;
        this.bOz = 0;
        am(alaLiveUserInfoData.live_mark_info_new);
        al(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Ym();
        setupClubIcon(alaLiveUserInfoData.clubMemberLevel);
        Yl();
    }

    public void setData4Yuyin(cx cxVar) {
        if (cxVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bOy = 0;
        this.bOz = 0;
        am(cxVar.live_mark_info_new);
        al(cxVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(cxVar.live_mark_info_new, cxVar.level_id);
        Ym();
        Yl();
    }

    public void am(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bOA = null;
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
                this.bOA = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bOA = null;
        }
    }

    public void setupLevelIcon(List<AlaLiveMarkData> list, int i) {
        setupLevelIconImage(list, i);
    }

    public void setupLevelIcon(int i) {
        if (this.bOs == null) {
            this.bOs = new TextView(getContext());
            this.bOs.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize22));
            this.bOs.setGravity(49);
            this.bOs.setPadding(0, getResources().getDimensionPixelSize(a.d.sdk_tbds4), 0, 0);
            this.bOs.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        }
        if (this.bOs.getParent() == null) {
            addView(this.bOs, 0);
        }
        this.bOs.setText(i + "");
        this.bOs.getPaint().setFakeBoldText(true);
        if (i <= 10) {
            this.bOs.setBackgroundResource(a.e.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bOs.setBackgroundResource(a.e.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bOs.setBackgroundResource(a.e.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bOs.setBackgroundResource(a.e.sdk_icon_live_im_level4);
        } else {
            this.bOs.setBackgroundResource(a.e.sdk_icon_live_im_level5);
        }
        this.bOy++;
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
                if (this.bOr == null) {
                    this.bOr = new TbImageView(getContext());
                    this.bOr.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.bOr.stopLoad();
                }
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
                int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
                if (this.bOr.getLayoutParams() == null) {
                    layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                    layoutParams.gravity = 17;
                } else {
                    layoutParams = (FrameLayout.LayoutParams) this.bOr.getLayoutParams();
                    layoutParams.width = i3;
                    layoutParams.height = dimensionPixelSize;
                    layoutParams.gravity = 17;
                }
                this.bOr.setLayoutParams(layoutParams);
                if (this.bOq == null) {
                    this.bOq = new FrameLayout(getContext());
                    this.bOq.setBackgroundColor(0);
                }
                if (this.bOr.getParent() == null) {
                    this.bOq.addView(this.bOr);
                }
                this.bOr.startLoad(alaLiveMarkData.mark_pic, 10, false);
                if (this.bOq.getParent() == null) {
                    addView(this.bOq, 0);
                }
                this.bOy++;
            }
        }
    }

    private void setupOfficialIcon(boolean z) {
        if (z) {
            if (this.bOt == null) {
                this.bOt = new TextView(getContext());
                this.bOt.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bOt.setGravity(17);
                this.bOt.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bOt.setBackgroundResource(a.e.sdk_bg_ala_official);
                this.bOt.setText(a.h.sdk_official);
            }
            if (this.bOt.getParent() == null) {
                addView(this.bOt, j(false, false));
                this.bOy++;
            }
        } else if (this.bOt != null && this.bOt.getParent() != null) {
            ((ViewGroup) this.bOt.getParent()).removeView(this.bOt);
        }
    }

    private void Yl() {
        if (this.bOA == null || this.bOA.type != 2) {
            a(this.bOu);
        } else if (TextUtils.isEmpty(this.bOA.mark_pic)) {
            a(this.bOu);
        } else {
            if (this.bOu == null) {
                this.bOu = new TbImageView(getContext());
                this.bOu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bOu.stopLoad();
            }
            this.bOu.startLoad(this.bOA.mark_pic, 10, false);
            if (this.bOu.getParent() == null) {
                addView(this.bOu, b(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds54)));
                this.bOy++;
            }
        }
    }

    private void Ym() {
        if (this.bOB == null || this.bOB.type != 105) {
            a(this.bOC);
        } else if (TextUtils.isEmpty(this.bOB.mark_pic)) {
            a(this.bOC);
        } else {
            if (this.bOC == null) {
                this.bOC = new TbImageView(getContext());
                this.bOC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bOC.stopLoad();
            }
            this.bOC.startLoad(this.bOB.mark_pic, 10, false);
            if (this.bOC.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds126), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds60));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
                addView(this.bOC, layoutParams);
                this.bOy++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }

    private void a(int i, String str, boolean z, int i2) {
        Bitmap a2 = com.baidu.live.ak.b.a(getContext(), str, i, z, i2);
        if (a2 != null) {
            if (this.bOv == null) {
                this.bOv = new TbImageView(getContext());
                this.bOv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
            this.bOv.setImageBitmap(a2);
            if (this.bOv.getParent() == null) {
                addView(this.bOv, b(false, true, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
                this.bOy++;
            }
        }
    }

    private void setupClubIcon(int i) {
        String eT = com.baidu.live.guardclub.g.LZ().eT(i);
        if (TextUtils.isEmpty(eT)) {
            a(this.bOv);
            return;
        }
        if (this.bOv == null) {
            this.bOv = new TbImageView(getContext());
            this.bOv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            this.bOv.stopLoad();
        }
        this.bOv.startLoad(eT, 10, false);
        if (this.bOv.getParent() == null) {
            addView(this.bOv, b(false, false, getResources().getDimensionPixelOffset(a.d.sdk_tbds62)));
            this.bOy++;
        }
    }

    private void I(String str, int i) {
        int i2;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 5) {
                str = str.substring(0, 5);
            }
            if (this.bOw == null) {
                this.bOw = new TextView(getContext());
                this.bOw.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_tbfontsize26));
                this.bOw.setGravity(17);
                this.bOw.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
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
                    if (this.bOw != null && this.bOw.getParent() != null) {
                        this.bOw.setBackgroundDrawable(null);
                        ((ViewGroup) this.bOw.getParent()).removeView(this.bOw);
                        return;
                    }
                    return;
            }
            if (this.bOw.getParent() == null) {
                this.bOw.setText(str);
                this.bOw.setBackgroundResource(i2);
                this.bOw.setPadding(this.bOp, 0, this.bOp, 6);
                addView(this.bOw, j(false, true));
                this.bOz = str.length();
            }
        }
    }

    private ViewGroup.LayoutParams j(boolean z, boolean z2) {
        return b(z, z2, this.bOo);
    }

    private ViewGroup.LayoutParams b(boolean z, boolean z2, int i) {
        if (z2) {
            i = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, this.bOo);
        layoutParams.gravity = 16;
        if (!z) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(a.d.sdk_tbds10);
        }
        return layoutParams;
    }

    public void Yn() {
        if (this.bOx == null) {
            this.bOx = new ImageView(getContext());
            this.bOx.setImageResource(a.e.sdk_icon_live_im_visitors_14);
        }
        if (this.bOx.getParent() == null) {
            addView(this.bOx, j(true, false));
            this.bOy++;
        }
    }

    public void b(int i, float f) {
        this.bOs.setTextColor(getResources().getColor(i));
        this.bOs.setAlpha(f);
    }

    public int getIconCount() {
        return this.bOy;
    }

    public int getUserTypeTxtCount() {
        return this.bOz;
    }

    public void setTextLayoutParams(int i, int i2, int i3, int i4) {
        if (this.bOs != null) {
            this.bOs.setPadding(i, i2, i3, i4);
        }
    }
}
