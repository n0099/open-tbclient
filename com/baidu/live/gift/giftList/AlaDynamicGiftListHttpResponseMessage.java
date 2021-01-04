package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.d;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> bgx;

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
                String string = d.Ba().getSharedPreferences().getString("dynamic_cache_data_list", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject2 = new JSONObject(string);
                } else {
                    return;
                }
            } else {
                jSONObject2 = optJSONObject;
            }
            this.bgx = M(jSONObject2);
            String JS = getOrginalMessage() instanceof a ? ((a) getOrginalMessage()).JS() : null;
            if (!TextUtils.isEmpty(JS)) {
                List<com.baidu.live.gift.b> M = M(this.bgx);
                if (M != null) {
                    b(M, JS);
                }
                d.Ba().putString("dynamic_cache_data_list", jSONObject2.toString());
            } else if (this.bgx.size() <= 0) {
                com.baidu.live.gift.c.a.JV().HD();
                d.Ba().putString("dynamic_cache_data_list", "");
                v.gP(null);
            } else {
                hx(d.Ba().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                d.Ba().putString("dynamic_cache_data_list", jSONObject2.toString());
                JT();
                FI();
                b(this.bgx, null);
            }
        }
    }

    private List<com.baidu.live.gift.b> M(List<com.baidu.live.gift.b> list) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        ArrayList arrayList2 = null;
        if (list != null && !list.isEmpty()) {
            String string = d.Ba().getSharedPreferences().getString("dynamic_cache_data_list", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    arrayList = M(new JSONObject(string));
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

    private void hx(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = M(new JSONObject(str));
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
                    if (bVar != null && bVar.aWY != null && !TextUtils.isEmpty(bVar.aWY.zipName)) {
                        com.baidu.live.gift.c.a.JV().gL(bVar.aWY.zipName);
                        v.gP(bVar.aWY.zipName);
                    }
                }
            }
        }
    }

    private void JT() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.CC().CD()) {
            File file = new File(com.baidu.live.gift.c.a.aZM);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.i.b.b(com.baidu.live.gift.c.a.aZM + name, com.baidu.live.i.b.gt("dynamic_video_md5_" + name))) {
                        com.baidu.live.i.a.cleanDir(new File(com.baidu.live.gift.c.a.aZN + name));
                    }
                }
            }
        }
    }

    private void FI() {
        hy(com.baidu.live.gift.c.a.aZM);
        hy(com.baidu.live.gift.c.a.aZN);
    }

    private void hy(String str) {
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
                                if (com.baidu.live.gift.c.a.aZM.equals(str)) {
                                    str2 = com.baidu.live.ah.b.in(name);
                                } else if (com.baidu.live.gift.c.a.aZN.equals(str)) {
                                    str2 = com.baidu.live.ah.b.io(name);
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
        if (list != null && !list.isEmpty()) {
            List<u> HF = v.HF();
            for (int i = 0; i < list.size(); i++) {
                com.baidu.live.gift.b bVar = list.get(i);
                if (bVar.aWY != null) {
                    if (HF != null) {
                        for (u uVar : HF) {
                            if (uVar.name.equals(bVar.aWY.zipName)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    com.baidu.live.gift.c.a.JV().a(bVar, !TextUtils.isEmpty(str) && str.equals(bVar.giftId), z);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aWY == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aWY.videoMd5) && TextUtils.isEmpty(bVar.aWY.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.bgx.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.bgx.get(i);
            if ((!TextUtils.isEmpty(bVar2.aWY.videoMd5) && bVar2.aWY.videoMd5.equals(bVar.aWY.videoMd5)) || (!TextUtils.isEmpty(bVar2.aWY.zipMD5) && bVar2.aWY.zipMD5.equals(bVar.aWY.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> M(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> JU() {
        return this.bgx;
    }

    public boolean FS() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
