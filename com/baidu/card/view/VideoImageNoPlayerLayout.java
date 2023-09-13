package com.baidu.card.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b15;
import com.baidu.tieba.ez;
import com.baidu.tieba.mp6;
import com.baidu.tieba.ux;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements ux<b15> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public TbImageView c;
    public View d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public RelativeLayout j;
    public RelativeLayout k;
    public boolean l;
    public mp6<b15> m;
    public b15 n;
    public View.OnClickListener o;
    public ez p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoImageNoPlayerLayout a;

        public a(VideoImageNoPlayerLayout videoImageNoPlayerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoImageNoPlayerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoImageNoPlayerLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m != null) {
                    mp6 mp6Var = this.a.m;
                    VideoImageNoPlayerLayout videoImageNoPlayerLayout = this.a;
                    mp6Var.a(videoImageNoPlayerLayout.c, videoImageNoPlayerLayout.n);
                }
                if (this.a.o != null) {
                    this.a.o.onClick(this.a.c);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoImageNoPlayerLayout a;

        public b(VideoImageNoPlayerLayout videoImageNoPlayerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoImageNoPlayerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoImageNoPlayerLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p.a(this.a.n);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.l = false;
        this.a = context;
        e();
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    public void setData(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, b15Var) == null) {
            this.n = b15Var;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setOnCardSubClickListener(mp6<b15> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mp6Var) == null) {
            this.m = mp6Var;
        }
    }

    public void setVideoAreaClickListener(ez ezVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ezVar) == null) {
            this.p = ezVar;
            if (ezVar != null) {
                h();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.video_image_no_player_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.j = (RelativeLayout) findViewById(R.id.operable_video_container);
            this.k = (RelativeLayout) findViewById(R.id.video_container);
            new WeakReference(TbadkCoreApplication.getInst());
            this.c = (TbImageView) findViewById(R.id.video_thumbnail);
            this.d = findViewById(R.id.video_thumbnail_mask);
            this.e = (ImageView) findViewById(R.id.video_play);
            this.f = (ImageView) findViewById(R.id.video_pause);
            this.g = (TextView) findViewById(R.id.video_play_count);
            this.h = (TextView) findViewById(R.id.video_play_flag);
            this.i = (TextView) findViewById(R.id.video_duration);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X05);
            this.c.setDrawCorner(true);
            this.c.setPlaceHolder(3);
            setOnClickListener(new a(this));
            SkinManager.setBackgroundResource(this, R.color.CAM_X0206);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: f */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().originalThreadData != null) {
            OriginalThreadInfo originalThreadInfo = b15Var.getThreadData().originalThreadData;
            originalThreadInfo.r.is_vertical.intValue();
            String str = originalThreadInfo.f;
            originalThreadInfo.r.video_length.intValue();
            originalThreadInfo.r.video_duration.intValue();
            long j = originalThreadInfo.e;
            this.i.setText(StringHelper.stringForVideoTime(originalThreadInfo.r.video_duration.intValue() * 1000));
            this.g.setText(String.format(this.a.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(originalThreadInfo.r.play_count.intValue())));
            this.h.setVisibility(8);
            this.c.startLoad(originalThreadInfo.r.thumbnail_url, 10, false);
        }
    }

    public void g(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.b != i) {
                EMManager.from(this.d).setMaskBackGround(R.array.Mask_X003);
                EMManager.from(this.d).setCorner(R.string.J_X05);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
                this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            }
            this.b = i;
        }
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public final void h() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (relativeLayout = this.k) != null) {
            relativeLayout.setOnClickListener(new b(this));
        }
    }
}
