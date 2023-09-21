package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.bc3;
import com.baidu.tieba.cc3;
import com.baidu.tieba.iy3;
import com.baidu.tieba.kk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements kk1 {
    @Override // com.baidu.tieba.kk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new bc3());
        arrayList.add(new cc3());
        arrayList.add(new iy3());
        return arrayList;
    }
}
