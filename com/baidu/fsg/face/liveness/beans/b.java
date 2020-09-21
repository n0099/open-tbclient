package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
/* loaded from: classes16.dex */
public abstract class b extends BaseBean {
    public b(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        StringBuilder sb = new StringBuilder();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
        if (livenessRecogDTO != null) {
            sb.append("bduss=" + livenessRecogDTO.bduss);
            sb.append(";stoken=" + livenessRecogDTO.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
