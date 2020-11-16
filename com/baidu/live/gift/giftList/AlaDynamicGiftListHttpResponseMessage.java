package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.d;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
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
    private ArrayList<com.baidu.live.gift.b> baN;

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
                String string = d.Aq().getSharedPreferences().getString("dynamic_cache_data_list", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject2 = new JSONObject(string);
                } else {
                    return;
                }
            } else {
                jSONObject2 = optJSONObject;
            }
            this.baN = F(jSONObject2);
            String Iq = getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).Iq() : null;
            if (!TextUtils.isEmpty(Iq)) {
                List<com.baidu.live.gift.b> L = L(this.baN);
                if (L != null) {
                    b(L, Iq);
                }
                d.Aq().putString("dynamic_cache_data_list", jSONObject2.toString());
            } else if (this.baN.size() <= 0) {
                com.baidu.live.gift.b.a.Iu().Gn();
                d.Aq().putString("dynamic_cache_data_list", "");
                u.gJ(null);
            } else {
                ho(d.Aq().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                d.Aq().putString("dynamic_cache_data_list", jSONObject2.toString());
                Ir();
                EE();
                b(this.baN, null);
            }
        }
    }

    private List<com.baidu.live.gift.b> L(List<com.baidu.live.gift.b> list) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        ArrayList arrayList2 = null;
        if (list != null && !list.isEmpty()) {
            String string = d.Aq().getSharedPreferences().getString("dynamic_cache_data_list", "");
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

    private void ho(String str) {
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
                    if (bVar != null && bVar.aSr != null && !TextUtils.isEmpty(bVar.aSr.zipName)) {
                        com.baidu.live.gift.b.a.Iu().gF(bVar.aSr.zipName);
                        u.gJ(bVar.aSr.zipName);
                    }
                }
            }
        }
    }

    private void Ir() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.BC().BD()) {
            File file = new File(com.baidu.live.gift.b.a.aUW);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.f.b.b(com.baidu.live.gift.b.a.aUW + name, com.baidu.live.f.b.gn("dynamic_video_md5_" + name))) {
                        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.gift.b.a.aUX + name));
                    }
                }
            }
        }
    }

    private void EE() {
        hp(com.baidu.live.gift.b.a.aUW);
        hp(com.baidu.live.gift.b.a.aUX);
    }

    private void hp(String str) {
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
                                if (com.baidu.live.gift.b.a.aUW.equals(str)) {
                                    str2 = com.baidu.live.ac.b.hW(name);
                                } else if (com.baidu.live.gift.b.a.aUX.equals(str)) {
                                    str2 = com.baidu.live.ac.b.hX(name);
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
        if ((!BdNetTypeUtil.isMobileNet() || !l.TW()) && list != null && !list.isEmpty()) {
            List<t> Gp = u.Gp();
            for (int i = 0; i < list.size(); i++) {
                com.baidu.live.gift.b bVar = list.get(i);
                if (bVar.aSr != null) {
                    if (Gp != null) {
                        for (t tVar : Gp) {
                            if (tVar.name.equals(bVar.aSr.zipName)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    com.baidu.live.gift.b.a.Iu().a(bVar, !TextUtils.isEmpty(str) && str.equals(bVar.giftId), z);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aSr == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aSr.videoMd5) && TextUtils.isEmpty(bVar.aSr.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.baN.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.baN.get(i);
            if ((!TextUtils.isEmpty(bVar2.aSr.videoMd5) && bVar2.aSr.videoMd5.equals(bVar.aSr.videoMd5)) || (!TextUtils.isEmpty(bVar2.aSr.zipMD5) && bVar2.aSr.zipMD5.equals(bVar.aSr.zipMD5))) {
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

    public ArrayList<com.baidu.live.gift.b> Is() {
        return this.baN;
    }

    public boolean EO() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
