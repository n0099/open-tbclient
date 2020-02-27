package com.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private final List<String> hE;
    @Nullable
    private f hF;

    public e(String... strArr) {
        this.hE = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.hE = new ArrayList(eVar.hE);
        this.hF = eVar.hF;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e O(String str) {
        e eVar = new e(this);
        eVar.hE.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.hF = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f ck() {
        return this.hF;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (P(str)) {
            return true;
        }
        if (i >= this.hE.size()) {
            return false;
        }
        return this.hE.get(i).equals(str) || this.hE.get(i).equals("**") || this.hE.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int d(String str, int i) {
        if (P(str)) {
            return 0;
        }
        if (this.hE.get(i).equals("**")) {
            return (i != this.hE.size() + (-1) && this.hE.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e(String str, int i) {
        if (i >= this.hE.size()) {
            return false;
        }
        boolean z = i == this.hE.size() + (-1);
        String str2 = this.hE.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.hE.size() + (-2) && cl())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.hE.get(i + 1).equals(str)) {
            return i == this.hE.size() + (-2) || (i == this.hE.size() + (-3) && cl());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.hE.size() - 1) {
                return this.hE.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean f(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.hE.size() + (-1) || this.hE.get(i).equals("**");
    }

    private boolean P(String str) {
        return str.equals("__container");
    }

    private boolean cl() {
        return this.hE.get(this.hE.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.hE + ",resolved=" + (this.hF != null) + '}';
    }
}
