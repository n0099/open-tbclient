package com.airbnb.lottie;

import android.support.v4.util.ArraySet;
import android.support.v4.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class i {
    private boolean enabled = false;
    private final Set<a> lD = new ArraySet();
    private Map<String, com.airbnb.lottie.c.d> lE = new HashMap();
    private final Comparator<Pair<String, Float>> lF = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
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

    /* loaded from: classes2.dex */
    public interface a {
        void f(float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void b(String str, float f) {
        if (this.enabled) {
            com.airbnb.lottie.c.d dVar = this.lE.get(str);
            if (dVar == null) {
                dVar = new com.airbnb.lottie.c.d();
                this.lE.put(str, dVar);
            }
            dVar.o(f);
            if (str.equals("root")) {
                for (a aVar : this.lD) {
                    aVar.f(f);
                }
            }
        }
    }
}
