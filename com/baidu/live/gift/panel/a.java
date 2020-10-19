package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.g;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.i;
import com.baidu.live.gift.u;
import com.baidu.live.gift.y;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a implements y {
    private final String aWH;
    private com.baidu.live.gift.c.a bbw;
    private Context mContext;

    public a(Context context) {
        this.aWH = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.mContext = context;
        IF();
    }

    @Override // com.baidu.live.gift.y
    public void gS(String str) {
        this.bbw.hj(str);
    }

    @Override // com.baidu.live.gift.y
    public void Gx() {
    }

    @Override // com.baidu.live.gift.y
    public void release() {
        if (this.bbw != null) {
            this.bbw.release();
        }
    }

    private void IF() {
        this.bbw = new com.baidu.live.gift.c.a();
        this.bbw.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                a.this.c(z, arrayList);
            }

            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                a.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, List<i> list) {
        if (z) {
            u.Gg().H(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            B(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.bbw == null) {
                this.bbw = new com.baidu.live.gift.c.a();
            }
            this.bbw.hj("gift_send_101");
        }
    }

    private void hk(String str) {
        if (str != null) {
            HashSet<Object> hashSet = new HashSet();
            String string = SharedPrefHelper.getInstance().getString(this.aWH, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(jSONArray.optString(i));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            hashSet.remove(str);
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray2.put(obj);
            }
            SharedPrefHelper.getInstance().putString(this.aWH, jSONArray2.toString());
            AlaGiftTabView.aXD.remove(str);
        }
    }

    private void B(String str, int i) {
        List<i> datas;
        if (i == 0) {
            hk(str);
        }
        if (!TextUtils.isEmpty(str) && (datas = u.Gg().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<com.baidu.live.gift.g> FE = iVar.FE();
                if (FE != null) {
                    if (i == 0) {
                        Iterator<com.baidu.live.gift.g> it = FE.iterator();
                        while (it.hasNext()) {
                            if (it.next().Fd().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (com.baidu.live.gift.g gVar : FE) {
                            if (gVar.Fd().equals(str)) {
                                gVar.aSt.aSG = i;
                            }
                        }
                    }
                }
            }
            u.Gg().H(arrayList);
        }
    }
}
