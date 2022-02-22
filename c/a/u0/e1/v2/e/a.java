package c.a.u0.e1.v2.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.b.d;
import c.a.t0.s.v.c;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.f1;
import c.a.u0.e1.f3.e;
import c.a.u0.e1.i1;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TopViewLogic.java */
/* loaded from: classes8.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? d.u() : invokeV.booleanValue;
    }

    public static void b(@NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, view) == null) && a()) {
            ViewCommonUtil.setViewMargin(view, -1, -1, -1, UtilHelper.getDimenPixelSize(d1.tbds9));
        }
    }

    public static void c(@NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, view) == null) && a()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds18);
            ViewCommonUtil.setViewPadding(view, -1, dimenPixelSize, -1, dimenPixelSize);
        }
    }

    public static void d(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view) == null) {
            if (a()) {
                c d2 = c.d(view);
                d2.n(i1.J_X05);
                d2.f(c1.CAM_X0201);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(d1.M_H_X002);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(view, c1.CAM_X0204);
        }
    }

    public static void e(@NonNull e.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) && a()) {
            ViewCommonUtil.setViewWidthHeight(fVar.f16585d, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f16584c, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f16586e, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f16587f, -3, -2);
            ViewCommonUtil.setViewMargin(fVar.f16587f, 0, 0, 0, 0);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.tbds18);
            ViewCommonUtil.setViewPadding(fVar.f16587f, -1, dimenPixelSize, -1, dimenPixelSize);
        }
    }

    public static void f(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, textView, i2) == null) {
            Context context = textView.getContext();
            if (a()) {
                textView.setTextColor(i2);
                textView.setTextSize(0, n.f(context, d1.T_X07));
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                return;
            }
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(context, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(i2).into(textView);
            SkinManager.setViewTextColor(textView, c1.CAM_X0101);
            textView.setTextSize(0, n.f(context, d1.T_X10));
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = n.f(context, d1.tbds74);
            layoutParams2.height = n.f(context, d1.tbds40);
        }
    }

    @Nullable
    public static BdTypeRecyclerView g(@Nullable FrsTopView frsTopView, @Nullable BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, frsTopView, bdTypeRecyclerView)) == null) {
            if (!a() || frsTopView == null || bdTypeRecyclerView == null) {
                return null;
            }
            View findHeaderViewByTagData = bdTypeRecyclerView.findHeaderViewByTagData(Integer.valueOf(b.a));
            if (findHeaderViewByTagData != null) {
                bdTypeRecyclerView.removeHeaderView(findHeaderViewByTagData);
            }
            if (frsTopView.getParent() instanceof ViewGroup) {
                ((ViewGroup) frsTopView.getParent()).removeView(frsTopView);
            }
            frsTopView.setTag(f1.item_data, Integer.valueOf(b.a));
            bdTypeRecyclerView.addHeaderView(frsTopView);
            return bdTypeRecyclerView;
        }
        return (BdTypeRecyclerView) invokeLL.objValue;
    }
}
