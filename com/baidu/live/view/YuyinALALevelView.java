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
/* loaded from: classes11.dex */
public class YuyinALALevelView extends LinearLayout {
    private FrameLayout bSi;
    private TbImageView bSj;
    private TextView bSk;
    private TbImageView bSn;
    private int bSr;
    private int bSs;
    private AlaLiveMarkData bSu;
    private AlaLiveMarkData bSv;
    private TbImageView bSw;
    private AlaLiveMarkData bUA;
    private AlaLiveMarkData bUB;
    private AlaLiveMarkData bUC;
    private TbImageView bUx;
    private TbImageView bUy;
    private TbImageView bUz;

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
        this.bSr = 0;
        this.bSs = 0;
        ao(bVar.live_mark_info_new);
        an(bVar.live_mark_info_new);
        ap(bVar.live_mark_info_new);
        aq(bVar.live_mark_info_new);
        ar(bVar.live_mark_info_new);
        removeAllViews();
        XI();
        setupLevelIconImage(bVar.live_mark_info_new, bVar.level_id);
        Xm();
        XH();
        XJ();
        Xk();
    }

    public void an(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bSv = null;
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
                this.bSv = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bSv = null;
        }
    }

    public void ap(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bUA = null;
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
                this.bUA = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bUA = null;
        }
    }

    public void aq(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bUB = null;
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
                this.bUB = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bUB = null;
        }
    }

    public void ar(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bUC = null;
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
                this.bUC = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bUC = null;
        }
    }

    public void setData4Yuyin(AlaLiveUserInfoData alaLiveUserInfoData) {
        if (alaLiveUserInfoData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bSr = 0;
        this.bSs = 0;
        ao(alaLiveUserInfoData.live_mark_info_new);
        an(alaLiveUserInfoData.live_mark_info_new);
        ar(alaLiveUserInfoData.live_mark_info_new);
        removeAllViews();
        XI();
        setupLevelIconImage(alaLiveUserInfoData.live_mark_info_new, alaLiveUserInfoData.levelId);
        Xm();
        XH();
        XJ();
        Xk();
    }

    public void setData4Yuyin(df dfVar) {
        if (dfVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bSr = 0;
        this.bSs = 0;
        ao(dfVar.live_mark_info_new);
        an(dfVar.live_mark_info_new);
        ar(dfVar.live_mark_info_new);
        removeAllViews();
        if (dfVar.level_id > 0) {
            setupLevelIconImage(dfVar.live_mark_info_new, dfVar.level_id);
        }
        Xm();
        Xk();
        XI();
        XH();
        XJ();
    }

    public void ao(List<AlaLiveMarkData> list) {
        int i;
        if (list == null) {
            this.bSu = null;
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
                this.bSu = alaLiveMarkData;
                break;
            }
        }
        if (i >= list.size()) {
            this.bSu = null;
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
            if (this.bSj == null) {
                this.bSj = new TbImageView(getContext());
                this.bSj.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                this.bSj.stopLoad();
            }
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i3 = (alaLiveMarkData.width <= 0 || alaLiveMarkData.height <= 0) ? dimensionPixelSize : (int) (((1.0f * alaLiveMarkData.width) / alaLiveMarkData.height) * dimensionPixelSize);
            if (this.bSj.getLayoutParams() == null) {
                layoutParams = new FrameLayout.LayoutParams(i3, dimensionPixelSize);
                layoutParams.gravity = 17;
            } else {
                layoutParams = (FrameLayout.LayoutParams) this.bSj.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = dimensionPixelSize;
                layoutParams.gravity = 17;
            }
            this.bSj.setLayoutParams(layoutParams);
            if (this.bSi == null) {
                this.bSi = new FrameLayout(getContext());
                this.bSi.setBackgroundColor(0);
            }
            if (this.bSj.getParent() == null) {
                this.bSi.addView(this.bSj);
            }
            if (this.bSk == null) {
                this.bSk = new TextView(getContext());
                this.bSk.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
                this.bSk.setTextSize(0, getResources().getDimensionPixelOffset(a.d.sdk_tbfontsize26));
                this.bSk.setGravity(17);
                this.bSk.getPaint().setFakeBoldText(true);
            }
            if (this.bSk.getParent() == null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 17;
                this.bSi.addView(this.bSk, layoutParams2);
            }
            this.bSj.startLoad(alaLiveMarkData.mark_pic, 10, false);
            if (this.bSi.getParent() == null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 16;
                layoutParams3.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bSi, layoutParams3);
            }
            this.bSr++;
        }
    }

    private void Xk() {
        if (this.bSu == null || this.bSu.type != 2) {
            a(this.bSn);
        } else if (TextUtils.isEmpty(this.bSu.mark_pic)) {
            a(this.bSn);
        } else {
            if (this.bSn == null) {
                this.bSn = new TbImageView(getContext());
                this.bSn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bSn.stopLoad();
            }
            this.bSn.startLoad(this.bSu.mark_pic, 10, false);
            if (this.bSn.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(a.d.sdk_ds44), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds32));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bSn, layoutParams);
                this.bSr++;
            }
        }
    }

    private void Xm() {
        if (this.bSv == null || this.bSv.type != 105) {
            a(this.bSw);
        } else if (TextUtils.isEmpty(this.bSv.mark_pic)) {
            a(this.bSw);
        } else {
            if (this.bSw == null) {
                this.bSw = new TbImageView(getContext());
                this.bSw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bSw.stopLoad();
            }
            this.bSw.startLoad(this.bSv.mark_pic, 10, false);
            if (this.bSw.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.dip2px(getContext(), 38.0f), BdUtilHelper.dip2px(getContext(), 16.0f));
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 5.0f);
                addView(this.bSw, layoutParams);
                this.bSr++;
            }
        }
    }

    private void XH() {
        if (this.bUA == null || this.bUA.type != 103) {
            a(this.bUx);
        } else if (TextUtils.isEmpty(this.bUA.mark_pic)) {
            a(this.bUx);
        } else {
            if (this.bUx == null) {
                this.bUx = new TbImageView(getContext());
                this.bUx.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bUx.stopLoad();
            }
            this.bUx.startLoad(this.bUA.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bUA.width <= 0 || this.bUA.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bUA.width) / this.bUA.height) * dimensionPixelSize);
            if (this.bUx.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bUx, layoutParams);
                this.bSr++;
            }
        }
    }

    private void XI() {
        if (this.bUC == null || this.bUC.type != 300) {
            a(this.bUz);
        } else if (TextUtils.isEmpty(this.bUC.mark_pic)) {
            a(this.bUz);
        } else {
            if (this.bUz == null) {
                this.bUz = new TbImageView(getContext());
                this.bUz.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bUz.stopLoad();
            }
            this.bUz.startLoad(this.bUC.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bUC.width <= 0 || this.bUC.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bUC.width) / this.bUC.height) * dimensionPixelSize);
            if (this.bUz.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                addView(this.bUz, 0, layoutParams);
                this.bSr++;
            }
        }
    }

    private void XJ() {
        if (this.bUB == null || this.bUB.type != 104) {
            a(this.bUy);
        } else if (TextUtils.isEmpty(this.bUB.mark_pic)) {
            a(this.bUy);
        } else {
            if (this.bUy == null) {
                this.bUy = new TbImageView(getContext());
                this.bUy.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            } else {
                this.bUy.stopLoad();
            }
            this.bUy.startLoad(this.bUB.mark_pic, 10, false);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds32);
            int i = (this.bUB.width <= 0 || this.bUB.height <= 0) ? dimensionPixelSize : (int) (((1.0f * this.bUB.width) / this.bUB.height) * dimensionPixelSize);
            if (this.bUy.getParent() == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, dimensionPixelSize);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = BdUtilHelper.dip2px(getContext(), 4.0f);
                addView(this.bUy, layoutParams);
                this.bSr++;
            }
        }
    }

    private void a(TbImageView tbImageView) {
        if (tbImageView != null && tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
    }
}
