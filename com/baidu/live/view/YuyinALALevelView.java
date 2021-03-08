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
import com.baidu.live.data.df;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes10.dex */
public class YuyinALALevelView extends LinearLayout {
    private FrameLayout bTI;
    private TbImageView bTJ;
    private TextView bTK;
    private TbImageView bTN;
    private int bTR;
    private int bTS;
    private AlaLiveMarkData bTU;
    private AlaLiveMarkData bTV;
    private TbImageView bTW;
    private TbImageView bVX;
    private TbImageView bVY;
    private TbImageView bVZ;
    private AlaLiveMarkData bWa;
    private AlaLiveMarkData bWb;
    private AlaLiveMarkData bWc;

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
        this.bTR = 0;
        this.bTS = 0;
        ao(bVar.live_mark_info_new);
        an(bVar.live_mark_info_new);
        ap(bVar.live_mark_info_new);
        aq(bVar.live_mark_info_new);
        ar(bVar.live_mark_info_new);
        removeAllViews();
        XL();
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        Xp();
        XK();
        XM();
        Xn();
    }

    public void an(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bTV = null;
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
                this.bTV = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bTV = null;
        }
    }

    public void ap(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bWa = null;
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
                this.bWa = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bWa = null;
        }
    }

    public void aq(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bWb = null;
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
                this.bWb = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bWb = null;
        }
    }

    public void ar(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bWc = null;
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
                this.bWc = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bWc = null;
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
        ar(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        XL();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Xp();
        XK();
        XM();
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
        ar(dfVar.live_mark_info_new);
        removeAllViews();
        if (dfVar.level_id > 0) {
            setupLevelIconImage(dfVar.live_mark_info_new, dfVar.level_id);
        }
        Xp();
        Xn();
        XL();
        XK();
        XM();
    }

    public void ao(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bTU = null;
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
                this.bTU = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bTU = null;
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
            if (this.bTK == null) {
                this.bTK = new TextView(getContext());
                this.bTK.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bTK.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bTK.setGravity(17);
                this.bTK.getPaint().setFakeBoldText(true);
            }
            if (this.bTK.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bTI.addView(this.bTK, layoutParams2);
            }
            this.bTJ.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bTI.getParent() == null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 16;
                layoutParams3.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bTI, layoutParams3);
            }
            this.bTR++;
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_ds44), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bTN, layoutParams);
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bTW, layoutParams);
                this.bTR++;
            }
        }
    }

    private void XK() {
        if (this.bWa == null || this.bWa.type != 103) {
            a(this.bVX);
        } else if (TextUtils.isEmpty(this.bWa.mark_pic)) {
            a(this.bVX);
        } else {
            if (this.bVX == null) {
                this.bVX = new TbImageView(getContext());
                this.bVX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bVX.stopLoad();
            }
            this.bVX.startLoad(this.bWa.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bWa.width <= 0 || this.bWa.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bWa.width) / this.bWa.height) * dimensionPixelSize);
            if (this.bVX.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bVX, layoutParams);
                this.bTR++;
            }
        }
    }

    private void XL() {
        if (this.bWc == null || this.bWc.type != 300) {
            a(this.bVZ);
        } else if (TextUtils.isEmpty(this.bWc.mark_pic)) {
            a(this.bVZ);
        } else {
            if (this.bVZ == null) {
                this.bVZ = new TbImageView(getContext());
                this.bVZ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bVZ.stopLoad();
            }
            this.bVZ.startLoad(this.bWc.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bWc.width <= 0 || this.bWc.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bWc.width) / this.bWc.height) * dimensionPixelSize);
            if (this.bVZ.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                addView(this.bVZ, 0, layoutParams);
                this.bTR++;
            }
        }
    }

    private void XM() {
        if (this.bWb == null || this.bWb.type != 104) {
            a(this.bVY);
        } else if (TextUtils.isEmpty(this.bWb.mark_pic)) {
            a(this.bVY);
        } else {
            if (this.bVY == null) {
                this.bVY = new TbImageView(getContext());
                this.bVY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bVY.stopLoad();
            }
            this.bVY.startLoad(this.bWb.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bWb.width <= 0 || this.bWb.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bWb.width) / this.bWb.height) * dimensionPixelSize);
            if (this.bVY.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bVY, layoutParams);
                this.bTR++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
