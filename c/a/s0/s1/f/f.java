package c.a.s0.s1.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<MsglistActivity<?>> a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f22060b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f22061c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f22062d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f22063e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f22064f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f22065g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f22066h;

    /* loaded from: classes8.dex */
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
            if (aVar.f46307b == null || aVar.a == null) {
                return;
            }
            this.a.f22065g.addAll(aVar.f46307b);
            this.a.f22061c.addAdapters(new ArrayList(this.a.f22065g));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22060b : (List) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.a, ChatMessage.TYPE_MSG_LEFT);
            this.f22062d = msgLeftViewItemAdapter;
            msgLeftViewItemAdapter.k0(true);
            this.f22062d.l0(true);
            MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.a, ChatMessage.TYPE_MSG_RIGHT);
            this.f22063e = msgRightViewItemAdapter;
            msgRightViewItemAdapter.k0(true);
            this.f22063e.l0(true);
            this.f22064f = new MsgMidViewItemAdapter(this.a, ChatMessage.TYPE_MSG_MID);
            this.f22065g.add(this.f22062d);
            this.f22065g.add(this.f22063e);
            this.f22065g.add(this.f22064f);
            e();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.f46307b = new ArrayList();
            aVar.a = this.a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f22066h.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.f22066h);
        }
    }

    public void f(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && (this.f22061c.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.f22061c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f22061c.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.f22061c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (this.f22061c.getAdapter2() instanceof c.a.d.m.e.e)) {
            this.f22061c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f22066h == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f22066h);
        this.f22066h = null;
    }

    public void j(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f22060b = list;
            ArrayList arrayList = new ArrayList();
            if (this.f22060b != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 > 0) {
                        if (list.get(i2).getCacheData() == null) {
                            list.get(i2).setCacheData(new MsgCacheData());
                        }
                        list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                    }
                }
                arrayList.addAll(this.f22060b);
            }
            this.f22061c.setData(arrayList);
        }
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (msgRightViewItemAdapter = this.f22063e) == null) {
            return;
        }
        msgRightViewItemAdapter.q0(z);
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (msgLeftViewItemAdapter = this.f22062d) == null) {
            return;
        }
        msgLeftViewItemAdapter.q0(z);
    }

    public void m(c.a.d.f.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f22065g) {
                if (msgCommonItemAdapter.h0()) {
                    msgCommonItemAdapter.m0(aVar);
                }
            }
        }
    }

    public void n(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f22065g) {
                if (msgCommonItemAdapter.i0()) {
                    msgCommonItemAdapter.n0(bVar);
                }
            }
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
        this.f22060b = null;
        this.f22065g = new ArrayList();
        this.f22066h = new a(this, 2001275);
        this.a = tbPageContext;
        this.f22061c = bdTypeListView;
        d();
        this.f22062d.o0(i2);
        this.f22063e.o0(i2);
    }
}
