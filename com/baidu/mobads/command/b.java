package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3306a;

    /* renamed from: b  reason: collision with root package name */
    protected IXNonLinearAdSlot f3307b;
    protected IXAdInstanceInfo c;
    protected IXAdResource d;
    protected IXAdLogger e = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.f3307b = iXNonLinearAdSlot;
        if (iXNonLinearAdSlot != null) {
            this.f3306a = iXNonLinearAdSlot.getApplicationContext();
        } else {
            this.f3306a = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        }
        this.c = iXAdInstanceInfo;
        this.d = iXAdResource;
    }
}
