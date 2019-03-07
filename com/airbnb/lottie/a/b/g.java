package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> pC;
    private final List<a<Integer, Integer>> pD;
    private final List<Mask> pE;

    public g(List<Mask> list) {
        this.pE = list;
        this.pC = new ArrayList(list.size());
        this.pD = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.pC.add(list.get(i2).en().dF());
                this.pD.add(list.get(i2).dU().dF());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> dt() {
        return this.pE;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> du() {
        return this.pC;
    }

    public List<a<Integer, Integer>> dv() {
        return this.pD;
    }
}
