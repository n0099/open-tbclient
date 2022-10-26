package com.baidu.pass.face.platform.b;

import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FaceExtInfo[] a;
    public FaceExtInfo b;
    public FaceConfig c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ArrayList a(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, faceExtInfo, bDFaceImageInstance)) == null) {
            if (faceExtInfo == null) {
                str = "faceInfo == null";
            } else if (bDFaceImageInstance != null) {
                ArrayList arrayList = new ArrayList();
                ImageInfo imageInfo = new ImageInfo();
                int i = 0;
                int i2 = 300;
                FaceConfig faceConfig = this.c;
                if (faceConfig != null) {
                    i = faceConfig.getSecType();
                    i2 = this.c.getCompressValue();
                    z = this.c.isCompressImage();
                } else {
                    z = true;
                }
                if (i == 0) {
                    imageInfo.setBase64(bDFaceImageInstance.getBase64());
                }
                if (i == 1) {
                    String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance, z, i2);
                    if (!TextUtils.isEmpty(imageSec)) {
                        imageInfo.setSecBase64(imageSec.replaceAll("\n", ""));
                    }
                }
                arrayList.add(imageInfo);
                return arrayList;
            } else {
                str = "cropInstance == null";
            }
            Log.e("FaceModuleNew", str);
            return null;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public void a(FaceConfig faceConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, faceConfig) == null) {
            this.c = faceConfig;
        }
    }

    public FaceExtInfo[] a(FaceInfo[] faceInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceInfoArr)) == null) {
            if (this.a == null) {
                this.a = new FaceExtInfo[1];
                this.b = new FaceExtInfo();
            }
            if (faceInfoArr == null || faceInfoArr.length <= 0) {
                this.a[0] = null;
            } else {
                if (this.b == null) {
                    this.b = new FaceExtInfo();
                }
                this.b.addFaceInfo(faceInfoArr[0]);
                this.a[0] = this.b;
            }
            return this.a;
        }
        return (FaceExtInfo[]) invokeL.objValue;
    }

    public ArrayList b(FaceExtInfo faceExtInfo, BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeLL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, faceExtInfo, bDFaceImageInstance)) == null) {
            if (faceExtInfo == null) {
                str = "faceInfo == null";
            } else if (bDFaceImageInstance != null) {
                ArrayList arrayList = new ArrayList();
                ImageInfo imageInfo = new ImageInfo();
                int i = 0;
                int i2 = 300;
                FaceConfig faceConfig = this.c;
                if (faceConfig != null) {
                    i = faceConfig.getSecType();
                    i2 = this.c.getCompressValue();
                    z = this.c.isCompressImage();
                } else {
                    z = true;
                }
                if (i == 0) {
                    imageInfo.setBase64(bDFaceImageInstance.getBase64());
                }
                if (i == 1) {
                    String imageSec = FaceSDKManager.getInstance().imageSec(bDFaceImageInstance, z, i2);
                    if (!TextUtils.isEmpty(imageSec)) {
                        imageInfo.setSecBase64(imageSec.replaceAll("\n", ""));
                    }
                }
                arrayList.add(imageInfo);
                return arrayList;
            } else {
                str = "cropInstance == null";
            }
            Log.e("FaceModuleNew", str);
            return null;
        }
        return (ArrayList) invokeLL.objValue;
    }
}
