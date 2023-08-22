package com.baidu.searchbox.block.impl;

import android.util.Log;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.ioc.IBlockRegister;
import com.baidu.searchbox.block.ioc.IBlockRegister_BlockRuntime_ListProvider;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.jk1;
import com.baidu.tieba.lk1;
/* loaded from: classes3.dex */
public class BlockRuntime {
    public static volatile BlockRuntime sInstance;
    @Inject
    public lk1<IBlockRegister> mIBlockMonitorList;

    public void initmIBlockMonitorList() {
        jk1 b = jk1.b();
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

    public lk1<IBlockRegister> getIBlockUploadList() {
        return this.mIBlockMonitorList;
    }

    public boolean enableBlock() {
        lk1<IBlockRegister> lk1Var = this.mIBlockMonitorList;
        if (lk1Var != null && lk1Var.getList() != null) {
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
