package com.baidu.tbadk.core.view.itemcard;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.view.InputDeviceCompat;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import tbclient.Item;
/* loaded from: classes3.dex */
public class ItemCardHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f12697a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f12698b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f12699c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f12700d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f12701e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f12702f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f12703g;

    /* renamed from: h  reason: collision with root package name */
    public static b f12704h;

    /* renamed from: i  reason: collision with root package name */
    public static TBSpecificationBtn f12705i;
    public static Button j;
    public static String k;
    public static final HttpMessageListener l;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class OrderTipStatus {
        public static final /* synthetic */ OrderTipStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OrderTipStatus COMPLETED;
        public static final OrderTipStatus FAIL;
        public static final OrderTipStatus SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1277966632, "Lcom/baidu/tbadk/core/view/itemcard/ItemCardHelper$OrderTipStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1277966632, "Lcom/baidu/tbadk/core/view/itemcard/ItemCardHelper$OrderTipStatus;");
                    return;
                }
            }
            COMPLETED = new OrderTipStatus("COMPLETED", 0);
            SUCCESS = new OrderTipStatus(c.f2103g, 1);
            OrderTipStatus orderTipStatus = new OrderTipStatus("FAIL", 2);
            FAIL = orderTipStatus;
            $VALUES = new OrderTipStatus[]{COMPLETED, SUCCESS, orderTipStatus};
        }

        public OrderTipStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static OrderTipStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OrderTipStatus) Enum.valueOf(OrderTipStatus.class, str) : (OrderTipStatus) invokeL.objValue;
        }

        public static OrderTipStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OrderTipStatus[]) $VALUES.clone() : (OrderTipStatus[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003496) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (ItemCardHelper.f12704h != null) {
                        ItemCardHelper.f12704h.b();
                    }
                } else if (ItemCardHelper.f12704h != null) {
                    ItemCardHelper.f12704h.success();
                    ItemCardHelper.s();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b();

        void success();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1836185595, "Lcom/baidu/tbadk/core/view/itemcard/ItemCardHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1836185595, "Lcom/baidu/tbadk/core/view/itemcard/ItemCardHelper;");
                return;
            }
        }
        f12697a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order);
        f12698b = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
        f12699c = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order_complete);
        f12700d = TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse);
        f12701e = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_completed);
        f12702f = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_successs);
        f12703g = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_fail);
        f12704h = null;
        l = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f12698b.equals(str)) {
                return 1;
            }
            if (f12697a.equals(str)) {
                return 2;
            }
            return f12700d.equals(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) || k.isEmpty(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, "", str, true)));
    }

    public static HttpMessageListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? l : (HttpMessageListener) invokeV.objValue;
    }

    public static HttpMessageTask f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            tbHttpMessageTask.setResponsedClass(OrderHttpResponsedMsg.class);
            return tbHttpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public static void g(Context context, BdUniqueId bdUniqueId, View view, int i2, ViewGroup viewGroup) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, bdUniqueId, view, Integer.valueOf(i2), viewGroup}) == null) {
            Object tag = view.getTag(R.id.item_data);
            if (tag instanceof d.a.o0.r.f0.p.a) {
                d.a.o0.r.f0.p.a aVar = (d.a.o0.r.f0.p.a) tag;
                Item a2 = aVar.a();
                int b2 = aVar.b();
                if (view instanceof TBSpecificationBtn) {
                    j = null;
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view;
                    f12705i = tBSpecificationBtn;
                    str = tBSpecificationBtn.getText();
                } else if (view instanceof Button) {
                    f12705i = null;
                    Button button = (Button) view;
                    j = button;
                    str = button.getText().toString();
                } else {
                    str = "";
                }
                if (f12697a.equals(str)) {
                    if (StringUtils.isNull(a2.button_link)) {
                        o(bdUniqueId, a2);
                    } else {
                        d(context, a2.button_link);
                    }
                    k(b2, a2.item_id.longValue(), c(a2.button_name));
                }
                if (f12698b.equals(str) && a2.button_link_type.intValue() == 2) {
                    d(context, a2.button_link);
                    k(b2, a2.item_id.longValue(), c(a2.button_name));
                }
                if (f12700d.equals(str)) {
                    ItemClickJumpUtil.itemClickJump(a2.forum_name, String.valueOf(a2.item_id), i2);
                    k(b2, a2.item_id.longValue(), c(a2.button_name));
                }
                if (f12699c.equals(str)) {
                    q(context, OrderTipStatus.COMPLETED, viewGroup);
                }
            }
        }
    }

    public static void h(Context context, BdUniqueId bdUniqueId, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, bdUniqueId, view, viewGroup) == null) {
            g(context, bdUniqueId, view, 0, viewGroup);
        }
    }

    public static boolean i(Button button, d.a.o0.r.f0.p.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, button, aVar, str)) == null) {
            k = str;
            Item a2 = aVar.a();
            if (!f12697a.equals(a2.button_name) && !f12698b.equals(a2.button_name) && !f12699c.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f12700d;
                aVar.c(builder.build(true));
            }
            button.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean j(TBSpecificationBtn tBSpecificationBtn, d.a.o0.r.f0.p.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, tBSpecificationBtn, aVar)) == null) {
            Item a2 = aVar.a();
            if (!f12697a.equals(a2.button_name) && !f12698b.equals(a2.button_name) && !f12699c.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f12700d;
                a2 = builder.build(true);
                aVar.c(a2);
            }
            if (f12699c.equals(a2.button_name)) {
                TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
                if (styleConfig instanceof d.a.o0.r.f0.n.b) {
                    ((d.a.o0.r.f0.n.b) styleConfig).r(R.color.CAM_X0109);
                }
            }
            tBSpecificationBtn.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void k(int i2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_CLICK);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void l(int i2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_SHOW);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            MessageManager.getInstance().registerListener(e());
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            MessageManager.getInstance().registerTask(f());
        }
    }

    public static void o(BdUniqueId bdUniqueId, Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, bdUniqueId, item) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
            httpMessage.setTag(bdUniqueId);
            httpMessage.addParam(LegoListActivityConfig.ITEM_ID, item.item_id);
            httpMessage.addParam("item_name", item.item_name);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void p(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, bVar) == null) {
            f12704h = bVar;
        }
    }

    public static void q(Context context, OrderTipStatus orderTipStatus, ViewGroup viewGroup) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, context, orderTipStatus, viewGroup) == null) {
            boolean z = true;
            if (orderTipStatus == OrderTipStatus.COMPLETED) {
                str = f12701e;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                str = f12702f;
            } else {
                z = false;
                str = f12703g;
            }
            BdTopToast bdTopToast = new BdTopToast(context);
            bdTopToast.i(z);
            bdTopToast.h(str);
            bdTopToast.j(viewGroup);
        }
    }

    public static void r(Button button, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, button, str) == null) {
            k = str;
            if (button.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) button.getBackground();
                gradientDrawable.setShape(0);
                if (f12699c.equals(button.getText())) {
                    button.setTextColor(d.a.p0.h3.c.a(d.a.p0.h3.c.c(str), d.a.o0.r.u.a.a(R.string.A_X09)));
                    gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), d.a.p0.h3.c.a(d.a.p0.h3.c.c(str), d.a.o0.r.u.a.a(R.string.A_X09)));
                    gradientDrawable.setColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0201));
                } else {
                    button.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    gradientDrawable.setColor(d.a.p0.h3.c.c(str));
                }
                button.setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            if (f12705i != null) {
                d.a.o0.r.f0.n.b bVar = new d.a.o0.r.f0.n.b();
                bVar.r(R.color.CAM_X0109);
                f12705i.setConfig(bVar);
                f12705i.setText(f12699c);
                f12705i.refreshDrawableState();
            }
            Button button = j;
            if (button != null) {
                button.setText(f12699c);
                r(j, k);
            }
        }
    }
}
