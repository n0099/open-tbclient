package c.a.q0.h1.f;

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
    public TbPageContext<HotTopicActivity> f18718a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18719b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f18720c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18721d;

    /* renamed from: e  reason: collision with root package name */
    public View f18722e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f18723f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f18724g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f18725h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f18726i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f18727j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f18728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18729f;

        /* renamed from: c.a.q0.h1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0896a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f18730e;

            public RunnableC0896a(a aVar) {
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
                this.f18730e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18730e.f18729f.m <= 1 || this.f18730e.f18729f.f18720c.getAnimation() == this.f18730e.f18729f.f18726i) {
                    return;
                }
                this.f18730e.f18729f.f18720c.startAnimation(this.f18730e.f18729f.f18726i);
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
            this.f18729f = eVar;
            this.f18728e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18729f.f18720c.getAnimation() == this.f18729f.f18724g) {
                    this.f18729f.f18720c.clearAnimation();
                    return;
                }
                this.f18729f.f18721d.setVisibility(0);
                this.f18729f.f18721d.setText(StringHelper.numFormatOverWan(this.f18728e + 1));
                if (this.f18729f.l) {
                    SkinManager.setImageResource(this.f18729f.f18719b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f18729f.f18719b, R.drawable.candle_gif);
                }
                e eVar = this.f18729f;
                eVar.f18723f = (AnimationDrawable) eVar.f18719b.getDrawable();
                this.f18729f.f18723f.start();
                this.f18729f.f18720c.postDelayed(new RunnableC0896a(this), 2000L);
                ((HotTopicActivity) this.f18729f.f18718a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f18731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18732f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18733e;

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
                this.f18733e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18733e.f18732f.m <= 1 || this.f18733e.f18732f.f18720c.getAnimation() == this.f18733e.f18732f.f18726i) {
                    return;
                }
                this.f18733e.f18732f.f18720c.startAnimation(this.f18733e.f18732f.f18726i);
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
            this.f18732f = eVar;
            this.f18731e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18732f.f18720c.getAnimation() == this.f18732f.f18724g) {
                    this.f18732f.f18720c.clearAnimation();
                    return;
                }
                this.f18732f.f18721d.setVisibility(0);
                this.f18732f.f18721d.setText(StringHelper.numFormatOverWan(this.f18731e + 1));
                if (this.f18732f.l) {
                    SkinManager.setImageResource(this.f18732f.f18719b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f18732f.f18719b, R.drawable.candle_gif);
                }
                e eVar = this.f18732f;
                eVar.f18723f = (AnimationDrawable) eVar.f18719b.getDrawable();
                this.f18732f.f18723f.start();
                this.f18732f.f18720c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f18732f.f18718a.getOrignalPage()).sendBlessData();
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
        this.f18718a = tbPageContext;
        this.f18719b = (ImageView) view.findViewById(R.id.gif_image);
        this.f18720c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f18721d = (TextView) view.findViewById(R.id.git_desc);
        this.f18722e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18719b.clearAnimation();
            this.f18720c.clearAnimation();
            Animation animation = this.f18724g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f18725h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f18726i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f18727j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f18723f;
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
        this.f18720c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f18721d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f18721d.setVisibility(0);
                SkinManager.setImageResource(this.f18719b, R.drawable.bless_gif);
            } else {
                this.f18721d.setVisibility(8);
                SkinManager.setImageResource(this.f18719b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f18721d.getLayoutParams()).setMargins(this.f18718a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f18718a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f18721d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f18721d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f18721d.setVisibility(0);
                SkinManager.setImageResource(this.f18719b, R.drawable.candle_gif);
            } else {
                this.f18721d.setVisibility(8);
                SkinManager.setImageResource(this.f18719b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f18721d.getLayoutParams()).setMargins(this.f18718a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f18718a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f18721d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f18721d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f18720c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f18719b.getDrawable();
            this.f18723f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f18722e.setOnClickListener(new a(this, j2));
            this.f18720c.setOnClickListener(new b(this, j2));
        }
        this.k = true;
        this.f18724g = AnimationUtils.loadAnimation(this.f18718a.getPageActivity(), R.anim.gifview_rotate);
        this.f18725h = AnimationUtils.loadAnimation(this.f18718a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f18726i = AnimationUtils.loadAnimation(this.f18718a.getPageActivity(), R.anim.gifview_alpha);
        this.f18727j = AnimationUtils.loadAnimation(this.f18718a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f18719b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f18720c.getAnimation();
                    Animation animation2 = this.f18727j;
                    if (animation != animation2) {
                        this.f18720c.startAnimation(animation2);
                        this.f18723f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f18720c.getAnimation();
                Animation animation4 = this.f18726i;
                if (animation3 != animation4) {
                    this.f18720c.startAnimation(animation4);
                    this.f18723f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f18720c.getAnimation();
                Animation animation6 = this.f18724g;
                if (animation5 != animation6) {
                    this.f18720c.startAnimation(animation6);
                }
            } else if (this.f18720c.getAnimation() == this.f18724g) {
                this.f18720c.startAnimation(this.f18725h);
            }
        }
    }
}
