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
    public int f22677b;

    /* renamed from: c  reason: collision with root package name */
    public int f22678c;

    /* renamed from: d  reason: collision with root package name */
    public int f22679d;

    /* renamed from: e  reason: collision with root package name */
    public int f22680e;

    /* renamed from: f  reason: collision with root package name */
    public int f22681f;

    /* renamed from: g  reason: collision with root package name */
    public int f22682g;

    /* renamed from: h  reason: collision with root package name */
    public int f22683h;
    public int i;
    public int j;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22680e = -1;
        this.f22681f = -1;
        this.f22682g = -1;
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
    public void c(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.l != null) {
                IntBuffer d2 = BufferUtils.d(16);
                int i6 = 1;
                if (this.f22677b != 0 && this.f22678c != 0) {
                    z = false;
                } else if (this.f22677b + this.f22678c != 0) {
                    throw new GdxRuntimeException("either both or none of glType, glFormat must be zero");
                } else {
                    z = true;
                }
                if (this.f22681f > 0) {
                    i2 = 2;
                    i3 = 3553;
                } else {
                    i2 = 1;
                    i3 = 4660;
                }
                if (this.f22682g > 0) {
                    i2 = 3;
                    i3 = 4660;
                }
                int i7 = this.i;
                if (i7 == 6) {
                    if (i2 != 2) {
                        throw new GdxRuntimeException("cube map needs 2D faces");
                    }
                    i3 = 34067;
                } else if (i7 != 1) {
                    throw new GdxRuntimeException("numberOfFaces must be either 1 or 6");
                }
                if (this.f22683h > 0) {
                    if (i3 != 4660 && i3 != 3553) {
                        throw new GdxRuntimeException("No API for 3D and cube arrays yet");
                    }
                    i2++;
                    i3 = 4660;
                }
                if (i3 != 4660) {
                    int i8 = 34069;
                    if (this.i != 6 || i == 34067) {
                        if (this.i != 6 || i != 34067) {
                            if (i != i3 && (34069 > i || i > 34074 || i != 3553)) {
                                throw new GdxRuntimeException("Invalid target requested : 0x" + Integer.toHexString(i) + ", expecting : 0x" + Integer.toHexString(i3));
                            }
                            i8 = i;
                        }
                        i4 = -1;
                    } else if (34069 > i || i > 34074) {
                        throw new GdxRuntimeException("You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
                    } else {
                        i4 = i - 34069;
                    }
                    c.b.b.f.f22334e.C(3317, d2);
                    int i9 = d2.get(0);
                    int i10 = 4;
                    if (i9 != 4) {
                        c.b.b.f.f22334e.g(3317, 4);
                    }
                    int i11 = this.f22679d;
                    int i12 = this.f22678c;
                    int i13 = this.k;
                    int i14 = 0;
                    while (i14 < this.j) {
                        int max = Math.max(i6, this.f22680e >> i14);
                        int max2 = Math.max(i6, this.f22681f >> i14);
                        Math.max(i6, this.f22682g >> i14);
                        this.l.position(i13);
                        int i15 = this.l.getInt();
                        int i16 = (i15 + 3) & (-4);
                        i13 += i10;
                        int i17 = 0;
                        while (i17 < this.i) {
                            this.l.position(i13);
                            i13 += i16;
                            if (i4 == -1 || i4 == i17) {
                                ByteBuffer slice = this.l.slice();
                                slice.limit(i16);
                                i5 = i4;
                                if (i2 != 1) {
                                    if (i2 == 2) {
                                        int i18 = this.f22683h;
                                        if (i18 > 0) {
                                            max2 = i18;
                                        }
                                        if (z) {
                                            if (i11 == ETC1.f23777b) {
                                                z2 = z;
                                                if (!c.b.b.f.f22331b.a("GL_OES_compressed_ETC1_RGB8_texture")) {
                                                    Pixmap a = ETC1.a(new ETC1.a(max, max2, slice, 0), Pixmap.Format.RGB888);
                                                    c.b.b.f.f22334e.q(i8 + i17, i14, a.j(), a.n(), a.l(), 0, a.i(), a.k(), a.m());
                                                    a.dispose();
                                                } else {
                                                    c.b.b.f.f22334e.h(i8 + i17, i14, i11, max, max2, 0, i15, slice);
                                                }
                                            } else {
                                                z2 = z;
                                                c.b.b.f.f22334e.h(i8 + i17, i14, i11, max, max2, 0, i15, slice);
                                            }
                                        } else {
                                            z2 = z;
                                            c.b.b.f.f22334e.q(i8 + i17, i14, i11, max, max2, 0, i12, this.f22677b, slice);
                                        }
                                    } else {
                                        z2 = z;
                                        if (i2 == 3) {
                                            int i19 = this.f22683h;
                                        }
                                    }
                                    i17++;
                                    i4 = i5;
                                    z = z2;
                                }
                            } else {
                                i5 = i4;
                            }
                            z2 = z;
                            i17++;
                            i4 = i5;
                            z = z2;
                        }
                        i14++;
                        i4 = i4;
                        z = z;
                        i6 = 1;
                        i10 = 4;
                    }
                    if (i9 != 4) {
                        c.b.b.f.f22334e.g(3317, i9);
                    }
                    if (g()) {
                        c.b.b.f.f22334e.F(i8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22681f : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22680e : invokeV.intValue;
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
                                                                    int i = this.l.getInt();
                                                                    if (i != 67305985 && i != 16909060) {
                                                                        throw new GdxRuntimeException("Invalid KTX Header");
                                                                    }
                                                                    if (i != 67305985) {
                                                                        ByteBuffer byteBuffer = this.l;
                                                                        ByteOrder order = byteBuffer.order();
                                                                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                                                                        if (order == byteOrder) {
                                                                            byteOrder = ByteOrder.LITTLE_ENDIAN;
                                                                        }
                                                                        byteBuffer.order(byteOrder);
                                                                    }
                                                                    this.f22677b = this.l.getInt();
                                                                    this.l.getInt();
                                                                    this.f22678c = this.l.getInt();
                                                                    this.f22679d = this.l.getInt();
                                                                    this.l.getInt();
                                                                    this.f22680e = this.l.getInt();
                                                                    this.f22681f = this.l.getInt();
                                                                    this.f22682g = this.l.getInt();
                                                                    this.f22683h = this.l.getInt();
                                                                    this.i = this.l.getInt();
                                                                    int i2 = this.l.getInt();
                                                                    this.j = i2;
                                                                    if (i2 == 0) {
                                                                        this.j = 1;
                                                                        this.m = true;
                                                                    }
                                                                    this.k = this.l.position() + this.l.getInt();
                                                                    if (this.l.isDirect()) {
                                                                        return;
                                                                    }
                                                                    int i3 = this.k;
                                                                    for (int i4 = 0; i4 < this.j; i4++) {
                                                                        i3 += (((this.l.getInt(i3) + 3) & (-4)) * this.i) + 4;
                                                                    }
                                                                    this.l.limit(i3);
                                                                    this.l.position(0);
                                                                    ByteBuffer e4 = BufferUtils.e(i3);
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
