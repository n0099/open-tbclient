package com.baidu.fsg.face.liveness.datamodel;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class UploadContrastPortraitModel implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String authsid;
    public String callbackkey;
    public int contrastres;
    public int dxm_recordvideo;
    public int finalres;
    public int finish;
    public String imgdigests;
    public String need_confirm;
    public int recordvideo;

    /* loaded from: classes8.dex */
    public static class ConfirmBean implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cancel_msg;
        public String confirm_msg;
        public String tip_msg;
        public int tips_sec;
        public String title_tips;

        public ConfirmBean() {
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
    }

    public UploadContrastPortraitModel() {
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

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public ConfirmBean getConfirmBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return (ConfirmBean) JsonUtils.fromJson(this.need_confirm, ConfirmBean.class);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ConfirmBean) invokeV.objValue;
    }

    public boolean isContrastPass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? 1 == this.contrastres : invokeV.booleanValue;
    }

    public boolean isFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.finish == 1 : invokeV.booleanValue;
    }

    public boolean isGotoDXMRecordvideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? 1 == this.dxm_recordvideo : invokeV.booleanValue;
    }

    public boolean isGotoRecordvideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? 1 == this.recordvideo : invokeV.booleanValue;
    }

    public boolean isProcessPass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? 1 == this.finalres : invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
        }
    }
}
