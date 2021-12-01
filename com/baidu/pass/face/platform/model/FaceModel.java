package com.baidu.pass.face.platform.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class FaceModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceImageInstance BitmapInstance;
    public BDFaceImageInstance cropInstance;
    public FaceExtInfo[] faceInfos;
    public FaceStatusNewEnum faceNewStatus;
    public FaceInfo[] faceSDKInfos;
    public long frameTime;
    public BDFaceImageInstance imageInstance;

    public FaceModel() {
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

    public BDFaceImageInstance getBitmapInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.BitmapInstance : (BDFaceImageInstance) invokeV.objValue;
    }

    public BDFaceImageInstance getCropInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cropInstance : (BDFaceImageInstance) invokeV.objValue;
    }

    public FaceExtInfo[] getFaceInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.faceInfos : (FaceExtInfo[]) invokeV.objValue;
    }

    public FaceStatusNewEnum getFaceModuleStateNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.faceNewStatus : (FaceStatusNewEnum) invokeV.objValue;
    }

    public FaceInfo[] getFaceSDKInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.faceSDKInfos : (FaceInfo[]) invokeV.objValue;
    }

    public long getFrameTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.frameTime : invokeV.longValue;
    }

    public BDFaceImageInstance getImageInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.imageInstance : (BDFaceImageInstance) invokeV.objValue;
    }

    public void setBitmapInstance(BDFaceImageInstance bDFaceImageInstance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bDFaceImageInstance) == null) {
            this.BitmapInstance = bDFaceImageInstance;
        }
    }

    public void setCropInstance(BDFaceImageInstance bDFaceImageInstance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDFaceImageInstance) == null) {
            this.cropInstance = bDFaceImageInstance;
        }
    }

    public void setFaceInfos(FaceExtInfo[] faceExtInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, faceExtInfoArr) == null) {
            this.faceInfos = faceExtInfoArr;
        }
    }

    public void setFaceModuleStateNew(FaceStatusNewEnum faceStatusNewEnum) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, faceStatusNewEnum) == null) {
            this.faceNewStatus = faceStatusNewEnum;
        }
    }

    public void setFaceSDKInfos(FaceInfo[] faceInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, faceInfoArr) == null) {
            this.faceSDKInfos = faceInfoArr;
        }
    }

    public void setFrameTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.frameTime = j2;
        }
    }

    public void setImageInstance(BDFaceImageInstance bDFaceImageInstance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bDFaceImageInstance) == null) {
            this.imageInstance = bDFaceImageInstance;
        }
    }
}
