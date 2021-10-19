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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.f0.s.a;
import c.a.q0.s.f0.s.e;
import c.a.q0.s.f0.s.f;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
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
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes6.dex */
public class SpanGroupManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f48040a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f48041b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f48042c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<c.a.q0.s.f0.s.a> f48043d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48044e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48045f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0684a f48046g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.c.g.a f48047h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.e.c.g.a f48048i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            DEFAULT = new ChangeSpanGroupType("DEFAULT", 0);
            ChangeSpanGroupType changeSpanGroupType = new ChangeSpanGroupType("ON_TEXT_CHANGE", 1);
            ON_TEXT_CHANGE = changeSpanGroupType;
            $VALUES = new ChangeSpanGroupType[]{DEFAULT, changeSpanGroupType};
        }

        public ChangeSpanGroupType(String str, int i2) {
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

        public static ChangeSpanGroupType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChangeSpanGroupType) Enum.valueOf(ChangeSpanGroupType.class, str) : (ChangeSpanGroupType) invokeL.objValue;
        }

        public static ChangeSpanGroupType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChangeSpanGroupType[]) $VALUES.clone() : (ChangeSpanGroupType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f48049e;

        /* renamed from: f  reason: collision with root package name */
        public int f48050f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f48051g;

        public a(SpanGroupManager spanGroupManager) {
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
            this.f48051g = spanGroupManager;
            this.f48049e = -1;
            this.f48050f = -1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f48051g.u();
                this.f48051g.v();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f48049e = Selection.getSelectionStart(charSequence);
                this.f48050f = Selection.getSelectionEnd(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                SpanGroupManager spanGroupManager = this.f48051g;
                spanGroupManager.m(spanGroupManager.f48043d, this.f48049e, this.f48050f, i4 - i3, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
                this.f48051g.p();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f48052a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SpanGroupManager spanGroupManager, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupManager, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48052a = spanGroupManager;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl responseData;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = null;
                if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                    responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof UrlParserSocketResponseMessage ? ((UrlParserSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                    i2 = 0;
                } else {
                    RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                    str = requestUrlParserNetMessage.getUrl();
                    i2 = requestUrlParserNetMessage.getSpanGroupId();
                }
                if (responseData == null || responseData.data == null || i2 == 0) {
                    return;
                }
                f fVar = new f();
                fVar.a(responseData);
                fVar.f13932c = str;
                this.f48052a.O(fVar, i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f48053a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SpanGroupManager spanGroupManager, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spanGroupManager, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48053a = spanGroupManager;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            DataRes dataRes;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responseData == null || (dataRes = responseData.data) == null || dataRes.thread_info == null) {
                    return;
                }
                d2 d2Var = new d2();
                d2Var.Y2(responseData.data.thread_info);
                this.f48053a.P(d2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f48054e;

        public d(SpanGroupManager spanGroupManager) {
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
            this.f48054e = spanGroupManager;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 67 && keyEvent.getAction() == 0) {
                    return this.f48054e.T();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48040a = new a(this);
        this.f48043d = new LinkedList<>();
        this.f48044e = true;
        this.f48045f = true;
        this.f48047h = new b(this, CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        this.f48048i = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        if (spanGroupEditText == null) {
            return;
        }
        this.f48041b = bdUniqueId;
        this.f48042c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.f48040a);
        this.f48042c.setEditableFactory(new c.a.q0.s.f0.s.b(new c.a.q0.s.f0.s.c(this)));
        this.f48042c.setSoftKeyListener(new d(this));
        this.f48048i.setTag(this.f48041b);
        MessageManager.getInstance().registerListener(this.f48048i);
        this.f48047h.setTag(this.f48041b);
        MessageManager.getInstance().registerListener(this.f48047h);
    }

    public synchronized String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f48042c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f48042c.getText());
                LinkedList<c.a.q0.s.f0.s.a> linkedList = new LinkedList<>();
                Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c.a.q0.s.f0.s.d) {
                            linkedList.add(c.a.q0.s.f0.s.d.w((c.a.q0.s.f0.s.d) next, spannableStringBuilder));
                        } else if (next instanceof e) {
                            linkedList.add(e.u((e) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<c.a.q0.s.f0.s.a> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    c.a.q0.s.f0.s.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    next2.p(spannableStringBuilder);
                    m(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public c.a.q0.s.f0.s.a B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if (next.h() && i2 > next.f() && i2 < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (c.a.q0.s.f0.s.a) invokeI.objValue;
    }

    public c.a.q0.s.f0.s.a C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if (next.h() && i2 == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (c.a.q0.s.f0.s.a) invokeI.objValue;
    }

    public LinkedList<c.a.q0.s.f0.s.a> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48043d : (LinkedList) invokeV.objValue;
    }

    public synchronized String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.f48042c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f48042c.getText());
                LinkedList<c.a.q0.s.f0.s.a> linkedList = new LinkedList<>();
                Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c.a.q0.s.f0.s.d) {
                            linkedList.add(c.a.q0.s.f0.s.d.w((c.a.q0.s.f0.s.d) next, spannableStringBuilder));
                        } else if (next instanceof e) {
                            linkedList.add(e.u((e) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<c.a.q0.s.f0.s.a> it2 = linkedList.iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    c.a.q0.s.f0.s.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    next2.q(spannableStringBuilder, i2);
                    m(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                    i2++;
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public final int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public List<e> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if ((next instanceof e) && next.h()) {
                    arrayList.add((e) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void H(TbLinkSpanGroup tbLinkSpanGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbLinkSpanGroup) == null) || this.f48043d == null) {
            return;
        }
        tbLinkSpanGroup.k(this.f48046g);
        this.f48043d.add(tbLinkSpanGroup);
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f48042c;
            return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean K(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, charSequence, i2)) == null) ? charSequence != null && charSequence.length() != 0 && i2 >= 0 && charSequence.charAt(i2) == '\n' : invokeLI.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !ListUtils.isEmpty(x()) : invokeV.booleanValue;
    }

    public boolean M(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if ((next instanceof e) && next.h()) {
                    e eVar = (e) next;
                    if (i2 >= eVar.f() && eVar.c() > i2) {
                        return true;
                    }
                    if (i3 > eVar.f() && eVar.c() >= i3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || I()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.f48042c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.f48042c.getText());
        c.a.q0.s.f0.s.a B = B(selectionStart);
        c.a.q0.s.f0.s.a B2 = B(selectionEnd);
        if (B instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f48042c.getText(), B.f(), B.f());
        } else if (B2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f48042c.getText(), B2.f(), B2.f());
        }
    }

    public final synchronized void O(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, fVar, i2) == null) {
            synchronized (this) {
                if (fVar != null) {
                    if (fVar.f13930a == 1 && fVar.f13931b != 3) {
                        this.f48042c.removeTextChangedListener(this.f48040a);
                        Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                        while (it.hasNext()) {
                            c.a.q0.s.f0.s.a next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i2 && (fVar.f13931b == 1 || fVar.f13931b == 2)) {
                                    tbLinkSpanGroup.z(fVar.f13934e);
                                    if (fVar.f13931b == 1) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (fVar.f13931b == 2) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    w.c(tbLinkSpanGroup, fVar);
                                    if (this.f48046g != null) {
                                        this.f48046g.a(i2, true);
                                    }
                                    int f2 = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.E();
                                    m(this.f48043d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                                    N();
                                }
                            }
                        }
                        this.f48042c.addTextChangedListener(this.f48040a);
                    }
                }
            }
        }
    }

    public final synchronized void P(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, d2Var) == null) {
            synchronized (this) {
                this.f48042c.removeTextChangedListener(this.f48040a);
                Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.u() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(d2Var.s1(), tbLinkSpanGroup.v())) {
                            String title = d2Var.getTitle();
                            if (k.isEmpty(title)) {
                                title = d2Var.o();
                            }
                            tbLinkSpanGroup.z(title);
                            int f2 = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            m(this.f48043d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                            N();
                        }
                    }
                }
                this.f48042c.addTextChangedListener(this.f48040a);
            }
        }
    }

    public void Q() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (spanGroupEditText = this.f48042c) == null || (textWatcher = this.f48040a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void R(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i2) == null) {
            long forumId = this.f48042c.getForumId();
            int F = F() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.f48041b);
            requestUrlParserNetMessage.setParams(forumId, F, str, i2);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.f48041b);
            requestGetMyPostNetMessage.setParams(c.a.e.e.m.b.g(str, 0L), 0L, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f48042c;
            if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.f48042c.getSelectionEnd()) {
                Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (next.h() && next.c() == selectionStart) {
                        Selection.setSelection(this.f48042c.getText(), next.f(), next.c());
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void U(a.InterfaceC0684a interfaceC0684a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, interfaceC0684a) == null) {
            this.f48046g = interfaceC0684a;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f48045f = z;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f48044e = z;
        }
    }

    public synchronized void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i2) == null) {
            synchronized (this) {
                if (this.f48042c != null && str != null) {
                    if (G().size() > 0) {
                        for (e eVar : G()) {
                            r(eVar.f(), eVar.c());
                            if (eVar.c() <= i2) {
                                i2 = (i2 - eVar.c()) + eVar.f();
                            }
                        }
                    }
                    e eVar2 = new e(str);
                    eVar2.a(this.f48042c.getText(), i2, eVar2.s().length() + i2, (int) this.f48042c.getTextSize());
                    if (!c.a.q0.t0.b.i(this.f48042c.getText(), i2)) {
                        this.f48043d.add(eVar2);
                    }
                    eVar2.r();
                }
            }
        }
    }

    public synchronized void i(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, atSelectData) == null) {
            synchronized (this) {
                if (this.f48042c != null && atSelectData != null) {
                    c.a.q0.s.f0.s.d dVar = new c.a.q0.s.f0.s.d(atSelectData);
                    String v = dVar.v();
                    int selectionStart = this.f48042c.getSelectionStart();
                    int length = v.length() + selectionStart;
                    this.f48042c.getEditableText().insert(selectionStart, v);
                    Selection.setSelection(this.f48042c.getText(), length);
                    dVar.a(this.f48042c.getText(), selectionStart, length, (int) this.f48042c.getTextSize());
                    dVar.r();
                    this.f48043d.add(dVar);
                }
            }
        }
    }

    public synchronized void j(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        boolean z = false;
                        Iterator<c.a.q0.s.f0.s.d> it = x().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            c.a.q0.s.f0.s.d next = it.next();
                            if (next.u() != null && next.u().getNameShow() != null && next.u().getPortrait() != null && next.u().getNameShow().equals(atSelectData.getNameShow()) && next.u().getPortrait().equals(atSelectData.getPortrait())) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i(atSelectData);
                        }
                    }
                }
            }
        }
    }

    public void k() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (spanGroupEditText = this.f48042c) == null || (textWatcher = this.f48040a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a A[Catch: all -> 0x0080, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x0009, B:10:0x0010, B:12:0x001b, B:14:0x0029, B:17:0x003f, B:20:0x004c, B:26:0x005f, B:28:0x006a, B:29:0x0070), top: B:40:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void l(String str, int i2, boolean z) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.f48042c != null && !TextUtils.isEmpty(str)) {
                    if (G().size() > 0) {
                        Iterator<e> it = G().iterator();
                        if (it.hasNext()) {
                            e next = it.next();
                            i3 = next.f();
                            if (str.equals(next.t())) {
                                if (z) {
                                    r(next.f(), next.c());
                                }
                                return;
                            }
                            r(next.f(), next.c());
                            if (i3 == -1 || i2 == -1) {
                                i2 = i3;
                            }
                            String s = new e(str).s();
                            if (i2 == -1) {
                                i2 = this.f48042c.getSelectionStart();
                            }
                            s.length();
                            this.f48042c.getEditableText().insert(i2, s);
                        }
                    }
                    i3 = -1;
                    if (i3 == -1) {
                    }
                    i2 = i3;
                    String s2 = new e(str).s();
                    if (i2 == -1) {
                    }
                    s2.length();
                    this.f48042c.getEditableText().insert(i2, s2);
                }
            }
        }
    }

    public synchronized void m(LinkedList<c.a.q0.s.f0.s.a> linkedList, int i2, int i3, int i4, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{linkedList, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<c.a.q0.s.f0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (next.h() && (!z || next.f() != i2)) {
                        if (i2 <= next.f() && i3 <= next.f()) {
                            next.m(next.f() + i4);
                            next.j(next.c() + i4);
                        } else if (i2 <= next.f() && i3 > next.f()) {
                            next.o(false);
                        } else if (i2 > next.f() && i2 < next.c() && i3 < next.c()) {
                            next.j(next.c() + i4);
                        } else if (i2 > next.f() && i2 < next.c() && i3 >= next.c()) {
                            next.o(false);
                        } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i2 == i3 && Math.abs(i4) == next.c() - next.f() && next.c() <= i3 && next.c() > i3 + i4) {
                            next.o(false);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
        r(r1.f(), r1.c());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            Iterator<c.a.q0.s.f0.s.d> it = x().iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.d next = it.next();
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
                    r(next.f(), next.c());
                }
            }
        }
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        w t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f48043d) && !TextUtils.isEmpty(str)) {
                Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                while (it.hasNext()) {
                    c.a.q0.s.f0.s.a next = it.next();
                    if (!next.h()) {
                        return false;
                    }
                    if ((next instanceof TbLinkSpanGroup) && (t = ((TbLinkSpanGroup) next).t()) != null && str.equals(t.q)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
                while (it.hasNext()) {
                    if (!it.next().h()) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f48043d.clear();
        }
    }

    public void r(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) {
            s(i2, i3, false);
        }
    }

    public void s(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || I() || i2 > i3 || i2 >= this.f48042c.length() || i3 > this.f48042c.length()) {
            return;
        }
        this.f48042c.removeTextChangedListener(this.f48040a);
        m(this.f48043d, i2, i3, i2 - i3, false, ChangeSpanGroupType.DEFAULT);
        p();
        if (!z) {
            this.f48042c.getText().delete(i2, i3);
        }
        this.f48042c.addTextChangedListener(this.f48040a);
    }

    public synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            synchronized (this) {
                if (this.f48042c == null) {
                    return;
                }
                Editable text = this.f48042c.getText();
                Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
                if (matcher.find()) {
                    String group = matcher.group();
                    String substring = group.substring(18, group.length() - 7);
                    int start = matcher.start();
                    int end = matcher.end();
                    c.a.r0.d1.a aVar = null;
                    try {
                        aVar = c.a.r0.d1.a.g(new JSONObject(substring));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (aVar != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        w b2 = w.b(tbLinkSpanGroup, aVar);
                        tbLinkSpanGroup.a(text, start, end, (int) this.f48042c.getTextSize());
                        b2.l = substring;
                        tbLinkSpanGroup.z(b2.f14356h);
                        tbLinkSpanGroup.r();
                        m(this.f48043d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.k(this.f48046g);
                        this.f48043d.add(tbLinkSpanGroup);
                    }
                    t();
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? A() : (String) invokeV.objValue;
    }

    public final synchronized void u() {
        TbLinkSpanGroup tbLinkSpanGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            synchronized (this) {
                if (this.f48042c != null && this.f48044e) {
                    Editable text = this.f48042c.getText();
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
                            u();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.f48042c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (UrlManager.getInstance().isPbUrl(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                                tbLinkSpanGroup.B(tidFromPbUrl);
                                S(tidFromPbUrl);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.f48042c.getTextSize());
                            tbLinkSpanGroup.r();
                            tbLinkSpanGroup.k(this.f48046g);
                            this.f48043d.add(tbLinkSpanGroup);
                        } else if (this.f48042c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.f48042c.getTextSize());
                            tbLinkSpanGroup2.r();
                            R(subSequence.toString(), tbLinkSpanGroup2.e());
                            tbLinkSpanGroup2.k(this.f48046g);
                            this.f48043d.add(tbLinkSpanGroup2);
                        }
                        u();
                    }
                }
            }
        }
    }

    public final synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            synchronized (this) {
                if (this.f48042c != null && this.f48045f) {
                    Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(this.f48042c.getText());
                    if (matcher.find()) {
                        AtSelectData atSelectData = new AtSelectData(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim());
                        int start = matcher.start();
                        int end = matcher.end();
                        c.a.q0.s.f0.s.d dVar = new c.a.q0.s.f0.s.d(atSelectData);
                        this.f48042c.getEditableText().replace(start, end, dVar.v());
                        dVar.a(this.f48042c.getText(), start, dVar.v().length() + start, (int) this.f48042c.getTextSize());
                        dVar.r();
                        this.f48043d.add(dVar);
                        v();
                    }
                }
            }
        }
    }

    public ArrayList<AtSelectData> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            List<c.a.q0.s.f0.s.d> x = x();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (c.a.q0.s.f0.s.d dVar : x) {
                if (dVar != null && dVar.u() != null) {
                    arrayList.add(dVar.u());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<c.a.q0.s.f0.s.d> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if ((next instanceof c.a.q0.s.f0.s.d) && next.h()) {
                    arrayList.add((c.a.q0.s.f0.s.d) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (L()) {
                for (c.a.q0.s.f0.s.d dVar : x()) {
                    if (dVar.u() != null && dVar.u().getUid() != null) {
                        arrayList.add(dVar.u().getUid());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        w t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            int i2 = 0;
            if (ListUtils.isEmpty(this.f48043d)) {
                return 0;
            }
            Iterator<c.a.q0.s.f0.s.a> it = this.f48043d.iterator();
            while (it.hasNext()) {
                c.a.q0.s.f0.s.a next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.f14354f == 2) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }
}
