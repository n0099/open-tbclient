package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.face.liveness.datamodel.ConfirmModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.wallet.core.beans.NetworkBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    public int f6087a;

    /* renamed from: b  reason: collision with root package name */
    public int f6088b;

    /* renamed from: c  reason: collision with root package name */
    public LivenessRecogDTO f6089c;

    public d(Context context) {
        super(context);
    }

    public void a(int i2) {
        this.f6087a = i2;
    }

    public void b(int i2) {
        this.f6088b = i2;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f6089c;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f6089c.processid));
            LivenessRecogType livenessRecogType = this.f6089c.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f6089c.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f6089c.realName);
                    jSONObject.put("cert", this.f6089c.idCardNum);
                    jSONObject.put("bankmobile", this.f6089c.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f6089c.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f6089c.exUid));
            }
            arrayList.add(new RestNameValuePair("opt", String.valueOf(this.f6087a)));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f6089c.serviceType));
            arrayList.add(new RestNameValuePair("living_type", String.valueOf(this.f6088b)));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 13;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.p;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return ConfirmModel.class;
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.f6089c = livenessRecogDTO;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f6089c != null) {
            sb.append("bduss=" + this.f6089c.bduss);
            sb.append(";stoken=" + this.f6089c.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
