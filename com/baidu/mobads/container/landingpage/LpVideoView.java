package com.baidu.mobads.container.landingpage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.mobads.container.video.ICustomVideoView;
import com.baidu.mobads.container.video.LPVideoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LpVideoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLAY_BIG = "iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAC3FBMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAODg7Dw8P4+Pj39/fExMQkJCT////19fWVlZX5+fnf399MTEz8/Py2trYREREAAADv7+93d3cAAAD////Q0NAxMTGenp4CAgLj4+NZWVkAAAD9/f28vLwYGBjx8fGDg4PV1dU6Ojr6+vqnp6cHBwfo6OhkZGT+/v7ExMQgICD09PSOjo7c3NxFRUX7+/uwsLDs7Oxvb2/Ly8srKyv39/eYmJgAAADg4OBRUVH9/f24uLgVFRXw8PB7e3vR0dE1NTWioqIFBQXm5uZcXFz9/f3AwMAcHBzy8vKFhYXZ2dk+Pj76+vqrq6sKCgrq6upnZ2fHx8f09PSRkZHe3t5JSUlubm7n5+f7+/vm5ub5+flpaWnb29tDQ0Pz8/ONjY3+/v4eHh7n5+diYmL5+fmnp6fV1dU4ODjx8fGCgoLj4+NYWFj4+PidnZ0AAADOzs4vLy/t7e21tbXf39+UlJTJycnr6+tra2v7+/usrKzZ2dlBQUHz8/OIiIjCwsJfX1+kpKTU1NQ2NjYAAADw8PB9fX26urrj4+NSUlIAAAD39/ebm5vOzs4tLS3t7e1ycnK0tLTd3d309PTAwMD29vbCwsKskq0kAAAA9HRSTlMAChUgJy84P0RJS1JOQjoyKyMYCwEOITNFVGJmZFgoBAgfNk9lVkAQHjtfRioMLEpjNxcJTVoCSA01XBwpA10wBVBeGS1MFDlZYEEGG1siQwc9VxZhGkcSPCQmEzEPEWq89fS9cP/xnfXXfPqyai7ojlH+x3OjZ9yBU/y4bOyUzXb3qWjghf6+bu+Z03r6ruWKxHHynjTZfvuza+mPyXSlZ92C/btt7ZXQd/iqaOOGwPGb1nuJ3/ne9ojSee+Y/W7ghfeozHbrk9uA9KIlx3PostadweOI+KzRee6WvIOmy3VV65G22n8+86DGcuaLsNXwufK7DkqAWQAAB8RJREFUeNrt3QdbU1cYB/AbImEFEEgo5g07oZSABJAhSIAISEQQATEOQGuPtbW1hU7stMNOu6yttcvW2mmHtXbvPezeu3TZPb9Aq/LgBULGvec99xwf/l/gPL8nufes954jSROZyEQ0iS5MPyncEBEZFR0dE2OMjo6MjYufnJCYZBJGYDInH5IyxQLjxJoaHZcWls45IiMzK3tcgjw2e07aoZwi0nMPs0NIyXPkF3D3REwtdIKSTCkq5kdRkj/NBspTagjjQVGmL1ej2B97eInGjIrplUAl1sgqDRmJKTagF/uMam0YuUagHFdNLXtGVR0gxB3OuKucaQSkuOrL2DHMDkBMqp4Ro3a6E3DT0MjCoa8E9FhnoT8quhRgkibkbmWSB1hldjPiKD0FGKZ0JpZjTiUwjS0L5U1clmUD1qlDmK+UNIAGcc+h7QhrAU1iq6HraHWCVplLc0xcAxrG2EbtMZ8HmqbdTGl5pBw0jovK2Kt5GmgeTwcFRx1wkM75qh0xwEUsKjuU9GzgJJZENY7qBuAmHhXLeKYu4CjuBYohXuAqLUki9uc+B8PKJsALgbt0KdnvanTyB4FZCqa1pcBjFoX8wirk0gGWxSFCsoDTtIe2uFIF3GZ2SBN0F78QSAgB0sWxAzzBL62kAdeZFmxvosvjGwJTg4SkcO4AS0Vw+wbAfcqD2sdp4R8CySJ3hfI0BV61q3CKAIEl4j/pQ8sqgSZZM0GQRASAZIsCsXb7dWSCMIn1C4kRB2Lr8VcnAwIl0g/EKBLENv5uQyIIlbhxIZFiQSwZ4zgKrGJBIF7kUZY8Lb4LCsqoFDb0Ll12+PIjGEn0iPOQ5eT/rDiSDSTKJ4TOnudKsi9HHc3kDexr6KijU2pChrLqmGMZSFb7gEwGqhBCjjseH9KH16sfgJD+E05El4zt3ZNs1CGELDvpZGTI2JqbqYAAIeSUU3EhA2MghTgQsua001ElutEb6k4kCCFnnIkJScOaiRAfOetsdrMSLyaErD3nXCyIZ9R4y44KIeS887EkI7/RygBkCFl3wYUsOnc9OoSQiy5GgThGQIoYQAi55FIEiBtpXc4fhKy/rJe+RL5SZ7KwgRBy+RXUIfLN0W5gBSH9V15FGTJdXp/MDkLIhqvpjiS7ZJCNLCGEXHMtTUgpzqZIMBCy6brNFCWyoo4BxhBCrr+BXpOyOhsPcwghN95Ef1GoDTSAkJU3b6E9SGnUBELILbdSaTIOpUQgFAjZets2qqOtNK0ghNx+h/omjcOQcO0ghNx5l9om7cMQg5YQcvc922mNfyM0hRBy732qmrQNQxwaQ8i6+1VtRDTTXYdXASHkgR0q2sygvTinAkLIgzsVt1mAsSutGELWPnSQQMgupW0Of1jSxwfkYdUQTn6RR1RDGriAPPqY0jbNHL1+CXn8CfVvLQ4gTz6los3hr5JjtYY8vfwZNW0Ol5zGaQx59jlVTXYOj7XiNYU8/4LKzZNU2lvsyiAvvqS2yT6MhcZQIS+/or7JQpRi35AYa06jsVCXc6DiTCPIq69RafJA/ZnJqgXk9TcoLWbvPrDSmMoe0v/mW7SaTKRf9hA85G2KpUOyoq04xpBV71DcgvPgfOYWjONdquV1RhmkgyVkxXtANV55SY2NGWTd+7RLUPPl29PtrCAffAi0M6KGI4cN5KOPt1N3OKtxPmr15/jkU6Cf7BGVDz0MIJ99DhgpGlnmlIcN2frFNhTH6LJyBzJk15c4DLCNOkZsBipk5VdbkBxQN/rbEUzI198AWsZ8QzKIBvn2O0DMmCPEDEiQTd9vxnS4xpw2UIwD+eFHQM2esUX+pQiQn37Gro33cRCagTqk/5dfkRk+/lmSFEYb8tvvgB6vr0+T2qlC1v/Ri++ARLxzwYa+sfpzJwMGDPo+Z4fKotDSvYy/dgCT1COektD794Z//mX0HaIzQ7gjnHxn3G/zBwWDjHty4yKxHA3jH+xbKRREL9DJjKG/e4fOknULBFko1GGZfn4Qv8eFpbuEgbT6P6mmXhTHQKATfpsEgQS81iNZDEdX4IPCGkRwBDgCaV8W2ASAGII5hG4W/46WoA40reX/eW8V/kTW/XEEewTobL4debpgIW0tB8Mfi/s/V4QUQgz8OlJrQ7o7pY9XhzXEGzwKeJ2ZTA71mPIqPjv4nIPgQoK9iVFyKcFc/hzuCgUOKb2ON4dF4VU9Gal8OWyZSu8fMbvFfmHJNn88HDk2qrmkZ76FG4dBUpUqXiTz1F5kxYnEa1IL4ePfZZAopCNP7Odctq6i8S03tnpaFyImTdHS4WyVqKU2SjuHq5jmnaEmzaaMAxUS3bR2ajP/oH+bdk87e4Y1X0JIM/PlrtQOCScJbMeQe2olrBQwvAjVnSwhxpTP6keJLZFwk8TkjqvSXAk/yegjFquhVmKR9CW4fYrDLLGKLgLv0P+BKollumNxViIHWyXW6YmkT7EvNEkaxOylO3lsyNWEsW9rawm1N5gztlHSMqZcB43nfrC+TdI8utUqd4Vc3mKJk5hrFF+35N4zxyTxlKS0lJCHYbbs+DC+FEMbj8WrHUEvezuzizLbJI7TnZBVHqAGxGP05hdXSyKkebG+Ps5htLvlfWZnU19URPzuxCRJxLTpzOYFjWZzQVuZNJGJiJj/AAGsTFoLt207AAAAAElFTkSuQmCC";
    public static final int PLAY_ICON_HEGIHT = 45;
    public static final int PLAY_ICON_WIDHT = 45;
    public transient /* synthetic */ FieldHolder $fh;
    public IXAdInstanceInfo mAdInstanceInfo;
    public BackgroundLayout mVideoBackgroundImageView;
    public PlayIconLayout mVideoEndImageView;
    public LPVideoLayout mVideoLayout;
    public OnVideoListener mVideoListener;
    public ICustomVideoView.VideoPlayCallbackImpl mVideoPlayCallback;
    public Context mViewContext;
    public int screenWidth;
    public int videoHeight;

    /* loaded from: classes2.dex */
    public class BackgroundLayout extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView mBigImageView;
        public final /* synthetic */ LpVideoView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BackgroundLayout(LpVideoView lpVideoView, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lpVideoView, context};
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
            this.this$0 = lpVideoView;
            ImageView imageView = new ImageView(context);
            this.mBigImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(this.mBigImageView, new RelativeLayout.LayoutParams(-1, -1));
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* loaded from: classes2.dex */
    public class DownloadFilesTask extends AsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LpVideoView this$0;

        public DownloadFilesTask(LpVideoView lpVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lpVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = lpVideoView;
        }

        private Bitmap loadImageFromFile(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
                try {
                    String storagePath = SdcardUtils.getStoragePath(XAdRemoteCommonUtils.getApplicationContext());
                    String md5 = EncryptUtils.getMD5(str);
                    return BitmapFactory.decodeFile(storagePath + md5 + XAdSimpleImageLoader.TEMP_SUFFIX);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    Thread.sleep(3000L);
                    String str = strArr[0];
                    Bitmap loadImageFromFile = loadImageFromFile(str);
                    if (loadImageFromFile == null) {
                        loadImageFromFile = CommonUtils.getBitmapFromURL(str);
                    }
                    return CommonUtils.getResizedBitmap(loadImageFromFile, this.this$0.screenWidth, this.this$0.videoHeight);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) || bitmap == null) {
                return;
            }
            BackgroundLayout backgroundLayout = this.this$0.mVideoBackgroundImageView;
            if (backgroundLayout != null) {
                backgroundLayout.mBigImageView.setImageBitmap(bitmap);
            }
            LpVideoView lpVideoView = this.this$0;
            LpVideoView lpVideoView2 = this.this$0;
            lpVideoView.mVideoEndImageView = new PlayIconLayout(lpVideoView2, lpVideoView2.mViewContext, bitmap);
            this.this$0.mVideoEndImageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.LpVideoView.DownloadFilesTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadFilesTask this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        ((ViewGroup) this.this$1.this$0.mVideoEndImageView.getParent()).removeView(this.this$1.this$0.mVideoEndImageView);
                        this.this$1.this$0.mVideoLayout.play();
                        this.this$1.this$0.sendMonitorLogForVideoStart();
                    }
                }
            });
        }
    }

    /* loaded from: classes2.dex */
    public interface OnVideoListener {
        void onReturnButtonClicked();
    }

    /* loaded from: classes2.dex */
    public class PlayIconLayout extends RelativeLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView mBigImageView;
        public ImageView mSmallImageView;
        public final /* synthetic */ LpVideoView this$0;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PlayIconLayout(LpVideoView lpVideoView, Context context, Bitmap bitmap) {
            this(lpVideoView, context, bitmap, false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lpVideoView, context, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((LpVideoView) objArr2[0], (Context) objArr2[1], (Bitmap) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void createImage(Context context, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, bitmap) == null) {
                ImageView imageView = new ImageView(context);
                this.mBigImageView = imageView;
                imageView.setImageBitmap(bitmap);
                this.mBigImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                addView(this.mBigImageView, new RelativeLayout.LayoutParams(-1, -1));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlayIconLayout(LpVideoView lpVideoView, Context context, Bitmap bitmap, boolean z) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lpVideoView, context, bitmap, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = lpVideoView;
            createImage(context, bitmap);
            if (z) {
                return;
            }
            ImageView imageView = new ImageView(context);
            this.mSmallImageView = imageView;
            imageView.setImageBitmap(ConvertUtils.string2bitmap(LpVideoView.PLAY_BIG));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(context, 45), ScreenUtils.getPixel(context, 45));
            layoutParams.addRule(13);
            addView(this.mSmallImageView, layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LpVideoView(Context context, IXAdInstanceInfo iXAdInstanceInfo) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iXAdInstanceInfo};
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
        this.screenWidth = 0;
        this.videoHeight = 0;
        this.mVideoEndImageView = null;
        this.mVideoBackgroundImageView = null;
        this.mVideoPlayCallback = new ICustomVideoView.VideoPlayCallbackImpl(this) { // from class: com.baidu.mobads.container.landingpage.LpVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LpVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onClickAd() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onCloseVideo(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4) == null) {
                    this.this$0.sendMonitorLogForVideoClose(i4);
                }
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onCompletion(MediaPlayer mediaPlayer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer) == null) {
                    PlayIconLayout playIconLayout = this.this$0.mVideoEndImageView;
                    if (playIconLayout != null && playIconLayout.getParent() == null) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        LpVideoView lpVideoView = this.this$0;
                        lpVideoView.mVideoLayout.addView(lpVideoView.mVideoEndImageView, layoutParams);
                    }
                    this.this$0.sendMonitorLogForVideoClose(mediaPlayer != null ? mediaPlayer.getDuration() : 0);
                }
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onError(MediaPlayer mediaPlayer, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(1048579, this, mediaPlayer, i4, i5) == null) {
                }
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onFullScreen(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                }
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onReturnButtonClicked() {
                OnVideoListener onVideoListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || (onVideoListener = this.this$0.mVideoListener) == null) {
                    return;
                }
                onVideoListener.onReturnButtonClicked();
            }

            @Override // com.baidu.mobads.container.video.ICustomVideoView.VideoPlayCallbackImpl
            public void onStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }
        };
        setBackgroundColor(-1);
        this.mViewContext = context;
        this.mAdInstanceInfo = iXAdInstanceInfo;
        initLayout();
    }

    private String getOutputFolderPath(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) {
            return context.getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
        }
        return (String) invokeL.objValue;
    }

    private String getVideoPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String videoUrl = this.mAdInstanceInfo.getVideoUrl();
            String str = getOutputFolderPath(getContext()) + EncryptUtils.getMD5(videoUrl);
            return new File(str).exists() ? str : videoUrl;
        }
        return (String) invokeV.objValue;
    }

    private void initLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int screenWidth = CommonUtils.getScreenWidth(this.mViewContext);
            this.screenWidth = screenWidth;
            this.videoHeight = (screenWidth * this.mAdInstanceInfo.getVideoHeight()) / this.mAdInstanceInfo.getVideoWidth();
            setLayoutParams(new RelativeLayout.LayoutParams(this.screenWidth, this.videoHeight));
            LPVideoLayout lPVideoLayout = new LPVideoLayout(this.mViewContext);
            this.mVideoLayout = lPVideoLayout;
            lPVideoLayout.setVideoPlayCallback(this.mVideoPlayCallback);
            this.mVideoLayout.setActivity((Activity) this.mViewContext);
            addView(this.mVideoLayout, new RelativeLayout.LayoutParams(-1, -1));
            new DownloadFilesTask().execute(this.mAdInstanceInfo.getMainPictureUrl());
        }
    }

    private List<String> replaceProgressOfVideoMonitorUrl(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    arrayList.add(list.get(i2).replaceAll(XAdSDKRemoteConfig.REGULAR_MATCH_PROGRESS, str));
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().e(e2);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public boolean closeFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LPVideoLayout lPVideoLayout = this.mVideoLayout;
            if (lPVideoLayout != null) {
                return lPVideoLayout.closeFullScreen();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        LPVideoLayout lPVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lPVideoLayout = this.mVideoLayout) == null) {
            return;
        }
        lPVideoLayout.pause();
    }

    public void resume() {
        LPVideoLayout lPVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lPVideoLayout = this.mVideoLayout) == null) {
            return;
        }
        lPVideoLayout.resume();
    }

    public void sendMonitorLogForVideoClose(int i2) {
        IXAdInstanceInfo iXAdInstanceInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (iXAdInstanceInfo = this.mAdInstanceInfo) == null) {
            return;
        }
        XAdRemoteCommonUtils.makeRequest(replaceProgressOfVideoMonitorUrl(iXAdInstanceInfo.getCloseTrackers(), String.valueOf(i2)), 1);
    }

    public void sendMonitorLogForVideoStart() {
        IXAdInstanceInfo iXAdInstanceInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iXAdInstanceInfo = this.mAdInstanceInfo) == null) {
            return;
        }
        XAdRemoteCommonUtils.makeRequest(replaceProgressOfVideoMonitorUrl(iXAdInstanceInfo.getStartTrackers(), "0"), 1);
    }

    public void setVideoListener(OnVideoListener onVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onVideoListener) == null) {
            this.mVideoListener = onVideoListener;
        }
    }

    public void start() {
        LPVideoLayout lPVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lPVideoLayout = this.mVideoLayout) == null) {
            return;
        }
        lPVideoLayout.setVideoURI(getVideoPlayUrl());
    }

    public void stopAndRelease() {
        LPVideoLayout lPVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (lPVideoLayout = this.mVideoLayout) == null) {
            return;
        }
        lPVideoLayout.stopAndRelease();
    }
}
