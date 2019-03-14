package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c extends Handler {
    final /* synthetic */ InnerPanoramaView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InnerPanoramaView innerPanoramaView) {
        this.a = innerPanoramaView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HashMap hashMap;
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                hashMap = this.a.d;
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (str.equals(entry.getKey()) && ((com.baidu.pano.platform.comapi.a.a) entry.getValue()).mListener != null) {
                        ((com.baidu.pano.platform.comapi.a.a) entry.getValue()).mListener.onTab();
                    }
                }
                return;
            default:
                return;
        }
    }
}
