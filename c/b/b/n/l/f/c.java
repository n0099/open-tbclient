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
import com.baidu.android.common.others.IStringUtil;
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
/* loaded from: classes3.dex */
public class c extends g<b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f22579h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final i f22580d;

    /* renamed from: e  reason: collision with root package name */
    public final i f22581e;

    /* renamed from: f  reason: collision with root package name */
    public final i f22582f;

    /* renamed from: g  reason: collision with root package name */
    public final c.b.b.q.a<a> f22583g;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public String f22584b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.a<Integer> f22585c;

        /* renamed from: d  reason: collision with root package name */
        public int f22586d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22587e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22588f;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f22585c = new c.b.b.q.a<>(200);
            this.f22586d = 0;
            new c.b.b.n.l.c("");
            this.f22584b = "default";
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22589c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22580d = new i(300);
        this.f22581e = new i(300);
        this.f22582f = new i(200);
        this.f22583g = new c.b.b.q.a<>(10);
    }

    public final int j(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            int parseInt = Integer.parseInt(str);
            return parseInt < 0 ? i + parseInt : parseInt - 1;
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
            return l(aVar, bVar != null && bVar.f22589c);
        }
        return (c.b.b.n.l.g.g.b) invokeLL.objValue;
    }

    public c.b.b.n.l.g.g.b l(c.b.b.m.a aVar, boolean z) {
        InterceptResult invokeLZ;
        int i;
        int i2;
        char charAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, aVar, z)) == null) {
            if (f22579h) {
                f.a.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
            }
            c.b.b.n.l.f.b bVar = new c.b.b.n.l.f.b();
            a aVar2 = new a(this, "default");
            this.f22583g.a(aVar2);
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
                                this.f22580d.a(Float.parseFloat(split[1]));
                                this.f22580d.a(Float.parseFloat(split[2]));
                                this.f22580d.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 'n') {
                                this.f22581e.a(Float.parseFloat(split[1]));
                                this.f22581e.a(Float.parseFloat(split[2]));
                                this.f22581e.a(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 't') {
                                this.f22582f.a(Float.parseFloat(split[1]));
                                this.f22582f.a(z ? 1.0f - Float.parseFloat(split[2]) : Float.parseFloat(split[2]));
                            }
                        } else if (charAt == 'f') {
                            c.b.b.q.a<Integer> aVar3 = aVar2.f22585c;
                            int i3 = 1;
                            while (i3 < split.length - 2) {
                                String[] split2 = split[1].split("/");
                                aVar3.a(Integer.valueOf(j(split2[0], this.f22580d.f22765b)));
                                if (split2.length > 2) {
                                    if (i3 == 1) {
                                        aVar2.f22587e = true;
                                    }
                                    aVar3.a(Integer.valueOf(j(split2[2], this.f22581e.f22765b)));
                                }
                                if (split2.length > 1 && split2[1].length() > 0) {
                                    if (i3 == 1) {
                                        aVar2.f22588f = true;
                                    }
                                    aVar3.a(Integer.valueOf(j(split2[1], this.f22582f.f22765b)));
                                }
                                int i4 = i3 + 1;
                                String[] split3 = split[i4].split("/");
                                aVar3.a(Integer.valueOf(j(split3[0], this.f22580d.f22765b)));
                                if (split3.length > 2) {
                                    aVar3.a(Integer.valueOf(j(split3[2], this.f22581e.f22765b)));
                                }
                                if (split3.length > 1 && split3[1].length() > 0) {
                                    aVar3.a(Integer.valueOf(j(split3[1], this.f22582f.f22765b)));
                                }
                                int i5 = i4 + 1;
                                String[] split4 = split[i5].split("/");
                                aVar3.a(Integer.valueOf(j(split4[0], this.f22580d.f22765b)));
                                if (split4.length > 2) {
                                    aVar3.a(Integer.valueOf(j(split4[2], this.f22581e.f22765b)));
                                }
                                if (split4.length > 1 && split4[1].length() > 0) {
                                    aVar3.a(Integer.valueOf(j(split4[1], this.f22582f.f22765b)));
                                }
                                aVar2.f22586d++;
                                i3 = i5 - 1;
                            }
                        } else {
                            if (charAt != 'o' && charAt != 'g') {
                                if (split[0].equals("mtllib")) {
                                    bVar.b(aVar.i().a(split[1]));
                                } else if (split[0].equals("usemtl")) {
                                    if (split.length == 1) {
                                        aVar2.f22584b = "default";
                                    } else {
                                        aVar2.f22584b = split[1].replace(IStringUtil.EXTENSION_SEPARATOR, '_');
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
            int i6 = 0;
            while (true) {
                c.b.b.q.a<a> aVar4 = this.f22583g;
                i = aVar4.f22717b;
                if (i6 >= i) {
                    break;
                }
                if (aVar4.get(i6).f22586d < 1) {
                    this.f22583g.i(i6);
                    i6--;
                }
                i6++;
            }
            if (i < 1) {
                return null;
            }
            c.b.b.n.l.g.g.b bVar2 = new c.b.b.n.l.g.g.b();
            int i7 = 0;
            int i8 = 0;
            while (i7 < i) {
                a aVar5 = this.f22583g.get(i7);
                c.b.b.q.a<Integer> aVar6 = aVar5.f22585c;
                int i9 = aVar6.f22717b;
                int i10 = aVar5.f22586d;
                boolean z2 = aVar5.f22587e;
                boolean z3 = aVar5.f22588f;
                int i11 = i10 * 3;
                float[] fArr = new float[i11 * ((z2 ? 3 : 0) + 3 + (z3 ? 2 : 0))];
                int i12 = 0;
                int i13 = 0;
                while (i12 < i9) {
                    int i14 = i12 + 1;
                    int intValue = aVar6.get(i12).intValue() * 3;
                    int i15 = i13 + 1;
                    int i16 = i;
                    int i17 = i9;
                    int i18 = intValue + 1;
                    fArr[i13] = this.f22580d.c(intValue);
                    int i19 = i15 + 1;
                    int i20 = i7;
                    fArr[i15] = this.f22580d.c(i18);
                    int i21 = i19 + 1;
                    fArr[i19] = this.f22580d.c(i18 + 1);
                    if (z2) {
                        int i22 = i14 + 1;
                        int intValue2 = aVar6.get(i14).intValue() * 3;
                        int i23 = i21 + 1;
                        int i24 = intValue2 + 1;
                        fArr[i21] = this.f22581e.c(intValue2);
                        int i25 = i23 + 1;
                        fArr[i23] = this.f22581e.c(i24);
                        i21 = i25 + 1;
                        fArr[i25] = this.f22581e.c(i24 + 1);
                        i14 = i22;
                    }
                    if (z3) {
                        int i26 = i14 + 1;
                        int intValue3 = aVar6.get(i14).intValue() * 2;
                        int i27 = i21 + 1;
                        int i28 = intValue3 + 1;
                        fArr[i21] = this.f22582f.c(intValue3);
                        i2 = i27 + 1;
                        fArr[i27] = this.f22582f.c(i28);
                        i12 = i26;
                    } else {
                        i2 = i21;
                        i12 = i14;
                    }
                    i9 = i17;
                    i7 = i20;
                    i13 = i2;
                    i = i16;
                }
                int i29 = i7;
                int i30 = i;
                if (i11 >= 32767) {
                    i11 = 0;
                }
                short[] sArr = new short[i11];
                if (i11 > 0) {
                    for (int i31 = 0; i31 < i11; i31++) {
                        sArr[i31] = (short) i31;
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
                i8++;
                String num = Integer.toString(i8);
                String str = "default".equals(aVar5.a) ? NodeJS.NODE + num : aVar5.a;
                if ("default".equals(aVar5.a)) {
                    String str2 = "mesh" + num;
                } else {
                    String str3 = aVar5.a;
                }
                String str4 = "default".equals(aVar5.a) ? SpeedStatsMainTable.PART + num : aVar5.a;
                c.b.b.n.l.g.g.e eVar = new c.b.b.n.l.g.g.e();
                eVar.a = str;
                eVar.f22619d = new Vector3(1.0f, 1.0f, 1.0f);
                eVar.f22617b = new Vector3();
                eVar.f22618c = new Quaternion();
                h hVar = new h();
                hVar.f22626b = str4;
                hVar.a = aVar5.f22584b;
                eVar.f22620e = new h[]{hVar};
                d dVar = new d();
                dVar.a = str4;
                dVar.f22615b = sArr;
                dVar.f22616c = 4;
                c.b.b.n.l.g.g.c cVar = new c.b.b.n.l.g.g.c();
                cVar.a = (c.b.b.n.i[]) aVar7.n(c.b.b.n.i.class);
                cVar.f22613b = fArr;
                cVar.f22614c = new d[]{dVar};
                bVar2.f22611d.a(eVar);
                bVar2.f22609b.a(cVar);
                bVar2.f22610c.a(bVar.a(aVar5.f22584b));
                i7 = i29 + 1;
                i = i30;
            }
            i iVar = this.f22580d;
            if (iVar.f22765b > 0) {
                iVar.b();
            }
            i iVar2 = this.f22581e;
            if (iVar2.f22765b > 0) {
                iVar2.b();
            }
            i iVar3 = this.f22582f;
            if (iVar3.f22765b > 0) {
                iVar3.b();
            }
            c.b.b.q.a<a> aVar8 = this.f22583g;
            if (aVar8.f22717b > 0) {
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
            a.b<a> it = this.f22583g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            a aVar = new a(this, str);
            this.f22583g.a(aVar);
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
