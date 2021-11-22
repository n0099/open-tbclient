package b.a.r0.y1.h.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.y1.h.f.a<Void> f29253a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.y1.h.f.a<Integer> f29254b;

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f29255c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f29256d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29257e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.c.g.a f29258f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.c.g.a f29259g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f29260h;

    /* loaded from: classes6.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f29261a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f29261a = gVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.a.r0.y1.h.a.d resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f29261a.f29253a == null) {
                return;
            }
            if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            if (resultData == null) {
                return;
            }
            this.f29261a.f29255c = new ArrayList();
            if (resultData.b() != null) {
                for (TailData tailData : resultData.b()) {
                    TailData tailData2 = new TailData();
                    tailData2.setId(tailData.getId());
                    tailData2.setContent(tailData.getContent());
                    tailData2.setFontColor(tailData.getFontColor());
                    tailData2.setFontType(tailData.getFontType());
                    tailData2.setSelected(tailData.isSelected());
                    this.f29261a.f29255c.add(tailData2);
                }
            }
            this.f29261a.f29253a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            this.f29261a.q();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f29262a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f29262a = gVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.a.r0.y1.h.a.f resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f29262a.f29253a == null) {
                return;
            }
            if (responsedMessage instanceof SetTailHttpResponseMessage) {
                resultData = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            this.f29262a.f29254b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f29263a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f29263a = gVar;
        }

        public final void a(b.a.r0.y1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f29263a.f29255c.size()) {
                        break;
                    } else if (((TailData) this.f29263a.f29255c.get(i2)).getId() == eVar.f29155b.getId()) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return;
                }
                this.f29263a.f29255c.add(eVar.f29155b);
            }
        }

        public final void b(b.a.r0.y1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                boolean z = false;
                for (int i2 = 0; i2 < this.f29263a.f29255c.size(); i2++) {
                    if (((TailData) this.f29263a.f29255c.get(i2)).getId() == eVar.f29155b.getId()) {
                        this.f29263a.f29255c.remove(i2);
                        if (this.f29263a.f29255c.size() != 0) {
                            Iterator it = this.f29263a.f29255c.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (((TailData) it.next()).isSelected()) {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
                        return;
                    }
                }
            }
        }

        public final void c(b.a.r0.y1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
                for (int i2 = 0; i2 < this.f29263a.f29255c.size(); i2++) {
                    if (((TailData) this.f29263a.f29255c.get(i2)).getId() == eVar.f29155b.getId()) {
                        ((TailData) this.f29263a.f29255c.get(i2)).setContent(eVar.f29155b.getContent());
                        ((TailData) this.f29263a.f29255c.get(i2)).setFontColor(eVar.f29155b.getFontColor());
                        ((TailData) this.f29263a.f29255c.get(i2)).setSelected(eVar.f29155b.isSelected());
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof b.a.r0.y1.h.a.e)) {
                return;
            }
            b.a.r0.y1.h.a.e eVar = (b.a.r0.y1.h.a.e) customResponsedMessage.getData();
            if (eVar.f29155b == null || this.f29263a.f29255c == null) {
                return;
            }
            int i2 = eVar.f29154a;
            if (i2 == 1) {
                a(eVar);
            } else if (i2 == 3) {
                b(eVar);
            } else if (i2 == 2) {
                c(eVar);
            }
            this.f29263a.f29253a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29256d = Boolean.FALSE;
        this.f29257e = false;
        this.f29258f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.f29259g = new b(this, CmdConfigHttp.CMD_TAIL_SET, 305104);
        this.f29260h = new c(this, 2001340);
        this.f29255c = new ArrayList();
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29256d = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29256d.booleanValue() : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29257e : invokeV.booleanValue;
    }

    public List<TailData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29255c : (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().registerListener(this.f29258f);
            MessageManager.getInstance().registerListener(this.f29259g);
            MessageManager.getInstance().registerListener(this.f29260h);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f29258f);
            MessageManager.getInstance().unRegisterListener(this.f29259g);
            MessageManager.getInstance().unRegisterListener(this.f29260h);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f29257e = z;
        }
    }

    public void n(b.a.r0.y1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f29254b = aVar;
        }
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, z ? 1 : 0));
        }
    }

    public void p(b.a.r0.y1.h.f.a<Void> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f29253a = aVar;
        }
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Iterator<TailData> it = this.f29255c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().isSelected()) {
                    z = true;
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
        }
    }
}
