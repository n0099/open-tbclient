package b.a.e.e.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f1600a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapFactory.Options f1601b;

    /* renamed from: c  reason: collision with root package name */
    public a f1602c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1603d;

    /* renamed from: e  reason: collision with root package name */
    public long f1604e;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: d  reason: collision with root package name */
        public static byte f1605d = Byte.MIN_VALUE;

        /* renamed from: e  reason: collision with root package name */
        public static byte f1606e = Byte.MIN_VALUE;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1607a;

        /* renamed from: b  reason: collision with root package name */
        public long f1608b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1609c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-424994771, "Lb/a/e/e/a/f/c$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-424994771, "Lb/a/e/e/a/f/c$a;");
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
            this.f1607a = false;
            this.f1608b = 0L;
            this.f1609c = true;
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return 14;
            }
            return invokeV.intValue;
        }

        public boolean b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                if (bArr == null || bArr.length < a()) {
                    return false;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
                if (wrap.getInt() != 1786600511) {
                    return false;
                }
                if ((wrap.get() & f1605d) != 0) {
                    this.f1607a = true;
                }
                this.f1608b = wrap.getLong();
                if ((wrap.get() & f1606e) != 0) {
                    this.f1609c = false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public byte[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ByteBuffer allocate = ByteBuffer.allocate(a());
                allocate.putInt(1786600511);
                allocate.put(this.f1607a ? (byte) (f1605d | 0) : (byte) 0);
                allocate.putLong(this.f1608b);
                allocate.put(this.f1609c ? (byte) 0 : (byte) (f1606e | 0));
                allocate.flip();
                return allocate.array();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1600a = null;
        this.f1601b = null;
        this.f1602c = null;
        this.f1603d = true;
        this.f1602c = new a();
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    public boolean b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (bArr != null && this.f1602c.b(bArr)) {
                long j = this.f1602c.f1608b;
                if (j == 0 || j >= System.currentTimeMillis()) {
                    int a2 = a.a();
                    try {
                        if (this.f1601b == null) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            this.f1601b = options;
                            options.inPreferredConfig = Bitmap.Config.RGB_565;
                        }
                        this.f1601b.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f1601b);
                    } catch (Error e2) {
                        BdLog.e(e2.getMessage());
                    }
                    if (!this.f1601b.mCancel && this.f1601b.outWidth != -1 && this.f1601b.outHeight != -1) {
                        this.f1601b.inSampleSize = a(this.f1601b, i2, i3);
                        this.f1601b.inJustDecodeBounds = false;
                        this.f1600a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f1601b);
                        return this.f1600a != null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mData == null || !this.f1603d) {
                return null;
            }
            return this.f1602c.c();
        }
        return (byte[]) invokeV.objValue;
    }

    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int a2 = a.a();
            int length = this.mData.length - a2;
            byte[] bArr = new byte[length];
            System.arraycopy(this.mData, a2, bArr, 0, length);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1602c.f1609c : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f1602c.f1609c = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void endLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.e.e.l.a.k(isSuccess(), System.currentTimeMillis() - this.f1604e);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f1603d = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            if (bArr != null && this.f1602c.b(bArr)) {
                long j = this.f1602c.f1608b;
                if (j == 0 || j >= System.currentTimeMillis()) {
                    if (this.f1601b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.f1601b = options;
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                    }
                    int a2 = a.a();
                    try {
                        this.f1600a = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.f1601b);
                    } catch (Error e2) {
                        BdLog.e(e2.getMessage());
                    }
                    return this.f1600a != null;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1600a : (Bitmap) invokeV.objValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1602c.f1607a : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bArr) == null) {
            super.setData(bArr);
            if (isGif() || !l.B(bArr)) {
                return;
            }
            setGif(true);
        }
    }

    public void setGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f1602c.f1607a = z;
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void startLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1604e = System.currentTimeMillis();
        }
    }
}
