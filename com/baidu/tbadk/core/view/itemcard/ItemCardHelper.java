package com.baidu.tbadk.core.view.itemcard;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
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
import com.repackage.dr4;
import com.repackage.er4;
import com.repackage.fr4;
import com.repackage.fu4;
import com.repackage.ht4;
import com.repackage.hu4;
import com.repackage.oi;
import com.repackage.xf8;
import com.repackage.xt4;
import com.repackage.yt4;
import tbclient.ApkDetail;
/* loaded from: classes3.dex */
public class ItemCardHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static c j;
    public static TBSpecificationBtn k;
    public static TextView l;
    public static String m;
    public static final HttpMessageListener n;
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
            SUCCESS = new OrderTipStatus("SUCCESS", 1);
            OrderTipStatus orderTipStatus = new OrderTipStatus("FAIL", 2);
            FAIL = orderTipStatus;
            $VALUES = new OrderTipStatus[]{COMPLETED, SUCCESS, orderTipStatus};
        }

        public OrderTipStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Context c;

        public b(String str, long j, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
            this.c = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.g(2, this.a, this.b);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.c, 3)));
            }
        }
    }

    /* loaded from: classes3.dex */
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
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0985);
        b = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0976);
        c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0989);
        d = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0986);
        e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0974);
        f = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0975);
        g = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1425);
        h = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1427);
        i = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1426);
        j = null;
        n = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (b.equals(str)) {
                return 2;
            }
            if (a.equals(str)) {
                return 1;
            }
            return e.equals(str) ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static void f(int i2, int i3, int i4, int i5, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
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
        if (!(interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) || oi.isEmpty(str)) {
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

    public static void k(Context context, BdUniqueId bdUniqueId, View view2, int i2, ViewGroup viewGroup) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, bdUniqueId, view2, Integer.valueOf(i2), viewGroup}) == null) {
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f20);
            if (tag instanceof fu4) {
                fu4 fu4Var = (fu4) tag;
                ItemData a2 = fu4Var.a();
                int b2 = fu4Var.b();
                boolean z = view2 instanceof TBSpecificationBtn;
                if (z) {
                    charSequence = ((TBSpecificationBtn) view2).getText();
                } else {
                    charSequence = view2 instanceof TextView ? ((TextView) view2).getText().toString() : "";
                }
                String str = charSequence;
                int intValue = a2.buttonLinkType.intValue();
                ApkDetail apkDetail = a2.apkDetail;
                int a3 = hu4.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0);
                if (a.equals(str)) {
                    if (StringUtils.isNull(a2.buttonLink)) {
                        if (z) {
                            l = null;
                            k = (TBSpecificationBtn) view2;
                        } else if (view2 instanceof TextView) {
                            k = null;
                            l = (TextView) view2;
                        }
                        u(bdUniqueId, a2);
                    } else {
                        h(context, a2.buttonLink);
                    }
                    if (b2 != 7) {
                        p(b2, a2.itemId, e(a2.buttonName), fu4Var.c(), a3, "");
                    }
                }
                if (b.equals(str) && a2.buttonLinkType.intValue() == 2) {
                    h(context, a2.buttonLink);
                    if (b2 != 7) {
                        p(b2, a2.itemId, e(a2.buttonName), fu4Var.c(), a3, "");
                    }
                }
                if (e.equals(str)) {
                    Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f090f1c);
                    boolean booleanValue = tag2 instanceof Boolean ? ((Boolean) tag2).booleanValue() : false;
                    ItemClickJumpUtil.itemClickJump(a2.forumName, String.valueOf(a2.itemId), i2);
                    if (b2 != 7) {
                        p(b2, a2.itemId, booleanValue ? 9 : e(a2.buttonName), fu4Var.c(), a3, "");
                    }
                }
            }
        }
    }

    public static void l(Context context, BdUniqueId bdUniqueId, View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65548, null, context, bdUniqueId, view2, viewGroup) == null) {
            k(context, bdUniqueId, view2, 0, viewGroup);
        }
    }

    public static boolean m(TextView textView, fu4 fu4Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, textView, fu4Var, str)) == null) {
            m = str;
            ItemData a2 = fu4Var.a();
            if (!a.equals(a2.buttonName) && !b.equals(a2.buttonName) && !d.equals(a2.buttonName) && !f.equals(a2.buttonName)) {
                a2.buttonName = e;
            }
            if ((b.equals(a2.buttonName) || c.equals(a2.buttonName)) && w(a2) && !o(a2)) {
                a2.buttonName = e;
            }
            textView.setTag(R.id.obfuscated_res_0x7f090f20, fu4Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean n(TBSpecificationBtn tBSpecificationBtn, fu4 fu4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, tBSpecificationBtn, fu4Var)) == null) {
            ItemData a2 = fu4Var.a();
            boolean equals = f.equals(a2.buttonName);
            if (!a.equals(a2.buttonName) && !b.equals(a2.buttonName) && !d.equals(a2.buttonName) && !c.equals(a2.buttonName)) {
                a2.buttonName = e;
            }
            if (((b.equals(a2.buttonName) || c.equals(a2.buttonName)) && w(a2) && !o(a2)) || (!w(a2) && (c.equals(a2.buttonName) || (b.equals(a2.buttonName) && a2.buttonLinkType.intValue() != 2)))) {
                a2.buttonName = e;
            }
            TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
            if (styleConfig instanceof yt4) {
                if (d.equals(a2.buttonName)) {
                    ((yt4) styleConfig).p(R.color.CAM_X0109);
                }
            } else if (styleConfig instanceof xt4) {
                if (d.equals(a2.buttonName)) {
                    ((xt4) styleConfig).t(R.color.CAM_X0109);
                } else {
                    ((xt4) styleConfig).p(R.color.CAM_X0302, R.color.CAM_X0101);
                }
            }
            tBSpecificationBtn.setConfig(styleConfig);
            tBSpecificationBtn.setTag(R.id.obfuscated_res_0x7f090f20, fu4Var);
            tBSpecificationBtn.setTag(R.id.obfuscated_res_0x7f090f1c, Boolean.valueOf(equals));
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
                str = g;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                String simpleName = ((Activity) context).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && ht4.k().h("key_download_manager_first_toast", true)) {
                    ht4.k().u("key_download_manager_first_toast", false);
                    g(1, simpleName, j2);
                    ScreenTopToast screenTopToast = new ScreenTopToast(context);
                    screenTopToast.m(context.getString(R.string.obfuscated_res_0x7f0f0983));
                    screenTopToast.k(context.getString(R.string.obfuscated_res_0x7f0f04d9));
                    screenTopToast.j(new b(simpleName, j2, context));
                    screenTopToast.n(viewGroup);
                    return;
                }
                str = h;
            } else {
                str = i;
                BdTopToast bdTopToast = new BdTopToast(context);
                bdTopToast.i(z);
                bdTopToast.h(str);
                bdTopToast.j(viewGroup);
            }
            z = true;
            BdTopToast bdTopToast2 = new BdTopToast(context);
            bdTopToast2.i(z);
            bdTopToast2.h(str);
            bdTopToast2.j(viewGroup);
        }
    }

    public static void y(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, textView, str) == null) {
            m = str;
            if (textView.getBackground() instanceof er4) {
                fr4 d2 = fr4.d(textView);
                if (!d.equals(textView.getText().toString()) && !f.equals(textView.getText().toString())) {
                    textView.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                    d2.n(R.string.J_X01);
                    d2.k(R.color.transparent);
                    d2.g(xf8.f(m));
                } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                    textView.setTextColor(xf8.a(xf8.f(m), dr4.a(R.string.A_X01)));
                    d2.l(R.dimen.tbds1);
                    d2.t(xf8.a(xf8.f(m), dr4.a(R.string.A_X07)));
                    d2.n(R.string.J_X01);
                    d2.f(R.color.CAM_X0209);
                } else {
                    fr4.d(textView).v(R.color.CAM_X0103);
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
                if (styleConfig instanceof yt4) {
                    ((yt4) styleConfig).p(R.color.CAM_X0109);
                } else if (styleConfig instanceof xt4) {
                    ((xt4) styleConfig).t(R.color.CAM_X0109);
                }
                if ((k.getTag(R.id.obfuscated_res_0x7f090f20) instanceof fu4) && ((fu4) k.getTag(R.id.obfuscated_res_0x7f090f20)).a() != null) {
                    ((fu4) k.getTag(R.id.obfuscated_res_0x7f090f20)).a().buttonName = d;
                }
                k.setConfig(styleConfig);
                k.setText(d);
                k.refreshDrawableState();
            }
            TextView textView = l;
            if (textView != null) {
                if ((textView.getTag(R.id.obfuscated_res_0x7f090f20) instanceof fu4) && ((fu4) l.getTag(R.id.obfuscated_res_0x7f090f20)).a() != null) {
                    ((fu4) l.getTag(R.id.obfuscated_res_0x7f090f20)).a().buttonName = d;
                }
                l.setText(d);
                y(l, m);
            }
        }
    }
}
