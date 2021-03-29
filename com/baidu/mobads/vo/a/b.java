package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.a.a;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends a {
    public String o;
    public HashMap<String, String> p;

    public b(String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, HashMap<String, String> hashMap) {
        super(new a.C0110a(iXAdInstanceInfo, iXAdProdInfo));
        this.o = "";
        this.p = null;
        this.o = str;
        this.p = hashMap;
    }

    public String a(Context context) {
        HashMap<String, String> c2 = c();
        try {
            StringBuilder sb = new StringBuilder("type=" + this.o + "&");
            StringBuilder sb2 = new StringBuilder();
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            for (String str : c2.keySet()) {
                String str2 = c2.get(str);
                if (str != null && str2 != null) {
                    String encodeURIComponent = commonUtils.encodeURIComponent(str);
                    String encodeURIComponent2 = commonUtils.encodeURIComponent(str2);
                    sb.append(encodeURIComponent);
                    sb.append("=");
                    sb.append(encodeURIComponent2);
                    sb.append("&");
                    sb2.append(encodeURIComponent2);
                    sb2.append(",");
                }
            }
            return "https://mobads-logs.baidu.com/dz.zb?" + sb.toString();
        } catch (Exception e2) {
            q.a().d(e2);
            return "";
        }
    }

    @Override // com.baidu.mobads.vo.a.a
    public HashMap<String, String> b() {
        if (this.p == null) {
            this.p = new HashMap<>();
        }
        return this.p;
    }
}
