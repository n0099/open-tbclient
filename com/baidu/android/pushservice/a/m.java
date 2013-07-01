package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class m extends c {
    int e;
    int f;

    public m(l lVar, Context context, int i, int i2) {
        super(lVar, context);
        this.e = 1;
        this.f = 1;
        this.e = i;
        this.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "fetch"));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_FETCH_TYPE, this.e + ""));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_FETCH_NUM, this.f + ""));
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("Fetch", "FETCH param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }
}
