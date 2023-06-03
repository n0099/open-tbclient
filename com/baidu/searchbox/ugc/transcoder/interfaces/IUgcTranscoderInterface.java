package com.baidu.searchbox.ugc.transcoder.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.security.WarmTipsManager;
/* loaded from: classes4.dex */
public interface IUgcTranscoderInterface extends IUgcCommonTranscoderInterface {
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(WarmTipsManager.SHARE_UGC_EXT_VALUE, "transcoder");

    /* loaded from: classes4.dex */
    public interface UgcTranscoderCallback {
        void initCallback(boolean z, int i, String str);
    }

    void init(UgcTranscoderCallback ugcTranscoderCallback);

    boolean isInited();
}
