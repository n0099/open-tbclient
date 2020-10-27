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
import com.baidu.live.data.cr;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinALALevelView extends LinearLayout {
    private FrameLayout bFn;
    private ImageView bFo;
    private TextView bFp;
    private TbImageView bFr;
    private int bFv;
    private int bFw;
    private AlaLiveMarkData bFx;
    private AlaLiveMarkData bFy;
    private TbImageView bFz;

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
        this.bFv = 0;
        this.bFw = 0;
        af(bVar.live_mark_info_new);
        ae(bVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(bVar.level_id);
        TV();
        TU();
    }

    public void ae(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bFy = null;
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
                this.bFy = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bFy = null;
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(alaLiveUserInfoData.live_mark_info_new);
        ae(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        TV();
        TU();
    }

    public void setData4Yuyin(cr crVar) {
        if (crVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bFv = 0;
        this.bFw = 0;
        af(crVar.live_mark_info_new);
        ae(crVar.live_mark_info_new);
        removeAllViews();
        if (crVar.level_id > 0) {
            setupLevelIconImage(crVar.level_id);
        }
        TV();
        TU();
    }

    public void af(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bFx = null;
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
                this.bFx = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bFx = null;
        }
    }

    public void setupLevelIconImage(int i) {
        if (this.bFn == null) {
            this.bFn = new FrameLayout(getContext());
            this.bFn.setBackgroundColor(0);
        }
        if (this.bFo == null) {
            this.bFo = new ImageView(getContext());
            this.bFo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bFo.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 13.0f), BdUtilHelper.dip2px(getContext(), 15.0f));
            layoutParams.gravity = 17;
            this.bFn.addView(this.bFo, layoutParams);
        }
        if (this.bFp == null) {
            this.bFp = new TextView(getContext());
            this.bFp.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bFp.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bFp.setGravity(17);
            this.bFp.getPaint().setFakeBoldText(true);
        }
        if (this.bFp.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bFn.addView(this.bFp, layoutParams2);
        }
        if (this.bFn.getParent() == null) {
            addView(this.bFn, 0);
        }
        if (i <= 10) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bFo.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bFp.setText(i + "");
        this.bFv++;
    }

    private void TU() {
        if (this.bFx == null || this.bFx.type != 2) {
            a(this.bFr);
        } else if (TextUtils.isEmpty(this.bFx.mark_pic)) {
            a(this.bFr);
        } else {
            if (this.bFr == null) {
                this.bFr = new TbImageView(getContext());
                this.bFr.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bFr.stopLoad();
            }
            this.bFr.startLoad(this.bFx.mark_pic, 10, false);
            if (this.bFr.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_tbds54), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds39));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bFr, layoutParams);
                this.bFv++;
            }
        }
    }

    private void TV() {
        if (this.bFy == null || this.bFy.type != 105) {
            a(this.bFz);
        } else if (TextUtils.isEmpty(this.bFy.mark_pic)) {
            a(this.bFz);
        } else {
            if (this.bFz == null) {
                this.bFz = new TbImageView(getContext());
                this.bFz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bFz.stopLoad();
            }
            this.bFz.startLoad(this.bFy.mark_pic, 10, false);
            if (this.bFz.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bFz, layoutParams);
                this.bFv++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
