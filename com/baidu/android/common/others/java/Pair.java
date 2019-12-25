package com.baidu.android.common.others.java;
/* loaded from: classes9.dex */
public class Pair<F, S> {
    public final F mFirst;
    public final S mSecond;

    public Pair(F f, S s) {
        this.mFirst = f;
        this.mSecond = s;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Pair) {
            try {
                Pair pair = (Pair) obj;
                return this.mFirst.equals(pair.mFirst) && this.mSecond.equals(pair.mSecond);
            } catch (ClassCastException e) {
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.mFirst.hashCode() + 31) * 31) + this.mSecond.hashCode();
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        return new Pair<>(a, b);
    }
}
