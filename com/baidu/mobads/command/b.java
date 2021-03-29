package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f8190a;

    /* renamed from: b  reason: collision with root package name */
    public IXNonLinearAdSlot f8191b;

    /* renamed from: c  reason: collision with root package name */
    public IXAdInstanceInfo f8192c;

    /* renamed from: d  reason: collision with root package name */
    public IXAdResource f8193d;

    /* renamed from: e  reason: collision with root package name */
    public IXAdLogger f8194e = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.f8191b = iXNonLinearAdSlot;
        if (iXNonLinearAdSlot != null) {
            this.f8190a = iXNonLinearAdSlot.getApplicationContext();
        } else {
            this.f8190a = XAdSDKFoundationFacade.getInstance().getApplicationContext();
        }
        this.f8192c = iXAdInstanceInfo;
        this.f8193d = iXAdResource;
    }
}
