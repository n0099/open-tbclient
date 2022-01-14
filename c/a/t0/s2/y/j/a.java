package c.a.t0.s2.y.j;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.d.f.p.m;
import c.a.s0.s.q.e2;
import c.a.t0.k0.h;
import c.a.t0.s2.l;
import c.a.t0.s2.r.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.s2.y.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class DialogInterface$OnDismissListenerC1426a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f23371e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f23372f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f23373g;

        public DialogInterface$OnDismissListenerC1426a(PbModel pbModel, AbsPbActivity absPbActivity, View view) {
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
            this.f23371e = pbModel;
            this.f23372f = absPbActivity;
            this.f23373g = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f23371e) == null || pbModel.R0() == null || !this.f23371e.R0().r0() || TbSingleton.getInstance().isNotchScreen(this.f23372f) || TbSingleton.getInstance().isCutoutScreen(this.f23372f) || (view = this.f23373g) == null) {
                return;
            }
            view.setSystemUiVisibility(4);
        }
    }

    public static int a(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, e2Var)) == null) {
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.I2()) {
                return 11;
            }
            if (e2Var.P1()) {
                return 10;
            }
            if (e2Var.S1()) {
                return 9;
            }
            if (e2Var.R1()) {
                return 8;
            }
            if (e2Var.Q1()) {
                return 7;
            }
            if (e2Var.A1) {
                return 6;
            }
            int i2 = e2Var.d0;
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

    public static int b(f fVar) {
        InterceptResult invokeL;
        e2 O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            if (fVar == null || (O = fVar.O()) == null) {
                return 0;
            }
            if (O.t2()) {
                return 4;
            }
            if (O.k0() == 1) {
                return 3;
            }
            if (O.P1()) {
                return 5;
            }
            if (O.S1()) {
                return 6;
            }
            if (O.Q1()) {
                return 7;
            }
            if (O.R1()) {
                return 8;
            }
            return O.u2() ? 2 : 1;
        }
        return invokeL.intValue;
    }

    public static void c(AbsPbActivity absPbActivity, int i2, int i3) {
        String h1;
        String str;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i2, i3) == null) || absPbActivity == null || absPbActivity.getPbModel() == null) {
            return;
        }
        PbModel pbModel = absPbActivity.getPbModel();
        View rootView = absPbActivity.getRootView();
        if (pbModel.a()) {
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            f R0 = pbModel.R0();
            String title = R0.O().getTitle();
            boolean v0 = pbModel.v0();
            if (R0.l() != null) {
                if (R0.l().isLike() == 1) {
                    AddExperiencedModel.B(R0.m());
                }
            }
            e2 O = pbModel.R0().O();
            if (O.G2()) {
                h1 = O.L().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (v0 ? 1 : 0) + "&dtype=" + O.L().oriUgcType + "&dvid=" + O.L().oriUgcVid + "&nid=" + O.L().oriUgcNid;
            } else {
                h1 = pbModel.h1();
                str = "?share=9105&fr=sharewise&see_lz=" + (v0 ? 1 : 0);
            }
            String str2 = "http://tieba.baidu.com/p/" + h1 + (str + "&share_from=post");
            String[] M = R0.M();
            String str3 = M[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            Uri parse = str3 == null ? null : Uri.parse(str3);
            String str4 = M[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", R0.m()).param("tid", R0.Q()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(l.default_share_content_tpl);
            if (R0.g0() && O.J() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4) || O.R1() || O.S1()) {
                    if (TextUtils.isEmpty(title)) {
                        c2 = 1;
                        title = M[1];
                    } else {
                        c2 = 1;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = O.J().getName_show();
                    objArr[c2] = TbadkCoreApplication.getInst().getResources().getString(l.default_share_content_tpl_suffix);
                    str4 = MessageFormat.format(string, objArr);
                }
            } else if (m.isEmpty(str4)) {
                str4 = title;
            }
            String cutString = m.cutString(title, 100);
            String cutString2 = m.cutString(str4, 100);
            ShareItem shareItem = new ShareItem();
            shareItem.r = cutString;
            shareItem.s = cutString2;
            if (R0.g0()) {
                shareItem.D = cutString2;
                shareItem.R = -1L;
            } else if (R0.O() != null && R0.O().t1() != null && !R0.O().G2()) {
                shareItem.R = R0.O().t1().play_count.intValue();
            }
            shareItem.t = str2;
            shareItem.f40763c = true;
            shareItem.q = pbModel.h1();
            shareItem.F = 3;
            shareItem.E = i3;
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.h1();
            shareItem.M = b(R0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.v = parse;
            }
            if (i3 == 2) {
                shareItem.F = pbModel.w0();
            }
            if (R0.g0()) {
                shareItem.m0 = false;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (R0 != null && R0.F() != null && R0.F().size() > 0) {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(O, 1, R0.F().get(0));
            } else {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (O != null) {
                shareItem.k0 = O.b1();
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
            shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1426a(pbModel, absPbActivity, rootView));
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            h.c().l(shareDialogConfig);
        }
    }
}
