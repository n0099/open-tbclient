package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpMessage extends Message<List<Map.Entry<String, Object>>> {
    private Comparator<Map.Entry<String, Object>> mComparator;
    private HashMap<String, String> mHeaders;
    private boolean mNeedProgress;
    private HashMap<String, Object> mParams;
    private int mRawNum;

    /* loaded from: classes.dex */
    public enum SORT {
        ASCEND,
        DESCEND,
        NONE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
        this.mRawNum = 0;
        this.mNeedProgress = false;
        initial();
    }

    public HttpMessage(int i, int i2) {
        super(i, i2);
        this.mHeaders = null;
        this.mParams = null;
        this.mComparator = null;
        this.mRawNum = 0;
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
        this.mRawNum++;
        if (put == null || !(put instanceof byte[])) {
            return null;
        }
        this.mRawNum--;
        return (byte[]) put;
    }

    public Object addParam(String str, Object obj) {
        if (str == null || obj == null) {
            return null;
        }
        Object put = this.mParams.put(str, obj);
        this.mRawNum++;
        if (put != null) {
            this.mRawNum--;
            return put;
        }
        return put;
    }

    public String addParam(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        Object put = this.mParams.put(str, str2);
        if (put != null) {
            if (put instanceof byte[]) {
                this.mRawNum--;
                return null;
            } else if (put instanceof String) {
                return (String) put;
            }
        }
        return null;
    }

    public Object removeParam(String str) {
        Object remove = this.mParams.remove(str);
        if (remove != null && (remove instanceof byte[])) {
            this.mRawNum--;
        }
        return remove;
    }

    public void removeAllParams() {
        this.mParams.clear();
        this.mRawNum = 0;
    }

    public String addHeader(String str, String str2) {
        return this.mHeaders.put(str, str2);
    }

    public String removeHeader(String str) {
        return this.mHeaders.remove(str);
    }

    public HashMap<String, String> getHeaders() {
        return this.mHeaders;
    }

    public boolean hasRaw() {
        return this.mRawNum > 0;
    }

    private void initial() {
        this.mParams = new HashMap<>();
        this.mHeaders = new HashMap<>();
        setSort(SORT.ASCEND);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public List<Map.Entry<String, Object>> encodeInBackGround() {
        ArrayList arrayList = new ArrayList(this.mParams.entrySet());
        if (this.mComparator != null) {
            Collections.sort(arrayList, this.mComparator);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entry = (Map.Entry) arrayList.get(i);
            Object value = entry.getValue();
            if (!(value instanceof String) && !(value instanceof byte[])) {
                entry.setValue(getByte(value));
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
            BdLog.e("getByte error");
        }
        return null;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.b(i);
    }

    public boolean setNeedProgress() {
        return this.mNeedProgress;
    }

    public void setNeedProgress(boolean z) {
        this.mNeedProgress = z;
    }
}
