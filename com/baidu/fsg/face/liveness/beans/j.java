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
    public String f5902b;

    /* renamed from: c  reason: collision with root package name */
    public String f5903c;

    /* renamed from: d  reason: collision with root package name */
    public String f5904d;

    /* renamed from: e  reason: collision with root package name */
    public String f5905e;

    /* renamed from: f  reason: collision with root package name */
    public String f5906f;

    /* renamed from: g  reason: collision with root package name */
    public String f5907g;

    /* renamed from: h  reason: collision with root package name */
    public LivenessRecogDTO f5908h;

    public j(Context context) {
        super(context);
        this.f5905e = "1";
        String zid2 = RimGlobalUtils.getZid2();
        this.f5904d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5903c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        this.f5907g = str;
    }

    public void b(String str) {
        this.f5902b = str;
    }

    public void c(String str) {
        this.f5906f = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(UploadContrastPortraitModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = this.f5908h;
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f5908h.processid));
            LivenessRecogType livenessRecogType = this.f5908h.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f5908h.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f5908h.realName);
                    jSONObject.put("cert", this.f5908h.idCardNum);
                    jSONObject.put("bankmobile", this.f5908h.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f5908h.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f5908h.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5908h.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        arrayList.add(new RestNameValuePair("imgdigests", this.f5902b));
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f5915a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        if (!TextUtils.isEmpty(this.f5904d)) {
            arrayList.add(new RestNameValuePair("zid2", this.f5904d));
        } else if (!TextUtils.isEmpty(this.f5903c)) {
            arrayList.add(new RestNameValuePair("zid", this.f5903c));
        }
        arrayList.add(new RestNameValuePair("last", this.f5905e));
        if (!TextUtils.isEmpty(this.f5906f)) {
            arrayList.add(new RestNameValuePair("callbackkey", this.f5906f));
        }
        if (!TextUtils.isEmpty(this.f5907g)) {
            arrayList.add(new RestNameValuePair("need_confirm", this.f5907g));
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
        this.f5908h = livenessRecogDTO;
    }

    public void a(boolean z) {
        this.f5905e = z ? "1" : "0";
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5908h != null) {
            sb.append("bduss=" + this.f5908h.bduss);
            sb.append(";stoken=" + this.f5908h.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
