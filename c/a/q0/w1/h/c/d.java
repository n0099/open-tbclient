package c.a.q0.w1.h.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f28108a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28109b;

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f28110c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.w1.h.f.a<Void> f28111d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.w1.h.f.a<Integer> f28112e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.c.g.a f28113f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f28114g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f28115h;

    /* loaded from: classes4.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f28116a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f28116a = dVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.q0.w1.h.a.d resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f28116a.f28111d == null) {
                return;
            }
            if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            if (resultData != null) {
                this.f28116a.f28110c = resultData.b();
            }
            this.f28116a.f28111d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f28117a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f28117a = dVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            c.a.q0.w1.h.a.c resultData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || this.f28117a.f28112e == null) {
                return;
            }
            if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
            } else {
                resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
            }
            this.f28117a.f28112e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f28118a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f28118a = dVar;
        }

        public final void a(c.a.q0.w1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f28118a.f28110c.size()) {
                        break;
                    } else if (((TailData) this.f28118a.f28110c.get(i2)).getId() == eVar.f28053b.getId()) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return;
                }
                this.f28118a.f28110c.add(eVar.f28053b);
            }
        }

        public final void b(c.a.q0.w1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                boolean z = false;
                for (int i2 = 0; i2 < this.f28118a.f28110c.size(); i2++) {
                    if (((TailData) this.f28118a.f28110c.get(i2)).getId() == eVar.f28053b.getId()) {
                        this.f28118a.f28110c.remove(i2);
                        if (this.f28118a.f28110c.size() != 0) {
                            Iterator it = this.f28118a.f28110c.iterator();
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

        public final void c(c.a.q0.w1.h.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
                for (int i2 = 0; i2 < this.f28118a.f28110c.size(); i2++) {
                    if (((TailData) this.f28118a.f28110c.get(i2)).getId() == eVar.f28053b.getId()) {
                        ((TailData) this.f28118a.f28110c.get(i2)).setContent(eVar.f28053b.getContent());
                        ((TailData) this.f28118a.f28110c.get(i2)).setFontColor(eVar.f28053b.getFontColor());
                        ((TailData) this.f28118a.f28110c.get(i2)).setSelected(eVar.f28053b.isSelected());
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof c.a.q0.w1.h.a.e) || this.f28118a.f28111d == null) {
                return;
            }
            c.a.q0.w1.h.a.e eVar = (c.a.q0.w1.h.a.e) customResponsedMessage.getData();
            if (eVar.f28053b == null || this.f28118a.f28110c == null) {
                return;
            }
            int i2 = eVar.f28052a;
            if (i2 == 1) {
                a(eVar);
            } else if (i2 == 3) {
                b(eVar);
            } else if (i2 == 2) {
                c(eVar);
            }
            this.f28118a.f28111d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
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
        this.f28109b = false;
        this.f28113f = new a(this, CmdConfigHttp.CMD_TAIL_GET, 305001);
        this.f28114g = new b(this, CmdConfigHttp.CMD_TAIL_DELETE, 305103);
        this.f28115h = new c(this, 2001340);
        this.f28108a = tbPageContext;
        this.f28110c = new ArrayList();
        this.f28108a.registerListener(this.f28113f);
        this.f28108a.registerListener(this.f28114g);
        this.f28108a.registerListener(this.f28115h);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f28108a.sendMessage(new DeleteTailNetMessage(i2));
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? 3 - this.f28110c.size() : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28109b : invokeV.booleanValue;
    }

    public List<TailData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28110c : (List) invokeV.objValue;
    }

    public boolean i(Serializable serializable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, serializable)) == null) {
            if (serializable != null && (serializable instanceof TailDataList)) {
                this.f28110c = ((TailDataList) serializable).getTails();
                return true;
            }
            j();
            return false;
        }
        return invokeL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28108a.sendMessage(new GetTailsNetMessage("stat"));
        }
    }

    public void k(c.a.q0.w1.h.f.a<Integer> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f28112e = aVar;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f28109b = z;
        }
    }

    public void m(c.a.q0.w1.h.f.a<Void> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f28111d = aVar;
        }
    }

    public void n(List<TailData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list == null) {
                this.f28110c.clear();
            } else {
                this.f28110c = list;
            }
        }
    }
}
