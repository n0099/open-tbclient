package com.baidu.searchbox.debug.data;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BT\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/debug/data/RadioDebugItemInfo;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/debug/data/CustomItemInfo;", "", "title", "", "Lkotlin/Pair;", "radios", "initialValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "valueChanged", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "debug-data_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class RadioDebugItemInfo<T> extends CustomItemInfo {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioDebugItemInfo(String title, List<? extends Pair<String, ? extends T>> radios, T t, Function1<? super T, Unit> valueChanged) {
        super(new RadioDebugViewFetcher(title, radios, t, valueChanged));
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(radios, "radios");
        Intrinsics.checkNotNullParameter(valueChanged, "valueChanged");
    }
}
