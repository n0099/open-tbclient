package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class AsyncListDiffer<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Executor sMainThreadExecutor;
    public transient /* synthetic */ FieldHolder $fh;
    public final AsyncDifferConfig<T> mConfig;
    @Nullable
    public List<T> mList;
    public final List<ListListener<T>> mListeners;
    public Executor mMainThreadExecutor;
    public int mMaxScheduledGeneration;
    @NonNull
    public List<T> mReadOnlyList;
    public final ListUpdateCallback mUpdateCallback;

    /* loaded from: classes.dex */
    public interface ListListener<T> {
        void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2);
    }

    /* loaded from: classes.dex */
    public static class MainThreadExecutor implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler mHandler;

        public MainThreadExecutor() {
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
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                this.mHandler.post(runnable);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-965426967, "Landroidx/recyclerview/widget/AsyncListDiffer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-965426967, "Landroidx/recyclerview/widget/AsyncListDiffer;");
                return;
            }
        }
        sMainThreadExecutor = new MainThreadExecutor();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).build());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adapter, itemCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ListUpdateCallback) objArr2[0], (AsyncDifferConfig) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void onCurrentListChanged(@NonNull List<T> list, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, list, runnable) == null) {
            for (ListListener<T> listListener : this.mListeners) {
                listListener.onCurrentListChanged(list, this.mReadOnlyList);
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void addListListener(@NonNull ListListener<T> listListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listListener) == null) {
            this.mListeners.add(listListener);
        }
    }

    @NonNull
    public List<T> getCurrentList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mReadOnlyList : (List) invokeV.objValue;
    }

    public void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, list, diffResult, runnable) == null) {
            List<T> list2 = this.mReadOnlyList;
            this.mList = list;
            this.mReadOnlyList = Collections.unmodifiableList(list);
            diffResult.dispatchUpdatesTo(this.mUpdateCallback);
            onCurrentListChanged(list2, runnable);
        }
    }

    public void removeListListener(@NonNull ListListener<T> listListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, listListener) == null) {
            this.mListeners.remove(listListener);
        }
    }

    public void submitList(@Nullable List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            submitList(list, null);
        }
    }

    public void submitList(@Nullable List<T> list, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, list, runnable) == null) {
            int i = this.mMaxScheduledGeneration + 1;
            this.mMaxScheduledGeneration = i;
            List<T> list2 = this.mList;
            if (list == list2) {
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            List<T> list3 = this.mReadOnlyList;
            if (list == null) {
                int size = list2.size();
                this.mList = null;
                this.mReadOnlyList = Collections.emptyList();
                this.mUpdateCallback.onRemoved(0, size);
                onCurrentListChanged(list3, runnable);
            } else if (list2 == null) {
                this.mList = list;
                this.mReadOnlyList = Collections.unmodifiableList(list);
                this.mUpdateCallback.onInserted(0, list.size());
                onCurrentListChanged(list3, runnable);
            } else {
                this.mConfig.getBackgroundThreadExecutor().execute(new Runnable(this, list2, list, i, runnable) { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AsyncListDiffer this$0;
                    public final /* synthetic */ Runnable val$commitCallback;
                    public final /* synthetic */ List val$newList;
                    public final /* synthetic */ List val$oldList;
                    public final /* synthetic */ int val$runGeneration;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list2, list, Integer.valueOf(i), runnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$oldList = list2;
                        this.val$newList = list;
                        this.val$runGeneration = i;
                        this.val$commitCallback = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.mMainThreadExecutor.execute(new Runnable(this, DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                                public boolean areContentsTheSame(int i2, int i3) {
                                    InterceptResult invokeII;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeII = interceptable3.invokeII(1048576, this, i2, i3)) == null) {
                                        Object obj = this.this$1.val$oldList.get(i2);
                                        Object obj2 = this.this$1.val$newList.get(i3);
                                        if (obj == null || obj2 == null) {
                                            if (obj == null && obj2 == null) {
                                                return true;
                                            }
                                            throw new AssertionError();
                                        }
                                        return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                                    }
                                    return invokeII.booleanValue;
                                }

                                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                                public boolean areItemsTheSame(int i2, int i3) {
                                    InterceptResult invokeII;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeII = interceptable3.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                                        Object obj = this.this$1.val$oldList.get(i2);
                                        Object obj2 = this.this$1.val$newList.get(i3);
                                        if (obj == null || obj2 == null) {
                                            return obj == null && obj2 == null;
                                        }
                                        return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
                                    }
                                    return invokeII.booleanValue;
                                }

                                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                                @Nullable
                                public Object getChangePayload(int i2, int i3) {
                                    InterceptResult invokeII;
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || (invokeII = interceptable3.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
                                        Object obj = this.this$1.val$oldList.get(i2);
                                        Object obj2 = this.this$1.val$newList.get(i3);
                                        if (obj != null && obj2 != null) {
                                            return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(obj, obj2);
                                        }
                                        throw new AssertionError();
                                    }
                                    return invokeII.objValue;
                                }

                                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                                public int getNewListSize() {
                                    InterceptResult invokeV;
                                    Interceptable interceptable3 = $ic;
                                    return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048579, this)) == null) ? this.this$1.val$newList.size() : invokeV.intValue;
                                }

                                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                                public int getOldListSize() {
                                    InterceptResult invokeV;
                                    Interceptable interceptable3 = $ic;
                                    return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048580, this)) == null) ? this.this$1.val$oldList.size() : invokeV.intValue;
                                }
                            })) { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
                                public final /* synthetic */ DiffUtil.DiffResult val$result;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$result = r7;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass1 anonymousClass1 = this.this$1;
                                        AsyncListDiffer asyncListDiffer = anonymousClass1.this$0;
                                        if (asyncListDiffer.mMaxScheduledGeneration == anonymousClass1.val$runGeneration) {
                                            asyncListDiffer.latchList(anonymousClass1.val$newList, this.val$result, anonymousClass1.val$commitCallback);
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listUpdateCallback, asyncDifferConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.mMainThreadExecutor = sMainThreadExecutor;
        }
    }
}
