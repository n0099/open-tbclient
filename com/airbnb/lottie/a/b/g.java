package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> na;
    private final List<a<Integer, Integer>> nb;
    private final List<Mask> nc;

    public g(List<Mask> list) {
        this.nc = list;
        this.na = new ArrayList(list.size());
        this.nb = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.na.add(list.get(i2).m6do().cF());
                this.nb.add(list.get(i2).cU().cF());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> cs() {
        return this.nc;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> ct() {
        return this.na;
    }

    public List<a<Integer, Integer>> cu() {
        return this.nb;
    }
}
