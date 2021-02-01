package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> Ew;
    private final List<a<Integer, Integer>> Ex;
    private final List<Mask> Ey;

    public g(List<Mask> list) {
        this.Ey = list;
        this.Ew = new ArrayList(list.size());
        this.Ex = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.Ew.add(list.get(i2).jz().jb());
                this.Ex.add(list.get(i2).jh().jb());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> iL() {
        return this.Ey;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> iM() {
        return this.Ew;
    }

    public List<a<Integer, Integer>> iN() {
        return this.Ex;
    }
}
