package com.baidu.ar.ability;

import com.baidu.ar.ARType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, String> bA;
    public static final HashMap<ARType, String> bB;
    public static final HashMap<String, String> bC;
    public static final HashMap<String, String> bx;
    public static final List<String> by;
    public static final HashMap<String, String> bz;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-962211986, "Lcom/baidu/ar/ability/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-962211986, "Lcom/baidu/ar/ability/b;");
                return;
            }
        }
        bx = new HashMap() { // from class: com.baidu.ar.ability.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("ability_image_track", "com.baidu.ar.track2d.Track2DAR");
                put("ability_3d_track", "com.baidu.ar.track3d.Track3DAR");
                put("ability_imu", "com.baidu.ar.imu.ImuAR");
                put("ability_vo", "com.baidu.ar.vo.VOAR");
                put("ability_face_child", "com.baidu.ar.child.ChildAR");
                put("ability_vpas", "com.baidu.ar.vpas.VpasAR");
                put("ability_logo_recognition", "com.baidu.ar.logo.LogoAR");
                put("ability_local_image_recognition", "com.baidu.ar.recg.RecgAR");
                put("ability_cloud_image_recognition", "com.baidu.ar.cloud.CloudAR");
                put("ability_face_filter", "com.baidu.ar.face.FaceAR");
                put("ability_makeup_filter", "com.baidu.ar.face.FaceAR");
                put("ability_face_model", "com.baidu.ar.face.FaceAR");
                put("ability_gesture", "com.baidu.ar.gesture.GestureAR");
                put("ability_pose", "com.baidu.ar.pose.PoseAR");
                put("ability_body_detect", "com.baidu.ar.stretch.StretchAR");
                put("ability_object_detect", "com.baidu.ar.objdetect.ObjDetectAR");
                put("ability_image_segmentation", "com.baidu.ar.seg.SegAR");
                put("ability_hair_segmentation", "com.baidu.ar.seg.SegAR");
                put("ability_sky_segmentation", "com.baidu.ar.seg.SegAR");
                put("ability_head_segmentation", "com.baidu.ar.headseg.HeadSegAR");
                put("ability_hand_skeleton", "com.baidu.ar.hand.HandAR");
                put("ability_anime", "com.baidu.ar.anime.AnimeAR");
                put("ability_gender_trans", "com.baidu.ar.gendertrans.GenderTransAR");
                put("ability_capture", "com.baidu.ar.capture.FamilyWithChildAR");
                put("ability_marker", "com.baidu.ar.vps.marker.MarkerAR");
            }
        };
        by = new ArrayList<String>() { // from class: com.baidu.ar.ability.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("ability_face_filter");
                add("ability_makeup_filter");
                add("ability_beauty_filter");
                add("ability_lut_filter");
            }
        };
        bz = new HashMap() { // from class: com.baidu.ar.ability.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("start_gesture", "ability_gesture");
                put("start_image_segmentation", "ability_image_segmentation");
                put("start_body_tracking", "ability_pose");
                put("start_body_detecting", "ability_body_detect");
                put("start_hair_segmentation", "ability_hair_segmentation");
                put("start_sky_segmentation", "ability_sky_segmentation");
                put("start_obj_detect", "ability_object_detect");
            }
        };
        bA = new HashMap() { // from class: com.baidu.ar.ability.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("stop_gesture", "ability_gesture");
                put("stop_image_segmentation", "ability_image_segmentation");
                put("stop_body_tracking", "ability_pose");
                put("stop_body_detecting", "ability_body_detect");
                put("stop_hair_segmentation", "ability_hair_segmentation");
                put("stop_sky_segmentation", "ability_sky_segmentation");
                put("stop_obj_detect", "ability_object_detect");
            }
        };
        bB = new HashMap() { // from class: com.baidu.ar.ability.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(ARType.IMU, "ability_imu");
                put(ARType.TRACK_2D, "ability_image_track");
                put(ARType.TRACK_3D, "ability_3d_track");
                put(ARType.VO, "ability_vo");
                put(ARType.FACE, "ability_face_model");
                put(ARType.CLOUD_IR, "ability_cloud_image_recognition");
                put(ARType.ON_DEVICE_IR, "ability_local_image_recognition");
                put(ARType.VPAS, "ability_vpas");
                put(ARType.MARKER, "ability_marker");
            }
        };
        bC = new HashMap() { // from class: com.baidu.ar.ability.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put("FaceDetector", "com.baidu.ar.face.FaceAR");
            }
        };
    }
}
