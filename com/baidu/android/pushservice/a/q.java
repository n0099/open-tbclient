package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class q extends c {
    public q(h hVar, Context context) {
        super(hVar, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.b
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "unbind"));
    }
}
