package com.baidu.searchbox.debug.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/debug/data/CheckDebugItemInfo;", "Lcom/baidu/searchbox/debug/data/CheckItemInfo;", "", "title", "", "initialValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "valueChanged", "<init>", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class CheckDebugItemInfo extends CheckItemInfo {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckDebugItemInfo(String title, boolean z, Function1<? super Boolean, Unit> valueChanged) {
        super(title, new OnCheckListener(valueChanged), Boolean.valueOf(z));
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(valueChanged, "valueChanged");
    }
}
