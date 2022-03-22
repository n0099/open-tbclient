package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.savedstate.SavedStateRegistry;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class SavedStateHandle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Class[] ACCEPTABLE_CLASSES;
    public static final String KEYS = "keys";
    public static final String VALUES = "values";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, SavingStateLiveData<?>> mLiveDatas;
    public final Map<String, Object> mRegular;
    public final SavedStateRegistry.SavedStateProvider mSavedStateProvider;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(631824138, "Landroidx/lifecycle/SavedStateHandle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(631824138, "Landroidx/lifecycle/SavedStateHandle;");
                return;
            }
        }
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        clsArr[4] = Integer.TYPE;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        clsArr[27] = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        clsArr[28] = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        ACCEPTABLE_CLASSES = clsArr;
    }

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateRegistry.SavedStateProvider(this) { // from class: androidx.lifecycle.SavedStateHandle.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SavedStateHandle this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NonNull
            public Bundle saveState() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Set<String> keySet = this.this$0.mRegular.keySet();
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                    for (String str : keySet) {
                        arrayList.add(str);
                        arrayList2.add(this.this$0.mRegular.get(str));
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
                    bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
                    return bundle;
                }
                return (Bundle) invokeV.objValue;
            }
        };
        this.mRegular = new HashMap(map);
    }

    public static SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bundle, bundle2)) == null) {
            if (bundle == null && bundle2 == null) {
                return new SavedStateHandle();
            }
            HashMap hashMap = new HashMap();
            if (bundle2 != null) {
                for (String str : bundle2.keySet()) {
                    hashMap.put(str, bundle2.get(str));
                }
            }
            if (bundle == null) {
                return new SavedStateHandle(hashMap);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEYS);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(VALUES);
            if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
                for (int i = 0; i < parcelableArrayList.size(); i++) {
                    hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
                }
                return new SavedStateHandle(hashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        return (SavedStateHandle) invokeLL.objValue;
    }

    @NonNull
    private <T> MutableLiveData<T> getLiveDataInternal(@NonNull String str, boolean z, @Nullable T t) {
        InterceptResult invokeCommon;
        SavingStateLiveData<?> savingStateLiveData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, Boolean.valueOf(z), t})) == null) {
            SavingStateLiveData<?> savingStateLiveData2 = this.mLiveDatas.get(str);
            if (savingStateLiveData2 != null) {
                return savingStateLiveData2;
            }
            if (this.mRegular.containsKey(str)) {
                savingStateLiveData = new SavingStateLiveData<>(this, str, this.mRegular.get(str));
            } else if (z) {
                savingStateLiveData = new SavingStateLiveData<>(this, str, t);
            } else {
                savingStateLiveData = new SavingStateLiveData<>(this, str);
            }
            this.mLiveDatas.put(str, savingStateLiveData);
            return savingStateLiveData;
        }
        return (MutableLiveData) invokeCommon.objValue;
    }

    public static void validateValue(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, obj) == null) || obj == null) {
            return;
        }
        for (Class cls : ACCEPTABLE_CLASSES) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.mRegular.containsKey(str) : invokeL.booleanValue;
    }

    @Nullable
    @MainThread
    public <T> T get(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (T) this.mRegular.get(str) : (T) invokeL.objValue;
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? getLiveDataInternal(str, false, null) : (MutableLiveData) invokeL.objValue;
    }

    @NonNull
    @MainThread
    public Set<String> keys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Collections.unmodifiableSet(this.mRegular.keySet()) : (Set) invokeV.objValue;
    }

    @Nullable
    @MainThread
    public <T> T remove(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            T t = (T) this.mRegular.remove(str);
            SavingStateLiveData<?> remove = this.mLiveDatas.remove(str);
            if (remove != null) {
                remove.detach();
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public SavedStateRegistry.SavedStateProvider savedStateProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSavedStateProvider : (SavedStateRegistry.SavedStateProvider) invokeV.objValue;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, t) == null) {
            validateValue(t);
            SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(str);
            if (savingStateLiveData != null) {
                savingStateLiveData.setValue(t);
            } else {
                this.mRegular.put(str, t);
            }
        }
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, t)) == null) ? getLiveDataInternal(str, true, t) : (MutableLiveData) invokeLL.objValue;
    }

    /* loaded from: classes.dex */
    public static class SavingStateLiveData<T> extends MutableLiveData<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SavedStateHandle mHandle;
        public String mKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t) {
            super(t);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {savedStateHandle, str, t};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }

        public void detach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mHandle = null;
            }
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                SavedStateHandle savedStateHandle = this.mHandle;
                if (savedStateHandle != null) {
                    savedStateHandle.mRegular.put(this.mKey, t);
                }
                super.setValue(t);
            }
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {savedStateHandle, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateRegistry.SavedStateProvider(this) { // from class: androidx.lifecycle.SavedStateHandle.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SavedStateHandle this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NonNull
            public Bundle saveState() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Set<String> keySet = this.this$0.mRegular.keySet();
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                    for (String str : keySet) {
                        arrayList.add(str);
                        arrayList2.add(this.this$0.mRegular.get(str));
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
                    bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
                    return bundle;
                }
                return (Bundle) invokeV.objValue;
            }
        };
        this.mRegular = new HashMap();
    }
}
