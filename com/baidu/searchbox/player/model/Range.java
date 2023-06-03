package com.baidu.searchbox.player.model;

import androidx.exifinterface.media.ExifInterface;
import com.fun.ad.sdk.FunAdSdk;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/player/model/Range;", ExifInterface.GPS_DIRECTION_TRUE, "", "range", "", "(Ljava/lang/String;)V", FunAdSdk.PLATFORM_MAX, "getMax", "()Ljava/lang/Object;", "setMax", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "min", "getMin", "setMin", "contains", "", "value", "(Ljava/lang/Object;)Z", "isValid", "parseRangeString", "", "parseValue", "content", "(Ljava/lang/String;)Ljava/lang/Object;", "toString", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Range<T> {
    public T max;
    public T min;
    public final String range;

    public abstract boolean contains(T t);

    public abstract T parseValue(String str);

    public Range(String str) {
        this.range = str;
        parseRangeString();
    }

    public final void setMax(T t) {
        this.max = t;
    }

    public final void setMin(T t) {
        this.min = t;
    }

    private final void parseRangeString() {
        boolean z;
        String str = this.range;
        if (str != null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
                if (split$default.size() > 1) {
                    this.min = parseValue((String) split$default.get(0));
                    this.max = parseValue((String) split$default.get(1));
                }
            }
        }
    }

    public final T getMax() {
        return this.max;
    }

    public final T getMin() {
        return this.min;
    }

    public final boolean isValid() {
        if (this.min == null && this.max == null) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[range]:max value is " + this.max + ",min value is " + this.min;
    }
}
