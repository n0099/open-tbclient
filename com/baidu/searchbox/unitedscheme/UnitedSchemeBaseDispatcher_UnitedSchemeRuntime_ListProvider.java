package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.ez3;
import com.baidu.tieba.gl1;
import com.baidu.tieba.xc3;
import com.baidu.tieba.yc3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements gl1 {
    @Override // com.baidu.tieba.gl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new xc3());
        arrayList.add(new yc3());
        arrayList.add(new ez3());
        return arrayList;
    }
}
