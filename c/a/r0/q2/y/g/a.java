package c.a.r0.q2.y.g;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c0.d;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.m0;
import c.a.q0.s.q.z1;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.i;
import c.a.r0.d1.w0;
import c.a.r0.k.g;
import c.a.r0.k.j;
import c.a.r0.q2.u.f.e0;
import c.a.r0.q2.u.f.f0;
import c.a.r0.q2.u.f.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.m.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public c.a.q0.s.c0.a J;
    public c.a.r0.t3.j0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public i.e N;
    public boolean O;
    public final b.c P;
    public AbsVideoPbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public PopupDialog f22462b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s.s.i f22463c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f22464d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.a f22465e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f22466f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f22467g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.s.s.c f22468h;

    /* renamed from: i  reason: collision with root package name */
    public View f22469i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f22470j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f22471k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public PopupDialog q;
    public c.a.q0.s.g0.a r;
    public c.a.q0.s.s.b s;
    public AlertDialog t;
    public e0 u;
    public c.a.r0.k.g v;
    public c.a.r0.k.j w;
    public c.a.r0.q2.u.g.a x;
    public PbFragment.b3 y;
    public x0 z;

    /* renamed from: c.a.r0.q2.y.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1300a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1300a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.a = this.a.B;
                        String str = "";
                        if (this.a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.C.memeInfo.pck_id;
                        }
                        aVar.f11797b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.a.F == null) {
                        this.a.F = new PermissionJudgePolicy();
                    }
                    this.a.F.clearRequestPermissionList();
                    this.a.F.appendRequestPermission(this.a.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F.startRequestPermission(this.a.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.z == null) {
                        a aVar2 = this.a;
                        aVar2.z = new x0(aVar2.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f22472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f22473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f22474g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f22475h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f22476i;

        public a0(a aVar, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22476i = aVar;
            this.f22472e = sparseArray;
            this.f22473f = z;
            this.f22474g = str;
            this.f22475h = str2;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f22476i.f22462b != null) {
                    this.f22476i.f22462b.dismiss();
                }
                if (i2 == 0) {
                    this.f22476i.g0(((Integer) this.f22472e.get(c.a.r0.q2.i.tag_del_post_type)).intValue(), (String) this.f22472e.get(c.a.r0.q2.i.tag_del_post_id), ((Integer) this.f22472e.get(c.a.r0.q2.i.tag_manage_user_identity)).intValue(), ((Boolean) this.f22472e.get(c.a.r0.q2.i.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f22472e.get(c.a.r0.q2.i.tag_user_mute_mute_username);
                    String str2 = (String) this.f22472e.get(c.a.r0.q2.i.tag_user_mute_thread_id);
                    String str3 = (String) this.f22472e.get(c.a.r0.q2.i.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f22473f, this.f22474g, str, str2, str3, 1, this.f22475h, this.f22476i.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f22476i.D);
                    this.f22476i.L0(this.f22473f, userMuteAddAndDelCustomMessage, this.f22475h, str, (String) this.f22472e.get(c.a.r0.q2.i.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22477e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22477e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22477e.a.deleteThread(aVar, (JSONArray) null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22478e;

        public b0(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22478e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f22478e.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f22479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f22480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f22481g;

        public d(a aVar, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22481g = aVar;
            this.f22479e = alertDialog;
            this.f22480f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f22479e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.j.A()) {
                    c.a.d.f.p.l.L(this.f22481g.a.getPbActivity(), c.a.r0.q2.l.neterror);
                } else {
                    this.f22481g.a.deleteThread(this.f22480f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f22482e;

        public e(a aVar, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22482e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f22482e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f22483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f22484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f22485g;

        public f(a aVar, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22485g = aVar;
            this.f22483e = alertDialog;
            this.f22484f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f22483e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.d.f.p.j.A()) {
                    c.a.d.f.p.l.L(this.f22485g.a.getPbActivity(), c.a.r0.q2.l.neterror);
                } else {
                    this.f22485g.a.deleteThread(this.f22484f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f22486e;

        public g(a aVar, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22486e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f22486e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class h implements g.InterfaceC1096g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.s.s.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22487b;

        public h(a aVar, c.a.q0.s.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22487b = aVar;
            this.a = aVar2;
        }

        @Override // c.a.r0.k.g.InterfaceC1096g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f22487b.a.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22488b;

        public i(a aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22488b = aVar;
            this.a = sparseArray;
        }

        @Override // c.a.r0.k.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f22488b.a.deleteThread(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f22489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f22490f;

        public j(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22490f = aVar;
            this.f22489e = z;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22490f.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f22490f.g0(((Integer) sparseArray.get(c.a.r0.q2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(c.a.r0.q2.i.tag_del_post_id), ((Integer) sparseArray.get(c.a.r0.q2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f22490f.y != null) {
                            this.f22490f.y.a(new Object[]{sparseArray.get(c.a.r0.q2.i.tag_manage_user_identity), sparseArray.get(c.a.r0.q2.i.tag_forbid_user_name), sparseArray.get(c.a.r0.q2.i.tag_forbid_user_post_id), sparseArray.get(c.a.r0.q2.i.tag_forbid_user_name_show), sparseArray.get(c.a.r0.q2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f22490f.T(this.f22489e, (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22491e;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22491e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22491e.t == null) {
                return;
            }
            c.a.d.f.m.g.a(this.f22491e.t, this.f22491e.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes6.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public l(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new c.a.r0.q2.u.f.c(this.a.a.getPbModel().h1(), this.a.H, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    a aVar2 = this.a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new c.a.r0.q2.u.f.c(this.a.a.getPbModel().h1(), this.a.H, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    a aVar3 = this.a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f22492e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f22493f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f22494g;

        public m(a aVar, PopupDialog popupDialog, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, popupDialog, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22494g = aVar;
            this.f22492e = popupDialog;
            this.f22493f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f22494g.a.getPbModel().e1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // c.a.q0.s.s.i.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            boolean B2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                return;
            }
            this.f22492e.dismiss();
            int i3 = 3;
            if (this.f22494g.a.getPbModel().e1() != 1 || i2 != 1) {
                if (this.f22494g.a.getPbModel().e1() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (this.f22494g.a.getPbModel().e1() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f22493f.getId() != c.a.r0.q2.i.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f22494g.a.getPbModel().R0().f21520f != null && this.f22494g.a.getPbModel().R0().f21520f.size() > i2) {
                    i2 = this.f22494g.a.getPbModel().R0().f21520f.get(i2).sort_type.intValue();
                }
                B2 = this.f22494g.a.getPbModel().B2(i2);
                this.f22493f.setTag(Integer.valueOf(this.f22494g.a.getPbModel().d1()));
                if (B2) {
                    return;
                }
                this.f22494g.a.setIsLoading(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f22493f.getId() != c.a.r0.q2.i.pb_sort ? 1 : 0).param("obj_type", i3));
            if (this.f22494g.a.getPbModel().R0().f21520f != null) {
                i2 = this.f22494g.a.getPbModel().R0().f21520f.get(i2).sort_type.intValue();
            }
            B2 = this.f22494g.a.getPbModel().B2(i2);
            this.f22493f.setTag(Integer.valueOf(this.f22494g.a.getPbModel().d1()));
            if (B2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f22495e;

        public n(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22495e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f22495e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f22496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f22497f;

        public o(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22497f = aVar;
            this.f22496e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f22496e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f22497f.a.getAttentionModel() != null) {
                    this.f22497f.a.getAttentionModel().l(!this.f22496e.hadConcerned(), this.f22496e.getPortrait(), this.f22496e.getUserId(), this.f22496e.isGod(), "6", this.f22497f.a.getPageContext().getUniqueId(), this.f22497f.a.getPbModel().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f22498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f22499f;

        public q(a aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22499f = aVar;
            this.f22498e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f22499f.B0();
                MessageManager.getInstance().sendMessage(this.f22498e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f22500e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f22501f;

        public s(a aVar, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22501f = aVar;
            this.f22500e = cVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f22501f.f22464d.dismiss();
                this.f22500e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22502e;

        public t(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22502e = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f22502e.n = (String) compoundButton.getTag();
                if (this.f22502e.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f22502e.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f22502e.n != null && !str.equals(this.f22502e.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22503e;

        public u(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22503e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f22503e.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22504e;

        public v(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22504e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f22504e.f22467g instanceof Dialog)) {
                c.a.d.f.m.g.b(this.f22504e.f22467g, this.f22504e.a.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements PbFragment.b3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public w(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.d.f.p.j.z()) {
                    this.a.a.showToast(c.a.r0.q2.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.getPbModel().R0().l().getId(), this.a.a.getPbModel().R0().l().getName(), this.a.a.getPbModel().R0().O().g0(), String.valueOf(this.a.a.getPbModel().R0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22505e;

        public x(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22505e = aVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f22505e.f22462b != null) {
                    this.f22505e.f22462b.dismiss();
                }
                this.f22505e.M0(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(c.a.r0.q2.i.pb_dialog_item_share);
                        this.f22505e.n0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(c.a.r0.q2.i.pb_dialog_item_reply);
                        this.f22505e.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(c.a.r0.q2.i.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        this.f22505e.n0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(c.a.r0.q2.i.pb_dialog_item_zan_2);
                        this.f22505e.n0(view5);
                        AgreeView agreeView2 = (AgreeView) view5;
                        if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                            return;
                        }
                        agreeView2.getImgAgree().performClick();
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.f22505e.A == null || TextUtils.isEmpty(this.f22505e.B)) {
                            return;
                        }
                        if (this.f22505e.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f22505e.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.a = this.f22505e.B;
                            String str = "";
                            if (this.f22505e.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f22505e.C.memeInfo.pck_id;
                            }
                            aVar.f11797b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f22505e.A = null;
                        this.f22505e.B = null;
                        return;
                    case 2:
                        if (this.f22505e.A == null || TextUtils.isEmpty(this.f22505e.B)) {
                            return;
                        }
                        if (this.f22505e.F == null) {
                            this.f22505e.F = new PermissionJudgePolicy();
                        }
                        this.f22505e.F.clearRequestPermissionList();
                        this.f22505e.F.appendRequestPermission(this.f22505e.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f22505e.F.startRequestPermission(this.f22505e.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f22505e.z == null) {
                            a aVar2 = this.f22505e;
                            aVar2.z = new x0(aVar2.a.getPageContext());
                        }
                        this.f22505e.z.b(this.f22505e.B, this.f22505e.A.n());
                        this.f22505e.A = null;
                        this.f22505e.B = null;
                        return;
                    case 3:
                        PostData postData = this.f22505e.G;
                        if (postData != null) {
                            postData.l0();
                            this.f22505e.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f22505e.a.checkUpIsLogin()) {
                            this.f22505e.d0(view);
                            if (this.f22505e.a.getPbModel().R0().O() == null || this.f22505e.a.getPbModel().R0().O().J() == null || this.f22505e.a.getPbModel().R0().O().J().getUserId() == null || this.f22505e.a.getMarkModel() == null) {
                                return;
                            }
                            a aVar3 = this.f22505e;
                            int S = aVar3.S(aVar3.a.getPbModel().R0());
                            d2 O = this.f22505e.a.getPbModel().R0().O();
                            if (O.P1()) {
                                i3 = 2;
                            } else if (O.S1()) {
                                i3 = 3;
                            } else if (!O.Q1()) {
                                i3 = O.R1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f22505e.a.getPbModel().h1()).param("obj_locate", 2).param("obj_id", this.f22505e.a.getPbModel().R0().O().J().getUserId()).param("obj_type", !this.f22505e.a.getMarkModel().e()).param("obj_source", S).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.d.f.p.j.z()) {
                            this.f22505e.a.showToast(c.a.r0.q2.l.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f22505e.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(c.a.r0.q2.i.tag_from, 0);
                                sparseArray2.put(c.a.r0.q2.i.tag_check_mute_from, 2);
                                this.f22505e.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(c.a.r0.q2.i.tag_del_post_type) instanceof Integer) && (sparseArray3.get(c.a.r0.q2.i.tag_del_post_id) instanceof String) && (sparseArray3.get(c.a.r0.q2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(c.a.r0.q2.i.tag_del_post_is_self) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(c.a.r0.q2.i.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(c.a.r0.q2.i.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(c.a.r0.q2.i.tag_has_sub_post)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.f22505e.a;
                            if (absVideoPbFragment == null || absVideoPbFragment.getPbActivity() == null) {
                                return;
                            }
                            boolean isHost = this.f22505e.a.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f22505e.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f22505e.i0(((Integer) sparseArray3.get(c.a.r0.q2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(c.a.r0.q2.i.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f22505e.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f22505e.g0(((Integer) sparseArray3.get(c.a.r0.q2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(c.a.r0.q2.i.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.d.f.p.j.z()) {
                            this.f22505e.a.showToast(c.a.r0.q2.l.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(c.a.r0.q2.i.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(c.a.r0.q2.i.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(c.a.r0.q2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray4.get(c.a.r0.q2.i.tag_is_self_post)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f22505e.g0(((Integer) sparseArray4.get(c.a.r0.q2.i.tag_del_post_type)).intValue(), (String) sparseArray4.get(c.a.r0.q2.i.tag_del_post_id), ((Integer) sparseArray4.get(c.a.r0.q2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(c.a.r0.q2.i.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(c.a.r0.q2.i.tag_from, 1);
                            sparseArray4.put(c.a.r0.q2.i.tag_check_mute_from, 2);
                            this.f22505e.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(c.a.r0.q2.i.tag_check_mute_from, 2);
                            }
                            this.f22505e.l0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.f22505e.a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(c.a.r0.q2.i.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            c.a.q0.n0.c f2 = TbPageExtraHelper.f(view);
                            if (f2 != null) {
                                postData2.q().objSource = f2.a();
                            }
                            this.f22505e.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.f22505e.a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.getPbModel() == null || this.f22505e.a.getPbModel().R0() == null || !ViewHelper.checkUpIsLogin(this.f22505e.a.getContext()) || this.f22505e.a.getPbActivity() == null) {
                            return;
                        }
                        this.f22505e.a.getPbActivity().showBlockDialog(c.a.r0.d4.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f22506e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22507f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f22508g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f22509h;

        public y(a aVar, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22509h = aVar;
            this.f22506e = sparseArray;
            this.f22507f = i2;
            this.f22508g = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f22509h.a.deleteThreadDirect(((Integer) this.f22506e.get(c.a.r0.q2.i.tag_del_post_type)).intValue(), (String) this.f22506e.get(c.a.r0.q2.i.tag_del_post_id), this.f22507f, this.f22508g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2124111365, "Lc/a/r0/q2/y/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2124111365, "Lc/a/r0/q2/y/g/a;");
        }
    }

    public a(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22464d = null;
        this.f22465e = null;
        this.f22466f = null;
        this.f22467g = null;
        this.f22468h = null;
        this.f22469i = null;
        this.f22470j = null;
        this.f22471k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.G = null;
        this.L = c.a.q0.b.d.v0();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new C1300a(this);
        this.a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        c.a.r0.q2.u.g.a aVar = new c.a.r0.q2.u.g.a(this.a.getContext());
        this.x = aVar;
        aVar.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.mark_like_cancel), new n(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.mark_like_confirm), new o(this, metaData));
        aVar.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.d.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.d.f.m.b.g((String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.r == null) {
                this.r = new c.a.q0.s.g0.a(this.a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new c.a.q0.s.c0.a();
        }
        if (this.K == null) {
            c.a.r0.t3.j0.e eVar = new c.a.r0.t3.j0.e();
            this.K = eVar;
            eVar.a = this.a.getUniqueId();
        }
        c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
        fVar.f12929b = 5;
        fVar.f12935h = 8;
        fVar.f12934g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.getPbModel() != null) {
            fVar.f12933f = this.a.getPbModel().Q0();
        }
        fVar.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f12936i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.getPbModel() == null || this.a.getPbModel().R0() == null) {
                    return;
                }
                this.J.b(this.a.getPbActivity(), fVar, agreeData, this.a.getPbModel().R0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f12936i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f12936i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, c.a.r0.k.i iVar, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new c.a.r0.k.j(this.a.getPageContext(), this.a.getView(), iVar, userData);
        }
        this.w.C(z2);
        AntiData L = L();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.q0.s.q.x0 x0Var = new c.a.q0.s.q.x0();
        x0Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(c.a.r0.q2.l.delete_thread_reason_1), this.a.getString(c.a.r0.q2.l.delete_thread_reason_2), this.a.getString(c.a.r0.q2.l.delete_thread_reason_3), this.a.getString(c.a.r0.q2.l.delete_thread_reason_4), this.a.getString(c.a.r0.q2.l.delete_thread_reason_5)});
        this.w.D(x0Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.d.f.p.l.f(pageActivity, c.a.r0.q2.g.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageContext().getPageActivity());
            aVar.setMessage(this.a.getResources().getString(c.a.r0.q2.l.mute_is_super_member_function));
            aVar.setPositiveButton(c.a.r0.q2.l.open_now, new b0(this));
            aVar.setNegativeButton(c.a.r0.q2.l.cancel, new c0(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<c.a.q0.s.s.f> b2;
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        c.a.q0.s.s.f fVar3;
        c.a.q0.s.s.f fVar4;
        c.a.d.m.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || !absVideoPbFragment.isAdded()) {
                return true;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Y(view)) {
                    if (view instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view;
                        this.A = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.B = url;
                        if (this.A == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info) != null && (view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info);
                        } else {
                            this.C = null;
                        }
                    } else if (view instanceof GifView) {
                        GifView gifView = (GifView) view;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.A = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.B = gifView.getBdImage().q();
                        }
                        if (view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info) != null && (view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info);
                        } else {
                            this.C = null;
                        }
                    } else if (view instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.A = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.B = tbMemeImageView.getBdImage().q();
                            }
                            if (view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info) != null && (view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view.getTag(c.a.r0.q2.i.tag_rich_text_meme_info);
                            } else {
                                this.C = null;
                            }
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        F0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(c.a.r0.q2.i.tag_clip_board);
            this.G = postData;
            if (postData == null || this.a.getMarkModel() == null) {
                return true;
            }
            boolean z5 = this.a.getMarkModel().e() && this.G.G() != null && this.G.G().equals(this.a.getPbModel().M0());
            boolean z6 = this.a.getPbModel().R0() != null && this.a.getPbModel().R0().g0();
            if (this.f22463c == null) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.a.getContext());
                this.f22463c = iVar;
                iVar.m(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view) && !z6;
            boolean z8 = (!Y(view) || (aVar = this.A) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(c.a.r0.q2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(c.a.r0.q2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(c.a.r0.q2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(c.a.r0.q2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(c.a.r0.q2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_forbid_user_post_id) : null;
            boolean booleanValue7 = sparseArray.get(c.a.r0.q2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_is_self_post)).booleanValue() : false;
            if (z7) {
                z2 = booleanValue7;
                z4 = booleanValue6;
                z3 = booleanValue5;
                arrayList.add(new c.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.save_to_emotion), this.f22463c));
            } else {
                z2 = booleanValue7;
                z3 = booleanValue5;
                z4 = booleanValue6;
            }
            if (z8) {
                arrayList.add(new c.a.q0.s.s.f(2, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.save_to_local), this.f22463c));
            }
            if (!z7 && !z8) {
                c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(3, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.copy), this.f22463c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(c.a.r0.q2.i.tag_clip_board, this.G);
                fVar5.f13159d.setTag(sparseArray3);
                arrayList.add(fVar5);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    fVar4 = new c.a.q0.s.s.f(4, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.remove_mark), this.f22463c);
                } else {
                    fVar4 = new c.a.q0.s.s.f(4, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.mark), this.f22463c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(c.a.r0.q2.i.tag_clip_board, this.G);
                sparseArray4.put(c.a.r0.q2.i.tag_is_subpb, Boolean.FALSE);
                fVar4.f13159d.setTag(sparseArray4);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(5, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.mute_option), this.f22463c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.TRUE);
                    int i2 = c.a.r0.q2.i.tag_is_mem;
                    sparseArray5.put(i2, sparseArray.get(i2));
                    int i3 = c.a.r0.q2.i.tag_user_mute_mute_userid;
                    sparseArray5.put(i3, sparseArray.get(i3));
                    int i4 = c.a.r0.q2.i.tag_user_mute_mute_username;
                    sparseArray5.put(i4, sparseArray.get(i4));
                    int i5 = c.a.r0.q2.i.tag_user_mute_mute_nameshow;
                    sparseArray5.put(i5, sparseArray.get(i5));
                    int i6 = c.a.r0.q2.i.tag_user_mute_post_id;
                    sparseArray5.put(i6, sparseArray.get(i6));
                    int i7 = c.a.r0.q2.i.tag_user_mute_thread_id;
                    sparseArray5.put(i7, sparseArray.get(i7));
                    int i8 = c.a.r0.q2.i.tag_del_post_is_self;
                    sparseArray5.put(i8, sparseArray.get(i8));
                    int i9 = c.a.r0.q2.i.tag_del_post_type;
                    sparseArray5.put(i9, sparseArray.get(i9));
                    int i10 = c.a.r0.q2.i.tag_del_post_id;
                    sparseArray5.put(i10, sparseArray.get(i10));
                    int i11 = c.a.r0.q2.i.tag_manage_user_identity;
                    sparseArray5.put(i11, sparseArray.get(i11));
                    fVar6.f13159d.setTag(sparseArray5);
                    arrayList.add(fVar6);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        c.a.q0.s.s.f fVar7 = new c.a.q0.s.s.f(5, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.report_text), this.f22463c);
                        fVar7.f13159d.setTag(str);
                        arrayList.add(fVar7);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(c.a.r0.q2.i.tag_should_manage_visible, Boolean.TRUE);
                    int i12 = c.a.r0.q2.i.tag_manage_user_identity;
                    sparseArray6.put(i12, sparseArray.get(i12));
                    int i13 = c.a.r0.q2.i.tag_forbid_user_name;
                    sparseArray6.put(i13, sparseArray.get(i13));
                    int i14 = c.a.r0.q2.i.tag_forbid_user_name_show;
                    sparseArray6.put(i14, sparseArray.get(i14));
                    int i15 = c.a.r0.q2.i.tag_forbid_user_portrait;
                    sparseArray6.put(i15, sparseArray.get(i15));
                    sparseArray6.put(c.a.r0.q2.i.tag_forbid_user_post_id, str);
                    if (!X() && z3) {
                        sparseArray6.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i16 = c.a.r0.q2.i.tag_is_mem;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        int i17 = c.a.r0.q2.i.tag_user_mute_mute_userid;
                        sparseArray6.put(i17, sparseArray.get(i17));
                        int i18 = c.a.r0.q2.i.tag_user_mute_mute_username;
                        sparseArray6.put(i18, sparseArray.get(i18));
                        int i19 = c.a.r0.q2.i.tag_user_mute_mute_nameshow;
                        sparseArray6.put(i19, sparseArray.get(i19));
                        int i20 = c.a.r0.q2.i.tag_user_mute_post_id;
                        sparseArray6.put(i20, sparseArray.get(i20));
                        int i21 = c.a.r0.q2.i.tag_user_mute_thread_id;
                        sparseArray6.put(i21, sparseArray.get(i21));
                    } else {
                        sparseArray6.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z4) {
                        sparseArray6.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray6.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i22 = c.a.r0.q2.i.tag_del_post_id;
                        sparseArray6.put(i22, sparseArray.get(i22));
                        int i23 = c.a.r0.q2.i.tag_del_post_type;
                        sparseArray6.put(i23, sparseArray.get(i23));
                        int i24 = c.a.r0.q2.i.tag_has_sub_post;
                        sparseArray6.put(i24, sparseArray.get(i24));
                        if (z2) {
                            c.a.q0.s.s.f fVar8 = new c.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.delete), this.f22463c);
                            fVar8.f13159d.setTag(sparseArray6);
                            fVar2 = fVar8;
                            fVar = new c.a.q0.s.s.f(7, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.bar_manager), this.f22463c);
                            fVar.f13159d.setTag(sparseArray6);
                        }
                    } else {
                        sparseArray6.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.FALSE);
                    }
                    fVar2 = null;
                    fVar = new c.a.q0.s.s.f(7, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.bar_manager), this.f22463c);
                    fVar.f13159d.setTag(sparseArray6);
                } else if (z4) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(c.a.r0.q2.i.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray7.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray7.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.TRUE);
                    int i25 = c.a.r0.q2.i.tag_manage_user_identity;
                    sparseArray7.put(i25, sparseArray.get(i25));
                    sparseArray7.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i26 = c.a.r0.q2.i.tag_del_post_id;
                    sparseArray7.put(i26, sparseArray.get(i26));
                    int i27 = c.a.r0.q2.i.tag_del_post_type;
                    sparseArray7.put(i27, sparseArray.get(i27));
                    int i28 = c.a.r0.q2.i.tag_has_sub_post;
                    sparseArray7.put(i28, sparseArray.get(i28));
                    if (this.a.getPbModel().R0().V() == 1002 && !booleanValue2) {
                        fVar3 = new c.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.report_text), this.f22463c);
                    } else {
                        fVar3 = new c.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.delete), this.f22463c);
                    }
                    fVar3.f13159d.setTag(sparseArray7);
                    fVar2 = fVar3;
                    fVar = null;
                } else {
                    fVar = null;
                    fVar2 = null;
                }
                if (fVar2 != null) {
                    arrayList.add(fVar2);
                }
                if (fVar != null) {
                    arrayList.add(fVar);
                }
                c.a.r0.q2.u.f.g1.a.a(arrayList, this.f22463c, this.G, this.a.getPbModel());
            }
            if (c.a.q0.b.d.L()) {
                b2 = c.a.r0.q2.u.f.g1.a.c(arrayList, this.G.q(), sparseArray, this.f22463c);
            } else {
                b2 = c.a.r0.q2.u.f.g1.a.b(arrayList, this.G.q(), sparseArray, this.f22463c);
            }
            c.a.r0.q2.u.f.g1.a.k(b2, this.O);
            c.a.r0.q2.u.f.g1.a.e(b2);
            this.f22463c.n(c.a.r0.q2.u.f.g1.a.f(this.G));
            if (c.a.q0.b.d.L()) {
                this.f22463c.k(b2, false);
            } else {
                this.f22463c.k(b2, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.a.getPageContext(), this.f22463c);
            this.f22462b = popupDialog;
            popupDialog.showDialog();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.getPbModel().h1()).param("fid", this.a.getPbModel().getForumId()).param("uid", this.a.getPbModel().R0().O().J().getUserId()).param("post_id", this.a.getPbModel().y()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(c.a.r0.q2.i.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.f22462b;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.f22462b.dismiss();
                this.f22462b = null;
            }
            String str = (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue()) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.a.getBaseFragmentActivity());
                iVar.m(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(c.a.r0.q2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(c.a.r0.q2.i.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.q0.s.s.f(0, TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.delete), iVar));
                }
                if (z2) {
                    arrayList.add(new c.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.un_mute), iVar));
                } else {
                    arrayList.add(new c.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.mute), iVar));
                }
                iVar.j(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(this.a.getPageContext(), iVar);
                this.f22462b = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.hideEditTool();
            PopupDialog popupDialog = this.f22462b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            this.a.hideKeyBroad();
            K();
        }
    }

    public void F0(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.f22464d;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.f22464d = null;
            }
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.getPbModel().R0() != null && this.a.getPbModel().R0().O() != null && !this.a.getPbModel().R0().O().T1()) {
                arrayList.add(new c.a.q0.s.s.f(0, this.a.getPageContext().getString(c.a.r0.q2.l.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new c.a.q0.s.s.f(1, this.a.getPageContext().getString(c.a.r0.q2.l.save_to_local), iVar));
            }
            iVar.j(arrayList);
            iVar.m(new s(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.a.getPageContext(), iVar);
            this.f22464d = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.hideEditTool();
            PopupDialog popupDialog = this.f22462b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            c.a.q0.s.s.c cVar = this.f22468h;
            if (cVar != null) {
                cVar.d();
                this.f22468h = null;
            }
            if (this.a.getPbModel() == null) {
                return;
            }
            ArrayList<c.a.q0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new c.a.q0.s.s.k(this.a.getContext().getString(c.a.r0.q2.l.all_person), "", this.a.getPbModel().a1() == 1, Integer.toString(1)));
            arrayList.add(new c.a.q0.s.s.k(this.a.getContext().getString(c.a.r0.q2.l.my_fans), "", this.a.getPbModel().a1() == 2, Integer.toString(5)));
            arrayList.add(new c.a.q0.s.s.k(this.a.getContext().getString(c.a.r0.q2.l.my_attentions), "", this.a.getPbModel().a1() == 3, Integer.toString(6)));
            arrayList.add(new c.a.q0.s.s.k(this.a.getContext().getString(c.a.r0.q2.l.myself_only), "", this.a.getPbModel().a1() == 4, Integer.toString(7)));
            c.a.q0.s.s.c cVar2 = new c.a.q0.s.s.c(this.a.getPageContext());
            cVar2.l(c.a.r0.q2.l.pb_privacy_setting_thread_reply_decs);
            this.f22468h = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.f22468h.n();
        }
    }

    public void H() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f22462b) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public void H0(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, f0Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new e0(absVideoPbFragment, absVideoPbFragment.listener);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), c.a.r0.q2.m.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        c.a.d.f.m.g.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), c.a.r0.q2.g._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(c.a.r0.q2.m.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.r());
        this.u.K(f0Var == null ? false : f0Var.a);
        this.u.v(f0Var == null ? false : f0Var.n);
        this.u.x(f0Var == null ? false : f0Var.f21986e);
        this.u.C(f0Var == null ? false : f0Var.f21990i);
        this.u.y(f0Var == null ? false : f0Var.f21987f);
        this.u.M(f0Var != null ? f0Var.f21984c : true);
        this.u.G(f0Var == null ? false : f0Var.f21992k);
        this.u.z(f0Var == null ? false : f0Var.l, f0Var.t);
        if (f0Var == null) {
            this.u.E(false, false);
            this.u.D(false, false);
        } else {
            this.u.E(f0Var.f21988g, f0Var.s);
            this.u.D(f0Var.f21989h, f0Var.r);
        }
        boolean z2 = f0Var == null ? false : f0Var.q;
        boolean z3 = f0Var == null ? false : f0Var.o;
        boolean z4 = f0Var == null ? false : f0Var.f21985d;
        boolean z5 = f0Var == null ? false : f0Var.f21983b;
        boolean z6 = f0Var == null ? false : f0Var.p;
        boolean z7 = f0Var == null ? false : f0Var.f21991j;
        boolean z8 = f0Var == null ? false : f0Var.m;
        this.u.A(z4, z3);
        this.u.L(z5, z2);
        this.u.F(z7, z6);
        this.u.Q(z8);
        if (f0Var != null) {
            e0 e0Var = this.u;
            boolean z9 = f0Var.u;
            e0Var.w = z9;
            if (z9) {
                e0Var.f().setText(c.a.r0.q2.l.report_text);
                this.u.y(false);
            }
        }
        this.u.w(f0Var != null ? f0Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.getPbModel() != null && this.a.getPbModel().R0() != null && this.a.getPbModel().R0().Q() != null && this.a.getPbModel().R0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(c.a.r0.q2.l.have_called_fans_short);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            c.a.d.f.m.e.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(c.a.q0.s.s.a aVar, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, aVar, i2) == null) || (absVideoPbFragment = this.a) == null || aVar == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new c.a.r0.k.g(this.a.getPageContext(), this.a.getView());
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        c.a.q0.s.q.x0 x0Var = new c.a.q0.s.q.x0();
        x0Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(c.a.r0.q2.l.delete_thread_reason_1), this.a.getString(c.a.r0.q2.l.delete_thread_reason_2), this.a.getString(c.a.r0.q2.l.delete_thread_reason_3), this.a.getString(c.a.r0.q2.l.delete_thread_reason_4), this.a.getString(c.a.r0.q2.l.delete_thread_reason_5)});
        this.v.x(x0Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, aVar));
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public void J0(View view) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.getPbModel() == null) {
            return;
        }
        PopupDialog popupDialog = new PopupDialog(this.a.getPageContext());
        if (this.a.getPbModel().R0().f21520f == null || this.a.getPbModel().R0().f21520f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.sort_type_old)};
        } else {
            strArr = new String[this.a.getPbModel().R0().f21520f.size()];
            for (int i2 = 0; i2 < this.a.getPbModel().R0().f21520f.size(); i2++) {
                strArr[i2] = this.a.getPbModel().R0().f21520f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.sort_static);
            }
        }
        popupDialog.setDefaultContentView(null, strArr, new m(this, popupDialog, view));
        popupDialog.showDialog();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.q0.s.s.a aVar = this.f22465e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f22466f;
            if (dialog != null) {
                c.a.d.f.m.g.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.f22467g;
            if (dialog2 != null) {
                c.a.d.f.m.g.b(dialog2, this.a.getPageContext());
            }
            PopupDialog popupDialog = this.q;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
        }
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (str == null) {
                str = "";
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(c.a.r0.q2.l.know, new p(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.getPbModel() == null || this.a.getPbModel().R0() == null) {
                return null;
            }
            return this.a.getPbModel().R0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void L0(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                B0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.a.getBaseFragmentActivity());
            if (c.a.d.f.p.k.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(c.a.r0.q2.l.confirm, new q(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(c.a.r0.q2.l.cancel, new r(this));
            aVar.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view = this.f22469i;
            if (view != null) {
                return view.findViewById(c.a.r0.q2.i.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.getPbModel().h1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.r0.q2.u.f.g1.a.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (e0Var = this.u) == null) {
            return;
        }
        e0Var.u();
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.E : invokeV.objValue;
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public e0 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (e0) invokeV.objValue;
    }

    public c.a.q0.s.s.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (c.a.q0.s.s.b) invokeV.objValue;
    }

    public int S(c.a.r0.q2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().r1() == 0) {
                return 1;
            }
            if (fVar.O().r1() == 54) {
                return 2;
            }
            return fVar.O().r1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            L0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (this.a.getPbModel() != null && this.a.getPbModel().R0() != null && this.a.getPbModel().R0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.getPbModel().h1(), str);
                d2 O = this.a.getPbModel().R0().O();
                if (O.P1()) {
                    format = format + "&channelid=33833";
                } else if (O.U1()) {
                    format = format + "&channelid=33842";
                } else if (O.S1()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        c.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new c.a.q0.s.s.b(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(c.a.r0.q2.l.call_phone), this.a.getPageContext().getString(c.a.r0.q2.l.sms_phone), this.a.getPageContext().getString(c.a.r0.q2.l.search_in_baidu)};
            c.a.q0.s.s.b bVar = this.s;
            bVar.j(strArr, new l(this));
            bVar.g(b.C0811b.a);
            bVar.h(17);
            bVar.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? c.a.r0.q2.u.f.g1.a.h(this.a.getPbModel()) : invokeV.booleanValue;
    }

    public boolean Y(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.getPbModel().R0().U() != null && (forumToolAuth = this.a.getPbModel().R0().U().getForumToolAuth()) != null) {
                    for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                        ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                        if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean a0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) ? i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 : invokeI.booleanValue;
    }

    public final boolean b0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z2)) == null) {
            if (this.a.getPbModel() != null && this.a.getPbModel().R0() != null) {
                return ((this.a.getPbModel().R0().V() != 0) || this.a.getPbModel().R0().O() == null || this.a.getPbModel().R0().O().J() == null || TextUtils.equals(this.a.getPbModel().R0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void d0(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(c.a.r0.q2.i.tag_clip_board)) == null) {
                return;
            }
            e0(postData);
        }
    }

    public void e0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.G() != null && postData.G().equals(this.a.getPbModel().M0())) {
            z2 = true;
        }
        MarkData L0 = this.a.getPbModel().L0(postData);
        if (this.a.getPbModel().R0() != null && this.a.getPbModel().R0().g0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData firstPostData = absVideoPbFragment.getFirstPostData(absVideoPbFragment.getPbModel().R0());
            if (firstPostData != null) {
                L0 = this.a.getPbModel().L0(firstPostData);
            }
        }
        if (L0 == null) {
            return;
        }
        this.a.setPreLoad();
        if (this.a.getMarkModel() != null) {
            this.a.getMarkModel().i(L0);
            if (!z2) {
                this.a.getMarkModel().a();
            } else {
                this.a.getMarkModel().d();
            }
        }
    }

    public void f0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.f22469i == null) {
                this.f22469i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(c.a.r0.q2.j.commit_good, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.f22469i);
            if (this.f22467g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), c.a.r0.q2.m.common_alert_dialog);
                this.f22467g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f22467g.setCancelable(true);
                this.o = (ScrollView) this.f22469i.findViewById(c.a.r0.q2.i.good_scroll);
                this.f22467g.setContentView(this.f22469i);
                WindowManager.LayoutParams attributes = this.f22467g.getWindow().getAttributes();
                attributes.width = c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), c.a.r0.q2.g.ds540);
                this.f22467g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.f22470j = (LinearLayout) this.f22469i.findViewById(c.a.r0.q2.i.good_class_group);
                TextView textView = (TextView) this.f22469i.findViewById(c.a.r0.q2.i.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.f22469i.findViewById(c.a.r0.q2.i.dialog_button_ok);
                this.f22471k = textView2;
                textView2.setOnClickListener(this.a.getListener());
            }
            this.f22470j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(c.a.r0.q2.l.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.f22470j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), c.a.r0.q2.g.ds1));
                        SkinManager.setBackgroundColor(view, c.a.r0.q2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f22470j.addView(view);
                        this.f22470j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.d.f.p.l.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.d.f.p.l.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.d.f.p.l.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.f22470j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.f22470j);
                }
            }
            c.a.d.f.m.g.j(this.f22467g, this.a.getPageContext());
        }
    }

    public void g0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            h0(i2, str, i3, z2, null);
        }
    }

    public void h0(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            i0(i2, str, i3, z2, str2, false);
        }
    }

    public void i0(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(c.a.r0.q2.i.tag_del_post_id, str);
            sparseArray.put(c.a.r0.q2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(c.a.r0.q2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = c.a.r0.q2.l.del_all_post_confirm;
            if (i3 == 1002 && !z2) {
                i4 = c.a.r0.q2.l.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = c.a.r0.q2.l.report_thread_confirm;
                } else {
                    i4 = c.a.r0.q2.l.del_thread_confirm;
                }
            }
            this.f22465e = new c.a.q0.s.s.a(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f22465e.setMessageId(i4);
            } else {
                this.f22465e.setOnlyMessageShowCenter(false);
                this.f22465e.setMessage(str2);
            }
            this.f22465e.setYesButtonTag(sparseArray);
            this.f22465e.setPositiveButton(c.a.r0.q2.l.dialog_ok, new b(this));
            this.f22465e.setNegativeButton(c.a.r0.q2.l.dialog_cancel, new c(this));
            this.f22465e.setCancelable(true);
            this.f22465e.create(this.a.getPageContext());
            if (z3) {
                v0(sparseArray);
            } else if (z2) {
                v0(sparseArray);
            } else if (q0()) {
                c.a.r0.k.i iVar = new c.a.r0.k.i(this.a.getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.getPbModel().R0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.getPbModel().R0().o().has_forum_rule.intValue());
                iVar.i(this.a.getPbModel().R0().l().getId(), this.a.getPbModel().R0().l().getName());
                iVar.h(this.a.getPbModel().R0().l().getImage_url());
                iVar.j(this.a.getPbModel().R0().l().getUser_level());
                C0(sparseArray, i2, iVar, this.a.getPbModel().R0().U(), false);
            } else {
                I0(this.f22465e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(c.a.r0.q2.i.tag_del_post_id, str);
            sparseArray.put(c.a.r0.q2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(c.a.r0.q2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.a.getContext());
            iVar.p(this.a.getString(c.a.r0.q2.l.bar_manager));
            iVar.m(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(c.a.r0.q2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(c.a.r0.q2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(c.a.r0.q2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(c.a.r0.q2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(c.a.r0.q2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.q0.s.s.f(10, this.a.getString(c.a.r0.q2.l.delete_post), iVar);
                } else {
                    fVar2 = new c.a.q0.s.s.f(10, this.a.getString(c.a.r0.q2.l.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = c.a.r0.q2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = c.a.r0.q2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = c.a.r0.q2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = c.a.r0.q2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f13159d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if (!"".equals(sparseArray.get(c.a.r0.q2.i.tag_forbid_user_name)) || !"".equals(sparseArray.get(c.a.r0.q2.i.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = c.a.r0.q2.i.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = c.a.r0.q2.i.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = c.a.r0.q2.i.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = c.a.r0.q2.i.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = c.a.r0.q2.i.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(11, this.a.getString(c.a.r0.q2.l.forbidden_person), iVar);
                fVar3.f13159d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = c.a.r0.q2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = c.a.r0.q2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = c.a.r0.q2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = c.a.r0.q2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = c.a.r0.q2.i.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = c.a.r0.q2.i.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = c.a.r0.q2.i.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z2) {
                    fVar = new c.a.q0.s.s.f(12, this.a.getString(c.a.r0.q2.l.un_mute), iVar);
                } else {
                    fVar = new c.a.q0.s.s.f(12, this.a.getString(c.a.r0.q2.l.mute), iVar);
                }
                fVar.f13159d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            iVar.j(arrayList);
            PopupDialog popupDialog = this.q;
            if (popupDialog == null) {
                this.q = new PopupDialog(this.a.getPageContext(), iVar);
            } else {
                popupDialog.setContentView(iVar);
            }
            this.q.showDialog();
        }
    }

    public void l0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public void m0() {
        AbsVideoPbFragment absVideoPbFragment;
        c.a.r0.q2.r.f R0;
        d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.getPbModel() == null || this.a.getPbModel().R0() == null || (O = (R0 = this.a.getPbModel().R0()).O()) == null || O.J() == null) {
            return;
        }
        this.a.hideEditTool();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        f0 f0Var = new f0();
        int V = this.a.getPbModel().R0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            f0Var.f21988g = false;
        } else {
            f0Var.f21988g = true;
            f0Var.s = O.s0() == 1;
        }
        if (Z(V)) {
            f0Var.f21989h = true;
            f0Var.r = O.r0() == 1;
        } else {
            f0Var.f21989h = false;
        }
        if (V == 1002 && !equals) {
            f0Var.u = true;
        }
        f0Var.n = y0(O.V1(), R0.i0(), equals, V, O.M2(), O.v2());
        f0Var.f21986e = u0(equals, R0.i0());
        f0Var.f21990i = z0();
        f0Var.f21987f = x0(equals);
        f0Var.f21992k = equals && R0.U() != null && R0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            f0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().f();
        }
        f0Var.t = equals;
        f0Var.q = this.a.getPbModel().f1();
        f0Var.f21983b = true;
        f0Var.a = b0(equals);
        f0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        f0Var.f21991j = true;
        f0Var.o = this.a.getPbModel().v0();
        f0Var.f21985d = true;
        if (O.t1() == null) {
            f0Var.f21984c = true;
        } else {
            f0Var.f21984c = false;
        }
        if (R0.g0()) {
            f0Var.f21983b = false;
            f0Var.f21985d = false;
            f0Var.f21984c = false;
            f0Var.f21988g = false;
            f0Var.f21989h = false;
        }
        f0Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !R0.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.getFirstPostData(absVideoPbFragment2.getPbModel().R0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            f0Var.w = absVideoPbFragment3.getFirstPostData(absVideoPbFragment3.getPbModel().R0()).U;
        }
        if (c.a.q0.g1.b.c.d()) {
            f0Var.f21985d = false;
            f0Var.f21983b = false;
            f0Var.f21984c = false;
        }
        if (O.V1()) {
            f0Var.n = false;
            f0Var.f21988g = false;
            f0Var.f21989h = false;
        }
        H0(f0Var);
    }

    public final void n0(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(c.a.r0.q2.i.pb_track_more_obj_source, Integer.valueOf(this.O ? 2 : 3));
        view.setTag(sparseArray);
    }

    public void o0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            this.O = z2;
        }
    }

    public void p0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            return (absVideoPbFragment == null || absVideoPbFragment.getPbModel().R0().l().getDeletedReasonInfo() == null || 1 != this.a.getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(c.a.r0.q2.i.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(c.a.r0.q2.l.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(c.a.r0.q2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.a.getPbActivity());
        lVar.q(c.a.r0.q2.l.musk_my_thread_confirm);
        lVar.j(c.a.r0.q2.l.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.p(aVar2, aVar);
        lVar.g(false);
        androidx.appcompat.app.AlertDialog t2 = lVar.t();
        aVar.a(new f(this, t2, sparseArray));
        aVar2.a(new g(this, t2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(c.a.r0.q2.i.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.r0.k.i iVar = new c.a.r0.k.i(this.a.getPbModel().R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.getPbModel().R0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.getPbModel().R0().o().has_forum_rule.intValue());
        iVar.i(this.a.getPbModel().R0().l().getId(), this.a.getPbModel().R0().l().getName());
        iVar.h(this.a.getPbModel().R0().l().getImage_url());
        iVar.j(this.a.getPbModel().R0().l().getUser_level());
        C0(sparseArray, i2, iVar, this.a.getPbModel().R0().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            c.a.r0.q2.u.f.g1.a.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        c.a.q0.s.q.e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || this.a.getPbModel().R0() == null) {
                return false;
            }
            c.a.r0.q2.r.f R0 = this.a.getPbModel().R0();
            d2 O = R0.O();
            if (O != null) {
                if (O.P1() || O.S1()) {
                    return false;
                }
                if (O.Q1() || O.R1()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !w0.isOn()) || this.a.getPbModel().E() || O.M2() || O.v2() || z3) {
                return false;
            }
            if (R0.l() == null || !R0.l().isBlockBawuDelete) {
                if (R0.O() == null || !R0.O().V1()) {
                    if (R0.V() != 0) {
                        return R0.V() != 3;
                    }
                    List<z1> p2 = R0.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (z1 z1Var : p2) {
                            if (z1Var != null && (e0Var = z1Var.f13113g) != null && e0Var.a && !e0Var.f12918c && ((i2 = e0Var.f12917b) == 1 || i2 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void v0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, sparseArray) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(c.a.r0.q2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(c.a.r0.q2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.a.getPbActivity());
        lVar.q(c.a.r0.q2.l.del_my_thread_confirm);
        lVar.j(c.a.r0.q2.l.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.p(aVar2, aVar);
        lVar.g(false);
        androidx.appcompat.app.AlertDialog t2 = lVar.t();
        aVar.a(new d(this, t2, sparseArray));
        aVar2.a(new e(this, t2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        c.a.q0.s.s.f fVar3;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.getPbModel() == null || sparseArray == null || (postData = (PostData) sparseArray.get(c.a.r0.q2.i.tag_clip_board)) == null) {
            return;
        }
        if (this.f22463c == null) {
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.a.getContext());
            this.f22463c = iVar;
            iVar.m(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.getPbModel().R0() != null && this.a.getPbModel().R0().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(c.a.r0.q2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(c.a.r0.q2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(c.a.r0.q2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.r0.q2.i.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(c.a.r0.q2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(c.a.r0.q2.i.tag_forbid_user_post_id) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int s2 = postData.s();
                if (z3 && s2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = c.a.r0.q2.l.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = c.a.r0.q2.l.action_dislike;
                }
                c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(8, absVideoPbFragment2.getString(i2), this.f22463c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(c.a.r0.q2.i.tag_clip_board, postData);
                fVar4.f13159d.setTag(sparseArray2);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(5, this.a.getString(c.a.r0.q2.l.mute_option), this.f22463c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = c.a.r0.q2.i.tag_is_mem;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = c.a.r0.q2.i.tag_user_mute_mute_userid;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = c.a.r0.q2.i.tag_user_mute_mute_username;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = c.a.r0.q2.i.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = c.a.r0.q2.i.tag_user_mute_post_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = c.a.r0.q2.i.tag_user_mute_thread_id;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = c.a.r0.q2.i.tag_del_post_is_self;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = c.a.r0.q2.i.tag_del_post_type;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = c.a.r0.q2.i.tag_del_post_id;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    int i12 = c.a.r0.q2.i.tag_manage_user_identity;
                    sparseArray3.put(i12, sparseArray.get(i12));
                    fVar5.f13159d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(5, this.a.getString(c.a.r0.q2.l.report_text), this.f22463c);
                        fVar6.f13159d.setTag(str);
                        arrayList.add(fVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(c.a.r0.q2.i.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = c.a.r0.q2.i.tag_manage_user_identity;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = c.a.r0.q2.i.tag_forbid_user_name;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = c.a.r0.q2.i.tag_forbid_user_name_show;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = c.a.r0.q2.i.tag_forbid_user_portrait;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    sparseArray4.put(c.a.r0.q2.i.tag_forbid_user_post_id, str);
                    if (booleanValue4) {
                        sparseArray4.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = c.a.r0.q2.i.tag_is_mem;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = c.a.r0.q2.i.tag_user_mute_mute_userid;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = c.a.r0.q2.i.tag_user_mute_mute_username;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = c.a.r0.q2.i.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = c.a.r0.q2.i.tag_user_mute_post_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                        int i22 = c.a.r0.q2.i.tag_user_mute_thread_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray4.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                        int i23 = c.a.r0.q2.i.tag_del_post_id;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = c.a.r0.q2.i.tag_del_post_type;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        int i25 = c.a.r0.q2.i.tag_has_sub_post;
                        sparseArray4.put(i25, sparseArray.get(i25));
                        fVar2 = new c.a.q0.s.s.f(6, this.a.getString(c.a.r0.q2.l.delete), this.f22463c);
                        fVar2.f13159d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.FALSE);
                        fVar2 = null;
                    }
                    fVar = new c.a.q0.s.s.f(7, this.a.getString(c.a.r0.q2.l.bar_manager), this.f22463c);
                    fVar.f13159d.setTag(sparseArray4);
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(c.a.r0.q2.i.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(c.a.r0.q2.i.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(c.a.r0.q2.i.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = c.a.r0.q2.i.tag_manage_user_identity;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    sparseArray5.put(c.a.r0.q2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                    int i27 = c.a.r0.q2.i.tag_del_post_id;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = c.a.r0.q2.i.tag_del_post_type;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    int i29 = c.a.r0.q2.i.tag_has_sub_post;
                    sparseArray5.put(i29, sparseArray.get(i29));
                    if (this.a.getPbModel().R0().V() == 1002 && !booleanValue) {
                        fVar3 = new c.a.q0.s.s.f(6, this.a.getString(c.a.r0.q2.l.report_text), this.f22463c);
                    } else {
                        fVar3 = new c.a.q0.s.s.f(6, this.a.getString(c.a.r0.q2.l.delete), this.f22463c);
                    }
                    fVar3.f13159d.setTag(sparseArray5);
                    fVar2 = fVar3;
                    fVar = null;
                } else {
                    fVar = null;
                    fVar2 = null;
                }
                if (fVar2 != null) {
                    arrayList.add(fVar2);
                }
                if (fVar != null) {
                    arrayList.add(fVar);
                }
                if (!booleanValue) {
                    arrayList.add(new c.a.q0.s.s.f(9, TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.block_user), this.f22463c));
                }
            }
            this.f22463c.j(arrayList);
            PopupDialog popupDialog = new PopupDialog(this.a.getPageContext(), this.f22463c);
            this.f22462b = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.getPbModel() == null || this.a.getPbModel().R0() == null || (this.a.getPbModel().R0().l() != null && this.a.getPbModel().R0().l().isBlockBawuDelete)) {
                return false;
            }
            c.a.r0.q2.r.f R0 = this.a.getPbModel().R0();
            if ((R0.O() == null || R0.O().J() == null || !R0.O().J().isForumBusinessAccount() || w0.isOn()) && !this.a.getPbModel().E()) {
                return ((R0.O() != null && R0.O().V1()) || this.a.getPbModel().R0().V() == 0 || this.a.getPbModel().R0().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final boolean y0(boolean z2, boolean z3, boolean z4, int i2, boolean z5, boolean z6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2), Boolean.valueOf(z5), Boolean.valueOf(z6)})) == null) {
            if (z2) {
                return false;
            }
            if (z5 || z6) {
                return true;
            }
            return z3 && (z4 || a0(i2));
        }
        return invokeCommon.booleanValue;
    }

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || !this.a.getPbModel().f1()) {
                return false;
            }
            return this.a.getPbModel().P0() == null || this.a.getPbModel().P0().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
