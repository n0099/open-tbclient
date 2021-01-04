package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import com.baidu.live.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class g {
    private final List<Mask> EA;
    private final List<a<com.baidu.live.lottie.model.content.h, Path>> Ey;
    private final List<a<Integer, Integer>> Ez;

    public g(List<Mask> list) {
        this.EA = list;
        this.Ey = new ArrayList(list.size());
        this.Ez = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                this.Ey.add(list.get(i2).Qj().PP());
                this.Ez.add(list.get(i2).PV().PP());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public List<Mask> iM() {
        return this.EA;
    }

    public List<a<com.baidu.live.lottie.model.content.h, Path>> iN() {
        return this.Ey;
    }

    public List<a<Integer, Integer>> iO() {
        return this.Ez;
    }
}
