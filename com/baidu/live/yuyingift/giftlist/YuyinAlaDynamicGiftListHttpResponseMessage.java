package com.baidu.live.yuyingift.giftlist;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.d;
import com.baidu.live.gift.am;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinAlaDynamicGiftListHttpResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<com.baidu.live.gift.b> bbG;
    private JSONObject bda;

    public YuyinAlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031058) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bda = jSONObject.optJSONObject("data");
            if (this.bda != null) {
                this.bbG = M(this.bda);
                String FX = getOrginalMessage() instanceof c ? ((c) getOrginalMessage()).FX() : null;
                if (!TextUtils.isEmpty(FX)) {
                    List<com.baidu.live.gift.b> M = M(this.bbG);
                    if (M != null) {
                        b(M, FX);
                    }
                    d.xf().putString("dynamic_cache_data_list", this.bda.toString());
                } else if (this.bbG.size() <= 0) {
                    am.Em().DI();
                    d.xf().putString("dynamic_cache_data_list", "");
                    v.fD(null);
                } else {
                    gl(d.xf().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                    d.xf().putString("dynamic_cache_data_list", this.bda.toString());
                    FY();
                    BN();
                    b(this.bbG, null);
                }
            }
        }
    }

    private List<com.baidu.live.gift.b> M(List<com.baidu.live.gift.b> list) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        ArrayList arrayList2 = null;
        if (list != null && !list.isEmpty()) {
            String string = d.xf().getSharedPreferences().getString("dynamic_cache_data_list", "");
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

    private void gl(String str) {
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
                    if (bVar != null && bVar.aSl != null && !TextUtils.isEmpty(bVar.aSl.zipName)) {
                        am.Em().fz(bVar.aSl.zipName);
                        v.fD(bVar.aSl.zipName);
                    }
                }
            }
        }
    }

    private void BN() {
        gm(am.aUZ);
        gm(am.aVa);
    }

    private void gm(String str) {
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
                                if (am.aUZ.equals(str)) {
                                    str2 = com.baidu.live.ah.b.hc(name);
                                } else if (am.aVa.equals(str)) {
                                    str2 = com.baidu.live.ah.b.hd(name);
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

    private void FY() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.yH().yI()) {
            File file = new File(am.aUZ);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.i.b.b(am.aUZ + name, com.baidu.live.i.b.fh("dynamic_video_md5_" + name))) {
                        com.baidu.live.i.a.cleanDir(new File(am.aVa + name));
                    }
                }
            }
        }
    }

    private void b(List<com.baidu.live.gift.b> list, String str) {
        boolean z;
        if ((!BdNetTypeUtil.isMobileNet() || !m.TI()) && list != null && !list.isEmpty()) {
            List<u> DK = v.DK();
            for (int i = 0; i < list.size(); i++) {
                com.baidu.live.gift.b bVar = list.get(i);
                if (bVar.aSl != null) {
                    if (DK != null) {
                        for (u uVar : DK) {
                            if (uVar.name.equals(bVar.aSl.zipName)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    am.Em().a(bVar, !TextUtils.isEmpty(str) && str.equals(bVar.giftId), z);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aSl == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aSl.videoMd5) && TextUtils.isEmpty(bVar.aSl.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.bbG.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.bbG.get(i);
            if ((!TextUtils.isEmpty(bVar2.aSl.videoMd5) && bVar2.aSl.videoMd5.equals(bVar.aSl.videoMd5)) || (!TextUtils.isEmpty(bVar2.aSl.zipMD5) && bVar2.aSl.zipMD5.equals(bVar.aSl.zipMD5))) {
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

    public ArrayList<com.baidu.live.gift.b> FZ() {
        return this.bbG;
    }

    public boolean BX() {
        if (getOrginalMessage() instanceof c) {
            return ((c) getOrginalMessage()).isHost();
        }
        return false;
    }
}
