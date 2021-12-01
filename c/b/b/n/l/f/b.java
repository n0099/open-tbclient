package c.b.b.n.l.f;

import c.b.b.n.l.g.g.i;
import c.b.b.q.a;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.b.b.q.a<ModelMaterial> a;

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
                return;
            }
        }
        this.a = new c.b.b.q.a<>();
    }

    public ModelMaterial a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            a.b<ModelMaterial> it = this.a.iterator();
            while (it.hasNext()) {
                ModelMaterial next = it.next();
                if (next.a.equals(str)) {
                    return next;
                }
            }
            ModelMaterial modelMaterial = new ModelMaterial();
            modelMaterial.a = str;
            modelMaterial.f31608c = new c.b.b.n.a(c.b.b.n.a.f27471e);
            this.a.a(modelMaterial);
            return modelMaterial;
        }
        return (ModelMaterial) invokeL.objValue;
    }

    public void b(c.b.b.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            c.b.b.n.a aVar2 = c.b.b.n.a.f27471e;
            if (aVar == null || !aVar.c()) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(aVar.m()), 4096);
            String str = "default";
            String str2 = null;
            float f2 = 1.0f;
            float f3 = 0.0f;
            c.b.b.n.a aVar3 = aVar2;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.length() > 0 && readLine.charAt(0) == '\t') {
                        readLine = readLine.substring(1).trim();
                    }
                    String[] split = readLine.split("\\s+");
                    if (split[0].length() != 0 && split[0].charAt(0) != '#') {
                        String lowerCase = split[0].toLowerCase();
                        if (lowerCase.equals("newmtl")) {
                            ModelMaterial modelMaterial = new ModelMaterial();
                            modelMaterial.a = str;
                            modelMaterial.f31608c = new c.b.b.n.a(aVar2);
                            modelMaterial.f31609d = new c.b.b.n.a(aVar3);
                            modelMaterial.f31613h = f2;
                            modelMaterial.f31612g = f3;
                            if (str2 != null) {
                                i iVar = new i();
                                iVar.f27663d = 2;
                                iVar.a = new String(str2);
                                if (modelMaterial.f31614i == null) {
                                    modelMaterial.f31614i = new c.b.b.q.a<>(1);
                                }
                                modelMaterial.f31614i.a(iVar);
                            }
                            this.a.a(modelMaterial);
                            str = split.length > 1 ? split[1].replace('.', '_') : "default";
                            aVar2 = c.b.b.n.a.f27471e;
                            aVar3 = c.b.b.n.a.f27471e;
                            f2 = 1.0f;
                            f3 = 0.0f;
                        } else {
                            if (!lowerCase.equals("kd") && !lowerCase.equals(FunAdSdk.PLATFORM_KS)) {
                                if (!lowerCase.equals("tr") && !lowerCase.equals("d")) {
                                    if (lowerCase.equals(NotificationStyle.NOTIFICATION_STYLE)) {
                                        f3 = Float.parseFloat(split[1]);
                                    } else if (lowerCase.equals("map_kd")) {
                                        str2 = aVar.i().a(split[1]).j();
                                    }
                                }
                                f2 = Float.parseFloat(split[1]);
                            }
                            float parseFloat = Float.parseFloat(split[1]);
                            float parseFloat2 = Float.parseFloat(split[2]);
                            float parseFloat3 = Float.parseFloat(split[3]);
                            float parseFloat4 = split.length > 4 ? Float.parseFloat(split[4]) : 1.0f;
                            if (split[0].toLowerCase().equals("kd")) {
                                aVar2 = new c.b.b.n.a();
                                aVar2.d(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                            } else {
                                aVar3 = new c.b.b.n.a();
                                aVar3.d(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                            }
                        }
                    }
                } catch (IOException unused) {
                    return;
                }
            }
            bufferedReader.close();
            ModelMaterial modelMaterial2 = new ModelMaterial();
            modelMaterial2.a = str;
            modelMaterial2.f31608c = new c.b.b.n.a(aVar2);
            modelMaterial2.f31609d = new c.b.b.n.a(aVar3);
            modelMaterial2.f31613h = f2;
            modelMaterial2.f31612g = f3;
            if (str2 != null) {
                i iVar2 = new i();
                iVar2.f27663d = 2;
                iVar2.a = new String(str2);
                if (modelMaterial2.f31614i == null) {
                    modelMaterial2.f31614i = new c.b.b.q.a<>(1);
                }
                modelMaterial2.f31614i.a(iVar2);
            }
            this.a.a(modelMaterial2);
        }
    }
}
