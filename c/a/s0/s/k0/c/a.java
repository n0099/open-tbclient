package c.a.s0.s.k0.c;

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
/* loaded from: classes6.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13197b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f13198c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f13199d;

    /* renamed from: e  reason: collision with root package name */
    public File f13200e;

    /* renamed from: f  reason: collision with root package name */
    public int f13201f;

    /* renamed from: g  reason: collision with root package name */
    public int f13202g;

    /* renamed from: h  reason: collision with root package name */
    public int f13203h;

    /* renamed from: i  reason: collision with root package name */
    public int f13204i;

    /* renamed from: j  reason: collision with root package name */
    public short f13205j;
    public short k;

    /* renamed from: c.a.s0.s.k0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0875a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13206e;

        public RunnableC0875a(a aVar) {
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
            this.f13206e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13206e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1667099432, "Lc/a/s0/s/k0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1667099432, "Lc/a/s0/s/k0/c/a;");
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
                return;
            }
        }
        this.a = 0;
        this.f13197b = false;
        this.f13198c = null;
        this.f13200e = null;
    }

    @Override // c.a.s0.s.k0.c.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13197b = false;
        }
    }

    @Override // c.a.s0.s.k0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13197b : invokeV.booleanValue;
    }

    @Override // c.a.s0.s.k0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // c.a.s0.s.k0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC0875a(this));
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

    public boolean g(int i2, int i3, int i4, int i5, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str})) == null) {
            this.a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
            this.f13202g = i3;
            this.f13203h = i4;
            this.f13204i = i5;
            AudioRecord audioRecord = this.f13198c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f13198c = new AudioRecord(i2, this.f13202g, this.f13203h, this.f13204i, this.a);
            this.f13205j = (short) (this.f13203h == 12 ? 2 : 1);
            this.k = (short) (this.f13204i == 2 ? 16 : 8);
            File file = new File(str);
            this.f13200e = file;
            if (file.exists()) {
                this.f13200e.delete();
            }
            try {
                this.f13200e.createNewFile();
                RandomAccessFile randomAccessFile = this.f13199d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f13199d = new RandomAccessFile(this.f13200e, "rw");
                    i();
                    f(this.f13200e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f13200e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f13198c) == null || this.f13200e == null) {
            return;
        }
        try {
            this.f13197b = true;
            int i2 = this.a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f13197b) {
                this.f13198c.read(bArr, 0, i2);
                this.f13199d.write(bArr);
                this.f13201f += i2;
            }
            this.f13199d.seek(4L);
            this.f13199d.writeInt(Integer.reverseBytes(this.f13201f + 36));
            this.f13199d.seek(40L);
            this.f13199d.writeInt(Integer.reverseBytes(this.f13201f));
            this.f13199d.close();
            this.f13198c.stop();
            this.f13198c.release();
            this.f13197b = false;
        } catch (Throwable unused) {
            if (this.f13200e.exists()) {
                this.f13200e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f13199d.setLength(0L);
                this.f13199d.writeBytes(com.baidu.wallet.base.audio.b.f50469e);
                this.f13199d.writeInt(0);
                this.f13199d.writeBytes(com.baidu.wallet.base.audio.b.f50470f);
                this.f13199d.writeBytes(com.baidu.wallet.base.audio.b.f50471g);
                this.f13199d.writeInt(Integer.reverseBytes(16));
                this.f13199d.writeShort(Short.reverseBytes((short) 1));
                this.f13199d.writeShort(Short.reverseBytes(this.f13205j));
                this.f13199d.writeInt(Integer.reverseBytes(this.f13202g));
                this.f13199d.writeInt(Integer.reverseBytes(((this.f13202g * this.f13205j) * this.k) / 8));
                this.f13199d.writeShort(Short.reverseBytes((short) ((this.f13205j * this.k) / 8)));
                this.f13199d.writeShort(Short.reverseBytes(this.k));
                this.f13199d.writeBytes("data");
                this.f13199d.writeInt(0);
            } catch (IOException e2) {
                if (this.f13200e.exists()) {
                    this.f13200e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
