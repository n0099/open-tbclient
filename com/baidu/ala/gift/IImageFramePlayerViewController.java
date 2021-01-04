package com.baidu.ala.gift;

import android.view.View;
/* loaded from: classes10.dex */
public interface IImageFramePlayerViewController {
    View getAnimView();

    void onDestroy();

    void setData(AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData);

    void setFrameCallback(IFrameCallback iFrameCallback);

    void startAnim();

    void stopAnim();
}
