package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class c {
    private final String DIR_PATH;
    private List<com.baidu.live.entereffect.a.a> aRy;

    public static c Ew() {
        return a.aRB;
    }

    public void B(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.Ex();
                    return null;
                }
                c.this.E(list);
                List<com.baidu.live.entereffect.a.a> gr = c.this.gr("enter_effect_dynamic_available");
                if (gr == null || gr.isEmpty()) {
                    c.this.Ex();
                    return null;
                }
                List c = c.this.c(list, gr);
                if (gr.isEmpty()) {
                    c.this.Ex();
                    return null;
                }
                c.this.D(c);
                return gr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: A */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aRy == null) {
                    c.this.aRy = new ArrayList();
                }
                c.this.aRy.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aRy, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.Ey();
                com.baidu.live.entereffect.a.Et().z(list);
                c.this.C(list);
            }
        }.execute(new Void[0]);
    }

    public void C(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aRy != null ? new ArrayList(this.aRy) : null));
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        String str;
        boolean z;
        String ie;
        if (aVarArr != null && aVarArr.length > 0) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (com.baidu.live.alphavideo.a.BT().BU() && !TextUtils.isEmpty(aVar.videoUrl)) {
                    z = true;
                    str = aVar.videoUrl;
                } else {
                    str = aVar.aRf;
                    z = false;
                }
                if (!TextUtils.isEmpty(str) && !ao(aVar.id, str)) {
                    b bVar = new b();
                    String ic = s.ic(aVar.id);
                    if (z) {
                        ie = s.id(aVar.id);
                    } else {
                        ie = s.ie(aVar.id);
                    }
                    bVar.a(z, aVar, str, ic, ie);
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a go(String str) {
        if (this.aRy == null || this.aRy.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aRy) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        com.baidu.live.f.b.dT(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        boolean z2;
        if (this.aRy != null && !this.aRy.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aRy) {
                if (aVar.id.equals(aVar2.id)) {
                    if (z) {
                        if (list == null || list.isEmpty()) {
                            z2 = true;
                        } else {
                            aVar2.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            z2 = true;
                        }
                    } else {
                        aVar2.b(aVar.aRf, str, list);
                        z2 = true;
                    }
                    if (!z2) {
                        if (z) {
                            if (list != null && !list.isEmpty()) {
                                aVar.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            }
                        } else {
                            aVar.b(aVar.aRf, str, list);
                        }
                        if (this.aRy == null) {
                            this.aRy = new ArrayList();
                        }
                        this.aRy.add(aVar);
                    }
                    Ey();
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        Ey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ex() {
        if (this.aRy != null) {
            this.aRy.clear();
        }
        com.baidu.live.c.AZ().putString("enter_effect_dynamic_available", "");
        com.baidu.live.f.a.cleanDir(new File(s.QZ()));
        EA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> gr(String str) {
        String string = com.baidu.live.c.AZ().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.Et().i(jSONArray);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> c(List<com.baidu.live.entereffect.a.a> list, List<com.baidu.live.entereffect.a.a> list2) {
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2 = null;
        Iterator<com.baidu.live.entereffect.a.a> it = list2.iterator();
        while (it.hasNext()) {
            boolean z2 = true;
            com.baidu.live.entereffect.a.a next = it.next();
            Iterator<com.baidu.live.entereffect.a.a> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                com.baidu.live.entereffect.a.a next2 = it2.next();
                if (!TextUtils.isEmpty(next2.id) && next2.id.equals(next.id)) {
                    next.priority = next2.priority;
                    if (next2.aRg != null && next2.aRg.aRQ != null) {
                        if (next.aRg == null) {
                            next.aRg = new com.baidu.live.gift.c();
                        }
                        next.aRg.aRQ = next2.aRg.aRQ;
                    }
                    if (com.baidu.live.alphavideo.a.BT().BU() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aRg.aRR = s.id(next.id);
                            String EM = next.aRg.EM();
                            if (TextUtils.isEmpty(EM) || !next.videoMd5.equals(com.baidu.live.f.a.getFileMd5(new File(EM)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aRg.aRR, EM, next.videoMd5);
                                com.baidu.live.f.a.cleanDir(new File(s.ie(next.id)));
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aRf) && !TextUtils.isEmpty(next.aRf) && next2.aRf.equals(next.aRf) && next.frameCount > 0) {
                        next.aRg.upZipDirPath = s.ie(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aRg.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aRf, next.aRg.upZipDirPath, dynamicGiftPicPathList);
                            z2 = false;
                        }
                    }
                }
            }
            if (z2) {
                it.remove();
                arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList.add(next);
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                com.baidu.live.f.a.cleanDir(new File(s.ib(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gt(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gu(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gv(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gw(aVar.id)));
            }
        }
    }

    private com.baidu.live.entereffect.a.a[] d(List<com.baidu.live.entereffect.a.a> list, List<com.baidu.live.entereffect.a.a> list2) {
        ArrayList<String> dynamicGiftPicPathList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list2 != null && !list2.isEmpty()) {
            Iterator<com.baidu.live.entereffect.a.a> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.live.entereffect.a.a next = it.next();
                Iterator<com.baidu.live.entereffect.a.a> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        com.baidu.live.entereffect.a.a next2 = it2.next();
                        if (next2.id.equals(next.id)) {
                            if (com.baidu.live.alphavideo.a.BT().BU() && !TextUtils.isEmpty(next.videoUrl)) {
                                if (next2.aRg != null && !TextUtils.isEmpty(next2.aRg.EM())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aRf) && next2.aRg != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aRg.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
        return (com.baidu.live.entereffect.a.a[]) list.toArray(new com.baidu.live.entereffect.a.a[list.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey() {
        if (this.aRy == null || this.aRy.isEmpty()) {
            com.baidu.live.c.AZ().putString("enter_effect_dynamic_available", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aRy) {
            if (aVar.Ev() != null) {
                jSONArray.put(aVar.Ev());
            }
        }
        com.baidu.live.c.AZ().putString("enter_effect_dynamic_available", jSONArray.toString());
    }

    private boolean ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
        if (ListUtils.isEmpty(downloadList)) {
            return false;
        }
        for (DownloadData downloadData : downloadList) {
            if (downloadData.getType() == 20 && str.equals(downloadData.getId()) && str2.equals(downloadData.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<com.baidu.live.entereffect.a.a> list) {
        List<com.baidu.live.entereffect.a.a> gr = gr("enter_effect_dynamic_available_list");
        if (gr == null || gr.isEmpty()) {
            EA();
            return;
        }
        List<com.baidu.live.entereffect.a.a> e = e(list, gr);
        if (gr.isEmpty()) {
            EA();
            return;
        }
        if (e != null && !e.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : e) {
                com.baidu.live.f.a.cleanDir(new File(gt(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gu(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gv(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gw(aVar.id)));
            }
        }
        F(gr);
        Ez();
        if (TextUtils.isEmpty(com.baidu.live.c.AZ().getString("enter_effect_dynamic_available", "")) && !gr.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar2 : gr) {
                if (aVar2.Ev() != null) {
                    jSONArray.put(aVar2.Ev());
                }
            }
            com.baidu.live.c.AZ().putString("enter_effect_dynamic_available", jSONArray.toString());
            EA();
        }
    }

    private List<com.baidu.live.entereffect.a.a> e(List<com.baidu.live.entereffect.a.a> list, List<com.baidu.live.entereffect.a.a> list2) {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        Iterator<com.baidu.live.entereffect.a.a> it = list2.iterator();
        while (it.hasNext()) {
            com.baidu.live.entereffect.a.a next = it.next();
            Iterator<com.baidu.live.entereffect.a.a> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                com.baidu.live.entereffect.a.a next2 = it2.next();
                if (!TextUtils.isEmpty(next2.id) && next2.id.equals(next.id)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                it.remove();
                arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList.add(next);
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    private void F(List<com.baidu.live.entereffect.a.a> list) {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.BT().BU() && list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(aVar.videoMd5)) {
                    File file = new File(gu(aVar.id));
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0 && aVar.videoMd5.equals(com.baidu.live.f.a.getFileMd5(listFiles[0]))) {
                        com.baidu.live.f.a.cleanDir(new File(gw(aVar.id)));
                    }
                }
            }
        }
    }

    private void Ez() {
        String ie;
        File file = new File(this.DIR_PATH);
        if (file.exists()) {
            if (!file.isDirectory()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                } else {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 == null || listFiles2.length == 0) {
                        file2.delete();
                    } else {
                        String name = file2.getName();
                        if (TextUtils.isEmpty(name)) {
                            com.baidu.live.f.a.cleanDir(file2);
                        } else if (name.startsWith("video_zip_")) {
                            com.baidu.live.f.a.cleanDir(file2);
                            file2.delete();
                        } else {
                            if (name.startsWith("video_")) {
                                ie = s.id(name.substring("video_".length()));
                            } else {
                                ie = s.ie(name);
                            }
                            File file3 = new File(ie);
                            if (file3.exists() || file3.mkdirs()) {
                                for (File file4 : listFiles2) {
                                    String name2 = file4.getName();
                                    if (!TextUtils.isEmpty(name2) && !"zip".equals(name2.substring(name2.lastIndexOf(".") + 1))) {
                                        file4.renameTo(new File(ie + "/" + name2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void EA() {
        com.baidu.live.c.AZ().putString("enter_effect_dynamic_available_list", "");
        File file = new File(this.DIR_PATH);
        com.baidu.live.f.a.cleanDir(file);
        if (file.exists()) {
            file.delete();
        }
    }

    private String gt(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String gu(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String gv(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String gw(String str) {
        return gv(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static c aRB = new c();
    }
}
