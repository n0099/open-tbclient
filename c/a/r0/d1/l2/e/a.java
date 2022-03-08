package c.a.r0.d1.l2.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.r.v.c;
import c.a.r0.d1.v2.e;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TopViewLogic.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? UbsABTestHelper.isFrsModifyABTestA() : invokeV.booleanValue;
    }

    public static void b(@NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, view) == null) && a()) {
            ViewCommonUtil.setViewMargin(view, -1, -1, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds9));
        }
    }

    public static void c(@NonNull View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, view) == null) && a()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds18);
            ViewCommonUtil.setViewPadding(view, -1, dimenPixelSize, -1, dimenPixelSize);
        }
    }

    public static void d(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view) == null) {
            if (a()) {
                c d2 = c.d(view);
                d2.n(R.string.J_X05);
                d2.f(R.color.CAM_X0201);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
        }
    }

    public static void e(@NonNull e.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) && a()) {
            ViewCommonUtil.setViewWidthHeight(fVar.f16635d, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f16634c, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f16636e, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f16637f, -3, -2);
            ViewCommonUtil.setViewMargin(fVar.f16637f, 0, 0, 0, 0);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds18);
            ViewCommonUtil.setViewPadding(fVar.f16637f, -1, dimenPixelSize, -1, dimenPixelSize);
        }
    }

    public static void f(@NonNull TextView textView, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, textView, i2) == null) {
            Context context = textView.getContext();
            if (a()) {
                textView.setTextColor(i2);
                textView.setTextSize(0, n.f(context, R.dimen.T_X07));
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                return;
            }
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(n.f(context, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(i2).into(textView);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            textView.setTextSize(0, n.f(context, R.dimen.T_X10));
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = n.f(context, R.dimen.tbds74);
            layoutParams2.height = n.f(context, R.dimen.tbds40);
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
            frsTopView.setTag(R.id.item_data, Integer.valueOf(b.a));
            bdTypeRecyclerView.addHeaderView(frsTopView);
            return bdTypeRecyclerView;
        }
        return (BdTypeRecyclerView) invokeLL.objValue;
    }
}
