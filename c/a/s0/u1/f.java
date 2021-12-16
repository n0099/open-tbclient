package c.a.s0.u1;

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
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.s0.v3.b0;
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
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageViewerActivity a;

    /* renamed from: b  reason: collision with root package name */
    public b f24505b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f24506c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f24507d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24508e;

    /* renamed from: f  reason: collision with root package name */
    public final int f24509f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f24510e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24510e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f24510e.f24505b == null) {
                return;
            }
            this.f24510e.f24505b.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends PopupWindow implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Activity f24511e;

        /* renamed from: f  reason: collision with root package name */
        public View f24512f;

        /* renamed from: g  reason: collision with root package name */
        public EMTextView f24513g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f24514h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f24515i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f24516j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f24517k;
        public ImageView l;
        public MultiImageView m;
        public c.a.r0.t.g.g n;
        public final /* synthetic */ f o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, activity};
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
            this.o = fVar;
            this.f24511e = activity;
            this.n = new c.a.r0.t.g.g(activity, null);
            setWidth(m.k(activity) - (fVar.f24509f * 2));
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
                View inflate = LayoutInflater.from(this.f24511e).inflate(R.layout.image_viewer_download_dialog, (ViewGroup) null);
                this.f24512f = inflate;
                this.f24513g = (EMTextView) inflate.findViewById(R.id.title);
                ImageView imageView = (ImageView) this.f24512f.findViewById(R.id.qq_friend);
                this.f24514h = imageView;
                imageView.setImageDrawable(this.f24511e.getDrawable(R.drawable.icon_mask_share_qq40_svg));
                this.f24514h.setOnClickListener(this);
                ImageView imageView2 = (ImageView) this.f24512f.findViewById(R.id.qq_zone);
                this.f24515i = imageView2;
                imageView2.setImageDrawable(this.f24511e.getDrawable(R.drawable.icon_mask_share_qqzone40_svg));
                this.f24515i.setOnClickListener(this);
                ImageView imageView3 = (ImageView) this.f24512f.findViewById(R.id.wechat_friend);
                this.f24516j = imageView3;
                imageView3.setImageDrawable(this.f24511e.getDrawable(R.drawable.icon_mask_share_wechat40_svg));
                this.f24516j.setOnClickListener(this);
                ImageView imageView4 = (ImageView) this.f24512f.findViewById(R.id.wechat_timeline);
                this.f24517k = imageView4;
                imageView4.setImageDrawable(this.f24511e.getDrawable(R.drawable.icon_mask_share_circle40_svg));
                this.f24517k.setOnClickListener(this);
                ImageView imageView5 = (ImageView) this.f24512f.findViewById(R.id.wechat_emotion);
                this.l = imageView5;
                imageView5.setImageDrawable(this.f24511e.getDrawable(R.drawable.icon_share_wechatexpression));
                this.l.setOnClickListener(this);
                setContentView(this.f24512f);
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
                if (!l.isEmpty(str)) {
                    shareItem.v = Uri.parse(str);
                    shareItem.Z = 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.q0) || TextUtils.isEmpty(shareItem.r0)) ? false : true : invokeL.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.f24513g, R.color.CAM_X0109);
                c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.f24512f);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0204);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.m = null;
                this.f24511e = null;
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
            if (!k.z()) {
                m.L(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (view == this.f24514h) {
                if (b0.b(this.f24511e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        c.a.r0.t.g.a.e(b2, this.f24511e, 8, null);
                        return;
                    } else {
                        this.n.o(b2);
                        return;
                    }
                }
                Activity activity = this.f24511e;
                BdToast.c(activity, activity.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.f24515i) {
                if (b0.b(this.f24511e, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        c.a.r0.t.g.a.e(b2, this.f24511e, 4, null);
                        return;
                    } else {
                        this.n.p(b2);
                        return;
                    }
                }
                Activity activity2 = this.f24511e;
                BdToast.c(activity2, activity2.getText(R.string.share_qq_not_install)).q();
            } else if (view == this.f24516j) {
                if (c(b2) && b2.a() != null && b2.a().contains(3)) {
                    c.a.r0.t.g.a.e(b2, this.f24511e, 3, null);
                } else if (b2.h0 != 1) {
                    this.n.t(b2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_source", 22).param("tid", b2.K).param("fid", b2.J));
            } else if (view == this.f24517k) {
                if (c(b2) && b2.a() != null && b2.a().contains(2)) {
                    c.a.r0.t.g.a.e(b2, this.f24511e, 2, null);
                } else if (b2.h0 == 1) {
                } else {
                    if (b2.f42067b) {
                        b2.s = "【" + b2.r + "】 " + b2.s;
                    }
                    this.n.u(b2);
                }
            } else if (view != this.l || this.o.f24507d == null) {
            } else {
                this.o.f24507d.onClick(view);
            }
        }
    }

    public f(ImageViewerActivity imageViewerActivity) {
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
        this.f24508e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f24509f = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
        this.a = imageViewerActivity;
        this.f24505b = new b(this, imageViewerActivity);
        this.f24506c = new a(this);
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
            b bVar = this.f24505b;
            if (bVar != null) {
                bVar.e();
            }
            this.a = null;
            this.f24507d = null;
        }
    }

    public void g(MultiImageView multiImageView, int i2, View.OnClickListener onClickListener) {
        b bVar;
        String str;
        String str2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, multiImageView, i2, onClickListener) == null) || (bVar = this.f24505b) == null || multiImageView == null) {
            return;
        }
        if (!bVar.isShowing()) {
            c.a.d.f.m.g.m(this.f24505b, multiImageView, 81, 0, i2 + c.a.d.f.p.b.b(this.a) + this.f24508e);
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
        this.f24505b.f(multiImageView);
        this.f24507d = onClickListener;
        c.a.d.f.m.e.a().removeCallbacks(this.f24506c);
        c.a.d.f.m.e.a().postDelayed(this.f24506c, 5000L);
    }
}
