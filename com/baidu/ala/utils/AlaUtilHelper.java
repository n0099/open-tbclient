package com.baidu.ala.utils;

import android.text.TextUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaUtilHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlaUtilHelper() {
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

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65537, null, tbImageView, str, z) == null) && tbImageView != null && !TextUtils.isEmpty(str)) {
            if (str.toLowerCase().startsWith("http")) {
                tbImageView.M(str, 10, false);
            } else if (z) {
                tbImageView.M(str, 25, false);
            } else {
                tbImageView.M(str, 12, false);
            }
        }
    }

    public static void startLoadPortrait(TbImageView tbImageView, String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbImageView, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && tbImageView != null && !TextUtils.isEmpty(str)) {
            if (z2 && str.toLowerCase().startsWith("http")) {
                tbImageView.M(str, 10, false);
            } else if (z) {
                tbImageView.M(str, 25, false);
            } else {
                tbImageView.M(str, 12, false);
            }
        }
    }
}
