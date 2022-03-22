package c.a.p0.w2.m.f.n1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.o0.r.t.a;
import c.a.o0.s.g.g;
import c.a.p0.l0.h;
import c.a.p0.w2.i.f;
import c.a.p0.w2.m.f.a1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.Thread2GroupShareView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20253b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a1 f20254c;

        public a(PbModel pbModel, PbFragment pbFragment, a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, a1Var};
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
            this.f20253b = pbFragment;
            this.f20254c = a1Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.a) == null || pbModel.S0() == null || !this.a.S0().r0() || TbSingleton.getInstance().isNotchScreen(this.f20253b.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f20253b.getBaseFragmentActivity())) {
                return;
            }
            this.f20254c.a1().setSystemUiVisibility(4);
        }
    }

    /* renamed from: c.a.p0.w2.m.f.n1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1515b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20256c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f20257d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20259f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20260g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f20261h;

        public C1515b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, thread2GroupShareView, Long.valueOf(j), str, str2, str3, shareFromPBMsgData};
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
            this.f20255b = pbFragment;
            this.f20256c = thread2GroupShareView;
            this.f20257d = j;
            this.f20258e = str;
            this.f20259f = str2;
            this.f20260g = str3;
            this.f20261h = shareFromPBMsgData;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                PbModel pbModel = this.a;
                if (pbModel != null && pbModel.S0() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.a.getForumId()).param("tid", this.a.k1()).param("obj_locate", 1);
                    if (b.i(this.a.S0()) != 0) {
                        param.param("obj_type", b.i(this.a.S0()));
                    }
                    TiebaStatic.log(param);
                }
                this.f20255b.HidenSoftKeyPad((InputMethodManager) this.f20255b.getBaseFragmentActivity().getSystemService("input_method"), this.f20256c.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f20255b.getBaseFragmentActivity(), this.f20257d, this.f20258e, this.f20259f, this.f20260g, 0, this.f20256c.getLeaveMsg(), this.f20261h.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20262b;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.f20262b = thread2GroupShareView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.f20262b.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20263b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20264c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f20265d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f20266e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f20267f;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j, String str, long j2, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView, Long.valueOf(j), str, Long.valueOf(j2), shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.f20263b = thread2GroupShareView;
            this.f20264c = j;
            this.f20265d = str;
            this.f20266e = j2;
            this.f20267f = shareFromPBMsgData;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.f20263b.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.getBaseFragmentActivity(), this.f20264c, this.f20265d, this.f20266e, "from_share", this.f20263b.getLeaveMsg(), this.f20267f.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20268b;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
            this.f20268b = thread2GroupShareView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) this.a.getBaseFragmentActivity().getSystemService("input_method"), this.f20268b.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-255273233, "Lc/a/p0/w2/m/f/n1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-255273233, "Lc/a/p0/w2/m/f/n1/b;");
                return;
            }
        }
        a = new HashSet();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.add(str);
        }
    }

    public static ShareItem c(Context context, ThreadData threadData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, threadData)) == null) {
            if (threadData == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                forum_name = originalForumInfo.ori_fname;
            }
            String title = threadData.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = threadData.getAbstract();
            }
            String tid = threadData.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=sharewise";
            String f2 = f(threadData);
            Uri parse = f2 == null ? null : Uri.parse(f2);
            String str2 = threadData.getAbstract();
            String format = MessageFormat.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f110f), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = threadData.getView_num();
            shareItem.D = str2;
            shareItem.t = str;
            shareItem.o = 2;
            shareItem.q = tid;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = forum_name;
            shareItem.K = tid;
            shareItem.f30356f = true;
            shareItem.E = 6;
            shareItem.M = h(threadData);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            shareItem.k0 = threadData.getShareImageUrl();
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.F);
            bundle.putInt("obj_type", shareItem.M);
            bundle.putString("fid", shareItem.J);
            bundle.putString("tid", shareItem.K);
            bundle.putInt("obj_source", shareItem.o);
            shareItem.k(bundle);
            return shareItem;
        }
        return (ShareItem) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem d(int i, int i2, PbModel pbModel) {
        InterceptResult invokeIIL;
        String k1;
        String str;
        String str2;
        ShareItem shareItem;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2, pbModel)) != null) {
            return (ShareItem) invokeIIL.objValue;
        }
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
        String str3 = "http://tieba.baidu.com/p/" + k1 + (str + "&share_from=post");
        String[] M = S0.M();
        String str4 = M[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(37);
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = M[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i == 1) {
            TiebaStatic.log(new StatisticItem("c10399").param("fid", S0.m()).param("tid", S0.Q()).param("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047a);
        if (S0.g0() && O.getAuthor() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                if (TextUtils.isEmpty(title) || O.isBJHVideoDynamicThreadType() || O.isBJHVideoThreadType()) {
                    title = M[1];
                }
                str2 = MessageFormat.format(string, O.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047b));
                String cutString = m.cutString(title, 100);
                String cutString2 = m.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString;
                shareItem.s = cutString2;
                if (!S0.g0()) {
                }
                shareItem.t = str3;
                shareItem.f30353c = true;
                shareItem.q = pbModel.k1();
                if (i2 == 2) {
                }
                shareItem.E = i2;
                shareItem.G = g(threadData);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.k1();
                shareItem.M = i(S0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (S0.g0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                if (S0 == null) {
                }
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                if (threadData != null) {
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.F);
                bundle.putInt("obj_type", shareItem.M);
                bundle.putString("fid", shareItem.J);
                bundle.putString("tid", shareItem.K);
                bundle.putString("uid", shareItem.N);
                shareItem.k(bundle);
                if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                }
            }
            str2 = str5;
            String cutString3 = m.cutString(title, 100);
            String cutString22 = m.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString3;
            shareItem.s = cutString22;
            if (!S0.g0()) {
            }
            shareItem.t = str3;
            shareItem.f30353c = true;
            shareItem.q = pbModel.k1();
            if (i2 == 2) {
            }
            shareItem.E = i2;
            shareItem.G = g(threadData);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.k1();
            shareItem.M = i(S0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (S0.g0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            if (S0 == null) {
            }
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            if (threadData != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.F);
            bundle2.putInt("obj_type", shareItem.M);
            bundle2.putString("fid", shareItem.J);
            bundle2.putString("tid", shareItem.K);
            bundle2.putString("uid", shareItem.N);
            shareItem.k(bundle2);
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
            }
        } else {
            if (m.isEmpty(str5)) {
                str2 = title;
                String cutString32 = m.cutString(title, 100);
                String cutString222 = m.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString32;
                shareItem.s = cutString222;
                if (!S0.g0()) {
                    shareItem.D = cutString222;
                    threadData = O;
                    shareItem.R = -1L;
                } else {
                    threadData = O;
                    shareItem.R = S0.P();
                }
                shareItem.t = str3;
                shareItem.f30353c = true;
                shareItem.q = pbModel.k1();
                if (i2 == 2) {
                    shareItem.F = pbModel.x0();
                }
                shareItem.E = i2;
                shareItem.G = g(threadData);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.k1();
                shareItem.M = i(S0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (S0.g0()) {
                    shareItem.m0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                if (S0 == null && S0.F() != null && S0.F().size() > 0) {
                    shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, S0.F().get(0));
                } else {
                    shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
                }
                if (threadData != null) {
                    shareItem.k0 = threadData.getShareImageUrl();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.F);
                bundle22.putInt("obj_type", shareItem.M);
                bundle22.putString("fid", shareItem.J);
                bundle22.putString("tid", shareItem.K);
                bundle22.putString("uid", shareItem.N);
                shareItem.k(bundle22);
                if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
                    return shareItem;
                }
                int k = g.k(threadData);
                String forum_name = threadData.getForum_name();
                OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
                if (originalForumInfo != null) {
                    forum_name = originalForumInfo.ori_fname;
                }
                shareItem.y0 = g.j(threadData, k);
                shareItem.z0 = g.i(threadData, k, forum_name, shareItem.R, "", M[1]);
                return shareItem;
            }
            str2 = str5;
            String cutString322 = m.cutString(title, 100);
            String cutString2222 = m.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString322;
            shareItem.s = cutString2222;
            if (!S0.g0()) {
            }
            shareItem.t = str3;
            shareItem.f30353c = true;
            shareItem.q = pbModel.k1();
            if (i2 == 2) {
            }
            shareItem.E = i2;
            shareItem.G = g(threadData);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.k1();
            shareItem.M = i(S0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (S0.g0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            if (S0 == null) {
            }
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(threadData, 1, null);
            if (threadData != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.F);
            bundle222.putInt("obj_type", shareItem.M);
            bundle222.putString("fid", shareItem.J);
            bundle222.putString("tid", shareItem.K);
            bundle222.putString("uid", shareItem.N);
            shareItem.k(bundle222);
            if (UbsABTestHelper.isShareH5CardOptimizeABTestA()) {
            }
        }
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.w() == null || pbFragment.S4() == null) {
                return null;
            }
            PbModel w = pbFragment.w();
            a1 S4 = pbFragment.S4();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] M = w.S0().M();
            PostData t0 = S4.t0();
            String str2 = "";
            if (t0 != null) {
                str = t0.G();
                String n = t0.n();
                if (!m.isEmpty(n)) {
                    M[1] = n;
                }
            } else {
                str = "";
            }
            String firstPostId = w.S0().O().getFirstPostId();
            if (firstPostId == null || !firstPostId.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(M[1]);
            shareFromPBMsgData.setImageUrl(M[0]);
            shareFromPBMsgData.setForumName(w.S0().l().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(w.S0().O().getId());
            shareFromPBMsgData.setTitle(w.S0().O().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, threadData)) == null) {
            String str = null;
            if (threadData == null || threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MediaData mediaData = medias.get(i);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i++;
            }
            return (str != null || threadData.getThreadVideoInfo() == null || TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) ? str : threadData.getThreadVideoInfo().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public static int g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadData)) == null) {
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

    public static int h(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
            if (threadData != null) {
                if (threadData.isRealGod()) {
                    return 4;
                }
                if (threadData.getIsLive() == 1) {
                    return 3;
                }
                return threadData.isRealVideoThread() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int i(f fVar) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVar)) == null) {
            if (fVar == null || (O = fVar.O()) == null) {
                return 0;
            }
            if (O.isRealGod()) {
                return 4;
            }
            if (O.getIsLive() == 1) {
                return 3;
            }
            if (O.isRealVideoThread()) {
                return 2;
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
            return O.isBJHVideoDynamicThreadType() ? 8 : 1;
        }
        return invokeL.intValue;
    }

    public static void j(PbFragment pbFragment, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, pbFragment, intent) == null) {
            m(pbFragment, intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
        }
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? a.contains(str) : invokeL.booleanValue;
    }

    public static void l(PbFragment pbFragment, long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j), str, Long.valueOf(j2)}) == null) || pbFragment == null) {
            return;
        }
        PbModel w = pbFragment.w();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (w == null || w.S0() == null || w.S0().O() == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f1107, new d(pbFragment, thread2GroupShareView, j, str, j2, e2));
        aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new e(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (m.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(e2.getImageUrl(), w.S0().s() == 1);
    }

    public static void m(PbFragment pbFragment, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{pbFragment, Long.valueOf(j), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel w = pbFragment.w();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (w == null || w.S0() == null || w.S0().O() == null) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f1107, new C1515b(w, pbFragment, thread2GroupShareView, j, str, str2, str3, e2));
        aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (m.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.c(e2.getImageUrl(), w.S0().s() == 1);
    }

    public static void n(Context context, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, null, context, threadData, i) == null) || threadData == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i, c(context, threadData), true));
    }

    public static void o(PbFragment pbFragment, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65551, null, pbFragment, i, i2) == null) || pbFragment == null || pbFragment.w() == null || pbFragment.S4() == null) {
            return;
        }
        PbModel w = pbFragment.w();
        a1 S4 = pbFragment.S4();
        if (w.a()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d2 = d(i, i2, w);
            TbadkCoreApplication.getInst().setShareItem(d2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d2, true, true);
            shareDialogConfig.setOnDismissListener(new a(w, pbFragment, S4));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(w.getTopicId());
            if (w.S0() != null) {
                shareDialogConfig.setShowNovelMask(w.S0().j0());
            }
            h.c().l(shareDialogConfig);
        }
    }
}
