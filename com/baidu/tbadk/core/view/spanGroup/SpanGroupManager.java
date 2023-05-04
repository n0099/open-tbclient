package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.a75;
import com.baidu.tieba.c75;
import com.baidu.tieba.cn7;
import com.baidu.tieba.d75;
import com.baidu.tieba.e75;
import com.baidu.tieba.y65;
import com.baidu.tieba.yq5;
import com.baidu.tieba.yx4;
import com.baidu.tieba.z65;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class SpanGroupManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextWatcher a;
    public BdUniqueId b;
    public SpanGroupEditText c;
    public LinkedList<y65> d;
    public y65 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public y65.a i;
    public za j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ChangeSpanGroupType {
        public static final /* synthetic */ ChangeSpanGroupType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ChangeSpanGroupType DEFAULT;
        public static final ChangeSpanGroupType ON_TEXT_CHANGE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(195110129, "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupManager$ChangeSpanGroupType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(195110129, "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupManager$ChangeSpanGroupType;");
                    return;
                }
            }
            DEFAULT = new ChangeSpanGroupType(EngineName.DEFAULT_ENGINE, 0);
            ChangeSpanGroupType changeSpanGroupType = new ChangeSpanGroupType("ON_TEXT_CHANGE", 1);
            ON_TEXT_CHANGE = changeSpanGroupType;
            $VALUES = new ChangeSpanGroupType[]{DEFAULT, changeSpanGroupType};
        }

        public ChangeSpanGroupType(String str, int i) {
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

        public static ChangeSpanGroupType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ChangeSpanGroupType) Enum.valueOf(ChangeSpanGroupType.class, str);
            }
            return (ChangeSpanGroupType) invokeL.objValue;
        }

        public static ChangeSpanGroupType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ChangeSpanGroupType[]) $VALUES.clone();
            }
            return (ChangeSpanGroupType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public final /* synthetic */ SpanGroupManager c;

        public a(SpanGroupManager spanGroupManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = spanGroupManager;
            this.a = -1;
            this.b = -1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.u();
                this.c.v();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (this.c.e != null) {
                    this.c.V();
                }
                this.a = Selection.getSelectionStart(charSequence);
                this.b = Selection.getSelectionEnd(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                SpanGroupManager spanGroupManager = this.c;
                spanGroupManager.n(spanGroupManager.d, this.a, this.b, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
                this.c.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SpanGroupManager spanGroupManager, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupManager, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spanGroupManager;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl urlParserResIdl;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = null;
                if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                    urlParserResIdl = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof UrlParserSocketResponseMessage) {
                    urlParserResIdl = ((UrlParserSocketResponseMessage) responsedMessage).getResponseData();
                } else {
                    urlParserResIdl = null;
                }
                if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                    RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                    str = requestUrlParserNetMessage.getUrl();
                    i = requestUrlParserNetMessage.getSpanGroupId();
                } else {
                    i = 0;
                }
                if (urlParserResIdl != null && urlParserResIdl.data != null && i != 0) {
                    e75 e75Var = new e75();
                    e75Var.a(urlParserResIdl);
                    e75Var.c = str;
                    this.a.R(e75Var, i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupManager a;

        public c(SpanGroupManager spanGroupManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spanGroupManager;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    return this.a.U();
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    public SpanGroupManager(@NonNull SpanGroupEditText spanGroupEditText, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spanGroupEditText, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
        this.d = new LinkedList<>();
        this.f = false;
        this.g = true;
        this.h = true;
        this.j = new b(this, CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        if (spanGroupEditText == null) {
            return;
        }
        this.b = bdUniqueId;
        this.c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.a);
        this.c.setEditableFactory(new z65(new a75(this)));
        this.c.setSoftKeyListener(new c(this));
        this.j.setTag(this.b);
        MessageManager.getInstance().registerListener(this.j);
    }

    public synchronized void i(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, str, i) == null) {
            synchronized (this) {
                if (this.c != null && str != null) {
                    if (I().size() > 0) {
                        for (d75 d75Var : I()) {
                            delete(d75Var.f(), d75Var.c());
                            if (d75Var.c() <= i) {
                                i = (i - d75Var.c()) + d75Var.f();
                            }
                        }
                    }
                    d75 d75Var2 = new d75(str);
                    d75Var2.a(this.c.getText(), i, d75Var2.u().length() + i, (int) this.c.getTextSize());
                    if (!yq5.g(this.c.getText(), i)) {
                        this.d.add(d75Var2);
                    }
                    d75Var2.t();
                }
            }
        }
    }

    public void K(TbLinkSpanGroup tbLinkSpanGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, tbLinkSpanGroup) == null) && this.d != null) {
            tbLinkSpanGroup.m(this.i);
            this.d.add(tbLinkSpanGroup);
        }
    }

    public void W(y65.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            this.i = aVar;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.h = z;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.g = z;
        }
    }

    public synchronized String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                LinkedList<y65> linkedList = new LinkedList<>();
                Iterator<y65> it = this.d.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.A((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c75) {
                            linkedList.add(c75.z((c75) next, spannableStringBuilder));
                        } else if (next instanceof d75) {
                            linkedList.add(d75.w((d75) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<y65> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    y65 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.r(spannableStringBuilder);
                    n(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                int selectionEnd = this.c.getSelectionEnd();
                LinkedList<y65> linkedList = new LinkedList<>();
                Iterator<y65> it = this.d.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.A((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c75) {
                            linkedList.add(c75.z((c75) next, spannableStringBuilder));
                        } else if (next instanceof d75) {
                            linkedList.add(d75.w((d75) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<y65> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    y65 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    int i = c2 - f;
                    next2.r(spannableStringBuilder);
                    int c3 = next2.c() - next2.f();
                    n(linkedList, f, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                    if (c2 <= selectionEnd) {
                        selectionEnd = (selectionEnd + c3) - i;
                    }
                }
                return spannableStringBuilder.replace(0, selectionEnd, (CharSequence) "").toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                int selectionStart = this.c.getSelectionStart();
                spannableStringBuilder.length();
                LinkedList<y65> linkedList = new LinkedList<>();
                Iterator<y65> it = this.d.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.A((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c75) {
                            linkedList.add(c75.z((c75) next, spannableStringBuilder));
                        } else if (next instanceof d75) {
                            linkedList.add(d75.w((d75) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<y65> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    y65 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    if (c2 <= selectionStart) {
                        int i = c2 - f;
                        next2.r(spannableStringBuilder);
                        int c3 = next2.c() - next2.f();
                        n(linkedList, f, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                        selectionStart = (selectionStart + c3) - i;
                    }
                }
                return spannableStringBuilder.subSequence(0, selectionStart).toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                LinkedList<y65> linkedList = new LinkedList<>();
                Iterator<y65> it = this.d.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.A((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c75) {
                            linkedList.add(c75.z((c75) next, spannableStringBuilder));
                        } else if (next instanceof d75) {
                            linkedList.add(d75.w((d75) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<y65> it2 = linkedList.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    y65 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.s(spannableStringBuilder, i);
                    n(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                    i++;
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return;
                }
                Editable text = this.c.getText();
                Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
                if (matcher.find()) {
                    String group = matcher.group();
                    String substring = group.substring(18, group.length() - 7);
                    int start = matcher.start();
                    int end = matcher.end();
                    cn7 cn7Var = null;
                    try {
                        cn7Var = cn7.g(new JSONObject(substring));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (cn7Var != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        yx4 b2 = yx4.b(tbLinkSpanGroup, cn7Var);
                        tbLinkSpanGroup.a(text, start, end, (int) this.c.getTextSize());
                        b2.h = substring;
                        tbLinkSpanGroup.C(b2.d);
                        tbLinkSpanGroup.t();
                        n(this.d, end, end, (tbLinkSpanGroup.z() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.m(this.i);
                        this.d.add(tbLinkSpanGroup);
                    }
                    t();
                }
            }
        }
    }

    public y65 D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if (next.h() && i > next.f() && i < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (y65) invokeI.objValue;
    }

    public y65 E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if (next.h() && i == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (y65) invokeI.objValue;
    }

    public LinkedList<y65> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (LinkedList) invokeV.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null && spanGroupEditText.getText().length() > 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return !ListUtils.isEmpty(x());
        }
        return invokeV.booleanValue;
    }

    public void S() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (spanGroupEditText = this.c) != null && (textWatcher = this.a) != null) {
            spanGroupEditText.removeTextChangedListener(textWatcher);
        }
    }

    public final void V() {
        y65 y65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (y65Var = this.e) != null) {
            this.f = true;
            y65Var.q(false);
            this.e.j();
            this.e.i();
            this.f = false;
            r();
        }
    }

    public void l() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (spanGroupEditText = this.c) != null && (textWatcher = this.a) != null) {
            spanGroupEditText.addTextChangedListener(textWatcher);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && !this.f && this.e != null) {
            this.e = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.d.clear();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return A();
        }
        return (String) invokeV.objValue;
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Iterator<y65> it = this.d.iterator();
            int i = 0;
            while (it.hasNext()) {
                y65 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).w() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public List<d75> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if ((next instanceof d75) && next.h()) {
                    arrayList.add((d75) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            synchronized (this) {
                Iterator<y65> it = this.d.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (!next.h()) {
                        if (this.i != null) {
                            this.i.e(next.e(), false);
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    public ArrayList<AtSelectData> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            List<c75> x = x();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (c75 c75Var : x) {
                if (c75Var != null && c75Var.w() != null) {
                    arrayList.add(c75Var.w());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<c75> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if ((next instanceof c75) && next.h()) {
                    arrayList.add((c75) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void J(String str, SpanGroupEditText.EDIT_TEXT_TYPE edit_text_type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, edit_text_type) == null) {
            if (edit_text_type == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_LINK_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", 1).param("obj_source", str));
            } else if (edit_text_type == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_PB) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_LINK_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", 2).param("obj_source", str));
            }
        }
    }

    public boolean P(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i, i2)) == null) {
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if ((next instanceof d75) && next.h()) {
                    d75 d75Var = (d75) next;
                    if (i < d75Var.f() || d75Var.c() <= i) {
                        if (i2 > d75Var.f() && d75Var.c() >= i2) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean N(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, charSequence, i)) == null) {
            if (charSequence == null || charSequence.length() == 0 || i < 0 || charSequence.charAt(i) != '\n') {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void delete(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) {
            delete(i, i2, false);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || L()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.c.getText());
        y65 D = D(selectionStart);
        y65 D2 = D(selectionEnd);
        if (D instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), D.f(), D.f());
        } else if (D2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), D2.f(), D2.f());
        }
    }

    public final boolean U() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText == null || (selectionStart = spanGroupEditText.getSelectionStart()) != this.c.getSelectionEnd()) {
                return false;
            }
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if (next.h() && next.c() == selectionStart) {
                    Selection.setSelection(this.c.getText(), next.f(), next.c());
                    this.e = next;
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (O()) {
                for (c75 c75Var : x()) {
                    if (c75Var.w() != null && c75Var.w().getUid() != null) {
                        arrayList.add(c75Var.w().getUid());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        yx4 v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int i = 0;
            if (ListUtils.isEmpty(this.d)) {
                return 0;
            }
            Iterator<y65> it = this.d.iterator();
            while (it.hasNext()) {
                y65 next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (v = ((TbLinkSpanGroup) next).v()) != null && v.b == 2) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized void R(e75 e75Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, e75Var, i) == null) {
            synchronized (this) {
                if (e75Var != null) {
                    if (e75Var.a == 1 && e75Var.b != 3) {
                        this.c.removeTextChangedListener(this.a);
                        Iterator<y65> it = this.d.iterator();
                        while (it.hasNext()) {
                            y65 next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i && (e75Var.b == 1 || e75Var.b == 2 || e75Var.b == 4 || e75Var.b == 5)) {
                                    tbLinkSpanGroup.C(e75Var.e);
                                    if (e75Var.b == 1) {
                                        tbLinkSpanGroup.D(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (e75Var.b == 2 || e75Var.b == 4 || e75Var.b == 5) {
                                        tbLinkSpanGroup.D(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    yx4.c(tbLinkSpanGroup, e75Var);
                                    if (this.i != null) {
                                        this.i.e(i, true);
                                    }
                                    int f = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.G();
                                    n(this.d, f, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                                    Q();
                                    if (e75Var.b == 5) {
                                        J(tbLinkSpanGroup.y().toString(), this.c.getType());
                                    }
                                }
                            }
                        }
                        this.c.addTextChangedListener(this.a);
                    }
                }
            }
        }
    }

    public final void T(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, str, i) == null) {
            long forumId = this.c.getForumId();
            int H = H() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.b);
            requestUrlParserNetMessage.setParams(forumId, H, str, i);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public void delete(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && !L() && i <= i2 && i < this.c.length() && i2 <= this.c.length()) {
            this.c.removeTextChangedListener(this.a);
            n(this.d, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            q();
            if (!z) {
                this.c.getText().delete(i, i2);
            }
            this.c.addTextChangedListener(this.a);
        }
    }

    public synchronized void j(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, atSelectData) == null) {
            synchronized (this) {
                if (this.c != null && atSelectData != null) {
                    c75 c75Var = new c75(atSelectData);
                    String y = c75Var.y();
                    int selectionStart = this.c.getSelectionStart();
                    int length = y.length() + selectionStart;
                    this.c.getEditableText().insert(selectionStart, y);
                    if (this.c.getText() == null || this.c.getText().length() >= length) {
                        c75Var.a(this.c.getText(), selectionStart, length, (int) this.c.getTextSize());
                        c75Var.t();
                        selectionStart = length;
                    }
                    Selection.setSelection(this.c.getText(), selectionStart);
                    this.d.add(c75Var);
                }
            }
        }
    }

    public synchronized void k(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        boolean z = false;
                        Iterator<c75> it = x().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            c75 next = it.next();
                            if (next.w() != null && next.w().getNameShow() != null && next.w().getPortrait() != null && next.w().getNameShow().equals(atSelectData.getNameShow()) && next.w().getPortrait().equals(atSelectData.getPortrait())) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j(atSelectData);
                        }
                    }
                }
            }
        }
    }

    public synchronized void m(String str, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.c != null && !TextUtils.isEmpty(str)) {
                    if (I().size() > 0) {
                        i2 = -1;
                        for (d75 d75Var : I()) {
                            int f = d75Var.f();
                            if (str.equals(d75Var.v())) {
                                if (z) {
                                    delete(d75Var.f(), d75Var.c());
                                }
                                return;
                            }
                            delete(d75Var.f(), d75Var.c());
                            i2 = f;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1 || i == -1) {
                        i = i2;
                    }
                    String u = new d75(str).u();
                    if (i == -1) {
                        i = this.c.getSelectionStart();
                    }
                    u.length();
                    this.c.getEditableText().insert(i, u);
                }
            }
        }
    }

    public synchronized void n(LinkedList<y65> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{linkedList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<y65> it = linkedList.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (next.h() && (!z || next.f() != i)) {
                        if (i <= next.f() && i2 <= next.f()) {
                            next.o(next.f() + i3);
                            next.l(next.c() + i3);
                        } else if (i <= next.f() && i2 > next.f()) {
                            next.q(false);
                        } else if (i > next.f() && i < next.c() && i2 < next.c()) {
                            next.l(next.c() + i3);
                        } else if (i > next.f() && i < next.c() && i2 >= next.c()) {
                            next.q(false);
                        } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i == i2 && Math.abs(i3) == next.c() - next.f() && next.c() <= i2 && next.c() > i2 + i3) {
                            next.q(false);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
        delete(r1.f(), r1.c());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            Iterator<c75> it = x().iterator();
            while (it.hasNext()) {
                c75 next = it.next();
                if (list != null && !list.isEmpty()) {
                    boolean z = false;
                    Iterator<AtSelectData> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        AtSelectData next2 = it2.next();
                        if (next.w() != null && next.w().getNameShow() != null && next.w().getPortrait() != null) {
                            if (next.w().getNameShow().equals(next2.getNameShow()) && next.w().getPortrait().equals(next2.getPortrait())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    delete(next.f(), next.c());
                }
            }
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        yx4 v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (!ListUtils.isEmpty(this.d) && !TextUtils.isEmpty(str)) {
                Iterator<y65> it = this.d.iterator();
                while (it.hasNext()) {
                    y65 next = it.next();
                    if (!next.h()) {
                        return false;
                    }
                    if ((next instanceof TbLinkSpanGroup) && (v = ((TbLinkSpanGroup) next).v()) != null && str.equals(v.m)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            synchronized (this) {
                if (this.c != null && this.g) {
                    Editable text = this.c.getText();
                    Matcher matcher = TbPatternsCompat.WEB_URL_END_WITH_BLANK.matcher(text);
                    if (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end() - 1;
                        int end2 = matcher.end();
                        if (end < 0) {
                            return;
                        }
                        if (N(text, end)) {
                            text.replace(end, end2, " ");
                            u();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                        tbLinkSpanGroup.a(text, start, end2, (int) this.c.getTextSize());
                        tbLinkSpanGroup.t();
                        T(subSequence.toString(), tbLinkSpanGroup.e());
                        tbLinkSpanGroup.m(this.i);
                        this.d.add(tbLinkSpanGroup);
                        u();
                    }
                }
            }
        }
    }

    public final synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            synchronized (this) {
                if (this.c != null && this.h) {
                    Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(this.c.getText());
                    if (matcher.find()) {
                        AtSelectData atSelectData = new AtSelectData(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim());
                        int start = matcher.start();
                        int end = matcher.end();
                        c75 c75Var = new c75(atSelectData);
                        this.c.getEditableText().replace(start, end, c75Var.y());
                        c75Var.a(this.c.getText(), start, c75Var.y().length() + start, (int) this.c.getTextSize());
                        c75Var.t();
                        this.d.add(c75Var);
                        v();
                    }
                }
            }
        }
    }
}
