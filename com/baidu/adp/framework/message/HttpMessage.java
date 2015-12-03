package com.baidu.adp.framework.message;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
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
    private Comparator<Map.Entry<String, Object>> mComparator;
    private HashMap<String, String> mHeaders;
    private boolean mNeedProgress;
    private HashMap<String, Object> mParams;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public enum SORT {
        ASCEND,
        DESCEND,
        NONE;

        /* JADX DEBUG: Replace access to removed values field (qv) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static SORT[] valuesCustom() {
            SORT[] valuesCustom = values();
            int length = valuesCustom.length;
            SORT[] sortArr = new SORT[length];
            System.arraycopy(valuesCustom, 0, sortArr, 0, length);
            return sortArr;
        }
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
            this.mComparator = new a(sort);
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
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (this.mHeaders.containsKey(KEY_COOKIE)) {
            hashMap.putAll(j.B(this.mHeaders.get(KEY_COOKIE), ";"));
        }
        String str3 = hashMap.containsKey(str) ? (String) hashMap.get(str) : null;
        hashMap.put(str, str2);
        addHeader(KEY_COOKIE, j.b(";", hashMap));
        return str3;
    }

    public String removeHeader(String str) {
        return this.mHeaders.remove(str);
    }

    public String removeCookie(String str) {
        if (str == null || !this.mHeaders.containsKey(KEY_COOKIE)) {
            return null;
        }
        Map<String, String> B = j.B(this.mHeaders.get(KEY_COOKIE), ";");
        String remove = B.remove(str);
        addHeader(KEY_COOKIE, j.b(";", B));
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
    /* loaded from: classes.dex */
    public static class a implements Comparator<Map.Entry<String, Object>> {
        private SORT qu;

        public a(SORT sort) {
            this.qu = null;
            this.qu = sort;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
            return this.qu == SORT.ASCEND ? entry.getKey().compareTo(entry2.getKey()) : entry2.getKey().compareTo(entry.getKey());
        }
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.v(i);
    }

    public boolean setNeedProgress() {
        return this.mNeedProgress;
    }

    public void setNeedProgress(boolean z) {
        this.mNeedProgress = z;
    }

    @Override // com.baidu.adp.framework.message.Message
    public void setClientLogID(long j) {
        super.setClientLogID(j);
    }
}
