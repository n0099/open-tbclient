package com.baidu.ar.ability;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class AbilityType {
    public static final /* synthetic */ AbilityType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AbilityType ANIME;
    public static final AbilityType BODY_DETECT;
    public static final AbilityType CLOUD_IR;
    public static final AbilityType COMMON_FILTER;
    public static final AbilityType FACE_FILTER;
    public static final AbilityType FACE_MODEL;
    public static final AbilityType GENDER_TRANS;
    public static final AbilityType GESTURE;
    public static final AbilityType HAIR_SEG;
    public static final AbilityType HAND_SKELETON;
    public static final AbilityType HEAD_SEG;
    public static final AbilityType IMG_SEG;
    public static final AbilityType IMU;
    public static final AbilityType LOCAL_IR;
    public static final AbilityType LOGO_IR;
    public static final AbilityType OBJ_DETECT;
    public static final AbilityType POSE;
    public static final AbilityType SKY_SEG;
    public static final AbilityType TRACK_2D;
    public static final AbilityType TRACK_3D;
    public static final AbilityType VO;
    public static final AbilityType VPAS;
    public static final AbilityType VPAS_MARKER;
    public transient /* synthetic */ FieldHolder $fh;
    public String mTypeValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975441516, "Lcom/baidu/ar/ability/AbilityType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975441516, "Lcom/baidu/ar/ability/AbilityType;");
                return;
            }
        }
        TRACK_2D = new AbilityType("TRACK_2D", 0, "ability_image_track");
        TRACK_3D = new AbilityType("TRACK_3D", 1, "ability_3d_track");
        IMU = new AbilityType("IMU", 2, "ability_imu");
        VO = new AbilityType("VO", 3, "ability_vo");
        LOCAL_IR = new AbilityType("LOCAL_IR", 4, "ability_local_image_recognition");
        CLOUD_IR = new AbilityType("CLOUD_IR", 5, "ability_cloud_image_recognition");
        LOGO_IR = new AbilityType("LOGO_IR", 6, "ability_logo_recognition");
        VPAS = new AbilityType("VPAS", 7, "ability_vpas");
        FACE_FILTER = new AbilityType("FACE_FILTER", 8, "ability_face_filter");
        FACE_MODEL = new AbilityType("FACE_MODEL", 9, "ability_face_model");
        GESTURE = new AbilityType("GESTURE", 10, "ability_gesture");
        POSE = new AbilityType("POSE", 11, "ability_pose");
        BODY_DETECT = new AbilityType("BODY_DETECT", 12, "ability_body_detect");
        OBJ_DETECT = new AbilityType("OBJ_DETECT", 13, "ability_object_detect");
        IMG_SEG = new AbilityType("IMG_SEG", 14, "ability_image_segmentation");
        HAIR_SEG = new AbilityType("HAIR_SEG", 15, "ability_hair_segmentation");
        SKY_SEG = new AbilityType("SKY_SEG", 16, "ability_sky_segmentation");
        COMMON_FILTER = new AbilityType("COMMON_FILTER", 17, "ability_common_filter");
        HAND_SKELETON = new AbilityType("HAND_SKELETON", 18, "ability_hand_skeleton");
        ANIME = new AbilityType("ANIME", 19, "ability_anime");
        HEAD_SEG = new AbilityType("HEAD_SEG", 20, "ability_head_segmentation");
        GENDER_TRANS = new AbilityType("GENDER_TRANS", 21, "com.baidu.ar.gendertrans.GenderTransAR");
        AbilityType abilityType = new AbilityType("VPAS_MARKER", 22, "ability_marker");
        VPAS_MARKER = abilityType;
        $VALUES = new AbilityType[]{TRACK_2D, TRACK_3D, IMU, VO, LOCAL_IR, CLOUD_IR, LOGO_IR, VPAS, FACE_FILTER, FACE_MODEL, GESTURE, POSE, BODY_DETECT, OBJ_DETECT, IMG_SEG, HAIR_SEG, SKY_SEG, COMMON_FILTER, HAND_SKELETON, ANIME, HEAD_SEG, GENDER_TRANS, abilityType};
    }

    public AbilityType(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTypeValue = str2;
    }

    public static AbilityType getTypeOf(String str) {
        InterceptResult invokeL;
        AbilityType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (AbilityType abilityType : values()) {
                if (abilityType.getTypeValue() == str) {
                    return abilityType;
                }
            }
            return null;
        }
        return (AbilityType) invokeL.objValue;
    }

    public static AbilityType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (AbilityType) Enum.valueOf(AbilityType.class, str) : (AbilityType) invokeL.objValue;
    }

    public static AbilityType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (AbilityType[]) $VALUES.clone() : (AbilityType[]) invokeV.objValue;
    }

    public String getTypeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTypeValue : (String) invokeV.objValue;
    }
}
