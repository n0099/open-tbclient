package c.a.p0.l3.n0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import c.a.p0.l3.j0.b.h;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f16314b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f16315c;

    public f(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f16314b = context;
        this.f16315c = viewGroup;
    }

    public final boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if ("apk_download".equals(str)) {
                return "apk_download".equals(str2);
            }
            if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str)) {
                return TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public g b(h hVar, g gVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, gVar)) == null) {
            if (hVar == null || (str = hVar.a) == null) {
                return gVar;
            }
            if (gVar == null || !a(str, gVar.a)) {
                ViewGroup viewGroup = this.f16315c;
                if (viewGroup == null) {
                    return null;
                }
                viewGroup.removeAllViews();
                if (TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT.equals(hVar.a)) {
                    int i = this.a;
                    if (i == 1) {
                        return new e(LayoutInflater.from(this.f16314b).inflate(R.layout.obfuscated_res_0x7f0d0892, this.f16315c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    if (i == 2) {
                        return new d(LayoutInflater.from(this.f16314b).inflate(R.layout.obfuscated_res_0x7f0d087c, this.f16315c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                    }
                    return new b(LayoutInflater.from(this.f16314b).inflate(R.layout.obfuscated_res_0x7f0d080a, this.f16315c, true), TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                } else if ("apk_download".equals(hVar.a)) {
                    if (this.a == 2) {
                        return new c(LayoutInflater.from(this.f16314b).inflate(R.layout.obfuscated_res_0x7f0d087b, this.f16315c, true), "apk_download");
                    }
                    return new a(LayoutInflater.from(this.f16314b).inflate(R.layout.obfuscated_res_0x7f0d0809, this.f16315c, true), "apk_download");
                } else {
                    return null;
                }
            }
            return gVar;
        }
        return (g) invokeLL.objValue;
    }
}
