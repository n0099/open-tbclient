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
    private FrameLayout bJi;
    private TbImageView bJj;
    private TextView bJk;
    private TbImageView bJm;
    private int bJq;
    private int bJr;
    private AlaLiveMarkData bJs;
    private AlaLiveMarkData bJt;
    private TbImageView bJu;

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
        this.bJq = 0;
        this.bJr = 0;
        ak(bVar.live_mark_info_new);
        aj(bVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        VM();
        VL();
    }

    public void aj(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bJt = null;
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
                this.bJt = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bJt = null;
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bJq = 0;
        this.bJr = 0;
        ak(alaLiveUserInfoData.live_mark_info_new);
        aj(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        VM();
        VL();
    }

    public void setData4Yuyin(cv cvVar) {
        if (cvVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bJq = 0;
        this.bJr = 0;
        ak(cvVar.live_mark_info_new);
        aj(cvVar.live_mark_info_new);
        removeAllViews();
        if (cvVar.level_id > 0) {
            setupLevelIconImage(cvVar.live_mark_info_new, cvVar.level_id);
        }
        VM();
        VL();
    }

    public void ak(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bJs = null;
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
                this.bJs = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bJs = null;
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
            if (this.bJj == null) {
                this.bJj = new TbImageView(getContext());
                this.bJj.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.bJj.stopLoad();
            }
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
            if (this.bJj.getLayoutParams() == null) {
                layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                layoutParams.gravity = 17;
            } else {
                layoutParams = (FrameLayout.LayoutParams) this.bJj.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = dimensionPixelSize;
                layoutParams.gravity = 17;
            }
            this.bJj.setLayoutParams(layoutParams);
            if (this.bJi == null) {
                this.bJi = new FrameLayout(getContext());
                this.bJi.setBackgroundColor(0);
            }
            if (this.bJj.getParent() == null) {
                this.bJi.addView(this.bJj);
            }
            if (this.bJk == null) {
                this.bJk = new TextView(getContext());
                this.bJk.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bJk.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bJk.setGravity(17);
                this.bJk.getPaint().setFakeBoldText(true);
            }
            if (this.bJk.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bJi.addView(this.bJk, layoutParams2);
            }
            this.bJj.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bJi.getParent() == null) {
                addView(this.bJi, 0);
            }
            this.bJq++;
        }
    }

    private void VL() {
        if (this.bJs == null || this.bJs.type != 2) {
            a(this.bJm);
        } else if (TextUtils.isEmpty(this.bJs.mark_pic)) {
            a(this.bJm);
        } else {
            if (this.bJm == null) {
                this.bJm = new TbImageView(getContext());
                this.bJm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bJm.stopLoad();
            }
            this.bJm.startLoad(this.bJs.mark_pic, 10, false);
            if (this.bJm.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_tbds54), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_tbds39));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bJm, layoutParams);
                this.bJq++;
            }
        }
    }

    private void VM() {
        if (this.bJt == null || this.bJt.type != 105) {
            a(this.bJu);
        } else if (TextUtils.isEmpty(this.bJt.mark_pic)) {
            a(this.bJu);
        } else {
            if (this.bJu == null) {
                this.bJu = new TbImageView(getContext());
                this.bJu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bJu.stopLoad();
            }
            this.bJu.startLoad(this.bJt.mark_pic, 10, false);
            if (this.bJu.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bJu, layoutParams);
                this.bJq++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
