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
    private File CO;
    private Map<String, ActivityInfo> CQ;
    private Map<String, ProviderInfo> CR;
    private Map<String, IntentFilter> CS;
    private Map<String, IntentFilter> CT;
    private Context mContext;
    private Resources mPluginResource;
    private PackageInfo CP = null;
    private ActivityInfo CU = null;
    private boolean CV = false;

    public e(Context context, File file, Resources resources) {
        this.CQ = null;
        this.CR = null;
        this.CS = null;
        this.CT = null;
        this.mPluginResource = null;
        this.mContext = context;
        this.CO = file;
        this.mPluginResource = resources;
        this.CQ = new HashMap();
        this.CS = new HashMap();
        this.CT = new HashMap();
        this.CR = new HashMap();
    }

    public ServiceInfo bd(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo pluginPackageInfo = getPluginPackageInfo();
        if (pluginPackageInfo == null || pluginPackageInfo.services == null || this.CT.isEmpty()) {
            return null;
        }
        for (ServiceInfo serviceInfo : pluginPackageInfo.services) {
            IntentFilter intentFilter = this.CT.get(serviceInfo.name);
            if (intentFilter != null && intentFilter.hasAction(str)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public Map<String, IntentFilter> kF() {
        return this.CS;
    }

    public Map<String, ProviderInfo> kG() {
        return this.CR;
    }

    public PackageInfo getPluginPackageInfo() {
        if (this.mContext == null || this.CO == null) {
            return null;
        }
        if (this.CP == null) {
            try {
                this.CP = this.mContext.getPackageManager().getPackageArchiveInfo(this.CO.getAbsolutePath(), 15);
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.lf().f("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
            }
        }
        return this.CP;
    }

    private void a(XmlResourceParser xmlResourceParser, int i) {
        if (this.CP != null && this.CP.activities != null) {
            String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
            while (i != 1) {
                switch (i) {
                    case 2:
                        if ("action".equals(xmlResourceParser.getName())) {
                            if (!"android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                                i = xmlResourceParser.next();
                                continue;
                            } else {
                                if (attributeValue.startsWith(".")) {
                                    attributeValue = String.valueOf(this.CP.packageName) + attributeValue;
                                }
                                for (int i2 = 0; i2 < this.CP.activities.length; i2++) {
                                    if (this.CP.activities[i2].name.equals(attributeValue)) {
                                        this.CU = this.CP.activities[i2];
                                        return;
                                    }
                                }
                                break;
                            }
                        } else {
                            break;
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

    public boolean kH() {
        XmlResourceParser openXmlResourceParser;
        char c;
        String str;
        char c2;
        ProviderInfo[] providerInfoArr;
        ActivityInfo[] activityInfoArr;
        PackageInfo pluginPackageInfo = getPluginPackageInfo();
        if (pluginPackageInfo == null) {
            BdLog.w("Plugin: initManifest() pkgInfo == null!!");
            return false;
        }
        if (pluginPackageInfo.receivers != null) {
            for (ActivityInfo activityInfo : pluginPackageInfo.receivers) {
                this.CQ.put(activityInfo.name, activityInfo);
            }
        }
        if (pluginPackageInfo.providers != null) {
            for (ProviderInfo providerInfo : pluginPackageInfo.providers) {
                this.CR.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.mPluginResource.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lf().f("plugin_install", "plugin_third_manifest_failed", pluginPackageInfo.packageName, e.getMessage());
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
                            attributeValue = String.valueOf(pluginPackageInfo.packageName) + attributeValue;
                        }
                        c = c2;
                        str = attributeValue;
                        continue;
                    } else if (str2 != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = c2 == 1 ? this.CT : this.CS;
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
                        if (this.CU == null && "activity".equals(openXmlResourceParser.getName())) {
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
                        this.CV = true;
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
