package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d extends c {
    protected int f;
    private String g;

    public d(h hVar, Context context, int i, String str) {
        super(hVar, context);
        this.f = 0;
        this.f = i;
        this.g = str;
        if (this.f == 0) {
            this.e = true;
        }
    }

    @Override // com.baidu.android.pushservice.a.b
    protected void a(Intent intent) {
        intent.putExtra(PushConstants.EXTRA_BIND_STATUS, this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.b
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "bind"));
        list.add(new BasicNameValuePair("rsa_access_token", this.b.b));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_BIND_NAME, TextUtils.isEmpty(this.g) ? Build.MODEL : this.g));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_BIND_STATUS, this.f + ""));
    }
}
