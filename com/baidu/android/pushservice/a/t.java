package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t extends d {
    protected String f;

    public t(l lVar, Context context, String str) {
        super(lVar, context);
        this.f = null;
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "sendmsgtoserver"));
        if (this.f != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.f);
                if (jSONObject.has("to")) {
                    list.add(new BasicNameValuePair(PushConstants.EXTRA_CB_URL, jSONObject.getString("to")));
                    Log.d("Send", jSONObject.getString("to"));
                }
                if (jSONObject.has("data")) {
                    list.add(new BasicNameValuePair("cb_data", jSONObject.getString("data")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (com.baidu.android.pushservice.b.a()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Log.d("Send", "send param -- " + ((NameValuePair) it.next()).toString());
                }
            }
        }
    }
}
