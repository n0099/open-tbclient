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
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.R;
import com.baidu.tieba.eu7;
import com.baidu.tieba.f25;
import com.baidu.tieba.fb5;
import com.baidu.tieba.p9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SpanGroupEditText extends AppCompatEditText {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EDIT_TEXT_TYPE a;
    public SpanGroupManager b;
    public View.OnKeyListener c;
    public long d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class EDIT_TEXT_TYPE {
        public static final /* synthetic */ EDIT_TEXT_TYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EDIT_TEXT_TYPE TYPE_COMMODITY;
        public static final EDIT_TEXT_TYPE TYPE_DEFAULT;
        public static final EDIT_TEXT_TYPE TYPE_PB;
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
            TYPE_PB = new EDIT_TEXT_TYPE("TYPE_PB", 1);
            EDIT_TEXT_TYPE edit_text_type = new EDIT_TEXT_TYPE("TYPE_DEFAULT", 2);
            TYPE_DEFAULT = edit_text_type;
            $VALUES = new EDIT_TEXT_TYPE[]{TYPE_COMMODITY, TYPE_PB, edit_text_type};
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (EDIT_TEXT_TYPE) Enum.valueOf(EDIT_TEXT_TYPE.class, str);
            }
            return (EDIT_TEXT_TYPE) invokeL.objValue;
        }

        public static EDIT_TEXT_TYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (EDIT_TEXT_TYPE[]) $VALUES.clone();
            }
            return (EDIT_TEXT_TYPE[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.c != null && this.a.c.onKey(this.a, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                return super.sendKeyEvent(keyEvent);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpanGroupEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040295);
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
        BdUniqueId bdUniqueId;
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
        if (context instanceof p9) {
            bdUniqueId = ((p9) context).getUniqueId();
        } else {
            bdUniqueId = null;
        }
        this.b = new SpanGroupManager(this, bdUniqueId);
    }

    public void b(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.b.k(list);
        }
    }

    public void e(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b.o(list);
        }
    }

    public void f(int i) {
        fb5 E;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (E = this.b.E(i)) != null && getText() != null) {
            this.b.delete(E.f(), E.c());
        }
    }

    public void insert(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, charSequence) != null) || getText() == null) {
            return;
        }
        getText().insert(getSelectionEnd(), charSequence);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, editorInfo)) == null) {
            return new a(this, super.onCreateInputConnection(editorInfo), true);
        }
        return (InputConnection) invokeL.objValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.d = j;
        }
    }

    public void setOnSpanGroupChangedListener(fb5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.b.W(aVar);
        }
    }

    public void setSoftKeyListener(View.OnKeyListener onKeyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onKeyListener) == null) {
            this.c = onKeyListener;
        }
    }

    public void setTransAt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.b.X(z);
        }
    }

    public void setTransLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.b.Y(z);
        }
    }

    public void setType(EDIT_TEXT_TYPE edit_text_type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, edit_text_type) == null) {
            this.a = edit_text_type;
        }
    }

    public void c() {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (spanGroupManager = this.b) != null) {
            spanGroupManager.l();
        }
    }

    public ArrayList<AtSelectData> getAtDataInText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.w();
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<String> getAtUidList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.y();
        }
        return (List) invokeV.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public String getPlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b.A();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getSelectionAfterPlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String B = this.b.B();
            if (B == null) {
                return "";
            }
            return B;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getSelectionBeforePlainTextContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String C = this.b.C();
            if (C == null) {
                return "";
            }
            return C;
        }
        return (String) invokeV.objValue;
    }

    public SpanGroupManager getSpanGroupManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    @NonNull
    public String getToServerContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String G = this.b.G();
            if (G == null) {
                return "";
            }
            return G;
        }
        return (String) invokeV.objValue;
    }

    public EDIT_TEXT_TYPE getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a;
        }
        return (EDIT_TEXT_TYPE) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b.M();
        }
        return invokeV.booleanValue;
    }

    public void i() {
        SpanGroupManager spanGroupManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (spanGroupManager = this.b) != null) {
            spanGroupManager.S();
        }
    }

    public void d(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.b.m(str, i, z);
        }
    }

    public void g(List<eu7> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, list, list2) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            eu7 eu7Var = list.get(i);
            String str = list2.get(i);
            if (!this.b.p(eu7Var.a())) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                tbLinkSpanGroup.a(getText(), getSelectionEnd(), getSelectionEnd(), (int) getTextSize());
                f25 b = f25.b(tbLinkSpanGroup, eu7Var);
                b.h = str;
                tbLinkSpanGroup.C(b.d);
                tbLinkSpanGroup.t();
                this.b.K(tbLinkSpanGroup);
            }
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, charSequence, bufferType) == null) {
            SpanGroupManager spanGroupManager = this.b;
            if (spanGroupManager != null) {
                spanGroupManager.s();
            }
            super.setText(charSequence, bufferType);
        }
    }
}
