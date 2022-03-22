package c.a.o0.r.l0.s;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes2.dex */
public class d extends a<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtSelectData i;

    public d() {
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

    public static d w(@NonNull d dVar, @NonNull Editable editable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dVar, editable)) == null) {
            d dVar2 = new d();
            dVar2.b(dVar);
            dVar2.n(editable);
            return dVar2;
        }
        return (d) invokeLL.objValue;
    }

    @Override // c.a.o0.r.l0.s.a
    public void a(Editable editable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i, i2, i3) == null) {
            super.a(editable, i, i2, i3);
        }
    }

    @Override // c.a.o0.r.l0.s.a
    public void p(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, editable) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getNameShow());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getUid());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            i(sb);
        }
    }

    @Override // c.a.o0.r.l0.s.a
    public void q(Editable editable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, editable, i) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("#(at, ");
            sb.append(this.i.getPortrait());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.i.getNameShow());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(" ");
            i(sb);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            o(true);
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l(new SpanGroupForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f(), c(), 33);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.r.l0.s.a
    /* renamed from: t */
    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            super.b(dVar);
            this.i = dVar.i;
        }
    }

    public AtSelectData u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i : (AtSelectData) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "@" + this.i.getNameShow() + " ";
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = atSelectData;
    }
}
