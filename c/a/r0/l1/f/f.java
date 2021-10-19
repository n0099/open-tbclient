package c.a.r0.l1.f;

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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<MsglistActivity<?>> f21417a;

    /* renamed from: b  reason: collision with root package name */
    public List<ChatMessage> f21418b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f21419c;

    /* renamed from: d  reason: collision with root package name */
    public MsgLeftViewItemAdapter f21420d;

    /* renamed from: e  reason: collision with root package name */
    public MsgRightViewItemAdapter f21421e;

    /* renamed from: f  reason: collision with root package name */
    public MsgMidViewItemAdapter f21422f;

    /* renamed from: g  reason: collision with root package name */
    public List<MsgCommonItemAdapter> f21423g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f21424h;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f21425a;

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
            this.f21425a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f52922b == null || aVar.f52921a == null) {
                return;
            }
            this.f21425a.f21423g.addAll(aVar.f52922b);
            this.f21425a.f21419c.addAdapters(new ArrayList(this.f21425a.f21423g));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21418b : (List) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.f21417a, ChatMessage.TYPE_MSG_LEFT);
            this.f21420d = msgLeftViewItemAdapter;
            msgLeftViewItemAdapter.l0(true);
            this.f21420d.m0(true);
            MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.f21417a, ChatMessage.TYPE_MSG_RIGHT);
            this.f21421e = msgRightViewItemAdapter;
            msgRightViewItemAdapter.l0(true);
            this.f21421e.m0(true);
            this.f21422f = new MsgMidViewItemAdapter(this.f21417a, ChatMessage.TYPE_MSG_MID);
            this.f21423g.add(this.f21420d);
            this.f21423g.add(this.f21421e);
            this.f21423g.add(this.f21422f);
            e();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.f52922b = new ArrayList();
            aVar.f52921a = this.f21417a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f21424h.setPriority(Integer.MAX_VALUE);
            this.f21417a.registerListener(this.f21424h);
        }
    }

    public void f(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && (this.f21419c.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f21419c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f21419c.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f21419c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (this.f21419c.getAdapter2() instanceof c.a.e.l.e.e)) {
            this.f21419c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f21424h == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.f21424h);
        this.f21424h = null;
    }

    public void j(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f21418b = list;
            ArrayList arrayList = new ArrayList();
            if (this.f21418b != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 > 0) {
                        if (list.get(i2).getCacheData() == null) {
                            list.get(i2).setCacheData(new MsgCacheData());
                        }
                        list.get(i2).getCacheData().setLastMsgTime(list.get(i2 - 1).getTime());
                    }
                }
                arrayList.addAll(this.f21418b);
            }
            this.f21419c.setData(arrayList);
        }
    }

    public void k(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (msgRightViewItemAdapter = this.f21421e) == null) {
            return;
        }
        msgRightViewItemAdapter.r0(z);
    }

    public void l(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (msgLeftViewItemAdapter = this.f21420d) == null) {
            return;
        }
        msgLeftViewItemAdapter.r0(z);
    }

    public void m(c.a.e.e.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f21423g) {
                if (msgCommonItemAdapter.i0()) {
                    msgCommonItemAdapter.n0(aVar);
                }
            }
        }
    }

    public void n(c.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.f21423g) {
                if (msgCommonItemAdapter.j0()) {
                    msgCommonItemAdapter.o0(bVar);
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
        this.f21418b = null;
        this.f21423g = new ArrayList();
        this.f21424h = new a(this, 2001275);
        this.f21417a = tbPageContext;
        this.f21419c = bdTypeListView;
        d();
        this.f21420d.p0(i2);
        this.f21421e.p0(i2);
    }
}
