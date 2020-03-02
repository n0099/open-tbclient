package com.baidu.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes10.dex */
public class e implements IXAdManager {
    private static IXAdManager aOt;
    private String a;
    private Location b;
    private Context c;

    public static IXAdManager aT(Context context) {
        if (aOt == null) {
            aOt = new e(context);
        }
        return aOt;
    }

    private e(Context context) {
        this.c = context instanceof Activity ? context.getApplicationContext() : context;
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public void setAppSid(String str) {
        this.a = str;
        XAdSDKFoundationFacade.getInstance().getCommonUtils().setAppId(str);
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public void setLocation(Location location) {
        this.b = location;
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public IXAdContext newAdContext() {
        return new a(this.c, this.a, this.b);
    }

    @Override // com.baidu.mobads.interfaces.IXAdManager
    public String getVersion() {
        return "8.8146";
    }
}
