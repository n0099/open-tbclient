package com.baidu.adp.plugin.install;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Object, String[]> {
    private Context mContext;
    final /* synthetic */ c this$0;

    public f(c cVar, Context context) {
        this.this$0 = cVar;
        this.mContext = null;
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public String[] doInBackground(String... strArr) {
        if (this.mContext == null) {
            return null;
        }
        try {
            return this.mContext.getAssets().list("plugins");
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public void onPostExecute(String[] strArr) {
        a aVar;
        a aVar2;
        boolean z;
        boolean v;
        boolean z2 = false;
        super.onPostExecute(strArr);
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (str != null && str.endsWith(".apk")) {
                    v = this.this$0.v(this.mContext, "plugins/" + str);
                    if (v) {
                        z2 = true;
                    }
                }
            }
        }
        if (!z2) {
            aVar = this.this$0.sl;
            if (aVar != null) {
                aVar2 = this.this$0.sl;
                z = this.this$0.so;
                aVar2.J(z);
            }
        }
    }
}
