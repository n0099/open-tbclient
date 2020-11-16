package com.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes16.dex */
public class e {
    private final List<String> EJ;
    @Nullable
    private f EK;

    public e(String... strArr) {
        this.EJ = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.EJ = new ArrayList(eVar.EJ);
        this.EK = eVar.EK;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e bk(String str) {
        e eVar = new e(this);
        eVar.EJ.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.EK = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f jA() {
        return this.EK;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (bl(str)) {
            return true;
        }
        if (i >= this.EJ.size()) {
            return false;
        }
        return this.EJ.get(i).equals(str) || this.EJ.get(i).equals("**") || this.EJ.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int i(String str, int i) {
        if (bl(str)) {
            return 0;
        }
        if (this.EJ.get(i).equals("**")) {
            return (i != this.EJ.size() + (-1) && this.EJ.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (i >= this.EJ.size()) {
            return false;
        }
        boolean z = i == this.EJ.size() + (-1);
        String str2 = this.EJ.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.EJ.size() + (-2) && jB())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.EJ.get(i + 1).equals(str)) {
            return i == this.EJ.size() + (-2) || (i == this.EJ.size() + (-3) && jB());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.EJ.size() - 1) {
                return this.EJ.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean k(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.EJ.size() + (-1) || this.EJ.get(i).equals("**");
    }

    private boolean bl(String str) {
        return str.equals("__container");
    }

    private boolean jB() {
        return this.EJ.get(this.EJ.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.EJ + ",resolved=" + (this.EK != null) + '}';
    }
}
