package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ap.b;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.bo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinAlaRoomGiftView extends RelativeLayout {
    private int bWL;
    private int[] bWM;
    private a bWN;
    private int bWO;
    private int bWP;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    static /* synthetic */ int a(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bWP;
        yuyinAlaRoomGiftView.bWP = i - 1;
        return i;
    }

    static /* synthetic */ int c(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bWO;
        yuyinAlaRoomGiftView.bWO = i - 1;
        return i;
    }

    public YuyinAlaRoomGiftView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.bWM = new int[2];
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
        this.bWO = 0;
        removeAllViews();
        ArrayList<AlaWheatInfoData> arrayList = new ArrayList();
        List<r.a> jf = r.jf(cVar.bnb);
        if (jf != null && jf.size() > 0) {
            for (r.a aVar : jf) {
                String str = aVar.uk;
                AlaWheatInfoData jw = b.YX().jw(str);
                if (jw == null) {
                    if (b.YX().ju(str)) {
                        AlaWheatInfoData YY = b.YX().YY();
                        YY.locationCenterX = 0.0f;
                        YY.locationCenterY = 0.0f;
                        arrayList.add(YY);
                    }
                } else {
                    arrayList.add(jw);
                }
            }
            for (AlaWheatInfoData alaWheatInfoData : arrayList) {
                this.bWO++;
                this.bWP++;
                final YuyinAlaRoomGiftItemView yuyinAlaRoomGiftItemView = new YuyinAlaRoomGiftItemView(getContext());
                yuyinAlaRoomGiftItemView.setAnimalCallBack(new YuyinAlaRoomGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void ZR() {
                        YuyinAlaRoomGiftView.a(YuyinAlaRoomGiftView.this);
                        if (YuyinAlaRoomGiftView.this.bWP <= 0) {
                            com.baidu.live.yuyingift.b.g(cVar);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        }
                    }

                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void ZS() {
                        YuyinAlaRoomGiftView.c(YuyinAlaRoomGiftView.this);
                        YuyinAlaRoomGiftView.this.removeView(yuyinAlaRoomGiftItemView);
                        if (YuyinAlaRoomGiftView.this.bWO <= 0) {
                            YuyinAlaRoomGiftView.this.bWN.onAnimEnd();
                        }
                    }
                });
                addView(yuyinAlaRoomGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
                yuyinAlaRoomGiftItemView.a(getStartLoc()[0], getStartLoc()[1], alaWheatInfoData, cVar);
            }
            start();
        } else if (this.bWN != null) {
            this.bWN.onAnimEnd();
        }
    }

    private void start() {
        if (getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    ((YuyinAlaRoomGiftItemView) getChildAt(i2)).ZQ();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (this.bWN != null) {
            this.bWN.onAnimEnd();
        }
    }

    private int[] getStartLoc() {
        if (this.bWM[0] == 0) {
            this.bWM = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.bWM;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.bWM;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.bWM;
    }

    public void setCallBack(a aVar) {
        this.bWN = aVar;
    }

    private int getGiftPanelHeight() {
        if (this.bWL <= 0) {
            this.bWL = getDataPagerHeight();
            this.bWL += getNobalHeight();
            this.bWL += getMicrophoneListHeight();
            this.bWL += getOffset();
        }
        return this.bWL;
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.d.sdk_ds96);
    }

    private int getNobalHeight() {
        if (ZV()) {
            return getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.d.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.d.sdk_ds4) + getResources().getDimensionPixelOffset(a.d.sdk_ds12) + getResources().getDimensionPixelOffset(a.d.sdk_ds116) + getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean ZV() {
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        if (boVar == null || boVar.aQP == null || (boVar.aQP.aTn && boVar.aQP.aTo && boVar.aQP.aTp)) {
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
