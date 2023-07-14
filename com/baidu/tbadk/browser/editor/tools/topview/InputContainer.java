package com.baidu.tbadk.browser.editor.tools.topview;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.browser.editor.tools.topview.InputContainer;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.b85;
import com.baidu.tieba.d47;
import com.baidu.tieba.e47;
import com.baidu.tieba.hb5;
import com.baidu.tieba.jl5;
import com.baidu.tieba.mj5;
import com.baidu.tieba.nl5;
import com.baidu.tieba.rta;
import com.baidu.tieba.yd5;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
import com.baidu.tieba.zi5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001?B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u001d\u001a\u00020\u001e2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0002J\u0012\u00103\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0016J0\u00107\u001a\u00020\u001e2&\u00101\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u000209\u0018\u000108j\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u000209\u0018\u0001`:H\u0016J\u0010\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u0012H\u0016J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\tH\u0016R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/baidu/tbadk/browser/editor/tools/topview/InputContainer;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tbadk/editortools/ToolViewInterface;", "Lcom/baidu/tbadk/editortools/topview/IToolData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "inputView", "Landroid/widget/EditText;", "getInputView", "()Landroid/widget/EditText;", "isOnlyLocalEmotion", "", "mET", "Lcom/baidu/tbadk/editortools/EditorTools;", "mInputView", "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "mNeedMax", "mSendView", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "mSkinType", "mTextChangeRunnable", "Ljava/lang/Runnable;", "pasteFlag", "selection", "addAtName", "", "atSelectDataList", "Ljava/util/ArrayList;", "Lcom/baidu/tbadk/data/AtSelectData;", "Lkotlin/collections/ArrayList;", "addHotTopic", "hotTopic", "", "changeSendViewColor", CriusAttrConstants.DISPLAY, "getToolId", "hide", "init", "initInputView", "initSendView", "onAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "onAddLocalEmotion", "data", "Lcom/baidu/tbadk/coreExtra/data/EmotionItemData;", "onAddNetEmotion", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "sendAction", "setData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setEditorTools", "et", "setToolId", "id", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputContainer extends LinearLayout implements mj5, nl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public SpanGroupEditText c;
    public TBSpecificationBtn d;
    public boolean e;
    public int f;
    public final boolean g;
    public final boolean h;
    public final Runnable i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1958454723, "Lcom/baidu/tbadk/browser/editor/tools/topview/InputContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1958454723, "Lcom/baidu/tbadk/browser/editor/tools/topview/InputContainer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputContainer(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.mj5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mj5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.mj5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tieba.mj5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static final class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputContainer a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
            }
        }

        public a(InputContainer inputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i;
            boolean z;
            int i2;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                boolean z3 = false;
                if (editable != null) {
                    String obj = editable.toString();
                    int length = obj.length() - 1;
                    int i3 = 0;
                    boolean z4 = false;
                    while (i3 <= length) {
                        if (!z4) {
                            i2 = i3;
                        } else {
                            i2 = length;
                        }
                        if (Intrinsics.compare((int) obj.charAt(i2), 32) <= 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z4) {
                            if (!z2) {
                                z4 = true;
                            } else {
                                i3++;
                            }
                        } else if (!z2) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    if (obj.subSequence(i3, length + 1).toString() != null) {
                        zg.a().removeCallbacks(this.a.i);
                        zg.a().post(this.a.i);
                    }
                }
                TBSpecificationBtn tBSpecificationBtn = this.a.d;
                if (tBSpecificationBtn == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                    tBSpecificationBtn = null;
                }
                if (editable != null) {
                    String obj2 = editable.toString();
                    int length2 = obj2.length() - 1;
                    int i4 = 0;
                    boolean z5 = false;
                    while (i4 <= length2) {
                        if (!z5) {
                            i = i4;
                        } else {
                            i = length2;
                        }
                        if (Intrinsics.compare((int) obj2.charAt(i), 32) <= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z5) {
                            if (!z) {
                                z5 = true;
                            } else {
                                i4++;
                            }
                        } else if (!z) {
                            break;
                        } else {
                            length2--;
                        }
                    }
                    if (!StringUtils.isNull(obj2.subSequence(i4, length2 + 1).toString())) {
                        z3 = true;
                    }
                }
                tBSpecificationBtn.setEnabled(z3);
                this.a.k();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.a.e) {
                    return;
                }
                this.a.e = true;
                if (this.a.f != -1) {
                    SpanGroupEditText spanGroupEditText = this.a.c;
                    if (spanGroupEditText == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        spanGroupEditText = null;
                    }
                    spanGroupEditText.setSelection(this.a.f);
                    this.a.f = -1;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputContainer(Context context, AttributeSet attributeSet, int i) {
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
        this.e = true;
        this.f = -1;
        this.h = true;
        setOrientation(0);
        setMinimumHeight(yi.g(context, R.dimen.obfuscated_res_0x7f070422));
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        m(context);
        o(context);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.i = new Runnable() { // from class: com.baidu.tieba.fz4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    InputContainer.q(InputContainer.this);
                }
            }
        };
    }

    public /* synthetic */ InputContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void l(InputContainer this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Context context = this$0.getContext();
            SpanGroupEditText spanGroupEditText = this$0.c;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            yi.P(context, spanGroupEditText);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void G(zi5 action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            EditorTools editorTools = this.a;
            if (editorTools != null) {
                editorTools.D(action);
            }
        }
    }

    @Override // com.baidu.tieba.nl5
    public void setData(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, hashMap) != null) || hashMap == null) {
            return;
        }
        SpanGroupEditText spanGroupEditText = this.c;
        String str = null;
        if (spanGroupEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            spanGroupEditText = null;
        }
        Object obj = hashMap.get("inputHint");
        if (obj != null) {
            str = obj.toString();
        }
        spanGroupEditText.setHint(str);
    }

    @Override // com.baidu.tieba.mj5
    public void setEditorTools(EditorTools et) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, et) == null) {
            Intrinsics.checkNotNullParameter(et, "et");
            this.a = et;
        }
    }

    public static final boolean n(InputContainer this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (motionEvent.getAction() == 1) {
                SpanGroupEditText spanGroupEditText = null;
                this$0.G(new zi5(5, -1, null));
                SpanGroupEditText spanGroupEditText2 = this$0.c;
                if (spanGroupEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                } else {
                    spanGroupEditText = spanGroupEditText2;
                }
                spanGroupEditText.requestFocus();
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static final void p(InputContainer this$0, View view2) {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SpanGroupEditText spanGroupEditText = this$0.c;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            String valueOf = String.valueOf(spanGroupEditText.getText());
            int length = valueOf.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                if (!z2) {
                    i = i2;
                } else {
                    i = length;
                }
                if (Intrinsics.compare((int) valueOf.charAt(i), 32) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z2) {
                    if (!z) {
                        z2 = true;
                    } else {
                        i2++;
                    }
                } else if (!z) {
                    break;
                } else {
                    length--;
                }
            }
            if (Intrinsics.areEqual(valueOf.subSequence(i2, length + 1).toString(), "")) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String H = b85.H(R.string.reply_not_empty);
                Intrinsics.checkNotNullExpressionValue(H, "getString(R.string.reply_not_empty)");
                String format = String.format(H, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                yi.R(this$0.getContext(), format);
                return;
            }
            this$0.G(new zi5(8, -1, null));
        }
    }

    public static final void q(InputContainer this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            jl5 jl5Var = new jl5();
            SpanGroupEditText spanGroupEditText = this$0.c;
            SpanGroupEditText spanGroupEditText2 = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            jl5Var.a = String.valueOf(spanGroupEditText.getText());
            SpanGroupEditText spanGroupEditText3 = this$0.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                spanGroupEditText2 = spanGroupEditText3;
            }
            jl5Var.c = spanGroupEditText2.getSpanGroupManager();
            this$0.G(new zi5(4, -1, jl5Var));
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        String str2 = HotSelectActivityConfig.HOT_TOPIC_SING + str;
        Intrinsics.checkNotNullExpressionValue(str2, "builder.toString()");
        SpanGroupEditText spanGroupEditText = this.c;
        SpanGroupEditText spanGroupEditText2 = null;
        if (spanGroupEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            spanGroupEditText = null;
        }
        int selectionStart = spanGroupEditText.getSelectionStart();
        SpanGroupEditText spanGroupEditText3 = this.c;
        if (spanGroupEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
        } else {
            spanGroupEditText2 = spanGroupEditText3;
        }
        Editable text = spanGroupEditText2.getText();
        if (text != null) {
            text.insert(selectionStart, str2);
        }
    }

    public final void s(yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, yd5Var) == null) {
            if (this.g && yd5Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            SpanGroupEditText spanGroupEditText = this.c;
            SpanGroupEditText spanGroupEditText2 = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            String valueOf = String.valueOf(spanGroupEditText.getText());
            if (this.h && d47.a(valueOf) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            Context context = getContext();
            SpanGroupEditText spanGroupEditText3 = this.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                spanGroupEditText2 = spanGroupEditText3;
            }
            e47.c(context, yd5Var, spanGroupEditText2);
        }
    }

    public static final void r(InputContainer this$0, SpannableStringBuilder spannableStringBuilder) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, this$0, spannableStringBuilder) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SpanGroupEditText spanGroupEditText = this$0.c;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            spanGroupEditText.setText(spannableStringBuilder);
            SpanGroupEditText spanGroupEditText2 = this$0.c;
            if (spanGroupEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText2 = null;
            }
            SpanGroupEditText spanGroupEditText3 = this$0.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText3 = null;
            }
            Editable text = spanGroupEditText3.getText();
            if (text != null) {
                i = text.length();
            } else {
                i = 0;
            }
            spanGroupEditText2.setSelection(i);
            this$0.G(new zi5(5, -1, null));
            this$0.requestFocus();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v33, types: [com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn] */
    @Override // com.baidu.tieba.aj5
    public void B(zi5 zi5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zi5Var) != null) || zi5Var == null) {
            return;
        }
        int i = zi5Var.a;
        SpanGroupEditText spanGroupEditText = null;
        if (i != 3) {
            if (i != 6) {
                if (i != 9) {
                    if (i != 17) {
                        if (i != 24) {
                            if (i == 44 && (obj = zi5Var.c) != null) {
                                if (obj instanceof String) {
                                    if (obj != null) {
                                        j((String) obj);
                                        return;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                } else if (obj instanceof jl5) {
                                    if (obj != null) {
                                        if (((jl5) obj).a != null) {
                                            if (obj != null) {
                                                String hotTopic = ((jl5) obj).a;
                                                Intrinsics.checkNotNullExpressionValue(hotTopic, "hotTopic");
                                                j(hotTopic);
                                                return;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.pb.SubPbInputContentData");
                                        }
                                        return;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.editortools.pb.SubPbInputContentData");
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        Object obj2 = zi5Var.c;
                        if (obj2 instanceof yd5) {
                            if (obj2 != null) {
                                yd5 yd5Var = (yd5) obj2;
                                if (yd5Var.getType() == EmotionGroupType.NET_SUG) {
                                    t(yd5Var);
                                    return;
                                } else {
                                    s(yd5Var);
                                    return;
                                }
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.coreExtra.data.EmotionItemData");
                        }
                        return;
                    }
                    Object obj3 = zi5Var.c;
                    if (obj3 instanceof ArrayList) {
                        if (obj3 != null) {
                            i((ArrayList) obj3);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.baidu.tbadk.data.AtSelectData>{ kotlin.collections.TypeAliasesKt.ArrayList<com.baidu.tbadk.data.AtSelectData> }");
                    }
                    return;
                }
                Object obj4 = zi5Var.c;
                if (obj4 != null) {
                    if (((Boolean) obj4).booleanValue()) {
                        SpanGroupEditText spanGroupEditText2 = this.c;
                        if (spanGroupEditText2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                            spanGroupEditText2 = null;
                        }
                        spanGroupEditText2.setText((CharSequence) null);
                    }
                    ?? r7 = this.d;
                    if (r7 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                    } else {
                        spanGroupEditText = r7;
                    }
                    spanGroupEditText.setEnabled(false);
                    k();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            Object obj5 = zi5Var.c;
            if (obj5 == null) {
                SpanGroupEditText spanGroupEditText3 = this.c;
                if (spanGroupEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText3 = null;
                }
                spanGroupEditText3.setText((CharSequence) null);
                return;
            } else if (obj5 instanceof String) {
                if (obj5 != null) {
                    if (TextUtils.isEmpty((String) obj5)) {
                        SpanGroupEditText spanGroupEditText4 = this.c;
                        if (spanGroupEditText4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                            spanGroupEditText4 = null;
                        }
                        spanGroupEditText4.setText((CharSequence) null);
                        return;
                    }
                    Context context = getContext();
                    Object obj6 = zi5Var.c;
                    if (obj6 != null) {
                        e47.h(context, (String) obj6, new e47.i() { // from class: com.baidu.tieba.iz4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.baidu.tieba.e47.i
                            public final void a(SpannableStringBuilder spannableStringBuilder) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder) == null) {
                                    InputContainer.r(InputContainer.this, spannableStringBuilder);
                                }
                            }
                        });
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else {
                return;
            }
        }
        SpanGroupEditText spanGroupEditText5 = this.c;
        if (spanGroupEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            spanGroupEditText5 = null;
        }
        if (spanGroupEditText5.getSelectionStart() > 0) {
            SpanGroupEditText spanGroupEditText6 = this.c;
            if (spanGroupEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText6 = null;
            }
            String valueOf = String.valueOf(spanGroupEditText6.getText());
            SpanGroupEditText spanGroupEditText7 = this.c;
            if (spanGroupEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText7 = null;
            }
            String substring = valueOf.substring(0, spanGroupEditText7.getSelectionStart());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Matcher matcher = d47.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                SpanGroupEditText spanGroupEditText8 = this.c;
                if (spanGroupEditText8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText8 = null;
                }
                Editable text = spanGroupEditText8.getText();
                if (text != null) {
                    SpanGroupEditText spanGroupEditText9 = this.c;
                    if (spanGroupEditText9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        spanGroupEditText9 = null;
                    }
                    int selectionStart = spanGroupEditText9.getSelectionStart() - length;
                    SpanGroupEditText spanGroupEditText10 = this.c;
                    if (spanGroupEditText10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    } else {
                        spanGroupEditText = spanGroupEditText10;
                    }
                    text.delete(selectionStart, spanGroupEditText.getSelectionStart());
                    return;
                }
                return;
            }
            SpanGroupEditText spanGroupEditText11 = this.c;
            if (spanGroupEditText11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText11 = null;
            }
            Editable text2 = spanGroupEditText11.getText();
            if (text2 != null) {
                SpanGroupEditText spanGroupEditText12 = this.c;
                if (spanGroupEditText12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText12 = null;
                }
                int selectionStart2 = spanGroupEditText12.getSelectionStart() - 1;
                SpanGroupEditText spanGroupEditText13 = this.c;
                if (spanGroupEditText13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                } else {
                    spanGroupEditText = spanGroupEditText13;
                }
                text2.delete(selectionStart2, spanGroupEditText.getSelectionStart());
            }
        }
    }

    @Override // com.baidu.tieba.mj5
    public void display() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getVisibility() == 0) {
            SpanGroupEditText spanGroupEditText = this.c;
            SpanGroupEditText spanGroupEditText2 = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            spanGroupEditText.setFocusable(true);
            SpanGroupEditText spanGroupEditText3 = this.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText3 = null;
            }
            spanGroupEditText3.setFocusableInTouchMode(true);
            SpanGroupEditText spanGroupEditText4 = this.c;
            if (spanGroupEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                spanGroupEditText2 = spanGroupEditText4;
            }
            spanGroupEditText2.requestFocus();
            zg.a().postDelayed(new Runnable() { // from class: com.baidu.tieba.hz4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        InputContainer.l(InputContainer.this);
                    }
                }
            }, 200L);
        }
    }

    public final EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                return null;
            }
            return spanGroupEditText;
        }
        return (EditText) invokeV.objValue;
    }

    public final void i(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            SpanGroupEditText spanGroupEditText2 = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            int selectionStart = spanGroupEditText.getSelectionStart();
            if (selectionStart > 0) {
                SpanGroupEditText spanGroupEditText3 = this.c;
                if (spanGroupEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText3 = null;
                }
                int i = selectionStart - 1;
                if (String.valueOf(spanGroupEditText3.getText()).charAt(i) == '@') {
                    SpanGroupEditText spanGroupEditText4 = this.c;
                    if (spanGroupEditText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        spanGroupEditText4 = null;
                    }
                    spanGroupEditText4.getEditableText().delete(i, selectionStart);
                }
            }
            SpanGroupEditText spanGroupEditText5 = this.c;
            if (spanGroupEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText5 = null;
            }
            spanGroupEditText5.e(arrayList);
            if (arrayList != null && arrayList.size() > 0) {
                SpanGroupEditText spanGroupEditText6 = this.c;
                if (spanGroupEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText6 = null;
                }
                Editable text = spanGroupEditText6.getText();
                if (text != null) {
                    SpanGroupEditText spanGroupEditText7 = this.c;
                    if (spanGroupEditText7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        spanGroupEditText7 = null;
                    }
                    int selectionStart2 = spanGroupEditText7.getSelectionStart();
                    SpanGroupEditText spanGroupEditText8 = this.c;
                    if (spanGroupEditText8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                        spanGroupEditText8 = null;
                    }
                    text.delete(selectionStart2, spanGroupEditText8.getSelectionEnd());
                }
                SpanGroupEditText spanGroupEditText9 = this.c;
                if (spanGroupEditText9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                } else {
                    spanGroupEditText2 = spanGroupEditText9;
                }
                spanGroupEditText2.b(arrayList);
            }
        }
    }

    public final void t(yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, yd5Var) == null) && yd5Var != null && !TextUtils.isEmpty(yd5Var.d()) && !TextUtils.isEmpty(yd5Var.g())) {
            SpanGroupEditText spanGroupEditText = this.c;
            SpanGroupEditText spanGroupEditText2 = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            String valueOf = String.valueOf(spanGroupEditText.getText());
            if (this.h && d47.a(valueOf) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            Context context = getContext();
            SpanGroupEditText spanGroupEditText3 = this.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                spanGroupEditText2 = spanGroupEditText3;
            }
            e47.d(context, yd5Var, spanGroupEditText2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.d;
            TBSpecificationBtn tBSpecificationBtn2 = null;
            if (tBSpecificationBtn == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                tBSpecificationBtn = null;
            }
            if (tBSpecificationBtn.isEnabled()) {
                TBSpecificationBtn tBSpecificationBtn3 = this.d;
                if (tBSpecificationBtn3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                } else {
                    tBSpecificationBtn2 = tBSpecificationBtn3;
                }
                SkinManager.setViewTextColor(tBSpecificationBtn2, R.color.CAM_X0302, 1, this.b);
                return;
            }
            TBSpecificationBtn tBSpecificationBtn4 = this.d;
            if (tBSpecificationBtn4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
            } else {
                tBSpecificationBtn2 = tBSpecificationBtn4;
            }
            SkinManager.setViewTextColor(tBSpecificationBtn2, R.color.CAM_X0107, 1);
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.c = spanGroupEditText;
            View view2 = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X006));
            SpanGroupEditText spanGroupEditText2 = this.c;
            if (spanGroupEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText2 = null;
            }
            spanGroupEditText2.setMaxLines(4);
            SpanGroupEditText spanGroupEditText3 = this.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText3 = null;
            }
            spanGroupEditText3.setMinLines(2);
            SpanGroupEditText spanGroupEditText4 = this.c;
            if (spanGroupEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText4 = null;
            }
            spanGroupEditText4.setGravity(48);
            SpanGroupEditText spanGroupEditText5 = this.c;
            if (spanGroupEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText5 = null;
            }
            spanGroupEditText5.setIncludeFontPadding(false);
            SpanGroupEditText spanGroupEditText6 = this.c;
            if (spanGroupEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText6 = null;
            }
            spanGroupEditText6.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            SpanGroupEditText spanGroupEditText7 = this.c;
            if (spanGroupEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText7 = null;
            }
            spanGroupEditText7.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SpanGroupEditText spanGroupEditText8 = this.c;
            if (spanGroupEditText8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText8 = null;
            }
            spanGroupEditText8.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SpanGroupEditText spanGroupEditText9 = this.c;
            if (spanGroupEditText9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText9 = null;
            }
            rta.l(spanGroupEditText9, R.drawable.edittext_cursor);
            SpanGroupEditText spanGroupEditText10 = this.c;
            if (spanGroupEditText10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText10 = null;
            }
            spanGroupEditText10.setLineSpacing(yi.g(context, R.dimen.M_T_X002), 1.0f);
            SpanGroupEditText spanGroupEditText11 = this.c;
            if (spanGroupEditText11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText11 = null;
            }
            spanGroupEditText11.setPadding(yi.g(context, R.dimen.M_W_X006), yi.g(context, R.dimen.M_H_X004), yi.g(context, R.dimen.M_W_X006), yi.g(context, R.dimen.M_H_X004));
            InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(2000)};
            SpanGroupEditText spanGroupEditText12 = this.c;
            if (spanGroupEditText12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText12 = null;
            }
            spanGroupEditText12.setFilters(inputFilterArr);
            SpanGroupEditText spanGroupEditText13 = this.c;
            if (spanGroupEditText13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText13 = null;
            }
            spanGroupEditText13.addTextChangedListener(new a(this));
            SpanGroupEditText spanGroupEditText14 = this.c;
            if (spanGroupEditText14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText14 = null;
            }
            spanGroupEditText14.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.dz4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) ? InputContainer.n(InputContainer.this, view3, motionEvent) : invokeLL.booleanValue;
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(yi.g(context, R.dimen.M_W_X010), yi.g(context, R.dimen.M_H_X002), yi.g(context, R.dimen.M_W_X008), yi.g(context, R.dimen.M_H_X002));
            View view3 = this.c;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            hb5 hb5Var = new hb5();
            hb5Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.d = tBSpecificationBtn;
            TBSpecificationBtn tBSpecificationBtn2 = null;
            if (tBSpecificationBtn == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                tBSpecificationBtn = null;
            }
            tBSpecificationBtn.setConfig(hb5Var);
            TBSpecificationBtn tBSpecificationBtn3 = this.d;
            if (tBSpecificationBtn3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                tBSpecificationBtn3 = null;
            }
            tBSpecificationBtn3.setEnabled(false);
            TBSpecificationBtn tBSpecificationBtn4 = this.d;
            if (tBSpecificationBtn4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                tBSpecificationBtn4 = null;
            }
            tBSpecificationBtn4.setTextSize(R.dimen.T_X08);
            TBSpecificationBtn tBSpecificationBtn5 = this.d;
            if (tBSpecificationBtn5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                tBSpecificationBtn5 = null;
            }
            tBSpecificationBtn5.setText(context.getString(R.string.pb_send_post));
            TBSpecificationBtn tBSpecificationBtn6 = this.d;
            if (tBSpecificationBtn6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
                tBSpecificationBtn6 = null;
            }
            tBSpecificationBtn6.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gz4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        InputContainer.p(InputContainer.this, view2);
                    }
                }
            });
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(yi.g(context, R.dimen.tbds167), yi.g(context, R.dimen.tbds80));
            layoutParams2.rightMargin = yi.g(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = yi.g(context, R.dimen.M_H_X002);
            TBSpecificationBtn tBSpecificationBtn7 = this.d;
            if (tBSpecificationBtn7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
            } else {
                tBSpecificationBtn2 = tBSpecificationBtn7;
            }
            linearLayout.addView(tBSpecificationBtn2, layoutParams2);
            addView(linearLayout, layoutParams);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b = i;
            SpanGroupEditText spanGroupEditText = this.c;
            TBSpecificationBtn tBSpecificationBtn = null;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText = null;
            }
            spanGroupEditText.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SpanGroupEditText spanGroupEditText2 = this.c;
            if (spanGroupEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText2 = null;
            }
            SkinManager.setViewTextColor(spanGroupEditText2, R.color.CAM_X0105, 2, i);
            DrawableSelector radius = TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i).setShape(0).radius(yi.g(getContext(), R.dimen.tbds21));
            SpanGroupEditText spanGroupEditText3 = this.c;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                spanGroupEditText3 = null;
            }
            radius.into(spanGroupEditText3);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
            if (i == 0) {
                SpanGroupEditText spanGroupEditText4 = this.c;
                if (spanGroupEditText4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText4 = null;
                }
                rta.l(spanGroupEditText4, R.drawable.edittext_cursor);
                SpanGroupEditText spanGroupEditText5 = this.c;
                if (spanGroupEditText5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText5 = null;
                }
                spanGroupEditText5.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            } else {
                SpanGroupEditText spanGroupEditText6 = this.c;
                if (spanGroupEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText6 = null;
                }
                rta.l(spanGroupEditText6, R.drawable.edittext_cursor_2);
                SpanGroupEditText spanGroupEditText7 = this.c;
                if (spanGroupEditText7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputView");
                    spanGroupEditText7 = null;
                }
                spanGroupEditText7.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.d;
            if (tBSpecificationBtn2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSendView");
            } else {
                tBSpecificationBtn = tBSpecificationBtn2;
            }
            tBSpecificationBtn.l(i);
        }
    }
}
