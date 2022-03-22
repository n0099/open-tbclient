package c.a.o0.r.r;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class w implements Comparable<w> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f10972b;

    /* renamed from: c  reason: collision with root package name */
    public String f10973c;

    /* renamed from: d  reason: collision with root package name */
    public String f10974d;

    /* renamed from: e  reason: collision with root package name */
    public String f10975e;

    /* renamed from: f  reason: collision with root package name */
    public String f10976f;

    /* renamed from: g  reason: collision with root package name */
    public String f10977g;

    /* renamed from: h  reason: collision with root package name */
    public String f10978h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public int p;

    public w(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.f10972b = i2;
    }

    public static w b(TbLinkSpanGroup tbLinkSpanGroup, c.a.p0.l1.a aVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbLinkSpanGroup, aVar)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            w wVar = new w(tbLinkSpanGroup.e(), 2);
            if (aVar == null) {
                return wVar;
            }
            if (TextUtils.isEmpty(aVar.f())) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1548);
            } else {
                str = aVar.f() + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0400);
            }
            wVar.f10974d = str;
            wVar.f10973c = aVar.c();
            wVar.m = aVar.a();
            if (!ListUtils.isEmpty(aVar.b()) && aVar.b().get(0) != null) {
                wVar.f10975e = aVar.b().get(0).a();
            }
            wVar.l = aVar.f();
            wVar.f10976f = aVar.d();
            if (aVar.e() != null) {
                wVar.j = aVar.e().a();
                wVar.k = aVar.e().b();
            }
            tbLinkSpanGroup.y(wVar);
            return wVar;
        }
        return (w) invokeLL.objValue;
    }

    public static w c(TbLinkSpanGroup tbLinkSpanGroup, c.a.o0.r.l0.s.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbLinkSpanGroup, fVar)) == null) {
            if (tbLinkSpanGroup == null) {
                return null;
            }
            w wVar = new w(tbLinkSpanGroup.e(), 1);
            if (fVar == null) {
                return wVar;
            }
            wVar.f10973c = fVar.f10693e;
            wVar.f10975e = fVar.f10692d;
            wVar.l = fVar.f10694f;
            wVar.f10976f = fVar.f10695g;
            wVar.f10977g = fVar.f10691c;
            wVar.n = fVar.f10696h;
            String str = fVar.i;
            wVar.i = fVar.f10690b == 1;
            wVar.o = fVar.f10690b;
            tbLinkSpanGroup.y(wVar);
            return wVar;
        }
        return (w) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) ? this.p - wVar.p : invokeL.intValue;
    }
}
