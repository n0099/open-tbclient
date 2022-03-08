package c.a.r0.f3;

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
import c.a.q0.e1.n.j;
import c.a.r0.a3.t;
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

    /* renamed from: e  reason: collision with root package name */
    public final PushDialogActivity f17418e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f17419f;

    /* renamed from: g  reason: collision with root package name */
    public View f17420g;

    /* renamed from: h  reason: collision with root package name */
    public View f17421h;

    /* renamed from: i  reason: collision with root package name */
    public EditorScrollView f17422i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f17423j;
    public TextView k;
    public ImageView l;
    public TextView m;
    public TbRichTextView n;
    public PushDialogVideoView o;
    public ClickableHeaderImageView p;
    public TextView q;
    public TextView r;
    public CommonUserLikeButton s;
    public View t;
    public TextView u;
    public c.a.q0.e1.n.a v;
    public long w;
    public j x;
    public boolean y;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.y) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 1).param("tid", this.a.f17418e.getTid()));
            this.a.y = true;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17424e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17424e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17424e.f17418e == null || this.f17424e.f17418e.getScreenLockUtils() == null) {
                return;
            }
            this.f17424e.f17418e.getScreenLockUtils().d();
        }
    }

    public c(PushDialogActivity pushDialogActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pushDialogActivity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = false;
        this.f17418e = pushDialogActivity;
        pushDialogActivity.setContentView(i2);
        this.f17421h = d(R.id.root_view);
        this.f17420g = d(R.id.dialog_wrapper_view);
        EditorScrollView editorScrollView = (EditorScrollView) d(R.id.push_dialog_content_layout);
        this.f17422i = editorScrollView;
        editorScrollView.setOverScrollMode(2);
        this.f17422i.setListener(new a(this));
        if (this.f17420g.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17420g.getLayoutParams();
            int i5 = n.i(this.f17418e);
            layoutParams.height = i5 / 2;
            layoutParams.topMargin = (int) (i5 * 0.22f);
            this.f17420g.postInvalidate();
        }
        if (n.z()) {
            Drawable a2 = c.a.r0.j4.c.a();
            this.f17419f = a2;
            if (a2 != null && this.f17418e.getWindow() != null) {
                this.f17418e.getWindow().setBackgroundDrawable(this.f17419f);
            }
        }
        View d2 = d(R.id.push_dialog_bottom_layout);
        this.t = d2;
        d2.setOnClickListener(this);
        this.u = (TextView) d(R.id.comment_num);
        TbImageView tbImageView = (TbImageView) d(R.id.push_dialog_title_img);
        this.f17423j = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.tb_launcher_icon);
        this.f17423j.setAutoChangeStyle(false);
        this.k = (TextView) d(R.id.push_dialog_title_text);
        this.m = (TextView) d(R.id.push_dialog_content_title);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) d(R.id.push_dialog_user_head);
        this.p = clickableHeaderImageView;
        clickableHeaderImageView.setBorderSurroundContent(true);
        this.p.setIsRound(true);
        this.p.setEnabled(false);
        this.p.setAutoChangeStyle(false);
        this.p.setBorderWidth(n.f(this.f17418e, R.dimen.tbds1));
        this.p.setBorderColor(ContextCompat.getColor(this.f17418e, R.color.black_alpha15));
        this.v = new c.a.q0.e1.n.a();
        TbRichTextView tbRichTextView = (TbRichTextView) d(R.id.push_dialog_content);
        this.n = tbRichTextView;
        tbRichTextView.setTextColor(ContextCompat.getColor(this.f17418e, R.color.CAM_X0107));
        this.v.s(n.f(this.f17418e, R.dimen.tbds38));
        this.v.v(n.f(this.f17418e, R.dimen.tbds42));
        this.v.j(n.f(this.f17418e, R.dimen.tbds23));
        this.v.o(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.v.i(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.n.setLayoutStrategy(this.v);
        PushDialogVideoView pushDialogVideoView = (PushDialogVideoView) d(R.id.push_dialog_video);
        this.o = pushDialogVideoView;
        pushDialogVideoView.setPageContext(this.f17418e.getPageContext());
        this.q = (TextView) d(R.id.push_dialog_user_name);
        this.r = (TextView) d(R.id.push_dialog_user_god_info);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) d(R.id.push_dialog_user_like_btn);
        this.s = commonUserLikeButton;
        commonUserLikeButton.setAfterOnClickListener(this);
        ImageView imageView = (ImageView) d(R.id.dialog_close_btn);
        this.l = imageView;
        imageView.setOnClickListener(this);
    }

    public final View d(@IdRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f17418e.findViewById(i2) : (View) invokeI.objValue;
    }

    public void e() {
        PushDialogVideoView pushDialogVideoView;
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pushDialogVideoView = this.o) == null) {
            return;
        }
        pushDialogVideoView.setNetworkChange();
        if (!l.x() || !this.o.isVideoPlaying() || (jVar = this.x) == null || jVar.c() <= 0 || this.x.b() <= 0) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        double c2 = ((this.x.c() * (1.0f - ((this.o.getCurrentPosition() * 1.0f) / (this.x.b() * 1000)))) * 1.0f) / 1048576.0f;
        if (c2 >= 0.1d) {
            n.N(this.f17418e.getPageContext().getPageActivity(), String.format(this.f17418e.getPageContext().getString(R.string.push_dialog_video_net_change_tip), decimalFormat.format(c2)));
        }
    }

    public void f() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (pushDialogVideoView = this.o) == null) {
            return;
        }
        pushDialogVideoView.onDestroy();
    }

    public void g() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pushDialogVideoView = this.o) == null) {
            return;
        }
        pushDialogVideoView.onPause();
    }

    public void h() {
        PushDialogVideoView pushDialogVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pushDialogVideoView = this.o) == null) {
            return;
        }
        pushDialogVideoView.onResume();
    }

    public void i(c.a.r0.f3.d.a aVar) {
        int f2;
        int f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f17423j.startLoad(aVar.a(), 17, false);
        this.k.setText(aVar.b());
        if (aVar.d() != null) {
            this.p.setData(aVar.d());
            this.q.setText(aVar.d().getName_show());
            if (aVar.d().getGodUserData() != null && (!StringUtils.isNull(aVar.d().getGodUserData().getForumName()) || !StringUtils.isNull(aVar.d().getGodUserData().getIntro()))) {
                this.r.setText(aVar.d().getGodUserData().getForumName() + "吧 " + aVar.d().getGodIntro());
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.d().getUserId())) {
                this.s.setVisibility(8);
            } else {
                new c.a.q0.r.l0.t.c(this.f17418e.getPageContext(), this.s).n(aVar.d());
                this.s.onChangeSkinType(0);
                this.s.setVisibility(0);
            }
            c.a.r0.f3.d.b c2 = aVar.c();
            if (c2 == null) {
                this.f17418e.getScreenLockUtils().d();
                this.f17418e.finish();
                return;
            }
            boolean z = c2.a() == null || ListUtils.isEmpty(c2.a().y());
            if (StringUtils.isNull(c2.d()) && z) {
                this.f17418e.getScreenLockUtils().d();
                this.f17418e.finish();
                return;
            }
            if (c2.a() != null) {
                Iterator<TbRichTextData> it = c2.a().y().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        this.x = next.L();
                    }
                    if (this.x != null) {
                        break;
                    }
                }
            }
            this.w = c2.c();
            if (this.x == null) {
                this.o.setVisibility(8);
                this.n.setVisibility(0);
                boolean z2 = l.v() || l.H();
                this.v.w(z2);
                if (z2) {
                    f2 = (n.k(TbadkCoreApplication.getInst()) - (n.f(this.f17418e, R.dimen.tbds22) * 2)) - (n.f(this.f17418e, R.dimen.tbds44) * 2);
                    f3 = (int) (f2 * 1.618f);
                } else {
                    f2 = n.f(this.f17418e, R.dimen.tbds360);
                    f3 = n.f(this.f17418e, R.dimen.tbds202);
                }
                this.v.k(z2);
                this.v.q(f2);
                this.v.p(f3);
                this.n.setText(c2.a());
            } else {
                this.n.setVisibility(8);
                this.o.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
                int k = n.k(this.f17418e) - n.f(this.f17418e, R.dimen.tbds132);
                layoutParams.width = k;
                layoutParams.height = (int) (k * 0.5625f);
                this.o.setLayoutParams(layoutParams);
                this.o.setTbRichTextVideoInfo(this.x);
                this.o.stopPlay();
                this.o.setThumbnail(this.x.e());
                this.o.setVideoUrl(this.x.f(), String.valueOf(this.w));
                this.o.resetPlayerUI();
                t tVar = new t();
                tVar.a = "15";
                tVar.f14940c = String.valueOf(this.w);
                tVar.f14942e = TbadkCoreApplication.getCurrentAccount();
                this.o.setVideoViewBusiness(tVar);
            }
            if (StringUtils.isNull(c2.d())) {
                this.m.setVisibility(8);
            } else {
                this.m.setText(c2.d());
                this.m.setVisibility(0);
            }
            this.u.setText(String.format(Locale.CHINA, this.f17418e.getString(R.string.bottom_comment), Integer.valueOf(c2.b())));
            if (this.f17418e.getScreenLockUtils().c()) {
                return;
            }
            this.f17418e.getScreenLockUtils().e();
            return;
        }
        this.f17418e.getScreenLockUtils().d();
        this.f17418e.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.l) {
                TiebaStatic.log(new StatisticItem("c13198").param("tid", this.f17418e.getTid()));
                e.a().postDelayed(new b(this), 100L);
                this.f17418e.finish();
            } else if (view == this.t) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 4).param("tid", this.f17418e.getTid()));
                if (this.w == 0) {
                    this.f17418e.finish();
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f17418e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(this.w + "", null, null)));
                this.f17418e.getScreenLockUtils().e();
                this.f17418e.finish();
            } else if (view == this.s) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 3).param("tid", this.f17418e.getTid()));
            }
        }
    }
}
