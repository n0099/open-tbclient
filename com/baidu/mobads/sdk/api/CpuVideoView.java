package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CpuVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CpuVideoView";
    public transient /* synthetic */ FieldHolder $fh;
    public CpuVideoStatusListener mCpuVideoStatusListener;
    public FeedPortraitVideoView mVideoView;

    /* loaded from: classes3.dex */
    public interface CpuVideoStatusListener {
        void playCompletion();

        void playError();

        void playPause();

        void playRenderingStart();

        void playResume();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CpuVideoView(Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CpuVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuVideoView(Context context, AttributeSet attributeSet, int i) {
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
        initVideoView();
    }

    public void setCpuVideoStatusListener(CpuVideoStatusListener cpuVideoStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cpuVideoStatusListener) == null) {
            this.mCpuVideoStatusListener = cpuVideoStatusListener;
        }
    }

    public void setVideoConfig(IBasicCPUData iBasicCPUData) {
        FeedPortraitVideoView feedPortraitVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, iBasicCPUData) == null) && (feedPortraitVideoView = this.mVideoView) != null) {
            feedPortraitVideoView.setAdData(iBasicCPUData);
        }
    }

    private void initVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(getContext());
            this.mVideoView = feedPortraitVideoView;
            feedPortraitVideoView.systemSetVideoMute(true);
            this.mVideoView.setProgressBarColor(-1);
            this.mVideoView.setProgressHeightInDp(1);
            this.mVideoView.setProgressBackgroundColor(-16777216);
            this.mVideoView.setFeedPortraitListener(new IFeedPortraitListener(this) { // from class: com.baidu.mobads.sdk.api.CpuVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CpuVideoView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void pauseBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        av.h(CpuVideoView.TAG).d("pauseBtnClick: ");
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playCompletion() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        av.h(CpuVideoView.TAG).d("playCompletion: ");
                        if (this.this$0.mCpuVideoStatusListener != null) {
                            this.this$0.mCpuVideoStatusListener.playCompletion();
                        }
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playError() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        av.h(CpuVideoView.TAG).d("playError: ");
                        if (this.this$0.mCpuVideoStatusListener != null) {
                            this.this$0.mCpuVideoStatusListener.playError();
                        }
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playPause() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        av.h(CpuVideoView.TAG).d("playPause: ");
                        if (this.this$0.mCpuVideoStatusListener != null) {
                            this.this$0.mCpuVideoStatusListener.playPause();
                        }
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playRenderingStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        av.h(CpuVideoView.TAG).d("playRenderingStart: ");
                        if (this.this$0.mCpuVideoStatusListener != null) {
                            this.this$0.mCpuVideoStatusListener.playRenderingStart();
                        }
                    }
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public void playResume() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                        av.h(CpuVideoView.TAG).d("playResume: ");
                        if (this.this$0.mCpuVideoStatusListener != null) {
                            this.this$0.mCpuVideoStatusListener.playResume();
                        }
                    }
                }
            });
            addView(this.mVideoView, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
        }
    }
}
