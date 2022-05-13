package com.baidu.swan.apps.core.launchtips.scene;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s02;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class SceneType {
    public static final /* synthetic */ SceneType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final SceneType SCENE_DOWNLOAD_PKG_TIMEOUT;
    public static final SceneType SCENE_INIT_DATA_ERROR;
    public static final SceneType SCENE_PMS_TIMEOUT;
    public static final SceneType SCENE_SKELETON_DEV_TIMEOUT;
    public static final SceneType SCENE_SKELETON_TIMEOUT;
    public static final SceneType SCENE_WHITE_SCREEN_L1;
    public static final SceneType SCENE_WHITE_SCREEN_L2;
    public static final SceneType SCENE_WHITE_SCREEN_L3;
    public transient /* synthetic */ FieldHolder $fh;
    public final String scene;
    public final String type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(439058905, "Lcom/baidu/swan/apps/core/launchtips/scene/SceneType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(439058905, "Lcom/baidu/swan/apps/core/launchtips/scene/SceneType;");
                return;
            }
        }
        SCENE_PMS_TIMEOUT = new SceneType("SCENE_PMS_TIMEOUT", 0, "pms_getPkg", "PMS获取包接口返回超过3秒；");
        SCENE_DOWNLOAD_PKG_TIMEOUT = new SceneType("SCENE_DOWNLOAD_PKG_TIMEOUT", 1, "pms_downloadPkg", "包下载进度更新间隔超2秒；");
        SCENE_SKELETON_TIMEOUT = new SceneType("SCENE_SKELETON_TIMEOUT", 2, "skeleton", "5秒内未触发骨架屏移除；");
        SCENE_WHITE_SCREEN_L1 = new SceneType("SCENE_WHITE_SCREEN_L1", 3, "whiteScreen_L1", "检测到纯白屏；");
        SCENE_WHITE_SCREEN_L2 = new SceneType("SCENE_WHITE_SCREEN_L2", 4, "whiteScreen_L2", s02.a);
        SCENE_WHITE_SCREEN_L3 = new SceneType("SCENE_WHITE_SCREEN_L3", 5, "whiteScreen_L3", s02.b);
        SCENE_INIT_DATA_ERROR = new SceneType("SCENE_INIT_DATA_ERROR", 6, "data_init", "业务数据初始化异常；");
        SceneType sceneType = new SceneType("SCENE_SKELETON_DEV_TIMEOUT", 7, "skeleton_dev", "开发者骨架屏异常；");
        SCENE_SKELETON_DEV_TIMEOUT = sceneType;
        $VALUES = new SceneType[]{SCENE_PMS_TIMEOUT, SCENE_DOWNLOAD_PKG_TIMEOUT, SCENE_SKELETON_TIMEOUT, SCENE_WHITE_SCREEN_L1, SCENE_WHITE_SCREEN_L2, SCENE_WHITE_SCREEN_L3, SCENE_INIT_DATA_ERROR, sceneType};
    }

    public SceneType(@NonNull String str, @NonNull int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = str2;
        this.scene = str3;
    }

    public static SceneType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SceneType) Enum.valueOf(SceneType.class, str) : (SceneType) invokeL.objValue;
    }

    public static SceneType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SceneType[]) $VALUES.clone() : (SceneType[]) invokeV.objValue;
    }

    public String getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.scene : (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.type : (String) invokeV.objValue;
    }
}
