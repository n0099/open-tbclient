package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class f extends b {
    protected String e;

    public f(h hVar, Context context, String str) {
        super(hVar, context);
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.b
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "gmsgcount"));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_GID, this.e));
    }
}
