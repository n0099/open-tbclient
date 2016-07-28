package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p {
    public void eX() {
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            eX();
            return null;
        }

        private void eX() {
            int i;
            ArrayList<com.baidu.adp.lib.stats.base.c> F = com.baidu.adp.lib.stats.base.b.F(true);
            if (F != null && F.size() != 0) {
                int i2 = 0;
                Iterator<com.baidu.adp.lib.stats.base.c> it = F.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    i2 = (int) (it.next().of + i);
                }
                int i3 = i - 31457280;
                ArrayList arrayList = new ArrayList();
                if (i3 > 0) {
                    Collections.sort(F, new com.baidu.adp.lib.stats.base.d());
                    Iterator<com.baidu.adp.lib.stats.base.c> it2 = F.iterator();
                    while (true) {
                        int i4 = i3;
                        if (!it2.hasNext()) {
                            break;
                        }
                        com.baidu.adp.lib.stats.base.c next = it2.next();
                        arrayList.add(next.mFileName);
                        i3 = (int) (i4 - next.of);
                        if (i3 <= 0) {
                            break;
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<com.baidu.adp.lib.stats.base.c> it3 = F.iterator();
                while (it3.hasNext()) {
                    com.baidu.adp.lib.stats.base.c next2 = it3.next();
                    if (next2 != null) {
                        long j = next2.og;
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
