package com.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    private final List<String> hA;
    @Nullable
    private f hB;

    public e(String... strArr) {
        this.hA = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.hA = new ArrayList(eVar.hA);
        this.hB = eVar.hB;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e O(String str) {
        e eVar = new e(this);
        eVar.hA.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.hB = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f cj() {
        return this.hB;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (P(str)) {
            return true;
        }
        if (i >= this.hA.size()) {
            return false;
        }
        return this.hA.get(i).equals(str) || this.hA.get(i).equals("**") || this.hA.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int d(String str, int i) {
        if (P(str)) {
            return 0;
        }
        if (this.hA.get(i).equals("**")) {
            return (i != this.hA.size() + (-1) && this.hA.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e(String str, int i) {
        if (i >= this.hA.size()) {
            return false;
        }
        boolean z = i == this.hA.size() + (-1);
        String str2 = this.hA.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.hA.size() + (-2) && ck())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.hA.get(i + 1).equals(str)) {
            return i == this.hA.size() + (-2) || (i == this.hA.size() + (-3) && ck());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.hA.size() - 1) {
                return this.hA.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean f(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.hA.size() + (-1) || this.hA.get(i).equals("**");
    }

    private boolean P(String str) {
        return str.equals("__container");
    }

    private boolean ck() {
        return this.hA.get(this.hA.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.hA + ",resolved=" + (this.hB != null) + '}';
    }
}
