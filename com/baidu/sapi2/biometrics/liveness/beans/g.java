package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.core.DebugConfig;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends a {
    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) b.a().a(b.a);
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", livenessRecogDTO.processid));
        }
        arrayList.add(new RestNameValuePair("atbc", a()));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return DebugConfig.getInstance(this.mContext).getRimHttpsHost() + d.r;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean, com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public boolean needNonce() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        return true;
    }
}
