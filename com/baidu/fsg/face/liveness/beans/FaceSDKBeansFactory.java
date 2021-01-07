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
    public static final int FACE_WARNING_CONFIRG = 13;
    public static final int GETPORTRAITBEAN = 2;
    public static final int GET_RECORDVIDEO_QUESTION = 6;
    public static final int GET_UPLOAD_PHOTO_CONTRAST = 5;
    public static final int LIVENSEE_UPLOAD_FAILURE_IMAGE_BEAN = 12;
    public static final int RECORDVIDEOREVIEWAUTHBEAN = 1;
    public static final int UPLOAD_VIDEO_BEAN = 7;
    public static final int VIDEO_FACEMATCH_BEAN = 10;
    public static final int VIDEO_GETPORTRAIT_BEAN = 9;
    public static final int VIDEO_UPLOAD_BEAN = 11;

    /* renamed from: a  reason: collision with root package name */
    private static FaceSDKBeansFactory f2316a;

    private FaceSDKBeansFactory() {
    }

    public static FaceSDKBeansFactory getInstance() {
        if (f2316a == null) {
            f2316a = new FaceSDKBeansFactory();
        }
        return f2316a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanFactory
    public ApollonBean getBean(Context context, int i, String str) {
        ApollonBean dVar;
        switch (i) {
            case 1:
                dVar = new i(context);
                break;
            case 2:
                dVar = new g(context);
                break;
            case 3:
            case 4:
            default:
                dVar = null;
                break;
            case 5:
                dVar = new j(context);
                break;
            case 6:
                dVar = new h(context);
                break;
            case 7:
                dVar = new m(context);
                break;
            case 8:
                dVar = new e(context);
                break;
            case 9:
                dVar = new o(context);
                break;
            case 10:
                dVar = new n(context);
                break;
            case 11:
                dVar = new a(context);
                break;
            case 12:
                dVar = new k(context);
                break;
            case 13:
                dVar = new d(context);
                break;
        }
        if (dVar != null) {
            BeanManager.getInstance().addBean(str, dVar);
        }
        return dVar;
    }
}
