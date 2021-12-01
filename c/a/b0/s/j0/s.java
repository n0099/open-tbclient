package c.a.b0.s.j0;

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

    @Override // c.a.b0.s.j0.i, c.a.b0.s.j0.b
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.C();
            this.f1974i.J(c.a.b0.e.a.d());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.b0.s.j0.b
    /* renamed from: C0 */
    public c.a.b0.s.f v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.b0.s.e v = super.v();
            if (!(v instanceof c.a.b0.s.f)) {
                v = null;
            }
            return (c.a.b0.s.f) v;
        }
        return (c.a.b0.s.f) invokeV.objValue;
    }

    public final HashMap<String, String> D0(String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
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

    public final String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final HashMap<String, String> F0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? new HashMap<>() : (HashMap) invokeL.objValue;
    }

    public final void G0(BdVideoSeries bdVideoSeries, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, bdVideoSeries, i2) == null) {
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void I0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
        }
    }

    public final void J0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdVideoSeries) == null) {
        }
    }

    public final void K0(BdVideo bdVideo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, bdVideo, i2) == null) {
        }
    }

    public final void L0(BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdVideoSeries) == null) {
        }
    }

    public final void M0(@NonNull BdVideoSeries bdVideoSeries) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdVideoSeries) == null) {
            String format = bdVideoSeries.getFormat();
            v0(format, F0(format));
        }
    }

    public void N0(BdVideoSeries series, c.a.b0.s.m0.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, series, hVar) == null) {
            Intrinsics.checkNotNullParameter(series, "series");
            int i2 = hVar != null ? hVar.f2039d : -1;
            String str = (hVar == null || (str = hVar.a) == null) ? "" : "";
            s0(series.getProxy());
            o0(D0(series.getHttpHeader()));
            K0(series.getSelectedVideo(), i2);
            J0(series);
            M0(series);
            G0(series, i2);
            I0(i2, str);
            t0();
            H0();
            L0(series);
        }
    }

    @Override // c.a.b0.s.j0.i
    public c.a.b0.s.f0.g V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (c.a.b0.s.f0.g) invokeV.objValue;
    }

    @Override // c.a.b0.s.j0.i, c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void e(c.a.b0.s.c0.p event) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String c2 = event.c();
            int hashCode = c2.hashCode();
            if (hashCode != -882902390) {
                if (hashCode == 1370689931 && c2.equals(PlayerEvent.ACTION_ON_INFO) && event.g(1) != 904) {
                    event.g(1);
                }
            } else if (c2.equals(PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                Object f2 = event.f(3);
                if (!(f2 instanceof c.a.b0.s.m0.h)) {
                    f2 = null;
                }
                c.a.b0.s.m0.h hVar = (c.a.b0.s.m0.h) f2;
                c.a.b0.s.f v = v();
                if (v != null && (o1 = v.o1()) != null) {
                    String vid = o1.getVid();
                    Intrinsics.checkNotNullExpressionValue(vid, "vid");
                    this.l = vid;
                    Intrinsics.checkNotNullExpressionValue(o1, "this");
                    N0(o1, hVar);
                }
            }
            super.e(event);
        }
    }

    @Override // c.a.b0.s.j0.i, c.a.b0.s.j0.b, c.a.b0.s.f0.j
    public void l(c.a.b0.s.c0.p event) {
        BdVideoSeries o1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(LayerEvent.ACTION_CHANGE_CLARITY, event.c())) {
                Object f2 = event.f(31);
                if (!(f2 instanceof c.a.b0.s.m0.h)) {
                    f2 = null;
                }
                c.a.b0.s.m0.h hVar = (c.a.b0.s.m0.h) f2;
                c.a.b0.s.f v = v();
                if (v != null && (o1 = v.o1()) != null) {
                    Intrinsics.checkNotNullExpressionValue(o1, "this");
                    N0(o1, hVar);
                }
            }
            super.l(event);
        }
    }

    @Override // c.a.b0.s.j0.b, c.a.b0.s.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onLayerRelease();
        }
    }

    @Override // c.a.b0.s.j0.i
    public void x0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) {
            super.x0(str, z);
        }
    }

    @Override // c.a.b0.s.j0.i
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.z0();
        }
    }
}
