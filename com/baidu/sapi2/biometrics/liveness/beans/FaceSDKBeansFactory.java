package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.restnet.beans.ApollonBean;
import com.baidu.fsg.base.restnet.beans.BeanManager;
import com.baidu.fsg.base.restnet.beans.IBeanFactory;
/* loaded from: classes2.dex */
public class FaceSDKBeansFactory implements NoProguard, IBeanFactory {
    public static final int CONFIG_URL = 4;
    public static final int FACE_DETECT_BEAN = 8;
    public static final int GETPORTRAITBEAN = 2;
    public static final int GET_RECORDVIDEO_QUESTION = 6;
    public static final int GET_UPLOAD_PHOTO_CONTRAST = 5;
    public static final int RECORDVIDEOREVIEWAUTHBEAN = 1;
    public static final int UPLOAD_VIDEO_BEAN = 7;
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
        ApollonBean cVar;
        switch (i) {
            case 1:
                cVar = new g(context);
                break;
            case 2:
                cVar = new e(context);
                break;
            case 3:
            case 4:
            default:
                cVar = null;
                break;
            case 5:
                cVar = new h(context);
                break;
            case 6:
                cVar = new f(context);
                break;
            case 7:
                cVar = new i(context);
                break;
            case 8:
                cVar = new c(context);
                break;
        }
        if (cVar != null) {
            BeanManager.getInstance().addBean(str, cVar);
        }
        return cVar;
    }
}
