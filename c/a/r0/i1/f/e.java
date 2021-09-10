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
    public TbPageContext<HotTopicActivity> f19374a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19375b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19376c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19377d;

    /* renamed from: e  reason: collision with root package name */
    public View f19378e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f19379f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19380g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19381h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f19382i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f19383j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19384e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19385f;

        /* renamed from: c.a.r0.i1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0933a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19386e;

            public RunnableC0933a(a aVar) {
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
                this.f19386e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19386e.f19385f.m <= 1 || this.f19386e.f19385f.f19376c.getAnimation() == this.f19386e.f19385f.f19382i) {
                    return;
                }
                this.f19386e.f19385f.f19376c.startAnimation(this.f19386e.f19385f.f19382i);
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
            this.f19385f = eVar;
            this.f19384e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19385f.f19376c.getAnimation() == this.f19385f.f19380g) {
                    this.f19385f.f19376c.clearAnimation();
                    return;
                }
                this.f19385f.f19377d.setVisibility(0);
                this.f19385f.f19377d.setText(StringHelper.numFormatOverWan(this.f19384e + 1));
                if (this.f19385f.l) {
                    SkinManager.setImageResource(this.f19385f.f19375b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19385f.f19375b, R.drawable.candle_gif);
                }
                e eVar = this.f19385f;
                eVar.f19379f = (AnimationDrawable) eVar.f19375b.getDrawable();
                this.f19385f.f19379f.start();
                this.f19385f.f19376c.postDelayed(new RunnableC0933a(this), 2000L);
                ((HotTopicActivity) this.f19385f.f19374a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19388f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19389e;

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
                this.f19389e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19389e.f19388f.m <= 1 || this.f19389e.f19388f.f19376c.getAnimation() == this.f19389e.f19388f.f19382i) {
                    return;
                }
                this.f19389e.f19388f.f19376c.startAnimation(this.f19389e.f19388f.f19382i);
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
            this.f19388f = eVar;
            this.f19387e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19388f.f19376c.getAnimation() == this.f19388f.f19380g) {
                    this.f19388f.f19376c.clearAnimation();
                    return;
                }
                this.f19388f.f19377d.setVisibility(0);
                this.f19388f.f19377d.setText(StringHelper.numFormatOverWan(this.f19387e + 1));
                if (this.f19388f.l) {
                    SkinManager.setImageResource(this.f19388f.f19375b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19388f.f19375b, R.drawable.candle_gif);
                }
                e eVar = this.f19388f;
                eVar.f19379f = (AnimationDrawable) eVar.f19375b.getDrawable();
                this.f19388f.f19379f.start();
                this.f19388f.f19376c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f19388f.f19374a.getOrignalPage()).sendBlessData();
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
        this.f19374a = tbPageContext;
        this.f19375b = (ImageView) view.findViewById(R.id.gif_image);
        this.f19376c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f19377d = (TextView) view.findViewById(R.id.git_desc);
        this.f19378e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19375b.clearAnimation();
            this.f19376c.clearAnimation();
            Animation animation = this.f19380g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f19381h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f19382i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f19383j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f19379f;
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
        this.f19376c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f19377d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f19377d.setVisibility(0);
                SkinManager.setImageResource(this.f19375b, R.drawable.bless_gif);
            } else {
                this.f19377d.setVisibility(8);
                SkinManager.setImageResource(this.f19375b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f19377d.getLayoutParams()).setMargins(this.f19374a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f19374a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f19377d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f19377d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f19377d.setVisibility(0);
                SkinManager.setImageResource(this.f19375b, R.drawable.candle_gif);
            } else {
                this.f19377d.setVisibility(8);
                SkinManager.setImageResource(this.f19375b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f19377d.getLayoutParams()).setMargins(this.f19374a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f19374a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f19377d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f19377d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f19376c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f19375b.getDrawable();
            this.f19379f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f19378e.setOnClickListener(new a(this, j2));
            this.f19376c.setOnClickListener(new b(this, j2));
        }
        this.k = true;
        this.f19380g = AnimationUtils.loadAnimation(this.f19374a.getPageActivity(), R.anim.gifview_rotate);
        this.f19381h = AnimationUtils.loadAnimation(this.f19374a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f19382i = AnimationUtils.loadAnimation(this.f19374a.getPageActivity(), R.anim.gifview_alpha);
        this.f19383j = AnimationUtils.loadAnimation(this.f19374a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f19375b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f19376c.getAnimation();
                    Animation animation2 = this.f19383j;
                    if (animation != animation2) {
                        this.f19376c.startAnimation(animation2);
                        this.f19379f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f19376c.getAnimation();
                Animation animation4 = this.f19382i;
                if (animation3 != animation4) {
                    this.f19376c.startAnimation(animation4);
                    this.f19379f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f19376c.getAnimation();
                Animation animation6 = this.f19380g;
                if (animation5 != animation6) {
                    this.f19376c.startAnimation(animation6);
                }
            } else if (this.f19376c.getAnimation() == this.f19380g) {
                this.f19376c.startAnimation(this.f19381h);
            }
        }
    }
}
