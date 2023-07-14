package com.baidu.tbadk.afx;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.OnVideoStartedListener;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lm;
import com.baidu.tieba.mm;
import com.baidu.tieba.qm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class TbAlphaVideo extends FrameLayout implements Animatable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public AlphaVideo b;
    public TbImageView c;
    public boolean d;
    public int e;
    public String f;

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends DefaultDownloadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TbAlphaVideo b;

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadCancel(PackageInfo packageInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, packageInfo) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo, errorInfo) == null) {
            }
        }

        public a(TbAlphaVideo tbAlphaVideo, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbAlphaVideo, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbAlphaVideo;
            this.a = str;
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, packageInfo, errorInfo) == null) {
                super.onDownloadSuccess(packageInfo, errorInfo);
                File file = new File(qm.b(this.a));
                if (!StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(this.a)) && file.exists()) {
                    this.b.setSourceFile(file);
                    this.b.i();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements OnVideoErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OnVideoErrorListener a;
        public final /* synthetic */ TbAlphaVideo b;

        public b(TbAlphaVideo tbAlphaVideo, OnVideoErrorListener onVideoErrorListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbAlphaVideo, onVideoErrorListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbAlphaVideo;
            this.a = onVideoErrorListener;
        }

        @Override // com.baidu.searchbox.afx.callback.OnVideoErrorListener
        public boolean onError(com.baidu.searchbox.afx.callback.ErrorInfo errorInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, errorInfo)) != null) {
                return invokeL.booleanValue;
            }
            this.b.j();
            OnVideoErrorListener onVideoErrorListener = this.a;
            if (onVideoErrorListener != null) {
                return onVideoErrorListener.onError(errorInfo);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbAlphaVideo(@NonNull Context context) {
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
        this.d = true;
        this.e = 3;
        this.f = "";
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbAlphaVideo(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.d = true;
        this.e = 3;
        this.f = "";
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbAlphaVideo(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = true;
        this.e = 3;
        this.f = "";
        c(context);
    }

    public void g(int i) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.e == i) {
            return;
        }
        this.e = i;
        if (i == 0) {
            f = 0.0f;
        } else {
            f = 0.3f;
        }
        setDarkFilter(f);
    }

    public void setAssetsAndPlay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            String str2 = this.f;
            if (str2 != null && str2.equals(str)) {
                return;
            }
            setSourceAssets(str);
            this.f = str;
            i();
        }
    }

    public void setDarkFilter(float f) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048591, this, f) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setDarkFilter(f);
        }
    }

    public void setDefaultImage(@DrawableRes int i) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (tbImageView = this.c) != null) {
            tbImageView.setDefaultResource(i);
        }
    }

    public void setKeepLastFrame(boolean z) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setKeepLastFrame(z);
        }
    }

    public void setLoopSection(int i) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setLoopSection(i);
        }
    }

    public void setLooping(boolean z) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setLooping(z);
        }
    }

    public void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, onVideoEndedListener) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setOnVideoEndedListener(onVideoEndedListener);
        }
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, onVideoErrorListener) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setOnVideoErrorListener(new b(this, onVideoErrorListener));
        }
    }

    public void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, onVideoStartedListener) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setOnVideoStartedListener(onVideoStartedListener);
        }
    }

    public void setShowDefault(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.d = z;
        }
    }

    public void setSourceAssets(String str) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, str) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setSourceAssets(str);
            this.f = str;
        }
    }

    public void setSourceFile(File file) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, file) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setSourceFile(file);
            file.getName();
        }
    }

    public void setSourcePath(String str) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setSourcePath(str);
        }
    }

    public void b() {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.destroy();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlphaVideo alphaVideo = this.b;
            if (alphaVideo != null && alphaVideo.isPaused()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlphaVideo alphaVideo = this.b;
            if (alphaVideo != null && alphaVideo.isPlaying()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AlphaVideo alphaVideo = this.b;
            if (alphaVideo != null && alphaVideo.isStopped()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AlphaVideo alphaVideo = this.b;
            if (alphaVideo != null) {
                return alphaVideo.getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AlphaVideo alphaVideo = this.b;
            if (alphaVideo != null) {
                return alphaVideo.getFps();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void h() {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.pause();
        }
    }

    public void i() {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.play();
        }
    }

    public final void j() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.d && (tbImageView = this.c) != null && tbImageView.getVisibility() == 8) {
            this.c.setVisibility(0);
        }
    }

    public void l() {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.stop();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.b != null) {
            if (e()) {
                l();
            }
            b();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.tb_afx_layout, (ViewGroup) this, true);
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).startAnimatable(this);
            } else if (context instanceof BaseActivity) {
                ((BaseActivity) context).startAnimatable(this);
            }
            this.c = (TbImageView) inflate.findViewById(R.id.default_image);
            setDefaultImage(R.drawable.img_default_100);
            setOnVideoErrorListener(null);
            AlphaVideo alphaVideo = (AlphaVideo) inflate.findViewById(R.id.alpha_video);
            this.b = alphaVideo;
            alphaVideo.setLooping(true);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            File file = new File(qm.b(str));
            if (!StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(str)) && file.exists()) {
                setSourceFile(file);
                i();
                return;
            }
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(mm.a);
            requestParams.setRunNode("aps");
            requestParams.addChannel(new lm("com.baidu.tieba.resloader." + str, new a(this, str)));
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public void setLoopSection(int i, int i2) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setLoopSection(i, i2);
        }
    }

    public void setLoopSection(long j) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048596, this, j) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setLoopSection(j);
        }
    }

    public void setLoopSection(long j, long j2) {
        AlphaVideo alphaVideo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && (alphaVideo = this.b) != null) {
            alphaVideo.setLoopSection(j, j2);
        }
    }
}
