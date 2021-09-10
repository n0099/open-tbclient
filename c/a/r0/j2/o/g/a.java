package c.a.r0.j2.o.g;

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
import c.a.q0.s.q.x0;
import c.a.q0.s.q.z1;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.i;
import c.a.r0.i.g;
import c.a.r0.i.j;
import c.a.r0.j2.k.e.d0;
import c.a.r0.j2.k.e.e0;
import c.a.r0.j2.k.e.w0;
import c.a.r0.w0.v0;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.e.l.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public c.a.q0.s.b0.a J;
    public c.a.r0.j3.i0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public i.e N;
    public boolean O;
    public final b.c P;

    /* renamed from: a  reason: collision with root package name */
    public AbsVideoPbFragment f20629a;

    /* renamed from: b  reason: collision with root package name */
    public PopupDialog f20630b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s.s.i f20631c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f20632d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.s.s.a f20633e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f20634f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f20635g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.s.s.c f20636h;

    /* renamed from: i  reason: collision with root package name */
    public View f20637i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f20638j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public PopupDialog q;
    public c.a.q0.s.f0.a r;
    public c.a.q0.s.s.b s;
    public AlertDialog t;
    public d0 u;
    public c.a.r0.i.g v;
    public c.a.r0.i.j w;
    public c.a.r0.j2.k.f.a x;
    public PbFragment.z2 y;
    public w0 z;

    /* renamed from: c.a.r0.j2.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0978a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20639a;

        public C0978a(a aVar) {
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
            this.f20639a = aVar;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f20639a.A == null || TextUtils.isEmpty(this.f20639a.B)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f20639a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f20639a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f12802a = this.f20639a.B;
                        String str = "";
                        if (this.f20639a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f20639a.C.memeInfo.pck_id;
                        }
                        aVar.f12803b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f20639a.F == null) {
                        this.f20639a.F = new PermissionJudgePolicy();
                    }
                    this.f20639a.F.clearRequestPermissionList();
                    this.f20639a.F.appendRequestPermission(this.f20639a.f20629a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f20639a.F.startRequestPermission(this.f20639a.f20629a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f20639a.z == null) {
                        a aVar2 = this.f20639a;
                        aVar2.z = new w0(aVar2.f20629a.getPageContext());
                    }
                    this.f20639a.z.b(this.f20639a.B, this.f20639a.A.n());
                }
                this.f20639a.A = null;
                this.f20639a.B = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f20641f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20642g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20643h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f20644i;

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
            this.f20644i = aVar;
            this.f20640e = sparseArray;
            this.f20641f = z;
            this.f20642g = str;
            this.f20643h = str2;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f20644i.f20630b != null) {
                    this.f20644i.f20630b.dismiss();
                }
                if (i2 == 0) {
                    this.f20644i.g0(((Integer) this.f20640e.get(R.id.tag_del_post_type)).intValue(), (String) this.f20640e.get(R.id.tag_del_post_id), ((Integer) this.f20640e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f20640e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f20640e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f20640e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f20640e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f20641f, this.f20642g, str, str2, str3, 1, this.f20643h, this.f20644i.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f20644i.D);
                    this.f20644i.L0(this.f20641f, userMuteAddAndDelCustomMessage, this.f20643h, str, (String) this.f20640e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20645e;

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
            this.f20645e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20645e.f20629a.deleteThread(aVar, (JSONArray) null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20646e;

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
            this.f20646e = aVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f20646e.f20629a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f20649g;

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
            this.f20649g = aVar;
            this.f20647e = alertDialog;
            this.f20648f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f20647e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f20649g.f20629a.getPbActivity(), R.string.neterror);
                } else {
                    this.f20649g.f20629a.deleteThread(this.f20648f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20650e;

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
            this.f20650e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20650e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20651e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20652f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f20653g;

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
            this.f20653g = aVar;
            this.f20651e = alertDialog;
            this.f20652f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f20651e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f20653g.f20629a.getPbActivity(), R.string.neterror);
                } else {
                    this.f20653g.f20629a.deleteThread(this.f20652f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20654e;

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
            this.f20654e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20654e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements g.InterfaceC0925g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f20655a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20656b;

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
            this.f20656b = aVar;
            this.f20655a = aVar2;
        }

        @Override // c.a.r0.i.g.InterfaceC0925g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20656b.f20629a.deleteThread(this.f20655a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20658b;

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
            this.f20658b = aVar;
            this.f20657a = sparseArray;
        }

        @Override // c.a.r0.i.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20658b.f20629a.deleteThread(this.f20657a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20659e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20660f;

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
            this.f20660f = aVar;
            this.f20659e = z;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20660f.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f20660f.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f20660f.y != null) {
                            this.f20660f.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f20660f.T(this.f20659e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20661e;

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
            this.f20661e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20661e.t == null) {
                return;
            }
            c.a.e.e.m.g.a(this.f20661e.t, this.f20661e.f20629a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20662a;

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
            this.f20662a = aVar;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f20662a.f20629a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.f20662a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.f20662a.f20629a.getPageContext().getPageActivity(), this.f20662a.H);
                    new c.a.r0.j2.k.e.c(this.f20662a.f20629a.getPbModel().e1(), this.f20662a.H, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f20662a.f20629a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    a aVar2 = this.f20662a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.f20662a.f20629a.getPageContext().getPageActivity(), this.f20662a.H);
                    new c.a.r0.j2.k.e.c(this.f20662a.f20629a.getPbModel().e1(), this.f20662a.H, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    a aVar3 = this.f20662a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.f20662a.f20629a.getPageContext().getPageActivity(), this.f20662a.H);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f20663e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f20664f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f20665g;

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
            this.f20665g = aVar;
            this.f20663e = popupDialog;
            this.f20664f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f20665g.f20629a.getPbModel().b1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // c.a.q0.s.s.i.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            boolean r2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                return;
            }
            this.f20663e.dismiss();
            int i3 = 3;
            if (this.f20665g.f20629a.getPbModel().b1() != 1 || i2 != 1) {
                if (this.f20665g.f20629a.getPbModel().b1() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (this.f20665g.f20629a.getPbModel().b1() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f20664f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f20665g.f20629a.getPbModel().O0().f19616f != null && this.f20665g.f20629a.getPbModel().O0().f19616f.size() > i2) {
                    i2 = this.f20665g.f20629a.getPbModel().O0().f19616f.get(i2).sort_type.intValue();
                }
                r2 = this.f20665g.f20629a.getPbModel().r2(i2);
                this.f20664f.setTag(Integer.valueOf(this.f20665g.f20629a.getPbModel().a1()));
                if (r2) {
                    return;
                }
                this.f20665g.f20629a.setIsLoading(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f20664f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
            if (this.f20665g.f20629a.getPbModel().O0().f19616f != null) {
                i2 = this.f20665g.f20629a.getPbModel().O0().f19616f.get(i2).sort_type.intValue();
            }
            r2 = this.f20665g.f20629a.getPbModel().r2(i2);
            this.f20664f.setTag(Integer.valueOf(this.f20665g.f20629a.getPbModel().a1()));
            if (r2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f20666e;

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
            this.f20666e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f20666e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f20667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20668f;

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
            this.f20668f = aVar;
            this.f20667e = metaData;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f20667e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f20668f.f20629a.getAttentionModel() != null) {
                    this.f20668f.f20629a.getAttentionModel().m(!this.f20667e.hadConcerned(), this.f20667e.getPortrait(), this.f20667e.getUserId(), this.f20667e.isGod(), "6", this.f20668f.f20629a.getPageContext().getUniqueId(), this.f20668f.f20629a.getPbModel().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class q implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f20669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20670f;

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
            this.f20670f = aVar;
            this.f20669e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20670f.B0();
                MessageManager.getInstance().sendMessage(this.f20669e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class s implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f20671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20672f;

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
            this.f20672f = aVar;
            this.f20671e = cVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20672f.f20632d.dismiss();
                this.f20671e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20673e;

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
            this.f20673e = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f20673e.n = (String) compoundButton.getTag();
                if (this.f20673e.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f20673e.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f20673e.n != null && !str.equals(this.f20673e.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20674e;

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
            this.f20674e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f20674e.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20675e;

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
            this.f20675e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f20675e.f20635g instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f20675e.f20635g, this.f20675e.f20629a.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements PbFragment.z2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20676a;

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
            this.f20676a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.z2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f20676a.f20629a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f20676a.f20629a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f20676a.f20629a.getPageContext().getPageActivity(), this.f20676a.f20629a.getPbModel().O0().m().getId(), this.f20676a.f20629a.getPbModel().O0().m().getName(), this.f20676a.f20629a.getPbModel().O0().O().f0(), String.valueOf(this.f20676a.f20629a.getPbModel().O0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20677e;

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
            this.f20677e = aVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f20677e.f20630b != null) {
                    this.f20677e.f20630b.dismiss();
                }
                this.f20677e.M0(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f20677e.n0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f20677e.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        this.f20677e.n0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        this.f20677e.n0(view5);
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
                        if (this.f20677e.A == null || TextUtils.isEmpty(this.f20677e.B)) {
                            return;
                        }
                        if (this.f20677e.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f20677e.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f12802a = this.f20677e.B;
                            String str = "";
                            if (this.f20677e.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f20677e.C.memeInfo.pck_id;
                            }
                            aVar.f12803b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f20677e.A = null;
                        this.f20677e.B = null;
                        return;
                    case 2:
                        if (this.f20677e.A == null || TextUtils.isEmpty(this.f20677e.B)) {
                            return;
                        }
                        if (this.f20677e.F == null) {
                            this.f20677e.F = new PermissionJudgePolicy();
                        }
                        this.f20677e.F.clearRequestPermissionList();
                        this.f20677e.F.appendRequestPermission(this.f20677e.f20629a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f20677e.F.startRequestPermission(this.f20677e.f20629a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f20677e.z == null) {
                            a aVar2 = this.f20677e;
                            aVar2.z = new w0(aVar2.f20629a.getPageContext());
                        }
                        this.f20677e.z.b(this.f20677e.B, this.f20677e.A.n());
                        this.f20677e.A = null;
                        this.f20677e.B = null;
                        return;
                    case 3:
                        a aVar3 = this.f20677e;
                        PostData postData = aVar3.G;
                        if (postData != null) {
                            postData.h0(aVar3.f20629a.getPageContext().getPageActivity());
                            this.f20677e.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f20677e.f20629a.checkUpIsLogin()) {
                            this.f20677e.d0(view);
                            if (this.f20677e.f20629a.getPbModel().O0().O() == null || this.f20677e.f20629a.getPbModel().O0().O().J() == null || this.f20677e.f20629a.getPbModel().O0().O().J().getUserId() == null || this.f20677e.f20629a.getMarkModel() == null) {
                                return;
                            }
                            a aVar4 = this.f20677e;
                            int S = aVar4.S(aVar4.f20629a.getPbModel().O0());
                            d2 O = this.f20677e.f20629a.getPbModel().O0().O();
                            if (O.M1()) {
                                i3 = 2;
                            } else if (O.P1()) {
                                i3 = 3;
                            } else if (!O.N1()) {
                                i3 = O.O1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f20677e.f20629a.getPbModel().e1()).param("obj_locate", 2).param("obj_id", this.f20677e.f20629a.getPbModel().O0().O().J().getUserId()).param("obj_type", !this.f20677e.f20629a.getMarkModel().e()).param("obj_source", S).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.e.e.p.j.z()) {
                            this.f20677e.f20629a.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f20677e.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f20677e.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.f20677e.f20629a;
                            if (absVideoPbFragment == null || absVideoPbFragment.getPbActivity() == null) {
                                return;
                            }
                            boolean isHost = this.f20677e.f20629a.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f20677e.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f20677e.i0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f20677e.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f20677e.g0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.e.e.p.j.z()) {
                            this.f20677e.f20629a.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f20677e.g0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f20677e.B(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f20677e.l0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.f20677e.f20629a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            c.a.q0.m0.c f2 = TbPageExtraHelper.f(view);
                            if (f2 != null) {
                                postData2.q().objSource = f2.a();
                            }
                            this.f20677e.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.f20677e.f20629a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.getPbModel() == null || this.f20677e.f20629a.getPbModel().O0() == null || !ViewHelper.checkUpIsLogin(this.f20677e.f20629a.getContext()) || this.f20677e.f20629a.getPbActivity() == null) {
                            return;
                        }
                        this.f20677e.f20629a.getPbActivity().showBlockDialog(c.a.r0.t3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f20680g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f20681h;

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
            this.f20681h = aVar;
            this.f20678e = sparseArray;
            this.f20679f = i2;
            this.f20680g = z;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f20681h.f20629a.deleteThreadDirect(((Integer) this.f20678e.get(R.id.tag_del_post_type)).intValue(), (String) this.f20678e.get(R.id.tag_del_post_id), this.f20679f, this.f20680g);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1651843774, "Lc/a/r0/j2/o/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1651843774, "Lc/a/r0/j2/o/g/a;");
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
        this.f20632d = null;
        this.f20633e = null;
        this.f20634f = null;
        this.f20635g = null;
        this.f20636h = null;
        this.f20637i = null;
        this.f20638j = null;
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
        this.L = c.a.q0.b.d.b0();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new C0978a(this);
        this.f20629a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        c.a.r0.j2.k.f.a aVar = new c.a.r0.j2.k.f.a(this.f20629a.getContext());
        this.x = aVar;
        aVar.b(this.f20629a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20629a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new n(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new o(this, metaData));
        aVar.create(this.f20629a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.e.e.m.b.g((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
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
                this.r = new c.a.q0.s.f0.a(this.f20629a.getPageContext());
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
            this.J = new c.a.q0.s.b0.a();
        }
        if (this.K == null) {
            c.a.r0.j3.i0.e eVar = new c.a.r0.j3.i0.e();
            this.K = eVar;
            eVar.f20840a = this.f20629a.getUniqueId();
        }
        c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
        fVar.f14167b = 5;
        fVar.f14173h = 8;
        fVar.f14172g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.f20629a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.getPbModel() != null) {
            fVar.f14171f = this.f20629a.getPbModel().N0();
        }
        fVar.f14166a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f14174i = 0;
                this.J.c(agreeData, i2, this.f20629a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.f20629a;
                if (absVideoPbFragment != null || absVideoPbFragment.getPbModel() == null || this.f20629a.getPbModel().O0() == null) {
                    return;
                }
                this.J.b(this.f20629a.getPbActivity(), fVar, agreeData, this.f20629a.getPbModel().O0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f14174i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f14174i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.f20629a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.f20629a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, c.a.r0.i.i iVar, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.f20629a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new c.a.r0.i.j(this.f20629a.getPageContext(), this.f20629a.getView(), iVar, userData);
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
        x0 x0Var = new x0();
        x0Var.k(sparseArray2);
        this.w.E(new String[]{this.f20629a.getString(R.string.delete_thread_reason_1), this.f20629a.getString(R.string.delete_thread_reason_2), this.f20629a.getString(R.string.delete_thread_reason_3), this.f20629a.getString(R.string.delete_thread_reason_4), this.f20629a.getString(R.string.delete_thread_reason_5)});
        this.w.D(x0Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f20629a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, c.a.e.e.p.l.g(pageActivity, R.dimen.ds100));
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
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20629a.getPageContext().getPageActivity());
            aVar.setMessage(this.f20629a.getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new b0(this));
            aVar.setNegativeButton(R.string.cancel, new c0(this));
            aVar.create(this.f20629a.getPageContext()).show();
        }
    }

    public final boolean E(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        List<c.a.q0.s.s.f> b2;
        c.a.q0.s.s.f fVar;
        c.a.q0.s.s.f fVar2;
        c.a.q0.s.s.f fVar3;
        c.a.q0.s.s.f fVar4;
        c.a.e.l.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f20629a;
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
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.G = postData;
            if (postData == null || this.f20629a.getMarkModel() == null) {
                return true;
            }
            boolean z4 = this.f20629a.getMarkModel().e() && this.G.E() != null && this.G.E().equals(this.f20629a.getPbModel().J0());
            boolean z5 = this.f20629a.getPbModel().O0() != null && this.f20629a.getPbModel().O0().f0();
            if (this.f20631c == null) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20629a.getContext());
                this.f20631c = iVar;
                iVar.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z6 = Y(view) && !z5;
            boolean z7 = (!Y(view) || (aVar = this.A) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (z6) {
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new c.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.f20631c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
            }
            if (z7) {
                arrayList.add(new c.a.q0.s.s.f(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.f20631c));
            }
            if (!z6 && !z7) {
                c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.f20631c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.G);
                fVar5.f14428d.setTag(sparseArray3);
                arrayList.add(fVar5);
            }
            if (!booleanValue && !z5) {
                if (z4) {
                    fVar4 = new c.a.q0.s.s.f(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.f20631c);
                } else {
                    fVar4 = new c.a.q0.s.s.f(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.f20631c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.G);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                fVar4.f14428d.setTag(sparseArray4);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.f20631c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i2 = R.id.tag_is_mem;
                    sparseArray5.put(i2, sparseArray.get(i2));
                    int i3 = R.id.tag_user_mute_mute_userid;
                    sparseArray5.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_username;
                    sparseArray5.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray5.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_post_id;
                    sparseArray5.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_thread_id;
                    sparseArray5.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_del_post_is_self;
                    sparseArray5.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_type;
                    sparseArray5.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_id;
                    sparseArray5.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i11, sparseArray.get(i11));
                    fVar6.f14428d.setTag(sparseArray5);
                    arrayList.add(fVar6);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z5) {
                        c.a.q0.s.s.f fVar7 = new c.a.q0.s.s.f(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f20631c);
                        fVar7.f14428d.setTag(str);
                        arrayList.add(fVar7);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray6.put(i12, sparseArray.get(i12));
                    int i13 = R.id.tag_forbid_user_name;
                    sparseArray6.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name_show;
                    sparseArray6.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_portrait;
                    sparseArray6.put(i15, sparseArray.get(i15));
                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i16 = R.id.tag_is_mem;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        int i17 = R.id.tag_user_mute_mute_userid;
                        sparseArray6.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_username;
                        sparseArray6.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray6.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_post_id;
                        sparseArray6.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_thread_id;
                        sparseArray6.put(i21, sparseArray.get(i21));
                    } else {
                        sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i22 = R.id.tag_del_post_id;
                        sparseArray6.put(i22, sparseArray.get(i22));
                        int i23 = R.id.tag_del_post_type;
                        sparseArray6.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_has_sub_post;
                        sparseArray6.put(i24, sparseArray.get(i24));
                        fVar2 = new c.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f20631c);
                        fVar2.f14428d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        fVar2 = null;
                    }
                    fVar = new c.a.q0.s.s.f(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.f20631c);
                    fVar.f14428d.setTag(sparseArray6);
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i25 = R.id.tag_manage_user_identity;
                    sparseArray7.put(i25, sparseArray.get(i25));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i26 = R.id.tag_del_post_id;
                    sparseArray7.put(i26, sparseArray.get(i26));
                    int i27 = R.id.tag_del_post_type;
                    sparseArray7.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_has_sub_post;
                    sparseArray7.put(i28, sparseArray.get(i28));
                    if (this.f20629a.getPbModel().O0().V() == 1002 && !booleanValue2) {
                        fVar3 = new c.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f20631c);
                    } else {
                        fVar3 = new c.a.q0.s.s.f(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f20631c);
                    }
                    fVar3.f14428d.setTag(sparseArray7);
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
                c.a.r0.j2.k.e.f1.a.a(arrayList, this.f20631c, this.G, this.f20629a.getPbModel());
            }
            if (c.a.q0.b.d.C()) {
                b2 = c.a.r0.j2.k.e.f1.a.c(arrayList, this.G.q(), sparseArray, this.f20631c);
            } else {
                b2 = c.a.r0.j2.k.e.f1.a.b(arrayList, this.G.q(), sparseArray, this.f20631c);
            }
            c.a.r0.j2.k.e.f1.a.k(b2, this.O);
            c.a.r0.j2.k.e.f1.a.e(b2);
            this.f20631c.o(c.a.r0.j2.k.e.f1.a.f(this.G));
            if (c.a.q0.b.d.C()) {
                this.f20631c.l(b2, false);
            } else {
                this.f20631c.l(b2, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f20629a.getPageContext(), this.f20631c);
            this.f20630b = popupDialog;
            popupDialog.showDialog();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f20629a.getPbModel().e1()).param("fid", this.f20629a.getPbModel().getForumId()).param("uid", this.f20629a.getPbModel().O0().O().J().getUserId()).param("post_id", this.f20629a.getPbModel().y()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.f20630b;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.f20630b.dismiss();
                this.f20630b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20629a.getBaseFragmentActivity());
                iVar.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.q0.s.s.f(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), iVar));
                }
                if (z2) {
                    arrayList.add(new c.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), iVar));
                } else {
                    arrayList.add(new c.a.q0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), iVar));
                }
                iVar.k(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(this.f20629a.getPageContext(), iVar);
                this.f20630b = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.f20629a.hideEditTool();
            PopupDialog popupDialog = this.f20630b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            this.f20629a.hideKeyBroad();
            K();
        }
    }

    public void F0(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.f20632d;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.f20632d = null;
            }
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20629a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.f20629a.getPbModel().O0() != null && this.f20629a.getPbModel().O0().O() != null && !this.f20629a.getPbModel().O0().O().Q1()) {
                arrayList.add(new c.a.q0.s.s.f(0, this.f20629a.getPageContext().getString(R.string.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new c.a.q0.s.s.f(1, this.f20629a.getPageContext().getString(R.string.save_to_local), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new s(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f20629a.getPageContext(), iVar);
            this.f20632d = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.f20629a.hideEditTool();
            PopupDialog popupDialog = this.f20630b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            c.a.q0.s.s.c cVar = this.f20636h;
            if (cVar != null) {
                cVar.d();
                this.f20636h = null;
            }
            if (this.f20629a.getPbModel() == null) {
                return;
            }
            ArrayList<c.a.q0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new c.a.q0.s.s.k(this.f20629a.getContext().getString(R.string.all_person), "", this.f20629a.getPbModel().X0() == 1, Integer.toString(1)));
            arrayList.add(new c.a.q0.s.s.k(this.f20629a.getContext().getString(R.string.my_fans), "", this.f20629a.getPbModel().X0() == 2, Integer.toString(5)));
            arrayList.add(new c.a.q0.s.s.k(this.f20629a.getContext().getString(R.string.my_attentions), "", this.f20629a.getPbModel().X0() == 3, Integer.toString(6)));
            arrayList.add(new c.a.q0.s.s.k(this.f20629a.getContext().getString(R.string.myself_only), "", this.f20629a.getPbModel().X0() == 4, Integer.toString(7)));
            c.a.q0.s.s.c cVar2 = new c.a.q0.s.s.c(this.f20629a.getPageContext());
            cVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.f20636h = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.f20636h.n();
        }
    }

    public void H() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f20630b) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public void H0(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, e0Var) == null) || this.f20629a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.f20629a;
        this.u = new d0(absVideoPbFragment, absVideoPbFragment.listener);
        AlertDialog create = new AlertDialog.Builder(this.f20629a.getContext(), R.style.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        c.a.e.e.m.g.i(this.t, this.f20629a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.r());
        this.u.O(e0Var == null ? false : e0Var.f20036a);
        this.u.v(e0Var == null ? false : e0Var.n);
        this.u.x(e0Var == null ? false : e0Var.f20040e);
        this.u.D(e0Var == null ? false : e0Var.f20044i);
        this.u.y(e0Var == null ? false : e0Var.f20041f);
        this.u.Q(e0Var != null ? e0Var.f20038c : true);
        this.u.N(e0Var == null ? false : e0Var.k);
        this.u.z(e0Var == null ? false : e0Var.l, e0Var.t);
        if (e0Var == null) {
            this.u.K(false, false);
            this.u.J(false, false);
        } else {
            this.u.K(e0Var.f20042g, e0Var.s);
            this.u.J(e0Var.f20043h, e0Var.r);
        }
        boolean z2 = e0Var == null ? false : e0Var.q;
        boolean z3 = e0Var == null ? false : e0Var.o;
        boolean z4 = e0Var == null ? false : e0Var.f20039d;
        boolean z5 = e0Var == null ? false : e0Var.f20037b;
        boolean z6 = e0Var == null ? false : e0Var.p;
        boolean z7 = e0Var == null ? false : e0Var.f20045j;
        boolean z8 = e0Var == null ? false : e0Var.m;
        this.u.A(z4, z3);
        this.u.P(z5, z2);
        this.u.L(z7, z6);
        this.u.S(z8);
        if (e0Var != null) {
            d0 d0Var = this.u;
            boolean z9 = e0Var.u;
            d0Var.w = z9;
            if (z9) {
                d0Var.f().setText(R.string.report_text);
                this.u.y(false);
            }
        }
        this.u.w(e0Var != null ? e0Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f20629a.getPbModel() != null && this.f20629a.getPbModel().O0() != null && this.f20629a.getPbModel().O0().Q() != null && this.f20629a.getPbModel().O0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(R.string.have_called_fans_short);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            c.a.e.e.m.e.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(c.a.q0.s.s.a aVar, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, aVar, i2) == null) || (absVideoPbFragment = this.f20629a) == null || aVar == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new c.a.r0.i.g(this.f20629a.getPageContext(), this.f20629a.getView());
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
        x0 x0Var = new x0();
        x0Var.k(sparseArray);
        this.v.y(new String[]{this.f20629a.getString(R.string.delete_thread_reason_1), this.f20629a.getString(R.string.delete_thread_reason_2), this.f20629a.getString(R.string.delete_thread_reason_3), this.f20629a.getString(R.string.delete_thread_reason_4), this.f20629a.getString(R.string.delete_thread_reason_5)});
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
        c.a.e.e.m.g.a(alertDialog, this.f20629a.getPageContext().getPageActivity());
    }

    public void J0(View view) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (absVideoPbFragment = this.f20629a) == null || absVideoPbFragment.getPbModel() == null) {
            return;
        }
        PopupDialog popupDialog = new PopupDialog(this.f20629a.getPageContext());
        if (this.f20629a.getPbModel().O0().f19616f == null || this.f20629a.getPbModel().O0().f19616f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
        } else {
            strArr = new String[this.f20629a.getPbModel().O0().f19616f.size()];
            for (int i2 = 0; i2 < this.f20629a.getPbModel().O0().f19616f.size(); i2++) {
                strArr[i2] = this.f20629a.getPbModel().O0().f19616f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
            }
        }
        popupDialog.setDefaultContentView(null, strArr, new m(this, popupDialog, view));
        popupDialog.showDialog();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.q0.s.s.a aVar = this.f20633e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f20634f;
            if (dialog != null) {
                c.a.e.e.m.g.b(dialog, this.f20629a.getPageContext());
            }
            Dialog dialog2 = this.f20635g;
            if (dialog2 != null) {
                c.a.e.e.m.g.b(dialog2, this.f20629a.getPageContext());
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
            AbsVideoPbFragment absVideoPbFragment = this.f20629a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20629a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new p(this));
            aVar.create(this.f20629a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f20629a.getPbModel() == null || this.f20629a.getPbModel().O0() == null) {
                return null;
            }
            return this.f20629a.getPbModel().O0().d();
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
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20629a.getBaseFragmentActivity());
            if (c.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new q(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new r(this));
            aVar.create(this.f20629a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view = this.f20637i;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f20629a.getPbModel().e1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.r0.j2.k.e.f1.a.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (d0Var = this.u) == null) {
            return;
        }
        d0Var.u();
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

    public d0 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (d0) invokeV.objValue;
    }

    public c.a.q0.s.s.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (c.a.q0.s.s.b) invokeV.objValue;
    }

    public int S(c.a.r0.j2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return 0;
            }
            if (eVar.O().o1() == 0) {
                return 1;
            }
            if (eVar.O().o1() == 54) {
                return 2;
            }
            return eVar.O().o1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            L0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (this.f20629a.getPbModel() != null && this.f20629a.getPbModel().O0() != null && this.f20629a.getPbModel().O0().f0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.f20629a.getPbModel().e1(), str);
                d2 O = this.f20629a.getPbModel().O0().O();
                if (O.M1()) {
                    format = format + "&channelid=33833";
                } else if (O.R1()) {
                    format = format + "&channelid=33842";
                } else if (O.P1()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        c.a.q0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new c.a.q0.s.s.b(this.f20629a.getPageContext().getPageActivity());
            String[] strArr = {this.f20629a.getPageContext().getString(R.string.call_phone), this.f20629a.getPageContext().getString(R.string.sms_phone), this.f20629a.getPageContext().getString(R.string.search_in_baidu)};
            c.a.q0.s.s.b bVar = this.s;
            bVar.j(strArr, new l(this));
            bVar.g(b.C0696b.f14406a);
            bVar.h(17);
            bVar.c(this.f20629a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? c.a.r0.j2.k.e.f1.a.h(this.f20629a.getPbModel()) : invokeV.booleanValue;
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
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f20629a.getPbModel().O0().U() != null && (forumToolAuth = this.f20629a.getPbModel().O0().U().getForumToolAuth()) != null) {
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
            if (this.f20629a.getPbModel() != null && this.f20629a.getPbModel().O0() != null) {
                return ((this.f20629a.getPbModel().O0().V() != 0) || this.f20629a.getPbModel().O0().O() == null || this.f20629a.getPbModel().O0().O().J() == null || TextUtils.equals(this.f20629a.getPbModel().O0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f20629a.getContext(), "", str, true);
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
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
        if (postData.E() != null && postData.E().equals(this.f20629a.getPbModel().J0())) {
            z2 = true;
        }
        MarkData I0 = this.f20629a.getPbModel().I0(postData);
        if (this.f20629a.getPbModel().O0() != null && this.f20629a.getPbModel().O0().f0()) {
            AbsVideoPbFragment absVideoPbFragment = this.f20629a;
            PostData firstPostData = absVideoPbFragment.getFirstPostData(absVideoPbFragment.getPbModel().O0());
            if (firstPostData != null) {
                I0 = this.f20629a.getPbModel().I0(firstPostData);
            }
        }
        if (I0 == null) {
            return;
        }
        this.f20629a.setPreLoad();
        if (this.f20629a.getMarkModel() != null) {
            this.f20629a.getMarkModel().i(I0);
            if (!z2) {
                this.f20629a.getMarkModel().a();
            } else {
                this.f20629a.getMarkModel().d();
            }
        }
    }

    public void f0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.f20637i == null) {
                this.f20637i = LayoutInflater.from(this.f20629a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f20629a.getBaseFragmentActivity().getLayoutMode().j(this.f20637i);
            if (this.f20635g == null) {
                Dialog dialog = new Dialog(this.f20629a.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.f20635g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f20635g.setCancelable(true);
                this.o = (ScrollView) this.f20637i.findViewById(R.id.good_scroll);
                this.f20635g.setContentView(this.f20637i);
                WindowManager.LayoutParams attributes = this.f20635g.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.f20635g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.f20638j = (LinearLayout) this.f20637i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.f20637i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.f20637i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.f20629a.getListener());
            }
            this.f20638j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.f20629a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.f20638j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.f20629a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f20638j.addView(view);
                        this.f20638j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20629a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20629a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20629a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.f20638j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.f20638j);
                }
            }
            c.a.e.e.m.g.j(this.f20635g, this.f20629a.getPageContext());
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
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = R.string.del_all_post_confirm;
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            this.f20633e = new c.a.q0.s.s.a(this.f20629a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f20633e.setMessageId(i4);
            } else {
                this.f20633e.setOnlyMessageShowCenter(false);
                this.f20633e.setMessage(str2);
            }
            this.f20633e.setYesButtonTag(sparseArray);
            this.f20633e.setPositiveButton(R.string.dialog_ok, new b(this));
            this.f20633e.setNegativeButton(R.string.dialog_cancel, new c(this));
            this.f20633e.setCancelable(true);
            this.f20633e.create(this.f20629a.getPageContext());
            if (z3) {
                v0(sparseArray);
            } else if (z2) {
                v0(sparseArray);
            } else if (q0()) {
                c.a.r0.i.i iVar = new c.a.r0.i.i(this.f20629a.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20629a.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20629a.getPbModel().O0().p().has_forum_rule.intValue());
                iVar.i(this.f20629a.getPbModel().O0().m().getId(), this.f20629a.getPbModel().O0().m().getName());
                iVar.h(this.f20629a.getPbModel().O0().m().getImage_url());
                iVar.j(this.f20629a.getPbModel().O0().m().getUser_level());
                C0(sparseArray, i2, iVar, this.f20629a.getPbModel().O0().U(), false);
            } else {
                I0(this.f20633e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
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
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20629a.getContext());
            iVar.q(this.f20629a.getString(R.string.bar_manager));
            iVar.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.q0.s.s.f(10, this.f20629a.getString(R.string.delete_post), iVar);
                } else {
                    fVar2 = new c.a.q0.s.s.f(10, this.f20629a.getString(R.string.delete), iVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = R.id.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                fVar2.f14428d.setTag(sparseArray2);
                arrayList.add(fVar2);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = R.id.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = R.id.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(11, this.f20629a.getString(R.string.forbidden_person), iVar);
                fVar3.f14428d.setTag(sparseArray3);
                arrayList.add(fVar3);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = R.id.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = R.id.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z2) {
                    fVar = new c.a.q0.s.s.f(12, this.f20629a.getString(R.string.un_mute), iVar);
                } else {
                    fVar = new c.a.q0.s.s.f(12, this.f20629a.getString(R.string.mute), iVar);
                }
                fVar.f14428d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            iVar.k(arrayList);
            PopupDialog popupDialog = this.q;
            if (popupDialog == null) {
                this.q = new PopupDialog(this.f20629a.getPageContext(), iVar);
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
        c.a.r0.j2.h.e O0;
        d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.f20629a) == null || absVideoPbFragment.getPbModel() == null || this.f20629a.getPbModel().O0() == null || (O = (O0 = this.f20629a.getPbModel().O0()).O()) == null || O.J() == null) {
            return;
        }
        this.f20629a.hideEditTool();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        e0 e0Var = new e0();
        int V = this.f20629a.getPbModel().O0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            e0Var.f20042g = false;
        } else {
            e0Var.f20042g = true;
            e0Var.s = O.r0() == 1;
        }
        if (Z(V)) {
            e0Var.f20043h = true;
            e0Var.r = O.q0() == 1;
        } else {
            e0Var.f20043h = false;
        }
        if (V == 1002 && !equals) {
            e0Var.u = true;
        }
        e0Var.n = y0(O.S1(), O0.h0(), equals, V, O.I2(), O.s2());
        e0Var.f20040e = u0(equals, O0.h0());
        e0Var.f20044i = z0();
        e0Var.f20041f = x0(equals);
        e0Var.k = equals && O0.U() != null && O0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            e0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().e();
        }
        e0Var.t = equals;
        e0Var.q = this.f20629a.getPbModel().c1();
        e0Var.f20037b = true;
        e0Var.f20036a = b0(equals);
        e0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        e0Var.f20045j = true;
        e0Var.o = this.f20629a.getPbModel().s0();
        e0Var.f20039d = true;
        if (O.q1() == null) {
            e0Var.f20038c = true;
        } else {
            e0Var.f20038c = false;
        }
        if (O0.f0()) {
            e0Var.f20037b = false;
            e0Var.f20039d = false;
            e0Var.f20038c = false;
            e0Var.f20042g = false;
            e0Var.f20043h = false;
        }
        e0Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !O0.f0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.f20629a;
        if (absVideoPbFragment2.getFirstPostData(absVideoPbFragment2.getPbModel().O0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.f20629a;
            e0Var.w = absVideoPbFragment3.getFirstPostData(absVideoPbFragment3.getPbModel().O0()).S;
        }
        if (c.a.q0.g1.b.e.d()) {
            e0Var.f20039d = false;
            e0Var.f20037b = false;
            e0Var.f20038c = false;
        }
        if (O.S1()) {
            e0Var.n = false;
            e0Var.f20042g = false;
            e0Var.f20043h = false;
        }
        H0(e0Var);
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
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.O ? 2 : 3));
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
            AbsVideoPbFragment absVideoPbFragment = this.f20629a;
            return (absVideoPbFragment == null || absVideoPbFragment.getPbModel().O0().m().getDeletedReasonInfo() == null || 1 != this.f20629a.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.f20629a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f20629a.getPbActivity());
        lVar.p(R.string.musk_my_thread_confirm);
        lVar.j(R.string.musk_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        androidx.appcompat.app.AlertDialog s2 = lVar.s();
        aVar.a(new f(this, s2, sparseArray));
        aVar2.a(new g(this, s2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.f20629a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.r0.i.i iVar = new c.a.r0.i.i(this.f20629a.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20629a.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20629a.getPbModel().O0().p().has_forum_rule.intValue());
        iVar.i(this.f20629a.getPbModel().O0().m().getId(), this.f20629a.getPbModel().O0().m().getName());
        iVar.h(this.f20629a.getPbModel().O0().m().getImage_url());
        iVar.j(this.f20629a.getPbModel().O0().m().getUser_level());
        C0(sparseArray, i2, iVar, this.f20629a.getPbModel().O0().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            c.a.r0.j2.k.e.f1.a.d(this.f20629a.getActivity(), this.f20629a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        c.a.q0.s.q.e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f20629a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || this.f20629a.getPbModel().O0() == null) {
                return false;
            }
            c.a.r0.j2.h.e O0 = this.f20629a.getPbModel().O0();
            d2 O = O0.O();
            if (O != null) {
                if (O.M1() || O.P1()) {
                    return false;
                }
                if (O.N1() || O.O1()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !v0.isOn()) || this.f20629a.getPbModel().D() || O.I2() || O.s2() || z3) {
                return false;
            }
            if (O0.m() == null || !O0.m().isBlockBawuDelete) {
                if (O0.V() != 0) {
                    return O0.V() != 3;
                }
                List<z1> q2 = O0.q();
                if (ListUtils.getCount(q2) > 0) {
                    for (z1 z1Var : q2) {
                        if (z1Var != null && (e0Var = z1Var.f14379g) != null && e0Var.f14152a && !e0Var.f14154c && ((i2 = e0Var.f14153b) == 1 || i2 == 2)) {
                            return true;
                        }
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
        if (!(interceptable == null || interceptable.invokeL(1048636, this, sparseArray) == null) || this.f20629a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f20629a.getPbActivity());
        lVar.p(R.string.del_my_thread_confirm);
        lVar.j(R.string.del_my_thread_confirm_subtitle);
        lVar.l(true);
        lVar.o(aVar2, aVar);
        lVar.g(false);
        androidx.appcompat.app.AlertDialog s2 = lVar.s();
        aVar.a(new d(this, s2, sparseArray));
        aVar2.a(new e(this, s2));
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
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.f20629a) == null || absVideoPbFragment.getPbModel() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.f20631c == null) {
            c.a.q0.s.s.i iVar = new c.a.q0.s.s.i(this.f20629a.getContext());
            this.f20631c = iVar;
            iVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.f20629a.getPbModel().O0() != null && this.f20629a.getPbModel().O0().f0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int s2 = postData.s();
                if (z3 && s2 == 5) {
                    absVideoPbFragment2 = this.f20629a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.f20629a;
                    i2 = R.string.action_dislike;
                }
                c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(8, absVideoPbFragment2.getString(i2), this.f20631c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                fVar4.f14428d.setTag(sparseArray2);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(5, this.f20629a.getString(R.string.mute_option), this.f20631c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = R.id.tag_is_mem;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_userid;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_username;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_post_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_user_mute_thread_id;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_is_self;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_type;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_del_post_id;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray3.put(i12, sparseArray.get(i12));
                    fVar5.f14428d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(5, this.f20629a.getString(R.string.report_text), this.f20631c);
                        fVar6.f14428d.setTag(str);
                        arrayList.add(fVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = R.id.tag_manage_user_identity;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_name_show;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = R.id.tag_forbid_user_portrait;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = R.id.tag_is_mem;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_userid;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_username;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_post_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                        int i22 = R.id.tag_user_mute_thread_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                        int i23 = R.id.tag_del_post_id;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_del_post_type;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        int i25 = R.id.tag_has_sub_post;
                        sparseArray4.put(i25, sparseArray.get(i25));
                        fVar2 = new c.a.q0.s.s.f(6, this.f20629a.getString(R.string.delete), this.f20631c);
                        fVar2.f14428d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        fVar2 = null;
                    }
                    fVar = new c.a.q0.s.s.f(7, this.f20629a.getString(R.string.bar_manager), this.f20631c);
                    fVar.f14428d.setTag(sparseArray4);
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                    int i27 = R.id.tag_del_post_id;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_del_post_type;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    int i29 = R.id.tag_has_sub_post;
                    sparseArray5.put(i29, sparseArray.get(i29));
                    if (this.f20629a.getPbModel().O0().V() == 1002 && !booleanValue) {
                        fVar3 = new c.a.q0.s.s.f(6, this.f20629a.getString(R.string.report_text), this.f20631c);
                    } else {
                        fVar3 = new c.a.q0.s.s.f(6, this.f20629a.getString(R.string.delete), this.f20631c);
                    }
                    fVar3.f14428d.setTag(sparseArray5);
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
                    arrayList.add(new c.a.q0.s.s.f(9, TbadkCoreApplication.getInst().getString(R.string.block_user), this.f20631c));
                }
            }
            this.f20631c.k(arrayList);
            PopupDialog popupDialog = new PopupDialog(this.f20629a.getPageContext(), this.f20631c);
            this.f20630b = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.f20629a) == null || absVideoPbFragment.getPbModel() == null || this.f20629a.getPbModel().O0() == null || (this.f20629a.getPbModel().O0().m() != null && this.f20629a.getPbModel().O0().m().isBlockBawuDelete)) {
                return false;
            }
            c.a.r0.j2.h.e O0 = this.f20629a.getPbModel().O0();
            return ((O0.O() != null && O0.O().J() != null && O0.O().J().isForumBusinessAccount() && !v0.isOn()) || this.f20629a.getPbModel().D() || this.f20629a.getPbModel().O0().V() == 0 || this.f20629a.getPbModel().O0().V() == 3) ? false : true;
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
            AbsVideoPbFragment absVideoPbFragment = this.f20629a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || !this.f20629a.getPbModel().c1()) {
                return false;
            }
            return this.f20629a.getPbModel().M0() == null || this.f20629a.getPbModel().M0().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
