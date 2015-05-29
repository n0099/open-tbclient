package com.baidu.adp.lib.stats.upload;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ b this$0;
    private com.baidu.adp.lib.stats.base.a xq;
    private ArrayList<String> xr;
    private boolean xs;

    public e(b bVar, com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z) {
        this.this$0 = bVar;
        this.xq = null;
        this.xr = null;
        this.xs = false;
        this.xq = aVar;
        this.xr = arrayList;
        this.xs = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        b(this.xq, this.xs);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        this.xq.D(false);
    }

    private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        com.baidu.adp.lib.h.e eVar;
        int i;
        try {
            eVar = this.this$0.xn;
            String a = f.a(aVar, eVar);
            BdUploadingLogInfo a2 = a.a(aVar);
            int size = a2.size();
            if (a2 != null && size > 0) {
                if (!z) {
                    for (int i2 = 0; i2 < size; i2++) {
                        ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.xr);
                        if (logStringByIndex != null && logStringByIndex.size() != 0) {
                            this.this$0.a(aVar, a, logStringByIndex, a2.get(i2));
                        }
                    }
                    return;
                }
                int i3 = 0;
                for (int i4 = size - 1; i4 >= 0; i4--) {
                    ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i4, this.xr);
                    if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                        if (k.iY()) {
                            i = i3;
                        } else {
                            i = logStringByIndex2.toString().length() + i3;
                            if (i > 102400) {
                                return;
                            }
                        }
                        this.this$0.a(aVar, a, logStringByIndex2, a2.get(i4));
                        i3 = i;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
