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
import com.baidu.live.data.ck;
import com.baidu.live.data.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinALALevelView extends LinearLayout {
    private FrameLayout bvO;
    private ImageView bvP;
    private TextView bvQ;
    private TbImageView bvS;
    private int bvW;
    private int bvX;
    private AlaLiveMarkData bvY;
    private AlaLiveMarkData bvZ;
    private TbImageView bwa;

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

    public void setData(h.b bVar) {
        if (bVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(bVar.live_mark_info_new);
        X(bVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(bVar.level_id);
        Re();
        Rd();
    }

    public void X(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bvZ = null;
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
                this.bvZ = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bvZ = null;
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(alaLiveUserInfoData.live_mark_info_new);
        X(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        Re();
        Rd();
    }

    public void setData4Yuyin(ck ckVar) {
        if (ckVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bvW = 0;
        this.bvX = 0;
        Y(ckVar.live_mark_info_new);
        X(ckVar.live_mark_info_new);
        removeAllViews();
        if (ckVar.level_id > 0) {
            setupLevelIconImage(ckVar.level_id);
        }
        Re();
        Rd();
    }

    public void Y(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bvY = null;
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
                this.bvY = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bvY = null;
        }
    }

    public void setupLevelIconImage(int i) {
        if (this.bvO == null) {
            this.bvO = new FrameLayout(getContext());
            this.bvO.setBackgroundColor(0);
        }
        if (this.bvP == null) {
            this.bvP = new ImageView(getContext());
            this.bvP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bvP.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 13.0f), BdUtilHelper.dip2px(getContext(), 15.0f));
            layoutParams.gravity = 17;
            this.bvO.addView(this.bvP, layoutParams);
        }
        if (this.bvQ == null) {
            this.bvQ = new TextView(getContext());
            this.bvQ.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bvQ.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bvQ.setGravity(17);
            this.bvQ.getPaint().setFakeBoldText(true);
        }
        if (this.bvQ.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bvO.addView(this.bvQ, layoutParams2);
        }
        if (this.bvO.getParent() == null) {
            addView(this.bvO, 0);
        }
        if (i <= 10) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bvP.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bvQ.setText(i + "");
        this.bvW++;
    }

    private void Rd() {
        if (this.bvY == null || this.bvY.type != 2) {
            a(this.bvS);
        } else if (TextUtils.isEmpty(this.bvY.mark_pic)) {
            a(this.bvS);
        } else {
            if (this.bvS == null) {
                this.bvS = new TbImageView(getContext());
                this.bvS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bvS.stopLoad();
            }
            this.bvS.startLoad(this.bvY.mark_pic, 10, false);
            if (this.bvS.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_tbds54), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds39));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bvS, layoutParams);
                this.bvW++;
            }
        }
    }

    private void Re() {
        if (this.bvZ == null || this.bvZ.type != 105) {
            a(this.bwa);
        } else if (TextUtils.isEmpty(this.bvZ.mark_pic)) {
            a(this.bwa);
        } else {
            if (this.bwa == null) {
                this.bwa = new TbImageView(getContext());
                this.bwa.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bwa.stopLoad();
            }
            this.bwa.startLoad(this.bvZ.mark_pic, 10, false);
            if (this.bwa.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bwa, layoutParams);
                this.bvW++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
