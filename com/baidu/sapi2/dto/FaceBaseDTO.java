package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes2.dex */
public class FaceBaseDTO extends SapiDTO {
    public static final String BUSINESS_SENCE = "netdisk_2pwd";
    public static final String BUSINESS_SENCE_FACE_LOGIN_SWITCH = "native_face_login_switch";
    public static final String BUSINESS_SENCE_NETDISK_PWD = "netdisk_2pwd";
    public static final String BUSINESS_SENCE_REALNAME_FACE = "face_verify";
    public static final String KEY_BUSINESS_SCENE = "scene";
    public String businessSence;
    public String subpro;
    public boolean showGuidePage = false;
    public List<NameValuePair> transParamsList = new ArrayList();
}
