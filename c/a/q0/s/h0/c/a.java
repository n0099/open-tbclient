package c.a.q0.s.h0.c;

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
/* loaded from: classes5.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic = null;
    public static int l = 8000;
    public static int m = 2;
    public static int n = 2;
    public static int o = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12753b;

    /* renamed from: c  reason: collision with root package name */
    public AudioRecord f12754c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f12755d;

    /* renamed from: e  reason: collision with root package name */
    public File f12756e;

    /* renamed from: f  reason: collision with root package name */
    public int f12757f;

    /* renamed from: g  reason: collision with root package name */
    public int f12758g;

    /* renamed from: h  reason: collision with root package name */
    public int f12759h;

    /* renamed from: i  reason: collision with root package name */
    public int f12760i;

    /* renamed from: j  reason: collision with root package name */
    public short f12761j;

    /* renamed from: k  reason: collision with root package name */
    public short f12762k;

    /* renamed from: c.a.q0.s.h0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC0802a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12763e;

        public RunnableC0802a(a aVar) {
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
            this.f12763e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12763e.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1253577049, "Lc/a/q0/s/h0/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1253577049, "Lc/a/q0/s/h0/c/a;");
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
        this.f12753b = false;
        this.f12754c = null;
        this.f12756e = null;
    }

    @Override // c.a.q0.s.h0.c.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12753b = false;
        }
    }

    @Override // c.a.q0.s.h0.c.d
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12753b : invokeV.booleanValue;
    }

    @Override // c.a.q0.s.h0.c.d
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? g(o, l, m, n, str) : invokeL.booleanValue;
    }

    @Override // c.a.q0.s.h0.c.d
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Thread thread = new Thread(new RunnableC0802a(this));
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
            this.f12758g = i3;
            this.f12759h = i4;
            this.f12760i = i5;
            AudioRecord audioRecord = this.f12754c;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.f12754c = new AudioRecord(i2, this.f12758g, this.f12759h, this.f12760i, this.a);
            this.f12761j = (short) (this.f12759h == 12 ? 2 : 1);
            this.f12762k = (short) (this.f12760i == 2 ? 16 : 8);
            File file = new File(str);
            this.f12756e = file;
            if (file.exists()) {
                this.f12756e.delete();
            }
            try {
                this.f12756e.createNewFile();
                RandomAccessFile randomAccessFile = this.f12755d;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                try {
                    this.f12755d = new RandomAccessFile(this.f12756e, "rw");
                    i();
                    f(this.f12756e.getParent());
                    return true;
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    return false;
                }
            } catch (IOException unused) {
                this.f12756e = null;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final void h() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (audioRecord = this.f12754c) == null || this.f12756e == null) {
            return;
        }
        try {
            this.f12753b = true;
            int i2 = this.a;
            byte[] bArr = new byte[i2];
            audioRecord.startRecording();
            while (this.f12753b) {
                this.f12754c.read(bArr, 0, i2);
                this.f12755d.write(bArr);
                this.f12757f += i2;
            }
            this.f12755d.seek(4L);
            this.f12755d.writeInt(Integer.reverseBytes(this.f12757f + 36));
            this.f12755d.seek(40L);
            this.f12755d.writeInt(Integer.reverseBytes(this.f12757f));
            this.f12755d.close();
            this.f12754c.stop();
            this.f12754c.release();
            this.f12753b = false;
        } catch (Throwable unused) {
            if (this.f12756e.exists()) {
                this.f12756e.delete();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f12755d.setLength(0L);
                this.f12755d.writeBytes(com.baidu.wallet.base.audio.b.f51909e);
                this.f12755d.writeInt(0);
                this.f12755d.writeBytes(com.baidu.wallet.base.audio.b.f51910f);
                this.f12755d.writeBytes(com.baidu.wallet.base.audio.b.f51911g);
                this.f12755d.writeInt(Integer.reverseBytes(16));
                this.f12755d.writeShort(Short.reverseBytes((short) 1));
                this.f12755d.writeShort(Short.reverseBytes(this.f12761j));
                this.f12755d.writeInt(Integer.reverseBytes(this.f12758g));
                this.f12755d.writeInt(Integer.reverseBytes(((this.f12758g * this.f12761j) * this.f12762k) / 8));
                this.f12755d.writeShort(Short.reverseBytes((short) ((this.f12761j * this.f12762k) / 8)));
                this.f12755d.writeShort(Short.reverseBytes(this.f12762k));
                this.f12755d.writeBytes("data");
                this.f12755d.writeInt(0);
            } catch (IOException e2) {
                if (this.f12756e.exists()) {
                    this.f12756e.delete();
                }
                e2.printStackTrace();
            }
        }
    }
}
