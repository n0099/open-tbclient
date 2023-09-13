package com.baidu.cyberplayer.sdk.vrplayer;
/* loaded from: classes3.dex */
public class VrPlayerConst {
    public static final int AUTH_ERROR_CONFIG = 3;
    public static final int AUTH_ERROR_EXCEPTION = 4;
    public static final int AUTH_ERROR_FUNCTION_DISABLED = 5;
    public static final int AUTH_ERROR_INTERNAL = 1;
    public static final int AUTH_ERROR_TIMEOUT = 2;
    public static final int AUTH_SUCCESS = 0;
    public static final int DISPLAY_MODE_GLASS = 102;
    public static final int DISPLAY_MODE_NORMAL = 101;
    public static final int DISPLAY_MODE_SNAPSHOT = 103;
    public static final int IMAGE_ERROR = 2000;
    public static final int IMAGE_ERROR_INVALID_ASSET = 2;
    public static final int IMAGE_ERROR_INVALID_URI = 3;
    public static final int IMAGE_ERROR_NONE = 1;
    public static final int IMAGE_ERROR_OUT_OF_MEMORY = 4;
    public static final int INFO_NOT_SUPPORT_MODE = 1;
    public static final int INTERACTIVE_MODE_GVR_MOTION = 4;
    public static final int INTERACTIVE_MODE_GVR_MOTION_WITH_TOUCH = 5;
    public static final int INTERACTIVE_MODE_MOTION = 1;
    public static final int INTERACTIVE_MODE_MOTION_WITH_TOUCH = 3;
    public static final int INTERACTIVE_MODE_TOUCH = 2;
    public static final int LOG_LEVEL_D = 1;
    public static final int LOG_LEVEL_E = 4;
    public static final int LOG_LEVEL_I = 2;
    public static final int LOG_LEVEL_V = 0;
    public static final int LOG_LEVEL_W = 3;
    public static final int MEDIA_ERROR_AUTH = 600;
    public static final int MEDIA_ERROR_FFMPEG = 500;
    public static final int MEDIA_ERROR_NETWORK = 300;
    public static final int MEDIA_ERROR_SYS = 400;
    public static final int MEDIA_WRONG_TIME_EXIT = 30000;
    public static final int MEDIA_WRONG_TIME_NONE = 0;
    public static final int MEDIA_WRONG_TIME_PLAYING = 20000;
    public static final int MEDIA_WRONG_TIME_START = 10000;
    public static final int ONCLICK_SRC_GLVIEW = 1;
    public static final int ONCLICK_SRC_HOTSPOT = 3;
    public static final int ONCLICK_SRC_SCENE_SELECTOR = 2;
    public static final int ONTOUCH_TYPE_DRAG = 1;
    public static final int ONTOUCH_TYPE_FLING = 3;
    public static final int ONTOUCH_TYPE_PINCH = 2;
    public static final int PLAYER_TYPE_IJKPLAYER = 1;
    public static final int PLAYER_TYPE_MEDIAPLAYER = 2;
    public static final int PROJECTION_MODE_DOME180 = 202;
    public static final int PROJECTION_MODE_DOME180_UPPER = 204;
    public static final int PROJECTION_MODE_DOME230 = 203;
    public static final int PROJECTION_MODE_DOME230_UPPER = 205;
    public static final int PROJECTION_MODE_MULTI_FISH_EYE_HORIZONTAL = 210;
    public static final int PROJECTION_MODE_MULTI_FISH_EYE_VERTICAL = 211;
    public static final int PROJECTION_MODE_PLANE_CROP = 208;
    public static final int PROJECTION_MODE_PLANE_FIT = 207;
    public static final int PROJECTION_MODE_PLANE_FULL = 209;
    public static final int PROJECTION_MODE_SPHERE = 201;
    public static final int PROJECTION_MODE_STEREO_PLANE_FIT_HORIZONTAL = 214;
    public static final int PROJECTION_MODE_STEREO_PLANE_FIT_VERTICAL = 215;
    public static final int PROJECTION_MODE_STEREO_PLANE_FULL_HORIZONTAL = 216;
    public static final int PROJECTION_MODE_STEREO_PLANE_FULL_VERTICAL = 217;
    public static final int PROJECTION_MODE_STEREO_SPHERE_HORIZONTAL = 212;
    public static final int PROJECTION_MODE_STEREO_SPHERE_VERTICAL = 213;
    public static final int SOURCE_TYPE_NORMAL_2D = 1;
    public static final int SOURCE_TYPE_NORMAL_3D_LR = 3;
    public static final int SOURCE_TYPE_NORMAL_3D_TB = 2;
    public static final int SOURCE_TYPE_PANO_2D = 4;
    public static final int SOURCE_TYPE_PANO_3D_LR = 6;
    public static final int SOURCE_TYPE_PANO_3D_TB = 5;
    public static final int VIEW_TYPE_GLSURFACEVIEW = 1;
    public static final int VIEW_TYPE_GLTEXTUREVIEW = 2;
    public static final int VIEW_TYPE_SURFACEVIEW = 3;
    public static final int VIEW_TYPE_TEXTUREVIEW = 4;

    public static int getProperProjectionMode(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 5) {
                        return i != 6 ? 201 : 212;
                    }
                    return 213;
                }
                return 214;
            }
            return 215;
        }
        return 207;
    }
}
