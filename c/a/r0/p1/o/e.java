package c.a.r0.p1.o;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f21237b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f21238c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21239d;

    /* renamed from: e  reason: collision with root package name */
    public View f21240e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f21241f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f21242g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f21243h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f21244i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f21245j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21246k;
    public boolean l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21248f;

        /* renamed from: c.a.r0.p1.o.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1251a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f21249e;

            public RunnableC1251a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21249e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21249e.f21248f.m <= 1 || this.f21249e.f21248f.f21238c.getAnimation() == this.f21249e.f21248f.f21244i) {
                    return;
                }
                this.f21249e.f21248f.f21238c.startAnimation(this.f21249e.f21248f.f21244i);
            }
        }

        public a(e eVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21248f = eVar;
            this.f21247e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21248f.f21238c.getAnimation() == this.f21248f.f21242g) {
                    this.f21248f.f21238c.clearAnimation();
                    return;
                }
                this.f21248f.f21239d.setVisibility(0);
                this.f21248f.f21239d.setText(StringHelper.numFormatOverWan(this.f21247e + 1));
                if (this.f21248f.l) {
                    SkinManager.setImageResource(this.f21248f.f21237b, c.a.r0.p1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f21248f.f21237b, c.a.r0.p1.d.candle_gif);
                }
                e eVar = this.f21248f;
                eVar.f21241f = (AnimationDrawable) eVar.f21237b.getDrawable();
                this.f21248f.f21241f.start();
                this.f21248f.f21238c.postDelayed(new RunnableC1251a(this), 2000L);
                ((HotTopicActivity) this.f21248f.a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21250e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21251f;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21252e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21252e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21252e.f21251f.m <= 1 || this.f21252e.f21251f.f21238c.getAnimation() == this.f21252e.f21251f.f21244i) {
                    return;
                }
                this.f21252e.f21251f.f21238c.startAnimation(this.f21252e.f21251f.f21244i);
            }
        }

        public b(e eVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21251f = eVar;
            this.f21250e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21251f.f21238c.getAnimation() == this.f21251f.f21242g) {
                    this.f21251f.f21238c.clearAnimation();
                    return;
                }
                this.f21251f.f21239d.setVisibility(0);
                this.f21251f.f21239d.setText(StringHelper.numFormatOverWan(this.f21250e + 1));
                if (this.f21251f.l) {
                    SkinManager.setImageResource(this.f21251f.f21237b, c.a.r0.p1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f21251f.f21237b, c.a.r0.p1.d.candle_gif);
                }
                e eVar = this.f21251f;
                eVar.f21241f = (AnimationDrawable) eVar.f21237b.getDrawable();
                this.f21251f.f21241f.start();
                this.f21251f.f21238c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f21251f.a.getOrignalPage()).sendBlessData();
            }
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21246k = false;
        this.l = false;
        this.m = -1;
        this.a = tbPageContext;
        this.f21237b = (ImageView) view.findViewById(c.a.r0.p1.e.gif_image);
        this.f21238c = (LinearLayout) view.findViewById(c.a.r0.p1.e.gif_group);
        this.f21239d = (TextView) view.findViewById(c.a.r0.p1.e.git_desc);
        this.f21240e = view.findViewById(c.a.r0.p1.e.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21237b.clearAnimation();
            this.f21238c.clearAnimation();
            Animation animation = this.f21242g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f21243h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f21244i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f21245j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f21241f;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public void l(int i2, boolean z, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i3)}) == null) || this.f21246k) {
            return;
        }
        this.f21238c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f21239d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f21239d.setVisibility(0);
                SkinManager.setImageResource(this.f21237b, c.a.r0.p1.d.bless_gif);
            } else {
                this.f21239d.setVisibility(8);
                SkinManager.setImageResource(this.f21237b, c.a.r0.p1.d.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f21239d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.r0.p1.c.bless_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.r0.p1.c.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f21239d, c.a.r0.p1.b.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f21239d, c.a.r0.p1.d.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f21239d.setVisibility(0);
                SkinManager.setImageResource(this.f21237b, c.a.r0.p1.d.candle_gif);
            } else {
                this.f21239d.setVisibility(8);
                SkinManager.setImageResource(this.f21237b, c.a.r0.p1.d.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f21239d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.r0.p1.c.candle_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.r0.p1.c.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f21239d, c.a.r0.p1.b.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f21239d, c.a.r0.p1.d.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f21238c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f21237b.getDrawable();
            this.f21241f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f21240e.setOnClickListener(new a(this, j2));
            this.f21238c.setOnClickListener(new b(this, j2));
        }
        this.f21246k = true;
        this.f21242g = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.r0.p1.a.gifview_rotate);
        this.f21243h = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.r0.p1.a.gifview_rotate_out);
        this.f21244i = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.r0.p1.a.gifview_alpha);
        this.f21245j = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.r0.p1.a.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f21246k) {
            this.m = i2;
            if (this.f21237b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f21238c.getAnimation();
                    Animation animation2 = this.f21245j;
                    if (animation != animation2) {
                        this.f21238c.startAnimation(animation2);
                        this.f21241f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f21238c.getAnimation();
                Animation animation4 = this.f21244i;
                if (animation3 != animation4) {
                    this.f21238c.startAnimation(animation4);
                    this.f21241f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f21238c.getAnimation();
                Animation animation6 = this.f21242g;
                if (animation5 != animation6) {
                    this.f21238c.startAnimation(animation6);
                }
            } else if (this.f21238c.getAnimation() == this.f21242g) {
                this.f21238c.startAnimation(this.f21243h);
            }
        }
    }
}
