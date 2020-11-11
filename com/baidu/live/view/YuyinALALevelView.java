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
import com.baidu.live.data.cv;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinALALevelView extends LinearLayout {
    private FrameLayout bKT;
    private TbImageView bKU;
    private TextView bKV;
    private TbImageView bKX;
    private int bLb;
    private int bLc;
    private AlaLiveMarkData bLd;
    private AlaLiveMarkData bLe;
    private TbImageView bLf;

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
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        Wv();
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
        if (cvVar.level_id > 0) {
            setupLevelIconImage(cvVar.live_mark_info_new, cvVar.level_id);
        }
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
            if (this.bKV == null) {
                this.bKV = new TextView(getContext());
                this.bKV.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bKV.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bKV.setGravity(17);
                this.bKV.getPaint().setFakeBoldText(true);
            }
            if (this.bKV.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bKT.addView(this.bKV, layoutParams2);
            }
            this.bKU.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bKT.getParent() == null) {
                addView(this.bKT, 0);
            }
            this.bLb++;
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_tbds54), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds39));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bKX, layoutParams);
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
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
}
