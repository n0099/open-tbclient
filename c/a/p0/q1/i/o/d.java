package c.a.p0.q1.i.o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.p0.c3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class d implements c.a.p0.c3.w.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f17483b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f17484c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f17485d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17486e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17487f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17488g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadData f17489h;
    public BdUniqueId i;
    public String j;
    public String k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public u n;
    public int o;

    public d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17483b = context;
        this.f17484c = viewGroup;
        a();
    }

    public final void a() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (context = this.f17483b) == null || this.f17484c == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08e2, this.f17484c, true);
        if (inflate != null) {
            inflate.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) this.f17484c.findViewById(R.id.obfuscated_res_0x7f092361);
        if (imageView != null) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
            imageView.setOnClickListener(this);
        }
        TextView textView = (TextView) this.f17484c.findViewById(R.id.obfuscated_res_0x7f092323);
        this.f17487f = textView;
        if (textView != null) {
            c.a.o0.r.v.c.d(textView).y(R.array.S_O_X001);
        }
        TextView textView2 = (TextView) this.f17484c.findViewById(R.id.obfuscated_res_0x7f092363);
        this.f17486e = textView2;
        if (textView2 != null) {
            c.a.o0.r.v.c.d(textView2).y(R.array.S_O_X001);
        }
        TbImageView tbImageView = (TbImageView) this.f17484c.findViewById(R.id.obfuscated_res_0x7f092392);
        this.f17485d = tbImageView;
        if (tbImageView != null) {
            tbImageView.s();
            this.f17485d.setDrawCorner(false);
            this.f17485d.setPlaceHolder(3);
        }
    }

    public final void b() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17488g || (viewGroup = this.f17484c) == null || this.f17483b == null || this.f17489h == null) {
            return;
        }
        viewGroup.removeAllViews();
        c cVar = new c(this.f17483b, this.f17484c);
        this.a = cVar;
        cVar.setUniqueId(this.i);
        this.a.setFrom(this.j);
        this.a.setStageType(this.k);
        this.a.setData(this.f17489h);
        if (this.f17489h.getThreadVideoInfo() != null && this.f17489h.getThreadVideoInfo().is_vertical.intValue() == 1 && UbsABTestHelper.showNewUI()) {
            this.a.changeRenderViewMode(this.o);
        }
        this.a.setJumpToPbClickListener(this.l);
        this.a.setAfterClickListener(this.m);
        this.a.setStatistic(this.n);
        this.f17488g = true;
    }

    @Override // c.a.p0.c3.w.a
    public void changeRenderViewMode(int i) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.o = i;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.changeRenderViewMode(i);
        }
    }

    @Override // c.a.p0.c3.w.a
    public int getCurrentPosition() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return 0;
            }
            return cVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.c3.w.a
    public View getMainView() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return null;
            }
            return cVar.getMainView();
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.p0.c3.w.a
    public boolean isFullScreen() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public boolean onBackPress() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.onBackPress();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.onBackground(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            b();
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.onClick(view);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f17488g && (cVar = this.a) != null) {
            cVar.onCompletion();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i, i2, obj)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, obj)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.onInfo(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f17488g && (cVar = this.a) != null) {
            cVar.onPrepared();
        }
    }

    @Override // c.a.p0.c3.w.a
    public void onScroll() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.f17488g && (cVar = this.a) != null) {
            cVar.onScroll();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f17488g && (cVar = this.a) != null) {
            cVar.onSeekComplete();
        }
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f17488g && (cVar = this.a) != null) {
            cVar.onSurfaceDestroyed();
        }
    }

    @Override // c.a.p0.c3.w.a
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!this.f17488g || (cVar = this.a) == null) {
                return false;
            }
            return cVar.onVolumeUp();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.c3.w.a
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.m = onClickListener;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.setAfterClickListener(onClickListener);
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setData(ThreadData threadData) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null) {
            return;
        }
        this.f17489h = threadData;
        if (this.f17488g && (cVar = this.a) != null) {
            cVar.setData(threadData);
            return;
        }
        int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
        TextView textView = this.f17487f;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(intValue));
        }
        TextView textView2 = this.f17486e;
        if (textView2 != null) {
            textView2.setText(String.format(this.f17483b.getResources().getString(R.string.obfuscated_res_0x7f0f0e4b), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
        }
        if (this.f17485d != null) {
            if (TbadkCoreApplication.getInst().getVideoAutoPlay() != 2 && TbadkCoreApplication.getInst().getVideoAutoPlay() != 0) {
                this.f17485d.J(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            } else if (!m.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.f17485d.J(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.f17485d.J(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setFrom(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.j = str;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.setFrom(str);
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.l = onClickListener;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.setJumpToPbClickListener(onClickListener);
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setStageType(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.k = str;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.setStageType(str);
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setStatistic(u uVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, uVar) == null) {
            this.n = uVar;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.setStatistic(uVar);
        }
    }

    @Override // c.a.p0.c3.w.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.setUniqueId(bdUniqueId);
        }
    }

    @Override // c.a.p0.c3.w.a
    public void startPlay() {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            b();
            if (!this.f17488g || (cVar = this.a) == null) {
                return;
            }
            cVar.startPlay();
        }
    }

    @Override // c.a.p0.c3.w.a
    public void stopPlay() {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && this.f17488g && (cVar = this.a) != null) {
            cVar.stopPlay();
        }
    }
}
