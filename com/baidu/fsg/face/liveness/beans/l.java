package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.face.liveness.datamodel.UploadVideoModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends UploadBean {
    private String a;
    private String b;
    private String c;
    private String d;
    private LivenessRecogDTO e;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public l(Context context) {
        super(context);
        this.d = RimGlobalUtils.getZid2();
        if (TextUtils.isEmpty(this.d)) {
            this.c = RimGlobalUtils.getZid(context.getApplicationContext());
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        this.e = (LivenessRecogDTO) c.a().a(c.a);
        if (this.e != null && this.files != null && this.files.get(0) != null && this.files.get(0).filedata != null) {
            setSpParameter(this.e.spParams);
            arrayList.add(new RestNameValuePair("processid", this.e.processid));
            arrayList.add(new RestNameValuePair("atbc", a()));
            arrayList.add(new RestNameValuePair("callbackkey", this.a));
            if (!TextUtils.isEmpty(this.b)) {
                arrayList.add(new RestNameValuePair("image_callbackkey", this.b));
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.files.get(0).filedata);
            arrayList.add(new RestNameValuePair("videomd5", Md5Utils.getMd5FromInputStream(byteArrayInputStream)));
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            arrayList.add(new RestNameValuePair("service_type", this.e.serviceType));
            arrayList.add(new RestNameValuePair("type", "video"));
        }
        arrayList.add(new RestNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        if (!TextUtils.isEmpty(this.d)) {
            arrayList.add(new RestNameValuePair("zid2", this.d));
        } else if (!TextUtils.isEmpty(this.c)) {
            arrayList.add(new RestNameValuePair("zid", this.c));
        }
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 7;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + e.o;
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
        if (this.e != null) {
            sb.append("bduss=" + this.e.bduss);
            sb.append(";stoken=" + this.e.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
