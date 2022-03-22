package c.b.b.n.l.f;

import androidx.core.view.InputDeviceCompat;
import c.b.b.j.f.e;
import c.b.b.j.f.g;
import c.b.b.n.i;
import c.b.b.n.l.g.g.d;
import c.b.b.n.l.g.g.f;
import c.b.b.n.l.g.g.h;
import c.b.b.q.a;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes3.dex */
public class a extends g<g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.c f22577d;

    /* renamed from: e  reason: collision with root package name */
    public final Quaternion f22578e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.b.b.q.c cVar, e eVar) {
        super(eVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22578e = new Quaternion();
        this.f22577d = cVar;
    }

    @Override // c.b.b.j.f.g
    public c.b.b.n.l.g.g.b h(c.b.b.m.a aVar, g.a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? o(aVar) : (c.b.b.n.l.g.g.b) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, com.badlogic.gdx.math.Quaternion] */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v17, types: [T, com.badlogic.gdx.math.Quaternion] */
    public void j(c.b.b.n.l.g.g.b bVar, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, jsonValue) == null) {
            c.b.b.n.l.g.g.b bVar2 = bVar;
            JsonValue m = jsonValue.m("animations");
            if (m == null) {
                return;
            }
            bVar2.f22612e.e(m.j);
            JsonValue jsonValue2 = m.f23794f;
            while (jsonValue2 != null) {
                JsonValue m2 = jsonValue2.m("bones");
                if (m2 != null) {
                    c.b.b.n.l.g.g.a aVar = new c.b.b.n.l.g.g.a();
                    bVar2.f22612e.a(aVar);
                    aVar.f22608b.e(m2.j);
                    aVar.a = jsonValue2.r("id");
                    for (JsonValue jsonValue3 = m2.f23794f; jsonValue3 != null; jsonValue3 = jsonValue3.f23796h) {
                        f fVar = new f();
                        aVar.f22608b.a(fVar);
                        fVar.a = jsonValue3.r("boneId");
                        JsonValue m3 = jsonValue3.m("keyframes");
                        float f2 = 1000.0f;
                        float f3 = 0.0f;
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i4 = 3;
                        if (m3 != null && m3.v()) {
                            JsonValue jsonValue4 = m3.f23794f;
                            while (jsonValue4 != null) {
                                float p = jsonValue4.p("keytime", f3) / f2;
                                JsonValue m4 = jsonValue4.m("translation");
                                if (m4 != null && m4.j == i4) {
                                    if (fVar.f22622b == null) {
                                        fVar.f22622b = new c.b.b.q.a<>();
                                    }
                                    c.b.b.n.l.g.g.g<Vector3> gVar = new c.b.b.n.l.g.g.g<>();
                                    gVar.a = p;
                                    gVar.f22625b = new Vector3(m4.o(i3), m4.o(i2), m4.o(i));
                                    fVar.f22622b.a(gVar);
                                }
                                JsonValue m5 = jsonValue4.m("rotation");
                                if (m5 != null && m5.j == 4) {
                                    if (fVar.f22623c == null) {
                                        fVar.f22623c = new c.b.b.q.a<>();
                                    }
                                    c.b.b.n.l.g.g.g<Quaternion> gVar2 = new c.b.b.n.l.g.g.g<>();
                                    gVar2.a = p;
                                    gVar2.f22625b = new Quaternion(m5.o(0), m5.o(i2), m5.o(i), m5.o(3));
                                    fVar.f22623c.a(gVar2);
                                }
                                JsonValue m6 = jsonValue4.m(AnimationProperty.SCALE);
                                if (m6 != null && m6.j == 3) {
                                    if (fVar.f22624d == null) {
                                        fVar.f22624d = new c.b.b.q.a<>();
                                    }
                                    c.b.b.n.l.g.g.g<Vector3> gVar3 = new c.b.b.n.l.g.g.g<>();
                                    gVar3.a = p;
                                    gVar3.f22625b = new Vector3(m6.o(0), m6.o(1), m6.o(2));
                                    fVar.f22624d.a(gVar3);
                                }
                                jsonValue4 = jsonValue4.f23796h;
                                f2 = 1000.0f;
                                f3 = 0.0f;
                                i = 2;
                                i2 = 1;
                                i3 = 0;
                                i4 = 3;
                            }
                        } else {
                            JsonValue m7 = jsonValue3.m("translation");
                            if (m7 != null && m7.v()) {
                                c.b.b.q.a<c.b.b.n.l.g.g.g<Vector3>> aVar2 = new c.b.b.q.a<>();
                                fVar.f22622b = aVar2;
                                aVar2.e(m7.j);
                                for (JsonValue jsonValue5 = m7.f23794f; jsonValue5 != null; jsonValue5 = jsonValue5.f23796h) {
                                    c.b.b.n.l.g.g.g<Vector3> gVar4 = new c.b.b.n.l.g.g.g<>();
                                    fVar.f22622b.a(gVar4);
                                    gVar4.a = jsonValue5.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m8 = jsonValue5.m("value");
                                    if (m8 != null && m8.j >= 3) {
                                        gVar4.f22625b = new Vector3(m8.o(0), m8.o(1), m8.o(2));
                                    }
                                }
                            }
                            JsonValue m9 = jsonValue3.m("rotation");
                            if (m9 != null && m9.v()) {
                                c.b.b.q.a<c.b.b.n.l.g.g.g<Quaternion>> aVar3 = new c.b.b.q.a<>();
                                fVar.f22623c = aVar3;
                                aVar3.e(m9.j);
                                for (JsonValue jsonValue6 = m9.f23794f; jsonValue6 != null; jsonValue6 = jsonValue6.f23796h) {
                                    c.b.b.n.l.g.g.g<Quaternion> gVar5 = new c.b.b.n.l.g.g.g<>();
                                    fVar.f22623c.a(gVar5);
                                    gVar5.a = jsonValue6.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m10 = jsonValue6.m("value");
                                    if (m10 != null && m10.j >= 4) {
                                        gVar5.f22625b = new Quaternion(m10.o(0), m10.o(1), m10.o(2), m10.o(3));
                                    }
                                }
                            }
                            JsonValue m11 = jsonValue3.m("scaling");
                            if (m11 != null && m11.v()) {
                                c.b.b.q.a<c.b.b.n.l.g.g.g<Vector3>> aVar4 = new c.b.b.q.a<>();
                                fVar.f22624d = aVar4;
                                aVar4.e(m11.j);
                                for (JsonValue jsonValue7 = m11.f23794f; jsonValue7 != null; jsonValue7 = jsonValue7.f23796h) {
                                    c.b.b.n.l.g.g.g<Vector3> gVar6 = new c.b.b.n.l.g.g.g<>();
                                    fVar.f22624d.a(gVar6);
                                    gVar6.a = jsonValue7.p("keytime", 0.0f) / 1000.0f;
                                    JsonValue m12 = jsonValue7.m("value");
                                    if (m12 != null && m12.j >= 3) {
                                        gVar6.f22625b = new Vector3(m12.o(0), m12.o(1), m12.o(2));
                                    }
                                }
                            }
                        }
                    }
                }
                jsonValue2 = jsonValue2.f23796h;
                bVar2 = bVar;
            }
        }
    }

    public i[] k(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonValue)) == null) {
            c.b.b.q.a aVar = new c.b.b.q.a();
            int i = 0;
            int i2 = 0;
            for (JsonValue jsonValue2 = jsonValue.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
                String k = jsonValue2.k();
                if (k.equals("POSITION")) {
                    aVar.a(i.f());
                } else if (k.equals("NORMAL")) {
                    aVar.a(i.e());
                } else if (k.equals("COLOR")) {
                    aVar.a(i.d());
                } else if (k.equals("COLORPACKED")) {
                    aVar.a(i.c());
                } else if (k.equals("TANGENT")) {
                    aVar.a(i.g());
                } else if (k.equals("BINORMAL")) {
                    aVar.a(i.a());
                } else if (k.startsWith("TEXCOORD")) {
                    aVar.a(i.h(i));
                    i++;
                } else if (k.startsWith("BLENDWEIGHT")) {
                    aVar.a(i.b(i2));
                    i2++;
                } else {
                    throw new GdxRuntimeException("Unknown vertex attribute '" + k + "', should be one of position, normal, uv, tangent or binormal");
                }
            }
            return (i[]) aVar.n(i.class);
        }
        return (i[]) invokeL.objValue;
    }

    public c.b.b.n.a l(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsonValue)) == null) {
            if (jsonValue.j >= 3) {
                return new c.b.b.n.a(jsonValue.o(0), jsonValue.o(1), jsonValue.o(2), 1.0f);
            }
            throw new GdxRuntimeException("Expected Color values <> than three.");
        }
        return (c.b.b.n.a) invokeL.objValue;
    }

    public void m(c.b.b.n.l.g.g.b bVar, JsonValue jsonValue, String str) {
        JsonValue m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, bVar, jsonValue, str) == null) || (m = jsonValue.m("materials")) == null) {
            return;
        }
        bVar.f22610c.e(m.j);
        for (JsonValue jsonValue2 = m.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
            ModelMaterial modelMaterial = new ModelMaterial();
            String s = jsonValue2.s("id", null);
            if (s != null) {
                modelMaterial.a = s;
                JsonValue m2 = jsonValue2.m("diffuse");
                if (m2 != null) {
                    modelMaterial.f23771c = l(m2);
                }
                JsonValue m3 = jsonValue2.m("ambient");
                if (m3 != null) {
                    modelMaterial.f23770b = l(m3);
                }
                JsonValue m4 = jsonValue2.m("emissive");
                if (m4 != null) {
                    modelMaterial.f23773e = l(m4);
                }
                JsonValue m5 = jsonValue2.m("specular");
                if (m5 != null) {
                    modelMaterial.f23772d = l(m5);
                }
                JsonValue m6 = jsonValue2.m("reflection");
                if (m6 != null) {
                    modelMaterial.f23774f = l(m6);
                }
                modelMaterial.f23775g = jsonValue2.p("shininess", 0.0f);
                modelMaterial.f23776h = jsonValue2.p("opacity", 1.0f);
                JsonValue m7 = jsonValue2.m("textures");
                if (m7 != null) {
                    for (JsonValue jsonValue3 = m7.f23794f; jsonValue3 != null; jsonValue3 = jsonValue3.f23796h) {
                        c.b.b.n.l.g.g.i iVar = new c.b.b.n.l.g.g.i();
                        if (jsonValue3.s("id", null) != null) {
                            String s2 = jsonValue3.s(BreakpointSQLiteKey.FILENAME, null);
                            if (s2 != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                String str2 = "/";
                                sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "");
                                sb.append(s2);
                                iVar.a = sb.toString();
                                iVar.f22628b = t(jsonValue3.m("uvTranslation"), 0.0f, 0.0f);
                                iVar.f22629c = t(jsonValue3.m("uvScaling"), 1.0f, 1.0f);
                                String s3 = jsonValue3.s("type", null);
                                if (s3 != null) {
                                    iVar.f22630d = r(s3);
                                    if (modelMaterial.i == null) {
                                        modelMaterial.i = new c.b.b.q.a<>();
                                    }
                                    modelMaterial.i.a(iVar);
                                } else {
                                    throw new GdxRuntimeException("Texture needs type.");
                                }
                            } else {
                                throw new GdxRuntimeException("Texture needs filename.");
                            }
                        } else {
                            throw new GdxRuntimeException("Texture has no id.");
                        }
                    }
                    continue;
                }
                bVar.f22610c.a(modelMaterial);
            } else {
                throw new GdxRuntimeException("Material needs an id.");
            }
        }
    }

    public void n(c.b.b.n.l.g.g.b bVar, JsonValue jsonValue) {
        JsonValue m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, bVar, jsonValue) == null) || (m = jsonValue.m("meshes")) == null) {
            return;
        }
        bVar.f22609b.e(m.j);
        for (JsonValue jsonValue2 = m.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
            c.b.b.n.l.g.g.c cVar = new c.b.b.n.l.g.g.c();
            jsonValue2.s("id", "");
            cVar.a = k(jsonValue2.L("attributes"));
            cVar.f22613b = jsonValue2.L("vertices").f();
            JsonValue L = jsonValue2.L("parts");
            c.b.b.q.a aVar = new c.b.b.q.a();
            for (JsonValue jsonValue3 = L.f23794f; jsonValue3 != null; jsonValue3 = jsonValue3.f23796h) {
                d dVar = new d();
                String s = jsonValue3.s("id", null);
                if (s != null) {
                    a.b it = aVar.iterator();
                    while (it.hasNext()) {
                        if (((d) it.next()).a.equals(s)) {
                            throw new GdxRuntimeException("Mesh part with id '" + s + "' already in defined");
                        }
                    }
                    dVar.a = s;
                    String s2 = jsonValue3.s("type", null);
                    if (s2 != null) {
                        dVar.f22616c = s(s2);
                        dVar.f22615b = jsonValue3.L("indices").j();
                        aVar.a(dVar);
                    } else {
                        throw new GdxRuntimeException("No primitive type given for mesh part '" + s + "'");
                    }
                } else {
                    throw new GdxRuntimeException("Not id given for mesh part");
                }
            }
            cVar.f22614c = (d[]) aVar.n(d.class);
            bVar.f22609b.a(cVar);
        }
    }

    public c.b.b.n.l.g.g.b o(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            JsonValue a = this.f22577d.a(aVar);
            c.b.b.n.l.g.g.b bVar = new c.b.b.n.l.g.g.b();
            JsonValue L = a.L("version");
            bVar.a[0] = L.q(0);
            bVar.a[1] = L.q(1);
            short[] sArr = bVar.a;
            if (sArr[0] == 0 && sArr[1] == 1) {
                a.s("id", "");
                n(bVar, a);
                m(bVar, a, aVar.i().j());
                p(bVar, a);
                j(bVar, a);
                return bVar;
            }
            throw new GdxRuntimeException("Model version not supported");
        }
        return (c.b.b.n.l.g.g.b) invokeL.objValue;
    }

    public c.b.b.q.a<c.b.b.n.l.g.g.e> p(c.b.b.n.l.g.g.b bVar, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bVar, jsonValue)) == null) {
            JsonValue m = jsonValue.m("nodes");
            if (m != null) {
                bVar.f22611d.e(m.j);
                for (JsonValue jsonValue2 = m.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
                    bVar.f22611d.a(q(jsonValue2));
                }
            }
            return bVar.f22611d;
        }
        return (c.b.b.q.a) invokeLL.objValue;
    }

    public c.b.b.n.l.g.g.e q(JsonValue jsonValue) {
        InterceptResult invokeL;
        String str;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonValue)) == null) {
            a aVar = this;
            c.b.b.n.l.g.g.e eVar = new c.b.b.n.l.g.g.e();
            String str3 = null;
            String s = jsonValue.s("id", null);
            if (s != null) {
                eVar.a = s;
                String str4 = "translation";
                JsonValue m = jsonValue.m("translation");
                if (m == null || m.j == 3) {
                    boolean z = true;
                    eVar.f22617b = m == null ? null : new Vector3(m.o(0), m.o(1), m.o(2));
                    String str5 = "rotation";
                    JsonValue m2 = jsonValue.m("rotation");
                    if (m2 == null || m2.j == 4) {
                        eVar.f22618c = m2 == null ? null : new Quaternion(m2.o(0), m2.o(1), m2.o(2), m2.o(3));
                        JsonValue m3 = jsonValue.m(AnimationProperty.SCALE);
                        if (m3 == null || m3.j == 3) {
                            eVar.f22619d = m3 == null ? null : new Vector3(m3.o(0), m3.o(1), m3.o(2));
                            jsonValue.s("mesh", null);
                            JsonValue m4 = jsonValue.m("parts");
                            if (m4 != null) {
                                eVar.f22620e = new h[m4.j];
                                JsonValue jsonValue2 = m4.f23794f;
                                int i2 = 0;
                                while (jsonValue2 != null) {
                                    h hVar = new h();
                                    String s2 = jsonValue2.s("meshpartid", str3);
                                    String s3 = jsonValue2.s("materialid", str3);
                                    if (s2 != null && s3 != null) {
                                        hVar.a = s3;
                                        hVar.f22626b = s2;
                                        JsonValue m5 = jsonValue2.m("bones");
                                        if (m5 != null) {
                                            hVar.f22627c = new c.b.b.q.b<>(z, m5.j, String.class, Matrix4.class);
                                            JsonValue jsonValue3 = m5.f23794f;
                                            while (jsonValue3 != null) {
                                                String s4 = jsonValue3.s(NodeJS.NODE, null);
                                                if (s4 != null) {
                                                    Matrix4 matrix4 = new Matrix4();
                                                    JsonValue m6 = jsonValue3.m(str4);
                                                    if (m6 == null || m6.j < 3) {
                                                        str = str4;
                                                    } else {
                                                        str = str4;
                                                        matrix4.translate(m6.o(0), m6.o(1), m6.o(2));
                                                    }
                                                    JsonValue m7 = jsonValue3.m(str5);
                                                    if (m7 == null || m7.j < 4) {
                                                        str2 = str5;
                                                        i = 3;
                                                    } else {
                                                        str2 = str5;
                                                        i = 3;
                                                        matrix4.rotate(aVar.f22578e.set(m7.o(0), m7.o(1), m7.o(2), m7.o(3)));
                                                    }
                                                    JsonValue m8 = jsonValue3.m(AnimationProperty.SCALE);
                                                    if (m8 != null && m8.j >= i) {
                                                        matrix4.scale(m8.o(0), m8.o(1), m8.o(2));
                                                    }
                                                    hVar.f22627c.f(s4, matrix4);
                                                    jsonValue3 = jsonValue3.f23796h;
                                                    aVar = this;
                                                    str4 = str;
                                                    str5 = str2;
                                                } else {
                                                    throw new GdxRuntimeException("Bone node ID missing");
                                                }
                                            }
                                            continue;
                                        }
                                        eVar.f22620e[i2] = hVar;
                                        jsonValue2 = jsonValue2.f23796h;
                                        i2++;
                                        str3 = null;
                                        aVar = this;
                                        str4 = str4;
                                        str5 = str5;
                                        z = true;
                                    } else {
                                        throw new GdxRuntimeException("Node " + s + " part is missing meshPartId or materialId");
                                    }
                                }
                            }
                            JsonValue m9 = jsonValue.m("children");
                            if (m9 != null) {
                                eVar.f22621f = new c.b.b.n.l.g.g.e[m9.j];
                                JsonValue jsonValue4 = m9.f23794f;
                                int i3 = 0;
                                while (jsonValue4 != null) {
                                    eVar.f22621f[i3] = q(jsonValue4);
                                    jsonValue4 = jsonValue4.f23796h;
                                    i3++;
                                }
                            }
                            return eVar;
                        }
                        throw new GdxRuntimeException("Node scale incomplete");
                    }
                    throw new GdxRuntimeException("Node rotation incomplete");
                }
                throw new GdxRuntimeException("Node translation incomplete");
            }
            throw new GdxRuntimeException("Node id missing.");
        }
        return (c.b.b.n.l.g.g.e) invokeL.objValue;
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str.equalsIgnoreCase("AMBIENT")) {
                return 4;
            }
            if (str.equalsIgnoreCase("BUMP")) {
                return 8;
            }
            if (str.equalsIgnoreCase("DIFFUSE")) {
                return 2;
            }
            if (str.equalsIgnoreCase("EMISSIVE")) {
                return 3;
            }
            if (str.equalsIgnoreCase("NONE")) {
                return 1;
            }
            if (str.equalsIgnoreCase("NORMAL")) {
                return 7;
            }
            if (str.equalsIgnoreCase("REFLECTION")) {
                return 10;
            }
            if (str.equalsIgnoreCase("SHININESS")) {
                return 6;
            }
            if (str.equalsIgnoreCase("SPECULAR")) {
                return 5;
            }
            return str.equalsIgnoreCase("TRANSPARENCY") ? 9 : 0;
        }
        return invokeL.intValue;
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str.equals("TRIANGLES")) {
                return 4;
            }
            if (str.equals("LINES")) {
                return 1;
            }
            if (str.equals("POINTS")) {
                return 0;
            }
            if (str.equals("TRIANGLE_STRIP")) {
                return 5;
            }
            if (str.equals("LINE_STRIP")) {
                return 3;
            }
            throw new GdxRuntimeException("Unknown primitive type '" + str + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
        }
        return invokeL.intValue;
    }

    public Vector2 t(JsonValue jsonValue, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{jsonValue, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (jsonValue == null) {
                return new Vector2(f2, f3);
            }
            if (jsonValue.j == 2) {
                return new Vector2(jsonValue.o(0), jsonValue.o(1));
            }
            throw new GdxRuntimeException("Expected Vector2 values <> than two.");
        }
        return (Vector2) invokeCommon.objValue;
    }
}
