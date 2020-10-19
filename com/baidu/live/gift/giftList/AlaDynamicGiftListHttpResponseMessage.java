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
    private ArrayList<com.baidu.live.gift.b> aZI;
    private JSONObject aZJ;

    public AlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1021089) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aZJ = jSONObject.optJSONObject("data");
            if (this.aZJ != null) {
                this.aZI = G(this.aZJ);
                if (this.aZI.size() <= 0) {
                    com.baidu.live.gift.b.a.Ih().Ii();
                    com.baidu.live.c.AZ().putString("dynamic_cache_data_list", "");
                    return;
                }
                hc(com.baidu.live.c.AZ().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                com.baidu.live.c.AZ().putString("dynamic_cache_data_list", this.aZJ.toString());
                Id();
                Ez();
                Ie();
            }
        }
    }

    private void hc(String str) {
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
                    if (bVar != null && bVar.aRO != null && !TextUtils.isEmpty(bVar.aRO.zipName)) {
                        com.baidu.live.gift.b.a.Ih().he(bVar.aRO.zipName);
                    }
                }
            }
        }
    }

    private void Id() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.BT().BU()) {
            File file = new File(com.baidu.live.gift.b.a.aZV);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.f.b.b(com.baidu.live.gift.b.a.aZV + name, com.baidu.live.f.b.gn("dynamic_video_md5_" + name))) {
                        com.baidu.live.f.a.cleanDir(new File(com.baidu.live.gift.b.a.aZW + name));
                    }
                }
            }
        }
    }

    private void Ez() {
        hd(com.baidu.live.gift.b.a.aZV);
        hd(com.baidu.live.gift.b.a.aZW);
    }

    private void hd(String str) {
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
                                if (com.baidu.live.gift.b.a.aZV.equals(str)) {
                                    str2 = s.hZ(name);
                                } else if (com.baidu.live.gift.b.a.aZW.equals(str)) {
                                    str2 = s.ia(name);
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

    private void Ie() {
        if (!BdNetTypeUtil.isMobileNet() || !l.QR()) {
            for (int i = 0; i < this.aZI.size(); i++) {
                com.baidu.live.gift.b bVar = this.aZI.get(i);
                if (bVar.aRO != null) {
                    com.baidu.live.gift.b.a.Ih().a(bVar, false);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aRO == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aRO.videoMd5) && TextUtils.isEmpty(bVar.aRO.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.aZI.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.aZI.get(i);
            if ((!TextUtils.isEmpty(bVar2.aRO.videoMd5) && bVar2.aRO.videoMd5.equals(bVar.aRO.videoMd5)) || (!TextUtils.isEmpty(bVar2.aRO.zipMD5) && bVar2.aRO.zipMD5.equals(bVar.aRO.zipMD5))) {
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

    public ArrayList<com.baidu.live.gift.b> If() {
        return this.aZI;
    }

    public boolean EH() {
        if (getOrginalMessage() instanceof a) {
            return ((a) getOrginalMessage()).isHost();
        }
        return false;
    }
}
