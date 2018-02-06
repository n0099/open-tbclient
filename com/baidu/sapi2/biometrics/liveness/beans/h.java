package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.DebugConfig;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.biometrics.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends UploadBean {
    private String a;
    private String b;
    private String c;
    private LivenessRecogDTO d;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public h(Context context) {
        super(context);
        this.c = RimGlobalUtils.getZid(context.getApplicationContext());
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        this.d = (LivenessRecogDTO) b.a().a(b.a);
        if (this.d != null) {
            setSpParameter(this.d.spParams);
            arrayList.add(new RestNameValuePair("processid", this.d.processid));
            if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair("atbc", a()));
            } else if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", BiometricsManager.LIVENESS_RECOGNIZE_TYPE_CERTINFO));
                arrayList.add(new RestNameValuePair("exuid", this.d.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.d.realName);
                    jSONObject.put("cert", this.d.idCardNum);
                    jSONObject.put("bankmobile", this.d.phoneNum);
                    arrayList.add(new RestNameValuePair(BiometricsManager.LIVENESS_RECOGNIZE_TYPE_CERTINFO, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, jSONObject.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", BiometricsManager.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN));
                arrayList.add(new RestNameValuePair(BiometricsManager.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN, this.d.authToken));
            } else if (this.d.livenessType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.d.exUid));
            }
        }
        arrayList.add(new RestNameValuePair("imgdigests", this.b));
        arrayList.add(new RestNameValuePair("service_type", this.a));
        if (!TextUtils.isEmpty(this.c)) {
            arrayList.add(new RestNameValuePair("zid", this.c));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 5;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return DebugConfig.getInstance(this.mContext).getRimHttpsHost() + d.m;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(UploadContrastPortraitModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return UploadContrastPortraitModel.class;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        return true;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append("bduss=" + this.d.bduss);
            sb.append(";stoken=" + this.d.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
