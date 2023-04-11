package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PackageInfo implements NoProGuard, Cloneable {
    public static final int CODE_FILTERD = 1102;
    public static final int CODE_HOST_VERSION = 1103;
    public static final int CODE_NOT_EXISTS = 1101;
    public static final int CODE_SUCCESS = 0;
    public static final String TAG = "PackageInfo";
    public String abi;
    public String channelId;
    public long createTime;
    public long currentSize;
    public String dependInfo;
    public HashMap<String, String> dependencies;
    public String dependenciesString;
    public int disable;
    public int downloadOption;
    public String downloadUrl;
    public boolean enableXCDN;
    public int errNo;
    public String extraLocal;
    public String extraServer;
    public volatile String filePath;
    public boolean isHitTrafficLimit;
    public boolean isMainEntrance;
    public int isSilence;
    public int isSilentUpgrade;
    public boolean isTrafficForbid;
    public String key;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String netWorkStrategy;
    public String packageName;
    public String patchMD5;
    public String patchUrl;
    public volatile long rawId;
    public int retryCount;
    public String sign;
    public String size;
    public String subBundle;
    public long totalSize;
    public String trafficUrl;
    public volatile int type;
    public String uniqueID;
    public String uniqueVersion;
    public String updateSign;
    public long updateTime;
    public long updateVersion;
    public long version;
    public int wifi;

    public PackageInfo() {
        this(true);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Nullable
    public Map<String, String> getDependencies() {
        return this.dependencies;
    }

    @Nullable
    public String getDependenciesString() {
        return this.dependenciesString;
    }

    public String getNetWorkStrategyUrl() {
        String str;
        if (TextUtils.isEmpty(this.trafficUrl)) {
            str = this.downloadUrl;
        } else {
            str = this.trafficUrl;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(this.netWorkStrategy);
        return sb.toString();
    }

    public String getTrafficUrl() {
        if (TextUtils.isEmpty(this.trafficUrl)) {
            return this.downloadUrl;
        }
        return this.trafficUrl;
    }

    public boolean isAllowSilence() {
        if (this.isSilence == 1) {
            return true;
        }
        return false;
    }

    public boolean isAllowSilenceUpdate() {
        if (this.isSilentUpgrade == 1) {
            return true;
        }
        return false;
    }

    public boolean isDisable() {
        if (this.disable == 1) {
            return true;
        }
        return false;
    }

    public boolean isHitNetWorkStrategy() {
        return this.enableXCDN;
    }

    public boolean isHitTrafficLimit() {
        return this.isHitTrafficLimit;
    }

    public boolean isMainEntrance() {
        return this.isMainEntrance;
    }

    public boolean isOnlyWifi() {
        if (this.wifi == 1) {
            return true;
        }
        return false;
    }

    public boolean isTrafficForbid() {
        return this.isTrafficForbid;
    }

    public boolean isValid() {
        if (this.errNo == 0 && !TextUtils.isEmpty(this.channelId) && !TextUtils.isEmpty(this.packageName) && !TextUtils.isEmpty(this.md5) && !TextUtils.isEmpty(this.downloadUrl) && this.updateVersion >= 0) {
            return true;
        }
        return false;
    }

    public PackageInfo(boolean z) {
        this.errNo = -1;
        this.version = -1L;
        this.updateVersion = 0L;
        this.abi = "";
        this.uniqueVersion = "";
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
        this.isTrafficForbid = false;
        this.isHitTrafficLimit = false;
        this.isMainEntrance = z;
    }

    private boolean checkTrafficLimitTime(JSONObject jSONObject) {
        String optString = jSONObject.optString("startTime");
        String optString2 = jSONObject.optString("endTime");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date parse = simpleDateFormat.parse(optString);
                Date parse2 = simpleDateFormat.parse(optString2);
                long currentTimeMillis = System.currentTimeMillis();
                if (parse != null && parse2 != null && parse.getTime() < currentTimeMillis) {
                    if (parse2.getTime() > currentTimeMillis) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                if (PmsConstant.DEBUG) {
                    Log.d(TAG, "checkTrafficLimitTime fail, exception = " + e.toString());
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    private void addDependencies(String str, String str2) {
        if (this.dependencies == null) {
            this.dependencies = new HashMap<>();
        }
        this.dependencies.put(str, str2);
    }

    private boolean checkTrafficRatio(String str, long j) {
        boolean z;
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        if (crc32.getValue() % 100 < j) {
            z = true;
        } else {
            z = false;
        }
        this.isHitTrafficLimit = z;
        return z;
    }

    private void appendTrafficParam(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.downloadUrl);
        if (this.downloadUrl.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("sle=1&split=100&sl=");
        sb.append(str);
        this.trafficUrl = sb.toString();
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

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PackageInfo)) {
            return false;
        }
        return TextUtils.equals(getKey(), ((PackageInfo) obj).getKey());
    }

    public boolean isOlderThan(PackageInfo packageInfo) {
        if (this.version < packageInfo.version) {
            return true;
        }
        return false;
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

    public void setXCDNEnable(boolean z) {
        this.enableXCDN = z;
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
        packageInfo.abi = this.abi;
    }

    public String getKey() {
        if (TextUtils.isEmpty(this.key) && !TextUtils.isEmpty(this.channelId) && !TextUtils.isEmpty(this.packageName) && !TextUtils.isEmpty(this.md5)) {
            this.key = this.channelId + "_" + this.packageName + "_" + this.md5;
        }
        return this.key;
    }

    public void parseTrafficLimit() {
        boolean z;
        if (TextUtils.isEmpty(this.extraServer)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.extraServer);
            if (!checkTrafficLimitTime(jSONObject)) {
                return;
            }
            if (jSONObject.optInt("limitEnable") == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            String optString = jSONObject.optString("speed");
            if (Long.parseLong(optString) == 0) {
                return;
            }
            long optLong = jSONObject.optLong(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
            if (optLong == 0) {
                return;
            }
            String cuid = AppCuidManager.getInstance().getCuid();
            if (TextUtils.isEmpty(cuid)) {
                return;
            }
            if (!checkTrafficRatio(cuid, optLong)) {
                this.isTrafficForbid = true;
            } else {
                appendTrafficParam(optString);
            }
        } catch (Exception e) {
            if (PmsConstant.DEBUG) {
                Log.d(TAG, "parseTrafficLimit fail, exception = " + e.toString());
            }
        }
    }

    public String toString() {
        return "channelId=" + this.channelId + ",packageName=" + this.packageName + ",version=" + this.version + ",updateVersion=" + this.updateVersion + ",name=" + this.name + ",md5=" + this.md5 + ",type=" + this.type + ",downloadUrl=" + this.downloadUrl + ",extraServer=" + this.extraServer;
    }
}
