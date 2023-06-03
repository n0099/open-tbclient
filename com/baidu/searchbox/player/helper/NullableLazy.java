package com.baidu.searchbox.player.helper;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.msp.push.mode.MessageStat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\f\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0086\u0002¢\u0006\u0002\u0010\u0010J.\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/player/helper/NullableLazy;", ExifInterface.GPS_DIRECTION_TRUE, "", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "hasInitialized", "", "getInitializer", "()Lkotlin/jvm/functions/Function0;", "value", "Ljava/lang/Object;", "getValue", "thisRef", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NullableLazy<T> {
    public volatile boolean hasInitialized;
    public final Function0<T> initializer;
    public volatile T value;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public NullableLazy(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
    }

    public final Function0<T> getInitializer() {
        return this.initializer;
    }

    public final synchronized <T> T getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (!this.hasInitialized) {
            this.hasInitialized = true;
            this.value = this.initializer.invoke();
        }
        return this.value;
    }

    public final synchronized void setValue(Object obj, KProperty<?> property, T t) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (t == null) {
            this.value = t;
            this.hasInitialized = false;
        }
    }
}
