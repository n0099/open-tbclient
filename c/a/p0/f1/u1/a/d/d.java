package c.a.p0.f1.u1.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends c.a.p0.f1.u1.a.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public LabelDataList f14709c;

    /* renamed from: d  reason: collision with root package name */
    public Context f14710d;

    /* renamed from: e  reason: collision with root package name */
    public int f14711e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14712f;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14711e = 0;
        this.f14710d = context;
        this.f14712f = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258);
    }

    @Override // c.a.p0.f1.u1.a.e.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f14709c) : invokeV.intValue;
    }

    @Override // c.a.p0.f1.u1.a.e.a
    public Object c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? ListUtils.getItem(this.f14709c, i) : invokeI.objValue;
    }

    @Override // c.a.p0.f1.u1.a.e.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14712f : invokeV.intValue;
    }

    @Override // c.a.p0.f1.u1.a.e.a
    public long e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // c.a.p0.f1.u1.a.e.a
    public View g(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            if (view instanceof TextView) {
                m = (TextView) view;
            } else {
                m = m();
            }
            c.a.p0.f1.u1.a.a.a aVar = (c.a.p0.f1.u1.a.a.a) ListUtils.getItem(this.f14709c, i);
            if (aVar != null) {
                m.setText(aVar.f14688b);
            }
            l(m, this.f14711e == i);
            return m;
        }
        return (View) invokeILL.objValue;
    }

    @Override // c.a.p0.f1.u1.a.e.a
    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f14711e = i;
            this.f14709c.setSelectedIndex(i);
            notifyDataSetChanged();
        }
    }

    public void l(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, textView, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
                return;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
            SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
        }
    }

    public final TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = new TextView(this.f14710d);
            textView.setTextSize(0, this.f14710d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070326));
            textView.setGravity(17);
            textView.setHeight(d());
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void n(LabelDataList labelDataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, labelDataList) == null) {
            this.f14709c = labelDataList;
            notifyDataSetChanged();
        }
    }
}
