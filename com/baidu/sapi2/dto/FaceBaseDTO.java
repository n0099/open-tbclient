package com.baidu.sapi2.dto;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FaceBaseDTO extends SapiDTO {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSINESS_BAIDU_MINI_PROGRAMS_SENCE = "baidu_mini_programs";
    public static final String BUSINESS_SENCE = "netdisk_2pwd";
    public static final String BUSINESS_SENCE_FACE_LOGIN_SWITCH = "native_face_login_switch";
    public static final String BUSINESS_SENCE_NETDISK_PWD = "netdisk_2pwd";
    public static final String BUSINESS_SENCE_REALNAME_FACE = "face_verify";
    public static final String KEY_BUSINESS_SCENE = "scene";
    public transient /* synthetic */ FieldHolder $fh;
    public String businessSence;
    public boolean showGuidePage;
    public String subpro;
    public Map<String, String> transParamsList;

    public FaceBaseDTO() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.showGuidePage = false;
        this.transParamsList = new HashMap();
    }
}
