package c.a.r0.p0.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import c.a.r0.p0.a.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class c implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.p0.a.e.a f23408a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23409b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23410c;

    /* renamed from: d  reason: collision with root package name */
    public b f23411d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23412e;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23410c = false;
        this.f23412e = false;
        this.f23408a = new c.a.r0.p0.a.e.a();
        this.f23412e = z;
    }

    @Override // c.a.r0.p0.a.f.e
    public void a(String str, c.a.r0.p0.a.g.b bVar) {
        b bVar2;
        b bVar3;
        float f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f23409b) {
            File file = new File(bVar.f23441a);
            Bitmap decodeFile = BitmapFactory.decodeFile(bVar.f23441a);
            if (file.exists() && decodeFile != null) {
                float height = decodeFile.getHeight();
                float width = decodeFile.getWidth();
                float f3 = height * 1.0f;
                float f4 = f3 / width;
                float f5 = f4 > 1.0f ? 1.7777778f : 0.75f;
                float f6 = 0.0f;
                if (f4 > f5) {
                    float f7 = f5 * width;
                    f2 = (height - f7) * 0.5f;
                    height = f7;
                } else {
                    float f8 = f3 / f5;
                    f6 = (width - f8) * 0.5f;
                    width = f8;
                    f2 = 0.0f;
                }
                bVar.f23441a = FileHelper.saveFile(file.getPath(), file.getName(), Bitmap.createBitmap(decodeFile, (int) f6, (int) f2, (int) width, (int) height), 95);
            }
        }
        if ("default".equals(str)) {
            if (this.f23410c || (bVar3 = this.f23411d) == null) {
                return;
            }
            bVar3.onCoverPathCallBack(bVar.f23441a);
        } else if (!"manual".equals(str) || (bVar2 = this.f23411d) == null) {
        } else {
            bVar2.onCoverPathCallBack(bVar.f23441a);
        }
    }

    public void b(c.a.r0.p0.a.g.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str) == null) {
            this.f23408a.a(str, this.f23412e).a(cVar, this);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f23410c = z;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f23409b = z;
        }
    }

    public void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f23411d = bVar;
        }
    }

    @Override // c.a.r0.p0.a.f.e
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            BdLog.e("get cover error ! type : " + str + ", err : " + str2);
        }
    }
}
