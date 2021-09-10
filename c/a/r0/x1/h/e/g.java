package c.a.r0.x1.h.e;

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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.x1.h.f.a<Void> f28841a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.x1.h.f.a<Integer> f28842b;

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f28843c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f28844d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28845e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f28846f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f28847g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f28848h;

    /* loaded from: classes4.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28849a;

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
            this.f28849a = gVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.r0.x1.h.a.d resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f28849a.f28841a == null) {
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
            this.f28849a.f28843c = new ArrayList();
            if (resultData.b() != null) {
                for (TailData tailData : resultData.b()) {
                    TailData tailData2 = new TailData();
                    tailData2.setId(tailData.getId());
                    tailData2.setContent(tailData.getContent());
                    tailData2.setFontColor(tailData.getFontColor());
                    tailData2.setFontType(tailData.getFontType());
                    tailData2.setSelected(tailData.isSelected());
                    this.f28849a.f28843c.add(tailData2);
                }
            }
            this.f28849a.f28841a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
            this.f28849a.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28850a;

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
            this.f28850a = gVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.r0.x1.h.a.f resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f28850a.f28841a == null) {
                return;
            }
            if (responsedMessage instanceof SetTailHttpResponseMessage) {
                resultData = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            this.f28850a.f28842b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f28851a;

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
            this.f28851a = gVar;
        }

        public final void a(c.a.r0.x1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f28851a.f28843c.size()) {
                        break;
                    } else if (((TailData) this.f28851a.f28843c.get(i2)).getId() == eVar.f28740b.getId()) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return;
                }
                this.f28851a.f28843c.add(eVar.f28740b);
            }
        }

        public final void b(c.a.r0.x1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                boolean z = false;
                for (int i2 = 0; i2 < this.f28851a.f28843c.size(); i2++) {
                    if (((TailData) this.f28851a.f28843c.get(i2)).getId() == eVar.f28740b.getId()) {
                        this.f28851a.f28843c.remove(i2);
                        if (this.f28851a.f28843c.size() != 0) {
                            Iterator it = this.f28851a.f28843c.iterator();
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

        public final void c(c.a.r0.x1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
                for (int i2 = 0; i2 < this.f28851a.f28843c.size(); i2++) {
                    if (((TailData) this.f28851a.f28843c.get(i2)).getId() == eVar.f28740b.getId()) {
                        ((TailData) this.f28851a.f28843c.get(i2)).setContent(eVar.f28740b.getContent());
                        ((TailData) this.f28851a.f28843c.get(i2)).setFontColor(eVar.f28740b.getFontColor());
                        ((TailData) this.f28851a.f28843c.get(i2)).setSelected(eVar.f28740b.isSelected());
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof c.a.r0.x1.h.a.e)) {
                return;
            }
            c.a.r0.x1.h.a.e eVar = (c.a.r0.x1.h.a.e) customResponsedMessage.getData();
            if (eVar.f28740b == null || this.f28851a.f28843c == null) {
                return;
            }
            int i2 = eVar.f28739a;
            if (i2 == 1) {
                a(eVar);
            } else if (i2 == 3) {
                b(eVar);
            } else if (i2 == 2) {
                c(eVar);
            }
            this.f28851a.f28841a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
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
        this.f28844d = Boolean.FALSE;
        this.f28845e = false;
        this.f28846f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.f28847g = new b(this, CmdConfigHttp.CMD_TAIL_SET, 305104);
        this.f28848h = new c(this, 2001340);
        this.f28843c = new ArrayList();
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28844d = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28844d.booleanValue() : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28845e : invokeV.booleanValue;
    }

    public List<TailData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28843c : (List) invokeV.objValue;
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
            MessageManager.getInstance().registerListener(this.f28846f);
            MessageManager.getInstance().registerListener(this.f28847g);
            MessageManager.getInstance().registerListener(this.f28848h);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f28846f);
            MessageManager.getInstance().unRegisterListener(this.f28847g);
            MessageManager.getInstance().unRegisterListener(this.f28848h);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f28845e = z;
        }
    }

    public void n(c.a.r0.x1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f28842b = aVar;
        }
    }

    public void o(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, z ? 1 : 0));
        }
    }

    public void p(c.a.r0.x1.h.f.a<Void> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f28841a = aVar;
        }
    }

    public final void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Iterator<TailData> it = this.f28843c.iterator();
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
