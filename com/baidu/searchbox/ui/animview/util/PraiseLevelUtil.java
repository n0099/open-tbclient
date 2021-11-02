package com.baidu.searchbox.ui.animview.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public class PraiseLevelUtil {
    public static /* synthetic */ Interceptable $ic;
    public static Set<IResourceProvider.PraiseLevelConfig> sLevelConfigSet;
    public transient /* synthetic */ FieldHolder $fh;

    public PraiseLevelUtil() {
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

    public static void genDefaultLevelConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            Set<IResourceProvider.PraiseLevelConfig> set = sLevelConfigSet;
            if (set == null) {
                sLevelConfigSet = new TreeSet(new IResourceProvider.PraiseLevelConfig.DefaultComparator());
            } else {
                set.clear();
            }
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(9L, 1, 1));
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(99L, 2, 2));
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(499L, 3, 3));
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(999L, 3, 4));
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(1499L, 4, 5));
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(2147483647L, Integer.MAX_VALUE, Integer.MAX_VALUE));
            validateLevel0Config();
        }
    }

    public static IResourceProvider.PraiseLevelConfig matchPraiseLevel(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            Set<IResourceProvider.PraiseLevelConfig> set = sLevelConfigSet;
            if (set == null || set.isEmpty()) {
                genDefaultLevelConfig();
            }
            for (IResourceProvider.PraiseLevelConfig praiseLevelConfig : sLevelConfigSet) {
                if (j <= praiseLevelConfig.mBound) {
                    return praiseLevelConfig;
                }
            }
            return new IResourceProvider.PraiseLevelConfig(2147483647L, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        return (IResourceProvider.PraiseLevelConfig) invokeJ.objValue;
    }

    public static void updateLevelConfig(Set<IResourceProvider.PraiseLevelConfig> set) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, set) == null) {
            if (set != null && !set.isEmpty()) {
                Set<IResourceProvider.PraiseLevelConfig> set2 = sLevelConfigSet;
                if (set2 == null) {
                    sLevelConfigSet = new TreeSet(new IResourceProvider.PraiseLevelConfig.DefaultComparator());
                } else {
                    set2.clear();
                }
                for (IResourceProvider.PraiseLevelConfig praiseLevelConfig : set) {
                    long j = praiseLevelConfig.mBound;
                    if (j > 0 && (i2 = praiseLevelConfig.mTextCount) >= 1 && (i3 = praiseLevelConfig.mLevelImgIndex) >= 0) {
                        if (i2 > 4) {
                            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(j, 4, i3));
                        } else {
                            sLevelConfigSet.add(praiseLevelConfig);
                        }
                    }
                }
                if (sLevelConfigSet.isEmpty()) {
                    genDefaultLevelConfig();
                    return;
                }
                sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(2147483647L, Integer.MAX_VALUE, Integer.MAX_VALUE));
                validateLevel0Config();
                return;
            }
            genDefaultLevelConfig();
        }
    }

    public static void validateLevel0Config() {
        Set<IResourceProvider.PraiseLevelConfig> set;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (set = sLevelConfigSet) == null || set.isEmpty()) {
            return;
        }
        Iterator<IResourceProvider.PraiseLevelConfig> it = sLevelConfigSet.iterator();
        while (it.hasNext()) {
            IResourceProvider.PraiseLevelConfig next = it.next();
            if (next.mBound == 1 && next.mTextCount == 1) {
                it.remove();
            }
        }
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(1L, 1, 0));
    }
}
