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
/* loaded from: classes11.dex */
public class YuyinALALevelView extends LinearLayout {
    private FrameLayout bTe;
    private TbImageView bTf;
    private TextView bTg;
    private TbImageView bTj;
    private int bTn;
    private int bTo;
    private AlaLiveMarkData bTq;
    private AlaLiveMarkData bTr;
    private TbImageView bTs;
    private TbImageView bVt;
    private TbImageView bVu;
    private TbImageView bVv;
    private AlaLiveMarkData bVw;
    private AlaLiveMarkData bVx;
    private AlaLiveMarkData bVy;

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
        this.bTn = 0;
        this.bTo = 0;
        an(bVar.live_mark_info_new);
        am(bVar.live_mark_info_new);
        ao(bVar.live_mark_info_new);
        ap(bVar.live_mark_info_new);
        aq(bVar.live_mark_info_new);
        removeAllViews();
        ZR();
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        Zv();
        ZQ();
        ZS();
        Zt();
    }

    public void am(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bTr = null;
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
                this.bTr = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bTr = null;
        }
    }

    public void ao(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bVw = null;
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
                this.bVw = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bVw = null;
        }
    }

    public void ap(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bVx = null;
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
                this.bVx = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bVx = null;
        }
    }

    public void aq(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bVy = null;
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
                this.bVy = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bVy = null;
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTn = 0;
        this.bTo = 0;
        an(alaLiveUserInfoData.live_mark_info_new);
        am(alaLiveUserInfoData.live_mark_info_new);
        aq(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        ZR();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Zv();
        ZQ();
        ZS();
        Zt();
    }

    public void setData4Yuyin(cz czVar) {
        if (czVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTn = 0;
        this.bTo = 0;
        an(czVar.live_mark_info_new);
        am(czVar.live_mark_info_new);
        aq(czVar.live_mark_info_new);
        removeAllViews();
        if (czVar.level_id > 0) {
            setupLevelIconImage(czVar.live_mark_info_new, czVar.level_id);
        }
        Zv();
        Zt();
        ZR();
        ZQ();
        ZS();
    }

    public void an(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bTq = null;
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
                this.bTq = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bTq = null;
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
            if (this.bTf == null) {
                this.bTf = new TbImageView(getContext());
                this.bTf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.bTf.stopLoad();
            }
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
            if (this.bTf.getLayoutParams() == null) {
                layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                layoutParams.gravity = 17;
            } else {
                layoutParams = (FrameLayout.LayoutParams) this.bTf.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = dimensionPixelSize;
                layoutParams.gravity = 17;
            }
            this.bTf.setLayoutParams(layoutParams);
            if (this.bTe == null) {
                this.bTe = new FrameLayout(getContext());
                this.bTe.setBackgroundColor(0);
            }
            if (this.bTf.getParent() == null) {
                this.bTe.addView(this.bTf);
            }
            if (this.bTg == null) {
                this.bTg = new TextView(getContext());
                this.bTg.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bTg.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bTg.setGravity(17);
                this.bTg.getPaint().setFakeBoldText(true);
            }
            if (this.bTg.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bTe.addView(this.bTg, layoutParams2);
            }
            this.bTf.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bTe.getParent() == null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 16;
                layoutParams3.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bTe, layoutParams3);
            }
            this.bTn++;
        }
    }

    private void Zt() {
        if (this.bTq == null || this.bTq.type != 2) {
            a(this.bTj);
        } else if (TextUtils.isEmpty(this.bTq.mark_pic)) {
            a(this.bTj);
        } else {
            if (this.bTj == null) {
                this.bTj = new TbImageView(getContext());
                this.bTj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTj.stopLoad();
            }
            this.bTj.startLoad(this.bTq.mark_pic, 10, false);
            if (this.bTj.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_ds44), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bTj, layoutParams);
                this.bTn++;
            }
        }
    }

    private void Zv() {
        if (this.bTr == null || this.bTr.type != 105) {
            a(this.bTs);
        } else if (TextUtils.isEmpty(this.bTr.mark_pic)) {
            a(this.bTs);
        } else {
            if (this.bTs == null) {
                this.bTs = new TbImageView(getContext());
                this.bTs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bTs.stopLoad();
            }
            this.bTs.startLoad(this.bTr.mark_pic, 10, false);
            if (this.bTs.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bTs, layoutParams);
                this.bTn++;
            }
        }
    }

    private void ZQ() {
        if (this.bVw == null || this.bVw.type != 103) {
            a(this.bVt);
        } else if (TextUtils.isEmpty(this.bVw.mark_pic)) {
            a(this.bVt);
        } else {
            if (this.bVt == null) {
                this.bVt = new TbImageView(getContext());
                this.bVt.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bVt.stopLoad();
            }
            this.bVt.startLoad(this.bVw.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bVw.width <= 0 || this.bVw.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bVw.width) / this.bVw.height) * dimensionPixelSize);
            if (this.bVt.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bVt, layoutParams);
                this.bTn++;
            }
        }
    }

    private void ZR() {
        if (this.bVy == null || this.bVy.type != 300) {
            a(this.bVv);
        } else if (TextUtils.isEmpty(this.bVy.mark_pic)) {
            a(this.bVv);
        } else {
            if (this.bVv == null) {
                this.bVv = new TbImageView(getContext());
                this.bVv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bVv.stopLoad();
            }
            this.bVv.startLoad(this.bVy.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bVy.width <= 0 || this.bVy.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bVy.width) / this.bVy.height) * dimensionPixelSize);
            if (this.bVv.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                addView(this.bVv, 0, layoutParams);
                this.bTn++;
            }
        }
    }

    private void ZS() {
        if (this.bVx == null || this.bVx.type != 104) {
            a(this.bVu);
        } else if (TextUtils.isEmpty(this.bVx.mark_pic)) {
            a(this.bVu);
        } else {
            if (this.bVu == null) {
                this.bVu = new TbImageView(getContext());
                this.bVu.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bVu.stopLoad();
            }
            this.bVu.startLoad(this.bVx.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bVx.width <= 0 || this.bVx.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bVx.width) / this.bVx.height) * dimensionPixelSize);
            if (this.bVu.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bVu, layoutParams);
                this.bTn++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
