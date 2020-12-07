package com.baidu.searchbox.dns;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
    private int k;
    private List<String> l;
    private int stackType;
    private int type;

    public DnsParseResult(List<String> list, int i, int i2, int i3) {
        this.stackType = 0;
        if (list != null && !list.isEmpty()) {
            this.l = Collections.unmodifiableList(list);
        } else {
            this.l = null;
        }
        this.type = i;
        this.k = i2;
        this.stackType = i3;
    }

    public List<String> getIpList() {
        return this.l;
    }

    public int getType() {
        return this.type;
    }

    public int getSubType() {
        return this.k;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("subType", this.k);
            jSONObject.put("ipList", new JSONArray((Collection) this.l));
            jSONObject.put("stackType", this.stackType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public int getStackType() {
        return this.stackType;
    }
}
