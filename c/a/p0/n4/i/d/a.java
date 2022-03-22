package c.a.p0.n4.i.d;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.n4.i.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.n4.i.e.a f16629b;

    /* renamed from: c  reason: collision with root package name */
    public b f16630c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f16631d;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static void a(List<c.a.p0.n4.i.e.a> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65537, null, list, i, str, str2) == null) || list == null) {
            return;
        }
        list.add(new c.a.p0.n4.i.e.a(str, i, str2));
    }

    public static List<c.a.p0.n4.i.e.a> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080563, context.getString(R.string.obfuscated_res_0x7f0f060a), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080567, context.getString(R.string.obfuscated_res_0x7f0f0607), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056a, context.getString(R.string.obfuscated_res_0x7f0f060b), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080566, context.getString(R.string.obfuscated_res_0x7f0f0605), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080561, context.getString(R.string.obfuscated_res_0x7f0f0602), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056e, context.getString(R.string.obfuscated_res_0x7f0f060f), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080560, context.getString(R.string.obfuscated_res_0x7f0f0601), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080568, context.getString(R.string.obfuscated_res_0x7f0f0608), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080562, context.getString(R.string.obfuscated_res_0x7f0f0606), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055d, context.getString(R.string.obfuscated_res_0x7f0f05fe), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080564, context.getString(R.string.obfuscated_res_0x7f0f0603), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056c, context.getString(R.string.obfuscated_res_0x7f0f060d), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056d, context.getString(R.string.obfuscated_res_0x7f0f060e), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055f, context.getString(R.string.obfuscated_res_0x7f0f0600), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080569, context.getString(R.string.obfuscated_res_0x7f0f0609), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080565, context.getString(R.string.obfuscated_res_0x7f0f0604), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056b, context.getString(R.string.obfuscated_res_0x7f0f060c), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08055e, context.getString(R.string.obfuscated_res_0x7f0f05ff), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c.a.p0.n4.c.f16597f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.n4.i.e.a aVar = this.f16629b;
            return (aVar == null || "normal".equalsIgnoreCase(aVar.f16666c)) ? "" : this.f16629b.f16666c;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f16630c) == null) {
            return;
        }
        bVar.e();
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f16630c;
            if (bVar != null) {
                return bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            b bVar = this.f16630c;
            if ((bVar == null || !bVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                b bVar2 = new b(this.a, str, d(), str2);
                this.f16630c = bVar2;
                b.c cVar = this.f16631d;
                if (cVar != null) {
                    bVar2.h(cVar);
                }
                this.f16630c.i();
            }
        }
    }

    public void h(c.a.p0.n4.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f16629b = aVar;
        }
    }

    public void i(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f16631d = cVar;
            b bVar = this.f16630c;
            if (bVar != null) {
                bVar.h(cVar);
            }
        }
    }
}
