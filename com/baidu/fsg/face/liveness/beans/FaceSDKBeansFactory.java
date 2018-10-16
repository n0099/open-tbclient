package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.restnet.beans.ApollonBean;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.IBeanFactory;
/* loaded from: classes6.dex */
public class FaceSDKBeansFactory implements NoProguard, IBeanFactory {
    public static final int CONFIG_URL = 4;
    public static final int FACE_DETECT_BEAN = 8;
    public static final int GETPORTRAITBEAN = 2;
    public static final int GET_RECORDVIDEO_QUESTION = 6;
    public static final int GET_UPLOAD_PHOTO_CONTRAST = 5;
    public static final int LIVENSEE_UPLOAD_FAILURE_IMAGE_BEAN = 12;
    public static final int RECORDVIDEOREVIEWAUTHBEAN = 1;
    public static final int UPLOAD_VIDEO_BEAN = 7;
    public static final int VIDEO_FACEMATCH_BEAN = 10;
    public static final int VIDEO_GETPORTRAIT_BEAN = 9;
    public static final int VIDEO_UPLOAD_BEAN = 11;
    private static FaceSDKBeansFactory a;

    private FaceSDKBeansFactory() {
    }

    public static FaceSDKBeansFactory getInstance() {
        if (a == null) {
            a = new FaceSDKBeansFactory();
        }
        return a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanFactory
    public ApollonBean getBean(Context context, int i, String str) {
        ApollonBean jVar;
        switch (i) {
            case 1:
                jVar = new h(context);
                break;
            case 2:
                jVar = new f(context);
                break;
            case 3:
            case 4:
            default:
                jVar = null;
                break;
            case 5:
                jVar = new i(context);
                break;
            case 6:
                jVar = new g(context);
                break;
            case 7:
                jVar = new l(context);
                break;
            case 8:
                jVar = new d(context);
                break;
            case 9:
                jVar = new n(context);
                break;
            case 10:
                jVar = new m(context);
                break;
            case 11:
                jVar = new a(context);
                break;
            case 12:
                jVar = new j(context);
                break;
        }
        if (jVar != null) {
            BeanManager.getInstance().addBean(str, jVar);
        }
        return jVar;
    }
}
