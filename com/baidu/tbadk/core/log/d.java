package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ a a;
    private e b = null;
    private String c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        UtilHelper.NetworkStateInfo networkStateInfo;
        boolean z;
        String str;
        String str2;
        String str3;
        this.b = new e(this.a, (byte) 0);
        networkStateInfo = this.a.l;
        if (networkStateInfo != UtilHelper.NetworkStateInfo.WIFI) {
            a aVar = this.a;
            str3 = a.c;
            aVar.d(str3);
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str = a.c;
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (name.contains(".log") && (TextUtils.isEmpty(this.c) || !this.c.equals(name))) {
                            e eVar = this.b;
                            str2 = a.c;
                            eVar.a(String.valueOf(str2) + "/" + name, "c/s/logupload", true);
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a((d) str);
        this.a.q = null;
    }

    public d(a aVar, String str) {
        this.a = aVar;
        this.c = null;
        this.c = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.a();
        }
        this.a.q = null;
        super.cancel(true);
    }
}
