package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f extends d {
    protected int f;
    private String g;
    private int h;

    public f(l lVar, Context context, int i, String str, int i2) {
        super(lVar, context);
        this.f = 0;
        this.f = i;
        this.g = str;
        this.h = i2;
        if (this.f == 0) {
            this.e = true;
        }
    }

    @Override // com.baidu.android.pushservice.a.a
    protected void a(Intent intent) {
        intent.putExtra(PushConstants.EXTRA_BIND_STATUS, this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "bind"));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_BIND_NAME, TextUtils.isEmpty(this.g) ? Build.MODEL : this.g));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_BIND_STATUS, this.f + ""));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_PUSH_SDK_VERSION, this.h + ""));
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("Bind", "BIND param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.d, com.baidu.android.pushservice.a.a
    public String b(String str) {
        String b = super.b(str);
        if (!TextUtils.isEmpty(this.b.e)) {
            com.baidu.android.pushservice.a.a(this.f297a).e(this.b.e);
            if (!TextUtils.isEmpty(this.b.i)) {
                com.baidu.android.pushservice.a.a(this.f297a).a(this.b.e, new g(this.b.i, b));
            }
        }
        return b;
    }
}
