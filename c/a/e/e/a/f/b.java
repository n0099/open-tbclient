package c.a.e.e.a.f;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import c.a.e.e.a.f.c;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Rect f2117f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2, DiskFileOperate.Action action) {
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
        this.f2117f = null;
        this.f2117f = new Rect();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c A[RETURN] */
    @Override // c.a.e.e.a.f.c, com.baidu.adp.lib.Disk.ops.DiskFileOperate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr != null && this.f2120c.b(bArr)) {
                long j2 = this.f2120c.f2126b;
                if (j2 == 0 || j2 >= System.currentTimeMillis()) {
                    if (this.f2119b == null) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        this.f2119b = options;
                        options.inDither = false;
                        int i2 = BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi;
                        BitmapFactory.Options options2 = this.f2119b;
                        options2.inScreenDensity = i2;
                        options2.inTargetDensity = i2;
                        options2.inDensity = i2;
                    }
                    int a2 = c.a.a();
                    ByteArrayInputStream byteArrayInputStream2 = null;
                    try {
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(bArr, a2, bArr.length - a2);
                        } catch (Error e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        this.f2118a = BitmapFactory.decodeStream(byteArrayInputStream, this.f2117f, this.f2119b);
                        c.a.e.e.m.a.c(byteArrayInputStream);
                    } catch (Error e3) {
                        e = e3;
                        byteArrayInputStream2 = byteArrayInputStream;
                        BdLog.e(e.getMessage());
                        c.a.e.e.m.a.c(byteArrayInputStream2);
                        if (this.f2118a == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        c.a.e.e.m.a.c(byteArrayInputStream2);
                        throw th;
                    }
                    return this.f2118a == null;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Rect g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2117f : (Rect) invokeV.objValue;
    }
}
