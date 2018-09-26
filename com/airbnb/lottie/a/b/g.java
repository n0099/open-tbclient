package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> oO;
    private final List<a<Integer, Integer>> oP;
    private final List<Mask> oQ;

    public g(List<Mask> list) {
        this.oQ = list;
        this.oO = new ArrayList(list.size());
        this.oP = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.oO.add(list.get(i2).dX().dp());
                this.oP.add(list.get(i2).dE().dp());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> dd() {
        return this.oQ;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> de() {
        return this.oO;
    }

    public List<a<Integer, Integer>> df() {
        return this.oP;
    }
}
