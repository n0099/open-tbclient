package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3352a;

    /* renamed from: b  reason: collision with root package name */
    protected IXNonLinearAdSlot f3353b;
    protected IXAdInstanceInfo c;
    protected IXAdResource d;
    protected IXAdLogger e = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.f3353b = iXNonLinearAdSlot;
        if (iXNonLinearAdSlot != null) {
            this.f3352a = iXNonLinearAdSlot.getApplicationContext();
        } else {
            this.f3352a = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        }
        this.c = iXAdInstanceInfo;
        this.d = iXAdResource;
    }
}
