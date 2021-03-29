package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends d {
    public b(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.f8626b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
    }

    @Override // com.baidu.mobads.vo.d
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON");
        return hashMap;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }
}
