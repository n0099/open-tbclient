package com.baidu.mobads.command.a;

import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: f  reason: collision with root package name */
    public String f8189f;

    public a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.f8189f = null;
        this.f8189f = str;
    }

    public void a() {
        XAdSDKFoundationFacade.getInstance().getCommonUtils().browserOutside(this.f8190a, this.f8189f);
    }
}
