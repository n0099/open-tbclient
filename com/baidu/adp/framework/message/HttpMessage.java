package com.baidu.adp.framework.message;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpMessage extends Message<List<Map.Entry<String, Object>>> {
    public static final String KEY_COOKIE = "Cookie";
    public Comparator<Map.Entry<String, Object>> mComparator;
    public HashMap<String, String> mHeaders;
    public boolean mNeedProgress;
    public HashMap<String, Object> mParams;
    public String mUserAgent;

    /* loaded from: classes.dex */
    public enum SORT {
        ASCEND,
        DESCEND,
        NONE
    }

    /* loaded from: classes.dex */
    public static class a implements Comparator<Map.Entry<String, Object>> {

        /* renamed from: e  reason: collision with root package name */
        public SORT f2127e;

        public a(SORT sort) {
            this.f2127e = null;
            this.f2127e = sort;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
            if (this.f2127e == SORT.ASCEND) {
                return entry.getKey().compareTo(entry2.getKey());
            }
            return entry2.getKey().compareTo(entry.getKey());
        }
    }

    public HttpMessage(int i2) {
        super(i2);
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mNeedProgress = false;
        initial();
    }

    private byte[] getByte(Object obj) {
        try {
            Object invoke = obj.getClass().getMethod("toByteArray", new Class[0]).invoke(obj, new Object[0]);
            if (invoke == null || !(invoke instanceof byte[])) {
                return null;
            }
            return (byte[]) invoke;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    private void initial() {
        this.mParams = new HashMap<>();
        this.mHeaders = new HashMap<>();
        setSort(SORT.ASCEND);
    }

    private String map2KVString(String str, Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        if (str != null && map != null) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                String str2 = StringUtil.NULL_STRING;
                sb.append(key == null ? StringUtil.NULL_STRING : key.toString());
                sb.append(com.alipay.sdk.encrypt.a.f1873h);
                if (value != null) {
                    str2 = value.toString();
                }
                sb.append(str2);
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private Map<String, String> parseKVString(String str, String str2) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (str != null && str2 != null) {
            for (String str3 : str.split(str2)) {
                int indexOf = str3.indexOf("=");
                if (indexOf != -1) {
                    String trim = str3.substring(0, indexOf).trim();
                    String trim2 = str3.substring(indexOf + 1).trim();
                    if (!trim.isEmpty() && !trim2.isEmpty()) {
                        hashMap.put(trim.trim(), trim2.trim());
                    }
                }
            }
        }
        return hashMap;
    }

    public String addCookie(String str, String str2) {
        Map<String, String> parseKVString;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.mHeaders.containsKey("Cookie") && (parseKVString = parseKVString(this.mHeaders.get("Cookie"), ";")) != null) {
                String str3 = parseKVString.containsKey(str) ? parseKVString.get(str) : null;
                parseKVString.put(str, str2);
                addHeader("Cookie", map2KVString(";", parseKVString));
                return str3;
            }
            addHeader("Cookie", str + com.alipay.sdk.encrypt.a.f1873h + str2 + ';');
        }
        return null;
    }

    public String addHeader(String str, String str2) {
        return this.mHeaders.put(str, str2);
    }

    public byte[] addParam(String str, byte[] bArr) {
        Object put;
        if (str == null || bArr == null || (put = this.mParams.put(str, bArr)) == null || !(put instanceof byte[])) {
            return null;
        }
        return (byte[]) put;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i2) {
        return FrameHelper.b(i2);
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    public HashMap<String, Object> getParams() {
        return this.mParams;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void removeAllParams() {
        this.mParams.clear();
    }

    public String removeCookie(String str) {
        if (str == null || !this.mHeaders.containsKey("Cookie")) {
            return null;
        }
        Map<String, String> parseKVString = parseKVString(this.mHeaders.get("Cookie"), ";");
        String remove = parseKVString.remove(str);
        addHeader("Cookie", map2KVString(";", parseKVString));
        return remove;
    }

    public String removeHeader(String str) {
        return this.mHeaders.remove(str);
    }

    public Object removeParam(String str) {
        return this.mParams.remove(str);
    }

    @Override // com.baidu.adp.framework.message.Message
    public void setClientLogID(long j) {
        super.setClientLogID(j);
    }

    public boolean setNeedProgress() {
        return this.mNeedProgress;
    }

    public synchronized void setSort(SORT sort) {
        if (sort == SORT.NONE) {
            this.mComparator = null;
        } else {
            this.mComparator = new a(sort);
        }
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.Message
    public synchronized List<Map.Entry<String, Object>> encodeInBackGround() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.mParams.entrySet());
        if (this.mComparator != null) {
            Collections.sort(arrayList, this.mComparator);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (!(value instanceof String) && !(value instanceof byte[])) {
                Object obj = getByte(value);
                if (obj == null) {
                    obj = value.toString();
                }
                if (obj == null) {
                    it.remove();
                } else {
                    entry.setValue(obj);
                }
            }
        }
        return arrayList;
    }

    public void setNeedProgress(boolean z) {
        this.mNeedProgress = z;
    }

    public Object addParam(String str, Object obj) {
        if (str == null || obj == null) {
            return null;
        }
        return this.mParams.put(str, obj);
    }

    public Object addParam(String str, int i2) {
        if (str == null) {
            return null;
        }
        return this.mParams.put(str, String.valueOf(i2));
    }

    public Object addParam(String str, long j) {
        if (str == null) {
            return null;
        }
        return this.mParams.put(str, String.valueOf(j));
    }

    public HttpMessage(int i2, BdUniqueId bdUniqueId) {
        super(i2, bdUniqueId);
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mNeedProgress = false;
        initial();
    }

    public String addParam(String str, String str2) {
        Object put;
        if (str == null || str2 == null || (put = this.mParams.put(str, str2)) == null || !(put instanceof String)) {
            return null;
        }
        return (String) put;
    }
}
