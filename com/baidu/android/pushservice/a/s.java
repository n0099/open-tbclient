package com.baidu.android.pushservice.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends c {
    private ArrayList e;

    public s(l lVar, Context context) {
        super(lVar, context);
        this.e = new ArrayList();
    }

    @Override // com.baidu.android.pushservice.a.a
    protected void a(int i, byte[] bArr) {
        Intent intent = new Intent(PushConstants.ACTION_RECEIVE);
        intent.putExtra(PushConstants.EXTRA_METHOD, this.b.f691a);
        intent.putExtra("error_msg", i);
        intent.putExtra("content", bArr);
        if (!this.e.isEmpty()) {
            intent.putStringArrayListExtra(PushConstants.EXTRA_TAGS_LIST, this.e);
        }
        intent.setFlags(32);
        a(intent);
        if (TextUtils.isEmpty(this.b.e)) {
            return;
        }
        intent.setPackage(this.b.e);
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("Glist", "> sendResult to " + this.b.e + " ,method:" + this.b.f691a + " ,errorCode : " + i + " ,content : " + new String(bArr));
        }
        this.f689a.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "glist"));
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("Glist", "Glist param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public String b(String str) {
        String b = super.b(str);
        try {
            JSONArray jSONArray = new JSONObject(b).getJSONObject("response_params").getJSONArray("groups");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.e.add(jSONArray.getJSONObject(i).getString(SocialConstants.PARAM_MEDIA_UNAME));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return b;
    }
}
