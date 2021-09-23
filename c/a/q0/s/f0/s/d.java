package c.a.q0.s.f0.s;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
/* loaded from: classes3.dex */
public class d extends a<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public AtSelectData f13908i;

    public d() {
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

    public static d w(@NonNull d dVar, @NonNull Editable editable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dVar, editable)) == null) {
            d dVar2 = new d();
            dVar2.t(dVar);
            dVar2.n(editable);
            return dVar2;
        }
        return (d) invokeLL.objValue;
    }

    @Override // c.a.q0.s.f0.s.a
    public void a(Editable editable, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i2, i3, i4) == null) {
            super.a(editable, i2, i3, i4);
        }
    }

    @Override // c.a.q0.s.f0.s.a
    public void p(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.f13908i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.f13908i.getNameShow());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.f13908i.getUid());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            i(sb);
        }
    }

    @Override // c.a.q0.s.f0.s.a
    public void q(Editable editable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, editable, i2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.f13908i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.f13908i.getNameShow());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            i(sb);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o(true);
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f(), c(), 33);
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            super.b(dVar);
            this.f13908i = dVar.f13908i;
        }
    }

    public AtSelectData u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f13908i : (AtSelectData) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f13908i.getNameShow() + " ";
        }
        return (String) invokeV.objValue;
    }

    public d(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atSelectData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13908i = atSelectData;
    }
}
