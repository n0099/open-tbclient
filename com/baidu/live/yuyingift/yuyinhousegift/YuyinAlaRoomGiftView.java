package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.aj.b;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.bm;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class YuyinAlaRoomGiftView extends RelativeLayout {
    private int bNA;
    private int bNw;
    private int[] bNx;
    private a bNy;
    private int bNz;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    static /* synthetic */ int a(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bNA;
        yuyinAlaRoomGiftView.bNA = i - 1;
        return i;
    }

    static /* synthetic */ int c(YuyinAlaRoomGiftView yuyinAlaRoomGiftView) {
        int i = yuyinAlaRoomGiftView.bNz;
        yuyinAlaRoomGiftView.bNz = i - 1;
        return i;
    }

    public YuyinAlaRoomGiftView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.bNx = new int[2];
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
        this.bNz = 0;
        removeAllViews();
        ArrayList<AlaWheatInfoData> arrayList = new ArrayList();
        List<r.a> io2 = r.io(cVar.bja);
        if (io2 != null && io2.size() > 0) {
            for (r.a aVar : io2) {
                String str = aVar.uk;
                AlaWheatInfoData iL = b.UH().iL(str);
                if (iL == null) {
                    if (b.UH().iJ(str)) {
                        AlaWheatInfoData UJ = b.UH().UJ();
                        UJ.locationCenterX = 0.0f;
                        UJ.locationCenterY = 0.0f;
                        arrayList.add(UJ);
                    }
                } else {
                    arrayList.add(iL);
                }
            }
            for (AlaWheatInfoData alaWheatInfoData : arrayList) {
                this.bNz++;
                this.bNA++;
                final YuyinAlaRoomGiftItemView yuyinAlaRoomGiftItemView = new YuyinAlaRoomGiftItemView(getContext());
                yuyinAlaRoomGiftItemView.setAnimalCallBack(new YuyinAlaRoomGiftItemView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.1
                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void Vz() {
                        YuyinAlaRoomGiftView.a(YuyinAlaRoomGiftView.this);
                        if (YuyinAlaRoomGiftView.this.bNA <= 0) {
                            com.baidu.live.yuyingift.b.g(cVar);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                        }
                    }

                    @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftItemView.a
                    public void VA() {
                        YuyinAlaRoomGiftView.c(YuyinAlaRoomGiftView.this);
                        YuyinAlaRoomGiftView.this.removeView(yuyinAlaRoomGiftItemView);
                        if (YuyinAlaRoomGiftView.this.bNz <= 0) {
                            YuyinAlaRoomGiftView.this.bNy.onAnimEnd();
                        }
                    }
                });
                addView(yuyinAlaRoomGiftItemView, 0, new RelativeLayout.LayoutParams(-2, -2));
                yuyinAlaRoomGiftItemView.a(getStartLoc()[0], getStartLoc()[1], alaWheatInfoData, cVar);
            }
            start();
        } else if (this.bNy != null) {
            this.bNy.onAnimEnd();
        }
    }

    private void start() {
        if (getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    ((YuyinAlaRoomGiftItemView) getChildAt(i2)).Vy();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (this.bNy != null) {
            this.bNy.onAnimEnd();
        }
    }

    private int[] getStartLoc() {
        if (this.bNx[0] == 0) {
            this.bNx = BdUtilHelper.getScreenDimensions(getContext());
            int[] iArr = this.bNx;
            iArr[0] = iArr[0] / 2;
            int[] iArr2 = this.bNx;
            iArr2[1] = iArr2[1] - getGiftPanelHeight();
        }
        return this.bNx;
    }

    public void setCallBack(a aVar) {
        this.bNy = aVar;
    }

    private int getGiftPanelHeight() {
        if (this.bNw <= 0) {
            this.bNw = getDataPagerHeight();
            this.bNw += getNobalHeight();
            this.bNw += getMicrophoneListHeight();
            this.bNw += getOffset();
        }
        return this.bNw;
    }

    private int getOffset() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds266);
    }

    private int getMicrophoneListHeight() {
        return getResources().getDimensionPixelOffset(a.e.sdk_ds96);
    }

    private int getNobalHeight() {
        if (VD()) {
            return getResources().getDimensionPixelOffset(a.e.yuyin_ala_dimen_gift_noblr_maginbottom) + getResources().getDimensionPixelOffset(a.e.yuyin_ala_dimen_gift_noble_height);
        }
        return 0;
    }

    private int getDataPagerHeight() {
        return (getResources().getDimensionPixelOffset(a.e.sdk_ds192) * 2) + getResources().getDimensionPixelOffset(a.e.sdk_ds4) + getResources().getDimensionPixelOffset(a.e.sdk_ds12) + getResources().getDimensionPixelOffset(a.e.sdk_ds116) + getResources().getDimensionPixelOffset(a.e.yuyin_ala_dimen_gift_tabbar_height);
    }

    private boolean VD() {
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return false;
        }
        if (bmVar == null || bmVar.aOD == null || (bmVar.aOD.aQU && bmVar.aOD.aQV && bmVar.aOD.aQW)) {
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
