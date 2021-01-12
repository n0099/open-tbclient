package com.baidu.live.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private final List<String> Fl;
    @Nullable
    private f bpL;

    public e(String... strArr) {
        this.Fl = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.Fl = new ArrayList(eVar.Fl);
        this.bpL = eVar.bpL;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e gO(String str) {
        e eVar = new e(this);
        eVar.Fl.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.bpL = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f LS() {
        return this.bpL;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (bl(str)) {
            return true;
        }
        if (i >= this.Fl.size()) {
            return false;
        }
        return this.Fl.get(i).equals(str) || this.Fl.get(i).equals("**") || this.Fl.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int i(String str, int i) {
        if (bl(str)) {
            return 0;
        }
        if (this.Fl.get(i).equals("**")) {
            return (i != this.Fl.size() + (-1) && this.Fl.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (i >= this.Fl.size()) {
            return false;
        }
        boolean z = i == this.Fl.size() + (-1);
        String str2 = this.Fl.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.Fl.size() + (-2) && ja())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.Fl.get(i + 1).equals(str)) {
            return i == this.Fl.size() + (-2) || (i == this.Fl.size() + (-3) && ja());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.Fl.size() - 1) {
                return this.Fl.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean k(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.Fl.size() + (-1) || this.Fl.get(i).equals("**");
    }

    private boolean bl(String str) {
        return str.equals("__container");
    }

    private boolean ja() {
        return this.Fl.get(this.Fl.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.Fl + ",resolved=" + (this.bpL != null) + '}';
    }
}
