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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends k {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private LivenessRecogDTO g;

    public void a(LivenessRecogDTO livenessRecogDTO) {
        this.g = livenessRecogDTO;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(String str, String str2) {
        this.e = str;
        this.f = str2;
    }

    public j(Context context) {
        super(context);
        this.c = RimGlobalUtils.getZid2();
        if (TextUtils.isEmpty(this.c)) {
            this.b = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (this.g != null) {
            setSpParameter(this.g.spParams);
            arrayList.add(new RestNameValuePair("processid", this.g.processid));
            if (this.g.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "contrastportrait"));
                arrayList.add(new RestNameValuePair("atbc", a()));
            } else if (this.g.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.g.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.g.realName);
                    jSONObject.put("cert", this.g.idCardNum);
                    jSONObject.put("bankmobile", this.g.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, jSONObject.toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.g.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.g.authToken));
            } else if (this.g.livenessType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.g.exUid));
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.g.serviceType));
        }
        String randomString = RandomUtils.getRandomString(4096);
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        if (!TextUtils.isEmpty(this.c)) {
            arrayList.add(new RestNameValuePair("zid2", this.c));
        } else if (!TextUtils.isEmpty(this.b)) {
            arrayList.add(new RestNameValuePair("zid", this.b));
        }
        arrayList.add(new RestNameValuePair("report_type", this.d));
        if (!TextUtils.isEmpty(this.e)) {
            arrayList.add(new RestNameValuePair("naSeq", this.e));
        }
        if (!TextUtils.isEmpty(this.f)) {
            arrayList.add(new RestNameValuePair("idlSeq", this.f));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 12;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + e.w;
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

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append("bduss=" + this.g.bduss);
            sb.append(";stoken=" + this.g.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
