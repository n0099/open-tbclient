package b.h.b.a.a0.t;

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
/* loaded from: classes6.dex */
public interface w {

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f32681a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f32682b;

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
            this.f32681a = str;
            this.f32682b = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32683a;

        /* renamed from: b  reason: collision with root package name */
        public final String f32684b;

        /* renamed from: c  reason: collision with root package name */
        public final List<a> f32685c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f32686d;

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
            this.f32683a = i2;
            this.f32684b = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.f32685c = unmodifiableList;
            this.f32686d = bArr;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        w a(int i2, b bVar);

        SparseArray<w> b();
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f32687a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32688b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32689c;

        /* renamed from: d  reason: collision with root package name */
        public int f32690d;

        /* renamed from: e  reason: collision with root package name */
        public String f32691e;

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
                int i2 = this.f32690d;
                this.f32690d = i2 == Integer.MIN_VALUE ? this.f32688b : i2 + this.f32689c;
                this.f32691e = this.f32687a + this.f32690d;
            }
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                d();
                return this.f32691e;
            }
            return (String) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                d();
                return this.f32690d;
            }
            return invokeV.intValue;
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f32690d == Integer.MIN_VALUE) {
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
            this.f32687a = str;
            this.f32688b = i3;
            this.f32689c = i4;
            this.f32690d = Integer.MIN_VALUE;
        }
    }

    void a(b.h.b.a.i0.s sVar, b.h.b.a.a0.g gVar, d dVar);

    void b();

    void c(b.h.b.a.i0.l lVar, boolean z) throws ParserException;
}
