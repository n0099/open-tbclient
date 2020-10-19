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
import com.baidu.live.data.cl;
import com.baidu.live.data.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinALALevelView extends LinearLayout {
    private int bCA;
    private AlaLiveMarkData bCB;
    private AlaLiveMarkData bCC;
    private TbImageView bCD;
    private FrameLayout bCr;
    private ImageView bCs;
    private TextView bCt;
    private TbImageView bCv;
    private int bCz;

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
        this.bCz = 0;
        this.bCA = 0;
        ab(bVar.live_mark_info_new);
        aa(bVar.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(bVar.level_id);
        SW();
        SV();
    }

    public void aa(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bCC = null;
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
                this.bCC = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bCC = null;
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bCz = 0;
        this.bCA = 0;
        ab(alaLiveUserInfoData.live_mark_info_new);
        aa(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        setupLevelIconImage(alaLiveUserInfoData.levelId);
        SW();
        SV();
    }

    public void setData4Yuyin(cl clVar) {
        if (clVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bCz = 0;
        this.bCA = 0;
        ab(clVar.live_mark_info_new);
        aa(clVar.live_mark_info_new);
        removeAllViews();
        if (clVar.level_id > 0) {
            setupLevelIconImage(clVar.level_id);
        }
        SW();
        SV();
    }

    public void ab(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bCB = null;
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
                this.bCB = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bCB = null;
        }
    }

    public void setupLevelIconImage(int i) {
        if (this.bCr == null) {
            this.bCr = new FrameLayout(getContext());
            this.bCr.setBackgroundColor(0);
        }
        if (this.bCs == null) {
            this.bCs = new ImageView(getContext());
            this.bCs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (this.bCs.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 13.0f), BdUtilHelper.dip2px(getContext(), 15.0f));
            layoutParams.gravity = 17;
            this.bCr.addView(this.bCs, layoutParams);
        }
        if (this.bCt == null) {
            this.bCt = new TextView(getContext());
            this.bCt.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
            this.bCt.setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_tbfontsize26));
            this.bCt.setGravity(17);
            this.bCt.getPaint().setFakeBoldText(true);
        }
        if (this.bCt.getParent() == null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            this.bCr.addView(this.bCt, layoutParams2);
        }
        if (this.bCr.getParent() == null) {
            addView(this.bCr, 0);
        }
        if (i <= 10) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level1);
        } else if (i <= 20) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level2);
        } else if (i <= 30) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level3);
        } else if (i <= 40) {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level4);
        } else {
            this.bCs.setImageResource(a.f.sdk_icon_live_im_level5);
        }
        this.bCt.setText(i + "");
        this.bCz++;
    }

    private void SV() {
        if (this.bCB == null || this.bCB.type != 2) {
            a(this.bCv);
        } else if (TextUtils.isEmpty(this.bCB.mark_pic)) {
            a(this.bCv);
        } else {
            if (this.bCv == null) {
                this.bCv = new TbImageView(getContext());
                this.bCv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bCv.stopLoad();
            }
            this.bCv.startLoad(this.bCB.mark_pic, 10, false);
            if (this.bCv.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.e.sdk_tbds54), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_tbds39));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bCv, layoutParams);
                this.bCz++;
            }
        }
    }

    private void SW() {
        if (this.bCC == null || this.bCC.type != 105) {
            a(this.bCD);
        } else if (TextUtils.isEmpty(this.bCC.mark_pic)) {
            a(this.bCD);
        } else {
            if (this.bCD == null) {
                this.bCD = new TbImageView(getContext());
                this.bCD.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bCD.stopLoad();
            }
            this.bCD.startLoad(this.bCC.mark_pic, 10, false);
            if (this.bCD.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bCD, layoutParams);
                this.bCz++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
