package com.baidu.live.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class p {
    private boolean enabled = false;
    private final Set<a> Dm = new ArraySet();
    private final Map<String, com.baidu.live.lottie.d.d> Dn = new HashMap();
    private final Comparator<Pair<String, Float>> Do = new Comparator<Pair<String, Float>>() { // from class: com.baidu.live.lottie.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void g(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void c(String str, float f) {
        if (this.enabled) {
            com.baidu.live.lottie.d.d dVar = this.Dn.get(str);
            if (dVar == null) {
                dVar = new com.baidu.live.lottie.d.d();
                this.Dn.put(str, dVar);
            }
            dVar.add(f);
            if (str.equals("__container")) {
                for (a aVar : this.Dm) {
                    aVar.g(f);
                }
            }
        }
    }
}
