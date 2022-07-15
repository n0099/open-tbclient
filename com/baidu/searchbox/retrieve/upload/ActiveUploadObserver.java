package com.baidu.searchbox.retrieve.upload;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult_ActiveUploadObserver_ListProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pb1;
import com.repackage.rb1;
/* loaded from: classes2.dex */
public class ActiveUploadObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject(force = false)
    public rb1<IActiveUploadResult> mActiveObserverList;

    public ActiveUploadObserver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initmActiveObserverList();
    }

    public void initmActiveObserverList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pb1 b = pb1.b();
            this.mActiveObserverList = b;
            b.a(new IActiveUploadResult_ActiveUploadObserver_ListProvider());
        }
    }
}
