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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.f0.r.a;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes4.dex */
public class SpanGroupManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f12724a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f12725b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f12726c;

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<d.a.r0.r.f0.r.a> f12727d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12728e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1255a f12729f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f12730g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f12731h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f12732e;

        /* renamed from: f  reason: collision with root package name */
        public int f12733f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f12734g;

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
            this.f12734g = spanGroupManager;
            this.f12732e = -1;
            this.f12733f = -1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f12734g.n();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f12732e = Selection.getSelectionStart(charSequence);
                this.f12733f = Selection.getSelectionEnd(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                SpanGroupManager spanGroupManager = this.f12734g;
                spanGroupManager.h(spanGroupManager.f12727d, this.f12732e, this.f12733f, i4 - i3, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
                this.f12734g.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f12735a;

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
            this.f12735a = spanGroupManager;
        }

        @Override // d.a.c.c.g.a
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
                d.a.r0.r.f0.r.d dVar = new d.a.r0.r.f0.r.d();
                dVar.a(responseData);
                dVar.f55700c = str;
                this.f12735a.z(dVar, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f12736a;

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
            this.f12736a = spanGroupManager;
        }

        @Override // d.a.c.c.g.a
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
                b2 b2Var = new b2();
                b2Var.I2(responseData.data.thread_info);
                this.f12736a.A(b2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SpanGroupManager f12737e;

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
            this.f12737e = spanGroupManager;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 67 && keyEvent.getAction() == 0) {
                    return this.f12737e.E();
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
        this.f12724a = new a(this);
        this.f12727d = new LinkedList<>();
        this.f12728e = true;
        this.f12730g = new b(this, CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        this.f12731h = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        if (spanGroupEditText == null) {
            return;
        }
        this.f12725b = bdUniqueId;
        this.f12726c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.f12724a);
        this.f12726c.setEditableFactory(new d.a.r0.r.f0.r.b(new d.a.r0.r.f0.r.c(this)));
        this.f12726c.setSoftKeyListener(new d(this));
        this.f12731h.setTag(this.f12725b);
        MessageManager.getInstance().registerListener(this.f12731h);
        this.f12730g.setTag(this.f12725b);
        MessageManager.getInstance().registerListener(this.f12730g);
    }

    public final synchronized void A(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
            synchronized (this) {
                this.f12726c.removeTextChangedListener(this.f12724a);
                Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.u() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(b2Var.n1(), tbLinkSpanGroup.v())) {
                            String title = b2Var.getTitle();
                            if (k.isEmpty(title)) {
                                title = b2Var.h();
                            }
                            tbLinkSpanGroup.z(title);
                            int f2 = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            h(this.f12727d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                            y();
                        }
                    }
                }
                this.f12726c.addTextChangedListener(this.f12724a);
            }
        }
    }

    public void B() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (spanGroupEditText = this.f12726c) == null || (textWatcher = this.f12724a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void C(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            long forumId = this.f12726c.getForumId();
            int u = u() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.f12725b);
            requestUrlParserNetMessage.setParams(forumId, u, str, i2);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.f12725b);
            requestGetMyPostNetMessage.setParams(d.a.c.e.m.b.f(str, 0L), 0L, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f12726c;
            if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.f12726c.getSelectionEnd()) {
                Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
                    if (next.h() && next.c() == selectionStart) {
                        Selection.setSelection(this.f12726c.getText(), next.f(), next.c());
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void F(a.InterfaceC1255a interfaceC1255a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC1255a) == null) {
            this.f12729f = interfaceC1255a;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f12728e = z;
        }
    }

    public void g() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (spanGroupEditText = this.f12726c) == null || (textWatcher = this.f12724a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    public synchronized void h(LinkedList<d.a.r0.r.f0.r.a> linkedList, int i2, int i3, int i4, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{linkedList, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<d.a.r0.r.f0.r.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
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

    public boolean i(String str) {
        InterceptResult invokeL;
        w t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f12727d) && !TextUtils.isEmpty(str)) {
                Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
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

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                while (it.hasNext()) {
                    if (!it.next().h()) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f12727d.clear();
        }
    }

    public void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) || w() || i2 > i3 || i2 >= this.f12726c.length()) {
            return;
        }
        this.f12726c.removeTextChangedListener(this.f12724a);
        this.f12726c.getText().delete(i2, i3);
        h(this.f12727d, i2, i3, i2 - i3, false, ChangeSpanGroupType.DEFAULT);
        j();
        this.f12726c.addTextChangedListener(this.f12724a);
    }

    public synchronized void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (this.f12726c == null) {
                    return;
                }
                Editable text = this.f12726c.getText();
                Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
                if (matcher.find()) {
                    String group = matcher.group();
                    String substring = group.substring(18, group.length() - 7);
                    int start = matcher.start();
                    int end = matcher.end();
                    d.a.s0.a1.a aVar = null;
                    try {
                        aVar = d.a.s0.a1.a.g(new JSONObject(substring));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (aVar != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        w b2 = w.b(tbLinkSpanGroup, aVar);
                        tbLinkSpanGroup.a(text, start, end, (int) this.f12726c.getTextSize());
                        b2.l = substring;
                        tbLinkSpanGroup.z(b2.f56077h);
                        tbLinkSpanGroup.r();
                        h(this.f12727d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.k(this.f12729f);
                        this.f12727d.add(tbLinkSpanGroup);
                    }
                    m();
                }
            }
        }
    }

    public final synchronized void n() {
        TbLinkSpanGroup tbLinkSpanGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                if (this.f12726c != null && this.f12728e) {
                    Editable text = this.f12726c.getText();
                    Matcher matcher = TbPatternsCompat.WEB_URL_END_WITH_BLANK.matcher(text);
                    if (matcher.find()) {
                        int start = matcher.start();
                        int end = matcher.end() - 1;
                        int end2 = matcher.end();
                        if (end < 0) {
                            return;
                        }
                        if (x(text, end)) {
                            text.replace(end, end2, " ");
                            n();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.f12726c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (UrlManager.getInstance().isPbUrl(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                                tbLinkSpanGroup.B(tidFromPbUrl);
                                D(tidFromPbUrl);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.f12726c.getTextSize());
                            tbLinkSpanGroup.r();
                            tbLinkSpanGroup.k(this.f12729f);
                            this.f12727d.add(tbLinkSpanGroup);
                        } else if (this.f12726c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.f12726c.getTextSize());
                            tbLinkSpanGroup2.r();
                            C(subSequence.toString(), tbLinkSpanGroup2.e());
                            tbLinkSpanGroup2.k(this.f12729f);
                            this.f12727d.add(tbLinkSpanGroup2);
                        }
                        n();
                    }
                }
            }
        }
    }

    public int o() {
        InterceptResult invokeV;
        w t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = 0;
            if (ListUtils.isEmpty(this.f12727d)) {
                return 0;
            }
            Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
            while (it.hasNext()) {
                d.a.r0.r.f0.r.a next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.f56075f == 2) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                if (this.f12726c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f12726c.getText());
                LinkedList<d.a.r0.r.f0.r.a> linkedList = new LinkedList<>();
                Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else {
                            linkedList.add(next);
                        }
                    }
                }
                Iterator<d.a.r0.r.f0.r.a> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    d.a.r0.r.f0.r.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    next2.p(spannableStringBuilder);
                    h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public d.a.r0.r.f0.r.a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
            while (it.hasNext()) {
                d.a.r0.r.f0.r.a next = it.next();
                if (next.h() && i2 > next.f() && i2 < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (d.a.r0.r.f0.r.a) invokeI.objValue;
    }

    public d.a.r0.r.f0.r.a r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
            while (it.hasNext()) {
                d.a.r0.r.f0.r.a next = it.next();
                if (next.h() && i2 == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (d.a.r0.r.f0.r.a) invokeI.objValue;
    }

    public LinkedList<d.a.r0.r.f0.r.a> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f12727d : (LinkedList) invokeV.objValue;
    }

    public synchronized String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this) {
                if (this.f12726c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f12726c.getText());
                LinkedList<d.a.r0.r.f0.r.a> linkedList = new LinkedList<>();
                Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else {
                            linkedList.add(next);
                        }
                    }
                }
                Iterator<d.a.r0.r.f0.r.a> it2 = linkedList.iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    d.a.r0.r.f0.r.a next2 = it2.next();
                    int f2 = next2.f();
                    int c2 = next2.c();
                    next2.q(spannableStringBuilder, i2);
                    h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                    i2++;
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? p() : (String) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                d.a.r0.r.f0.r.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void v(TbLinkSpanGroup tbLinkSpanGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, tbLinkSpanGroup) == null) || this.f12727d == null) {
            return;
        }
        tbLinkSpanGroup.k(this.f12729f);
        this.f12727d.add(tbLinkSpanGroup);
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f12726c;
            return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean x(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, charSequence, i2)) == null) ? charSequence != null && charSequence.length() != 0 && i2 >= 0 && charSequence.charAt(i2) == '\n' : invokeLI.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || w()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.f12726c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.f12726c.getText());
        d.a.r0.r.f0.r.a q = q(selectionStart);
        d.a.r0.r.f0.r.a q2 = q(selectionEnd);
        if (q instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f12726c.getText(), q.f(), q.f());
        } else if (q2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f12726c.getText(), q2.f(), q2.f());
        }
    }

    public final synchronized void z(d.a.r0.r.f0.r.d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, dVar, i2) == null) {
            synchronized (this) {
                if (dVar != null) {
                    if (dVar.f55698a == 1 && dVar.f55699b != 3) {
                        this.f12726c.removeTextChangedListener(this.f12724a);
                        Iterator<d.a.r0.r.f0.r.a> it = this.f12727d.iterator();
                        while (it.hasNext()) {
                            d.a.r0.r.f0.r.a next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i2 && (dVar.f55699b == 1 || dVar.f55699b == 2)) {
                                    tbLinkSpanGroup.z(dVar.f55702e);
                                    if (dVar.f55699b == 1) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (dVar.f55699b == 2) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    w.c(tbLinkSpanGroup, dVar);
                                    if (this.f12729f != null) {
                                        this.f12729f.a(i2, true);
                                    }
                                    int f2 = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.E();
                                    h(this.f12727d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                                    y();
                                }
                            }
                        }
                        this.f12726c.addTextChangedListener(this.f12724a);
                    }
                }
            }
        }
    }
}
