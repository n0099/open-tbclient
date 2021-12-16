package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.activity.BaseActivity;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.a.a;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
public class LivenessBaseActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PassBiometricConfiguration mConfiguration;
    public PassFaceRecogDTO mPassFaceRecogDTO;

    public LivenessBaseActivity() {
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

    @TargetApi(27)
    public void customLiuHai() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || Build.VERSION.SDK_INT < 27) {
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            Field declaredField = attributes.getClass().getDeclaredField("layoutInDisplayCutoutMode");
            declaredField.setAccessible(true);
            declaredField.set(attributes, Integer.valueOf(WindowManager.LayoutParams.class.getField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES").getInt(WindowManager.LayoutParams.class)));
        } catch (Exception unused) {
        }
        getWindow().setAttributes(attributes);
    }

    public String getAtbc(PassFaceRecogDTO passFaceRecogDTO) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogDTO)) == null) {
            StringBuilder sb = new StringBuilder();
            if (passFaceRecogDTO != null) {
                sb.append("bduss=");
                sb.append(passFaceRecogDTO.bduss);
                sb.append(";stoken=");
                sb.append(passFaceRecogDTO.stoken);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String getFaceDetectUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mConfiguration.passDomain + PassBioEnv.FACE_DETECT_URI;
        }
        return (String) invokeV.objValue;
    }

    public String getPortraitContrastUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mConfiguration.passDomain + PassBioEnv.GET_UPLOAD_PHOTO_CONTRAST_URI;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("PassFaceRecogDTO");
                if (serializable instanceof PassFaceRecogDTO) {
                    this.mPassFaceRecogDTO = (PassFaceRecogDTO) serializable;
                    a.b().a("request_data", this.mPassFaceRecogDTO);
                }
            } else {
                this.mPassFaceRecogDTO = (PassFaceRecogDTO) a.b().a("request_data");
            }
            this.mConfiguration = PassFaceRecogManager.getInstance().getConfiguration();
            customLiuHai();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("PassFaceRecogDTO", this.mPassFaceRecogDTO);
        }
    }

    public void setActivityResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            Intent intent = new Intent();
            intent.putExtras(new Bundle());
            setResult(i2, intent);
        }
    }
}
