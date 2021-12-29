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
    public ImageView f22233b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f22234c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22235d;

    /* renamed from: e  reason: collision with root package name */
    public View f22236e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f22237f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f22238g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f22239h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f22240i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f22241j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22242k;
    public boolean l;
    public int m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f22244f;

        /* renamed from: c.a.t0.q1.o.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1329a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f22245e;

            public RunnableC1329a(a aVar) {
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
                this.f22245e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22245e.f22244f.m <= 1 || this.f22245e.f22244f.f22234c.getAnimation() == this.f22245e.f22244f.f22240i) {
                    return;
                }
                this.f22245e.f22244f.f22234c.startAnimation(this.f22245e.f22244f.f22240i);
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
            this.f22244f = eVar;
            this.f22243e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f22244f.f22234c.getAnimation() == this.f22244f.f22238g) {
                    this.f22244f.f22234c.clearAnimation();
                    return;
                }
                this.f22244f.f22235d.setVisibility(0);
                this.f22244f.f22235d.setText(StringHelper.numFormatOverWan(this.f22243e + 1));
                if (this.f22244f.l) {
                    SkinManager.setImageResource(this.f22244f.f22233b, c.a.t0.q1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f22244f.f22233b, c.a.t0.q1.d.candle_gif);
                }
                e eVar = this.f22244f;
                eVar.f22237f = (AnimationDrawable) eVar.f22233b.getDrawable();
                this.f22244f.f22237f.start();
                this.f22244f.f22234c.postDelayed(new RunnableC1329a(this), 2000L);
                ((HotTopicActivity) this.f22244f.a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22246e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f22247f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f22248e;

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
                this.f22248e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22248e.f22247f.m <= 1 || this.f22248e.f22247f.f22234c.getAnimation() == this.f22248e.f22247f.f22240i) {
                    return;
                }
                this.f22248e.f22247f.f22234c.startAnimation(this.f22248e.f22247f.f22240i);
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
            this.f22247f = eVar;
            this.f22246e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f22247f.f22234c.getAnimation() == this.f22247f.f22238g) {
                    this.f22247f.f22234c.clearAnimation();
                    return;
                }
                this.f22247f.f22235d.setVisibility(0);
                this.f22247f.f22235d.setText(StringHelper.numFormatOverWan(this.f22246e + 1));
                if (this.f22247f.l) {
                    SkinManager.setImageResource(this.f22247f.f22233b, c.a.t0.q1.d.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f22247f.f22233b, c.a.t0.q1.d.candle_gif);
                }
                e eVar = this.f22247f;
                eVar.f22237f = (AnimationDrawable) eVar.f22233b.getDrawable();
                this.f22247f.f22237f.start();
                this.f22247f.f22234c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f22247f.a.getOrignalPage()).sendBlessData();
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
        this.f22242k = false;
        this.l = false;
        this.m = -1;
        this.a = tbPageContext;
        this.f22233b = (ImageView) view.findViewById(c.a.t0.q1.e.gif_image);
        this.f22234c = (LinearLayout) view.findViewById(c.a.t0.q1.e.gif_group);
        this.f22235d = (TextView) view.findViewById(c.a.t0.q1.e.git_desc);
        this.f22236e = view.findViewById(c.a.t0.q1.e.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22233b.clearAnimation();
            this.f22234c.clearAnimation();
            Animation animation = this.f22238g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f22239h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f22240i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f22241j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f22237f;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public void l(int i2, boolean z, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i3)}) == null) || this.f22242k) {
            return;
        }
        this.f22234c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f22235d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f22235d.setVisibility(0);
                SkinManager.setImageResource(this.f22233b, c.a.t0.q1.d.bless_gif);
            } else {
                this.f22235d.setVisibility(8);
                SkinManager.setImageResource(this.f22233b, c.a.t0.q1.d.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f22235d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.bless_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f22235d, c.a.t0.q1.b.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f22235d, c.a.t0.q1.d.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f22235d.setVisibility(0);
                SkinManager.setImageResource(this.f22233b, c.a.t0.q1.d.candle_gif);
            } else {
                this.f22235d.setVisibility(8);
                SkinManager.setImageResource(this.f22233b, c.a.t0.q1.d.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f22235d.getLayoutParams()).setMargins(this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.candle_magin_left), 0, 0, this.a.getResources().getDimensionPixelSize(c.a.t0.q1.c.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f22235d, c.a.t0.q1.b.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f22235d, c.a.t0.q1.d.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f22234c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f22233b.getDrawable();
            this.f22237f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f22236e.setOnClickListener(new a(this, j2));
            this.f22234c.setOnClickListener(new b(this, j2));
        }
        this.f22242k = true;
        this.f22238g = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_rotate);
        this.f22239h = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_rotate_out);
        this.f22240i = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_alpha);
        this.f22241j = AnimationUtils.loadAnimation(this.a.getPageActivity(), c.a.t0.q1.a.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f22242k) {
            this.m = i2;
            if (this.f22233b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f22234c.getAnimation();
                    Animation animation2 = this.f22241j;
                    if (animation != animation2) {
                        this.f22234c.startAnimation(animation2);
                        this.f22237f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f22234c.getAnimation();
                Animation animation4 = this.f22240i;
                if (animation3 != animation4) {
                    this.f22234c.startAnimation(animation4);
                    this.f22237f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f22234c.getAnimation();
                Animation animation6 = this.f22238g;
                if (animation5 != animation6) {
                    this.f22234c.startAnimation(animation6);
                }
            } else if (this.f22234c.getAnimation() == this.f22238g) {
                this.f22234c.startAnimation(this.f22239h);
            }
        }
    }
}
