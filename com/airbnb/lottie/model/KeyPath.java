package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    public final List keys;
    public KeyPathElement resolvedElement;

    private boolean endsWithGlobstar() {
        List list = this.keys;
        return ((String) list.get(list.size() - 1)).equals("**");
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.keys);
        sb.append(",resolved=");
        if (this.resolvedElement != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append('}');
        return sb.toString();
    }

    public KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    public boolean fullyResolvesTo(String str, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (i >= this.keys.size()) {
            return false;
        }
        if (i == this.keys.size() - 1) {
            z = true;
        } else {
            z = false;
        }
        String str2 = (String) this.keys.get(i);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z3 = false;
            } else {
                z3 = true;
            }
            if ((!z && (i != this.keys.size() - 2 || !endsWithGlobstar())) || !z3) {
                return false;
            }
            return true;
        }
        if (!z && ((String) this.keys.get(i + 1)).equals(str)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (i != this.keys.size() - 2 && (i != this.keys.size() - 3 || !endsWithGlobstar())) {
                return false;
            }
            return true;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.keys.size() - 1) {
                return false;
            }
            return ((String) this.keys.get(i2)).equals(str);
        }
    }

    public int incrementDepthBy(String str, int i) {
        if (isContainer(str)) {
            return 0;
        }
        if (!((String) this.keys.get(i)).equals("**")) {
            return 1;
        }
        if (i == this.keys.size() - 1 || !((String) this.keys.get(i + 1)).equals(str)) {
            return 0;
        }
        return 2;
    }

    public boolean matches(String str, int i) {
        if (isContainer(str)) {
            return true;
        }
        if (i >= this.keys.size()) {
            return false;
        }
        if (((String) this.keys.get(i)).equals(str) || ((String) this.keys.get(i)).equals("**") || ((String) this.keys.get(i)).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean propagateToChildren(String str, int i) {
        if ("__container".equals(str) || i < this.keys.size() - 1 || ((String) this.keys.get(i)).equals("**")) {
            return true;
        }
        return false;
    }
}
