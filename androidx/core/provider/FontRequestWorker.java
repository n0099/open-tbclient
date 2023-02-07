package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class FontRequestWorker {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK;
    @GuardedBy("LOCK")
    public static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES;
    public static final LruCache<String, Typeface> sTypefaceCache;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class TypefaceResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTypeface = null;
            this.mResult = i;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(@NonNull Typeface typeface) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeface};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTypeface = typeface;
            this.mResult = 0;
        }

        @SuppressLint({"WrongConstant"})
        public boolean isSuccess() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mResult == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1151199675, "Landroidx/core/provider/FontRequestWorker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1151199675, "Landroidx/core/provider/FontRequestWorker;");
                return;
            }
        }
        sTypefaceCache = new LruCache<>(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap<>();
    }

    public FontRequestWorker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void resetTypefaceCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            sTypefaceCache.evictAll();
        }
    }

    public static String createCacheId(@NonNull FontRequest fontRequest, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, fontRequest, i)) == null) {
            return fontRequest.getId() + "-" + i;
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"WrongConstant"})
    public static int getFontFamilyResultStatus(@NonNull FontsContractCompat.FontFamilyResult fontFamilyResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fontFamilyResult)) == null) {
            int i = 1;
            if (fontFamilyResult.getStatusCode() != 0) {
                if (fontFamilyResult.getStatusCode() != 1) {
                    return -3;
                }
                return -2;
            }
            FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
            if (fonts != null && fonts.length != 0) {
                i = 0;
                for (FontsContractCompat.FontInfo fontInfo : fonts) {
                    int resultCode = fontInfo.getResultCode();
                    if (resultCode != 0) {
                        if (resultCode < 0) {
                            return -3;
                        }
                        return resultCode;
                    }
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static TypefaceResult getFontSync(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, fontRequest, i)) == null) {
            Typeface typeface = sTypefaceCache.get(str);
            if (typeface != null) {
                return new TypefaceResult(typeface);
            }
            try {
                FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest, null);
                int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
                if (fontFamilyResultStatus != 0) {
                    return new TypefaceResult(fontFamilyResultStatus);
                }
                Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i);
                if (createFromFontInfo != null) {
                    sTypefaceCache.put(str, createFromFontInfo);
                    return new TypefaceResult(createFromFontInfo);
                }
                return new TypefaceResult(-3);
            } catch (PackageManager.NameNotFoundException unused) {
                return new TypefaceResult(-1);
            }
        }
        return (TypefaceResult) invokeLLLI.objValue;
    }

    public static Typeface requestFontAsync(@NonNull Context context, @NonNull FontRequest fontRequest, int i, @Nullable Executor executor, @NonNull CallbackWithHandler callbackWithHandler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, fontRequest, Integer.valueOf(i), executor, callbackWithHandler})) == null) {
            String createCacheId = createCacheId(fontRequest, i);
            Typeface typeface = sTypefaceCache.get(createCacheId);
            if (typeface != null) {
                callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
                return typeface;
            }
            Consumer<TypefaceResult> consumer = new Consumer<TypefaceResult>(callbackWithHandler) { // from class: androidx.core.provider.FontRequestWorker.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CallbackWithHandler val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {callbackWithHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$callback = callbackWithHandler;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.core.util.Consumer
                public void accept(TypefaceResult typefaceResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, typefaceResult) == null) {
                        this.val$callback.onTypefaceResult(typefaceResult);
                    }
                }
            };
            synchronized (LOCK) {
                ArrayList<Consumer<TypefaceResult>> arrayList = PENDING_REPLIES.get(createCacheId);
                if (arrayList != null) {
                    arrayList.add(consumer);
                    return null;
                }
                ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
                arrayList2.add(consumer);
                PENDING_REPLIES.put(createCacheId, arrayList2);
                Callable<TypefaceResult> callable = new Callable<TypefaceResult>(createCacheId, context, fontRequest, i) { // from class: androidx.core.provider.FontRequestWorker.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$id;
                    public final /* synthetic */ FontRequest val$request;
                    public final /* synthetic */ int val$style;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {createCacheId, context, fontRequest, Integer.valueOf(i)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$id = createCacheId;
                        this.val$context = context;
                        this.val$request = fontRequest;
                        this.val$style = i;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public TypefaceResult call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
                        }
                        return (TypefaceResult) invokeV.objValue;
                    }
                };
                if (executor == null) {
                    executor = DEFAULT_EXECUTOR_SERVICE;
                }
                RequestExecutor.execute(executor, callable, new Consumer<TypefaceResult>(createCacheId) { // from class: androidx.core.provider.FontRequestWorker.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$id;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {createCacheId};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$id = createCacheId;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.core.util.Consumer
                    public void accept(TypefaceResult typefaceResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, typefaceResult) == null) {
                            synchronized (FontRequestWorker.LOCK) {
                                ArrayList<Consumer<TypefaceResult>> arrayList3 = FontRequestWorker.PENDING_REPLIES.get(this.val$id);
                                if (arrayList3 == null) {
                                    return;
                                }
                                FontRequestWorker.PENDING_REPLIES.remove(this.val$id);
                                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                                    arrayList3.get(i2).accept(typefaceResult);
                                }
                            }
                        }
                    }
                });
                return null;
            }
        }
        return (Typeface) invokeCommon.objValue;
    }

    public static Typeface requestFontSync(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, fontRequest, callbackWithHandler, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String createCacheId = createCacheId(fontRequest, i);
            Typeface typeface = sTypefaceCache.get(createCacheId);
            if (typeface != null) {
                callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
                return typeface;
            } else if (i2 == -1) {
                TypefaceResult fontSync = getFontSync(createCacheId, context, fontRequest, i);
                callbackWithHandler.onTypefaceResult(fontSync);
                return fontSync.mTypeface;
            } else {
                try {
                    TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new Callable<TypefaceResult>(createCacheId, context, fontRequest, i) { // from class: androidx.core.provider.FontRequestWorker.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ String val$id;
                        public final /* synthetic */ FontRequest val$request;
                        public final /* synthetic */ int val$style;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {createCacheId, context, fontRequest, Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$id = createCacheId;
                            this.val$context = context;
                            this.val$request = fontRequest;
                            this.val$style = i;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public TypefaceResult call() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
                            }
                            return (TypefaceResult) invokeV.objValue;
                        }
                    }, i2);
                    callbackWithHandler.onTypefaceResult(typefaceResult);
                    return typefaceResult.mTypeface;
                } catch (InterruptedException unused) {
                    callbackWithHandler.onTypefaceResult(new TypefaceResult(-3));
                    return null;
                }
            }
        }
        return (Typeface) invokeCommon.objValue;
    }
}
