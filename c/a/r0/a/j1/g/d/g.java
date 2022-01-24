package c.a.r0.a.j1.g.d;

import android.content.Context;
import c.a.r0.a.f2.f.z;
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
public class g extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c f7678c;

    /* renamed from: d  reason: collision with root package name */
    public m f7679d;

    /* renamed from: e  reason: collision with root package name */
    public e f7680e;

    /* renamed from: f  reason: collision with root package name */
    public d f7681f;

    /* renamed from: g  reason: collision with root package name */
    public j f7682g;

    /* renamed from: h  reason: collision with root package name */
    public b f7683h;

    /* renamed from: i  reason: collision with root package name */
    public k f7684i;

    /* renamed from: j  reason: collision with root package name */
    public i f7685j;
    public l k;
    public f l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (z.f6343b) {
                String str = "handle entity: " + unitedSchemeEntity.toString();
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.r0.a.f2.f.z
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLLL;
        char c2;
        boolean c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            c.a.r0.a.e0.d.i("VideoPlayerAction", "handleSubAction subAction : " + str + "params : " + z.a(unitedSchemeEntity, "params"));
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
                case -1440252277:
                    if (str.equals("/swanAPI/video/stop")) {
                        c2 = '\b';
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
                case 1568993060:
                    if (str.equals("/swanAPI/video/playbackRate")) {
                        c2 = '\t';
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
                    if (this.f7678c == null) {
                        this.f7678c = new c("/swanAPI/video/open");
                    }
                    c3 = this.f7678c.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 1:
                    if (this.f7679d == null) {
                        this.f7679d = new m("/swanAPI/video/update");
                    }
                    c3 = this.f7679d.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 2:
                    if (this.f7685j == null) {
                        this.f7685j = new i("/swanAPI/video/remove");
                    }
                    c3 = this.f7685j.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 3:
                    if (this.f7680e == null) {
                        this.f7680e = new e("/swanAPI/video/play");
                    }
                    c3 = this.f7680e.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 4:
                    if (this.f7681f == null) {
                        this.f7681f = new d("/swanAPI/video/pause");
                    }
                    c3 = this.f7681f.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 5:
                    if (this.f7682g == null) {
                        this.f7682g = new j("/swanAPI/video/seek");
                    }
                    c3 = this.f7682g.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 6:
                    if (this.f7683h == null) {
                        this.f7683h = new b("/swanAPI/video/fullScreen");
                    }
                    c3 = this.f7683h.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case 7:
                    if (this.f7684i == null) {
                        this.f7684i = new k("/swanAPI/video/sendDanmu");
                    }
                    c3 = this.f7684i.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case '\b':
                    if (this.k == null) {
                        this.k = new l("/swanAPI/video/stop");
                    }
                    c3 = this.k.c(context, unitedSchemeEntity, callbackHandler, eVar);
                    break;
                case '\t':
                    if (this.l == null) {
                        this.l = new f("/swanAPI/video/playbackRate");
                    }
                    c3 = this.l.c(context, unitedSchemeEntity, callbackHandler, eVar);
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
