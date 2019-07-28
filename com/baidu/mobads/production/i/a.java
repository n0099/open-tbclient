package com.baidu.mobads.production.i;

import android.content.Context;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.c.c;
import com.baidu.mobads.vo.d;
/* loaded from: classes5.dex */
public class a extends c {
    private com.baidu.mobads.production.h.a w;

    public a(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL;
        this.w = new com.baidu.mobads.production.h.a(getApplicationContext(), getActivity(), IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL, this);
        this.w.f(AdSize.PrerollVideoNative.getValue());
        this.w.d(str);
    }

    @Override // com.baidu.mobads.production.c.c
    public void a(com.baidu.mobad.feeds.a aVar) {
        int width = aVar.getWidth();
        int height = aVar.getHeight();
        if (width > 0 && height > 0) {
            this.w.d(width);
            this.w.e(height);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.production.c.c, com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: r */
    public d getAdRequestInfo() {
        return this.w;
    }

    @Override // com.baidu.mobads.production.c.c, com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.w);
    }
}
