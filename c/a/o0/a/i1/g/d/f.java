package c.a.o0.a.i1.g.d;

import android.content.Context;
import c.a.o0.a.c2.f.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f6842c;

    /* renamed from: d  reason: collision with root package name */
    public k f6843d;

    /* renamed from: e  reason: collision with root package name */
    public e f6844e;

    /* renamed from: f  reason: collision with root package name */
    public d f6845f;

    /* renamed from: g  reason: collision with root package name */
    public i f6846g;

    /* renamed from: h  reason: collision with root package name */
    public b f6847h;

    /* renamed from: i  reason: collision with root package name */
    public j f6848i;

    /* renamed from: j  reason: collision with root package name */
    public h f6849j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/video");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f4738b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.o0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLLL;
        char c2;
        boolean c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c.a.o0.a.e0.d.g("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + a0.a(unitedSchemeEntity, "params"));
            switch (str.hashCode()) {
                case -1701478259:
                    if (str.equals("/swanAPI/video/pause")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440375597:
                    if (str.equals("/swanAPI/video/open")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440349763:
                    if (str.equals("/swanAPI/video/play")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440267007:
                    if (str.equals("/swanAPI/video/seek")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1145507635:
                    if (str.equals("/swanAPI/video/remove")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1049743086:
                    if (str.equals("/swanAPI/video/update")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -274000988:
                    if (str.equals("/swanAPI/video/fullScreen")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 711122280:
                    if (str.equals("/swanAPI/video/sendDanmu")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (this.f6842c == null) {
                        this.f6842c = new c("/swanAPI/video/open");
                    }
                    c3 = this.f6842c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 1:
                    if (this.f6843d == null) {
                        this.f6843d = new k("/swanAPI/video/update");
                    }
                    c3 = this.f6843d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 2:
                    if (this.f6849j == null) {
                        this.f6849j = new h("/swanAPI/video/remove");
                    }
                    c3 = this.f6849j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 3:
                    if (this.f6844e == null) {
                        this.f6844e = new e("/swanAPI/video/play");
                    }
                    c3 = this.f6844e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 4:
                    if (this.f6845f == null) {
                        this.f6845f = new d("/swanAPI/video/pause");
                    }
                    c3 = this.f6845f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 5:
                    if (this.f6846g == null) {
                        this.f6846g = new i("/swanAPI/video/seek");
                    }
                    c3 = this.f6846g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 6:
                    if (this.f6847h == null) {
                        this.f6847h = new b("/swanAPI/video/fullScreen");
                    }
                    c3 = this.f6847h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 7:
                    if (this.f6848i == null) {
                        this.f6848i = new j("/swanAPI/video/sendDanmu");
                    }
                    c3 = this.f6848i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                default:
                    c3 = false;
                    break;
            }
            return c3 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        return invokeLLLLL.booleanValue;
    }
}
