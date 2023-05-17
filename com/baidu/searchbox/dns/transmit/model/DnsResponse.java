package com.baidu.searchbox.dns.transmit.model;

import android.text.TextUtils;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DnsResponse {
    public static final String BACKUP_DATA = "backup";
    public static final String BACKUP_VERSION = "version";
    public static final String DATA = "data";
    public static final String EXT_INFO = "ext-info";
    public static final String IPV6_GROUP = "ipv6-group";
    public static final String IPV6_TEST_AREA = "ipv6-test-area";
    public HashMap<String, DnsModel> backupDnsMap;
    public String backupIpString;
    public String backupIpVersion;
    public HashMap<String, DnsModel> dnsMap;
    public boolean hasExtInfo;
    public boolean isIPv6TestArea;
    public int mAddressType;
    public String mAreaInfo;
    public String mClientIp;
    public String mHttpdnsIp;
    public boolean mIdcToBgp;

    public DnsResponse(String str, String str2, int i, boolean z) {
        String str3;
        String str4;
        JSONObject optJSONObject;
        String str5;
        JSONObject jSONObject;
        String str6;
        ArrayList arrayList;
        DnsModel dnsModel;
        ArrayList ipList;
        String str7;
        String str8;
        ArrayList arrayList2;
        String str9;
        String str10;
        String str11;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        int i2;
        String str12;
        String str13;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        ArrayList arrayList3;
        ArrayList arrayList4;
        this.hasExtInfo = false;
        this.isIPv6TestArea = false;
        this.mIdcToBgp = false;
        this.backupIpString = null;
        this.backupIpVersion = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject7 = new JSONObject(str);
                String optString = jSONObject7.optString("msg", "error");
                String optString2 = jSONObject7.optString(DnsModel.AREA_KEY);
                this.mAreaInfo = optString2;
                String optString3 = jSONObject7.optString(DnsModel.CLIENTIP_KEY);
                this.mClientIp = optString3;
                this.mHttpdnsIp = str2;
                this.mAddressType = i;
                this.mIdcToBgp = z;
                int optInt = jSONObject7.optInt("ttl", 60) * 1000;
                JSONObject optJSONObject2 = jSONObject7.optJSONObject("data");
                JSONObject optJSONObject3 = jSONObject7.optJSONObject("backup");
                JSONObject optJSONObject4 = jSONObject7.optJSONObject("ext-info");
                this.backupIpVersion = jSONObject7.optString("version");
                try {
                    long optLong = jSONObject7.optLong(DnsModel.CACHETIME_KEY, System.currentTimeMillis());
                    String str14 = "ipv6";
                    String str15 = "ip";
                    if (optJSONObject2 != null) {
                        Iterator<String> keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONObject optJSONObject5 = optJSONObject2.optJSONObject(next);
                            if (optJSONObject5 != null) {
                                JSONArray optJSONArray = optJSONObject5.optJSONArray(str15);
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    str13 = str15;
                                    jSONObject5 = optJSONObject4;
                                    ArrayList arrayList5 = new ArrayList(optJSONArray.length());
                                    jSONObject6 = optJSONObject3;
                                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                        arrayList5.add(optJSONArray.getString(i3));
                                    }
                                    arrayList3 = arrayList5;
                                } else {
                                    str13 = str15;
                                    jSONObject5 = optJSONObject4;
                                    jSONObject6 = optJSONObject3;
                                    arrayList3 = null;
                                }
                                JSONArray optJSONArray2 = optJSONObject5.optJSONArray(str14);
                                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                    ArrayList arrayList6 = new ArrayList(optJSONArray2.length());
                                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                        arrayList6.add(optJSONArray2.getString(i4));
                                    }
                                    arrayList4 = arrayList6;
                                } else {
                                    arrayList4 = null;
                                }
                                if ((arrayList3 != null && !arrayList3.isEmpty()) || (arrayList4 != null && !arrayList4.isEmpty())) {
                                    str9 = str14;
                                    str11 = str13;
                                    str10 = optString;
                                    jSONObject2 = jSONObject5;
                                    jSONObject3 = jSONObject6;
                                    ArrayList arrayList7 = arrayList3;
                                    jSONObject4 = optJSONObject2;
                                    i2 = optInt;
                                    str12 = optString3;
                                    DnsModel dnsModel2 = new DnsModel(optString, optInt, optString2, optString3, str2, i, z, optLong, arrayList7, arrayList4);
                                    try {
                                        if (this.dnsMap == null) {
                                            this.dnsMap = new HashMap<>();
                                        }
                                        this.dnsMap.put(next, dnsModel2);
                                        if (DnsTransmitter.IDC_HOST.equalsIgnoreCase(next) && arrayList7.size() > 0) {
                                            DnsTransmitter.setIDCIp((String) arrayList7.get(0));
                                            DnsTransmitter.setIDCIpCacheTime(optLong);
                                            str14 = str9;
                                            str15 = str11;
                                            optJSONObject4 = jSONObject2;
                                            optString = str10;
                                            optJSONObject3 = jSONObject3;
                                            optJSONObject2 = jSONObject4;
                                            optInt = i2;
                                            optString3 = str12;
                                        }
                                    } catch (JSONException e) {
                                        e = e;
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                str15 = str13;
                                optJSONObject4 = jSONObject5;
                                optJSONObject3 = jSONObject6;
                            } else {
                                str9 = str14;
                                str10 = optString;
                                str11 = str15;
                                jSONObject2 = optJSONObject4;
                                jSONObject3 = optJSONObject3;
                                jSONObject4 = optJSONObject2;
                                i2 = optInt;
                                str12 = optString3;
                            }
                            str14 = str9;
                            str15 = str11;
                            optJSONObject4 = jSONObject2;
                            optString = str10;
                            optJSONObject3 = jSONObject3;
                            optJSONObject2 = jSONObject4;
                            optInt = i2;
                            optString3 = str12;
                        }
                    }
                    String str16 = str14;
                    String str17 = optString;
                    String str18 = str15;
                    JSONObject jSONObject8 = optJSONObject4;
                    int i5 = optInt;
                    String str19 = optString3;
                    JSONObject jSONObject9 = optJSONObject3;
                    if (jSONObject9 != null) {
                        Iterator<String> keys2 = jSONObject9.keys();
                        this.backupDnsMap = new HashMap<>();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            JSONObject optJSONObject6 = jSONObject9.optJSONObject(next2);
                            if (optJSONObject6 != null) {
                                String str20 = str18;
                                JSONArray optJSONArray3 = optJSONObject6.optJSONArray(str20);
                                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                    ArrayList arrayList8 = new ArrayList(optJSONArray3.length());
                                    for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                                        arrayList8.add(optJSONArray3.getString(i6));
                                    }
                                    arrayList2 = arrayList8;
                                } else {
                                    arrayList2 = null;
                                }
                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                    str7 = optString2;
                                    str8 = str20;
                                    this.backupDnsMap.put(next2, new DnsModel(str17, i5, optString2, str19, str2, i, z, optLong, arrayList2, null));
                                }
                                str18 = str20;
                            } else {
                                str7 = optString2;
                                str8 = str18;
                            }
                            optString2 = str7;
                            str18 = str8;
                        }
                        str3 = optString2;
                        str4 = str18;
                        this.backupIpString = jSONObject9.toString();
                    } else {
                        str3 = optString2;
                        str4 = str18;
                    }
                    if (jSONObject8 != null) {
                        this.hasExtInfo = true;
                        boolean optBoolean = jSONObject8.optBoolean(IPV6_TEST_AREA);
                        this.isIPv6TestArea = optBoolean;
                        if (optBoolean && (optJSONObject = jSONObject8.optJSONObject("ipv6-group")) != null) {
                            Iterator<String> keys3 = optJSONObject.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                JSONObject optJSONObject7 = optJSONObject.optJSONObject(next3);
                                if (optJSONObject7 != null) {
                                    String str21 = str16;
                                    JSONArray optJSONArray4 = optJSONObject7.optJSONArray(str21);
                                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                                        ArrayList arrayList9 = new ArrayList(optJSONArray4.length());
                                        for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                                            arrayList9.add(optJSONArray4.getString(i7));
                                        }
                                        String str22 = str4;
                                        JSONArray optJSONArray5 = optJSONObject7.optJSONArray(str22);
                                        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                                            arrayList = new ArrayList(optJSONArray5.length());
                                            for (int i8 = 0; i8 < optJSONArray5.length(); i8++) {
                                                arrayList.add(optJSONArray5.getString(i8));
                                            }
                                        } else {
                                            arrayList = null;
                                        }
                                        if (this.dnsMap == null) {
                                            this.dnsMap = new HashMap<>();
                                        }
                                        if ((arrayList == null || arrayList.isEmpty()) && (dnsModel = this.dnsMap.get(next3)) != null) {
                                            ipList = dnsModel.getIpList();
                                        } else {
                                            ipList = arrayList;
                                        }
                                        jSONObject = optJSONObject;
                                        str6 = str22;
                                        str5 = str21;
                                        this.dnsMap.put(next3, new DnsModel(str17, i5, str3, str19, str2, i, z, optLong, ipList, arrayList9));
                                    } else {
                                        str16 = str21;
                                    }
                                } else {
                                    str5 = str16;
                                    jSONObject = optJSONObject;
                                    str6 = str4;
                                }
                                optJSONObject = jSONObject;
                                str4 = str6;
                                str16 = str5;
                            }
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        }
    }

    public int getAddressType() {
        return this.mAddressType;
    }

    public String getAreaInfo() {
        return this.mAreaInfo;
    }

    public Map<String, DnsModel> getBackUpDnsMap() {
        HashMap<String, DnsModel> hashMap = this.backupDnsMap;
        if (hashMap != null) {
            return Collections.unmodifiableMap(hashMap);
        }
        return null;
    }

    public String getBackUpString() {
        return this.backupIpString;
    }

    public String getBackUpVersion() {
        return this.backupIpVersion;
    }

    public String getClientIp() {
        return this.mClientIp;
    }

    public Map<String, DnsModel> getDnsMap() {
        HashMap<String, DnsModel> hashMap = this.dnsMap;
        if (hashMap != null) {
            return Collections.unmodifiableMap(hashMap);
        }
        return null;
    }

    public String getHttpdnsIp() {
        return this.mHttpdnsIp;
    }

    public boolean getIdcToBgp() {
        return this.mIdcToBgp;
    }

    public boolean hasExtInfo() {
        return this.hasExtInfo;
    }

    public boolean isIPv6TestArea() {
        return this.isIPv6TestArea;
    }
}
