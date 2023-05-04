package com.baidu.searchbox.fluency.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b3\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b3\u00106B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b3\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\"\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\"\u0010*\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\"\u0010-\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/fluency/view/FpsFloatView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "initView", "(Landroid/content/Context;)V", "Lcom/baidu/searchbox/fluency/view/LineChartView;", "chartView", "Lcom/baidu/searchbox/fluency/view/LineChartView;", "getChartView", "()Lcom/baidu/searchbox/fluency/view/LineChartView;", "setChartView", "(Lcom/baidu/searchbox/fluency/view/LineChartView;)V", "Landroid/widget/TextView;", "dropExpectView", "Landroid/widget/TextView;", "getDropExpectView", "()Landroid/widget/TextView;", "setDropExpectView", "(Landroid/widget/TextView;)V", "fpsView", "getFpsView", "setFpsView", "levelFrozenView", "getLevelFrozenView", "setLevelFrozenView", "levelFrozensView", "getLevelFrozensView", "setLevelFrozensView", "levelHighView", "getLevelHighView", "setLevelHighView", "levelHighsView", "getLevelHighsView", "setLevelHighsView", "levelMiddleView", "getLevelMiddleView", "setLevelMiddleView", "levelMiddlesView", "getLevelMiddlesView", "setLevelMiddlesView", "levelNormalView", "getLevelNormalView", "setLevelNormalView", "levelNormalsView", "getLevelNormalsView", "setLevelNormalsView", "topPageView", "getTopPageView", "setTopPageView", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FpsFloatView extends LinearLayout {
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

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FpsFloatView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setChartView(LineChartView lineChartView) {
        Intrinsics.checkNotNullParameter(lineChartView, "<set-?>");
        this.chartView = lineChartView;
    }

    public final void setDropExpectView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.dropExpectView = textView;
    }

    public final void setFpsView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.fpsView = textView;
    }

    public final void setLevelFrozenView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelFrozenView = textView;
    }

    public final void setLevelFrozensView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelFrozensView = textView;
    }

    public final void setLevelHighView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelHighView = textView;
    }

    public final void setLevelHighsView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelHighsView = textView;
    }

    public final void setLevelMiddleView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelMiddleView = textView;
    }

    public final void setLevelMiddlesView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelMiddlesView = textView;
    }

    public final void setLevelNormalView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelNormalView = textView;
    }

    public final void setLevelNormalsView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.levelNormalsView = textView;
    }

    public final void setTopPageView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.topPageView = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FpsFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FpsFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    private final void initView(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        View.inflate(context, R.layout.obfuscated_res_0x7f0d02f0, this);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f090681);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.chart)");
        this.chartView = (LineChartView) findViewById;
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f090bcf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fps_view)");
        this.fpsView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.obfuscated_res_0x7f091460);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.level_frozen)");
        this.levelFrozenView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.obfuscated_res_0x7f091462);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.level_high)");
        this.levelHighView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.obfuscated_res_0x7f091464);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.level_middle)");
        this.levelMiddleView = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.obfuscated_res_0x7f091469);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.level_normal)");
        this.levelNormalView = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.obfuscated_res_0x7f091461);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.level_frozens)");
        this.levelFrozensView = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.obfuscated_res_0x7f091463);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.level_highs)");
        this.levelHighsView = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.obfuscated_res_0x7f091465);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.level_middles)");
        this.levelMiddlesView = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.obfuscated_res_0x7f09146a);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.level_normals)");
        this.levelNormalsView = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.obfuscated_res_0x7f09091c);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.drop_expect)");
        this.dropExpectView = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.obfuscated_res_0x7f0924a8);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.top_page)");
        this.topPageView = (TextView) findViewById12;
    }

    public final LineChartView getChartView() {
        LineChartView lineChartView = this.chartView;
        if (lineChartView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chartView");
        }
        return lineChartView;
    }

    public final TextView getDropExpectView() {
        TextView textView = this.dropExpectView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dropExpectView");
        }
        return textView;
    }

    public final TextView getFpsView() {
        TextView textView = this.fpsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fpsView");
        }
        return textView;
    }

    public final TextView getLevelFrozenView() {
        TextView textView = this.levelFrozenView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelFrozenView");
        }
        return textView;
    }

    public final TextView getLevelFrozensView() {
        TextView textView = this.levelFrozensView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelFrozensView");
        }
        return textView;
    }

    public final TextView getLevelHighView() {
        TextView textView = this.levelHighView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelHighView");
        }
        return textView;
    }

    public final TextView getLevelHighsView() {
        TextView textView = this.levelHighsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelHighsView");
        }
        return textView;
    }

    public final TextView getLevelMiddleView() {
        TextView textView = this.levelMiddleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelMiddleView");
        }
        return textView;
    }

    public final TextView getLevelMiddlesView() {
        TextView textView = this.levelMiddlesView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelMiddlesView");
        }
        return textView;
    }

    public final TextView getLevelNormalView() {
        TextView textView = this.levelNormalView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelNormalView");
        }
        return textView;
    }

    public final TextView getLevelNormalsView() {
        TextView textView = this.levelNormalsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("levelNormalsView");
        }
        return textView;
    }

    public final TextView getTopPageView() {
        TextView textView = this.topPageView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topPageView");
        }
        return textView;
    }
}
