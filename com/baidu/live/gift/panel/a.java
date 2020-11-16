package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.j;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
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
public class a implements ad {
    private final String aXJ;
    private com.baidu.live.gift.c.a bcs;
    private Context mContext;

    public a(Context context) {
        this.aXJ = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.mContext = context;
        IQ();
    }

    @Override // com.baidu.live.gift.ad
    public void he(String str) {
        this.bcs.hs(str);
    }

    @Override // com.baidu.live.gift.ad
    public void GK() {
    }

    @Override // com.baidu.live.gift.ad
    public void release() {
        if (this.bcs != null) {
            this.bcs.release();
        }
    }

    private void IQ() {
        this.bcs = new com.baidu.live.gift.c.a();
        this.bcs.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3) {
                super.a(z, i, str, arrayList, arrayList2, arrayList3);
                a.this.b(z, arrayList);
            }

            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, String str2, int i2) {
                super.a(z, i, str, str2, i2);
                a.this.b(z, i, str, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, List<h> list) {
        if (z) {
            y.Gt().G(list);
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
            if (this.bcs == null) {
                this.bcs = new com.baidu.live.gift.c.a();
            }
            this.bcs.hs("gift_send_101");
        }
    }

    private void ht(String str) {
        if (str != null) {
            HashSet<Object> hashSet = new HashSet();
            String string = SharedPrefHelper.getInstance().getString(this.aXJ, "");
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
            SharedPrefHelper.getInstance().putString(this.aXJ, jSONArray2.toString());
            AlaGiftTabView.aYF.remove(str);
        }
    }

    private void B(String str, int i) {
        List<h> datas;
        if (i == 0) {
            ht(str);
        }
        if (!TextUtils.isEmpty(str) && (datas = y.Gt().getDatas()) != null) {
            ArrayList<h> arrayList = new ArrayList(datas);
            for (h hVar : arrayList) {
                List<g> FL = hVar.FL();
                if (FL != null) {
                    if (i == 0) {
                        Iterator<g> it = FL.iterator();
                        while (it.hasNext()) {
                            if (it.next().Fk().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : FL) {
                            if (gVar.Fk().equals(str)) {
                                gVar.aSX.aTk = i;
                            }
                        }
                    }
                }
            }
            y.Gt().G(arrayList);
        }
    }
}
