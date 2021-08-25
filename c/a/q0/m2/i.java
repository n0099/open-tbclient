package c.a.q0.m2;

import android.app.Activity;
import android.content.Context;
import c.a.p0.s.s.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22425a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22426b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f22427c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.s.s.i f22428d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.p0.s.s.f> f22429e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.s.s.f f22430f;

    /* renamed from: g  reason: collision with root package name */
    public b f22431g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f22432h;

    /* renamed from: i  reason: collision with root package name */
    public i.d f22433i;

    /* loaded from: classes3.dex */
    public class a implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22434a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22434a = iVar;
        }

        @Override // c.a.p0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22434a.f22432h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", this.f22434a.f22432h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.f22434a.f22431g != null) {
                this.f22434a.f22431g.a(this.f22434a.f22432h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", this.f22434a.f22432h.swan_app_id.longValue());
            statisticItem.param("obj_name", this.f22434a.f22432h.name);
            TiebaStatic.log(statisticItem);
            if (this.f22434a.f22427c != null) {
                this.f22434a.f22427c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(47520530, "Lc/a/q0/m2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(47520530, "Lc/a/q0/m2/i;");
                return;
            }
        }
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22433i = new a(this);
        this.f22425a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f22426b = pageActivity;
        this.f22428d = new c.a.p0.s.s.i(pageActivity);
        this.f22429e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
            this.f22432h = smartApp;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22427c == null) {
            c.a.p0.s.s.f fVar = new c.a.p0.s.s.f(this.f22426b.getString(R.string.delete), this.f22428d);
            this.f22430f = fVar;
            fVar.l(this.f22433i);
            this.f22429e.add(this.f22430f);
            this.f22428d.k(this.f22429e);
            this.f22427c = new PopupDialog(this.f22425a, this.f22428d);
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f22431g = bVar;
        }
    }

    public void g() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (popupDialog = this.f22427c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
