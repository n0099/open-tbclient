package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class w extends e {
    protected String e;
    protected String f;
    protected String g;
    protected String h;

    public w(l lVar, Context context, String str, String str2, String str3, String str4) {
        super(lVar, context);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "sendmsgtouser"));
        list.add(new BasicNameValuePair("appid", this.e));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_USER_ID, this.f));
        if (this.h == null || this.g == null) {
            return;
        }
        Log.d(PushConstants.EXTRA_USER_ID, this.f);
        StringBuilder sb = new StringBuilder("[\"");
        sb.append(this.g).append("\"]");
        StringBuilder sb2 = new StringBuilder("[\"");
        sb2.append(this.h).append("\"]");
        list.add(new BasicNameValuePair("msg_keys", sb.toString()));
        list.add(new BasicNameValuePair("messages", sb2.toString()));
        Log.d("Send", "key:" + this.g.toString() + " messages:" + this.h.toString());
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("Send", "sendMsgToUser param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }
}
