package com.baidu.media.dlna;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.cyberplayer.sdk.dlna.DlnaProvider;
import com.baidu.media.duplayer.Keep;
@Keep
/* loaded from: classes2.dex */
public class DlnaProviderImpl extends DlnaProvider {
    public static String TAG = "DLNA-DlnaProviderImpl";

    /* renamed from: a  reason: collision with root package name */
    public boolean f8013a;

    public DlnaProviderImpl() {
        this.f8013a = false;
        this.f8013a = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DLNA, false);
    }

    public static DlnaProvider create() {
        return new DlnaProviderImpl();
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public CtrlPointProvider ctrlPoint(String str) {
        if (this.f8013a) {
            return DlnaApi.ctrlPoint(str);
        }
        CyberLog.d(TAG, "ctrlPoint() DLNA not enable");
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public void search(DlnaProvider.DlnaSearchListener dlnaSearchListener) {
        if (this.f8013a) {
            DlnaApi.search(dlnaSearchListener);
        } else {
            CyberLog.d(TAG, "search() DLNA not enable");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.DlnaProvider
    public void stop() {
        if (this.f8013a) {
            DlnaApi.stop();
        } else {
            CyberLog.d(TAG, "stop() DLNA not enable");
        }
    }
}
