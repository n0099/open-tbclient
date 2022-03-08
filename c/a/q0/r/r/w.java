package c.a.q0.r.r;

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

    /* renamed from: e  reason: collision with root package name */
    public int f13396e;

    /* renamed from: f  reason: collision with root package name */
    public int f13397f;

    /* renamed from: g  reason: collision with root package name */
    public String f13398g;

    /* renamed from: h  reason: collision with root package name */
    public String f13399h;

    /* renamed from: i  reason: collision with root package name */
    public String f13400i;

    /* renamed from: j  reason: collision with root package name */
    public String f13401j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public int s;
    public int t;

    public w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13396e = i2;
        this.f13397f = i3;
    }

    public static w b(TbLinkSpanGroup tbLinkSpanGroup, c.a.r0.j1.a aVar) {
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
                str = TbadkCoreApplication.getInst().getString(R.string.web_page_link);
            } else {
                str = aVar.f() + TbadkCoreApplication.getInst().getString(R.string.commodity_link);
            }
            wVar.f13399h = str;
            wVar.f13398g = aVar.c();
            wVar.q = aVar.a();
            if (!ListUtils.isEmpty(aVar.b()) && aVar.b().get(0) != null) {
                wVar.f13400i = aVar.b().get(0).a();
            }
            wVar.p = aVar.f();
            wVar.f13401j = aVar.d();
            if (aVar.e() != null) {
                wVar.n = aVar.e().a();
                wVar.o = aVar.e().b();
            }
            tbLinkSpanGroup.y(wVar);
            return wVar;
        }
        return (w) invokeLL.objValue;
    }

    public static w c(TbLinkSpanGroup tbLinkSpanGroup, c.a.q0.r.l0.s.f fVar) {
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
            wVar.f13398g = fVar.f13047e;
            wVar.f13400i = fVar.f13046d;
            wVar.p = fVar.f13048f;
            wVar.f13401j = fVar.f13049g;
            wVar.k = fVar.f13045c;
            wVar.r = fVar.f13050h;
            String str = fVar.f13051i;
            wVar.m = fVar.f13044b == 1;
            wVar.s = fVar.f13044b;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) ? this.t - wVar.t : invokeL.intValue;
    }
}
