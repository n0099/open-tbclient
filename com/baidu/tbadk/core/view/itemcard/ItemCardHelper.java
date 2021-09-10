package com.baidu.tbadk.core.view.itemcard;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.e.e.p.k;
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
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
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
import com.baidu.tieba.view.ScreenTopToast;
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
    public static final String f47951a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f47952b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f47953c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f47954d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f47955e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f47956f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f47957g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f47958h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f47959i;

    /* renamed from: j  reason: collision with root package name */
    public static c f47960j;
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
            SUCCESS = new OrderTipStatus(com.alipay.security.mobile.module.http.model.c.f36199g, 1);
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
                int statusCode = httpResponsedMessage.getStatusCode();
                long parseLong = Long.parseLong((String) ((HttpMessage) httpResponsedMessage.getOrginalMessage()).getParams().get("item_id"));
                if (statusCode != 200 || error != 0) {
                    if (ItemCardHelper.f47960j != null) {
                        ItemCardHelper.f47960j.b();
                    }
                } else if (ItemCardHelper.f47960j != null) {
                    ItemCardHelper.f47960j.a(parseLong);
                    ItemCardHelper.z();
                }
                TBSpecificationBtn unused = ItemCardHelper.k = null;
                TextView unused2 = ItemCardHelper.l = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f47962f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47963g;

        public b(String str, long j2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47961e = str;
            this.f47962f = j2;
            this.f47963g = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.h(2, this.f47961e, this.f47962f);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.f47963g, 3)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(long j2);

        void b();
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
        f47951a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order);
        f47952b = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
        f47953c = TbadkCoreApplication.getInst().getResources().getString(R.string.item_try_play);
        f47954d = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order_complete);
        f47955e = TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse);
        f47956f = TbadkCoreApplication.getInst().getResources().getString(R.string.item_coming_soon);
        f47957g = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_completed);
        f47958h = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_successs);
        f47959i = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_fail);
        f47960j = null;
        n = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (f47952b.equals(str)) {
                return 2;
            }
            if (f47951a.equals(str)) {
                return 1;
            }
            return f47955e.equals(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static void f(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4) == null) {
            TiebaStatic.log(new StatisticItem(i2 == 3 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_DOWNLOADING_CLICK : i2 == 1 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_ORDERED_CLICK : "").addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("obj_locate", i3).addParam("obj_type", i4));
        }
    }

    public static void g(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(65543, null, i2, i3, str) == null) || f47954d.equals(str)) {
            return;
        }
        TiebaStatic.log(new StatisticItem(i2 == 3 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_DOWNLOADING_CLICK : i2 == 1 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_ORDERED_CLICK : "").addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("obj_locate", i3).addParam("obj_type", e(str)));
    }

    public static void h(int i2, String str, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            if ("PbActivity".equals(str)) {
                i3 = 1;
            } else if ("FrsActivity".equals(str)) {
                i3 = 2;
            } else {
                i3 = "MainTabActivity".equals(str) ? 5 : 0;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_TOAST_DOWNLOAD_MANAGER_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("obj_type", i2).addParam("obj_source", j2).addParam("obj_locate", i3));
        }
    }

    public static void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) || k.isEmpty(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, "", str, true)));
    }

    public static HttpMessageListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? n : (HttpMessageListener) invokeV.objValue;
    }

    public static HttpMessageTask k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            tbHttpMessageTask.setResponsedClass(OrderHttpResponsedMsg.class);
            return tbHttpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public static void l(Context context, BdUniqueId bdUniqueId, View view, int i2, ViewGroup viewGroup) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, bdUniqueId, view, Integer.valueOf(i2), viewGroup}) == null) {
            Object tag = view.getTag(R.id.item_data);
            if (tag instanceof c.a.q0.s.f0.p.a) {
                c.a.q0.s.f0.p.a aVar = (c.a.q0.s.f0.p.a) tag;
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
                int a3 = c.a.q0.s.f0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0);
                if (f47951a.equals(str)) {
                    if (StringUtils.isNull(a2.button_link)) {
                        if (z) {
                            l = null;
                            k = (TBSpecificationBtn) view;
                        } else if (view instanceof TextView) {
                            k = null;
                            l = (TextView) view;
                        }
                        u(bdUniqueId, a2);
                    } else {
                        i(context, a2.button_link);
                    }
                    if (b2 != 7) {
                        q(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c(), a3, "");
                    }
                }
                if (f47952b.equals(str) && a2.button_link_type.intValue() == 2) {
                    i(context, a2.button_link);
                    if (b2 != 7) {
                        q(b2, a2.item_id.longValue(), e(a2.button_name), aVar.c(), a3, "");
                    }
                }
                if (f47955e.equals(str)) {
                    Object tag2 = view.getTag(R.id.item_coming_soon);
                    boolean booleanValue = tag2 instanceof Boolean ? ((Boolean) tag2).booleanValue() : false;
                    ItemClickJumpUtil.itemClickJump(a2.forum_name, String.valueOf(a2.item_id), i2);
                    q(b2, a2.item_id.longValue(), booleanValue ? 9 : e(a2.button_name), aVar.c(), a3, "");
                }
                if (f47954d.equals(str)) {
                    x(context, OrderTipStatus.COMPLETED, viewGroup, 0L);
                }
            }
        }
    }

    public static void m(Context context, BdUniqueId bdUniqueId, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, context, bdUniqueId, view, viewGroup) == null) {
            l(context, bdUniqueId, view, 0, viewGroup);
        }
    }

    public static boolean n(TextView textView, c.a.q0.s.f0.p.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, textView, aVar, str)) == null) {
            m = str;
            Item a2 = aVar.a();
            if (!f47951a.equals(a2.button_name) && !f47952b.equals(a2.button_name) && !f47954d.equals(a2.button_name) && !f47956f.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f47955e;
                a2 = builder.build(true);
                aVar.d(a2);
            }
            if ((f47952b.equals(a2.button_name) || f47953c.equals(a2.button_name)) && w(a2) && !p(a2)) {
                Item.Builder builder2 = new Item.Builder(a2);
                builder2.button_name = f47955e;
                aVar.d(builder2.build(true));
            }
            textView.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean o(TBSpecificationBtn tBSpecificationBtn, c.a.q0.s.f0.p.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, tBSpecificationBtn, aVar)) == null) {
            Item a2 = aVar.a();
            boolean equals = f47956f.equals(a2.button_name);
            if (!f47951a.equals(a2.button_name) && !f47952b.equals(a2.button_name) && !f47954d.equals(a2.button_name) && !f47953c.equals(a2.button_name)) {
                Item.Builder builder = new Item.Builder(a2);
                builder.button_name = f47955e;
                a2 = builder.build(true);
                aVar.d(a2);
            }
            if ((f47952b.equals(a2.button_name) || f47953c.equals(a2.button_name)) && w(a2) && !p(a2)) {
                Item.Builder builder2 = new Item.Builder(a2);
                builder2.button_name = f47955e;
                a2 = builder2.build(true);
                aVar.d(a2);
            }
            TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
            if (styleConfig instanceof c.a.q0.s.f0.n.c) {
                ((c.a.q0.s.f0.n.c) styleConfig).o(R.color.CAM_X0109);
            } else if (styleConfig instanceof c.a.q0.s.f0.n.b) {
                if (f47954d.equals(a2.button_name)) {
                    ((c.a.q0.s.f0.n.b) styleConfig).r(R.color.CAM_X0109);
                } else {
                    ((c.a.q0.s.f0.n.b) styleConfig).o(R.color.CAM_X0302, R.color.CAM_X0101);
                }
            }
            tBSpecificationBtn.setConfig(styleConfig);
            tBSpecificationBtn.setTag(R.id.item_data, aVar);
            tBSpecificationBtn.setTag(R.id.item_coming_soon, Boolean.valueOf(equals));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(Item item) {
        InterceptResult invokeL;
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, item)) == null) ? (item == null || item.button_link_type.intValue() != 1 || TextUtils.isEmpty(item.apk_name) || TextUtils.isEmpty(item.button_link) || (apkDetail = item.apk_detail) == null || TextUtils.isEmpty(apkDetail.developer) || TextUtils.isEmpty(item.apk_detail.version) || item.apk_detail.version_code.intValue() <= 0 || TextUtils.isEmpty(item.apk_detail.authority_url) || TextUtils.isEmpty(item.apk_detail.privacy_url)) ? false : true : invokeL.booleanValue;
    }

    public static void q(int i2, long j2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2}) == null) {
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

    public static void r(int i2, long j2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_SHOW);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            statisticItem.addParam("tid", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            MessageManager.getInstance().registerListener(j());
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            MessageManager.getInstance().registerTask(k());
        }
    }

    public static void u(BdUniqueId bdUniqueId, Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, bdUniqueId, item) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
            httpMessage.setTag(bdUniqueId);
            httpMessage.addParam("item_id", item.item_id);
            httpMessage.addParam("item_name", item.item_name);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void v(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, cVar) == null) {
            f47960j = cVar;
        }
    }

    public static boolean w(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, item)) == null) ? item != null && item.button_link_type.intValue() == 1 : invokeL.booleanValue;
    }

    public static void x(Context context, OrderTipStatus orderTipStatus, ViewGroup viewGroup, long j2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, orderTipStatus, viewGroup, Long.valueOf(j2)}) == null) {
            boolean z = false;
            if (orderTipStatus == OrderTipStatus.COMPLETED) {
                str = f47957g;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                String simpleName = ((Activity) context).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && c.a.q0.s.d0.b.j().g("key_download_manager_first_toast", true)) {
                    c.a.q0.s.d0.b.j().t("key_download_manager_first_toast", false);
                    h(1, simpleName, j2);
                    new ScreenTopToast(context).setTitle(context.getString(R.string.item_first_use_download_manager_toast)).setBtnText(context.getString(R.string.dialog_confirm_see)).setBtnClickListener(new b(simpleName, j2, context)).show(viewGroup);
                    return;
                }
                str = f47958h;
            } else {
                str = f47959i;
                new BdTopToast(context).setIcon(z).setContent(str).show(viewGroup);
            }
            z = true;
            new BdTopToast(context).setIcon(z).setContent(str).show(viewGroup);
        }
    }

    public static void y(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, textView, str) == null) {
            m = str;
            if (textView.getBackground() instanceof c.a.q0.s.u.b) {
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
                if (!f47954d.equals(textView.getText().toString()) && !f47956f.equals(textView.getText().toString())) {
                    textView.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    d2.o(R.string.J_X01);
                    d2.l(R.color.transparent);
                    d2.h(c.a.r0.j3.c.c(m));
                } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                    textView.setTextColor(c.a.r0.j3.c.a(c.a.r0.j3.c.c(m), c.a.q0.s.u.a.a(R.string.A_X01)));
                    d2.m(R.dimen.tbds1);
                    d2.u(c.a.r0.j3.c.a(c.a.r0.j3.c.c(m), c.a.q0.s.u.a.a(R.string.A_X07)));
                    d2.o(R.string.J_X01);
                    d2.f(R.color.CAM_X0209);
                } else {
                    c.a.q0.s.u.c.d(textView).w(R.color.CAM_X0103);
                    d2.m(R.dimen.tbds1);
                    d2.l(R.color.CAM_X0209);
                    d2.o(R.string.J_X01);
                    d2.f(R.color.CAM_X0209);
                }
            }
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, null) == null) {
            TBSpecificationBtn tBSpecificationBtn = k;
            if (tBSpecificationBtn != null) {
                TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
                if (styleConfig instanceof c.a.q0.s.f0.n.c) {
                    ((c.a.q0.s.f0.n.c) styleConfig).o(R.color.CAM_X0109);
                } else if (styleConfig instanceof c.a.q0.s.f0.n.b) {
                    ((c.a.q0.s.f0.n.b) styleConfig).r(R.color.CAM_X0109);
                }
                k.setConfig(styleConfig);
                k.setText(f47954d);
                k.refreshDrawableState();
            }
            TextView textView = l;
            if (textView != null) {
                textView.setText(f47954d);
                y(l, m);
            }
        }
    }
}
