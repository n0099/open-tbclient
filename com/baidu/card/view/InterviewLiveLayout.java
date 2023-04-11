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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cg;
import com.baidu.tieba.hx;
import com.baidu.tieba.ii;
import com.baidu.tieba.jw4;
import com.baidu.tieba.mz4;
import com.baidu.tieba.rv4;
import com.baidu.tieba.sm;
import com.baidu.tieba.xg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class InterviewLiveLayout extends FrameLayout implements hx<jw4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public xg6<jw4> c;
    public jw4 d;
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

    /* loaded from: classes2.dex */
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
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ListUtils.getCount(this.a.i) > 0) {
                if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                    ii.P(this.a.getContext(), R.string.plugin_image_viewer_install_error_tips);
                    return;
                }
                String str = (String) this.a.i.get(0);
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                ImageUrlData imageUrlData = new ImageUrlData();
                if (this.a.b) {
                    i = 13;
                } else {
                    i = 14;
                }
                imageUrlData.urlType = i;
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
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterviewLiveLayout a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

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
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && tbImageView != null && tbImageView.getImageMatrix() != null) {
                if (this.a.b) {
                    i = 13;
                } else {
                    i = 14;
                }
                sm w = TbImageMemoryCache.s().w(cg.h().g(tbImageView.getUrl(), i));
                int i3 = 0;
                if (w != null) {
                    i3 = w.r();
                    i2 = w.m();
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    if (tbImageView.z() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i3 * height > width * i2) {
                            f4 = height;
                            f5 = i2;
                        } else {
                            f4 = width;
                            f5 = i3;
                        }
                        float f6 = f4 / f5;
                        imageMatrix.setScale(f6, f6);
                        imageMatrix.postTranslate(0.0f, 0.0f);
                    } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        if (i3 * height > width * i2) {
                            f = height / i2;
                            f3 = (width - (i3 * f)) * 0.5f;
                            f2 = 0.0f;
                        } else {
                            f = width / i3;
                            f2 = (height - (i2 * f)) * 0.5f;
                            f3 = 0.0f;
                        }
                        imageMatrix.setScale(f, f);
                        if (i2 > i3) {
                            imageMatrix.postTranslate(f3, 0.0f);
                        } else {
                            imageMatrix.postTranslate(f3, f2);
                        }
                    }
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

    public void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && i != this.a) {
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
            SkinManager.setImageResource(this.g, R.drawable.interview_live_circle_share);
            SkinManager.setBackgroundResource(this.f, R.drawable.interview_live_circle_bg_shape);
        }
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
        if ((interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) && (tbImageView = this.e) != null) {
            tbImageView.setPageId(bdUniqueId);
        }
    }

    public void setSubClickListener(xg6<jw4> xg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xg6Var) == null) {
            this.c = xg6Var;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            TbImageView tbImageView = (TbImageView) findViewById(R.id.img_interview_live);
            this.e = tbImageView;
            tbImageView.r(15);
            this.e.setPlaceHolder(3);
            this.f = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
            this.g = (ImageView) findViewById(R.id.interview_live_tip_img);
            this.h = (TextView) findViewById(R.id.interview_live_tip);
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hx
    /* renamed from: k */
    public void a(jw4 jw4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jw4Var) == null) {
            this.d = jw4Var;
            if (jw4Var != null && this.e != null) {
                ThreadData threadData = jw4Var.getThreadData();
                mz4 taskInfoData = threadData.getTaskInfoData();
                if (taskInfoData == null) {
                    setVisibility(8);
                    return;
                }
                this.j = threadData;
                this.k = threadData.getFid();
                this.l = taskInfoData.g();
                if (rv4.c().g() && taskInfoData != null && !StringUtils.isNull(taskInfoData.k())) {
                    this.i.clear();
                    this.i.add(taskInfoData.k());
                    setVisibility(0);
                    this.e.setSupportNoImage(true);
                    this.e.setScaleType(ImageView.ScaleType.MATRIX);
                    this.e.setOnDrawListener(this.n);
                    TbImageView tbImageView = this.e;
                    String k = taskInfoData.k();
                    if (this.b) {
                        i = 13;
                    } else {
                        i = 14;
                    }
                    tbImageView.N(k, i, false);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                    int l = ii.l(getContext()) - ii.g(getContext(), R.dimen.tbds88);
                    layoutParams.width = l;
                    layoutParams.height = (int) ((l * 428.0f) / 760.0f);
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
}
