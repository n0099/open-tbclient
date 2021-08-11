package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class PerformanceTracker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean enabled;
    public final Comparator<Pair<String, Float>> floatComparator;
    public final Set<FrameListener> frameListeners;
    public final Map<String, MeanCalculator> layerRenderTimes;

    /* loaded from: classes4.dex */
    public interface FrameListener {
        void onFrameRendered(float f2);
    }

    public PerformanceTracker() {
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
        this.enabled = false;
        this.frameListeners = new ArraySet();
        this.layerRenderTimes = new HashMap();
        this.floatComparator = new Comparator<Pair<String, Float>>(this) { // from class: com.airbnb.lottie.PerformanceTracker.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PerformanceTracker this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, pair, pair2)) == null) {
                    float floatValue = pair.second.floatValue();
                    float floatValue2 = pair2.second.floatValue();
                    if (floatValue2 > floatValue) {
                        return 1;
                    }
                    return floatValue > floatValue2 ? -1 : 0;
                }
                return invokeLL.intValue;
            }
        };
    }

    public void addFrameListener(FrameListener frameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frameListener) == null) {
            this.frameListeners.add(frameListener);
        }
    }

    public void clearRenderTimes() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.layerRenderTimes.clear();
        }
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.enabled) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(this.layerRenderTimes.size());
            for (Map.Entry<String, MeanCalculator> entry : this.layerRenderTimes.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().getMean())));
            }
            Collections.sort(arrayList, this.floatComparator);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void logRenderTimes() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.enabled) {
            List<Pair<String, Float>> sortedRenderTimes = getSortedRenderTimes();
            for (int i2 = 0; i2 < sortedRenderTimes.size(); i2++) {
                Pair<String, Float> pair = sortedRenderTimes.get(i2);
                String.format("\t\t%30s:%.2f", pair.first, pair.second);
            }
        }
    }

    public void recordRenderTime(String str, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(1048580, this, str, f2) == null) && this.enabled) {
            MeanCalculator meanCalculator = this.layerRenderTimes.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.layerRenderTimes.put(str, meanCalculator);
            }
            meanCalculator.add(f2);
            if (str.equals("__container")) {
                for (FrameListener frameListener : this.frameListeners) {
                    frameListener.onFrameRendered(f2);
                }
            }
        }
    }

    public void removeFrameListener(FrameListener frameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, frameListener) == null) {
            this.frameListeners.remove(frameListener);
        }
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.enabled = z;
        }
    }
}
