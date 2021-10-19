package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.restnet.beans.ApollonBean;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.IBeanFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FaceSDKBeansFactory implements NoProguard, IBeanFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONFIG_URL = 4;
    public static final int FACE_DETECT_BEAN = 8;
    public static final int FACE_WARNING_CONFIRG = 13;
    public static final int GETPORTRAITBEAN = 2;
    public static final int GET_RECORDVIDEO_QUESTION = 6;
    public static final int GET_UPLOAD_PHOTO_CONTRAST = 5;
    public static final int LIVENSEE_UPLOAD_FAILURE_IMAGE_BEAN = 12;
    public static final int RECORDVIDEOREVIEWAUTHBEAN = 1;
    public static final int UPLOAD_VIDEO_BEAN = 7;
    public static final int VIDEO_FACEMATCH_BEAN = 10;
    public static final int VIDEO_GETPORTRAIT_BEAN = 9;
    public static final int VIDEO_UPLOAD_BEAN = 11;

    /* renamed from: a  reason: collision with root package name */
    public static FaceSDKBeansFactory f40182a;
    public transient /* synthetic */ FieldHolder $fh;

    public FaceSDKBeansFactory() {
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

    public static FaceSDKBeansFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f40182a == null) {
                f40182a = new FaceSDKBeansFactory();
            }
            return f40182a;
        }
        return (FaceSDKBeansFactory) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    @Override // com.baidu.fsg.base.restnet.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApollonBean getBean(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        ApollonBean iVar;
        ApollonBean apollonBean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, str)) == null) {
            if (i2 == 1) {
                iVar = new i(context);
            } else if (i2 != 2) {
                switch (i2) {
                    case 5:
                        iVar = new j(context);
                        break;
                    case 6:
                        iVar = new h(context);
                        break;
                    case 7:
                        iVar = new m(context);
                        break;
                    case 8:
                        iVar = new e(context);
                        break;
                    case 9:
                        iVar = new o(context);
                        break;
                    case 10:
                        iVar = new n(context);
                        break;
                    case 11:
                        iVar = new a(context);
                        break;
                    case 12:
                        iVar = new k(context);
                        break;
                    case 13:
                        iVar = new d(context);
                        break;
                    default:
                        apollonBean = null;
                        break;
                }
                if (apollonBean != null) {
                    BeanManager.getInstance().addBean(str, apollonBean);
                }
                return apollonBean;
            } else {
                iVar = new g(context);
            }
            apollonBean = iVar;
            if (apollonBean != null) {
            }
            return apollonBean;
        }
        return (ApollonBean) invokeLIL.objValue;
    }
}
