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
    private List<com.baidu.live.entereffect.a.a> aSs;

    public static c EJ() {
        return a.aSv;
    }

    public void B(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.EK();
                    return null;
                }
                c.this.D(list);
                List<com.baidu.live.entereffect.a.a> gw = c.this.gw("enter_effect_dynamic_available");
                if (gw == null || gw.isEmpty()) {
                    c.this.EK();
                    return null;
                }
                String[] c = c.this.c(list, gw);
                if (gw.isEmpty()) {
                    c.this.EK();
                    return null;
                }
                c.this.k(c);
                return gw;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: A */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aSs == null) {
                    c.this.aSs = Collections.synchronizedList(new ArrayList());
                }
                c.this.aSs.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aSs, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.EL();
                c.this.C(list);
            }
        }.execute(new Void[0]);
    }

    public void C(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aSs != null ? new ArrayList(this.aSs) : null));
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        String str;
        boolean z;
        String ia;
        if (aVarArr != null && aVarArr.length > 0) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (com.baidu.live.alphavideo.a.BT().BU() && !TextUtils.isEmpty(aVar.videoUrl)) {
                    z = true;
                    str = aVar.videoUrl;
                } else {
                    str = aVar.aRU;
                    z = false;
                }
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(str) && !ap(aVar.id, str)) {
                    b bVar = new b();
                    String hY = com.baidu.live.ab.b.hY(aVar.id);
                    if (z) {
                        ia = com.baidu.live.ab.b.hZ(aVar.id);
                    } else {
                        ia = com.baidu.live.ab.b.ia(aVar.id);
                    }
                    bVar.a(z, aVar, str, hY, ia, aVar.aRX);
                }
            }
        }
    }

    public List<com.baidu.live.entereffect.a.a> EG() {
        return this.aSs;
    }

    public com.baidu.live.entereffect.a.a gp(String str) {
        if (this.aSs == null || this.aSs.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aSs) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void gv(String str) {
        if (!TextUtils.isEmpty(str) && this.aSs != null && !this.aSs.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : this.aSs) {
                if (str.equals(aVar.id)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    aVar.aRV = currentTimeMillis;
                    String string = com.baidu.live.d.AZ().getString("enter_effect_dynamic_available", "");
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                if (optJSONObject != null && str.equals(optJSONObject.optString("id"))) {
                                    optJSONObject.put("last_accessed", currentTimeMillis);
                                    com.baidu.live.d.AZ().putString("enter_effect_dynamic_available", jSONArray.toString());
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

    public void stopDownload() {
        com.baidu.live.f.b.dT(20);
    }

    public void release() {
        stopDownload();
        if (this.aSs != null) {
            this.aSs.clear();
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
        if (this.aSs != null && !this.aSs.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aSs) {
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
                        aVar2.b(aVar.aRU, str, arrayList);
                    }
                    aVar2.aRV = System.currentTimeMillis();
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
                            aVar.b(aVar.aRU, str, arrayList2);
                        }
                        aVar.aRV = System.currentTimeMillis();
                        if (this.aSs == null) {
                            this.aSs = Collections.synchronizedList(new ArrayList());
                        }
                        this.aSs.add(aVar);
                    }
                    string = com.baidu.live.d.AZ().getString("enter_effect_dynamic_available", "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = new JSONArray(string);
                    } else {
                        jSONArray = new JSONArray();
                    }
                    if (jSONArray == null) {
                        jSONArray.put(aVar.EI());
                        com.baidu.live.d.AZ().putString("enter_effect_dynamic_available", jSONArray.toString());
                        return;
                    }
                    return;
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        string = com.baidu.live.d.AZ().getString("enter_effect_dynamic_available", "");
        if (TextUtils.isEmpty(string)) {
        }
        if (jSONArray == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EK() {
        if (this.aSs != null) {
            this.aSs.clear();
        }
        com.baidu.live.d.AZ().putString("enter_effect_dynamic_available", "");
        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ab.b.PS()));
        com.baidu.live.d.AZ().putString("enter_effect_res_last_accessed", "");
        EN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> gw(String str) {
        String string = com.baidu.live.d.AZ().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.EF().i(jSONArray);
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
                    if (next2.aRW != null && next2.aRW.aSL != null) {
                        if (next.aRW == null) {
                            next.aRW = new com.baidu.live.gift.c();
                        }
                        next.aRW.aSL = next2.aRW.aSL;
                    }
                    if (com.baidu.live.alphavideo.a.BT().BU() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aRW.aSM = com.baidu.live.ab.b.hZ(next.id);
                            String Fb = next.aRW.Fb();
                            if (TextUtils.isEmpty(Fb) || !next.videoMd5.equals(com.baidu.live.f.a.getFileMd5(new File(Fb)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aRW.aSM, Fb, next.videoMd5);
                                if (next.aRV <= 0) {
                                    next.aRV = new File(next.aRW.aSM).lastModified();
                                }
                                com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ab.b.ia(next.id)));
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aRU) && !TextUtils.isEmpty(next.aRU) && next2.aRU.equals(next.aRU) && next.frameCount > 0) {
                        next.aRW.upZipDirPath = com.baidu.live.ab.b.ia(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aRW.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aRU, next.aRW.upZipDirPath, dynamicGiftPicPathList);
                            if (next.aRV <= 0) {
                                next.aRV = new File(next.aRW.upZipDirPath).lastModified();
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
                com.baidu.live.f.a.cleanDir(new File(com.baidu.live.ab.b.hX(str)));
                com.baidu.live.f.a.cleanDir(new File(gx(str)));
                com.baidu.live.f.a.cleanDir(new File(gy(str)));
                com.baidu.live.f.a.cleanDir(new File(gz(str)));
                com.baidu.live.f.a.cleanDir(new File(gA(str)));
            }
        }
    }

    public void gr(String str) {
        if (this.aSs != null) {
            Iterator<com.baidu.live.entereffect.a.a> it = this.aSs.iterator();
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
                            if (com.baidu.live.alphavideo.a.BT().BU() && !TextUtils.isEmpty(next.videoUrl)) {
                                if (next2.aRW != null && !TextUtils.isEmpty(next2.aRW.Fb())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aRU) && next2.aRW != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aRW.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
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
    public void EL() {
        if (this.aSs == null || this.aSs.isEmpty()) {
            com.baidu.live.d.AZ().putString("enter_effect_dynamic_available", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aSs) {
            if (aVar.EI() != null) {
                jSONArray.put(aVar.EI());
            }
        }
        com.baidu.live.d.AZ().putString("enter_effect_dynamic_available", jSONArray.toString());
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
        List<com.baidu.live.entereffect.a.a> gw = gw("enter_effect_dynamic_available_list");
        if (gw == null || gw.isEmpty()) {
            EN();
            return;
        }
        List<com.baidu.live.entereffect.a.a> e = e(list, gw);
        if (gw.isEmpty()) {
            EN();
            return;
        }
        if (e != null && !e.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : e) {
                com.baidu.live.f.a.cleanDir(new File(gx(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gy(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gz(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(gA(aVar.id)));
            }
        }
        E(gw);
        EM();
        if (TextUtils.isEmpty(com.baidu.live.d.AZ().getString("enter_effect_dynamic_available", "")) && !gw.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (com.baidu.live.entereffect.a.a aVar2 : gw) {
                if (aVar2.EI() != null) {
                    jSONArray.put(aVar2.EI());
                }
            }
            com.baidu.live.d.AZ().putString("enter_effect_dynamic_available", jSONArray.toString());
            EN();
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
        if (com.baidu.live.alphavideo.a.BT().BU() && list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                if (!TextUtils.isEmpty(aVar.id) && !TextUtils.isEmpty(aVar.videoMd5)) {
                    File file = new File(gy(aVar.id));
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0 && aVar.videoMd5.equals(com.baidu.live.f.a.getFileMd5(listFiles[0]))) {
                        com.baidu.live.f.a.cleanDir(new File(gA(aVar.id)));
                    }
                }
            }
        }
    }

    private void EM() {
        String ia;
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
                                ia = com.baidu.live.ab.b.hZ(name.substring("video_".length()));
                            } else {
                                ia = com.baidu.live.ab.b.ia(name);
                            }
                            File file3 = new File(ia);
                            if (file3.exists() || file3.mkdirs()) {
                                for (File file4 : listFiles2) {
                                    String name2 = file4.getName();
                                    if (!TextUtils.isEmpty(name2) && !"zip".equals(name2.substring(name2.lastIndexOf(".") + 1))) {
                                        file4.renameTo(new File(ia + "/" + name2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void EN() {
        com.baidu.live.d.AZ().putString("enter_effect_dynamic_available_list", "");
        File file = new File(this.DIR_PATH);
        com.baidu.live.f.a.cleanDir(file);
        if (file.exists()) {
            file.delete();
        }
    }

    private String gx(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String gy(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String gz(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String gA(String str) {
        return gz(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static c aSv = new c();
    }
}
