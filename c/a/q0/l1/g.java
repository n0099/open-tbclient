package c.a.q0.l1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.i3.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageViewerActivity f21645a;

    /* renamed from: b  reason: collision with root package name */
    public b f21646b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f21647c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f21648d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21649e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21650f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f21651e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21651e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21651e.f21646b == null) {
                return;
            }
            this.f21651e.f21646b.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends PopupWindow implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Activity f21652e;

        /* renamed from: f  reason: collision with root package name */
        public View f21653f;

        /* renamed from: g  reason: collision with root package name */
        public EMTextView f21654g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f21655h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f21656i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f21657j;
        public ImageView k;
        public ImageView l;
        public MultiImageView m;
        public c.a.p0.t.g.g n;
        public final /* synthetic */ g o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = gVar;
            this.f21652e = activity;
            this.n = new c.a.p0.t.g.g(activity, null);
            setWidth(l.k(activity) - (gVar.f21650f * 2));
            setHeight(-2);
            setFocusable(false);
            setTouchable(true);
            setOutsideTouchable(true);
            setBackgroundDrawable(new ColorDrawable(0));
            a();
            d();
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View inflate = LayoutInflater.from(this.f21652e).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
                this.f21653f = inflate;
                this.f21654g = (EMTextView) inflate.findViewById(R.id.title);
                ImageView imageView = (ImageView) this.f21653f.findViewById(R.id.qq_friend);
                this.f21655h = imageView;
                imageView.setImageDrawable(this.f21652e.getDrawable(R.drawable.icon_mask_share_qq40_svg));
                this.f21655h.setOnClickListener(this);
                ImageView imageView2 = (ImageView) this.f21653f.findViewById(R.id.qq_zone);
                this.f21656i = imageView2;
                imageView2.setImageDrawable(this.f21652e.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
                this.f21656i.setOnClickListener(this);
                ImageView imageView3 = (ImageView) this.f21653f.findViewById(R.id.wechat_friend);
                this.f21657j = imageView3;
                imageView3.setImageDrawable(this.f21652e.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
                this.f21657j.setOnClickListener(this);
                ImageView imageView4 = (ImageView) this.f21653f.findViewById(R.id.wechat_timeline);
                this.k = imageView4;
                imageView4.setImageDrawable(this.f21652e.getDrawable(R.drawable.icon_mask_share_circle40_svg));
                this.k.setOnClickListener(this);
                ImageView imageView5 = (ImageView) this.f21653f.findViewById(R.id.wechat_emotion);
                this.l = imageView5;
                imageView5.setImageDrawable(this.f21652e.getDrawable(R.drawable.icon_share_wechatexpression));
                this.l.setOnClickListener(this);
                setContentView(this.f21653f);
            }
        }

        public final ShareItem b() {
            InterceptResult invokeV;
            UrlDragImageView currentUrlDragImageView;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                MultiImageView multiImageView = this.m;
                if (multiImageView == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
                    return null;
                }
                ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
                if (imageUrlData != null) {
                    str = imageUrlData.imageUrl;
                    str2 = BigImageLoaderProc.getNameMd5FromUrl(str);
                } else {
                    str = "";
                    str2 = str;
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.m.getCurrentImageUrl();
                    str2 = TbMd5.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                int i2 = 5;
                if (imageUrlData != null) {
                    long j2 = imageUrlData.threadId;
                    if (j2 > 0) {
                        shareItem.t = "http://tieba.baidu.com/p/" + j2 + "?fr=share";
                    }
                    shareItem.K = j2 + "";
                    shareItem.J = imageUrlData.forumId;
                    i2 = this.o.e(imageUrlData.from);
                }
                if (!k.isEmpty(str)) {
                    shareItem.v = Uri.parse(str);
                    shareItem.W = 2;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", "images");
                    bundle.putString("name", str2);
                    bundle.putBoolean("formatData", true);
                    bundle.putBoolean("isSubDir", true);
                    bundle.putBoolean("isSdcard", false);
                    bundle.putBoolean("isSavedCache", true);
                    shareItem.A = bundle;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("tid", shareItem.K);
                bundle2.putString("fid", shareItem.J);
                bundle2.putString("uid", TbadkCoreApplication.getCurrentAccount());
                bundle2.putInt("obj_source", i2);
                bundle2.putInt("obj_locate", 12);
                shareItem.k(bundle2);
                return shareItem;
            }
            return (ShareItem) invokeV.objValue;
        }

        public final boolean c(ShareItem shareItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.n0) || TextUtils.isEmpty(shareItem.o0)) ? false : true : invokeL.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.f21654g, R.color.CAM_X0109);
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f21653f);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0204);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.m = null;
                this.f21652e = null;
                this.n = null;
            }
        }

        public void f(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, multiImageView) == null) {
                this.m = multiImageView;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || (b2 = b()) == null) {
                return;
            }
            if (!j.z()) {
                l.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (view == this.f21655h) {
                if (z.b(this.f21652e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        c.a.p0.t.g.a.e(b2, this.f21652e, 8, null);
                        return;
                    } else {
                        this.n.h(b2);
                        return;
                    }
                }
                Activity activity = this.f21652e;
                BdToast.c(activity, activity.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.f21656i) {
                if (z.b(this.f21652e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        c.a.p0.t.g.a.e(b2, this.f21652e, 4, null);
                        return;
                    } else {
                        this.n.i(b2);
                        return;
                    }
                }
                Activity activity2 = this.f21652e;
                BdToast.c(activity2, activity2.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.f21657j) {
                if (c(b2) && b2.a() != null && b2.a().contains(3)) {
                    c.a.p0.t.g.a.e(b2, this.f21652e, 3, null);
                } else if (b2.e0 != 1) {
                    this.n.m(b2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_source", 22).param("tid", b2.K).param("fid", b2.J));
            } else if (view == this.k) {
                if (c(b2) && b2.a() != null && b2.a().contains(2)) {
                    c.a.p0.t.g.a.e(b2, this.f21652e, 2, null);
                } else if (b2.e0 == 1) {
                } else {
                    if (b2.f47978b) {
                        b2.s = "【" + b2.r + "】 " + b2.s;
                    }
                    this.n.n(b2);
                }
            } else if (view != this.l || this.o.f21648d == null) {
            } else {
                this.o.f21648d.onClick(view);
            }
        }
    }

    public g(ImageViewerActivity imageViewerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21649e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f21650f = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
        this.f21645a = imageViewerActivity;
        this.f21646b = new b(this, imageViewerActivity);
        this.f21647c = new a(this);
    }

    public final int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if ("index".equals(str)) {
                return 1;
            }
            if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
                return 2;
            }
            if ("hot_topic".equals(str)) {
                return 3;
            }
            return "frs".equals(str) ? 4 : 5;
        }
        return invokeL.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.f21646b;
            if (bVar != null) {
                bVar.e();
            }
            this.f21645a = null;
            this.f21648d = null;
        }
    }

    public void g(MultiImageView multiImageView, int i2, View.OnClickListener onClickListener) {
        b bVar;
        String str;
        String str2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, multiImageView, i2, onClickListener) == null) || (bVar = this.f21646b) == null || multiImageView == null) {
            return;
        }
        if (!bVar.isShowing()) {
            c.a.e.e.m.g.m(this.f21646b, multiImageView, 81, 0, i2 + c.a.e.e.p.a.b(this.f21645a) + this.f21649e);
            int i3 = 5;
            UrlDragImageView currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView();
            String str3 = "";
            if (currentUrlDragImageView == null || (imageUrlData = currentUrlDragImageView.getmAssistUrlData()) == null) {
                str = "";
                str2 = str;
            } else {
                String str4 = imageUrlData.threadId + "";
                str2 = imageUrlData.forumId + "";
                str3 = imageUrlData.postId + "";
                int e2 = e(imageUrlData.from);
                str = str4;
                i3 = e2;
            }
            TiebaStatic.log(new StatisticItem("c14045").param("post_id", str3).param("tid", str).param("fid", str2).param("obj_source", i3));
        }
        this.f21646b.f(multiImageView);
        this.f21648d = onClickListener;
        c.a.e.e.m.e.a().removeCallbacks(this.f21647c);
        c.a.e.e.m.e.a().postDelayed(this.f21647c, 5000L);
    }
}
