package com.baidu.platform.comapi.wnplatform.j;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.fsg.base.statistics.h;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.wnplatform.e.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    private c f3125a = null;
    private a b = null;
    private b c = null;
    private int d = 1;
    private int e = 0;
    private boolean f = false;
    private Handler g = new e(this);

    public d() {
        MessageCenter.registMessage(2008, this.g);
        MessageCenter.registMessage(4099, this.g);
        c();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        MessageCenter.unregistMessage(4099, this.g);
        MessageCenter.unregistMessage(2008, this.g);
        this.f3125a = null;
        this.b = null;
        this.f = false;
        this.g = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    private void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(int i) {
        return com.baidu.platform.comapi.walknavi.b.a().G().b(i);
    }

    public com.baidu.platform.comapi.wnplatform.e.a a() {
        if (this.e != 0) {
            return com.baidu.platform.comapi.walknavi.b.a().G().a(this.e);
        }
        return null;
    }

    public void a(c cVar) {
        this.f3125a = cVar;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        return com.baidu.platform.comapi.walknavi.b.a().G().a(iArr, iArr2, iArr3, iArr4);
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2) {
        return com.baidu.platform.comapi.walknavi.b.a().G().a(iArr, iArr2, iArr3, iArr4, strArr, strArr2);
    }

    public int a(int i, int i2, int i3, int i4, byte[] bArr) {
        if (this.f3125a != null) {
            this.f3125a.a();
        }
        return com.baidu.platform.comapi.walknavi.b.a().G().a(i, i2, i3, i4, bArr);
    }

    public int a(WalkNaviLaunchParam walkNaviLaunchParam) {
        if (this.c != null) {
            this.c.a();
        }
        this.e = com.baidu.platform.comapi.walknavi.b.a().G().a(b(walkNaviLaunchParam));
        return 0;
    }

    private String b(WalkNaviLaunchParam walkNaviLaunchParam) {
        com.baidu.platform.comapi.wnplatform.e.e eVar = new com.baidu.platform.comapi.wnplatform.e.e();
        eVar.a("qt", "walkplan");
        eVar.a(IXAdRequestInfo.SN, walkNaviLaunchParam.getStartNodeInfo().toQuery());
        eVar.a(h.f1497a, walkNaviLaunchParam.getEndNodeInfo().toQuery());
        eVar.a("run", 0);
        eVar.a("mt_rt", -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < walkNaviLaunchParam.getViaNodes().size(); i++) {
            try {
                JSONObject jSONObject = new JSONObject(walkNaviLaunchParam.getViaNodes().get(i).toQuery());
                if (jSONObject != null) {
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (jSONArray.length() != 0) {
            eVar.a("wp", jSONArray.toString());
        }
        int citycode = walkNaviLaunchParam.getStartNodeInfo().getCitycode();
        if (citycode != -1) {
            eVar.a("c", IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
            eVar.a(Config.STAT_SDK_CHANNEL, citycode);
        }
        int citycode2 = walkNaviLaunchParam.getEndNodeInfo().getCitycode();
        if (citycode2 != -1) {
            eVar.a("ec", citycode2);
        }
        eVar.a("version", 6);
        eVar.a("rp_format", "pb");
        eVar.a("from_navi", 0);
        eVar.a("spath_type", 1);
        eVar.b(13);
        eVar.a(true);
        eVar.b(false);
        eVar.a(e.a.PROTOBUF);
        eVar.a(e.b.GET);
        eVar.a(FAUEnum.PR_ANIMATE_FAILED);
        return eVar.toString();
    }

    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().G().c();
    }
}
