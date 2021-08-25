package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    public final List<String> keys;
    @Nullable
    public KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private boolean endsWithGlobstar() {
        List<String> list = this.keys;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fullyResolvesTo(String str, int i2) {
        if (i2 >= this.keys.size()) {
            return false;
        }
        boolean z = i2 == this.keys.size() - 1;
        String str2 = this.keys.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.keys.size() + (-2) && endsWithGlobstar())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.keys.get(i2 + 1).equals(str)) {
            return i2 == this.keys.size() + (-2) || (i2 == this.keys.size() + (-3) && endsWithGlobstar());
        } else if (z) {
            return true;
        } else {
            int i3 = i2 + 1;
            if (i3 < this.keys.size() - 1) {
                return false;
            }
            return this.keys.get(i3).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int incrementDepthBy(String str, int i2) {
        if (isContainer(str)) {
            return 0;
        }
        if (this.keys.get(i2).equals("**")) {
            return (i2 != this.keys.size() - 1 && this.keys.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean matches(String str, int i2) {
        if (isContainer(str)) {
            return true;
        }
        if (i2 >= this.keys.size()) {
            return false;
        }
        return this.keys.get(i2).equals(str) || this.keys.get(i2).equals("**") || this.keys.get(i2).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean propagateToChildren(String str, int i2) {
        return "__container".equals(str) || i2 < this.keys.size() - 1 || this.keys.get(i2).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.keys);
        sb.append(",resolved=");
        sb.append(this.resolvedElement != null);
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }

    public KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
