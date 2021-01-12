package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes14.dex */
public class XAdManager implements IXAdManager {
    private static IXAdManager d;

    /* renamed from: a  reason: collision with root package name */
    private String f3247a;

    /* renamed from: b  reason: collision with root package name */
    private Location f3248b;
    private Context c;

    public static IXAdManager getInstance(Context context) {
        if (d == null) {
            d = new XAdManager(context);
        }
        return d;
    }

    private XAdManager(Context context) {
        this.c = context instanceof Activity ? context.getApplicationContext() : context;
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public void setAppSid(String str) {
        this.f3247a = str;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public void setLocation(Location location) {
        this.f3248b = location;
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public IXAdContext newAdContext() {
        return new XAdContext(this.c, this.f3247a, this.f3248b);
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public String getVersion() {
        return "8.8146";
    }
}
