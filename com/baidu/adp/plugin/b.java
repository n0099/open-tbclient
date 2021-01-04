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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class b {
    private Map<String, ActivityInfo> SO;
    private Map<String, ProviderInfo> SQ;
    private Map<String, IntentFilter> SR;
    private Map<String, IntentFilter> SS;
    private Context mContext;
    private File mPluginFile;
    private Resources mPluginResource;
    private PackageInfo SM = null;
    private ActivityInfo ST = null;
    private boolean mIsInited = false;

    public b(Context context, File file, Resources resources) {
        this.SO = null;
        this.SQ = null;
        this.SR = null;
        this.SS = null;
        this.mPluginResource = null;
        this.mContext = context;
        this.mPluginFile = file;
        this.mPluginResource = resources;
        this.SO = new HashMap();
        this.SR = new HashMap();
        this.SS = new HashMap();
        this.SQ = new HashMap();
    }

    public ServiceInfo cj(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PackageInfo pluginPackageInfo = getPluginPackageInfo();
        if (pluginPackageInfo == null || pluginPackageInfo.services == null || this.SS.isEmpty()) {
            return null;
        }
        for (ServiceInfo serviceInfo : pluginPackageInfo.services) {
            IntentFilter intentFilter = this.SS.get(serviceInfo.name);
            if (intentFilter != null && intentFilter.hasAction(str)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public Map<String, IntentFilter> oG() {
        return this.SR;
    }

    public Map<String, ProviderInfo> oH() {
        return this.SQ;
    }

    public PackageInfo getPluginPackageInfo() {
        if (this.mContext == null || this.mPluginFile == null) {
            return null;
        }
        if (this.SM == null) {
            try {
                this.SM = this.mContext.getPackageManager().getPackageArchiveInfo(this.mPluginFile.getAbsolutePath(), 15);
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.pg().h("plugin_use", "plugin_manifest_pkginfo_failed", "getPluginPackageInfo", e.getMessage());
            }
        }
        return this.SM;
    }

    private void a(XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException, IOException {
        if (this.SM != null && this.SM.activities != null) {
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
                                    attributeValue = this.SM.packageName + attributeValue;
                                }
                                for (int i2 = 0; i2 < this.SM.activities.length; i2++) {
                                    if (this.SM.activities[i2].name.equals(attributeValue)) {
                                        this.ST = this.SM.activities[i2];
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

    public boolean oI() {
        XmlResourceParser openXmlResourceParser;
        char c;
        ProviderInfo[] providerInfoArr;
        ActivityInfo[] activityInfoArr;
        PackageInfo pluginPackageInfo = getPluginPackageInfo();
        if (pluginPackageInfo == null) {
            BdLog.w("Plugin: initManifest() pkgInfo == null!!");
            return false;
        }
        if (pluginPackageInfo.receivers != null) {
            for (ActivityInfo activityInfo : pluginPackageInfo.receivers) {
                this.SO.put(activityInfo.name, activityInfo);
            }
        }
        if (pluginPackageInfo.providers != null) {
            for (ProviderInfo providerInfo : pluginPackageInfo.providers) {
                this.SQ.put(providerInfo.name, providerInfo);
            }
        }
        try {
            openXmlResourceParser = this.mPluginResource.getAssets().openXmlResourceParser("AndroidManifest.xml");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.pg().h("plugin_install", "plugin_third_manifest_failed", pluginPackageInfo.packageName, e.getMessage());
        }
        if (openXmlResourceParser == null) {
            return false;
        }
        int next = openXmlResourceParser.next();
        char c2 = 65535;
        String str = null;
        while (next != 1) {
            switch (next) {
                case 2:
                    if (SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName())) {
                        c = 0;
                    } else {
                        c = "service".equals(openXmlResourceParser.getName()) ? (char) 1 : c2;
                    }
                    if (c >= 0 && str == null) {
                        String attributeValue = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue.startsWith(".")) {
                            attributeValue = pluginPackageInfo.packageName + attributeValue;
                        }
                        str = attributeValue;
                        continue;
                    } else if (str != null && "action".equals(openXmlResourceParser.getName())) {
                        String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                        if (attributeValue2 != null) {
                            Map<String, IntentFilter> map = c == 1 ? this.SS : this.SR;
                            IntentFilter intentFilter = map.get(str);
                            if (intentFilter == null) {
                                intentFilter = new IntentFilter(attributeValue2);
                            } else {
                                intentFilter.addAction(attributeValue2);
                            }
                            map.put(str, intentFilter);
                        }
                    } else if (this.ST == null && PushConstants.INTENT_ACTIVITY_NAME.equals(openXmlResourceParser.getName())) {
                        a(openXmlResourceParser, next);
                    }
                    next = openXmlResourceParser.next();
                    c2 = c;
                    break;
                case 3:
                    if (!SocialConstants.PARAM_RECEIVER.equals(openXmlResourceParser.getName()) && !"service".equals(openXmlResourceParser.getName())) {
                        if ("application".equals(openXmlResourceParser.getName())) {
                            this.mIsInited = true;
                            return true;
                        }
                    } else {
                        c = 65535;
                        str = null;
                        continue;
                        next = openXmlResourceParser.next();
                        c2 = c;
                    }
                    break;
            }
            c = c2;
            next = openXmlResourceParser.next();
            c2 = c;
        }
        return false;
    }
}
