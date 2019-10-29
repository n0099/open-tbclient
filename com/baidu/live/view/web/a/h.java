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
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import java.util.List;
/* loaded from: classes6.dex */
public class h extends com.baidu.live.view.web.a {
    private SchemeCallback atT;
    private Context context;

    public h(Context context, SchemeCallback schemeCallback) {
        this.context = context;
        this.atT = schemeCallback;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "wkBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void cZ(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl WkBridgeJsInterface params = " + str);
        if (str != null && str.contains("rmb_baiducloud://")) {
            if (this.context instanceof Activity) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.context, RequestResponseCode.REQUEST_REAL_AUTHEN, "")));
            }
        } else if (this.atT == null) {
            SchemeUtils.openScheme(str);
        } else {
            SchemeUtils.openScheme(str, this.atT);
        }
    }

    @Override // com.baidu.live.view.web.a
    public void d(String str, String str2, boolean z) {
        PackageManager packageManager;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            List<ResolveInfo> queryIntentActivities = (this.context == null || (packageManager = this.context.getPackageManager()) == null) ? null : packageManager.queryIntentActivities(intent, 0);
            boolean z2 = (queryIntentActivities == null || queryIntentActivities.isEmpty()) ? false : true;
            if (this.atT != null) {
                this.atT.doJsCallback(z2 ? 1 : 0, "", null, str2);
            }
            if (z && z2) {
                intent.addFlags(268435456);
                this.context.startActivity(intent);
            }
        }
    }
}
