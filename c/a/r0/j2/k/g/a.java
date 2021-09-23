package c.a.r0.j2.k.g;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.n0;
import c.a.q0.s.f0.f;
import c.a.q0.s.q.x0;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.r0.a0.m;
import c.a.r0.i.g;
import c.a.r0.i.j;
import c.a.r0.j2.h.r;
import c.a.r0.j2.i.c;
import c.a.r0.j2.k.g.b;
import c.a.r0.j3.z;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbMoreDialog;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class a implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int s0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public c.a.q0.s.f0.a B;
    public c.a.r0.j2.k.g.d C;
    public View D;
    public MorePopupWindow E;
    public View F;
    public c.a.q0.s.s.b G;
    public View H;
    public BlankView I;
    public View J;
    public Dialog K;
    public c.a.q0.s.s.a L;
    public View.OnClickListener M;
    public c.a.q0.s.s.b N;
    public boolean O;
    public ProgressBar P;
    public NewSubPbActivity.r0 Q;
    public NewSubPbActivity.r0 R;
    public c.a.q0.x.w.h S;
    public int T;
    public ArrayList<PostData> U;
    public r V;
    public TextView W;
    public RelativeLayout X;
    public ImageView Y;
    public ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public SubPbView f20412a;
    public LinearLayout a0;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f20413b;
    public HeadImageView b0;

    /* renamed from: c  reason: collision with root package name */
    public View f20414c;
    public View c0;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f20415d;
    public PbMoreDialog d0;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.j2.p.j f20416e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public NewSubPbActivity f20417f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f20418g;
    public SubPbModel g0;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f20419h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f20420i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f20421j;
    public c.a.r0.i.g j0;
    public NavigationBar k;
    public c.a.r0.i.j k0;
    public ImageView l;
    public c.a.r0.j2.k.g.c l0;
    public View m;
    public boolean m0;
    public TextView n;
    public f.g n0;
    public LinearLayout o;
    public MaskView o0;
    public HeadImageView p;
    public c.a.r0.j2.i.c p0;
    public TextView q;
    public AdapterView.OnItemLongClickListener q0;
    public View r;
    public AdapterView.OnItemClickListener r0;
    public ImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public EllipsizeRichTextView w;
    public TbImageView x;
    public PlayVoiceBntNew y;
    public TextView z;

    /* renamed from: c.a.r0.j2.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0966a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20423f;

        public RunnableC0966a(a aVar, boolean z) {
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
            this.f20423f = aVar;
            this.f20422e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20423f.f20415d.setEnabled(this.f20422e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements z.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20424e;

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
            this.f20424e = aVar;
        }

        @Override // c.a.r0.j3.z.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.f20424e.T();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20425e;

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
                    return;
                }
            }
            this.f20425e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                PostData postData = (PostData) ListUtils.getItem(this.f20425e.U, i2);
                if (view != null && view.getTag() != null) {
                    if (this.f20425e.d0 == null) {
                        this.f20425e.d0 = new PbMoreDialog(this.f20425e.f20417f.getPageContext(), this.f20425e.M);
                    }
                    this.f20425e.d0.showDialog();
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = null;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                    PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                    boolean z = this.f20425e.Z(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                    this.f20425e.d0.confirmItems(sparseArray, this.f20425e.g0.B0(), z, this.f20425e.m0 && postData2 != null && postData2.m0, this.f20425e.g0.j0());
                    if (z) {
                        this.f20425e.d0.getReportTextView().setVisibility(0);
                        this.f20425e.d0.getReportTextView().setTag(postData.E());
                    } else {
                        this.f20425e.d0.getReportTextView().setVisibility(8);
                    }
                    this.f20425e.d0.getMarkTextView().setVisibility(8);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20426e;

        public d(a aVar) {
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
            this.f20426e = aVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && this.f20426e.f20417f != null && ViewHelper.checkUpIsLogin(this.f20426e.f20417f.getPageContext().getPageActivity())) {
                if ((this.f20426e.f20417f.mReplyPrivacyController != null && this.f20426e.g0 != null && this.f20426e.g0.h0() != null && !this.f20426e.f20417f.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.f20426e.g0.h0().replyPrivateFlag)) || this.f20426e.g0 == null || this.f20426e.S == null) {
                    return;
                }
                this.f20426e.K0();
                if (view != null && (view.getTag() instanceof b.a)) {
                    this.f20426e.s();
                    this.f20426e.g0.c1();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(R.id.tag_photo_username);
                    String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                    String str3 = (String) sparseArray.get(R.id.tag_photo_portrait);
                    if (str != null) {
                        this.f20426e.S.X(str2);
                        this.f20426e.S.W(str, str3);
                    }
                }
                this.f20426e.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20427e;

        public e(a aVar) {
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
            this.f20427e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20427e.I == null) {
                return;
            }
            this.f20427e.f20412a.onFinish();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20429f;

        public f(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20429f = aVar;
            this.f20428e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.f20428e + this.f20429f.f20415d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.f20429f.f20415d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20430e;

        public g(a aVar) {
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
            this.f20430e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20430e.g0 == null || !this.f20430e.g0.I0()) {
                    if (this.f20430e.I != null) {
                        this.f20430e.f20412a.onFinish();
                        return;
                    } else {
                        this.f20430e.f20417f.finish();
                        return;
                    }
                }
                this.f20430e.f20417f.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20431a;

        public h(a aVar) {
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
            this.f20431a = aVar;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.r0.j2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                this.f20431a.x(false);
                this.f20431a.x(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20432e;

        public i(a aVar) {
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
            this.f20432e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20432e.K != null && (this.f20432e.K instanceof Dialog)) {
                    c.a.e.e.m.g.b(this.f20432e.K, this.f20432e.f20417f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f20432e.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20433e;

        public j(a aVar) {
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
            this.f20433e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20433e.K != null && (this.f20433e.K instanceof Dialog)) {
                    c.a.e.e.m.g.b(this.f20433e.K, this.f20433e.f20417f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null || this.f20433e.Q == null) {
                    return;
                }
                this.f20433e.Q.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f20434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20435f;

        public k(a aVar, boolean z) {
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
            this.f20435f = aVar;
            this.f20434e = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20435f.K != null && (this.f20435f.K instanceof Dialog)) {
                    c.a.e.e.m.g.b(this.f20435f.K, this.f20435f.f20417f.getPageContext());
                }
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.f20435f.f20417f.handleMuteClick(this.f20434e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f20437f;

        public l(a aVar, SparseArray sparseArray) {
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
            this.f20437f = aVar;
            this.f20436e = sparseArray;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f20437f.R != null) {
                    this.f20437f.R.a(new Object[]{this.f20436e.get(R.id.tag_del_post_id), this.f20436e.get(R.id.tag_manage_user_identity), this.f20436e.get(R.id.tag_del_post_is_self), this.f20436e.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(a aVar) {
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
    public class n implements g.InterfaceC0923g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20438a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20439b;

        public n(a aVar, SparseArray sparseArray) {
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
            this.f20439b = aVar;
            this.f20438a = sparseArray;
        }

        @Override // c.a.r0.i.g.InterfaceC0923g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f20439b.R != null) {
                    this.f20439b.R.a(new Object[]{this.f20438a.get(R.id.tag_del_post_id), this.f20438a.get(R.id.tag_manage_user_identity), this.f20438a.get(R.id.tag_del_post_is_self), this.f20438a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f20440a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20441b;

        public o(a aVar, SparseArray sparseArray) {
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
            this.f20441b = aVar;
            this.f20440a = sparseArray;
        }

        @Override // c.a.r0.i.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.f20441b.R != null) {
                    this.f20441b.R.a(new Object[]{this.f20440a.get(R.id.tag_del_post_id), this.f20440a.get(R.id.tag_manage_user_identity), this.f20440a.get(R.id.tag_del_post_is_self), this.f20440a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1537327170, "Lc/a/r0/j2/k/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1537327170, "Lc/a/r0/j2/k/g/a;");
                return;
            }
        }
        s0 = TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20412a = null;
        this.f20414c = null;
        this.f20415d = null;
        this.f20416e = null;
        this.f20417f = null;
        this.f20418g = null;
        this.f20419h = null;
        this.f20420i = null;
        this.f20421j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.E = null;
        this.G = null;
        this.H = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.O = true;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.e0 = 2;
        this.f0 = 0;
        this.h0 = 0;
        this.i0 = true;
        this.m0 = c.a.q0.b.d.i0();
        this.p0 = new c.a.r0.j2.i.c(new h(this));
        this.q0 = new c(this);
        this.r0 = new d(this);
        this.f20417f = newSubPbActivity;
        this.M = onClickListener;
        this.f20412a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.f20414c = LayoutInflater.from(this.f20417f.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.f20413b = (LinearLayout) this.f20412a.findViewById(R.id.navigation_bar_group);
        this.X = (RelativeLayout) this.f20412a.findViewById(R.id.subpb_editor_tool_comment);
        TextView textView = (TextView) this.f20412a.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.W = textView;
        textView.setOnClickListener(this.M);
        this.Y = (ImageView) this.f20412a.findViewById(R.id.subpb_editor_tool_more_img);
        ImageView imageView = (ImageView) this.f20412a.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.Z = imageView;
        imageView.setOnClickListener(this.M);
        this.Y.setOnClickListener(this.M);
        this.f20418g = (NoNetworkView) this.f20412a.findViewById(R.id.view_no_network);
        V();
        U();
        this.f20421j = (RelativeLayout) this.f20412a.findViewById(R.id.sub_pb_body_layout);
        this.f20415d = (BdTypeListView) this.f20412a.findViewById(R.id.new_sub_pb_list);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f20417f.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.A = threadSkinView;
        this.f20415d.addHeaderView(threadSkinView);
        this.f20415d.addHeaderView(this.f20414c);
        this.J = new TextView(newSubPbActivity.getActivity());
        this.J.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.f20415d.addHeaderView(this.J, 0);
        this.f20412a.setTopView(this.J);
        this.f20412a.setNavigationView(this.f20413b);
        this.f20412a.setListView(this.f20415d);
        this.f20412a.setContentView(this.f20421j);
        c.a.r0.j2.k.g.d dVar = new c.a.r0.j2.k.g.d(this.f20417f.getPageContext());
        this.C = dVar;
        dVar.v();
        this.H = this.C.b();
        this.f20415d.setNextPage(this.C);
        this.C.z(this.M);
        this.f20415d.setOnItemClickListener(this.r0);
        this.f20415d.setOnItemLongClickListener(this.q0);
        this.f20415d.setOnTouchListener(this.p0);
        c.a.r0.j2.p.j jVar = new c.a.r0.j2.p.j(newSubPbActivity.getPageContext());
        this.f20416e = jVar;
        jVar.i();
        this.f20416e.a(this.n0);
        this.f20416e.D(TbadkCoreApplication.getInst().getSkinType());
        this.P = (ProgressBar) this.f20412a.findViewById(R.id.progress);
        this.o0 = (MaskView) this.f20412a.findViewById(R.id.mask_view);
        this.c0 = this.f20412a.findViewById(R.id.view_comment_top_line);
        this.a0 = (LinearLayout) this.f20412a.findViewById(R.id.pb_editer_tool_comment_layout);
        HeadImageView headImageView = (HeadImageView) this.f20412a.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.b0 = headImageView;
        headImageView.setVisibility(0);
        this.b0.setIsRound(true);
        this.b0.setBorderWidth(c.a.e.e.p.l.g(this.f20417f, R.dimen.L_X01));
        this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.b0.setDefaultBgResource(0);
        this.b0.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.b0.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        e0(TbadkCoreApplication.getInst().getSkinType());
        View view = this.f20414c;
        if (view != null) {
            view.setVisibility(4);
        }
        View a2 = c.a.q0.e.c.b().a(this.f20417f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        c.a.r0.j2.k.g.c cVar = new c.a.r0.j2.k.g.c(this.f20417f, this.f20415d);
        this.l0 = cVar;
        cVar.f(this.O);
        this.l0.d(this.M);
        this.l0.b();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BlankView blankView = this.I;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.B == null) {
                this.B = new c.a.q0.s.f0.a(this.f20417f.getPageContext());
            }
            this.B.h(true);
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.q0.x.w.h hVar = this.S;
            if (hVar == null || hVar.a() == null) {
                return 0;
            }
            return this.S.a().getHeight();
        }
        return invokeV.intValue;
    }

    public final void B0(SparseArray<Object> sparseArray, c.a.r0.i.i iVar, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, sparseArray, iVar, userData) == null) || (newSubPbActivity = this.f20417f) == null || sparseArray == null || this.f20414c == null) {
            return;
        }
        if (this.k0 == null) {
            this.k0 = new c.a.r0.i.j(newSubPbActivity.getPageContext(), this.f20414c, iVar, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (h0 = subPbModel.h0()) != null && h0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = h0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.k(sparseArray2);
        this.k0.E(new String[]{this.f20417f.getString(R.string.delete_thread_reason_1), this.f20417f.getString(R.string.delete_thread_reason_2), this.f20417f.getString(R.string.delete_thread_reason_3), this.f20417f.getString(R.string.delete_thread_reason_4), this.f20417f.getString(R.string.delete_thread_reason_5)});
        this.k0.D(x0Var);
        this.k0.G("4");
        this.k0.F(new o(this, sparseArray));
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x : (View) invokeV.objValue;
    }

    public void C0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            W(NoDataViewFactory.e.d(null, this.f20417f.getResources().getString(R.string.refresh_view_title_text)));
            this.X.setVisibility(8);
        }
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void D0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            if (z) {
                W(NoDataViewFactory.e.d("", str));
            } else {
                W(NoDataViewFactory.e.d(str, this.f20417f.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.X.setVisibility(8);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f20414c : (View) invokeV.objValue;
    }

    public void E0(b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) {
            c.a.q0.s.s.b bVar = this.N;
            if (bVar != null) {
                bVar.e();
                this.N = null;
            }
            c.a.q0.s.s.b bVar2 = new c.a.q0.s.s.b(this.f20417f.getPageContext().getPageActivity());
            this.N = bVar2;
            if (z) {
                bVar2.j(new String[]{this.f20417f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
            } else {
                bVar2.j(new String[]{this.f20417f.getPageContext().getString(R.string.save_to_emotion), this.f20417f.getPageContext().getString(R.string.save_to_local)}, cVar);
            }
            this.N.c(this.f20417f.getPageContext());
            this.N.m();
        }
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public final void F0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData h0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, sparseArray) == null) || (newSubPbActivity = this.f20417f) == null || sparseArray == null || this.f20414c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new c.a.r0.i.g(newSubPbActivity.getPageContext(), this.f20414c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.g0;
        if (subPbModel != null && (h0 = subPbModel.h0()) != null && h0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = h0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.k(sparseArray2);
        this.j0.y(new String[]{this.f20417f.getString(R.string.delete_thread_reason_1), this.f20417f.getString(R.string.delete_thread_reason_2), this.f20417f.getString(R.string.delete_thread_reason_3), this.f20417f.getString(R.string.delete_thread_reason_4), this.f20417f.getString(R.string.delete_thread_reason_5)});
        this.j0.x(x0Var);
        this.j0.A("4");
        this.j0.z(new n(this, sparseArray));
    }

    public ListView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f20415d : (ListView) invokeV.objValue;
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f20415d.setNextPage(this.C);
            this.C.O();
        }
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.H : (View) invokeV.objValue;
    }

    public void H0(r rVar, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{rVar, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || rVar == null) {
            return;
        }
        if (this.i0 && (view = this.f20414c) != null) {
            view.setVisibility(8);
            this.f20415d.removeHeaderView(this.f20414c);
            this.e0 = 1;
        }
        this.V = rVar;
        if (rVar.i() != null) {
            this.V.i().m0 = true;
        }
        View view2 = this.f20414c;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (rVar.l() != null && rVar.l().D2()) {
            this.n.setText(R.string.view_original);
        } else {
            this.n.setText(R.string.view_subject);
        }
        if (rVar.i() != null) {
            int A = rVar.i().A();
            this.T = A;
            if (A > 0) {
                this.k.setCenterTextTitle(String.format(this.f20417f.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.T)));
                NewSubPbActivity newSubPbActivity = this.f20417f;
                if (newSubPbActivity != null) {
                    this.W.setText(newSubPbActivity.getReplyHint());
                }
            } else {
                this.k.setCenterTextTitle(this.f20417f.getResources().getString(R.string.local_floor_reply));
            }
            String str = this.f20417f.isFromPb() ? "PB" : null;
            if (rVar.i().L() != null) {
                this.A.setData(this.f20417f.getPageContext(), rVar.i().L(), c.a.r0.j3.k0.a.a("PB", "c0132", rVar.d().getId(), rVar.d().getName(), rVar.l().f0(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (rVar.o()) {
            this.C.O();
            this.l0.g(true);
        } else {
            this.C.f();
            this.l0.g(false);
        }
        ArrayList<PostData> k2 = rVar.k();
        this.U = k2;
        if (k2 == null || k2.size() <= s0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.U.size() - s0;
            j0(size);
            int firstVisiblePosition = this.f20415d.getFirstVisiblePosition() - size;
            View childAt = this.f20415d.getChildAt(0);
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = childAt == null ? 0 : childAt.getTop();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.U);
        if (ListUtils.isEmpty(this.U)) {
            this.f20415d.setNextPage(null);
            if (this.i0) {
                arrayList.add(0, new c.a.r0.j2.k.g.g.a());
            }
        } else {
            this.f20415d.setNextPage(this.C);
        }
        c.a.r0.j2.k.g.g.b bVar = new c.a.r0.j2.k.g.g.b();
        bVar.c(rVar.m());
        arrayList.add(0, bVar);
        if (this.i0) {
            arrayList.add(0, rVar.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f20417f;
        if (newSubPbActivity2 != null && newSubPbActivity2.getSubPbModel() != null) {
            this.o0.setVisibility(this.f20417f.getSubPbModel().J0() ? 0 : 8);
        }
        this.l0.e(this.V.l(), arrayList);
        y(rVar, rVar.i(), rVar.e(), rVar.f(), i2, z);
        if (i3 > 0) {
            this.f20415d.setSelectionFromTop(i4, i5);
        } else if (z2 && !c.a.e.e.p.k.isEmpty(this.f20417f.getSubPbModel().p0())) {
            String p0 = this.f20417f.getSubPbModel().p0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && p0.equals(((PostData) arrayList.get(i6)).E())) {
                        this.f20415d.post(new f(this, i6));
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (this.V.j() > 1) {
            this.f20415d.setPullRefresh(this.f20416e);
            this.f20412a.setEnableDragExit(false);
            return;
        }
        this.f20415d.setPullRefresh(null);
        this.f20412a.setEnableDragExit(true);
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l0.a() : invokeV.booleanValue;
    }

    public PbMoreDialog J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d0 : (PbMoreDialog) invokeV.objValue;
    }

    public final void J0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (n0.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? c.a.e.e.p.k.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String j2 = n0.j(name_show, 0, 14);
            if (j2.length() == name_show.length()) {
                name_show = j2;
            } else {
                name_show = j2 + "...";
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(Q(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                c.a.q0.e.b bVar = new c.a.q0.e.b();
                bVar.f13044a = metaData.getAlaUserData();
                bVar.f13045b = 4;
                this.r.setTag(bVar);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, R.color.cp_cont_r);
        } else if (c.a.q0.b.d.E()) {
            c.a.q0.s.u.c.d(this.q).w(R.color.CAM_X0108);
        } else {
            c.a.q0.s.u.c.d(this.q).w(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.startLoad(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
    }

    public ImageView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.Z : (ImageView) invokeV.objValue;
    }

    public void K0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeListView = this.f20415d) == null) {
            return;
        }
        this.f0 = bdTypeListView.getLastVisiblePosition();
    }

    public ImageView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public void L0(boolean z) {
        PbMoreDialog pbMoreDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (pbMoreDialog = this.d0) == null || pbMoreDialog.getMarkTextView() == null) {
            return;
        }
        if (z) {
            this.d0.getMarkTextView().setText(R.string.remove_mark);
        } else {
            this.d0.getMarkTextView().setText(R.string.mark);
        }
    }

    public MorePopupWindow M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.E : (MorePopupWindow) invokeV.objValue;
    }

    public TextView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.W : (TextView) invokeV.objValue;
    }

    public TextView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.w : (TextView) invokeV.objValue;
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f20412a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder Q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return c.a.r0.a0.m.h(this.f20417f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void R() {
        c.a.q0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void S() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (noDataView = this.f20419h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f20415d.setVisibility(0);
        this.X.setVisibility(0);
        this.f20412a.setOnTouchListener(null);
    }

    public void T() {
        c.a.q0.x.w.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.W == null || (hVar = this.S) == null) {
            return;
        }
        if (hVar.x()) {
            this.W.setText(R.string.draft_to_send);
        } else {
            this.W.setText(this.f20417f.getReplyHint());
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f20414c.findViewById(R.id.subpb_head_user_info_root);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.M);
            HeadImageView headImageView = (HeadImageView) this.f20414c.findViewById(R.id.photo);
            this.p = headImageView;
            headImageView.setRadius(c.a.e.e.p.l.g(this.f20417f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.f20414c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.f20414c.findViewById(R.id.user_rank);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.f20414c.findViewById(R.id.floor_owner);
            TextView textView = (TextView) this.f20414c.findViewById(R.id.see_subject);
            this.n = textView;
            textView.setOnClickListener(this.M);
            this.u = (TextView) this.f20414c.findViewById(R.id.floor);
            this.v = (TextView) this.f20414c.findViewById(R.id.time);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.f20414c.findViewById(R.id.content_text);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.M);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.f20414c.findViewById(R.id.sub_pb_image);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.M);
            this.z = (TextView) this.f20414c.findViewById(R.id.advert);
            this.y = (PlayVoiceBntNew) this.f20414c.findViewById(R.id.voice_btn);
            this.f20414c.setOnTouchListener(this.p0);
            this.f20414c.setOnClickListener(this.M);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int g2 = c.a.e.e.p.l.g(this.f20417f.getPageContext().getPageActivity(), R.dimen.ds88);
            int g3 = c.a.e.e.p.l.g(this.f20417f.getPageContext().getPageActivity(), R.dimen.ds2);
            NavigationBar navigationBar = (NavigationBar) this.f20412a.findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = g2;
                layoutParams.width = g2;
                layoutParams.leftMargin = g3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view = this.m;
            if (view != null && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = g2;
                layoutParams2.height = g2;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
        }
    }

    public final void W(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f20417f.getPageContext().getString(R.string.refresh_view_button_text), this.f20420i));
            if (this.f20419h == null) {
                Activity pageActivity = this.f20417f.getPageContext().getPageActivity();
                this.f20419h = NoDataViewFactory.a(pageActivity, this.f20421j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, c.a.e.e.p.l.g(pageActivity, R.dimen.ds250)), eVar, a2);
            }
            this.f20415d.setVisibility(8);
            this.P.setVisibility(8);
            this.S.z();
            SkinManager.setBackgroundColor(this.f20419h, R.color.CAM_X0201);
            this.f20419h.setClickable(true);
            this.f20419h.setTextOption(eVar);
            this.f20419h.onChangeSkinType(this.f20417f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f20419h.setVisibility(0);
        }
    }

    public void X(c.a.q0.x.w.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, hVar) == null) || hVar == null || hVar.a() == null) {
            return;
        }
        this.S = hVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.f20421j.addView(hVar.a(), layoutParams);
        this.S.S(new b(this));
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f20412a.isDrag() : invokeV.booleanValue;
    }

    public final boolean Z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
            SubPbModel subPbModel = this.g0;
            if (subPbModel == null || subPbModel.j0() == null) {
                return false;
            }
            if (this.g0.B0() != 0) {
                return false;
            }
            r rVar = this.V;
            return (rVar == null || rVar.l() == null || this.V.l().J() == null || !TextUtils.equals(this.V.l().J().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
        }
    }

    public void a0() {
        c.a.r0.j2.k.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.c();
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            SubPbView subPbView = this.f20412a;
            if (subPbView != null) {
                subPbView.onDestroy();
            }
            c.a.q0.x.w.h hVar = this.S;
            if (hVar != null) {
                hVar.E();
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    public void e0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.f20417f.getLayoutMode().k(i2 == 1);
            this.f20417f.getLayoutMode().j(this.f20412a);
            this.f20417f.getLayoutMode().j(this.f20414c);
            SkinManager.setBackgroundColor(this.f20412a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f20421j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f20417f.getPageContext(), i2);
            SubPbModel subPbModel = this.g0;
            if (subPbModel != null && subPbModel.I0()) {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.goto_see_subject_color);
            }
            this.f20418g.onChangeSkinType(this.f20417f.getPageContext(), i2);
            this.f20417f.getLayoutMode().j(this.H);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            c.a.q0.x.w.h hVar = this.S;
            if (hVar != null && hVar.a() != null) {
                this.S.a().onChangeSkinType(i2);
            }
            this.C.d(i2);
            this.y.changeSkin();
            SkinManager.setViewTextColor(this.W, R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0302);
            if (c.a.q0.b.d.E()) {
                c.a.q0.s.u.c.d(this.q).B(R.string.F_X02);
                c.a.q0.s.u.c.d(this.q).w(R.color.CAM_X0108);
            } else {
                c.a.q0.s.u.c.d(this.q).B(R.string.F_X01);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
            }
            this.W.setAlpha(0.95f);
            if (this.D != null) {
                c.a.q0.w0.a.a(this.f20417f.getPageContext(), this.D);
            }
            c.a.r0.j2.k.g.c cVar = this.l0;
            if (cVar != null) {
                cVar.c();
            }
            this.f20417f.getLayoutMode().j(this.F);
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0203);
            this.b0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.a0.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f20417f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            c.a.q0.s.u.c.d(this.X).f(R.color.CAM_X0208);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.f20417f.isPaused()) {
        }
    }

    public void g0(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            int i4 = R.string.del_all_post_confirm;
            if (i3 == 1002 && !z) {
                i4 = R.string.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f20417f.getPageContext().getPageActivity());
            this.L = aVar;
            aVar.setMessageId(i4);
            this.L.setYesButtonTag(sparseArray);
            this.L.setPositiveButton(R.string.dialog_ok, new l(this, sparseArray));
            this.L.setNegativeButton(R.string.dialog_cancel, new m(this));
            this.L.setCancelable(true);
            this.L.create(this.f20417f.getPageContext());
            if (z2) {
                this.L.show();
            } else if (z) {
                this.L.show();
            } else if (1 == this.g0.l0()) {
                c.a.r0.i.i iVar = new c.a.r0.i.i(this.g0.l0(), this.g0.k0(), this.g0.o0());
                iVar.i(this.V.d().getId(), this.V.d().getName());
                iVar.h(this.g0.m0());
                iVar.j(this.g0.C0());
                UserData userData = new UserData();
                userData.setIsManager(this.g0.q0());
                B0(sparseArray, iVar, userData);
            } else {
                F0(sparseArray);
            }
        }
    }

    public void h0(SparseArray<Object> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048622, this, sparseArray, z) == null) {
            boolean z2 = true;
            if (this.K == null) {
                Dialog dialog = new Dialog(this.f20417f.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.K = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.K.setCancelable(true);
                this.F = LayoutInflater.from(this.f20417f.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
                this.f20417f.getLayoutMode().j(this.F);
                this.K.setContentView(this.F);
                WindowManager.LayoutParams attributes = this.K.getWindow().getAttributes();
                attributes.width = (int) (c.a.e.e.p.l.k(this.f20417f.getPageContext().getPageActivity()) * 0.9d);
                this.K.getWindow().setAttributes(attributes);
            }
            TextView textView = (TextView) this.K.findViewById(R.id.del_post_btn);
            TextView textView2 = (TextView) this.K.findViewById(R.id.forbid_user_btn);
            TextView textView3 = (TextView) this.K.findViewById(R.id.disable_reply_btn);
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                SparseArray sparseArray2 = (SparseArray) textView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    textView.setTag(sparseArray2);
                }
                textView.setVisibility(0);
                int i2 = R.id.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                textView.setOnClickListener(new i(this));
            } else {
                textView.setVisibility(8);
            }
            if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                textView2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) textView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    textView2.setTag(sparseArray3);
                }
                textView2.setVisibility(0);
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
                textView2.setOnClickListener(new j(this));
            }
            if (!(((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) ? false : false)) {
                textView3.setVisibility(8);
            } else {
                SparseArray sparseArray4 = (SparseArray) textView3.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    textView3.setTag(sparseArray4);
                }
                textView3.setVisibility(0);
                if (z) {
                    textView3.setText(R.string.un_mute);
                } else {
                    textView3.setText(R.string.mute);
                }
                int i11 = R.id.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_user_mute_post_id;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_user_mute_thread_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_user_mute_mute_nameshow;
                sparseArray4.put(i16, sparseArray.get(i16));
                textView3.setOnClickListener(new k(this, z));
            }
            c.a.e.e.m.g.j(this.K, this.f20417f.getPageContext());
        }
    }

    public void i0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        h0(sparseArray, false);
    }

    public final void j0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (arrayList = this.U) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.U.clear();
        }
        int i3 = 0;
        Iterator<PostData> it = this.U.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void k0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, r0Var) == null) {
            this.R = r0Var;
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f20415d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.f();
        }
    }

    public void m0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, r0Var) == null) {
            this.Q = r0Var;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.i0 = z;
        }
    }

    public void o0(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, gVar) == null) {
            this.n0 = gVar;
            c.a.r0.j2.p.j jVar = this.f20416e;
            if (jVar != null) {
                jVar.a(gVar);
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f20415d.setVisibility(0);
            this.P.setVisibility(8);
            this.C.P();
        }
    }

    public void q0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, subPbModel) == null) {
            this.g0 = subPbModel;
        }
    }

    public void r(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z) == null) || (subPbModel = this.g0) == null || !subPbModel.H0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.I = new BlankView(this.f20417f.getPageContext().getPageActivity());
        if (this.g0.I0()) {
            this.h0 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.h0 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
        }
        this.f20413b.addView(this.I, 0, new LinearLayout.LayoutParams(-1, this.h0));
        this.I.setVisibility(0);
        this.I.setOnClickListener(new e(this));
        this.f20412a.setBlankView(this.I);
    }

    public void r0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, zVar) == null) {
            this.l0.i(zVar);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            v0(this.f20417f);
            this.f20415d.setNextPage(this.C);
        }
    }

    public void s0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onLongClickListener) == null) {
            this.l0.h(onLongClickListener);
        }
    }

    public void t(boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z) == null) || (headImageView = this.b0) == null) {
            return;
        }
        headImageView.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onClickListener) == null) {
            this.f20420i = onClickListener;
        }
    }

    public void u() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || this.g0 == null) {
            return;
        }
        if ((!I0() && (view = this.H) != null && view.isShown()) || ListUtils.isEmpty(this.U)) {
            this.g0.Y0(false);
        } else {
            this.g0.Y0(true);
        }
    }

    public void u0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onScrollListener) == null) {
            this.f20415d.setOnScrollListener(onScrollListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048640, this, postData, i2, sparseArray) == null) || postData == null) {
            return;
        }
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        boolean z6 = true;
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = postData.t().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        r rVar = this.V;
        if (rVar != null && rVar.l() != null && this.V.l().J() != null && postData.t() != null) {
            String userId3 = this.V.l().J().getUserId();
            String userId4 = postData.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = postData.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    int i3 = postData.A() == 1 ? 0 : 1;
                    if (z) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                        z6 = z5;
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                    if (z) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.V.l() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.V.l().f0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, postData.E());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.Y()));
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
                z2 = true;
                z3 = false;
                z4 = true;
                userId = postData.t().getUserId();
                if (userId != null) {
                    z2 = true;
                    z4 = true;
                }
                if (postData.A() == 1) {
                }
                if (z) {
                }
                if (z2) {
                }
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = postData.t().getUserId();
        if (userId != null) {
        }
        if (postData.A() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void v0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, pVar) == null) {
            this.f20415d.setOnSrollToBottomListener(pVar);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            MorePopupWindow morePopupWindow = this.E;
            if (morePopupWindow != null) {
                c.a.e.e.m.g.d(morePopupWindow, this.f20417f.getPageContext().getPageActivity());
            }
            c.a.q0.s.s.b bVar = this.G;
            if (bVar != null) {
                bVar.e();
            }
            c.a.q0.s.s.a aVar = this.L;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.K;
            if (dialog != null) {
                c.a.e.e.m.g.b(dialog, this.f20417f.getPageContext());
            }
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            PbMoreDialog pbMoreDialog = this.d0;
            if (pbMoreDialog != null) {
                pbMoreDialog.dismiss();
            }
        }
    }

    public void w0(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, view) == null) {
            this.D = view;
        }
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048644, this, z) == null) || (bdTypeListView = this.f20415d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new RunnableC0966a(this, z), 10L);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.P.setVisibility(0);
        }
    }

    public void y(r rVar, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{rVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.i0) {
            return;
        }
        if (!StringUtils.isNull(postData.z())) {
            this.x.setVisibility(0);
            this.x.startLoad(postData.z(), 10, true);
        } else {
            this.x.setVisibility(8);
        }
        c.a.r0.j3.i0.i v = postData.v();
        if (v != null && v.f20861a) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        SparseArray<Object> sparseArray = (SparseArray) this.f20414c.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f20414c.setTag(sparseArray);
        }
        sparseArray.clear();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        v(postData, i2, sparseArray);
        this.u.setText((CharSequence) null);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.i0) {
            J0(postData.t());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0302);
            }
        }
        this.v.setText(StringHelper.getFormatTime(postData.S()));
        String format = String.format(this.f20417f.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.A()));
        if (rVar.l() != null && rVar.l().D2()) {
            this.u.setText((CharSequence) null);
        } else {
            this.u.setText(format);
        }
        postData.t().getUserTbVipInfoData();
        boolean y0 = y0(this.w, postData.K());
        if (StringUtils.isNull(postData.z()) && !y0 && postData.W() != null) {
            this.y.setVisibility(0);
            this.y.setTag(postData.W());
            return;
        }
        this.y.setVisibility(8);
    }

    public final boolean y0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048647, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.y() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.y().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type == 17) {
                                    String str = next.z().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.x(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                } else if (type != 18 && type != 1282) {
                                }
                            }
                            tbRichTextData.Q(true);
                            textView.setMovementMethod(c.a.r0.b4.b.a());
                        } else {
                            tbRichTextData.x(next.F());
                        }
                    }
                }
                if (!tbRichTextData.M()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.F() == null || tbRichTextData.F().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.F());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void z(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.P;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f20417f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.delete_success));
            } else if (str == null || !z2) {
            } else {
                this.f20417f.showToast(str);
            }
        }
    }

    public void z0(PostData postData) {
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, postData) == null) || postData == null) {
            return;
        }
        postData.p0(true);
        PostData postData2 = new PostData();
        postData2.t0(52);
        if (!I0() && (view = this.H) != null && view.isShown()) {
            i2 = (this.f0 - this.e0) - 1;
        } else {
            i2 = this.f0 - this.e0;
        }
        int count = ListUtils.getCount(this.U);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.U, 0, i2));
        ListUtils.add(arrayList, postData2);
        ListUtils.add(arrayList, postData);
        this.f20415d.smoothScrollToPosition(this.f0 + 2);
        this.f20415d.setNextPage(null);
    }
}
