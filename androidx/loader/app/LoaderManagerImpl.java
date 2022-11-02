package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class LoaderManagerImpl extends LoaderManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static final String TAG = "LoaderManager";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final LifecycleOwner mLifecycleOwner;
    @NonNull
    public final LoaderViewModel mLoaderViewModel;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-639742447, "Landroidx/loader/app/LoaderManagerImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-639742447, "Landroidx/loader/app/LoaderManagerImpl;");
        }
    }

    /* loaded from: classes.dex */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Bundle mArgs;
        public final int mId;
        public LifecycleOwner mLifecycleOwner;
        @NonNull
        public final Loader<D> mLoader;
        public LoaderObserver<D> mObserver;
        public Loader<D> mPriorLoader;

        public LoaderInfo(int i, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), bundle, loader, loader2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mId = i;
            this.mArgs = bundle;
            this.mLoader = loader;
            this.mPriorLoader = loader2;
            loader.registerListener(i, this);
        }

        @MainThread
        public Loader<D> destroy(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Destroying: " + this);
                }
                this.mLoader.cancelLoad();
                this.mLoader.abandon();
                LoaderObserver<D> loaderObserver = this.mObserver;
                if (loaderObserver != null) {
                    removeObserver(loaderObserver);
                    if (z) {
                        loaderObserver.reset();
                    }
                }
                this.mLoader.unregisterListener(this);
                if ((loaderObserver != null && !loaderObserver.hasDeliveredData()) || z) {
                    this.mLoader.reset();
                    return this.mPriorLoader;
                }
                return this.mLoader;
            }
            return (Loader) invokeZ.objValue;
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.mId);
                printWriter.print(" mArgs=");
                printWriter.println(this.mArgs);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.mLoader);
                Loader<D> loader = this.mLoader;
                loader.dump(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                if (this.mObserver != null) {
                    printWriter.print(str);
                    printWriter.print("mCallbacks=");
                    printWriter.println(this.mObserver);
                    LoaderObserver<D> loaderObserver = this.mObserver;
                    loaderObserver.dump(str + GlideException.IndentedAppendable.INDENT, printWriter);
                }
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(getLoader().dataToString(getValue()));
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.println(hasActiveObservers());
            }
        }

        @NonNull
        public Loader<D> getLoader() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mLoader;
            }
            return (Loader) invokeV.objValue;
        }

        public boolean isCallbackWaitingForData() {
            InterceptResult invokeV;
            LoaderObserver<D> loaderObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!hasActiveObservers() || (loaderObserver = this.mObserver) == null || loaderObserver.hasDeliveredData()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public void markForRedelivery() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
                LoaderObserver<D> loaderObserver = this.mObserver;
                if (lifecycleOwner != null && loaderObserver != null) {
                    super.removeObserver(loaderObserver);
                    observe(lifecycleOwner, loaderObserver);
                }
            }
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                this.mLoader.startLoading();
            }
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Stopping: " + this);
                }
                this.mLoader.stopLoading();
            }
        }

        @Override // androidx.loader.content.Loader.OnLoadCompleteListener
        public void onLoadComplete(@NonNull Loader<D> loader, @Nullable D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, loader, d) == null) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "onLoadComplete: " + this);
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    setValue(d);
                    return;
                }
                if (LoaderManagerImpl.DEBUG) {
                    Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
                }
                postValue(d);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: androidx.lifecycle.Observer<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(@NonNull Observer<? super D> observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, observer) == null) {
                super.removeObserver(observer);
                this.mLifecycleOwner = null;
                this.mObserver = null;
            }
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, d) == null) {
                super.setValue(d);
                Loader<D> loader = this.mPriorLoader;
                if (loader != null) {
                    loader.reset();
                    this.mPriorLoader = null;
                }
            }
        }

        @NonNull
        @MainThread
        public Loader<D> setCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, lifecycleOwner, loaderCallbacks)) == null) {
                LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.mLoader, loaderCallbacks);
                observe(lifecycleOwner, loaderObserver);
                LoaderObserver<D> loaderObserver2 = this.mObserver;
                if (loaderObserver2 != null) {
                    removeObserver(loaderObserver2);
                }
                this.mLifecycleOwner = lifecycleOwner;
                this.mObserver = loaderObserver;
                return this.mLoader;
            }
            return (Loader) invokeLL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("LoaderInfo{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" #");
                sb.append(this.mId);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                DebugUtils.buildShortClassTag(this.mLoader, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class LoaderObserver<D> implements Observer<D> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final LoaderManager.LoaderCallbacks<D> mCallback;
        public boolean mDeliveredData;
        @NonNull
        public final Loader<D> mLoader;

        public LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loader, loaderCallbacks};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDeliveredData = false;
            this.mLoader = loader;
            this.mCallback = loaderCallbacks;
        }

        public void dump(String str, PrintWriter printWriter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, printWriter) == null) {
                printWriter.print(str);
                printWriter.print("mDeliveredData=");
                printWriter.println(this.mDeliveredData);
            }
        }

        public boolean hasDeliveredData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDeliveredData;
            }
            return invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mCallback.toString();
            }
            return (String) invokeV.objValue;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d) == null) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(d));
                }
                this.mCallback.onLoadFinished(this.mLoader, d);
                this.mDeliveredData = true;
            }
        }

        @MainThread
        public void reset() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mDeliveredData) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Resetting: " + this.mLoader);
                }
                this.mCallback.onLoaderReset(this.mLoader);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LoaderViewModel extends ViewModel {
        public static /* synthetic */ Interceptable $ic;
        public static final ViewModelProvider.Factory FACTORY;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCreatingLoader;
        public SparseArrayCompat<LoaderInfo> mLoaders;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1030221764, "Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1030221764, "Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;");
                    return;
                }
            }
            FACTORY = new ViewModelProvider.Factory() { // from class: androidx.loader.app.LoaderManagerImpl.LoaderViewModel.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NonNull
                public <T extends ViewModel> T create(@NonNull Class<T> cls) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) {
                        return new LoaderViewModel();
                    }
                    return (T) invokeL.objValue;
                }
            };
        }

        public LoaderViewModel() {
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
            this.mLoaders = new SparseArrayCompat<>();
            this.mCreatingLoader = false;
        }

        public void finishCreatingLoader() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mCreatingLoader = false;
            }
        }

        public boolean hasRunningLoaders() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int size = this.mLoaders.size();
                for (int i = 0; i < size; i++) {
                    if (this.mLoaders.valueAt(i).isCallbackWaitingForData()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isCreatingLoader() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mCreatingLoader;
            }
            return invokeV.booleanValue;
        }

        public void markForRedelivery() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int size = this.mLoaders.size();
                for (int i = 0; i < size; i++) {
                    this.mLoaders.valueAt(i).markForRedelivery();
                }
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                super.onCleared();
                int size = this.mLoaders.size();
                for (int i = 0; i < size; i++) {
                    this.mLoaders.valueAt(i).destroy(true);
                }
                this.mLoaders.clear();
            }
        }

        public void startCreatingLoader() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.mCreatingLoader = true;
            }
        }

        @NonNull
        public static LoaderViewModel getInstance(ViewModelStore viewModelStore) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewModelStore)) == null) {
                return (LoaderViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(LoaderViewModel.class);
            }
            return (LoaderViewModel) invokeL.objValue;
        }

        public <D> LoaderInfo<D> getLoader(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.mLoaders.get(i);
            }
            return (LoaderInfo) invokeI.objValue;
        }

        public void removeLoader(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.mLoaders.remove(i);
            }
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLL(1048576, this, str, fileDescriptor, printWriter, strArr) == null) && this.mLoaders.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.mLoaders.size(); i++) {
                    LoaderInfo valueAt = this.mLoaders.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.mLoaders.keyAt(i));
                    printWriter.print(": ");
                    printWriter.println(valueAt.toString());
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void putLoader(int i, @NonNull LoaderInfo loaderInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, loaderInfo) == null) {
                this.mLoaders.put(i, loaderInfo);
            }
        }
    }

    public LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycleOwner, viewModelStore};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = LoaderViewModel.getInstance(viewModelStore);
    }

    @NonNull
    @MainThread
    private <D> Loader<D> createAndInstallLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), bundle, loaderCallbacks, loader})) == null) {
            try {
                this.mLoaderViewModel.startCreatingLoader();
                Loader<D> onCreateLoader = loaderCallbacks.onCreateLoader(i, bundle);
                if (onCreateLoader != null) {
                    if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                    LoaderInfo loaderInfo = new LoaderInfo(i, bundle, onCreateLoader, loader);
                    if (DEBUG) {
                        Log.v("LoaderManager", "  Created new loader " + loaderInfo);
                    }
                    this.mLoaderViewModel.putLoader(i, loaderInfo);
                    this.mLoaderViewModel.finishCreatingLoader();
                    return loaderInfo.setCallback(this.mLifecycleOwner, loaderCallbacks);
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            } catch (Throwable th) {
                this.mLoaderViewModel.finishCreatingLoader();
                throw th;
            }
        }
        return (Loader) invokeCommon.objValue;
    }

    @Override // androidx.loader.app.LoaderManager
    @MainThread
    public void destroyLoader(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (!this.mLoaderViewModel.isCreatingLoader()) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    if (DEBUG) {
                        Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
                    }
                    LoaderInfo loader = this.mLoaderViewModel.getLoader(i);
                    if (loader != null) {
                        loader.destroy(true);
                        this.mLoaderViewModel.removeLoader(i);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("destroyLoader must be called on the main thread");
            }
            throw new IllegalStateException("Called while creating a loader");
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fileDescriptor, printWriter, strArr) == null) {
            this.mLoaderViewModel.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @Nullable
    public <D> Loader<D> getLoader(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (!this.mLoaderViewModel.isCreatingLoader()) {
                LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
                if (loader != null) {
                    return loader.getLoader();
                }
                return null;
            }
            throw new IllegalStateException("Called while creating a loader");
        }
        return (Loader) invokeI.objValue;
    }

    @Override // androidx.loader.app.LoaderManager
    public boolean hasRunningLoaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mLoaderViewModel.hasRunningLoaders();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.loader.app.LoaderManager
    public void markForRedelivery() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mLoaderViewModel.markForRedelivery();
        }
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> initLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, bundle, loaderCallbacks)) == null) {
            if (!this.mLoaderViewModel.isCreatingLoader()) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
                    if (DEBUG) {
                        Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                    }
                    if (loader == null) {
                        return createAndInstallLoader(i, bundle, loaderCallbacks, null);
                    }
                    if (DEBUG) {
                        Log.v("LoaderManager", "  Re-using existing loader " + loader);
                    }
                    return loader.setCallback(this.mLifecycleOwner, loaderCallbacks);
                }
                throw new IllegalStateException("initLoader must be called on the main thread");
            }
            throw new IllegalStateException("Called while creating a loader");
        }
        return (Loader) invokeILL.objValue;
    }

    @Override // androidx.loader.app.LoaderManager
    @NonNull
    @MainThread
    public <D> Loader<D> restartLoader(int i, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, bundle, loaderCallbacks)) == null) {
            if (!this.mLoaderViewModel.isCreatingLoader()) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    if (DEBUG) {
                        Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
                    }
                    LoaderInfo<D> loader = this.mLoaderViewModel.getLoader(i);
                    Loader<D> loader2 = null;
                    if (loader != null) {
                        loader2 = loader.destroy(false);
                    }
                    return createAndInstallLoader(i, bundle, loaderCallbacks, loader2);
                }
                throw new IllegalStateException("restartLoader must be called on the main thread");
            }
            throw new IllegalStateException("Called while creating a loader");
        }
        return (Loader) invokeILL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("LoaderManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
