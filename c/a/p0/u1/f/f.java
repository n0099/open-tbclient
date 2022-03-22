package c.a.p0.u1.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.MsgLeftViewItemAdapter;
import com.baidu.tieba.im.chat.MsgMidViewItemAdapter;
import com.baidu.tieba.im.chat.MsgRightViewItemAdapter;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<MsglistActivity<?>> a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f18684b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f18685c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f18686d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f18687e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f18688f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f18689g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f18690h;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f33672b == null || aVar.a == null) {
                return;
            }
            this.a.f18689g.addAll(aVar.f33672b);
            this.a.f18685c.a(new ArrayList(this.a.f18689g));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (BdTypeListView) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<ChatMessage> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18684b : (List) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.a, ChatMessage.TYPE_MSG_LEFT);
            this.f18686d = msgLeftViewItemAdapter;
            msgLeftViewItemAdapter.e0(true);
            this.f18686d.f0(true);
            MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.a, ChatMessage.TYPE_MSG_RIGHT);
            this.f18687e = msgRightViewItemAdapter;
            msgRightViewItemAdapter.e0(true);
            this.f18687e.f0(true);
            this.f18688f = new MsgMidViewItemAdapter(this.a, ChatMessage.TYPE_MSG_MID);
            this.f18689g.add(this.f18686d);
            this.f18689g.add(this.f18687e);
            this.f18689g.add(this.f18688f);
            e();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.f33672b = new ArrayList();
            aVar.a = this.a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18690h.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.f18690h);
        }
    }

    public void f(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && (this.f18685c.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f18685c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f18685c.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f18685c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (this.f18685c.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f18685c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f18690h == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f18690h);
        this.f18690h = null;
    }

    public void j(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18684b = list;
            ArrayList arrayList = new ArrayList();
            if (this.f18684b != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        if (list.get(i).getCacheData() == null) {
                            list.get(i).setCacheData(new MsgCacheData());
                        }
                        list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                    }
                }
                arrayList.addAll(this.f18684b);
            }
            this.f18685c.setData(arrayList);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f18686d;
            if (msgLeftViewItemAdapter != null) {
                msgLeftViewItemAdapter.d0(z);
            }
            MsgRightViewItemAdapter msgRightViewItemAdapter = this.f18687e;
            if (msgRightViewItemAdapter != null) {
                msgRightViewItemAdapter.d0(z);
            }
        }
    }

    public void l(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (msgRightViewItemAdapter = this.f18687e) == null) {
            return;
        }
        msgRightViewItemAdapter.m0(z);
    }

    public void m(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (msgLeftViewItemAdapter = this.f18686d) == null) {
            return;
        }
        msgLeftViewItemAdapter.m0(z);
    }

    public void n(c.a.d.f.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f18689g) {
                if (msgCommonItemAdapter.a0()) {
                    msgCommonItemAdapter.g0(aVar);
                }
            }
        }
    }

    public void o(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f18689g) {
                if (msgCommonItemAdapter.b0()) {
                    msgCommonItemAdapter.h0(bVar);
                }
            }
        }
    }

    public void p(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) {
            this.f18687e.i0(arrayList);
            this.f18686d.i0(arrayList);
        }
    }

    public void q(AbsMsglistView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f18686d.k0(gVar);
            this.f18687e.k0(gVar);
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18684b = null;
        this.f18689g = new ArrayList();
        this.f18690h = new a(this, 2001275);
        this.a = tbPageContext;
        this.f18685c = bdTypeListView;
        d();
        this.f18686d.j0(i);
        this.f18687e.j0(i);
    }
}
