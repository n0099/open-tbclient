package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> nb;
    private final List<a<Integer, Integer>> nc;
    private final List<Mask> nd;

    public g(List<Mask> list) {
        this.nd = list;
        this.nb = new ArrayList(list.size());
        this.nc = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.nb.add(list.get(i2).dh().cz());
                this.nc.add(list.get(i2).cO().cz());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> cn() {
        return this.nd;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> co() {
        return this.nb;
    }

    public List<a<Integer, Integer>> cp() {
        return this.nc;
    }
}
