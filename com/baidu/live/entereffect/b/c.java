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
/* loaded from: classes3.dex */
public class c {
    private static final String DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/enter_effect/";
    private List<com.baidu.live.entereffect.a.a> afx;

    public static c qW() {
        return a.afA;
    }

    public void p(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.qX();
                    return null;
                }
                List<com.baidu.live.entereffect.a.a> qY = c.this.qY();
                if (qY == null || qY.isEmpty()) {
                    c.this.qX();
                    return null;
                }
                List c = c.this.c(list, qY);
                if (qY.isEmpty()) {
                    c.this.qX();
                    return null;
                }
                c.this.q(c);
                return qY;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: o */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                c.this.b(list2 != null ? (com.baidu.live.entereffect.a.a[]) list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]) : null);
                com.baidu.live.entereffect.a.qR().n(list);
                c.this.a(c.this.d(list, list2));
            }
        }.execute(new Void[0]);
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        if (aVarArr != null && aVarArr.length > 0 && BdNetTypeUtil.isWifiNet()) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (!de(aVar.id)) {
                    new b().a(aVar, df(aVar.id), aVar.id);
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a da(String str) {
        if (this.afx == null || this.afx.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.afx) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        if (this.afx != null) {
            this.afx.clear();
        }
        com.baidu.live.f.b.bq(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        b(aVar.c(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX() {
        if (this.afx != null) {
            this.afx.clear();
        }
        com.baidu.live.c.pr().putString("enter_effect_dynamic_available_list", "");
        com.baidu.live.f.a.cleanDir(new File(DIR_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> qY() {
        String string = com.baidu.live.c.pr().getString("enter_effect_dynamic_available_list", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            return com.baidu.live.entereffect.a.qR().i(jSONArray);
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
                    next.afg.upZipDirPath = df(next.id);
                    ArrayList<String> dynamicGiftPicPathList = next.afg.getDynamicGiftPicPathList();
                    if (dynamicGiftPicPathList == null || dynamicGiftPicPathList.size() != next.frameCount) {
                        z = true;
                    } else {
                        next.c(df(next.id), dynamicGiftPicPathList);
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
                com.baidu.live.f.a.cleanDir(new File(df(aVar.id)));
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
            if (this.afx == null) {
                this.afx = new ArrayList();
            }
            Collections.addAll(this.afx, aVarArr);
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar : this.afx) {
                if (aVar.qU() != null) {
                    jSONArray.put(aVar.qU());
                }
            }
            com.baidu.live.c.pr().putString("enter_effect_dynamic_available_list", jSONArray.toString());
        }
    }

    private boolean de(String str) {
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

    private String df(String str) {
        return DIR_PATH + str + "/";
    }

    private c() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static c afA = new c();
    }
}
