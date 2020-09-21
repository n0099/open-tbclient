package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d extends com.baidu.mobads.vo.d {
    public d(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }
}
