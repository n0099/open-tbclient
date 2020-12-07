package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> EJ;
    private final List<a<Integer, Integer>> EK;
    private final List<Mask> EL;

    public g(List<Mask> list) {
        this.EL = list;
        this.EJ = new ArrayList(list.size());
        this.EK = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.EJ.add(list.get(i2).kb().jD());
                this.EK.add(list.get(i2).jJ().jD());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> jn() {
        return this.EL;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> jo() {
        return this.EJ;
    }

    public List<a<Integer, Integer>> jp() {
        return this.EK;
    }
}
