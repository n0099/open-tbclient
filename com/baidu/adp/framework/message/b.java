package com.baidu.adp.framework.message;

import com.baidu.adp.framework.message.HttpMessage;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes.dex */
final class b implements Comparator<Map.Entry<String, Object>> {
    private HttpMessage.SORT a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
        Map.Entry<String, Object> entry3 = entry;
        Map.Entry<String, Object> entry4 = entry2;
        return this.a == HttpMessage.SORT.ASCEND ? entry3.getKey().compareTo(entry4.getKey()) : entry4.getKey().compareTo(entry3.getKey());
    }

    public b(HttpMessage.SORT sort) {
        this.a = null;
        this.a = sort;
    }
}
