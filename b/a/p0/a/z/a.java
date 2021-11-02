package b.a.p0.a.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
import b.a.p0.a.v2.l0;
import b.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f9093c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Timer f9094a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.z.c.b f9095b;

    /* renamed from: b.a.p0.a.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0470a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z.c.b f9096e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f9097f;

        public C0470a(a aVar, b.a.p0.a.z.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9097f = aVar;
            this.f9096e = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z.c.b bVar = this.f9096e;
                if (bVar != null) {
                    bVar.a();
                }
                this.f9097f.j();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f9098a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1372305625, "Lb/a/p0/a/z/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1372305625, "Lb/a/p0/a/z/a$b;");
                    return;
                }
            }
            f9098a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065113947, "Lb/a/p0/a/z/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065113947, "Lb/a/p0/a/z/a;");
                return;
            }
        }
        f9093c = k.f6397a;
    }

    public /* synthetic */ a(C0470a c0470a) {
        this();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f9098a : (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.p0.a.z.c.b bVar = this.f9095b;
            if (bVar != null) {
                bVar.cancel();
            }
            j();
        }
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0 : invokeL.booleanValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0 : invokeL.booleanValue;
    }

    public void e(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            str3 = "error";
            if (l0.f("1.13.0")) {
                HashMap hashMap = new HashMap();
                hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                hashMap.put("cameraId", str2);
                hashMap.put("eType", z ? "error" : IntentConfig.STOP);
                f.T().u(new b.a.p0.a.o0.d.b("camera", hashMap));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                jSONObject.put("cameraId", str2);
                if (!z) {
                    str3 = IntentConfig.STOP;
                }
                jSONObject.put("eType", str3);
            } catch (JSONException e2) {
                if (f9093c) {
                    e2.printStackTrace();
                }
            }
            b.a.p0.a.w2.g.c.a.d(str, str2, "camera", jSONObject.optString("eType"), jSONObject);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                CameraPreview.releaseCamera();
            } catch (Exception e2) {
                if (f9093c) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            a();
        }
    }

    public boolean h(byte[] bArr, String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bArr, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (file.exists()) {
                    boolean delete = file.delete();
                    if (f9093c) {
                        String str2 = "delete = " + delete;
                    }
                }
                if (file.getParentFile() != null) {
                    boolean mkdirs = file.getParentFile().mkdirs();
                    if (f9093c) {
                        String str3 = "mkdirs = " + mkdirs;
                    }
                }
                boolean createNewFile = file.createNewFile();
                if (f9093c) {
                    String str4 = "createNewFile = " + createNewFile;
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (i3 != 0 || z) {
                    Matrix matrix = new Matrix();
                    matrix.reset();
                    if (i3 != 0) {
                        matrix.postRotate(i3);
                    }
                    if (z) {
                        matrix.postScale(-1.0f, 1.0f);
                    }
                    decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i2, bufferedOutputStream);
                bufferedOutputStream.flush();
                d.d(bufferedOutputStream);
                return true;
            } catch (Exception e2) {
                if (f9093c) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            } catch (OutOfMemoryError e3) {
                if (f9093c) {
                    e3.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void i(int i2, b.a.p0.a.z.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, bVar) == null) {
            this.f9095b = bVar;
            Timer timer = new Timer();
            this.f9094a = timer;
            timer.schedule(new C0470a(this, bVar), i2);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f9095b = null;
            Timer timer = this.f9094a;
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    public a() {
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
}
