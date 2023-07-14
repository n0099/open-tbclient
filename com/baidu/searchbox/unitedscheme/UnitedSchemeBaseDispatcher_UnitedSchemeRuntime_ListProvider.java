package com.baidu.searchbox.unitedscheme;

import com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemePublicDispatcher;
import com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher;
import com.baidu.tieba.qc3;
import com.baidu.tieba.rc3;
import com.baidu.tieba.xy3;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UnitedSchemePublicDispatcher());
        arrayList.add(new UnitedSchemeEmotionDispatcher());
        arrayList.add(new qc3());
        arrayList.add(new rc3());
        arrayList.add(new xy3());
        return arrayList;
    }
}
