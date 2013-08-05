package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class u extends e {
    protected String e;
    protected String f;
    protected String g;

    public u(l lVar, Context context, String str, String str2, String str3) {
        super(lVar, context);
        this.e = null;
        this.f = null;
        this.g = null;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "sendmsgtoserver"));
        list.add(new BasicNameValuePair("appid", this.e));
        if (this.g == null || this.f == null) {
            return;
        }
        list.add(new BasicNameValuePair(PushConstants.EXTRA_CB_URL, this.f));
        Log.d("SendMsgToServer", "cb_url:" + this.f);
        list.add(new BasicNameValuePair("cb_data", this.g));
        Log.d("SendMsgToServer", "cb_data:" + this.g);
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("SendMsgToServer", "SendMsgToServer param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }
}
