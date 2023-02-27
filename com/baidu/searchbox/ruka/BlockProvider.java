package com.baidu.searchbox.ruka;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.impl.BlockMonitor_Factory;
import com.baidu.searchbox.ruka.ioc.IBlockMonitor;
@Autowired
/* loaded from: classes2.dex */
public class BlockProvider {
    public static final IBlockMonitor EMPTY = new IBlockMonitor() { // from class: com.baidu.searchbox.ruka.BlockProvider.1
        @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
        public boolean enableMonitor() {
            return false;
        }

        @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
        public void startBlockMonitor(int i) {
        }

        @Override // com.baidu.searchbox.ruka.ioc.IBlockMonitor
        public void stopBlockMonitor() {
        }
    };

    @Inject(force = false)
    public static IBlockMonitor getBlockMonitor() {
        return BlockMonitor_Factory.get();
    }
}
