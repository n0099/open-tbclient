package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LottieComposition {
    public Rect bounds;
    public SparseArrayCompat characters;
    public float endFrame;
    public Map fonts;
    public float frameRate;
    public boolean hasDashPattern;
    public Map images;
    public LongSparseArray layerMap;
    public List layers;
    public List markers;
    public Map precomps;
    public float startFrame;
    public final PerformanceTracker performanceTracker = new PerformanceTracker();
    public final HashSet warnings = new HashSet();
    public int maskAndMatteCount = 0;

    @Deprecated
    /* loaded from: classes.dex */
    public class Factory {

        /* loaded from: classes.dex */
        public final class ListenerAdapter implements LottieListener, Cancellable {
            public boolean cancelled;
            public final OnCompositionLoadedListener listener;

            public ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.cancelled = false;
                this.listener = onCompositionLoadedListener;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                if (this.cancelled) {
                    return;
                }
                this.listener.onCompositionLoaded(lottieComposition);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.cancelled = true;
            }
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromAsset(context, str).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context, int i, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromRawRes(context, i).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromFileSync(Context context, String str) {
            return (LottieComposition) LottieCompositionFactory.fromAssetSync(context, str).getValue();
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean z) {
            if (z) {
                Logger.warning("Lottie now auto-closes input stream!");
            }
            return (LottieComposition) LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static Cancellable fromJsonString(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonString(str, null).addListener(listenerAdapter);
            return listenerAdapter;
        }

        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
            return (LottieComposition) LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream) {
            return (LottieComposition) LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader) throws IOException {
            return (LottieComposition) LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue();
        }

        @Deprecated
        public static LottieComposition fromJsonSync(String str) {
            return (LottieComposition) LottieCompositionFactory.fromJsonStringSync(str, null).getValue();
        }
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public SparseArrayCompat getCharacters() {
        return this.characters;
    }

    public float getDuration() {
        return (getDurationFrames() / this.frameRate) * 1000.0f;
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public Map getFonts() {
        return this.fonts;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map getImages() {
        return this.images;
    }

    public List getLayers() {
        return this.layers;
    }

    public List getMarkers() {
        return this.markers;
    }

    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public ArrayList getWarnings() {
        HashSet hashSet = this.warnings;
        return new ArrayList(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.layers) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }

    public void addWarning(String str) {
        Logger.warning(str);
        this.warnings.add(str);
    }

    public Marker getMarker(String str) {
        this.markers.size();
        for (int i = 0; i < this.markers.size(); i++) {
            Marker marker = (Marker) this.markers.get(i);
            if (marker.matchesName(str)) {
                return marker;
            }
        }
        return null;
    }

    public List getPrecomps(String str) {
        return (List) this.precomps.get(str);
    }

    public void incrementMatteOrMaskCount(int i) {
        this.maskAndMatteCount += i;
    }

    public Layer layerModelForId(long j) {
        return (Layer) this.layerMap.get(j);
    }

    public void setHasDashPattern(boolean z) {
        this.hasDashPattern = z;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTracker.setEnabled(z);
    }

    public void init(Rect rect, float f, float f2, float f3, List list, LongSparseArray longSparseArray, Map map, Map map2, SparseArrayCompat sparseArrayCompat, Map map3, List list2) {
        this.bounds = rect;
        this.startFrame = f;
        this.endFrame = f2;
        this.frameRate = f3;
        this.layers = list;
        this.layerMap = longSparseArray;
        this.precomps = map;
        this.images = map2;
        this.characters = sparseArrayCompat;
        this.fonts = map3;
        this.markers = list2;
    }
}
