package com.baidu.searchbox.block.ioc;

import android.content.Context;
import com.baidu.searchbox.block.impl.BlockInfo;
/* loaded from: classes3.dex */
public interface IBlockRegister {
    boolean checkEnable();

    void onBlockCatch(Context context, BlockInfo blockInfo);
}
