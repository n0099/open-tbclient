package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.k63;
import com.baidu.tieba.l63;
import com.baidu.tieba.rs3;
import com.baidu.tieba.ue1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements ue1 {
    @Override // com.baidu.tieba.ue1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new k63());
        arrayList.add(new l63());
        arrayList.add(new rs3());
        return arrayList;
    }
}
