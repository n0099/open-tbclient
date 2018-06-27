package com.baidu.sapi2.share.face;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.c;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FaceLoginService {
    public static final String KEY_SHARE_FACE_LOGIN = "face_login_model";
    public static final String TAG = FaceLoginService.class.getSimpleName();
    public Context context = SapiAccountManager.getInstance().getConfignation().context;

    public void syncFaceLoginUID(Context context, String str) {
        SapiContext.getInstance(context).setFaceLoginUid(str);
        SapiAccountManager.getInstance().getAccountService().faceLoginEnable(context);
    }

    public void syncShareFaceLoginModel(String str) {
        if (SapiContext.getInstance(this.context).getShareCommonStorageEnabel()) {
            String a = a(str);
            if (!TextUtils.isEmpty(a)) {
                ShareStorage shareStorage = new ShareStorage();
                if (!a.equals(shareStorage.getSp(KEY_SHARE_FACE_LOGIN))) {
                    shareStorage.setSp(KEY_SHARE_FACE_LOGIN, a);
                }
                String md5 = MD5Util.toMd5(KEY_SHARE_FACE_LOGIN.getBytes(), false);
                if (!a.equals(shareStorage.getSd(md5))) {
                    shareStorage.setSd(md5, a);
                }
            }
        }
    }

    public void requestFaceLoginModel() {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.share.face.FaceLoginService.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(SapiContext.getInstance(FaceLoginService.this.context).getFaceLoginUid())) {
                    FaceLoginService.this.a(FaceLoginService.this.context, null);
                    return;
                }
                FaceLoginModel convertResult2Model = FaceLoginService.this.convertResult2Model(SapiContext.getInstance(FaceLoginService.this.context).getFaceLoginModel());
                if (convertResult2Model == null || TextUtils.isEmpty(convertResult2Model.faceCheckStr)) {
                    FaceLoginService.this.a(FaceLoginService.this.context, convertResult2Model);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, FaceLoginModel faceLoginModel) {
        if (SapiContext.getInstance(context).getShareFaceLoginEnable()) {
            List<Intent> a = c.a(context);
            if (!a.isEmpty()) {
                ShareStorage shareStorage = new ShareStorage();
                FaceLoginModel faceLoginModel2 = null;
                Iterator<Intent> it = a.iterator();
                while (it.hasNext() && (faceLoginModel2 = convertResult2Model(shareStorage.getSp(it.next().getComponent().getPackageName(), KEY_SHARE_FACE_LOGIN))) == null) {
                }
                if (faceLoginModel2 == null) {
                    faceLoginModel2 = convertResult2Model(shareStorage.getSd(MD5Util.toMd5(KEY_SHARE_FACE_LOGIN.getBytes(), false)));
                }
                if (faceLoginModel2 != null || faceLoginModel != null) {
                    if ((faceLoginModel == null || faceLoginModel2 != null) && (faceLoginModel == null || faceLoginModel2 == null || !TextUtils.isEmpty(faceLoginModel2.faceCheckStr))) {
                        faceLoginModel = faceLoginModel2;
                    }
                    SapiContext.getInstance(context).setFaceLoginUid(faceLoginModel.livingUid);
                    String a2 = a(faceLoginModel);
                    SapiContext.getInstance(context).setFaceLoginModel(a2);
                    syncShareFaceLoginModel(a2);
                    if (TextUtils.isEmpty(faceLoginModel.faceCheckStr)) {
                        SapiAccountManager.getInstance().getAccountService().faceLoginEnable(context);
                    }
                }
            }
        }
    }

    public FaceLoginModel convertResult2Model(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            FaceLoginModel fromJSON = FaceLoginModel.fromJSON(new JSONObject(str));
            if (TextUtils.isEmpty(fromJSON.livingUid) || !fromJSON.cuid.equals(SapiUtils.getClientId(this.context))) {
                return null;
            }
            if (TextUtils.isEmpty(fromJSON.faceCheckStr)) {
                return fromJSON;
            }
            if ((((System.currentTimeMillis() - fromJSON.faceLoginCheckTime) / 1000) / 60) / 60 > SapiContext.getInstance(this.context).getFaceLoginCheckFreq() || fromJSON.getFaceCheckErrno() != 0) {
                fromJSON.faceCheckStr = "";
                fromJSON.faceLoginCheckTime = 0L;
                return fromJSON;
            }
            return fromJSON;
        } catch (JSONException e) {
            return null;
        }
    }

    private String a(String str) {
        if (SapiContext.getInstance(this.context).shareLivingunameEnable()) {
            try {
                return a(FaceLoginModel.fromJSON(new JSONObject(str)));
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    private String a(FaceLoginModel faceLoginModel) {
        if (!SapiContext.getInstance(this.context).shareLivingunameEnable()) {
            return null;
        }
        if (!SapiContext.getInstance(this.context).getShareFaceLoginEnable()) {
            faceLoginModel.faceCheckStr = "";
            faceLoginModel.faceLoginCheckTime = 0L;
        }
        return faceLoginModel.toJSON().toString();
    }

    public String getFaceLoginHash() {
        String faceLoginModel = SapiContext.getInstance(this.context).getFaceLoginModel();
        if (TextUtils.isEmpty(faceLoginModel)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(faceLoginModel).optString(FaceLoginModel.FACE_LOGIN_CHECK_RESUTL));
            String optString = jSONObject.optString(FaceLoginModel.DISPLAY_NAME);
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null && session.displayname.equals(optString)) {
                return "";
            }
            return jSONObject.optString("type");
        } catch (JSONException e) {
            return "";
        }
    }

    public void saveFaceLoginCheckResult(String str, String str2) {
        FaceLoginModel faceLoginModel = new FaceLoginModel();
        faceLoginModel.cuid = SapiUtils.getClientId(this.context);
        faceLoginModel.faceCheckStr = str2;
        faceLoginModel.faceLoginCheckTime = System.currentTimeMillis();
        faceLoginModel.livingUid = str;
        if (SapiAccountManager.getInstance().isLogin()) {
            faceLoginModel.displayName = SapiAccountManager.getInstance().getSession().displayname;
        }
        SapiContext.getInstance(this.context).setFaceLoginModel(faceLoginModel.toJSON().toString());
        new FaceLoginService().syncShareFaceLoginModel(faceLoginModel.toJSON().toString());
    }
}
