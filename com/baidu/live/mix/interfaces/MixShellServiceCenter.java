package com.baidu.live.mix.interfaces;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.nps.main.manager.Bundle;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/live/mix/interfaces/MixShellServiceCenter;", "Lkotlin/Any;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getMixShellService", "(Ljava/lang/Class;)Ljava/lang/Object;", "lib-live-mix-interface_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixShellServiceCenter {
    <T> T getMixShellService(Class<T> cls);
}
