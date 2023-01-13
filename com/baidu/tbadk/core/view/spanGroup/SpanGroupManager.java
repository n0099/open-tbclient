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
import com.baidu.tieba.a15;
import com.baidu.tieba.ck5;
import com.baidu.tieba.ct4;
import com.baidu.tieba.rb;
import com.baidu.tieba.u05;
import com.baidu.tieba.v05;
import com.baidu.tieba.w05;
import com.baidu.tieba.w27;
import com.baidu.tieba.y05;
import com.baidu.tieba.z05;
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
    public LinkedList<u05> d;
    public boolean e;
    public boolean f;
    public u05.a g;
    public rb h;

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
                this.c.r();
                this.c.s();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a = Selection.getSelectionStart(charSequence);
                this.b = Selection.getSelectionEnd(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                SpanGroupManager spanGroupManager = this.c;
                spanGroupManager.l(spanGroupManager.d, this.a, this.b, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
                this.c.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends rb {
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

        @Override // com.baidu.tieba.rb
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
                    a15 a15Var = new a15();
                    a15Var.a(urlParserResIdl);
                    a15Var.c = str;
                    this.a.O(a15Var, i);
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
                    return this.a.R();
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
        this.e = true;
        this.f = true;
        this.h = new b(this, CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        if (spanGroupEditText == null) {
            return;
        }
        this.b = bdUniqueId;
        this.c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.a);
        this.c.setEditableFactory(new v05(new w05(this)));
        this.c.setSoftKeyListener(new c(this));
        this.h.setTag(this.b);
        MessageManager.getInstance().registerListener(this.h);
    }

    public synchronized void g(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i) == null) {
            synchronized (this) {
                if (this.c != null && str != null) {
                    if (F().size() > 0) {
                        for (z05 z05Var : F()) {
                            delete(z05Var.f(), z05Var.c());
                            if (z05Var.c() <= i) {
                                i = (i - z05Var.c()) + z05Var.f();
                            }
                        }
                    }
                    z05 z05Var2 = new z05(str);
                    z05Var2.a(this.c.getText(), i, z05Var2.s().length() + i, (int) this.c.getTextSize());
                    if (!ck5.g(this.c.getText(), i)) {
                        this.d.add(z05Var2);
                    }
                    z05Var2.r();
                }
            }
        }
    }

    public void H(TbLinkSpanGroup tbLinkSpanGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tbLinkSpanGroup) == null) && this.d != null) {
            tbLinkSpanGroup.k(this.g);
            this.d.add(tbLinkSpanGroup);
        }
    }

    public void S(u05.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f = z;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.e = z;
        }
    }

    public u05 A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if (next.h() && i > next.f() && i < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (u05) invokeI.objValue;
    }

    public u05 B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if (next.h() && i == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (u05) invokeI.objValue;
    }

    public LinkedList<u05> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (LinkedList) invokeV.objValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null && spanGroupEditText.getText().length() > 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !ListUtils.isEmpty(u());
        }
        return invokeV.booleanValue;
    }

    public void P() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (spanGroupEditText = this.c) != null && (textWatcher = this.a) != null) {
            spanGroupEditText.removeTextChangedListener(textWatcher);
        }
    }

    public void j() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (spanGroupEditText = this.c) != null && (textWatcher = this.a) != null) {
            spanGroupEditText.addTextChangedListener(textWatcher);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.d.clear();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return x();
        }
        return (String) invokeV.objValue;
    }

    public synchronized String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                LinkedList<u05> linkedList = new LinkedList<>();
                Iterator<u05> it = this.d.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.y((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof y05) {
                            linkedList.add(y05.x((y05) next, spannableStringBuilder));
                        } else if (next instanceof z05) {
                            linkedList.add(z05.u((z05) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<u05> it2 = linkedList.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    u05 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.q(spannableStringBuilder, i);
                    l(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                    i++;
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
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
                    w27 w27Var = null;
                    try {
                        w27Var = w27.g(new JSONObject(substring));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (w27Var != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        ct4 b2 = ct4.b(tbLinkSpanGroup, w27Var);
                        tbLinkSpanGroup.a(text, start, end, (int) this.c.getTextSize());
                        b2.h = substring;
                        tbLinkSpanGroup.A(b2.d);
                        tbLinkSpanGroup.r();
                        l(this.d, end, end, (tbLinkSpanGroup.x() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.k(this.g);
                        this.d.add(tbLinkSpanGroup);
                    }
                    q();
                }
            }
        }
    }

    public synchronized String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                LinkedList<u05> linkedList = new LinkedList<>();
                Iterator<u05> it = this.d.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.y((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof y05) {
                            linkedList.add(y05.x((y05) next, spannableStringBuilder));
                        } else if (next instanceof z05) {
                            linkedList.add(z05.u((z05) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<u05> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    u05 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.p(spannableStringBuilder);
                    l(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                int selectionEnd = this.c.getSelectionEnd();
                LinkedList<u05> linkedList = new LinkedList<>();
                Iterator<u05> it = this.d.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.y((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof y05) {
                            linkedList.add(y05.x((y05) next, spannableStringBuilder));
                        } else if (next instanceof z05) {
                            linkedList.add(z05.u((z05) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<u05> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    u05 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    int i = c2 - f;
                    next2.p(spannableStringBuilder);
                    int c3 = next2.c() - next2.f();
                    l(linkedList, f, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                    if (c2 <= selectionEnd) {
                        selectionEnd = (selectionEnd + c3) - i;
                    }
                }
                return spannableStringBuilder.replace(0, selectionEnd, (CharSequence) "").toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                int selectionStart = this.c.getSelectionStart();
                spannableStringBuilder.length();
                LinkedList<u05> linkedList = new LinkedList<>();
                Iterator<u05> it = this.d.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.y((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof y05) {
                            linkedList.add(y05.x((y05) next, spannableStringBuilder));
                        } else if (next instanceof z05) {
                            linkedList.add(z05.u((z05) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<u05> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    u05 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    if (c2 <= selectionStart) {
                        int i = c2 - f;
                        next2.p(spannableStringBuilder);
                        int c3 = next2.c() - next2.f();
                        l(linkedList, f, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                        selectionStart = (selectionStart + c3) - i;
                    }
                }
                return spannableStringBuilder.subSequence(0, selectionStart).toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public final int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Iterator<u05> it = this.d.iterator();
            int i = 0;
            while (it.hasNext()) {
                u05 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public List<z05> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if ((next instanceof z05) && next.h()) {
                    arrayList.add((z05) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                Iterator<u05> it = this.d.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (!next.h()) {
                        if (this.g != null) {
                            this.g.e(next.e(), false);
                        }
                        it.remove();
                    }
                }
            }
        }
    }

    public ArrayList<AtSelectData> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            List<y05> u = u();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (y05 y05Var : u) {
                if (y05Var != null && y05Var.u() != null) {
                    arrayList.add(y05Var.u());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<y05> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if ((next instanceof y05) && next.h()) {
                    arrayList.add((y05) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void G(String str, SpanGroupEditText.EDIT_TEXT_TYPE edit_text_type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, edit_text_type) == null) {
            if (edit_text_type == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_LINK_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", 1).param("obj_source", str));
            } else if (edit_text_type == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_PB) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_LINK_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", 2).param("obj_source", str));
            }
        }
    }

    public boolean M(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if ((next instanceof z05) && next.h()) {
                    z05 z05Var = (z05) next;
                    if (i < z05Var.f() || z05Var.c() <= i) {
                        if (i2 > z05Var.f() && z05Var.c() >= i2) {
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

    public final boolean K(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, charSequence, i)) == null) {
            if (charSequence == null || charSequence.length() == 0 || i < 0 || charSequence.charAt(i) != '\n') {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void delete(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            delete(i, i2, false);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || I()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.c.getText());
        u05 A = A(selectionStart);
        u05 A2 = A(selectionEnd);
        if (A instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), A.f(), A.f());
        } else if (A2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), A2.f(), A2.f());
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText == null || (selectionStart = spanGroupEditText.getSelectionStart()) != this.c.getSelectionEnd()) {
                return false;
            }
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if (next.h() && next.c() == selectionStart) {
                    Selection.setSelection(this.c.getText(), next.f(), next.c());
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<String> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (L()) {
                for (y05 y05Var : u()) {
                    if (y05Var.u() != null && y05Var.u().getUid() != null) {
                        arrayList.add(y05Var.u().getUid());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        ct4 t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            int i = 0;
            if (ListUtils.isEmpty(this.d)) {
                return 0;
            }
            Iterator<u05> it = this.d.iterator();
            while (it.hasNext()) {
                u05 next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.b == 2) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized void O(a15 a15Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, a15Var, i) == null) {
            synchronized (this) {
                if (a15Var != null) {
                    if (a15Var.a == 1 && a15Var.b != 3) {
                        this.c.removeTextChangedListener(this.a);
                        Iterator<u05> it = this.d.iterator();
                        while (it.hasNext()) {
                            u05 next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i && (a15Var.b == 1 || a15Var.b == 2 || a15Var.b == 4 || a15Var.b == 5)) {
                                    tbLinkSpanGroup.A(a15Var.e);
                                    if (a15Var.b == 1) {
                                        tbLinkSpanGroup.B(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (a15Var.b == 2 || a15Var.b == 4 || a15Var.b == 5) {
                                        tbLinkSpanGroup.B(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    ct4.c(tbLinkSpanGroup, a15Var);
                                    if (this.g != null) {
                                        this.g.e(i, true);
                                    }
                                    int f = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.E();
                                    l(this.d, f, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                                    N();
                                    if (a15Var.b == 5) {
                                        G(tbLinkSpanGroup.w().toString(), this.c.getType());
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

    public final void Q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            long forumId = this.c.getForumId();
            int E = E() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.b);
            requestUrlParserNetMessage.setParams(forumId, E, str, i);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public void delete(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && !I() && i <= i2 && i < this.c.length() && i2 <= this.c.length()) {
            this.c.removeTextChangedListener(this.a);
            l(this.d, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            o();
            if (!z) {
                this.c.getText().delete(i, i2);
            }
            this.c.addTextChangedListener(this.a);
        }
    }

    public synchronized void h(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, atSelectData) == null) {
            synchronized (this) {
                if (this.c != null && atSelectData != null) {
                    y05 y05Var = new y05(atSelectData);
                    String w = y05Var.w();
                    int selectionStart = this.c.getSelectionStart();
                    int length = w.length() + selectionStart;
                    this.c.getEditableText().insert(selectionStart, w);
                    if (this.c.getText() == null || this.c.getText().length() >= length) {
                        y05Var.a(this.c.getText(), selectionStart, length, (int) this.c.getTextSize());
                        y05Var.r();
                        selectionStart = length;
                    }
                    Selection.setSelection(this.c.getText(), selectionStart);
                    this.d.add(y05Var);
                }
            }
        }
    }

    public synchronized void i(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        boolean z = false;
                        Iterator<y05> it = u().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            y05 next = it.next();
                            if (next.u() != null && next.u().getNameShow() != null && next.u().getPortrait() != null && next.u().getNameShow().equals(atSelectData.getNameShow()) && next.u().getPortrait().equals(atSelectData.getPortrait())) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            h(atSelectData);
                        }
                    }
                }
            }
        }
    }

    public synchronized void k(String str, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.c != null && !TextUtils.isEmpty(str)) {
                    if (F().size() > 0) {
                        i2 = -1;
                        for (z05 z05Var : F()) {
                            int f = z05Var.f();
                            if (str.equals(z05Var.t())) {
                                if (z) {
                                    delete(z05Var.f(), z05Var.c());
                                }
                                return;
                            }
                            delete(z05Var.f(), z05Var.c());
                            i2 = f;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1 || i == -1) {
                        i = i2;
                    }
                    String s = new z05(str).s();
                    if (i == -1) {
                        i = this.c.getSelectionStart();
                    }
                    s.length();
                    this.c.getEditableText().insert(i, s);
                }
            }
        }
    }

    public synchronized void l(LinkedList<u05> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{linkedList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<u05> it = linkedList.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (next.h() && (!z || next.f() != i)) {
                        if (i <= next.f() && i2 <= next.f()) {
                            next.m(next.f() + i3);
                            next.j(next.c() + i3);
                        } else if (i <= next.f() && i2 > next.f()) {
                            next.o(false);
                        } else if (i > next.f() && i < next.c() && i2 < next.c()) {
                            next.j(next.c() + i3);
                        } else if (i > next.f() && i < next.c() && i2 >= next.c()) {
                            next.o(false);
                        } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i == i2 && Math.abs(i3) == next.c() - next.f() && next.c() <= i2 && next.c() > i2 + i3) {
                            next.o(false);
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
    public void m(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            Iterator<y05> it = u().iterator();
            while (it.hasNext()) {
                y05 next = it.next();
                if (list != null && !list.isEmpty()) {
                    boolean z = false;
                    Iterator<AtSelectData> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        AtSelectData next2 = it2.next();
                        if (next.u() != null && next.u().getNameShow() != null && next.u().getPortrait() != null) {
                            if (next.u().getNameShow().equals(next2.getNameShow()) && next.u().getPortrait().equals(next2.getPortrait())) {
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

    public boolean n(String str) {
        InterceptResult invokeL;
        ct4 t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (!ListUtils.isEmpty(this.d) && !TextUtils.isEmpty(str)) {
                Iterator<u05> it = this.d.iterator();
                while (it.hasNext()) {
                    u05 next = it.next();
                    if (!next.h()) {
                        return false;
                    }
                    if ((next instanceof TbLinkSpanGroup) && (t = ((TbLinkSpanGroup) next).t()) != null && str.equals(t.m)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                if (this.c != null && this.e) {
                    Editable text = this.c.getText();
                    Matcher matcher = TbPatternsCompat.WEB_URL_END_WITH_BLANK.matcher(text);
                    if (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end() - 1;
                        int end2 = matcher.end();
                        if (end < 0) {
                            return;
                        }
                        if (K(text, end)) {
                            text.replace(end, end2, " ");
                            r();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                        tbLinkSpanGroup.a(text, start, end2, (int) this.c.getTextSize());
                        tbLinkSpanGroup.r();
                        Q(subSequence.toString(), tbLinkSpanGroup.e());
                        tbLinkSpanGroup.k(this.g);
                        this.d.add(tbLinkSpanGroup);
                        r();
                    }
                }
            }
        }
    }

    public final synchronized void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            synchronized (this) {
                if (this.c != null && this.f) {
                    Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(this.c.getText());
                    if (matcher.find()) {
                        AtSelectData atSelectData = new AtSelectData(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim());
                        int start = matcher.start();
                        int end = matcher.end();
                        y05 y05Var = new y05(atSelectData);
                        this.c.getEditableText().replace(start, end, y05Var.w());
                        y05Var.a(this.c.getText(), start, y05Var.w().length() + start, (int) this.c.getTextSize());
                        y05Var.r();
                        this.d.add(y05Var);
                        s();
                    }
                }
            }
        }
    }
}
