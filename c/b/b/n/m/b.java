package c.b.b.n.m;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b implements TextureData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.m.a a;

    /* renamed from: b  reason: collision with root package name */
    public int f27691b;

    /* renamed from: c  reason: collision with root package name */
    public int f27692c;

    /* renamed from: d  reason: collision with root package name */
    public Pixmap.Format f27693d;

    /* renamed from: e  reason: collision with root package name */
    public Pixmap f27694e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27695f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27696g;

    public b(c.b.b.m.a aVar, Pixmap pixmap, Pixmap.Format format, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, pixmap, format, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27691b = 0;
        this.f27692c = 0;
        this.f27696g = false;
        this.a = aVar;
        this.f27694e = pixmap;
        this.f27693d = format;
        this.f27695f = z;
        if (pixmap != null) {
            this.f27691b = pixmap.n();
            this.f27692c = this.f27694e.l();
            if (format == null) {
                this.f27693d = this.f27694e.h();
            }
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f27696g : invokeV.booleanValue;
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
            throw new GdxRuntimeException("This TextureData implementation does not upload data itself");
        }
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f27696g) {
                this.f27696g = false;
                Pixmap pixmap = this.f27694e;
                this.f27694e = null;
                return pixmap;
            }
            throw new GdxRuntimeException("Call prepare() before calling getPixmap()");
        }
        return (Pixmap) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public Pixmap.Format e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27693d : (Pixmap.Format) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27695f : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27692c : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public TextureData.TextureDataType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? TextureData.TextureDataType.Pixmap : (TextureData.TextureDataType) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27691b : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.graphics.TextureData
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f27696g) {
                if (this.f27694e == null) {
                    if (this.a.d().equals("cim")) {
                        this.f27694e = c.b.b.n.f.a(this.a);
                    } else {
                        this.f27694e = new Pixmap(this.a);
                    }
                    this.f27691b = this.f27694e.n();
                    this.f27692c = this.f27694e.l();
                    if (this.f27693d == null) {
                        this.f27693d = this.f27694e.h();
                    }
                }
                this.f27696g = true;
                return;
            }
            throw new GdxRuntimeException("Already prepared");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.toString() : (String) invokeV.objValue;
    }
}
