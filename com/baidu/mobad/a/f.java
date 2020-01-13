package com.baidu.mobad.a;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class f {
    private HashMap<String, IXAdProd> a = new HashMap<>();

    public Boolean er(String str) {
        return Boolean.valueOf(this.a.containsKey(str));
    }

    public void a(IXAdProd iXAdProd) {
        this.a.put(iXAdProd.getId(), iXAdProd);
    }

    public IXAdProd es(String str) {
        return this.a.get(str);
    }

    public IXLinearAdSlot BM() {
        return (IXLinearAdSlot) a(IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL);
    }

    public IXAdProd a(IXAdConstants4PDK.SlotType slotType) {
        ArrayList<IXAdProd> b = b(slotType);
        if (b.size() > 0) {
            return b.get(0);
        }
        return null;
    }

    public ArrayList<IXAdProd> b(IXAdConstants4PDK.SlotType slotType) {
        ArrayList<IXAdProd> arrayList = new ArrayList<>();
        for (String str : this.a.keySet()) {
            IXAdProd iXAdProd = this.a.get(str);
            if (iXAdProd.getType() == slotType) {
                arrayList.add(iXAdProd);
            }
        }
        return arrayList;
    }
}
