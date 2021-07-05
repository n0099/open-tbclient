package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.l.d;
import d.a.c.e.p.l;
import d.a.j.p;
import d.a.r0.a0.c;
import d.a.r0.r.k;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.z1;
import d.a.s0.a0.b0;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class InterviewLiveLayout extends FrameLayout implements p<d.a.r0.r.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f4444e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4445f;

    /* renamed from: g  reason: collision with root package name */
    public b0<d.a.r0.r.q.a> f4446g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.r.q.a f4447h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f4448i;
    public LinearLayout j;
    public ImageView k;
    public TextView l;
    public ArrayList<String> m;
    public b2 n;
    public long o;
    public String p;
    public View.OnClickListener q;
    public TbImageView.g r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterviewLiveLayout f4449e;

        public a(InterviewLiveLayout interviewLiveLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interviewLiveLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4449e = interviewLiveLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ListUtils.getCount(this.f4449e.m) <= 0) {
                return;
            }
            if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                String str = (String) this.f4449e.m.get(0);
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.f4449e.f4445f ? 13 : 14;
                imageUrlData.imageUrl = str;
                imageUrlData.originalUrl = str;
                imageUrlData.originalSize = 0L;
                imageUrlData.isLongPic = false;
                imageUrlData.mIsShowOrigonButton = false;
                imageUrlData.threadId = 0L;
                imageUrlData.postId = 0L;
                concurrentHashMap.put(str, imageUrlData);
                ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                bVar.x(this.f4449e.m);
                bVar.C(this.f4449e.f4445f);
                bVar.J(str);
                bVar.F(false);
                bVar.w(concurrentHashMap);
                bVar.H(false);
                bVar.N(this.f4449e.n);
                bVar.I(false);
                ImageViewerConfig v = bVar.v(this.f4449e.getContext());
                v.getIntent().putExtra("from", "frs");
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                v.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
                StatisticItem statisticItem = new StatisticItem("c13327");
                statisticItem.param("fid", this.f4449e.o);
                statisticItem.param("obj_id", this.f4449e.p);
                TiebaStatic.log(statisticItem);
                if (this.f4449e.f4446g != null) {
                    this.f4449e.f4446g.a(this.f4449e.f4448i, this.f4449e.f4447h);
                    return;
                }
                return;
            }
            l.L(this.f4449e.getContext(), R.string.plugin_image_viewer_install_error_tips);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterviewLiveLayout f4450a;

        public b(InterviewLiveLayout interviewLiveLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interviewLiveLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4450a = interviewLiveLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            d.a.c.k.d.a m = c.k().m(d.h().g(tbImageView.getUrl(), this.f4450a.f4445f ? 13 : 14));
            int i3 = 0;
            if (m != null) {
                i3 = m.r();
                i2 = m.m();
            } else {
                i2 = 0;
            }
            if (i3 == 0 || i2 == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            if (tbImageView.x() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f5 = height;
                    f6 = i2;
                } else {
                    f5 = width;
                    f6 = i3;
                }
                float f7 = f5 / f6;
                imageMatrix.setScale(f7, f7);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i3 * height > width * i2) {
                    f2 = height / i2;
                    f4 = (width - (i3 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i3;
                    f3 = (height - (i2 * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (i2 > i3) {
                    imageMatrix.postTranslate(f4, 0.0f);
                } else {
                    imageMatrix.postTranslate(f4, f3);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterviewLiveLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.img_interview_live);
            this.f4448i = tbImageView;
            tbImageView.r(15);
            this.f4448i.setPlaceHolder(3);
            this.j = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
            this.k = (ImageView) findViewById(R.id.interview_live_tip_img);
            this.l = (TextView) findViewById(R.id.interview_live_tip);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: k */
    public void a(d.a.r0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f4447h = aVar;
            if (aVar != null && this.f4448i != null) {
                b2 threadData = aVar.getThreadData();
                z1 e1 = threadData.e1();
                if (e1 == null) {
                    setVisibility(8);
                    return;
                }
                this.n = threadData;
                this.o = threadData.Q();
                this.p = e1.f();
                if (k.c().g() && e1 != null && !StringUtils.isNull(e1.i())) {
                    this.m.clear();
                    this.m.add(e1.i());
                    setVisibility(0);
                    this.f4448i.setSupportNoImage(true);
                    this.f4448i.setScaleType(ImageView.ScaleType.MATRIX);
                    this.f4448i.setOnDrawListener(this.r);
                    this.f4448i.M(e1.i(), this.f4445f ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                    int k = l.k(getContext()) - l.g(getContext(), R.dimen.tbds88);
                    layoutParams.width = k;
                    layoutParams.height = (int) ((k * 428.0f) / 760.0f);
                    setLayoutParams(layoutParams);
                } else {
                    setVisibility(8);
                }
                this.f4448i.setOnClickListener(this.q);
                return;
            }
            setVisibility(8);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 == this.f4444e) {
            return;
        }
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
        SkinManager.setImageResource(this.k, R.drawable.interview_live_circle_share);
        SkinManager.setBackgroundResource(this.j, R.drawable.interview_live_circle_bg_shape);
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f4445f = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) || (tbImageView = this.f4448i) == null) {
            return;
        }
        tbImageView.setPageId(bdUniqueId);
    }

    public void setSubClickListener(b0<d.a.r0.r.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b0Var) == null) {
            this.f4446g = b0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4444e = 3;
        this.f4445f = true;
        this.f4447h = null;
        this.m = new ArrayList<>();
        this.q = new a(this);
        this.r = new b(this);
        j();
    }
}
