package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.af;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class a implements af {
    private final String aXU;
    private com.baidu.live.gift.d.a bdk;
    private Context mContext;

    public a(Context context) {
        this.aXU = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.mContext = context;
        initModel();
    }

    @Override // com.baidu.live.gift.af
    public void fY(String str) {
        this.bdk.gp(str);
    }

    @Override // com.baidu.live.gift.af
    public void Ei() {
    }

    @Override // com.baidu.live.gift.af
    public void release() {
        if (this.bdk != null) {
            this.bdk.release();
        }
    }

    private void initModel() {
        this.bdk = new com.baidu.live.gift.d.a();
        this.bdk.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
            public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, List<k> list, int i2) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3, list, i2);
                a.this.a(z, arrayList, list, i2);
            }

            @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                a.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, List<h> list, List<k> list2, int i) {
        if (z) {
            z.DO().a(list, list2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, int i, String str, String str2, int i2) {
        if (z) {
            E(str2, i2);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            BdUtilHelper.showToast(this.mContext.getApplicationContext(), str);
        }
        if (i == 101) {
            if (this.bdk == null) {
                this.bdk = new com.baidu.live.gift.d.a();
            }
            this.bdk.gp("gift_send_101");
        }
    }

    private void gq(String str) {
        if (str != null) {
            HashSet<Object> hashSet = new HashSet();
            String string = SharedPrefHelper.getInstance().getString(this.aXU, "");
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
            SharedPrefHelper.getInstance().putString(this.aXU, jSONArray2.toString());
            AlaGiftTabView.aYV.remove(str);
        }
    }

    private void E(String str, int i) {
        List<h> datas;
        if (i == 0) {
            gq(str);
        }
        if (!TextUtils.isEmpty(str) && (datas = z.DO().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> Dg = hVar.Dg();
                if (Dg != null) {
                    if (i == 0) {
                        Iterator<g> it = Dg.iterator();
                        while (it.hasNext()) {
                            if (it.next().CC().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : Dg) {
                            if (gVar.CC().equals(str)) {
                                gVar.aSS.aTh = i;
                            }
                        }
                    }
                }
            }
            z.DO().H(arrayList);
        }
    }
}
