package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> ml;
    private final List<a<Integer, Integer>> mm;
    private final List<Mask> mn;

    public g(List<Mask> list) {
        this.mn = list;
        this.ml = new ArrayList(list.size());
        this.mm = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.ml.add(list.get(i2).cQ().ci());
                this.mm.add(list.get(i2).cx().ci());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bW() {
        return this.mn;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> bX() {
        return this.ml;
    }

    public List<a<Integer, Integer>> bY() {
        return this.mm;
    }
}
