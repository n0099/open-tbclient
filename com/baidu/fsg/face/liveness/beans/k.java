package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.RandomUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.utils.SafeUtils;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends l {

    /* renamed from: b  reason: collision with root package name */
    public String f6112b;

    /* renamed from: c  reason: collision with root package name */
    public String f6113c;

    /* renamed from: d  reason: collision with root package name */
    public String f6114d;

    /* renamed from: e  reason: collision with root package name */
    public String f6115e;

    /* renamed from: f  reason: collision with root package name */
    public String f6116f;

    /* renamed from: g  reason: collision with root package name */
    public LivenessRecogDTO f6117g;

    public k(Context context) {
        super(context);
        String zid2 = RimGlobalUtils.getZid2();
        this.f6113c = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f6112b = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.f6117g = livenessRecogDTO;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f6117g;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f6117g.processid));
            LivenessRecogType livenessRecogType = this.f6117g.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f6117g.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f6117g.realName);
                    jSONObject.put("cert", this.f6117g.idCardNum);
                    jSONObject.put("bankmobile", this.f6117g.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f6117g.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f6117g.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f6117g.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f6118a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        if (!TextUtils.isEmpty(this.f6113c)) {
            arrayList.add(new RestNameValuePair("zid2", this.f6113c));
        } else if (!TextUtils.isEmpty(this.f6112b)) {
            arrayList.add(new RestNameValuePair("zid", this.f6112b));
        }
        arrayList.add(new RestNameValuePair("report_type", this.f6114d));
        if (!TextUtils.isEmpty(this.f6115e)) {
            arrayList.add(new RestNameValuePair("naSeq", this.f6115e));
        }
        if (!TextUtils.isEmpty(this.f6116f)) {
            arrayList.add(new RestNameValuePair("idlSeq", this.f6116f));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 12;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.x;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }

    public void a(String str) {
        this.f6114d = str;
    }

    public void a(String str, String str2) {
        this.f6115e = str;
        this.f6116f = str2;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f6117g != null) {
            sb.append("bduss=" + this.f6117g.bduss);
            sb.append(";stoken=" + this.f6117g.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
