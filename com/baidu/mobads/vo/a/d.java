package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.vo.a.a;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class d extends a {
    private String o;
    private HashMap<String, String> p;

    public d(String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, HashMap<String, String> hashMap) {
        super(new a.C0226a(iXAdInstanceInfo, iXAdProdInfo));
        this.o = "";
        this.p = null;
        this.o = str;
        this.p = hashMap;
    }

    @Override // com.baidu.mobads.vo.a.a
    protected HashMap<String, String> b() {
        if (this.p == null) {
            this.p = new HashMap<>();
        }
        return this.p;
    }

    public String a(Context context) {
        HashMap<String, String> c = c();
        try {
            StringBuilder sb = new StringBuilder("type=" + this.o + ETAG.ITEM_SEPARATOR);
            StringBuilder sb2 = new StringBuilder();
            e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            for (String str : c.keySet()) {
                String str2 = c.get(str);
                if (str != null && str2 != null) {
                    String encodeURIComponent = commonUtils.encodeURIComponent(str);
                    String encodeURIComponent2 = commonUtils.encodeURIComponent(str2);
                    sb.append(encodeURIComponent);
                    sb.append(ETAG.EQUAL);
                    sb.append(encodeURIComponent2);
                    sb.append(ETAG.ITEM_SEPARATOR);
                    sb2.append(encodeURIComponent2);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            return "https://mobads-logs.baidu.com/dz.zb?" + sb.toString();
        } catch (Exception e) {
            m.a().d(e);
            return "";
        }
    }
}
