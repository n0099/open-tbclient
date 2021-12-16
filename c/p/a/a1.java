package c.p.a;

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
/* loaded from: classes9.dex */
public class a1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public int f31100b;

    /* renamed from: c  reason: collision with root package name */
    public int f31101c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ s1 f31102d;

    public a1(s1 s1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31102d = s1Var;
        this.f31100b = 0;
        this.f31101c = 0;
        if (Looper.myLooper() != null) {
            this.a = new x0(this, s1Var);
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
                this.f31102d.f31285h.a();
            } else if (i2 == 3) {
                this.f31102d.f31285h.c();
            } else if (i2 == 5) {
                this.f31102d.f31285h.b(((Integer) ((Object[]) message.obj)[0]).intValue());
            } else if (i2 != 7) {
            } else {
                this.f31102d.f31285h.d();
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cc -> B:49:0x00d3). Please submit an issue!!! */
    public void c(InputStream inputStream) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream) == null) {
            this.f31100b = 0;
            try {
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f31102d.f31284g));
                        int i2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            z = true;
                            if (read == -1) {
                                z = false;
                                break;
                            } else if (this.f31102d.f31287j) {
                                fileOutputStream.write(bArr, 0, read);
                                int i3 = this.f31100b + read;
                                this.f31100b = i3;
                                if (this.f31102d.f31282e + i3 < this.f31102d.f31288k + this.f31102d.f31282e) {
                                    int parseFloat = (int) (Float.parseFloat(new DecimalFormat("0.00").format((this.f31102d.f31282e + i3) / ((float) (this.f31102d.f31288k + this.f31102d.f31282e)))) * 100.0f);
                                    this.f31101c = parseFloat;
                                    if (i2 % 30 == 0 || parseFloat == 100) {
                                        d(a(5, new Object[]{Integer.valueOf(this.f31101c)}));
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
                        this.f31102d.f31287j = false;
                        if (!z) {
                            d(a(3, null));
                        }
                        inputStream.close();
                    } catch (Exception e2) {
                        d(a(7, null));
                        this.f31102d.f31287j = false;
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
                            this.f31102d.f31287j = false;
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                this.f31102d.f31287j = false;
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
