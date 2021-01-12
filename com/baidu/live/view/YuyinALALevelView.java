package com.baidu.live.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.cz;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes10.dex */
public class YuyinALALevelView extends LinearLayout {
    private int bOB;
    private int bOC;
    private AlaLiveMarkData bOE;
    private AlaLiveMarkData bOF;
    private TbImageView bOG;
    private FrameLayout bOs;
    private TbImageView bOt;
    private TextView bOu;
    private TbImageView bOx;
    private TbImageView bQH;
    private TbImageView bQI;
    private TbImageView bQJ;
    private AlaLiveMarkData bQK;
    private AlaLiveMarkData bQL;
    private AlaLiveMarkData bQM;

    public YuyinALALevelView(Context context) {
        super(context);
        init(context);
    }

    public YuyinALALevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public YuyinALALevelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setGravity(16);
        setOrientation(0);
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
        ao(bVar.live_mark_info_new);
        ap(bVar.live_mark_info_new);
        aq(bVar.live_mark_info_new);
        removeAllViews();
        VZ();
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        VD();
        VY();
        Wa();
        VB();
    }

    public void am(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bOF = null;
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
                this.bOF = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bOF = null;
        }
    }

    public void ao(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bQK = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 103) {
                i2 = i + 1;
            } else {
                this.bQK = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bQK = null;
        }
    }

    public void ap(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bQL = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 104) {
                i2 = i + 1;
            } else {
                this.bQL = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bQL = null;
        }
    }

    public void aq(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bQM = null;
            return;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= list.size()) {
                break;
            }
            AlaLiveMarkData alaLiveMarkData = list.get(i);
            if (alaLiveMarkData.type != 300) {
                i2 = i + 1;
            } else {
                this.bQM = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bQM = null;
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
        aq(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        VZ();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        VD();
        VY();
        Wa();
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
        aq(czVar.live_mark_info_new);
        removeAllViews();
        if (czVar.level_id > 0) {
            setupLevelIconImage(czVar.live_mark_info_new, czVar.level_id);
        }
        VD();
        VB();
        VZ();
        VY();
        Wa();
    }

    public void an(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bOE = null;
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
                this.bOE = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bOE = null;
        }
    }

    public void setupLevelIconImage(List<AlaLiveMarkData> list, int i) {
        AlaLiveMarkData alaLiveMarkData;
        FrameLayout.LayoutParams layoutParams;
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
            if (this.bOu == null) {
                this.bOu = new TextView(getContext());
                this.bOu.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bOu.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bOu.setGravity(17);
                this.bOu.getPaint().setFakeBoldText(true);
            }
            if (this.bOu.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bOs.addView(this.bOu, layoutParams2);
            }
            this.bOt.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bOs.getParent() == null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 16;
                layoutParams3.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bOs, layoutParams3);
            }
            this.bOB++;
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_ds44), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bOx, layoutParams);
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bOG, layoutParams);
                this.bOB++;
            }
        }
    }

    private void VY() {
        if (this.bQK == null || this.bQK.type != 103) {
            a(this.bQH);
        } else if (TextUtils.isEmpty(this.bQK.mark_pic)) {
            a(this.bQH);
        } else {
            if (this.bQH == null) {
                this.bQH = new TbImageView(getContext());
                this.bQH.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bQH.stopLoad();
            }
            this.bQH.startLoad(this.bQK.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bQK.width <= 0 || this.bQK.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bQK.width) / this.bQK.height) * dimensionPixelSize);
            if (this.bQH.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bQH, layoutParams);
                this.bOB++;
            }
        }
    }

    private void VZ() {
        if (this.bQM == null || this.bQM.type != 300) {
            a(this.bQJ);
        } else if (TextUtils.isEmpty(this.bQM.mark_pic)) {
            a(this.bQJ);
        } else {
            if (this.bQJ == null) {
                this.bQJ = new TbImageView(getContext());
                this.bQJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bQJ.stopLoad();
            }
            this.bQJ.startLoad(this.bQM.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bQM.width <= 0 || this.bQM.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bQM.width) / this.bQM.height) * dimensionPixelSize);
            if (this.bQJ.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                addView(this.bQJ, 0, layoutParams);
                this.bOB++;
            }
        }
    }

    private void Wa() {
        if (this.bQL == null || this.bQL.type != 104) {
            a(this.bQI);
        } else if (TextUtils.isEmpty(this.bQL.mark_pic)) {
            a(this.bQI);
        } else {
            if (this.bQI == null) {
                this.bQI = new TbImageView(getContext());
                this.bQI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bQI.stopLoad();
            }
            this.bQI.startLoad(this.bQL.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bQL.width <= 0 || this.bQL.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bQL.width) / this.bQL.height) * dimensionPixelSize);
            if (this.bQI.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bQI, layoutParams);
                this.bOB++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
