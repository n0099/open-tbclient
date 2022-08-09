package com.baidu.searchbox.fluency.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.utils.CommonUtilsKt;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0011\b\u0016\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109B\u001b\b\u0016\u0012\u0006\u00107\u001a\u000206\u0012\b\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b8\u0010<B#\b\u0016\u0012\u0006\u00107\u001a\u000206\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\u0006\u0010=\u001a\u00020\u0002¢\u0006\u0004\b8\u0010>J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0016\u0010 \u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010!\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001eR \u0010+\u001a\f\u0012\b\u0012\u00060*R\u00020\u00000)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0014R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0018R\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001bR\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0014R\u0016\u00101\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010$R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0014R\u0016\u00103\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010$R\u0016\u00104\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010$R\u0016\u00105\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001e¨\u0006A"}, d2 = {"Lcom/baidu/searchbox/fluency/view/LineChartView;", "Landroid/view/View;", "", FpsConstants.REPORT_FPS, "", "addFps", "(I)V", "getColor", "(I)I", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "bestColor", "I", "frozenColor", "Landroid/graphics/Path;", "frozenPath", "Landroid/graphics/Path;", "", "frozenTip", "[F", "", "height", "F", "highColor", "highPath", "highTip", "Landroid/graphics/Paint;", "levelLinePaint", "Landroid/graphics/Paint;", "lineMargin", "lineRightPadding", "lineStrokeWidth", "lineWidth", "Ljava/util/LinkedList;", "Lcom/baidu/searchbox/fluency/view/LineChartView$LineInfo;", "lines", "Ljava/util/LinkedList;", "middleColor", "middlePath", "middleTip", "normalColor", "paint", "tipColor", "tipLinePaint", "tipPaint", "width", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "LineInfo", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LineChartView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int LINE_COUNT = 50;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap _$_findViewCache;
    public final int bestColor;
    public final int frozenColor;
    public final Path frozenPath;
    public final float[] frozenTip;
    public float height;
    public final int highColor;
    public final Path highPath;
    public final float[] highTip;
    public final Paint levelLinePaint;
    public final float lineMargin;
    public final float lineRightPadding;
    public final float lineStrokeWidth;
    public float lineWidth;
    public final LinkedList<LineInfo> lines;
    public final int middleColor;
    public final Path middlePath;
    public final float[] middleTip;
    public final int normalColor;
    public Paint paint;
    public final int tipColor;
    public final Paint tipLinePaint;
    public final Paint tipPaint;
    public float width;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/fluency/view/LineChartView$Companion;", "", "LINE_COUNT", "I", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0007\b\u0086\u0004\u0018\u0000B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/fluency/view/LineChartView$LineInfo;", "Landroid/graphics/Canvas;", "canvas", "", "index", "", "draw", "(Landroid/graphics/Canvas;I)V", "color", "I", FpsConstants.REPORT_FPS, "getFps", "()I", "", "linePoint", "[F", "getLinePoint", "()[F", "<init>", "(Lcom/baidu/searchbox/fluency/view/LineChartView;II)V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class LineInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int color;
        public final int fps;
        public final float[] linePoint;
        public final /* synthetic */ LineChartView this$0;

        public LineInfo(LineChartView lineChartView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lineChartView, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lineChartView;
            this.fps = i;
            this.color = i2;
            this.linePoint = r7;
            float[] fArr = {0.0f, 0.0f, lineChartView.lineWidth - (((60 - this.fps) * lineChartView.lineWidth) / 60)};
        }

        public final void draw(Canvas canvas, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, canvas, i) == null) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                if (this.this$0.paint.getColor() != this.color) {
                    this.this$0.paint.setColor(this.color);
                }
                this.linePoint[1] = (i + 1) * this.this$0.lineMargin;
                float[] fArr = this.linePoint;
                fArr[3] = fArr[1];
                canvas.drawLine(fArr[0], fArr[1], fArr[2], fArr[3], this.this$0.paint);
            }
        }

        public final int getFps() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fps : invokeV.intValue;
        }

        public final float[] getLinePoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.linePoint : (float[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593957925, "Lcom/baidu/searchbox/fluency/view/LineChartView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593957925, "Lcom/baidu/searchbox/fluency/view/LineChartView;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineChartView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i)) == null) {
            if (i > 57) {
                return this.bestColor;
            }
            if (i > 50) {
                return this.normalColor;
            }
            if (i > 35) {
                return this.middleColor;
            }
            if (i > 20) {
                return this.highColor;
            }
            return this.frozenColor;
        }
        return invokeI.intValue;
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

    public final void addFps(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            LineInfo lineInfo = new LineInfo(this, i, getColor(i));
            if (this.lines.size() >= 50) {
                this.lines.removeLast();
            }
            this.lines.addFirst(lineInfo);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            if (canvas == null) {
                return;
            }
            float dp2px = CommonUtilsKt.dp2px(8);
            Iterator<LineInfo> it = this.lines.iterator();
            int i = 0;
            int i2 = 1;
            while (it.hasNext()) {
                LineInfo next = it.next();
                i += next.getFps();
                next.draw(canvas, i2);
                if (i2 % 25 == 0) {
                    Path path = new Path();
                    float f = next.getLinePoint()[1];
                    path.moveTo(0.0f, f);
                    path.lineTo(this.width, f);
                    canvas.drawPath(path, this.tipLinePaint);
                    this.tipPaint.setColor(this.tipColor);
                    canvas.drawText(String.valueOf(i2 / 5) + "s", this.lineWidth, f + dp2px, this.tipPaint);
                    if (i2 > 0) {
                        int i3 = i / i2;
                        this.tipPaint.setColor(getColor(i3));
                        canvas.drawText(String.valueOf(i3) + "FPS", this.lineWidth, f - (dp2px / 2), this.tipPaint);
                    }
                }
                i2++;
            }
            this.tipPaint.setColor(this.tipColor);
            this.levelLinePaint.setColor(this.frozenColor);
            canvas.drawPath(this.frozenPath, this.levelLinePaint);
            String valueOf = String.valueOf(20);
            float[] fArr = this.frozenTip;
            float f2 = dp2px / 2;
            canvas.drawText(valueOf, fArr[0] - f2, fArr[1] + dp2px, this.tipPaint);
            this.levelLinePaint.setColor(this.highColor);
            canvas.drawPath(this.highPath, this.levelLinePaint);
            String valueOf2 = String.valueOf(35);
            float[] fArr2 = this.highTip;
            canvas.drawText(valueOf2, fArr2[0] - f2, fArr2[1] + dp2px, this.tipPaint);
            this.levelLinePaint.setColor(this.middleColor);
            canvas.drawPath(this.middlePath, this.levelLinePaint);
            String valueOf3 = String.valueOf(50);
            float[] fArr3 = this.middleTip;
            canvas.drawText(valueOf3, fArr3[0] - f2, fArr3[1] + dp2px, this.tipPaint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            float f = i;
            this.width = f;
            float f2 = f - (3 * this.lineRightPadding);
            this.lineWidth = f2;
            this.height = i2;
            float f3 = f2 / 60;
            float f4 = 50;
            float dp2px = (this.lineMargin * f4) + CommonUtilsKt.dp2px(8);
            float[] fArr = this.frozenTip;
            fArr[0] = 20 * f3;
            fArr[1] = dp2px;
            this.frozenPath.moveTo(fArr[0], fArr[1]);
            this.frozenPath.lineTo(this.frozenTip[0], 0.0f);
            float[] fArr2 = this.highTip;
            fArr2[0] = 35 * f3;
            fArr2[1] = dp2px;
            this.highPath.moveTo(fArr2[0], fArr2[1]);
            this.highPath.lineTo(this.highTip[0], 0.0f);
            float[] fArr3 = this.middleTip;
            fArr3[0] = f4 * f3;
            fArr3[1] = dp2px;
            this.middlePath.moveTo(fArr3[0], fArr3[1]);
            this.middlePath.lineTo(this.middleTip[0], 0.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint();
        this.levelLinePaint = new Paint();
        this.tipPaint = new Paint();
        this.tipLinePaint = new Paint();
        this.middlePath = new Path();
        this.highPath = new Path();
        this.frozenPath = new Path();
        this.middleTip = new float[2];
        this.highTip = new float[2];
        this.frozenTip = new float[2];
        float dp2px = CommonUtilsKt.dp2px(1);
        this.lineStrokeWidth = dp2px;
        this.lineMargin = dp2px * 2;
        this.lineRightPadding = CommonUtilsKt.dp2px(8);
        this.lines = new LinkedList<>();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.bestColor = context2.getResources().getColor(R.color.obfuscated_res_0x7f06077f);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        this.normalColor = context3.getResources().getColor(R.color.obfuscated_res_0x7f060783);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        this.middleColor = context4.getResources().getColor(R.color.obfuscated_res_0x7f060782);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        this.highColor = context5.getResources().getColor(R.color.obfuscated_res_0x7f060781);
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        this.frozenColor = context6.getResources().getColor(R.color.obfuscated_res_0x7f060780);
        Context context7 = getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "context");
        this.tipColor = context7.getResources().getColor(R.color.obfuscated_res_0x7f0606e7);
        this.paint.setStrokeWidth(this.lineStrokeWidth);
        this.tipPaint.setTextSize(CommonUtilsKt.dp2px(8));
        this.tipPaint.setStrokeWidth(CommonUtilsKt.dp2px(1));
        this.tipPaint.setAntiAlias(true);
        this.tipPaint.setColor(this.tipColor);
        this.levelLinePaint.setStrokeWidth(CommonUtilsKt.dp2px(1));
        this.levelLinePaint.setStyle(Paint.Style.STROKE);
        this.levelLinePaint.setPathEffect(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f));
        this.tipLinePaint.setStrokeWidth(CommonUtilsKt.dp2px(1));
        this.tipLinePaint.setColor(this.tipColor);
        this.tipLinePaint.setStyle(Paint.Style.STROKE);
        this.tipLinePaint.setPathEffect(new DashPathEffect(new float[]{6.0f, 6.0f}, 0.0f));
    }
}
