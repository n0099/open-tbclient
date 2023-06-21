package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.bz3;
import com.baidu.tieba.dl1;
import com.baidu.tieba.uc3;
import com.baidu.tieba.vc3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements dl1 {
    @Override // com.baidu.tieba.dl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new uc3());
        arrayList.add(new vc3());
        arrayList.add(new bz3());
        return arrayList;
    }
}
