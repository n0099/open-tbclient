package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.core.DebugConfig;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import com.baidu.sapi2.biometrics.liveness.utils.enums.LivenessRecogType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends a {
    private static final String a = "bduss";
    private static final String b = "certinfo";
    private static final String c = "authtoken";
    private static final String d = "outer";

    public e(Context context) {
        super(context);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) b.a().a(b.a);
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", livenessRecogDTO.processid));
            if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("atbc", a()));
                arrayList.add(new RestNameValuePair("type", "bduss"));
            } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", livenessRecogDTO.realName);
                    jSONObject.put("cert", livenessRecogDTO.idCardNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, jSONObject.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("authtoken", livenessRecogDTO.authToken));
                arrayList.add(new RestNameValuePair("type", "authtoken"));
            } else if (livenessRecogDTO.livenessType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("exuid", livenessRecogDTO.exUid));
                arrayList.add(new RestNameValuePair("type", d));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 2;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return DebugConfig.getInstance(this.mContext).getRimHttpsHost() + d.p;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        return true;
    }
}
