package com.baidu.searchbox.dns;

import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DnsParseResult {
    public static final int NETWORK_STACK_TYPE_BOTH = 3;
    public static final int NETWORK_STACK_TYPE_IPV4 = 1;
    public static final int NETWORK_STACK_TYPE_IPV6 = 2;
    public static final int NETWORK_STACK_TYPE_NONE = 0;
    public static final int SUBTYPE_ASYNC_TASK_ONGOING = 4;
    public static final int SUBTYPE_BACKUP_IP = 5;
    public static final int SUBTYPE_CACHE_ERROR = 1004;
    public static final int SUBTYPE_CACHE_EXPIRE = 1003;
    public static final int SUBTYPE_CACHE_EXPIRE_DEFAULT = 1007;
    public static final int SUBTYPE_CACHE_EXPIRE_USE = 2009;
    public static final int SUBTYPE_CACHE_HIT = 2001;
    public static final int SUBTYPE_CACHE_HIT_DEFAULT = 2003;
    public static final int SUBTYPE_CACHE_HIT_PREFETCH = 1001;
    public static final int SUBTYPE_CACHE_LIST_ENMPTY = 1006;
    public static final int SUBTYPE_CACHE_TIME_INVALID = 1008;
    public static final int SUBTYPE_FORCE_HTTP = 2002;
    public static final int SUBTYPE_HTTP_CLOSE = 1;
    public static final int SUBTYPE_HTTP_ERROR = 2;
    public static final int SUBTYPE_HTTP_LIST_EMPTY = 3;
    public static final int SUBTYPE_NO_CACHE = 1002;
    public static final int SUBYYPE_CACHE_INVALID = 1005;
    public static final int TYPE_DNS_PROXY = 2000;
    public static final int TYPE_LOCAL = 0;
    public static final int TYPE_LOCAL_ASYNC_HTTP = 1000;
    public int addressType;
    public String area;
    public String clientIp;
    public String httpdnsIp;
    public boolean idcToBgp = false;
    public List<String> ipList;
    public int stackType;
    public int subType;
    public int type;

    public DnsParseResult(List<String> list, int i, int i2, int i3) {
        this.stackType = 0;
        if (list != null && !list.isEmpty()) {
            this.ipList = Collections.unmodifiableList(list);
        } else {
            this.ipList = null;
        }
        this.type = i;
        this.subType = i2;
        this.stackType = i3;
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
        return this.ipList;
    }

    public int getStackType() {
        return this.stackType;
    }

    public int getSubType() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public void setHttpdnsInfo(String str, String str2, String str3, int i, boolean z) {
        this.area = str;
        this.clientIp = str2;
        this.httpdnsIp = str3;
        this.addressType = i;
        this.idcToBgp = z;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put(AdvisoryMsgBusinessExtra.SUBTYPE_KEY, this.subType);
            jSONObject.put("ipList", new JSONArray((Collection) this.ipList));
            jSONObject.put("stackType", this.stackType);
            jSONObject.put(DnsModel.AREA_KEY, this.area);
            jSONObject.put("clientIp", this.clientIp);
            jSONObject.put(DnsModel.HTTPDNSIP_KEY, this.httpdnsIp);
            jSONObject.put(DnsModel.ADDRESSTYPE_KEY, this.addressType);
            jSONObject.put(DnsModel.IDCTOBGP_KEY, this.idcToBgp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
