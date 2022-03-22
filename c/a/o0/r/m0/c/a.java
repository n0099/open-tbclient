package c.a.o0.r.m0.c;

import android.media.AudioRecord;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10734b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f10735c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f10736d;

    /* renamed from: e  reason: collision with root package name */
    public File f10737e;

    /* renamed from: f  reason: collision with root package name */
    public int f10738f;

    /* renamed from: g  reason: collision with root package name */
    public int f10739g;

    /* renamed from: h  reason: collision with root package name */
    public int f10740h;
    public int i;
    public short j;
    public short k;

    /* renamed from: c.a.o0.r.m0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0836a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0836a(a aVar) {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(438263085, "Lc/a/o0/r/m0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(438263085, "Lc/a/o0/r/m0/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f10734b = false;
        this.f10735c = null;
        this.f10737e = null;
    }

    @Override // c.a.o0.r.m0.c.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10734b = false;
        }
    }

    @Override // c.a.o0.r.m0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10734b : invokeV.booleanValue;
    }

    @Override // c.a.o0.r.m0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // c.a.o0.r.m0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC0836a(this));
            thread.setPriority(10);
            thread.setDaemon(true);
            thread.start();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public boolean g(int i, int i2, int i3, int i4, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str})) == null) {
            this.a = AudioRecord.getMinBufferSize(i2, i3, i4) + 2048;
            this.f10739g = i2;
            this.f10740h = i3;
            this.i = i4;
            AudioRecord audioRecord = this.f10735c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f10735c = new AudioRecord(i, this.f10739g, this.f10740h, this.i, this.a);
            this.j = (short) (this.f10740h == 12 ? 2 : 1);
            this.k = (short) (this.i == 2 ? 16 : 8);
            File file = new File(str);
            this.f10737e = file;
            if (file.exists()) {
                this.f10737e.delete();
            }
            try {
                this.f10737e.createNewFile();
                RandomAccessFile randomAccessFile = this.f10736d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f10736d = new RandomAccessFile(this.f10737e, "rw");
                    i();
                    f(this.f10737e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f10737e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f10735c) == null || this.f10737e == null) {
            return;
        }
        try {
            this.f10734b = true;
            int i = this.a;
            byte[] bArr = new byte[i];
            audioRecord.startRecording();
            while (this.f10734b) {
                this.f10735c.read(bArr, 0, i);
                this.f10736d.write(bArr);
                this.f10738f += i;
            }
            this.f10736d.seek(4L);
            this.f10736d.writeInt(Integer.reverseBytes(this.f10738f + 36));
            this.f10736d.seek(40L);
            this.f10736d.writeInt(Integer.reverseBytes(this.f10738f));
            this.f10736d.close();
            this.f10735c.stop();
            this.f10735c.release();
            this.f10734b = false;
        } catch (Throwable unused) {
            if (this.f10737e.exists()) {
                this.f10737e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f10736d.setLength(0L);
                this.f10736d.writeBytes("RIFF");
                this.f10736d.writeInt(0);
                this.f10736d.writeBytes("WAVE");
                this.f10736d.writeBytes("fmt ");
                this.f10736d.writeInt(Integer.reverseBytes(16));
                this.f10736d.writeShort(Short.reverseBytes((short) 1));
                this.f10736d.writeShort(Short.reverseBytes(this.j));
                this.f10736d.writeInt(Integer.reverseBytes(this.f10739g));
                this.f10736d.writeInt(Integer.reverseBytes(((this.f10739g * this.j) * this.k) / 8));
                this.f10736d.writeShort(Short.reverseBytes((short) ((this.j * this.k) / 8)));
                this.f10736d.writeShort(Short.reverseBytes(this.k));
                this.f10736d.writeBytes("data");
                this.f10736d.writeInt(0);
            } catch (IOException e2) {
                if (this.f10737e.exists()) {
                    this.f10737e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
