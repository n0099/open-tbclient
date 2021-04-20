package com.baidu.mobads.container.bridge;

import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
/* loaded from: classes2.dex */
public interface BridgeListener {
    void onAdClicked(IXAdInstanceInfo iXAdInstanceInfo);

    void onAdFailed(String str);

    void onAdShow();

    @Deprecated
    void onAdSwitch();

    void onClose();

    void onExpand(boolean z);

    void onInited();

    void onPlayVideo(String str);

    void onPreloadEnd(boolean z);

    void onUseCustomClose(boolean z);

    void onVisibilityChanged(boolean z);

    void setVisibility(int i);
}
