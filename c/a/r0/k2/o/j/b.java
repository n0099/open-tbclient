package c.a.r0.k2.o.j;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.r0.f0.f;
import c.a.r0.k2.h.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f20891e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f20892f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f20893g;

        public a(PbModel pbModel, AbsPbActivity absPbActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, absPbActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20891e = pbModel;
            this.f20892f = absPbActivity;
            this.f20893g = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f20891e) == null || pbModel.P0() == null || !this.f20891e.P0().q0() || TbSingleton.getInstance().isNotchScreen(this.f20892f) || TbSingleton.getInstance().isCutoutScreen(this.f20892f) || (view = this.f20893g) == null) {
                return;
            }
            view.setSystemUiVisibility(4);
        }
    }

    public static int a(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, d2Var)) == null) {
            if (d2Var == null) {
                return 0;
            }
            if (d2Var.F2()) {
                return 11;
            }
            if (d2Var.M1()) {
                return 10;
            }
            if (d2Var.P1()) {
                return 9;
            }
            if (d2Var.O1()) {
                return 8;
            }
            if (d2Var.N1()) {
                return 7;
            }
            if (d2Var.z1) {
                return 6;
            }
            int i2 = d2Var.i0;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 40) {
                return 2;
            }
            if (i2 == 49) {
                return 3;
            }
            return i2 == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public static int b(e eVar) {
        InterceptResult invokeL;
        d2 O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, eVar)) == null) {
            if (eVar == null || (O = eVar.O()) == null) {
                return 0;
            }
            if (O.q2()) {
                return 4;
            }
            if (O.j0() == 1) {
                return 3;
            }
            if (O.M1()) {
                return 5;
            }
            if (O.P1()) {
                return 6;
            }
            if (O.N1()) {
                return 7;
            }
            if (O.O1()) {
                return 8;
            }
            return O.r2() ? 2 : 1;
        }
        return invokeL.intValue;
    }

    public static void c(AbsPbActivity absPbActivity, int i2, int i3) {
        String f1;
        String str;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i2, i3) == null) || absPbActivity == null || absPbActivity.getPbModel() == null) {
            return;
        }
        PbModel pbModel = absPbActivity.getPbModel();
        View rootView = absPbActivity.getRootView();
        if (pbModel.d()) {
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            e P0 = pbModel.P0();
            String title = P0.O().getTitle();
            boolean t0 = pbModel.t0();
            if (P0.m() != null) {
                if (P0.m().isLike() == 1) {
                    AddExperiencedModel.B(P0.n());
                }
            }
            d2 O = pbModel.P0().O();
            if (O.D2()) {
                f1 = O.L().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (t0 ? 1 : 0) + "&dtype=" + O.L().oriUgcType + "&dvid=" + O.L().oriUgcVid + "&nid=" + O.L().oriUgcNid;
            } else {
                f1 = pbModel.f1();
                str = "?share=9105&fr=sharewise&see_lz=" + (t0 ? 1 : 0);
            }
            String str2 = "http://tieba.baidu.com/p/" + f1 + (str + "&share_from=post");
            String[] M = P0.M(absPbActivity);
            String str3 = M[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            Uri parse = str3 == null ? null : Uri.parse(str3);
            String str4 = M[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", P0.n()).param("tid", P0.Q()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (P0.f0() && O.J() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4) || O.O1() || O.P1()) {
                    if (TextUtils.isEmpty(title)) {
                        c2 = 1;
                        title = M[1];
                    } else {
                        c2 = 1;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = O.J().getName_show();
                    objArr[c2] = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix);
                    str4 = MessageFormat.format(string, objArr);
                }
            } else if (k.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = k.cutString(title, 100);
            String cutString2 = k.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            if (P0.f0()) {
                shareItem.D = cutString2;
                shareItem.R = -1L;
            } else if (P0.O() != null && P0.O().q1() != null && !P0.O().D2()) {
                shareItem.R = P0.O().q1().play_count.intValue();
            }
            shareItem.t = str2;
            shareItem.f48136c = true;
            shareItem.q = pbModel.f1();
            shareItem.F = 3;
            shareItem.E = i3;
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.f1();
            shareItem.M = b(P0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.v = parse;
            }
            if (i3 == 2) {
                shareItem.F = pbModel.u0();
            }
            if (P0.f0()) {
                shareItem.j0 = false;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (P0 != null && P0.F() != null && P0.F().size() > 0) {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, P0.F().get(0));
            } else {
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (O != null) {
                shareItem.i0 = O.Z0();
            }
            shareItem.G = a(O);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putString("uid", shareItem.N);
            shareItem.k(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
            shareDialogConfig.setOnDismissListener(new a(pbModel, absPbActivity, rootView));
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            f.b().k(shareDialogConfig);
        }
    }
}
