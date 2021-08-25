package c.a.p0.a;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public v f12667a;

    /* renamed from: b  reason: collision with root package name */
    public long f12668b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f12669c;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u f12670a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, Integer.valueOf(i2)};
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
            this.f12670a = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f12670a.g();
        }
    }

    public u() {
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
        this.f12669c = new a(this, 2001371);
        this.f12667a = new v();
        MessageManager.getInstance().registerListener(this.f12669c);
        g();
        this.f12668b = c.a.p0.s.d0.b.j().l("key_redpacket_pop_last_time", 0L);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d() && e()) {
            f();
        }
    }

    public final boolean c(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar)) == null) ? zVar != null && this.f12668b >= zVar.b() && this.f12668b <= zVar.a() : invokeL.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Date date = new Date();
            return date.getTime() >= this.f12667a.b() && date.getTime() <= this.f12667a.a();
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (ListUtils.isEmpty(this.f12667a.c())) {
                return false;
            }
            Date date = new Date();
            Iterator<z> it = this.f12667a.c().iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (date.getTime() >= next.b() && date.getTime() <= next.a() && !c(next)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || c.a.e.e.p.k.isEmpty(this.f12667a.d())) {
            return;
        }
        this.f12668b = System.currentTimeMillis();
        c.a.p0.s.d0.b.j().w("key_redpacket_pop_last_time", this.f12668b);
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RED_PACKET_POP_WINDOW_SHOW));
        String str = this.f12667a.d() + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(currentActivity, "", str, true)));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f12667a.e(c.a.p0.s.d0.b.j().p("key_redpacket_pop", ""));
        }
    }
}
