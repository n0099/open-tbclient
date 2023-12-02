package com.baidu.searchbox.block.ioc;

import com.baidu.searchbox.block.ubc.UbcBlockRegister;
import com.baidu.tieba.pf1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class IBlockRegister_BlockRuntime_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcBlockRegister());
        return arrayList;
    }
}
