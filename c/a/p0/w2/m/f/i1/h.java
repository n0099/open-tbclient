package c.a.p0.w2.m.f.i1;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.h0.m;
import c.a.p0.w2.m.f.i1.h;
import c.a.p0.w2.m.f.x0;
import c.a.p0.w2.m.f.y0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbContent;
import tbclient.PluginUser;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TextView C;
    public TiePlusEventController D;
    public c.a.o0.e1.p.c E;
    public int F;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.j.c f20111b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f20112c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f20113d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.l0.g f20114e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f20115f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20116g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.w2.m.f.k f20117h;
    public ColumnLayout i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public HeadPendantView n;
    public TBLottieAnimationView o;
    public UserIconBox p;
    public UserIconBox q;
    public FrameLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public ClickableHeaderImageView u;
    public PbFirstFloorUserLikeButton v;
    public PbFirstFloorMessageButton w;
    public x0 x;
    public e y;
    public TextView z;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f20118b;

        public a(h hVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20118b = hVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f20118b.t.getMeasuredWidth();
                int measuredWidth2 = this.f20118b.z.getMeasuredWidth();
                int measuredWidth3 = this.f20118b.C.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i2 = this.a;
                if (i < i2) {
                    this.f20118b.B.setVisibility(8);
                    this.f20118b.A.setVisibility(8);
                } else if (i - i2 < dimenPixelSize) {
                    this.f20118b.A.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f20119b;

        public b(h hVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20119b = hVar;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20119b.E.q(TiePlusStat.StatType.CLICK);
                this.f20119b.D.g(this.f20119b.E);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(c.a.d.f.m.b.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.u(this.f20119b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public c(h hVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o.playAnimation();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final TBSpecificationBtn f20120b;

        /* renamed from: c  reason: collision with root package name */
        public String f20121c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f20122d;

        public e(@NonNull h hVar, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20122d = hVar;
            this.a = textView;
            this.f20120b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f20121c = str;
            }
        }

        @NonNull
        public final TiebaPlusConfigData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? TiebaPlusConfigData.DEFAULT : tiebaPlusConfigData;
            }
            return (TiebaPlusConfigData) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f20120b.setConfig(bVar);
                this.f20120b.setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.w2.m.f.i1.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            h.e.this.d(view);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view) {
            if (!c.a.d.f.p.l.A()) {
                n.M(this.f20122d.a.getContext(), R.string.obfuscated_res_0x7f0f0c15);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f20122d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.f20121c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.f20120b.l(i);
                } else {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().isSwitchOpen()) {
                    this.f20120b.setText(charSequence.toString());
                } else {
                    this.a.setText(charSequence);
                }
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.f20120b.setVisibility(i);
                    this.a.setVisibility(8);
                    return;
                }
                this.f20120b.setVisibility(8);
                this.a.setVisibility(i);
            }
        }
    }

    public h(PbFragment pbFragment, c.a.p0.w2.j.c cVar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20112c = null;
        this.f20113d = null;
        this.f20115f = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.r = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = 0;
        this.a = pbFragment;
        this.f20111b = cVar;
        this.f20112c = onClickListener;
        r();
    }

    public void A(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            if (fVar != null && fVar.r0()) {
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702be);
                int paddingBottom = this.i.getPaddingBottom();
                if (fVar.g0()) {
                    f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), f2, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (fVar != null && !fVar.O().isVideoThreadType() && fVar.g0() && (!StringUtils.isNull(fVar.O().getTitle()) || fVar.O().getSpan_str() != null)) {
                f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), f3, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void C(int i, c.a.p0.w2.i.f fVar, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), fVar, postData, onClickListener}) == null) {
            if (postData != null && postData.s() != null) {
                MetaData s = postData.s();
                String string = s.getName_show() == null ? StringUtils.string(s.getUserName()) : StringUtils.string(s.getName_show());
                if ((!StringUtils.isNull(postData.s().getSealPrefix()) ? m.byteLength(s.getSealPrefix()) + 2 : 0) > 0) {
                    if (m.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    }
                } else if (m.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> tShowInfoNew = s.getTShowInfoNew();
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.x() != null) {
                        this.p.setOnClickListener(this.a.x().mEvent.f20182d);
                    }
                    int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.p.h(tShowInfoNew, 3, f2, f2, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(p(s.getSealPrefix(), string));
                this.k.setTag(R.id.obfuscated_res_0x7f091eb7, s.getUserId());
                this.k.setTag(R.id.obfuscated_res_0x7f091ebf, s.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !s.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (fVar.g0()) {
                    this.l.setVisibility(8);
                } else if (s.getIs_bawu() == 1 && postData.c0()) {
                    c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.obfuscated_res_0x7f0f0330);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02ea);
                    this.l.setVisibility(0);
                    c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02eb);
                    this.l.setVisibility(0);
                    c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.V()), "yyyy"))) {
                    this.z.setText(StringHelper.getFormatTimeShort(postData.V()));
                } else {
                    this.z.setText(StringHelper.getFormatTime(postData.V()));
                }
                if (fVar.g0()) {
                    this.A.setVisibility(8);
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.C.setVisibility(0);
                        this.C.setText(authInfo);
                    } else {
                        this.C.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.C.setVisibility(0);
                        this.C.setText(authInfo2);
                    } else {
                        this.C.setVisibility(8);
                    }
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    c.a.o0.t.g K = postData.K();
                    if (K != null && !TextUtils.isEmpty(K.b()) && !TextUtils.isEmpty(K.b().trim())) {
                        this.A.setVisibility(0);
                        this.A.setText(K.b());
                    } else {
                        this.A.setVisibility(8);
                    }
                    if (K != null && !TextUtils.isEmpty(K.a())) {
                        this.B.setText(K.a());
                        this.B.setVisibility(0);
                        this.t.post(new a(this, (int) this.B.getPaint().measureText(K.a(), 0, K.a().length())));
                    } else {
                        this.B.setVisibility(8);
                    }
                }
                if (fVar.O().getAuthor() == null || fVar.O().getAuthor().getAlaInfo() == null || fVar.O().getAuthor().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    D(fVar);
                    z = true;
                }
                this.n.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.n.j(s, 4);
                    this.n.setIsclearmode(false);
                } else {
                    this.n.setIsclearmode(true);
                }
                this.n.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.u;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.n.getHeadView().setUserId(s.getUserId());
                this.n.getHeadView().setUserName(s.getUserName());
                this.n.getHeadView().setTid(postData.G());
                this.n.getHeadView().setFid(fVar != null ? fVar.m() : "");
                this.n.getHeadView().setFName(fVar.n());
                this.n.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.n.l(s.getAvater());
                } else {
                    this.n.n(s);
                    this.n.setIsNeedAlpAnima(true);
                }
                String name_show = s.getName_show();
                String userName = s.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(c.a.p0.w2.c.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.obfuscated_res_0x7f091e90, c.a.p0.w2.c.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (fVar != null) {
                this.f20117h.f(fVar.O());
            }
        }
    }

    public final void D(c.a.p0.w2.i.f fVar) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && fVar != null && fVar.O() != null && fVar.O().getAuthor() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", fVar.m());
            statisticItem.param("fname", fVar.n());
            statisticItem.param("obj_param1", fVar.O().getAuthor().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", fVar.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (fVar.O().getAuthor().getAlaInfo() != null) {
                AlaInfoData alaInfo = fVar.O().getAuthor().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
        this.o.setVisibility(0);
        this.o.setSpeed(0.8f);
        this.o.loop(true);
        this.o.post(new d(this));
    }

    public void E(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, postData, z) == null) {
            if (this.a.isSimpleForum()) {
                this.F = 0;
                if (postData != null && postData.s() != null) {
                    this.F = postData.s().getLevel_id();
                }
                if (this.F > 0 && !z) {
                    this.m.setVisibility(0);
                    s(this.m);
                    if (postData != null && postData.s() != null) {
                        H(postData);
                    }
                    SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.F));
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            if (postData == null || postData.s() == null) {
                return;
            }
            H(postData);
        }
    }

    public void F(c.a.p0.w2.i.f fVar, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, fVar, postData, z) == null) || fVar == null || postData == null) {
            return;
        }
        if (3 != fVar.g()) {
            this.v.setVisibility(0);
            s(this.v);
        }
        if (z) {
            this.v.setVisibility(8);
            if (fVar != null && fVar.O() != null && fVar.O().getBaijiahaoData() != null && fVar.O().getBaijiahaoData().oriUgcType == 3) {
                this.y.g(8);
            } else {
                this.y.g(0);
            }
            this.y.a(fVar.Q());
            this.y.f(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e32), StringHelper.numberUniformFormatExtra(fVar.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.s().hadConcerned()) {
            this.y.g(8);
        } else {
            this.v.setVisibility(8);
            this.y.g(8);
        }
        if (fVar.i || 3 == fVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void G(c.a.p0.w2.i.f fVar, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, fVar, postData) == null) || postData == null || this.a == null || postData.m0 == null || fVar.O() == null || fVar.O().getAuthor() == null) {
            return;
        }
        MetaData author = fVar.O().getAuthor();
        this.D = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
        PbContent o = TiePlusHelper.o(postData.m0);
        if (o == null || o.tiebaplus_info == null) {
            return;
        }
        c.a.o0.e1.p.c c2 = c.a.o0.e1.p.c.c(o.type.intValue(), o.tiebaplus_info, fVar.O());
        this.E = c2;
        c2.p(TiePlusStat.RichTextType.MESSAGE);
        this.E.q(TiePlusStat.StatType.EXPOSE);
        this.D.g(this.E);
        this.w.setVisibility(0);
        this.w.setOnClickListener(new b(this, author));
    }

    public final void H(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        MetaData s = postData.s();
        ArrayList<IconData> iconInfo = s.getIconInfo();
        UserIconBox userIconBox = this.q;
        if (userIconBox != null) {
            userIconBox.setTag(R.id.obfuscated_res_0x7f091eb7, s.getUserId());
            if (this.a.x() != null) {
                this.q.setOnClickListener(this.a.x().mEvent.f20181c);
            }
            int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            this.q.g(iconInfo, 4, f2, f2, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.q.setAutoChangedStyle(true);
            s(this.q);
        }
    }

    public void j(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f20115f);
    }

    public void k(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, bdTypeListView, i) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f20115f, i);
    }

    public void l(c.a.p0.w2.i.f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (fVar != null && fVar.j) {
                this.f20116g.setImageResource(R.drawable.obfuscated_res_0x7f080efe);
                this.f20116g.setVisibility(0);
                s(this.f20116g);
            } else if (z && z2) {
                this.f20116g.setImageResource(R.drawable.obfuscated_res_0x7f080f40);
                this.f20116g.setVisibility(0);
                s(this.f20116g);
            } else if (z) {
                this.f20116g.setImageResource(R.drawable.obfuscated_res_0x7f080f3e);
                this.f20116g.setVisibility(0);
                s(this.f20116g);
            } else if (z2) {
                this.f20116g.setImageResource(R.drawable.obfuscated_res_0x7f080f3f);
                this.f20116g.setVisibility(0);
                s(this.f20116g);
            } else {
                this.f20116g.setVisibility(8);
            }
        }
    }

    public void m() {
        c.a.p0.l0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.f20114e) == null) {
            return;
        }
        gVar.I();
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f20117h.e() : (TextView) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f20115f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str));
            return c.a.p0.h0.m.h(this.a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fc, (ViewGroup) null);
            this.f20115f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09172e);
            this.f20116g = imageView;
            imageView.getLayoutParams().height = y0.g();
            c.a.p0.w2.m.f.k kVar = new c.a.p0.w2.m.f.k(this.a.getBaseFragmentActivity(), this.f20115f);
            this.f20117h = kVar;
            kVar.a();
            c.a.p0.w2.m.f.k kVar2 = this.f20117h;
            kVar2.d(kVar2.e(), this.f20112c);
            this.i = (ColumnLayout) this.f20115f.findViewById(R.id.obfuscated_res_0x7f0916d2);
            this.j = (ThreadSkinView) this.f20115f.findViewById(R.id.obfuscated_res_0x7f09172b);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916d1);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0909df);
            this.m = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090e17);
            this.r = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0916ce);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f09170a);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f0916cf);
            this.i.setOnLongClickListener(this.f20113d);
            this.i.setOnTouchListener(this.f20111b);
            this.i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091cf5);
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091cf6);
            this.s = (LinearLayout) this.f20115f.findViewById(R.id.obfuscated_res_0x7f0916d0);
            this.t = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0916ac);
            this.v = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f0916e1);
            this.w = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f0916e7);
            this.y = new e(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09174e), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f09174f));
            this.z = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916d8);
            this.A = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916d6);
            this.B = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916d4);
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0916d5);
        }
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            view.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new c(this, view));
            ofInt.start();
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            SkinManager.setBackgroundColor(this.f20115f, R.color.CAM_X0205);
            ImageView imageView = this.m;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.F));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.w;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.r(i);
            }
            TextView textView = this.A;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.z;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            e eVar = this.y;
            if (eVar != null) {
                eVar.e(i);
            }
            TextView textView3 = this.C;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
            TextView textView4 = this.B;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            UserIconBox userIconBox = this.q;
            if (userIconBox != null) {
                userIconBox.i(i);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.p0.l0.g gVar = this.f20114e;
            if (gVar != null) {
                gVar.I();
            }
            ColumnLayout columnLayout = this.i;
            if (columnLayout != null && this.u != null) {
                columnLayout.removeView(this.r);
                this.u = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.o;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    public void v(c.a.p0.w2.i.f fVar, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{fVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || fVar == null || postData == null) {
            return;
        }
        String Q = fVar != null ? fVar.Q() : "";
        int i = y0.i(fVar);
        if (z && postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
        }
        if (this.x == null) {
            ThreadData O = fVar.O();
            int i2 = 1;
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    i2 = 4;
                } else if (O.isBJHVideoThreadType()) {
                    i2 = 6;
                } else if (O.isBJHVideoDynamicThreadType()) {
                    i2 = 7;
                } else if (O.isBJHNormalThreadType()) {
                    i2 = 5;
                } else if (O.isVideoWorksInfo()) {
                    i2 = 8;
                }
            }
            x0 x0Var = new x0(this.a.getPageContext(), this.v, i2);
            this.x = x0Var;
            x0Var.l(this.a.getUniqueId());
            this.x.v(O);
        }
        if (postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
            this.x.n(postData.s());
            this.x.x(Q);
        }
        x0 x0Var2 = this.x;
        x0Var2.p = z2;
        x0Var2.w(i);
    }

    public void w(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f20115f);
    }

    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onLongClickListener) == null) {
            this.f20113d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void y(PostData postData, c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, postData, fVar) == null) || postData == null || fVar == null) {
            return;
        }
        if (postData.O() != null) {
            this.j.setData(this.a.getPageContext(), fVar.F().get(0).O(), c.a.p0.a4.m0.a.a("PB", "c0132", fVar.l().getId(), fVar.l().getName(), fVar.O().getId(), this.a.k5() ? "FRS" : null));
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f20117h.g(z);
        }
    }
}
