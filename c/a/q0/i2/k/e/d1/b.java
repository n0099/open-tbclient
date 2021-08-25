package c.a.q0.i2.k.e.d1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.p0.s.q.c2;
import c.a.p0.s.s.a;
import c.a.q0.e0.f;
import c.a.q0.i2.k.e.q0;
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
    public static final Set<String> f19353a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f19354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q0 f19356g;

        public a(PbModel pbModel, PbFragment pbFragment, q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, pbFragment, q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19354e = pbModel;
            this.f19355f = pbFragment;
            this.f19356g = q0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || (pbModel = this.f19354e) == null || pbModel.O0() == null || !this.f19354e.O0().p0() || TbSingleton.getInstance().isNotchScreen(this.f19355f.getBaseFragmentActivity()) || TbSingleton.getInstance().isCutoutScreen(this.f19355f.getBaseFragmentActivity())) {
                return;
            }
            this.f19356g.b1().setSystemUiVisibility(4);
        }
    }

    /* renamed from: c.a.q0.i2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0922b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbModel f19357e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19358f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f19359g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f19360h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f19361i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f19362j;
        public final /* synthetic */ String k;
        public final /* synthetic */ ShareFromPBMsgData l;

        public C0922b(PbModel pbModel, PbFragment pbFragment, Thread2GroupShareView thread2GroupShareView, long j2, String str, String str2, String str3, ShareFromPBMsgData shareFromPBMsgData) {
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
            this.f19357e = pbModel;
            this.f19358f = pbFragment;
            this.f19359g = thread2GroupShareView;
            this.f19360h = j2;
            this.f19361i = str;
            this.f19362j = str2;
            this.k = str3;
            this.l = shareFromPBMsgData;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                PbModel pbModel = this.f19357e;
                if (pbModel != null && pbModel.O0() != null) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 1).param("obj_param1", 3).param("fid", this.f19357e.getForumId()).param("tid", this.f19357e.e1()).param("obj_locate", 1);
                    if (b.i(this.f19357e.O0()) != 0) {
                        param.param("obj_type", b.i(this.f19357e.O0()));
                    }
                    TiebaStatic.log(param);
                }
                this.f19358f.HidenSoftKeyPad((InputMethodManager) this.f19358f.getBaseFragmentActivity().getSystemService("input_method"), this.f19359g.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f19358f.getBaseFragmentActivity(), this.f19360h, this.f19361i, this.f19362j, this.k, 0, this.f19359g.getLeaveMsg(), this.l.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19363e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f19364f;

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
            this.f19363e = pbFragment;
            this.f19364f = thread2GroupShareView;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19363e.HidenSoftKeyPad((InputMethodManager) this.f19363e.getBaseFragmentActivity().getSystemService("input_method"), this.f19364f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19365e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f19366f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f19367g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19368h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ long f19369i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f19370j;

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
            this.f19365e = pbFragment;
            this.f19366f = thread2GroupShareView;
            this.f19367g = j2;
            this.f19368h = str;
            this.f19369i = j3;
            this.f19370j = shareFromPBMsgData;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19365e.HidenSoftKeyPad((InputMethodManager) this.f19365e.getBaseFragmentActivity().getSystemService("input_method"), this.f19366f.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f19365e.getBaseFragmentActivity(), this.f19367g, this.f19368h, this.f19369i, "from_share", this.f19366f.getLeaveMsg(), this.f19370j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19371e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Thread2GroupShareView f19372f;

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
            this.f19371e = pbFragment;
            this.f19372f = thread2GroupShareView;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19371e.HidenSoftKeyPad((InputMethodManager) this.f19371e.getBaseFragmentActivity().getSystemService("input_method"), this.f19372f.getChatMsgView());
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131676751, "Lc/a/q0/i2/k/e/d1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131676751, "Lc/a/q0/i2/k/e/d1/b;");
                return;
            }
        }
        f19353a = new HashSet();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f19353a.add(str);
        }
    }

    public static ShareItem c(Context context, c2 c2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, c2Var)) == null) {
            if (c2Var == null || context == null) {
                return null;
            }
            String valueOf = String.valueOf(c2Var.T());
            String Z = c2Var.Z();
            OriginalForumInfo originalForumInfo = c2Var.G1;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                Z = originalForumInfo.ori_fname;
            }
            String title = c2Var.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = c2Var.o();
            }
            String q1 = c2Var.q1();
            String str = "http://tieba.baidu.com/p/" + q1 + "?share=9105&fr=sharewise";
            String f2 = f(c2Var);
            Uri parse = f2 == null ? null : Uri.parse(f2);
            String o = c2Var.o();
            String format = MessageFormat.format(context.getResources().getString(R.string.share_content_tpl), title, o);
            ShareItem shareItem = new ShareItem();
            shareItem.r = title;
            shareItem.s = format;
            shareItem.R = c2Var.A1();
            shareItem.D = o;
            shareItem.t = str;
            shareItem.o = 2;
            shareItem.q = q1;
            shareItem.F = 3;
            shareItem.J = valueOf;
            shareItem.p = Z;
            shareItem.K = q1;
            shareItem.f47982f = true;
            shareItem.E = 6;
            shareItem.M = h(c2Var);
            if (parse != null) {
                shareItem.v = parse;
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(c2Var);
            shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(c2Var, 1, null);
            shareItem.f0 = c2Var.X0();
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
        String e1;
        String str;
        String str2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), pbModel})) == null) {
            c.a.q0.i2.h.e O0 = pbModel.O0();
            String title = O0.O().getTitle();
            boolean s0 = pbModel.s0();
            if (O0.m() != null) {
                if (O0.m().isLike() == 1) {
                    AddExperiencedModel.B(O0.n());
                }
            }
            c2 O = pbModel.O0().O();
            if (O.z2()) {
                e1 = O.L().oriUgcTid;
                str = "?share=9105&fr=dshare&see_lz=" + (s0 ? 1 : 0) + "&dtype=" + O.L().oriUgcType + "&dvid=" + O.L().oriUgcVid + "&nid=" + O.L().oriUgcNid;
            } else {
                e1 = pbModel.e1();
                str = "?share=9105&fr=sharewise&see_lz=" + (s0 ? 1 : 0);
            }
            String str3 = "http://tieba.baidu.com/p/" + e1 + (str + "&share_from=post");
            String[] M = O0.M(context);
            String str4 = M[0];
            if (!StringUtils.isNull(str4) && str4.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                str4 = str4.substring(37);
            }
            Uri parse = str4 == null ? null : Uri.parse(str4);
            String str5 = M[1];
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (i2 == 1) {
                TiebaStatic.log(new StatisticItem("c10399").param("fid", O0.n()).param("tid", O0.Q()).param("uid", currentAccount));
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (O0.f0() && O.J() != null) {
                if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str5)) {
                    if (TextUtils.isEmpty(title) || O.L1() || O.M1()) {
                        title = M[1];
                    }
                    str2 = MessageFormat.format(string, O.J().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    String cutString = k.cutString(title, 100);
                    String cutString2 = k.cutString(str2, 100);
                    shareItem = new ShareItem();
                    shareItem.r = cutString;
                    shareItem.s = cutString2;
                    if (!O0.f0()) {
                    }
                    shareItem.t = str3;
                    shareItem.f47979c = true;
                    shareItem.q = pbModel.e1();
                    if (i3 == 2) {
                    }
                    shareItem.E = i3;
                    shareItem.G = g(O);
                    shareItem.J = pbModel.getForumId();
                    shareItem.K = pbModel.e1();
                    shareItem.M = i(O0);
                    shareItem.N = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                    }
                    if (O0.f0()) {
                    }
                    shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                    if (O0 == null) {
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
                if (!O0.f0()) {
                }
                shareItem.t = str3;
                shareItem.f47979c = true;
                shareItem.q = pbModel.e1();
                if (i3 == 2) {
                }
                shareItem.E = i3;
                shareItem.G = g(O);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.e1();
                shareItem.M = i(O0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                }
                if (O0.f0()) {
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                if (O0 == null) {
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
                if (!O0.f0()) {
                    shareItem.D = cutString222;
                    shareItem.R = -1L;
                } else {
                    shareItem.R = O0.P();
                }
                shareItem.t = str3;
                shareItem.f47979c = true;
                shareItem.q = pbModel.e1();
                if (i3 == 2) {
                    shareItem.F = pbModel.t0();
                }
                shareItem.E = i3;
                shareItem.G = g(O);
                shareItem.J = pbModel.getForumId();
                shareItem.K = pbModel.e1();
                shareItem.M = i(O0);
                shareItem.N = TbadkCoreApplication.getCurrentAccount();
                if (parse != null) {
                    shareItem.v = parse;
                }
                if (O0.f0()) {
                    shareItem.g0 = false;
                }
                shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
                if (O0 == null && O0.F() != null && O0.F().size() > 0) {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, O0.F().get(0));
                } else {
                    shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(O, 1, null);
                }
                if (O != null) {
                    shareItem.f0 = O.X0();
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
            if (!O0.f0()) {
            }
            shareItem.t = str3;
            shareItem.f47979c = true;
            shareItem.q = pbModel.e1();
            if (i3 == 2) {
            }
            shareItem.E = i3;
            shareItem.G = g(O);
            shareItem.J = pbModel.getForumId();
            shareItem.K = pbModel.e1();
            shareItem.M = i(O0);
            shareItem.N = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (O0.f0()) {
            }
            shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(O);
            if (O0 == null) {
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
            q0 pbView = pbFragment.getPbView();
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            String[] M = pbModel.O0().M(pbFragment.getContext());
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
            String W = pbModel.O0().O().W();
            if (W == null || !W.equals(str)) {
                str2 = str;
            }
            shareFromPBMsgData.setContent(M[1]);
            shareFromPBMsgData.setImageUrl(M[0]);
            shareFromPBMsgData.setForumName(pbModel.O0().m().getName());
            shareFromPBMsgData.setPostId(str2);
            shareFromPBMsgData.setThreadId(pbModel.O0().O().f0());
            shareFromPBMsgData.setTitle(pbModel.O0().O().getTitle());
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeL.objValue;
    }

    public static String f(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, c2Var)) == null) {
            String str = null;
            if (c2Var == null || c2Var.C0() == null) {
                return null;
            }
            ArrayList<MediaData> C0 = c2Var.C0();
            int size = C0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MediaData mediaData = C0.get(i2);
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
            return (str != null || c2Var.o1() == null || TextUtils.isEmpty(c2Var.o1().thumbnail_url)) ? str : c2Var.o1().thumbnail_url;
        }
        return (String) invokeL.objValue;
    }

    public static int g(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, c2Var)) == null) {
            if (c2Var == null) {
                return 0;
            }
            if (c2Var.B2()) {
                return 11;
            }
            if (c2Var.J1()) {
                return 10;
            }
            if (c2Var.M1()) {
                return 9;
            }
            if (c2Var.L1()) {
                return 8;
            }
            if (c2Var.K1()) {
                return 7;
            }
            if (c2Var.w1) {
                return 6;
            }
            int i2 = c2Var.a0;
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

    public static int h(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c2Var)) == null) {
            if (c2Var != null) {
                if (c2Var.m2()) {
                    return 4;
                }
                if (c2Var.j0() == 1) {
                    return 3;
                }
                return c2Var.n2() ? 2 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int i(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        c2 O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, eVar)) == null) {
            if (eVar == null || (O = eVar.O()) == null) {
                return 0;
            }
            if (O.m2()) {
                return 4;
            }
            if (O.j0() == 1) {
                return 3;
            }
            if (O.n2()) {
                return 2;
            }
            if (O.J1()) {
                return 5;
            }
            if (O.M1()) {
                return 6;
            }
            if (O.K1()) {
                return 7;
            }
            return O.L1() ? 8 : 1;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? f19353a.contains(str) : invokeL.booleanValue;
    }

    public static void l(PbFragment pbFragment, long j2, String str, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbFragment, Long.valueOf(j2), str, Long.valueOf(j3)}) == null) || pbFragment == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (pbModel == null || pbModel.O0() == null || pbModel.O0().O() == null) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(pbFragment.getBaseFragmentActivity());
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
        thread2GroupShareView.loadImageIcon(e2.getImageUrl(), pbModel.O0().t() == 1);
    }

    public static void m(PbFragment pbFragment, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{pbFragment, Long.valueOf(j2), str, str2, str3}) == null) || pbFragment == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        ShareFromPBMsgData e2 = e(pbFragment);
        if (pbModel == null || pbModel.O0() == null || pbModel.O0().O() == null) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(pbFragment.getBaseFragmentActivity());
        Thread2GroupShareView thread2GroupShareView = new Thread2GroupShareView(pbFragment.getBaseFragmentActivity());
        thread2GroupShareView.setData(e2);
        aVar.setContentViewSize(1);
        aVar.setContentView(thread2GroupShareView);
        aVar.setPositiveButton(R.string.share, new C0922b(pbModel, pbFragment, thread2GroupShareView, j2, str, str2, str3, e2));
        aVar.setNegativeButton(R.string.cancel, new c(pbFragment, thread2GroupShareView));
        aVar.setCanceledOnTouchOutside(true);
        aVar.create(pbFragment.getPageContext()).show();
        if (k.isEmpty(e2.getImageUrl())) {
            return;
        }
        thread2GroupShareView.loadImageIcon(e2.getImageUrl(), pbModel.O0().t() == 1);
    }

    public static void n(Context context, c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, null, context, c2Var, i2) == null) || c2Var == null || context == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(context, i2, c(context, c2Var), true));
    }

    public static void o(PbFragment pbFragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65551, null, pbFragment, i2, i3) == null) || pbFragment == null || pbFragment.getPbModel() == null || pbFragment.getPbView() == null) {
            return;
        }
        PbModel pbModel = pbFragment.getPbModel();
        q0 pbView = pbFragment.getPbView();
        if (pbModel.d()) {
            TiebaStatic.eventStat(pbFragment.getContext(), CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            ShareItem d2 = d(pbFragment.getContext(), i2, i3, pbModel);
            TbadkCoreApplication.getInst().setShareItem(d2);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(pbFragment.getContext(), d2, true, true);
            shareDialogConfig.setOnDismissListener(new a(pbModel, pbFragment, pbView));
            Bundle bundle = new Bundle();
            bundle.putInt("source", 3);
            shareDialogConfig.shareItem.k(bundle);
            shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
            if (pbModel.O0() != null) {
                shareDialogConfig.setShowNovelMask(pbModel.O0().i0());
            }
            f.b().k(shareDialogConfig);
        }
    }
}
