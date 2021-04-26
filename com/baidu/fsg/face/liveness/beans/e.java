package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.RandomUtils;
import com.baidu.fsg.base.utils.SafeUtils;
import com.baidu.fsg.face.liveness.dto.LivenessRecogDTO;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends l {

    /* renamed from: b  reason: collision with root package name */
    public String f6090b;

    /* renamed from: c  reason: collision with root package name */
    public String f6091c;

    public e(Context context) {
        super(context);
        this.f6091c = "1";
    }

    public void a(String str) {
        this.f6090b = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        LivenessRecogDTO livenessRecogDTO = (LivenessRecogDTO) c.a().a("request_data");
        if (livenessRecogDTO != null) {
            setSpParameter(livenessRecogDTO.spParams);
            arrayList.add(new RestNameValuePair("processid", livenessRecogDTO.processid));
            arrayList.add(new RestNameValuePair("exuid", livenessRecogDTO.exUid));
        }
        arrayList.add(new RestNameValuePair("imgdigests", this.f6090b));
        String randomString = RandomUtils.getRandomString(4096);
        try {
            arrayList.add(new RestNameValuePair("image", Base64Utils.encodeToString(SafeUtils.xor(this.f6118a, randomString).getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        arrayList.add(new RestNameValuePair("ik", RimArmor.getInstance().encryptProxy(randomString)));
        arrayList.add(new RestNameValuePair("last", this.f6091c));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 8;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + f.n;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.BaseBean
    public boolean needCheckClientSign() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }

    public void a(boolean z) {
        this.f6091c = z ? "1" : "0";
    }
}
