package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PluginSetting implements Serializable, Cloneable {
    private static final long serialVersionUID = -6614934206499164039L;
    private String abandon_apk_path;
    public String apkPath;
    private int[] cmdRangeInt;
    private String cmdRangeStr;
    public String displayName;
    public boolean enable;
    public boolean forbidden;
    public int installStatus;
    public int install_fail_count;
    private int is_inject_classloader;
    public String md5;
    public String packageName;
    public String requireLoad;
    public int size;
    public String tempMd5;
    public int tempVersionCode;
    public String url;
    public String version;
    public int versionCode;
    public int priority = 1000;
    public int load_priority = 1000;
    public boolean hasRes = false;
    public boolean isThird = false;
    public boolean isPatch = false;
    public String replaceMethodClasses = null;
    public String ext = null;
    public int rollback = 0;

    public boolean isContainCmd(int i) {
        if (this.cmdRangeInt == null) {
            return false;
        }
        int length = this.cmdRangeInt.length;
        if (length % 2 == 0) {
            for (int i2 = 0; i2 < length - 1; i2 += 2) {
                if (i >= this.cmdRangeInt[i2] && i <= this.cmdRangeInt[i2 + 1]) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String getCmdRange() {
        return this.cmdRangeStr;
    }

    public void setCmdRange(String str) {
        this.cmdRangeInt = bR(str);
        this.cmdRangeStr = str;
    }

    private int[] bR(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null) {
            return null;
        }
        int length = split.length;
        int[] iArr = new int[length * 2];
        for (int i = 0; i < length; i++) {
            if (TextUtils.isEmpty(split[i])) {
                BdLog.e("cmdRange2Int is null");
                return null;
            }
            String[] split2 = split[i].split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split2 == null || split2.length != 2) {
                BdLog.e("cmdRange2Int split by '-' error");
                return null;
            }
            int f = com.baidu.adp.lib.g.b.f(split2[0], -1);
            int f2 = com.baidu.adp.lib.g.b.f(split2[1], -1);
            if (f < 0 || f2 < 0 || f > f2) {
                BdLog.e("cmdRange2Int split  toInt error");
                return null;
            }
            iArr[i * 2] = f;
            iArr[(i * 2) + 1] = f2;
        }
        return iArr;
    }

    public boolean isInjectClassloader() {
        return this.is_inject_classloader != 0;
    }

    public void setInjectClassloader(boolean z) {
        if (z) {
            this.is_inject_classloader = 1;
        } else {
            this.is_inject_classloader = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public PluginSetting m10clone() {
        PluginSetting pluginSetting = new PluginSetting();
        pluginSetting.apkPath = this.apkPath;
        pluginSetting.setCmdRange(this.cmdRangeStr);
        pluginSetting.displayName = this.displayName;
        pluginSetting.enable = this.enable;
        pluginSetting.forbidden = this.forbidden;
        pluginSetting.installStatus = this.installStatus;
        pluginSetting.md5 = this.md5;
        pluginSetting.packageName = this.packageName;
        pluginSetting.requireLoad = this.requireLoad;
        pluginSetting.size = this.size;
        pluginSetting.tempMd5 = this.tempMd5;
        pluginSetting.tempVersionCode = this.tempVersionCode;
        pluginSetting.url = this.url;
        pluginSetting.version = this.version;
        pluginSetting.versionCode = this.versionCode;
        pluginSetting.is_inject_classloader = this.is_inject_classloader;
        pluginSetting.abandon_apk_path = this.abandon_apk_path;
        pluginSetting.install_fail_count = this.install_fail_count;
        pluginSetting.priority = this.priority;
        pluginSetting.hasRes = this.hasRes;
        pluginSetting.isThird = this.isThird;
        pluginSetting.isPatch = this.isPatch;
        pluginSetting.load_priority = this.load_priority;
        pluginSetting.replaceMethodClasses = this.replaceMethodClasses;
        pluginSetting.ext = this.ext;
        pluginSetting.rollback = this.rollback;
        return pluginSetting;
    }

    public String getAbandon_apk_path() {
        return this.abandon_apk_path;
    }

    public void setAbandon_apk_path(String str) {
        this.abandon_apk_path = str;
    }

    public void addAbandonApk(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.abandon_apk_path)) {
                this.abandon_apk_path = str;
            } else {
                this.abandon_apk_path += Constants.ACCEPT_TIME_SEPARATOR_SP + str;
            }
        }
    }
}
