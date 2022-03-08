package c.q.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.Q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public int f28905b;

    /* renamed from: c  reason: collision with root package name */
    public int f28906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n1 f28907d;

    public a1(n1 n1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28907d = n1Var;
        this.f28905b = 0;
        this.f28906c = 0;
        if (Looper.myLooper() != null) {
            this.a = new x0(this, n1Var);
        }
    }

    public Message a(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, obj)) == null) {
            Handler handler = this.a;
            if (handler != null) {
                return handler.obtainMessage(i2, obj);
            }
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = obj;
            return obtain;
        }
        return (Message) invokeIL.objValue;
    }

    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                Q q = (Q) ((Object[]) message.obj)[0];
                this.f28907d.f29043h.a();
            } else if (i2 == 3) {
                this.f28907d.f29043h.c();
            } else if (i2 == 5) {
                this.f28907d.f29043h.b(((Integer) ((Object[]) message.obj)[0]).intValue());
            } else if (i2 != 7) {
            } else {
                this.f28907d.f29043h.d();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cc -> B:49:0x00d3). Please submit an issue!!! */
    public void c(InputStream inputStream) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
            this.f28905b = 0;
            try {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f28907d.f29042g));
                        int i2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            z = true;
                            if (read == -1) {
                                z = false;
                                break;
                            } else if (this.f28907d.f29045j) {
                                fileOutputStream.write(bArr, 0, read);
                                int i3 = this.f28905b + read;
                                this.f28905b = i3;
                                if (this.f28907d.f29040e + i3 < this.f28907d.k + this.f28907d.f29040e) {
                                    int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f28907d.f29040e + i3) / ((float) (this.f28907d.k + this.f28907d.f29040e)))) * 100.0f);
                                    this.f28906c = parseFloat;
                                    if (i2 % 30 == 0 || parseFloat == 100) {
                                        d(a(5, new Object[]{Integer.valueOf(this.f28906c)}));
                                    }
                                }
                                i2++;
                            } else {
                                d(a(7, null));
                                break;
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        this.f28907d.f29045j = false;
                        if (!z) {
                            d(a(3, null));
                        }
                        inputStream.close();
                    } catch (Exception e2) {
                        d(a(7, null));
                        this.f28907d.f29045j = false;
                        e2.printStackTrace();
                        if (inputStream == null) {
                            return;
                        }
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            this.f28907d.f29045j = false;
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                this.f28907d.f29045j = false;
                e4.printStackTrace();
            }
        }
    }

    public void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            Handler handler = this.a;
            if (handler != null) {
                handler.sendMessage(message);
            } else {
                b(message);
            }
        }
    }
}
