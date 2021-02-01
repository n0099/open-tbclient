package com.baidu.mobads.production.cpu;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class e extends com.baidu.mobads.vo.d {
    public e(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType, String str, String str2, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context, activity, slotType);
        d dVar = new d(context.getApplicationContext(), str2, str);
        this.f3529b = a(a(dVar, cPUWebAdRequestParam), dVar.a()).build().toString();
    }

    private Uri.Builder a(Map<String, Object> map, String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                buildUpon.appendQueryParameter(str2, (String) map.get(str2));
            }
        }
        return buildUpon;
    }

    private Map<String, Object> a(d dVar, CPUWebAdRequestParam cPUWebAdRequestParam) {
        if (cPUWebAdRequestParam == null) {
            return null;
        }
        Map<String, Object> parameters = cPUWebAdRequestParam.getParameters();
        if (parameters != null && parameters.containsKey("outerId")) {
            dVar.a((String) parameters.get("outerId"));
            parameters.remove("outerId");
        }
        return parameters;
    }

    public e(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context, activity, slotType);
        d dVar = new d(context.getApplicationContext(), i, str);
        if (i != 1080) {
            cPUWebAdRequestParam.getParameters().remove("city");
        }
        this.f3529b = a(a(dVar, cPUWebAdRequestParam), dVar.a()).build().toString();
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        return new HashMap<>();
    }

    public String c() {
        return this.f3529b;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return "http://127.0.0.1";
    }
}
