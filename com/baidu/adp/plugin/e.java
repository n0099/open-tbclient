package com.baidu.adp.plugin;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private File CJ;
    private Map<String, ActivityInfo> CL;
    private Map<String, ProviderInfo> CM;
    private Map<String, IntentFilter> CN;
    private Map<String, IntentFilter> CO;
    private Resources Ct;
    private Context mContext;
    private PackageInfo CK = null;
    private ActivityInfo CP = null;
    private boolean CQ = false;

    public e(Context context, File file, Resources resources) {
        this.CL = null;
        this.CM = null;
        this.CN = null;
        this.CO = null;
        this.Ct = null;
        this.mContext = context;
        this.CJ = file;
        this.Ct = resources;
        this.CL = new HashMap();
        this.CN = new HashMap();
        this.CO = new HashMap();
        this.CM = new HashMap();
    }

    public ServiceInfo bf(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo kF = kF();
        if (kF == null || kF.services == null || this.CO.isEmpty()) {
            return null;
        }
        for (ServiceInfo serviceInfo : kF.services) {
            IntentFilter intentFilter = this.CO.get(serviceInfo.name);
            if (intentFilter != null && intentFilter.hasAction(str)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public Map<String, IntentFilter> kQ() {
        return this.CN;
    }

    public Map<String, ProviderInfo> kR() {
        return this.CM;
    }

    public PackageInfo kF() {
        if (this.mContext == null || this.CJ == null) {
            return null;
        }
        if (this.CK == null) {
            try {
                this.CK = this.mContext.getPackageManager().getPackageArchiveInfo(this.CJ.getAbsolutePath(), 15);
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.lq().f("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
            }
        }
        return this.CK;
    }

    private void a(XmlResourceParser xmlResourceParser, int i) {
        if (this.CK != null && this.CK.activities != null) {
            String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
            while (i != 1) {
                switch (i) {
                    case 2:
                        if (!"action".equals(xmlResourceParser.getName())) {
                            break;
                        } else if ("android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                            if (attributeValue.startsWith(".")) {
                                attributeValue = String.valueOf(this.CK.packageName) + attributeValue;
                            }
                            for (int i2 = 0; i2 < this.CK.activities.length; i2++) {
                                if (this.CK.activities[i2].name.equals(attributeValue)) {
                                    this.CP = this.CK.activities[i2];
                                    return;
                                }
                            }
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ("activity".equals(xmlResourceParser.getName())) {
                            return;
                        }
                        break;
                }
                i = xmlResourceParser.next();
            }
        }
    }

    public boolean kS() {
        XmlResourceParser openXmlResourceParser;
        char c;
        String str;
        char c2;
        ProviderInfo[] providerInfoArr;
        ActivityInfo[] activityInfoArr;
        PackageInfo kF = kF();
        if (kF == null) {
            BdLog.w("Plugin: initManifest() pkgInfo == null!!");
            return false;
        }
        if (kF.receivers != null) {
            for (ActivityInfo activityInfo : kF.receivers) {
                this.CL.put(activityInfo.name, activityInfo);
            }
        }
        if (kF.providers != null) {
            for (ProviderInfo providerInfo : kF.providers) {
                this.CM.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.Ct.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lq().f("plugin_install", "plugin_third_manifest_failed", kF.packageName, e.getMessage());
        }
        if (openXmlResourceParser == null) {
            return false;
        }
        int next = openXmlResourceParser.next();
        String str2 = null;
        char c3 = 65535;
        while (next != 1) {
            switch (next) {
                case 2:
                    if ("receiver".equals(openXmlResourceParser.getName())) {
                        c2 = 0;
                    } else {
                        c2 = "service".equals(openXmlResourceParser.getName()) ? (char) 1 : c3;
                    }
                    if (c2 >= 0 && str2 == null) {
                        String attributeValue = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue.startsWith(".")) {
                            attributeValue = String.valueOf(kF.packageName) + attributeValue;
                        }
                        c = c2;
                        str = attributeValue;
                        continue;
                    } else if (str2 != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = c2 == 1 ? this.CO : this.CN;
                            IntentFilter intentFilter = map.get(str2);
                            if (intentFilter == null) {
                                intentFilter = new IntentFilter(attributeValue2);
                            } else {
                                intentFilter.addAction(attributeValue2);
                            }
                            map.put(str2, intentFilter);
                            c = c2;
                            str = str2;
                        }
                        c = c2;
                        str = str2;
                    } else {
                        if (this.CP == null && "activity".equals(openXmlResourceParser.getName())) {
                            a(openXmlResourceParser, next);
                            c = c2;
                            str = str2;
                        }
                        c = c2;
                        str = str2;
                    }
                    str2 = str;
                    char c4 = c;
                    next = openXmlResourceParser.next();
                    c3 = c4;
                    break;
                case 3:
                    if ("receiver".equals(openXmlResourceParser.getName()) || "service".equals(openXmlResourceParser.getName())) {
                        c = 65535;
                        str = null;
                        continue;
                        str2 = str;
                        char c42 = c;
                        next = openXmlResourceParser.next();
                        c3 = c42;
                    } else if ("application".equals(openXmlResourceParser.getName())) {
                        this.CQ = true;
                        return true;
                    }
                    break;
            }
            c = c3;
            str = str2;
            str2 = str;
            char c422 = c;
            next = openXmlResourceParser.next();
            c3 = c422;
        }
        return false;
    }
}
