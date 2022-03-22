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
import c.a.o0.r.v.c;
import c.a.p0.h0.b0;
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
/* loaded from: classes3.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements p<c.a.o0.r.r.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f25207b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f25208c;

    /* renamed from: d  reason: collision with root package name */
    public View f25209d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f25210e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f25211f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f25212g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25213h;
    public TextView i;
    public RelativeLayout j;
    public RelativeLayout k;
    public boolean l;
    public b0<c.a.o0.r.r.a> m;
    public c.a.o0.r.r.a n;
    public View.OnClickListener o;
    public c.a.l.x0.a p;

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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.m != null) {
                    b0 b0Var = this.a.m;
                    VideoImageNoPlayerLayout videoImageNoPlayerLayout = this.a;
                    b0Var.a(videoImageNoPlayerLayout.f25208c, videoImageNoPlayerLayout.n);
                }
                if (this.a.o != null) {
                    this.a.o.onClick(this.a.f25208c);
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
        this.f25207b = 3;
        this.l = false;
        this.a = context;
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d087f, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09160b);
            this.k = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09231b);
            new WeakReference(TbadkCoreApplication.getInst());
            this.f25208c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092392);
            this.f25209d = findViewById(R.id.obfuscated_res_0x7f092393);
            this.f25210e = (ImageView) findViewById(R.id.obfuscated_res_0x7f092361);
            this.f25211f = (ImageView) findViewById(R.id.obfuscated_res_0x7f092356);
            this.f25212g = (TextView) findViewById(R.id.obfuscated_res_0x7f092363);
            this.f25213h = (TextView) findViewById(R.id.obfuscated_res_0x7f092365);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092323);
            this.f25208c.setConrers(15);
            this.f25208c.setRadiusById(R.string.J_X05);
            this.f25208c.setDrawCorner(true);
            this.f25208c.setPlaceHolder(3);
            setOnClickListener(new a(this));
            SkinManager.setBackgroundResource(this, R.color.CAM_X0206);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: g */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().originalThreadData == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = aVar.getThreadData().originalThreadData;
        originalThreadInfo.r.is_vertical.intValue();
        String str = originalThreadInfo.f29826f;
        originalThreadInfo.r.video_length.intValue();
        originalThreadInfo.r.video_duration.intValue();
        long j = originalThreadInfo.f29825e;
        this.i.setText(StringHelper.stringForVideoTime(originalThreadInfo.r.video_duration.intValue() * 1000));
        this.f25212g.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e4b), StringHelper.numFormatOverWan(originalThreadInfo.r.play_count.intValue())));
        this.f25213h.setVisibility(8);
        this.f25208c.J(originalThreadInfo.r.thumbnail_url, 10, false);
    }

    @Override // android.view.View
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void h(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.f25207b != i) {
                c.d(this.f25209d).s(R.array.Mask_X003);
                c.d(this.f25209d).n(R.string.J_X05);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
                this.f25210e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                this.f25211f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809dd, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            }
            this.f25207b = i;
        }
    }

    public final void i() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (relativeLayout = this.k) == null) {
            return;
        }
        relativeLayout.setOnClickListener(new b(this));
    }

    public void setCanCenterStart(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    public void setData(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setOnCardSubClickListener(b0<c.a.o0.r.r.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, b0Var) == null) {
            this.m = b0Var;
        }
    }

    public void setVideoAreaClickListener(c.a.l.x0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.p = aVar;
            if (aVar != null) {
                i();
            }
        }
    }
}
