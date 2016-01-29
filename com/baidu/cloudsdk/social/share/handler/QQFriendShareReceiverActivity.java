package com.baidu.cloudsdk.social.share.handler;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.Build;
import com.baidu.cloudsdk.IBaiduListener;
import com.e;
import com.f;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QQFriendShareReceiverActivity extends Activity {
    private static final String a = QQFriendShareReceiverActivity.class.getSimpleName();
    private IBaiduListener b;

    private Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                }
            }
        }
        return bundle;
    }

    private void a(Uri uri) {
        if (uri == null || TextUtils.isEmpty(uri.toString())) {
            finish();
            return;
        }
        String uri2 = uri.toString();
        Bundle a2 = a(uri2.substring(uri2.indexOf(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR) + 1));
        String string = a2.getString("action");
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("shareToQQ")) {
                this.b = e.dG();
            } else if (string.equals("shareToQzone")) {
                this.b = f.dG();
            }
            a(a2);
        } else if (this.b != null) {
            this.b.onError(new BaiduException("unknown action"));
        }
        finish();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("result");
            String string2 = bundle.getString("response");
            if (!TextUtils.isEmpty(string) && string.equals("cancel")) {
                if (this.b != null) {
                    this.b.onCancel();
                }
            } else if (!TextUtils.isEmpty(string) && string.equals("error")) {
                if (this.b != null) {
                    this.b.onError(new BaiduException("unknown error"));
                }
            } else if (TextUtils.isEmpty(string) || !string.equals("complete")) {
            } else {
                if (string2 == null) {
                    string2 = "{\"ret\": 0}";
                }
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    if (this.b != null) {
                        if (Build.DEBUG) {
                            Log.d(a, "execShareToQQCallback onComplete ");
                        }
                        this.b.onComplete(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (this.b != null) {
                        this.b.onError(new BaiduException("JSONException"));
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        if (data != null && Build.DEBUG) {
            Log.d(a, "uri = " + data.toString());
        }
        a(data);
    }
}
