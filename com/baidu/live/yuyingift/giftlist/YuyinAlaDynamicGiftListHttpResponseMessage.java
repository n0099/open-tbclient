package com.baidu.live.yuyingift.giftlist;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.d;
import com.baidu.live.gift.al;
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
public class YuyinAlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> bbg;
    private JSONObject bcB;

    public YuyinAlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031058) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bcB = jSONObject.optJSONObject("data");
            if (this.bcB != null) {
                this.bbg = I(this.bcB);
                String Iy = getOrginalMessage() instanceof c ? ((c) getOrginalMessage()).Iy() : null;
                if (!TextUtils.isEmpty(Iy)) {
                    List<com.baidu.live.gift.b> L = L(this.bbg);
                    if (L != null) {
                        b(L, Iy);
                    }
                    d.AZ().putString("dynamic_cache_data_list", this.bcB.toString());
                } else if (this.bbg.size() <= 0) {
                    al.GW().Gv();
                    d.AZ().putString("dynamic_cache_data_list", "");
                    v.gK(null);
                } else {
                    hn(d.AZ().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                    d.AZ().putString("dynamic_cache_data_list", this.bcB.toString());
                    Iz();
                    EM();
                    b(this.bbg, null);
                }
            }
        }
    }

    private List<com.baidu.live.gift.b> L(List<com.baidu.live.gift.b> list) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        ArrayList arrayList2 = null;
        if (list != null && !list.isEmpty()) {
            String string = d.AZ().getSharedPreferences().getString("dynamic_cache_data_list", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    arrayList = I(new JSONObject(string));
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

    private void hn(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = I(new JSONObject(str));
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
                    if (bVar != null && bVar.aSJ != null && !TextUtils.isEmpty(bVar.aSJ.zipName)) {
                        al.GW().gG(bVar.aSJ.zipName);
                        v.gK(bVar.aSJ.zipName);
                    }
                }
            }
        }
    }

    private void EM() {
        ho(al.aVp);
        ho(al.aVq);
    }

    private void ho(String str) {
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
                                if (al.aVp.equals(str)) {
                                    str2 = com.baidu.live.ab.b.hV(name);
                                } else if (al.aVq.equals(str)) {
                                    str2 = com.baidu.live.ab.b.hW(name);
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

    private void Iz() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.BT().BU()) {
            File file = new File(al.aVp);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.f.b.b(al.aVp + name, com.baidu.live.f.b.go("dynamic_video_md5_" + name))) {
                        com.baidu.live.f.a.cleanDir(new File(al.aVq + name));
                    }
                }
            }
        }
    }

    private void b(List<com.baidu.live.gift.b> list, String str) {
        boolean z;
        if ((!BdNetTypeUtil.isMobileNet() || !l.RX()) && list != null && !list.isEmpty()) {
            List<u> Gx = v.Gx();
            for (int i = 0; i < list.size(); i++) {
                com.baidu.live.gift.b bVar = list.get(i);
                if (bVar.aSJ != null) {
                    if (Gx != null) {
                        for (u uVar : Gx) {
                            if (uVar.name.equals(bVar.aSJ.zipName)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    al.GW().a(bVar, !TextUtils.isEmpty(str) && str.equals(bVar.giftId), z);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aSJ == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aSJ.videoMd5) && TextUtils.isEmpty(bVar.aSJ.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.bbg.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.bbg.get(i);
            if ((!TextUtils.isEmpty(bVar2.aSJ.videoMd5) && bVar2.aSJ.videoMd5.equals(bVar.aSJ.videoMd5)) || (!TextUtils.isEmpty(bVar2.aSJ.zipMD5) && bVar2.aSJ.zipMD5.equals(bVar.aSJ.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> I(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> IA() {
        return this.bbg;
    }

    public boolean EW() {
        if (getOrginalMessage() instanceof c) {
            return ((c) getOrginalMessage()).isHost();
        }
        return false;
    }
}
