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
    private Map<String, ActivityInfo> CB;
    private Map<String, ProviderInfo> CC;
    private Map<String, IntentFilter> CD;
    private Map<String, IntentFilter> CE;
    private Resources Cl;
    private File Cz;
    private Context mContext;
    private PackageInfo CA = null;
    private ActivityInfo CF = null;
    private boolean CG = false;

    public e(Context context, File file, Resources resources) {
        this.CB = null;
        this.CC = null;
        this.CD = null;
        this.CE = null;
        this.Cl = null;
        this.mContext = context;
        this.Cz = file;
        this.Cl = resources;
        this.CB = new HashMap();
        this.CD = new HashMap();
        this.CE = new HashMap();
        this.CC = new HashMap();
    }

    public ServiceInfo bf(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo kv = kv();
        if (kv == null || kv.services == null || this.CE.isEmpty()) {
            return null;
        }
        for (ServiceInfo serviceInfo : kv.services) {
            IntentFilter intentFilter = this.CE.get(serviceInfo.name);
            if (intentFilter != null && intentFilter.hasAction(str)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public Map<String, IntentFilter> kG() {
        return this.CD;
    }

    public Map<String, ProviderInfo> kH() {
        return this.CC;
    }

    public PackageInfo kv() {
        if (this.mContext == null || this.Cz == null) {
            return null;
        }
        if (this.CA == null) {
            try {
                this.CA = this.mContext.getPackageManager().getPackageArchiveInfo(this.Cz.getAbsolutePath(), 15);
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.lf().e("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
            }
        }
        return this.CA;
    }

    private void a(XmlResourceParser xmlResourceParser, int i) {
        if (this.CA != null && this.CA.activities != null) {
            String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
            while (i != 1) {
                switch (i) {
                    case 2:
                        if (!"action".equals(xmlResourceParser.getName())) {
                            break;
                        } else if ("android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                            if (attributeValue.startsWith(".")) {
                                attributeValue = String.valueOf(this.CA.packageName) + attributeValue;
                            }
                            for (int i2 = 0; i2 < this.CA.activities.length; i2++) {
                                if (this.CA.activities[i2].name.equals(attributeValue)) {
                                    this.CF = this.CA.activities[i2];
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

    public boolean kI() {
        XmlResourceParser openXmlResourceParser;
        char c;
        String str;
        char c2;
        ProviderInfo[] providerInfoArr;
        ActivityInfo[] activityInfoArr;
        PackageInfo kv = kv();
        if (kv == null) {
            BdLog.w("Plugin: initManifest() pkgInfo == null!!");
            return false;
        }
        if (kv.receivers != null) {
            for (ActivityInfo activityInfo : kv.receivers) {
                this.CB.put(activityInfo.name, activityInfo);
            }
        }
        if (kv.providers != null) {
            for (ProviderInfo providerInfo : kv.providers) {
                this.CC.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.Cl.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lf().e("plugin_install", "plugin_third_manifest_failed", kv.packageName, e.getMessage());
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
                            attributeValue = String.valueOf(kv.packageName) + attributeValue;
                        }
                        c = c2;
                        str = attributeValue;
                        continue;
                    } else if (str2 != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = c2 == 1 ? this.CE : this.CD;
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
                        if (this.CF == null && "activity".equals(openXmlResourceParser.getName())) {
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
                        this.CG = true;
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
