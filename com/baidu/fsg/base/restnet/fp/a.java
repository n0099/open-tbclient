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
    public static final String f5249a = "/risk/init/v2/config";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5250b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Context f5251c;

    /* renamed from: d  reason: collision with root package name */
    public String f5252d;

    public a(Context context) {
        super(context);
        this.f5251c = context;
        BdWalletUtils.cleanExps(context);
    }

    public void a(String str) {
        this.f5252d = str;
    }

    @Override // com.baidu.fsg.base.restnet.beans.business.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f5252d)) {
            setSpParameter(this.f5252d);
        }
        arrayList.add(new RestNameValuePair("confSign", BdWalletUtils.getRimAllConfigChangesign(this.f5251c)));
        return arrayList;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public int getBeanId() {
        return 1;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public String getUrl() {
        return EnvConfig.getInstance(this.f5251c).getRimHttpsHost() + f5249a;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public Class<?> responseClass() {
        return GetFPResponse.class;
    }
}
