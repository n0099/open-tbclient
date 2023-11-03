package com.baidu.searchbox.block.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.block.ioc.IBlockContext;
import com.baidu.searchbox.block.ioc.IBlockRegister;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.pf1;
@Autowired
/* loaded from: classes3.dex */
public class BlockContext {
    public static final IBlockContext BLOCK_CONTEXT = new IBlockContext() { // from class: com.baidu.searchbox.block.impl.BlockContext.1
        @Override // com.baidu.searchbox.block.ioc.IBlockContext
        public void onAppBlock(Context context, BlockInfo blockInfo) {
            if (AppConfig.isDebug()) {
                Log.d(BlockMonitor.TAG, "onAppBlock");
            }
            pf1<IBlockRegister> iBlockUploadList = BlockRuntime.getInstance().getIBlockUploadList();
            if (iBlockUploadList != null && iBlockUploadList.getList() != null && blockInfo != null) {
                if (AppConfig.isDebug()) {
                    Log.i(BlockMonitor.TAG, "blockInfo = " + blockInfo.getStackTrace());
                }
                TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
                if (lastTrackUI != null) {
                    if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                        blockInfo.setCurrentPage(lastTrackUI.getFragmentPage());
                    } else if (!TextUtils.isEmpty(lastTrackUI.getActivityPage())) {
                        blockInfo.setCurrentPage(lastTrackUI.getActivityPage());
                    }
                }
                blockInfo.setTrackUIs(Track.getInstance().getAllTrackUIs());
                blockInfo.setLogId(CommonUtils.getLogId());
                for (IBlockRegister iBlockRegister : iBlockUploadList.getList()) {
                    iBlockRegister.onBlockCatch(context, blockInfo);
                }
            }
        }
    };

    @Inject(force = false)
    public static IBlockContext getBlockContext() {
        return BLOCK_CONTEXT;
    }
}
