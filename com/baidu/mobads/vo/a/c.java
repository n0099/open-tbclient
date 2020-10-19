package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobstat.Config;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c extends a {
    public boolean o;
    private Context p;
    private IXAppInfo q;

    public c(Context context, IXAppInfo iXAppInfo) {
        super(iXAppInfo.getAdId(), iXAppInfo.getQk(), iXAppInfo.getProd());
        this.o = true;
        this.p = context;
        this.q = iXAppInfo;
    }

    @Override // com.baidu.mobads.vo.a.a
    protected HashMap<String, String> b() {
        String str = "" + XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessId(this.p);
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("autoOpen", this.o ? "true" : "false");
            hashMap.put("pk", this.q.getPackageName());
            hashMap.put("c", "0");
            hashMap.put("clickProcId", str);
            hashMap.put("clickTime", this.q.getClickTime() + "");
            hashMap.put("contentLength", "" + this.q.getAppSize());
            hashMap.put("dlCnt", "1");
            hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.q.getClickTime()));
            hashMap.put("dlTunnel", "3");
            hashMap.put("dlWay", this.q.isTooLarge() ? "1" : "0");
            hashMap.put("exp_id", "");
            hashMap.put("exp2", "");
            hashMap.put(Config.INPUT_DEF_PKG, this.q.getPackageName());
            hashMap.put("typeProcId", str);
            hashMap.put("url2", "");
            hashMap.put(IXAdRequestInfo.SN, XAdSDKFoundationFacade.getInstance().getBase64().encode(XAdSDKFoundationFacade.getInstance().getSystemUtils().getIMEI(this.p)));
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
        return hashMap;
    }
}
