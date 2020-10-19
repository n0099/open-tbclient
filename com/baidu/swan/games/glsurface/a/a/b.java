package com.baidu.swan.games.glsurface.a.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes10.dex */
public class b {
    @V8JavascriptField
    public double clientX;
    @V8JavascriptField
    public double clientY;
    @V8JavascriptField
    public int identifier;

    public String toString() {
        return "{identifier=" + this.identifier + ", clientX=" + this.clientX + ", clientY=" + this.clientY + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.identifier == bVar.identifier && this.clientX == bVar.clientX && this.clientY == bVar.clientY;
        }
        return false;
    }

    public int hashCode() {
        return Double.valueOf(this.identifier + this.clientX + this.clientY).hashCode();
    }
}
