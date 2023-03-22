package com.baidu.tbadk.core.util;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"checkNull", "", ExifInterface.GPS_DIRECTION_TRUE, "notNullBlock", "Lkotlin/Function1;", "nullBlock", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "tbadkcore_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ObjectUtilKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T> void checkNull(T t, Function1<? super T, Unit> notNullBlock, Function0<Unit> nullBlock) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, t, notNullBlock, nullBlock) == null) {
            Intrinsics.checkNotNullParameter(notNullBlock, "notNullBlock");
            Intrinsics.checkNotNullParameter(nullBlock, "nullBlock");
            if (t == null) {
                nullBlock.invoke();
            } else {
                notNullBlock.invoke(t);
            }
        }
    }
}
