package b.a.r0.x0.c2.a.d;

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
/* loaded from: classes5.dex */
public class d extends b.a.r0.x0.c2.a.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public LabelDataList f25652g;

    /* renamed from: h  reason: collision with root package name */
    public Context f25653h;

    /* renamed from: i  reason: collision with root package name */
    public int f25654i;
    public final int j;

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
        this.f25654i = 0;
        this.f25653h = context;
        this.j = context.getResources().getDimensionPixelSize(R.dimen.ds64);
    }

    @Override // b.a.r0.x0.c2.a.e.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f25652g) : invokeV.intValue;
    }

    @Override // b.a.r0.x0.c2.a.e.a
    public Object c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f25652g, i2) : invokeI.objValue;
    }

    @Override // b.a.r0.x0.c2.a.e.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // b.a.r0.x0.c2.a.e.a
    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // b.a.r0.x0.c2.a.e.a
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
            b.a.r0.x0.c2.a.a.a aVar = (b.a.r0.x0.c2.a.a.a) ListUtils.getItem(this.f25652g, i2);
            if (aVar != null) {
                m.setText(aVar.f25620b);
            }
            l(m, this.f25654i == i2);
            return m;
        }
        return (View) invokeILL.objValue;
    }

    @Override // b.a.r0.x0.c2.a.e.a
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f25654i = i2;
            this.f25652g.setSelectedIndex(i2);
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
            TextView textView = new TextView(this.f25653h);
            textView.setTextSize(0, this.f25653h.getResources().getDimensionPixelSize(R.dimen.fontsize26));
            textView.setGravity(17);
            textView.setHeight(d());
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void n(LabelDataList labelDataList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, labelDataList) == null) {
            this.f25652g = labelDataList;
            notifyDataSetChanged();
        }
    }
}
