package b.a.r0.c4;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b extends LinkMovementMethod {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f15362f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.f1.n.f f15363a;

    /* renamed from: b  reason: collision with root package name */
    public int f15364b;

    /* renamed from: c  reason: collision with root package name */
    public int f15365c;

    /* renamed from: d  reason: collision with root package name */
    public long f15366d;

    /* renamed from: e  reason: collision with root package name */
    public int f15367e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15367e = -1;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f15362f == null) {
                f15362f = new b();
            }
            return f15362f;
        }
        return (b) invokeV.objValue;
    }

    public static boolean c(float f2, float f3, float f4, float f5, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return Math.abs(f4 - f2) <= 100.0f && Math.abs(f5 - f3) <= 100.0f && j2 - j >= j3;
        }
        return invokeCommon.booleanValue;
    }

    public final b.a.q0.f1.n.f b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, textView, spannable, motionEvent)) == null) {
            if (motionEvent != null && motionEvent.getAction() != 3) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                try {
                    Layout layout = textView.getLayout();
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                    b.a.q0.f1.n.f[] fVarArr = (b.a.q0.f1.n.f[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, b.a.q0.f1.n.f.class);
                    if (fVarArr == null || fVarArr.length <= 0 || fVarArr[0] == null) {
                        return null;
                    }
                    return fVarArr[0];
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return this.f15363a;
                }
            }
            return this.f15363a;
        }
        return (b.a.q0.f1.n.f) invokeLLL.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f15367e = i2;
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, spannable, motionEvent)) == null) {
            b.a.q0.f1.n.f b2 = b(textView, spannable, motionEvent);
            if (b2 == null && motionEvent.getAction() == 0) {
                try {
                    return super.onTouchEvent(textView, spannable, motionEvent);
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return true;
                }
            }
            if (b2 != null) {
                this.f15363a = b2;
            }
            int i2 = this.f15367e;
            if (i2 > -1) {
                this.f15363a.g(i2);
            }
            if (motionEvent.getAction() == 0) {
                this.f15364b = (int) motionEvent.getX();
                this.f15365c = (int) motionEvent.getY();
                this.f15366d = System.currentTimeMillis();
                b.a.q0.f1.n.f fVar = this.f15363a;
                if (fVar != null) {
                    fVar.h(1);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.f15363a), spannable.getSpanEnd(this.f15363a));
                }
                textView.invalidate();
            } else if (motionEvent.getAction() == 2) {
                if (this.f15363a != null && (Math.abs(this.f15364b - motionEvent.getX()) > 20.0f || Math.abs(this.f15365c - motionEvent.getY()) > 20.0f)) {
                    this.f15363a.h(2);
                    textView.invalidate();
                    Selection.removeSelection(spannable);
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                b.a.q0.f1.n.f fVar2 = this.f15363a;
                if (fVar2 != null) {
                    fVar2.h(2);
                    textView.invalidate();
                    Selection.removeSelection(spannable);
                }
                if (c(this.f15364b, this.f15365c, motionEvent.getX(), motionEvent.getY(), this.f15366d, System.currentTimeMillis(), 500L)) {
                    return true;
                }
            }
            try {
                return super.onTouchEvent(textView, spannable, motionEvent);
            } catch (Exception e3) {
                BdLog.e(e3);
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }
}
