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
import com.baidu.fsg.face.liveness.datamodel.UploadVideoModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.wallet.core.beans.NetworkBean;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class m extends UploadBean {

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
    public String f5878f;

    /* renamed from: g  reason: collision with root package name */
    public LivenessRecogDTO f5879g;

    public m(Context context) {
        super(context);
        String zid2 = RimGlobalUtils.getZid2();
        this.f5877e = zid2;
        if (TextUtils.isEmpty(zid2)) {
            this.f5876d = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    public void a(String str) {
        this.f5878f = str;
    }

    public void b(String str) {
        this.f5874b = str;
    }

    public void c(String str) {
        this.f5875c = str;
    }

    public void d(String str) {
        this.f5873a = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(UploadVideoModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        List<UploadBean.UploadFileModel> list;
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
        this.f5879g = livenessRecogDTO;
        if (livenessRecogDTO != null && (list = this.files) != null && list.get(0) != null && this.files.get(0).filedata != null) {
            setSpParameter(this.f5879g.spParams);
            if (!TextUtils.isEmpty(this.f5879g.processid)) {
                arrayList.add(new RestNameValuePair("processid", this.f5879g.processid));
            }
            if (!TextUtils.isEmpty(a())) {
                arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, a()));
            }
            if (!TextUtils.isEmpty(this.f5873a)) {
                arrayList.add(new RestNameValuePair("video_type", this.f5873a));
            }
            if (!TextUtils.isEmpty(this.f5874b)) {
                arrayList.add(new RestNameValuePair("callbackkey", this.f5874b));
            }
            if (!TextUtils.isEmpty(this.f5875c)) {
                arrayList.add(new RestNameValuePair("image_callbackkey", this.f5875c));
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
            arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(this.f5879g.serviceType)) {
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.f5879g.serviceType));
            }
            arrayList.add(new RestNameValuePair("type", "video"));
        }
        arrayList.add(new RestNameValuePair("client", "android"));
        if (!TextUtils.isEmpty(this.f5877e)) {
            arrayList.add(new RestNameValuePair("zid2", this.f5877e));
        } else if (!TextUtils.isEmpty(this.f5876d)) {
            arrayList.add(new RestNameValuePair("zid", this.f5876d));
        }
        if (!TextUtils.isEmpty(this.f5878f)) {
            arrayList.add(new RestNameValuePair("need_confirm", this.f5878f));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 7;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.o;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return UploadVideoModel.class;
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5879g != null) {
            sb.append("bduss=" + this.f5879g.bduss);
            sb.append(";stoken=" + this.f5879g.stoken);
        }
        return PayUtils.encrypt("phone_number", sb.toString());
    }
}
