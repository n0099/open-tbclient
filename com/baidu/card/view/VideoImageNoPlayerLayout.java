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
import com.repackage.fr4;
import com.repackage.fx;
import com.repackage.mx5;
import com.repackage.ny;
import com.repackage.ym4;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class VideoImageNoPlayerLayout extends RelativeLayout implements fx<ym4> {
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
    public mx5<ym4> m;
    public ym4 n;
    public View.OnClickListener o;
    public ny p;

    /* loaded from: classes.dex */
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
                    mx5 mx5Var = this.a.m;
                    VideoImageNoPlayerLayout videoImageNoPlayerLayout = this.a;
                    mx5Var.a(videoImageNoPlayerLayout.c, videoImageNoPlayerLayout.n);
                }
                if (this.a.o != null) {
                    this.a.o.onClick(this.a.c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
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
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d085f, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.j = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0915c5);
            this.k = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0922e3);
            new WeakReference(TbadkCoreApplication.getInst());
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092353);
            this.d = findViewById(R.id.obfuscated_res_0x7f092354);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f092322);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f092317);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f092324);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f092326);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0922eb);
            this.c.setConrers(15);
            this.c.setRadiusById(R.string.J_X05);
            this.c.setDrawCorner(true);
            this.c.setPlaceHolder(3);
            setOnClickListener(new a(this));
            SkinManager.setBackgroundResource(this, R.color.CAM_X0206);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fx
    /* renamed from: g */
    public void a(ym4 ym4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ym4Var) == null) || ym4Var == null || ym4Var.getThreadData() == null || ym4Var.getThreadData().originalThreadData == null) {
            return;
        }
        OriginalThreadInfo originalThreadInfo = ym4Var.getThreadData().originalThreadData;
        originalThreadInfo.r.is_vertical.intValue();
        String str = originalThreadInfo.f;
        originalThreadInfo.r.video_length.intValue();
        originalThreadInfo.r.video_duration.intValue();
        long j = originalThreadInfo.e;
        this.i.setText(StringHelper.stringForVideoTime(originalThreadInfo.r.video_duration.intValue() * 1000));
        this.g.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e79), StringHelper.numFormatOverWan(originalThreadInfo.r.play_count.intValue())));
        this.h.setVisibility(8);
        this.c.J(originalThreadInfo.r.thumbnail_url, 10, false);
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
            if (this.b != i) {
                fr4.d(this.d).s(R.array.Mask_X003);
                fr4.d(this.d).n(R.string.J_X05);
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0206);
                SkinManager.setBackgroundColor(this, R.color.CAM_X0206);
                this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
                this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809f6, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            }
            this.b = i;
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

    public void setData(ym4 ym4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ym4Var) == null) {
            this.n = ym4Var;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setOnCardSubClickListener(mx5<ym4> mx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mx5Var) == null) {
            this.m = mx5Var;
        }
    }

    public void setVideoAreaClickListener(ny nyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nyVar) == null) {
            this.p = nyVar;
            if (nyVar != null) {
                i();
            }
        }
    }
}
