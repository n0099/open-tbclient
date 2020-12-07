package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.d;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.l;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> beL;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2;
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (getError() != 0 || optJSONObject == null) {
                String string = d.BM().getSharedPreferences().getString("dynamic_cache_data_list", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject2 = new JSONObject(string);
                } else {
                    return;
                }
            } else {
                jSONObject2 = optJSONObject;
            }
            this.beL = F(jSONObject2);
            String Kq = getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).Kq() : null;
            if (!TextUtils.isEmpty(Kq)) {
                List<com.baidu.live.gift.b> M = M(this.beL);
                if (M != null) {
                    b(M, Kq);
                }
                d.BM().putString("dynamic_cache_data_list", jSONObject2.toString());
            } else if (this.beL.size() <= 0) {
                com.baidu.live.gift.c.a.Ku().Ic();
                d.BM().putString("dynamic_cache_data_list", "");
                v.he(null);
            } else {
                hM(d.BM().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                d.BM().putString("dynamic_cache_data_list", jSONObject2.toString());
                Kr();
                Gp();
                b(this.beL, null);
            }
        }
    }

    private List<com.baidu.live.gift.b> M(List<com.baidu.live.gift.b> list) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        ArrayList arrayList2 = null;
        if (list != null && !list.isEmpty()) {
            String string = d.BM().getSharedPreferences().getString("dynamic_cache_data_list", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    arrayList = F(new JSONObject(string));
                } catch (Exception e) {
                    e.printStackTrace();
                    arrayList = null;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    HashSet hashSet = new HashSet();
                    for (com.baidu.live.gift.b bVar : arrayList) {
                        hashSet.add(bVar.giftId);
                    }
                    for (com.baidu.live.gift.b bVar2 : list) {
                        if (!hashSet.contains(bVar2.giftId)) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(bVar2);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    private void hM(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = F(new JSONObject(str));
            } catch (Exception e) {
                arrayList = null;
            }
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!a(arrayList.get(i))) {
                        arrayList2.add(arrayList.get(i));
                    }
                }
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    com.baidu.live.gift.b bVar = (com.baidu.live.gift.b) arrayList2.get(i2);
                    if (bVar != null && bVar.aVt != null && !TextUtils.isEmpty(bVar.aVt.zipName)) {
                        com.baidu.live.gift.c.a.Ku().ha(bVar.aVt.zipName);
                        v.he(bVar.aVt.zipName);
                    }
                }
            }
        }
    }

    private void Kr() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.Dl().Dm()) {
            File file = new File(com.baidu.live.gift.c.a.aYh);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.h.b.b(com.baidu.live.gift.c.a.aYh + name, com.baidu.live.h.b.gJ("dynamic_video_md5_" + name))) {
                        com.baidu.live.h.a.cleanDir(new File(com.baidu.live.gift.c.a.aYi + name));
                    }
                }
            }
        }
    }

    private void Gp() {
        hN(com.baidu.live.gift.c.a.aYh);
        hN(com.baidu.live.gift.c.a.aYi);
    }

    private void hN(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
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
                        String name = file2.getName();
                        if (TextUtils.isEmpty(name)) {
                            file2.delete();
                        } else {
                            File[] listFiles2 = file2.listFiles();
                            if (listFiles2.length == 0) {
                                file2.delete();
                            } else {
                                String str2 = null;
                                if (com.baidu.live.gift.c.a.aYh.equals(str)) {
                                    str2 = com.baidu.live.ag.b.iA(name);
                                } else if (com.baidu.live.gift.c.a.aYi.equals(str)) {
                                    str2 = com.baidu.live.ag.b.iB(name);
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    File file3 = new File(str2);
                                    if (file3.exists() || file3.mkdirs()) {
                                        for (File file4 : listFiles2) {
                                            String name2 = file4.getName();
                                            if (!TextUtils.isEmpty(name2) && !"zip".equals(name2.substring(name2.lastIndexOf(".") + 1))) {
                                                file4.renameTo(new File(str2 + "/" + name2));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(List<com.baidu.live.gift.b> list, String str) {
        boolean z;
        if ((!BdNetTypeUtil.isMobileNet() || !l.Ww()) && list != null && !list.isEmpty()) {
            List<u> Ie = v.Ie();
            for (int i = 0; i < list.size(); i++) {
                com.baidu.live.gift.b bVar = list.get(i);
                if (bVar.aVt != null) {
                    if (Ie != null) {
                        for (u uVar : Ie) {
                            if (uVar.name.equals(bVar.aVt.zipName)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    com.baidu.live.gift.c.a.Ku().a(bVar, !TextUtils.isEmpty(str) && str.equals(bVar.giftId), z);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aVt == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aVt.videoMd5) && TextUtils.isEmpty(bVar.aVt.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.beL.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.beL.get(i);
            if ((!TextUtils.isEmpty(bVar2.aVt.videoMd5) && bVar2.aVt.videoMd5.equals(bVar.aVt.videoMd5)) || (!TextUtils.isEmpty(bVar2.aVt.zipMD5) && bVar2.aVt.zipMD5.equals(bVar.aVt.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> F(JSONObject jSONObject) throws Exception {
        ArrayList<com.baidu.live.gift.b> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("dynamic_gift_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    bVar.parseJson(optJSONObject);
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<com.baidu.live.gift.b> Ks() {
        return this.beL;
    }

    public boolean Gz() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
