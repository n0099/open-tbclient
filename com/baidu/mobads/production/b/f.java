package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobad.feeds.ArticleInfo;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class f extends com.baidu.mobads.vo.d {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f2448a;

    public f(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.j) {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
        } else {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
        }
        if (this.f2448a != null && !this.f2448a.isEmpty()) {
            hashMap.putAll(this.f2448a);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Map<String, String> map) {
        if (this.f2448a == null) {
            this.f2448a = new HashMap<>();
        } else {
            this.f2448a.clear();
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    this.f2448a.put(e(entry.getKey().trim()), entry.getValue().trim());
                } catch (Throwable th) {
                }
            }
        }
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
    public String b() {
        return super.b();
    }
}
