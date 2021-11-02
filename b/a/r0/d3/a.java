package b.a.r0.d3;

import android.content.Context;
import android.location.Location;
import b.a.e.e.p.j;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.t.g.g;
import b.a.r0.f0.h;
import b.a.r0.l3.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f15698a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15698a = context;
    }

    public final String a(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shareItem)) == null) {
            String str = "【" + shareItem.r + "】 " + shareItem.s;
            shareItem.s = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final Location b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? h.b() : (Location) invokeV.objValue;
    }

    public void c(int i2, ShareItem shareItem, boolean z) {
        Location b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) || shareItem == null) {
            return;
        }
        if (!j.z()) {
            l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            return;
        }
        if (z && (b2 = b()) != null) {
            shareItem.B = b2;
        }
        g gVar = new g(this.f15698a, null);
        if (i2 == 3) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                BdToast.c(this.f15698a, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).q();
                return;
            }
            e(shareItem, 4);
            gVar.m(shareItem);
        } else if (i2 == 2) {
            IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
            if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                BdToast.c(this.f15698a, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).q();
                return;
            }
            e(shareItem, 3);
            if (shareItem.f45689b) {
                shareItem.s = a(shareItem);
            }
            gVar.n(shareItem);
        } else if (i2 == 4) {
            if (b0.b(this.f15698a, "com.tencent.mobileqq")) {
                e(shareItem, 5);
                gVar.i(shareItem);
                return;
            }
            Context context = this.f15698a;
            BdToast.c(context, context.getText(R.string.share_qq_not_install)).q();
        } else if (i2 == 5) {
            if (!shareItem.f45688a) {
                shareItem.s = a(shareItem);
            }
            gVar.l(shareItem);
        } else if (i2 == 6) {
            e(shareItem, 7);
            if (!shareItem.f45688a) {
                shareItem.s = a(shareItem);
            }
            gVar.k(shareItem);
        } else if (i2 == 7) {
            if (!shareItem.f45688a) {
                shareItem.s = a(shareItem);
            }
            gVar.j(shareItem);
        } else if (i2 == 8) {
            if (b0.b(this.f15698a, "com.tencent.mobileqq")) {
                e(shareItem, 9);
                gVar.h(shareItem);
                return;
            }
            Context context2 = this.f15698a;
            BdToast.c(context2, context2.getText(R.string.share_qq_not_install)).q();
        }
    }

    public final void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            TiebaStatic.eventStat(this.f15698a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void e(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, shareItem, i2) == null) || shareItem == null || shareItem.q == null) {
            return;
        }
        if (shareItem.f45689b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2));
        } else if (!shareItem.f45690c && !shareItem.f45693f) {
            if (shareItem.f45691d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.f45688a) {
                d(i2, shareItem.C);
            } else if (shareItem.f45692e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q));
            } else if (shareItem.f45694g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                if (!k.isEmpty(shareItem.t) && shareItem.t.contains("worldcup")) {
                    param.param("obj_param1", 9);
                }
                TiebaStatic.log(param);
            } else if (shareItem.f45695h) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("fid", shareItem.J).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G).param(TiebaStatic.Params.OBJ_PARAM3, shareItem.H).param("obj_locate", shareItem.I));
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }
}
