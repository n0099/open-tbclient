package com.baidu.sapi2.passhost.framework.a;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.hostsdk.service.SafeService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes.dex */
public class a implements ISapiBaseService {
    private static final String a = "SapiBaseService";
    private Context b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sapi2.passhost.framework.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0091a {
        public static a a = new a();

        private C0091a() {
        }
    }

    public static a a() {
        return C0091a.a;
    }

    public void a(Context context) {
        this.b = context;
    }

    private a() {
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiBaseService
    public String getPiranhaVersion() {
        return PluginFacade.a.a;
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
        String str = null;
        SapiAccount session = ServiceManager.getInstance().getIsAccountManager().getSession();
        if (session != null) {
            str = session.uid;
        }
        return SafeService.getInstance().getZidAndCheckSafe(this.b, str, 1);
    }
}
