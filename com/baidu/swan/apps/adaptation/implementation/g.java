package com.baidu.swan.apps.adaptation.implementation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.baidu.swan.apps.scheme.actions.p;
import java.io.File;
/* loaded from: classes7.dex */
public class g implements com.baidu.swan.apps.adaptation.a.s {
    @Override // com.baidu.swan.apps.adaptation.a.s
    public boolean a(Activity activity, Uri uri, String str) {
        if (activity == null || uri == null || uri.getPath() == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.aq.c.hasNougat()) {
            uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", new File(uri.getPath()));
        }
        b(activity, uri, str);
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.s
    public boolean J(Context context, String str) {
        return true;
    }

    @Override // com.baidu.swan.apps.adaptation.a.s
    public boolean a(Activity activity, String str, p.a aVar) {
        return false;
    }

    private void b(Activity activity, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(uri, str);
        com.baidu.swan.apps.aq.e.startActivitySafely(activity, intent);
    }
}
