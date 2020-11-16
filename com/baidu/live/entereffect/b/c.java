package com.baidu.live.entereffect.b;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.download.DownloadData;
import com.baidu.live.tbadk.download.FileSerialDownLoader;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private final String DIR_PATH;
    private List<com.baidu.live.entereffect.a.a> aSa;

    public static c EB() {
        return a.aSd;
    }

    public void B(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.EC();
                    return null;
                }
                c.this.D(list);
                List<com.baidu.live.entereffect.a.a> gv = c.this.gv("enter_effect_dynamic_available");
                if (gv == null || gv.isEmpty()) {
                    c.this.EC();
                    return null;
                }
                String[] c = c.this.c(list, gv);
                if (gv.isEmpty()) {
                    c.this.EC();
                    return null;
                }
                c.this.k(c);
                return gv;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: A */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aSa == null) {
                    c.this.aSa = Collections.synchronizedList(new ArrayList());
                }
                c.this.aSa.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aSa, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.ED();
                c.this.C(list);
            }
        }.execute(new Void[0]);
    }

    public void C(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aSa != null ? new ArrayList(this.aSa) : null));
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        String str;
        boolean z;
        String ib;
        if (aVarArr != null && aVarArr.length > 0) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (com.baidu.live.alphavideo.a.BC().BD() && !TextUtils.isEmpty(aVar.videoUrl)) {
                    z = true;
                    str = aVar.videoUrl;
                } else {
                    str = aVar.aRB;
                    z = false;
                }
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(str) && !ap(aVar.id, str)) {
                    b bVar = new b();
                    String hZ = com.baidu.live.ac.b.hZ(aVar.id);
                    if (z) {
                        ib = com.baidu.live.ac.b.ia(aVar.id);
                    } else {
                        ib = com.baidu.live.ac.b.ib(aVar.id);
                    }
                    bVar.a(z, aVar, str, hZ, ib, aVar.aRE);
                }
            }
        }
    }

    public List<com.baidu.live.entereffect.a.a> Ey() {
        return this.aSa;
    }

    public com.baidu.live.entereffect.a.a go(String str) {
        if (this.aSa == null || this.aSa.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aSa) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void gu(String str) {
        if (!TextUtils.isEmpty(str) && this.aSa != null && !this.aSa.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : this.aSa) {
                if (str.equals(aVar.id)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    aVar.aRC = currentTimeMillis;
                    String string = com.baidu.live.d.Aq().getString("enter_effect_dynamic_available", "");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                if (optJSONObject != null && str.equals(optJSONObject.optString("id"))) {
                                    optJSONObject.put("last_accessed", currentTimeMillis);
                                    com.baidu.live.d.Aq().putString("enter_effect_dynamic_available", jSONArray.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    public void release() {
        com.baidu.live.f.b.dP(20);
        if (this.aSa != null) {
            this.aSa.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:5|(3:8|(11:10|11|(1:(1:18))(4:53|(2:56|54)|57|58)|19|(4:(1:(1:27))(4:32|(2:35|33)|36|37)|28|(1:30)|31)|38|39|40|(1:42)(1:50)|43|(2:45|46)(1:48))|6)|59)|60|(0)|38|39|40|(0)(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0113, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0114, code lost:
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac A[Catch: JSONException -> 0x0113, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0113, blocks: (B:33:0x00a6, B:35:0x00ac, B:49:0x010d), top: B:55:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d A[Catch: JSONException -> 0x0113, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0113, blocks: (B:33:0x00a6, B:35:0x00ac, B:49:0x010d), top: B:55:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.live.entereffect.a.a aVar, String str, List<com.baidu.live.entereffect.a.b> list) {
        boolean z2;
        String string;
        JSONArray jSONArray;
        if (this.aSa != null && !this.aSa.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aSa) {
                if (aVar.id.equals(aVar2.id)) {
                    if (z) {
                        if (list != null && !list.isEmpty() && list.get(0) != null) {
                            aVar2.k(aVar.videoUrl, str, list.get(0).path, list.get(0).md5);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (com.baidu.live.entereffect.a.b bVar : list) {
                            arrayList.add(bVar.path);
                        }
                        aVar2.b(aVar.aRB, str, arrayList);
                    }
                    aVar2.aRC = System.currentTimeMillis();
                    z2 = true;
                    if (!z2) {
                        if (z) {
                            if (list != null && !list.isEmpty() && list.get(0) != null) {
                                aVar.k(aVar.videoUrl, str, list.get(0).path, list.get(0).md5);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (com.baidu.live.entereffect.a.b bVar2 : list) {
                                arrayList2.add(bVar2.path);
                            }
                            aVar.b(aVar.aRB, str, arrayList2);
                        }
                        aVar.aRC = System.currentTimeMillis();
                        if (this.aSa == null) {
                            this.aSa = Collections.synchronizedList(new ArrayList());
                        }
                        this.aSa.add(aVar);
                    }
                    string = com.baidu.live.d.Aq().getString("enter_effect_dynamic_available", "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray(string);
                    } else {
                        jSONArray = new JSONArray();
                    }
                    if (jSONArray == null) {
                        jSONArray.put(aVar.EA());
                        com.baidu.live.d.Aq().putString("enter_effect_dynamic_available", jSONArray.toString());
                        return;
                    }
                    return;
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        string = com.baidu.live.d.Aq().getString("enter_effect_dynamic_available", "");
        if (TextUtils.isEmpty(string)) {
        }
        if (jSONArray == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        if (this.aSa != null) {
            this.aSa.clear();
        }
        com.baidu.live.d.Aq().putString("enter_effect_dynamic_available", "");
        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.PJ()));
        com.baidu.live.d.Aq().putString("enter_effect_res_last_accessed", "");
        EF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> gv(String str) {
        String string = com.baidu.live.d.Aq().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.Ex().i(jSONArray);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] c(List<com.baidu.live.entereffect.a.a> list, List<com.baidu.live.entereffect.a.a> list2) {
        ArrayList arrayList;
        boolean z;
        Iterator<com.baidu.live.entereffect.a.a> it = list2.iterator();
        ArrayList arrayList2 = null;
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
                    if (next2.aRD != null && next2.aRD.aSt != null) {
                        if (next.aRD == null) {
                            next.aRD = new com.baidu.live.gift.c();
                        }
                        next.aRD.aSt = next2.aRD.aSt;
                    }
                    if (com.baidu.live.alphavideo.a.BC().BD() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aRD.aSu = com.baidu.live.ac.b.ia(next.id);
                            String ET = next.aRD.ET();
                            if (TextUtils.isEmpty(ET) || !next.videoMd5.equals(com.baidu.live.f.a.getFileMd5(new File(ET)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aRD.aSu, ET, next.videoMd5);
                                if (next.aRC <= 0) {
                                    next.aRC = new File(next.aRD.aSu).lastModified();
                                }
                                com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.ib(next.id)));
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aRB) && !TextUtils.isEmpty(next.aRB) && next2.aRB.equals(next.aRB) && next.frameCount > 0) {
                        next.aRD.upZipDirPath = com.baidu.live.ac.b.ib(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aRD.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aRB, next.aRD.upZipDirPath, dynamicGiftPicPathList);
                            if (next.aRC <= 0) {
                                next.aRC = new File(next.aRD.upZipDirPath).lastModified();
                            }
                            z2 = false;
                        }
                    }
                }
            }
            if (z2) {
                it.remove();
                arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList.add(next.id);
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        if (arrayList2 != null) {
            return (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String... strArr) {
        if (Looper.myLooper() != Looper.getMainLooper() && strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ac.b.hY(str)));
                com.baidu.live.f.a.cleanDir(new File(gw(str)));
                com.baidu.live.f.a.cleanDir(new File(gx(str)));
                com.baidu.live.f.a.cleanDir(new File(gy(str)));
                com.baidu.live.f.a.cleanDir(new File(gz(str)));
            }
        }
    }

    public void gq(String str) {
        if (this.aSa != null) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aSa.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().id.equals(str)) {
                    it.remove();
                    break;
                }
            }
            k(str);
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
                            if (com.baidu.live.alphavideo.a.BC().BD() && !TextUtils.isEmpty(next.videoUrl)) {
                                if (next2.aRD != null && !TextUtils.isEmpty(next2.aRD.ET())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aRB) && next2.aRD != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aRD.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
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
    public void ED() {
        if (this.aSa == null || this.aSa.isEmpty()) {
            com.baidu.live.d.Aq().putString("enter_effect_dynamic_available", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aSa) {
            if (aVar.EA() != null) {
                jSONArray.put(aVar.EA());
            }
        }
        com.baidu.live.d.Aq().putString("enter_effect_dynamic_available", jSONArray.toString());
    }

    private boolean ap(String str, String str2) {
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
    public void D(List<com.baidu.live.entereffect.a.a> list) {
        List<com.baidu.live.entereffect.a.a> gv = gv("enter_effect_dynamic_available_list");
        if (gv == null || gv.isEmpty()) {
            EF();
            return;
        }
        List<com.baidu.live.entereffect.a.a> e = e(list, gv);
        if (gv.isEmpty()) {
            EF();
            return;
        }
        if (e != null && !e.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : e) {
                com.baidu.live.f.a.cleanDir(new File(gw(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gx(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gy(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gz(aVar.id)));
            }
        }
        E(gv);
        EE();
        if (TextUtils.isEmpty(com.baidu.live.d.Aq().getString("enter_effect_dynamic_available", "")) && !gv.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar2 : gv) {
                if (aVar2.EA() != null) {
                    jSONArray.put(aVar2.EA());
                }
            }
            com.baidu.live.d.Aq().putString("enter_effect_dynamic_available", jSONArray.toString());
            EF();
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

    private void E(List<com.baidu.live.entereffect.a.a> list) {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.BC().BD() && list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(aVar.videoMd5)) {
                    File file = new File(gx(aVar.id));
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0 && aVar.videoMd5.equals(com.baidu.live.f.a.getFileMd5(listFiles[0]))) {
                        com.baidu.live.f.a.cleanDir(new File(gz(aVar.id)));
                    }
                }
            }
        }
    }

    private void EE() {
        String ib;
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
                                ib = com.baidu.live.ac.b.ia(name.substring("video_".length()));
                            } else {
                                ib = com.baidu.live.ac.b.ib(name);
                            }
                            File file3 = new File(ib);
                            if (file3.exists() || file3.mkdirs()) {
                                for (File file4 : listFiles2) {
                                    String name2 = file4.getName();
                                    if (!TextUtils.isEmpty(name2) && !"zip".equals(name2.substring(name2.lastIndexOf(".") + 1))) {
                                        file4.renameTo(new File(ib + "/" + name2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void EF() {
        com.baidu.live.d.Aq().putString("enter_effect_dynamic_available_list", "");
        File file = new File(this.DIR_PATH);
        com.baidu.live.f.a.cleanDir(file);
        if (file.exists()) {
            file.delete();
        }
    }

    private String gw(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String gx(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String gy(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String gz(String str) {
        return gy(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static c aSd = new c();
    }
}
