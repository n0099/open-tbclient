package c.a.s0.q1.o;

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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f21722b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f21723c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21724d;

    /* renamed from: e  reason: collision with root package name */
    public View f21725e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f21726f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f21727g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f21728h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f21729i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f21730j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21731k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21732e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21733f;

        /* renamed from: c.a.s0.q1.o.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1302a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f21734e;

            public RunnableC1302a(a aVar) {
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
                this.f21734e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21734e.f21733f.m <= 1 || this.f21734e.f21733f.f21723c.getAnimation() == this.f21734e.f21733f.f21729i) {
                    return;
                }
                this.f21734e.f21733f.f21723c.startAnimation(this.f21734e.f21733f.f21729i);
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
            this.f21733f = eVar;
            this.f21732e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21733f.f21723c.getAnimation() == this.f21733f.f21727g) {
                    this.f21733f.f21723c.clearAnimation();
                    return;
                }
                this.f21733f.f21724d.setVisibility(0);
                this.f21733f.f21724d.setText(StringHelper.numFormatOverWan(this.f21732e + 1));
                if (this.f21733f.l) {
                    SkinManager.setImageResource(this.f21733f.f21722b, c.a.s0.q1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f21733f.f21722b, c.a.s0.q1.d.candle_gif);
                }
                e eVar = this.f21733f;
                eVar.f21726f = (AnimationDrawable) eVar.f21722b.getDrawable();
                this.f21733f.f21726f.start();
                this.f21733f.f21723c.postDelayed(new RunnableC1302a(this), 2000L);
                ((HotTopicActivity) this.f21733f.a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21736f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21737e;

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
                this.f21737e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21737e.f21736f.m <= 1 || this.f21737e.f21736f.f21723c.getAnimation() == this.f21737e.f21736f.f21729i) {
                    return;
                }
                this.f21737e.f21736f.f21723c.startAnimation(this.f21737e.f21736f.f21729i);
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
            this.f21736f = eVar;
            this.f21735e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21736f.f21723c.getAnimation() == this.f21736f.f21727g) {
                    this.f21736f.f21723c.clearAnimation();
                    return;
                }
                this.f21736f.f21724d.setVisibility(0);
                this.f21736f.f21724d.setText(StringHelper.numFormatOverWan(this.f21735e + 1));
                if (this.f21736f.l) {
                    SkinManager.setImageResource(this.f21736f.f21722b, c.a.s0.q1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f21736f.f21722b, c.a.s0.q1.d.candle_gif);
                }
                e eVar = this.f21736f;
                eVar.f21726f = (AnimationDrawable) eVar.f21722b.getDrawable();
                this.f21736f.f21726f.start();
                this.f21736f.f21723c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f21736f.a.getOrignalPage()).sendBlessData();
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
        this.f21731k = false;
        this.l = false;
        this.m = -1;
        this.a = tbPageContext;
        this.f21722b = (ImageView) view.findViewById(c.a.s0.q1.e.gif_image);
        this.f21723c = (LinearLayout) view.findViewById(c.a.s0.q1.e.gif_group);
        this.f21724d = (TextView) view.findViewById(c.a.s0.q1.e.git_desc);
        this.f21725e = view.findViewById(c.a.s0.q1.e.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21722b.clearAnimation();
            this.f21723c.clearAnimation();
            Animation animation = this.f21727g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f21728h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f21729i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f21730j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f21726f;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public void l(int i2, boolean z, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i3)}) == null) || this.f21731k) {
            return;
        }
        this.f21723c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f21724d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f21724d.setVisibility(0);
                SkinManager.setImageResource(this.f21722b, c.a.s0.q1.d.bless_gif);
            } else {
                this.f21724d.setVisibility(8);
                SkinManager.setImageResource(this.f21722b, c.a.s0.q1.d.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f21724d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.s0.q1.c.bless_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.s0.q1.c.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f21724d, c.a.s0.q1.b.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f21724d, c.a.s0.q1.d.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f21724d.setVisibility(0);
                SkinManager.setImageResource(this.f21722b, c.a.s0.q1.d.candle_gif);
            } else {
                this.f21724d.setVisibility(8);
                SkinManager.setImageResource(this.f21722b, c.a.s0.q1.d.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f21724d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.s0.q1.c.candle_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.s0.q1.c.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f21724d, c.a.s0.q1.b.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f21724d, c.a.s0.q1.d.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f21723c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f21722b.getDrawable();
            this.f21726f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f21725e.setOnClickListener(new a(this, j2));
            this.f21723c.setOnClickListener(new b(this, j2));
        }
        this.f21731k = true;
        this.f21727g = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.s0.q1.a.gifview_rotate);
        this.f21728h = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.s0.q1.a.gifview_rotate_out);
        this.f21729i = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.s0.q1.a.gifview_alpha);
        this.f21730j = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.s0.q1.a.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f21731k) {
            this.m = i2;
            if (this.f21722b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f21723c.getAnimation();
                    Animation animation2 = this.f21730j;
                    if (animation != animation2) {
                        this.f21723c.startAnimation(animation2);
                        this.f21726f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f21723c.getAnimation();
                Animation animation4 = this.f21729i;
                if (animation3 != animation4) {
                    this.f21723c.startAnimation(animation4);
                    this.f21726f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f21723c.getAnimation();
                Animation animation6 = this.f21727g;
                if (animation5 != animation6) {
                    this.f21723c.startAnimation(animation6);
                }
            } else if (this.f21723c.getAnimation() == this.f21727g) {
                this.f21723c.startAnimation(this.f21728h);
            }
        }
    }
}
