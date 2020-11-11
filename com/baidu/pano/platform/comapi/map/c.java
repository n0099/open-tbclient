package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InnerPanoramaView f2680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(InnerPanoramaView innerPanoramaView) {
        this.f2680a = innerPanoramaView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HashMap hashMap;
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                hashMap = this.f2680a.d;
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
