package com.baidu.live.gift.panel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.container.AlaGiftTabView;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a implements ae {
    private final String aYc;
    private com.baidu.live.gift.c.a bcK;
    private Context mContext;

    public a(Context context) {
        this.aYc = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.mContext = context;
        IY();
    }

    @Override // com.baidu.live.gift.ae
    public void hd(String str) {
        this.bcK.hr(str);
    }

    @Override // com.baidu.live.gift.ae
    public void GS() {
    }

    @Override // com.baidu.live.gift.ae
    public void release() {
        if (this.bcK != null) {
            this.bcK.release();
        }
    }

    private void IY() {
        this.bcK = new com.baidu.live.gift.c.a();
        this.bcK.a(new com.baidu.live.gift.c.b() { // from class: com.baidu.live.gift.panel.a.1
            @Override // com.baidu.live.gift.c.b, com.baidu.live.gift.c.c.a
            public void a(boolean z, int i, String str, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3) {
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
    public void b(boolean z, List<i> list) {
        if (z) {
            z.GB().G(list);
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
            if (this.bcK == null) {
                this.bcK = new com.baidu.live.gift.c.a();
            }
            this.bcK.hr("gift_send_101");
        }
    }

    private void hs(String str) {
        if (str != null) {
            HashSet<Object> hashSet = new HashSet();
            String string = SharedPrefHelper.getInstance().getString(this.aYc, "");
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
            SharedPrefHelper.getInstance().putString(this.aYc, jSONArray2.toString());
            AlaGiftTabView.aYY.remove(str);
        }
    }

    private void B(String str, int i) {
        List<i> datas;
        if (i == 0) {
            hs(str);
        }
        if (!TextUtils.isEmpty(str) && (datas = z.GB().getDatas()) != null) {
            ArrayList<i> arrayList = new ArrayList(datas);
            for (i iVar : arrayList) {
                List<g> FT = iVar.FT();
                if (FT != null) {
                    if (i == 0) {
                        Iterator<g> it = FT.iterator();
                        while (it.hasNext()) {
                            if (it.next().Fs().equals(str)) {
                                it.remove();
                            }
                        }
                    } else {
                        for (g gVar : FT) {
                            if (gVar.Fs().equals(str)) {
                                gVar.aTp.aTC = i;
                            }
                        }
                    }
                }
            }
            z.GB().G(arrayList);
        }
    }
}
