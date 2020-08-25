package com.baidu.fsg.base.restnet.fp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseBean {
    public static final String a = "/risk/init/v2/config";
    public static final int b = 1;
    private Context c;
    private String d;

    public a(Context context) {
        super(context);
        this.c = context;
        BdWalletUtils.cleanExps(this.c);
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.d)) {
            setSpParameter(this.d);
        }
        arrayList.add(new RestNameValuePair("confSign", BdWalletUtils.getRimAllConfigChangesign(this.c)));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.c).getRimHttpsHost() + a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return GetFPResponse.class;
    }
}
