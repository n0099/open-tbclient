package com.baidu.searchbox.dns.transmit.model;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DnsModel {
    public static final String ADDRESSTYPE_KEY = "addressType";
    public static final String AREA_KEY = "area";
    public static final String CACHETIME_KEY = "cachetime";
    public static final String CLIENTIP_KEY = "clientip";
    public static final int DEFAULT_TTL = 60;
    public static final String HTTPDNSIP_KEY = "httpdnsIp";
    public static final String IDCTOBGP_KEY = "idcToBgp";
    public static final String IPV6_KEY = "ipv6";
    public static final String IP_KEY = "ip";
    public static final String MSG_ERROR = "error";
    public static final String MSG_KEY = "msg";
    public static final String MSG_OK = "ok";
    public static final String MSG_STOP = "stop";
    public static final String MSG_WARNING = "warning";
    public static final String TTL_KEY = "ttl";
    public int addressType;
    public String area;
    public long cacheTime;
    public String clientIp;
    public String httpdnsIp;
    public boolean idcToBgp;
    public List<String> ipList;
    public List<String> ipv6List;
    public String msg;
    public String rawString;
    public int ttl;

    public DnsModel(String str) {
        this.idcToBgp = false;
        this.rawString = str;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(this.rawString);
                this.msg = jSONObject.optString("msg", "error");
                this.area = jSONObject.optString(AREA_KEY);
                this.clientIp = jSONObject.optString(CLIENTIP_KEY);
                this.httpdnsIp = jSONObject.optString(HTTPDNSIP_KEY);
                this.addressType = jSONObject.optInt(ADDRESSTYPE_KEY);
                this.idcToBgp = jSONObject.optBoolean(IDCTOBGP_KEY);
                this.ttl = jSONObject.optInt("ttl", -1);
                this.cacheTime = jSONObject.optLong(CACHETIME_KEY, -1L);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                this.ipList = new ArrayList(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.ipList.add(optJSONArray.getString(i));
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ipv6");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.ipv6List = new ArrayList(optJSONArray2.length());
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.ipv6List.add(optJSONArray2.getString(i2));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public DnsModel(String str, int i, String str2, String str3, String str4, int i2, boolean z, long j, List<String> list, List<String> list2) {
        this.idcToBgp = false;
        this.msg = str;
        this.ttl = i;
        this.area = str2;
        this.cacheTime = j;
        this.clientIp = str3;
        this.httpdnsIp = str4;
        this.addressType = i2;
        this.idcToBgp = z;
        this.ipList = list;
        this.ipv6List = list2;
        this.rawString = getRawString();
    }

    private String getRawString() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) this.ipList);
            JSONArray jSONArray2 = new JSONArray((Collection) this.ipv6List);
            jSONObject.put("msg", this.msg);
            jSONObject.put(AREA_KEY, this.area);
            jSONObject.put(CLIENTIP_KEY, this.clientIp);
            jSONObject.put(HTTPDNSIP_KEY, this.httpdnsIp);
            jSONObject.put(ADDRESSTYPE_KEY, this.addressType);
            jSONObject.put(IDCTOBGP_KEY, this.idcToBgp);
            jSONObject.put("ttl", this.ttl);
            jSONObject.put(CACHETIME_KEY, this.cacheTime);
            jSONObject.put("ip", jSONArray);
            jSONObject.put("ipv6", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String listToString(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public int getAddressType() {
        return this.addressType;
    }

    public String getArea() {
        return this.area;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getHttpdnsIp() {
        return this.httpdnsIp;
    }

    public boolean getIdcToBgp() {
        return this.idcToBgp;
    }

    public List<String> getIpList() {
        if (this.ipList != null) {
            if (DnsUtil.DEBUG) {
                Log.i(DnsUtil.TAG, " getIp v4 List: " + listToString(this.ipList));
            }
            return Collections.unmodifiableList(this.ipList);
        }
        return null;
    }

    public List<String> getIpv6List() {
        if (this.ipv6List != null) {
            if (DnsUtil.DEBUG) {
                Log.i(DnsUtil.TAG, " getIp v6 List: " + listToString(this.ipv6List));
            }
            return Collections.unmodifiableList(this.ipv6List);
        }
        return null;
    }

    public String toString() {
        return this.rawString;
    }
}
