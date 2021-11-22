package b.a.r0.k2.y.g;

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
import b.a.q0.c0.d;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.m0;
import b.a.q0.s.q.z1;
import b.a.q0.s.s.a;
import b.a.q0.s.s.b;
import b.a.q0.s.s.i;
import b.a.r0.j.g;
import b.a.r0.j.j;
import b.a.r0.k2.u.f.e0;
import b.a.r0.k2.u.f.f0;
import b.a.r0.k2.u.f.x0;
import b.a.r0.x0.w0;
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
import tbclient.DeleteThreadInfo;
import tbclient.ForumToolPerm;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.e.m.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public b.a.q0.s.c0.a J;
    public b.a.r0.m3.j0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public i.e N;
    public boolean O;
    public final b.c P;

    /* renamed from: a  reason: collision with root package name */
    public AbsVideoPbFragment f21335a;

    /* renamed from: b  reason: collision with root package name */
    public PopupDialog f21336b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.s.s.i f21337c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f21338d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.s.s.a f21339e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f21340f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f21341g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.s.c f21342h;

    /* renamed from: i  reason: collision with root package name */
    public View f21343i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public PopupDialog q;
    public b.a.q0.s.g0.a r;
    public b.a.q0.s.s.b s;
    public AlertDialog t;
    public e0 u;
    public b.a.r0.j.g v;
    public b.a.r0.j.j w;
    public b.a.r0.k2.u.g.a x;
    public PbFragment.b3 y;
    public x0 z;

    /* renamed from: b.a.r0.k2.y.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1053a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21344a;

        public C1053a(a aVar) {
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
            this.f21344a = aVar;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f21344a.A == null || TextUtils.isEmpty(this.f21344a.B)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f21344a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f21344a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f12740a = this.f21344a.B;
                        String str = "";
                        if (this.f21344a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f21344a.C.memeInfo.pck_id;
                        }
                        aVar.f12741b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f21344a.F == null) {
                        this.f21344a.F = new PermissionJudgePolicy();
                    }
                    this.f21344a.F.clearRequestPermissionList();
                    this.f21344a.F.appendRequestPermission(this.f21344a.f21335a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f21344a.F.startRequestPermission(this.f21344a.f21335a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f21344a.z == null) {
                        a aVar2 = this.f21344a;
                        aVar2.z = new x0(aVar2.f21335a.getPageContext());
                    }
                    this.f21344a.z.b(this.f21344a.B, this.f21344a.A.n());
                }
                this.f21344a.A = null;
                this.f21344a.B = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f21345e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21346f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f21347g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f21348h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f21349i;

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
            this.f21349i = aVar;
            this.f21345e = sparseArray;
            this.f21346f = z;
            this.f21347g = str;
            this.f21348h = str2;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f21349i.f21336b != null) {
                    this.f21349i.f21336b.dismiss();
                }
                if (i2 == 0) {
                    this.f21349i.g0(((Integer) this.f21345e.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) this.f21345e.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) this.f21345e.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) this.f21345e.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f21345e.get(b.a.r0.k2.i.tag_user_mute_mute_username);
                    String str2 = (String) this.f21345e.get(b.a.r0.k2.i.tag_user_mute_thread_id);
                    String str3 = (String) this.f21345e.get(b.a.r0.k2.i.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f21346f, this.f21347g, str, str2, str3, 1, this.f21348h, this.f21349i.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f21349i.D);
                    this.f21349i.L0(this.f21346f, userMuteAddAndDelCustomMessage, this.f21348h, str, (String) this.f21345e.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21350e;

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
            this.f21350e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21350e.f21335a.deleteThread(aVar, (JSONArray) null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21351e;

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
            this.f21351e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f21351e.f21335a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f21352e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f21353f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f21354g;

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
            this.f21354g = aVar;
            this.f21352e = alertDialog;
            this.f21353f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f21352e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f21354g.f21335a.getPbActivity(), b.a.r0.k2.l.neterror);
                } else {
                    this.f21354g.f21335a.deleteThread(this.f21353f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f21355e;

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
            this.f21355e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f21355e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f21356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f21357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f21358g;

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
            this.f21358g = aVar;
            this.f21356e = alertDialog;
            this.f21357f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f21356e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!b.a.e.f.p.j.A()) {
                    b.a.e.f.p.l.L(this.f21358g.f21335a.getPbActivity(), b.a.r0.k2.l.neterror);
                } else {
                    this.f21358g.f21335a.deleteThread(this.f21357f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f21359e;

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
            this.f21359e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f21359e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements g.InterfaceC0991g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f21360a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21361b;

        public h(a aVar, b.a.q0.s.s.a aVar2) {
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
            this.f21361b = aVar;
            this.f21360a = aVar2;
        }

        @Override // b.a.r0.j.g.InterfaceC0991g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f21361b.f21335a.deleteThread(this.f21360a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f21362a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21363b;

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
            this.f21363b = aVar;
            this.f21362a = sparseArray;
        }

        @Override // b.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f21363b.f21335a.deleteThread(this.f21362a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f21364e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21365f;

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
            this.f21365f = aVar;
            this.f21364e = z;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f21365f.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f21365f.g0(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f21365f.y != null) {
                            this.f21365f.y.a(new Object[]{sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show), sparseArray.get(b.a.r0.k2.i.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f21365f.T(this.f21364e, (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21366e;

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
            this.f21366e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21366e.t == null) {
                return;
            }
            b.a.e.f.m.g.a(this.f21366e.t, this.f21366e.f21335a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21367a;

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
            this.f21367a = aVar;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f21367a.f21335a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.f21367a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.f21367a.f21335a.getPageContext().getPageActivity(), this.f21367a.H);
                    new b.a.r0.k2.u.f.c(this.f21367a.f21335a.getPbModel().f1(), this.f21367a.H, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f21367a.f21335a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    a aVar2 = this.f21367a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.f21367a.f21335a.getPageContext().getPageActivity(), this.f21367a.H);
                    new b.a.r0.k2.u.f.c(this.f21367a.f21335a.getPbModel().f1(), this.f21367a.H, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    a aVar3 = this.f21367a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.f21367a.f21335a.getPageContext().getPageActivity(), this.f21367a.H);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f21368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f21369f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f21370g;

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
            this.f21370g = aVar;
            this.f21368e = popupDialog;
            this.f21369f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f21370g.f21335a.getPbModel().c1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // b.a.q0.s.s.i.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            boolean x2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                return;
            }
            this.f21368e.dismiss();
            int i3 = 3;
            if (this.f21370g.f21335a.getPbModel().c1() != 1 || i2 != 1) {
                if (this.f21370g.f21335a.getPbModel().c1() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (this.f21370g.f21335a.getPbModel().c1() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f21369f.getId() != b.a.r0.k2.i.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f21370g.f21335a.getPbModel().P0().f20298f != null && this.f21370g.f21335a.getPbModel().P0().f20298f.size() > i2) {
                    i2 = this.f21370g.f21335a.getPbModel().P0().f20298f.get(i2).sort_type.intValue();
                }
                x2 = this.f21370g.f21335a.getPbModel().x2(i2);
                this.f21369f.setTag(Integer.valueOf(this.f21370g.f21335a.getPbModel().b1()));
                if (x2) {
                    return;
                }
                this.f21370g.f21335a.setIsLoading(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f21369f.getId() != b.a.r0.k2.i.pb_sort ? 1 : 0).param("obj_type", i3));
            if (this.f21370g.f21335a.getPbModel().P0().f20298f != null) {
                i2 = this.f21370g.f21335a.getPbModel().P0().f20298f.get(i2).sort_type.intValue();
            }
            x2 = this.f21370g.f21335a.getPbModel().x2(i2);
            this.f21369f.setTag(Integer.valueOf(this.f21370g.f21335a.getPbModel().b1()));
            if (x2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f21371e;

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
            this.f21371e = metaData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f21371e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f21372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21373f;

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
            this.f21373f = aVar;
            this.f21372e = metaData;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f21372e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f21373f.f21335a.getAttentionModel() != null) {
                    this.f21373f.f21335a.getAttentionModel().l(!this.f21372e.hadConcerned(), this.f21372e.getPortrait(), this.f21372e.getUserId(), this.f21372e.isGod(), "6", this.f21373f.f21335a.getPageContext().getUniqueId(), this.f21373f.f21335a.getPbModel().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f21374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21375f;

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
            this.f21375f = aVar;
            this.f21374e = userMuteAddAndDelCustomMessage;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f21375f.B0();
                MessageManager.getInstance().sendMessage(this.f21374e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f21376e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21377f;

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
            this.f21377f = aVar;
            this.f21376e = cVar;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f21377f.f21338d.dismiss();
                this.f21376e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21378e;

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
            this.f21378e = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f21378e.n = (String) compoundButton.getTag();
                if (this.f21378e.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f21378e.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f21378e.n != null && !str.equals(this.f21378e.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21379e;

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
            this.f21379e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f21379e.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21380e;

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
            this.f21380e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f21380e.f21341g instanceof Dialog)) {
                b.a.e.f.m.g.b(this.f21380e.f21341g, this.f21380e.f21335a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements PbFragment.b3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21381a;

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
            this.f21381a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!b.a.e.f.p.j.z()) {
                    this.f21381a.f21335a.showToast(b.a.r0.k2.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f21381a.f21335a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f21381a.f21335a.getPageContext().getPageActivity(), this.f21381a.f21335a.getPbModel().P0().l().getId(), this.f21381a.f21335a.getPbModel().P0().l().getName(), this.f21381a.f21335a.getPbModel().P0().O().f0(), String.valueOf(this.f21381a.f21335a.getPbModel().P0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21382e;

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
            this.f21382e = aVar;
        }

        @Override // b.a.q0.s.s.i.e
        public void onItemClick(b.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f21382e.f21336b != null) {
                    this.f21382e.f21336b.dismiss();
                }
                this.f21382e.M0(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_share);
                        this.f21382e.n0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_reply);
                        this.f21382e.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        this.f21382e.n0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(b.a.r0.k2.i.pb_dialog_item_zan_2);
                        this.f21382e.n0(view5);
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
                        if (this.f21382e.A == null || TextUtils.isEmpty(this.f21382e.B)) {
                            return;
                        }
                        if (this.f21382e.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f21382e.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f12740a = this.f21382e.B;
                            String str = "";
                            if (this.f21382e.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f21382e.C.memeInfo.pck_id;
                            }
                            aVar.f12741b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f21382e.A = null;
                        this.f21382e.B = null;
                        return;
                    case 2:
                        if (this.f21382e.A == null || TextUtils.isEmpty(this.f21382e.B)) {
                            return;
                        }
                        if (this.f21382e.F == null) {
                            this.f21382e.F = new PermissionJudgePolicy();
                        }
                        this.f21382e.F.clearRequestPermissionList();
                        this.f21382e.F.appendRequestPermission(this.f21382e.f21335a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f21382e.F.startRequestPermission(this.f21382e.f21335a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f21382e.z == null) {
                            a aVar2 = this.f21382e;
                            aVar2.z = new x0(aVar2.f21335a.getPageContext());
                        }
                        this.f21382e.z.b(this.f21382e.B, this.f21382e.A.n());
                        this.f21382e.A = null;
                        this.f21382e.B = null;
                        return;
                    case 3:
                        a aVar3 = this.f21382e;
                        PostData postData = aVar3.G;
                        if (postData != null) {
                            postData.l0(aVar3.f21335a.getPageContext().getPageActivity());
                            this.f21382e.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f21382e.f21335a.checkUpIsLogin()) {
                            this.f21382e.d0(view);
                            if (this.f21382e.f21335a.getPbModel().P0().O() == null || this.f21382e.f21335a.getPbModel().P0().O().J() == null || this.f21382e.f21335a.getPbModel().P0().O().J().getUserId() == null || this.f21382e.f21335a.getMarkModel() == null) {
                                return;
                            }
                            a aVar4 = this.f21382e;
                            int S = aVar4.S(aVar4.f21335a.getPbModel().P0());
                            d2 O = this.f21382e.f21335a.getPbModel().P0().O();
                            if (O.O1()) {
                                i3 = 2;
                            } else if (O.R1()) {
                                i3 = 3;
                            } else if (!O.P1()) {
                                i3 = O.Q1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f21382e.f21335a.getPbModel().f1()).param("obj_locate", 2).param("obj_id", this.f21382e.f21335a.getPbModel().P0().O().J().getUserId()).param("obj_type", !this.f21382e.f21335a.getMarkModel().e()).param("obj_source", S).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!b.a.e.f.p.j.z()) {
                            this.f21382e.f21335a.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f21382e.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(b.a.r0.k2.i.tag_from, 0);
                                sparseArray2.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                this.f21382e.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer) && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_id) instanceof String) && (sparseArray3.get(b.a.r0.k2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(b.a.r0.k2.i.tag_has_sub_post)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.f21382e.f21335a;
                            if (absVideoPbFragment == null || absVideoPbFragment.getPbActivity() == null) {
                                return;
                            }
                            boolean isHost = this.f21382e.f21335a.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f21382e.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f21382e.i0(((Integer) sparseArray3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f21382e.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f21382e.g0(((Integer) sparseArray3.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!b.a.e.f.p.j.z()) {
                            this.f21382e.f21335a.showToast(b.a.r0.k2.l.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f21382e.g0(((Integer) sparseArray4.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray4.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray4.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(b.a.r0.k2.i.tag_from, 1);
                            sparseArray4.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                            this.f21382e.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                            }
                            this.f21382e.l0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.f21382e.f21335a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            b.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
                            if (f2 != null) {
                                postData2.q().objSource = f2.a();
                            }
                            this.f21382e.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.f21382e.f21335a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.getPbModel() == null || this.f21382e.f21335a.getPbModel().P0() == null || !ViewHelper.checkUpIsLogin(this.f21382e.f21335a.getContext()) || this.f21382e.f21335a.getPbActivity() == null) {
                            return;
                        }
                        this.f21382e.f21335a.getPbActivity().showBlockDialog(b.a.r0.w3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f21383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f21384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f21385g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f21386h;

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
            this.f21386h = aVar;
            this.f21383e = sparseArray;
            this.f21384f = i2;
            this.f21385g = z;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f21386h.f21335a.deleteThreadDirect(((Integer) this.f21383e.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) this.f21383e.get(b.a.r0.k2.i.tag_del_post_id), this.f21384f, this.f21385g);
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(641214998, "Lb/a/r0/k2/y/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(641214998, "Lb/a/r0/k2/y/g/a;");
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
        this.f21338d = null;
        this.f21339e = null;
        this.f21340f = null;
        this.f21341g = null;
        this.f21342h = null;
        this.f21343i = null;
        this.j = null;
        this.k = null;
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
        this.L = b.a.q0.b.d.q0();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new C1053a(this);
        this.f21335a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        b.a.r0.k2.u.g.a aVar = new b.a.r0.k2.u.g.a(this.f21335a.getContext());
        this.x = aVar;
        aVar.b(this.f21335a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21335a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.mark_like_cancel), new n(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.mark_like_confirm), new o(this, metaData));
        aVar.create(this.f21335a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = b.a.e.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = b.a.e.f.m.b.g((String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid), 0L);
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
                this.r = new b.a.q0.s.g0.a(this.f21335a.getPageContext());
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
            this.J = new b.a.q0.s.c0.a();
        }
        if (this.K == null) {
            b.a.r0.m3.j0.e eVar = new b.a.r0.m3.j0.e();
            this.K = eVar;
            eVar.f22451a = this.f21335a.getUniqueId();
        }
        b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
        fVar.f14080b = 5;
        fVar.f14086h = 8;
        fVar.f14085g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.f21335a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.getPbModel() != null) {
            fVar.f14084f = this.f21335a.getPbModel().O0();
        }
        fVar.f14079a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f14087i = 0;
                this.J.c(agreeData, i2, this.f21335a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.f21335a;
                if (absVideoPbFragment != null || absVideoPbFragment.getPbModel() == null || this.f21335a.getPbModel().P0() == null) {
                    return;
                }
                this.J.b(this.f21335a.getPbActivity(), fVar, agreeData, this.f21335a.getPbModel().P0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f14087i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f14087i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.f21335a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.f21335a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, b.a.r0.j.i iVar, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.f21335a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new b.a.r0.j.j(this.f21335a.getPageContext(), this.f21335a.getView(), iVar, userData);
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
        b.a.q0.s.q.x0 x0Var = new b.a.q0.s.q.x0();
        x0Var.j(sparseArray2);
        this.w.E(new String[]{this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_5)});
        this.w.D(x0Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f21335a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, b.a.e.f.p.l.g(pageActivity, b.a.r0.k2.g.ds100));
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
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21335a.getPageContext().getPageActivity());
            aVar.setMessage(this.f21335a.getResources().getString(b.a.r0.k2.l.mute_is_super_member_function));
            aVar.setPositiveButton(b.a.r0.k2.l.open_now, new b0(this));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new c0(this));
            aVar.create(this.f21335a.getPageContext()).show();
        }
    }

    public final boolean E(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<b.a.q0.s.s.f> b2;
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        b.a.q0.s.s.f fVar3;
        b.a.q0.s.s.f fVar4;
        b.a.e.m.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f21335a;
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
                        if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) != null && (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
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
                        if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) != null && (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
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
                            if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) != null && (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
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
            PostData postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
            this.G = postData;
            if (postData == null || this.f21335a.getMarkModel() == null) {
                return true;
            }
            boolean z5 = this.f21335a.getMarkModel().e() && this.G.G() != null && this.G.G().equals(this.f21335a.getPbModel().K0());
            boolean z6 = this.f21335a.getPbModel().P0() != null && this.f21335a.getPbModel().P0().g0();
            if (this.f21337c == null) {
                b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f21335a.getContext());
                this.f21337c = iVar;
                iVar.m(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view) && !z6;
            boolean z8 = (!Y(view) || (aVar = this.A) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) : null;
            boolean booleanValue7 = sparseArray.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
            if (z7) {
                z2 = booleanValue7;
                z4 = booleanValue6;
                z3 = booleanValue5;
                arrayList.add(new b.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.save_to_emotion), this.f21337c));
            } else {
                z2 = booleanValue7;
                z3 = booleanValue5;
                z4 = booleanValue6;
            }
            if (z8) {
                arrayList.add(new b.a.q0.s.s.f(2, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.save_to_local), this.f21337c));
            }
            if (!z7 && !z8) {
                b.a.q0.s.s.f fVar5 = new b.a.q0.s.s.f(3, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.copy), this.f21337c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(b.a.r0.k2.i.tag_clip_board, this.G);
                fVar5.f14338d.setTag(sparseArray3);
                arrayList.add(fVar5);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    fVar4 = new b.a.q0.s.s.f(4, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.remove_mark), this.f21337c);
                } else {
                    fVar4 = new b.a.q0.s.s.f(4, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.mark), this.f21337c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(b.a.r0.k2.i.tag_clip_board, this.G);
                sparseArray4.put(b.a.r0.k2.i.tag_is_subpb, Boolean.FALSE);
                fVar4.f14338d.setTag(sparseArray4);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    b.a.q0.s.s.f fVar6 = new b.a.q0.s.s.f(5, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.mute_option), this.f21337c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                    int i2 = b.a.r0.k2.i.tag_is_mem;
                    sparseArray5.put(i2, sparseArray.get(i2));
                    int i3 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                    sparseArray5.put(i3, sparseArray.get(i3));
                    int i4 = b.a.r0.k2.i.tag_user_mute_mute_username;
                    sparseArray5.put(i4, sparseArray.get(i4));
                    int i5 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                    sparseArray5.put(i5, sparseArray.get(i5));
                    int i6 = b.a.r0.k2.i.tag_user_mute_post_id;
                    sparseArray5.put(i6, sparseArray.get(i6));
                    int i7 = b.a.r0.k2.i.tag_user_mute_thread_id;
                    sparseArray5.put(i7, sparseArray.get(i7));
                    int i8 = b.a.r0.k2.i.tag_del_post_is_self;
                    sparseArray5.put(i8, sparseArray.get(i8));
                    int i9 = b.a.r0.k2.i.tag_del_post_type;
                    sparseArray5.put(i9, sparseArray.get(i9));
                    int i10 = b.a.r0.k2.i.tag_del_post_id;
                    sparseArray5.put(i10, sparseArray.get(i10));
                    int i11 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray5.put(i11, sparseArray.get(i11));
                    fVar6.f14338d.setTag(sparseArray5);
                    arrayList.add(fVar6);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        b.a.q0.s.s.f fVar7 = new b.a.q0.s.s.f(5, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.report_text), this.f21337c);
                        fVar7.f14338d.setTag(str);
                        arrayList.add(fVar7);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                    int i12 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray6.put(i12, sparseArray.get(i12));
                    int i13 = b.a.r0.k2.i.tag_forbid_user_name;
                    sparseArray6.put(i13, sparseArray.get(i13));
                    int i14 = b.a.r0.k2.i.tag_forbid_user_name_show;
                    sparseArray6.put(i14, sparseArray.get(i14));
                    int i15 = b.a.r0.k2.i.tag_forbid_user_portrait;
                    sparseArray6.put(i15, sparseArray.get(i15));
                    sparseArray6.put(b.a.r0.k2.i.tag_forbid_user_post_id, str);
                    if (!X() && z3) {
                        sparseArray6.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i16 = b.a.r0.k2.i.tag_is_mem;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        int i17 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                        sparseArray6.put(i17, sparseArray.get(i17));
                        int i18 = b.a.r0.k2.i.tag_user_mute_mute_username;
                        sparseArray6.put(i18, sparseArray.get(i18));
                        int i19 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                        sparseArray6.put(i19, sparseArray.get(i19));
                        int i20 = b.a.r0.k2.i.tag_user_mute_post_id;
                        sparseArray6.put(i20, sparseArray.get(i20));
                        int i21 = b.a.r0.k2.i.tag_user_mute_thread_id;
                        sparseArray6.put(i21, sparseArray.get(i21));
                    } else {
                        sparseArray6.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z4) {
                        sparseArray6.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray6.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i22 = b.a.r0.k2.i.tag_del_post_id;
                        sparseArray6.put(i22, sparseArray.get(i22));
                        int i23 = b.a.r0.k2.i.tag_del_post_type;
                        sparseArray6.put(i23, sparseArray.get(i23));
                        int i24 = b.a.r0.k2.i.tag_has_sub_post;
                        sparseArray6.put(i24, sparseArray.get(i24));
                        if (z2) {
                            b.a.q0.s.s.f fVar8 = new b.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.delete), this.f21337c);
                            fVar8.f14338d.setTag(sparseArray6);
                            fVar2 = fVar8;
                            fVar = new b.a.q0.s.s.f(7, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.bar_manager), this.f21337c);
                            fVar.f14338d.setTag(sparseArray6);
                        }
                    } else {
                        sparseArray6.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
                    }
                    fVar2 = null;
                    fVar = new b.a.q0.s.s.f(7, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.bar_manager), this.f21337c);
                    fVar.f14338d.setTag(sparseArray6);
                } else if (z4) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray7.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray7.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                    int i25 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray7.put(i25, sparseArray.get(i25));
                    sparseArray7.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i26 = b.a.r0.k2.i.tag_del_post_id;
                    sparseArray7.put(i26, sparseArray.get(i26));
                    int i27 = b.a.r0.k2.i.tag_del_post_type;
                    sparseArray7.put(i27, sparseArray.get(i27));
                    int i28 = b.a.r0.k2.i.tag_has_sub_post;
                    sparseArray7.put(i28, sparseArray.get(i28));
                    if (this.f21335a.getPbModel().P0().V() == 1002 && !booleanValue2) {
                        fVar3 = new b.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.report_text), this.f21337c);
                    } else {
                        fVar3 = new b.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.delete), this.f21337c);
                    }
                    fVar3.f14338d.setTag(sparseArray7);
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
                b.a.r0.k2.u.f.g1.a.a(arrayList, this.f21337c, this.G, this.f21335a.getPbModel());
            }
            if (b.a.q0.b.d.I()) {
                b2 = b.a.r0.k2.u.f.g1.a.c(arrayList, this.G.q(), sparseArray, this.f21337c);
            } else {
                b2 = b.a.r0.k2.u.f.g1.a.b(arrayList, this.G.q(), sparseArray, this.f21337c);
            }
            b.a.r0.k2.u.f.g1.a.k(b2, this.O);
            b.a.r0.k2.u.f.g1.a.e(b2);
            this.f21337c.n(b.a.r0.k2.u.f.g1.a.f(this.G));
            if (b.a.q0.b.d.I()) {
                this.f21337c.k(b2, false);
            } else {
                this.f21337c.k(b2, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f21335a.getPageContext(), this.f21337c);
            this.f21336b = popupDialog;
            popupDialog.showDialog();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f21335a.getPbModel().f1()).param("fid", this.f21335a.getPbModel().getForumId()).param("uid", this.f21335a.getPbModel().P0().O().J().getUserId()).param("post_id", this.f21335a.getPbModel().y()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.f21336b;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.f21336b.dismiss();
                this.f21336b = null;
            }
            String str = (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f21335a.getBaseFragmentActivity());
                iVar.m(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new b.a.q0.s.s.f(0, TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.delete), iVar));
                }
                if (z2) {
                    arrayList.add(new b.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.un_mute), iVar));
                } else {
                    arrayList.add(new b.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.mute), iVar));
                }
                iVar.j(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(this.f21335a.getPageContext(), iVar);
                this.f21336b = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.f21335a.hideEditTool();
            PopupDialog popupDialog = this.f21336b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            this.f21335a.hideKeyBroad();
            K();
        }
    }

    public void F0(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.f21338d;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.f21338d = null;
            }
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f21335a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.f21335a.getPbModel().P0() != null && this.f21335a.getPbModel().P0().O() != null && !this.f21335a.getPbModel().P0().O().S1()) {
                arrayList.add(new b.a.q0.s.s.f(0, this.f21335a.getPageContext().getString(b.a.r0.k2.l.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new b.a.q0.s.s.f(1, this.f21335a.getPageContext().getString(b.a.r0.k2.l.save_to_local), iVar));
            }
            iVar.j(arrayList);
            iVar.m(new s(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f21335a.getPageContext(), iVar);
            this.f21338d = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.f21335a.hideEditTool();
            PopupDialog popupDialog = this.f21336b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            b.a.q0.s.s.c cVar = this.f21342h;
            if (cVar != null) {
                cVar.d();
                this.f21342h = null;
            }
            if (this.f21335a.getPbModel() == null) {
                return;
            }
            ArrayList<b.a.q0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new b.a.q0.s.s.k(this.f21335a.getContext().getString(b.a.r0.k2.l.all_person), "", this.f21335a.getPbModel().Y0() == 1, Integer.toString(1)));
            arrayList.add(new b.a.q0.s.s.k(this.f21335a.getContext().getString(b.a.r0.k2.l.my_fans), "", this.f21335a.getPbModel().Y0() == 2, Integer.toString(5)));
            arrayList.add(new b.a.q0.s.s.k(this.f21335a.getContext().getString(b.a.r0.k2.l.my_attentions), "", this.f21335a.getPbModel().Y0() == 3, Integer.toString(6)));
            arrayList.add(new b.a.q0.s.s.k(this.f21335a.getContext().getString(b.a.r0.k2.l.myself_only), "", this.f21335a.getPbModel().Y0() == 4, Integer.toString(7)));
            b.a.q0.s.s.c cVar2 = new b.a.q0.s.s.c(this.f21335a.getPageContext());
            cVar2.l(b.a.r0.k2.l.pb_privacy_setting_thread_reply_decs);
            this.f21342h = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.f21342h.n();
        }
    }

    public void H() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f21336b) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public void H0(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, f0Var) == null) || this.f21335a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.f21335a;
        this.u = new e0(absVideoPbFragment, absVideoPbFragment.listener);
        AlertDialog create = new AlertDialog.Builder(this.f21335a.getContext(), b.a.r0.k2.m.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        b.a.e.f.m.g.i(this.t, this.f21335a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(b.a.r0.k2.m.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.r());
        this.u.O(f0Var == null ? false : f0Var.f20792a);
        this.u.v(f0Var == null ? false : f0Var.n);
        this.u.x(f0Var == null ? false : f0Var.f20796e);
        this.u.D(f0Var == null ? false : f0Var.f20800i);
        this.u.y(f0Var == null ? false : f0Var.f20797f);
        this.u.Q(f0Var != null ? f0Var.f20794c : true);
        this.u.N(f0Var == null ? false : f0Var.k);
        this.u.z(f0Var == null ? false : f0Var.l, f0Var.t);
        if (f0Var == null) {
            this.u.L(false, false);
            this.u.K(false, false);
        } else {
            this.u.L(f0Var.f20798g, f0Var.s);
            this.u.K(f0Var.f20799h, f0Var.r);
        }
        boolean z2 = f0Var == null ? false : f0Var.q;
        boolean z3 = f0Var == null ? false : f0Var.o;
        boolean z4 = f0Var == null ? false : f0Var.f20795d;
        boolean z5 = f0Var == null ? false : f0Var.f20793b;
        boolean z6 = f0Var == null ? false : f0Var.p;
        boolean z7 = f0Var == null ? false : f0Var.j;
        boolean z8 = f0Var == null ? false : f0Var.m;
        this.u.A(z4, z3);
        this.u.P(z5, z2);
        this.u.M(z7, z6);
        this.u.S(z8);
        if (f0Var != null) {
            e0 e0Var = this.u;
            boolean z9 = f0Var.u;
            e0Var.w = z9;
            if (z9) {
                e0Var.f().setText(b.a.r0.k2.l.report_text);
                this.u.y(false);
            }
        }
        this.u.w(f0Var != null ? f0Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f21335a.getPbModel() != null && this.f21335a.getPbModel().P0() != null && this.f21335a.getPbModel().P0().Q() != null && this.f21335a.getPbModel().P0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(b.a.r0.k2.l.have_called_fans_short);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            b.a.e.f.m.e.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(b.a.q0.s.s.a aVar, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, aVar, i2) == null) || (absVideoPbFragment = this.f21335a) == null || aVar == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new b.a.r0.j.g(this.f21335a.getPageContext(), this.f21335a.getView());
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
        b.a.q0.s.q.x0 x0Var = new b.a.q0.s.q.x0();
        x0Var.j(sparseArray);
        this.v.y(new String[]{this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_1), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_2), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_3), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_4), this.f21335a.getString(b.a.r0.k2.l.delete_thread_reason_5)});
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
        b.a.e.f.m.g.a(alertDialog, this.f21335a.getPageContext().getPageActivity());
    }

    public void J0(View view) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (absVideoPbFragment = this.f21335a) == null || absVideoPbFragment.getPbModel() == null) {
            return;
        }
        PopupDialog popupDialog = new PopupDialog(this.f21335a.getPageContext());
        if (this.f21335a.getPbModel().P0().f20298f == null || this.f21335a.getPbModel().P0().f20298f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.sort_type_old)};
        } else {
            strArr = new String[this.f21335a.getPbModel().P0().f20298f.size()];
            for (int i2 = 0; i2 < this.f21335a.getPbModel().P0().f20298f.size(); i2++) {
                strArr[i2] = this.f21335a.getPbModel().P0().f20298f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.sort_static);
            }
        }
        popupDialog.setDefaultContentView(null, strArr, new m(this, popupDialog, view));
        popupDialog.showDialog();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b.a.q0.s.s.a aVar = this.f21339e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f21340f;
            if (dialog != null) {
                b.a.e.f.m.g.b(dialog, this.f21335a.getPageContext());
            }
            Dialog dialog2 = this.f21341g;
            if (dialog2 != null) {
                b.a.e.f.m.g.b(dialog2, this.f21335a.getPageContext());
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
            AbsVideoPbFragment absVideoPbFragment = this.f21335a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21335a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(b.a.r0.k2.l.know, new p(this));
            aVar.create(this.f21335a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f21335a.getPbModel() == null || this.f21335a.getPbModel().P0() == null) {
                return null;
            }
            return this.f21335a.getPbModel().P0().d();
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
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21335a.getBaseFragmentActivity());
            if (b.a.e.f.p.k.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(b.a.r0.k2.l.confirm, new q(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new r(this));
            aVar.create(this.f21335a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view = this.f21343i;
            if (view != null) {
                return view.findViewById(b.a.r0.k2.i.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f21335a.getPbModel().f1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(b.a.r0.k2.u.f.g1.a.m(i2))));
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

    public b.a.q0.s.s.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (b.a.q0.s.s.b) invokeV.objValue;
    }

    public int S(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().p1() == 0) {
                return 1;
            }
            if (fVar.O().p1() == 54) {
                return 2;
            }
            return fVar.O().p1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            L0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (this.f21335a.getPbModel() != null && this.f21335a.getPbModel().P0() != null && this.f21335a.getPbModel().P0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.f21335a.getPbModel().f1(), str);
                d2 O = this.f21335a.getPbModel().P0().O();
                if (O.O1()) {
                    format = format + "&channelid=33833";
                } else if (O.T1()) {
                    format = format + "&channelid=33842";
                } else if (O.R1()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        b.a.q0.s.g0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new b.a.q0.s.s.b(this.f21335a.getPageContext().getPageActivity());
            String[] strArr = {this.f21335a.getPageContext().getString(b.a.r0.k2.l.call_phone), this.f21335a.getPageContext().getString(b.a.r0.k2.l.sms_phone), this.f21335a.getPageContext().getString(b.a.r0.k2.l.search_in_baidu)};
            b.a.q0.s.s.b bVar = this.s;
            bVar.j(strArr, new l(this));
            bVar.g(b.C0728b.f14318a);
            bVar.h(17);
            bVar.c(this.f21335a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? b.a.r0.k2.u.f.g1.a.h(this.f21335a.getPbModel()) : invokeV.booleanValue;
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
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f21335a.getPbModel().P0().U() != null && (forumToolAuth = this.f21335a.getPbModel().P0().U().getForumToolAuth()) != null) {
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
            if (this.f21335a.getPbModel() != null && this.f21335a.getPbModel().P0() != null) {
                return ((this.f21335a.getPbModel().P0().V() != 0) || this.f21335a.getPbModel().P0().O() == null || this.f21335a.getPbModel().P0().O().J() == null || TextUtils.equals(this.f21335a.getPbModel().P0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f21335a.getContext(), "", str, true);
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) == null) {
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
        if (postData.G() != null && postData.G().equals(this.f21335a.getPbModel().K0())) {
            z2 = true;
        }
        MarkData J0 = this.f21335a.getPbModel().J0(postData);
        if (this.f21335a.getPbModel().P0() != null && this.f21335a.getPbModel().P0().g0()) {
            AbsVideoPbFragment absVideoPbFragment = this.f21335a;
            PostData firstPostData = absVideoPbFragment.getFirstPostData(absVideoPbFragment.getPbModel().P0());
            if (firstPostData != null) {
                J0 = this.f21335a.getPbModel().J0(firstPostData);
            }
        }
        if (J0 == null) {
            return;
        }
        this.f21335a.setPreLoad();
        if (this.f21335a.getMarkModel() != null) {
            this.f21335a.getMarkModel().i(J0);
            if (!z2) {
                this.f21335a.getMarkModel().a();
            } else {
                this.f21335a.getMarkModel().d();
            }
        }
    }

    public void f0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.f21343i == null) {
                this.f21343i = LayoutInflater.from(this.f21335a.getPageContext().getPageActivity()).inflate(b.a.r0.k2.j.commit_good, (ViewGroup) null);
            }
            this.f21335a.getBaseFragmentActivity().getLayoutMode().j(this.f21343i);
            if (this.f21341g == null) {
                Dialog dialog = new Dialog(this.f21335a.getPageContext().getPageActivity(), b.a.r0.k2.m.common_alert_dialog);
                this.f21341g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f21341g.setCancelable(true);
                this.o = (ScrollView) this.f21343i.findViewById(b.a.r0.k2.i.good_scroll);
                this.f21341g.setContentView(this.f21343i);
                WindowManager.LayoutParams attributes = this.f21341g.getWindow().getAttributes();
                attributes.width = b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds540);
                this.f21341g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.f21343i.findViewById(b.a.r0.k2.i.good_class_group);
                TextView textView = (TextView) this.f21343i.findViewById(b.a.r0.k2.i.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.f21343i.findViewById(b.a.r0.k2.i.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.f21335a.getListener());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.f21335a.getPageContext().getString(b.a.r0.k2.l.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.f21335a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds1));
                        SkinManager.setBackgroundColor(view, b.a.r0.k2.f.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.j.addView(view);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = b.a.e.f.p.l.e(this.f21335a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = b.a.e.f.p.l.e(this.f21335a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = b.a.e.f.p.l.e(this.f21335a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            b.a.e.f.m.g.j(this.f21341g, this.f21335a.getPageContext());
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
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = b.a.r0.k2.l.del_all_post_confirm;
            if (i3 == 1002 && !z2) {
                i4 = b.a.r0.k2.l.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = b.a.r0.k2.l.report_thread_confirm;
                } else {
                    i4 = b.a.r0.k2.l.del_thread_confirm;
                }
            }
            this.f21339e = new b.a.q0.s.s.a(this.f21335a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f21339e.setMessageId(i4);
            } else {
                this.f21339e.setOnlyMessageShowCenter(false);
                this.f21339e.setMessage(str2);
            }
            this.f21339e.setYesButtonTag(sparseArray);
            this.f21339e.setPositiveButton(b.a.r0.k2.l.dialog_ok, new b(this));
            this.f21339e.setNegativeButton(b.a.r0.k2.l.dialog_cancel, new c(this));
            this.f21339e.setCancelable(true);
            this.f21339e.create(this.f21335a.getPageContext());
            if (z3) {
                v0(sparseArray);
            } else if (z2) {
                v0(sparseArray);
            } else if (q0()) {
                b.a.r0.j.i iVar = new b.a.r0.j.i(this.f21335a.getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f21335a.getPbModel().P0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f21335a.getPbModel().P0().o().has_forum_rule.intValue());
                iVar.i(this.f21335a.getPbModel().P0().l().getId(), this.f21335a.getPbModel().P0().l().getName());
                iVar.h(this.f21335a.getPbModel().P0().l().getImage_url());
                iVar.j(this.f21335a.getPbModel().P0().l().getUser_level());
                C0(sparseArray, i2, iVar, this.f21335a.getPbModel().P0().U(), false);
            } else {
                I0(this.f21339e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(b.a.r0.k2.i.tag_del_post_id, str);
            sparseArray.put(b.a.r0.k2.i.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(b.a.r0.k2.i.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f21335a.getContext());
            iVar.p(this.f21335a.getString(b.a.r0.k2.l.bar_manager));
            iVar.m(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(b.a.r0.k2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new b.a.q0.s.s.f(10, this.f21335a.getString(b.a.r0.k2.l.delete_post), iVar);
                } else {
                    fVar2 = new b.a.q0.s.s.f(10, this.f21335a.getString(b.a.r0.k2.l.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = b.a.r0.k2.i.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = b.a.r0.k2.i.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = b.a.r0.k2.i.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f14338d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if (!"".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name)) || !"".equals(sparseArray.get(b.a.r0.k2.i.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = b.a.r0.k2.i.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = b.a.r0.k2.i.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = b.a.r0.k2.i.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = b.a.r0.k2.i.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = b.a.r0.k2.i.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(11, this.f21335a.getString(b.a.r0.k2.l.forbidden_person), iVar);
                fVar3.f14338d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = b.a.r0.k2.i.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = b.a.r0.k2.i.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = b.a.r0.k2.i.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = b.a.r0.k2.i.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = b.a.r0.k2.i.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z2) {
                    fVar = new b.a.q0.s.s.f(12, this.f21335a.getString(b.a.r0.k2.l.un_mute), iVar);
                } else {
                    fVar = new b.a.q0.s.s.f(12, this.f21335a.getString(b.a.r0.k2.l.mute), iVar);
                }
                fVar.f14338d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            iVar.j(arrayList);
            PopupDialog popupDialog = this.q;
            if (popupDialog == null) {
                this.q = new PopupDialog(this.f21335a.getPageContext(), iVar);
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
        b.a.r0.k2.r.f P0;
        d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.f21335a) == null || absVideoPbFragment.getPbModel() == null || this.f21335a.getPbModel().P0() == null || (O = (P0 = this.f21335a.getPbModel().P0()).O()) == null || O.J() == null) {
            return;
        }
        this.f21335a.hideEditTool();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        f0 f0Var = new f0();
        int V = this.f21335a.getPbModel().P0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            f0Var.f20798g = false;
        } else {
            f0Var.f20798g = true;
            f0Var.s = O.r0() == 1;
        }
        if (Z(V)) {
            f0Var.f20799h = true;
            f0Var.r = O.q0() == 1;
        } else {
            f0Var.f20799h = false;
        }
        if (V == 1002 && !equals) {
            f0Var.u = true;
        }
        f0Var.n = y0(O.U1(), P0.i0(), equals, V, O.K2(), O.u2());
        f0Var.f20796e = u0(equals, P0.i0());
        f0Var.f20800i = z0();
        f0Var.f20797f = x0(equals);
        f0Var.k = equals && P0.U() != null && P0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            f0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().f();
        }
        f0Var.t = equals;
        f0Var.q = this.f21335a.getPbModel().d1();
        f0Var.f20793b = true;
        f0Var.f20792a = b0(equals);
        f0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        f0Var.j = true;
        f0Var.o = this.f21335a.getPbModel().t0();
        f0Var.f20795d = true;
        if (O.r1() == null) {
            f0Var.f20794c = true;
        } else {
            f0Var.f20794c = false;
        }
        if (P0.g0()) {
            f0Var.f20793b = false;
            f0Var.f20795d = false;
            f0Var.f20794c = false;
            f0Var.f20798g = false;
            f0Var.f20799h = false;
        }
        f0Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !P0.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.f21335a;
        if (absVideoPbFragment2.getFirstPostData(absVideoPbFragment2.getPbModel().P0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.f21335a;
            f0Var.w = absVideoPbFragment3.getFirstPostData(absVideoPbFragment3.getPbModel().P0()).U;
        }
        if (b.a.q0.f1.b.c.d()) {
            f0Var.f20795d = false;
            f0Var.f20793b = false;
            f0Var.f20794c = false;
        }
        if (O.U1()) {
            f0Var.n = false;
            f0Var.f20798g = false;
            f0Var.f20799h = false;
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
        sparseArray.put(b.a.r0.k2.i.pb_track_more_obj_source, Integer.valueOf(this.O ? 2 : 3));
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
            AbsVideoPbFragment absVideoPbFragment = this.f21335a;
            return (absVideoPbFragment == null || absVideoPbFragment.getPbModel().P0().l().getDeletedReasonInfo() == null || 1 != this.f21335a.getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.f21335a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(b.a.r0.k2.i.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.k2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f21335a.getPbActivity());
        lVar.q(b.a.r0.k2.l.musk_my_thread_confirm);
        lVar.j(b.a.r0.k2.l.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.p(aVar2, aVar);
        lVar.g(false);
        androidx.appcompat.app.AlertDialog t2 = lVar.t();
        aVar.a(new f(this, t2, sparseArray));
        aVar2.a(new g(this, t2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.f21335a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(b.a.r0.k2.i.tag_is_block_thread, Boolean.TRUE);
        }
        b.a.r0.j.i iVar = new b.a.r0.j.i(this.f21335a.getPbModel().P0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f21335a.getPbModel().P0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f21335a.getPbModel().P0().o().has_forum_rule.intValue());
        iVar.i(this.f21335a.getPbModel().P0().l().getId(), this.f21335a.getPbModel().P0().l().getName());
        iVar.h(this.f21335a.getPbModel().P0().l().getImage_url());
        iVar.j(this.f21335a.getPbModel().P0().l().getUser_level());
        C0(sparseArray, i2, iVar, this.f21335a.getPbModel().P0().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            b.a.r0.k2.u.f.g1.a.d(this.f21335a.getActivity(), this.f21335a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        b.a.q0.s.q.e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f21335a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || this.f21335a.getPbModel().P0() == null) {
                return false;
            }
            b.a.r0.k2.r.f P0 = this.f21335a.getPbModel().P0();
            d2 O = P0.O();
            if (O != null) {
                if (O.O1() || O.R1()) {
                    return false;
                }
                if (O.P1() || O.Q1()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !w0.isOn()) || this.f21335a.getPbModel().E() || O.K2() || O.u2() || z3) {
                return false;
            }
            if (P0.l() == null || !P0.l().isBlockBawuDelete) {
                if (P0.O() == null || !P0.O().U1()) {
                    if (P0.V() != 0) {
                        return P0.V() != 3;
                    }
                    List<z1> p2 = P0.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (z1 z1Var : p2) {
                            if (z1Var != null && (e0Var = z1Var.f14293g) != null && e0Var.f14065a && !e0Var.f14067c && ((i2 = e0Var.f14066b) == 1 || i2 == 2)) {
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
        if (!(interceptable == null || interceptable.invokeL(1048636, this, sparseArray) == null) || this.f21335a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(b.a.r0.k2.l.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.k2.l.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(this.f21335a.getPbActivity());
        lVar.q(b.a.r0.k2.l.del_my_thread_confirm);
        lVar.j(b.a.r0.k2.l.del_my_thread_confirm_subtitle);
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
        b.a.q0.s.s.f fVar;
        b.a.q0.s.s.f fVar2;
        b.a.q0.s.s.f fVar3;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.f21335a) == null || absVideoPbFragment.getPbModel() == null || sparseArray == null || (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) == null) {
            return;
        }
        if (this.f21337c == null) {
            b.a.q0.s.s.i iVar = new b.a.q0.s.s.i(this.f21335a.getContext());
            this.f21337c = iVar;
            iVar.m(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.f21335a.getPbModel().P0() != null && this.f21335a.getPbModel().P0().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_forbid_user_post_id) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int s2 = postData.s();
                if (z3 && s2 == 5) {
                    absVideoPbFragment2 = this.f21335a;
                    i2 = b.a.r0.k2.l.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.f21335a;
                    i2 = b.a.r0.k2.l.action_dislike;
                }
                b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(8, absVideoPbFragment2.getString(i2), this.f21337c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(b.a.r0.k2.i.tag_clip_board, postData);
                fVar4.f14338d.setTag(sparseArray2);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    b.a.q0.s.s.f fVar5 = new b.a.q0.s.s.f(5, this.f21335a.getString(b.a.r0.k2.l.mute_option), this.f21337c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = b.a.r0.k2.i.tag_is_mem;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = b.a.r0.k2.i.tag_user_mute_mute_username;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = b.a.r0.k2.i.tag_user_mute_post_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = b.a.r0.k2.i.tag_user_mute_thread_id;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = b.a.r0.k2.i.tag_del_post_is_self;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = b.a.r0.k2.i.tag_del_post_type;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = b.a.r0.k2.i.tag_del_post_id;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    int i12 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray3.put(i12, sparseArray.get(i12));
                    fVar5.f14338d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        b.a.q0.s.s.f fVar6 = new b.a.q0.s.s.f(5, this.f21335a.getString(b.a.r0.k2.l.report_text), this.f21337c);
                        fVar6.f14338d.setTag(str);
                        arrayList.add(fVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = b.a.r0.k2.i.tag_forbid_user_name;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = b.a.r0.k2.i.tag_forbid_user_name_show;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = b.a.r0.k2.i.tag_forbid_user_portrait;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    sparseArray4.put(b.a.r0.k2.i.tag_forbid_user_post_id, str);
                    if (booleanValue4) {
                        sparseArray4.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = b.a.r0.k2.i.tag_is_mem;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = b.a.r0.k2.i.tag_user_mute_mute_userid;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = b.a.r0.k2.i.tag_user_mute_mute_username;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = b.a.r0.k2.i.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = b.a.r0.k2.i.tag_user_mute_post_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                        int i22 = b.a.r0.k2.i.tag_user_mute_thread_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray4.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                        int i23 = b.a.r0.k2.i.tag_del_post_id;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = b.a.r0.k2.i.tag_del_post_type;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        int i25 = b.a.r0.k2.i.tag_has_sub_post;
                        sparseArray4.put(i25, sparseArray.get(i25));
                        fVar2 = new b.a.q0.s.s.f(6, this.f21335a.getString(b.a.r0.k2.l.delete), this.f21337c);
                        fVar2.f14338d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.FALSE);
                        fVar2 = null;
                    }
                    fVar = new b.a.q0.s.s.f(7, this.f21335a.getString(b.a.r0.k2.l.bar_manager), this.f21337c);
                    fVar.f14338d.setTag(sparseArray4);
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(b.a.r0.k2.i.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(b.a.r0.k2.i.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = b.a.r0.k2.i.tag_manage_user_identity;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    sparseArray5.put(b.a.r0.k2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                    int i27 = b.a.r0.k2.i.tag_del_post_id;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = b.a.r0.k2.i.tag_del_post_type;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    int i29 = b.a.r0.k2.i.tag_has_sub_post;
                    sparseArray5.put(i29, sparseArray.get(i29));
                    if (this.f21335a.getPbModel().P0().V() == 1002 && !booleanValue) {
                        fVar3 = new b.a.q0.s.s.f(6, this.f21335a.getString(b.a.r0.k2.l.report_text), this.f21337c);
                    } else {
                        fVar3 = new b.a.q0.s.s.f(6, this.f21335a.getString(b.a.r0.k2.l.delete), this.f21337c);
                    }
                    fVar3.f14338d.setTag(sparseArray5);
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
                    arrayList.add(new b.a.q0.s.s.f(9, TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.block_user), this.f21337c));
                }
            }
            this.f21337c.j(arrayList);
            PopupDialog popupDialog = new PopupDialog(this.f21335a.getPageContext(), this.f21337c);
            this.f21336b = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.f21335a) == null || absVideoPbFragment.getPbModel() == null || this.f21335a.getPbModel().P0() == null || (this.f21335a.getPbModel().P0().l() != null && this.f21335a.getPbModel().P0().l().isBlockBawuDelete)) {
                return false;
            }
            b.a.r0.k2.r.f P0 = this.f21335a.getPbModel().P0();
            if ((P0.O() == null || P0.O().J() == null || !P0.O().J().isForumBusinessAccount() || w0.isOn()) && !this.f21335a.getPbModel().E()) {
                return ((P0.O() != null && P0.O().U1()) || this.f21335a.getPbModel().P0().V() == 0 || this.f21335a.getPbModel().P0().V() == 3) ? false : true;
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
            AbsVideoPbFragment absVideoPbFragment = this.f21335a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || !this.f21335a.getPbModel().d1()) {
                return false;
            }
            return this.f21335a.getPbModel().N0() == null || this.f21335a.getPbModel().N0().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
