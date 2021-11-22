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
    public TbPageContext<HotTopicActivity> f19869a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19870b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19871c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19872d;

    /* renamed from: e  reason: collision with root package name */
    public View f19873e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f19874f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19875g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19876h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f19877i;
    public Animation j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19879f;

        /* renamed from: b.a.r0.j1.o.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0999a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19880e;

            public RunnableC0999a(a aVar) {
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
                this.f19880e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19880e.f19879f.m <= 1 || this.f19880e.f19879f.f19871c.getAnimation() == this.f19880e.f19879f.f19877i) {
                    return;
                }
                this.f19880e.f19879f.f19871c.startAnimation(this.f19880e.f19879f.f19877i);
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
            this.f19879f = eVar;
            this.f19878e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19879f.f19871c.getAnimation() == this.f19879f.f19875g) {
                    this.f19879f.f19871c.clearAnimation();
                    return;
                }
                this.f19879f.f19872d.setVisibility(0);
                this.f19879f.f19872d.setText(StringHelper.numFormatOverWan(this.f19878e + 1));
                if (this.f19879f.l) {
                    SkinManager.setImageResource(this.f19879f.f19870b, b.a.r0.j1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19879f.f19870b, b.a.r0.j1.d.candle_gif);
                }
                e eVar = this.f19879f;
                eVar.f19874f = (AnimationDrawable) eVar.f19870b.getDrawable();
                this.f19879f.f19874f.start();
                this.f19879f.f19871c.postDelayed(new RunnableC0999a(this), 2000L);
                ((HotTopicActivity) this.f19879f.f19869a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19882f;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19883e;

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
                this.f19883e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19883e.f19882f.m <= 1 || this.f19883e.f19882f.f19871c.getAnimation() == this.f19883e.f19882f.f19877i) {
                    return;
                }
                this.f19883e.f19882f.f19871c.startAnimation(this.f19883e.f19882f.f19877i);
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
            this.f19882f = eVar;
            this.f19881e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19882f.f19871c.getAnimation() == this.f19882f.f19875g) {
                    this.f19882f.f19871c.clearAnimation();
                    return;
                }
                this.f19882f.f19872d.setVisibility(0);
                this.f19882f.f19872d.setText(StringHelper.numFormatOverWan(this.f19881e + 1));
                if (this.f19882f.l) {
                    SkinManager.setImageResource(this.f19882f.f19870b, b.a.r0.j1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19882f.f19870b, b.a.r0.j1.d.candle_gif);
                }
                e eVar = this.f19882f;
                eVar.f19874f = (AnimationDrawable) eVar.f19870b.getDrawable();
                this.f19882f.f19874f.start();
                this.f19882f.f19871c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f19882f.f19869a.getOrignalPage()).sendBlessData();
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
        this.f19869a = tbPageContext;
        this.f19870b = (ImageView) view.findViewById(b.a.r0.j1.e.gif_image);
        this.f19871c = (LinearLayout) view.findViewById(b.a.r0.j1.e.gif_group);
        this.f19872d = (TextView) view.findViewById(b.a.r0.j1.e.git_desc);
        this.f19873e = view.findViewById(b.a.r0.j1.e.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19870b.clearAnimation();
            this.f19871c.clearAnimation();
            Animation animation = this.f19875g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f19876h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f19877i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f19874f;
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
        this.f19871c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f19872d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f19872d.setVisibility(0);
                SkinManager.setImageResource(this.f19870b, b.a.r0.j1.d.bless_gif);
            } else {
                this.f19872d.setVisibility(8);
                SkinManager.setImageResource(this.f19870b, b.a.r0.j1.d.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f19872d.getLayoutParams()).setMargins(this.f19869a.getResources().getDimensionPixelSize(b.a.r0.j1.c.bless_magin_left), 0, 0, this.f19869a.getResources().getDimensionPixelSize(b.a.r0.j1.c.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f19872d, b.a.r0.j1.b.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f19872d, b.a.r0.j1.d.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f19872d.setVisibility(0);
                SkinManager.setImageResource(this.f19870b, b.a.r0.j1.d.candle_gif);
            } else {
                this.f19872d.setVisibility(8);
                SkinManager.setImageResource(this.f19870b, b.a.r0.j1.d.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f19872d.getLayoutParams()).setMargins(this.f19869a.getResources().getDimensionPixelSize(b.a.r0.j1.c.candle_magin_left), 0, 0, this.f19869a.getResources().getDimensionPixelSize(b.a.r0.j1.c.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f19872d, b.a.r0.j1.b.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f19872d, b.a.r0.j1.d.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f19871c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f19870b.getDrawable();
            this.f19874f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f19873e.setOnClickListener(new a(this, j));
            this.f19871c.setOnClickListener(new b(this, j));
        }
        this.k = true;
        this.f19875g = AnimationUtils.loadAnimation(this.f19869a.getPageActivity(), b.a.r0.j1.a.gifview_rotate);
        this.f19876h = AnimationUtils.loadAnimation(this.f19869a.getPageActivity(), b.a.r0.j1.a.gifview_rotate_out);
        this.f19877i = AnimationUtils.loadAnimation(this.f19869a.getPageActivity(), b.a.r0.j1.a.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f19869a.getPageActivity(), b.a.r0.j1.a.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f19870b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f19871c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f19871c.startAnimation(animation2);
                        this.f19874f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f19871c.getAnimation();
                Animation animation4 = this.f19877i;
                if (animation3 != animation4) {
                    this.f19871c.startAnimation(animation4);
                    this.f19874f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f19871c.getAnimation();
                Animation animation6 = this.f19875g;
                if (animation5 != animation6) {
                    this.f19871c.startAnimation(animation6);
                }
            } else if (this.f19871c.getAnimation() == this.f19875g) {
                this.f19871c.startAnimation(this.f19876h);
            }
        }
    }
}
