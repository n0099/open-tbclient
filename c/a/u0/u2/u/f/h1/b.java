package c.a.u0.u2.u.f.h1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.t0.s.r.e2;
import c.a.t0.s.t.a;
import c.a.t0.t.g.g;
import c.a.u0.k0.h;
import c.a.u0.u2.l;
import c.a.u0.u2.r.f;
import c.a.u0.u2.u.f.u0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f23665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f23666f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ u0 f23667g;

        public a(PbModel pbModel, PbFragment pbFragment, u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23665e = pbModel;
            this.f23666f = pbFragment;
            this.f23667g = u0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f23665e) == null || pbModel.R0() == null || !this.f23665e.R0().r0() || TbSingleton.getInstance().isNotchScreen(this.f23666f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f23666f.getBaseFragmentActivity())) {
                return;
            }
            this.f23667g.b1().setSystemUiVisibility(4);
        }
    }

    /* renamed from: c.a.u0.u2.u.f.h1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1444b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f23668e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f23669f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f23670g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f23671h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f23672i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f23673j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C1444b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j2, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
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
            this.f23668e = pbModel;
            this.f23669f = pbFragment;
            this.f23670g = thread2GroupShareView;
            this.f23671h = j2;
            this.f23672i = str;
            this.f23673j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                PbModel pbModel = this.f23668e;
                if (pbModel != null && pbModel.R0() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f23668e.getForumId()).param("tid", this.f23668e.h1()).param("obj_locate", 1);
                    if (b.i(this.f23668e.R0()) != 0) {
                        param.param("obj_type", b.i(this.f23668e.R0()));
                    }
                    TiebaStatic.log(param);
                }
                this.f23669f.HidenSoftKeyPad((InputMethodManager) this.f23669f.getBaseFragmentActivity().getSystemService("input_method"), this.f23670g.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f23669f.getBaseFragmentActivity(), this.f23671h, this.f23672i, this.f23673j, this.k, 0, this.f23670g.getLeaveMsg(), this.l.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f23674e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f23675f;

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
            this.f23674e = pbFragment;
            this.f23675f = thread2GroupShareView;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23674e.HidenSoftKeyPad((InputMethodManager) this.f23674e.getBaseFragmentActivity().getSystemService("input_method"), this.f23675f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f23676e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f23677f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f23678g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f23679h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f23680i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f23681j;

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
            this.f23676e = pbFragment;
            this.f23677f = thread2GroupShareView;
            this.f23678g = j2;
            this.f23679h = str;
            this.f23680i = j3;
            this.f23681j = shareFromPBMsgData;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23676e.HidenSoftKeyPad((InputMethodManager) this.f23676e.getBaseFragmentActivity().getSystemService("input_method"), this.f23677f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f23676e.getBaseFragmentActivity(), this.f23678g, this.f23679h, this.f23680i, "from_share", this.f23677f.getLeaveMsg(), this.f23681j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f23682e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f23683f;

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
            this.f23682e = pbFragment;
            this.f23683f = thread2GroupShareView;
        }

        @Override // c.a.t0.s.t.a.e
        public void onClick(c.a.t0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f23682e.HidenSoftKeyPad((InputMethodManager) this.f23682e.getBaseFragmentActivity().getSystemService("input_method"), this.f23683f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1149078136, "Lc/a/u0/u2/u/f/h1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1149078136, "Lc/a/u0/u2/u/f/h1/b;");
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

    public static ShareItem c(Context context, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, e2Var)) == null) {
            if (e2Var == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(e2Var.U());
            String b0 = e2Var.b0();
            OriginalForumInfo originalForumInfo = e2Var.J1;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                b0 = originalForumInfo.ori_fname;
            }
            String title = e2Var.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = e2Var.o();
            }
            String w1 = e2Var.w1();
            String str = "http://tieba.baidu.com/p/" + w1 + "?share=9105&fr=sharewise";
            String f2 = f(e2Var);
            Uri parse = f2 == null ? null : Uri.parse(f2);
            String o = e2Var.o();
            String format = MessageFormat.format(context.getResources().getString(l.share_content_tpl), title, o);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = e2Var.F1();
            shareItem.D = o;
            shareItem.t = str;
            shareItem.o = 2;
            shareItem.q = w1;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = b0;
            shareItem.K = w1;
            shareItem.f41023f = true;
            shareItem.E = 6;
            shareItem.M = h(e2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var, 1, null);
            shareItem.k0 = e2Var.c1();
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

    /* JADX WARN: Removed duplicated region for block: B:49:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShareItem d(int i2, int i3, PbModel pbModel) {
        InterceptResult invokeIIL;
        String h1;
        String str;
        String str2;
        ShareItem shareItem;
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, pbModel)) != null) {
            return (ShareItem) invokeIIL.objValue;
        }
        f R0 = pbModel.R0();
        String title = R0.O().getTitle();
        boolean v0 = pbModel.v0();
        if (R0.l() != null) {
            if (R0.l().isLike() == 1) {
                AddExperiencedModel.B(R0.m());
            }
        }
        e2 O = pbModel.R0().O();
        if (O.H2()) {
            h1 = O.L().oriUgcTid;
            str = "?share=9105&fr=dshare&see_lz=" + (v0 ? 1 : 0) + "&dtype=" + O.L().oriUgcType + "&dvid=" + O.L().oriUgcVid + "&nid=" + O.L().oriUgcNid;
        } else {
            h1 = pbModel.h1();
            str = "?share=9105&fr=sharewise&see_lz=" + (v0 ? 1 : 0);
        }
        String str3 = "http://tieba.baidu.com/p/" + h1 + (str + "&share_from=post");
        String[] M = R0.M();
        String str4 = M[0];
        if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
            str4 = str4.substring(37);
        }
        Uri parse = str4 == null ? null : Uri.parse(str4);
        String str5 = M[1];
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem("c10399").param("fid", R0.m()).param("tid", R0.Q()).param("uid", currentAccount));
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(l.default_share_content_tpl);
        if (R0.g0() && O.J() != null) {
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                if (TextUtils.isEmpty(title) || O.S1() || O.T1()) {
                    title = M[1];
                }
                str2 = MessageFormat.format(string, O.J().getName_show(), TbadkCoreApplication.getInst().getResources().getString(l.default_share_content_tpl_suffix));
                String cutString = m.cutString(title, 100);
                String cutString2 = m.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString;
                shareItem.s = cutString2;
                if (!R0.g0()) {
                }
                shareItem.t = str3;
                shareItem.f41020c = true;
                shareItem.q = pbModel.h1();
                if (i3 == 2) {
                }
                shareItem.E = i3;
                shareItem.G = g(e2Var);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.h1();
                shareItem.M = i(R0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (R0.g0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
                if (R0 == null) {
                }
                shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var, 1, null);
                if (e2Var != null) {
                }
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.F);
                bundle.putInt("obj_type", shareItem.M);
                bundle.putString("fid", shareItem.J);
                bundle.putString("tid", shareItem.K);
                bundle.putString("uid", shareItem.N);
                shareItem.k(bundle);
                if (c.a.t0.b.d.n0()) {
                }
            }
            str2 = str5;
            String cutString3 = m.cutString(title, 100);
            String cutString22 = m.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString3;
            shareItem.s = cutString22;
            if (!R0.g0()) {
            }
            shareItem.t = str3;
            shareItem.f41020c = true;
            shareItem.q = pbModel.h1();
            if (i3 == 2) {
            }
            shareItem.E = i3;
            shareItem.G = g(e2Var);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.h1();
            shareItem.M = i(R0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (R0.g0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
            if (R0 == null) {
            }
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var, 1, null);
            if (e2Var != null) {
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.F);
            bundle2.putInt("obj_type", shareItem.M);
            bundle2.putString("fid", shareItem.J);
            bundle2.putString("tid", shareItem.K);
            bundle2.putString("uid", shareItem.N);
            shareItem.k(bundle2);
            if (c.a.t0.b.d.n0()) {
            }
        } else {
            if (m.isEmpty(str5)) {
                str2 = title;
                String cutString32 = m.cutString(title, 100);
                String cutString222 = m.cutString(str2, 100);
                shareItem = new ShareItem();
                shareItem.r = cutString32;
                shareItem.s = cutString222;
                if (!R0.g0()) {
                    shareItem.D = cutString222;
                    e2Var = O;
                    shareItem.R = -1L;
                } else {
                    e2Var = O;
                    shareItem.R = R0.P();
                }
                shareItem.t = str3;
                shareItem.f41020c = true;
                shareItem.q = pbModel.h1();
                if (i3 == 2) {
                    shareItem.F = pbModel.w0();
                }
                shareItem.E = i3;
                shareItem.G = g(e2Var);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.h1();
                shareItem.M = i(R0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (R0.g0()) {
                    shareItem.m0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
                if (R0 == null && R0.F() != null && R0.F().size() > 0) {
                    shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var, 1, R0.F().get(0));
                } else {
                    shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var, 1, null);
                }
                if (e2Var != null) {
                    shareItem.k0 = e2Var.c1();
                }
                Bundle bundle22 = new Bundle();
                bundle22.putInt("obj_param1", shareItem.F);
                bundle22.putInt("obj_type", shareItem.M);
                bundle22.putString("fid", shareItem.J);
                bundle22.putString("tid", shareItem.K);
                bundle22.putString("uid", shareItem.N);
                shareItem.k(bundle22);
                if (c.a.t0.b.d.n0()) {
                    return shareItem;
                }
                int k = g.k(e2Var);
                String b0 = e2Var.b0();
                OriginalForumInfo originalForumInfo = e2Var.J1;
                if (originalForumInfo != null) {
                    b0 = originalForumInfo.ori_fname;
                }
                shareItem.y0 = g.j(e2Var, k);
                shareItem.z0 = g.i(e2Var, k, b0, shareItem.R, "", M[1]);
                return shareItem;
            }
            str2 = str5;
            String cutString322 = m.cutString(title, 100);
            String cutString2222 = m.cutString(str2, 100);
            shareItem = new ShareItem();
            shareItem.r = cutString322;
            shareItem.s = cutString2222;
            if (!R0.g0()) {
            }
            shareItem.t = str3;
            shareItem.f41020c = true;
            shareItem.q = pbModel.h1();
            if (i3 == 2) {
            }
            shareItem.E = i3;
            shareItem.G = g(e2Var);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.h1();
            shareItem.M = i(R0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (R0.g0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(e2Var);
            if (R0 == null) {
            }
            shareItem.W = ShareItem.ForwardInfo.generateForwardInfo(e2Var, 1, null);
            if (e2Var != null) {
            }
            Bundle bundle222 = new Bundle();
            bundle222.putInt("obj_param1", shareItem.F);
            bundle222.putInt("obj_type", shareItem.M);
            bundle222.putString("fid", shareItem.J);
            bundle222.putString("tid", shareItem.K);
            bundle222.putString("uid", shareItem.N);
            shareItem.k(bundle222);
            if (c.a.t0.b.d.n0()) {
            }
        }
    }

    public static ShareFromPBMsgData e(PbFragment pbFragment) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pbFragment)) == null) {
            if (pbFragment == null || pbFragment.getPbModel() == null || pbFragment.getPbView() == null) {
                return null;
            }
            PbModel pbModel = pbFragment.getPbModel();
            u0 pbView = pbFragment.getPbView();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] M = pbModel.R0().M();
            PostData t0 = pbView.t0();
            String str2 = "";
            if (t0 != null) {
                str = t0.G();
                String o = t0.o();
                if (!m.isEmpty(o)) {
                    M[1] = o;
                }
            } else {
                str = "";
            }
            String X = pbModel.R0().O().X();
            if (X == null || !X.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(M[1]);
            shareFromPBMsgData.setImageUrl(M[0]);
            shareFromPBMsgData.setForumName(pbModel.R0().l().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(pbModel.R0().O().h0());
            shareFromPBMsgData.setTitle(pbModel.R0().O().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String f(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, e2Var)) == null) {
            String str = null;
            if (e2Var == null || e2Var.G0() == null) {
                return null;
            }
            ArrayList<MediaData> G0 = e2Var.G0();
            int size = G0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = G0.get(i2);
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
            return (str != null || e2Var.u1() == null || TextUtils.isEmpty(e2Var.u1().thumbnail_url)) ? str : e2Var.u1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public static int g(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, e2Var)) == null) {
            if (e2Var == null) {
                return 0;
            }
            if (e2Var.J2()) {
                return 11;
            }
            if (e2Var.Q1()) {
                return 10;
            }
            if (e2Var.T1()) {
                return 9;
            }
            if (e2Var.S1()) {
                return 8;
            }
            if (e2Var.R1()) {
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

    public static int h(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, e2Var)) == null) {
            if (e2Var != null) {
                if (e2Var.u2()) {
                    return 4;
                }
                if (e2Var.l0() == 1) {
                    return 3;
                }
                return e2Var.v2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int i(f fVar) {
        InterceptResult invokeL;
        e2 O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVar)) == null) {
            if (fVar == null || (O = fVar.O()) == null) {
                return 0;
            }
            if (O.u2()) {
                return 4;
            }
            if (O.l0() == 1) {
                return 3;
            }
            if (O.v2()) {
                return 2;
            }
            if (O.Q1()) {
                return 5;
            }
            if (O.T1()) {
                return 6;
            }
            if (O.R1()) {
                return 7;
            }
            return O.S1() ? 8 : 1;
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

    public static void l(PbFragment pbFragment, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j2), str, Long.valueOf(j3)}) == null) || pbFragment == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (pbModel == null || pbModel.R0() == null || pbModel.R0().O() == null) {
            return;
        }
        c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(l.share, new d(pbFragment, thread2GroupShareView, j2, str, j3, e2));
        aVar.setNegativeButton(l.cancel, new e(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (m.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(e2.getImageUrl(), pbModel.R0().s() == 1);
    }

    public static void m(PbFragment pbFragment, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{pbFragment, Long.valueOf(j2), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (pbModel == null || pbModel.R0() == null || pbModel.R0().O() == null) {
            return;
        }
        c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(l.share, new C1444b(pbModel, pbFragment, thread2GroupShareView, j2, str, str2, str3, e2));
        aVar.setNegativeButton(l.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (m.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(e2.getImageUrl(), pbModel.R0().s() == 1);
    }

    public static void n(Context context, e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, null, context, e2Var, i2) == null) || e2Var == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i2, c(context, e2Var), true));
    }

    public static void o(PbFragment pbFragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65551, null, pbFragment, i2, i3) == null) || pbFragment == null || pbFragment.getPbModel() == null || pbFragment.getPbView() == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        u0 pbView = pbFragment.getPbView();
        if (pbModel.a()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d2 = d(i2, i3, pbModel);
            TbadkCoreApplication.getInst().setShareItem(d2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d2, true, true);
            shareDialogConfig.setOnDismissListener(new a(pbModel, pbFragment, pbView));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            bundle.putInt("obj_param1", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            shareDialogConfig.setTopicId(pbModel.getTopicId());
            if (pbModel.R0() != null) {
                shareDialogConfig.setShowNovelMask(pbModel.R0().j0());
            }
            h.c().l(shareDialogConfig);
        }
    }
}
