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
import c.a.d.f.l.d;
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.o0.b0.c;
import c.a.o0.r.l;
import c.a.o0.r.r.z1;
import c.a.p0.h0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class InterviewLiveLayout extends FrameLayout implements p<c.a.o0.r.r.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25076b;

    /* renamed from: c  reason: collision with root package name */
    public b0<c.a.o0.r.r.a> f25077c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.r.a f25078d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f25079e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25080f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25081g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25082h;
    public ArrayList<String> i;
    public ThreadData j;
    public long k;
    public String l;
    public View.OnClickListener m;
    public TbImageView.h n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterviewLiveLayout a;

        public a(InterviewLiveLayout interviewLiveLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interviewLiveLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interviewLiveLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ListUtils.getCount(this.a.i) <= 0) {
                return;
            }
            if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                String str = (String) this.a.i.get(0);
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.a.f25076b ? 13 : 14;
                imageUrlData.imageUrl = str;
                imageUrlData.originalUrl = str;
                imageUrlData.originalSize = 0L;
                imageUrlData.isLongPic = false;
                imageUrlData.mIsShowOrigonButton = false;
                imageUrlData.threadId = 0L;
                imageUrlData.postId = 0L;
                concurrentHashMap.put(str, imageUrlData);
                ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                bVar.x(this.a.i);
                bVar.C(this.a.f25076b);
                bVar.J(str);
                bVar.F(false);
                bVar.w(concurrentHashMap);
                bVar.H(false);
                bVar.N(this.a.j);
                bVar.I(false);
                ImageViewerConfig v = bVar.v(this.a.getContext());
                v.getIntent().putExtra("from", "frs");
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                v.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
                StatisticItem statisticItem = new StatisticItem("c13327");
                statisticItem.param("fid", this.a.k);
                statisticItem.param("obj_id", this.a.l);
                TiebaStatic.log(statisticItem);
                if (this.a.f25077c != null) {
                    this.a.f25077c.a(this.a.f25079e, this.a.f25078d);
                    return;
                }
                return;
            }
            n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0e63);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterviewLiveLayout a;

        public b(InterviewLiveLayout interviewLiveLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interviewLiveLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interviewLiveLayout;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            c.a.d.o.d.a m = c.k().m(d.h().g(tbImageView.getUrl(), this.a.f25076b ? 13 : 14));
            int i2 = 0;
            if (m != null) {
                i2 = m.r();
                i = m.m();
            } else {
                i = 0;
            }
            if (i2 == 0 || i == 0) {
                return;
            }
            int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
            int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
            Matrix imageMatrix = tbImageView.getImageMatrix();
            if (tbImageView.x() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f5 = height;
                    f6 = i;
                } else {
                    f5 = width;
                    f6 = i2;
                }
                float f7 = f5 / f6;
                imageMatrix.setScale(f7, f7);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f2 = height / i;
                    f4 = (width - (i2 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / i2;
                    f3 = (height - (i * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                imageMatrix.setScale(f2, f2);
                if (i > i2) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03f4, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090eb9);
            this.f25079e = tbImageView;
            tbImageView.r(15);
            this.f25079e.setPlaceHolder(3);
            this.f25080f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f43);
            this.f25081g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f44);
            this.f25082h = (TextView) findViewById(R.id.obfuscated_res_0x7f090f42);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: k */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f25078d = aVar;
            if (aVar != null && this.f25079e != null) {
                ThreadData threadData = aVar.getThreadData();
                z1 taskInfoData = threadData.getTaskInfoData();
                if (taskInfoData == null) {
                    setVisibility(8);
                    return;
                }
                this.j = threadData;
                this.k = threadData.getFid();
                this.l = taskInfoData.f();
                if (l.c().g() && taskInfoData != null && !StringUtils.isNull(taskInfoData.i())) {
                    this.i.clear();
                    this.i.add(taskInfoData.i());
                    setVisibility(0);
                    this.f25079e.setSupportNoImage(true);
                    this.f25079e.setScaleType(ImageView.ScaleType.MATRIX);
                    this.f25079e.setOnDrawListener(this.n);
                    this.f25079e.J(taskInfoData.i(), this.f25076b ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                    int k = n.k(getContext()) - n.f(getContext(), R.dimen.tbds88);
                    layoutParams.width = k;
                    layoutParams.height = (int) ((k * 428.0f) / 760.0f);
                    setLayoutParams(layoutParams);
                } else {
                    setVisibility(8);
                }
                this.f25079e.setOnClickListener(this.m);
                return;
            }
            setVisibility(8);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i == this.a) {
            return;
        }
        SkinManager.setViewTextColor(this.f25082h, (int) R.color.CAM_X0101);
        SkinManager.setImageResource(this.f25081g, R.drawable.interview_live_circle_share);
        SkinManager.setBackgroundResource(this.f25080f, R.drawable.interview_live_circle_bg_shape);
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f25076b = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) || (tbImageView = this.f25079e) == null) {
            return;
        }
        tbImageView.setPageId(bdUniqueId);
    }

    public void setSubClickListener(b0<c.a.o0.r.r.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b0Var) == null) {
            this.f25077c = b0Var;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f25076b = true;
        this.f25078d = null;
        this.i = new ArrayList<>();
        this.m = new a(this);
        this.n = new b(this);
        j();
    }
}
