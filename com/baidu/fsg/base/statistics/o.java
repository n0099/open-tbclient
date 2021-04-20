package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.util.Base64;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class o extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    public String f5368a;

    public o(Context context, String str) {
        super(context);
        this.f5368a = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        String encodeToString = Base64.encodeToString(this.f5368a.getBytes(), 2);
        arrayList.add(new RestNameValuePair("datetime", System.currentTimeMillis() + ""));
        arrayList.add(new RestNameValuePair(TbConfig.TMP_LOG_DIR_NAME, encodeToString));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 0;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.mContext).getRimHttpsHost() + "/risk/init/stat/crashlogcollection";
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }
}
