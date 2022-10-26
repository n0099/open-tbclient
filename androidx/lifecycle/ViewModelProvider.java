package androidx.lifecycle;

import android.app.Application;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class ViewModelProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    public transient /* synthetic */ FieldHolder $fh;
    public final Factory mFactory;
    public final ViewModelStore mViewModelStore;

    /* loaded from: classes.dex */
    public interface Factory {
        ViewModel create(Class cls);
    }

    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static /* synthetic */ Interceptable $ic;
        public static AndroidViewModelFactory sInstance;
        public transient /* synthetic */ FieldHolder $fh;
        public Application mApplication;

        public AndroidViewModelFactory(Application application) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {application};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mApplication = application;
        }

        public static AndroidViewModelFactory getInstance(Application application) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, application)) == null) {
                if (sInstance == null) {
                    sInstance = new AndroidViewModelFactory(application);
                }
                return sInstance;
            }
            return (AndroidViewModelFactory) invokeL.objValue;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                if (AndroidViewModel.class.isAssignableFrom(cls)) {
                    try {
                        return cls.getConstructor(Application.class).newInstance(this.mApplication);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Cannot create an instance of " + cls, e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Cannot create an instance of " + cls, e2);
                    } catch (NoSuchMethodException e3) {
                        throw new RuntimeException("Cannot create an instance of " + cls, e3);
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException("Cannot create an instance of " + cls, e4);
                    }
                }
                return (T) super.create(cls);
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract <T extends ViewModel> T create(String str, Class<T> cls);

        public KeyedFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        public static /* synthetic */ Interceptable $ic;
        public static NewInstanceFactory sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        public NewInstanceFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static NewInstanceFactory getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (sInstance == null) {
                    sInstance = new NewInstanceFactory();
                }
                return sInstance;
            }
            return (NewInstanceFactory) invokeV.objValue;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                }
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onRequery(ViewModel viewModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewModel) == null) {
            }
        }

        public OnRequeryFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewModelStore, factory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    public <T extends ViewModel> T get(String str, Class<T> cls) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cls)) == null) {
            T t2 = (T) this.mViewModelStore.get(str);
            if (cls.isInstance(t2)) {
                Factory factory = this.mFactory;
                if (factory instanceof OnRequeryFactory) {
                    ((OnRequeryFactory) factory).onRequery(t2);
                }
                return t2;
            }
            Factory factory2 = this.mFactory;
            if (factory2 instanceof KeyedFactory) {
                t = (T) ((KeyedFactory) factory2).create(str, cls);
            } else {
                t = (T) factory2.create(cls);
            }
            this.mViewModelStore.put(str, t);
            return t;
        }
        return (T) invokeLL.objValue;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner) {
        this(r0, r8);
        Factory newInstanceFactory;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewModelStoreOwner};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ViewModelStore) objArr2[0], (Factory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            newInstanceFactory = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
        } else {
            newInstanceFactory = NewInstanceFactory.getInstance();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewModelStoreOwner, factory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ViewModelStore) objArr2[0], (Factory) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            String canonicalName = cls.getCanonicalName();
            if (canonicalName != null) {
                return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
            }
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) invokeL.objValue;
    }
}
