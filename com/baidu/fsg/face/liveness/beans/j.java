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
import com.baidu.fsg.face.liveness.datamodel.UploadContrastPortraitModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j extends l {

    /* renamed from: b  reason: collision with root package name */
    public String f5942b;

    /* renamed from: c  reason: collision with root package name */
    public String f5943c;

    /* renamed from: d  reason: collision with root package name */
    public String f5944d;

    /* renamed from: e  reason: collision with root package name */
    public String f5945e;

    /* renamed from: f  reason: collision with root package name */
    public String f5946f;

    /* renamed from: g  reason: collision with root package name */
    public String f5947g;

    /* renamed from: h  reason: collision with root package name */
    public LivenessRecogDTO f5948h;

    public j(Context context) {
        super(context);
        this.f5945e = "1";
        String zid2 = RimGlobalUtils.getZid2();
        this.f5944d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5943c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        this.f5947g = str;
    }

    public void b(String str) {
        this.f5942b = str;
    }

    public void c(String str) {
        this.f5946f = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(UploadContrastPortraitModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f5948h;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f5948h.processid));
            LivenessRecogType livenessRecogType = this.f5948h.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f5948h.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f5948h.realName);
                    jSONObject.put("cert", this.f5948h.idCardNum);
                    jSONObject.put("bankmobile", this.f5948h.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f5948h.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f5948h.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5948h.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        arrayList.add(new RestNameValuePair("imgdigests", this.f5942b));
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f5955a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        if (!TextUtils.isEmpty(this.f5944d)) {
            arrayList.add(new RestNameValuePair("zid2", this.f5944d));
        } else if (!TextUtils.isEmpty(this.f5943c)) {
            arrayList.add(new RestNameValuePair("zid", this.f5943c));
        }
        arrayList.add(new RestNameValuePair("last", this.f5945e));
        if (!TextUtils.isEmpty(this.f5946f)) {
            arrayList.add(new RestNameValuePair("callbackkey", this.f5946f));
        }
        if (!TextUtils.isEmpty(this.f5947g)) {
            arrayList.add(new RestNameValuePair("need_confirm", this.f5947g));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 5;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.m;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return UploadContrastPortraitModel.class;
    }

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.f5948h = livenessRecogDTO;
    }

    public void a(boolean z) {
        this.f5945e = z ? "1" : "0";
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5948h != null) {
            sb.append("bduss=" + this.f5948h.bduss);
            sb.append(";stoken=" + this.f5948h.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
