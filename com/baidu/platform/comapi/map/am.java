package com.baidu.platform.comapi.map;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes2.dex */
public class am extends GestureDetector.SimpleOnGestureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MapController a;
    public OnLongPressListener b;
    public volatile Set<GestureDetector.SimpleOnGestureListener> c;
    public Object d;

    public am() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new CopyOnWriteArraySet();
        this.d = new Object();
    }

    public OnLongPressListener a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (OnLongPressListener) invokeV.objValue;
    }

    public void a(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, simpleOnGestureListener) == null) {
            synchronized (this.d) {
                this.c.add(simpleOnGestureListener);
            }
        }
    }

    public void b(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, simpleOnGestureListener) == null) {
            synchronized (this.d) {
                this.c.remove(simpleOnGestureListener);
            }
        }
    }

    public void a(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mapController) == null) {
            this.a = mapController;
        }
    }

    public void a(OnLongPressListener onLongPressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongPressListener) == null) {
            this.b = onLongPressListener;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        simpleOnGestureListener.onDoubleTap(motionEvent);
                    }
                }
            }
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.handleDoubleDownClick(motionEvent);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        MapController mapController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        simpleOnGestureListener.onDoubleTapEvent(motionEvent);
                    }
                }
            }
            if (motionEvent.getAction() == 1 && (mapController = this.a) != null) {
                mapController.handleDoubleTouch(motionEvent);
            }
            return super.onDoubleTapEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        simpleOnGestureListener.onDown(motionEvent);
                    }
                }
            }
            return super.onDown(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, motionEvent) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onShowPress(motionEvent);
                        }
                    }
                }
            }
            super.onShowPress(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onSingleTapConfirmed(motionEvent);
                        }
                    }
                }
            }
            MapController mapController = this.a;
            if (mapController != null && mapController.handleTouchSingleClick(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        simpleOnGestureListener.onSingleTapUp(motionEvent);
                    }
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        simpleOnGestureListener.onFling(motionEvent, motionEvent2, f, f2);
                    }
                }
            }
            MapController mapController = this.a;
            if (mapController == null) {
                return false;
            }
            if (mapController.getMapControlMode() == MapController.MapControlMode.STREET) {
                this.a.handleTouchUp(motionEvent2);
            }
            return this.a.handleFling(motionEvent, motionEvent2, f, f2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, motionEvent) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        if (simpleOnGestureListener != null) {
                            simpleOnGestureListener.onLongPress(motionEvent);
                        }
                    }
                }
            }
            MapController mapController = this.a;
            if (mapController != null && !mapController.isEnableDMoveZoom() && !this.a.isNaviMode() && (onLongPressListener = this.b) != null) {
                onLongPressListener.onLongPress(motionEvent);
            }
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            synchronized (this.d) {
                Set<GestureDetector.SimpleOnGestureListener> set = this.c;
                if (set != null) {
                    for (GestureDetector.SimpleOnGestureListener simpleOnGestureListener : set) {
                        simpleOnGestureListener.onScroll(motionEvent, motionEvent2, f, f2);
                    }
                }
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        return invokeCommon.booleanValue;
    }
}
