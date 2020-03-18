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
    private List<com.baidu.live.entereffect.a.a> afH;

    public static c rb() {
        return a.afK;
    }

    public void p(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.rc();
                    return null;
                }
                List<com.baidu.live.entereffect.a.a> rd = c.this.rd();
                if (rd == null || rd.isEmpty()) {
                    c.this.rc();
                    return null;
                }
                List c = c.this.c(list, rd);
                if (rd.isEmpty()) {
                    c.this.rc();
                    return null;
                }
                c.this.q(c);
                return rd;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: o */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                c.this.b(list2 != null ? (com.baidu.live.entereffect.a.a[]) list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]) : null);
                com.baidu.live.entereffect.a.qW().n(list);
                c.this.a(c.this.d(list, list2));
            }
        }.execute(new Void[0]);
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        if (aVarArr != null && aVarArr.length > 0 && BdNetTypeUtil.isWifiNet()) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (!dd(aVar.id)) {
                    new b().a(aVar, de(aVar.id), aVar.id);
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a cZ(String str) {
        if (this.afH == null || this.afH.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.afH) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        if (this.afH != null) {
            this.afH.clear();
        }
        com.baidu.live.f.b.bq(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        b(aVar.c(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc() {
        if (this.afH != null) {
            this.afH.clear();
        }
        com.baidu.live.c.pw().putString("enter_effect_dynamic_available_list", "");
        com.baidu.live.f.a.cleanDir(new File(DIR_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> rd() {
        String string = com.baidu.live.c.pw().getString("enter_effect_dynamic_available_list", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            return com.baidu.live.entereffect.a.qW().i(jSONArray);
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
                    next.afq.upZipDirPath = de(next.id);
                    ArrayList<String> dynamicGiftPicPathList = next.afq.getDynamicGiftPicPathList();
                    if (dynamicGiftPicPathList == null || dynamicGiftPicPathList.size() != next.frameCount) {
                        z = true;
                    } else {
                        next.c(de(next.id), dynamicGiftPicPathList);
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
                com.baidu.live.f.a.cleanDir(new File(de(aVar.id)));
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
            if (this.afH == null) {
                this.afH = new ArrayList();
            }
            Collections.addAll(this.afH, aVarArr);
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar : this.afH) {
                if (aVar.qZ() != null) {
                    jSONArray.put(aVar.qZ());
                }
            }
            com.baidu.live.c.pw().putString("enter_effect_dynamic_available_list", jSONArray.toString());
        }
    }

    private boolean dd(String str) {
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

    private String de(String str) {
        return DIR_PATH + str + "/";
    }

    private c() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static c afK = new c();
    }
}
