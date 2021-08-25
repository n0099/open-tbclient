package c.a.p0.s.g0.c;

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
/* loaded from: classes3.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14005a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14006b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f14007c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f14008d;

    /* renamed from: e  reason: collision with root package name */
    public File f14009e;

    /* renamed from: f  reason: collision with root package name */
    public int f14010f;

    /* renamed from: g  reason: collision with root package name */
    public int f14011g;

    /* renamed from: h  reason: collision with root package name */
    public int f14012h;

    /* renamed from: i  reason: collision with root package name */
    public int f14013i;

    /* renamed from: j  reason: collision with root package name */
    public short f14014j;
    public short k;

    /* renamed from: c.a.p0.s.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0687a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14015e;

        public RunnableC0687a(a aVar) {
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
            this.f14015e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14015e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2024803847, "Lc/a/p0/s/g0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2024803847, "Lc/a/p0/s/g0/c/a;");
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
        this.f14005a = 0;
        this.f14006b = false;
        this.f14007c = null;
        this.f14009e = null;
    }

    @Override // c.a.p0.s.g0.c.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14006b = false;
        }
    }

    @Override // c.a.p0.s.g0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14006b : invokeV.booleanValue;
    }

    @Override // c.a.p0.s.g0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // c.a.p0.s.g0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC0687a(this));
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
            this.f14005a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
            this.f14011g = i3;
            this.f14012h = i4;
            this.f14013i = i5;
            AudioRecord audioRecord = this.f14007c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f14007c = new AudioRecord(i2, this.f14011g, this.f14012h, this.f14013i, this.f14005a);
            this.f14014j = (short) (this.f14012h == 12 ? 2 : 1);
            this.k = (short) (this.f14013i == 2 ? 16 : 8);
            File file = new File(str);
            this.f14009e = file;
            if (file.exists()) {
                this.f14009e.delete();
            }
            try {
                this.f14009e.createNewFile();
                RandomAccessFile randomAccessFile = this.f14008d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f14008d = new RandomAccessFile(this.f14009e, "rw");
                    i();
                    f(this.f14009e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f14009e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f14007c) == null || this.f14009e == null) {
            return;
        }
        try {
            this.f14006b = true;
            int i2 = this.f14005a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f14006b) {
                this.f14007c.read(bArr, 0, i2);
                this.f14008d.write(bArr);
                this.f14010f += i2;
            }
            this.f14008d.seek(4L);
            this.f14008d.writeInt(Integer.reverseBytes(this.f14010f + 36));
            this.f14008d.seek(40L);
            this.f14008d.writeInt(Integer.reverseBytes(this.f14010f));
            this.f14008d.close();
            this.f14007c.stop();
            this.f14007c.release();
            this.f14006b = false;
        } catch (Throwable unused) {
            if (this.f14009e.exists()) {
                this.f14009e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f14008d.setLength(0L);
                this.f14008d.writeBytes(com.baidu.wallet.base.audio.b.f60055e);
                this.f14008d.writeInt(0);
                this.f14008d.writeBytes(com.baidu.wallet.base.audio.b.f60056f);
                this.f14008d.writeBytes(com.baidu.wallet.base.audio.b.f60057g);
                this.f14008d.writeInt(Integer.reverseBytes(16));
                this.f14008d.writeShort(Short.reverseBytes((short) 1));
                this.f14008d.writeShort(Short.reverseBytes(this.f14014j));
                this.f14008d.writeInt(Integer.reverseBytes(this.f14011g));
                this.f14008d.writeInt(Integer.reverseBytes(((this.f14011g * this.f14014j) * this.k) / 8));
                this.f14008d.writeShort(Short.reverseBytes((short) ((this.f14014j * this.k) / 8)));
                this.f14008d.writeShort(Short.reverseBytes(this.k));
                this.f14008d.writeBytes("data");
                this.f14008d.writeInt(0);
            } catch (IOException e2) {
                if (this.f14009e.exists()) {
                    this.f14009e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
