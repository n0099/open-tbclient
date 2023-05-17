package com.baidu.searchbox.dns.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DnsCacheHelper {
    public static final String DIR_NAME = "dns";
    public static final String SP_BACKUPIP_KEY = "SP_BACKUPIP_KEY";
    public static final String SP_BACKUPIP_VERSION_KEY = "SP_BACKUPIP_VERSION_KEY";
    public static final String SP_DNS_KEY = "dns_prefs";
    public static volatile DnsCacheHelper cacheHelper;
    public volatile int mAddressType;
    public volatile String mAreaInfo;
    public volatile String mClientIp;
    public volatile String mHttpdnsIp;
    public volatile long mLastAreaInfoUpdateTime;
    public boolean isIPv6TestArea = false;
    public volatile boolean mIdcToBgp = false;
    public ICache cache = new MemCache();
    public ICache backupCache = new MemCache();

    public static DnsCacheHelper getCacheHelper() {
        return cacheHelper;
    }

    public void clear() {
        this.cache.clear();
        this.backupCache.clear();
        this.isIPv6TestArea = false;
        this.mAreaInfo = null;
        this.mClientIp = null;
        this.mLastAreaInfoUpdateTime = -1L;
    }

    public int getAddressType() {
        return this.mAddressType;
    }

    public String getAreaInfo() {
        return this.mAreaInfo;
    }

    public String getClientIp() {
        return this.mClientIp;
    }

    public String getDiskBackUpIp() {
        return KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).getString(SP_BACKUPIP_KEY, "");
    }

    public String getDiskBackUpIpVersion() {
        return KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).getString(SP_BACKUPIP_VERSION_KEY, "0");
    }

    public String getHttpdnsIp() {
        return this.mHttpdnsIp;
    }

    public boolean getIdcToBgp() {
        return this.mIdcToBgp;
    }

    public boolean getIsIPv6TestArea() {
        return this.isIPv6TestArea;
    }

    public long getLastAreaInfoUpdateTime() {
        return this.mLastAreaInfoUpdateTime;
    }

    public boolean isIPv6TestArea() {
        return this.isIPv6TestArea;
    }

    public static void initCacheHelper(Context context) {
        if (cacheHelper == null) {
            synchronized (DnsCacheHelper.class) {
                if (cacheHelper == null) {
                    cacheHelper = new DnsCacheHelper();
                }
            }
        }
    }

    public void cacheBackUpIp(String str) {
        SharedPreferences.Editor edit = KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).edit();
        edit.putString(SP_BACKUPIP_KEY, str);
        edit.apply();
    }

    public void cacheBackUpIpVersion(String str) {
        SharedPreferences.Editor edit = KVStorageFactory.getSharedPreferences(SP_DNS_KEY, 0).edit();
        edit.putString(SP_BACKUPIP_VERSION_KEY, str);
        edit.apply();
    }

    public DnsModel get(String str) {
        String str2 = this.cache.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return new DnsModel(str2);
        }
        return null;
    }

    public void setAddressType(int i) {
        this.mAddressType = i;
    }

    public void setAreaInfo(String str) {
        this.mAreaInfo = str;
    }

    public void setClientIp(String str) {
        this.mClientIp = str;
    }

    public void setHttpdnsIp(String str) {
        this.mHttpdnsIp = str;
    }

    public void setIdcToBgp(boolean z) {
        this.mIdcToBgp = z;
    }

    public void setIsIPv6TestArea(boolean z) {
        this.isIPv6TestArea = z;
    }

    public void setLastAreaInfoUpdateTime(long j) {
        this.mLastAreaInfoUpdateTime = j;
    }

    public DnsModel getBackup(String str) {
        try {
            if (this.backupCache.isEmpty()) {
                String diskBackUpIp = getDiskBackUpIp();
                if (TextUtils.isEmpty(diskBackUpIp)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(diskBackUpIp);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("ip");
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.getString(i));
                        }
                        if (!arrayList.isEmpty()) {
                            putBackup(next, new DnsModel(null, 0, null, null, getHttpdnsIp(), getAddressType(), getIdcToBgp(), 0L, arrayList, null));
                        }
                    }
                }
            }
            String str2 = this.backupCache.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return new DnsModel(str2);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void put(String str, DnsModel dnsModel) {
        if (dnsModel != null) {
            String dnsModel2 = dnsModel.toString();
            if (!TextUtils.isEmpty(dnsModel2)) {
                this.cache.put(str, dnsModel2);
            }
        }
    }

    public void putBackup(String str, DnsModel dnsModel) {
        if (dnsModel != null) {
            String dnsModel2 = dnsModel.toString();
            if (!TextUtils.isEmpty(dnsModel2)) {
                this.backupCache.put(str, dnsModel2);
            }
        }
    }
}
