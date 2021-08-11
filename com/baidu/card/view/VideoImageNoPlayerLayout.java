package com.baidu.card.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.l.p;
import c.a.o0.s.u.c;
import c.a.p0.a0.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<c.a.o0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canCenterStart;

    /* renamed from: e  reason: collision with root package name */
    public Context f38601e;

    /* renamed from: f  reason: collision with root package name */
    public int f38602f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f38603g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f38604h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38605i;
    public boolean isVerticalVideo;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38606j;
    public TextView k;
    public b0<c.a.o0.s.q.a> l;
    public c.a.o0.s.q.a m;
    public RelativeLayout mContainerView;
    public long mFid;
    public String mFrom;
    public String mTid;
    public RelativeLayout mVideoContainerView;
    public long mVideoDurationData;
    public long mVideoSize;
    public TbImageView mVideoThumbnail;
    public View mVideoThumbnailMask;
    public View.OnClickListener n;
    public c.a.l.w0.a o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoImageNoPlayerLayout f38607e;

        public a(VideoImageNoPlayerLayout videoImageNoPlayerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoImageNoPlayerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38607e = videoImageNoPlayerLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f38607e.l != null) {
                    b0 b0Var = this.f38607e.l;
                    VideoImageNoPlayerLayout videoImageNoPlayerLayout = this.f38607e;
                    b0Var.a(videoImageNoPlayerLayout.mVideoThumbnail, videoImageNoPlayerLayout.m);
                }
                if (this.f38607e.n != null) {
                    this.f38607e.n.onClick(this.f38607e.mVideoThumbnail);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoImageNoPlayerLayout f38608e;

        public b(VideoImageNoPlayerLayout videoImageNoPlayerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoImageNoPlayerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38608e = videoImageNoPlayerLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f38608e.o.a(this.f38608e.m);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoImageNoPlayerLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38602f = 3;
        this.canCenterStart = false;
        this.f38601e = context;
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mContainerView = (RelativeLayout) findViewById(R.id.operable_video_container);
            this.mVideoContainerView = (RelativeLayout) findViewById(R.id.video_container);
            new WeakReference(TbadkCoreApplication.getInst());
            this.mVideoThumbnail = (TbImageView) findViewById(R.id.video_thumbnail);
            this.mVideoThumbnailMask = findViewById(R.id.video_thumbnail_mask);
            this.f38603g = (ImageView) findViewById(R.id.video_play);
            this.f38604h = (ImageView) findViewById(R.id.video_pause);
            this.f38605i = (TextView) findViewById(R.id.video_play_count);
            this.f38606j = (TextView) findViewById(R.id.video_play_flag);
            this.k = (TextView) findViewById(R.id.video_duration);
            this.mVideoThumbnail.setConrers(15);
            this.mVideoThumbnail.setRadiusById(R.string.J_X05);
            this.mVideoThumbnail.setDrawCorner(true);
            this.mVideoThumbnail.setPlaceHolder(3);
            setOnClickListener(new a(this));
            SkinManager.setBackgroundResource(this, R.color.CAM_X0206);
        }
    }

    public final void f() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (relativeLayout = this.mVideoContainerView) == null) {
            return;
        }
        relativeLayout.setOnClickListener(new b(this));
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mContainerView : (View) invokeV.objValue;
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i2) == null) {
            if (this.f38602f != i2) {
                c.d(this.mVideoThumbnailMask).r(R.array.Mask_X003);
                c.d(this.mVideoThumbnailMask).n(R.string.J_X05);
                SkinManager.setBackgroundColor(this.mContainerView, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.mVideoContainerView, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
                this.f38603g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                this.f38604h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            }
            this.f38602f = i2;
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.canCenterStart = z;
        }
    }

    public void setData(c.a.o0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void setOnCardSubClickListener(b0<c.a.o0.s.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, b0Var) == null) {
            this.l = b0Var;
        }
    }

    public void setVideoAreaClickListener(c.a.l.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                f();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    public void onBindDataToView(c.a.o0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().v1 == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = aVar.getThreadData().v1;
        this.isVerticalVideo = originalThreadInfo.r.is_vertical.intValue() == 1;
        this.mTid = originalThreadInfo.f47200f;
        this.mVideoSize = originalThreadInfo.r.video_length.intValue();
        this.mVideoDurationData = originalThreadInfo.r.video_duration.intValue();
        this.mFid = originalThreadInfo.f47199e;
        this.k.setText(StringHelper.stringForVideoTime(originalThreadInfo.r.video_duration.intValue() * 1000));
        this.f38605i.setText(String.format(this.f38601e.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(originalThreadInfo.r.play_count.intValue())));
        this.f38606j.setVisibility(8);
        this.mVideoThumbnail.startLoad(originalThreadInfo.r.thumbnail_url, 10, false);
    }
}
