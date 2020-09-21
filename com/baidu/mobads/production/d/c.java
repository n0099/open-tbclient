package com.baidu.mobads.production.d;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c extends d {
    public c(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm");
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        return new HashMap<>();
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return "http://127.0.0.1";
    }
}
