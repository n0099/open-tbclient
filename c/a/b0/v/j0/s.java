package c.a.b0.v.j0;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideo;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes.dex */
public class s extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(String kernelType) {
        super(kernelType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kernelType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(kernelType, "kernelType");
        this.l = "";
    }

    public final void A0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
        }
    }

    @Override // c.a.b0.v.j0.i, c.a.b0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.B();
            this.f2138i.J(c.a.b0.h.a.e());
        }
    }

    public final void B0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdVideoSeries) == null) {
        }
    }

    public final void C0(BdVideo bdVideo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bdVideo, i2) == null) {
        }
    }

    public final void D0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdVideoSeries) == null) {
        }
    }

    public final void E0(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdVideoSeries) == null) {
            String format = bdVideoSeries.getFormat();
            n0(format, x0(format));
        }
    }

    public void F0(BdVideoSeries series, c.a.b0.v.m0.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, series, hVar) == null) {
            Intrinsics.checkNotNullParameter(series, "series");
            int i2 = hVar != null ? hVar.f2196d : -1;
            String str = (hVar == null || (str = hVar.a) == null) ? "" : "";
            k0(series.getProxy());
            g0(v0(series.getHttpHeader()));
            C0(series.getSelectedVideo(), i2);
            B0(series);
            E0(series);
            y0(series, i2);
            A0(i2, str);
            l0();
            z0();
            D0(series);
        }
    }

    @Override // c.a.b0.v.j0.i
    public c.a.b0.v.f0.g N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (c.a.b0.v.f0.g) invokeV.objValue;
    }

    @Override // c.a.b0.v.j0.i, c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void d(c.a.b0.v.c0.p event) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String c2 = event.c();
            int hashCode = c2.hashCode();
            if (hashCode != -882902390) {
                if (hashCode == 1370689931 && c2.equals(PlayerEvent.ACTION_ON_INFO) && event.g(1) != 904) {
                    event.g(1);
                }
            } else if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                Object f2 = event.f(3);
                if (!(f2 instanceof c.a.b0.v.m0.h)) {
                    f2 = null;
                }
                c.a.b0.v.m0.h hVar = (c.a.b0.v.m0.h) f2;
                c.a.b0.v.f u = u();
                if (u != null && (o1 = u.o1()) != null) {
                    String vid = o1.getVid();
                    Intrinsics.checkNotNullExpressionValue(vid, "vid");
                    this.l = vid;
                    Intrinsics.checkNotNullExpressionValue(o1, "this");
                    F0(o1, hVar);
                }
            }
            super.d(event);
        }
    }

    @Override // c.a.b0.v.j0.i, c.a.b0.v.j0.b, c.a.b0.v.f0.j
    public void k(c.a.b0.v.c0.p event) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(LayerEvent.ACTION_CHANGE_CLARITY, event.c())) {
                Object f2 = event.f(31);
                if (!(f2 instanceof c.a.b0.v.m0.h)) {
                    f2 = null;
                }
                c.a.b0.v.m0.h hVar = (c.a.b0.v.m0.h) f2;
                c.a.b0.v.f u = u();
                if (u != null && (o1 = u.o1()) != null) {
                    Intrinsics.checkNotNullExpressionValue(o1, "this");
                    F0(o1, hVar);
                }
            }
            super.k(event);
        }
    }

    @Override // c.a.b0.v.j0.b, c.a.b0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // c.a.b0.v.j0.i
    public void p0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) {
            super.p0(str, z);
        }
    }

    @Override // c.a.b0.v.j0.i
    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.r0();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.b0.v.j0.b
    /* renamed from: u0 */
    public c.a.b0.v.f u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.b0.v.e u = super.u();
            if (!(u instanceof c.a.b0.v.f)) {
                u = null;
            }
            return (c.a.b0.v.f) u;
        }
        return (c.a.b0.v.f) invokeV.objValue;
    }

    public final HashMap<String, String> v0(String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str != null) {
                if (str.length() > 0) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    Object[] array = new Regex("\r\n").split(str, 0).toArray(new String[0]);
                    if (array != null) {
                        for (String str2 : (String[]) array) {
                            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, ":", 0, false, 6, (Object) null);
                            if (indexOf$default > 0 && indexOf$default < str2.length()) {
                                if (str2 != null) {
                                    String substring = str2.substring(0, indexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    int i2 = indexOf$default + 1;
                                    if (str2 != null) {
                                        String substring2 = str2.substring(i2);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                                        hashMap.put(substring, substring2);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                            }
                        }
                        return hashMap;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                return null;
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    public final String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final HashMap<String, String> x0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? new HashMap<>() : (HashMap) invokeL.objValue;
    }

    public final void y0(BdVideoSeries bdVideoSeries, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, bdVideoSeries, i2) == null) {
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }
}
