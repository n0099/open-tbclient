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
import c.a.d.f.p.n;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.c1.s;
import c.a.p0.w2.m.f.e1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public final ThreadAchievementShareInfo a;

    /* renamed from: b  reason: collision with root package name */
    public Gson f29791b;

    /* renamed from: c  reason: collision with root package name */
    public Context f29792c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f29793d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29794e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29795f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29796g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f29797h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public PermissionJudgePolicy m;
    public e1 n;
    public TbPageContext o;
    public c.a.o0.r.t.a p;
    public Bitmap q;
    public View r;
    public ImageView s;
    public LinearLayout t;
    public FrameLayout u;
    public HeadImageView v;
    public TextView w;
    public TextView x;
    public FrameLayout y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public a(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.p != null && this.a.p.isShowing()) {
                this.a.p.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public b(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.a;
                threadAchievementShareDialogView.n(threadAchievementShareDialogView.k());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public c(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.a;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public d(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.a;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public e(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.a;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 4);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public f(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.a;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadAchievementShareDialogView a;

        public g(ThreadAchievementShareDialogView threadAchievementShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadAchievementShareDialogView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadAchievementShareDialogView threadAchievementShareDialogView = this.a;
                threadAchievementShareDialogView.p(threadAchievementShareDialogView.k(), 6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bitmap a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f29798b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f29799c;

        public h(ThreadAchievementShareDialogView threadAchievementShareDialogView, Bitmap bitmap, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView, bitmap, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29799c = threadAchievementShareDialogView;
            this.a = bitmap;
            this.f29798b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29799c.j(this.a, this.f29798b) : (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ThreadAchievementShareDialogView f29800b;

        public i(ThreadAchievementShareDialogView threadAchievementShareDialogView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadAchievementShareDialogView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29800b = threadAchievementShareDialogView;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f29800b.f29792c, this.a, shareItem, false));
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
        this.f29791b = new Gson();
        this.f29792c = context;
        this.a = m(str);
    }

    private int getTextViewWidth() {
        InterceptResult invokeV;
        int k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            int f2 = n.f(this.f29792c, R.dimen.tbds44);
            int f3 = n.f(this.f29792c, R.dimen.tbds54);
            if (UtilHelper.getRealScreenOrientation(this.f29792c) == 2) {
                k = n.i(this.f29792c);
            } else {
                k = n.k(this.f29792c);
            }
            return ((k - (f2 * 2)) - f3) / 6;
        }
        return invokeV.intValue;
    }

    public final void f() {
        ThreadAchievementShareInfo threadAchievementShareInfo;
        String user_img;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (threadAchievementShareInfo = this.a) == null || threadAchievementShareInfo.getParams() == null) {
            return;
        }
        ThreadAchievementShareInfo.UserBean user = this.a.getParams().getUser();
        if (!TextUtils.isEmpty(user.getImg())) {
            user_img = user.getImg();
        } else {
            user_img = user.getUser_img();
        }
        HeadImageView headImageView = this.v;
        headImageView.J("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
        this.k.setText(user.getUsername());
        if (!TextUtils.isEmpty(this.a.getParams().getUrl())) {
            i(this.a.getParams().getUrl());
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.m == null) {
                this.m = new PermissionJudgePolicy();
            }
            this.m.clearRequestPermissionList();
            this.m.appendRequestPermission(this.o.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.m.startRequestPermission(this.o.getPageActivity());
        }
        return invokeV.booleanValue;
    }

    public boolean h(TbPageContext tbPageContext, c.a.o0.r.t.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, aVar)) == null) {
            this.o = tbPageContext;
            this.p = aVar;
            l(this.f29792c);
            if (this.a.getParams() != null && !ListUtils.isEmpty(this.a.getParams().getThread_list())) {
                this.u.addView(new c.a.o0.l.i.a(this.f29792c, this.a).a());
                this.l.setText(this.a.getParams().getTitle());
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem.param("obj_source", 1);
                TiebaStatic.log(statisticItem);
                this.z = 2;
            } else if (this.a.getParams() != null) {
                if (this.a.getParams().getVideo_info() != null) {
                    this.u.addView(new c.a.o0.l.i.c(this.f29792c, this.a).a());
                } else {
                    this.u.addView(new c.a.o0.l.i.b(this.f29792c, this.a).a());
                }
                this.l.setText(this.a.getParams().getTitle());
                StatisticItem statisticItem2 = new StatisticItem("c10898");
                statisticItem2.param("obj_source", 2);
                TiebaStatic.log(statisticItem2);
                this.z = 3;
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
        this.s.setImageBitmap((Bitmap) runTask.getData());
    }

    public final ShareItem j(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, bitmap, i2)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.i0 = false;
            shareItem.h0 = false;
            shareItem.b0 = 1;
            shareItem.r = this.f29792c.getString(R.string.obfuscated_res_0x7f0f029e);
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
            if (this.q == null) {
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.r, R.drawable.pic_announcement);
                this.t.buildDrawingCache();
                this.q = this.t.getDrawingCache();
            }
            SkinManager.setBackgroundResource(this.t, R.drawable.bg_frs_private_dialog);
            SkinManager.setBackgroundResource(this.r, R.drawable.pic_announcement_round);
            return this.q;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08be, this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090bb4);
            this.f29793d = linearLayout;
            this.r = linearLayout.findViewById(R.id.obfuscated_res_0x7f0918d2);
            SkinManager.setBackgroundResource(this.f29793d, R.drawable.bg_frs_private_dialog);
            SkinManager.setBackgroundResource(this.r, R.drawable.pic_announcement_round);
            this.u = (FrameLayout) this.f29793d.findViewById(R.id.obfuscated_res_0x7f0918d1);
            this.l = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090053);
            this.v = (HeadImageView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090d24);
            TextView textView = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.k = textView;
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            this.v.setIsRound(true);
            this.v.setPlaceHolder(2);
            this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.t = (LinearLayout) this.f29793d.findViewById(R.id.obfuscated_res_0x7f091ce4);
            this.s = (ImageView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f091cd0);
            this.w = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f09199b);
            this.x = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f091998);
            this.y = (FrameLayout) this.f29793d.findViewById(R.id.obfuscated_res_0x7f091999);
            ImageView imageView = (ImageView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f09066b);
            this.A = imageView;
            imageView.setOnClickListener(new a(this));
            SkinManager.setImageResource(this.A, R.drawable.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.t, R.drawable.bg_frs_private_dialog);
            TextView textView2 = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090bb6);
            this.f29794e = textView2;
            o(textView2, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807de));
            this.f29794e.setOnClickListener(new b(this));
            TextView textView3 = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090bbf);
            this.f29795f = textView3;
            o(textView3, new SvgMaskType(R.drawable.obfuscated_res_0x7f080823));
            this.f29795f.setOnClickListener(new c(this));
            TextView textView4 = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090bb7);
            this.f29796g = textView4;
            o(textView4, new SvgMaskType(R.drawable.obfuscated_res_0x7f08081f));
            this.f29796g.setOnClickListener(new d(this));
            TextView textView5 = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090bbc);
            this.f29797h = textView5;
            o(textView5, new SvgMaskType(R.drawable.obfuscated_res_0x7f080821));
            this.f29797h.setOnClickListener(new e(this));
            TextView textView6 = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090bba);
            this.i = textView6;
            o(textView6, new SvgMaskType(R.drawable.obfuscated_res_0x7f080820));
            this.i.setOnClickListener(new f(this));
            TextView textView7 = (TextView) this.f29793d.findViewById(R.id.obfuscated_res_0x7f090bc0);
            this.j = textView7;
            o(textView7, new SvgMaskType(R.drawable.obfuscated_res_0x7f080824));
            this.j.setOnClickListener(new g(this));
        }
    }

    public final ThreadAchievementShareInfo m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (ThreadAchievementShareInfo) this.f29791b.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
        }
        return (ThreadAchievementShareInfo) invokeL.objValue;
    }

    public final void n(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) || g()) {
            return;
        }
        if (this.n == null) {
            this.n = new e1(this.o);
        }
        if (this.a.getParams() != null && !TextUtils.isEmpty(this.a.getParams().getUrl())) {
            this.n.b(this.a.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
        } else {
            this.n.b("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
        this.A.performClick();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.z);
        TiebaStatic.log(statisticItem);
    }

    public final void o(TextView textView, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, textView, absSvgType) == null) || absSvgType == null) {
            return;
        }
        Drawable drawable = absSvgType.getDrawable();
        int f2 = n.f(getContext(), R.dimen.tbds88);
        drawable.setBounds(0, 0, f2, f2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
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
        statisticItem.param("obj_source", this.z);
        TiebaStatic.log(statisticItem);
        n0.b(new h(this, bitmap, i2), new i(this, i2));
    }
}
