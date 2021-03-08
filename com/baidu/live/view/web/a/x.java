package com.baidu.live.view.web.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class x extends com.baidu.live.view.web.a {
    private Context context;
    private SchemeCallback schemeCallback;

    public x(Context context, SchemeCallback schemeCallback) {
        this.context = context;
        this.schemeCallback = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "wkBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl WkBridgeJsInterface params = " + str);
        if (str != null && str.contains("rmb_baiducloud://")) {
            if (this.context instanceof Activity) {
                FaceRecognitionActivityConfig faceRecognitionActivityConfig = new FaceRecognitionActivityConfig(this.context, RequestResponseCode.REQUEST_REAL_AUTHEN, "");
                Uri parse = Uri.parse(str);
                Iterator<String> it = parse.getQueryParameterNames().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    String queryParameter = parse.getQueryParameter(next);
                    if ("retry".equals(next) && "1".equals(queryParameter)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913142));
                        break;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, faceRecognitionActivityConfig));
            }
        } else if (this.schemeCallback == null) {
            SchemeUtils.openScheme(str);
        } else {
            SchemeUtils.openScheme(str, this.schemeCallback);
        }
    }

    @Override // com.baidu.live.view.web.a
    public void j(String str, String str2, boolean z) {
        PackageManager packageManager;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            List<ResolveInfo> queryIntentActivities = (this.context == null || (packageManager = this.context.getPackageManager()) == null) ? null : packageManager.queryIntentActivities(intent, 0);
            boolean z2 = (queryIntentActivities == null || queryIntentActivities.isEmpty()) ? false : true;
            if (this.schemeCallback != null) {
                this.schemeCallback.doJsCallback(z2 ? 1 : 0, "", null, str2);
            }
            if (z && z2 && this.context != null) {
                intent.addFlags(268435456);
                this.context.startActivity(intent);
            }
        }
    }
}
