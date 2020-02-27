package com.baidu.mobads.production.b;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.v;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b extends com.baidu.mobads.production.b implements IXNonLinearAdSlot {
    private d w;

    public b(Context context, RelativeLayout relativeLayout, String str, String str2) {
        super(context);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU;
        this.w = new d(getApplicationContext(), getActivity(), this.o, str, str2);
    }

    @Override // com.baidu.mobads.production.b
    public void g() {
        load();
    }

    @Override // com.baidu.mobads.production.b
    protected void h() {
        this.m = 10000;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        a(this.w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.b
    public void b(com.baidu.mobads.vo.d dVar) {
        this.k = dVar;
        k();
        a((com.baidu.mobads.openad.d.c) null, (v) null, 5000);
    }

    @Override // com.baidu.mobads.production.b
    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c("{'ad':[{'id':99999999,'html':'" + this.w.c() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        b("XAdMouldeLoader ad-server requesting success");
    }

    @Override // com.baidu.mobads.production.b
    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    @Override // com.baidu.mobads.production.b
    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: q */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.b
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.production.b
    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }
}
