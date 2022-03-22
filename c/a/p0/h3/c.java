package c.a.p0.h3;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.e1.n.j;
import c.a.p0.c3.u;
import c.a.p0.l4.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.pushdialog.PushDialogVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PushDialogActivity a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f15440b;

    /* renamed from: c  reason: collision with root package name */
    public View f15441c;

    /* renamed from: d  reason: collision with root package name */
    public View f15442d;

    /* renamed from: e  reason: collision with root package name */
    public EditorScrollView f15443e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f15444f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15445g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f15446h;
    public TextView i;
    public TbRichTextView j;
    public PushDialogVideoView k;
    public ClickableHeaderImageView l;
    public TextView m;
    public TextView n;
    public CommonUserLikeButton o;
    public View p;
    public TextView q;
    public c.a.o0.e1.n.a r;
    public long s;
    public j t;
    public boolean u;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.u) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 1).param("tid", this.a.a.getTid()));
            this.a.u = true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || this.a.a.getScreenLockUtils() == null) {
                return;
            }
            this.a.a.getScreenLockUtils().d();
        }
    }

    public c(PushDialogActivity pushDialogActivity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushDialogActivity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.a = pushDialogActivity;
        pushDialogActivity.setContentView(i);
        this.f15442d = d(R.id.obfuscated_res_0x7f091aee);
        this.f15441c = d(R.id.obfuscated_res_0x7f0907ba);
        EditorScrollView editorScrollView = (EditorScrollView) d(R.id.obfuscated_res_0x7f091980);
        this.f15443e = editorScrollView;
        editorScrollView.setOverScrollMode(2);
        this.f15443e.setListener(new a(this));
        if (this.f15441c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f15441c.getLayoutParams();
            int i4 = n.i(this.a);
            layoutParams.height = i4 / 2;
            layoutParams.topMargin = (int) (i4 * 0.22f);
            this.f15441c.postInvalidate();
        }
        if (n.z()) {
            Drawable a2 = d.a();
            this.f15440b = a2;
            if (a2 != null && this.a.getWindow() != null) {
                this.a.getWindow().setBackgroundDrawable(this.f15440b);
            }
        }
        View d2 = d(R.id.obfuscated_res_0x7f09197e);
        this.p = d2;
        d2.setOnClickListener(this);
        this.q = (TextView) d(R.id.obfuscated_res_0x7f09068e);
        TbImageView tbImageView = (TbImageView) d(R.id.obfuscated_res_0x7f091982);
        this.f15444f = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081833);
        this.f15444f.setAutoChangeStyle(false);
        this.f15445g = (TextView) d(R.id.obfuscated_res_0x7f091983);
        this.i = (TextView) d(R.id.obfuscated_res_0x7f091981);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) d(R.id.obfuscated_res_0x7f091985);
        this.l = clickableHeaderImageView;
        clickableHeaderImageView.setBorderSurroundContent(true);
        this.l.setIsRound(true);
        this.l.setEnabled(false);
        this.l.setAutoChangeStyle(false);
        this.l.setBorderWidth(n.f(this.a, R.dimen.tbds1));
        this.l.setBorderColor(ContextCompat.getColor(this.a, R.color.black_alpha15));
        this.r = new c.a.o0.e1.n.a();
        TbRichTextView tbRichTextView = (TbRichTextView) d(R.id.obfuscated_res_0x7f09197f);
        this.j = tbRichTextView;
        tbRichTextView.setTextColor(ContextCompat.getColor(this.a, R.color.CAM_X0107));
        this.r.s(n.f(this.a, R.dimen.tbds38));
        this.r.v(n.f(this.a, R.dimen.tbds42));
        this.r.j(n.f(this.a, R.dimen.tbds23));
        this.r.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.r.i(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.j.setLayoutStrategy(this.r);
        PushDialogVideoView pushDialogVideoView = (PushDialogVideoView) d(R.id.obfuscated_res_0x7f091988);
        this.k = pushDialogVideoView;
        pushDialogVideoView.setPageContext(this.a.getPageContext());
        this.m = (TextView) d(R.id.obfuscated_res_0x7f091987);
        this.n = (TextView) d(R.id.obfuscated_res_0x7f091984);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) d(R.id.obfuscated_res_0x7f091986);
        this.o = commonUserLikeButton;
        commonUserLikeButton.setAfterOnClickListener(this);
        ImageView imageView = (ImageView) d(R.id.obfuscated_res_0x7f09079c);
        this.f15446h = imageView;
        imageView.setOnClickListener(this);
    }

    public final View d(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.a.findViewById(i) : (View) invokeI.objValue;
    }

    public void e() {
        PushDialogVideoView pushDialogVideoView;
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pushDialogVideoView = this.k) == null) {
            return;
        }
        pushDialogVideoView.setNetworkChange();
        if (!l.x() || !this.k.y() || (jVar = this.t) == null || jVar.c() <= 0 || this.t.b() <= 0) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        double c2 = ((this.t.c() * (1.0f - ((this.k.getCurrentPosition() * 1.0f) / (this.t.b() * 1000)))) * 1.0f) / 1048576.0f;
        if (c2 >= 0.1d) {
            n.N(this.a.getPageContext().getPageActivity(), String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f0a), decimalFormat.format(c2)));
        }
    }

    public void f() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pushDialogVideoView = this.k) == null) {
            return;
        }
        pushDialogVideoView.A();
    }

    public void g() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pushDialogVideoView = this.k) == null) {
            return;
        }
        pushDialogVideoView.B();
    }

    public void h() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pushDialogVideoView = this.k) == null) {
            return;
        }
        pushDialogVideoView.C();
    }

    public void i(c.a.p0.h3.d.a aVar) {
        int f2;
        int f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f15444f.J(aVar.a(), 17, false);
        this.f15445g.setText(aVar.b());
        if (aVar.d() != null) {
            this.l.setData(aVar.d());
            this.m.setText(aVar.d().getName_show());
            if (aVar.d().getGodUserData() != null && (!StringUtils.isNull(aVar.d().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.d().getGodUserData().getIntro()))) {
                this.n.setText(aVar.d().getGodUserData().getForumName() + "吧 " + aVar.d().getGodIntro());
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.d().getUserId())) {
                this.o.setVisibility(8);
            } else {
                new c.a.o0.r.l0.t.c(this.a.getPageContext(), this.o).n(aVar.d());
                this.o.g(0);
                this.o.setVisibility(0);
            }
            c.a.p0.h3.d.b c2 = aVar.c();
            if (c2 == null) {
                this.a.getScreenLockUtils().d();
                this.a.finish();
                return;
            }
            boolean z = c2.a() == null || ListUtils.isEmpty(c2.a().A());
            if (StringUtils.isNull(c2.d()) && z) {
                this.a.getScreenLockUtils().d();
                this.a.finish();
                return;
            }
            if (c2.a() != null) {
                Iterator<TbRichTextData> it = c2.a().A().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        this.t = next.N();
                    }
                    if (this.t != null) {
                        break;
                    }
                }
            }
            this.s = c2.c();
            if (this.t == null) {
                this.k.setVisibility(8);
                this.j.setVisibility(0);
                boolean z2 = l.v() || l.H();
                this.r.w(z2);
                if (z2) {
                    f2 = (n.k(TbadkCoreApplication.getInst()) - (n.f(this.a, R.dimen.tbds22) * 2)) - (n.f(this.a, R.dimen.tbds44) * 2);
                    f3 = (int) (f2 * 1.618f);
                } else {
                    f2 = n.f(this.a, R.dimen.tbds360);
                    f3 = n.f(this.a, R.dimen.tbds202);
                }
                this.r.k(z2);
                this.r.q(f2);
                this.r.p(f3);
                this.j.setText(c2.a());
            } else {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                int k = n.k(this.a) - n.f(this.a, R.dimen.tbds132);
                layoutParams.width = k;
                layoutParams.height = (int) (k * 0.5625f);
                this.k.setLayoutParams(layoutParams);
                this.k.setTbRichTextVideoInfo(this.t);
                this.k.stopPlay();
                this.k.setThumbnail(this.t.d());
                this.k.setVideoUrl(this.t.e(), String.valueOf(this.s));
                this.k.E();
                u uVar = new u();
                uVar.a = "15";
                uVar.f13504c = String.valueOf(this.s);
                uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
                this.k.setVideoViewBusiness(uVar);
            }
            if (StringUtils.isNull(c2.d())) {
                this.i.setVisibility(8);
            } else {
                this.i.setText(c2.d());
                this.i.setVisibility(0);
            }
            this.q.setText(String.format(Locale.CHINA, this.a.getString(R.string.obfuscated_res_0x7f0f032c), Integer.valueOf(c2.b())));
            if (this.a.getScreenLockUtils().c()) {
                return;
            }
            this.a.getScreenLockUtils().e();
            return;
        }
        this.a.getScreenLockUtils().d();
        this.a.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.f15446h) {
                TiebaStatic.log(new StatisticItem("c13198").param("tid", this.a.getTid()));
                e.a().postDelayed(new b(this), 100L);
                this.a.finish();
            } else if (view == this.p) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 4).param("tid", this.a.getTid()));
                if (this.s == 0) {
                    this.a.finish();
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(this.s + "", null, null)));
                this.a.getScreenLockUtils().e();
                this.a.finish();
            } else if (view == this.o) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 3).param("tid", this.a.getTid()));
            }
        }
    }
}
