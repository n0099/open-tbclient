package com.baidu.tbadk.core.view.spanGroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e9;
import com.repackage.hs6;
import com.repackage.rv4;
import com.repackage.wo4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SpanGroupEditText extends AppCompatEditText {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EDIT_TEXT_TYPE a;
    public SpanGroupManager b;
    public View.OnKeyListener c;
    public long d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public EDIT_TEXT_TYPE(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public class a extends InputConnectionWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupEditText a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpanGroupEditText spanGroupEditText, InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupEditText, inputConnection, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((InputConnection) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spanGroupEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                if (i == 1 && i2 == 0) {
                    return sendKeyEvent(new KeyEvent(0, 67));
                }
                return super.deleteSurroundingText(i, i2);
            }
            return invokeII.booleanValue;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
                if (this.a.c == null || !this.a.c.onKey(this.a, keyEvent.getKeyCode(), keyEvent)) {
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
    }

    public void b(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.b.j(list);
        }
    }

    public void c() {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (spanGroupManager = this.b) == null) {
            return;
        }
        spanGroupManager.k();
    }

    public void d(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.b.l(str, i, z);
        }
    }

    public void e(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b.n(list);
        }
    }

    public void f(int i) {
        rv4 C;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (C = this.b.C(i)) == null || getText() == null) {
            return;
        }
        this.b.delete(C.f(), C.c());
    }

    public void g(List<hs6> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, list, list2) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            hs6 hs6Var = list.get(i);
            String str = list2.get(i);
            if (!this.b.o(hs6Var.a())) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                wo4 b = wo4.b(tbLinkSpanGroup, hs6Var);
                b.h = str;
                tbLinkSpanGroup.z(b.d);
                tbLinkSpanGroup.r();
                this.b.H(tbLinkSpanGroup);
            }
        }
    }

    public ArrayList<AtSelectData> getAtDataInText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b.u() : (ArrayList) invokeV.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : invokeV.longValue;
    }

    public String getPlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b.y() : (String) invokeV.objValue;
    }

    @NonNull
    public String getSelectionAfterPlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String z = this.b.z();
            return z == null ? "" : z;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getSelectionBeforePlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String A = this.b.A();
            return A == null ? "" : A;
        }
        return (String) invokeV.objValue;
    }

    public SpanGroupManager getSpanGroupManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b : (SpanGroupManager) invokeV.objValue;
    }

    @NonNull
    public String getToServerContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String E = this.b.E();
            return E == null ? "" : E;
        }
        return (String) invokeV.objValue;
    }

    public EDIT_TEXT_TYPE getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (EDIT_TEXT_TYPE) invokeV.objValue;
    }

    public void h() {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (spanGroupManager = this.b) == null) {
            return;
        }
        spanGroupManager.P();
    }

    public void insert(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, charSequence) == null) || getText() == null) {
            return;
        }
        getText().insert(getSelectionEnd(), charSequence);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, editorInfo)) == null) ? new a(this, super.onCreateInputConnection(editorInfo), true) : (InputConnection) invokeL.objValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.d = j;
        }
    }

    public void setOnSpanGroupChangedListener(rv4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.b.T(aVar);
        }
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onKeyListener) == null) {
            this.c = onKeyListener;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, charSequence, bufferType) == null) {
            SpanGroupManager spanGroupManager = this.b;
            if (spanGroupManager != null) {
                spanGroupManager.q();
            }
            super.setText(charSequence, bufferType);
        }
    }

    public void setTransAt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.b.U(z);
        }
    }

    public void setTransLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.b.V(z);
        }
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, edit_text_type) == null) {
            this.a = edit_text_type;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040214);
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpanGroupEditText(Context context, AttributeSet attributeSet, int i) {
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
        this.a = EDIT_TEXT_TYPE.TYPE_DEFAULT;
        this.d = 0L;
        this.b = new SpanGroupManager(this, context instanceof e9 ? ((e9) context).getUniqueId() : null);
    }
}
