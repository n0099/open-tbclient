package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
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
/* loaded from: classes4.dex */
public class c {
    private final String DIR_PATH;
    private List<com.baidu.live.entereffect.a.a> aHj;

    public static c xG() {
        return a.aHm;
    }

    public void y(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.xH();
                    return null;
                }
                List<com.baidu.live.entereffect.a.a> xI = c.this.xI();
                if (xI == null || xI.isEmpty()) {
                    c.this.xH();
                    return null;
                }
                List c = c.this.c(list, xI);
                if (xI.isEmpty()) {
                    c.this.xH();
                    return null;
                }
                c.this.A(c);
                return xI;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: x */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aHj == null) {
                    c.this.aHj = new ArrayList();
                }
                c.this.aHj.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aHj, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.xJ();
                com.baidu.live.entereffect.a.xD().w(list);
                c.this.z(list);
            }
        }.execute(new Void[0]);
    }

    public void z(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aHj != null ? new ArrayList(this.aHj) : null));
    }

    public void a(com.baidu.live.entereffect.a.a... aVarArr) {
        String str;
        boolean z;
        if (aVarArr != null && aVarArr.length > 0 && BdNetTypeUtil.isWifiNet()) {
            for (com.baidu.live.entereffect.a.a aVar : aVarArr) {
                if (com.baidu.live.alphavideo.a.vj().vk() && !TextUtils.isEmpty(aVar.videoUrl)) {
                    z = true;
                    str = aVar.videoUrl;
                } else {
                    str = aVar.aGQ;
                    z = false;
                }
                if (!TextUtils.isEmpty(str) && !ai(aVar.id, str)) {
                    new b().a(z, aVar, str, z ? eD(aVar.id) : eF(aVar.id), z ? eE(aVar.id) : eG(aVar.id));
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a eA(String str) {
        if (this.aHj == null || this.aHj.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aHj) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        com.baidu.live.f.b.bY(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        boolean z2;
        if (this.aHj != null && !this.aHj.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aHj) {
                if (aVar.id.equals(aVar2.id)) {
                    if (z) {
                        if (list == null || list.isEmpty()) {
                            z2 = true;
                        } else {
                            aVar2.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            z2 = true;
                        }
                    } else {
                        aVar2.b(aVar.aGQ, str, list);
                        z2 = true;
                    }
                    if (!z2) {
                        if (z) {
                            if (list != null && !list.isEmpty()) {
                                aVar.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            }
                        } else {
                            aVar.b(aVar.aGQ, str, list);
                        }
                        if (this.aHj == null) {
                            this.aHj = new ArrayList();
                        }
                        this.aHj.add(aVar);
                    }
                    xJ();
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        xJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH() {
        if (this.aHj != null) {
            this.aHj.clear();
        }
        com.baidu.live.c.vf().putString("enter_effect_dynamic_available_list", "");
        com.baidu.live.f.a.cleanDir(new File(this.DIR_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> xI() {
        String string = com.baidu.live.c.vf().getString("enter_effect_dynamic_available_list", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.xD().i(jSONArray);
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
                    if (next2.aGR != null && next2.aGR.aHB != null) {
                        if (next.aGR == null) {
                            next.aGR = new com.baidu.live.gift.c();
                        }
                        next.aGR.aHB = next2.aGR.aHB;
                    }
                    if (com.baidu.live.alphavideo.a.vj().vk() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aGR.aHC = eE(next.id);
                            String xX = next.aGR.xX();
                            if (TextUtils.isEmpty(xX) || !next.videoMd5.equals(com.baidu.live.f.a.getFileMd5(new File(xX)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aGR.aHC, xX, next.videoMd5);
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aGQ) && !TextUtils.isEmpty(next.aGQ) && next2.aGQ.equals(next.aGQ) && next.frameCount > 0) {
                        next.aGR.upZipDirPath = eG(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aGR.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aGQ, next.aGR.upZipDirPath, dynamicGiftPicPathList);
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
    public void A(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                com.baidu.live.f.a.cleanDir(new File(eD(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(eE(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(eF(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(eG(aVar.id)));
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
                            if (com.baidu.live.alphavideo.a.vj().vk() && !TextUtils.isEmpty(next.videoUrl)) {
                                if (next2.aGR != null && !TextUtils.isEmpty(next2.aGR.xX())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aGQ) && next2.aGR != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aGR.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
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
    public void xJ() {
        if (this.aHj == null || this.aHj.isEmpty()) {
            com.baidu.live.c.vf().putString("enter_effect_dynamic_available_list", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aHj) {
            if (aVar.xF() != null) {
                jSONArray.put(aVar.xF());
            }
        }
        com.baidu.live.c.vf().putString("enter_effect_dynamic_available_list", jSONArray.toString());
    }

    private boolean ai(String str, String str2) {
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

    private String eD(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String eE(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String eF(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String eG(String str) {
        return eF(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static c aHm = new c();
    }
}
