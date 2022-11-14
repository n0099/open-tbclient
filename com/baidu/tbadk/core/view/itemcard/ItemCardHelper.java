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
import com.baidu.tieba.nw4;
import com.baidu.tieba.ow4;
import com.baidu.tieba.oz4;
import com.baidu.tieba.pw4;
import com.baidu.tieba.py4;
import com.baidu.tieba.pz4;
import com.baidu.tieba.qn8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.vz4;
import com.baidu.tieba.xi;
import com.baidu.tieba.xz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
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
    public static WeakReference<c> j;
    public static TBSpecificationBtn k;
    public static TextView l;
    public static String m;
    public static final HttpMessageListener n;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface c {
        void a(long j);

        void b(long j);
    }

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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (OrderTipStatus) Enum.valueOf(OrderTipStatus.class, str);
            }
            return (OrderTipStatus) invokeL.objValue;
        }

        public static OrderTipStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (OrderTipStatus[]) $VALUES.clone();
            }
            return (OrderTipStatus[]) invokeV.objValue;
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
            c cVar;
            c cVar2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003496) {
                int error = httpResponsedMessage.getError();
                int statusCode = httpResponsedMessage.getStatusCode();
                long parseLong = Long.parseLong((String) ((HttpMessage) httpResponsedMessage.getOrginalMessage()).getParams().get("item_id"));
                if (statusCode == 200 && error == 0) {
                    if (ItemCardHelper.j != null && (cVar2 = (c) ItemCardHelper.j.get()) != null) {
                        cVar2.b(parseLong);
                        ItemCardHelper.A();
                    }
                } else if (ItemCardHelper.j != null && (cVar = (c) ItemCardHelper.j.get()) != null) {
                    cVar.a(parseLong);
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
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09c4);
        b = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b5);
        c = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09c8);
        d = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09c5);
        e = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b3);
        f = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09b4);
        g = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f146f);
        h = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1471);
        i = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1470);
        n = new a(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            TBSpecificationBtn tBSpecificationBtn = k;
            if (tBSpecificationBtn != null) {
                TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
                if (styleConfig instanceof pz4) {
                    ((pz4) styleConfig).p(R.color.CAM_X0109);
                } else if (styleConfig instanceof oz4) {
                    ((oz4) styleConfig).t(R.color.CAM_X0109);
                }
                if ((k.getTag(R.id.obfuscated_res_0x7f090fc9) instanceof vz4) && ((vz4) k.getTag(R.id.obfuscated_res_0x7f090fc9)).a() != null) {
                    ((vz4) k.getTag(R.id.obfuscated_res_0x7f090fc9)).a().buttonName = d;
                }
                k.setConfig(styleConfig);
                k.setText(d);
                k.refreshDrawableState();
            }
            TextView textView = l;
            if (textView != null) {
                if ((textView.getTag(R.id.obfuscated_res_0x7f090fc9) instanceof vz4) && ((vz4) l.getTag(R.id.obfuscated_res_0x7f090fc9)).a() != null) {
                    ((vz4) l.getTag(R.id.obfuscated_res_0x7f090fc9)).a().buttonName = d;
                }
                l.setText(d);
                z(l, m);
            }
        }
    }

    public static HttpMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return n;
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            MessageManager.getInstance().registerListener(i());
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            MessageManager.getInstance().registerTask(j());
        }
    }

    public static void w(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, cVar) == null) {
            WeakReference<c> weakReference = j;
            if (weakReference != null) {
                weakReference.clear();
                j = null;
            }
            if (cVar != null) {
                j = new WeakReference<>(cVar);
            }
        }
    }

    public static boolean x(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, itemData)) == null) {
            if (itemData != null && itemData.buttonLinkType.intValue() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (b.equals(str)) {
                return 2;
            }
            if (a.equals(str)) {
                return 1;
            }
            if (e.equals(str)) {
                return 3;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void f(int i2, int i3, int i4, int i5, String str, boolean z) {
        String str2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
            int i7 = 1;
            if (i2 == 3) {
                str2 = CommonStatisticKey.KEY_DOWNLOAD_MANAGER_DOWNLOADING_CLICK;
            } else if (i2 == 2) {
                str2 = CommonStatisticKey.KEY_DOWNLOAD_MANAGER_INSTALLED_CLICK;
            } else if (i2 == 1) {
                str2 = CommonStatisticKey.KEY_DOWNLOAD_MANAGER_ORDERED_CLICK;
            } else {
                str2 = "";
            }
            if (i5 == 2) {
                i6 = 1;
            } else {
                i6 = 2;
            }
            StatisticItem addParam = new StatisticItem(str2).addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("obj_locate", i3).addParam("obj_type", i4).addParam("obj_source", i6).addParam("obj_name", str);
            if (i2 == 3) {
                if (!z) {
                    i7 = 2;
                }
                addParam.addParam("obj_param1", i7);
            }
            TiebaStatic.log(addParam);
        }
    }

    public static void g(int i2, String str, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            if ("PbActivity".equals(str)) {
                i3 = 1;
            } else if ("FrsActivity".equals(str)) {
                i3 = 2;
            } else if ("MainTabActivity".equals(str)) {
                i3 = 5;
            } else {
                i3 = 0;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_TOAST_DOWNLOAD_MANAGER_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccountId()).addParam("obj_type", i2).addParam("obj_source", j2).addParam("obj_locate", i3));
        }
    }

    public static boolean m(TextView textView, vz4 vz4Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, textView, vz4Var, str)) == null) {
            m = str;
            ItemData a2 = vz4Var.a();
            if (!a.equals(a2.buttonName) && !b.equals(a2.buttonName) && !d.equals(a2.buttonName) && !f.equals(a2.buttonName)) {
                a2.buttonName = e;
            }
            if ((b.equals(a2.buttonName) || c.equals(a2.buttonName)) && x(a2) && !o(a2)) {
                a2.buttonName = e;
            }
            textView.setTag(R.id.obfuscated_res_0x7f090fc9, vz4Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void h(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65545, null, context, str) != null) || xi.isEmpty(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, "", str, true)));
    }

    public static void u(BdUniqueId bdUniqueId, ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, bdUniqueId, itemData) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
            httpMessage.setTag(bdUniqueId);
            httpMessage.addParam("item_id", itemData.itemId);
            httpMessage.addParam("item_name", itemData.mTitle);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static HttpMessageTask j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            tbHttpMessageTask.setResponsedClass(OrderHttpResponsedMsg.class);
            return tbHttpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public static void k(Context context, BdUniqueId bdUniqueId, View view2, int i2, ViewGroup viewGroup) {
        String str;
        int i3;
        int e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, bdUniqueId, view2, Integer.valueOf(i2), viewGroup}) == null) {
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f090fc9);
            if (!(tag instanceof vz4)) {
                return;
            }
            vz4 vz4Var = (vz4) tag;
            ItemData a2 = vz4Var.a();
            int b2 = vz4Var.b();
            boolean z = view2 instanceof TBSpecificationBtn;
            if (z) {
                str = ((TBSpecificationBtn) view2).getText();
            } else if (view2 instanceof TextView) {
                str = ((TextView) view2).getText().toString();
            } else {
                str = "";
            }
            String str2 = str;
            int intValue = a2.buttonLinkType.intValue();
            ApkDetail apkDetail = a2.apkDetail;
            boolean z2 = false;
            if (apkDetail != null) {
                i3 = apkDetail.pkg_source.intValue();
            } else {
                i3 = 0;
            }
            int a3 = xz4.a(intValue, i3);
            if (a.equals(str2)) {
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
                    p(b2, a2.itemId, e(a2.buttonName), vz4Var.c(), a3, "");
                }
            }
            if (b.equals(str2) && a2.buttonLinkType.intValue() == 2) {
                h(context, a2.buttonLink);
                if (b2 != 7) {
                    p(b2, a2.itemId, e(a2.buttonName), vz4Var.c(), a3, "");
                }
            }
            if (e.equals(str2)) {
                Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f090fc4);
                if (tag2 instanceof Boolean) {
                    z2 = ((Boolean) tag2).booleanValue();
                }
                ItemClickJumpUtil.itemClickJump(a2.forumName, String.valueOf(a2.itemId), i2);
                if (b2 != 7) {
                    long j2 = a2.itemId;
                    if (z2) {
                        e2 = 9;
                    } else {
                        e2 = e(a2.buttonName);
                    }
                    p(b2, j2, e2, vz4Var.c(), a3, "");
                }
            }
        }
    }

    public static void l(Context context, BdUniqueId bdUniqueId, View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, context, bdUniqueId, view2, viewGroup) == null) {
            k(context, bdUniqueId, view2, 0, viewGroup);
        }
    }

    public static boolean n(TBSpecificationBtn tBSpecificationBtn, vz4 vz4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, tBSpecificationBtn, vz4Var)) == null) {
            ItemData a2 = vz4Var.a();
            boolean equals = f.equals(a2.buttonName);
            if (!a.equals(a2.buttonName) && !b.equals(a2.buttonName) && !d.equals(a2.buttonName) && !c.equals(a2.buttonName)) {
                a2.buttonName = e;
            }
            if (((b.equals(a2.buttonName) || c.equals(a2.buttonName)) && x(a2) && !o(a2)) || (!x(a2) && (c.equals(a2.buttonName) || (b.equals(a2.buttonName) && a2.buttonLinkType.intValue() != 2)))) {
                a2.buttonName = e;
            }
            TBSpecificationButtonConfig styleConfig = tBSpecificationBtn.getStyleConfig();
            if (styleConfig instanceof pz4) {
                if (d.equals(a2.buttonName)) {
                    ((pz4) styleConfig).p(R.color.CAM_X0109);
                }
            } else if (styleConfig instanceof oz4) {
                if (d.equals(a2.buttonName)) {
                    ((oz4) styleConfig).t(R.color.CAM_X0109);
                } else {
                    ((oz4) styleConfig).p(R.color.CAM_X0302, R.color.CAM_X0101);
                }
            }
            tBSpecificationBtn.setConfig(styleConfig);
            tBSpecificationBtn.setTag(R.id.obfuscated_res_0x7f090fc9, vz4Var);
            tBSpecificationBtn.setTag(R.id.obfuscated_res_0x7f090fc4, Boolean.valueOf(equals));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void z(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, textView, str) == null) {
            m = str;
            if (!(textView.getBackground() instanceof ow4)) {
                return;
            }
            pw4 d2 = pw4.d(textView);
            if (!d.equals(textView.getText().toString()) && !f.equals(textView.getText().toString())) {
                textView.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                d2.n(R.string.J_X01);
                d2.k(R.color.transparent);
                d2.g(qn8.f(m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                textView.setTextColor(qn8.a(qn8.f(m), nw4.b(R.string.A_X01)));
                d2.l(R.dimen.tbds1);
                d2.t(qn8.a(qn8.f(m), nw4.b(R.string.A_X07)));
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0209);
            } else {
                pw4.d(textView).v(R.color.CAM_X0103);
                d2.l(R.dimen.tbds1);
                d2.k(R.color.CAM_X0209);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0209);
            }
        }
    }

    public static boolean o(ItemData itemData) {
        InterceptResult invokeL;
        ApkDetail apkDetail;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, itemData)) == null) {
            if (itemData != null && itemData.buttonLinkType.intValue() == 1 && !TextUtils.isEmpty(itemData.pkgName) && !TextUtils.isEmpty(itemData.buttonLink) && (apkDetail = itemData.apkDetail) != null && !TextUtils.isEmpty(apkDetail.developer) && !TextUtils.isEmpty(itemData.apkDetail.version) && itemData.apkDetail.version_code.intValue() > 0 && !TextUtils.isEmpty(itemData.apkDetail.authority_url) && !TextUtils.isEmpty(itemData.apkDetail.privacy_url)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void p(int i2, long j2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2}) == null) {
            q(i2, j2, i3, str, i4, str2, 1);
        }
    }

    public static void q(int i2, long j2, int i3, String str, int i4, String str2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2, Integer.valueOf(i5)}) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ITEM_CARD_BUTTON_SHOW);
            statisticItem.addParam("obj_locate", i2);
            statisticItem.addParam("obj_source", j2);
            statisticItem.addParam("obj_type", i3);
            statisticItem.addParam("tid", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void v(BdUniqueId bdUniqueId, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, bdUniqueId, str, str2) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GAME_ITEM_ORDER);
            httpMessage.setTag(bdUniqueId);
            httpMessage.addParam("item_id", str);
            httpMessage.addParam("item_name", str2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void y(Context context, OrderTipStatus orderTipStatus, ViewGroup viewGroup, long j2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, orderTipStatus, viewGroup, Long.valueOf(j2)}) == null) {
            boolean z = false;
            if (orderTipStatus == OrderTipStatus.COMPLETED) {
                str = g;
            } else if (orderTipStatus == OrderTipStatus.SUCCESS) {
                String simpleName = ((Activity) context).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && py4.k().h("key_download_manager_first_toast", true)) {
                    py4.k().u("key_download_manager_first_toast", false);
                    g(1, simpleName, j2);
                    ScreenTopToast screenTopToast = new ScreenTopToast(context);
                    screenTopToast.m(context.getString(R.string.obfuscated_res_0x7f0f09c2));
                    screenTopToast.k(context.getString(R.string.obfuscated_res_0x7f0f04fd));
                    screenTopToast.j(new b(simpleName, j2, context));
                    screenTopToast.n(viewGroup);
                    return;
                }
                str = h;
            } else {
                str = i;
                BdTopToast bdTopToast = new BdTopToast(context);
                bdTopToast.h(z);
                bdTopToast.g(str);
                bdTopToast.i(viewGroup);
            }
            z = true;
            BdTopToast bdTopToast2 = new BdTopToast(context);
            bdTopToast2.h(z);
            bdTopToast2.g(str);
            bdTopToast2.i(viewGroup);
        }
    }
}
