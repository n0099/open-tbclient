package c.a.t0.q1.o;

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
    public ImageView f21623b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f21624c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21625d;

    /* renamed from: e  reason: collision with root package name */
    public View f21626e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f21627f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f21628g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f21629h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f21630i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f21631j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21633f;

        /* renamed from: c.a.t0.q1.o.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1343a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f21634e;

            public RunnableC1343a(a aVar) {
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
                this.f21634e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21634e.f21633f.m <= 1 || this.f21634e.f21633f.f21624c.getAnimation() == this.f21634e.f21633f.f21630i) {
                    return;
                }
                this.f21634e.f21633f.f21624c.startAnimation(this.f21634e.f21633f.f21630i);
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
            this.f21633f = eVar;
            this.f21632e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21633f.f21624c.getAnimation() == this.f21633f.f21628g) {
                    this.f21633f.f21624c.clearAnimation();
                    return;
                }
                this.f21633f.f21625d.setVisibility(0);
                this.f21633f.f21625d.setText(StringHelper.numFormatOverWan(this.f21632e + 1));
                if (this.f21633f.l) {
                    SkinManager.setImageResource(this.f21633f.f21623b, c.a.t0.q1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f21633f.f21623b, c.a.t0.q1.d.candle_gif);
                }
                e eVar = this.f21633f;
                eVar.f21627f = (AnimationDrawable) eVar.f21623b.getDrawable();
                this.f21633f.f21627f.start();
                this.f21633f.f21624c.postDelayed(new RunnableC1343a(this), 2000L);
                ((HotTopicActivity) this.f21633f.a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f21636f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f21637e;

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
                this.f21637e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21637e.f21636f.m <= 1 || this.f21637e.f21636f.f21624c.getAnimation() == this.f21637e.f21636f.f21630i) {
                    return;
                }
                this.f21637e.f21636f.f21624c.startAnimation(this.f21637e.f21636f.f21630i);
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
            this.f21636f = eVar;
            this.f21635e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21636f.f21624c.getAnimation() == this.f21636f.f21628g) {
                    this.f21636f.f21624c.clearAnimation();
                    return;
                }
                this.f21636f.f21625d.setVisibility(0);
                this.f21636f.f21625d.setText(StringHelper.numFormatOverWan(this.f21635e + 1));
                if (this.f21636f.l) {
                    SkinManager.setImageResource(this.f21636f.f21623b, c.a.t0.q1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f21636f.f21623b, c.a.t0.q1.d.candle_gif);
                }
                e eVar = this.f21636f;
                eVar.f21627f = (AnimationDrawable) eVar.f21623b.getDrawable();
                this.f21636f.f21627f.start();
                this.f21636f.f21624c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f21636f.a.getOrignalPage()).sendBlessData();
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
        this.a = tbPageContext;
        this.f21623b = (ImageView) view.findViewById(c.a.t0.q1.e.gif_image);
        this.f21624c = (LinearLayout) view.findViewById(c.a.t0.q1.e.gif_group);
        this.f21625d = (TextView) view.findViewById(c.a.t0.q1.e.git_desc);
        this.f21626e = view.findViewById(c.a.t0.q1.e.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21623b.clearAnimation();
            this.f21624c.clearAnimation();
            Animation animation = this.f21628g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f21629h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f21630i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f21631j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f21627f;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public void l(int i2, boolean z, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i3)}) == null) || this.k) {
            return;
        }
        this.f21624c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f21625d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f21625d.setVisibility(0);
                SkinManager.setImageResource(this.f21623b, c.a.t0.q1.d.bless_gif);
            } else {
                this.f21625d.setVisibility(8);
                SkinManager.setImageResource(this.f21623b, c.a.t0.q1.d.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f21625d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.bless_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f21625d, c.a.t0.q1.b.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f21625d, c.a.t0.q1.d.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f21625d.setVisibility(0);
                SkinManager.setImageResource(this.f21623b, c.a.t0.q1.d.candle_gif);
            } else {
                this.f21625d.setVisibility(8);
                SkinManager.setImageResource(this.f21623b, c.a.t0.q1.d.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f21625d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.candle_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f21625d, c.a.t0.q1.b.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f21625d, c.a.t0.q1.d.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f21624c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f21623b.getDrawable();
            this.f21627f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f21626e.setOnClickListener(new a(this, j2));
            this.f21624c.setOnClickListener(new b(this, j2));
        }
        this.k = true;
        this.f21628g = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_rotate);
        this.f21629h = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_rotate_out);
        this.f21630i = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_alpha);
        this.f21631j = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f21623b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f21624c.getAnimation();
                    Animation animation2 = this.f21631j;
                    if (animation != animation2) {
                        this.f21624c.startAnimation(animation2);
                        this.f21627f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f21624c.getAnimation();
                Animation animation4 = this.f21630i;
                if (animation3 != animation4) {
                    this.f21624c.startAnimation(animation4);
                    this.f21627f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f21624c.getAnimation();
                Animation animation6 = this.f21628g;
                if (animation5 != animation6) {
                    this.f21624c.startAnimation(animation6);
                }
            } else if (this.f21624c.getAnimation() == this.f21628g) {
                this.f21624c.startAnimation(this.f21629h);
            }
        }
    }
}
