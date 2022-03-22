package c.a.p0.w1;

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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.a4.c0;
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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageViewerActivity a;

    /* renamed from: b  reason: collision with root package name */
    public b f19669b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f19670c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f19671d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19672e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19673f;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f19669b == null) {
                return;
            }
            this.a.f19669b.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends PopupWindow implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Activity a;

        /* renamed from: b  reason: collision with root package name */
        public View f19674b;

        /* renamed from: c  reason: collision with root package name */
        public EMTextView f19675c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f19676d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f19677e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f19678f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f19679g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19680h;
        public MultiImageView i;
        public c.a.o0.s.g.g j;
        public final /* synthetic */ f k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, Activity activity) {
            super(activity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = fVar;
            this.a = activity;
            this.j = new c.a.o0.s.g.g(activity, null);
            setWidth(n.k(activity) - (fVar.f19673f * 2));
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
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d9, (ViewGroup) null);
                this.f19674b = inflate;
                this.f19675c = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f09202b);
                ImageView imageView = (ImageView) this.f19674b.findViewById(R.id.obfuscated_res_0x7f09198f);
                this.f19676d = imageView;
                imageView.setImageDrawable(this.a.getDrawable(R.drawable.obfuscated_res_0x7f080820));
                this.f19676d.setOnClickListener(this);
                ImageView imageView2 = (ImageView) this.f19674b.findViewById(R.id.obfuscated_res_0x7f091994);
                this.f19677e = imageView2;
                imageView2.setImageDrawable(this.a.getDrawable(R.drawable.obfuscated_res_0x7f080821));
                this.f19677e.setOnClickListener(this);
                ImageView imageView3 = (ImageView) this.f19674b.findViewById(R.id.obfuscated_res_0x7f09245c);
                this.f19678f = imageView3;
                imageView3.setImageDrawable(this.a.getDrawable(R.drawable.obfuscated_res_0x7f080823));
                this.f19678f.setOnClickListener(this);
                ImageView imageView4 = (ImageView) this.f19674b.findViewById(R.id.obfuscated_res_0x7f09245e);
                this.f19679g = imageView4;
                imageView4.setImageDrawable(this.a.getDrawable(R.drawable.obfuscated_res_0x7f08081f));
                this.f19679g.setOnClickListener(this);
                ImageView imageView5 = (ImageView) this.f19674b.findViewById(R.id.obfuscated_res_0x7f09245b);
                this.f19680h = imageView5;
                imageView5.setImageDrawable(this.a.getDrawable(R.drawable.obfuscated_res_0x7f080a20));
                this.f19680h.setOnClickListener(this);
                setContentView(this.f19674b);
            }
        }

        public final ShareItem b() {
            InterceptResult invokeV;
            UrlDragImageView currentUrlDragImageView;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                MultiImageView multiImageView = this.i;
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
                    str = this.i.getCurrentImageUrl();
                    str2 = TbMd5.getNameMd5FromUrl(str);
                }
                ShareItem shareItem = new ShareItem();
                int i = 5;
                if (imageUrlData != null) {
                    long j = imageUrlData.threadId;
                    if (j > 0) {
                        shareItem.t = "http://tieba.baidu.com/p/" + j + "?fr=share";
                    }
                    shareItem.K = j + "";
                    shareItem.J = imageUrlData.forumId;
                    i = this.k.e(imageUrlData.from);
                }
                if (!m.isEmpty(str)) {
                    shareItem.v = Uri.parse(str);
                    shareItem.b0 = 2;
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
                bundle2.putInt("obj_source", i);
                bundle2.putInt("obj_locate", 12);
                shareItem.k(bundle2);
                return shareItem;
            }
            return (ShareItem) invokeV.objValue;
        }

        public final boolean c(ShareItem shareItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.t0) || TextUtils.isEmpty(shareItem.u0)) ? false : true : invokeL.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setViewTextColor(this.f19675c, (int) R.color.CAM_X0109);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f19674b);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0204);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.i = null;
                this.a = null;
                this.j = null;
            }
        }

        public void f(MultiImageView multiImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, multiImageView) == null) {
                this.i = multiImageView;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareItem b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || (b2 = b()) == null) {
                return;
            }
            if (!l.z()) {
                n.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f111d);
            } else if (view == this.f19676d) {
                if (c0.b(this.a, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        c.a.o0.s.g.a.e(b2, this.a, 8, null);
                        return;
                    } else {
                        this.j.o(b2);
                        return;
                    }
                }
                Activity activity = this.a;
                BdToast.c(activity, activity.getText(R.string.obfuscated_res_0x7f0f1128)).q();
            } else if (view == this.f19677e) {
                if (c0.b(this.a, "com.tencent.mobileqq")) {
                    if (c(b2) && b2.a() != null && b2.a().contains(4)) {
                        c.a.o0.s.g.a.e(b2, this.a, 4, null);
                        return;
                    } else {
                        this.j.p(b2);
                        return;
                    }
                }
                Activity activity2 = this.a;
                BdToast.c(activity2, activity2.getText(R.string.obfuscated_res_0x7f0f1128)).q();
            } else if (view == this.f19678f) {
                if (c(b2) && b2.a() != null && b2.a().contains(3)) {
                    c.a.o0.s.g.a.e(b2, this.a, 3, null);
                } else if (b2.j0 != 1) {
                    this.j.t(b2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_source", 22).param("tid", b2.K).param("fid", b2.J));
            } else if (view == this.f19679g) {
                if (c(b2) && b2.a() != null && b2.a().contains(2)) {
                    c.a.o0.s.g.a.e(b2, this.a, 2, null);
                } else if (b2.j0 == 1) {
                } else {
                    if (b2.f30352b) {
                        b2.s = "【" + b2.r + "】 " + b2.s;
                    }
                    this.j.u(b2);
                }
            } else if (view != this.f19680h || this.k.f19671d == null) {
            } else {
                this.k.f19671d.onClick(view);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19672e = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        this.f19673f = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
        this.a = imageViewerActivity;
        this.f19669b = new b(this, imageViewerActivity);
        this.f19670c = new a(this);
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
            b bVar = this.f19669b;
            if (bVar != null) {
                bVar.e();
            }
            this.a = null;
            this.f19671d = null;
        }
    }

    public void g(MultiImageView multiImageView, int i, View.OnClickListener onClickListener) {
        b bVar;
        String str;
        String str2;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, multiImageView, i, onClickListener) == null) || (bVar = this.f19669b) == null || multiImageView == null) {
            return;
        }
        if (!bVar.isShowing()) {
            c.a.d.f.m.g.m(this.f19669b, multiImageView, 81, 0, i + c.a.d.f.p.c.b(this.a) + this.f19672e);
            int i2 = 5;
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
                i2 = e2;
            }
            TiebaStatic.log(new StatisticItem("c14045").param("post_id", str3).param("tid", str).param("fid", str2).param("obj_source", i2));
        }
        this.f19669b.f(multiImageView);
        this.f19671d = onClickListener;
        c.a.d.f.m.e.a().removeCallbacks(this.f19670c);
        c.a.d.f.m.e.a().postDelayed(this.f19670c, 5000L);
    }
}
