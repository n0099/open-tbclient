package com.baidu.live.gift.giftList;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.l;
import com.baidu.live.utils.s;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> aWx;
    private JSONObject aWy;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aWy = jSONObject.optJSONObject("data");
            if (this.aWy != null) {
                this.aWx = G(this.aWy);
                if (this.aWx.size() <= 0) {
                    com.baidu.live.gift.b.a.Hl();
                    com.baidu.live.c.AR().putString("dynamic_cache_data_list", "");
                    return;
                }
                gO(com.baidu.live.c.AR().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.AR().putString("dynamic_cache_data_list", this.aWy.toString());
                Hh();
                DC();
                Hi();
            }
        }
    }

    private void gO(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = G(new JSONObject(str));
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
                    if (bVar != null && bVar.aOD != null && !TextUtils.isEmpty(bVar.aOD.zipName)) {
                        com.baidu.live.gift.b.a.gT(bVar.aOD.zipName);
                    }
                }
            }
        }
    }

    private void Hh() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.AW().AX()) {
            File file = new File(com.baidu.live.gift.b.a.aWK);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.f.b.b(com.baidu.live.gift.b.a.aWK + name, com.baidu.live.f.b.fZ("dynamic_video_md5_" + name))) {
                        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.gift.b.a.aWL + name));
                    }
                }
            }
        }
    }

    private void DC() {
        gP(com.baidu.live.gift.b.a.aWK);
        gP(com.baidu.live.gift.b.a.aWL);
    }

    private void gP(String str) {
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
                                if (com.baidu.live.gift.b.a.aWK.equals(str)) {
                                    str2 = s.hI(name);
                                } else if (com.baidu.live.gift.b.a.aWL.equals(str)) {
                                    str2 = s.hJ(name);
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

    private void Hi() {
        if (!BdNetTypeUtil.isMobileNet() || !l.PM()) {
            for (int i = 0; i < this.aWx.size(); i++) {
                com.baidu.live.gift.b bVar = this.aWx.get(i);
                if (bVar.aOD != null) {
                    com.baidu.live.gift.b.a.a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aOD == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aOD.videoMd5) && TextUtils.isEmpty(bVar.aOD.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aWx.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.aWx.get(i);
            if ((!TextUtils.isEmpty(bVar2.aOD.videoMd5) && bVar2.aOD.videoMd5.equals(bVar.aOD.videoMd5)) || (!TextUtils.isEmpty(bVar2.aOD.zipMD5) && bVar2.aOD.zipMD5.equals(bVar.aOD.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> G(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> Hj() {
        return this.aWx;
    }

    public boolean DK() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
