package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.m.b;
import java.io.Serializable;
/* loaded from: classes.dex */
public class PluginSetting implements Serializable, Cloneable {
    public static final long serialVersionUID = -6614934206499164039L;
    public String abandon_apk_path;
    public String apkPath;
    public int[] cmdRangeInt;
    public String cmdRangeStr;
    public String displayName;
    public boolean enable;
    public boolean forbidden;
    public int installStatus;
    public int install_fail_count;
    public int is_inject_classloader;
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

    private int[] cmdRange2Int(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(",")) == null) {
            return null;
        }
        int length = split.length;
        int[] iArr = new int[length * 2];
        for (int i = 0; i < length; i++) {
            if (TextUtils.isEmpty(split[i])) {
                BdLog.e("cmdRange2Int is null");
                return null;
            }
            String[] split2 = split[i].split("-");
            if (split2 != null && split2.length == 2) {
                int d2 = b.d(split2[0], -1);
                int d3 = b.d(split2[1], -1);
                if (d2 >= 0 && d3 >= 0 && d2 <= d3) {
                    int i2 = i * 2;
                    iArr[i2] = d2;
                    iArr[i2 + 1] = d3;
                } else {
                    BdLog.e("cmdRange2Int split  toInt error");
                    return null;
                }
            } else {
                BdLog.e("cmdRange2Int split by '-' error");
                return null;
            }
        }
        return iArr;
    }

    private String cmdRange2String(int[] iArr) {
        if (iArr == null || iArr.length == 0 || iArr.length % 2 != 0) {
            return null;
        }
        int length = iArr.length;
        StringBuilder sb = new StringBuilder(50);
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            if (i != length - 1) {
                if (i % 2 == 0) {
                    sb.append("-");
                } else {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public void addAbandonApk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.abandon_apk_path)) {
            this.abandon_apk_path = str;
            return;
        }
        this.abandon_apk_path += "," + str;
    }

    public String getAbandon_apk_path() {
        return this.abandon_apk_path;
    }

    public String getCmdRange() {
        return this.cmdRangeStr;
    }

    public boolean isContainCmd(int i) {
        int[] iArr = this.cmdRangeInt;
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        if (length % 2 != 0) {
            return false;
        }
        for (int i2 = 0; i2 < length - 1; i2 += 2) {
            int[] iArr2 = this.cmdRangeInt;
            if (i >= iArr2[i2] && i <= iArr2[i2 + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isInjectClassloader() {
        return this.is_inject_classloader != 0;
    }

    public void setAbandon_apk_path(String str) {
        this.abandon_apk_path = str;
    }

    public void setCmdRange(String str) {
        this.cmdRangeInt = cmdRange2Int(str);
        this.cmdRangeStr = str;
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
    public PluginSetting m8clone() {
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
}
