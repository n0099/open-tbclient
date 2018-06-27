package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> mw;
    private final List<a<Integer, Integer>> mx;
    private final List<Mask> my;

    public g(List<Mask> list) {
        this.my = list;
        this.mw = new ArrayList(list.size());
        this.mx = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.mw.add(list.get(i2).cS().ck());
                this.mx.add(list.get(i2).cz().ck());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bY() {
        return this.my;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> bZ() {
        return this.mw;
    }

    public List<a<Integer, Integer>> ca() {
        return this.mx;
    }
}
