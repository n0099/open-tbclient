package c.i.b.a.d0.w.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final List<C1670a> f29553c;

    /* renamed from: d  reason: collision with root package name */
    public final List<C1670a> f29554d;

    /* renamed from: e  reason: collision with root package name */
    public final List<C1670a> f29555e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f29556f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Format> f29557g;

    /* renamed from: c.i.b.a.d0.w.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1670a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f29558b;

        public C1670a(String str, Format format) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, format};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f29558b = format;
        }

        public static C1670a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new C1670a(str, Format.createContainerFormat("0", "application/x-mpegURL", null, null, -1, 0, null)) : (C1670a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, List<String> list, List<C1670a> list2, List<C1670a> list3, List<C1670a> list4, Format format, List<Format> list5) {
        super(str, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, list2, list3, list4, format, list5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29553c = Collections.unmodifiableList(list2);
        this.f29554d = Collections.unmodifiableList(list3);
        this.f29555e = Collections.unmodifiableList(list4);
        this.f29556f = format;
        this.f29557g = list5 != null ? Collections.unmodifiableList(list5) : null;
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            List singletonList = Collections.singletonList(C1670a.a(str));
            List emptyList = Collections.emptyList();
            return new a(null, Collections.emptyList(), singletonList, emptyList, emptyList, null, null);
        }
        return (a) invokeL.objValue;
    }
}
