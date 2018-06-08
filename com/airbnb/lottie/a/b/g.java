package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> mx;
    private final List<a<Integer, Integer>> my;
    private final List<Mask> mz;

    public g(List<Mask> list) {
        this.mz = list;
        this.mx = new ArrayList(list.size());
        this.my = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.mx.add(list.get(i2).cS().ck());
                this.my.add(list.get(i2).cz().ck());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bY() {
        return this.mz;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> bZ() {
        return this.mx;
    }

    public List<a<Integer, Integer>> ca() {
        return this.my;
    }
}
