package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class DownloadManagerActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CURRENT_TAB = "current_tab";
    public static final int FROM_GAME_CENTER = 2;
    public static final int FROM_MINE = 1;
    public static final int FROM_OTHER_TAB = 4;
    public static final int FROM_SCHEME = 5;
    public static final int FROM_TOAST = 3;
    public static final String SOURCE = "source";
    public static final int TAB_DOWNLOADING = 3;
    public static final int TAB_INSTALLED = 2;
    public static final int TAB_ORDEDED = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerActivityConfig(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        getIntent().putExtra("source", i);
    }

    public DownloadManagerActivityConfig setCurrentTab(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            getIntent().putExtra(CURRENT_TAB, i);
            return this;
        }
        return (DownloadManagerActivityConfig) invokeI.objValue;
    }
}
