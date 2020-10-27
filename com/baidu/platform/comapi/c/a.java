package com.baidu.platform.comapi.c;

import android.util.Log;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.util.k;
import com.baidu.platform.comjni.base.networkdetect.NANetworkDetect;
import com.baidu.platform.comjni.engine.NAEngine;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private NANetworkDetect f2854a;

    /* renamed from: com.baidu.platform.comapi.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static final class C0268a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f2855a = new a(null);
    }

    private a() {
    }

    /* synthetic */ a(b bVar) {
        this();
    }

    public static a a() {
        return C0268a.f2855a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Log.d("NetworkLogic", "NetworkDetect");
        if (this.f2854a == null) {
            this.f2854a = new NANetworkDetect();
            this.f2854a.create();
        }
        String currentNetMode = NetworkUtil.getCurrentNetMode(com.baidu.platform.comapi.b.e());
        HashMap hashMap = new HashMap();
        hashMap.put("nettype", currentNetMode);
        com.baidu.platform.comapi.e.a.a().a("update_net", hashMap);
        k.a(com.baidu.platform.comapi.b.e());
        SysOSUtil.getInstance().updateNetType(currentNetMode);
        if (this.f2854a != null) {
            try {
                JsonBuilder jsonBuilder = new JsonBuilder();
                jsonBuilder.object();
                try {
                    jsonBuilder.key("nettype").value(Integer.parseInt(currentNetMode));
                } catch (NumberFormatException e) {
                    jsonBuilder.key("nettype").value(-1);
                }
                int networkOperatorType = NetworkUtil.getNetworkOperatorType(com.baidu.platform.comapi.b.e());
                jsonBuilder.key("telecomtype").value(networkOperatorType);
                jsonBuilder.key("triggerType").value(str);
                jsonBuilder.endObject();
                this.f2854a.a(jsonBuilder.toString());
                hashMap.put("telcomtype", String.valueOf(networkOperatorType));
                com.baidu.platform.comapi.e.a.a().a("net_detect", hashMap);
            } catch (Exception e2) {
            }
        }
    }

    public void b() {
        Log.d("NetworkLogic", "onReady");
        NAEngine.startRunningRequest();
    }
}
