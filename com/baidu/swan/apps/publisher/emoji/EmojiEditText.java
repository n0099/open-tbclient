package com.baidu.swan.apps.publisher.emoji;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.r0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class EmojiEditText extends AppCompatEditText {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_WORD_LIMIT = 200;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f39691e;

    /* renamed from: f  reason: collision with root package name */
    public f f39692f;

    /* renamed from: g  reason: collision with root package name */
    public String f39693g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f39694h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f39695i;

    /* renamed from: j  reason: collision with root package name */
    public int f39696j;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmojiEditText f39697e;

        public a(EmojiEditText emojiEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39697e = emojiEditText;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f39697e.b()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Editable f39698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmojiEditText f39699f;

        public b(EmojiEditText emojiEditText, Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiEditText, editable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39699f = emojiEditText;
            this.f39698e = editable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int selectionStart = this.f39699f.getSelectionStart();
                if (selectionStart > 0) {
                    this.f39698e.delete(selectionStart - 1, selectionStart);
                }
                this.f39699f.restoreClipboard();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends InputConnectionWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmojiEditText a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(EmojiEditText emojiEditText, InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiEditText, inputConnection, Boolean.valueOf(z)};
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
            this.a = emojiEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                if (i2 == 1 && i3 == 0) {
                    return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
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
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                    return super.sendKeyEvent(keyEvent);
                }
                return super.sendKeyEvent(keyEvent);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmojiEditText f39700e;

        public d(EmojiEditText emojiEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emojiEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39700e = emojiEditText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }

        public /* synthetic */ d(EmojiEditText emojiEditText, a aVar) {
            this(emojiEditText);
        }
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(int i2);

        void b(int i2);

        void onBack();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(int i2, int i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiEditText(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39696j = 200;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int scrollY = getScrollY();
            int height = getLayout().getHeight() - getHeight();
            if (height == 0) {
                return false;
            }
            return scrollY > 0 || scrollY < height - 1;
        }
        return invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f39694h = r0.b(getContext());
            setText(getText());
            setOnTouchListener(new a(this));
            addTextChangedListener(new d(this, null));
        }
    }

    public void handleDraftEmojiDisplay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Editable editableText = getEditableText();
            if (!TextUtils.isEmpty(editableText) && Pattern.compile("\\[([一-龥\\w])+\\]").matcher(editableText).find()) {
                getEditableText().replace(0, editableText.length(), c.a.p0.a.z1.h.b.c().g(getContext(), editableText, this));
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, editorInfo)) == null) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (onCreateInputConnection == null) {
                return null;
            }
            return new c(this, onCreateInputConnection, true);
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, keyEvent)) == null) {
            if (i2 != 4 || (eVar = this.f39691e) == null) {
                return false;
            }
            eVar.onBack();
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onSelectionChanged(i2, i3);
            f fVar = this.f39692f;
            if (fVar != null) {
                fVar.a(i2, i3);
            }
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, charSequence, i2, i3, i4) == null) {
            String charSequence2 = charSequence.toString();
            Matcher matcher = Pattern.compile("\\[([一-龥\\w])+]").matcher(charSequence2);
            int i5 = 0;
            while (matcher.find()) {
                i5++;
                charSequence2 = charSequence2.replace(matcher.group(), "");
            }
            int length = charSequence2.length() + i5;
            if (length <= this.f39696j) {
                e eVar = this.f39691e;
                if (eVar != null) {
                    eVar.b(length);
                    return;
                }
                return;
            }
            e eVar2 = this.f39691e;
            if (eVar2 != null) {
                eVar2.a(length);
            }
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == 16908322) {
                CharSequence a2 = this.f39694h.a();
                if (a2 == null) {
                    return super.onTextContextMenuItem(i2);
                }
                this.f39693g = a2.toString();
                this.f39694h.c(" ");
                SpannableString g2 = c.a.p0.a.z1.h.b.c().g(getContext(), this.f39693g, this);
                int selectionStart = getSelectionStart();
                Editable editableText = getEditableText();
                editableText.insert(selectionStart, g2);
                b bVar = new b(this, editableText);
                this.f39695i = bVar;
                post(bVar);
            }
            return super.onTextContextMenuItem(i2);
        }
        return invokeI.booleanValue;
    }

    public void removeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f39691e = null;
        }
    }

    public void restoreClipboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f39694h.c(this.f39693g);
        }
    }

    public void setListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.f39691e = eVar;
        }
    }

    public void setMaxSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f39696j = i2;
        }
    }

    public void setSelectListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.f39692f = fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39696j = 200;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiEditText(Context context, AttributeSet attributeSet, int i2) {
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
        this.f39696j = 200;
        c();
    }
}
