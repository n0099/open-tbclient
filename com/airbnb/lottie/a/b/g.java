package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> gH;
    private final List<a<Integer, Integer>> gI;
    private final List<Mask> gJ;

    public g(List<Mask> list) {
        this.gJ = list;
        this.gH = new ArrayList(list.size());
        this.gI = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.gH.add(list.get(i2).cK().cm());
                this.gI.add(list.get(i2).cs().cm());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bW() {
        return this.gJ;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> bX() {
        return this.gH;
    }

    public List<a<Integer, Integer>> bY() {
        return this.gI;
    }
}
