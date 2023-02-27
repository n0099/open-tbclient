package com.baidu.searchbox.block.ioc;

import com.baidu.searchbox.block.ubc.UbcBlockRegister;
import com.baidu.tieba.jk1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IBlockRegister_BlockRuntime_ListProvider implements jk1 {
    @Override // com.baidu.tieba.jk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcBlockRegister());
        return arrayList;
    }
}
