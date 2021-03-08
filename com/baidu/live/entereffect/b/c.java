package com.baidu.live.entereffect.b;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes10.dex */
public class c {
    private final String DIR_PATH;
    private List<com.baidu.live.entereffect.a.a> aWm;

    public static c Dc() {
        return a.aWp;
    }

    public void C(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.Dd();
                    return null;
                }
                c.this.E(list);
                List<com.baidu.live.entereffect.a.a> fP = c.this.fP("enter_effect_dynamic_available");
                if (fP == null || fP.isEmpty()) {
                    c.this.Dd();
                    return null;
                }
                String[] c = c.this.c(list, fP);
                if (fP.isEmpty()) {
                    c.this.Dd();
                    return null;
                }
                c.this.k(c);
                return fP;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aWm == null) {
                    c.this.aWm = Collections.synchronizedList(new ArrayList());
                }
                c.this.aWm.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aWm, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.De();
                c.this.D(list);
            }
        }.execute(new Void[0]);
    }

    public void D(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aWm != null ? new ArrayList(this.aWm) : null));
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        String str;
        boolean z;
        String hJ;
        if (aVarArr != null && aVarArr.length > 0) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (com.baidu.live.alphavideo.a.zr().zs() && !TextUtils.isEmpty(aVar.videoUrl)) {
                    z = true;
                    str = aVar.videoUrl;
                } else {
                    str = aVar.aVN;
                    z = false;
                }
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(str) && !e(aVar.id, str, aVar.aVQ)) {
                    b bVar = new b();
                    String hH = com.baidu.live.storage.b.hH(aVar.id);
                    if (z) {
                        hJ = com.baidu.live.storage.b.hI(aVar.id);
                    } else {
                        hJ = com.baidu.live.storage.b.hJ(aVar.id);
                    }
                    bVar.a(z, aVar, str, hH, hJ, aVar.aVQ);
                }
            }
        }
    }

    public List<com.baidu.live.entereffect.a.a> CZ() {
        return this.aWm;
    }

    public com.baidu.live.entereffect.a.a fJ(String str) {
        if (this.aWm == null || this.aWm.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aWm) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void fO(String str) {
        if (!TextUtils.isEmpty(str) && this.aWm != null && !this.aWm.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : this.aWm) {
                if (str.equals(aVar.id)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    aVar.aVO = currentTimeMillis;
                    String string = com.baidu.live.d.xf().getString("enter_effect_dynamic_available", "");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                if (optJSONObject != null && str.equals(optJSONObject.optString("id"))) {
                                    optJSONObject.put("last_accessed", currentTimeMillis);
                                    com.baidu.live.d.xf().putString("enter_effect_dynamic_available", jSONArray.toString());
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
        com.baidu.live.h.b.cF(20);
        if (this.aWm != null) {
            this.aWm.clear();
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
        if (this.aWm != null && !this.aWm.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aWm) {
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
                        aVar2.b(aVar.aVN, str, arrayList);
                    }
                    aVar2.aVO = System.currentTimeMillis();
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
                            aVar.b(aVar.aVN, str, arrayList2);
                        }
                        aVar.aVO = System.currentTimeMillis();
                        if (this.aWm == null) {
                            this.aWm = Collections.synchronizedList(new ArrayList());
                        }
                        this.aWm.add(aVar);
                    }
                    string = com.baidu.live.d.xf().getString("enter_effect_dynamic_available", "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray(string);
                    } else {
                        jSONArray = new JSONArray();
                    }
                    if (jSONArray == null) {
                        jSONArray.put(aVar.Db());
                        com.baidu.live.d.xf().putString("enter_effect_dynamic_available", jSONArray.toString());
                        return;
                    }
                    return;
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        string = com.baidu.live.d.xf().getString("enter_effect_dynamic_available", "");
        if (TextUtils.isEmpty(string)) {
        }
        if (jSONArray == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dd() {
        if (this.aWm != null) {
            this.aWm.clear();
        }
        com.baidu.live.d.xf().putString("enter_effect_dynamic_available", "");
        com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.QQ()));
        com.baidu.live.d.xf().putString("enter_effect_res_last_accessed", "");
        Dg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> fP(String str) {
        String string = com.baidu.live.d.xf().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.CY().i(jSONArray);
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
                    if (next2.aVP != null && next2.aVP.aWS != null) {
                        if (next.aVP == null) {
                            next.aVP = new com.baidu.live.gift.c();
                        }
                        next.aVP.aWS = next2.aVP.aWS;
                    }
                    if (com.baidu.live.alphavideo.a.zr().zs() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aVP.aWT = com.baidu.live.storage.b.hI(next.id);
                            String DB = next.aVP.DB();
                            if (TextUtils.isEmpty(DB) || !next.videoMd5.equals(com.baidu.live.h.a.getFileMd5(new File(DB)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aVP.aWT, DB, next.videoMd5);
                                if (next.aVO <= 0) {
                                    next.aVO = new File(next.aVP.aWT).lastModified();
                                }
                                com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.hJ(next.id)));
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aVN) && !TextUtils.isEmpty(next.aVN) && next2.aVN.equals(next.aVN) && next.frameCount > 0) {
                        next.aVP.upZipDirPath = com.baidu.live.storage.b.hJ(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aVP.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aVN, next.aVP.upZipDirPath, dynamicGiftPicPathList);
                            if (next.aVO <= 0) {
                                next.aVO = new File(next.aVP.upZipDirPath).lastModified();
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
                com.baidu.live.h.a.cleanDir(new File(com.baidu.live.storage.b.hG(str)));
                com.baidu.live.h.a.cleanDir(new File(fQ(str)));
                com.baidu.live.h.a.cleanDir(new File(fR(str)));
                com.baidu.live.h.a.cleanDir(new File(fS(str)));
                com.baidu.live.h.a.cleanDir(new File(fT(str)));
            }
        }
    }

    public void fL(String str) {
        if (this.aWm != null) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aWm.iterator();
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
                            if (com.baidu.live.alphavideo.a.zr().zs() && !TextUtils.isEmpty(next.videoUrl)) {
                                if (next2.aVP != null && !TextUtils.isEmpty(next2.aVP.DB())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aVN) && next2.aVP != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aVP.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
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
    public void De() {
        if (this.aWm == null || this.aWm.isEmpty()) {
            com.baidu.live.d.xf().putString("enter_effect_dynamic_available", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aWm) {
            if (aVar.Db() != null) {
                jSONArray.put(aVar.Db());
            }
        }
        com.baidu.live.d.xf().putString("enter_effect_dynamic_available", jSONArray.toString());
    }

    private boolean e(String str, String str2, boolean z) {
        DownloadData downloadData;
        int i;
        if (FileSerialDownLoader.getInstance().isDownloading(str, str2, 20)) {
            if (z) {
                List<DownloadData> downloadList = FileSerialDownLoader.getInstance().getDownloadList();
                try {
                    Iterator<DownloadData> it = downloadList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            downloadData = null;
                            break;
                        }
                        DownloadData next = it.next();
                        if (next != null && 20 == next.getType() && next.getId().equals(str) && next.getUrl().equals(str2)) {
                            next.setPriority(383);
                            it.remove();
                            downloadData = next;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (downloadData == null) {
                    return true;
                }
                if (!downloadList.isEmpty()) {
                    for (int i2 = 0; i2 < downloadList.size(); i2++) {
                        if (downloadData.getPriority() >= downloadList.get(i2).getPriority()) {
                            i = i2;
                            break;
                        }
                    }
                }
                i = -1;
                if (i >= 0) {
                    downloadList.add(i, downloadData);
                } else {
                    downloadList.add(downloadData);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<com.baidu.live.entereffect.a.a> list) {
        List<com.baidu.live.entereffect.a.a> fP = fP("enter_effect_dynamic_available_list");
        if (fP == null || fP.isEmpty()) {
            Dg();
            return;
        }
        List<com.baidu.live.entereffect.a.a> e = e(list, fP);
        if (fP.isEmpty()) {
            Dg();
            return;
        }
        if (e != null && !e.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : e) {
                com.baidu.live.h.a.cleanDir(new File(fQ(aVar.id)));
                com.baidu.live.h.a.cleanDir(new File(fR(aVar.id)));
                com.baidu.live.h.a.cleanDir(new File(fS(aVar.id)));
                com.baidu.live.h.a.cleanDir(new File(fT(aVar.id)));
            }
        }
        F(fP);
        Df();
        if (TextUtils.isEmpty(com.baidu.live.d.xf().getString("enter_effect_dynamic_available", "")) && !fP.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar2 : fP) {
                if (aVar2.Db() != null) {
                    jSONArray.put(aVar2.Db());
                }
            }
            com.baidu.live.d.xf().putString("enter_effect_dynamic_available", jSONArray.toString());
            Dg();
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
        if (com.baidu.live.alphavideo.a.zr().zs() && list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(aVar.videoMd5)) {
                    File file = new File(fR(aVar.id));
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0 && aVar.videoMd5.equals(com.baidu.live.h.a.getFileMd5(listFiles[0]))) {
                        com.baidu.live.h.a.cleanDir(new File(fT(aVar.id)));
                    }
                }
            }
        }
    }

    private void Df() {
        String hJ;
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
                            com.baidu.live.h.a.cleanDir(file2);
                        } else if (name.startsWith("video_zip_")) {
                            com.baidu.live.h.a.cleanDir(file2);
                            file2.delete();
                        } else {
                            if (name.startsWith("video_")) {
                                hJ = com.baidu.live.storage.b.hI(name.substring("video_".length()));
                            } else {
                                hJ = com.baidu.live.storage.b.hJ(name);
                            }
                            File file3 = new File(hJ);
                            if (file3.exists() || file3.mkdirs()) {
                                for (File file4 : listFiles2) {
                                    String name2 = file4.getName();
                                    if (!TextUtils.isEmpty(name2) && !"zip".equals(name2.substring(name2.lastIndexOf(".") + 1))) {
                                        file4.renameTo(new File(hJ + "/" + name2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void Dg() {
        com.baidu.live.d.xf().putString("enter_effect_dynamic_available_list", "");
        File file = new File(this.DIR_PATH);
        com.baidu.live.h.a.cleanDir(file);
        if (file.exists()) {
            file.delete();
        }
    }

    private String fQ(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String fR(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String fS(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String fT(String str) {
        return fS(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static c aWp = new c();
    }
}
