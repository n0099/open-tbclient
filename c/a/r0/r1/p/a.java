package c.a.r0.r1.p;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.t.e.f;
import c.a.r0.r1.t.c;
import c.a.r0.r1.t.d;
import c.a.r0.r1.t.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f23092c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImMessageCenterPojo> a;

    /* renamed from: b  reason: collision with root package name */
    public final CustomMessageListener f23093b;

    /* renamed from: c.a.r0.r1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1331a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1331a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.t(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.s(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.u(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                if (this.a.a != null) {
                    this.a.a.clear();
                }
                c.a.q0.t.d.b.g0().f0(new f());
                c.a.q0.t.d.b.g0().b0(0);
                c.a.q0.t.d.b.g0().a();
                c.a.q0.t.d.b.g0().l();
            } else if (customResponsedMessage.getCmd() != 2016010 || this.a.a == null) {
            } else {
                this.a.v(false);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList();
        this.f23093b = new C1331a(this, 0);
        w();
    }

    public static a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (f23092c == null) {
                synchronized (a.class) {
                    if (f23092c == null) {
                        f23092c = new a();
                    }
                }
            }
            return f23092c;
        }
        return (a) invokeV.objValue;
    }

    public final boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void g(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterPojo, fVar) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.a().b()) {
            fVar.T(imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo, fVar) == null) || imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 4 || !d.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) || StringUtils.isNull(imMessageCenterPojo.getLast_content()) || imMessageCenterPojo.getUnread_count() <= 0 || (userType = imMessageCenterPojo.getUserType()) == 3) {
            return;
        }
        f.a aVar = new f.a();
        aVar.a = imMessageCenterPojo.getGid();
        aVar.f13519e = imMessageCenterPojo.getGroup_name();
        if (userType == 4) {
            String str4 = null;
            try {
                jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
            } catch (Exception e2) {
                e = e2;
                str = null;
                str2 = null;
            }
            if (jSONArray.length() == 1) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                str = jSONObject.optString("title", null);
                try {
                    str2 = jSONObject.optString("text", null);
                } catch (Exception e3) {
                    e = e3;
                    str2 = null;
                }
                try {
                    str3 = jSONObject.optString("isShow", null);
                } catch (Exception e4) {
                    e = e4;
                    BdLog.e(e);
                    str3 = null;
                    str4 = str;
                    if (str2 == null) {
                    }
                    if (str4 == null) {
                    }
                    aVar.f13516b = str4;
                    aVar.f13517c = str2;
                    aVar.f13523i = str3;
                    aVar.f13518d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                    aVar.f13520f = userType;
                    aVar.f13521g = imMessageCenterPojo.getUnread_count();
                    fVar.g().add(aVar);
                    if (userType == 4) {
                    }
                    fVar.U(fVar.u() + imMessageCenterPojo.getUnread_count());
                }
                str4 = str;
                if (str2 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                    str2 = imMessageCenterPojo.getLast_content();
                }
                if (str4 == null) {
                    str4 = imMessageCenterPojo.getGroup_name();
                }
                aVar.f13516b = str4;
                aVar.f13517c = str2;
                aVar.f13523i = str3;
                aVar.f13518d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            } else {
                str3 = null;
                str2 = null;
                if (str2 == null) {
                }
                if (str4 == null) {
                }
                aVar.f13516b = str4;
                aVar.f13517c = str2;
                aVar.f13523i = str3;
                aVar.f13518d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
            }
        } else {
            String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
            aVar.f13517c = str5;
            aVar.f13518d = str5;
        }
        aVar.f13520f = userType;
        aVar.f13521g = imMessageCenterPojo.getUnread_count();
        fVar.g().add(aVar);
        if (userType == 4) {
            fVar.S(fVar.s() + imMessageCenterPojo.getUnread_count());
        }
        fVar.U(fVar.u() + imMessageCenterPojo.getUnread_count());
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, imMessageCenterPojo, fVar) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && e.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                fVar.H(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> h2 = fVar.h();
                if (h2 != null) {
                    h2.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            fVar.W(fVar.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, imMessageCenterPojo, fVar) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && c.a.r0.r1.t.f.a().b()) {
            fVar.Y(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, imMessageCenterPojo, fVar) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -3) {
            fVar.B(imMessageCenterPojo.getGroup_name());
            fVar.G(imMessageCenterPojo.getLast_content());
            fVar.O(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imMessageCenterPojo, fVar) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -4) {
            fVar.Q(imMessageCenterPojo.getUnread_count());
            fVar.I(imMessageCenterPojo.getLast_content());
            fVar.C(imMessageCenterPojo.getGroup_name());
        }
    }

    public final void m(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, imMessageCenterPojo, fVar) == null) && imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 1) {
            HashMap<String, String> a = fVar.a();
            if (!c.a.r0.r1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
                fVar.M(fVar.l() + imMessageCenterPojo.getUnread_count());
            } else if (imMessageCenterPojo.getUnread_count() > 0) {
                if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                    fVar.F(imMessageCenterPojo.getLast_content());
                } else {
                    fVar.F(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
                }
                a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
            }
            fVar.L(fVar.j() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void n(List<f.a> list, List<f.a> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) || list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return;
        }
        for (f.a aVar : list) {
            if (aVar != null) {
                for (f.a aVar2 : list2) {
                    if (aVar2 != null && StringHelper.equals(aVar.a, aVar2.a)) {
                        aVar.f13522h = aVar2.f13521g;
                    }
                }
            }
        }
    }

    public final void p(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        x(imMessageCenterPojo, list);
        list.add(imMessageCenterPojo);
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo == null) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return f(imMessageCenterPojo);
            }
            if (imMessageCenterPojo.getCustomGroupType() == -8) {
                return true;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                return f(imMessageCenterPojo);
            }
            return imMessageCenterPojo.getCustomGroupType() == -7;
        }
        return invokeL.booleanValue;
    }

    public final boolean r(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                return e.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return false;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 4) {
                return d.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            }
            if (imMessageCenterPojo.getCustomGroupType() != -3) {
                imMessageCenterPojo.getCustomGroupType();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void s(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean r = r(data);
            if (memoryChangedMessage.getType() == 1) {
                p(data, this.a);
            } else if (memoryChangedMessage.getType() == 2) {
                x(data, this.a);
            }
            v(r);
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void u(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.a.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (q(imMessageCenterPojo)) {
                        this.a.add(imMessageCenterPojo);
                    }
                }
            }
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            f fVar = new f();
            fVar.K(z);
            y(fVar);
            fVar.D();
            fVar.E();
            fVar.X(c.a.q0.t.d.b.g0().F().w());
            fVar.N(c.a.q0.t.d.b.g0().F().k());
            fVar.V(c.a.q0.t.d.b.g0().F().u());
            fVar.R(c.a.q0.t.d.b.g0().F().q());
            fVar.P(c.a.q0.t.d.b.g0().F().n());
            n(fVar.g(), c.a.q0.t.d.b.g0().F().g());
            if (!c.a.q0.t.d.d.d().n()) {
                fVar.L(0);
            }
            if (!c.a.q0.t.d.d.d().p()) {
                fVar.W(0);
            }
            if (!c.a.q0.t.d.d.d().l()) {
                fVar.U(0);
                fVar.T(0);
                fVar.S(0);
            }
            if (c.a.q0.t.d.d.d().e() <= 0) {
                fVar.L(0);
                fVar.W(0);
                fVar.T(0);
                fVar.U(0);
                fVar.S(0);
                fVar.Y(0);
                fVar.K(false);
            }
            if ((((((fVar.w() + fVar.j()) + fVar.n()) + fVar.q()) + fVar.t()) + fVar.u()) - fVar.l() <= 0) {
                fVar.K(false);
            }
            c.a.q0.t.d.b.g0().V(fVar);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(2016004, this.f23093b);
            MessageManager.getInstance().registerListener(2016007, this.f23093b);
            MessageManager.getInstance().registerListener(2016001, this.f23093b);
            MessageManager.getInstance().registerListener(2016010, this.f23093b);
            MessageManager.getInstance().registerListener(2016002, this.f23093b);
        }
    }

    public final void x(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, imMessageCenterPojo, list) == null) || imMessageCenterPojo == null || list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImMessageCenterPojo imMessageCenterPojo2 = list.get(i2);
            if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                list.remove(i2);
                return;
            }
        }
    }

    public final void y(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) || fVar == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && q(imMessageCenterPojo)) {
                m(imMessageCenterPojo, fVar);
                h(imMessageCenterPojo, fVar);
                i(imMessageCenterPojo, fVar);
                l(imMessageCenterPojo, fVar);
                k(imMessageCenterPojo, fVar);
                g(imMessageCenterPojo, fVar);
                j(imMessageCenterPojo, fVar);
            }
        }
    }
}
