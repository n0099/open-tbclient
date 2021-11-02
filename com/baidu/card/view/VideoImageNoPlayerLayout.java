package com.baidu.card.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.l.p;
import b.a.q0.s.u.c;
import b.a.r0.b0.c0;
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
/* loaded from: classes7.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canCenterStart;

    /* renamed from: e  reason: collision with root package name */
    public Context f36845e;

    /* renamed from: f  reason: collision with root package name */
    public int f36846f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f36847g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f36848h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f36849i;
    public boolean isVerticalVideo;
    public TextView j;
    public TextView k;
    public c0<b.a.q0.s.q.a> l;
    public b.a.q0.s.q.a m;
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
    public b.a.l.w0.a o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoImageNoPlayerLayout f36850e;

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
            this.f36850e = videoImageNoPlayerLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f36850e.l != null) {
                    c0 c0Var = this.f36850e.l;
                    VideoImageNoPlayerLayout videoImageNoPlayerLayout = this.f36850e;
                    c0Var.a(videoImageNoPlayerLayout.mVideoThumbnail, videoImageNoPlayerLayout.m);
                }
                if (this.f36850e.n != null) {
                    this.f36850e.n.onClick(this.f36850e.mVideoThumbnail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoImageNoPlayerLayout f36851e;

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
            this.f36851e = videoImageNoPlayerLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f36851e.o.a(this.f36851e.m);
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
        this.f36846f = 3;
        this.canCenterStart = false;
        this.f36845e = context;
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
            this.f36847g = (ImageView) findViewById(R.id.video_play);
            this.f36848h = (ImageView) findViewById(R.id.video_pause);
            this.f36849i = (TextView) findViewById(R.id.video_play_count);
            this.j = (TextView) findViewById(R.id.video_play_flag);
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
            if (this.f36846f != i2) {
                c.d(this.mVideoThumbnailMask).s(R.array.Mask_X003);
                c.d(this.mVideoThumbnailMask).n(R.string.J_X05);
                SkinManager.setBackgroundColor(this.mContainerView, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.mVideoContainerView, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
                this.f36847g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                this.f36848h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            }
            this.f36846f = i2;
        }
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.canCenterStart = z;
        }
    }

    public void setData(b.a.q0.s.q.a aVar) {
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

    public void setOnCardSubClickListener(c0<b.a.q0.s.q.a> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, c0Var) == null) {
            this.l = c0Var;
        }
    }

    public void setVideoAreaClickListener(b.a.l.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.o = aVar;
            if (aVar != null) {
                f();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = aVar.getThreadData().y1;
        this.isVerticalVideo = originalThreadInfo.r.is_vertical.intValue() == 1;
        this.mTid = originalThreadInfo.f45040f;
        this.mVideoSize = originalThreadInfo.r.video_length.intValue();
        this.mVideoDurationData = originalThreadInfo.r.video_duration.intValue();
        this.mFid = originalThreadInfo.f45039e;
        this.k.setText(StringHelper.stringForVideoTime(originalThreadInfo.r.video_duration.intValue() * 1000));
        this.f36849i.setText(String.format(this.f36845e.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(originalThreadInfo.r.play_count.intValue())));
        this.j.setVisibility(8);
        this.mVideoThumbnail.startLoad(originalThreadInfo.r.thumbnail_url, 10, false);
    }
}
