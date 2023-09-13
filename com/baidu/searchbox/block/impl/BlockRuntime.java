package com.baidu.searchbox.block.impl;

import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.ioc.IBlockRegister;
import com.baidu.searchbox.block.ioc.IBlockRegister_BlockRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.nk1;
import com.baidu.tieba.pk1;
/* loaded from: classes3.dex */
public class BlockRuntime {
    public static volatile BlockRuntime sInstance;
    @Inject
    public pk1<IBlockRegister> mIBlockMonitorList;

    public void initmIBlockMonitorList() {
        nk1 b = nk1.b();
        this.mIBlockMonitorList = b;
        b.a(new IBlockRegister_BlockRuntime_ListProvider());
    }

    public BlockRuntime() {
        initmIBlockMonitorList();
    }

    public static BlockRuntime getInstance() {
        if (sInstance == null) {
            synchronized (BlockRuntime.class) {
                if (sInstance == null) {
                    sInstance = new BlockRuntime();
                }
            }
        }
        return sInstance;
    }

    public pk1<IBlockRegister> getIBlockUploadList() {
        return this.mIBlockMonitorList;
    }

    public boolean enableBlock() {
        pk1<IBlockRegister> pk1Var = this.mIBlockMonitorList;
        if (pk1Var != null && pk1Var.getList() != null) {
            for (IBlockRegister iBlockRegister : this.mIBlockMonitorList.getList()) {
                if (iBlockRegister != null && iBlockRegister.checkEnable()) {
                    if (AppConfig.isDebug()) {
                        Log.d(BlockMonitor.TAG, "enableBlock = true");
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
