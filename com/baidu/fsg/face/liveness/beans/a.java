package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.face.liveness.datamodel.AudioVideoUploadModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends UploadBean {

    /* renamed from: a  reason: collision with root package name */
    private String f2316a;

    /* renamed from: b  reason: collision with root package name */
    private String f2317b;
    private String c;
    private String d;
    private String e;
    private LivenessRecogDTO f;

    public void a(String str) {
        this.f2316a = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public a(Context context) {
        super(context, 1);
        this.d = RimGlobalUtils.getZid2();
        if (TextUtils.isEmpty(this.d)) {
            this.c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        this.f = (LivenessRecogDTO) c.a().a("request_data");
        if (this.f != null && this.files != null && this.files.get(0) != null && this.files.get(0).filedata != null) {
            setSpParameter(this.f.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f.processid));
            if (!TextUtils.isEmpty(this.f2317b)) {
                arrayList.add(new RestNameValuePair("image_callbackkey", this.f2317b));
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
            arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f.serviceType));
            if (this.f.livenessType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "bduss"));
                arrayList.add(new RestNameValuePair("atbc", a()));
            } else if (this.f.livenessType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f.realName);
                    jSONObject.put("cert", this.f.idCardNum);
                    jSONObject.put("bankmobile", this.f.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (this.f.livenessType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f.authToken));
            } else if (this.f.livenessType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f.exUid));
            }
        }
        arrayList.add(new RestNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        if (!TextUtils.isEmpty(this.d)) {
            arrayList.add(new RestNameValuePair("zid2", this.d));
        } else if (!TextUtils.isEmpty(this.c)) {
            arrayList.add(new RestNameValuePair("zid", this.c));
        }
        if (!TextUtils.isEmpty(this.f2316a)) {
            arrayList.add(new RestNameValuePair("audioStartTime", "0"));
        }
        if (!TextUtils.isEmpty(this.e)) {
            arrayList.add(new RestNameValuePair("shouldCollectPicture", this.e));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 11;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.w;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(AudioVideoUploadModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return AudioVideoUploadModel.class;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        return true;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append("bduss=" + this.f.bduss);
            sb.append(";stoken=" + this.f.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
