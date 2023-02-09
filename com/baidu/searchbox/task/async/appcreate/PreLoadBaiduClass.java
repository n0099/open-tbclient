package com.baidu.searchbox.task.async.appcreate;

import android.util.Log;
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
/* loaded from: classes3.dex */
public class PreLoadBaiduClass extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public PreLoadBaiduClass() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                Class.forName("com.baidu.tieba.qk1");
            } catch (ClassNotFoundException e) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e.toString());
                e.printStackTrace();
            }
            try {
                Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (ClassNotFoundException e2) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e2.toString());
                e2.printStackTrace();
            }
            try {
                Class.forName("androidx.recyclerview.widget.LinearLayoutManager");
            } catch (ClassNotFoundException e3) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e3.toString());
                e3.printStackTrace();
            }
            try {
                Class.forName(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME);
            } catch (ClassNotFoundException e4) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e4.toString());
                e4.printStackTrace();
            }
            try {
                Class.forName("com.baidu.tieba.z49");
            } catch (ClassNotFoundException e5) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e5.toString());
                e5.printStackTrace();
            }
            try {
                Class.forName("com.baidu.tbadk.core.tabHost.FragmentTabHost");
            } catch (ClassNotFoundException e6) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e6.toString());
                e6.printStackTrace();
            }
            try {
                Class.forName("com.baidu.sapi2.utils.SapiUtils");
            } catch (ClassNotFoundException e7) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e7.toString());
                e7.printStackTrace();
            }
            if (Fresco.hasBeenInitialized()) {
                ImagePipelineFactory.getInstance().getImagePipeline();
            }
            try {
                Class.forName("com.baidu.webkit.sdk.WebView");
            } catch (ClassNotFoundException e8) {
                Log.e(LaunchTask.TAG, "preLoadClass exception " + e8.toString());
                e8.printStackTrace();
            }
        }
    }
}
