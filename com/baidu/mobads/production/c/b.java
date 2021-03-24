package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends d {
    public b(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.f8625b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm");
    }

    @Override // com.baidu.mobads.vo.d
    public HashMap<String, String> a() {
        return new HashMap<>();
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return "http://127.0.0.1";
    }
}
