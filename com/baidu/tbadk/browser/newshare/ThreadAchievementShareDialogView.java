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
import c.a.e.e.p.l;
import c.a.o0.b1.h0;
import c.a.o0.b1.k0;
import c.a.o0.b1.n;
import c.a.p0.i2.k.e.w0;
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
/* loaded from: classes6.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HOT_LIST_VIEW_TYPE = "hot";
    public static final String THREAD_IMG_HOST = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static final String THREAD_IMG_SUFFIX = ".jpg";
    public static final String THREAD_INTERACTION_VIEW_TYPE = "interaction";
    public static final String VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public FrameLayout B;
    public int C;
    public ImageView D;

    /* renamed from: e  reason: collision with root package name */
    public Gson f47120e;

    /* renamed from: f  reason: collision with root package name */
    public Context f47121f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f47122g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47123h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47124i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47125j;
    public TextView k;
    public TextView l;
    public TextView m;
    public final ThreadAchievementShareInfo mShareInfo;
    public TextView n;
    public TextView o;
    public PermissionJudgePolicy p;
    public w0 q;
    public TbPageContext r;
    public c.a.o0.s.s.a s;
    public Bitmap t;
    public View u;
    public ImageView v;
    public LinearLayout w;
    public FrameLayout x;
    public HeadImageView y;
    public TextView z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47126e;

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
            this.f47126e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f47126e.s != null && this.f47126e.s.isShowing()) {
                this.f47126e.s.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47127e;

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
            this.f47127e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f47127e;
                threadAchievementShareDialogView.l(threadAchievementShareDialogView.generateSharedImg());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47128e;

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
            this.f47128e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f47128e;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.generateSharedImg(), 3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47129e;

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
            this.f47129e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f47129e;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.generateSharedImg(), 2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47130e;

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
            this.f47130e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f47130e;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.generateSharedImg(), 4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47131e;

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
            this.f47131e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f47131e;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.generateSharedImg(), 8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47132e;

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
            this.f47132e = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.f47132e;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.generateSharedImg(), 6);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends h0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f47133a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f47134b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47135c;

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
            this.f47135c = threadAchievementShareDialogView;
            this.f47133a = bitmap;
            this.f47134b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.h0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47135c.i(this.f47133a, this.f47134b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f47136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f47137b;

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
            this.f47137b = threadAchievementShareDialogView;
            this.f47136a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f47137b.f47121f, this.f47136a, shareItem, false));
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
        this.f47120e = new Gson();
        this.f47121f = context;
        this.mShareInfo = k(str);
    }

    private int getTextViewWidth() {
        InterceptResult invokeV;
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            int g2 = l.g(this.f47121f, R.dimen.tbds44);
            int g3 = l.g(this.f47121f, R.dimen.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.f47121f) == 2) {
                k = l.i(this.f47121f);
            } else {
                k = l.k(this.f47121f);
            }
            return ((k - (g2 * 2)) - g3) / 6;
        }
        return invokeV.intValue;
    }

    public boolean configShareDialog(TbPageContext tbPageContext, c.a.o0.s.s.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, aVar)) == null) {
            this.r = tbPageContext;
            this.s = aVar;
            j(this.f47121f);
            if (this.mShareInfo.getParams() != null && !ListUtils.isEmpty(this.mShareInfo.getParams().getThread_list())) {
                this.x.addView(new c.a.o0.m.f.a(this.f47121f, this.mShareInfo).a());
                this.o.setText(this.mShareInfo.getParams().getTitle());
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                this.C = 2;
            } else if (this.mShareInfo.getParams() != null) {
                if (this.mShareInfo.getParams().getVideo_info() != null) {
                    this.x.addView(new c.a.o0.m.f.c(this.f47121f, this.mShareInfo).a());
                } else {
                    this.x.addView(new c.a.o0.m.f.b(this.f47121f, this.mShareInfo).a());
                }
                this.o.setText(this.mShareInfo.getParams().getTitle());
                StatisticItem statisticItem2 = new StatisticItem("c10898");
                statisticItem2.param("obj_source", 2);
                TiebaStatic.log(statisticItem2);
                this.C = 3;
            }
            f();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void f() {
        ThreadAchievementShareInfo threadAchievementShareInfo;
        String user_img;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (threadAchievementShareInfo = this.mShareInfo) == null || threadAchievementShareInfo.getParams() == null) {
            return;
        }
        ThreadAchievementShareInfo.UserBean user = this.mShareInfo.getParams().getUser();
        if (!TextUtils.isEmpty(user.getImg())) {
            user_img = user.getImg();
        } else {
            user_img = user.getUser_img();
        }
        HeadImageView headImageView = this.y;
        headImageView.startLoad(THREAD_IMG_HOST + user_img + THREAD_IMG_SUFFIX, 12, false);
        this.n.setText(user.getUsername());
        if (!TextUtils.isEmpty(this.mShareInfo.getParams().getUrl())) {
            h(this.mShareInfo.getParams().getUrl());
            this.v.setVisibility(0);
            return;
        }
        this.v.setVisibility(8);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.p == null) {
                this.p = new PermissionJudgePolicy();
            }
            this.p.clearRequestPermissionList();
            this.p.appendRequestPermission(this.r.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.p.startRequestPermission(this.r.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public Bitmap generateSharedImg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.t == null) {
                SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.u, R.drawable.pic_announcement);
                this.w.buildDrawingCache();
                this.t = this.w.getDrawingCache();
            }
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_frs_private_dialog);
            SkinManager.setBackgroundResource(this.u, R.drawable.pic_announcement_round);
            return this.t;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void h(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.v.setImageBitmap((Bitmap) runTask.getData());
    }

    public final ShareItem i(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bitmap, i2)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.d0 = false;
            shareItem.c0 = false;
            shareItem.W = 1;
            shareItem.r = this.f47121f.getString(R.string.app_name);
            shareItem.s = "";
            shareItem.i(bitmap);
            shareItem.g();
            return shareItem;
        }
        return (ShareItem) invokeLI.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.frs_private_share);
            this.f47122g = linearLayout;
            this.u = linearLayout.findViewById(R.id.poster_head_bg);
            SkinManager.setBackgroundResource(this.f47122g, R.drawable.bg_frs_private_dialog);
            SkinManager.setBackgroundResource(this.u, R.drawable.pic_announcement_round);
            this.x = (FrameLayout) this.f47122g.findViewById(R.id.poster_container);
            this.o = (TextView) this.f47122g.findViewById(R.id.achievement_desc);
            this.y = (HeadImageView) this.f47122g.findViewById(R.id.head_portrait);
            TextView textView = (TextView) this.f47122g.findViewById(R.id.user_name);
            this.n = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
            this.y.setIsRound(true);
            this.y.setPlaceHolder(2);
            this.y.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.w = (LinearLayout) this.f47122g.findViewById(R.id.share_view_layout);
            this.v = (ImageView) this.f47122g.findViewById(R.id.share_qrcode);
            this.z = (TextView) this.f47122g.findViewById(R.id.qrcode_top_desc);
            this.A = (TextView) this.f47122g.findViewById(R.id.qrcode_bottom_desc);
            this.B = (FrameLayout) this.f47122g.findViewById(R.id.qrcode_layout);
            ImageView imageView = (ImageView) this.f47122g.findViewById(R.id.close_button);
            this.D = imageView;
            imageView.setOnClickListener(new a(this));
            SkinManager.setImageResource(this.D, R.drawable.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.w, R.drawable.bg_frs_private_dialog);
            TextView textView2 = (TextView) this.f47122g.findViewById(R.id.frs_private_share_download);
            this.f47123h = textView2;
            m(textView2, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
            this.f47123h.setOnClickListener(new b(this));
            TextView textView3 = (TextView) this.f47122g.findViewById(R.id.frs_private_share_wechat);
            this.f47124i = textView3;
            m(textView3, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            this.f47124i.setOnClickListener(new c(this));
            TextView textView4 = (TextView) this.f47122g.findViewById(R.id.frs_private_share_moment);
            this.f47125j = textView4;
            m(textView4, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            this.f47125j.setOnClickListener(new d(this));
            TextView textView5 = (TextView) this.f47122g.findViewById(R.id.frs_private_share_qzone);
            this.k = textView5;
            m(textView5, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            this.k.setOnClickListener(new e(this));
            TextView textView6 = (TextView) this.f47122g.findViewById(R.id.frs_private_share_qq);
            this.l = textView6;
            m(textView6, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            this.l.setOnClickListener(new f(this));
            TextView textView7 = (TextView) this.f47122g.findViewById(R.id.frs_private_share_weibo);
            this.m = textView7;
            m(textView7, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            this.m.setOnClickListener(new g(this));
        }
    }

    public final ThreadAchievementShareInfo k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (ThreadAchievementShareInfo) this.f47120e.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
        }
        return (ThreadAchievementShareInfo) invokeL.objValue;
    }

    public final void l(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) || g()) {
            return;
        }
        if (this.q == null) {
            this.q = new w0(this.r);
        }
        if (this.mShareInfo.getParams() != null && !TextUtils.isEmpty(this.mShareInfo.getParams().getUrl())) {
            this.q.b(this.mShareInfo.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
        } else {
            this.q.b("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
        this.D.performClick();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.C);
        TiebaStatic.log(statisticItem);
    }

    public final void m(TextView textView, AbsSvgType absSvgType) {
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

    public final void n(Bitmap bitmap, int i2) {
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
        statisticItem.param("obj_source", this.C);
        TiebaStatic.log(statisticItem);
        k0.b(new h(this, bitmap, i2), new i(this, i2));
    }
}
