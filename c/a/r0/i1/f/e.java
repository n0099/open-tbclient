package c.a.r0.i1.f;

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
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f19389a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19390b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19391c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19392d;

    /* renamed from: e  reason: collision with root package name */
    public View f19393e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f19394f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19395g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19396h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f19397i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f19398j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19399e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19400f;

        /* renamed from: c.a.r0.i1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0931a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19401e;

            public RunnableC0931a(a aVar) {
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
                this.f19401e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19401e.f19400f.m <= 1 || this.f19401e.f19400f.f19391c.getAnimation() == this.f19401e.f19400f.f19397i) {
                    return;
                }
                this.f19401e.f19400f.f19391c.startAnimation(this.f19401e.f19400f.f19397i);
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
            this.f19400f = eVar;
            this.f19399e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19400f.f19391c.getAnimation() == this.f19400f.f19395g) {
                    this.f19400f.f19391c.clearAnimation();
                    return;
                }
                this.f19400f.f19392d.setVisibility(0);
                this.f19400f.f19392d.setText(StringHelper.numFormatOverWan(this.f19399e + 1));
                if (this.f19400f.l) {
                    SkinManager.setImageResource(this.f19400f.f19390b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19400f.f19390b, R.drawable.candle_gif);
                }
                e eVar = this.f19400f;
                eVar.f19394f = (AnimationDrawable) eVar.f19390b.getDrawable();
                this.f19400f.f19394f.start();
                this.f19400f.f19391c.postDelayed(new RunnableC0931a(this), 2000L);
                ((HotTopicActivity) this.f19400f.f19389a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19403f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19404e;

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
                this.f19404e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19404e.f19403f.m <= 1 || this.f19404e.f19403f.f19391c.getAnimation() == this.f19404e.f19403f.f19397i) {
                    return;
                }
                this.f19404e.f19403f.f19391c.startAnimation(this.f19404e.f19403f.f19397i);
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
            this.f19403f = eVar;
            this.f19402e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19403f.f19391c.getAnimation() == this.f19403f.f19395g) {
                    this.f19403f.f19391c.clearAnimation();
                    return;
                }
                this.f19403f.f19392d.setVisibility(0);
                this.f19403f.f19392d.setText(StringHelper.numFormatOverWan(this.f19402e + 1));
                if (this.f19403f.l) {
                    SkinManager.setImageResource(this.f19403f.f19390b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19403f.f19390b, R.drawable.candle_gif);
                }
                e eVar = this.f19403f;
                eVar.f19394f = (AnimationDrawable) eVar.f19390b.getDrawable();
                this.f19403f.f19394f.start();
                this.f19403f.f19391c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f19403f.f19389a.getOrignalPage()).sendBlessData();
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
        this.f19389a = tbPageContext;
        this.f19390b = (ImageView) view.findViewById(R.id.gif_image);
        this.f19391c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f19392d = (TextView) view.findViewById(R.id.git_desc);
        this.f19393e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19390b.clearAnimation();
            this.f19391c.clearAnimation();
            Animation animation = this.f19395g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f19396h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f19397i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f19398j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f19394f;
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
        this.f19391c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f19392d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f19392d.setVisibility(0);
                SkinManager.setImageResource(this.f19390b, R.drawable.bless_gif);
            } else {
                this.f19392d.setVisibility(8);
                SkinManager.setImageResource(this.f19390b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f19392d.getLayoutParams()).setMargins(this.f19389a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f19389a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f19392d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f19392d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f19392d.setVisibility(0);
                SkinManager.setImageResource(this.f19390b, R.drawable.candle_gif);
            } else {
                this.f19392d.setVisibility(8);
                SkinManager.setImageResource(this.f19390b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f19392d.getLayoutParams()).setMargins(this.f19389a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f19389a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f19392d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f19392d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f19391c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f19390b.getDrawable();
            this.f19394f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f19393e.setOnClickListener(new a(this, j2));
            this.f19391c.setOnClickListener(new b(this, j2));
        }
        this.k = true;
        this.f19395g = AnimationUtils.loadAnimation(this.f19389a.getPageActivity(), R.anim.gifview_rotate);
        this.f19396h = AnimationUtils.loadAnimation(this.f19389a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f19397i = AnimationUtils.loadAnimation(this.f19389a.getPageActivity(), R.anim.gifview_alpha);
        this.f19398j = AnimationUtils.loadAnimation(this.f19389a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f19390b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f19391c.getAnimation();
                    Animation animation2 = this.f19398j;
                    if (animation != animation2) {
                        this.f19391c.startAnimation(animation2);
                        this.f19394f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f19391c.getAnimation();
                Animation animation4 = this.f19397i;
                if (animation3 != animation4) {
                    this.f19391c.startAnimation(animation4);
                    this.f19394f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f19391c.getAnimation();
                Animation animation6 = this.f19395g;
                if (animation5 != animation6) {
                    this.f19391c.startAnimation(animation6);
                }
            } else if (this.f19391c.getAnimation() == this.f19395g) {
                this.f19391c.startAnimation(this.f19396h);
            }
        }
    }
}
