package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.al.b;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.bn;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinAlaRoomGiftView extends RelativeLayout {
    private int bTf;
    private int[] bTg;
    private a bTh;
    private int bTi;
    private int bTj;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    static /* synthetic */ int a(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bTj;
        yuyinAlaRoomGiftView.bTj = i - 1;
        return i;
    }

    static /* synthetic */ int c(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bTi;
        yuyinAlaRoomGiftView.bTi = i - 1;
        return i;
    }

    public YuyinAlaRoomGiftView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.bTg = new int[2];
    }

    public boolean s(c cVar) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = 0;
            int i2 = 0;
            while (i < childCount) {
                int i3 = ((YuyinAlaRoomGiftItemView) getChildAt(i)).q(cVar) ? i2 + 1 : i2;
                i++;
                i2 = i3;
            }
            if (i2 > 0) {
                return true;
            }
        }
        return false;
    }

    public void setData(final c cVar) {
        this.bTi = 0;
        removeAllViews();
        ArrayList<AlaWheatInfoData> arrayList = new ArrayList();
        List<r.a> iH = r.iH(cVar.bku);
        if (iH != null && iH.size() > 0) {
            for (r.a aVar : iH) {
                String str = aVar.uk;
                AlaWheatInfoData iY = b.Xh().iY(str);
                if (iY == null) {
                    if (b.Xh().iW(str)) {
                        AlaWheatInfoData Xi = b.Xh().Xi();
                        Xi.locationCenterX = 0.0f;
                        Xi.locationCenterY = 0.0f;
                        arrayList.add(Xi);
                    }
                } else {
                    arrayList.add(iY);
                }
            }
            for (AlaWheatInfoData alaWheatInfoData : arrayList) {
                this.bTi++;
                this.bTj++;
                final YuyinAlaRoomGiftItemView yuyinAlaRoomGiftItemView = new YuyinAlaRoomGiftItemView(getContext());
                yuyinAlaRoomGiftItemView.setAnimalCallBack(new YuyinAlaRoomGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void XY() {
                        YuyinAlaRoomGiftView.a(YuyinAlaRoomGiftView.this);
                        if (YuyinAlaRoomGiftView.this.bTj <= 0) {
                            com.baidu.live.yuyingift.b.g(cVar);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        }
                    }

                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void XZ() {
                        YuyinAlaRoomGiftView.c(YuyinAlaRoomGiftView.this);
                        YuyinAlaRoomGiftView.this.removeView(yuyinAlaRoomGiftItemView);
                        if (YuyinAlaRoomGiftView.this.bTi <= 0) {
                            YuyinAlaRoomGiftView.this.bTh.onAnimEnd();
                        }
                    }
                });
                addView(yuyinAlaRoomGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
                yuyinAlaRoomGiftItemView.a(getStartLoc()[0], getStartLoc()[1], alaWheatInfoData, cVar);
            }
            start();
        } else if (this.bTh != null) {
            this.bTh.onAnimEnd();
        }
    }

    private void start() {
        if (getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    ((YuyinAlaRoomGiftItemView) getChildAt(i2)).XX();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (this.bTh != null) {
            this.bTh.onAnimEnd();
        }
    }

    private int[] getStartLoc() {
        if (this.bTg[0] == 0) {
            this.bTg = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.bTg;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.bTg;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.bTg;
    }

    public void setCallBack(a aVar) {
        this.bTh = aVar;
    }

    private int getGiftPanelHeight() {
        if (this.bTf <= 0) {
            this.bTf = getDataPagerHeight();
            this.bTf += getNobalHeight();
            this.bTf += getMicrophoneListHeight();
            this.bTf += getOffset();
        }
        return this.bTf;
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds96);
    }

    private int getNobalHeight() {
        if (Yc()) {
            return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean Yc() {
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        if (bnVar == null || bnVar.aPA == null || (bnVar.aPA.aRW && bnVar.aPA.aRX && bnVar.aPA.aRY)) {
            return TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((YuyinAlaRoomGiftItemView) getChildAt(i)).cancel();
        }
    }

    public void onDestory() {
        onDetachedFromWindow();
    }
}
