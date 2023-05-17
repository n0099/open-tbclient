package com.baidu.searchbox.debug.data;

import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getChildItemList", "()Ljava/util/List;", "", "getGroupName", "()Ljava/lang/String;", "<init>", "()V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class DebugDataGroupProvider {
    public abstract List<DebugItemInfo> getChildItemList();

    public abstract String getGroupName();
}
