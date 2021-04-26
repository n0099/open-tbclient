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
    public String f6105b;

    /* renamed from: c  reason: collision with root package name */
    public String f6106c;

    /* renamed from: d  reason: collision with root package name */
    public String f6107d;

    /* renamed from: e  reason: collision with root package name */
    public String f6108e;

    /* renamed from: f  reason: collision with root package name */
    public String f6109f;

    /* renamed from: g  reason: collision with root package name */
    public String f6110g;

    /* renamed from: h  reason: collision with root package name */
    public LivenessRecogDTO f6111h;

    public j(Context context) {
        super(context);
        this.f6108e = "1";
        String zid2 = RimGlobalUtils.getZid2();
        this.f6107d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f6106c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        this.f6110g = str;
    }

    public void b(String str) {
        this.f6105b = str;
    }

    public void c(String str) {
        this.f6109f = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(UploadContrastPortraitModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f6111h;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f6111h.processid));
            LivenessRecogType livenessRecogType = this.f6111h.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f6111h.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f6111h.realName);
                    jSONObject.put("cert", this.f6111h.idCardNum);
                    jSONObject.put("bankmobile", this.f6111h.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f6111h.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f6111h.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f6111h.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        arrayList.add(new RestNameValuePair("imgdigests", this.f6105b));
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f6118a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        if (!TextUtils.isEmpty(this.f6107d)) {
            arrayList.add(new RestNameValuePair("zid2", this.f6107d));
        } else if (!TextUtils.isEmpty(this.f6106c)) {
            arrayList.add(new RestNameValuePair("zid", this.f6106c));
        }
        arrayList.add(new RestNameValuePair("last", this.f6108e));
        if (!TextUtils.isEmpty(this.f6109f)) {
            arrayList.add(new RestNameValuePair("callbackkey", this.f6109f));
        }
        if (!TextUtils.isEmpty(this.f6110g)) {
            arrayList.add(new RestNameValuePair("need_confirm", this.f6110g));
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
        this.f6111h = livenessRecogDTO;
    }

    public void a(boolean z) {
        this.f6108e = z ? "1" : "0";
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f6111h != null) {
            sb.append("bduss=" + this.f6111h.bduss);
            sb.append(";stoken=" + this.f6111h.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
