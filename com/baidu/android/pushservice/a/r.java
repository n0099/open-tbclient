package com.baidu.android.pushservice.a;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class r extends c {
    protected String e;

    public r(l lVar, Context context, String str) {
        super(lVar, context);
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.pushservice.a.a
    public void a(List list) {
        super.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "gunbind"));
        list.add(new BasicNameValuePair(PushConstants.EXTRA_GID, this.e));
        if (com.baidu.android.pushservice.b.a()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Log.d("Gunbind", "Gunbind param -- " + ((NameValuePair) it.next()).toString());
            }
        }
    }
}
