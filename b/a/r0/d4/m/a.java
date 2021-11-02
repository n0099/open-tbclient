package b.a.r0.d4.m;

import b.a.e.e.d.l;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.d4.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0812a extends i0<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f15961a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f15962b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f15963c;

        public C0812a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15961a = i2;
            this.f15962b = str;
            this.f15963c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // b.a.q0.d1.i0
        public Integer doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f15961a;
                b.a.q0.s.r.a.f();
                l<String> g2 = b.a.q0.s.r.a.g("tb.write_privacy_state_space" + this.f15962b);
                if (g2 != null) {
                    i2 = b.a.e.e.m.b.e(g2.get(this.f15963c), this.f15961a);
                }
                return Integer.valueOf(i2);
            }
            return (Integer) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements q<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15964a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15964a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, num) == null) || (cVar = this.f15964a) == null) {
                return;
            }
            cVar.a(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2);
    }

    public static void a(String str, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65536, null, str, i2, cVar) == null) || StringUtils.isNull(str) || cVar == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        l0.b(new C0812a(i2, currentAccount, str), new b(cVar));
    }

    public static void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) || StringUtils.isNull(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        b.a.q0.s.r.a.f();
        l<String> g2 = b.a.q0.s.r.a.g("tb.write_privacy_state_space" + currentAccount);
        if (g2 != null) {
            g2.a(str, String.valueOf(i2));
        }
    }
}
