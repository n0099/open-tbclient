package c.a.r0.o2;

import android.app.Activity;
import android.content.Context;
import c.a.q0.s.s.i;
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
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23193a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23194b;

    /* renamed from: c  reason: collision with root package name */
    public PopupDialog f23195c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.i f23196d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.q0.s.s.f> f23197e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.s.s.f f23198f;

    /* renamed from: g  reason: collision with root package name */
    public b f23199g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f23200h;

    /* renamed from: i  reason: collision with root package name */
    public i.d f23201i;

    /* loaded from: classes3.dex */
    public class a implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f23202a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23202a = jVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23202a.f23200h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", this.f23202a.f23200h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.f23202a.f23199g != null) {
                this.f23202a.f23199g.a(this.f23202a.f23200h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", this.f23202a.f23200h.swan_app_id.longValue());
            statisticItem.param("obj_name", this.f23202a.f23200h.name);
            TiebaStatic.log(statisticItem);
            if (this.f23202a.f23195c != null) {
                this.f23202a.f23195c.dismiss();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1792177938, "Lc/a/r0/o2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1792177938, "Lc/a/r0/o2/j;");
                return;
            }
        }
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
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
        this.f23201i = new a(this);
        this.f23193a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f23194b = pageActivity;
        this.f23196d = new c.a.q0.s.s.i(pageActivity);
        this.f23197e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
            this.f23200h = smartApp;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f23195c == null) {
            c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(this.f23194b.getString(R.string.delete), this.f23196d);
            this.f23198f = fVar;
            fVar.l(this.f23201i);
            this.f23197e.add(this.f23198f);
            this.f23196d.k(this.f23197e);
            this.f23195c = new PopupDialog(this.f23193a, this.f23196d);
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f23199g = bVar;
        }
    }

    public void g() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (popupDialog = this.f23195c) == null) {
            return;
        }
        popupDialog.showDialog();
    }
}
