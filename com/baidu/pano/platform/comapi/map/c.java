package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InnerPanoramaView f9483a;

    public c(InnerPanoramaView innerPanoramaView) {
        this.f9483a = innerPanoramaView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HashMap hashMap;
        if (message.what != 1001) {
            return;
        }
        String str = (String) message.obj;
        hashMap = this.f9483a.f9477d;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (str.equals(entry.getKey()) && ((com.baidu.pano.platform.comapi.a.a) entry.getValue()).mListener != null) {
                ((com.baidu.pano.platform.comapi.a.a) entry.getValue()).mListener.onTab();
            }
        }
    }
}
