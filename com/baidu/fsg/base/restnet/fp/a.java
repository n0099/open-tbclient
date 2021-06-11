package com.baidu.fsg.base.restnet.fp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5178a = "/risk/init/v2/config";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5179b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Context f5180c;

    /* renamed from: d  reason: collision with root package name */
    public String f5181d;

    public a(Context context) {
        super(context);
        this.f5180c = context;
        BdWalletUtils.cleanExps(context);
    }

    public void a(String str) {
        this.f5181d = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f5181d)) {
            setSpParameter(this.f5181d);
        }
        arrayList.add(new RestNameValuePair("confSign", BdWalletUtils.getRimAllConfigChangesign(this.f5180c)));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.f5180c).getRimHttpsHost() + f5178a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return GetFPResponse.class;
    }
}
