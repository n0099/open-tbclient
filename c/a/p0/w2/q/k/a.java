package c.a.p0.w2.q.k;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.a.d.f.p.m;
import c.a.p0.l0.h;
import c.a.p0.w2.i.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.w2.q.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnDismissListenerC1531a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsPbActivity f20523b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f20524c;

        public DialogInterface$OnDismissListenerC1531a(PbModel pbModel, AbsPbActivity absPbActivity, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, absPbActivity, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.f20523b = absPbActivity;
            this.f20524c = view;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.a) == null || pbModel.S0() == null || !this.a.S0().r0() || TbSingleton.getInstance().isNotchScreen(this.f20523b) || TbSingleton.getInstance().isCutoutScreen(this.f20523b) || (view = this.f20524c) == null) {
                return;
            }
            view.setSystemUiVisibility(4);
        }
    }

    public static int a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i = threadData.threadType;
            if (i == 0) {
                return 1;
            }
            if (i == 40) {
                return 2;
            }
            if (i == 49) {
                return 3;
            }
            return i == 54 ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public static int b(f fVar) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) {
            if (fVar == null || (O = fVar.O()) == null) {
                return 0;
            }
            if (O.isRealGod()) {
                return 4;
            }
            if (O.getIsLive() == 1) {
                return 3;
            }
            if (O.isBJHArticleThreadType()) {
                return 5;
            }
            if (O.isBJHVideoThreadType()) {
                return 6;
            }
            if (O.isBJHNormalThreadType()) {
                return 7;
            }
            if (O.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            return O.isRealVideoThread() ? 2 : 1;
        }
        return invokeL.intValue;
    }

    public static void c(AbsPbActivity absPbActivity, int i, int i2) {
        String k1;
        String str;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65538, null, absPbActivity, i, i2) == null) || absPbActivity == null || absPbActivity.getPbModel() == null) {
            return;
        }
        PbModel pbModel = absPbActivity.getPbModel();
        View rootView = absPbActivity.getRootView();
        if (pbModel.a()) {
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            f S0 = pbModel.S0();
            String title = S0.O().getTitle();
            boolean w0 = pbModel.w0();
            if (S0.l() != null) {
                if (S0.l().isLike() == 1) {
                    AddExperiencedModel.D(S0.m());
                }
            }
            ThreadData O = pbModel.S0().O();
            if (O.isUgcThreadType()) {
                k1 = O.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (w0 ? 1 : 0) + "&dtype=" + O.getBaijiahaoData().oriUgcType + "&dvid=" + O.getBaijiahaoData().oriUgcVid + "&nid=" + O.getBaijiahaoData().oriUgcNid;
            } else {
                k1 = pbModel.k1();
                str = "?share=9105&fr=sharewise&see_lz=" + (w0 ? 1 : 0);
            }
            String str2 = "http://tieba.baidu.com/p/" + k1 + (str + "&share_from=post");
            String[] M = S0.M();
            String str3 = M[0];
            if (!StringUtils.isNull(str3) && str3.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str3 = str3.substring(37);
            }
            Uri parse = str3 == null ? null : Uri.parse(str3);
            String str4 = M[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", S0.m()).param("tid", S0.Q()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047a);
            if (S0.g0() && O.getAuthor() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str4) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                    if (TextUtils.isEmpty(title)) {
                        c2 = 1;
                        title = M[1];
                    } else {
                        c2 = 1;
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = O.getAuthor().getName_show();
                    objArr[c2] = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047b);
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
            if (S0.g0()) {
                shareItem.D = cutString2;
                shareItem.R = -1L;
            } else if (S0.O() != null && S0.O().getThreadVideoInfo() != null && !S0.O().isUgcThreadType()) {
                shareItem.R = S0.O().getThreadVideoInfo().play_count.intValue();
            }
            shareItem.t = str2;
            shareItem.f30353c = true;
            shareItem.q = pbModel.k1();
            shareItem.F = 3;
            shareItem.E = i2;
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.k1();
            shareItem.M = b(S0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
                shareItem.v = parse;
            }
            if (i2 == 2) {
                shareItem.F = pbModel.x0();
            }
            if (S0.g0()) {
                shareItem.m0 = false;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (S0 != null && S0.F() != null && S0.F().size() > 0) {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(O, 1, S0.F().get(0));
            } else {
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (O != null) {
                shareItem.k0 = O.getShareImageUrl();
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
            shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1531a(pbModel, absPbActivity, rootView));
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            h.c().l(shareDialogConfig);
        }
    }
}
