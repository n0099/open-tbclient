package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import androidx.annotation.NonNull;
import c.a.b0.v.v0.h;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BdVideoNewCacheView extends BdVideoCacheView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoNewCacheView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdVideoCacheView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            h.b("BdVideoNewCacheView", "onWindowVisibilityChanged(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
            if (i2 != 0) {
                setVisibility(4);
            } else if (this.mLoadingView.isRunning()) {
                setVisibility(0);
            }
            super.onWindowVisibilityChanged(i2);
        }
    }
}
