package com.baidu.swan.apps.api.module.c;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.w.f;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hi(String str) {
        Uri fromFile;
        if (DEBUG) {
            Log.d("Api-Base", "handle: " + str);
        }
        if (TU()) {
            c.e("Api-Base", "Api-Base does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-Base does not supported when app is invisible.");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-Base", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                c.e("Api-Base", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        String optString = jSONObject.optString("filePath");
        String bT = com.baidu.swan.apps.storage.b.bT(optString, e.aoH());
        if (TextUtils.isEmpty(optString) || com.baidu.swan.apps.storage.b.oQ(optString) != PathType.BD_FILE || TextUtils.isEmpty(bT)) {
            c.e("Api-Base", "a valid filePath is required");
            return new com.baidu.swan.apps.api.c.b(202, "a valid filePath is required");
        }
        final String optString2 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            c.e("Api-Base", "cb is required");
            return new com.baidu.swan.apps.api.c.b(202, "cb is required");
        }
        File file = new File(bT);
        if (!file.exists() || file.isDirectory()) {
            c.e("Api-Base", "file not exists");
            return new com.baidu.swan.apps.api.c.b(1001, "file not exists");
        }
        SwanAppActivity ahF = f.ahV().ahF();
        if (ahF == null) {
            c.e("Api-Base", "activity null");
            return new com.baidu.swan.apps.api.c.b(1001, "activity null");
        }
        ActivityResultDispatcher resultDispatcher = ahF.getResultDispatcher();
        Intent intent = new Intent();
        if (com.baidu.swan.apps.aq.b.hasNougat()) {
            fromFile = FileProvider.getUriForFile(ahF, ahF.getPackageName() + ".swan.fileprovider", file);
            intent.setFlags(3);
        } else {
            fromFile = Uri.fromFile(file);
        }
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        intent.setType(hj(bT));
        resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.api.module.c.a.1
            @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
            public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                if (d.DEBUG) {
                    Log.d("shareFile", "resultCode:" + i);
                }
                a.this.a(optString2, new com.baidu.swan.apps.api.c.b(0));
                return true;
            }
        });
        resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private String hj(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf > 0) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
            if (!TextUtils.isEmpty(contentTypeFor)) {
                return contentTypeFor;
            }
        }
        return "*/*";
    }
}
