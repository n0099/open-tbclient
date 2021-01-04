package com.baidu.live.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private final List<String> Fn;
    @Nullable
    private f buz;

    public e(String... strArr) {
        this.Fn = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.Fn = new ArrayList(eVar.Fn);
        this.buz = eVar.buz;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e hZ(String str) {
        e eVar = new e(this);
        eVar.Fn.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.buz = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f PN() {
        return this.buz;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (bl(str)) {
            return true;
        }
        if (i >= this.Fn.size()) {
            return false;
        }
        return this.Fn.get(i).equals(str) || this.Fn.get(i).equals("**") || this.Fn.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int i(String str, int i) {
        if (bl(str)) {
            return 0;
        }
        if (this.Fn.get(i).equals("**")) {
            return (i != this.Fn.size() + (-1) && this.Fn.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (i >= this.Fn.size()) {
            return false;
        }
        boolean z = i == this.Fn.size() + (-1);
        String str2 = this.Fn.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.Fn.size() + (-2) && ja())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.Fn.get(i + 1).equals(str)) {
            return i == this.Fn.size() + (-2) || (i == this.Fn.size() + (-3) && ja());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.Fn.size() - 1) {
                return this.Fn.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean k(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.Fn.size() + (-1) || this.Fn.get(i).equals("**");
    }

    private boolean bl(String str) {
        return str.equals("__container");
    }

    private boolean ja() {
        return this.Fn.get(this.Fn.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.Fn + ",resolved=" + (this.buz != null) + '}';
    }
}
