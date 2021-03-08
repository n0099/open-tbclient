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
    private ArrayList<com.baidu.live.gift.b> bgp;
    private JSONObject bhK;

    public YuyinAlaDynamicGiftListHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null && i == 1031058) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.bhK = jSONObject.optJSONObject("data");
            if (this.bhK != null) {
                this.bgp = O(this.bhK);
                String Hq = getOrginalMessage() instanceof c ? ((c) getOrginalMessage()).Hq() : null;
                if (!TextUtils.isEmpty(Hq)) {
                    List<com.baidu.live.gift.b> M = M(this.bgp);
                    if (M != null) {
                        b(M, Hq);
                    }
                    d.xf().putString("dynamic_cache_data_list", this.bhK.toString());
                } else if (this.bgp.size() <= 0) {
                    am.FF().Fb();
                    d.xf().putString("dynamic_cache_data_list", "");
                    v.ge(null);
                } else {
                    gP(d.xf().getSharedPreferences().getString("dynamic_cache_data_list", ""));
                    d.xf().putString("dynamic_cache_data_list", this.bhK.toString());
                    Hr();
                    Df();
                    b(this.bgp, null);
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
                    arrayList = O(new JSONObject(string));
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

    private void gP(String str) {
        ArrayList<com.baidu.live.gift.b> arrayList;
        if (!TextUtils.isEmpty(str)) {
            try {
                arrayList = O(new JSONObject(str));
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
                    if (bVar != null && bVar.aWP != null && !TextUtils.isEmpty(bVar.aWP.zipName)) {
                        am.FF().ga(bVar.aWP.zipName);
                        v.ge(bVar.aWP.zipName);
                    }
                }
            }
        }
    }

    private void Df() {
        gQ(am.aZH);
        gQ(am.aZI);
    }

    private void gQ(String str) {
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
                                if (am.aZH.equals(str)) {
                                    str2 = com.baidu.live.storage.b.hE(name);
                                } else if (am.aZI.equals(str)) {
                                    str2 = com.baidu.live.storage.b.hF(name);
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

    private void Hr() {
        File[] listFiles;
        if (com.baidu.live.alphavideo.a.zr().zs()) {
            File file = new File(am.aZH);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    String name = file2.getName();
                    if (!TextUtils.isEmpty(name) && !com.baidu.live.h.b.b(am.aZH + name, com.baidu.live.h.b.fI("dynamic_video_md5_" + name))) {
                        com.baidu.live.h.a.cleanDir(new File(am.aZI + name));
                    }
                }
            }
        }
    }

    private void b(List<com.baidu.live.gift.b> list, String str) {
        boolean z;
        if ((!BdNetTypeUtil.isMobileNet() || !m.Vs()) && list != null && !list.isEmpty()) {
            List<u> Fd = v.Fd();
            for (int i = 0; i < list.size(); i++) {
                com.baidu.live.gift.b bVar = list.get(i);
                if (bVar.aWP != null) {
                    if (Fd != null) {
                        for (u uVar : Fd) {
                            if (uVar.name.equals(bVar.aWP.zipName) && uVar.aWR > 0) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    am.FF().a(bVar, !TextUtils.isEmpty(str) && str.equals(bVar.giftId), z);
                }
            }
        }
    }

    private boolean a(com.baidu.live.gift.b bVar) {
        if (bVar == null || bVar.aWP == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.aWP.videoMd5) && TextUtils.isEmpty(bVar.aWP.zipMD5)) {
            return false;
        }
        for (int i = 0; i < this.bgp.size(); i++) {
            com.baidu.live.gift.b bVar2 = this.bgp.get(i);
            if ((!TextUtils.isEmpty(bVar2.aWP.videoMd5) && bVar2.aWP.videoMd5.equals(bVar.aWP.videoMd5)) || (!TextUtils.isEmpty(bVar2.aWP.zipMD5) && bVar2.aWP.zipMD5.equals(bVar.aWP.zipMD5))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<com.baidu.live.gift.b> O(JSONObject jSONObject) throws Exception {
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

    public ArrayList<com.baidu.live.gift.b> Hs() {
        return this.bgp;
    }

    public boolean Dp() {
        if (getOrginalMessage() instanceof c) {
            return ((c) getOrginalMessage()).isHost();
        }
        return false;
    }
}
