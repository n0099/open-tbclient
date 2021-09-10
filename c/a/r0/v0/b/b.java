package c.a.r0.v0.b;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.r0.v0.b.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f26265e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.v0.b.c f26266f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.v0.b.d f26267g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.v0.b.a f26268h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<n> f26269i;

    /* renamed from: j  reason: collision with root package name */
    public String f26270j;
    public int k;
    public long l;
    public String m;
    public BaijiahaoData n;
    public OriginalThreadInfo.ShareInfo o;
    public String p;
    public String q;
    public View.OnClickListener r;
    public Runnable s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public d.b v;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26271e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26271e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof c.a.r0.v0.c.b)) {
                Intent intent = new Intent();
                this.f26271e.f26265e.getPageActivity().setResult(-1, intent);
                c.a.r0.v0.c.b bVar = (c.a.r0.v0.c.b) view.getTag();
                if (this.f26271e.k == 1) {
                    this.f26271e.q(bVar.k(), bVar.o());
                } else if (this.f26271e.k == 2) {
                    this.f26271e.s(bVar);
                    TiebaStatic.log(new StatisticItem("c12609").param("fid", bVar.k()));
                } else if (this.f26271e.k != 3) {
                    if (this.f26271e.k == 4) {
                        this.f26271e.r(String.valueOf(bVar.k()), bVar.o());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.k()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.o());
                    this.f26271e.f26265e.getPageActivity().finish();
                }
            }
        }
    }

    /* renamed from: c.a.r0.v0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1230b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26272e;

        public RunnableC1230b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26272e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.K(this.f26272e.f26265e.getPageActivity(), this.f26272e.f26266f.f26282d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26273a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26273a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.f26273a.f26266f.f26282d.setText(str);
                this.f26273a.f26266f.f26282d.setSelection(str.length());
                this.f26273a.n();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26274a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26274a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f26274a.L();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26275a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26275a = bVar;
        }

        @Override // c.a.r0.v0.b.d.b
        public void a(boolean z, c.a.r0.v0.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                if (!z || cVar == null || ListUtils.isEmpty(cVar.a())) {
                    if (StringUtils.isNull(this.f26275a.f26270j)) {
                        this.f26275a.L();
                        return;
                    } else {
                        this.f26275a.N();
                        return;
                    }
                }
                this.f26275a.f26269i = cVar.a();
                b bVar = this.f26275a;
                bVar.v(bVar.f26269i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26276a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26276a = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    this.f26276a.n();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26277e;

        public g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26277e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f26277e.n();
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
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f26278e;

        public h(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26278e = bVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    l.x(this.f26278e.f26265e.getPageActivity(), view);
                } else {
                    this.f26278e.n();
                }
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new RunnableC1230b(this);
        this.t = new c(this, 2921021);
        this.u = new d(this, 2921020);
        this.v = new e(this);
        this.f26265e = tbPageContext;
        this.f26266f = new c.a.r0.v0.b.c(tbPageContext);
        m();
        c.a.r0.v0.b.d dVar = new c.a.r0.v0.b.d(tbPageContext, tbPageContext.getUniqueId());
        this.f26267g = dVar;
        dVar.e(this.v);
        this.f26269i = new ArrayList<>();
        c.a.r0.v0.b.a aVar = new c.a.r0.v0.b.a(tbPageContext, this.f26266f.f26285g);
        this.f26268h = aVar;
        aVar.a(this.r);
        L();
        tbPageContext.registerListener(this.u);
        tbPageContext.registerListener(this.t);
        c.a.e.e.m.e.a().postDelayed(this.s, 500L);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void B(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareInfo) == null) {
            this.o = shareInfo;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.q = str;
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f26267g.c();
            this.f26269i.clear();
            ArrayList<String> c2 = c.a.r0.v0.b.e.c();
            if (!ListUtils.isEmpty(c2)) {
                c.a.r0.v0.c.a aVar = new c.a.r0.v0.c.a();
                aVar.i(c.a.r0.v0.c.a.f26294h);
                this.f26269i.add(aVar);
                this.f26269i.add(new c.a.r0.v0.c.a(c2));
                v(this.f26269i);
                return;
            }
            this.f26269i.clear();
            v(this.f26269i);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26269i.clear();
            c.a.r0.v0.c.a aVar = new c.a.r0.v0.c.a();
            aVar.i(c.a.r0.v0.c.a.f26295i);
            this.f26269i.add(aVar);
            v(this.f26269i);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f26266f.f26280b.setOnClickListener(this);
            this.f26266f.f26282d.setOnEditorActionListener(new f(this));
            this.f26266f.f26282d.addTextChangedListener(new g(this));
            this.f26266f.f26282d.setOnFocusChangeListener(new h(this));
            this.f26266f.f26282d.setOnClickListener(this);
            this.f26266f.f26283e.setOnClickListener(this);
            this.f26266f.f26284f.setOnClickListener(this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f26266f.f26282d.getText() != null && !StringUtils.isNull(this.f26266f.f26282d.getText().toString())) {
                n nVar = (n) ListUtils.getItem(this.f26269i, 0);
                if (nVar != null && nVar.getType() == c.a.r0.v0.c.a.f26294h) {
                    this.f26269i.clear();
                    v(this.f26269i);
                }
                this.f26266f.f26283e.setVisibility(0);
                String obj = this.f26266f.f26282d.getText().toString();
                this.f26270j = obj;
                this.f26267g.d(obj);
                return;
            }
            this.f26266f.f26283e.setVisibility(8);
            this.f26270j = null;
            L();
        }
    }

    public c.a.r0.v0.b.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f26266f : (c.a.r0.v0.b.c) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            c.a.r0.v0.b.c cVar = this.f26266f;
            EditText editText = cVar.f26282d;
            if (view == editText) {
                n();
            } else if (view == cVar.f26284f) {
                l.x(this.f26265e.getPageActivity(), this.f26266f.f26282d);
                this.f26265e.getPageActivity().finish();
            } else if (view == cVar.f26283e) {
                editText.setText("");
            } else if (view == cVar.f26280b) {
                v(this.f26269i);
            }
        }
    }

    public final FrsTabInfoData p(c.a.r0.v0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bVar)) == null) {
            if (bVar == null || ListUtils.isEmpty(bVar.p())) {
                return null;
            }
            ArrayList arrayList = new ArrayList(bVar.p().size());
            for (FrsTabInfo frsTabInfo : bVar.p()) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = -1;
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeL.objValue;
    }

    public final void q(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j2, str) == null) {
            TransmitForumData transmitForumData = new TransmitForumData(j2, str, true, 0);
            transmitForumData.tabItemDatas = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(transmitForumData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.f26265e.getPageActivity(), arrayList, String.valueOf(this.l), this.m)));
            this.f26265e.getPageActivity().finish();
        }
    }

    public final void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f26265e.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.f26265e.getPageActivity().finish();
    }

    public final void s(c.a.r0.v0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) || bVar == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.f26265e.getPageActivity(), 9, String.valueOf(bVar.k()), bVar.o(), null, null, 13011, null, null, null, this.o);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.n);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.p);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.q);
        transmitPostEditActivityConfig.setFrsTabInfo(p(bVar));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.f26265e.getPageActivity().finish();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.s);
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    public void u(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, baijiahaoData) == null) {
            this.n = baijiahaoData;
        }
    }

    public void v(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) {
            this.f26269i = arrayList;
            this.f26266f.f26285g.setData(arrayList);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.k = i2;
        }
    }

    public void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.l = j2;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }
}
