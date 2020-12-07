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
import com.baidu.live.data.cx;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinALALevelView extends LinearLayout {
    private AlaLiveMarkData bOA;
    private AlaLiveMarkData bOB;
    private TbImageView bOC;
    private FrameLayout bOq;
    private TbImageView bOr;
    private TextView bOs;
    private TbImageView bOu;
    private int bOy;
    private int bOz;

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
        this.bOy = 0;
        this.bOz = 0;
        am(bVar.live_mark_info_new);
        al(bVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        Ym();
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
        if (cxVar.level_id > 0) {
            setupLevelIconImage(cxVar.live_mark_info_new, cxVar.level_id);
        }
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
            if (this.bOs == null) {
                this.bOs = new TextView(getContext());
                this.bOs.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bOs.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bOs.setGravity(17);
                this.bOs.getPaint().setFakeBoldText(true);
            }
            if (this.bOs.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bOq.addView(this.bOs, layoutParams2);
            }
            this.bOr.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bOq.getParent() == null) {
                addView(this.bOq, 0);
            }
            this.bOy++;
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_tbds54), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds39));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bOu, layoutParams);
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
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
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
}
