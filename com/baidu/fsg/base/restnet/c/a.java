package com.baidu.fsg.base.restnet.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.EnvConfig;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.beans.business.BaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseBean {
    public static final String a = "/risk/init/stat";
    public static final int b = 1;
    private Context c;
    private String d;
    private String e;
    private String f;

    public <T> a(Context context) {
        super(context);
        this.c = context;
    }

    public void a(String str, String str2, String str3) {
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.d)) {
            arrayList.add(new RestNameValuePair("atbc", this.d));
        }
        arrayList.add(new RestNameValuePair("ek", this.e));
        arrayList.add(new RestNameValuePair("ev", this.f));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.c).getRimHttpsHost() + a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void execBean() {
        super.execBean(String.class);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return String.class;
    }
}
