package com.baidu.sapi2.views;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int f = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceHolder a;
    public Camera b;
    public b c;
    public Handler d;
    public Camera.PreviewCallback e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0135a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public HandlerC0135a(a aVar) {
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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.a.b == null || this.a.c == null) {
                return;
            }
            this.a.c.a(this.a.d, 1001);
            this.a.b.autoFocus(this.a.c);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String c;
        public static final long d = 500;
        public transient /* synthetic */ FieldHolder $fh;
        public Handler a;
        public int b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-626308721, "Lcom/baidu/sapi2/views/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-626308721, "Lcom/baidu/sapi2/views/a$b;");
                    return;
                }
            }
            c = b.class.getSimpleName();
        }

        public b() {
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

        public void a(Handler handler, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, handler, i) == null) {
                this.a = handler;
                this.b = i;
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, camera) == null) || (handler = this.a) == null) {
                return;
            }
            this.a.sendMessageDelayed(handler.obtainMessage(this.b, Boolean.valueOf(z)), 500L);
            this.a = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, Camera camera) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, camera};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HandlerC0135a(this);
        this.b = camera;
        SurfaceHolder holder = getHolder();
        this.a = holder;
        holder.addCallback(this);
        this.a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, previewCallback) == null) {
            this.e = previewCallback;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder, i, i2, i3) == null) {
            Log.e("SurfaceView-callback", "surfaceChanged");
            if (surfaceHolder.getSurface() == null) {
                return;
            }
            try {
                this.b.stopPreview();
                this.b.setDisplayOrientation(90);
                this.b.setPreviewDisplay(this.a);
                if (this.e != null) {
                    this.b.setPreviewCallback(this.e);
                }
                this.b.startPreview();
                if (this.c == null) {
                    this.c = new b();
                }
                this.c.a(this.d, 1001);
                this.b.autoFocus(this.c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, surfaceHolder) == null) {
            Log.e("SurfaceView-callback", "surfaceCreated");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) {
            Log.e("SurfaceView-callback", "surfaceDestroyed");
            surfaceHolder.removeCallback(this);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(null, 0);
                this.c = null;
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.d = null;
            }
            this.a.removeCallback(this);
            this.a = null;
        }
    }
}
