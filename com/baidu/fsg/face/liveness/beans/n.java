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
import com.baidu.fsg.face.liveness.datamodel.VideoFaceMatchModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n extends l {

    /* renamed from: b  reason: collision with root package name */
    public String f5963b;

    /* renamed from: c  reason: collision with root package name */
    public String f5964c;

    /* renamed from: d  reason: collision with root package name */
    public String f5965d;

    /* renamed from: e  reason: collision with root package name */
    public String f5966e;

    /* renamed from: f  reason: collision with root package name */
    public LivenessRecogDTO f5967f;

    public n(Context context) {
        super(context);
        String zid2 = RimGlobalUtils.getZid2();
        this.f5965d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5964c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.f5967f = livenessRecogDTO;
    }

    public void b(String str) {
        this.f5966e = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(VideoFaceMatchModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f5967f;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f5967f.processid));
            LivenessRecogType livenessRecogType = this.f5967f.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "bduss"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f5967f.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f5967f.realName);
                    jSONObject.put("cert", this.f5967f.idCardNum);
                    jSONObject.put("bankmobile", this.f5967f.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f5967f.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f5967f.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5967f.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f5955a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("imgdigests", this.f5963b));
        if (!TextUtils.isEmpty(this.f5965d)) {
            arrayList.add(new RestNameValuePair("zid2", this.f5965d));
        } else if (!TextUtils.isEmpty(this.f5964c)) {
            arrayList.add(new RestNameValuePair("zid", this.f5964c));
        }
        if (!TextUtils.isEmpty(this.f5966e)) {
            arrayList.add(new RestNameValuePair("reqTimes", this.f5966e));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 10;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.v;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return VideoFaceMatchModel.class;
    }

    public void a(String str) {
        this.f5963b = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5967f != null) {
            sb.append("bduss=" + this.f5967f.bduss);
            sb.append(";stoken=" + this.f5967f.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
