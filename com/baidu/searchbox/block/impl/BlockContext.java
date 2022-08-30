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
import com.baidu.tieba.jc1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes2.dex */
public class BlockContext {
    public static /* synthetic */ Interceptable $ic;
    public static final IBlockContext BLOCK_CONTEXT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(909554694, "Lcom/baidu/searchbox/block/impl/BlockContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(909554694, "Lcom/baidu/searchbox/block/impl/BlockContext;");
                return;
            }
        }
        BLOCK_CONTEXT = new IBlockContext() { // from class: com.baidu.searchbox.block.impl.BlockContext.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.block.ioc.IBlockContext
            public void onAppBlock(Context context, BlockInfo blockInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, blockInfo) == null) {
                    if (AppConfig.isDebug()) {
                        Log.d(BlockMonitor.TAG, "onAppBlock");
                    }
                    jc1<IBlockRegister> iBlockUploadList = BlockRuntime.getInstance().getIBlockUploadList();
                    if (iBlockUploadList == null || iBlockUploadList.getList() == null || blockInfo == null) {
                        return;
                    }
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
    }

    public BlockContext() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Inject(force = false)
    public static IBlockContext getBlockContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? BLOCK_CONTEXT : (IBlockContext) invokeV.objValue;
    }
}
