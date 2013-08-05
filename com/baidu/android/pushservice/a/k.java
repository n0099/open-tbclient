package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class k extends c {
    String[] e;

    public k(l lVar, Context context, String[] strArr) {
        super(lVar, context);
        this.e = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        int length = this.e.length;
        if (length == 0) {
            a(PushConstants.ERROR_PARAMS_ERROR);
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("Delete", "Delete param -- msgIds == null");
                return;
            }
            return;
        }
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "delete"));
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            jSONArray.put(this.e[i]);
        }
        list.add(new BasicNameValuePair(PushConstants.EXTRA_MSG_IDS, jSONArray.toString()));
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("Delete", "Delete param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }
}
