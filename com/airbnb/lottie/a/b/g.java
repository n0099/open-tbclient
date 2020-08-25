package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class g {
    private final List<Mask> DA;
    private final List<a<com.airbnb.lottie.model.content.h, Path>> Dy;
    private final List<a<Integer, Integer>> Dz;

    public g(List<Mask> list) {
        this.DA = list;
        this.Dy = new ArrayList(list.size());
        this.Dz = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.Dy.add(list.get(i2).jZ().jB());
                this.Dz.add(list.get(i2).jH().jB());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> jl() {
        return this.DA;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> jm() {
        return this.Dy;
    }

    public List<a<Integer, Integer>> jn() {
        return this.Dz;
    }
}
