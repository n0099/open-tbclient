package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {
    public void gV() {
        new a().execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            gV();
            return null;
        }

        private void gV() {
            int i;
            ArrayList<com.baidu.adp.lib.stats.base.c> I = com.baidu.adp.lib.stats.base.b.I(true);
            if (I != null && I.size() != 0) {
                int i2 = 0;
                Iterator<com.baidu.adp.lib.stats.base.c> it = I.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    i2 = (int) (it.next().qu + i);
                }
                int i3 = i - BdStatsConstant.MAX_STATISTICS_SIZE;
                ArrayList arrayList = new ArrayList();
                if (i3 > 0) {
                    Collections.sort(I, new com.baidu.adp.lib.stats.base.d());
                    Iterator<com.baidu.adp.lib.stats.base.c> it2 = I.iterator();
                    while (true) {
                        int i4 = i3;
                        if (!it2.hasNext()) {
                            break;
                        }
                        com.baidu.adp.lib.stats.base.c next = it2.next();
                        arrayList.add(next.mFileName);
                        i3 = (int) (i4 - next.qu);
                        if (i3 <= 0) {
                            break;
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<com.baidu.adp.lib.stats.base.c> it3 = I.iterator();
                while (it3.hasNext()) {
                    com.baidu.adp.lib.stats.base.c next2 = it3.next();
                    if (next2 != null) {
                        long j = next2.qv;
                        if (j != 0 && j + 604800000 < currentTimeMillis && !arrayList.contains(next2.mFileName)) {
                            arrayList.add(next2.mFileName);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.adp.lib.stats.base.b.a(arrayList, true);
                }
            }
        }
    }
}
