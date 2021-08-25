package com.baidu.tbadk.core.view.itemcard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
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
    public static final String f47828a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f47829b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f47830c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f47831d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f47832e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f47833f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f47834g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f47835h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f47836i;

    /* renamed from: j  reason: collision with root package name */
    public static b f47837j;
    public static TBSpecificationBtn k;
    public static TextView l;
    public static String m;
    public static final HttpMessageListener n;
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
            SUCCESS = new OrderTipStatus(c.f36090g, 1);
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
                    if (ItemCardHelper.f47837j != null) {
                        ItemCardHelper.f47837j.b();
                    }
                } else if (ItemCardHelper.f47837j != null) {
                    ItemCardHelper.f47837j.success();
                    ItemCardHelper.w();
                }
                TBSpecificationBtn unused = ItemCardHelper.k = null;
                TextView unused2 = ItemCardHelper.l = null;
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
        f47828a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order);
        f47829b = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
        f47830c = TbadkCoreApplication.getInst().getResources().getString(R.string.item_try_play);
        f47831d = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order_complete);
        f47832e = TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse);
        f47833f = TbadkCoreApplication.getInst().getResources().getString(R.string.item_coming_soon);
        f47834g = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_completed);
        f47835h = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_successs);
        f47836i = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_fail);
        f47837j = null;
        n = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (f47829b.equals(str)) {
                return 2;
            }
            if (f47828a.equals(str)) {
                return 1;
            }
            return f47832e.equals(str) ? 3 : -1;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? n : (HttpMessageListener) invokeV.objValue;
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
            if (tag instanceof c.a.p0.s.f0.p.a) {
                c.a.p0.s.f0.p.a aVar = (c.a.p0.s.f0.p.a) tag;
                Item a2 = aVar.a();
                int b2 = aVar.b();
                boolean z = view instanceof TBSpecificationBtn;
                if (z) {
                    charSequence = ((TBSpecificationBtn) view).getText();
                } else {
                    charSequence = view instanceof TextView ? ((TextView) view).getText().toString() : "";
                }
                String str = charSequence;
                int intValue = a2.button_link_type.intValue();
                ApkDetail apkDetail = a2.apk_detail;
                int a3 = c.a.p0.s.f0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0);
                if (f47828a.equals(str)) {
                    if (StringUtils.isNull(a2.button_link)) {
                        if (z) {
                            l = null;
                            k = (TBSpecificationBtn) view;
                        } else if (view instanceof TextView) {
                            k = null;
                            l = (TextView) view;
                        }
                        r(bdUniqueId, a2);
                    } else {
                        f(context, a2.button_link);
                    }
                    n(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c(), a3, "");
                }
                if (f47829b.equals(str) && a2.button_link_type.intValue() == 2) {
                    f(context, a2.button_link);
                    n(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c(), a3, "");
                }
                if (f47832e.equals(str)) {
                    Object tag2 = view.getTag(R.id.item_coming_soon);
                    boolean booleanValue = tag2 instanceof Boolean ? ((Boolean) tag2).booleanValue() : false;
                    ItemClickJumpUtil.itemClickJump(a2.forum_name, String.valueOf(a2.item_id), i2);
                    n(b2, a2.item_id.longValue(), booleanValue ? 9 : e(a2.button_name), aVar.c(), a3, "");
                }
                if (f47831d.equals(str)) {
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

    public static boolean k(TextView textView, c.a.p0.s.f0.p.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, aVar, str)) == null) {
            m = str;
            Item a2 = aVar.a();
            if (!f47828a.equals(a2.button_name) && !f47829b.equals(a2.button_name) && !f47831d.equals(a2.button_name) && !f47833f.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f47832e;
                a2 = builder.build(true);
                aVar.d(a2);
            }
            if ((f47829b.equals(a2.button_name) || f47830c.equals(a2.button_name)) && t(a2) && !m(a2)) {
                Item.Builder builder2 = new Item.Builder(a2);
                builder2.button_name = f47832e;
                aVar.d(builder2.build(true));
            }
            textView.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean l(TBSpecificationBtn tBSpecificationBtn, c.a.p0.s.f0.p.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, tBSpecificationBtn, aVar)) == null) {
            Item a2 = aVar.a();
            boolean equals = f47833f.equals(a2.button_name);
            if (!f47828a.equals(a2.button_name) && !f47829b.equals(a2.button_name) && !f47831d.equals(a2.button_name) && !f47830c.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f47832e;
                a2 = builder.build(true);
                aVar.d(a2);
            }
            if ((f47829b.equals(a2.button_name) || f47830c.equals(a2.button_name)) && t(a2) && !m(a2)) {
                Item.Builder builder2 = new Item.Builder(a2);
                builder2.button_name = f47832e;
                a2 = builder2.build(true);
                aVar.d(a2);
            }
            if (f47831d.equals(a2.button_name)) {
                TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
                if (styleConfig instanceof c.a.p0.s.f0.n.c) {
                    ((c.a.p0.s.f0.n.c) styleConfig).o(R.color.CAM_X0109);
                }
            }
            tBSpecificationBtn.setTag(R.id.item_data, aVar);
            tBSpecificationBtn.setTag(R.id.item_coming_soon, Boolean.valueOf(equals));
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

    public static void n(int i2, long j2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_CLICK);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            statisticItem.addParam("tid", str);
            statisticItem.addParam("obj_param1", i4);
            if (!StringUtils.isNull(str2)) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
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
            f47837j = bVar;
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
                str = f47834g;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                str = f47835h;
            } else {
                z = false;
                str = f47836i;
            }
            new BdTopToast(context).setIcon(z).setContent(str).show(viewGroup);
        }
    }

    public static void v(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, textView, str) == null) {
            m = str;
            if (textView.getBackground() instanceof c.a.p0.s.u.b) {
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
                if (!f47831d.equals(textView.getText().toString()) && !f47833f.equals(textView.getText().toString())) {
                    textView.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    d2.n(R.string.J_X01);
                    d2.k(R.color.transparent);
                    d2.g(c.a.q0.i3.c.c(m));
                } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                    textView.setTextColor(c.a.q0.i3.c.a(c.a.q0.i3.c.c(m), c.a.p0.s.u.a.a(R.string.A_X01)));
                    d2.l(R.dimen.tbds1);
                    d2.s(c.a.q0.i3.c.a(c.a.q0.i3.c.c(m), c.a.p0.s.u.a.a(R.string.A_X07)));
                    d2.n(R.string.J_X01);
                    d2.f(R.color.CAM_X0209);
                } else {
                    c.a.p0.s.u.c.d(textView).u(R.color.CAM_X0103);
                    d2.l(R.dimen.tbds1);
                    d2.k(R.color.CAM_X0209);
                    d2.n(R.string.J_X01);
                    d2.f(R.color.CAM_X0209);
                }
            }
        }
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, null) == null) {
            if (k != null) {
                c.a.p0.s.f0.n.c cVar = new c.a.p0.s.f0.n.c();
                cVar.o(R.color.CAM_X0109);
                k.setConfig(cVar);
                k.setText(f47831d);
                k.refreshDrawableState();
            }
            TextView textView = l;
            if (textView != null) {
                textView.setText(f47831d);
                v(l, m);
            }
        }
    }
}
