package com.baidu.fsg.face.liveness.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.activity.BeanActivity;
import com.baidu.fsg.face.liveness.beans.c;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.view.BioAlertDialog;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class LivenessBaseActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LivenessRecogDTO livenessRecogDTO;

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

    @Override // com.baidu.fsg.base.activity.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }

    public boolean isSupportLiuHai() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.activity.BeanActivity, com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("LivenessRecogDTO");
                if (serializable != null && (serializable instanceof LivenessRecogDTO)) {
                    this.livenessRecogDTO = (LivenessRecogDTO) serializable;
                    c.a().a("request_data", this.livenessRecogDTO);
                }
            } else {
                this.livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
            }
            if (isSupportLiuHai()) {
                customLiuHai();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("LivenessRecogDTO", this.livenessRecogDTO);
        }
    }

    public void showNoNetWorkDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
            bioAlertDialog.setDialogMsg(getString(R.string.rim_liveness_no_network_tip));
            bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.sapi_dialog_title_text_color));
            bioAlertDialog.setBtnCount(2);
            bioAlertDialog.setPositiveBtn(getString(R.string.rim_liveness_network_set), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessBaseActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f38718a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessBaseActivity f38719b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38719b = this;
                    this.f38718a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f38718a.dismiss();
                        try {
                            this.f38719b.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            });
            bioAlertDialog.setNegativeBtn(getString(R.string.rim_liveness_cancle), new View.OnClickListener(this, bioAlertDialog) { // from class: com.baidu.fsg.face.liveness.activity.LivenessBaseActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BioAlertDialog f38720a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessBaseActivity f38721b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioAlertDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38721b = this;
                    this.f38720a = bioAlertDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f38720a.dismiss();
                    }
                }
            });
            bioAlertDialog.setCancelable(false);
            if (isFinishing() || bioAlertDialog.isShowing()) {
                return;
            }
            bioAlertDialog.show();
        }
    }
}
