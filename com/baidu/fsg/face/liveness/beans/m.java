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
import com.baidu.fsg.face.liveness.datamodel.UploadVideoModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import com.baidu.live.tbadk.log.LogConfig;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class m extends UploadBean {

    /* renamed from: a  reason: collision with root package name */
    private String f2331a;

    /* renamed from: b  reason: collision with root package name */
    private String f2332b;
    private String c;
    private String d;
    private String e;
    private String f;
    private LivenessRecogDTO g;

    public void a(String str) {
        this.f = str;
    }

    public void b(String str) {
        this.f2332b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.f2331a = str;
    }

    public m(Context context) {
        super(context);
        this.e = RimGlobalUtils.getZid2();
        if (TextUtils.isEmpty(this.e)) {
            this.d = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        this.g = (LivenessRecogDTO) c.a().a("request_data");
        if (this.g != null && this.files != null && this.files.get(0) != null && this.files.get(0).filedata != null) {
            setSpParameter(this.g.spParams);
            if (!TextUtils.isEmpty(this.g.processid)) {
                arrayList.add(new RestNameValuePair("processid", this.g.processid));
            }
            if (!TextUtils.isEmpty(a())) {
                arrayList.add(new RestNameValuePair("atbc", a()));
            }
            if (!TextUtils.isEmpty(this.f2331a)) {
                arrayList.add(new RestNameValuePair(LogConfig.LOG_VIDEO_TYPE, this.f2331a));
            }
            if (!TextUtils.isEmpty(this.f2332b)) {
                arrayList.add(new RestNameValuePair("callbackkey", this.f2332b));
            }
            if (!TextUtils.isEmpty(this.c)) {
                arrayList.add(new RestNameValuePair("image_callbackkey", this.c));
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
            arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(this.g.serviceType)) {
                arrayList.add(new RestNameValuePair(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, this.g.serviceType));
            }
            arrayList.add(new RestNameValuePair("type", "video"));
        }
        arrayList.add(new RestNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        if (!TextUtils.isEmpty(this.e)) {
            arrayList.add(new RestNameValuePair("zid2", this.e));
        } else if (!TextUtils.isEmpty(this.d)) {
            arrayList.add(new RestNameValuePair("zid", this.d));
        }
        if (!TextUtils.isEmpty(this.f)) {
            arrayList.add(new RestNameValuePair("need_confirm", this.f));
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

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(UploadVideoModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return UploadVideoModel.class;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
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
