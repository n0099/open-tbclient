package com.baidu.mobads.a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.r;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
/* loaded from: classes2.dex */
public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final IXAdLogger f8159a = XAdSDKFoundationFacade.getInstance().getAdLogger();

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.mobads.command.a f8160b;

    public a(com.baidu.mobads.command.a aVar) {
        this.f8160b = aVar;
    }

    @Override // android.content.BroadcastReceiver
    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
            String replace = intent.getDataString().replace("package:", "");
            if (replace.equals(this.f8160b.f8185f)) {
                r packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
                com.baidu.mobads.command.a aVar = this.f8160b;
                if (aVar.k && (str = aVar.l) != null && !str.equals("")) {
                    if (packageUtils.sendAPOInfo(context, this.f8160b.l, replace, 381, XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload(), 0)) {
                        XAdSDKFoundationFacade.getInstance().getCommonUtils().browserOutside(context, this.f8160b.l);
                    }
                    context.unregisterReceiver(this);
                } else if (this.f8160b.f8186g) {
                    try {
                        Thread.sleep(600L);
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(replace);
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        context.unregisterReceiver(this);
                    } catch (Exception e2) {
                        this.f8159a.d("InstallReceiver", e2);
                    }
                }
            }
        }
    }
}
