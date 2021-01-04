package com.baidu.swan.games.glsurface.a.a;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class a {
    @V8JavascriptField
    public b[] changedTouches;
    @V8JavascriptField
    public long timeStamp;
    @V8JavascriptField
    public b[] touches;

    public String toString() {
        return "SwanGameTouchData{touches=" + Arrays.toString(this.touches) + ", changedTouches=" + Arrays.toString(this.changedTouches) + ", timeStamp=" + this.timeStamp + '}';
    }
}
