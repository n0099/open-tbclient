package c.a.r0.j1.f;

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
    public TbPageContext<HotTopicActivity> f19560a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19561b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f19562c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19563d;

    /* renamed from: e  reason: collision with root package name */
    public View f19564e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f19565f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19566g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19567h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f19568i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f19569j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19570e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19571f;

        /* renamed from: c.a.r0.j1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0940a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19572e;

            public RunnableC0940a(a aVar) {
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
                this.f19572e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19572e.f19571f.m <= 1 || this.f19572e.f19571f.f19562c.getAnimation() == this.f19572e.f19571f.f19568i) {
                    return;
                }
                this.f19572e.f19571f.f19562c.startAnimation(this.f19572e.f19571f.f19568i);
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
            this.f19571f = eVar;
            this.f19570e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19571f.f19562c.getAnimation() == this.f19571f.f19566g) {
                    this.f19571f.f19562c.clearAnimation();
                    return;
                }
                this.f19571f.f19563d.setVisibility(0);
                this.f19571f.f19563d.setText(StringHelper.numFormatOverWan(this.f19570e + 1));
                if (this.f19571f.l) {
                    SkinManager.setImageResource(this.f19571f.f19561b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19571f.f19561b, R.drawable.candle_gif);
                }
                e eVar = this.f19571f;
                eVar.f19565f = (AnimationDrawable) eVar.f19561b.getDrawable();
                this.f19571f.f19565f.start();
                this.f19571f.f19562c.postDelayed(new RunnableC0940a(this), 2000L);
                ((HotTopicActivity) this.f19571f.f19560a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f19573e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f19574f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19575e;

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
                this.f19575e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19575e.f19574f.m <= 1 || this.f19575e.f19574f.f19562c.getAnimation() == this.f19575e.f19574f.f19568i) {
                    return;
                }
                this.f19575e.f19574f.f19562c.startAnimation(this.f19575e.f19574f.f19568i);
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
            this.f19574f = eVar;
            this.f19573e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19574f.f19562c.getAnimation() == this.f19574f.f19566g) {
                    this.f19574f.f19562c.clearAnimation();
                    return;
                }
                this.f19574f.f19563d.setVisibility(0);
                this.f19574f.f19563d.setText(StringHelper.numFormatOverWan(this.f19573e + 1));
                if (this.f19574f.l) {
                    SkinManager.setImageResource(this.f19574f.f19561b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f19574f.f19561b, R.drawable.candle_gif);
                }
                e eVar = this.f19574f;
                eVar.f19565f = (AnimationDrawable) eVar.f19561b.getDrawable();
                this.f19574f.f19565f.start();
                this.f19574f.f19562c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f19574f.f19560a.getOrignalPage()).sendBlessData();
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
        this.f19560a = tbPageContext;
        this.f19561b = (ImageView) view.findViewById(R.id.gif_image);
        this.f19562c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f19563d = (TextView) view.findViewById(R.id.git_desc);
        this.f19564e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19561b.clearAnimation();
            this.f19562c.clearAnimation();
            Animation animation = this.f19566g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f19567h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f19568i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f19569j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f19565f;
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
        this.f19562c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f19563d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f19563d.setVisibility(0);
                SkinManager.setImageResource(this.f19561b, R.drawable.bless_gif);
            } else {
                this.f19563d.setVisibility(8);
                SkinManager.setImageResource(this.f19561b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f19563d.getLayoutParams()).setMargins(this.f19560a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f19560a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f19563d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f19563d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f19563d.setVisibility(0);
                SkinManager.setImageResource(this.f19561b, R.drawable.candle_gif);
            } else {
                this.f19563d.setVisibility(8);
                SkinManager.setImageResource(this.f19561b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f19563d.getLayoutParams()).setMargins(this.f19560a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f19560a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f19563d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f19563d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f19562c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f19561b.getDrawable();
            this.f19565f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f19564e.setOnClickListener(new a(this, j2));
            this.f19562c.setOnClickListener(new b(this, j2));
        }
        this.k = true;
        this.f19566g = AnimationUtils.loadAnimation(this.f19560a.getPageActivity(), R.anim.gifview_rotate);
        this.f19567h = AnimationUtils.loadAnimation(this.f19560a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f19568i = AnimationUtils.loadAnimation(this.f19560a.getPageActivity(), R.anim.gifview_alpha);
        this.f19569j = AnimationUtils.loadAnimation(this.f19560a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f19561b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f19562c.getAnimation();
                    Animation animation2 = this.f19569j;
                    if (animation != animation2) {
                        this.f19562c.startAnimation(animation2);
                        this.f19565f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f19562c.getAnimation();
                Animation animation4 = this.f19568i;
                if (animation3 != animation4) {
                    this.f19562c.startAnimation(animation4);
                    this.f19565f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f19562c.getAnimation();
                Animation animation6 = this.f19566g;
                if (animation5 != animation6) {
                    this.f19562c.startAnimation(animation6);
                }
            } else if (this.f19562c.getAnimation() == this.f19566g) {
                this.f19562c.startAnimation(this.f19567h);
            }
        }
    }
}
