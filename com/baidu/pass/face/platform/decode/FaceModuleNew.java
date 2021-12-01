package com.baidu.pass.face.platform.decode;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceConfig;
import com.baidu.pass.face.platform.FaceSDKManager;
import com.baidu.pass.face.platform.model.FaceExtInfo;
import com.baidu.pass.face.platform.model.ImageInfo;
import com.baidu.pass.main.facesdk.FaceInfo;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes8.dex */
public class FaceModuleNew {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceModuleNew";
    public transient /* synthetic */ FieldHolder $fh;
    public FaceConfig mFaceConfig;
    public FaceExtInfo mFaceExtInfo;
    public FaceExtInfo[] mFaceExtInfos;

    public FaceModuleNew() {
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

    public ArrayList<ImageInfo> getDetectBestCropImageList(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, faceExtInfo, bDFaceImageInstance)) == null) {
            if (faceExtInfo == null || bDFaceImageInstance == null) {
                return null;
            }
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            FaceConfig faceConfig = this.mFaceConfig;
            int secType = faceConfig != null ? faceConfig.getSecType() : 0;
            imageInfo.setBase64(bDFaceImageInstance.getBase64());
            if (secType == 1) {
                String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance);
                if (!TextUtils.isEmpty(imageSec)) {
                    imageInfo.setSecBase64(imageSec.replaceAll(StringUtils.LF, ""));
                }
            }
            arrayList.add(imageInfo);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public ArrayList<ImageInfo> getDetectBestSrcImageList(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceExtInfo, bDFaceImageInstance)) == null) {
            if (faceExtInfo == null || bDFaceImageInstance == null) {
                return null;
            }
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            ImageInfo imageInfo = new ImageInfo();
            FaceConfig faceConfig = this.mFaceConfig;
            int secType = faceConfig != null ? faceConfig.getSecType() : 0;
            imageInfo.setBase64(bDFaceImageInstance.getBase64());
            if (secType == 1) {
                String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance);
                if (!TextUtils.isEmpty(imageSec)) {
                    imageInfo.setSecBase64(imageSec.replaceAll(StringUtils.LF, ""));
                }
            }
            arrayList.add(imageInfo);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public FaceExtInfo[] getFaceExtInfo(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceInfoArr)) == null) {
            if (this.mFaceExtInfos == null) {
                this.mFaceExtInfos = new FaceExtInfo[1];
                this.mFaceExtInfo = new FaceExtInfo();
            }
            if (faceInfoArr != null && faceInfoArr.length > 0) {
                if (this.mFaceExtInfo == null) {
                    this.mFaceExtInfo = new FaceExtInfo();
                }
                this.mFaceExtInfo.addFaceInfo(faceInfoArr[0]);
                this.mFaceExtInfos[0] = this.mFaceExtInfo;
            } else {
                this.mFaceExtInfos[0] = null;
            }
            return this.mFaceExtInfos;
        }
        return (FaceExtInfo[]) invokeL.objValue;
    }

    public void setFaceConfig(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, faceConfig) == null) {
            this.mFaceConfig = faceConfig;
        }
    }
}
