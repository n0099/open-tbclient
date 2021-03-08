package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class m {
    private boolean enabled = false;
    private final Set<a> EG = new ArraySet();
    private final Map<String, com.airbnb.lottie.d.d> EH = new HashMap();
    private final Comparator<Pair<String, Float>> EI = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.m.1
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

    /* loaded from: classes5.dex */
    public interface a {
        void k(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void c(String str, float f) {
        if (this.enabled) {
            com.airbnb.lottie.d.d dVar = this.EH.get(str);
            if (dVar == null) {
                dVar = new com.airbnb.lottie.d.d();
                this.EH.put(str, dVar);
            }
            dVar.add(f);
            if (str.equals("__container")) {
                for (a aVar : this.EG) {
                    aVar.k(f);
                }
            }
        }
    }
}
