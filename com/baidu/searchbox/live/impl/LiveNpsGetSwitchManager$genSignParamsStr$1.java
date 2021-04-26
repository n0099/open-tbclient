package com.baidu.searchbox.live.impl;

import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00032&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "o1", "", "", "kotlin.jvm.PlatformType", "o2", "compare"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveNpsGetSwitchManager$genSignParamsStr$1<T> implements Comparator<Map.Entry<? extends String, ? extends String>> {
    public static final LiveNpsGetSwitchManager$genSignParamsStr$1 INSTANCE = new LiveNpsGetSwitchManager$genSignParamsStr$1();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Map.Entry<? extends String, ? extends String> entry, Map.Entry<? extends String, ? extends String> entry2) {
        return compare2((Map.Entry<String, String>) entry, (Map.Entry<String, String>) entry2);
    }

    /* renamed from: compare  reason: avoid collision after fix types in other method */
    public final int compare2(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
        return entry.getKey().compareTo(entry2.getKey());
    }
}
