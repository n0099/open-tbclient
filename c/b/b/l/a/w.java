package c.b.b.l.a;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.tachikoma.core.utility.FileUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class w extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22445d;

    /* renamed from: e  reason: collision with root package name */
    public long f22446e;

    /* renamed from: f  reason: collision with root package name */
    public a0 f22447f;

    /* renamed from: g  reason: collision with root package name */
    public String f22448g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(String str) {
        super((AssetManager) null, str, Files.FileType.Internal);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (String) objArr2[1], (Files.FileType) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        w();
    }

    @Override // c.b.b.l.a.g, c.b.b.m.a
    public c.b.b.m.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.getPath().length() == 0) {
                return new w(new File(str), this.f22467b);
            }
            return new w(new File(this.a, str), this.f22467b);
        }
        return (c.b.b.m.a) invokeL.objValue;
    }

    @Override // c.b.b.l.a.g, c.b.b.m.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22445d || this.f22447f.b(v()).length != 0 : invokeV.booleanValue;
    }

    @Override // c.b.b.l.a.g, c.b.b.m.a
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f22445d) {
                return this.f22446e;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.b.b.l.a.g, c.b.b.m.a
    public c.b.b.m.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null) {
                parentFile = new File("");
            }
            return new w(parentFile.getPath());
        }
        return (c.b.b.m.a) invokeV.objValue;
    }

    @Override // c.b.b.l.a.g, c.b.b.m.a
    public InputStream m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return this.f22447f.c(v());
            } catch (IOException e2) {
                throw new GdxRuntimeException("Error reading file: " + this.a + " (ZipResourceFile)", e2);
            }
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // c.b.b.l.a.g, c.b.b.m.a
    public c.b.b.m.a s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (this.a.getPath().length() != 0) {
                return c.b.b.f.f22333d.d(new File(this.a.getParent(), str).getPath(), this.f22467b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (c.b.b.m.a) invokeL.objValue;
    }

    @Override // c.b.b.l.a.g
    public AssetFileDescriptor u() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22447f.a(v()) : (AssetFileDescriptor) invokeV.objValue;
    }

    public final String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22448g : (String) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f22448g = this.a.getPath().replace(FileUtil.WINDOWS_SEPARATOR, WebvttCueParser.CHAR_SLASH);
            a0 c2 = ((h) c.b.b.f.f22333d).c();
            this.f22447f = c2;
            AssetFileDescriptor a = c2.a(v());
            if (a != null) {
                this.f22445d = true;
                this.f22446e = a.getLength();
                try {
                    a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f22445d = false;
            }
            if (x()) {
                this.f22448g += "/";
            }
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !this.f22445d : invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(File file, Files.FileType fileType) {
        super((AssetManager) null, file, fileType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, fileType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((AssetManager) objArr2[0], (File) objArr2[1], (Files.FileType) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        w();
    }
}
