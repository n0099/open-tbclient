package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ArrayBlockingQueue;
/* loaded from: classes.dex */
public final class AsyncLayoutInflater {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AsyncLayoutInflater";
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public Handler.Callback mHandlerCallback;
    public InflateThread mInflateThread;
    public LayoutInflater mInflater;

    /* loaded from: classes.dex */
    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view2, @LayoutRes int i, @Nullable ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class BasicInflater extends LayoutInflater {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] sClassPrefixList;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1638712441, "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$BasicInflater;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1638712441, "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$BasicInflater;");
                    return;
                }
            }
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BasicInflater(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return new BasicInflater(context);
            }
            return (LayoutInflater) invokeL.objValue;
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            InterceptResult invokeLL;
            View createView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, attributeSet)) == null) {
                for (String str2 : sClassPrefixList) {
                    try {
                        createView = createView(str, str2, attributeSet);
                    } catch (ClassNotFoundException unused) {
                    }
                    if (createView != null) {
                        return createView;
                    }
                }
                return super.onCreateView(str, attributeSet);
            }
            return (View) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class InflateRequest {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OnInflateFinishedListener callback;
        public AsyncLayoutInflater inflater;
        public ViewGroup parent;
        public int resid;

        /* renamed from: view  reason: collision with root package name */
        public View f1049view;

        public InflateRequest() {
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

    /* loaded from: classes.dex */
    public static class InflateThread extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public static final InflateThread sInstance;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayBlockingQueue<InflateRequest> mQueue;
        public Pools.SynchronizedPool<InflateRequest> mRequestPool;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-593881809, "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$InflateThread;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-593881809, "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$InflateThread;");
                    return;
                }
            }
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        public static InflateThread getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return sInstance;
            }
            return (InflateThread) invokeV.objValue;
        }

        public InflateRequest obtainRequest() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                InflateRequest acquire = this.mRequestPool.acquire();
                if (acquire == null) {
                    return new InflateRequest();
                }
                return acquire;
            }
            return (InflateRequest) invokeV.objValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            while (true) {
                runInner();
            }
        }

        public InflateThread() {
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
            this.mQueue = new ArrayBlockingQueue<>(10);
            this.mRequestPool = new Pools.SynchronizedPool<>(10);
        }

        public void runInner() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                try {
                    InflateRequest take = this.mQueue.take();
                    try {
                        take.f1049view = take.inflater.mInflater.inflate(take.resid, take.parent, false);
                    } catch (RuntimeException e) {
                        Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
                    }
                    Message.obtain(take.inflater.mHandler, 0, take).sendToTarget();
                } catch (InterruptedException e2) {
                    Log.w(AsyncLayoutInflater.TAG, e2);
                }
            }
        }

        public void enqueue(InflateRequest inflateRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, inflateRequest) == null) {
                try {
                    this.mQueue.put(inflateRequest);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Failed to enqueue async inflate request", e);
                }
            }
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inflateRequest) == null) {
                inflateRequest.callback = null;
                inflateRequest.inflater = null;
                inflateRequest.parent = null;
                inflateRequest.resid = 0;
                inflateRequest.f1049view = null;
                this.mRequestPool.release(inflateRequest);
            }
        }
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandlerCallback = new Handler.Callback(this) { // from class: androidx.asynclayoutinflater.view.AsyncLayoutInflater.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AsyncLayoutInflater this$0;

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

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    InflateRequest inflateRequest = (InflateRequest) message.obj;
                    if (inflateRequest.f1049view == null) {
                        inflateRequest.f1049view = this.this$0.mInflater.inflate(inflateRequest.resid, inflateRequest.parent, false);
                    }
                    inflateRequest.callback.onInflateFinished(inflateRequest.f1049view, inflateRequest.resid, inflateRequest.parent);
                    this.this$0.mInflateThread.releaseRequest(inflateRequest);
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        this.mInflater = new BasicInflater(context);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    @UiThread
    public void inflate(@LayoutRes int i, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, viewGroup, onInflateFinishedListener) == null) {
            if (onInflateFinishedListener != null) {
                InflateRequest obtainRequest = this.mInflateThread.obtainRequest();
                obtainRequest.inflater = this;
                obtainRequest.resid = i;
                obtainRequest.parent = viewGroup;
                obtainRequest.callback = onInflateFinishedListener;
                this.mInflateThread.enqueue(obtainRequest);
                return;
            }
            throw new NullPointerException("callback argument may not be null!");
        }
    }
}
