package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import com.baidu.live.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    private final List<a<com.baidu.live.lottie.model.content.h, Path>> FP;
    private final List<a<Integer, Integer>> FQ;
    private final List<Mask> FR;

    public g(List<Mask> list) {
        this.FR = list;
        this.FP = new ArrayList(list.size());
        this.FQ = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.FP.add(list.get(i2).NP().Nv());
                this.FQ.add(list.get(i2).NB().Nv());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> iL() {
        return this.FR;
    }

    public List<a<com.baidu.live.lottie.model.content.h, Path>> iM() {
        return this.FP;
    }

    public List<a<Integer, Integer>> iN() {
        return this.FQ;
    }
}
