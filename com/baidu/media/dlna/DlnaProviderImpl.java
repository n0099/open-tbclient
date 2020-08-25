package com.baidu.media.dlna;

import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.media.duplayer.Keep;
@Keep
/* loaded from: classes12.dex */
public class DlnaProviderImpl extends DlnaProvider {
    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public CtrlPointProvider ctrlPoint(String str) {
        return DlnaApi.ctrlPoint(str);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        DlnaApi.search(dlnaSearchListener);
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public void stop() {
        DlnaApi.stop();
    }
}
