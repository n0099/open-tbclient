package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.fy3;
import com.baidu.tieba.hk1;
import com.baidu.tieba.yb3;
import com.baidu.tieba.zb3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements hk1 {
    @Override // com.baidu.tieba.hk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new yb3());
        arrayList.add(new zb3());
        arrayList.add(new fy3());
        return arrayList;
    }
}
