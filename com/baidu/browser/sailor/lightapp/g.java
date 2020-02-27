package com.baidu.browser.sailor.lightapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class g extends AsyncTask<Uri, Void, String> {
    final /* synthetic */ int Jl;
    final /* synthetic */ BdLightappKernelClient Jm;
    final /* synthetic */ ContentResolver Jn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BdLightappKernelClient bdLightappKernelClient, ContentResolver contentResolver, int i) {
        this.Jm = bdLightappKernelClient;
        this.Jn = contentResolver;
        this.Jl = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Uri... uriArr) {
        Cursor cursor = null;
        try {
            Cursor query = this.Jn.query(uriArr[0], new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        String string = query.getString(0);
                        if (query != null) {
                            query.close();
                            return string;
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        if (this.Jm.mActivity == null || this.Jm.mActivity.isFinishing()) {
            Log.w("BdLightappKernelClient", "mActivity is null or finished.");
        } else {
            this.Jm.cloudaHandleResult(this.Jl, str, !TextUtils.isEmpty(str));
        }
    }
}
