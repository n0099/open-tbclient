package c.a.r0.b4;

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
/* loaded from: classes3.dex */
public class b extends LinkMovementMethod {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f16172f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.f1.m.e f16173a;

    /* renamed from: b  reason: collision with root package name */
    public int f16174b;

    /* renamed from: c  reason: collision with root package name */
    public int f16175c;

    /* renamed from: d  reason: collision with root package name */
    public long f16176d;

    /* renamed from: e  reason: collision with root package name */
    public int f16177e;

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
        this.f16177e = -1;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f16172f == null) {
                f16172f = new b();
            }
            return f16172f;
        }
        return (b) invokeV.objValue;
    }

    public static boolean c(float f2, float f3, float f4, float f5, long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            return Math.abs(f4 - f2) <= 100.0f && Math.abs(f5 - f3) <= 100.0f && j3 - j2 >= j4;
        }
        return invokeCommon.booleanValue;
    }

    public final c.a.q0.f1.m.e b(TextView textView, Spannable spannable, MotionEvent motionEvent) {
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
                    c.a.q0.f1.m.e[] eVarArr = (c.a.q0.f1.m.e[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, c.a.q0.f1.m.e.class);
                    if (eVarArr == null || eVarArr.length <= 0 || eVarArr[0] == null) {
                        return null;
                    }
                    return eVarArr[0];
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return this.f16173a;
                }
            }
            return this.f16173a;
        }
        return (c.a.q0.f1.m.e) invokeLLL.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f16177e = i2;
        }
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, textView, spannable, motionEvent)) == null) {
            c.a.q0.f1.m.e b2 = b(textView, spannable, motionEvent);
            if (b2 == null && motionEvent.getAction() == 0) {
                try {
                    return super.onTouchEvent(textView, spannable, motionEvent);
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return true;
                }
            }
            if (b2 != null) {
                this.f16173a = b2;
            }
            int i2 = this.f16177e;
            if (i2 > -1) {
                this.f16173a.g(i2);
            }
            if (motionEvent.getAction() == 0) {
                this.f16174b = (int) motionEvent.getX();
                this.f16175c = (int) motionEvent.getY();
                this.f16176d = System.currentTimeMillis();
                c.a.q0.f1.m.e eVar = this.f16173a;
                if (eVar != null) {
                    eVar.h(1);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.f16173a), spannable.getSpanEnd(this.f16173a));
                }
                textView.invalidate();
            } else if (motionEvent.getAction() == 2) {
                if (this.f16173a != null && (Math.abs(this.f16174b - motionEvent.getX()) > 20.0f || Math.abs(this.f16175c - motionEvent.getY()) > 20.0f)) {
                    this.f16173a.h(2);
                    textView.invalidate();
                    Selection.removeSelection(spannable);
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                c.a.q0.f1.m.e eVar2 = this.f16173a;
                if (eVar2 != null) {
                    eVar2.h(2);
                    textView.invalidate();
                    Selection.removeSelection(spannable);
                }
                if (c(this.f16174b, this.f16175c, motionEvent.getX(), motionEvent.getY(), this.f16176d, System.currentTimeMillis(), 500L)) {
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
