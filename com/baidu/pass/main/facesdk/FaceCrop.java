package com.baidu.pass.main.facesdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.callback.Callback;
import com.baidu.pass.main.facesdk.model.BDFaceCropParam;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceInstance;
import com.baidu.pass.main.facesdk.model.BDFaceIsOutBoundary;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class FaceCrop {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FaceCrop";
    public transient /* synthetic */ FieldHolder $fh;
    public BDFaceInstance bdFaceInstance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-550782602, "Lcom/baidu/pass/main/facesdk/FaceCrop;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-550782602, "Lcom/baidu/pass/main/facesdk/FaceCrop;");
        }
    }

    public FaceCrop(BDFaceInstance bDFaceInstance) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDFaceInstance};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (bDFaceInstance == null) {
            return;
        }
        this.bdFaceInstance = bDFaceInstance;
    }

    private native BDFaceImageInstance nativeCropFaceByBox(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f2, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByBoxIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByBoxParam(long j, BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmark(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f2, boolean z, int[] iArr);

    private native BDFaceIsOutBoundary nativeCropFaceByLandmarkIsOutofBoundary(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native BDFaceImageInstance nativeCropFaceByLandmarkParam(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    private native long nativeCropFaceByLandmarkParamInstance(long j, BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeCropImageInit(long j);

    private native BDFaceImageInstance nativeResizeImage(BDFaceImageInstance bDFaceImageInstance, int i2, BDFaceSDKCommon.BDFaceImageType bDFaceImageType);

    private native int nativeUnInitCropImage(long j);

    public BDFaceImageInstance cropFaceByBox(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, float f2, AtomicInteger atomicInteger) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bDFaceImageInstance, faceInfo, Float.valueOf(f2), atomicInteger})) == null) {
            if (bDFaceImageInstance == null || faceInfo == null || atomicInteger == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            int[] iArr = new int[1];
            BDFaceImageInstance nativeCropFaceByBox = nativeCropFaceByBox(index, bDFaceImageInstance, faceInfo, f2, iArr);
            atomicInteger.set(iArr[0]);
            return nativeCropFaceByBox;
        }
        return (BDFaceImageInstance) invokeCommon.objValue;
    }

    public BDFaceIsOutBoundary cropFaceByBoxIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDFaceImageInstance, faceInfo, bDFaceCropParam)) == null) {
            if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByBoxIsOutofBoundary(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
        }
        return (BDFaceIsOutBoundary) invokeLLL.objValue;
    }

    public BDFaceImageInstance cropFaceByBoxParam(BDFaceImageInstance bDFaceImageInstance, FaceInfo faceInfo, BDFaceCropParam bDFaceCropParam) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bDFaceImageInstance, faceInfo, bDFaceCropParam)) == null) {
            if (bDFaceImageInstance == null || faceInfo == null || bDFaceCropParam == null) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByBoxParam(index, bDFaceImageInstance, faceInfo, bDFaceCropParam);
        }
        return (BDFaceImageInstance) invokeLLL.objValue;
    }

    public BDFaceImageInstance cropFaceByLandmark(BDFaceImageInstance bDFaceImageInstance, float[] fArr, float f2, boolean z, AtomicInteger atomicInteger) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bDFaceImageInstance, fArr, Float.valueOf(f2), Boolean.valueOf(z), atomicInteger})) == null) {
            if (bDFaceImageInstance == null || atomicInteger == null || fArr.length < 0) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            int[] iArr = new int[1];
            BDFaceImageInstance nativeCropFaceByLandmark = nativeCropFaceByLandmark(index, bDFaceImageInstance, fArr, f2, z, iArr);
            atomicInteger.set(iArr[0]);
            return nativeCropFaceByLandmark;
        }
        return (BDFaceImageInstance) invokeCommon.objValue;
    }

    public BDFaceIsOutBoundary cropFaceByLandmarkIsOutofBoundary(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, bDFaceImageInstance, fArr, bDFaceCropParam)) == null) {
            if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByLandmarkIsOutofBoundary(index, bDFaceImageInstance, fArr, bDFaceCropParam);
        }
        return (BDFaceIsOutBoundary) invokeLLL.objValue;
    }

    public BDFaceImageInstance cropFaceByLandmarkParam(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, bDFaceImageInstance, fArr, bDFaceCropParam)) == null) {
            if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return nativeCropFaceByLandmarkParam(index, bDFaceImageInstance, fArr, bDFaceCropParam);
        }
        return (BDFaceImageInstance) invokeLLL.objValue;
    }

    public BDFaceImageInstance cropFaceByLandmarkParamInstance(BDFaceImageInstance bDFaceImageInstance, float[] fArr, BDFaceCropParam bDFaceCropParam) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, bDFaceImageInstance, fArr, bDFaceCropParam)) == null) {
            if (bDFaceImageInstance == null || fArr == null || bDFaceCropParam == null || fArr.length == 0) {
                return null;
            }
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return null;
            }
            return new BDFaceImageInstance(nativeCropFaceByLandmarkParamInstance(index, bDFaceImageInstance, fArr, bDFaceCropParam));
        }
        return (BDFaceImageInstance) invokeLLL.objValue;
    }

    public void initFaceCrop(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, callback) == null) {
            FaceQueue.getInstance().execute(new Runnable(this, callback) { // from class: com.baidu.pass.main.facesdk.FaceCrop.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FaceCrop this$0;
                public final /* synthetic */ Callback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = callback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long index = this.this$0.bdFaceInstance.getIndex();
                        if (index != 0) {
                            int nativeCropImageInit = this.this$0.nativeCropImageInit(index);
                            if (nativeCropImageInit == 0) {
                                this.val$callback.onResponse(nativeCropImageInit, "抠图能力加载成功");
                                return;
                            }
                            Callback callback2 = this.val$callback;
                            callback2.onResponse(nativeCropImageInit, "抠图能力加载失败: " + nativeCropImageInit);
                            return;
                        }
                        this.val$callback.onResponse(-1, "抠图能力加载失败 instanceIndex=0");
                    }
                }
            });
        }
    }

    public BDFaceImageInstance resizeImage(BDFaceImageInstance bDFaceImageInstance, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDFaceImageInstance, i2)) == null) {
            if (bDFaceImageInstance == null) {
                return null;
            }
            return nativeResizeImage(bDFaceImageInstance, i2, bDFaceImageInstance.imageType);
        }
        return (BDFaceImageInstance) invokeLI.objValue;
    }

    public int uninitFaceCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long index = this.bdFaceInstance.getIndex();
            if (index == 0) {
                return -1;
            }
            return nativeUnInitCropImage(index);
        }
        return invokeV.intValue;
    }

    public FaceCrop() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        BDFaceInstance bDFaceInstance = new BDFaceInstance();
        this.bdFaceInstance = bDFaceInstance;
        bDFaceInstance.getDefautlInstance();
    }
}
