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
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.l0.s.a;
import c.a.o0.r.l0.s.e;
import c.a.o0.r.l0.s.f;
import c.a.o0.r.r.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class SpanGroupManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextWatcher a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f30291b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f30292c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<c.a.o0.r.l0.s.a> f30293d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30294e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30295f;

    /* renamed from: g  reason: collision with root package name */
    public a.InterfaceC0831a f30296g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.g.a f30297h;
    public c.a.d.c.g.a i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChangeSpanGroupType) Enum.valueOf(ChangeSpanGroupType.class, str) : (ChangeSpanGroupType) invokeL.objValue;
        }

        public static ChangeSpanGroupType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChangeSpanGroupType[]) $VALUES.clone() : (ChangeSpanGroupType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f30298b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f30299c;

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
            this.f30299c = spanGroupManager;
            this.a = -1;
            this.f30298b = -1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f30299c.s();
                this.f30299c.t();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a = Selection.getSelectionStart(charSequence);
                this.f30298b = Selection.getSelectionEnd(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                SpanGroupManager spanGroupManager = this.f30299c;
                spanGroupManager.m(spanGroupManager.f30293d, this.a, this.f30298b, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
                this.f30299c.p();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends c.a.d.c.g.a {
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

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl responseData;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = null;
                if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                    responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof UrlParserSocketResponseMessage ? ((UrlParserSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                    i = 0;
                } else {
                    RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                    str = requestUrlParserNetMessage.getUrl();
                    i = requestUrlParserNetMessage.getSpanGroupId();
                }
                if (responseData == null || responseData.data == null || i == 0) {
                    return;
                }
                f fVar = new f();
                fVar.a(responseData);
                fVar.f10691c = str;
                this.a.N(fVar, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SpanGroupManager spanGroupManager, int i, int i2) {
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

        @Override // c.a.d.c.g.a
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
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(responseData.data.thread_info);
                this.a.O(threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpanGroupManager a;

        public d(SpanGroupManager spanGroupManager) {
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
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i, keyEvent)) == null) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    return this.a.S();
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
        this.f30293d = new LinkedList<>();
        this.f30294e = true;
        this.f30295f = true;
        this.f30297h = new b(this, CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        this.i = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        if (spanGroupEditText == null) {
            return;
        }
        this.f30291b = bdUniqueId;
        this.f30292c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.a);
        this.f30292c.setEditableFactory(new c.a.o0.r.l0.s.b(new c.a.o0.r.l0.s.c(this)));
        this.f30292c.setSoftKeyListener(new d(this));
        this.i.setTag(this.f30291b);
        MessageManager.getInstance().registerListener(this.i);
        this.f30297h.setTag(this.f30291b);
        MessageManager.getInstance().registerListener(this.f30297h);
    }

    public synchronized String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f30292c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f30292c.getText());
                int selectionStart = this.f30292c.getSelectionStart();
                spannableStringBuilder.length();
                LinkedList<c.a.o0.r.l0.s.a> linkedList = new LinkedList<>();
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c.a.o0.r.l0.s.d) {
                            linkedList.add(c.a.o0.r.l0.s.d.w((c.a.o0.r.l0.s.d) next, spannableStringBuilder));
                        } else if (next instanceof e) {
                            linkedList.add(e.u((e) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<c.a.o0.r.l0.s.a> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    c.a.o0.r.l0.s.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    if (c2 <= selectionStart) {
                        int i = c2 - f2;
                        next2.p(spannableStringBuilder);
                        int c3 = next2.c() - next2.f();
                        m(linkedList, f2, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                        selectionStart = (selectionStart + c3) - i;
                    }
                }
                return spannableStringBuilder.subSequence(0, selectionStart).toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public c.a.o0.r.l0.s.a B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if (next.h() && i > next.f() && i < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (c.a.o0.r.l0.s.a) invokeI.objValue;
    }

    public c.a.o0.r.l0.s.a C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if (next.h() && i == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (c.a.o0.r.l0.s.a) invokeI.objValue;
    }

    public LinkedList<c.a.o0.r.l0.s.a> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30293d : (LinkedList) invokeV.objValue;
    }

    public synchronized String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.f30292c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f30292c.getText());
                LinkedList<c.a.o0.r.l0.s.a> linkedList = new LinkedList<>();
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c.a.o0.r.l0.s.d) {
                            linkedList.add(c.a.o0.r.l0.s.d.w((c.a.o0.r.l0.s.d) next, spannableStringBuilder));
                        } else if (next instanceof e) {
                            linkedList.add(e.u((e) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<c.a.o0.r.l0.s.a> it2 = linkedList.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    c.a.o0.r.l0.s.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    next2.q(spannableStringBuilder, i);
                    m(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                    i++;
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
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            int i = 0;
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public List<e> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbLinkSpanGroup) == null) || this.f30293d == null) {
            return;
        }
        tbLinkSpanGroup.k(this.f30296g);
        this.f30293d.add(tbLinkSpanGroup);
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f30292c;
            return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean J(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, charSequence, i)) == null) ? charSequence != null && charSequence.length() != 0 && i >= 0 && charSequence.charAt(i) == '\n' : invokeLI.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !ListUtils.isEmpty(v()) : invokeV.booleanValue;
    }

    public boolean L(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if ((next instanceof e) && next.h()) {
                    e eVar = (e) next;
                    if (i >= eVar.f() && eVar.c() > i) {
                        return true;
                    }
                    if (i2 > eVar.f() && eVar.c() >= i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || I()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.f30292c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.f30292c.getText());
        c.a.o0.r.l0.s.a B = B(selectionStart);
        c.a.o0.r.l0.s.a B2 = B(selectionEnd);
        if (B instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f30292c.getText(), B.f(), B.f());
        } else if (B2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f30292c.getText(), B2.f(), B2.f());
        }
    }

    public final synchronized void N(f fVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, fVar, i) == null) {
            synchronized (this) {
                if (fVar != null) {
                    if (fVar.a == 1 && fVar.f10690b != 3) {
                        this.f30292c.removeTextChangedListener(this.a);
                        Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                        while (it.hasNext()) {
                            c.a.o0.r.l0.s.a next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i && (fVar.f10690b == 1 || fVar.f10690b == 2)) {
                                    tbLinkSpanGroup.z(fVar.f10693e);
                                    if (fVar.f10690b == 1) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (fVar.f10690b == 2) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    w.c(tbLinkSpanGroup, fVar);
                                    if (this.f30296g != null) {
                                        this.f30296g.a(i, true);
                                    }
                                    int f2 = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.E();
                                    m(this.f30293d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                                    M();
                                }
                            }
                        }
                        this.f30292c.addTextChangedListener(this.a);
                    }
                }
            }
        }
    }

    public final synchronized void O(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) {
            synchronized (this) {
                this.f30292c.removeTextChangedListener(this.a);
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.u() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(threadData.getTid(), tbLinkSpanGroup.v())) {
                            String title = threadData.getTitle();
                            if (m.isEmpty(title)) {
                                title = threadData.getAbstract();
                            }
                            tbLinkSpanGroup.z(title);
                            int f2 = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            m(this.f30293d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                            M();
                        }
                    }
                }
                this.f30292c.addTextChangedListener(this.a);
            }
        }
    }

    public void P() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (spanGroupEditText = this.f30292c) == null || (textWatcher = this.a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void Q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) {
            long forumId = this.f30292c.getForumId();
            int F = F() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.f30291b);
            requestUrlParserNetMessage.setParams(forumId, F, str, i);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            int k = n.k(TbadkCoreApplication.getInst());
            int i = n.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.f30291b);
            requestGetMyPostNetMessage.setParams(c.a.d.f.m.b.g(str, 0L), 0L, 0L, k, i, f2, i2);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f30292c;
            if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.f30292c.getSelectionEnd()) {
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.h() && next.c() == selectionStart) {
                        Selection.setSelection(this.f30292c.getText(), next.f(), next.c());
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T(a.InterfaceC0831a interfaceC0831a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, interfaceC0831a) == null) {
            this.f30296g = interfaceC0831a;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f30295f = z;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f30294e = z;
        }
    }

    public void delete(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || I() || i > i2 || i >= this.f30292c.length() || i2 > this.f30292c.length()) {
            return;
        }
        this.f30292c.removeTextChangedListener(this.a);
        m(this.f30293d, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
        p();
        if (!z) {
            this.f30292c.getText().delete(i, i2);
        }
        this.f30292c.addTextChangedListener(this.a);
    }

    public synchronized void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i) == null) {
            synchronized (this) {
                if (this.f30292c != null && str != null) {
                    if (G().size() > 0) {
                        for (e eVar : G()) {
                            delete(eVar.f(), eVar.c());
                            if (eVar.c() <= i) {
                                i = (i - eVar.c()) + eVar.f();
                            }
                        }
                    }
                    e eVar2 = new e(str);
                    eVar2.a(this.f30292c.getText(), i, eVar2.s().length() + i, (int) this.f30292c.getTextSize());
                    if (!c.a.o0.t0.a.g(this.f30292c.getText(), i)) {
                        this.f30293d.add(eVar2);
                    }
                    eVar2.r();
                }
            }
        }
    }

    public synchronized void i(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, atSelectData) == null) {
            synchronized (this) {
                if (this.f30292c != null && atSelectData != null) {
                    c.a.o0.r.l0.s.d dVar = new c.a.o0.r.l0.s.d(atSelectData);
                    String v = dVar.v();
                    int selectionStart = this.f30292c.getSelectionStart();
                    int length = v.length() + selectionStart;
                    this.f30292c.getEditableText().insert(selectionStart, v);
                    Selection.setSelection(this.f30292c.getText(), length);
                    dVar.a(this.f30292c.getText(), selectionStart, length, (int) this.f30292c.getTextSize());
                    dVar.r();
                    this.f30293d.add(dVar);
                }
            }
        }
    }

    public synchronized void j(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        boolean z = false;
                        Iterator<c.a.o0.r.l0.s.d> it = v().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            c.a.o0.r.l0.s.d next = it.next();
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
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (spanGroupEditText = this.f30292c) == null || (textWatcher = this.a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    public synchronized void l(String str, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.f30292c != null && !TextUtils.isEmpty(str)) {
                    if (G().size() > 0) {
                        i2 = -1;
                        for (e eVar : G()) {
                            int f2 = eVar.f();
                            if (str.equals(eVar.t())) {
                                if (z) {
                                    delete(eVar.f(), eVar.c());
                                }
                                return;
                            }
                            delete(eVar.f(), eVar.c());
                            i2 = f2;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1 || i == -1) {
                        i = i2;
                    }
                    String s = new e(str).s();
                    if (i == -1) {
                        i = this.f30292c.getSelectionStart();
                    }
                    s.length();
                    this.f30292c.getEditableText().insert(i, s);
                }
            }
        }
    }

    public synchronized void m(LinkedList<c.a.o0.r.l0.s.a> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{linkedList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<c.a.o0.r.l0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
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
    public void n(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            Iterator<c.a.o0.r.l0.s.d> it = v().iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.d next = it.next();
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

    public boolean o(String str) {
        InterceptResult invokeL;
        w t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f30293d) && !TextUtils.isEmpty(str)) {
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
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

    public final synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            synchronized (this) {
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
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
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f30293d.clear();
        }
    }

    public synchronized void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                if (this.f30292c == null) {
                    return;
                }
                Editable text = this.f30292c.getText();
                Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
                if (matcher.find()) {
                    String group = matcher.group();
                    String substring = group.substring(18, group.length() - 7);
                    int start = matcher.start();
                    int end = matcher.end();
                    c.a.p0.l1.a aVar = null;
                    try {
                        aVar = c.a.p0.l1.a.g(new JSONObject(substring));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (aVar != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        w b2 = w.b(tbLinkSpanGroup, aVar);
                        tbLinkSpanGroup.a(text, start, end, (int) this.f30292c.getTextSize());
                        b2.f10978h = substring;
                        tbLinkSpanGroup.z(b2.f10974d);
                        tbLinkSpanGroup.r();
                        m(this.f30293d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.k(this.f30296g);
                        this.f30293d.add(tbLinkSpanGroup);
                    }
                    r();
                }
            }
        }
    }

    public final synchronized void s() {
        TbLinkSpanGroup tbLinkSpanGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            synchronized (this) {
                if (this.f30292c != null && this.f30294e) {
                    Editable text = this.f30292c.getText();
                    Matcher matcher = TbPatternsCompat.WEB_URL_END_WITH_BLANK.matcher(text);
                    if (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end() - 1;
                        int end2 = matcher.end();
                        if (end < 0) {
                            return;
                        }
                        if (J(text, end)) {
                            text.replace(end, end2, " ");
                            s();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.f30292c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (UrlManager.getInstance().isPbUrl(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                                tbLinkSpanGroup.B(tidFromPbUrl);
                                R(tidFromPbUrl);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.f30292c.getTextSize());
                            tbLinkSpanGroup.r();
                            tbLinkSpanGroup.k(this.f30296g);
                            this.f30293d.add(tbLinkSpanGroup);
                        } else if (this.f30292c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.f30292c.getTextSize());
                            tbLinkSpanGroup2.r();
                            Q(subSequence.toString(), tbLinkSpanGroup2.e());
                            tbLinkSpanGroup2.k(this.f30296g);
                            this.f30293d.add(tbLinkSpanGroup2);
                        }
                        s();
                    }
                }
            }
        }
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this) {
                if (this.f30292c != null && this.f30295f) {
                    Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(this.f30292c.getText());
                    if (matcher.find()) {
                        AtSelectData atSelectData = new AtSelectData(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim());
                        int start = matcher.start();
                        int end = matcher.end();
                        c.a.o0.r.l0.s.d dVar = new c.a.o0.r.l0.s.d(atSelectData);
                        this.f30292c.getEditableText().replace(start, end, dVar.v());
                        dVar.a(this.f30292c.getText(), start, dVar.v().length() + start, (int) this.f30292c.getTextSize());
                        dVar.r();
                        this.f30293d.add(dVar);
                        t();
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? y() : (String) invokeV.objValue;
    }

    public ArrayList<AtSelectData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            List<c.a.o0.r.l0.s.d> v = v();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (c.a.o0.r.l0.s.d dVar : v) {
                if (dVar != null && dVar.u() != null) {
                    arrayList.add(dVar.u());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<c.a.o0.r.l0.s.d> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if ((next instanceof c.a.o0.r.l0.s.d) && next.h()) {
                    arrayList.add((c.a.o0.r.l0.s.d) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (K()) {
                for (c.a.o0.r.l0.s.d dVar : v()) {
                    if (dVar.u() != null && dVar.u().getUid() != null) {
                        arrayList.add(dVar.u().getUid());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        w t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            int i = 0;
            if (ListUtils.isEmpty(this.f30293d)) {
                return 0;
            }
            Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
            while (it.hasNext()) {
                c.a.o0.r.l0.s.a next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.f10972b == 2) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this) {
                if (this.f30292c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f30292c.getText());
                LinkedList<c.a.o0.r.l0.s.a> linkedList = new LinkedList<>();
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c.a.o0.r.l0.s.d) {
                            linkedList.add(c.a.o0.r.l0.s.d.w((c.a.o0.r.l0.s.d) next, spannableStringBuilder));
                        } else if (next instanceof e) {
                            linkedList.add(e.u((e) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<c.a.o0.r.l0.s.a> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    c.a.o0.r.l0.s.a next2 = it2.next();
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

    public synchronized String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            synchronized (this) {
                if (this.f30292c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f30292c.getText());
                int selectionEnd = this.f30292c.getSelectionEnd();
                LinkedList<c.a.o0.r.l0.s.a> linkedList = new LinkedList<>();
                Iterator<c.a.o0.r.l0.s.a> it = this.f30293d.iterator();
                while (it.hasNext()) {
                    c.a.o0.r.l0.s.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof c.a.o0.r.l0.s.d) {
                            linkedList.add(c.a.o0.r.l0.s.d.w((c.a.o0.r.l0.s.d) next, spannableStringBuilder));
                        } else if (next instanceof e) {
                            linkedList.add(e.u((e) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<c.a.o0.r.l0.s.a> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    c.a.o0.r.l0.s.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    int i = c2 - f2;
                    next2.p(spannableStringBuilder);
                    int c3 = next2.c() - next2.f();
                    m(linkedList, f2, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                    if (c2 <= selectionEnd) {
                        selectionEnd = (selectionEnd + c3) - i;
                    }
                }
                return spannableStringBuilder.replace(0, selectionEnd, (CharSequence) "").toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public void delete(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            delete(i, i2, false);
        }
    }
}
