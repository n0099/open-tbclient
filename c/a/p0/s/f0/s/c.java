package c.a.p0.s.f0.s;

import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c implements SpanWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SpanGroupManager f13954e;

    /* renamed from: f  reason: collision with root package name */
    public int f13955f;

    /* renamed from: g  reason: collision with root package name */
    public int f13956g;

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
        this.f13954e = spanGroupManager;
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
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{spannable, obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (spanGroupManager = this.f13954e) == null) {
            return;
        }
        if (obj == Selection.SELECTION_END && this.f13956g != i4) {
            this.f13956g = i4;
            a q = spanGroupManager.q(i4);
            if (q instanceof TbLinkSpanGroup) {
                int f2 = q.f();
                int c2 = q.c();
                if (Math.abs(this.f13956g - c2) <= Math.abs(this.f13956g - f2)) {
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
        if (obj != Selection.SELECTION_START || this.f13955f == i4) {
            return;
        }
        this.f13955f = i4;
        a q2 = this.f13954e.q(i4);
        if (q2 instanceof TbLinkSpanGroup) {
            int f3 = q2.f();
            int c3 = q2.c();
            if (Math.abs(this.f13955f - c3) <= Math.abs(this.f13955f - f3)) {
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
