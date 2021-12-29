package c.b.b.n.l.f;

import c.b.b.f;
import c.b.b.j.f.e;
import c.b.b.j.f.g;
import c.b.b.n.l.g.g.d;
import c.b.b.n.l.g.g.h;
import c.b.b.q.a;
import c.b.b.q.i;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class c extends g<b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f28058h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final i f28059d;

    /* renamed from: e  reason: collision with root package name */
    public final i f28060e;

    /* renamed from: f  reason: collision with root package name */
    public final i f28061f;

    /* renamed from: g  reason: collision with root package name */
    public final c.b.b.q.a<a> f28062g;

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public String f28063b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.a<Integer> f28064c;

        /* renamed from: d  reason: collision with root package name */
        public int f28065d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28066e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28067f;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
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
            this.f28064c = new c.b.b.q.a<>(200);
            this.f28065d = 0;
            new c.b.b.n.l.c("");
            this.f28063b = "default";
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28068c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-390497449, "Lc/b/b/n/l/f/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-390497449, "Lc/b/b/n/l/f/c;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28059d = new i(300);
        this.f28060e = new i(300);
        this.f28061f = new i(200);
        this.f28062g = new c.b.b.q.a<>(10);
    }

    public final int j(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            int parseInt = Integer.parseInt(str);
            return parseInt < 0 ? i2 + parseInt : parseInt - 1;
        }
        return invokeLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.j.f.g
    /* renamed from: k */
    public c.b.b.n.l.g.g.b h(c.b.b.m.a aVar, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, bVar)) == null) {
            return l(aVar, bVar != null && bVar.f28068c);
        }
        return (c.b.b.n.l.g.g.b) invokeLL.objValue;
    }

    public c.b.b.n.l.g.g.b l(c.b.b.m.a aVar, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        int i3;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, aVar, z)) == null) {
            if (f28058h) {
                f.a.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
            }
            c.b.b.n.l.f.b bVar = new c.b.b.n.l.f.b();
            a aVar2 = new a(this, "default");
            this.f28062g.a(aVar2);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(aVar.m()), 4096);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\\s+");
                    if (split.length < 1) {
                        break;
                    } else if (split[0].length() != 0 && (charAt = split[0].toLowerCase().charAt(0)) != '#') {
                        if (charAt == 'v') {
                            if (split[0].length() == 1) {
                                this.f28059d.a(Float.parseFloat(split[1]));
                                this.f28059d.a(Float.parseFloat(split[2]));
                                this.f28059d.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 'n') {
                                this.f28060e.a(Float.parseFloat(split[1]));
                                this.f28060e.a(Float.parseFloat(split[2]));
                                this.f28060e.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 't') {
                                this.f28061f.a(Float.parseFloat(split[1]));
                                this.f28061f.a(z ? 1.0f - Float.parseFloat(split[2]) : Float.parseFloat(split[2]));
                            }
                        } else if (charAt == 'f') {
                            c.b.b.q.a<Integer> aVar3 = aVar2.f28064c;
                            int i4 = 1;
                            while (i4 < split.length - 2) {
                                String[] split2 = split[1].split("/");
                                aVar3.a(Integer.valueOf(j(split2[0], this.f28059d.f28273b)));
                                if (split2.length > 2) {
                                    if (i4 == 1) {
                                        aVar2.f28066e = true;
                                    }
                                    aVar3.a(Integer.valueOf(j(split2[2], this.f28060e.f28273b)));
                                }
                                if (split2.length > 1 && split2[1].length() > 0) {
                                    if (i4 == 1) {
                                        aVar2.f28067f = true;
                                    }
                                    aVar3.a(Integer.valueOf(j(split2[1], this.f28061f.f28273b)));
                                }
                                int i5 = i4 + 1;
                                String[] split3 = split[i5].split("/");
                                aVar3.a(Integer.valueOf(j(split3[0], this.f28059d.f28273b)));
                                if (split3.length > 2) {
                                    aVar3.a(Integer.valueOf(j(split3[2], this.f28060e.f28273b)));
                                }
                                if (split3.length > 1 && split3[1].length() > 0) {
                                    aVar3.a(Integer.valueOf(j(split3[1], this.f28061f.f28273b)));
                                }
                                int i6 = i5 + 1;
                                String[] split4 = split[i6].split("/");
                                aVar3.a(Integer.valueOf(j(split4[0], this.f28059d.f28273b)));
                                if (split4.length > 2) {
                                    aVar3.a(Integer.valueOf(j(split4[2], this.f28060e.f28273b)));
                                }
                                if (split4.length > 1 && split4[1].length() > 0) {
                                    aVar3.a(Integer.valueOf(j(split4[1], this.f28061f.f28273b)));
                                }
                                aVar2.f28065d++;
                                i4 = i6 - 1;
                            }
                        } else {
                            if (charAt != 'o' && charAt != 'g') {
                                if (split[0].equals("mtllib")) {
                                    bVar.b(aVar.i().a(split[1]));
                                } else if (split[0].equals("usemtl")) {
                                    if (split.length == 1) {
                                        aVar2.f28063b = "default";
                                    } else {
                                        aVar2.f28063b = split[1].replace('.', '_');
                                    }
                                }
                            }
                            if (split.length > 1) {
                                aVar2 = m(split[1]);
                            } else {
                                aVar2 = m("default");
                            }
                        }
                    }
                } catch (IOException unused) {
                    return null;
                }
            }
            bufferedReader.close();
            int i7 = 0;
            while (true) {
                c.b.b.q.a<a> aVar4 = this.f28062g;
                i2 = aVar4.f28217f;
                if (i7 >= i2) {
                    break;
                }
                if (aVar4.get(i7).f28065d < 1) {
                    this.f28062g.h(i7);
                    i7--;
                }
                i7++;
            }
            if (i2 < 1) {
                return null;
            }
            c.b.b.n.l.g.g.b bVar2 = new c.b.b.n.l.g.g.b();
            int i8 = 0;
            int i9 = 0;
            while (i8 < i2) {
                a aVar5 = this.f28062g.get(i8);
                c.b.b.q.a<Integer> aVar6 = aVar5.f28064c;
                int i10 = aVar6.f28217f;
                int i11 = aVar5.f28065d;
                boolean z2 = aVar5.f28066e;
                boolean z3 = aVar5.f28067f;
                int i12 = i11 * 3;
                float[] fArr = new float[i12 * ((z2 ? 3 : 0) + 3 + (z3 ? 2 : 0))];
                int i13 = 0;
                int i14 = 0;
                while (i13 < i10) {
                    int i15 = i13 + 1;
                    int intValue = aVar6.get(i13).intValue() * 3;
                    int i16 = i14 + 1;
                    int i17 = i2;
                    int i18 = i10;
                    int i19 = intValue + 1;
                    fArr[i14] = this.f28059d.c(intValue);
                    int i20 = i16 + 1;
                    int i21 = i8;
                    fArr[i16] = this.f28059d.c(i19);
                    int i22 = i20 + 1;
                    fArr[i20] = this.f28059d.c(i19 + 1);
                    if (z2) {
                        int i23 = i15 + 1;
                        int intValue2 = aVar6.get(i15).intValue() * 3;
                        int i24 = i22 + 1;
                        int i25 = intValue2 + 1;
                        fArr[i22] = this.f28060e.c(intValue2);
                        int i26 = i24 + 1;
                        fArr[i24] = this.f28060e.c(i25);
                        i22 = i26 + 1;
                        fArr[i26] = this.f28060e.c(i25 + 1);
                        i15 = i23;
                    }
                    if (z3) {
                        int i27 = i15 + 1;
                        int intValue3 = aVar6.get(i15).intValue() * 2;
                        int i28 = i22 + 1;
                        int i29 = intValue3 + 1;
                        fArr[i22] = this.f28061f.c(intValue3);
                        i3 = i28 + 1;
                        fArr[i28] = this.f28061f.c(i29);
                        i13 = i27;
                    } else {
                        i3 = i22;
                        i13 = i15;
                    }
                    i10 = i18;
                    i8 = i21;
                    i14 = i3;
                    i2 = i17;
                }
                int i30 = i8;
                int i31 = i2;
                if (i12 >= 32767) {
                    i12 = 0;
                }
                short[] sArr = new short[i12];
                if (i12 > 0) {
                    for (int i32 = 0; i32 < i12; i32++) {
                        sArr[i32] = (short) i32;
                    }
                }
                c.b.b.q.a aVar7 = new c.b.b.q.a();
                aVar7.a(new c.b.b.n.i(1, 3, "a_position"));
                if (z2) {
                    aVar7.a(new c.b.b.n.i(8, 3, "a_normal"));
                }
                if (z3) {
                    aVar7.a(new c.b.b.n.i(16, 2, "a_texCoord0"));
                }
                i9++;
                String num = Integer.toString(i9);
                String str = "default".equals(aVar5.a) ? NodeJS.NODE + num : aVar5.a;
                if ("default".equals(aVar5.a)) {
                    String str2 = "mesh" + num;
                } else {
                    String str3 = aVar5.a;
                }
                String str4 = "default".equals(aVar5.a) ? SpeedStatsMainTable.PART + num : aVar5.a;
                c.b.b.n.l.g.g.e eVar = new c.b.b.n.l.g.g.e();
                eVar.a = str;
                eVar.f28101d = new Vector3(1.0f, 1.0f, 1.0f);
                eVar.f28099b = new Vector3();
                eVar.f28100c = new Quaternion();
                h hVar = new h();
                hVar.f28108b = str4;
                hVar.a = aVar5.f28063b;
                eVar.f28102e = new h[]{hVar};
                d dVar = new d();
                dVar.a = str4;
                dVar.f28097b = sArr;
                dVar.f28098c = 4;
                c.b.b.n.l.g.g.c cVar = new c.b.b.n.l.g.g.c();
                cVar.a = (c.b.b.n.i[]) aVar7.m(c.b.b.n.i.class);
                cVar.f28095b = fArr;
                cVar.f28096c = new d[]{dVar};
                bVar2.f28093d.a(eVar);
                bVar2.f28091b.a(cVar);
                bVar2.f28092c.a(bVar.a(aVar5.f28063b));
                i8 = i30 + 1;
                i2 = i31;
            }
            i iVar = this.f28059d;
            if (iVar.f28273b > 0) {
                iVar.b();
            }
            i iVar2 = this.f28060e;
            if (iVar2.f28273b > 0) {
                iVar2.b();
            }
            i iVar3 = this.f28061f;
            if (iVar3.f28273b > 0) {
                iVar3.b();
            }
            c.b.b.q.a<a> aVar8 = this.f28062g;
            if (aVar8.f28217f > 0) {
                aVar8.clear();
            }
            return bVar2;
        }
        return (c.b.b.n.l.g.g.b) invokeLZ.objValue;
    }

    public final a m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            a.b<a> it = this.f28062g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            a aVar = new a(this, str);
            this.f28062g.a(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
