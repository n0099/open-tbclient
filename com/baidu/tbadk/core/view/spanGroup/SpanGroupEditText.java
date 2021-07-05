package com.baidu.tbadk.core.view.spanGroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.i;
import d.a.r0.r.f0.r.a;
import d.a.r0.r.q.w;
import java.util.List;
/* loaded from: classes4.dex */
public class SpanGroupEditText extends AppCompatEditText {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EDIT_TEXT_TYPE f12719e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupManager f12720f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnKeyListener f12721g;

    /* renamed from: h  reason: collision with root package name */
    public long f12722h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class EDIT_TEXT_TYPE {
        public static final /* synthetic */ EDIT_TEXT_TYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EDIT_TEXT_TYPE TYPE_COMMODITY;
        public static final EDIT_TEXT_TYPE TYPE_DEFAULT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1844977867, "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText$EDIT_TEXT_TYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1844977867, "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText$EDIT_TEXT_TYPE;");
                    return;
                }
            }
            TYPE_COMMODITY = new EDIT_TEXT_TYPE("TYPE_COMMODITY", 0);
            EDIT_TEXT_TYPE edit_text_type = new EDIT_TEXT_TYPE("TYPE_DEFAULT", 1);
            TYPE_DEFAULT = edit_text_type;
            $VALUES = new EDIT_TEXT_TYPE[]{TYPE_COMMODITY, edit_text_type};
        }

        public EDIT_TEXT_TYPE(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EDIT_TEXT_TYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EDIT_TEXT_TYPE) Enum.valueOf(EDIT_TEXT_TYPE.class, str) : (EDIT_TEXT_TYPE) invokeL.objValue;
        }

        public static EDIT_TEXT_TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EDIT_TEXT_TYPE[]) $VALUES.clone() : (EDIT_TEXT_TYPE[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends InputConnectionWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpanGroupEditText f12723a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpanGroupEditText spanGroupEditText, InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupEditText, inputConnection, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((InputConnection) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12723a = spanGroupEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                if (i2 == 1 && i3 == 0) {
                    return sendKeyEvent(new KeyEvent(0, 67));
                }
                return super.deleteSurroundingText(i2, i3);
            }
            return invokeII.booleanValue;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
                if (this.f12723a.f12721g == null || !this.f12723a.f12721g.onKey(this.f12723a, keyEvent.getKeyCode(), keyEvent)) {
                    return super.sendKeyEvent(keyEvent);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpanGroupEditText(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b() {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (spanGroupManager = this.f12720f) == null) {
            return;
        }
        spanGroupManager.g();
    }

    public void c(int i2) {
        d.a.r0.r.f0.r.a r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (r = this.f12720f.r(i2)) == null || getText() == null) {
            return;
        }
        this.f12720f.l(r.f(), r.c());
    }

    public void d(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) || getText() == null) {
            return;
        }
        getText().insert(getSelectionEnd(), charSequence);
    }

    public void e(List<d.a.s0.a1.a> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            d.a.s0.a1.a aVar = list.get(i2);
            String str = list2.get(i2);
            if (!this.f12720f.i(aVar.a())) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                w b2 = w.b(tbLinkSpanGroup, aVar);
                b2.l = str;
                tbLinkSpanGroup.z(b2.f56077h);
                tbLinkSpanGroup.r();
                this.f12720f.v(tbLinkSpanGroup);
            }
        }
    }

    public void f() {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (spanGroupManager = this.f12720f) == null) {
            return;
        }
        spanGroupManager.B();
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12722h : invokeV.longValue;
    }

    public SpanGroupManager getSpanGroupManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12720f : (SpanGroupManager) invokeV.objValue;
    }

    public EDIT_TEXT_TYPE getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12719e : (EDIT_TEXT_TYPE) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editorInfo)) == null) ? new a(this, super.onCreateInputConnection(editorInfo), true) : (InputConnection) invokeL.objValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.f12722h = j;
        }
    }

    public void setOnSpanGroupChangedListener(a.InterfaceC1255a interfaceC1255a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interfaceC1255a) == null) {
            this.f12720f.F(interfaceC1255a);
        }
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onKeyListener) == null) {
            this.f12721g = onKeyListener;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, charSequence, bufferType) == null) {
            SpanGroupManager spanGroupManager = this.f12720f;
            if (spanGroupManager != null) {
                spanGroupManager.k();
            }
            super.setText(charSequence, bufferType);
        }
    }

    public void setTransLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f12720f.G(z);
        }
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, edit_text_type) == null) {
            this.f12719e = edit_text_type;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f12719e = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.f12722h = 0L;
        this.f12720f = new SpanGroupManager(this, context instanceof i ? ((i) context).getUniqueId() : null);
    }
}
