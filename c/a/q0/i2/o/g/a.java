package c.a.q0.i2.o.g;

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
import c.a.p0.b0.d;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.e0;
import c.a.p0.s.q.m0;
import c.a.p0.s.q.x0;
import c.a.p0.s.q.y1;
import c.a.p0.s.s.a;
import c.a.p0.s.s.b;
import c.a.p0.s.s.i;
import c.a.q0.i.g;
import c.a.q0.i.j;
import c.a.q0.i2.k.e.d0;
import c.a.q0.i2.k.e.u0;
import c.a.q0.v0.v0;
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
    public c.a.p0.s.b0.a J;
    public c.a.q0.i3.i0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public i.e N;
    public boolean O;
    public final b.c P;

    /* renamed from: a  reason: collision with root package name */
    public AbsVideoPbFragment f20065a;

    /* renamed from: b  reason: collision with root package name */
    public PopupDialog f20066b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s.s.i f20067c;

    /* renamed from: d  reason: collision with root package name */
    public PopupDialog f20068d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.s.s.a f20069e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f20070f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f20071g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.s.s.c f20072h;

    /* renamed from: i  reason: collision with root package name */
    public View f20073i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f20074j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public PopupDialog q;
    public c.a.p0.s.f0.a r;
    public c.a.p0.s.s.b s;
    public AlertDialog t;
    public c.a.q0.i2.k.e.c0 u;
    public c.a.q0.i.g v;
    public c.a.q0.i.j w;
    public c.a.q0.i2.k.f.a x;
    public PbFragment.z2 y;
    public u0 z;

    /* renamed from: c.a.q0.i2.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0945a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20075a;

        public C0945a(a aVar) {
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
            this.f20075a = aVar;
        }

        @Override // c.a.p0.s.s.b.c
        public void a(c.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f20075a.A == null || TextUtils.isEmpty(this.f20075a.B)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f20075a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f20075a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f12810a = this.f20075a.B;
                        String str = "";
                        if (this.f20075a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f20075a.C.memeInfo.pck_id;
                        }
                        aVar.f12811b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f20075a.F == null) {
                        this.f20075a.F = new PermissionJudgePolicy();
                    }
                    this.f20075a.F.clearRequestPermissionList();
                    this.f20075a.F.appendRequestPermission(this.f20075a.f20065a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f20075a.F.startRequestPermission(this.f20075a.f20065a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f20075a.z == null) {
                        a aVar2 = this.f20075a;
                        aVar2.z = new u0(aVar2.f20065a.getPageContext());
                    }
                    this.f20075a.z.b(this.f20075a.B, this.f20075a.A.n());
                }
                this.f20075a.A = null;
                this.f20075a.B = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20076e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f20077f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20078g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20079h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f20080i;

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
            this.f20080i = aVar;
            this.f20076e = sparseArray;
            this.f20077f = z;
            this.f20078g = str;
            this.f20079h = str2;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f20080i.f20066b != null) {
                    this.f20080i.f20066b.dismiss();
                }
                if (i2 == 0) {
                    this.f20080i.g0(((Integer) this.f20076e.get(R.id.tag_del_post_type)).intValue(), (String) this.f20076e.get(R.id.tag_del_post_id), ((Integer) this.f20076e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f20076e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f20076e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f20076e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f20076e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f20077f, this.f20078g, str, str2, str3, 1, this.f20079h, this.f20080i.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f20080i.D);
                    this.f20080i.L0(this.f20077f, userMuteAddAndDelCustomMessage, this.f20079h, str, (String) this.f20076e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20081e;

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
            this.f20081e = aVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20081e.f20065a.deleteThread(aVar, (JSONArray) null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20082e;

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
            this.f20082e = aVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f20082e.f20065a.getFragmentActivity(), 2, true, 4);
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20084f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f20085g;

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
            this.f20085g = aVar;
            this.f20083e = alertDialog;
            this.f20084f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f20083e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f20085g.f20065a.getPbActivity(), R.string.neterror);
                } else {
                    this.f20085g.f20065a.deleteThread(this.f20084f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20086e;

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
            this.f20086e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20086e) == null) {
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
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20088f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f20089g;

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
            this.f20089g = aVar;
            this.f20087e = alertDialog;
            this.f20088f = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                androidx.appcompat.app.AlertDialog alertDialog = this.f20087e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!c.a.e.e.p.j.A()) {
                    c.a.e.e.p.l.L(this.f20089g.f20065a.getPbActivity(), R.string.neterror);
                } else {
                    this.f20089g.f20065a.deleteThread(this.f20088f, (JSONArray) null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.AlertDialog f20090e;

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
            this.f20090e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.app.AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f20090e) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements g.InterfaceC0904g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f20091a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20092b;

        public h(a aVar, c.a.p0.s.s.a aVar2) {
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
            this.f20092b = aVar;
            this.f20091a = aVar2;
        }

        @Override // c.a.q0.i.g.InterfaceC0904g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20092b.f20065a.deleteThread(this.f20091a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20093a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20094b;

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
            this.f20094b = aVar;
            this.f20093a = sparseArray;
        }

        @Override // c.a.q0.i.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f20094b.f20065a.deleteThread(this.f20093a, jSONArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20096f;

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
            this.f20096f = aVar;
            this.f20095e = z;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20096f.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f20096f.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f20096f.y != null) {
                            this.f20096f.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f20096f.T(this.f20095e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
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
        public final /* synthetic */ a f20097e;

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
            this.f20097e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20097e.t == null) {
                return;
            }
            c.a.e.e.m.g.a(this.f20097e.t, this.f20097e.f20065a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes3.dex */
    public class l implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20098a;

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
            this.f20098a = aVar;
        }

        @Override // c.a.p0.s.s.b.c
        public void a(c.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f20098a.f20065a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.f20098a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.f20098a.f20065a.getPageContext().getPageActivity(), this.f20098a.H);
                    new c.a.q0.i2.k.e.b(this.f20098a.f20065a.getPbModel().e1(), this.f20098a.H, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f20098a.f20065a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    a aVar2 = this.f20098a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.f20098a.f20065a.getPageContext().getPageActivity(), this.f20098a.H);
                    new c.a.q0.i2.k.e.b(this.f20098a.f20065a.getPbModel().e1(), this.f20098a.H, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    a aVar3 = this.f20098a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.f20098a.f20065a.getPageContext().getPageActivity(), this.f20098a.H);
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
        public final /* synthetic */ PopupDialog f20099e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f20100f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f20101g;

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
            this.f20101g = aVar;
            this.f20099e = popupDialog;
            this.f20100f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f20101g.f20065a.getPbModel().b1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // c.a.p0.s.s.i.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            boolean r2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, iVar, i2, view) != null) {
                return;
            }
            this.f20099e.dismiss();
            int i3 = 3;
            if (this.f20101g.f20065a.getPbModel().b1() != 1 || i2 != 1) {
                if (this.f20101g.f20065a.getPbModel().b1() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (this.f20101g.f20065a.getPbModel().b1() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f20100f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f20101g.f20065a.getPbModel().O0().f19067f != null && this.f20101g.f20065a.getPbModel().O0().f19067f.size() > i2) {
                    i2 = this.f20101g.f20065a.getPbModel().O0().f19067f.get(i2).sort_type.intValue();
                }
                r2 = this.f20101g.f20065a.getPbModel().r2(i2);
                this.f20100f.setTag(Integer.valueOf(this.f20101g.f20065a.getPbModel().a1()));
                if (r2) {
                    return;
                }
                this.f20101g.f20065a.setIsLoading(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f20100f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
            if (this.f20101g.f20065a.getPbModel().O0().f19067f != null) {
                i2 = this.f20101g.f20065a.getPbModel().O0().f19067f.get(i2).sort_type.intValue();
            }
            r2 = this.f20101g.f20065a.getPbModel().r2(i2);
            this.f20100f.setTag(Integer.valueOf(this.f20101g.f20065a.getPbModel().a1()));
            if (r2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f20102e;

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
            this.f20102e = metaData;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f20102e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f20103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20104f;

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
            this.f20104f = aVar;
            this.f20103e = metaData;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f20103e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f20104f.f20065a.getAttentionModel() != null) {
                    this.f20104f.f20065a.getAttentionModel().m(!this.f20103e.hadConcerned(), this.f20103e.getPortrait(), this.f20103e.getUserId(), this.f20103e.isGod(), "6", this.f20104f.f20065a.getPageContext().getUniqueId(), this.f20104f.f20065a.getPbModel().getForumId(), "0");
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f20105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20106f;

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
            this.f20106f = aVar;
            this.f20105e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f20106f.B0();
                MessageManager.getInstance().sendMessage(this.f20105e);
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ b.c f20107e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20108f;

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
            this.f20108f = aVar;
            this.f20107e = cVar;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                this.f20108f.f20068d.dismiss();
                this.f20107e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20109e;

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
            this.f20109e = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f20109e.n = (String) compoundButton.getTag();
                if (this.f20109e.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f20109e.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f20109e.n != null && !str.equals(this.f20109e.n)) {
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
        public final /* synthetic */ a f20110e;

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
            this.f20110e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f20110e.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20111e;

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
            this.f20111e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f20111e.f20071g instanceof Dialog)) {
                c.a.e.e.m.g.b(this.f20111e.f20071g, this.f20111e.f20065a.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements PbFragment.z2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20112a;

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
            this.f20112a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.z2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f20112a.f20065a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f20112a.f20065a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f20112a.f20065a.getPageContext().getPageActivity(), this.f20112a.f20065a.getPbModel().O0().m().getId(), this.f20112a.f20065a.getPbModel().O0().m().getName(), this.f20112a.f20065a.getPbModel().O0().O().f0(), String.valueOf(this.f20112a.f20065a.getPbModel().O0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20113e;

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
            this.f20113e = aVar;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f20113e.f20066b != null) {
                    this.f20113e.f20066b.dismiss();
                }
                this.f20113e.M0(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f20113e.n0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f20113e.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        this.f20113e.n0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        this.f20113e.n0(view5);
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
                        if (this.f20113e.A == null || TextUtils.isEmpty(this.f20113e.B)) {
                            return;
                        }
                        if (this.f20113e.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f20113e.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f12810a = this.f20113e.B;
                            String str = "";
                            if (this.f20113e.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f20113e.C.memeInfo.pck_id;
                            }
                            aVar.f12811b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f20113e.A = null;
                        this.f20113e.B = null;
                        return;
                    case 2:
                        if (this.f20113e.A == null || TextUtils.isEmpty(this.f20113e.B)) {
                            return;
                        }
                        if (this.f20113e.F == null) {
                            this.f20113e.F = new PermissionJudgePolicy();
                        }
                        this.f20113e.F.clearRequestPermissionList();
                        this.f20113e.F.appendRequestPermission(this.f20113e.f20065a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f20113e.F.startRequestPermission(this.f20113e.f20065a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f20113e.z == null) {
                            a aVar2 = this.f20113e;
                            aVar2.z = new u0(aVar2.f20065a.getPageContext());
                        }
                        this.f20113e.z.b(this.f20113e.B, this.f20113e.A.n());
                        this.f20113e.A = null;
                        this.f20113e.B = null;
                        return;
                    case 3:
                        a aVar3 = this.f20113e;
                        PostData postData = aVar3.G;
                        if (postData != null) {
                            postData.h0(aVar3.f20065a.getPageContext().getPageActivity());
                            this.f20113e.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f20113e.f20065a.checkUpIsLogin()) {
                            this.f20113e.d0(view);
                            if (this.f20113e.f20065a.getPbModel().O0().O() == null || this.f20113e.f20065a.getPbModel().O0().O().J() == null || this.f20113e.f20065a.getPbModel().O0().O().J().getUserId() == null || this.f20113e.f20065a.getMarkModel() == null) {
                                return;
                            }
                            a aVar4 = this.f20113e;
                            int S = aVar4.S(aVar4.f20065a.getPbModel().O0());
                            c2 O = this.f20113e.f20065a.getPbModel().O0().O();
                            if (O.J1()) {
                                i3 = 2;
                            } else if (O.M1()) {
                                i3 = 3;
                            } else if (!O.K1()) {
                                i3 = O.L1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f20113e.f20065a.getPbModel().e1()).param("obj_locate", 2).param("obj_id", this.f20113e.f20065a.getPbModel().O0().O().J().getUserId()).param("obj_type", !this.f20113e.f20065a.getMarkModel().e()).param("obj_source", S).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.e.e.p.j.z()) {
                            this.f20113e.f20065a.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f20113e.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f20113e.B(sparseArray2);
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
                            AbsVideoPbFragment absVideoPbFragment = this.f20113e.f20065a;
                            if (absVideoPbFragment == null || absVideoPbFragment.getPbActivity() == null) {
                                return;
                            }
                            boolean isHost = this.f20113e.f20065a.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f20113e.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f20113e.i0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f20113e.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f20113e.g0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.e.e.p.j.z()) {
                            this.f20113e.f20065a.showToast(R.string.network_not_available);
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
                                this.f20113e.g0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f20113e.B(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f20113e.l0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.f20113e.f20065a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            c.a.p0.k0.c f2 = TbPageExtraHelper.f(view);
                            if (f2 != null) {
                                postData2.q().objSource = f2.a();
                            }
                            this.f20113e.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.f20113e.f20065a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.getPbModel() == null || this.f20113e.f20065a.getPbModel().O0() == null || !ViewHelper.checkUpIsLogin(this.f20113e.f20065a.getContext()) || this.f20113e.f20065a.getPbActivity() == null) {
                            return;
                        }
                        this.f20113e.f20065a.getPbActivity().showBlockDialog(c.a.q0.s3.a.b(view));
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
        public final /* synthetic */ SparseArray f20114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f20115f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f20116g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f20117h;

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
            this.f20117h = aVar;
            this.f20114e = sparseArray;
            this.f20115f = i2;
            this.f20116g = z;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f20117h.f20065a.deleteThreadDirect(((Integer) this.f20114e.get(R.id.tag_del_post_type)).intValue(), (String) this.f20114e.get(R.id.tag_del_post_id), this.f20115f, this.f20116g);
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-964751778, "Lc/a/q0/i2/o/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-964751778, "Lc/a/q0/i2/o/g/a;");
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
        this.f20068d = null;
        this.f20069e = null;
        this.f20070f = null;
        this.f20071g = null;
        this.f20072h = null;
        this.f20073i = null;
        this.f20074j = null;
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
        this.L = c.a.p0.b.d.x0();
        this.M = new u(this);
        this.N = new x(this);
        this.P = new C0945a(this);
        this.f20065a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        c.a.q0.i2.k.f.a aVar = new c.a.q0.i2.k.f.a(this.f20065a.getContext());
        this.x = aVar;
        aVar.b(this.f20065a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f20065a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new n(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new o(this, metaData));
        aVar.create(this.f20065a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.e.e.m.b.f(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.e.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
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
                this.r = new c.a.p0.s.f0.a(this.f20065a.getPageContext());
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
            this.J = new c.a.p0.s.b0.a();
        }
        if (this.K == null) {
            c.a.q0.i3.i0.e eVar = new c.a.q0.i3.i0.e();
            this.K = eVar;
            eVar.f20276a = this.f20065a.getUniqueId();
        }
        c.a.p0.s.q.f fVar = new c.a.p0.s.q.f();
        fVar.f14219b = 5;
        fVar.f14225h = 8;
        fVar.f14224g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.f20065a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.getPbModel() != null) {
            fVar.f14223f = this.f20065a.getPbModel().N0();
        }
        fVar.f14218a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f14226i = 0;
                this.J.c(agreeData, i2, this.f20065a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.f20065a;
                if (absVideoPbFragment != null || absVideoPbFragment.getPbModel() == null || this.f20065a.getPbModel().O0() == null) {
                    return;
                }
                this.J.b(this.f20065a.getPbActivity(), fVar, agreeData, this.f20065a.getPbModel().O0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f14226i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f14226i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.f20065a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.f20065a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, c.a.q0.i.i iVar, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), iVar, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.f20065a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new c.a.q0.i.j(this.f20065a.getPageContext(), this.f20065a.getView(), iVar, userData);
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
        this.w.E(new String[]{this.f20065a.getString(R.string.delete_thread_reason_1), this.f20065a.getString(R.string.delete_thread_reason_2), this.f20065a.getString(R.string.delete_thread_reason_3), this.f20065a.getString(R.string.delete_thread_reason_4), this.f20065a.getString(R.string.delete_thread_reason_5)});
        this.w.D(x0Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f20065a.getPageContext().getPageActivity();
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
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f20065a.getPageContext().getPageActivity());
            aVar.setMessage(this.f20065a.getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new b0(this));
            aVar.setNegativeButton(R.string.cancel, new c0(this));
            aVar.create(this.f20065a.getPageContext()).show();
        }
    }

    public final boolean E(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        List<c.a.p0.s.s.f> b2;
        c.a.p0.s.s.f fVar;
        c.a.p0.s.s.f fVar2;
        c.a.p0.s.s.f fVar3;
        c.a.p0.s.s.f fVar4;
        c.a.e.l.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f20065a;
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
            if (postData == null || this.f20065a.getMarkModel() == null) {
                return true;
            }
            boolean z4 = this.f20065a.getMarkModel().e() && this.G.E() != null && this.G.E().equals(this.f20065a.getPbModel().J0());
            boolean z5 = this.f20065a.getPbModel().O0() != null && this.f20065a.getPbModel().O0().f0();
            if (this.f20067c == null) {
                c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f20065a.getContext());
                this.f20067c = iVar;
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
                arrayList.add(new c.a.p0.s.s.f(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.f20067c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
            }
            if (z7) {
                arrayList.add(new c.a.p0.s.s.f(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.f20067c));
            }
            if (!z6 && !z7) {
                c.a.p0.s.s.f fVar5 = new c.a.p0.s.s.f(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.f20067c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.G);
                fVar5.f14463d.setTag(sparseArray3);
                arrayList.add(fVar5);
            }
            if (!booleanValue && !z5) {
                if (z4) {
                    fVar4 = new c.a.p0.s.s.f(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.f20067c);
                } else {
                    fVar4 = new c.a.p0.s.s.f(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.f20067c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.G);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                fVar4.f14463d.setTag(sparseArray4);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    c.a.p0.s.s.f fVar6 = new c.a.p0.s.s.f(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.f20067c);
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
                    fVar6.f14463d.setTag(sparseArray5);
                    arrayList.add(fVar6);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z5) {
                        c.a.p0.s.s.f fVar7 = new c.a.p0.s.s.f(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f20067c);
                        fVar7.f14463d.setTag(str);
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
                        fVar2 = new c.a.p0.s.s.f(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f20067c);
                        fVar2.f14463d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        fVar2 = null;
                    }
                    fVar = new c.a.p0.s.s.f(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.f20067c);
                    fVar.f14463d.setTag(sparseArray6);
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
                    if (this.f20065a.getPbModel().O0().V() == 1002 && !booleanValue2) {
                        fVar3 = new c.a.p0.s.s.f(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f20067c);
                    } else {
                        fVar3 = new c.a.p0.s.s.f(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f20067c);
                    }
                    fVar3.f14463d.setTag(sparseArray7);
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
                c.a.q0.i2.k.e.d1.a.a(arrayList, this.f20067c, this.G, this.f20065a.getPbModel());
            }
            if (c.a.p0.b.d.O()) {
                b2 = c.a.q0.i2.k.e.d1.a.c(arrayList, this.G.q(), sparseArray, this.f20067c);
            } else {
                b2 = c.a.q0.i2.k.e.d1.a.b(arrayList, this.G.q(), sparseArray, this.f20067c);
            }
            c.a.q0.i2.k.e.d1.a.k(b2, this.O);
            c.a.q0.i2.k.e.d1.a.e(b2);
            this.f20067c.o(c.a.q0.i2.k.e.d1.a.f(this.G));
            if (c.a.p0.b.d.O()) {
                this.f20067c.l(b2, false);
            } else {
                this.f20067c.l(b2, true);
            }
            PopupDialog popupDialog = new PopupDialog(this.f20065a.getPageContext(), this.f20067c);
            this.f20066b = popupDialog;
            popupDialog.showDialog();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f20065a.getPbModel().e1()).param("fid", this.f20065a.getPbModel().getForumId()).param("uid", this.f20065a.getPbModel().O0().O().J().getUserId()).param("post_id", this.f20065a.getPbModel().y()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.f20066b;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.f20066b.dismiss();
                this.f20066b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f20065a.getBaseFragmentActivity());
                iVar.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.p0.s.s.f(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), iVar));
                }
                if (z2) {
                    arrayList.add(new c.a.p0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), iVar));
                } else {
                    arrayList.add(new c.a.p0.s.s.f(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), iVar));
                }
                iVar.k(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(this.f20065a.getPageContext(), iVar);
                this.f20066b = popupDialog2;
                popupDialog2.showDialog();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.f20065a.hideEditTool();
            PopupDialog popupDialog = this.f20066b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            this.f20065a.hideKeyBroad();
            K();
        }
    }

    public void F0(b.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            PopupDialog popupDialog = this.f20068d;
            if (popupDialog != null) {
                popupDialog.dismiss();
                this.f20068d = null;
            }
            c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f20065a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.f20065a.getPbModel().O0() != null && this.f20065a.getPbModel().O0().O() != null && !this.f20065a.getPbModel().O0().O().N1()) {
                arrayList.add(new c.a.p0.s.s.f(0, this.f20065a.getPageContext().getString(R.string.save_to_emotion), iVar));
            }
            if (!z2) {
                arrayList.add(new c.a.p0.s.s.f(1, this.f20065a.getPageContext().getString(R.string.save_to_local), iVar));
            }
            iVar.k(arrayList);
            iVar.n(new s(this, cVar));
            PopupDialog popupDialog2 = new PopupDialog(this.f20065a.getPageContext(), iVar);
            this.f20068d = popupDialog2;
            popupDialog2.showDialog();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.f20065a.hideEditTool();
            PopupDialog popupDialog = this.f20066b;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            c.a.p0.s.s.c cVar = this.f20072h;
            if (cVar != null) {
                cVar.d();
                this.f20072h = null;
            }
            if (this.f20065a.getPbModel() == null) {
                return;
            }
            ArrayList<c.a.p0.s.s.k> arrayList = new ArrayList<>();
            arrayList.add(new c.a.p0.s.s.k(this.f20065a.getContext().getString(R.string.all_person), "", this.f20065a.getPbModel().X0() == 1, Integer.toString(1)));
            arrayList.add(new c.a.p0.s.s.k(this.f20065a.getContext().getString(R.string.my_fans), "", this.f20065a.getPbModel().X0() == 2, Integer.toString(5)));
            arrayList.add(new c.a.p0.s.s.k(this.f20065a.getContext().getString(R.string.my_attentions), "", this.f20065a.getPbModel().X0() == 3, Integer.toString(6)));
            arrayList.add(new c.a.p0.s.s.k(this.f20065a.getContext().getString(R.string.myself_only), "", this.f20065a.getPbModel().X0() == 4, Integer.toString(7)));
            c.a.p0.s.s.c cVar2 = new c.a.p0.s.s.c(this.f20065a.getPageContext());
            cVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.f20072h = cVar2;
            cVar2.k(arrayList, onItemClickListener);
            cVar2.c();
            this.f20072h.n();
        }
    }

    public void H() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (popupDialog = this.f20066b) == null) {
            return;
        }
        popupDialog.dismiss();
    }

    public void H0(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, d0Var) == null) || this.f20065a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.f20065a;
        this.u = new c.a.q0.i2.k.e.c0(absVideoPbFragment, absVideoPbFragment.listener);
        AlertDialog create = new AlertDialog.Builder(this.f20065a.getContext(), R.style.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        c.a.e.e.m.g.i(this.t, this.f20065a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.r());
        this.u.O(d0Var == null ? false : d0Var.f19343a);
        this.u.v(d0Var == null ? false : d0Var.n);
        this.u.x(d0Var == null ? false : d0Var.f19347e);
        this.u.D(d0Var == null ? false : d0Var.f19351i);
        this.u.y(d0Var == null ? false : d0Var.f19348f);
        this.u.Q(d0Var != null ? d0Var.f19345c : true);
        this.u.N(d0Var == null ? false : d0Var.k);
        this.u.z(d0Var == null ? false : d0Var.l, d0Var.t);
        if (d0Var == null) {
            this.u.K(false, false);
            this.u.J(false, false);
        } else {
            this.u.K(d0Var.f19349g, d0Var.s);
            this.u.J(d0Var.f19350h, d0Var.r);
        }
        boolean z2 = d0Var == null ? false : d0Var.q;
        boolean z3 = d0Var == null ? false : d0Var.o;
        boolean z4 = d0Var == null ? false : d0Var.f19346d;
        boolean z5 = d0Var == null ? false : d0Var.f19344b;
        boolean z6 = d0Var == null ? false : d0Var.p;
        boolean z7 = d0Var == null ? false : d0Var.f19352j;
        boolean z8 = d0Var == null ? false : d0Var.m;
        this.u.A(z4, z3);
        this.u.P(z5, z2);
        this.u.L(z7, z6);
        this.u.S(z8);
        if (d0Var != null) {
            c.a.q0.i2.k.e.c0 c0Var = this.u;
            boolean z9 = d0Var.u;
            c0Var.w = z9;
            if (z9) {
                c0Var.f().setText(R.string.report_text);
                this.u.y(false);
            }
        }
        this.u.w(d0Var != null ? d0Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f20065a.getPbModel() != null && this.f20065a.getPbModel().O0() != null && this.f20065a.getPbModel().O0().Q() != null && this.f20065a.getPbModel().O0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
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

    public final void I0(c.a.p0.s.s.a aVar, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, aVar, i2) == null) || (absVideoPbFragment = this.f20065a) == null || aVar == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new c.a.q0.i.g(this.f20065a.getPageContext(), this.f20065a.getView());
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
        this.v.y(new String[]{this.f20065a.getString(R.string.delete_thread_reason_1), this.f20065a.getString(R.string.delete_thread_reason_2), this.f20065a.getString(R.string.delete_thread_reason_3), this.f20065a.getString(R.string.delete_thread_reason_4), this.f20065a.getString(R.string.delete_thread_reason_5)});
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
        c.a.e.e.m.g.a(alertDialog, this.f20065a.getPageContext().getPageActivity());
    }

    public void J0(View view) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view) == null) || (absVideoPbFragment = this.f20065a) == null || absVideoPbFragment.getPbModel() == null) {
            return;
        }
        PopupDialog popupDialog = new PopupDialog(this.f20065a.getPageContext());
        if (this.f20065a.getPbModel().O0().f19067f == null || this.f20065a.getPbModel().O0().f19067f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
        } else {
            strArr = new String[this.f20065a.getPbModel().O0().f19067f.size()];
            for (int i2 = 0; i2 < this.f20065a.getPbModel().O0().f19067f.size(); i2++) {
                strArr[i2] = this.f20065a.getPbModel().O0().f19067f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
            }
        }
        popupDialog.setDefaultContentView(null, strArr, new m(this, popupDialog, view));
        popupDialog.showDialog();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.p0.s.s.a aVar = this.f20069e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f20070f;
            if (dialog != null) {
                c.a.e.e.m.g.b(dialog, this.f20065a.getPageContext());
            }
            Dialog dialog2 = this.f20071g;
            if (dialog2 != null) {
                c.a.e.e.m.g.b(dialog2, this.f20065a.getPageContext());
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
            AbsVideoPbFragment absVideoPbFragment = this.f20065a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f20065a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new p(this));
            aVar.create(this.f20065a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f20065a.getPbModel() == null || this.f20065a.getPbModel().O0() == null) {
                return null;
            }
            return this.f20065a.getPbModel().O0().d();
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
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f20065a.getBaseFragmentActivity());
            if (c.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new q(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new r(this));
            aVar.create(this.f20065a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view = this.f20073i;
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
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f20065a.getPbModel().e1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.q0.i2.k.e.d1.a.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        c.a.q0.i2.k.e.c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (c0Var = this.u) == null) {
            return;
        }
        c0Var.u();
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

    public c.a.q0.i2.k.e.c0 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (c.a.q0.i2.k.e.c0) invokeV.objValue;
    }

    public c.a.p0.s.s.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (c.a.p0.s.s.b) invokeV.objValue;
    }

    public int S(c.a.q0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, eVar)) == null) {
            if (eVar == null || eVar.O() == null) {
                return 0;
            }
            if (eVar.O().m1() == 0) {
                return 1;
            }
            if (eVar.O().m1() == 54) {
                return 2;
            }
            return eVar.O().m1() == 40 ? 3 : 4;
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
            if (this.f20065a.getPbModel() != null && this.f20065a.getPbModel().O0() != null && this.f20065a.getPbModel().O0().f0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.f20065a.getPbModel().e1(), str);
                c2 O = this.f20065a.getPbModel().O0().O();
                if (O.J1()) {
                    format = format + "&channelid=33833";
                } else if (O.O1()) {
                    format = format + "&channelid=33842";
                } else if (O.M1()) {
                    format = format + "&channelid=33840";
                }
                c0(format);
                return;
            }
            this.x.a(str);
        }
    }

    public void V() {
        c.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new c.a.p0.s.s.b(this.f20065a.getPageContext().getPageActivity());
            String[] strArr = {this.f20065a.getPageContext().getString(R.string.call_phone), this.f20065a.getPageContext().getString(R.string.sms_phone), this.f20065a.getPageContext().getString(R.string.search_in_baidu)};
            c.a.p0.s.s.b bVar = this.s;
            bVar.j(strArr, new l(this));
            bVar.g(b.C0697b.f14441a);
            bVar.h(17);
            bVar.c(this.f20065a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? c.a.q0.i2.k.e.d1.a.h(this.f20065a.getPbModel()) : invokeV.booleanValue;
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
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f20065a.getPbModel().O0().U() != null && (forumToolAuth = this.f20065a.getPbModel().O0().U().getForumToolAuth()) != null) {
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
            if (this.f20065a.getPbModel() != null && this.f20065a.getPbModel().O0() != null) {
                return ((this.f20065a.getPbModel().O0().V() != 0) || this.f20065a.getPbModel().O0().O() == null || this.f20065a.getPbModel().O0().O().J() == null || TextUtils.equals(this.f20065a.getPbModel().O0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f20065a.getContext(), "", str, true);
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
        if (postData.E() != null && postData.E().equals(this.f20065a.getPbModel().J0())) {
            z2 = true;
        }
        MarkData I0 = this.f20065a.getPbModel().I0(postData);
        if (this.f20065a.getPbModel().O0() != null && this.f20065a.getPbModel().O0().f0()) {
            AbsVideoPbFragment absVideoPbFragment = this.f20065a;
            PostData firstPostData = absVideoPbFragment.getFirstPostData(absVideoPbFragment.getPbModel().O0());
            if (firstPostData != null) {
                I0 = this.f20065a.getPbModel().I0(firstPostData);
            }
        }
        if (I0 == null) {
            return;
        }
        this.f20065a.setPreLoad();
        if (this.f20065a.getMarkModel() != null) {
            this.f20065a.getMarkModel().i(I0);
            if (!z2) {
                this.f20065a.getMarkModel().a();
            } else {
                this.f20065a.getMarkModel().d();
            }
        }
    }

    public void f0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.f20073i == null) {
                this.f20073i = LayoutInflater.from(this.f20065a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f20065a.getBaseFragmentActivity().getLayoutMode().j(this.f20073i);
            if (this.f20071g == null) {
                Dialog dialog = new Dialog(this.f20065a.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.f20071g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f20071g.setCancelable(true);
                this.o = (ScrollView) this.f20073i.findViewById(R.id.good_scroll);
                this.f20071g.setContentView(this.f20073i);
                WindowManager.LayoutParams attributes = this.f20071g.getWindow().getAttributes();
                attributes.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.f20071g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.f20074j = (LinearLayout) this.f20073i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.f20073i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.f20073i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.f20065a.getListener());
            }
            this.f20074j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.f20065a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.f20074j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.f20065a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.f20074j.addView(view);
                        this.f20074j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20065a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20065a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = c.a.e.e.p.l.e(this.f20065a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.f20074j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.f20074j);
                }
            }
            c.a.e.e.m.g.j(this.f20071g, this.f20065a.getPageContext());
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
            this.f20069e = new c.a.p0.s.s.a(this.f20065a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f20069e.setMessageId(i4);
            } else {
                this.f20069e.setOnlyMessageShowCenter(false);
                this.f20069e.setMessage(str2);
            }
            this.f20069e.setYesButtonTag(sparseArray);
            this.f20069e.setPositiveButton(R.string.dialog_ok, new b(this));
            this.f20069e.setNegativeButton(R.string.dialog_cancel, new c(this));
            this.f20069e.setCancelable(true);
            this.f20069e.create(this.f20065a.getPageContext());
            if (z3) {
                v0(sparseArray);
            } else if (z2) {
                v0(sparseArray);
            } else if (q0()) {
                c.a.q0.i.i iVar = new c.a.q0.i.i(this.f20065a.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20065a.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20065a.getPbModel().O0().p().has_forum_rule.intValue());
                iVar.i(this.f20065a.getPbModel().O0().m().getId(), this.f20065a.getPbModel().O0().m().getName());
                iVar.h(this.f20065a.getPbModel().O0().m().getImage_url());
                iVar.j(this.f20065a.getPbModel().O0().m().getUser_level());
                C0(sparseArray, i2, iVar, this.f20065a.getPbModel().O0().U(), false);
            } else {
                I0(this.f20069e, i2);
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
        c.a.p0.s.s.f fVar;
        c.a.p0.s.s.f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f20065a.getContext());
            iVar.q(this.f20065a.getString(R.string.bar_manager));
            iVar.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    fVar2 = new c.a.p0.s.s.f(10, this.f20065a.getString(R.string.delete_post), iVar);
                } else {
                    fVar2 = new c.a.p0.s.s.f(10, this.f20065a.getString(R.string.delete), iVar);
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
                fVar2.f14463d.setTag(sparseArray2);
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
                c.a.p0.s.s.f fVar3 = new c.a.p0.s.s.f(11, this.f20065a.getString(R.string.forbidden_person), iVar);
                fVar3.f14463d.setTag(sparseArray3);
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
                    fVar = new c.a.p0.s.s.f(12, this.f20065a.getString(R.string.un_mute), iVar);
                } else {
                    fVar = new c.a.p0.s.s.f(12, this.f20065a.getString(R.string.mute), iVar);
                }
                fVar.f14463d.setTag(sparseArray4);
                arrayList.add(fVar);
            }
            iVar.k(arrayList);
            PopupDialog popupDialog = this.q;
            if (popupDialog == null) {
                this.q = new PopupDialog(this.f20065a.getPageContext(), iVar);
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
        c.a.q0.i2.h.e O0;
        c2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.f20065a) == null || absVideoPbFragment.getPbModel() == null || this.f20065a.getPbModel().O0() == null || (O = (O0 = this.f20065a.getPbModel().O0()).O()) == null || O.J() == null) {
            return;
        }
        this.f20065a.hideEditTool();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        d0 d0Var = new d0();
        int V = this.f20065a.getPbModel().O0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            d0Var.f19349g = false;
        } else {
            d0Var.f19349g = true;
            d0Var.s = O.p0() == 1;
        }
        if (Z(V)) {
            d0Var.f19350h = true;
            d0Var.r = O.o0() == 1;
        } else {
            d0Var.f19350h = false;
        }
        if (V == 1002 && !equals) {
            d0Var.u = true;
        }
        d0Var.n = y0(O.P1(), O0.h0(), equals, V, O.E2(), O.o2());
        d0Var.f19347e = u0(equals, O0.h0());
        d0Var.f19351i = z0();
        d0Var.f19348f = x0(equals);
        d0Var.k = equals && O0.U() != null && O0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            d0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().c();
        }
        d0Var.t = equals;
        d0Var.q = this.f20065a.getPbModel().c1();
        d0Var.f19344b = true;
        d0Var.f19343a = b0(equals);
        d0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        d0Var.f19352j = true;
        d0Var.o = this.f20065a.getPbModel().s0();
        d0Var.f19346d = true;
        if (O.o1() == null) {
            d0Var.f19345c = true;
        } else {
            d0Var.f19345c = false;
        }
        if (O0.f0()) {
            d0Var.f19344b = false;
            d0Var.f19346d = false;
            d0Var.f19345c = false;
            d0Var.f19349g = false;
            d0Var.f19350h = false;
        }
        d0Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !O0.f0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.f20065a;
        if (absVideoPbFragment2.getFirstPostData(absVideoPbFragment2.getPbModel().O0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.f20065a;
            d0Var.w = absVideoPbFragment3.getFirstPostData(absVideoPbFragment3.getPbModel().O0()).S;
        }
        if (c.a.p0.e1.b.e.d()) {
            d0Var.f19346d = false;
            d0Var.f19344b = false;
            d0Var.f19345c = false;
        }
        if (O.P1()) {
            d0Var.n = false;
            d0Var.f19349g = false;
            d0Var.f19350h = false;
        }
        H0(d0Var);
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
            AbsVideoPbFragment absVideoPbFragment = this.f20065a;
            return (absVideoPbFragment == null || absVideoPbFragment.getPbModel().O0().m().getDeletedReasonInfo() == null || 1 != this.f20065a.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.f20065a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.shield, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.p0.s.s.l lVar = new c.a.p0.s.s.l(this.f20065a.getPbActivity());
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
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.f20065a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        c.a.q0.i.i iVar = new c.a.q0.i.i(this.f20065a.getPbModel().O0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f20065a.getPbModel().O0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f20065a.getPbModel().O0().p().has_forum_rule.intValue());
        iVar.i(this.f20065a.getPbModel().O0().m().getId(), this.f20065a.getPbModel().O0().m().getName());
        iVar.h(this.f20065a.getPbModel().O0().m().getImage_url());
        iVar.j(this.f20065a.getPbModel().O0().m().getUser_level());
        C0(sparseArray, i2, iVar, this.f20065a.getPbModel().O0().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            c.a.q0.i2.k.e.d1.a.d(this.f20065a.getActivity(), this.f20065a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f20065a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || this.f20065a.getPbModel().O0() == null) {
                return false;
            }
            c.a.q0.i2.h.e O0 = this.f20065a.getPbModel().O0();
            c2 O = O0.O();
            if (O != null) {
                if (O.J1() || O.M1()) {
                    return false;
                }
                if (O.K1() || O.L1()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !v0.isOn()) || this.f20065a.getPbModel().D() || O.E2() || O.o2() || z3) {
                return false;
            }
            if (O0.m() == null || !O0.m().isBlockBawuDelete) {
                if (O0.V() != 0) {
                    return O0.V() != 3;
                }
                List<y1> q2 = O0.q();
                if (ListUtils.getCount(q2) > 0) {
                    for (y1 y1Var : q2) {
                        if (y1Var != null && (e0Var = y1Var.f14404g) != null && e0Var.f14201a && !e0Var.f14203c && ((i2 = e0Var.f14202b) == 1 || i2 == 2)) {
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
        if (!(interceptable == null || interceptable.invokeL(1048636, this, sparseArray) == null) || this.f20065a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a(R.string.delete, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
        c.a.p0.s.s.l lVar = new c.a.p0.s.s.l(this.f20065a.getPbActivity());
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
        c.a.p0.s.s.f fVar;
        c.a.p0.s.s.f fVar2;
        c.a.p0.s.s.f fVar3;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.f20065a) == null || absVideoPbFragment.getPbModel() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.f20067c == null) {
            c.a.p0.s.s.i iVar = new c.a.p0.s.s.i(this.f20065a.getContext());
            this.f20067c = iVar;
            iVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.f20065a.getPbModel().O0() != null && this.f20065a.getPbModel().O0().f0();
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
                    absVideoPbFragment2 = this.f20065a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.f20065a;
                    i2 = R.string.action_dislike;
                }
                c.a.p0.s.s.f fVar4 = new c.a.p0.s.s.f(8, absVideoPbFragment2.getString(i2), this.f20067c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                fVar4.f14463d.setTag(sparseArray2);
                arrayList.add(fVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    c.a.p0.s.s.f fVar5 = new c.a.p0.s.s.f(5, this.f20065a.getString(R.string.mute_option), this.f20067c);
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
                    fVar5.f14463d.setTag(sparseArray3);
                    arrayList.add(fVar5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        c.a.p0.s.s.f fVar6 = new c.a.p0.s.s.f(5, this.f20065a.getString(R.string.report_text), this.f20067c);
                        fVar6.f14463d.setTag(str);
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
                        fVar2 = new c.a.p0.s.s.f(6, this.f20065a.getString(R.string.delete), this.f20067c);
                        fVar2.f14463d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        fVar2 = null;
                    }
                    fVar = new c.a.p0.s.s.f(7, this.f20065a.getString(R.string.bar_manager), this.f20067c);
                    fVar.f14463d.setTag(sparseArray4);
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
                    if (this.f20065a.getPbModel().O0().V() == 1002 && !booleanValue) {
                        fVar3 = new c.a.p0.s.s.f(6, this.f20065a.getString(R.string.report_text), this.f20067c);
                    } else {
                        fVar3 = new c.a.p0.s.s.f(6, this.f20065a.getString(R.string.delete), this.f20067c);
                    }
                    fVar3.f14463d.setTag(sparseArray5);
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
                    arrayList.add(new c.a.p0.s.s.f(9, TbadkCoreApplication.getInst().getString(R.string.block_user), this.f20067c));
                }
            }
            this.f20067c.k(arrayList);
            PopupDialog popupDialog = new PopupDialog(this.f20065a.getPageContext(), this.f20067c);
            this.f20066b = popupDialog;
            popupDialog.showDialog();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.f20065a) == null || absVideoPbFragment.getPbModel() == null || this.f20065a.getPbModel().O0() == null || (this.f20065a.getPbModel().O0().m() != null && this.f20065a.getPbModel().O0().m().isBlockBawuDelete)) {
                return false;
            }
            c.a.q0.i2.h.e O0 = this.f20065a.getPbModel().O0();
            return ((O0.O() != null && O0.O().J() != null && O0.O().J().isForumBusinessAccount() && !v0.isOn()) || this.f20065a.getPbModel().D() || this.f20065a.getPbModel().O0().V() == 0 || this.f20065a.getPbModel().O0().V() == 3) ? false : true;
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
            AbsVideoPbFragment absVideoPbFragment = this.f20065a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPbModel() == null || !this.f20065a.getPbModel().c1()) {
                return false;
            }
            return this.f20065a.getPbModel().M0() == null || this.f20065a.getPbModel().M0().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
