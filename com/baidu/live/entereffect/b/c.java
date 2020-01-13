package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c {
    private static final String DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/enter_effect/";
    private List<com.baidu.live.entereffect.a.a> adv;

    public static c ql() {
        return a.ady;
    }

    public void p(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.qm();
                    return null;
                }
                List<com.baidu.live.entereffect.a.a> qn = c.this.qn();
                if (qn == null || qn.isEmpty()) {
                    c.this.qm();
                    return null;
                }
                List c = c.this.c(list, qn);
                if (qn.isEmpty()) {
                    c.this.qm();
                    return null;
                }
                c.this.q(c);
                return qn;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: o */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                c.this.b(list2 != null ? (com.baidu.live.entereffect.a.a[]) list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]) : null);
                com.baidu.live.entereffect.a.qg().n(list);
                c.this.a(c.this.d(list, list2));
            }
        }.execute(new Void[0]);
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        if (aVarArr != null && aVarArr.length > 0 && BdNetTypeUtil.isWifiNet()) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (!cV(aVar.id)) {
                    new b().a(aVar, cW(aVar.id), aVar.id);
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a cR(String str) {
        if (this.adv == null || this.adv.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.adv) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        if (this.adv != null) {
            this.adv.clear();
        }
        com.baidu.live.f.b.bj(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        b(aVar.b(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qm() {
        if (this.adv != null) {
            this.adv.clear();
        }
        com.baidu.live.c.oJ().putString("enter_effect_dynamic_available_list", "");
        com.baidu.live.f.a.cleanDir(new File(DIR_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> qn() {
        String string = com.baidu.live.c.oJ().getString("enter_effect_dynamic_available_list", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            return com.baidu.live.entereffect.a.qg().i(jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> c(List<com.baidu.live.entereffect.a.a> list, List<com.baidu.live.entereffect.a.a> list2) {
        ArrayList arrayList = null;
        Iterator<com.baidu.live.entereffect.a.a> it = list2.iterator();
        while (it.hasNext()) {
            com.baidu.live.entereffect.a.a next = it.next();
            boolean z = !list.contains(next);
            if (!z) {
                if (next.frameCount <= 0) {
                    z = true;
                } else {
                    next.ade.upZipDirPath = cW(next.id);
                    ArrayList<String> dynamicGiftPicPathList = next.ade.getDynamicGiftPicPathList();
                    if (dynamicGiftPicPathList == null || dynamicGiftPicPathList.size() != next.frameCount) {
                        z = true;
                    } else {
                        next.b(cW(next.id), dynamicGiftPicPathList);
                    }
                }
            }
            if (z) {
                it.remove();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                com.baidu.live.f.a.cleanDir(new File(cW(aVar.id)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.entereffect.a.a[] d(List<com.baidu.live.entereffect.a.a> list, List<com.baidu.live.entereffect.a.a> list2) {
        if (list == null) {
            return null;
        }
        if (list2 != null && !list2.isEmpty()) {
            list.removeAll(list2);
        }
        return (com.baidu.live.entereffect.a.a[]) list.toArray(new com.baidu.live.entereffect.a.a[list.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.entereffect.a.a... aVarArr) {
        if (aVarArr != null && aVarArr.length != 0) {
            if (this.adv == null) {
                this.adv = new ArrayList();
            }
            Collections.addAll(this.adv, aVarArr);
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar : this.adv) {
                if (aVar.qj() != null) {
                    jSONArray.put(aVar.qj());
                }
            }
            com.baidu.live.c.oJ().putString("enter_effect_dynamic_available_list", jSONArray.toString());
        }
    }

    private boolean cV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList)) {
            return false;
        }
        for (DownloadData downloadData : downloadList) {
            if (downloadData.getType() == 20 && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private String cW(String str) {
        return DIR_PATH + str + "/";
    }

    private c() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static c ady = new c();
    }
}
