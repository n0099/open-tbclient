package com.baidu.adp.framework.message;

import com.baidu.adp.framework.message.HttpMessage;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes.dex */
class a implements Comparator<Map.Entry<String, Object>> {
    private HttpMessage.SORT cQ;

    public a(HttpMessage.SORT sort) {
        this.cQ = null;
        this.cQ = sort;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
        return this.cQ == HttpMessage.SORT.ASCEND ? entry.getKey().compareTo(entry2.getKey()) : entry2.getKey().compareTo(entry.getKey());
    }
}
