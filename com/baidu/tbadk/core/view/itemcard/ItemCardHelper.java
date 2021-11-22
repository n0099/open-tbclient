package com.baidu.tbadk.core.view.itemcard;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.e.f.p.k;
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
import com.baidu.tbadk.core.data.ItemData;
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
/* loaded from: classes8.dex */
public class ItemCardHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f46389a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f46390b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f46391c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f46392d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f46393e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f46394f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f46395g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f46396h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f46397i;
    public static c j;
    public static TBSpecificationBtn k;
    public static TextView l;
    public static String m;
    public static final HttpMessageListener n;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            SUCCESS = new OrderTipStatus(com.alipay.security.mobile.module.http.model.c.p, 1);
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

    /* loaded from: classes8.dex */
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
                    if (ItemCardHelper.j != null) {
                        ItemCardHelper.j.b();
                    }
                } else if (ItemCardHelper.j != null) {
                    ItemCardHelper.j.a(parseLong);
                    ItemCardHelper.z();
                }
                TBSpecificationBtn unused = ItemCardHelper.k = null;
                TextView unused2 = ItemCardHelper.l = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46399f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46400g;

        public b(String str, long j, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46398e = str;
            this.f46399f = j;
            this.f46400g = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.g(2, this.f46398e, this.f46399f);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.f46400g, 3)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(long j);

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
        f46389a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order);
        f46390b = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
        f46391c = TbadkCoreApplication.getInst().getResources().getString(R.string.item_try_play);
        f46392d = TbadkCoreApplication.getInst().getResources().getString(R.string.item_order_complete);
        f46393e = TbadkCoreApplication.getInst().getResources().getString(R.string.item_browse);
        f46394f = TbadkCoreApplication.getInst().getResources().getString(R.string.item_coming_soon);
        f46395g = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_completed);
        f46396h = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_successs);
        f46397i = TbadkCoreApplication.getInst().getResources().getString(R.string.tip_order_fail);
        j = null;
        n = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (f46390b.equals(str)) {
                return 2;
            }
            if (f46389a.equals(str)) {
                return 1;
            }
            return f46393e.equals(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static void f(int i2, int i3, int i4, int i5, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
            StatisticItem addParam = new StatisticItem(i2 == 3 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_DOWNLOADING_CLICK : i2 == 2 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_INSTALLED_CLICK : i2 == 1 ? CommonStatisticKey.KEY_DOWNLOAD_MANAGER_ORDERED_CLICK : "").addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("obj_locate", i3).addParam("obj_type", i4).addParam("obj_source", i5 == 2 ? 1 : 2).addParam("obj_name", str);
            if (i2 == 3) {
                addParam.addParam("obj_param1", z ? 1 : 2);
            }
            TiebaStatic.log(addParam);
        }
    }

    public static void g(int i2, String str, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
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

    public static void h(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) || k.isEmpty(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, "", str, true)));
    }

    public static HttpMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? n : (HttpMessageListener) invokeV.objValue;
    }

    public static HttpMessageTask j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            tbHttpMessageTask.setResponsedClass(OrderHttpResponsedMsg.class);
            return tbHttpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public static void k(Context context, BdUniqueId bdUniqueId, View view, int i2, ViewGroup viewGroup) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, bdUniqueId, view, Integer.valueOf(i2), viewGroup}) == null) {
            Object tag = view.getTag(R.id.item_data);
            if (tag instanceof b.a.q0.s.g0.p.a) {
                b.a.q0.s.g0.p.a aVar = (b.a.q0.s.g0.p.a) tag;
                ItemData a2 = aVar.a();
                int b2 = aVar.b();
                boolean z = view instanceof TBSpecificationBtn;
                if (z) {
                    charSequence = ((TBSpecificationBtn) view).getText();
                } else {
                    charSequence = view instanceof TextView ? ((TextView) view).getText().toString() : "";
                }
                String str = charSequence;
                int intValue = a2.buttonLinkType.intValue();
                ApkDetail apkDetail = a2.apkDetail;
                int a3 = b.a.q0.s.g0.p.c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0);
                if (f46389a.equals(str)) {
                    if (StringUtils.isNull(a2.buttonLink)) {
                        if (z) {
                            l = null;
                            k = (TBSpecificationBtn) view;
                        } else if (view instanceof TextView) {
                            k = null;
                            l = (TextView) view;
                        }
                        u(bdUniqueId, a2);
                    } else {
                        h(context, a2.buttonLink);
                    }
                    if (b2 != 7) {
                        p(b2, a2.itemId, e(a2.buttonName), aVar.c(), a3, "");
                    }
                }
                if (f46390b.equals(str) && a2.buttonLinkType.intValue() == 2) {
                    h(context, a2.buttonLink);
                    if (b2 != 7) {
                        p(b2, a2.itemId, e(a2.buttonName), aVar.c(), a3, "");
                    }
                }
                if (f46393e.equals(str)) {
                    Object tag2 = view.getTag(R.id.item_coming_soon);
                    boolean booleanValue = tag2 instanceof Boolean ? ((Boolean) tag2).booleanValue() : false;
                    ItemClickJumpUtil.itemClickJump(a2.forumName, String.valueOf(a2.itemId), i2);
                    if (b2 != 7) {
                        p(b2, a2.itemId, booleanValue ? 9 : e(a2.buttonName), aVar.c(), a3, "");
                    }
                }
                if (f46392d.equals(str)) {
                    x(context, OrderTipStatus.COMPLETED, viewGroup, 0L);
                }
            }
        }
    }

    public static void l(Context context, BdUniqueId bdUniqueId, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, bdUniqueId, view, viewGroup) == null) {
            k(context, bdUniqueId, view, 0, viewGroup);
        }
    }

    public static boolean m(TextView textView, b.a.q0.s.g0.p.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, textView, aVar, str)) == null) {
            m = str;
            ItemData a2 = aVar.a();
            if (!f46389a.equals(a2.buttonName) && !f46390b.equals(a2.buttonName) && !f46392d.equals(a2.buttonName) && !f46394f.equals(a2.buttonName)) {
                a2.buttonName = f46393e;
            }
            if ((f46390b.equals(a2.buttonName) || f46391c.equals(a2.buttonName)) && w(a2) && !o(a2)) {
                a2.buttonName = f46393e;
            }
            textView.setTag(R.id.item_data, aVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean n(TBSpecificationBtn tBSpecificationBtn, b.a.q0.s.g0.p.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, tBSpecificationBtn, aVar)) == null) {
            ItemData a2 = aVar.a();
            boolean equals = f46394f.equals(a2.buttonName);
            if (!f46389a.equals(a2.buttonName) && !f46390b.equals(a2.buttonName) && !f46392d.equals(a2.buttonName) && !f46391c.equals(a2.buttonName)) {
                a2.buttonName = f46393e;
            }
            if (((f46390b.equals(a2.buttonName) || f46391c.equals(a2.buttonName)) && w(a2) && !o(a2)) || (!w(a2) && (f46391c.equals(a2.buttonName) || (f46390b.equals(a2.buttonName) && a2.buttonLinkType.intValue() != 2)))) {
                a2.buttonName = f46393e;
            }
            TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
            if (styleConfig instanceof b.a.q0.s.g0.n.c) {
                if (f46392d.equals(a2.buttonName)) {
                    ((b.a.q0.s.g0.n.c) styleConfig).p(R.color.CAM_X0109);
                }
            } else if (styleConfig instanceof b.a.q0.s.g0.n.b) {
                if (f46392d.equals(a2.buttonName)) {
                    ((b.a.q0.s.g0.n.b) styleConfig).s(R.color.CAM_X0109);
                } else {
                    ((b.a.q0.s.g0.n.b) styleConfig).p(R.color.CAM_X0302, R.color.CAM_X0101);
                }
            }
            tBSpecificationBtn.setConfig(styleConfig);
            tBSpecificationBtn.setTag(R.id.item_data, aVar);
            tBSpecificationBtn.setTag(R.id.item_coming_soon, Boolean.valueOf(equals));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean o(ItemData itemData) {
        InterceptResult invokeL;
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, itemData)) == null) ? (itemData == null || itemData.buttonLinkType.intValue() != 1 || TextUtils.isEmpty(itemData.pkgName) || TextUtils.isEmpty(itemData.buttonLink) || (apkDetail = itemData.apkDetail) == null || TextUtils.isEmpty(apkDetail.developer) || TextUtils.isEmpty(itemData.apkDetail.version) || itemData.apkDetail.version_code.intValue() <= 0 || TextUtils.isEmpty(itemData.apkDetail.authority_url) || TextUtils.isEmpty(itemData.apkDetail.privacy_url)) ? false : true : invokeL.booleanValue;
    }

    public static void p(int i2, long j2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2}) == null) {
            q(i2, j2, i3, str, i4, str2, 1);
        }
    }

    public static void q(int i2, long j2, int i3, String str, int i4, String str2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2, Integer.valueOf(i5)}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_CLICK);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            statisticItem.addParam("tid", str);
            statisticItem.addParam("obj_param1", i4);
            if (!StringUtils.isNull(str2)) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            }
            if (i5 != 0) {
                statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM3, i5);
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
            MessageManager.getInstance().registerListener(i());
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            MessageManager.getInstance().registerTask(j());
        }
    }

    public static void u(BdUniqueId bdUniqueId, ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, bdUniqueId, itemData) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
            httpMessage.setTag(bdUniqueId);
            httpMessage.addParam("item_id", itemData.itemId);
            httpMessage.addParam("item_name", itemData.mTitle);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void v(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, cVar) == null) {
            j = cVar;
        }
    }

    public static boolean w(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, itemData)) == null) ? itemData != null && itemData.buttonLinkType.intValue() == 1 : invokeL.booleanValue;
    }

    public static void x(Context context, OrderTipStatus orderTipStatus, ViewGroup viewGroup, long j2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, orderTipStatus, viewGroup, Long.valueOf(j2)}) == null) {
            boolean z = false;
            if (orderTipStatus == OrderTipStatus.COMPLETED) {
                str = f46395g;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                String simpleName = ((Activity) context).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && b.a.q0.s.e0.b.j().g("key_download_manager_first_toast", true)) {
                    b.a.q0.s.e0.b.j().t("key_download_manager_first_toast", false);
                    g(1, simpleName, j2);
                    new ScreenTopToast(context).setTitle(context.getString(R.string.item_first_use_download_manager_toast)).setBtnText(context.getString(R.string.dialog_confirm_see)).setBtnClickListener(new b(simpleName, j2, context)).show(viewGroup);
                    return;
                }
                str = f46396h;
            } else {
                str = f46397i;
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
            if (textView.getBackground() instanceof b.a.q0.s.u.b) {
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(textView);
                if (!f46392d.equals(textView.getText().toString()) && !f46394f.equals(textView.getText().toString())) {
                    textView.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0101));
                    d2.n(R.string.J_X01);
                    d2.k(R.color.transparent);
                    d2.g(b.a.r0.m3.c.c(m));
                } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                    textView.setTextColor(b.a.r0.m3.c.a(b.a.r0.m3.c.c(m), b.a.q0.s.u.a.a(R.string.A_X01)));
                    d2.l(R.dimen.tbds1);
                    d2.t(b.a.r0.m3.c.a(b.a.r0.m3.c.c(m), b.a.q0.s.u.a.a(R.string.A_X07)));
                    d2.n(R.string.J_X01);
                    d2.f(R.color.CAM_X0209);
                } else {
                    b.a.q0.s.u.c.d(textView).v(R.color.CAM_X0103);
                    d2.l(R.dimen.tbds1);
                    d2.k(R.color.CAM_X0209);
                    d2.n(R.string.J_X01);
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
                if (styleConfig instanceof b.a.q0.s.g0.n.c) {
                    ((b.a.q0.s.g0.n.c) styleConfig).p(R.color.CAM_X0109);
                } else if (styleConfig instanceof b.a.q0.s.g0.n.b) {
                    ((b.a.q0.s.g0.n.b) styleConfig).s(R.color.CAM_X0109);
                }
                if ((k.getTag(R.id.item_data) instanceof b.a.q0.s.g0.p.a) && ((b.a.q0.s.g0.p.a) k.getTag(R.id.item_data)).a() != null) {
                    ((b.a.q0.s.g0.p.a) k.getTag(R.id.item_data)).a().buttonName = f46392d;
                }
                k.setConfig(styleConfig);
                k.setText(f46392d);
                k.refreshDrawableState();
            }
            TextView textView = l;
            if (textView != null) {
                if ((textView.getTag(R.id.item_data) instanceof b.a.q0.s.g0.p.a) && ((b.a.q0.s.g0.p.a) l.getTag(R.id.item_data)).a() != null) {
                    ((b.a.q0.s.g0.p.a) l.getTag(R.id.item_data)).a().buttonName = f46392d;
                }
                l.setText(f46392d);
                y(l, m);
            }
        }
    }
}
