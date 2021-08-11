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
/* loaded from: classes5.dex */
public class a extends SurfaceView implements SurfaceHolder.Callback {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final int f44777f = 1001;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f44778a;

    /* renamed from: b  reason: collision with root package name */
    public Camera f44779b;

    /* renamed from: c  reason: collision with root package name */
    public b f44780c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f44781d;

    /* renamed from: e  reason: collision with root package name */
    public Camera.PreviewCallback f44782e;

    /* renamed from: com.baidu.sapi2.views.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1697a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44783a;

        public HandlerC1697a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44783a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f44783a.f44779b == null || this.f44783a.f44780c == null) {
                return;
            }
            this.f44783a.f44780c.a(this.f44783a.f44781d, 1001);
            this.f44783a.f44779b.autoFocus(this.f44783a.f44780c);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Camera.AutoFocusCallback {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: c  reason: collision with root package name */
        public static final String f44784c;

        /* renamed from: d  reason: collision with root package name */
        public static final long f44785d = 500;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Handler f44786a;

        /* renamed from: b  reason: collision with root package name */
        public int f44787b;

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
            f44784c = b.class.getSimpleName();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void a(Handler handler, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, handler, i2) == null) {
                this.f44786a = handler;
                this.f44787b = i2;
            }
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            Handler handler;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, camera) == null) || (handler = this.f44786a) == null) {
                return;
            }
            this.f44786a.sendMessageDelayed(handler.obtainMessage(this.f44787b, Boolean.valueOf(z)), 500L);
            this.f44786a = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44781d = new HandlerC1697a(this);
        this.f44779b = camera;
        SurfaceHolder holder = getHolder();
        this.f44778a = holder;
        holder.addCallback(this);
        this.f44778a.setType(3);
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, previewCallback) == null) {
            this.f44782e = previewCallback;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, surfaceHolder, i2, i3, i4) == null) {
            Log.e("SurfaceView-callback", "surfaceChanged");
            if (surfaceHolder.getSurface() == null) {
                return;
            }
            try {
                this.f44779b.stopPreview();
                this.f44779b.setDisplayOrientation(90);
                this.f44779b.setPreviewDisplay(this.f44778a);
                if (this.f44782e != null) {
                    this.f44779b.setPreviewCallback(this.f44782e);
                }
                this.f44779b.startPreview();
                if (this.f44780c == null) {
                    this.f44780c = new b();
                }
                this.f44780c.a(this.f44781d, 1001);
                this.f44779b.autoFocus(this.f44780c);
            } catch (IOException e2) {
                e2.printStackTrace();
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
            b bVar = this.f44780c;
            if (bVar != null) {
                bVar.a(null, 0);
                this.f44780c = null;
            }
            Handler handler = this.f44781d;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f44781d = null;
            }
            this.f44778a.removeCallback(this);
            this.f44778a = null;
        }
    }
}
