package c.a.r0.s1.f;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<MsglistActivity<?>> a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f21702b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f21703c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f21704d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f21705e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f21706f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f21707g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f21708h;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            if (aVar.f43384b == null || aVar.a == null) {
                return;
            }
            this.a.f21707g.addAll(aVar.f43384b);
            this.a.f21703c.addAdapters(new ArrayList(this.a.f21707g));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21702b : (List) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.a, ChatMessage.TYPE_MSG_LEFT);
            this.f21704d = msgLeftViewItemAdapter;
            msgLeftViewItemAdapter.e0(true);
            this.f21704d.f0(true);
            MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.a, ChatMessage.TYPE_MSG_RIGHT);
            this.f21705e = msgRightViewItemAdapter;
            msgRightViewItemAdapter.e0(true);
            this.f21705e.f0(true);
            this.f21706f = new MsgMidViewItemAdapter(this.a, ChatMessage.TYPE_MSG_MID);
            this.f21707g.add(this.f21704d);
            this.f21707g.add(this.f21705e);
            this.f21707g.add(this.f21706f);
            e();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.f43384b = new ArrayList();
            aVar.a = this.a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21708h.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.f21708h);
        }
    }

    public void f(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && (this.f21703c.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f21703c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f21703c.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f21703c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (this.f21703c.getAdapter2() instanceof c.a.d.o.e.e)) {
            this.f21703c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f21708h == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f21708h);
        this.f21708h = null;
    }

    public void j(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f21702b = list;
            ArrayList arrayList = new ArrayList();
            if (this.f21702b != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 > 0) {
                        if (list.get(i2).getCacheData() == null) {
                            list.get(i2).setCacheData(new MsgCacheData());
                        }
                        list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                    }
                }
                arrayList.addAll(this.f21702b);
            }
            this.f21703c.setData(arrayList);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.f21704d;
            if (msgLeftViewItemAdapter != null) {
                msgLeftViewItemAdapter.d0(z);
            }
            MsgRightViewItemAdapter msgRightViewItemAdapter = this.f21705e;
            if (msgRightViewItemAdapter != null) {
                msgRightViewItemAdapter.d0(z);
            }
        }
    }

    public void l(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (msgRightViewItemAdapter = this.f21705e) == null) {
            return;
        }
        msgRightViewItemAdapter.m0(z);
    }

    public void m(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (msgLeftViewItemAdapter = this.f21704d) == null) {
            return;
        }
        msgLeftViewItemAdapter.m0(z);
    }

    public void n(c.a.d.f.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f21707g) {
                if (msgCommonItemAdapter.a0()) {
                    msgCommonItemAdapter.g0(aVar);
                }
            }
        }
    }

    public void o(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f21707g) {
                if (msgCommonItemAdapter.b0()) {
                    msgCommonItemAdapter.h0(bVar);
                }
            }
        }
    }

    public void p(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            this.f21705e.i0(map);
            this.f21704d.i0(map);
        }
    }

    public void q(AbsMsglistView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f21704d.k0(gVar);
            this.f21705e.k0(gVar);
        }
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21702b = null;
        this.f21707g = new ArrayList();
        this.f21708h = new a(this, 2001275);
        this.a = tbPageContext;
        this.f21703c = bdTypeListView;
        d();
        this.f21704d.j0(i2);
        this.f21705e.j0(i2);
    }
}
