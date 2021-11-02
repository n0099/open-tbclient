package b.a.r0.j1.o;

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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f18535a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18536b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f18537c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18538d;

    /* renamed from: e  reason: collision with root package name */
    public View f18539e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f18540f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f18541g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f18542h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f18543i;
    public Animation j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f18544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18545f;

        /* renamed from: b.a.r0.j1.o.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0938a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f18546e;

            public RunnableC0938a(a aVar) {
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
                this.f18546e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18546e.f18545f.m <= 1 || this.f18546e.f18545f.f18537c.getAnimation() == this.f18546e.f18545f.f18543i) {
                    return;
                }
                this.f18546e.f18545f.f18537c.startAnimation(this.f18546e.f18545f.f18543i);
            }
        }

        public a(e eVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18545f = eVar;
            this.f18544e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18545f.f18537c.getAnimation() == this.f18545f.f18541g) {
                    this.f18545f.f18537c.clearAnimation();
                    return;
                }
                this.f18545f.f18538d.setVisibility(0);
                this.f18545f.f18538d.setText(StringHelper.numFormatOverWan(this.f18544e + 1));
                if (this.f18545f.l) {
                    SkinManager.setImageResource(this.f18545f.f18536b, b.a.r0.j1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f18545f.f18536b, b.a.r0.j1.d.candle_gif);
                }
                e eVar = this.f18545f;
                eVar.f18540f = (AnimationDrawable) eVar.f18536b.getDrawable();
                this.f18545f.f18540f.start();
                this.f18545f.f18537c.postDelayed(new RunnableC0938a(this), 2000L);
                ((HotTopicActivity) this.f18545f.f18535a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f18547e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18548f;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18549e;

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
                this.f18549e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18549e.f18548f.m <= 1 || this.f18549e.f18548f.f18537c.getAnimation() == this.f18549e.f18548f.f18543i) {
                    return;
                }
                this.f18549e.f18548f.f18537c.startAnimation(this.f18549e.f18548f.f18543i);
            }
        }

        public b(e eVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18548f = eVar;
            this.f18547e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18548f.f18537c.getAnimation() == this.f18548f.f18541g) {
                    this.f18548f.f18537c.clearAnimation();
                    return;
                }
                this.f18548f.f18538d.setVisibility(0);
                this.f18548f.f18538d.setText(StringHelper.numFormatOverWan(this.f18547e + 1));
                if (this.f18548f.l) {
                    SkinManager.setImageResource(this.f18548f.f18536b, b.a.r0.j1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f18548f.f18536b, b.a.r0.j1.d.candle_gif);
                }
                e eVar = this.f18548f;
                eVar.f18540f = (AnimationDrawable) eVar.f18536b.getDrawable();
                this.f18548f.f18540f.start();
                this.f18548f.f18537c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f18548f.f18535a.getOrignalPage()).sendBlessData();
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
        this.k = false;
        this.l = false;
        this.m = -1;
        this.f18535a = tbPageContext;
        this.f18536b = (ImageView) view.findViewById(b.a.r0.j1.e.gif_image);
        this.f18537c = (LinearLayout) view.findViewById(b.a.r0.j1.e.gif_group);
        this.f18538d = (TextView) view.findViewById(b.a.r0.j1.e.git_desc);
        this.f18539e = view.findViewById(b.a.r0.j1.e.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18536b.clearAnimation();
            this.f18537c.clearAnimation();
            Animation animation = this.f18541g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f18542h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f18543i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f18540f;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public void l(int i2, boolean z, long j, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j), Integer.valueOf(i3)}) == null) || this.k) {
            return;
        }
        this.f18537c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f18538d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f18538d.setVisibility(0);
                SkinManager.setImageResource(this.f18536b, b.a.r0.j1.d.bless_gif);
            } else {
                this.f18538d.setVisibility(8);
                SkinManager.setImageResource(this.f18536b, b.a.r0.j1.d.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f18538d.getLayoutParams()).setMargins(this.f18535a.getResources().getDimensionPixelSize(b.a.r0.j1.c.bless_magin_left), 0, 0, this.f18535a.getResources().getDimensionPixelSize(b.a.r0.j1.c.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f18538d, b.a.r0.j1.b.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f18538d, b.a.r0.j1.d.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f18538d.setVisibility(0);
                SkinManager.setImageResource(this.f18536b, b.a.r0.j1.d.candle_gif);
            } else {
                this.f18538d.setVisibility(8);
                SkinManager.setImageResource(this.f18536b, b.a.r0.j1.d.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f18538d.getLayoutParams()).setMargins(this.f18535a.getResources().getDimensionPixelSize(b.a.r0.j1.c.candle_magin_left), 0, 0, this.f18535a.getResources().getDimensionPixelSize(b.a.r0.j1.c.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f18538d, b.a.r0.j1.b.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f18538d, b.a.r0.j1.d.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f18537c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f18536b.getDrawable();
            this.f18540f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f18539e.setOnClickListener(new a(this, j));
            this.f18537c.setOnClickListener(new b(this, j));
        }
        this.k = true;
        this.f18541g = AnimationUtils.loadAnimation(this.f18535a.getPageActivity(), b.a.r0.j1.a.gifview_rotate);
        this.f18542h = AnimationUtils.loadAnimation(this.f18535a.getPageActivity(), b.a.r0.j1.a.gifview_rotate_out);
        this.f18543i = AnimationUtils.loadAnimation(this.f18535a.getPageActivity(), b.a.r0.j1.a.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f18535a.getPageActivity(), b.a.r0.j1.a.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f18536b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f18537c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f18537c.startAnimation(animation2);
                        this.f18540f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f18537c.getAnimation();
                Animation animation4 = this.f18543i;
                if (animation3 != animation4) {
                    this.f18537c.startAnimation(animation4);
                    this.f18540f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f18537c.getAnimation();
                Animation animation6 = this.f18541g;
                if (animation5 != animation6) {
                    this.f18537c.startAnimation(animation6);
                }
            } else if (this.f18537c.getAnimation() == this.f18541g) {
                this.f18537c.startAnimation(this.f18542h);
            }
        }
    }
}
