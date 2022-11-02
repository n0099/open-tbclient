package com.baidu.pass.biometrics.face.liveness.enums;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.view.face.CircleProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class a extends TimerTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CircleProgressView a;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.enums.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0123a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0123a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int progress;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.a == null || (progress = this.a.a.getProgress()) <= 0) {
                return;
            }
            this.a.a.setProgress(progress - 1);
        }
    }

    public a(CircleProgressView circleProgressView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circleProgressView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = circleProgressView;
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.a = null;
            return super.cancel();
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        CircleProgressView circleProgressView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (circleProgressView = this.a) != null) {
            circleProgressView.post(new RunnableC0123a(this));
        }
    }
}
