package com.baidu.ar.databasic;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class HandleConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FORMAT_BGR = 2;
    public static final int FORMAT_NV12 = 1;
    public static final int FORMAT_NV21 = 0;
    public static final int FORMAT_RGB = 3;
    public static final int FORMAT_RGBA = 4;
    public static final int TEXTURE_FORMAT_ALPHA = 1;
    public static final int TEXTURE_FORMAT_LUMINANCE = 0;
    public static final int TEXTURE_FORMAT_LUMINANCE_ALPHA = 3;
    public static final int TEXTURE_FORMAT_RGBA = 2;
    public static final int TYPE_ANIME = 21;
    public static final int TYPE_CHILD = 20;
    public static final int TYPE_FACE = 10;
    public static final int TYPE_FAMILY_WITH_CHILD = 23;
    public static final int TYPE_FINGER_POINT = 15;
    public static final int TYPE_GENDER_TRANS = 24;
    public static final int TYPE_GESTURE = 14;
    public static final int TYPE_HAIR_SEG = 13;
    public static final int TYPE_HAND_SKELETON = 19;
    public static final int TYPE_HEAD_SEG = 22;
    public static final int TYPE_HUMAN_SEG = 11;
    public static final int TYPE_IMU = 8;
    public static final int TYPE_OBJ_DETECT = 18;
    public static final int TYPE_POSE = 16;
    public static final int TYPE_SKY_SEG = 12;
    public static final int TYPE_SLAM = 5;
    public static final int TYPE_STRETCH = 17;
    public transient /* synthetic */ FieldHolder $fh;

    public HandleConstants() {
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
}
