package com.baidu.live.adp.framework.message;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class HttpMessage extends Message<List<Map.Entry<String, Object>>> {
    private static final String KEY_COOKIE = "Cookie";
    private Comparator<Map.Entry<String, Object>> mComparator;
    private HashMap<String, String> mHeaders;
    private boolean mNeedProgress;
    private HashMap<String, Object> mParams;
    private String mUserAgent;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public enum SORT {
        ASCEND,
        DESCEND,
        NONE
    }

    public HttpMessage(int i) {
        super(i);
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mNeedProgress = false;
        initial();
    }

    public HttpMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mNeedProgress = false;
        initial();
    }

    protected synchronized void setSort(SORT sort) {
        if (sort == SORT.NONE) {
            this.mComparator = null;
        } else {
            this.mComparator = new ParamsComparator(sort);
        }
    }

    public byte[] addParam(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        Object put = this.mParams.put(str, bArr);
        if (put == null || !(put instanceof byte[])) {
            return null;
        }
        return (byte[]) put;
    }

    public Object addParam(String str, Object obj) {
        if (str == null || obj == null) {
            return null;
        }
        return this.mParams.put(str, obj);
    }

    public Object addParam(String str, int i) {
        if (str == null) {
            return null;
        }
        return this.mParams.put(str, String.valueOf(i));
    }

    public Object addParam(String str, long j) {
        if (str == null) {
            return null;
        }
        return this.mParams.put(str, String.valueOf(j));
    }

    public Object addParam(String str, double d) {
        if (str == null) {
            return null;
        }
        return this.mParams.put(str, String.valueOf(d));
    }

    public Object addParam(String str, float f) {
        if (str == null) {
            return null;
        }
        return this.mParams.put(str, String.valueOf(f));
    }

    public String addParam(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        Object put = this.mParams.put(str, str2);
        if (put == null || !(put instanceof String)) {
            return null;
        }
        return (String) put;
    }

    public Object removeParam(String str) {
        return this.mParams.remove(str);
    }

    public void removeAllParams() {
        this.mParams.clear();
    }

    public String addHeader(String str, String str2) {
        return this.mHeaders.put(str, str2);
    }

    public String addCookie(String str, String str2) {
        Map<String, String> parseKVString;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (this.mHeaders.containsKey("Cookie") && (parseKVString = parseKVString(this.mHeaders.get("Cookie"), ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) != null) {
            String str3 = parseKVString.containsKey(str) ? parseKVString.get(str) : null;
            parseKVString.put(str, str2);
            addHeader("Cookie", map2KVString(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, parseKVString));
            return str3;
        }
        addHeader("Cookie", str + '=' + str2 + ';');
        return null;
    }

    public String removeHeader(String str) {
        return this.mHeaders.remove(str);
    }

    public String removeCookie(String str) {
        if (str == null || !this.mHeaders.containsKey("Cookie")) {
            return null;
        }
        Map<String, String> parseKVString = parseKVString(this.mHeaders.get("Cookie"), ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String remove = parseKVString.remove(str);
        addHeader("Cookie", map2KVString(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR, parseKVString));
        return remove;
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    private void initial() {
        this.mParams = new HashMap<>();
        this.mHeaders = new HashMap<>();
        setSort(SORT.ASCEND);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.message.IEncode
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

    private byte[] getByte(Object obj) {
        try {
            Object invoke = obj.getClass().getMethod("toByteArray", new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null && (invoke instanceof byte[])) {
                return (byte[]) invoke;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ParamsComparator implements Comparator<Map.Entry<String, Object>> {
        private SORT mSort;

        public ParamsComparator(SORT sort) {
            this.mSort = null;
            this.mSort = sort;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
            return this.mSort == SORT.ASCEND ? entry.getKey().compareTo(entry2.getKey()) : entry2.getKey().compareTo(entry.getKey());
        }
    }

    @Override // com.baidu.live.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.checkHttpCmd(i);
    }

    public boolean setNeedProgress() {
        return this.mNeedProgress;
    }

    public void setNeedProgress(boolean z) {
        this.mNeedProgress = z;
    }

    @Override // com.baidu.live.adp.framework.message.Message
    public void setClientLogID(long j) {
        super.setClientLogID(j);
    }

    private Map<String, String> parseKVString(String str, String str2) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (str != null && str2 != null) {
            for (String str3 : str.split(str2)) {
                int indexOf = str3.indexOf(ETAG.EQUAL);
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

    private String map2KVString(String str, Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        if (str != null && map != null) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                sb.append(key == null ? "null" : key.toString());
                sb.append('=');
                sb.append(value == null ? "null" : value.toString());
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public void setUserAgent(String str) {
        this.mUserAgent = str;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }
}
