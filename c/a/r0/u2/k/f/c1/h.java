package c.a.r0.u2.k.f.c1;

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
import c.a.q0.r.r.e2;
import c.a.r0.f0.m;
import c.a.r0.u2.k.f.c1.h;
import c.a.r0.u2.k.f.r0;
import c.a.r0.u2.k.f.s0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
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
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TextView C;
    public TiePlusEventController D;
    public c.a.q0.e1.p.b E;
    public int F;
    public PbFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.u2.i.c f23392b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f23393c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f23394d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.j0.g f23395e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f23396f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23397g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.u2.k.f.h f23398h;

    /* renamed from: i  reason: collision with root package name */
    public ColumnLayout f23399i;

    /* renamed from: j  reason: collision with root package name */
    public ThreadSkinView f23400j;
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
    public r0 x;
    public e y;
    public TextView z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f23402f;

        public a(h hVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23402f = hVar;
            this.f23401e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.f23402f.t.getMeasuredWidth();
                int measuredWidth2 = this.f23402f.z.getMeasuredWidth();
                int measuredWidth3 = this.f23402f.C.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i2 = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i3 = this.f23401e;
                if (i2 < i3) {
                    this.f23402f.B.setVisibility(8);
                    this.f23402f.A.setVisibility(8);
                } else if (i2 - i3 < dimenPixelSize) {
                    this.f23402f.A.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f23403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f23404f;

        public b(h hVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23404f = hVar;
            this.f23403e = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23404f.E.q(TiePlusStat.StatType.CLICK);
                this.f23404f.D.statRichTextEvent(this.f23404f.E);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(c.a.d.f.m.b.g(this.f23403e.getUserId(), 0L));
                builder.user_name_show = this.f23403e.getName_show();
                builder.user_photo = this.f23403e.getPortrait();
                builder.user_type = Integer.valueOf(this.f23403e.getType());
                TiePlusHelper.u(this.f23404f.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f23405e;

        public c(h hVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23405e = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f23405e.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f23406e;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23406e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23406e.o.playAnimation();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final TBSpecificationBtn f23407b;

        /* renamed from: c  reason: collision with root package name */
        public String f23408c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f23409d;

        public e(@NonNull h hVar, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23409d = hVar;
            this.a = textView;
            this.f23407b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f23408c = str;
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
                c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
                bVar.r(R.color.CAM_X0302);
                this.f23407b.setConfig(bVar);
                this.f23407b.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.u2.k.f.c1.a
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
                n.M(this.f23409d.a.getContext(), R.string.neterror);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f23409d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.f23408c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (b().isSwitchOpen()) {
                    this.f23407b.changeSkinType(i2);
                } else {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().isSwitchOpen()) {
                    this.f23407b.setText(charSequence.toString());
                } else {
                    this.a.setText(charSequence);
                }
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                if (b().isSwitchOpen()) {
                    this.f23407b.setVisibility(i2);
                    this.a.setVisibility(8);
                    return;
                }
                this.f23407b.setVisibility(8);
                this.a.setVisibility(i2);
            }
        }
    }

    public h(PbFragment pbFragment, c.a.r0.u2.i.c cVar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23393c = null;
        this.f23394d = null;
        this.f23396f = null;
        this.f23399i = null;
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
        this.f23392b = cVar;
        this.f23393c = onClickListener;
        r();
    }

    public void A(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            if (fVar != null && fVar.r0()) {
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.ds45);
                int paddingBottom = this.f23399i.getPaddingBottom();
                if (fVar.g0()) {
                    f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.f23399i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), f2, this.f23399i.getPaddingRight(), paddingBottom);
                return;
            }
            int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.f23399i.getPaddingBottom();
            if (fVar != null && !fVar.O().I2() && fVar.g0() && (!StringUtils.isNull(fVar.O().getTitle()) || fVar.O().j1() != null)) {
                f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.ds20);
            }
            ColumnLayout columnLayout2 = this.f23399i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), f3, this.f23399i.getPaddingRight(), paddingBottom2);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f23399i.setVisibility(i2);
        }
    }

    public void C(int i2, c.a.r0.u2.h.f fVar, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), fVar, postData, onClickListener}) == null) {
            if (postData != null && postData.t() != null) {
                MetaData t = postData.t();
                String string = t.getName_show() == null ? StringUtils.string(t.getUserName()) : StringUtils.string(t.getName_show());
                if ((!StringUtils.isNull(postData.t().getSealPrefix()) ? m.byteLength(t.getSealPrefix()) + 2 : 0) > 0) {
                    if (m.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, "...");
                    }
                } else if (m.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, "...");
                }
                ArrayList<IconData> tShowInfoNew = t.getTShowInfoNew();
                if (this.p != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.p.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.getPbActivity() != null) {
                        this.p.setOnClickListener(this.a.getPbActivity().mEvent.f23482d);
                    }
                    int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.p.loadIcon(tShowInfoNew, 3, f2, f2, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(p(t.getSealPrefix(), string));
                this.k.setTag(R.id.tag_user_id, t.getUserId());
                this.k.setTag(R.id.tag_user_name, t.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !t.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (fVar.g0()) {
                    this.l.setVisibility(8);
                } else if (t.getIs_bawu() == 1 && postData.c0()) {
                    c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_bazhu_tip);
                    this.l.setVisibility(0);
                    c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    this.l.setText(R.string.bawu_member_xbazhu_tip);
                    this.l.setVisibility(0);
                    c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(this.l);
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
                    this.f23399i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(t);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.C.setVisibility(0);
                        this.C.setText(authInfo);
                    } else {
                        this.C.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(t);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.C.setVisibility(0);
                        this.C.setText(authInfo2);
                    } else {
                        this.C.setVisibility(8);
                    }
                    if (this.t.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.t.getLayoutParams())).rightMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.f23399i.setSpacingRight(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    c.a.q0.t.g K = postData.K();
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
                if (fVar.O().J() == null || fVar.O().J().getAlaInfo() == null || fVar.O().J().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    D(fVar);
                    z = true;
                }
                this.n.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.n.showHeadPendantAndBigV(t, 4);
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
                this.n.getHeadView().setUserId(t.getUserId());
                this.n.getHeadView().setUserName(t.getUserName());
                this.n.getHeadView().setTid(postData.G());
                this.n.getHeadView().setFid(fVar != null ? fVar.m() : "");
                this.n.getHeadView().setFName(fVar.n());
                this.n.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.n.startLoadOnlyHeadUrl(t.getAvater());
                } else {
                    this.n.startLoadWithPendantAndBigV(t);
                    this.n.setIsNeedAlpAnima(true);
                }
                String name_show = t.getName_show();
                String userName = t.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(c.a.r0.u2.c.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.tag_nick_name_activity, c.a.r0.u2.c.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
            }
            if (fVar != null) {
                this.f23398h.f(fVar.O());
            }
        }
    }

    public final void D(c.a.r0.u2.h.f fVar) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && fVar != null && fVar.O() != null && fVar.O().J() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", fVar.m());
            statisticItem.param("fname", fVar.n());
            statisticItem.param("obj_param1", fVar.O().J().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", fVar.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (fVar.O().J().getAlaInfo() != null) {
                AlaInfoData alaInfo = fVar.O().J().getAlaInfo();
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
                if (postData != null && postData.t() != null) {
                    this.F = postData.t().getLevel_id();
                }
                if (this.F > 0 && !z) {
                    this.m.setVisibility(0);
                    s(this.m);
                    if (postData != null && postData.t() != null) {
                        H(postData);
                    }
                    SkinManager.setImageResource(this.m, BitmapHelper.getGradeResourceIdInEnterForum(this.F));
                    return;
                }
                this.m.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            if (postData == null || postData.t() == null) {
                return;
            }
            H(postData);
        }
    }

    public void F(c.a.r0.u2.h.f fVar, PostData postData, boolean z) {
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
            if (fVar != null && fVar.O() != null && fVar.O().L() != null && fVar.O().L().oriUgcType == 3) {
                this.y.g(8);
            } else {
                this.y.g(0);
            }
            this.y.a(fVar.Q());
            this.y.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(fVar.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.t().hadConcerned()) {
            this.y.g(8);
        } else {
            this.v.setVisibility(8);
            this.y.g(8);
        }
        if (fVar.f23099i || 3 == fVar.g()) {
            this.v.setVisibility(8);
        }
    }

    public void G(c.a.r0.u2.h.f fVar, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, fVar, postData) == null) || postData == null || this.a == null || postData.q0 == null || fVar.O() == null || fVar.O().J() == null) {
            return;
        }
        MetaData J = fVar.O().J();
        this.D = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
        PbContent o = TiePlusHelper.o(postData.q0);
        if (o == null || o.tiebaplus_info == null) {
            return;
        }
        c.a.q0.e1.p.b c2 = c.a.q0.e1.p.b.c(o.type.intValue(), o.tiebaplus_info, fVar.O());
        this.E = c2;
        c2.p(TiePlusStat.RichTextType.MESSAGE);
        this.E.q(TiePlusStat.StatType.EXPOSE);
        this.D.statRichTextEvent(this.E);
        this.w.setVisibility(0);
        this.w.setOnClickListener(new b(this, J));
    }

    public final void H(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null || postData.t() == null) {
            return;
        }
        MetaData t = postData.t();
        ArrayList<IconData> iconInfo = t.getIconInfo();
        UserIconBox userIconBox = this.q;
        if (userIconBox != null) {
            userIconBox.setTag(R.id.tag_user_id, t.getUserId());
            if (this.a.getPbActivity() != null) {
                this.q.setOnClickListener(this.a.getPbActivity().mEvent.f23481c);
            }
            int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            this.q.loadIcon(iconInfo, 4, f2, f2, n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.q.setAutoChangedStyle(true);
            s(this.q);
        }
    }

    public void j(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f23396f);
    }

    public void k(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, bdTypeListView, i2) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f23396f, i2);
    }

    public void l(c.a.r0.u2.h.f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (fVar != null && fVar.f23100j) {
                this.f23397g.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f23397g.setVisibility(0);
                s(this.f23397g);
            } else if (z && z2) {
                this.f23397g.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f23397g.setVisibility(0);
                s(this.f23397g);
            } else if (z) {
                this.f23397g.setImageResource(R.drawable.pic_pb_refined_n);
                this.f23397g.setVisibility(0);
                s(this.f23397g);
            } else if (z2) {
                this.f23397g.setImageResource(R.drawable.pic_pb_stick_n);
                this.f23397g.setVisibility(0);
                s(this.f23397g);
            } else {
                this.f23397g.setVisibility(8);
            }
        }
    }

    public void m() {
        c.a.r0.j0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gVar = this.f23395e) == null) {
            return;
        }
        gVar.I();
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f23398h.e() : (TextView) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f23396f : (View) invokeV.objValue;
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
            return c.a.r0.f0.m.h(this.a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.f23399i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.f23399i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_user_item, (ViewGroup) null);
            this.f23396f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pb_thread_type_stamp_top_part);
            this.f23397g = imageView;
            imageView.getLayoutParams().height = s0.g();
            c.a.r0.u2.k.f.h hVar = new c.a.r0.u2.k.f.h(this.a.getBaseFragmentActivity(), this.f23396f);
            this.f23398h = hVar;
            hVar.a();
            c.a.r0.u2.k.f.h hVar2 = this.f23398h;
            hVar2.d(hVar2.e(), this.f23393c);
            this.f23399i = (ColumnLayout) this.f23396f.findViewById(R.id.pb_head_owner_root);
            this.f23400j = (ThreadSkinView) this.f23396f.findViewById(R.id.pb_thread_skin);
            this.k = (TextView) this.f23399i.findViewById(R.id.pb_head_owner_info_user_name);
            this.l = (TextView) this.f23399i.findViewById(R.id.floor_owner);
            this.m = (ImageView) this.f23399i.findViewById(R.id.icon_forum_level);
            this.r = (FrameLayout) this.f23399i.findViewById(R.id.pb_head_headImage_container);
            HeadPendantView headPendantView = (HeadPendantView) this.f23399i.findViewById(R.id.pb_pendant_head_owner_photo);
            this.n = headPendantView;
            headPendantView.setHasPendantStyle();
            this.o = (TBLottieAnimationView) this.f23399i.findViewById(R.id.pb_head_living_lottie);
            this.f23399i.setOnLongClickListener(this.f23394d);
            this.f23399i.setOnTouchListener(this.f23392b);
            this.f23399i.setVisibility(8);
            if (this.n.getHeadView() != null) {
                this.n.getHeadView().setIsRound(true);
                this.n.getHeadView().setDrawBorder(true);
                this.n.getHeadView().setPlaceHolder(1);
            }
            this.p = (UserIconBox) this.f23399i.findViewById(R.id.show_icon_vip);
            this.q = (UserIconBox) this.f23399i.findViewById(R.id.show_icon_yinji);
            this.s = (LinearLayout) this.f23396f.findViewById(R.id.pb_head_owner_info_root);
            this.t = (LinearLayout) this.f23399i.findViewById(R.id.pb_first_floor_location_container);
            this.v = (PbFirstFloorUserLikeButton) this.f23399i.findViewById(R.id.pb_like_button);
            this.w = (PbFirstFloorMessageButton) this.f23399i.findViewById(R.id.pb_message_button);
            this.y = new e(this, (TextView) this.f23399i.findViewById(R.id.pb_views), (TBSpecificationBtn) this.f23399i.findViewById(R.id.pb_views_btn));
            this.z = (TextView) this.f23399i.findViewById(R.id.pb_item_first_floor_reply_time);
            this.A = (TextView) this.f23399i.findViewById(R.id.pb_item_first_floor_location_address);
            this.B = (TextView) this.f23399i.findViewById(R.id.pb_item_first_floor_distance);
            this.C = (TextView) this.f23399i.findViewById(R.id.pb_item_first_floor_general_desc);
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

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f23396f, R.color.CAM_X0205);
            ImageView imageView = this.m;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.F));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.v;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.onChangeSkinType(i2);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.w;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.onChangeSkinType(i2);
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
                eVar.e(i2);
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
                userIconBox.onChangeSkin(i2);
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.r0.j0.g gVar = this.f23395e;
            if (gVar != null) {
                gVar.I();
            }
            ColumnLayout columnLayout = this.f23399i;
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

    public void v(c.a.r0.u2.h.f fVar, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{fVar, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || fVar == null || postData == null) {
            return;
        }
        String Q = fVar != null ? fVar.Q() : "";
        int i2 = s0.i(fVar);
        if (z && postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
        }
        if (this.x == null) {
            e2 O = fVar.O();
            int i3 = 1;
            if (O != null) {
                if (O.Q1()) {
                    i3 = 4;
                } else if (O.T1()) {
                    i3 = 6;
                } else if (O.S1()) {
                    i3 = 7;
                } else if (O.R1()) {
                    i3 = 5;
                } else if (O.J2()) {
                    i3 = 8;
                }
            }
            r0 r0Var = new r0(this.a.getPageContext(), this.v, i3);
            this.x = r0Var;
            r0Var.l(this.a.getUniqueId());
            this.x.v(O);
        }
        if (postData != null && postData.t() != null) {
            postData.t().setIsLike(postData.t().hadConcerned());
            this.x.n(postData.t());
            this.x.x(Q);
        }
        r0 r0Var2 = this.x;
        r0Var2.t = z2;
        r0Var2.w(i2);
    }

    public void w(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f23396f);
    }

    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onLongClickListener) == null) {
            this.f23394d = onLongClickListener;
            this.f23399i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void y(PostData postData, c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, postData, fVar) == null) || postData == null || fVar == null) {
            return;
        }
        if (postData.O() != null) {
            this.f23400j.setData(this.a.getPageContext(), fVar.F().get(0).O(), c.a.r0.y3.m0.a.a("PB", "c0132", fVar.l().getId(), fVar.l().getName(), fVar.O().h0(), this.a.isFromFrs() ? "FRS" : null));
            ColumnLayout columnLayout = this.f23399i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds20), this.f23399i.getPaddingRight(), this.f23399i.getPaddingBottom());
            return;
        }
        this.f23400j.setData(null, null, null);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f23398h.g(z);
        }
    }
}
