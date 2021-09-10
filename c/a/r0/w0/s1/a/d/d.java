package c.a.r0.w0.s1.a.d;

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
/* loaded from: classes4.dex */
public class d extends c.a.r0.w0.s1.a.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public LabelDataList f27792g;

    /* renamed from: h  reason: collision with root package name */
    public Context f27793h;

    /* renamed from: i  reason: collision with root package name */
    public int f27794i;

    /* renamed from: j  reason: collision with root package name */
    public final int f27795j;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27794i = 0;
        this.f27793h = context;
        this.f27795j = context.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // c.a.r0.w0.s1.a.e.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f27792g) : invokeV.intValue;
    }

    @Override // c.a.r0.w0.s1.a.e.a
    public Object c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f27792g, i2) : invokeI.objValue;
    }

    @Override // c.a.r0.w0.s1.a.e.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27795j : invokeV.intValue;
    }

    @Override // c.a.r0.w0.s1.a.e.a
    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // c.a.r0.w0.s1.a.e.a
    public View g(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view instanceof TextView) {
                m = (TextView) view;
            } else {
                m = m();
            }
            c.a.r0.w0.s1.a.a.a aVar = (c.a.r0.w0.s1.a.a.a) ListUtils.getItem(this.f27792g, i2);
            if (aVar != null) {
                m.setText(aVar.f27759b);
            }
            l(m, this.f27794i == i2);
            return m;
        }
        return (View) invokeILL.objValue;
    }

    @Override // c.a.r0.w0.s1.a.e.a
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f27794i = i2;
            this.f27792g.setSelectedIndex(i2);
            notifyDataSetChanged();
        }
    }

    public void l(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, textView, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_s);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
            SkinManager.setBackgroundResource(textView, R.drawable.shape_frs_game_label_item_bg_n);
        }
    }

    public final TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = new TextView(this.f27793h);
            textView.setTextSize(0, this.f27793h.getResources().getDimensionPixelSize(R.dimen.fontsize26));
            textView.setGravity(17);
            textView.setHeight(d());
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void n(LabelDataList labelDataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, labelDataList) == null) {
            this.f27792g = labelDataList;
            notifyDataSetChanged();
        }
    }
}
