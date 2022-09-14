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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.lq4;
import com.baidu.tieba.mt4;
import com.baidu.tieba.on;
import com.baidu.tieba.u75;
import com.baidu.tieba.up4;
import com.baidu.tieba.v16;
import com.baidu.tieba.wx;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class InterviewLiveLayout extends FrameLayout implements wx<lq4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public v16<lq4> c;
    public lq4 d;
    public TbImageView e;
    public LinearLayout f;
    public ImageView g;
    public TextView h;
    public ArrayList<String> i;
    public ThreadData j;
    public long k;
    public String l;
    public View.OnClickListener m;
    public TbImageView.h n;

    /* loaded from: classes.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || ListUtils.getCount(this.a.i) <= 0) {
                return;
            }
            if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                String str = (String) this.a.i.get(0);
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                ImageUrlData imageUrlData = new ImageUrlData();
                imageUrlData.urlType = this.a.b ? 13 : 14;
                imageUrlData.imageUrl = str;
                imageUrlData.originalUrl = str;
                imageUrlData.originalSize = 0L;
                imageUrlData.isLongPic = false;
                imageUrlData.mIsShowOrigonButton = false;
                imageUrlData.threadId = 0L;
                imageUrlData.postId = 0L;
                concurrentHashMap.put(str, imageUrlData);
                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                builder.A(this.a.i);
                builder.F(this.a.b);
                builder.M(str);
                builder.I(false);
                builder.y(concurrentHashMap);
                builder.K(false);
                builder.Q(this.a.j);
                builder.L(false);
                builder.O(this.a.j.getFirst_post_id());
                ImageViewerConfig x = builder.x(this.a.getContext());
                x.getIntent().putExtra("from", "frs");
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                x.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x));
                StatisticItem statisticItem = new StatisticItem("c13327");
                statisticItem.param("fid", this.a.k);
                statisticItem.param("obj_id", this.a.l);
                TiebaStatic.log(statisticItem);
                if (this.a.c != null) {
                    this.a.c.a(this.a.e, this.a.d);
                    return;
                }
                return;
            }
            ej.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0ec1);
        }
    }

    /* loaded from: classes.dex */
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
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) || tbImageView == null || tbImageView.getImageMatrix() == null) {
                return;
            }
            on m = u75.k().m(zg.h().g(tbImageView.getUrl(), this.a.b ? 13 : 14));
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
                    f4 = height;
                    f5 = i;
                } else {
                    f4 = width;
                    f5 = i2;
                }
                float f6 = f4 / f5;
                imageMatrix.setScale(f6, f6);
                imageMatrix.postTranslate(0.0f, 0.0f);
            } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                if (i2 * height > width * i) {
                    f = height / i;
                    f3 = (width - (i2 * f)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f = width / i2;
                    f2 = (height - (i * f)) * 0.5f;
                    f3 = 0.0f;
                }
                imageMatrix.setScale(f, f);
                if (i > i2) {
                    imageMatrix.postTranslate(f3, 0.0f);
                } else {
                    imageMatrix.postTranslate(f3, f2);
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03e4, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090ee8);
            this.e = tbImageView;
            tbImageView.r(15);
            this.e.setPlaceHolder(3);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090f70);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f71);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090f6f);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wx
    /* renamed from: k */
    public void a(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lq4Var) == null) {
            this.d = lq4Var;
            if (lq4Var != null && this.e != null) {
                ThreadData threadData = lq4Var.getThreadData();
                mt4 taskInfoData = threadData.getTaskInfoData();
                if (taskInfoData == null) {
                    setVisibility(8);
                    return;
                }
                this.j = threadData;
                this.k = threadData.getFid();
                this.l = taskInfoData.f();
                if (up4.c().g() && taskInfoData != null && !StringUtils.isNull(taskInfoData.i())) {
                    this.i.clear();
                    this.i.add(taskInfoData.i());
                    setVisibility(0);
                    this.e.setSupportNoImage(true);
                    this.e.setScaleType(ImageView.ScaleType.MATRIX);
                    this.e.setOnDrawListener(this.n);
                    this.e.K(taskInfoData.i(), this.b ? 13 : 14, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                    int k = ej.k(getContext()) - ej.f(getContext(), R.dimen.tbds88);
                    layoutParams.width = k;
                    layoutParams.height = (int) ((k * 428.0f) / 760.0f);
                    setLayoutParams(layoutParams);
                } else {
                    setVisibility(8);
                }
                this.e.setOnClickListener(this.m);
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
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
        SkinManager.setImageResource(this.g, R.drawable.interview_live_circle_share);
        SkinManager.setBackgroundResource(this.f, R.drawable.interview_live_circle_bg_shape);
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.b = z;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) || (tbImageView = this.e) == null) {
            return;
        }
        tbImageView.setPageId(bdUniqueId);
    }

    public void setSubClickListener(v16<lq4> v16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, v16Var) == null) {
            this.c = v16Var;
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
        this.b = true;
        this.d = null;
        this.i = new ArrayList<>();
        this.m = new a(this);
        this.n = new b(this);
        j();
    }
}
