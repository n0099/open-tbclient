package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect bounds;
    public SparseArrayCompat<FontCharacter> characters;
    public float endFrame;
    public Map<String, Font> fonts;
    public float frameRate;
    public boolean hasDashPattern;
    public Map<String, LottieImageAsset> images;
    public LongSparseArray<Layer> layerMap;
    public List<Layer> layers;
    public List<Marker> markers;
    public int maskAndMatteCount;
    public final PerformanceTracker performanceTracker;
    public Map<String, List<Layer>> precomps;
    public float startFrame;
    public final HashSet<String> warnings;

    /* renamed from: com.airbnb.lottie.LottieComposition$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean cancelled;
            public final OnCompositionLoadedListener listener;

            public /* synthetic */ ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener, AnonymousClass1 anonymousClass1) {
                this(onCompositionLoadedListener);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.cancelled = true;
                }
            }

            public ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {onCompositionLoadedListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.cancelled = false;
                this.listener = onCompositionLoadedListener;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieComposition) == null) || this.cancelled) {
                    return;
                }
                this.listener.onCompositionLoaded(lottieComposition);
            }
        }

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, onCompositionLoadedListener)) == null) {
                ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener, null);
                LottieCompositionFactory.fromAsset(context, str).addListener(listenerAdapter);
                return listenerAdapter;
            }
            return (Cancellable) invokeLLL.objValue;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromFileSync(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? LottieCompositionFactory.fromAssetSync(context, str).getValue() : (LottieComposition) invokeLL.objValue;
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, inputStream, onCompositionLoadedListener)) == null) {
                ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener, null);
                LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener(listenerAdapter);
                return listenerAdapter;
            }
            return (Cancellable) invokeLL.objValue;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, inputStream)) == null) ? LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue() : (LottieComposition) invokeL.objValue;
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jsonReader, onCompositionLoadedListener)) == null) {
                ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener, null);
                LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener(listenerAdapter);
                return listenerAdapter;
            }
            return (Cancellable) invokeLL.objValue;
        }

        @Deprecated
        public static Cancellable fromJsonString(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, onCompositionLoadedListener)) == null) {
                ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener, null);
                LottieCompositionFactory.fromJsonString(str, null).addListener(listenerAdapter);
                return listenerAdapter;
            }
            return (Cancellable) invokeLL.objValue;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, resources, jSONObject)) == null) ? LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue() : (LottieComposition) invokeLL.objValue;
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context, @RawRes int i2, OnCompositionLoadedListener onCompositionLoadedListener) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, null, context, i2, onCompositionLoadedListener)) == null) {
                ListenerAdapter listenerAdapter = new ListenerAdapter(onCompositionLoadedListener, null);
                LottieCompositionFactory.fromRawRes(context, i2).addListener(listenerAdapter);
                return listenerAdapter;
            }
            return (Cancellable) invokeLIL.objValue;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, inputStream, z)) == null) {
                if (z) {
                    Logger.warning("Lottie now auto-closes input stream!");
                }
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
            }
            return (LottieComposition) invokeLZ.objValue;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromJsonSync(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? LottieCompositionFactory.fromJsonStringSync(str, null).getValue() : (LottieComposition) invokeL.objValue;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jsonReader)) == null) ? LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue() : (LottieComposition) invokeL.objValue;
        }
    }

    public LottieComposition() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.performanceTracker = new PerformanceTracker();
        this.warnings = new HashSet<>();
        this.maskAndMatteCount = 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void addWarning(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Logger.warning(str);
            this.warnings.add(str);
        }
    }

    public Rect getBounds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bounds : (Rect) invokeV.objValue;
    }

    public SparseArrayCompat<FontCharacter> getCharacters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.characters : (SparseArrayCompat) invokeV.objValue;
    }

    public float getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (getDurationFrames() / this.frameRate) * 1000.0f : invokeV.floatValue;
    }

    public float getDurationFrames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.endFrame - this.startFrame : invokeV.floatValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getEndFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.endFrame : invokeV.floatValue;
    }

    public Map<String, Font> getFonts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.fonts : (Map) invokeV.objValue;
    }

    public float getFrameRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.frameRate : invokeV.floatValue;
    }

    public Map<String, LottieImageAsset> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.images : (Map) invokeV.objValue;
    }

    public List<Layer> getLayers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.layers : (List) invokeV.objValue;
    }

    @Nullable
    public Marker getMarker(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.markers.size();
            for (int i2 = 0; i2 < this.markers.size(); i2++) {
                Marker marker = this.markers.get(i2);
                if (marker.matchesName(str)) {
                    return marker;
                }
            }
            return null;
        }
        return (Marker) invokeL.objValue;
    }

    public List<Marker> getMarkers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.markers : (List) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMaskAndMatteCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.maskAndMatteCount : invokeV.intValue;
    }

    public PerformanceTracker getPerformanceTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.performanceTracker : (PerformanceTracker) invokeV.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> getPrecomps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.precomps.get(str) : (List) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getStartFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.startFrame : invokeV.floatValue;
    }

    public ArrayList<String> getWarnings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            HashSet<String> hashSet = this.warnings;
            return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
        }
        return (ArrayList) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDashPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.hasDashPattern : invokeV.booleanValue;
    }

    public boolean hasImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? !this.images.isEmpty() : invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void incrementMatteOrMaskCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.maskAndMatteCount += i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void init(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{rect, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), list, longSparseArray, map, map2, sparseArrayCompat, map3, list2}) == null) {
            this.bounds = rect;
            this.startFrame = f2;
            this.endFrame = f3;
            this.frameRate = f4;
            this.layers = list;
            this.layerMap = longSparseArray;
            this.precomps = map;
            this.images = map2;
            this.characters = sparseArrayCompat;
            this.fonts = map3;
            this.markers = list2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer layerModelForId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048597, this, j)) == null) ? this.layerMap.get(j) : (Layer) invokeJ.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasDashPattern(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.hasDashPattern = z;
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.performanceTracker.setEnabled(z);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            StringBuilder sb = new StringBuilder("LottieComposition:\n");
            for (Layer layer : this.layers) {
                sb.append(layer.toString(TrackUI.SEPERATOR));
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
