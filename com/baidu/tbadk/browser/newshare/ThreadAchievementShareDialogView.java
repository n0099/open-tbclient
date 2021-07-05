package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.r0.z0.n;
import d.a.s0.h2.k.e.x0;
/* loaded from: classes4.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public FrameLayout C;
    public int D;
    public ImageView E;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadAchievementShareInfo f12156e;

    /* renamed from: f  reason: collision with root package name */
    public Gson f12157f;

    /* renamed from: g  reason: collision with root package name */
    public Context f12158g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12159h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12160i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public PermissionJudgePolicy q;
    public x0 r;
    public TbPageContext s;
    public d.a.r0.r.s.a t;
    public Bitmap u;
    public View v;
    public ImageView w;
    public LinearLayout x;
    public FrameLayout y;
    public HeadImageView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12161e;

        public a(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12161e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f12161e.t != null && this.f12161e.t.isShowing()) {
                this.f12161e.t.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12162e;

        public b(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12162e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f12162e;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.k());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12163e;

        public c(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12163e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f12163e;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12164e;

        public d(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12164e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f12164e;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12165e;

        public e(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12165e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f12165e;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 4);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12166e;

        public f(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12166e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f12166e;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12167e;

        public g(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12167e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f12167e;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f12168a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f12169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12170c;

        public h(ThreadAchievementShareDialogView threadAchievementShareDialogView, Bitmap bitmap, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView, bitmap, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12170c = threadAchievementShareDialogView;
            this.f12168a = bitmap;
            this.f12169b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12170c.j(this.f12168a, this.f12169b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f12171a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f12172b;

        public i(ThreadAchievementShareDialogView threadAchievementShareDialogView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12172b = threadAchievementShareDialogView;
            this.f12171a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f12172b.f12158g, this.f12171a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        this.f12157f = new Gson();
        this.f12158g = context;
        this.f12156e = m(str);
    }

    private int getTextViewWidth() {
        InterceptResult invokeV;
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int g2 = l.g(this.f12158g, R.dimen.tbds44);
            int g3 = l.g(this.f12158g, R.dimen.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.f12158g) == 2) {
                k = l.i(this.f12158g);
            } else {
                k = l.k(this.f12158g);
            }
            return ((k - (g2 * 2)) - g3) / 6;
        }
        return invokeV.intValue;
    }

    public final void f() {
        ThreadAchievementShareInfo threadAchievementShareInfo;
        String user_img;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (threadAchievementShareInfo = this.f12156e) == null || threadAchievementShareInfo.getParams() == null) {
            return;
        }
        ThreadAchievementShareInfo.UserBean user = this.f12156e.getParams().getUser();
        if (!TextUtils.isEmpty(user.getImg())) {
            user_img = user.getImg();
        } else {
            user_img = user.getUser_img();
        }
        HeadImageView headImageView = this.z;
        headImageView.M("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
        this.o.setText(user.getUsername());
        if (!TextUtils.isEmpty(this.f12156e.getParams().getUrl())) {
            i(this.f12156e.getParams().getUrl());
            this.w.setVisibility(0);
            return;
        }
        this.w.setVisibility(8);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.q == null) {
                this.q = new PermissionJudgePolicy();
            }
            this.q.clearRequestPermissionList();
            this.q.appendRequestPermission(this.s.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            return this.q.startRequestPermission(this.s.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public boolean h(TbPageContext tbPageContext, d.a.r0.r.s.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, aVar)) == null) {
            this.s = tbPageContext;
            this.t = aVar;
            l(this.f12158g);
            if (this.f12156e.getParams() != null && !ListUtils.isEmpty(this.f12156e.getParams().getThread_list())) {
                this.y.addView(new d.a.r0.l.f.a(this.f12158g, this.f12156e).a());
                this.p.setText(this.f12156e.getParams().getTitle());
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                this.D = 2;
            } else if (this.f12156e.getParams() != null) {
                if (this.f12156e.getParams().getVideo_info() != null) {
                    this.y.addView(new d.a.r0.l.f.c(this.f12158g, this.f12156e).a());
                } else {
                    this.y.addView(new d.a.r0.l.f.b(this.f12158g, this.f12156e).a());
                }
                this.p.setText(this.f12156e.getParams().getTitle());
                StatisticItem statisticItem2 = new StatisticItem("c10898");
                statisticItem2.param("obj_source", 2);
                TiebaStatic.log(statisticItem2);
                this.D = 3;
            }
            f();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void i(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.w.setImageBitmap((Bitmap) runTask.getData());
    }

    public final ShareItem j(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bitmap, i2)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.c0 = false;
            shareItem.b0 = false;
            shareItem.W = 1;
            shareItem.r = this.f12158g.getString(R.string.app_name);
            shareItem.s = "";
            shareItem.i(bitmap);
            shareItem.g();
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public Bitmap k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.u == null) {
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.v, R.drawable.pic_announcement);
                this.x.buildDrawingCache();
                this.u = this.x.getDrawingCache();
            }
            SkinManager.setBackgroundResource(this.x, R.drawable.bg_frs_private_dialog);
            SkinManager.setBackgroundResource(this.v, R.drawable.pic_announcement_round);
            return this.u;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_share);
            this.f12159h = linearLayout;
            this.v = linearLayout.findViewById(R.id.poster_head_bg);
            SkinManager.setBackgroundResource(this.f12159h, R.drawable.bg_frs_private_dialog);
            SkinManager.setBackgroundResource(this.v, R.drawable.pic_announcement_round);
            this.y = (FrameLayout) this.f12159h.findViewById(R.id.poster_container);
            this.p = (TextView) this.f12159h.findViewById(R.id.achievement_desc);
            this.z = (HeadImageView) this.f12159h.findViewById(R.id.head_portrait);
            TextView textView = (TextView) this.f12159h.findViewById(R.id.user_name);
            this.o = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
            this.z.setIsRound(true);
            this.z.setPlaceHolder(2);
            this.z.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.x = (LinearLayout) this.f12159h.findViewById(R.id.share_view_layout);
            this.w = (ImageView) this.f12159h.findViewById(R.id.share_qrcode);
            this.A = (TextView) this.f12159h.findViewById(R.id.qrcode_top_desc);
            this.B = (TextView) this.f12159h.findViewById(R.id.qrcode_bottom_desc);
            this.C = (FrameLayout) this.f12159h.findViewById(R.id.qrcode_layout);
            ImageView imageView = (ImageView) this.f12159h.findViewById(R.id.close_button);
            this.E = imageView;
            imageView.setOnClickListener(new a(this));
            SkinManager.setImageResource(this.E, R.drawable.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.x, R.drawable.bg_frs_private_dialog);
            TextView textView2 = (TextView) this.f12159h.findViewById(R.id.frs_private_share_download);
            this.f12160i = textView2;
            o(textView2, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.f12160i.setOnClickListener(new b(this));
            TextView textView3 = (TextView) this.f12159h.findViewById(R.id.frs_private_share_wechat);
            this.j = textView3;
            o(textView3, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            this.j.setOnClickListener(new c(this));
            TextView textView4 = (TextView) this.f12159h.findViewById(R.id.frs_private_share_moment);
            this.k = textView4;
            o(textView4, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            this.k.setOnClickListener(new d(this));
            TextView textView5 = (TextView) this.f12159h.findViewById(R.id.frs_private_share_qzone);
            this.l = textView5;
            o(textView5, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            this.l.setOnClickListener(new e(this));
            TextView textView6 = (TextView) this.f12159h.findViewById(R.id.frs_private_share_qq);
            this.m = textView6;
            o(textView6, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            this.m.setOnClickListener(new f(this));
            TextView textView7 = (TextView) this.f12159h.findViewById(R.id.frs_private_share_weibo);
            this.n = textView7;
            o(textView7, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            this.n.setOnClickListener(new g(this));
        }
    }

    public final ThreadAchievementShareInfo m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (ThreadAchievementShareInfo) this.f12157f.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
        }
        return (ThreadAchievementShareInfo) invokeL.objValue;
    }

    public final void n(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) || g()) {
            return;
        }
        if (this.r == null) {
            this.r = new x0(this.s);
        }
        if (this.f12156e.getParams() != null && !TextUtils.isEmpty(this.f12156e.getParams().getUrl())) {
            this.r.b(this.f12156e.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
        } else {
            this.r.b("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
        this.E.performClick();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.D);
        TiebaStatic.log(statisticItem);
    }

    public final void o(TextView textView, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, textView, absSvgType) == null) || absSvgType == null) {
            return;
        }
        Drawable drawable = absSvgType.getDrawable();
        int g2 = l.g(getContext(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = getTextViewWidth();
        textView.setLayoutParams(layoutParams);
    }

    public final void p(Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, bitmap, i2) == null) || bitmap == null || g()) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i2 == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i2 == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i2 == 4) {
            statisticItem.param("obj_type", 5);
        } else {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.D);
        TiebaStatic.log(statisticItem);
        i0.b(new h(this, bitmap, i2), new i(this, i2));
    }
}
