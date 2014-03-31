package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class HttpMessage extends d<List<Map.Entry<String, Object>>> {
    private HashMap<String, String> a;
    private HashMap<String, Object> b;
    private Comparator<Map.Entry<String, Object>> c;
    private int d;
    private boolean e;

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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.b = new HashMap<>();
        this.a = new HashMap<>();
        a(SORT.ASCEND);
    }

    private synchronized void a(SORT sort) {
        if (sort == SORT.NONE) {
            this.c = null;
        } else {
            this.c = new b(sort);
        }
    }

    public final String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        Object put = this.b.put(str, str2);
        if (put != null) {
            if (put instanceof byte[]) {
                this.d--;
                return null;
            } else if (put instanceof String) {
                return (String) put;
            }
        }
        return null;
    }

    public final void a() {
        this.b.clear();
        this.d = 0;
    }

    public final String b(String str, String str2) {
        return this.a.put(str, str2);
    }

    public final HashMap<String, String> b() {
        return this.a;
    }

    public final boolean c() {
        return this.d > 0;
    }

    public final List<Map.Entry<String, Object>> d() {
        ArrayList arrayList = new ArrayList(this.b.entrySet());
        if (this.c != null) {
            Collections.sort(arrayList, this.c);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entry = (Map.Entry) arrayList.get(i);
            Object value = entry.getValue();
            if (!(value instanceof String) && !(value instanceof byte[])) {
                entry.setValue(a(value));
            }
        }
        return arrayList;
    }

    private static byte[] a(Object obj) {
        try {
            Object invoke = obj.getClass().getMethod("toByteArray", new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null && (invoke instanceof byte[])) {
                return (byte[]) invoke;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("getByte error");
        }
        return null;
    }

    @Override // com.baidu.adp.framework.message.d
    public final boolean a(int i) {
        return FrameHelper.c(i) || FrameHelper.b(i);
    }
}
