package com.baidu.fsg.base.restnet.fp;

import android.content.Context;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.DebugConfig;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseBean {
    public static final String a = "/risk/init/config";
    public static final int b = 1;
    private Context c;

    public a(Context context) {
        super(context);
        this.c = context;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("confSign", BdWalletUtils.getRimAllConfigChangesign(this.c)));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return DebugConfig.getInstance(this.c).getRimHttpsHost() + a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return GetFPResponse.class;
    }
}
