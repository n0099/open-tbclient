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
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class d extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    private int f1712a;
    private int b;
    private LivenessRecogDTO c;

    public d(Context context) {
        super(context);
    }

    public void a(int i) {
        this.f1712a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.c = livenessRecogDTO;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.c != null) {
            setSpParameter(this.c.spParams);
            arrayList.add(new RestNameValuePair("processid", this.c.processid));
            if (this.c.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair("atbc", a()));
            } else if (this.c.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.c.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.c.realName);
                    jSONObject.put("cert", this.c.idCardNum);
                    jSONObject.put("bankmobile", this.c.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, jSONObject.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.c.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.c.authToken));
            } else if (this.c.livenessType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.c.exUid));
            }
            arrayList.add(new RestNameValuePair(UgcConstant.UGC_TAG_OPTION, String.valueOf(this.f1712a)));
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.c.serviceType));
            arrayList.add(new RestNameValuePair("living_type", String.valueOf(this.b)));
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

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.c != null) {
            sb.append("bduss=" + this.c.bduss);
            sb.append(";stoken=" + this.c.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
