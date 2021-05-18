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
    public int f5941a;

    /* renamed from: b  reason: collision with root package name */
    public int f5942b;

    /* renamed from: c  reason: collision with root package name */
    public LivenessRecogDTO f5943c;

    public d(Context context) {
        super(context);
    }

    public void a(int i2) {
        this.f5941a = i2;
    }

    public void b(int i2) {
        this.f5942b = i2;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f5943c;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f5943c.processid));
            LivenessRecogType livenessRecogType = this.f5943c.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f5943c.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f5943c.realName);
                    jSONObject.put("cert", this.f5943c.idCardNum);
                    jSONObject.put("bankmobile", this.f5943c.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f5943c.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f5943c.exUid));
            }
            arrayList.add(new RestNameValuePair("opt", String.valueOf(this.f5941a)));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5943c.serviceType));
            arrayList.add(new RestNameValuePair("living_type", String.valueOf(this.f5942b)));
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
        this.f5943c = livenessRecogDTO;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5943c != null) {
            sb.append("bduss=" + this.f5943c.bduss);
            sb.append(";stoken=" + this.f5943c.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
