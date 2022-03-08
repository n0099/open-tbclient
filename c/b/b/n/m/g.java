package c.b.b.n.m;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.i0;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.ETC1;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.zip.GZIPInputStream;
/* loaded from: classes3.dex */
public class g implements TextureData, c.b.b.n.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.b.b.m.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f27453b;

    /* renamed from: c  reason: collision with root package name */
    public int f27454c;

    /* renamed from: d  reason: collision with root package name */
    public int f27455d;

    /* renamed from: e  reason: collision with root package name */
    public int f27456e;

    /* renamed from: f  reason: collision with root package name */
    public int f27457f;

    /* renamed from: g  reason: collision with root package name */
    public int f27458g;

    /* renamed from: h  reason: collision with root package name */
    public int f27459h;

    /* renamed from: i  reason: collision with root package name */
    public int f27460i;

    /* renamed from: j  reason: collision with root package name */
    public int f27461j;
    public int k;
    public ByteBuffer l;
    public boolean m;

    public g(c.b.b.m.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27456e = -1;
        this.f27457f = -1;
        this.f27458g = -1;
        this.a = aVar;
        this.m = z;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l != null : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void c(int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.l != null) {
                IntBuffer d2 = BufferUtils.d(16);
                int i7 = 1;
                if (this.f27453b != 0 && this.f27454c != 0) {
                    z = false;
                } else if (this.f27453b + this.f27454c != 0) {
                    throw new GdxRuntimeException("either both or none of glType, glFormat must be zero");
                } else {
                    z = true;
                }
                if (this.f27457f > 0) {
                    i3 = 2;
                    i4 = 3553;
                } else {
                    i3 = 1;
                    i4 = 4660;
                }
                if (this.f27458g > 0) {
                    i3 = 3;
                    i4 = 4660;
                }
                int i8 = this.f27460i;
                if (i8 == 6) {
                    if (i3 != 2) {
                        throw new GdxRuntimeException("cube map needs 2D faces");
                    }
                    i4 = 34067;
                } else if (i8 != 1) {
                    throw new GdxRuntimeException("numberOfFaces must be either 1 or 6");
                }
                if (this.f27459h > 0) {
                    if (i4 != 4660 && i4 != 3553) {
                        throw new GdxRuntimeException("No API for 3D and cube arrays yet");
                    }
                    i3++;
                    i4 = 4660;
                }
                if (i4 != 4660) {
                    int i9 = 34069;
                    if (this.f27460i != 6 || i2 == 34067) {
                        if (this.f27460i != 6 || i2 != 34067) {
                            if (i2 != i4 && (34069 > i2 || i2 > 34074 || i2 != 3553)) {
                                throw new GdxRuntimeException("Invalid target requested : 0x" + Integer.toHexString(i2) + ", expecting : 0x" + Integer.toHexString(i4));
                            }
                            i9 = i2;
                        }
                        i5 = -1;
                    } else if (34069 > i2 || i2 > 34074) {
                        throw new GdxRuntimeException("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
                    } else {
                        i5 = i2 - 34069;
                    }
                    c.b.b.f.f27077e.C(3317, d2);
                    int i10 = d2.get(0);
                    int i11 = 4;
                    if (i10 != 4) {
                        c.b.b.f.f27077e.g(3317, 4);
                    }
                    int i12 = this.f27455d;
                    int i13 = this.f27454c;
                    int i14 = this.k;
                    int i15 = 0;
                    while (i15 < this.f27461j) {
                        int max = Math.max(i7, this.f27456e >> i15);
                        int max2 = Math.max(i7, this.f27457f >> i15);
                        Math.max(i7, this.f27458g >> i15);
                        this.l.position(i14);
                        int i16 = this.l.getInt();
                        int i17 = (i16 + 3) & (-4);
                        i14 += i11;
                        int i18 = 0;
                        while (i18 < this.f27460i) {
                            this.l.position(i14);
                            i14 += i17;
                            if (i5 == -1 || i5 == i18) {
                                ByteBuffer slice = this.l.slice();
                                slice.limit(i17);
                                i6 = i5;
                                if (i3 != 1) {
                                    if (i3 == 2) {
                                        int i19 = this.f27459h;
                                        if (i19 > 0) {
                                            max2 = i19;
                                        }
                                        if (z) {
                                            if (i12 == ETC1.f29756b) {
                                                z2 = z;
                                                if (!c.b.b.f.f27074b.a("GL_OES_compressed_ETC1_RGB8_texture")) {
                                                    Pixmap a = ETC1.a(new ETC1.a(max, max2, slice, 0), Pixmap.Format.RGB888);
                                                    c.b.b.f.f27077e.q(i9 + i18, i15, a.j(), a.n(), a.l(), 0, a.i(), a.k(), a.m());
                                                    a.dispose();
                                                } else {
                                                    c.b.b.f.f27077e.h(i9 + i18, i15, i12, max, max2, 0, i16, slice);
                                                }
                                            } else {
                                                z2 = z;
                                                c.b.b.f.f27077e.h(i9 + i18, i15, i12, max, max2, 0, i16, slice);
                                            }
                                        } else {
                                            z2 = z;
                                            c.b.b.f.f27077e.q(i9 + i18, i15, i12, max, max2, 0, i13, this.f27453b, slice);
                                        }
                                    } else {
                                        z2 = z;
                                        if (i3 == 3) {
                                            int i20 = this.f27459h;
                                        }
                                    }
                                    i18++;
                                    i5 = i6;
                                    z = z2;
                                }
                            } else {
                                i6 = i5;
                            }
                            z2 = z;
                            i18++;
                            i5 = i6;
                            z = z2;
                        }
                        i15++;
                        i5 = i5;
                        z = z;
                        i7 = 1;
                        i11 = 4;
                    }
                    if (i10 != 4) {
                        c.b.b.f.f27077e.g(3317, i10);
                    }
                    if (g()) {
                        c.b.b.f.f27077e.F(i9);
                    }
                    i();
                    return;
                }
                throw new GdxRuntimeException("Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
            }
            throw new GdxRuntimeException("Call prepare() before calling consumeCompressedData()");
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
        }
        return (Pixmap) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap.Format e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new GdxRuntimeException("This TextureData implementation directly handles texture formats.");
        }
        return (Pixmap.Format) invokeV.objValue;
    }

    @Override // c.b.b.n.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c(34067);
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27457f : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public TextureData.TextureDataType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? TextureData.TextureDataType.Custom : (TextureData.TextureDataType) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f27456e : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ByteBuffer byteBuffer = this.l;
            if (byteBuffer != null) {
                BufferUtils.b(byteBuffer);
            }
            this.l = null;
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.l == null) {
                c.b.b.m.a aVar = this.a;
                if (aVar != null) {
                    if (aVar.g().endsWith(".zktx")) {
                        byte[] bArr = new byte[10240];
                        DataInputStream dataInputStream2 = null;
                        try {
                            try {
                                dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(this.a.m())));
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                        try {
                            this.l = BufferUtils.e(dataInputStream.readInt());
                            while (true) {
                                int read = dataInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                this.l.put(bArr, 0, read);
                            }
                            this.l.position(0);
                            this.l.limit(this.l.capacity());
                            i0.a(dataInputStream);
                        } catch (Exception e3) {
                            e = e3;
                            throw new GdxRuntimeException("Couldn't load zktx file '" + this.a + "'", e);
                        } catch (Throwable th2) {
                            th = th2;
                            dataInputStream2 = dataInputStream;
                            i0.a(dataInputStream2);
                            throw th;
                        }
                    } else {
                        this.l = ByteBuffer.wrap(this.a.n());
                    }
                    if (this.l.get() == -85) {
                        if (this.l.get() == 75) {
                            if (this.l.get() == 84) {
                                if (this.l.get() == 88) {
                                    if (this.l.get() == 32) {
                                        if (this.l.get() == 49) {
                                            if (this.l.get() == 49) {
                                                if (this.l.get() == -69) {
                                                    if (this.l.get() == 13) {
                                                        if (this.l.get() == 10) {
                                                            if (this.l.get() == 26) {
                                                                if (this.l.get() == 10) {
                                                                    int i2 = this.l.getInt();
                                                                    if (i2 != 67305985 && i2 != 16909060) {
                                                                        throw new GdxRuntimeException("Invalid KTX Header");
                                                                    }
                                                                    if (i2 != 67305985) {
                                                                        ByteBuffer byteBuffer = this.l;
                                                                        ByteOrder order = byteBuffer.order();
                                                                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                                                                        if (order == byteOrder) {
                                                                            byteOrder = ByteOrder.LITTLE_ENDIAN;
                                                                        }
                                                                        byteBuffer.order(byteOrder);
                                                                    }
                                                                    this.f27453b = this.l.getInt();
                                                                    this.l.getInt();
                                                                    this.f27454c = this.l.getInt();
                                                                    this.f27455d = this.l.getInt();
                                                                    this.l.getInt();
                                                                    this.f27456e = this.l.getInt();
                                                                    this.f27457f = this.l.getInt();
                                                                    this.f27458g = this.l.getInt();
                                                                    this.f27459h = this.l.getInt();
                                                                    this.f27460i = this.l.getInt();
                                                                    int i3 = this.l.getInt();
                                                                    this.f27461j = i3;
                                                                    if (i3 == 0) {
                                                                        this.f27461j = 1;
                                                                        this.m = true;
                                                                    }
                                                                    this.k = this.l.position() + this.l.getInt();
                                                                    if (this.l.isDirect()) {
                                                                        return;
                                                                    }
                                                                    int i4 = this.k;
                                                                    for (int i5 = 0; i5 < this.f27461j; i5++) {
                                                                        i4 += (((this.l.getInt(i4) + 3) & (-4)) * this.f27460i) + 4;
                                                                    }
                                                                    this.l.limit(i4);
                                                                    this.l.position(0);
                                                                    ByteBuffer e4 = BufferUtils.e(i4);
                                                                    e4.order(this.l.order());
                                                                    e4.put(this.l);
                                                                    this.l = e4;
                                                                    return;
                                                                }
                                                                throw new GdxRuntimeException("Invalid KTX Header");
                                                            }
                                                            throw new GdxRuntimeException("Invalid KTX Header");
                                                        }
                                                        throw new GdxRuntimeException("Invalid KTX Header");
                                                    }
                                                    throw new GdxRuntimeException("Invalid KTX Header");
                                                }
                                                throw new GdxRuntimeException("Invalid KTX Header");
                                            }
                                            throw new GdxRuntimeException("Invalid KTX Header");
                                        }
                                        throw new GdxRuntimeException("Invalid KTX Header");
                                    }
                                    throw new GdxRuntimeException("Invalid KTX Header");
                                }
                                throw new GdxRuntimeException("Invalid KTX Header");
                            }
                            throw new GdxRuntimeException("Invalid KTX Header");
                        }
                        throw new GdxRuntimeException("Invalid KTX Header");
                    }
                    throw new GdxRuntimeException("Invalid KTX Header");
                }
                throw new GdxRuntimeException("Need a file to load from");
            }
            throw new GdxRuntimeException("Already prepared");
        }
    }
}
