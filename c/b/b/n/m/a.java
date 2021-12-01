package c.b.b.n.m;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.glutils.ETC1;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements TextureData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.b.b.m.a a;

    /* renamed from: b  reason: collision with root package name */
    public ETC1.a f27686b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27687c;

    /* renamed from: d  reason: collision with root package name */
    public int f27688d;

    /* renamed from: e  reason: collision with root package name */
    public int f27689e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27690f;

    public a(c.b.b.m.a aVar, boolean z) {
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
        this.f27688d = 0;
        this.f27689e = 0;
        this.f27690f = false;
        this.a = aVar;
        this.f27687c = z;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27690f : invokeV.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f27690f) {
                if (!c.b.b.f.f27320b.a("GL_OES_compressed_ETC1_RGB8_texture")) {
                    Pixmap a = ETC1.a(this.f27686b, Pixmap.Format.RGB565);
                    c.b.b.f.f27323e.q(i2, 0, a.j(), a.n(), a.l(), 0, a.i(), a.k(), a.m());
                    if (this.f27687c) {
                        h.a(i2, a, a.n(), a.l());
                    }
                    a.dispose();
                    this.f27687c = false;
                } else {
                    c.b.b.n.c cVar = c.b.b.f.f27323e;
                    int i3 = ETC1.f31615b;
                    int i4 = this.f27688d;
                    int i5 = this.f27689e;
                    int capacity = this.f27686b.f31618g.capacity();
                    ETC1.a aVar = this.f27686b;
                    cVar.h(i2, 0, i3, i4, i5, 0, capacity - aVar.f31619h, aVar.f31618g);
                    if (g()) {
                        c.b.b.f.f27324f.F(3553);
                    }
                }
                this.f27686b.dispose();
                this.f27686b = null;
                this.f27690f = false;
                return;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Pixmap.Format.RGB565 : (Pixmap.Format) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27687c : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27689e : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public TextureData.TextureDataType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextureData.TextureDataType.Custom : (TextureData.TextureDataType) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27688d : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f27690f) {
                if (this.a == null && this.f27686b == null) {
                    throw new GdxRuntimeException("Can only load once from ETC1Data");
                }
                c.b.b.m.a aVar = this.a;
                if (aVar != null) {
                    this.f27686b = new ETC1.a(aVar);
                }
                ETC1.a aVar2 = this.f27686b;
                this.f27688d = aVar2.f31616e;
                this.f27689e = aVar2.f31617f;
                this.f27690f = true;
                return;
            }
            throw new GdxRuntimeException("Already prepared");
        }
    }
}
