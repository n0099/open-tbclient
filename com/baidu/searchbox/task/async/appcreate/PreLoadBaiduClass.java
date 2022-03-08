package com.baidu.searchbox.task.async.appcreate;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
/* loaded from: classes4.dex */
public class PreLoadBaiduClass extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PreLoadBaiduClass() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                Class.forName("c.a.i0.b.b.c");
            } catch (ClassNotFoundException e2) {
                String str = "preLoadClass exception " + e2.toString();
                e2.printStackTrace();
            }
            try {
                Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (ClassNotFoundException e3) {
                String str2 = "preLoadClass exception " + e3.toString();
                e3.printStackTrace();
            }
            try {
                Class.forName("androidx.recyclerview.widget.LinearLayoutManager");
            } catch (ClassNotFoundException e4) {
                String str3 = "preLoadClass exception " + e4.toString();
                e4.printStackTrace();
            }
            try {
                Class.forName(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME);
            } catch (ClassNotFoundException e5) {
                String str4 = "preLoadClass exception " + e5.toString();
                e5.printStackTrace();
            }
            try {
                Class.forName("c.a.r0.a4.h");
            } catch (ClassNotFoundException e6) {
                String str5 = "preLoadClass exception " + e6.toString();
                e6.printStackTrace();
            }
            try {
                Class.forName("com.baidu.tbadk.core.tabHost.FragmentTabHost");
            } catch (ClassNotFoundException e7) {
                String str6 = "preLoadClass exception " + e7.toString();
                e7.printStackTrace();
            }
            try {
                Class.forName("com.baidu.sapi2.utils.SapiUtils");
            } catch (ClassNotFoundException e8) {
                String str7 = "preLoadClass exception " + e8.toString();
                e8.printStackTrace();
            }
            if (Fresco.hasBeenInitialized()) {
                ImagePipelineFactory.getInstance().getImagePipeline();
            }
            try {
                Class.forName("com.baidu.webkit.sdk.WebView");
            } catch (ClassNotFoundException e9) {
                String str8 = "preLoadClass exception " + e9.toString();
                e9.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PreLoadBaiduClass" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
