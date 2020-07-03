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
/* loaded from: classes3.dex */
public class c {
    private final String DIR_PATH;
    private List<com.baidu.live.entereffect.a.a> aFO;

    public static c xd() {
        return a.aFR;
    }

    public void w(final List<com.baidu.live.entereffect.a.a> list) {
        new BdAsyncTask<Void, Void, List<com.baidu.live.entereffect.a.a>>() { // from class: com.baidu.live.entereffect.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: c */
            public List<com.baidu.live.entereffect.a.a> doInBackground(Void... voidArr) {
                if (list == null || list.isEmpty()) {
                    c.this.xe();
                    return null;
                }
                List<com.baidu.live.entereffect.a.a> xf = c.this.xf();
                if (xf == null || xf.isEmpty()) {
                    c.this.xe();
                    return null;
                }
                List c = c.this.c(list, xf);
                if (xf.isEmpty()) {
                    c.this.xe();
                    return null;
                }
                c.this.y(c);
                return xf;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
            /* renamed from: v */
            public void onPostExecute(List<com.baidu.live.entereffect.a.a> list2) {
                super.onPostExecute(list2);
                if (c.this.aFO == null) {
                    c.this.aFO = new ArrayList();
                }
                c.this.aFO.clear();
                if (list2 != null) {
                    Collections.addAll(c.this.aFO, list2.toArray(new com.baidu.live.entereffect.a.a[list2.size()]));
                }
                c.this.xg();
                com.baidu.live.entereffect.a.xa().u(list);
                c.this.x(list);
            }
        }.execute(new Void[0]);
    }

    public void x(List<com.baidu.live.entereffect.a.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a(d(new ArrayList(list), this.aFO != null ? new ArrayList(this.aFO) : null));
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
                    str = aVar.aFv;
                    z = false;
                }
                if (!TextUtils.isEmpty(str) && !aj(aVar.id, str)) {
                    new b().a(z, aVar, str, z ? eE(aVar.id) : eG(aVar.id), z ? eF(aVar.id) : eH(aVar.id));
                }
            }
        }
    }

    public com.baidu.live.entereffect.a.a eB(String str) {
        if (this.aFO == null || this.aFO.isEmpty()) {
            return null;
        }
        for (com.baidu.live.entereffect.a.a aVar : this.aFO) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void release() {
        com.baidu.live.f.b.bS(20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, com.baidu.live.entereffect.a.a aVar, String str, List<String> list) {
        boolean z2;
        if (this.aFO != null && !this.aFO.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar2 : this.aFO) {
                if (aVar.id.equals(aVar2.id)) {
                    if (z) {
                        if (list == null || list.isEmpty()) {
                            z2 = true;
                        } else {
                            aVar2.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            z2 = true;
                        }
                    } else {
                        aVar2.b(aVar.aFv, str, list);
                        z2 = true;
                    }
                    if (!z2) {
                        if (z) {
                            if (list != null && !list.isEmpty()) {
                                aVar.k(aVar.videoUrl, str, list.get(0), com.baidu.live.f.a.getFileMd5(new File(list.get(0))));
                            }
                        } else {
                            aVar.b(aVar.aFv, str, list);
                        }
                        if (this.aFO == null) {
                            this.aFO = new ArrayList();
                        }
                        this.aFO.add(aVar);
                    }
                    xg();
                }
            }
        }
        z2 = false;
        if (!z2) {
        }
        xg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe() {
        if (this.aFO != null) {
            this.aFO.clear();
        }
        com.baidu.live.c.vf().putString("enter_effect_dynamic_available_list", "");
        com.baidu.live.f.a.cleanDir(new File(this.DIR_PATH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.entereffect.a.a> xf() {
        String string = com.baidu.live.c.vf().getString("enter_effect_dynamic_available_list", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() != 0) {
                return com.baidu.live.entereffect.a.xa().i(jSONArray);
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
                    if (next2.aFw != null && next2.aFw.aGg != null) {
                        if (next.aFw == null) {
                            next.aFw = new com.baidu.live.gift.c();
                        }
                        next.aFw.aGg = next2.aFw.aGg;
                    }
                    if (com.baidu.live.alphavideo.a.vj().vk() && !TextUtils.isEmpty(next2.videoUrl) && !TextUtils.isEmpty(next.videoUrl) && next2.videoUrl.equals(next.videoUrl)) {
                        if (!TextUtils.isEmpty(next.videoMd5)) {
                            next.aFw.aGh = eF(next.id);
                            String xv = next.aFw.xv();
                            if (TextUtils.isEmpty(xv) || !next.videoMd5.equals(com.baidu.live.f.a.getFileMd5(new File(xv)))) {
                                z = true;
                            } else {
                                next.k(next.videoUrl, next.aFw.aGh, xv, next.videoMd5);
                                z = false;
                            }
                            z2 = z;
                        }
                    } else if (!TextUtils.isEmpty(next2.aFv) && !TextUtils.isEmpty(next.aFv) && next2.aFv.equals(next.aFv) && next.frameCount > 0) {
                        next.aFw.upZipDirPath = eH(next.id);
                        ArrayList<String> dynamicGiftPicPathList = next.aFw.getDynamicGiftPicPathList();
                        if (dynamicGiftPicPathList != null && dynamicGiftPicPathList.size() == next.frameCount) {
                            next.b(next.aFv, next.aFw.upZipDirPath, dynamicGiftPicPathList);
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
    public void y(List<com.baidu.live.entereffect.a.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.entereffect.a.a aVar : list) {
                com.baidu.live.f.a.cleanDir(new File(eE(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(eF(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(eG(aVar.id)));
                com.baidu.live.f.a.cleanDir(new File(eH(aVar.id)));
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
                                if (next2.aFw != null && !TextUtils.isEmpty(next2.aFw.xv())) {
                                    it.remove();
                                }
                            } else if (!TextUtils.isEmpty(next.aFv) && next2.aFw != null && next2.frameCount > 0 && (dynamicGiftPicPathList = next2.aFw.getDynamicGiftPicPathList()) != null && dynamicGiftPicPathList.size() == next2.frameCount) {
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
    public void xg() {
        if (this.aFO == null || this.aFO.isEmpty()) {
            com.baidu.live.c.vf().putString("enter_effect_dynamic_available_list", "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (com.baidu.live.entereffect.a.a aVar : this.aFO) {
            if (aVar.xc() != null) {
                jSONArray.put(aVar.xc());
            }
        }
        com.baidu.live.c.vf().putString("enter_effect_dynamic_available_list", jSONArray.toString());
    }

    private boolean aj(String str, String str2) {
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

    private String eE(String str) {
        return this.DIR_PATH + "video_zip_" + str + "/";
    }

    private String eF(String str) {
        return this.DIR_PATH + "video_" + str + "/";
    }

    private String eG(String str) {
        return this.DIR_PATH + str + "/";
    }

    private String eH(String str) {
        return eG(str);
    }

    private c() {
        this.DIR_PATH = TbadkCoreApplication.getInst().getApp().getFilesDir() + "/" + UbcStatConstant.ContentType.UBC_TYPE_ENTEREFFECT_DYNAMIC_LIST + "/";
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static c aFR = new c();
    }
}
