package com.baidu.sapi2.dto;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FaceBaseDTO extends SapiDTO {
    public static final String BUSINESS_BAIDU_MINI_PROGRAMS_SENCE = "baidu_mini_programs";
    public static final String BUSINESS_SENCE = "netdisk_2pwd";
    public static final String BUSINESS_SENCE_FACE_LOGIN_SWITCH = "native_face_login_switch";
    public static final String BUSINESS_SENCE_NETDISK_PWD = "netdisk_2pwd";
    public static final String BUSINESS_SENCE_REALNAME_FACE = "face_verify";
    public static final String KEY_BUSINESS_SCENE = "scene";
    public String businessSence;
    public String subpro;
    public boolean showGuidePage = false;
    public Map<String, String> transParamsList = new HashMap();
}
