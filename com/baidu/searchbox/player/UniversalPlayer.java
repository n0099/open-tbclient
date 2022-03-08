package com.baidu.searchbox.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.helper.ITimerTask;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.ProgressHelper;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.interfaces.INeuronSetupHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher;
import com.baidu.searchbox.player.stat.UniversalStatDispatcherImp;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes4.dex */
public class UniversalPlayer extends BDVideoPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "UniversalPlayer";
    public static boolean sIsOrientationLock;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<Class<? extends IPlayerContext>, IPlayerContext> mContextMap;
    public String mCurrentMode;
    public boolean mIsEnableOrientation;
    public OrientationHelper mOrientationHelper;
    public ITimerTask mProgressHelper;
    public IPlayerStyleSwitchHelper mStyleSwitchHelper;
    @Deprecated
    public VideoSession mVideoSession;

    /* loaded from: classes4.dex */
    public class OrientationChangeCallBack implements OrientationHelper.IOrientationChange {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DELAY_TIME = 1000;
        public transient /* synthetic */ FieldHolder $fh;
        public long mChangedTime;
        public boolean mIsLandscape;
        public boolean mIsPortrait;
        public final /* synthetic */ UniversalPlayer this$0;

        public OrientationChangeCallBack(UniversalPlayer universalPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {universalPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = universalPlayer;
            this.mChangedTime = 0L;
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || UniversalPlayer.isOrientationLock()) {
                return;
            }
            UniversalPlayer universalPlayer = this.this$0;
            if (universalPlayer.mPlayerContainer == null || !universalPlayer.canChangeOrientation() || this.this$0.isFloatingMode() || OrientationHelper.isSystemOrientationLocked(BDPlayerConfig.getAppContext())) {
                return;
            }
            if (!this.this$0.isFullMode()) {
                this.mIsLandscape = false;
                if (OrientationHelper.isPortrait(i2)) {
                    this.mIsPortrait = true;
                }
                if (this.mIsPortrait && OrientationHelper.isLandscape(i2) && this.this$0.mPlayerContainer.getVisibility() == 0 && System.currentTimeMillis() - this.mChangedTime > 1000) {
                    this.mChangedTime = System.currentTimeMillis();
                    this.this$0.switchToFull(0);
                    this.mIsPortrait = false;
                    return;
                }
                return;
            }
            this.mIsPortrait = false;
            if (OrientationHelper.isReverseLandscape(i2)) {
                this.mIsLandscape = true;
                BdActivityUtils.requestLandscape(this.this$0.getActivity(), true);
            } else if (OrientationHelper.isLandscape(i2)) {
                this.mIsLandscape = true;
                BdActivityUtils.requestLandscape(this.this$0.getActivity(), false);
            } else if (OrientationHelper.isPortrait(i2) && this.mIsLandscape && System.currentTimeMillis() - this.mChangedTime > 1000) {
                this.mChangedTime = System.currentTimeMillis();
                this.this$0.switchToHalf(0);
                this.mIsLandscape = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-941729277, "Lcom/baidu/searchbox/player/UniversalPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-941729277, "Lcom/baidu/searchbox/player/UniversalPlayer;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalPlayer(@Nullable Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    @PublicMethod
    public static boolean isOrientationLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? sIsOrientationLock : invokeV.booleanValue;
    }

    private void setupInternalNeuron(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, context) == null) || getNeuronSetupHelper() == null) {
            return;
        }
        getNeuronSetupHelper().setupInternalNeuron(context);
    }

    public boolean canChangeOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @PublicMethod
    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (orientationHelper = this.mOrientationHelper) == null) {
            return;
        }
        this.mIsEnableOrientation = false;
        orientationHelper.disable();
    }

    @PublicMethod
    public void enableOrientationEventHelper() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mOrientationHelper.canDetectOrientation()) {
            this.mIsEnableOrientation = this.mOrientationHelper.enableSensor();
        }
    }

    @IntRange(from = -1)
    @PublicMethod
    public int findLayerIndex(@NonNull ILayer iLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iLayer)) == null) ? this.mLayerContainer.indexOfChild(iLayer.getContentView()) : invokeL.intValue;
    }

    @PublicMethod
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCurrentMode : (String) invokeV.objValue;
    }

    @Nullable
    public INeuronSetupHelper getNeuronSetupHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (INeuronSetupHelper) invokeV.objValue;
    }

    @PublicMethod
    public OrientationHelper getOrientationHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mOrientationHelper : (OrientationHelper) invokeV.objValue;
    }

    @Nullable
    @PublicMethod
    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            T t = (T) this.mContextMap.get(cls);
            if (t != null) {
                return t;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    @PublicMethod
    public IPlayerStyleSwitchHelper getStyleSwitchHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mStyleSwitchHelper : (IPlayerStyleSwitchHelper) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public VideoSession getVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mVideoSession : (VideoSession) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void goBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.goBackOrForeground(z);
            if (z) {
                enableOrientationEventHelper();
            } else {
                disableOrientationEventHelper();
            }
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void initCallBackManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.mCallbackManager = new UniversalPlayerCallbackManager();
        }
    }

    public void initHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mProgressHelper = new ProgressHelper(this);
            OrientationHelper orientationHelper = new OrientationHelper(BDPlayerConfig.getAppContext(), 3);
            this.mOrientationHelper = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.mIsEnableOrientation = true;
                this.mOrientationHelper.disable();
                this.mOrientationHelper.setListener(new OrientationChangeCallBack(this));
            }
            this.mStyleSwitchHelper = new SimpleStyleSwitchHelper(this);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void initPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            initHelper();
        }
    }

    public boolean isEnablePlayerConfigNotch(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            return true;
        }
        return invokeZ.booleanValue;
    }

    @PublicMethod
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? TextUtils.equals(this.mCurrentMode, PlayerConstant.FLOATING_MODE) : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isFullMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? TextUtils.equals(this.mCurrentMode, PlayerConstant.FULL_MODE) : invokeV.booleanValue;
    }

    @PublicMethod
    public boolean isReverseLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            OrientationHelper orientationHelper = this.mOrientationHelper;
            if (orientationHelper == null || !this.mIsEnableOrientation) {
                return false;
            }
            return OrientationHelper.isReverseLandscape(orientationHelper.getLastOrientation());
        }
        return invokeV.booleanValue;
    }

    @PublicMethod
    public boolean onKeyBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (isFullMode()) {
                BdVideoLog.d(TAG, "switch to half");
                switchToHalf(3);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @PublicMethod
    public void registerContext(Class<? extends IPlayerContext> cls, @NonNull IPlayerContext iPlayerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, cls, iPlayerContext) == null) {
            iPlayerContext.setPlayer(this);
            this.mContextMap.put(cls, iPlayerContext);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.release();
            this.mContextMap.clear();
        }
    }

    @PublicMethod
    public void setIsFullMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                this.mCurrentMode = PlayerConstant.FULL_MODE;
            } else {
                this.mCurrentMode = PlayerConstant.HALF_MODE;
            }
        }
    }

    @PublicMethod
    public void setOrientationHelper(@NonNull OrientationHelper orientationHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, orientationHelper) == null) {
            this.mOrientationHelper = orientationHelper;
        }
    }

    @PublicMethod
    public void setOrientationLock(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            sIsOrientationLock = z;
            if (z) {
                return;
            }
            enableOrientationEventHelper();
        }
    }

    @PublicMethod
    public void setPlayerMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.mCurrentMode = str;
        }
    }

    @PublicMethod
    public void setRemote(boolean z) {
        BaseKernelLayer baseKernelLayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (baseKernelLayer = this.mKernelLayer) == null) {
            return;
        }
        baseKernelLayer.setRemote(z);
    }

    @PublicMethod
    public void setStyleSwitchHelper(@NonNull IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iPlayerStyleSwitchHelper) == null) {
            this.mStyleSwitchHelper = iPlayerStyleSwitchHelper;
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupLayers(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlayer(@NonNull Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, baseKernelLayer) == null) {
            super.setupPlayer(context, baseKernelLayer);
            setupInternalNeuron(context);
        }
    }

    @PublicMethod
    public void switchOrientationLock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            setOrientationLock(!sIsOrientationLock);
        }
    }

    @PublicMethod
    public void switchToFull(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            switchToFull();
        }
    }

    @PublicMethod
    public void switchToHalf(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            if (isEnablePlayerConfigNotch(false)) {
                BdViewOpUtils.fixFullScreen4Notch(getActivity(), false);
            }
            getPlayerCallbackManager().onBeforeSwitchToHalf();
            BdVideoLog.d(TAG, "player start switchToHalf");
            this.mStyleSwitchHelper.switchToNormalStyle();
            sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_HALF));
            getPlayerCallbackManager().onVideoSwitchToHalf();
        }
    }

    @PublicMethod
    public int findLayerIndex(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            int childCount = this.mLayerContainer.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.mLayerContainer.getChildAt(i2).getClass() == cls) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @NonNull
    @PublicMethod
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (UniversalPlayerCallbackManager) this.mCallbackManager : (UniversalPlayerCallbackManager) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @NonNull
    @PublicMethod
    public IUniversalPlayerStatDispatcher getStatDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? UniversalStatDispatcherImp.EMPTY : (IUniversalPlayerStatDispatcher) invokeV.objValue;
    }

    @PublicMethod
    public void switchToFull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (isEnablePlayerConfigNotch(true)) {
                BdViewOpUtils.fixFullScreen4Notch(getActivity(), true);
            }
            BdVideoLog.d(TAG, "player start switchToFull");
            getPlayerCallbackManager().onBeforeSwitchToFull();
            this.mStyleSwitchHelper.switchToFullStyle();
            sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FULL));
            getPlayerCallbackManager().onVideoSwitchToFull();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BaseKernelLayer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str) {
        super(context, baseKernelLayer, str, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BaseKernelLayer) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    @PublicMethod
    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            switchToHalf(-1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversalPlayer(@Nullable Context context, @NonNull String str, @Nullable String str2) {
        super(context, null, str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BaseKernelLayer) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }
}
