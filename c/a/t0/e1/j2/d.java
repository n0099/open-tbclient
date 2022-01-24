package c.a.t0.e1.j2;

import c.a.s0.s.s.a;
import c.a.t0.e1.e1;
import c.a.t0.e1.i1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16557e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f16558f;

        public b(TbPageContext tbPageContext, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16557e = tbPageContext;
            this.f16558f = blockPopInfoData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                UrlManager.getInstance().dealOneLink(this.f16557e, new String[]{this.f16558f.ahead_url});
                if (aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }
    }

    public static boolean a(TbPageContext<?> tbPageContext, FrsViewData frsViewData) {
        InterceptResult invokeLL;
        String fixedText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, frsViewData)) == null) {
            if (tbPageContext != null && frsViewData != null) {
                if (!ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                    return true;
                }
                AntiData anti = frsViewData.getAnti();
                if (anti != null) {
                    if (b(tbPageContext, anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (StringHelper.getRealSize(forbid_info) > 14) {
                            forbid_info = StringHelper.getFixedText(forbid_info, 7, false) + org.apache.commons.lang3.StringUtils.LF + forbid_info.substring(fixedText.length());
                        }
                        BdToast i2 = BdToast.i(tbPageContext.getPageActivity(), forbid_info, e1.icon_pure_toast_mistake40_svg, true);
                        i2.k(1.25f);
                        i2.q();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext, int i2, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, tbPageContext, i2, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? tbPageContext.getResources().getString(i1.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
            if (i2 != 1 && i2 != 2) {
                BdToast i3 = BdToast.i(tbPageContext.getPageActivity(), string, e1.icon_pure_toast_mistake40_svg, true);
                i3.k(1.25f);
                i3.q();
                return false;
            }
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(StringHelper.getFixedText(string, 50, true));
            aVar.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? tbPageContext.getResources().getString(i1.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a());
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                aVar.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new b(tbPageContext, blockPopInfoData));
            }
            aVar.create(tbPageContext).show();
            return true;
        }
        return invokeLIL.booleanValue;
    }
}
