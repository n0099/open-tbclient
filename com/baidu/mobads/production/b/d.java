package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class d extends com.baidu.mobads.vo.d {
    public d(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType, String str, String str2) {
        super(context, activity, slotType);
        this.b = new c(context.getApplicationContext(), str2, str).a();
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        return new HashMap<>();
    }

    public String c() {
        return this.b;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return "http://127.0.0.1";
    }
}
