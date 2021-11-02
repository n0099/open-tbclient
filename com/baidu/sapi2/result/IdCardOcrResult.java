package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class IdCardOcrResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_ALBUM_ERROR = -404;
    public static final int CODE_CAMERA_ERROR = -403;
    public static final int CODE_NO_ALBUM_PERMISSION = -402;
    public static final int CODE_NO_CAMERA_PERMISSION = -401;
    public static final int CODE_PAGE_PARAMS_ERROR = -405;
    public static final String MESSAGE_ALBUM_ERROR = "获取相册图片失败";
    public static final String MESSAGE_CAMERA_ERROR = "获取相机图片失败";
    public static final String MESSAGE_NO_ALBUM_PERMISSION = "请打开文件权限";
    public static final String MESSAGE_NO_CAMERA_PERMISSION = "请打开相机权限";
    public static final String MESSAGE_PAGE_PARAMS_ERROR = "打开页面传参错误";
    public transient /* synthetic */ FieldHolder $fh;
    public String image;
    public String type;

    public IdCardOcrResult() {
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
