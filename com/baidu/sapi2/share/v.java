package com.baidu.sapi2.share;

import android.content.Intent;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes19.dex */
class v implements Comparator<Map.Entry<Intent, Integer>> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(Map.Entry<Intent, Integer> entry, Map.Entry<Intent, Integer> entry2) {
        return entry.getValue().compareTo(entry2.getValue());
    }
}
