package com.baidu.searchbox.bdeventbus;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/Action;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Any;", "type", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;)V", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface Action<T> {
    void call(T t);
}
