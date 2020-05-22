package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {
    public void ml() {
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
            ml();
            return null;
        }

        private void ml() {
            int i;
            ArrayList<com.baidu.adp.lib.stats.base.d> ar = com.baidu.adp.lib.stats.base.b.ar(true);
            if (ar != null && ar.size() != 0) {
                int i2 = 0;
                Iterator<com.baidu.adp.lib.stats.base.d> it = ar.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    i2 = (int) (it.next().mFileSize + i);
                }
                int i3 = i - BdStatsConstant.MAX_STATISTICS_SIZE;
                ArrayList arrayList = new ArrayList();
                if (i3 > 0) {
                    Collections.sort(ar, new com.baidu.adp.lib.stats.base.e());
                    Iterator<com.baidu.adp.lib.stats.base.d> it2 = ar.iterator();
                    while (true) {
                        int i4 = i3;
                        if (!it2.hasNext()) {
                            break;
                        }
                        com.baidu.adp.lib.stats.base.d next = it2.next();
                        arrayList.add(next.mFileName);
                        i3 = (int) (i4 - next.mFileSize);
                        if (i3 <= 0) {
                            break;
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<com.baidu.adp.lib.stats.base.d> it3 = ar.iterator();
                while (it3.hasNext()) {
                    com.baidu.adp.lib.stats.base.d next2 = it3.next();
                    if (next2 != null) {
                        long j = next2.MG;
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
