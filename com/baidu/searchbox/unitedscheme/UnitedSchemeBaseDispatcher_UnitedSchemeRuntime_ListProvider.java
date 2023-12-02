package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.f73;
import com.baidu.tieba.g73;
import com.baidu.tieba.mt3;
import com.baidu.tieba.pf1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new f73());
        arrayList.add(new g73());
        arrayList.add(new mt3());
        return arrayList;
    }
}
