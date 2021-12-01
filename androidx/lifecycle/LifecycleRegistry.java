package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAddingObserverCounter;
    public boolean mHandlingEvent;
    public final WeakReference<LifecycleOwner> mLifecycleOwner;
    public boolean mNewEventOccurred;
    public FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap;
    public ArrayList<Lifecycle.State> mParentStates;
    public Lifecycle.State mState;

    /* renamed from: androidx.lifecycle.LifecycleRegistry$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-930682650, "Landroidx/lifecycle/LifecycleRegistry$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-930682650, "Landroidx/lifecycle/LifecycleRegistry$1;");
                    return;
                }
            }
            int[] iArr = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr;
            try {
                iArr[Lifecycle.State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr2;
            try {
                iArr2[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ObserverWithState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LifecycleEventObserver mLifecycleObserver;
        public Lifecycle.State mState;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lifecycleObserver, state};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.mState = state;
        }

        public void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, lifecycleOwner, event) == null) {
                Lifecycle.State stateAfter = LifecycleRegistry.getStateAfter(event);
                this.mState = LifecycleRegistry.min(this.mState, stateAfter);
                this.mLifecycleObserver.onStateChanged(lifecycleOwner, event);
                this.mState = stateAfter;
            }
        }
    }

    public LifecycleRegistry(@NonNull LifecycleOwner lifecycleOwner) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycleOwner};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mObserverMap = new FastSafeIterableMap<>();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList<>();
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = Lifecycle.State.INITIALIZED;
    }

    private void backwardPass(LifecycleOwner lifecycleOwner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, lifecycleOwner) == null) {
            Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.mObserverMap.descendingIterator();
            while (descendingIterator.hasNext() && !this.mNewEventOccurred) {
                Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
                ObserverWithState value = next.getValue();
                while (value.mState.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(next.getKey())) {
                    Lifecycle.Event downEvent = downEvent(value.mState);
                    pushParentState(getStateAfter(downEvent));
                    value.dispatchEvent(lifecycleOwner, downEvent);
                    popParentState();
                }
            }
        }
    }

    private Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, lifecycleObserver)) == null) {
            Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.mObserverMap.ceil(lifecycleObserver);
            Lifecycle.State state = null;
            Lifecycle.State state2 = ceil != null ? ceil.getValue().mState : null;
            if (!this.mParentStates.isEmpty()) {
                ArrayList<Lifecycle.State> arrayList = this.mParentStates;
                state = arrayList.get(arrayList.size() - 1);
            }
            return min(min(this.mState, state2), state);
        }
        return (Lifecycle.State) invokeL.objValue;
    }

    public static Lifecycle.Event downEvent(Lifecycle.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, state)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                throw new IllegalArgumentException("Unexpected state value " + state);
                            }
                            throw new IllegalArgumentException();
                        }
                        return Lifecycle.Event.ON_PAUSE;
                    }
                    return Lifecycle.Event.ON_STOP;
                }
                return Lifecycle.Event.ON_DESTROY;
            }
            throw new IllegalArgumentException();
        }
        return (Lifecycle.Event) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry$ObserverWithState> */
    /* JADX WARN: Multi-variable type inference failed */
    private void forwardPass(LifecycleOwner lifecycleOwner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, lifecycleOwner) == null) {
            SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions iteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
            while (iteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
                Map.Entry next = iteratorWithAdditions.next();
                ObserverWithState observerWithState = (ObserverWithState) next.getValue();
                while (observerWithState.mState.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains(next.getKey())) {
                    pushParentState(observerWithState.mState);
                    observerWithState.dispatchEvent(lifecycleOwner, upEvent(observerWithState.mState));
                    popParentState();
                }
            }
        }
    }

    public static Lifecycle.State getStateAfter(Lifecycle.Event event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, event)) == null) {
            switch (AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
                case 1:
                case 2:
                    return Lifecycle.State.CREATED;
                case 3:
                case 4:
                    return Lifecycle.State.STARTED;
                case 5:
                    return Lifecycle.State.RESUMED;
                case 6:
                    return Lifecycle.State.DESTROYED;
                default:
                    throw new IllegalArgumentException("Unexpected event value " + event);
            }
        }
        return (Lifecycle.State) invokeL.objValue;
    }

    private boolean isSynced() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.mObserverMap.size() == 0) {
                return true;
            }
            Lifecycle.State state = this.mObserverMap.eldest().getValue().mState;
            Lifecycle.State state2 = this.mObserverMap.newest().getValue().mState;
            return state == state2 && this.mState == state2;
        }
        return invokeV.booleanValue;
    }

    public static Lifecycle.State min(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, state, state2)) == null) ? (state2 == null || state2.compareTo(state) >= 0) ? state : state2 : (Lifecycle.State) invokeLL.objValue;
    }

    private void moveToState(Lifecycle.State state) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, state) == null) || this.mState == state) {
            return;
        }
        this.mState = state;
        if (!this.mHandlingEvent && this.mAddingObserverCounter == 0) {
            this.mHandlingEvent = true;
            sync();
            this.mHandlingEvent = false;
            return;
        }
        this.mNewEventOccurred = true;
    }

    private void popParentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ArrayList<Lifecycle.State> arrayList = this.mParentStates;
            arrayList.remove(arrayList.size() - 1);
        }
    }

    private void pushParentState(Lifecycle.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, state) == null) {
            this.mParentStates.add(state);
        }
    }

    private void sync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner.get();
            if (lifecycleOwner != null) {
                while (!isSynced()) {
                    this.mNewEventOccurred = false;
                    if (this.mState.compareTo(this.mObserverMap.eldest().getValue().mState) < 0) {
                        backwardPass(lifecycleOwner);
                    }
                    Map.Entry<LifecycleObserver, ObserverWithState> newest = this.mObserverMap.newest();
                    if (!this.mNewEventOccurred && newest != null && this.mState.compareTo(newest.getValue().mState) > 0) {
                        forwardPass(lifecycleOwner);
                    }
                }
                this.mNewEventOccurred = false;
                return;
            }
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }

    public static Lifecycle.Event upEvent(Lifecycle.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, state)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[state.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return Lifecycle.Event.ON_START;
                }
                if (i2 == 3) {
                    return Lifecycle.Event.ON_RESUME;
                }
                if (i2 == 4) {
                    throw new IllegalArgumentException();
                }
                if (i2 != 5) {
                    throw new IllegalArgumentException("Unexpected state value " + state);
                }
            }
            return Lifecycle.Event.ON_CREATE;
        }
        return (Lifecycle.Event) invokeL.objValue;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@NonNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lifecycleObserver) == null) {
            Lifecycle.State state = this.mState;
            Lifecycle.State state2 = Lifecycle.State.DESTROYED;
            if (state != state2) {
                state2 = Lifecycle.State.INITIALIZED;
            }
            ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
            if (this.mObserverMap.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.mLifecycleOwner.get()) != null) {
                boolean z = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
                Lifecycle.State calculateTargetState = calculateTargetState(lifecycleObserver);
                this.mAddingObserverCounter++;
                while (observerWithState.mState.compareTo(calculateTargetState) < 0 && this.mObserverMap.contains(lifecycleObserver)) {
                    pushParentState(observerWithState.mState);
                    observerWithState.dispatchEvent(lifecycleOwner, upEvent(observerWithState.mState));
                    popParentState();
                    calculateTargetState = calculateTargetState(lifecycleObserver);
                }
                if (!z) {
                    sync();
                }
                this.mAddingObserverCounter--;
            }
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mState : (Lifecycle.State) invokeV.objValue;
    }

    public int getObserverCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mObserverMap.size() : invokeV.intValue;
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            moveToState(getStateAfter(event));
        }
    }

    @MainThread
    @Deprecated
    public void markState(@NonNull Lifecycle.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, state) == null) {
            setCurrentState(state);
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NonNull LifecycleObserver lifecycleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lifecycleObserver) == null) {
            this.mObserverMap.remove(lifecycleObserver);
        }
    }

    @MainThread
    public void setCurrentState(@NonNull Lifecycle.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, state) == null) {
            moveToState(state);
        }
    }
}
