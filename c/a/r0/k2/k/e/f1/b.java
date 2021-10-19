package c.a.r0.k2.k.e.f1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.r0.f0.f;
import c.a.r0.k2.k.e.s0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f20248a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f20249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20250f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s0 f20251g;

        public a(PbModel pbModel, PbFragment pbFragment, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20249e = pbModel;
            this.f20250f = pbFragment;
            this.f20251g = s0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f20249e) == null || pbModel.P0() == null || !this.f20249e.P0().q0() || TbSingleton.getInstance().isNotchScreen(this.f20250f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f20250f.getBaseFragmentActivity())) {
                return;
            }
            this.f20251g.b1().setSystemUiVisibility(4);
        }
    }

    /* renamed from: c.a.r0.k2.k.e.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0967b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f20252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20253f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20254g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f20255h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f20256i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f20257j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C0967b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j2, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, thread2GroupShareView, Long.valueOf(j2), str, str2, str3, shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20252e = pbModel;
            this.f20253f = pbFragment;
            this.f20254g = thread2GroupShareView;
            this.f20255h = j2;
            this.f20256i = str;
            this.f20257j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                PbModel pbModel = this.f20252e;
                if (pbModel != null && pbModel.P0() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f20252e.getForumId()).param("tid", this.f20252e.f1()).param("obj_locate", 1);
                    if (b.i(this.f20252e.P0()) != 0) {
                        param.param("obj_type", b.i(this.f20252e.P0()));
                    }
                    TiebaStatic.log(param);
                }
                this.f20253f.HidenSoftKeyPad((InputMethodManager) this.f20253f.getBaseFragmentActivity().getSystemService("input_method"), this.f20254g.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f20253f.getBaseFragmentActivity(), this.f20255h, this.f20256i, this.f20257j, this.k, 0, this.f20254g.getLeaveMsg(), this.l.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20259f;

        public c(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20258e = pbFragment;
            this.f20259f = thread2GroupShareView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20258e.HidenSoftKeyPad((InputMethodManager) this.f20258e.getBaseFragmentActivity().getSystemService("input_method"), this.f20259f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20260e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20261f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f20262g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20263h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f20264i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f20265j;

        public d(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j2, String str, long j3, ShareFromPBMsgData shareFromPBMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView, Long.valueOf(j2), str, Long.valueOf(j3), shareFromPBMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20260e = pbFragment;
            this.f20261f = thread2GroupShareView;
            this.f20262g = j2;
            this.f20263h = str;
            this.f20264i = j3;
            this.f20265j = shareFromPBMsgData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20260e.HidenSoftKeyPad((InputMethodManager) this.f20260e.getBaseFragmentActivity().getSystemService("input_method"), this.f20261f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f20260e.getBaseFragmentActivity(), this.f20262g, this.f20263h, this.f20264i, "from_share", this.f20261f.getLeaveMsg(), this.f20265j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f20266e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f20267f;

        public e(PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, thread2GroupShareView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20266e = pbFragment;
            this.f20267f = thread2GroupShareView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20266e.HidenSoftKeyPad((InputMethodManager) this.f20266e.getBaseFragmentActivity().getSystemService("input_method"), this.f20267f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364112462, "Lc/a/r0/k2/k/e/f1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-364112462, "Lc/a/r0/k2/k/e/f1/b;");
                return;
            }
        }
        f20248a = new HashSet();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f20248a.add(str);
        }
    }

    public static ShareItem c(Context context, d2 d2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, d2Var)) == null) {
            if (d2Var == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(d2Var.T());
            String Z = d2Var.Z();
            OriginalForumInfo originalForumInfo = d2Var.J1;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                Z = originalForumInfo.ori_fname;
            }
            String title = d2Var.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = d2Var.o();
            }
            String s1 = d2Var.s1();
            String str = "http://tieba.baidu.com/p/" + s1 + "?share=9105&fr=sharewise";
            String f2 = f(d2Var);
            Uri parse = f2 == null ? null : Uri.parse(f2);
            String o = d2Var.o();
            String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, o);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = d2Var.C1();
            shareItem.D = o;
            shareItem.t = str;
            shareItem.o = 2;
            shareItem.q = s1;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = Z;
            shareItem.K = s1;
            shareItem.f48139f = true;
            shareItem.E = 6;
            shareItem.M = h(d2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(d2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(d2Var, 1, null);
            shareItem.i0 = d2Var.Z0();
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
    /* JADX WARN: Removed duplicated region for block: B:50:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem d(Context context, int i2, int i3, PbModel pbModel) {
        InterceptResult invokeCommon;
        String f1;
        String str;
        String str2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), pbModel})) == null) {
            c.a.r0.k2.h.e P0 = pbModel.P0();
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
            String str3 = "http://tieba.baidu.com/p/" + f1 + (str + "&share_from=post");
            String[] M = P0.M(context);
            String str4 = M[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = M[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", P0.n()).param("tid", P0.Q()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (P0.f0() && O.J() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                    if (TextUtils.isEmpty(title) || O.O1() || O.P1()) {
                        title = M[1];
                    }
                    str2 = MessageFormat.format(string, O.J().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    String cutString = k.cutString(title, 100);
                    String cutString2 = k.cutString(str2, 100);
                    shareItem = new ShareItem();
                    shareItem.r = cutString;
                    shareItem.s = cutString2;
                    if (!P0.f0()) {
                    }
                    shareItem.t = str3;
                    shareItem.f48136c = true;
                    shareItem.q = pbModel.f1();
                    if (i3 == 2) {
                    }
                    shareItem.E = i3;
                    shareItem.G = g(O);
                    shareItem.J = pbModel.getForumId();
                    shareItem.K = pbModel.f1();
                    shareItem.M = i(P0);
                    shareItem.N = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (P0.f0()) {
                    }
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                    if (P0 == null) {
                    }
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                    if (O != null) {
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.F);
                    bundle.putInt("obj_type", shareItem.M);
                    bundle.putString("fid", shareItem.J);
                    bundle.putString("tid", shareItem.K);
                    bundle.putString("uid", shareItem.N);
                    shareItem.k(bundle);
                    return shareItem;
                }
                str2 = str5;
                String cutString3 = k.cutString(title, 100);
                String cutString22 = k.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString3;
                shareItem.s = cutString22;
                if (!P0.f0()) {
                }
                shareItem.t = str3;
                shareItem.f48136c = true;
                shareItem.q = pbModel.f1();
                if (i3 == 2) {
                }
                shareItem.E = i3;
                shareItem.G = g(O);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.f1();
                shareItem.M = i(P0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (P0.f0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                if (P0 == null) {
                }
                shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                if (O != null) {
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("obj_param1", shareItem.F);
                bundle2.putInt("obj_type", shareItem.M);
                bundle2.putString("fid", shareItem.J);
                bundle2.putString("tid", shareItem.K);
                bundle2.putString("uid", shareItem.N);
                shareItem.k(bundle2);
                return shareItem;
            }
            if (k.isEmpty(str5)) {
                str2 = title;
                String cutString32 = k.cutString(title, 100);
                String cutString222 = k.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString32;
                shareItem.s = cutString222;
                if (!P0.f0()) {
                    shareItem.D = cutString222;
                    shareItem.R = -1L;
                } else {
                    shareItem.R = P0.P();
                }
                shareItem.t = str3;
                shareItem.f48136c = true;
                shareItem.q = pbModel.f1();
                if (i3 == 2) {
                    shareItem.F = pbModel.u0();
                }
                shareItem.E = i3;
                shareItem.G = g(O);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.f1();
                shareItem.M = i(P0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (P0.f0()) {
                    shareItem.j0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                if (P0 == null && P0.F() != null && P0.F().size() > 0) {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, P0.F().get(0));
                } else {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                }
                if (O != null) {
                    shareItem.i0 = O.Z0();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.F);
                bundle22.putInt("obj_type", shareItem.M);
                bundle22.putString("fid", shareItem.J);
                bundle22.putString("tid", shareItem.K);
                bundle22.putString("uid", shareItem.N);
                shareItem.k(bundle22);
                return shareItem;
            }
            str2 = str5;
            String cutString322 = k.cutString(title, 100);
            String cutString2222 = k.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString322;
            shareItem.s = cutString2222;
            if (!P0.f0()) {
            }
            shareItem.t = str3;
            shareItem.f48136c = true;
            shareItem.q = pbModel.f1();
            if (i3 == 2) {
            }
            shareItem.E = i3;
            shareItem.G = g(O);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.f1();
            shareItem.M = i(P0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (P0.f0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (P0 == null) {
            }
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
            if (O != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.F);
            bundle222.putInt("obj_type", shareItem.M);
            bundle222.putString("fid", shareItem.J);
            bundle222.putString("tid", shareItem.K);
            bundle222.putString("uid", shareItem.N);
            shareItem.k(bundle222);
            return shareItem;
        }
        return (ShareItem) invokeCommon.objValue;
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.getPbModel() == null || pbFragment.getPbView() == null) {
                return null;
            }
            PbModel pbModel = pbFragment.getPbModel();
            s0 pbView = pbFragment.getPbView();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] M = pbModel.P0().M(pbFragment.getContext());
            PostData u0 = pbView.u0();
            String str2 = "";
            if (u0 != null) {
                str = u0.E();
                String o = u0.o(pbFragment.getContext());
                if (!k.isEmpty(o)) {
                    M[1] = o;
                }
            } else {
                str = "";
            }
            String W = pbModel.P0().O().W();
            if (W == null || !W.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(M[1]);
            shareFromPBMsgData.setImageUrl(M[0]);
            shareFromPBMsgData.setForumName(pbModel.P0().m().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(pbModel.P0().O().f0());
            shareFromPBMsgData.setTitle(pbModel.P0().O().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String f(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, d2Var)) == null) {
            String str = null;
            if (d2Var == null || d2Var.E0() == null) {
                return null;
            }
            ArrayList<MediaData> E0 = d2Var.E0();
            int size = E0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = E0.get(i2);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i2++;
            }
            return (str != null || d2Var.q1() == null || TextUtils.isEmpty(d2Var.q1().thumbnail_url)) ? str : d2Var.q1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public static int g(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, d2Var)) == null) {
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

    public static int h(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, d2Var)) == null) {
            if (d2Var != null) {
                if (d2Var.q2()) {
                    return 4;
                }
                if (d2Var.j0() == 1) {
                    return 3;
                }
                return d2Var.r2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int i(c.a.r0.k2.h.e eVar) {
        InterceptResult invokeL;
        d2 O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, eVar)) == null) {
            if (eVar == null || (O = eVar.O()) == null) {
                return 0;
            }
            if (O.q2()) {
                return 4;
            }
            if (O.j0() == 1) {
                return 3;
            }
            if (O.r2()) {
                return 2;
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
            return O.O1() ? 8 : 1;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? f20248a.contains(str) : invokeL.booleanValue;
    }

    public static void l(PbFragment pbFragment, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j2), str, Long.valueOf(j3)}) == null) || pbFragment == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (pbModel == null || pbModel.P0() == null || pbModel.P0().O() == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new d(pbFragment, thread2GroupShareView, j2, str, j3, e2));
        aVar.setNegativeButton(R.string.cancel, new e(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(e2.getImageUrl(), pbModel.P0().t() == 1);
    }

    public static void m(PbFragment pbFragment, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{pbFragment, Long.valueOf(j2), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (pbModel == null || pbModel.P0() == null || pbModel.P0().O() == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new C0967b(pbModel, pbFragment, thread2GroupShareView, j2, str, str2, str3, e2));
        aVar.setNegativeButton(R.string.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(e2.getImageUrl(), pbModel.P0().t() == 1);
    }

    public static void n(Context context, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, null, context, d2Var, i2) == null) || d2Var == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i2, c(context, d2Var), true));
    }

    public static void o(PbFragment pbFragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65551, null, pbFragment, i2, i3) == null) || pbFragment == null || pbFragment.getPbModel() == null || pbFragment.getPbView() == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        s0 pbView = pbFragment.getPbView();
        if (pbModel.d()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d2 = d(pbFragment.getContext(), i2, i3, pbModel);
            TbadkCoreApplication.getInst().setShareItem(d2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d2, true, true);
            shareDialogConfig.setOnDismissListener(new a(pbModel, pbFragment, pbView));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(pbModel.getTopicId());
            if (pbModel.P0() != null) {
                shareDialogConfig.setShowNovelMask(pbModel.P0().i0());
            }
            f.b().k(shareDialogConfig);
        }
    }
}
