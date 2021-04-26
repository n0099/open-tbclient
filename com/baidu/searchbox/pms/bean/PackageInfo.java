package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.NoProGuard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PackageInfo implements NoProGuard, Cloneable {
    public static final int CODE_FILTERD = 1102;
    public static final int CODE_HOST_VERSION = 1103;
    public static final int CODE_NOT_EXISTS = 1101;
    public static final int CODE_SUCCESS = 0;
    public String channelId;
    public long createTime;
    public long currentSize;
    public HashMap<String, String> dependencies;
    public String dependenciesString;
    public int disable;
    public int downloadOption;
    public String downloadUrl;
    public int errNo;
    public String extraLocal;
    public String extraServer;
    public volatile String filePath;
    public boolean isMainEntrance;
    public int isSilence;
    public int isSilentUpgrade;
    public String key;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String packageName;
    public volatile long rawId;
    public int retryCount;
    public String sign;
    public String size;
    public long totalSize;
    public volatile int type;
    public String uniqueID;
    public String updateSign;
    public long updateTime;
    public long updateVersion;
    public long version;
    public int wifi;

    public PackageInfo() {
        this(true);
    }

    private void addDependencies(String str, String str2) {
        if (this.dependencies == null) {
            this.dependencies = new HashMap<>();
        }
        this.dependencies.put(str, str2);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void copyDownloadInfo(PackageInfo packageInfo) {
        packageInfo.errNo = this.errNo;
        packageInfo.type = this.type;
        packageInfo.filePath = this.filePath;
        packageInfo.totalSize = this.totalSize;
        packageInfo.currentSize = this.currentSize;
        packageInfo.createTime = this.createTime;
        packageInfo.updateTime = this.updateTime;
    }

    public void copyTo(PackageInfo packageInfo) {
        packageInfo.name = this.name;
        packageInfo.extraLocal = this.extraLocal;
        packageInfo.downloadOption = this.downloadOption;
        packageInfo.channelId = this.channelId;
        packageInfo.version = this.version;
        packageInfo.updateVersion = this.updateVersion;
        packageInfo.minHostVersion = this.minHostVersion;
        packageInfo.maxHostVersion = this.maxHostVersion;
        packageInfo.extraServer = this.extraServer;
        packageInfo.downloadUrl = this.downloadUrl;
        packageInfo.packageName = this.packageName;
        packageInfo.disable = this.disable;
        packageInfo.wifi = this.wifi;
        packageInfo.isSilence = this.isSilence;
        packageInfo.isSilentUpgrade = this.isSilentUpgrade;
        packageInfo.sign = this.sign;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PackageInfo)) {
            return TextUtils.equals(getKey(), ((PackageInfo) obj).getKey());
        }
        return false;
    }

    @Nullable
    public Map<String, String> getDependencies() {
        return this.dependencies;
    }

    @Nullable
    public String getDependenciesString() {
        return this.dependenciesString;
    }

    public String getKey() {
        if (TextUtils.isEmpty(this.key) && !TextUtils.isEmpty(this.channelId) && !TextUtils.isEmpty(this.packageName) && !TextUtils.isEmpty(this.md5)) {
            this.key = this.channelId + "_" + this.packageName + "_" + this.md5;
        }
        return this.key;
    }

    public boolean isAllowSilence() {
        return this.isSilence == 1;
    }

    public boolean isAllowSilenceUpdate() {
        return this.isSilentUpgrade == 1;
    }

    public boolean isDisable() {
        return this.disable == 1;
    }

    public boolean isMainEntrance() {
        return this.isMainEntrance;
    }

    public boolean isOlderThan(PackageInfo packageInfo) {
        return this.version < packageInfo.version;
    }

    public boolean isOnlyWifi() {
        return this.wifi == 1;
    }

    public boolean isValid() {
        return (this.errNo != 0 || TextUtils.isEmpty(this.channelId) || TextUtils.isEmpty(this.packageName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.updateVersion < 0) ? false : true;
    }

    public void setDependenciesString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(next)) {
                addDependencies(next, optString);
            }
        }
        this.dependenciesString = jSONObject.toString();
    }

    public String toString() {
        return "channelId=" + this.channelId + ",packageName=" + this.packageName + ",version=" + this.version + ",updateVersion=" + this.updateVersion + ",name=" + this.name + ",md5=" + this.md5 + ",type=" + this.type + ",downloadUrl=" + this.downloadUrl;
    }

    public PackageInfo(boolean z) {
        this.errNo = -1;
        this.version = -1L;
        this.updateVersion = 0L;
        this.type = 0;
        this.retryCount = 0;
        this.filePath = "";
        this.totalSize = 0L;
        this.currentSize = 0L;
        this.createTime = 0L;
        this.updateTime = 0L;
        this.rawId = 0L;
        this.uniqueID = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(1000);
        this.isMainEntrance = true;
        this.isMainEntrance = z;
    }
}
