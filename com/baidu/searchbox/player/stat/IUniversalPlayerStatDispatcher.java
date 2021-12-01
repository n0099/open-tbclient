package com.baidu.searchbox.player.stat;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface IUniversalPlayerStatDispatcher extends IPlayerStatisticsDispatcher {

    /* loaded from: classes9.dex */
    public static final class SimpleStatDispatcher implements IUniversalPlayerStatDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SimpleStatDispatcher() {
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

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void end(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void endInitPlayer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void endInitPlayerKernel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void goBackOrForeground(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void onError(int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, obj) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingClick(String str, Point point) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, point) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingDismiss(String str, Point point) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, point) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingScale(boolean z, String str, Point point) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, point}) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher
        public void onFloatingShow(String str, Point point) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, point) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void onInfo(int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, obj) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void resume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void start() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void startInitPlayer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void startInitPlayerKernel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher
        public void stop(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            }
        }
    }

    void onFloatingClick(String str, Point point);

    void onFloatingDismiss(String str, Point point);

    void onFloatingScale(boolean z, String str, Point point);

    void onFloatingShow(String str, Point point);
}
