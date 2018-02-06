package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.UploadBean;
import com.baidu.fsg.base.restnet.beans.business.core.DebugConfig;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends UploadBean {
    private String a;

    public void a(String str) {
        this.a = str;
    }

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) b.a().a(b.a);
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", livenessRecogDTO.processid));
            arrayList.add(new RestNameValuePair("exuid", livenessRecogDTO.exUid));
        }
        arrayList.add(new RestNameValuePair("imgdigests", this.a));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 8;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return DebugConfig.getInstance(this.mContext).getRimHttpsHost() + d.n;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.UploadBean
    public boolean needCheckClientSign() {
        return true;
    }
}
