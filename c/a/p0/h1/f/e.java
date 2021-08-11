package c.a.p0.h1.f;

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
    public TbPageContext<HotTopicActivity> f18385a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f18386b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f18387c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f18388d;

    /* renamed from: e  reason: collision with root package name */
    public View f18389e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f18390f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f18391g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f18392h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f18393i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f18394j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f18395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18396f;

        /* renamed from: c.a.p0.h1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0885a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f18397e;

            public RunnableC0885a(a aVar) {
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
                this.f18397e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18397e.f18396f.m <= 1 || this.f18397e.f18396f.f18387c.getAnimation() == this.f18397e.f18396f.f18393i) {
                    return;
                }
                this.f18397e.f18396f.f18387c.startAnimation(this.f18397e.f18396f.f18393i);
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
            this.f18396f = eVar;
            this.f18395e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18396f.f18387c.getAnimation() == this.f18396f.f18391g) {
                    this.f18396f.f18387c.clearAnimation();
                    return;
                }
                this.f18396f.f18388d.setVisibility(0);
                this.f18396f.f18388d.setText(StringHelper.numFormatOverWan(this.f18395e + 1));
                if (this.f18396f.l) {
                    SkinManager.setImageResource(this.f18396f.f18386b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f18396f.f18386b, R.drawable.candle_gif);
                }
                e eVar = this.f18396f;
                eVar.f18390f = (AnimationDrawable) eVar.f18386b.getDrawable();
                this.f18396f.f18390f.start();
                this.f18396f.f18387c.postDelayed(new RunnableC0885a(this), 2000L);
                ((HotTopicActivity) this.f18396f.f18385a.getOrignalPage()).sendBlessData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f18398e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18399f;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18400e;

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
                this.f18400e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18400e.f18399f.m <= 1 || this.f18400e.f18399f.f18387c.getAnimation() == this.f18400e.f18399f.f18393i) {
                    return;
                }
                this.f18400e.f18399f.f18387c.startAnimation(this.f18400e.f18399f.f18393i);
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
            this.f18399f = eVar;
            this.f18398e = j2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f18399f.f18387c.getAnimation() == this.f18399f.f18391g) {
                    this.f18399f.f18387c.clearAnimation();
                    return;
                }
                this.f18399f.f18388d.setVisibility(0);
                this.f18399f.f18388d.setText(StringHelper.numFormatOverWan(this.f18398e + 1));
                if (this.f18399f.l) {
                    SkinManager.setImageResource(this.f18399f.f18386b, R.drawable.bless_gif);
                } else {
                    SkinManager.setImageResource(this.f18399f.f18386b, R.drawable.candle_gif);
                }
                e eVar = this.f18399f;
                eVar.f18390f = (AnimationDrawable) eVar.f18386b.getDrawable();
                this.f18399f.f18390f.start();
                this.f18399f.f18387c.postDelayed(new a(this), 2000L);
                ((HotTopicActivity) this.f18399f.f18385a.getOrignalPage()).sendBlessData();
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
        this.f18385a = tbPageContext;
        this.f18386b = (ImageView) view.findViewById(R.id.gif_image);
        this.f18387c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f18388d = (TextView) view.findViewById(R.id.git_desc);
        this.f18389e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18386b.clearAnimation();
            this.f18387c.clearAnimation();
            Animation animation = this.f18391g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.f18392h;
            if (animation2 != null) {
                animation2.cancel();
            }
            Animation animation3 = this.f18393i;
            if (animation3 != null) {
                animation3.cancel();
            }
            Animation animation4 = this.f18394j;
            if (animation4 != null) {
                animation4.cancel();
            }
            AnimationDrawable animationDrawable = this.f18390f;
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
        this.f18387c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f18388d.setText(StringHelper.numFormatOverWan(j2));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f18388d.setVisibility(0);
                SkinManager.setImageResource(this.f18386b, R.drawable.bless_gif);
            } else {
                this.f18388d.setVisibility(8);
                SkinManager.setImageResource(this.f18386b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f18388d.getLayoutParams()).setMargins(this.f18385a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f18385a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f18388d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f18388d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f18388d.setVisibility(0);
                SkinManager.setImageResource(this.f18386b, R.drawable.candle_gif);
            } else {
                this.f18388d.setVisibility(8);
                SkinManager.setImageResource(this.f18386b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f18388d.getLayoutParams()).setMargins(this.f18385a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f18385a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f18388d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f18388d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f18387c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f18386b.getDrawable();
            this.f18390f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f18389e.setOnClickListener(new a(this, j2));
            this.f18387c.setOnClickListener(new b(this, j2));
        }
        this.k = true;
        this.f18391g = AnimationUtils.loadAnimation(this.f18385a.getPageActivity(), R.anim.gifview_rotate);
        this.f18392h = AnimationUtils.loadAnimation(this.f18385a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f18393i = AnimationUtils.loadAnimation(this.f18385a.getPageActivity(), R.anim.gifview_alpha);
        this.f18394j = AnimationUtils.loadAnimation(this.f18385a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.k) {
            this.m = i2;
            if (this.f18386b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f18387c.getAnimation();
                    Animation animation2 = this.f18394j;
                    if (animation != animation2) {
                        this.f18387c.startAnimation(animation2);
                        this.f18390f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f18387c.getAnimation();
                Animation animation4 = this.f18393i;
                if (animation3 != animation4) {
                    this.f18387c.startAnimation(animation4);
                    this.f18390f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f18387c.getAnimation();
                Animation animation6 = this.f18391g;
                if (animation5 != animation6) {
                    this.f18387c.startAnimation(animation6);
                }
            } else if (this.f18387c.getAnimation() == this.f18391g) {
                this.f18387c.startAnimation(this.f18392h);
            }
        }
    }
}
