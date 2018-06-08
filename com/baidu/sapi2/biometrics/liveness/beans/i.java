package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.DebugConfig;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.sapi2.biometrics.liveness.datamodel.UploadVideoModel;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends UploadBean {
    private String a;
    private String b;
    private String c;
    private LivenessRecogDTO d;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public i(Context context) {
        super(context);
        this.c = RimGlobalUtils.getZid(context.getApplicationContext());
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        this.d = (LivenessRecogDTO) b.a().a(b.a);
        if (this.d != null && this.files != null && this.files.get(0) != null && this.files.get(0).filedata != null) {
            setSpParameter(this.d.spParams);
            arrayList.add(new RestNameValuePair("processid", this.d.processid));
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
            arrayList.add(new RestNameValuePair("service_type", this.d.serviceType));
            arrayList.add(new RestNameValuePair("type", "video"));
        }
        arrayList.add(new RestNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        if (!TextUtils.isEmpty(this.c)) {
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
        return DebugConfig.getInstance(this.mContext).getRimHttpsHost() + d.o;
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
        if (this.d != null) {
            sb.append("bduss=" + this.d.bduss);
            sb.append(";stoken=" + this.d.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
