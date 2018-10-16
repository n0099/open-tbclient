package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> pG;
    private final List<a<Integer, Integer>> pH;
    private final List<Mask> pI;

    public g(List<Mask> list) {
        this.pI = list;
        this.pG = new ArrayList(list.size());
        this.pH = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.pG.add(list.get(i2).ep().dH());
                this.pH.add(list.get(i2).dW().dH());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> dv() {
        return this.pI;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> dw() {
        return this.pG;
    }

    public List<a<Integer, Integer>> dx() {
        return this.pH;
    }
}
