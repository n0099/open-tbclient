package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d extends com.baidu.mobads.vo.d {

    /* renamed from: a  reason: collision with root package name */
    public int f8443a;
    public int l;
    public int m;

    public d(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.f8443a = 1;
        this.l = 1;
        this.m = 1;
        this.f8625b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    @Override // com.baidu.mobads.vo.d
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.j) {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,VIDEO");
        } else {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,CLICK2VIDEO,PAUSE,VIDEO");
        }
        hashMap.put("pos", "" + this.l);
        hashMap.put("seq", "" + this.m);
        hashMap.put("viewid", "" + this.f8443a);
        return hashMap;
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

    public void a(int i) {
        this.f8443a = i;
    }
}
