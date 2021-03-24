package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobad.feeds.ArticleInfo;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class f extends com.baidu.mobads.vo.d {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f8444a;

    public f(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.f8625b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    private String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : ArticleInfo.PREDEFINED_KEYS) {
                if (str2.equals(str) || "mpt".equals(str)) {
                    return str;
                }
            }
        }
        return "c_" + str;
    }

    @Override // com.baidu.mobads.vo.d
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.j) {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
        } else {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
        }
        HashMap<String, String> hashMap2 = this.f8444a;
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            hashMap.putAll(this.f8444a);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }

    public void a(Map<String, String> map) {
        HashMap<String, String> hashMap = this.f8444a;
        if (hashMap == null) {
            this.f8444a = new HashMap<>();
        } else {
            hashMap.clear();
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                this.f8444a.put(e(entry.getKey().trim()), entry.getValue().trim());
            } catch (Throwable unused) {
            }
        }
    }
}
