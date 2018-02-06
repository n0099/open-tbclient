package com.baidu.sapi2.biometrics.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.sapi2.biometrics.liveness.dto.LivenessRecogDTO;
/* loaded from: classes2.dex */
public abstract class a extends BaseBean {
    public a(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        StringBuilder sb = new StringBuilder();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) b.a().a(b.a);
        if (livenessRecogDTO != null) {
            sb.append("bduss=" + livenessRecogDTO.bduss);
            sb.append(";stoken=" + livenessRecogDTO.stoken);
        }
        return PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, sb.toString());
    }
}
