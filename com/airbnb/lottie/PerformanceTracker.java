package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class PerformanceTracker {
    public boolean enabled = false;
    public final Set frameListeners = new ArraySet();
    public final Map layerRenderTimes = new HashMap();
    public final Comparator floatComparator = new Comparator() { // from class: com.airbnb.lottie.PerformanceTracker.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Pair pair, Pair pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    };

    /* loaded from: classes.dex */
    public interface FrameListener {
        void onFrameRendered(float f);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public void addFrameListener(FrameListener frameListener) {
        this.frameListeners.add(frameListener);
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.frameListeners.remove(frameListener);
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public List getSortedRenderTimes() {
        if (!this.enabled) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.layerRenderTimes.size());
        for (Map.Entry entry : this.layerRenderTimes.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(((MeanCalculator) entry.getValue()).getMean())));
        }
        Collections.sort(arrayList, this.floatComparator);
        return arrayList;
    }

    public void logRenderTimes() {
        if (!this.enabled) {
            return;
        }
        List sortedRenderTimes = getSortedRenderTimes();
        Log.d(L.TAG, "Render times:");
        for (int i = 0; i < sortedRenderTimes.size(); i++) {
            Pair pair = (Pair) sortedRenderTimes.get(i);
            Log.d(L.TAG, String.format("\t\t%30s:%.2f", pair.first, pair.second));
        }
    }

    public void recordRenderTime(String str, float f) {
        if (!this.enabled) {
            return;
        }
        MeanCalculator meanCalculator = (MeanCalculator) this.layerRenderTimes.get(str);
        if (meanCalculator == null) {
            meanCalculator = new MeanCalculator();
            this.layerRenderTimes.put(str, meanCalculator);
        }
        meanCalculator.add(f);
        if (str.equals("__container")) {
            for (FrameListener frameListener : this.frameListeners) {
                frameListener.onFrameRendered(f);
            }
        }
    }
}
