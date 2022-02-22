package c.a.u0.i3.b.a;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends AsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f18794b;

    /* renamed from: c  reason: collision with root package name */
    public a f18795c;

    /* renamed from: d  reason: collision with root package name */
    public int f18796d;

    /* loaded from: classes8.dex */
    public interface a {
        String processData(byte[] bArr, int i2, int i3, boolean z);
    }

    public c(Camera camera, byte[] bArr, a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {camera, bArr, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = camera;
        this.f18794b = bArr;
        this.f18795c = aVar;
        this.f18796d = i2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || getStatus() == AsyncTask.Status.FINISHED) {
            return;
        }
        cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Camera.Parameters parameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            Camera camera = this.a;
            if (camera == null) {
                return null;
            }
            try {
                parameters = camera.getParameters();
            } catch (RuntimeException e2) {
                BdLog.e(e2);
                parameters = null;
            }
            if (parameters == null) {
                return null;
            }
            Camera.Size previewSize = parameters.getPreviewSize();
            int i2 = previewSize.width;
            int i3 = previewSize.height;
            byte[] bArr = this.f18794b;
            if (this.f18796d == 0) {
                bArr = new byte[bArr.length];
                for (int i4 = 0; i4 < i3; i4++) {
                    for (int i5 = 0; i5 < i2; i5++) {
                        bArr[(((i5 * i3) + i3) - i4) - 1] = this.f18794b[(i4 * i2) + i5];
                    }
                }
                i2 = i3;
                i3 = i2;
            }
            try {
                try {
                    if (this.f18795c == null) {
                        return null;
                    }
                    return this.f18795c.processData(bArr, i2, i3, false);
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return this.f18795c.processData(bArr, i2, i3, true);
            }
        }
        return (String) invokeL.objValue;
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                execute(new Void[0]);
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCancelled();
            this.f18795c = null;
        }
    }
}
