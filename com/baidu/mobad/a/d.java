package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdEvent4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
/* loaded from: classes7.dex */
public class d extends com.baidu.mobads.openad.c.b implements IXAdEvent4PDK {
    private IXAdProd a;

    public d(String str, IXAdProd iXAdProd) {
        super(str);
        this.a = iXAdProd;
    }

    @Override // com.baidu.mobads.interfaces.IXAdEvent4PDK
    public IXAdProd getAdSlot() {
        return this.a;
    }
}
