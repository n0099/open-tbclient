package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class g extends b {
    String[] e;

    public g(h hVar, Context context, String[] strArr) {
        super(hVar, context);
        this.e = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.b
    public void a(List list) {
        super.a(list);
        int length = this.e.length;
        if (length == 0) {
            a(PushConstants.ERROR_PARAMS_ERROR);
            return;
        }
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "delete"));
        list.add(new BasicNameValuePair("rsa_access_token", this.b.b));
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            jSONArray.put(this.e[i]);
        }
        list.add(new BasicNameValuePair(PushConstants.EXTRA_MSG_IDS, jSONArray.toString()));
    }
}
