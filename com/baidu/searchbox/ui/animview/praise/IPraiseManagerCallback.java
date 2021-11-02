package com.baidu.searchbox.ui.animview.praise;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface IPraiseManagerCallback {

    /* loaded from: classes7.dex */
    public static class DefaultStub implements IPraiseManagerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultStub() {
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

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorLeft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorTop() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public int getAnchorWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public String getPraiseId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.ui.animview.praise.IPraiseManagerCallback
        public String getPraiseSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "" : (String) invokeV.objValue;
        }
    }

    int getAnchorHeight();

    int getAnchorLeft();

    int getAnchorTop();

    int getAnchorWidth();

    String getPraiseId();

    String getPraiseSource();
}
