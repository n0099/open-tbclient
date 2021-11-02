package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface IPraiseElementBuilder<RESULT> {

    /* loaded from: classes7.dex */
    public static class FetchConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<Drawable.Callback> callback;
        public int canvasHeight;
        public int canvasWidth;
        public int height;
        public int left;
        public String pkgTag;
        public int strategy;
        public String strategyTag;
        public int top;
        public int width;

        public FetchConfig() {
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

        public int getCanvasHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.canvasHeight : invokeV.intValue;
        }

        public int getCanvasWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.canvasWidth : invokeV.intValue;
        }

        public Drawable.Callback getDrawableCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                WeakReference<Drawable.Callback> weakReference = this.callback;
                if (weakReference == null) {
                    return null;
                }
                return weakReference.get();
            }
            return (Drawable.Callback) invokeV.objValue;
        }

        public int getHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.height : invokeV.intValue;
        }

        public int getLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.left : invokeV.intValue;
        }

        public String getPkgTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pkgTag : (String) invokeV.objValue;
        }

        public int getStrategy() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.strategy : invokeV.intValue;
        }

        public String getStrategyTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.strategyTag : (String) invokeV.objValue;
        }

        public int getTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.top : invokeV.intValue;
        }

        public int getWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.width : invokeV.intValue;
        }

        public FetchConfig setCanvasHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                this.canvasHeight = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }

        public FetchConfig setCanvasWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                this.canvasWidth = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }

        public FetchConfig setDrawableCallback(Drawable.Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, callback)) == null) {
                this.callback = new WeakReference<>(callback);
                return this;
            }
            return (FetchConfig) invokeL.objValue;
        }

        public FetchConfig setHeight(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                this.height = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }

        public FetchConfig setLeft(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                this.left = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }

        public FetchConfig setPkgTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                this.pkgTag = str;
                return this;
            }
            return (FetchConfig) invokeL.objValue;
        }

        public FetchConfig setStrategy(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                this.strategy = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }

        public FetchConfig setStrategyTag(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.strategyTag = str;
                return this;
            }
            return (FetchConfig) invokeL.objValue;
        }

        public FetchConfig setTop(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
                this.top = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }

        public FetchConfig setWidth(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                this.width = i2;
                return this;
            }
            return (FetchConfig) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class PreBuildConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<Integer, Integer> elementCntsMap;
        public WeakReference<IResourceProvider> resourceProvider;

        public PreBuildConfig() {
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

        public Map<Integer, Integer> getElementCntsMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.elementCntsMap : (Map) invokeV.objValue;
        }

        public IResourceProvider getResourceProvider() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                WeakReference<IResourceProvider> weakReference = this.resourceProvider;
                if (weakReference == null) {
                    return null;
                }
                return weakReference.get();
            }
            return (IResourceProvider) invokeV.objValue;
        }

        public void setElementCntsMap(Map<Integer, Integer> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
                this.elementCntsMap = map;
            }
        }

        public PreBuildConfig setResourceProvider(IResourceProvider iResourceProvider) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iResourceProvider)) == null) {
                this.resourceProvider = new WeakReference<>(iResourceProvider);
                return this;
            }
            return (PreBuildConfig) invokeL.objValue;
        }
    }

    PreBuildConfig getPreBuildConfig();

    RESULT getResult(FetchConfig fetchConfig);

    void preBuild(PreBuildConfig preBuildConfig);
}
