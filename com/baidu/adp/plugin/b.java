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
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class b {
    private Context mContext;
    private Resources mPluginResource;
    private File uh;
    private Map<String, ActivityInfo> uk;
    private Map<String, ProviderInfo> ul;
    private Map<String, IntentFilter> um;
    private Map<String, IntentFilter> uo;
    private PackageInfo uj = null;
    private ActivityInfo uq = null;
    private boolean ur = false;

    public b(Context context, File file, Resources resources) {
        this.uk = null;
        this.ul = null;
        this.um = null;
        this.uo = null;
        this.mPluginResource = null;
        this.mContext = context;
        this.uh = file;
        this.mPluginResource = resources;
        this.uk = new HashMap();
        this.um = new HashMap();
        this.uo = new HashMap();
        this.ul = new HashMap();
    }

    public ServiceInfo az(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo pluginPackageInfo = getPluginPackageInfo();
        if (pluginPackageInfo == null || pluginPackageInfo.services == null || this.uo.isEmpty()) {
            return null;
        }
        for (ServiceInfo serviceInfo : pluginPackageInfo.services) {
            IntentFilter intentFilter = this.uo.get(serviceInfo.name);
            if (intentFilter != null && intentFilter.hasAction(str)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public Map<String, IntentFilter> hU() {
        return this.um;
    }

    public Map<String, ProviderInfo> hV() {
        return this.ul;
    }

    public PackageInfo getPluginPackageInfo() {
        if (this.mContext == null || this.uh == null) {
            return null;
        }
        if (this.uj == null) {
            try {
                this.uj = this.mContext.getPackageManager().getPackageArchiveInfo(this.uh.getAbsolutePath(), 15);
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.iv().g("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
            }
        }
        return this.uj;
    }

    private void a(XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException, IOException {
        if (this.uj != null && this.uj.activities != null) {
            String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
            while (i != 1) {
                switch (i) {
                    case 2:
                        if ("action".equals(xmlResourceParser.getName())) {
                            if (!"android.intent.action.MAIN".equals(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name"))) {
                                i = xmlResourceParser.next();
                                continue;
                            } else {
                                if (attributeValue.startsWith(DefaultConfig.TOKEN_SEPARATOR)) {
                                    attributeValue = this.uj.packageName + attributeValue;
                                }
                                for (int i2 = 0; i2 < this.uj.activities.length; i2++) {
                                    if (this.uj.activities[i2].name.equals(attributeValue)) {
                                        this.uq = this.uj.activities[i2];
                                        return;
                                    }
                                }
                                break;
                            }
                        } else {
                            break;
                        }
                    case 3:
                        if (PushConstants.INTENT_ACTIVITY_NAME.equals(xmlResourceParser.getName())) {
                            return;
                        }
                        break;
                }
                i = xmlResourceParser.next();
            }
        }
    }

    public boolean hW() {
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
                this.uk.put(activityInfo.name, activityInfo);
            }
        }
        if (pluginPackageInfo.providers != null) {
            for (ProviderInfo providerInfo : pluginPackageInfo.providers) {
                this.ul.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.mPluginResource.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.iv().g("plugin_install", "plugin_third_manifest_failed", pluginPackageInfo.packageName, e.getMessage());
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
                    if (SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName())) {
                        c2 = 0;
                    } else {
                        c2 = "service".equals(openXmlResourceParser.getName()) ? (char) 1 : c3;
                    }
                    if (c2 >= 0 && str2 == null) {
                        String attributeValue = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue.startsWith(DefaultConfig.TOKEN_SEPARATOR)) {
                            attributeValue = pluginPackageInfo.packageName + attributeValue;
                        }
                        c = c2;
                        str = attributeValue;
                        continue;
                    } else if (str2 != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = c2 == 1 ? this.uo : this.um;
                            IntentFilter intentFilter = map.get(str2);
                            if (intentFilter == null) {
                                intentFilter = new IntentFilter(attributeValue2);
                            } else {
                                intentFilter.addAction(attributeValue2);
                            }
                            map.put(str2, intentFilter);
                        }
                        c = c2;
                        str = str2;
                    } else if (this.uq == null && PushConstants.INTENT_ACTIVITY_NAME.equals(openXmlResourceParser.getName())) {
                        a(openXmlResourceParser, next);
                        c = c2;
                        str = str2;
                    } else {
                        c = c2;
                        str = str2;
                    }
                    str2 = str;
                    char c4 = c;
                    next = openXmlResourceParser.next();
                    c3 = c4;
                    break;
                case 3:
                    if (!SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName()) && !"service".equals(openXmlResourceParser.getName())) {
                        if ("application".equals(openXmlResourceParser.getName())) {
                            this.ur = true;
                            return true;
                        }
                    } else {
                        c = 65535;
                        str = null;
                        continue;
                        str2 = str;
                        char c42 = c;
                        next = openXmlResourceParser.next();
                        c3 = c42;
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
