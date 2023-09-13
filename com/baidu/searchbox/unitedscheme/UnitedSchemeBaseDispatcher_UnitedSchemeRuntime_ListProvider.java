package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.cc3;
import com.baidu.tieba.dc3;
import com.baidu.tieba.jy3;
import com.baidu.tieba.lk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements lk1 {
    @Override // com.baidu.tieba.lk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new cc3());
        arrayList.add(new dc3());
        arrayList.add(new jy3());
        return arrayList;
    }
}
