package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.face.liveness.datamodel.GetRecordVedioQuestionModel;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class h extends b {
    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", livenessRecogDTO.processid));
        }
        arrayList.add(new RestNameValuePair("atbc", a()));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 6;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.r;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(GetRecordVedioQuestionModel.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return GetRecordVedioQuestionModel.class;
    }
}
