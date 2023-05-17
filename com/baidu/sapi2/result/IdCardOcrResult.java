package com.baidu.sapi2.result;
/* loaded from: classes3.dex */
public class IdCardOcrResult extends SapiResult {
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
    public String image;
    public String type;
}
