package c.a.o0.v.i.a.c;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.f1.e.b;
import c.a.o0.r.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ZeusPluginFactory.Invoker) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.v.i.a.c.a
    public void B0(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            try {
                JSONObject I0 = I0();
                JSONObject J0 = J0();
                J0.put("errorNo", i2);
                J0.put("sub_errorNo", i3);
                J0.put("errorInfo", str);
                I0.put("ext", J0.toString());
                e.m("36", I0);
            } catch (Exception e2) {
                if (a.x) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // c.a.o0.v.i.a.c.a, c.a.o0.a.y0.k.g.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // c.a.o0.v.i.a.c.a
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                JSONObject I0 = I0();
                I0.put("type", "first_frame");
                I0.put("ext", J0().toString());
                e.m(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, I0);
            } catch (Exception e2) {
                if (a.x) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // c.a.o0.v.i.a.c.a, c.a.o0.a.y0.k.g.a
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @NonNull
    public final JSONObject I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "video");
                jSONObject.put("network", SwanAppNetworkUtils.e());
            } catch (Exception e2) {
                if (a.x) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public final JSONObject J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext_from", "aiapp");
                jSONObject.put("appid", c.a.o0.a.a2.e.V());
                jSONObject.put("url", this.f12379b);
                jSONObject.put(TiebaStatic.Params.VID, this.f12379b);
                jSONObject.put("isInline", true);
                String str = "";
                c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
                if (i2 != null) {
                    str = i2.m0() ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan";
                    b.a N = i2.N();
                    if (N != null && N.s1() > 0) {
                        jSONObject.put("ext_start", N.s1());
                    }
                }
                jSONObject.put("ext_page", str);
            } catch (Exception e2) {
                if (a.x) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.a.o0.a.y0.k.g.a
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, invoker) == null) {
        }
    }

    @Override // c.a.o0.a.y0.k.g.a
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.o0.a.y0.k.g.a
    public ZeusPluginFactory.Invoker f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // c.a.o0.v.i.a.c.a, c.a.o0.a.y0.k.g.a
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
