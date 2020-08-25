package com.airbnb.lottie.model;

import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes18.dex */
public class e {
    private final List<String> Er;
    @Nullable
    private f Es;

    public e(String... strArr) {
        this.Er = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.Er = new ArrayList(eVar.Er);
        this.Es = eVar.Es;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e bk(String str) {
        e eVar = new e(this);
        eVar.Er.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.Es = fVar;
        return eVar;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f jy() {
        return this.Es;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (bl(str)) {
            return true;
        }
        if (i >= this.Er.size()) {
            return false;
        }
        return this.Er.get(i).equals(str) || this.Er.get(i).equals("**") || this.Er.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int i(String str, int i) {
        if (bl(str)) {
            return 0;
        }
        if (this.Er.get(i).equals("**")) {
            return (i != this.Er.size() + (-1) && this.Er.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j(String str, int i) {
        if (i >= this.Er.size()) {
            return false;
        }
        boolean z = i == this.Er.size() + (-1);
        String str2 = this.Er.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.Er.size() + (-2) && jz())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.Er.get(i + 1).equals(str)) {
            return i == this.Er.size() + (-2) || (i == this.Er.size() + (-3) && jz());
        } else if (z) {
            return true;
        } else {
            if (i + 1 >= this.Er.size() - 1) {
                return this.Er.get(i + 1).equals(str);
            }
            return false;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean k(String str, int i) {
        if (str.equals("__container")) {
            return true;
        }
        return i < this.Er.size() + (-1) || this.Er.get(i).equals("**");
    }

    private boolean bl(String str) {
        return str.equals("__container");
    }

    private boolean jz() {
        return this.Er.get(this.Er.size() - 1).equals("**");
    }

    public String toString() {
        return "KeyPath{keys=" + this.Er + ",resolved=" + (this.Es != null) + '}';
    }
}
