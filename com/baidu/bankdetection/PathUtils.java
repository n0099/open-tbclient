package com.baidu.bankdetection;

import android.os.Environment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PathUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATA_DIR = "";
    public static final String captcha_path = "bankcard-2.bundle/model/bank_card_captcha.txt";
    public static final String dtc_mean_path_fst = null;
    public static final String dtc_mean_path_scd = null;
    public static final String dtc_model_path_fst = "bankcard-2.bundle/model/dtc_model_bank_card_fst_64";
    public static final String dtc_model_path_scd = "bankcard-2.bundle/model/dtc_model_bank_card_scd_64";
    public static final String mean_path = "bankcard-2.bundle/mean/data_mean_32_bank_card";
    public static final String model_path = "bankcard-2.bundle/model/cdnn_model_bank_card_32";
    public static final boolean use_new_captcha = true;
    public static final boolean use_new_dtc_fst = true;
    public static final boolean use_new_dtc_scd = true;
    public static final boolean use_new_recog = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1019428195, "Lcom/baidu/bankdetection/PathUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1019428195, "Lcom/baidu/bankdetection/PathUtils;");
        }
    }

    public PathUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getSDPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null).toString();
        }
        return (String) invokeV.objValue;
    }
}
