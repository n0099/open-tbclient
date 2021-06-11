package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.face.liveness.datamodel.AudioVideoUploadModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends UploadBean {

    /* renamed from: a  reason: collision with root package name */
    public String f5873a;

    /* renamed from: b  reason: collision with root package name */
    public String f5874b;

    /* renamed from: c  reason: collision with root package name */
    public String f5875c;

    /* renamed from: d  reason: collision with root package name */
    public String f5876d;

    /* renamed from: e  reason: collision with root package name */
    public String f5877e;

    /* renamed from: f  reason: collision with root package name */
    public LivenessRecogDTO f5878f;

    public a(Context context) {
        super(context, 1);
        String zid2 = RimGlobalUtils.getZid2();
        this.f5876d = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5875c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        this.f5873a = str;
    }

    public void b(String str) {
        this.f5877e = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(AudioVideoUploadModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        List<UploadBean.UploadFileModel> list;
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
        this.f5878f = livenessRecogDTO;
        if (livenessRecogDTO != null && (list = this.files) != null && list.get(0) != null && this.files.get(0).filedata != null) {
            setSpParameter(this.f5878f.spParams);
            arrayList.add(new RestNameValuePair("processid", this.f5878f.processid));
            if (!TextUtils.isEmpty(this.f5874b)) {
                arrayList.add(new RestNameValuePair("image_callbackkey", this.f5874b));
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
            arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5878f.serviceType));
            LivenessRecogType livenessRecogType = this.f5878f.livenessType;
            if (livenessRecogType == LivenessRecogType.RECOG_TYPE_BDUSS) {
                arrayList.add(new RestNameValuePair("type", "bduss"));
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_CERTINFO) {
                arrayList.add(new RestNameValuePair("type", "certinfo"));
                arrayList.add(new RestNameValuePair("exuid", this.f5878f.exUid));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("name", this.f5878f.realName);
                    jSONObject.put("cert", this.f5878f.idCardNum);
                    jSONObject.put("bankmobile", this.f5878f.phoneNum);
                    arrayList.add(new RestNameValuePair("certinfo", PayUtils.encrypt("phone_number", jSONObject.toString())));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_AUTHTOKEN) {
                arrayList.add(new RestNameValuePair("type", "authtoken"));
                arrayList.add(new RestNameValuePair("authtoken", this.f5878f.authToken));
            } else if (livenessRecogType == LivenessRecogType.RECOG_TYPE_OUTER) {
                arrayList.add(new RestNameValuePair("type", "outer"));
                arrayList.add(new RestNameValuePair("exuid", this.f5878f.exUid));
            }
        }
        arrayList.add(new RestNameValuePair("client", "android"));
        if (!TextUtils.isEmpty(this.f5876d)) {
            arrayList.add(new RestNameValuePair("zid2", this.f5876d));
        } else if (!TextUtils.isEmpty(this.f5875c)) {
            arrayList.add(new RestNameValuePair("zid", this.f5875c));
        }
        if (!TextUtils.isEmpty(this.f5873a)) {
            arrayList.add(new RestNameValuePair("audioStartTime", "0"));
        }
        if (!TextUtils.isEmpty(this.f5877e)) {
            arrayList.add(new RestNameValuePair("shouldCollectPicture", this.f5877e));
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

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return AudioVideoUploadModel.class;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5878f != null) {
            sb.append("bduss=" + this.f5878f.bduss);
            sb.append(";stoken=" + this.f5878f.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
