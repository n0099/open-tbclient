package com.baidu.fsg.base.restnet.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import com.baidu.wallet.core.beans.NetworkBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseBean {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5226a = "/risk/init/stat";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5227b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Context f5228c;

    /* renamed from: d  reason: collision with root package name */
    public String f5229d;

    /* renamed from: e  reason: collision with root package name */
    public String f5230e;

    /* renamed from: f  reason: collision with root package name */
    public String f5231f;

    public <T> a(Context context) {
        super(context);
        this.f5228c = context;
    }

    public void a(String str, String str2, String str3) {
        this.f5229d = str;
        this.f5230e = str2;
        this.f5231f = str3;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f5229d)) {
            arrayList.add(new RestNameValuePair(NetworkBean.PARAM_COOKIE, this.f5229d));
        }
        arrayList.add(new RestNameValuePair("ek", this.f5230e));
        arrayList.add(new RestNameValuePair("ev", this.f5231f));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.f5228c).getRimHttpsHost() + f5226a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }
}
