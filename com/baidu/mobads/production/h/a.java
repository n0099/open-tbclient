package com.baidu.mobads.production.h;

import android.content.Context;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.production.b.e;
import com.baidu.mobads.vo.d;
/* loaded from: classes5.dex */
public class a extends e {
    private com.baidu.mobads.production.g.a z;

    public a(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL;
        this.z = new com.baidu.mobads.production.g.a(getApplicationContext(), getActivity(), IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL, this);
        this.z.f(AdSize.PrerollVideoNative.getValue());
        this.z.d(str);
    }

    @Override // com.baidu.mobads.production.b.e, com.baidu.mobads.production.a
    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.z.d(width);
            this.z.e(height);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.mobads.production.b.e, com.baidu.mobads.interfaces.IXAdProd
    /* renamed from: b */
    public d getAdRequestInfo() {
        return this.z;
    }

    @Override // com.baidu.mobads.production.b.e, com.baidu.mobads.interfaces.IXAdProd
    public void request() {
        super.a(this.z);
    }
}
