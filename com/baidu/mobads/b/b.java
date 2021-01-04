package com.baidu.mobads.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.a.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    protected final IXAdLogger f3343a;
    private a d;
    private String e;
    private File f;
    private Boolean g;

    public b(Context context, String str, File file, boolean z) {
        super(context);
        this.f3343a = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.e = str;
        this.f = file;
        this.g = Boolean.valueOf(z);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        this.d = (a) broadcastReceiver;
    }

    public void a() {
        try {
            if (this.e != null) {
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                this.f3428b.registerReceiver(this.d, intentFilter);
            }
            XAdSDKFoundationFacade.getInstance().getPackageUtils().b(this.f3428b, this.f);
        } catch (Exception e) {
            this.f3343a.e("XAdInstallController", "");
        }
    }
}
