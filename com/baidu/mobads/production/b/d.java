package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class d extends com.baidu.mobads.vo.d {

    /* renamed from: a  reason: collision with root package name */
    private int f2447a;
    private int l;
    private int m;

    public d(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.f2447a = 1;
        this.l = 1;
        this.m = 1;
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.j) {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,VIDEO");
        } else {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,CLICK2VIDEO,PAUSE,VIDEO");
        }
        hashMap.put("pos", "" + this.l);
        hashMap.put("seq", "" + this.m);
        hashMap.put("viewid", "" + this.f2447a);
        return hashMap;
    }

    public void a(int i) {
        this.f2447a = i;
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.m = i;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }
}
