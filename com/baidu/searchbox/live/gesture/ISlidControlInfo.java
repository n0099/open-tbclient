package com.baidu.searchbox.live.gesture;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.util.ListExtKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface ISlidControlInfo {

    /* loaded from: classes2.dex */
    public static class SimpleControlInfo implements ISlidControlInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context context;

        public SimpleControlInfo(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getLeftDivision() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListExtKt.isDynamicDisplay(this.context)) {
                    return ListExtKt.getDisplayWidth(this.context) / 2;
                }
                return ListExtKt.getDisplayWidth() / 2;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getLeftMaxOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (ListExtKt.isDynamicDisplay(this.context)) {
                    return ListExtKt.getDisplayWidth(this.context);
                }
                return ListExtKt.getDisplayWidth();
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getRightDivision() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) (ListExtKt.getDisplayWidth() * 0.41f) : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public int getRightMaxOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) ((-ListExtKt.getDisplayWidth()) * 0.82f) : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean hasLeftSlidOut() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean hasRightSlidIn() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.live.gesture.ISlidControlInfo
        public boolean isEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    int getLeftDivision();

    int getLeftMaxOffset();

    int getRightDivision();

    int getRightMaxOffset();

    boolean hasLeftSlidOut();

    boolean hasRightSlidIn();

    boolean isEnable();
}
