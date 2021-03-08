package com.baidu.mobads.production.cpu;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.production.p;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c extends com.baidu.mobads.production.a implements IXNonLinearAdSlot {
    private e z;

    public c(Context context, RelativeLayout relativeLayout, String str, String str2, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU;
        this.z = new e(getApplicationContext(), getActivity(), this.o, str, str2, cPUWebAdRequestParam);
    }

    public c(Context context, RelativeLayout relativeLayout, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU;
        this.z = new e(getApplicationContext(), getActivity(), this.o, str, i, cPUWebAdRequestParam);
    }

    @Override // com.baidu.mobads.production.a
    public void c() {
        load();
    }

    @Override // com.baidu.mobads.production.a
    protected void d() {
        this.m = 10000;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        a(this.z);
    }

    @Override // com.baidu.mobads.production.a
    protected void b(com.baidu.mobads.vo.d dVar) {
        this.k = dVar;
        k();
        a((com.baidu.mobads.openad.b.b) null, (p) null, 5000);
    }

    @Override // com.baidu.mobads.production.a
    protected void a(com.baidu.mobads.openad.b.b bVar, p pVar, int i) {
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c("{'ad':[{'id':99999999,'html':'" + this.z.c() + "', type='" + IXAdInstanceInfo.CreativeType.HTML.getValue() + "'}],'n':1}"));
        } catch (Exception e) {
        }
        a("XAdMouldeLoader ad-server requesting success");
    }

    @Override // com.baidu.mobads.production.a
    protected void a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    @Override // com.baidu.mobads.production.a
    protected void b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: a */
    public com.baidu.mobads.vo.d getAdRequestInfo() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.production.a
    public void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.e.a(IXAdEvent.AD_USER_CLOSE));
    }

    @Override // com.baidu.mobads.production.a
    public void b(IXAdResponseInfo iXAdResponseInfo) {
    }
}
