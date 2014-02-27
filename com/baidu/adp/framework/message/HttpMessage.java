package com.baidu.adp.framework.message;

import com.baidu.adp.framework.FrameHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class HttpMessage extends e<List<Map.Entry<String, Object>>> {
    private HashMap<String, String> a;
    private HashMap<String, Object> b;
    private Comparator<Map.Entry<String, Object>> c;
    private int d;

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

    public final HashMap<String, String> a() {
        return this.a;
    }

    public final boolean b() {
        return this.d > 0;
    }

    public final List<Map.Entry<String, Object>> c() {
        ArrayList arrayList = new ArrayList(this.b.entrySet());
        if (this.c != null) {
            Collections.sort(arrayList, this.c);
        }
        return arrayList;
    }

    @Override // com.baidu.adp.framework.message.e
    public final boolean a(int i) {
        return FrameHelper.b(i);
    }
}
