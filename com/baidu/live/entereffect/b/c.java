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
/* loaded from: classes6.dex */
public class c {
    private static final String DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/enter_effect/";
    private List<com.baidu.live.entereffect.a.a> VY;

    public static c oK() {
        return a.Wb;
    }

    public void q(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.oL();
                    return null;
                }
                List<com.baidu.live.entereffect.a.a> oM = c.this.oM();
                if (oM == null || oM.isEmpty()) {
                    c.this.oL();
                    return null;
                }
                List c = c.this.c(list, oM);
                if (oM.isEmpty()) {
                    c.this.oL();
                    return null;
                }
                c.this.r(c);
                return oM;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: p */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                c.this.b(list2 != null ? (com.baidu.live.entereffect.a.a[]) list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]) : null);
                com.baidu.live.entereffect.a.oF().o(list);
                c.this.a(c.this.d(list, list2));
            }
        }.execute(new Void[0]);
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        if (aVarArr != null && aVarArr.length > 0 && BdNetTypeUtil.isWifiNet()) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (!cc(aVar.id)) {
                    new b().a(aVar, cd(aVar.id), aVar.id);
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a bY(String str) {
        if (this.VY == null || this.VY.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.VY) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        if (this.VY != null) {
            this.VY.clear();
        }
        com.baidu.live.d.b.aY(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        b(aVar.c(str, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL() {
        if (this.VY != null) {
            this.VY.clear();
        }
        com.baidu.live.c.np().putString("enter_effect_dynamic_available_list", "");
        com.baidu.live.d.a.cleanDir(new File(DIR_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> oM() {
        String string = com.baidu.live.c.np().getString("enter_effect_dynamic_available_list", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray == null || jSONArray.length() == 0) {
                return null;
            }
            return com.baidu.live.entereffect.a.oF().i(jSONArray);
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
                    next.VG.upZipDirPath = cd(next.id);
                    ArrayList<String> dynamicGiftPicPathList = next.VG.getDynamicGiftPicPathList();
                    if (dynamicGiftPicPathList == null || dynamicGiftPicPathList.size() != next.frameCount) {
                        z = true;
                    } else {
                        next.c(cd(next.id), dynamicGiftPicPathList);
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
    public void r(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                com.baidu.live.d.a.cleanDir(new File(cd(aVar.id)));
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
            if (this.VY == null) {
                this.VY = new ArrayList();
            }
            Collections.addAll(this.VY, aVarArr);
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar : this.VY) {
                if (aVar.oI() != null) {
                    jSONArray.put(aVar.oI());
                }
            }
            com.baidu.live.c.np().putString("enter_effect_dynamic_available_list", jSONArray.toString());
        }
    }

    private boolean cc(String str) {
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

    private String cd(String str) {
        return DIR_PATH + str + "/";
    }

    private c() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static c Wb = new c();
    }
}
