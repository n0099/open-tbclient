package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    private final List<String> GG;
    @Nullable
    private f GH;

    public e(String... strArr) {
        this.GG = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.GG = new ArrayList(eVar.GG);
        this.GH = eVar.GH;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e bo(String str) {
        e eVar = new e(this);
        eVar.GG.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.GH = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f iY() {
        return this.GH;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (bp(str)) {
            return true;
        }
        if (i >= this.GG.size()) {
            return false;
        }
        return this.GG.get(i).equals(str) || this.GG.get(i).equals("**") || this.GG.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int i(String str, int i) {
        if (bp(str)) {
            return 0;
        }
        if (this.GG.get(i).equals("**")) {
            return (i != this.GG.size() + (-1) && this.GG.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (i >= this.GG.size()) {
            return false;
        }
        boolean z = i == this.GG.size() + (-1);
        String str2 = this.GG.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.GG.size() + (-2) && iZ())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.GG.get(i + 1).equals(str)) {
            return i == this.GG.size() + (-2) || (i == this.GG.size() + (-3) && iZ());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.GG.size() - 1) {
                return this.GG.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean k(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.GG.size() + (-1) || this.GG.get(i).equals("**");
    }

    private boolean bp(String str) {
        return str.equals("__container");
    }

    private boolean iZ() {
        return this.GG.get(this.GG.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.GG + ",resolved=" + (this.GH != null) + '}';
    }
}
