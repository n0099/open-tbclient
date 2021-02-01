package com.baidu.mobads.a;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.r;
/* loaded from: classes5.dex */
public class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    protected final IXAdLogger f3288a = XAdSDKFoundationFacade.getInstance().getAdLogger();

    /* renamed from: b  reason: collision with root package name */
    private com.baidu.mobads.command.a f3289b;

    public a(com.baidu.mobads.command.a aVar) {
        this.f3289b = aVar;
    }

    @Override // android.content.BroadcastReceiver
    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String replace = intent.getDataString().replace("package:", "");
            if (replace.equals(this.f3289b.f)) {
                r packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
                if (this.f3289b.k && this.f3289b.l != null && !this.f3289b.l.equals("")) {
                    if (packageUtils.sendAPOInfo(context, this.f3289b.l, replace, 381, XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload(), 0)) {
                        XAdSDKFoundationFacade.getInstance().getCommonUtils().browserOutside(context, this.f3289b.l);
                    }
                    context.unregisterReceiver(this);
                } else if (this.f3289b.g) {
                    try {
                        Thread.sleep(600L);
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(replace);
                        launchIntentForPackage.addFlags(268435456);
                        context.startActivity(launchIntentForPackage);
                        context.unregisterReceiver(this);
                    } catch (Exception e) {
                        this.f3288a.d("InstallReceiver", e);
                    }
                }
            }
        }
    }
}
