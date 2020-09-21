package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class XAdSlotManager {
    private HashMap<String, IXAdProd> a = new HashMap<>();

    public Boolean containsAdSlot(String str) {
        return Boolean.valueOf(this.a.containsKey(str));
    }

    public void addAdSlot(IXAdProd iXAdProd) {
        this.a.put(iXAdProd.getId(), iXAdProd);
    }

    public IXAdProd retrieveAdSlotById(String str) {
        return this.a.get(str);
    }

    public IXLinearAdSlot retrievePrerollAdSlot() {
        return (IXLinearAdSlot) retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL);
    }

    public IXLinearAdSlot retrievePostAdSlot() {
        return (IXLinearAdSlot) retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType.SLOT_TYPE_POSTROLL);
    }

    public IXAdProd retrievePauseAdSlot() {
        return retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType.SLOT_TYPE_PAUSE_ROLL);
    }

    public IXAdProd retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType slotType) {
        ArrayList<IXAdProd> retrieveAdSlotsByType = retrieveAdSlotsByType(slotType);
        if (retrieveAdSlotsByType.size() > 0) {
            return retrieveAdSlotsByType.get(0);
        }
        return null;
    }

    public ArrayList<IXAdProd> retrieveAdSlotsByType(IXAdConstants4PDK.SlotType slotType) {
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
