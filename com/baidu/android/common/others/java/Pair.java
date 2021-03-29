package com.baidu.android.common.others.java;
@Deprecated
/* loaded from: classes.dex */
public class Pair<F, S> {
    public final F mFirst;
    public final S mSecond;

    public Pair(F f2, S s) {
        this.mFirst = f2;
        this.mSecond = s;
    }

    public static <A, B> Pair<A, B> create(A a2, B b2) {
        return new Pair<>(a2, b2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Pair) {
            try {
                Pair pair = (Pair) obj;
                return this.mFirst.equals(pair.mFirst) && this.mSecond.equals(pair.mSecond);
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.mFirst.hashCode() + 31) * 31) + this.mSecond.hashCode();
    }
}
