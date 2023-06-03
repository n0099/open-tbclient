package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.az3;
import com.baidu.tieba.cl1;
import com.baidu.tieba.tc3;
import com.baidu.tieba.uc3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements cl1 {
    @Override // com.baidu.tieba.cl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new tc3());
        arrayList.add(new uc3());
        arrayList.add(new az3());
        return arrayList;
    }
}
