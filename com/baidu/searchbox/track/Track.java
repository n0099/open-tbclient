package com.baidu.searchbox.track;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.track.ui.EvictingDeque;
import com.baidu.searchbox.track.ui.OnFragmentTraceListener;
import com.baidu.searchbox.track.ui.TraceManager;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class Track {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UI_TRACK_CAPACITY = 20;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mLockListener;
    public Object mLockTrackUI;
    public EvictingDeque<TrackUI> mTrackUIDeque;
    public LinkedList<OnTrackUIListener> mTrackUIListeners;

    /* renamed from: com.baidu.searchbox.track.Track$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public interface OnTrackUIListener {
        void onAddTrackUI(TrackUI trackUI);
    }

    /* loaded from: classes2.dex */
    public static final class TrackCreator {
        public static /* synthetic */ Interceptable $ic;
        public static final Track mTrace;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1794305117, "Lcom/baidu/searchbox/track/Track$TrackCreator;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1794305117, "Lcom/baidu/searchbox/track/Track$TrackCreator;");
                    return;
                }
            }
            mTrace = new Track(null);
        }

        public TrackCreator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ Track(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Track getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? TrackCreator.mTrace : (Track) invokeV.objValue;
    }

    public void addTrackUI(@NonNull TrackUI trackUI) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, trackUI) == null) {
            if (trackUI != null) {
                synchronized (this.mLockTrackUI) {
                    this.mTrackUIDeque.offerLast(trackUI);
                }
                return;
            }
            throw new NullPointerException("trackUI should not be null");
        }
    }

    public void addTrackUIListener(@NonNull OnTrackUIListener onTrackUIListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onTrackUIListener) == null) {
            synchronized (this.mLockListener) {
                if (!this.mTrackUIListeners.contains(onTrackUIListener)) {
                    this.mTrackUIListeners.add(onTrackUIListener);
                }
            }
        }
    }

    public LinkedList<TrackUI> getAllTrackUIs() {
        InterceptResult invokeV;
        LinkedList<TrackUI> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mLockTrackUI) {
                linkedList = new LinkedList<>(this.mTrackUIDeque.getElements());
            }
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    @Nullable
    public TrackUI getLastTrackUI() {
        InterceptResult invokeV;
        TrackUI peekLast;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.mLockTrackUI) {
                peekLast = this.mTrackUIDeque.peekLast();
            }
            return peekLast;
        }
        return (TrackUI) invokeV.objValue;
    }

    public LinkedList<OnTrackUIListener> getTrackUIListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTrackUIListeners : (LinkedList) invokeV.objValue;
    }

    public boolean isForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? BdBoxActivityManager.isForeground() : invokeV.booleanValue;
    }

    public void removeTrackUIListener(@NonNull OnTrackUIListener onTrackUIListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onTrackUIListener) == null) {
            synchronized (this.mLockListener) {
                this.mTrackUIListeners.remove(onTrackUIListener);
            }
        }
    }

    public void setOnFragmentTraceListener(@Nullable OnFragmentTraceListener onFragmentTraceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onFragmentTraceListener) == null) {
            TraceManager.getInstance().setOnFragmentListener(onFragmentTraceListener);
        }
    }

    public void setTrackUICapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 >= 0) {
                this.mTrackUIDeque.setCapacity(i2);
                return;
            }
            throw new IllegalArgumentException("capacity should not < 0");
        }
    }

    public void startTrack(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, context) == null) || TraceManager.getInstance().isRegistered()) {
            return;
        }
        TraceManager.getInstance().register(context);
    }

    public Track() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLockTrackUI = new Object();
        this.mLockListener = new Object();
        this.mTrackUIDeque = EvictingDeque.create(20);
        this.mTrackUIListeners = new LinkedList<>();
    }
}
