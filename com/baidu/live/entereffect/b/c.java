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
    private List<com.baidu.live.entereffect.a.a> aOn;

    public static c Dz() {
        return a.aOq;
    }

    public void z(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.DA();
                    return null;
                }
                c.this.C(list);
                List<com.baidu.live.entereffect.a.a> gd = c.this.gd("enter_effect_dynamic_available");
                if (gd == null || gd.isEmpty()) {
                    c.this.DA();
                    return null;
                }
                List c = c.this.c(list, gd);
                if (gd.isEmpty()) {
                    c.this.DA();
                    return null;
                }
                c.this.B(c);
                return gd;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: y */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aOn == null) {
                    c.this.aOn = new ArrayList();
                }
                c.this.aOn.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aOn, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.DB();
                com.baidu.live.entereffect.a.Dw().x(list);
                c.this.A(list);
            }
        }.execute(new Void[0]);
    }

    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aOn != null ? new ArrayList(this.aOn) : null));
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        String str;
        boolean z;
        String hN;
        if (aVarArr != null && aVarArr.length > 0) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (com.baidu.live.alphavideo.a.AW().AX() && !TextUtils.isEmpty(aVar.videoUrl)) {
                    z = true;
                    str = aVar.videoUrl;
                } else {
                    str = aVar.aNU;
                    z = false;
                }
                if (!TextUtils.isEmpty(str) && !am(aVar.id, str)) {
                    b bVar = new b();
                    String hL = s.hL(aVar.id);
                    if (z) {
                        hN = s.hM(aVar.id);
                    } else {
                        hN = s.hN(aVar.id);
                    }
                    bVar.a(z, aVar, str, hL, hN);
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a ga(String str) {
        if (this.aOn == null || this.aOn.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aOn) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        com.baidu.live.f.b.dO(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        boolean z2;
        if (this.aOn != null && !this.aOn.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aOn) {
                if (aVar.id.equals(aVar2.id)) {
                    if (z) {
                        if (list == null || list.isEmpty()) {
                            z2 = true;
                        } else {
                            aVar2.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            z2 = true;
                        }
                    } else {
                        aVar2.b(aVar.aNU, str, list);
                        z2 = true;
                    }
                    if (!z2) {
                        if (z) {
                            if (list != null && !list.isEmpty()) {
                                aVar.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            }
                        } else {
                            aVar.b(aVar.aNU, str, list);
                        }
                        if (this.aOn == null) {
                            this.aOn = new ArrayList();
                        }
                        this.aOn.add(aVar);
                    }
                    DB();
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        DB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA() {
        if (this.aOn != null) {
            this.aOn.clear();
        }
        com.baidu.live.c.AR().putString("enter_effect_dynamic_available", "");
        com.baidu.live.f.a.cleanDir(new File(s.PU()));
        DD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> gd(String str) {
        String string = com.baidu.live.c.AR().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.Dw().i(jSONArray);
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
                    if (next2.aNV != null && next2.aNV.aOF != null) {
                        if (next.aNV == null) {
                            next.aNV = new com.baidu.live.gift.c();
                        }
                        next.aNV.aOF = next2.aNV.aOF;
                    }
                    if (com.baidu.live.alphavideo.a.AW().AX() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aNV.aOG = s.hM(next.id);
                            String DQ = next.aNV.DQ();
                            if (TextUtils.isEmpty(DQ) || !next.videoMd5.equals(com.baidu.live.f.a.getFileMd5(new File(DQ)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aNV.aOG, DQ, next.videoMd5);
                                com.baidu.live.f.a.cleanDir(new File(s.hN(next.id)));
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aNU) && !TextUtils.isEmpty(next.aNU) && next2.aNU.equals(next.aNU) && next.frameCount > 0) {
                        next.aNV.upZipDirPath = s.hN(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aNV.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aNU, next.aNV.upZipDirPath, dynamicGiftPicPathList);
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
    public void B(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                com.baidu.live.f.a.cleanDir(new File(s.hK(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(ge(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gf(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gg(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gh(aVar.id)));
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
                            if (com.baidu.live.alphavideo.a.AW().AX() && !TextUtils.isEmpty(next.videoUrl)) {
                                if (next2.aNV != null && !TextUtils.isEmpty(next2.aNV.DQ())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aNU) && next2.aNV != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aNV.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
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
    public void DB() {
        if (this.aOn == null || this.aOn.isEmpty()) {
            com.baidu.live.c.AR().putString("enter_effect_dynamic_available", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aOn) {
            if (aVar.Dy() != null) {
                jSONArray.put(aVar.Dy());
            }
        }
        com.baidu.live.c.AR().putString("enter_effect_dynamic_available", jSONArray.toString());
    }

    private boolean am(String str, String str2) {
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
    public void C(List<com.baidu.live.entereffect.a.a> list) {
        List<com.baidu.live.entereffect.a.a> gd = gd("enter_effect_dynamic_available_list");
        if (gd == null || gd.isEmpty()) {
            DD();
            return;
        }
        List<com.baidu.live.entereffect.a.a> e = e(list, gd);
        if (gd.isEmpty()) {
            DD();
            return;
        }
        if (e != null && !e.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : e) {
                com.baidu.live.f.a.cleanDir(new File(ge(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gf(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gg(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gh(aVar.id)));
            }
        }
        D(gd);
        DC();
        if (TextUtils.isEmpty(com.baidu.live.c.AR().getString("enter_effect_dynamic_available", "")) && !gd.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar2 : gd) {
                if (aVar2.Dy() != null) {
                    jSONArray.put(aVar2.Dy());
                }
            }
            com.baidu.live.c.AR().putString("enter_effect_dynamic_available", jSONArray.toString());
            DD();
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

    private void D(List<com.baidu.live.entereffect.a.a> list) {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.AW().AX() && list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(aVar.videoMd5)) {
                    File file = new File(gf(aVar.id));
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0 && aVar.videoMd5.equals(com.baidu.live.f.a.getFileMd5(listFiles[0]))) {
                        com.baidu.live.f.a.cleanDir(new File(gh(aVar.id)));
                    }
                }
            }
        }
    }

    private void DC() {
        String hN;
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
                                hN = s.hM(name.substring("video_".length()));
                            } else {
                                hN = s.hN(name);
                            }
                            File file3 = new File(hN);
                            if (file3.exists() || file3.mkdirs()) {
                                for (File file4 : listFiles2) {
                                    String name2 = file4.getName();
                                    if (!TextUtils.isEmpty(name2) && !"zip".equals(name2.substring(name2.lastIndexOf(".") + 1))) {
                                        file4.renameTo(new File(hN + "/" + name2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void DD() {
        com.baidu.live.c.AR().putString("enter_effect_dynamic_available_list", "");
        File file = new File(this.DIR_PATH);
        com.baidu.live.f.a.cleanDir(file);
        if (file.exists()) {
            file.delete();
        }
    }

    private String ge(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String gf(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String gg(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String gh(String str) {
        return gg(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static c aOq = new c();
    }
}
