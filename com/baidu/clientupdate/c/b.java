package com.baidu.clientupdate.c;

import android.text.TextUtils;
import com.baidu.util.Base64Encoder;
import com.baidu.util.LogUtil;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f1363a;

    public b(String str) {
        this.f1363a = new StringBuilder(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1363a.append(ETAG.ITEM_SEPARATOR + str + "=");
        byte[] b64Encode = Base64Encoder.b64Encode(URLEncoder.encode(str2).getBytes());
        this.f1363a.append(new String(b64Encode));
        LogUtil.logD("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
        LogUtil.logD("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + new String(b64Encode));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f1363a.append(ETAG.ITEM_SEPARATOR + str + "=");
        this.f1363a.append(URLEncoder.encode(str2));
        LogUtil.logD("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
        LogUtil.logD("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + str2);
    }

    public String toString() {
        return this.f1363a.toString();
    }
}
