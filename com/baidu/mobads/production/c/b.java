package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b extends com.baidu.mobads.vo.d {

    /* renamed from: a  reason: collision with root package name */
    private int f3472a;
    private int j;
    private int k;

    public b(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        super(context, activity, slotType);
        this.f3472a = 1;
        this.j = 1;
        this.k = 1;
        this.f3562b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    @Override // com.baidu.mobads.vo.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,CLICK2VIDEO,PAUSE,VIDEO");
        hashMap.put("pos", "" + this.j);
        hashMap.put("seq", "" + this.k);
        hashMap.put("viewid", "" + this.f3472a);
        return hashMap;
    }

    public void a(int i) {
        this.f3472a = i;
    }

    public void b(int i) {
        this.j = i;
    }

    public void c(int i) {
        this.k = i;
    }

    @Override // com.baidu.mobads.vo.d
    public String b() {
        return super.b();
    }
}
