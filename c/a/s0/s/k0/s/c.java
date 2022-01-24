package c.a.s0.s.k0.s;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c implements SpanWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SpanGroupManager f13339e;

    /* renamed from: f  reason: collision with root package name */
    public int f13340f;

    /* renamed from: g  reason: collision with root package name */
    public int f13341g;

    public c(@NonNull SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spanGroupManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13339e = spanGroupManager;
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, spannable, obj, i2, i3) == null) {
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{spannable, obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (spanGroupManager = this.f13339e) == null) {
            return;
        }
        if (obj == Selection.SELECTION_END && this.f13341g != i4) {
            this.f13341g = i4;
            a B = spanGroupManager.B(i4);
            if (B != null) {
                int f2 = B.f();
                int c2 = B.c();
                if (Math.abs(this.f13341g - c2) <= Math.abs(this.f13341g - f2)) {
                    f2 = c2;
                }
                int selectionStart = Selection.getSelectionStart(spannable);
                if (selectionStart > spannable.length()) {
                    selectionStart = spannable.length();
                }
                if (f2 > spannable.length()) {
                    f2 = spannable.length();
                }
                Selection.setSelection(spannable, selectionStart, f2);
            }
        }
        if (obj != Selection.SELECTION_START || this.f13340f == i4) {
            return;
        }
        this.f13340f = i4;
        a B2 = this.f13339e.B(i4);
        if (B2 != null) {
            int f3 = B2.f();
            int c3 = B2.c();
            if (Math.abs(this.f13340f - c3) <= Math.abs(this.f13340f - f3)) {
                f3 = c3;
            }
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (selectionEnd > spannable.length()) {
                selectionEnd = spannable.length();
            }
            if (f3 > spannable.length()) {
                f3 = spannable.length();
            }
            Selection.setSelection(spannable, f3, selectionEnd);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_SEND_USER_MSG, this, spannable, obj, i2, i3) == null) {
        }
    }
}
