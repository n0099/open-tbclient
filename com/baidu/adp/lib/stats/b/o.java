package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class o {
    public void it() {
        new a(null).execute(new String[0]);
    }

    /* loaded from: classes.dex */
    private static class a extends BdAsyncTask<String, Integer, String> {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            it();
            return null;
        }

        private void it() {
            int i;
            ArrayList<com.baidu.adp.lib.stats.base.c> E = com.baidu.adp.lib.stats.base.b.E(true);
            if (E != null && E.size() != 0) {
                int i2 = 0;
                Iterator<com.baidu.adp.lib.stats.base.c> it = E.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    i2 = (int) (it.next().wV + i);
                }
                int i3 = i - 31457280;
                ArrayList arrayList = new ArrayList();
                if (i3 > 0) {
                    Collections.sort(E, new com.baidu.adp.lib.stats.base.d());
                    Iterator<com.baidu.adp.lib.stats.base.c> it2 = E.iterator();
                    while (true) {
                        int i4 = i3;
                        if (!it2.hasNext()) {
                            break;
                        }
                        com.baidu.adp.lib.stats.base.c next = it2.next();
                        arrayList.add(next.mFileName);
                        i3 = (int) (i4 - next.wV);
                        if (i3 <= 0) {
                            break;
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<com.baidu.adp.lib.stats.base.c> it3 = E.iterator();
                while (it3.hasNext()) {
                    com.baidu.adp.lib.stats.base.c next2 = it3.next();
                    if (next2 != null) {
                        long j = next2.wW;
                        if (j != 0 && j + TbConfig.APP_OVERDUR_DRAFT_BOX < currentTimeMillis && !arrayList.contains(next2.mFileName)) {
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
