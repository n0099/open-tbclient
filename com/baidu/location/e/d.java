package com.baidu.location.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d a;

    /* renamed from: b  reason: collision with root package name */
    public static final double[] f35176b;

    /* renamed from: c  reason: collision with root package name */
    public static final double[] f35177c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<b> f35178d;

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public double f35179b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f35180c;

        public a(d dVar, double d2, double d3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Double.valueOf(d2), Double.valueOf(d3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35180c = dVar;
            this.a = d2;
            this.f35179b = d3;
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a a;

        /* renamed from: b  reason: collision with root package name */
        public a f35181b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f35182c;

        public b(d dVar, a aVar, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35182c = dVar;
            this.a = aVar;
            this.f35181b = aVar2;
        }

        public double a(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                d dVar = this.f35182c;
                a aVar2 = this.f35181b;
                double d2 = aVar2.a;
                a aVar3 = this.a;
                a aVar4 = new a(dVar, d2 - aVar3.a, aVar2.f35179b - aVar3.f35179b);
                d dVar2 = this.f35182c;
                double d3 = aVar.a;
                a aVar5 = this.a;
                a aVar6 = new a(dVar2, d3 - aVar5.a, aVar.f35179b - aVar5.f35179b);
                return (aVar4.a * aVar6.f35179b) - (aVar4.f35179b * aVar6.a);
            }
            return invokeL.doubleValue;
        }

        public boolean b(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.f35182c.a(a(aVar)) == 0 && aVar.a < Math.max(this.a.a, this.f35181b.a) + 1.0E-8d && aVar.a > Math.min(this.a.a, this.f35181b.a) - 1.0E-8d && aVar.f35179b < Math.max(this.a.f35179b, this.f35181b.f35179b) + 1.0E-8d && aVar.f35179b > Math.min(this.a.f35179b, this.f35181b.f35179b) - 1.0E-8d : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037812749, "Lcom/baidu/location/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037812749, "Lcom/baidu/location/e/d;");
                return;
            }
        }
        f35176b = new double[]{110.389648d, 105.070224d, 96.898845d, 95.617053d, 93.822557d, 91.387165d, 91.387165d, 89.079901d, 87.221341d, 86.259997d, 85.170461d, 85.234525d, 82.863261d, 81.901917d, 79.594685d, 80.395798d, 79.931142d, 77.800174d, 75.252622d, 73.490158d, 73.185732d, 73.874699d, 74.403435d, 74.099003d, 75.460905d, 76.77474d, 78.280852d, 78.15266d, 78.37698d, 78.8897d, 79.690818d, 81.196914d, 81.805762d, 83.888674d, 85.939538d, 87.862215d, 89.031847d, 90.057287d, 91.098741d, 92.156213d, 93.742421d, 95.825333d, 97.956327d, 97.123143d, 98.212679d, 99.206055d, 101.657471d, 102.52267d, 102.23427d, 105.022158d, 106.095662d, 107.858116d, 111.639396d, 109.588503d, 112.280343d, 117.792023d, 118.945559d, 114.203031d, 118.689303d, 123.143466d, 122.726858d, 120.932369d, 123.415857d, 122.374385d, 122.134054d, 121.586108d, 121.17271d, 120.676006d, 120.243409d, 122.790961d, 122.871076d, 121.300884d, 122.134052d, 123.736285d, 126.412019d, 128.559027d, 129.712627d, 131.218707d, 131.987795d, 133.622084d, 135.60888d, 131.378992d, 130.866224d, 128.623088d, 126.091572d, 124.393204d, 122.214164d, 119.65058d, 119.778772d, 118.561044d, 116.510192d, 114.811824d, 119.073776d, 116.446096d, 111.735536d, 110.389648d};
        f35177c = new double[]{43.216755d, 42.378597d, 43.172612d, 44.421188d, 45.097508d, 45.565732d, 47.334548d, 48.687188d, 49.62362d, 48.947316d, 48.479092d, 47.334548d, 47.438596d, 46.03394d, 45.201556d, 43.344095d, 42.328663d, 41.395882d, 40.829126d, 39.955382d, 39.258748d, 38.361382d, 38.054394d, 37.168842d, 36.389553d, 35.362313d, 34.311457d, 32.587581d, 31.572149d, 30.781055d, 30.438642d, 29.77743d, 30.09623d, 28.714766d, 27.71114d, 27.581258d, 27.014504d, 27.781984d, 27.510415d, 26.506787d, 26.707513d, 27.959095d, 27.29788d, 23.649404d, 23.62579d, 21.677574d, 20.780213d, 21.323353d, 22.185291d, 22.315173d, 22.515897d, 16.802289d, 13.198973d, 0.693351d, 1.541191d, 10.504055d, 15.591095d, 17.892375d, 19.951383d, 22.187501d, 25.375613d, 25.617568d, 30.627458d, 31.082902d, 31.894166d, 32.503117d, 32.805056d, 34.256784d, 35.155304d, 36.90119d, 37.83411d, 37.940728d, 38.64708d, 38.966937d, 40.979374d, 41.253698d, 42.069802d, 42.48888d, 44.65045d, 44.691252d, 48.620679d, 48.091311d, 49.194151d, 50.032311d, 53.274665d, 53.627577d, 53.892257d, 52.987929d, 52.017425d, 50.230825d, 50.186707d, 47.495779d, 47.341379d, 46.503219d, 45.245983d, 43.216755d};
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35178d = null;
        int length = f35176b.length;
        this.f35178d = new LinkedList<>();
        int i4 = 0;
        while (i4 < length - 1) {
            i4++;
            this.f35178d.add(new b(this, new a(this, f35176b[i4] * 100000.0d, f35177c[i4] * 100000.0d), new a(this, f35176b[i4] * 100000.0d, f35177c[i4] * 100000.0d)));
        }
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = new d();
            }
            return a;
        }
        return (d) invokeV.objValue;
    }

    public int a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < -1.0E-8d) {
                return -1;
            }
            return d2 > 1.0E-8d ? 1 : 0;
        }
        return invokeCommon.intValue;
    }

    public boolean a(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            try {
                a aVar = new a(this, d2 * 100000.0d, d3 * 100000.0d);
                Iterator<b> it = this.f35178d.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    if (next.b(aVar)) {
                        return true;
                    }
                    int a2 = a(next.a(aVar));
                    int a3 = a(next.a.f35179b - aVar.f35179b);
                    int a4 = a(next.f35181b.f35179b - aVar.f35179b);
                    if (a2 > 0 && a3 <= 0 && a4 > 0) {
                        i2++;
                    }
                    if (a2 < 0 && a4 <= 0 && a3 > 0) {
                        i2--;
                    }
                }
                return i2 != 0;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }
}
