package c.i.b.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
/* loaded from: classes7.dex */
public interface g extends q {

    /* loaded from: classes7.dex */
    public interface a {
        void h(int i2, Object obj) throws ExoPlaybackException;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30118b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f30119c;

        public b(a aVar, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f30118b = i2;
            this.f30119c = obj;
        }
    }

    void a(b... bVarArr);

    void b(c.i.b.a.d0.l lVar);

    void s(b... bVarArr);
}
