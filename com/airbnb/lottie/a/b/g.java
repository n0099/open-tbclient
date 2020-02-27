package com.airbnb.lottie.a.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> gL;
    private final List<a<Integer, Integer>> gM;
    private final List<Mask> gN;

    public g(List<Mask> list) {
        this.gN = list;
        this.gL = new ArrayList(list.size());
        this.gM = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.gL.add(list.get(i2).cL().cn());
                this.gM.add(list.get(i2).ct().cn());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> bX() {
        return this.gN;
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> bY() {
        return this.gL;
    }

    public List<a<Integer, Integer>> bZ() {
        return this.gM;
    }
}
