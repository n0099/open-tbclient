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
    private int bRv;
    private int[] bRw;
    private a bRx;
    private int bRy;
    private int bRz;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    static /* synthetic */ int a(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bRz;
        yuyinAlaRoomGiftView.bRz = i - 1;
        return i;
    }

    static /* synthetic */ int c(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bRy;
        yuyinAlaRoomGiftView.bRy = i - 1;
        return i;
    }

    public YuyinAlaRoomGiftView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.bRw = new int[2];
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
        this.bRy = 0;
        removeAllViews();
        ArrayList<AlaWheatInfoData> arrayList = new ArrayList();
        List<r.a> iB = r.iB(cVar.biJ);
        if (iB != null && iB.size() > 0) {
            for (r.a aVar : iB) {
                String str = aVar.uk;
                AlaWheatInfoData iS = b.Wy().iS(str);
                if (iS == null) {
                    if (b.Wy().iQ(str)) {
                        AlaWheatInfoData Wz = b.Wy().Wz();
                        Wz.locationCenterX = 0.0f;
                        Wz.locationCenterY = 0.0f;
                        arrayList.add(Wz);
                    }
                } else {
                    arrayList.add(iS);
                }
            }
            for (AlaWheatInfoData alaWheatInfoData : arrayList) {
                this.bRy++;
                this.bRz++;
                final YuyinAlaRoomGiftItemView yuyinAlaRoomGiftItemView = new YuyinAlaRoomGiftItemView(getContext());
                yuyinAlaRoomGiftItemView.setAnimalCallBack(new YuyinAlaRoomGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void Xp() {
                        YuyinAlaRoomGiftView.a(YuyinAlaRoomGiftView.this);
                        if (YuyinAlaRoomGiftView.this.bRz <= 0) {
                            com.baidu.live.yuyingift.b.g(cVar);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        }
                    }

                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void Xq() {
                        YuyinAlaRoomGiftView.c(YuyinAlaRoomGiftView.this);
                        YuyinAlaRoomGiftView.this.removeView(yuyinAlaRoomGiftItemView);
                        if (YuyinAlaRoomGiftView.this.bRy <= 0) {
                            YuyinAlaRoomGiftView.this.bRx.onAnimEnd();
                        }
                    }
                });
                addView(yuyinAlaRoomGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
                yuyinAlaRoomGiftItemView.a(getStartLoc()[0], getStartLoc()[1], alaWheatInfoData, cVar);
            }
            start();
        } else if (this.bRx != null) {
            this.bRx.onAnimEnd();
        }
    }

    private void start() {
        if (getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    ((YuyinAlaRoomGiftItemView) getChildAt(i2)).Xo();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (this.bRx != null) {
            this.bRx.onAnimEnd();
        }
    }

    private int[] getStartLoc() {
        if (this.bRw[0] == 0) {
            this.bRw = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.bRw;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.bRw;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.bRw;
    }

    public void setCallBack(a aVar) {
        this.bRx = aVar;
    }

    private int getGiftPanelHeight() {
        if (this.bRv <= 0) {
            this.bRv = getDataPagerHeight();
            this.bRv += getNobalHeight();
            this.bRv += getMicrophoneListHeight();
            this.bRv += getOffset();
        }
        return this.bRv;
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds96);
    }

    private int getNobalHeight() {
        if (Xt()) {
            return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean Xt() {
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        if (bnVar == null || bnVar.aNP == null || (bnVar.aNP.aQl && bnVar.aNP.aQm && bnVar.aNP.aQn)) {
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
