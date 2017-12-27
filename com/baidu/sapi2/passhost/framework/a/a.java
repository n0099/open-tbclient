package com.baidu.sapi2.passhost.framework.a;

import android.content.Context;
import com.baidu.sapi2.passhost.hostsdk.service.SafeService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public class a implements ISapiBaseService {
    private static final String a = "SapiBaseService";
    private Context b;

    /* renamed from: com.baidu.sapi2.passhost.framework.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0055a {
        public static a a = new a();

        private C0055a() {
        }
    }

    public static a a() {
        return C0055a.a;
    }

    public void a(Context context) {
        this.b = context;
    }

    private a() {
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getPiranhaVersion() {
        return "1.0.3";
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getAppVersionName() {
        return SapiUtils.getVersionName(this.b);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getClientId() {
        return SapiUtils.getClientId(this.b);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getAppPackageSign() {
        return SapiUtils.getPackageSign(this.b, this.b.getPackageName());
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getDeviceInfo(String str) {
        return SapiDeviceInfo.getDeviceInfo(str);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getLocation() {
        return SapiUtils.getLocation(this.b);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public boolean isRoot() {
        return SapiUtils.isRoot();
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getWifiInfo() {
        return SapiUtils.getWifiInfo(this.b);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getGPSInfo() {
        return SapiUtils.getGPSInfo(this.b);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public boolean checkRequestPermission(String str) {
        return SapiUtils.checkRequestPermission(str, this.b);
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getAppZid() {
        return SafeService.getInstance().getCurZid(this.b);
    }
}
