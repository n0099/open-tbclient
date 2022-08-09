package com.baidu.searchbox.fluency.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b3\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b3\u00106B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b3\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\"\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\"\u0010-\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsFloatView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "initView", "(Landroid/content/Context;)V", "Lcom/baidu/searchbox/fluency/view/LineChartView;", "chartView", "Lcom/baidu/searchbox/fluency/view/LineChartView;", "getChartView", "()Lcom/baidu/searchbox/fluency/view/LineChartView;", "setChartView", "(Lcom/baidu/searchbox/fluency/view/LineChartView;)V", "Landroid/widget/TextView;", "dropExpectView", "Landroid/widget/TextView;", "getDropExpectView", "()Landroid/widget/TextView;", "setDropExpectView", "(Landroid/widget/TextView;)V", "fpsView", "getFpsView", "setFpsView", "levelFrozenView", "getLevelFrozenView", "setLevelFrozenView", "levelFrozensView", "getLevelFrozensView", "setLevelFrozensView", "levelHighView", "getLevelHighView", "setLevelHighView", "levelHighsView", "getLevelHighsView", "setLevelHighsView", "levelMiddleView", "getLevelMiddleView", "setLevelMiddleView", "levelMiddlesView", "getLevelMiddlesView", "setLevelMiddlesView", "levelNormalView", "getLevelNormalView", "setLevelNormalView", "levelNormalsView", "getLevelNormalsView", "setLevelNormalsView", "topPageView", "getTopPageView", "setTopPageView", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FpsFloatView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;
    public LineChartView chartView;
    public TextView dropExpectView;
    public TextView fpsView;
    public TextView levelFrozenView;
    public TextView levelFrozensView;
    public TextView levelHighView;
    public TextView levelHighsView;
    public TextView levelMiddleView;
    public TextView levelMiddlesView;
    public TextView levelNormalView;
    public TextView levelNormalsView;
    public TextView topPageView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FpsFloatView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            View.inflate(context, R.layout.obfuscated_res_0x7f0d02cc, this);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0905ec);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.chart)");
            this.chartView = (LineChartView) findViewById;
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f090aae);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fps_view)");
            this.fpsView = (TextView) findViewById2;
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f0912c4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.level_frozen)");
            this.levelFrozenView = (TextView) findViewById3;
            View findViewById4 = findViewById(R.id.obfuscated_res_0x7f0912c6);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.level_high)");
            this.levelHighView = (TextView) findViewById4;
            View findViewById5 = findViewById(R.id.obfuscated_res_0x7f0912c8);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.level_middle)");
            this.levelMiddleView = (TextView) findViewById5;
            View findViewById6 = findViewById(R.id.obfuscated_res_0x7f0912cd);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.level_normal)");
            this.levelNormalView = (TextView) findViewById6;
            View findViewById7 = findViewById(R.id.obfuscated_res_0x7f0912c5);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.level_frozens)");
            this.levelFrozensView = (TextView) findViewById7;
            View findViewById8 = findViewById(R.id.obfuscated_res_0x7f0912c7);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.level_highs)");
            this.levelHighsView = (TextView) findViewById8;
            View findViewById9 = findViewById(R.id.obfuscated_res_0x7f0912c9);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.level_middles)");
            this.levelMiddlesView = (TextView) findViewById9;
            View findViewById10 = findViewById(R.id.obfuscated_res_0x7f0912ce);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.level_normals)");
            this.levelNormalsView = (TextView) findViewById10;
            View findViewById11 = findViewById(R.id.obfuscated_res_0x7f090848);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.drop_expect)");
            this.dropExpectView = (TextView) findViewById11;
            View findViewById12 = findViewById(R.id.obfuscated_res_0x7f092250);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.top_page)");
            this.topPageView = (TextView) findViewById12;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hashMap = this._$_findViewCache) == null) {
            return;
        }
        hashMap.clear();
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this._$_findViewCache == null) {
                this._$_findViewCache = new HashMap();
            }
            View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                this._$_findViewCache.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final LineChartView getChartView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LineChartView lineChartView = this.chartView;
            if (lineChartView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chartView");
            }
            return lineChartView;
        }
        return (LineChartView) invokeV.objValue;
    }

    public final TextView getDropExpectView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.dropExpectView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dropExpectView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getFpsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.fpsView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fpsView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelFrozenView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TextView textView = this.levelFrozenView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelFrozenView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelFrozensView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.levelFrozensView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelFrozensView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelHighView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TextView textView = this.levelHighView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelHighView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelHighsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TextView textView = this.levelHighsView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelHighsView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelMiddleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TextView textView = this.levelMiddleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelMiddleView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelMiddlesView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TextView textView = this.levelMiddlesView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelMiddlesView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelNormalView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TextView textView = this.levelNormalView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelNormalView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getLevelNormalsView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            TextView textView = this.levelNormalsView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("levelNormalsView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getTopPageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            TextView textView = this.topPageView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topPageView");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final void setChartView(LineChartView lineChartView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, lineChartView) == null) {
            Intrinsics.checkNotNullParameter(lineChartView, "<set-?>");
            this.chartView = lineChartView;
        }
    }

    public final void setDropExpectView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.dropExpectView = textView;
        }
    }

    public final void setFpsView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.fpsView = textView;
        }
    }

    public final void setLevelFrozenView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelFrozenView = textView;
        }
    }

    public final void setLevelFrozensView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelFrozensView = textView;
        }
    }

    public final void setLevelHighView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelHighView = textView;
        }
    }

    public final void setLevelHighsView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelHighsView = textView;
        }
    }

    public final void setLevelMiddleView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelMiddleView = textView;
        }
    }

    public final void setLevelMiddlesView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelMiddlesView = textView;
        }
    }

    public final void setLevelNormalView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelNormalView = textView;
        }
    }

    public final void setLevelNormalsView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.levelNormalsView = textView;
        }
    }

    public final void setTopPageView(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.topPageView = textView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FpsFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FpsFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }
}
