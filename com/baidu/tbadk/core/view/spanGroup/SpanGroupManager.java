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
import com.baidu.tieba.au6;
import com.baidu.tieba.bb;
import com.baidu.tieba.dp4;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.lw4;
import com.baidu.tieba.mw4;
import com.baidu.tieba.ne5;
import com.baidu.tieba.nw4;
import com.baidu.tieba.pg;
import com.baidu.tieba.pw4;
import com.baidu.tieba.qi;
import com.baidu.tieba.qw4;
import com.baidu.tieba.ri;
import com.baidu.tieba.rw4;
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
    public LinkedList<lw4> d;
    public boolean e;
    public boolean f;
    public lw4.a g;
    public bb h;
    public bb i;

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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChangeSpanGroupType) Enum.valueOf(ChangeSpanGroupType.class, str) : (ChangeSpanGroupType) invokeL.objValue;
        }

        public static ChangeSpanGroupType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChangeSpanGroupType[]) $VALUES.clone() : (ChangeSpanGroupType[]) invokeV.objValue;
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
                this.c.r();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends bb {
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

        @Override // com.baidu.tieba.bb
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
                rw4 rw4Var = new rw4();
                rw4Var.a(responseData);
                rw4Var.c = str;
                this.a.P(rw4Var, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends bb {
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

        @Override // com.baidu.tieba.bb
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
                this.a.Q(threadData);
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
        this.c.setEditableFactory(new mw4(new nw4(this)));
        this.c.setSoftKeyListener(new d(this));
        this.i.setTag(this.b);
        MessageManager.getInstance().registerListener(this.i);
        this.h.setTag(this.b);
        MessageManager.getInstance().registerListener(this.h);
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
                LinkedList<lw4> linkedList = new LinkedList<>();
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.z((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof pw4) {
                            linkedList.add(pw4.y((pw4) next, spannableStringBuilder));
                        } else if (next instanceof qw4) {
                            linkedList.add(qw4.w((qw4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<lw4> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    lw4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.r(spannableStringBuilder);
                    m(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
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
                LinkedList<lw4> linkedList = new LinkedList<>();
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.z((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof pw4) {
                            linkedList.add(pw4.y((pw4) next, spannableStringBuilder));
                        } else if (next instanceof qw4) {
                            linkedList.add(qw4.w((qw4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<lw4> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    lw4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    int i = c2 - f;
                    next2.r(spannableStringBuilder);
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
                LinkedList<lw4> linkedList = new LinkedList<>();
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.z((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof pw4) {
                            linkedList.add(pw4.y((pw4) next, spannableStringBuilder));
                        } else if (next instanceof qw4) {
                            linkedList.add(qw4.w((qw4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<lw4> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    lw4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    if (c2 <= selectionStart) {
                        int i = c2 - f;
                        next2.r(spannableStringBuilder);
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

    public lw4 D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            Iterator<lw4> it = this.d.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if (next.h() && i > next.f() && i < next.c()) {
                    return next;
                }
            }
            return null;
        }
        return (lw4) invokeI.objValue;
    }

    public lw4 E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Iterator<lw4> it = this.d.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if (next.h() && i == next.e()) {
                    return next;
                }
            }
            return null;
        }
        return (lw4) invokeI.objValue;
    }

    public LinkedList<lw4> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (LinkedList) invokeV.objValue;
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
                LinkedList<lw4> linkedList = new LinkedList<>();
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.h()) {
                        if (next instanceof TbLinkSpanGroup) {
                            linkedList.add(TbLinkSpanGroup.z((TbLinkSpanGroup) next, spannableStringBuilder));
                        } else if (next instanceof pw4) {
                            linkedList.add(pw4.y((pw4) next, spannableStringBuilder));
                        } else if (next instanceof qw4) {
                            linkedList.add(qw4.w((qw4) next, spannableStringBuilder));
                        } else {
                            throw new RuntimeException("Need create new spanGroup copy form current spanGroup to forbid current spanGroup position error.");
                        }
                    }
                }
                Iterator<lw4> it2 = linkedList.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    lw4 next2 = it2.next();
                    int f = next2.f();
                    int c2 = next2.c();
                    next2.s(spannableStringBuilder, i);
                    m(linkedList, f, c2, (next2.c() - next2.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                    i++;
                }
                return spannableStringBuilder.toString();
            }
        }
        return (String) invokeV.objValue;
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Iterator<lw4> it = this.d.iterator();
            int i = 0;
            while (it.hasNext()) {
                lw4 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).w() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public List<qw4> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<lw4> it = this.d.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if ((next instanceof qw4) && next.h()) {
                    arrayList.add((qw4) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void J(TbLinkSpanGroup tbLinkSpanGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, tbLinkSpanGroup) == null) || this.d == null) {
            return;
        }
        tbLinkSpanGroup.m(this.g);
        this.d.add(tbLinkSpanGroup);
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean L(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, charSequence, i)) == null) ? charSequence != null && charSequence.length() != 0 && i >= 0 && charSequence.charAt(i) == '\n' : invokeLI.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? !ListUtils.isEmpty(x()) : invokeV.booleanValue;
    }

    public boolean N(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
            Iterator<lw4> it = this.d.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if ((next instanceof qw4) && next.h()) {
                    qw4 qw4Var = (qw4) next;
                    if (i >= qw4Var.f() && qw4Var.c() > i) {
                        return true;
                    }
                    if (i2 > qw4Var.f() && qw4Var.c() >= i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || K()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.c.getText());
        lw4 D = D(selectionStart);
        lw4 D2 = D(selectionEnd);
        if (D instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), D.f(), D.f());
        } else if (D2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.c.getText(), D2.f(), D2.f());
        }
    }

    public final synchronized void P(rw4 rw4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, rw4Var, i) == null) {
            synchronized (this) {
                if (rw4Var != null) {
                    if (rw4Var.a == 1 && rw4Var.b != 3) {
                        this.c.removeTextChangedListener(this.a);
                        Iterator<lw4> it = this.d.iterator();
                        while (it.hasNext()) {
                            lw4 next = it.next();
                            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                                if (tbLinkSpanGroup.e() == i && (rw4Var.b == 1 || rw4Var.b == 2 || rw4Var.b == 4)) {
                                    tbLinkSpanGroup.B(rw4Var.e);
                                    if (rw4Var.b == 1) {
                                        tbLinkSpanGroup.C(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                    } else if (rw4Var.b == 2 || rw4Var.b == 4) {
                                        tbLinkSpanGroup.C(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                                    }
                                    dp4.c(tbLinkSpanGroup, rw4Var);
                                    if (this.g != null) {
                                        this.g.a(i, true);
                                    }
                                    int f = tbLinkSpanGroup.f();
                                    int c2 = tbLinkSpanGroup.c();
                                    tbLinkSpanGroup.G();
                                    m(this.d, f, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                                    O();
                                }
                            }
                        }
                        this.c.addTextChangedListener(this.a);
                    }
                }
            }
        }
    }

    public final synchronized void Q(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) {
            synchronized (this) {
                this.c.removeTextChangedListener(this.a);
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.w() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(threadData.getTid(), tbLinkSpanGroup.x())) {
                            String title = threadData.getTitle();
                            if (qi.isEmpty(title)) {
                                title = threadData.getAbstract();
                            }
                            tbLinkSpanGroup.B(title);
                            int f = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.G();
                            m(this.d, f, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f), true, ChangeSpanGroupType.DEFAULT);
                            O();
                        }
                    }
                }
                this.c.addTextChangedListener(this.a);
            }
        }
    }

    public void R() {
        SpanGroupEditText spanGroupEditText;
        TextWatcher textWatcher;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (spanGroupEditText = this.c) == null || (textWatcher = this.a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void S(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i) == null) {
            long forumId = this.c.getForumId();
            int H = H() + 1;
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setTag(this.b);
            requestUrlParserNetMessage.setParams(forumId, H, str, i);
            MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            int k = ri.k(TbadkCoreApplication.getInst());
            int i = ri.i(TbadkCoreApplication.getInst());
            float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.b);
            requestGetMyPostNetMessage.setParams(pg.g(str, 0L), 0L, 0L, k, i, f, i2);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public final boolean U() {
        InterceptResult invokeV;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.c.getSelectionEnd()) {
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
                    if (next.h() && next.c() == selectionStart) {
                        Selection.setSelection(this.c.getText(), next.f(), next.c());
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void V(lw4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f = z;
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.e = z;
        }
    }

    public void delete(int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || K() || i > i2 || i >= this.c.length() || i2 > this.c.length()) {
            return;
        }
        this.c.removeTextChangedListener(this.a);
        m(this.d, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
        r();
        if (!z) {
            this.c.getText().delete(i, i2);
        }
        this.c.addTextChangedListener(this.a);
    }

    public synchronized void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            synchronized (this) {
                if (this.c != null && str != null) {
                    if (I().size() > 0) {
                        for (qw4 qw4Var : I()) {
                            delete(qw4Var.f(), qw4Var.c());
                            if (qw4Var.c() <= i) {
                                i = (i - qw4Var.c()) + qw4Var.f();
                            }
                        }
                    }
                    qw4 qw4Var2 = new qw4(str);
                    qw4Var2.a(this.c.getText(), i, qw4Var2.u().length() + i, (int) this.c.getTextSize());
                    if (!ne5.g(this.c.getText(), i)) {
                        this.d.add(qw4Var2);
                    }
                    qw4Var2.t();
                }
            }
        }
    }

    public synchronized void i(AtSelectData atSelectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, atSelectData) == null) {
            synchronized (this) {
                if (this.c != null && atSelectData != null) {
                    pw4 pw4Var = new pw4(atSelectData);
                    String x = pw4Var.x();
                    int selectionStart = this.c.getSelectionStart();
                    int length = x.length() + selectionStart;
                    this.c.getEditableText().insert(selectionStart, x);
                    if (this.c.getText() == null || this.c.getText().length() >= length) {
                        pw4Var.a(this.c.getText(), selectionStart, length, (int) this.c.getTextSize());
                        pw4Var.t();
                        selectionStart = length;
                    }
                    Selection.setSelection(this.c.getText(), selectionStart);
                    this.d.add(pw4Var);
                }
            }
        }
    }

    public synchronized void j(List<AtSelectData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        boolean z = false;
                        Iterator<pw4> it = x().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            pw4 next = it.next();
                            if (next.w() != null && next.w().getNameShow() != null && next.w().getPortrait() != null && next.w().getNameShow().equals(atSelectData.getNameShow()) && next.w().getPortrait().equals(atSelectData.getPortrait())) {
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
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (spanGroupEditText = this.c) == null || (textWatcher = this.a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    public synchronized void l(String str, int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.c != null && !TextUtils.isEmpty(str)) {
                    if (I().size() > 0) {
                        i2 = -1;
                        for (qw4 qw4Var : I()) {
                            int f = qw4Var.f();
                            if (str.equals(qw4Var.v())) {
                                if (z) {
                                    delete(qw4Var.f(), qw4Var.c());
                                }
                                return;
                            }
                            delete(qw4Var.f(), qw4Var.c());
                            i2 = f;
                        }
                    } else {
                        i2 = -1;
                    }
                    if (i2 != -1 || i == -1) {
                        i = i2;
                    }
                    String u = new qw4(str).u();
                    if (i == -1) {
                        i = this.c.getSelectionStart();
                    }
                    u.length();
                    this.c.getEditableText().insert(i, u);
                }
            }
        }
    }

    public synchronized void m(LinkedList<lw4> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{linkedList, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), changeSpanGroupType}) == null) {
            synchronized (this) {
                Iterator<lw4> it = linkedList.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
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

    public void n(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048608, this, i, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        Iterator<lw4> it = this.d.iterator();
        while (it.hasNext()) {
            lw4 next = it.next();
            if (q(next, i, i2)) {
                next.j();
                next.i();
                it.remove();
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
            Iterator<pw4> it = x().iterator();
            while (it.hasNext()) {
                pw4 next = it.next();
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
        dp4 v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (!ListUtils.isEmpty(this.d) && !TextUtils.isEmpty(str)) {
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    lw4 next = it.next();
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

    public final boolean q(@NonNull lw4 lw4Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048611, this, lw4Var, i, i2)) == null) ? lw4Var.c() >= i && lw4Var.f() <= i + i2 : invokeLII.booleanValue;
    }

    public final synchronized void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this) {
                Iterator<lw4> it = this.d.iterator();
                while (it.hasNext()) {
                    if (!it.next().h()) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.d.clear();
        }
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
                    au6 au6Var = null;
                    try {
                        au6Var = au6.g(new JSONObject(substring));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (au6Var != null) {
                        TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                        dp4 b2 = dp4.b(tbLinkSpanGroup, au6Var);
                        tbLinkSpanGroup.a(text, start, end, (int) this.c.getTextSize());
                        b2.h = substring;
                        tbLinkSpanGroup.B(b2.d);
                        tbLinkSpanGroup.t();
                        m(this.d, end, end, (tbLinkSpanGroup.y() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                        tbLinkSpanGroup.m(this.g);
                        this.d.add(tbLinkSpanGroup);
                    }
                    t();
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? A() : (String) invokeV.objValue;
    }

    public final synchronized void u() {
        TbLinkSpanGroup tbLinkSpanGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
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
                        if (L(text, end)) {
                            text.replace(end, end2, " ");
                            u();
                            return;
                        }
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (UrlManager.getInstance().isPbUrl(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                                tbLinkSpanGroup.D(tidFromPbUrl);
                                T(tidFromPbUrl);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.c.getTextSize());
                            tbLinkSpanGroup.t();
                            tbLinkSpanGroup.m(this.g);
                            this.d.add(tbLinkSpanGroup);
                        } else if (this.c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.c.getTextSize());
                            tbLinkSpanGroup2.t();
                            S(subSequence.toString(), tbLinkSpanGroup2.e());
                            tbLinkSpanGroup2.m(this.g);
                            this.d.add(tbLinkSpanGroup2);
                        }
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
                if (this.c != null && this.f) {
                    Matcher matcher = TbPatternsCompat.PLAIN_TEXT_AT_WITH_BLANK.matcher(this.c.getText());
                    if (matcher.find()) {
                        AtSelectData atSelectData = new AtSelectData(matcher.group(1).trim(), matcher.group(2).trim(), matcher.group(3).trim());
                        int start = matcher.start();
                        int end = matcher.end();
                        pw4 pw4Var = new pw4(atSelectData);
                        this.c.getEditableText().replace(start, end, pw4Var.x());
                        pw4Var.a(this.c.getText(), start, pw4Var.x().length() + start, (int) this.c.getTextSize());
                        pw4Var.t();
                        this.d.add(pw4Var);
                        v();
                    }
                }
            }
        }
    }

    public ArrayList<AtSelectData> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            List<pw4> x = x();
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            for (pw4 pw4Var : x) {
                if (pw4Var != null && pw4Var.w() != null) {
                    arrayList.add(pw4Var.w());
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<pw4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<lw4> it = this.d.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if ((next instanceof pw4) && next.h()) {
                    arrayList.add((pw4) next);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (M()) {
                for (pw4 pw4Var : x()) {
                    if (pw4Var.w() != null && pw4Var.w().getUid() != null) {
                        arrayList.add(pw4Var.w().getUid());
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        dp4 v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int i = 0;
            if (ListUtils.isEmpty(this.d)) {
                return 0;
            }
            Iterator<lw4> it = this.d.iterator();
            while (it.hasNext()) {
                lw4 next = it.next();
                if ((next instanceof TbLinkSpanGroup) && next.h() && (v = ((TbLinkSpanGroup) next).v()) != null && v.b == 2) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void delete(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            delete(i, i2, false);
        }
    }
}
