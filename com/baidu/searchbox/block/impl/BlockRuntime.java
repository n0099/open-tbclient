package com.baidu.searchbox.block.impl;

import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.ioc.IBlockRegister;
import com.baidu.searchbox.block.ioc.IBlockRegister_BlockRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.bj1;
import com.baidu.tieba.dj1;
/* loaded from: classes2.dex */
public class BlockRuntime {
    public static volatile BlockRuntime sInstance;
    @Inject
    public dj1<IBlockRegister> mIBlockMonitorList;

    public void initmIBlockMonitorList() {
        bj1 b = bj1.b();
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

    public dj1<IBlockRegister> getIBlockUploadList() {
        return this.mIBlockMonitorList;
    }

    public boolean enableBlock() {
        dj1<IBlockRegister> dj1Var = this.mIBlockMonitorList;
        if (dj1Var != null && dj1Var.getList() != null) {
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
