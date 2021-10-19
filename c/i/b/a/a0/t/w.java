package c.i.b.a.a0.t;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public interface w {

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f32970a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f32971b;

        public a(String str, int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32970a = str;
            this.f32971b = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32972a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32973b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f32974c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f32975d;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            List<a> unmodifiableList;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, list, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32972a = i2;
            this.f32973b = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.f32974c = unmodifiableList;
            this.f32975d = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        w a(int i2, b bVar);

        SparseArray<w> b();
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f32976a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32977b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32978c;

        /* renamed from: d  reason: collision with root package name */
        public int f32979d;

        /* renamed from: e  reason: collision with root package name */
        public String f32980e;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f32979d;
                this.f32979d = i2 == Integer.MIN_VALUE ? this.f32977b : i2 + this.f32978c;
                this.f32980e = this.f32976a + this.f32979d;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d();
                return this.f32980e;
            }
            return (String) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                d();
                return this.f32979d;
            }
            return invokeV.intValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f32979d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public d(int i2, int i3, int i4) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f32976a = str;
            this.f32977b = i3;
            this.f32978c = i4;
            this.f32979d = Integer.MIN_VALUE;
        }
    }

    void a(c.i.b.a.i0.s sVar, c.i.b.a.a0.g gVar, d dVar);

    void b();

    void c(c.i.b.a.i0.l lVar, boolean z) throws ParserException;
}
