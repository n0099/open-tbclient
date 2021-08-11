package c.a.o0.s.g0.c;

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
    public int f13701a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13702b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f13703c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f13704d;

    /* renamed from: e  reason: collision with root package name */
    public File f13705e;

    /* renamed from: f  reason: collision with root package name */
    public int f13706f;

    /* renamed from: g  reason: collision with root package name */
    public int f13707g;

    /* renamed from: h  reason: collision with root package name */
    public int f13708h;

    /* renamed from: i  reason: collision with root package name */
    public int f13709i;

    /* renamed from: j  reason: collision with root package name */
    public short f13710j;
    public short k;

    /* renamed from: c.a.o0.s.g0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0676a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13711e;

        public RunnableC0676a(a aVar) {
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
            this.f13711e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13711e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1895721128, "Lc/a/o0/s/g0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1895721128, "Lc/a/o0/s/g0/c/a;");
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
        this.f13701a = 0;
        this.f13702b = false;
        this.f13703c = null;
        this.f13705e = null;
    }

    @Override // c.a.o0.s.g0.c.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13702b = false;
        }
    }

    @Override // c.a.o0.s.g0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13702b : invokeV.booleanValue;
    }

    @Override // c.a.o0.s.g0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // c.a.o0.s.g0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC0676a(this));
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
            this.f13701a = AudioRecord.getMinBufferSize(i3, i4, i5) + 2048;
            this.f13707g = i3;
            this.f13708h = i4;
            this.f13709i = i5;
            AudioRecord audioRecord = this.f13703c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f13703c = new AudioRecord(i2, this.f13707g, this.f13708h, this.f13709i, this.f13701a);
            this.f13710j = (short) (this.f13708h == 12 ? 2 : 1);
            this.k = (short) (this.f13709i == 2 ? 16 : 8);
            File file = new File(str);
            this.f13705e = file;
            if (file.exists()) {
                this.f13705e.delete();
            }
            try {
                this.f13705e.createNewFile();
                RandomAccessFile randomAccessFile = this.f13704d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f13704d = new RandomAccessFile(this.f13705e, "rw");
                    i();
                    f(this.f13705e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f13705e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f13703c) == null || this.f13705e == null) {
            return;
        }
        try {
            this.f13702b = true;
            int i2 = this.f13701a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f13702b) {
                this.f13703c.read(bArr, 0, i2);
                this.f13704d.write(bArr);
                this.f13706f += i2;
            }
            this.f13704d.seek(4L);
            this.f13704d.writeInt(Integer.reverseBytes(this.f13706f + 36));
            this.f13704d.seek(40L);
            this.f13704d.writeInt(Integer.reverseBytes(this.f13706f));
            this.f13704d.close();
            this.f13703c.stop();
            this.f13703c.release();
            this.f13702b = false;
        } catch (Throwable unused) {
            if (this.f13705e.exists()) {
                this.f13705e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f13704d.setLength(0L);
                this.f13704d.writeBytes(com.baidu.wallet.base.audio.b.f59855e);
                this.f13704d.writeInt(0);
                this.f13704d.writeBytes(com.baidu.wallet.base.audio.b.f59856f);
                this.f13704d.writeBytes(com.baidu.wallet.base.audio.b.f59857g);
                this.f13704d.writeInt(Integer.reverseBytes(16));
                this.f13704d.writeShort(Short.reverseBytes((short) 1));
                this.f13704d.writeShort(Short.reverseBytes(this.f13710j));
                this.f13704d.writeInt(Integer.reverseBytes(this.f13707g));
                this.f13704d.writeInt(Integer.reverseBytes(((this.f13707g * this.f13710j) * this.k) / 8));
                this.f13704d.writeShort(Short.reverseBytes((short) ((this.f13710j * this.k) / 8)));
                this.f13704d.writeShort(Short.reverseBytes(this.k));
                this.f13704d.writeBytes("data");
                this.f13704d.writeInt(0);
            } catch (IOException e2) {
                if (this.f13705e.exists()) {
                    this.f13705e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
