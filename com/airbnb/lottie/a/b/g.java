package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> pH;
    private final List<a<Integer, Integer>> pI;
    private final List<Mask> pJ;

    public g(List<Mask> list) {
        this.pJ = list;
        this.pH = new ArrayList(list.size());
        this.pI = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.pH.add(list.get(i2).eo().dG());
                this.pI.add(list.get(i2).dV().dG());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> du() {
        return this.pJ;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> dv() {
        return this.pH;
    }

    public List<a<Integer, Integer>> dw() {
        return this.pI;
    }
}
