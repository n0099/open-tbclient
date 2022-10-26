package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.gw6;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.nh5;
import com.baidu.tieba.nz4;
import com.baidu.tieba.oz4;
import com.baidu.tieba.pz4;
import com.baidu.tieba.qb;
import com.baidu.tieba.rz4;
import com.baidu.tieba.sz4;
import com.baidu.tieba.tz4;
import com.baidu.tieba.xr4;
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
/* loaded from: classes3.dex */
public class SpanGroupManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextWatcher a;
    public BdUniqueId b;
    public SpanGroupEditText c;
    public LinkedList<nz4> d;
    public boolean e;
    public boolean f;
    public nz4.a g;
    public qb h;
    public qb i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public final class ChangeSpanGroupType {
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
                this.c.s();
                this.c.t();
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
                spanGroupManager.m(spanGroupManager.d, this.a, this.b, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
                this.c.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
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
                    tz4 tz4Var = new tz4();
                    tz4Var.a(urlParserResIdl);
                    tz4Var.c = str;
                    this.a.O(tz4Var, i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            GetMyPostResIdl getMyPostResIdl;
            DataRes dataRes;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                } else {
                    getMyPostResIdl = null;
                }
                if (getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && dataRes.thread_info != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(getMyPostResIdl.data.thread_info);
                    this.a.P(threadData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    return this.a.T();
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    public SpanGroupManager(SpanGroupEditText spanGroupEditText, BdUniqueId bdUniqueId) {
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
        this.i = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        if (spanGroupEditText == null) {
            return;
        }
        this.b = bdUniqueId;
        this.c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.a);
        this.c.setEditableFactory(new oz4(new pz4(this)));
        this.c.setSoftKeyListener(new d(this));
        this.i.setTag(this.b);
        MessageManager.getInstance().registerListener(this.i);
        this.h.setTag(this.b);
        MessageManager.getInstance().registerListener(this.h);
    }

    public final synchronized void O(tz4 tz4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, tz4Var, i) == null) {
            synchronized (this) {
                if (tz4Var != null) {
                    if (tz4Var.a == 1 && tz4Var.b != 3) {
                        this.c.removeTextChangedListener(this.a);
                        Iterator<nz4> it = this.d.iterator();
                        while (it.hasNext()) {
                            nz4 next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i && (tz4Var.b == 1 || tz4Var.b == 2 || tz4Var.b == 4)) {
                                    tbLinkSpanGroup.z(tz4Var.e);
                                    if (tz4Var.b == 1) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (tz4Var.b == 2 || tz4Var.b == 4) {
                                        tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    xr4.c(tbLinkSpanGroup, tz4Var);
                                    if (this.g != null) {
                                        this.g.e(i, true);
                                    }
                                    int f = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.E();
                                    m(this.d, f, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                                    N();
                                }
                            }
                        }
                        this.c.addTextChangedListener(this.a);
                    }
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

    public void U(nz4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f = z;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.e = z;
        }
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
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            delete(i, i2, false);
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
                int selectionStart = this.c.getSelectionStart();
                spannableStringBuilder.length();
                LinkedList<nz4> linkedList = new LinkedList<>();
                Iterator<nz4> it = this.d.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof rz4) {
                            linkedList.add(rz4.w((rz4) next, spannableStringBuilder));
                        } else if (next instanceof sz4) {
                            linkedList.add(sz4.u((sz4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<nz4> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    nz4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    if (c2 <= selectionStart) {
                        int i = c2 - f;
                        next2.p(spannableStringBuilder);
                        int c3 = next2.c() - next2.f();
                        m(linkedList, f, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                        selectionStart = (selectionStart + c3) - i;
                    }
                }
                return spannableStringBuilder.subSequence(0, selectionStart).toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                LinkedList<nz4> linkedList = new LinkedList<>();
                Iterator<nz4> it = this.d.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof rz4) {
                            linkedList.add(rz4.w((rz4) next, spannableStringBuilder));
                        } else if (next instanceof sz4) {
                            linkedList.add(sz4.u((sz4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<nz4> it2 = linkedList.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    nz4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.q(spannableStringBuilder, i);
                    m(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                    i++;
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
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
                    gw6 gw6Var = null;
                    try {
                        gw6Var = gw6.g(new JSONObject(substring));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (gw6Var != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        xr4 b2 = xr4.b(tbLinkSpanGroup, gw6Var);
                        tbLinkSpanGroup.a(text, start, end, (int) this.c.getTextSize());
                        b2.h = substring;
                        tbLinkSpanGroup.z(b2.d);
                        tbLinkSpanGroup.r();
                        m(this.d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.k(this.g);
                        this.d.add(tbLinkSpanGroup);
                    }
                    r();
                }
            }
        }
    }

    public synchronized String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                LinkedList<nz4> linkedList = new LinkedList<>();
                Iterator<nz4> it = this.d.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof rz4) {
                            linkedList.add(rz4.w((rz4) next, spannableStringBuilder));
                        } else if (next instanceof sz4) {
                            linkedList.add(sz4.u((sz4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<nz4> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    nz4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.p(spannableStringBuilder);
                    m(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            synchronized (this) {
                if (this.c == null) {
                    return null;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c.getText());
                int selectionEnd = this.c.getSelectionEnd();
                LinkedList<nz4> linkedList = new LinkedList<>();
                Iterator<nz4> it = this.d.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof rz4) {
                            linkedList.add(rz4.w((rz4) next, spannableStringBuilder));
                        } else if (next instanceof sz4) {
                            linkedList.add(sz4.u((sz4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<nz4> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    nz4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    int i = c2 - f;
                    next2.p(spannableStringBuilder);
                    int c3 = next2.c() - next2.f();
                    m(linkedList, f, c2, c3 - i, true, ChangeSpanGroupType.DEFAULT);
                    if (c2 <= selectionEnd) {
                        selectionEnd = (selectionEnd + c3) - i;
                    }
                }
                return spannableStringBuilder.replace(0, selectionEnd, (CharSequence) "").toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public nz4 B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if (next.h() && i > next.f() && i < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (nz4) invokeI.objValue;
    }

    public nz4 C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if (next.h() && i == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (nz4) invokeI.objValue;
    }

    public LinkedList<nz4> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
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
            return !ListUtils.isEmpty(v());
        }
        return invokeV.booleanValue;
    }

    public void Q() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (spanGroupEditText = this.c) != null && (textWatcher = this.a) != null) {
            spanGroupEditText.removeTextChangedListener(textWatcher);
        }
    }

    public void k() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (spanGroupEditText = this.c) != null && (textWatcher = this.a) != null) {
            spanGroupEditText.addTextChangedListener(textWatcher);
        }
    }

    public final synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            synchronized (this) {
                Iterator<nz4> it = this.d.iterator();
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
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.d.clear();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return y();
        }
        return (String) invokeV.objValue;
    }

    public final int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Iterator<nz4> it = this.d.iterator();
            int i = 0;
            while (it.hasNext()) {
                nz4 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public List<sz4> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if ((next instanceof sz4) && next.h()) {
                    arrayList.add((sz4) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public ArrayList<AtSelectData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            List<rz4> v = v();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (rz4 rz4Var : v) {
                if (rz4Var != null && rz4Var.u() != null) {
                    arrayList.add(rz4Var.u());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<rz4> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if ((next instanceof rz4) && next.h()) {
                    arrayList.add((rz4) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public boolean M(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if ((next instanceof sz4) && next.h()) {
                    sz4 sz4Var = (sz4) next;
                    if (i < sz4Var.f() || sz4Var.c() <= i) {
                        if (i2 > sz4Var.f() && sz4Var.c() >= i2) {
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

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || I()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.c.getText());
        nz4 B = B(selectionStart);
        nz4 B2 = B(selectionEnd);
        if (B instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), B.f(), B.f());
        } else if (B2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), B2.f(), B2.f());
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText == null || (selectionStart = spanGroupEditText.getSelectionStart()) != this.c.getSelectionEnd()) {
                return false;
            }
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if (next.h() && next.c() == selectionStart) {
                    Selection.setSelection(this.c.getText(), next.f(), next.c());
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<String> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (L()) {
                for (rz4 rz4Var : v()) {
                    if (rz4Var.u() != null && rz4Var.u().getUid() != null) {
                        arrayList.add(rz4Var.u().getUid());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        xr4 t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            int i = 0;
            if (ListUtils.isEmpty(this.d)) {
                return 0;
            }
            Iterator<nz4> it = this.d.iterator();
            while (it.hasNext()) {
                nz4 next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.b == 2) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized void P(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) {
            synchronized (this) {
                this.c.removeTextChangedListener(this.a);
                Iterator<nz4> it = this.d.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.u() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(threadData.getTid(), tbLinkSpanGroup.v())) {
                            String title = threadData.getTitle();
                            if (ej.isEmpty(title)) {
                                title = threadData.getAbstract();
                            }
                            tbLinkSpanGroup.z(title);
                            int f = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            m(this.d, f, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                            N();
                        }
                    }
                }
                this.c.addTextChangedListener(this.a);
            }
        }
    }

    public synchronized void i(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, atSelectData) == null) {
            synchronized (this) {
                if (this.c != null && atSelectData != null) {
                    rz4 rz4Var = new rz4(atSelectData);
                    String v = rz4Var.v();
                    int selectionStart = this.c.getSelectionStart();
                    int length = v.length() + selectionStart;
                    this.c.getEditableText().insert(selectionStart, v);
                    if (this.c.getText() == null || this.c.getText().length() >= length) {
                        rz4Var.a(this.c.getText(), selectionStart, length, (int) this.c.getTextSize());
                        rz4Var.r();
                        selectionStart = length;
                    }
                    Selection.setSelection(this.c.getText(), selectionStart);
                    this.d.add(rz4Var);
                }
            }
        }
    }

    public synchronized void j(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        boolean z = false;
                        Iterator<rz4> it = v().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            rz4 next = it.next();
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

    public final void R(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, str, i) == null) {
            long forumId = this.c.getForumId();
            int F = F() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.b);
            requestUrlParserNetMessage.setParams(forumId, F, str, i);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public final void S(String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            int k = fj.k(TbadkCoreApplication.getInst());
            int i2 = fj.i(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.b);
            requestGetMyPostNetMessage.setParams(eh.g(str, 0L), 0L, 0L, k, i2, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        xr4 t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (!ListUtils.isEmpty(this.d) && !TextUtils.isEmpty(str)) {
                Iterator<nz4> it = this.d.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
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

    public void delete(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && !I() && i <= i2 && i < this.c.length() && i2 <= this.c.length()) {
            this.c.removeTextChangedListener(this.a);
            m(this.d, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            p();
            if (!z) {
                this.c.getText().delete(i, i2);
            }
            this.c.addTextChangedListener(this.a);
        }
    }

    public synchronized void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, str, i) == null) {
            synchronized (this) {
                if (this.c != null && str != null) {
                    if (G().size() > 0) {
                        for (sz4 sz4Var : G()) {
                            delete(sz4Var.f(), sz4Var.c());
                            if (sz4Var.c() <= i) {
                                i = (i - sz4Var.c()) + sz4Var.f();
                            }
                        }
                    }
                    sz4 sz4Var2 = new sz4(str);
                    sz4Var2.a(this.c.getText(), i, sz4Var2.s().length() + i, (int) this.c.getTextSize());
                    if (!nh5.g(this.c.getText(), i)) {
                        this.d.add(sz4Var2);
                    }
                    sz4Var2.r();
                }
            }
        }
    }

    public synchronized void l(String str, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.c != null && !TextUtils.isEmpty(str)) {
                    if (G().size() > 0) {
                        i2 = -1;
                        for (sz4 sz4Var : G()) {
                            int f = sz4Var.f();
                            if (str.equals(sz4Var.t())) {
                                if (z) {
                                    delete(sz4Var.f(), sz4Var.c());
                                }
                                return;
                            }
                            delete(sz4Var.f(), sz4Var.c());
                            i2 = f;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1 || i == -1) {
                        i = i2;
                    }
                    String s = new sz4(str).s();
                    if (i == -1) {
                        i = this.c.getSelectionStart();
                    }
                    s.length();
                    this.c.getEditableText().insert(i, s);
                }
            }
        }
    }

    public synchronized void m(LinkedList<nz4> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{linkedList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<nz4> it = linkedList.iterator();
                while (it.hasNext()) {
                    nz4 next = it.next();
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
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            Iterator<rz4> it = v().iterator();
            while (it.hasNext()) {
                rz4 next = it.next();
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

    public final synchronized void s() {
        TbLinkSpanGroup tbLinkSpanGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
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
                            s();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (UrlManager.getInstance().isPbUrl(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                                tbLinkSpanGroup.B(tidFromPbUrl);
                                S(tidFromPbUrl);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.c.getTextSize());
                            tbLinkSpanGroup.r();
                            tbLinkSpanGroup.k(this.g);
                            this.d.add(tbLinkSpanGroup);
                        } else if (this.c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.c.getTextSize());
                            tbLinkSpanGroup2.r();
                            R(subSequence.toString(), tbLinkSpanGroup2.e());
                            tbLinkSpanGroup2.k(this.g);
                            this.d.add(tbLinkSpanGroup2);
                        }
                        s();
                    }
                }
            }
        }
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            synchronized (this) {
                if (this.c != null && this.f) {
                    Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(this.c.getText());
                    if (matcher.find()) {
                        AtSelectData atSelectData = new AtSelectData(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim());
                        int start = matcher.start();
                        int end = matcher.end();
                        rz4 rz4Var = new rz4(atSelectData);
                        this.c.getEditableText().replace(start, end, rz4Var.v());
                        rz4Var.a(this.c.getText(), start, rz4Var.v().length() + start, (int) this.c.getTextSize());
                        rz4Var.r();
                        this.d.add(rz4Var);
                        t();
                    }
                }
            }
        }
    }
}
