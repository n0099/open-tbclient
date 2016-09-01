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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class e {
    private Context mContext;
    private Resources mPluginResource;
    private File vX;
    private Map<String, ActivityInfo> vZ;
    private Map<String, ProviderInfo> wa;
    private Map<String, IntentFilter> wb;
    private Map<String, IntentFilter> wc;
    private PackageInfo vY = null;
    private ActivityInfo wd = null;
    private boolean we = false;

    public e(Context context, File file, Resources resources) {
        this.vZ = null;
        this.wa = null;
        this.wb = null;
        this.wc = null;
        this.mPluginResource = null;
        this.mContext = context;
        this.vX = file;
        this.mPluginResource = resources;
        this.vZ = new HashMap();
        this.wb = new HashMap();
        this.wc = new HashMap();
        this.wa = new HashMap();
    }

    public ServiceInfo aY(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo pluginPackageInfo = getPluginPackageInfo();
        if (pluginPackageInfo == null || pluginPackageInfo.services == null || this.wc.isEmpty()) {
            return null;
        }
        for (ServiceInfo serviceInfo : pluginPackageInfo.services) {
            IntentFilter intentFilter = this.wc.get(serviceInfo.name);
            if (intentFilter != null && intentFilter.hasAction(str)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public Map<String, IntentFilter> hO() {
        return this.wb;
    }

    public Map<String, ProviderInfo> hP() {
        return this.wa;
    }

    public PackageInfo getPluginPackageInfo() {
        if (this.mContext == null || this.vX == null) {
            return null;
        }
        if (this.vY == null) {
            try {
                this.vY = this.mContext.getPackageManager().getPackageArchiveInfo(this.vX.getAbsolutePath(), 15);
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.io().f("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
            }
        }
        return this.vY;
    }

    private void a(XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException, IOException {
        if (this.vY != null && this.vY.activities != null) {
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
                                    attributeValue = String.valueOf(this.vY.packageName) + attributeValue;
                                }
                                for (int i2 = 0; i2 < this.vY.activities.length; i2++) {
                                    if (this.vY.activities[i2].name.equals(attributeValue)) {
                                        this.wd = this.vY.activities[i2];
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

    public boolean hQ() {
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
                this.vZ.put(activityInfo.name, activityInfo);
            }
        }
        if (pluginPackageInfo.providers != null) {
            for (ProviderInfo providerInfo : pluginPackageInfo.providers) {
                this.wa.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.mPluginResource.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.io().f("plugin_install", "plugin_third_manifest_failed", pluginPackageInfo.packageName, e.getMessage());
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
                            Map<String, IntentFilter> map = c2 == 1 ? this.wc : this.wb;
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
                        if (this.wd == null && "activity".equals(openXmlResourceParser.getName())) {
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
                        this.we = true;
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
