package b.i.b.a.d0.v.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f32085a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32086b;

    /* renamed from: c  reason: collision with root package name */
    public final List<g> f32087c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f32088d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f32089e;

    public a(int i2, int i3, List<g> list, List<d> list2, List<d> list3) {
        List<d> unmodifiableList;
        List<d> unmodifiableList2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), list, list2, list3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32085a = i2;
        this.f32086b = i3;
        this.f32087c = Collections.unmodifiableList(list);
        if (list2 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list2);
        }
        this.f32088d = unmodifiableList;
        if (list3 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list3);
        }
        this.f32089e = unmodifiableList2;
    }
}
