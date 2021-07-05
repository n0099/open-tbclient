package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMSliceListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GetPaInfoSliceListener implements IMSliceListener<PaInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public int errorCode;
    public String errorMsg;
    public int maxCount;
    public IGetPaInfosListener paListener;
    public List<PaInfo> result;

    public GetPaInfoSliceListener(IGetPaInfosListener iGetPaInfosListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iGetPaInfosListener, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.count = 0;
        this.paListener = iGetPaInfosListener;
        this.maxCount = i2;
        this.result = new ArrayList();
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public List<PaInfo> getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.result : (List) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.count == this.maxCount : invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public void mergeErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            List<PaInfo> list = this.result;
            if (list != null && !list.isEmpty()) {
                this.errorCode = 0;
            } else {
                this.errorCode = i2;
            }
        }
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public void mergeErrorMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (this.errorCode == 0) {
                this.errorMsg = Constants.ERROR_MSG_SUCCESS;
            } else {
                this.errorMsg = str;
            }
        }
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public void mergeSliceData(List<PaInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.result.addAll(list);
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public synchronized void onResult(int i2, String str, List<PaInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, str, list) == null) {
            synchronized (this) {
                if (isComplete()) {
                    return;
                }
                this.count++;
                mergeSliceData(list);
                mergeErrorCode(i2);
                mergeErrorMsg(str);
                if (isComplete() && this.paListener != null) {
                    this.paListener.onResult(this.errorCode, this.errorMsg, new ArrayList<>(this.result));
                }
            }
        }
    }
}
