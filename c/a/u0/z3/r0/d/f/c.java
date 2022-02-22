package c.a.u0.z3.r0.d.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26369g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, int i2, int i3, long j2, String str2) {
        super(str, i2, i3, j2, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.u0.z3.r0.d.f.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26369g = true;
        }
    }

    @Override // c.a.u0.z3.r0.d.f.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26369g : invokeV.booleanValue;
    }

    @Override // c.a.u0.z3.r0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, str, i2)) == null) {
            d dVar = new d();
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f26354b), "r");
                int i3 = 0;
                int size = arrayList.size();
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    int i4 = i3 + 1;
                    d h2 = h(randomAccessFile, it.next().intValue(), i2, str);
                    if (h2 == null) {
                        return null;
                    }
                    d((int) (((i4 * 50.0f) / size) + 30.0f));
                    if (!StringUtils.isNull(h2.a) || h2.f26370b != 0) {
                        return h2;
                    }
                    i3 = i4;
                    dVar = h2;
                }
            } catch (FileNotFoundException unused) {
            }
            return dVar;
        }
        return (d) invokeLLI.objValue;
    }
}
