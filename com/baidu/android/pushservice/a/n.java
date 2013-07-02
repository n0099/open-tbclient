package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class n extends b {
    protected String e;

    public n(h hVar, Context context, String str) {
        super(hVar, context);
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.b
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "gunbind"));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_GID, this.e));
    }
}
