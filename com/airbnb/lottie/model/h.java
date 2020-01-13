package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Pair;
import com.baidu.android.imsdk.utils.HanziToPinyin;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class h<T> {
    @Nullable
    T first;
    @Nullable
    T second;

    public void set(T t, T t2) {
        this.first = t;
        this.second = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return objectsEqual(pair.first, this.first) && objectsEqual(pair.second, this.second);
        }
        return false;
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return (this.first == null ? 0 : this.first.hashCode()) ^ (this.second != null ? this.second.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + HanziToPinyin.Token.SEPARATOR + String.valueOf(this.second) + "}";
    }
}
