package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f extends com.baidu.mobads.vo.d {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f3480a;

    public f(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType, Boolean bool) {
        super(context, activity, slotType);
        this.f3480a = bool;
        if (c().booleanValue()) {
            this.f3563b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm");
        }
    }

    public Boolean c() {
        return this.f3480a;
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return c().booleanValue() ? super.b() : "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
