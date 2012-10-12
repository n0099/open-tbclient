package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i extends b {
    int e;
    int f;

    public i(h hVar, Context context, int i, int i2) {
        super(hVar, context);
        this.e = 1;
        this.f = 1;
        this.e = i;
        this.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.b
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "fetch"));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_FETCH_TYPE, this.e + ""));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_FETCH_NUM, this.f + ""));
    }
}
