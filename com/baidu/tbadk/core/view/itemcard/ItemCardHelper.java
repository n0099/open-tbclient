package com.baidu.tbadk.core.view.itemcard;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
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
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes6.dex */
public class ItemCardHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f47731a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f47732b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f47733c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f47734d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f47735e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f47736f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f47737g;

    /* renamed from: h  reason: collision with root package name */
    public static b f47738h;

    /* renamed from: i  reason: collision with root package name */
    public static TBSpecificationBtn f47739i;

    /* renamed from: j  reason: collision with root package name */
    public static Button f47740j;
    public static String k;
    public static final HttpMessageListener l;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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
            SUCCESS = new OrderTipStatus(c.f35984g, 1);
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

    /* loaded from: classes6.dex */
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
                    if (ItemCardHelper.f47738h != null) {
                        ItemCardHelper.f47738h.b();
                    }
                } else if (ItemCardHelper.f47738h != null) {
                    ItemCardHelper.f47738h.success();
                    ItemCardHelper.w();
                }
                TBSpecificationBtn unused = ItemCardHelper.f47739i = null;
                Button unused2 = ItemCardHelper.f47740j = null;
            }
        }
    }

    /* loaded from: classes6.dex */
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
        f47731a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order);
        f47732b = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
        f47733c = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order_complete);
        f47734d = TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse);
        f47735e = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_completed);
        f47736f = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_successs);
        f47737g = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_fail);
        f47738h = null;
        l = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (f47732b.equals(str)) {
                return 1;
            }
            if (f47731a.equals(str)) {
                return 2;
            }
            return f47734d.equals(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) || k.isEmpty(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, "", str, true)));
    }

    public static HttpMessageListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? l : (HttpMessageListener) invokeV.objValue;
    }

    public static HttpMessageTask h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            tbHttpMessageTask.setResponsedClass(OrderHttpResponsedMsg.class);
            return tbHttpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public static void i(Context context, BdUniqueId bdUniqueId, View view, int i2, ViewGroup viewGroup) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, bdUniqueId, view, Integer.valueOf(i2), viewGroup}) == null) {
            Object tag = view.getTag(R.id.item_data);
            if (tag instanceof c.a.o0.s.f0.p.a) {
                c.a.o0.s.f0.p.a aVar = (c.a.o0.s.f0.p.a) tag;
                Item a2 = aVar.a();
                int b2 = aVar.b();
                boolean z = view instanceof TBSpecificationBtn;
                if (z) {
                    charSequence = ((TBSpecificationBtn) view).getText();
                } else {
                    charSequence = view instanceof Button ? ((Button) view).getText().toString() : "";
                }
                if (f47731a.equals(charSequence)) {
                    if (StringUtils.isNull(a2.button_link)) {
                        if (z) {
                            f47740j = null;
                            f47739i = (TBSpecificationBtn) view;
                        } else if (view instanceof Button) {
                            f47739i = null;
                            f47740j = (Button) view;
                        }
                        r(bdUniqueId, a2);
                    } else {
                        f(context, a2.button_link);
                    }
                    n(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c());
                }
                if (f47732b.equals(charSequence) && a2.button_link_type.intValue() == 2) {
                    f(context, a2.button_link);
                    n(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c());
                }
                if (f47734d.equals(charSequence)) {
                    ItemClickJumpUtil.itemClickJump(a2.forum_name, String.valueOf(a2.item_id), i2);
                    n(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c());
                }
                if (f47733c.equals(charSequence)) {
                    u(context, OrderTipStatus.COMPLETED, viewGroup);
                }
            }
        }
    }

    public static void j(Context context, BdUniqueId bdUniqueId, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65546, null, context, bdUniqueId, view, viewGroup) == null) {
            i(context, bdUniqueId, view, 0, viewGroup);
        }
    }

    public static boolean k(Button button, c.a.o0.s.f0.p.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, button, aVar, str)) == null) {
            k = str;
            Item a2 = aVar.a();
            if (!f47731a.equals(a2.button_name) && !f47732b.equals(a2.button_name) && !f47733c.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f47734d;
                a2 = builder.build(true);
                aVar.d(a2);
            }
            if (f47732b.equals(a2.button_name) && t(a2) && !m(a2)) {
                Item.Builder builder2 = new Item.Builder(a2);
                builder2.button_name = f47734d;
                aVar.d(builder2.build(true));
            }
            button.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean l(TBSpecificationBtn tBSpecificationBtn, c.a.o0.s.f0.p.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, tBSpecificationBtn, aVar)) == null) {
            Item a2 = aVar.a();
            if (!f47731a.equals(a2.button_name) && !f47732b.equals(a2.button_name) && !f47733c.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f47734d;
                a2 = builder.build(true);
                aVar.d(a2);
            }
            if (f47732b.equals(a2.button_name) && t(a2) && !m(a2)) {
                Item.Builder builder2 = new Item.Builder(a2);
                builder2.button_name = f47734d;
                a2 = builder2.build(true);
                aVar.d(a2);
            }
            if (f47733c.equals(a2.button_name)) {
                TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
                if (styleConfig instanceof c.a.o0.s.f0.n.c) {
                    ((c.a.o0.s.f0.n.c) styleConfig).o(R.color.CAM_X0109);
                }
            }
            tBSpecificationBtn.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean m(Item item) {
        InterceptResult invokeL;
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, item)) == null) ? (item == null || item.button_link_type.intValue() != 1 || TextUtils.isEmpty(item.apk_name) || TextUtils.isEmpty(item.button_link) || (apkDetail = item.apk_detail) == null || TextUtils.isEmpty(apkDetail.developer) || TextUtils.isEmpty(item.apk_detail.version) || item.apk_detail.version_code.intValue() <= 0 || TextUtils.isEmpty(item.apk_detail.authority_url) || TextUtils.isEmpty(item.apk_detail.privacy_url)) ? false : true : invokeL.booleanValue;
    }

    public static void n(int i2, long j2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_CLICK);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            statisticItem.addParam("tid", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void o(int i2, long j2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_SHOW);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            statisticItem.addParam("tid", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            MessageManager.getInstance().registerListener(g());
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            MessageManager.getInstance().registerTask(h());
        }
    }

    public static void r(BdUniqueId bdUniqueId, Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, bdUniqueId, item) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
            httpMessage.setTag(bdUniqueId);
            httpMessage.addParam("item_id", item.item_id);
            httpMessage.addParam("item_name", item.item_name);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, bVar) == null) {
            f47738h = bVar;
        }
    }

    public static boolean t(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, item)) == null) ? item != null && item.button_link_type.intValue() == 1 : invokeL.booleanValue;
    }

    public static void u(Context context, OrderTipStatus orderTipStatus, ViewGroup viewGroup) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, context, orderTipStatus, viewGroup) == null) {
            boolean z = true;
            if (orderTipStatus == OrderTipStatus.COMPLETED) {
                str = f47735e;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                str = f47736f;
            } else {
                z = false;
                str = f47737g;
            }
            new BdTopToast(context).setIcon(z).setContent(str).show(viewGroup);
        }
    }

    public static void v(Button button, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, button, str) == null) {
            k = str;
            if (button.getBackground() instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) button.getBackground();
                gradientDrawable.setShape(0);
                if (f47733c.equals(button.getText())) {
                    button.setTextColor(c.a.p0.i3.c.a(c.a.p0.i3.c.c(str), c.a.o0.s.u.a.a(R.string.A_X09)));
                    gradientDrawable.setStroke(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1), c.a.p0.i3.c.a(c.a.p0.i3.c.c(str), c.a.o0.s.u.a.a(R.string.A_X09)));
                    gradientDrawable.setColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0201));
                } else {
                    button.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    gradientDrawable.setColor(c.a.p0.i3.c.c(str));
                }
                button.setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            if (f47739i != null) {
                c.a.o0.s.f0.n.c cVar = new c.a.o0.s.f0.n.c();
                cVar.o(R.color.CAM_X0109);
                f47739i.setConfig(cVar);
                f47739i.setText(f47733c);
                f47739i.refreshDrawableState();
            }
            Button button = f47740j;
            if (button != null) {
                button.setText(f47733c);
                v(f47740j, k);
            }
        }
    }
}
