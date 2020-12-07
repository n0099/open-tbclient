package com.baidu.ar.ability;

import com.baidu.ar.ARType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static final HashMap<String, String> bx = new HashMap() { // from class: com.baidu.ar.ability.b.1
        {
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
    public static final List<String> by = new ArrayList<String>() { // from class: com.baidu.ar.ability.b.2
        {
            add("ability_face_filter");
            add("ability_makeup_filter");
            add("ability_beauty_filter");
            add("ability_lut_filter");
        }
    };
    public static final HashMap<String, String> bz = new HashMap() { // from class: com.baidu.ar.ability.b.3
        {
            put("start_gesture", "ability_gesture");
            put("start_image_segmentation", "ability_image_segmentation");
            put("start_body_tracking", "ability_pose");
            put("start_body_detecting", "ability_body_detect");
            put("start_hair_segmentation", "ability_hair_segmentation");
            put("start_sky_segmentation", "ability_sky_segmentation");
            put("start_obj_detect", "ability_object_detect");
        }
    };
    public static final HashMap<String, String> bA = new HashMap() { // from class: com.baidu.ar.ability.b.4
        {
            put("stop_gesture", "ability_gesture");
            put("stop_image_segmentation", "ability_image_segmentation");
            put("stop_body_tracking", "ability_pose");
            put("stop_body_detecting", "ability_body_detect");
            put("stop_hair_segmentation", "ability_hair_segmentation");
            put("stop_sky_segmentation", "ability_sky_segmentation");
            put("stop_obj_detect", "ability_object_detect");
        }
    };
    public static final HashMap<ARType, String> bB = new HashMap() { // from class: com.baidu.ar.ability.b.5
        {
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
    public static final HashMap<String, String> bC = new HashMap() { // from class: com.baidu.ar.ability.b.6
        {
            put("FaceDetector", "com.baidu.ar.face.FaceAR");
        }
    };
}
