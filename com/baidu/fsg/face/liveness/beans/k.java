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
    public String f5966b;

    /* renamed from: c  reason: collision with root package name */
    public String f5967c;

    /* renamed from: d  reason: collision with root package name */
    public String f5968d;

    /* renamed from: e  reason: collision with root package name */
    public String f5969e;

    /* renamed from: f  reason: collision with root package name */
    public String f5970f;

    /* renamed from: g  reason: collision with root package name */
    public LivenessRecogDTO f5971g;

    public k(Context context) {
        super(context);
        String zid2 = RimGlobalUtils.getZid2();
        this.f5967c = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5966b = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.f5971g = livenessRecogDTO;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f5971g;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f5971g.processid));
            LivenessRecogType livenessRecogType = this.f5971g.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f5971g.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f5971g.realName);
                    jSONObject.put("cert", this.f5971g.idCardNum);
                    jSONObject.put("bankmobile", this.f5971g.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f5971g.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f5971g.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5971g.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f5972a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        if (!TextUtils.isEmpty(this.f5967c)) {
            arrayList.add(new RestNameValuePair("zid2", this.f5967c));
        } else if (!TextUtils.isEmpty(this.f5966b)) {
            arrayList.add(new RestNameValuePair("zid", this.f5966b));
        }
        arrayList.add(new RestNameValuePair("report_type", this.f5968d));
        if (!TextUtils.isEmpty(this.f5969e)) {
            arrayList.add(new RestNameValuePair("naSeq", this.f5969e));
        }
        if (!TextUtils.isEmpty(this.f5970f)) {
            arrayList.add(new RestNameValuePair("idlSeq", this.f5970f));
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
        this.f5968d = str;
    }

    public void a(String str, String str2) {
        this.f5969e = str;
        this.f5970f = str2;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5971g != null) {
            sb.append("bduss=" + this.f5971g.bduss);
            sb.append(";stoken=" + this.f5971g.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
