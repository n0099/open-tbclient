package com.baidu.mobads.container.util;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class ViewVisibilityUtil implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INTERVAL_MILLIS = 500;
    public static final int MSG_CHECK_VIEW_STATE = 1;
    public static final int PERCENT_VISIBLE = 50;
    public static final int STATE_INVISIBLE = 0;
    public static final int STATE_REMOVED = -1;
    public static final int STATE_VISIBLE = 1;
    public static HandlerThread mHandlerThread;
    public static ViewVisibilityUtil mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<WeakReference<View>, WeakReference<OnViewVisibleChangedListener>> mTotalViewHashMap;
    public Handler mUiHandler;
    public ConcurrentHashMap<WeakReference<View>, Integer> mViewStateHashMap;
    public Handler mVisibleMonitor;

    /* loaded from: classes2.dex */
    public interface OnViewVisibleChangedListener {
        void onViewVisibleChange(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(767129780, "Lcom/baidu/mobads/container/util/ViewVisibilityUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(767129780, "Lcom/baidu/mobads/container/util/ViewVisibilityUtil;");
                return;
            }
        }
        mHandlerThread = new HandlerThread("mobads-msg-thread");
    }

    public ViewVisibilityUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTotalViewHashMap = new ConcurrentHashMap<>();
        this.mViewStateHashMap = new ConcurrentHashMap<>();
    }

    private void checkViewState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Iterator<Map.Entry<WeakReference<View>, WeakReference<OnViewVisibleChangedListener>>> it = this.mTotalViewHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<WeakReference<View>, WeakReference<OnViewVisibleChangedListener>> next = it.next();
                WeakReference<View> key = next.getKey();
                Integer num = this.mViewStateHashMap.get(key);
                View view = key.get();
                if (view != null && num != null && num.intValue() != -1) {
                    OnViewVisibleChangedListener onViewVisibleChangedListener = next.getValue().get();
                    if (onViewVisibleChangedListener != null) {
                        if (isVisible(view)) {
                            Integer put = this.mViewStateHashMap.put(key, 1);
                            if (put == null) {
                                RemoteXAdLogger.getInstance().i("View init state gets lost.");
                            } else if (put.intValue() == 0) {
                                postListenerOnUiThread(onViewVisibleChangedListener, true);
                            }
                        } else {
                            Integer put2 = this.mViewStateHashMap.put(key, 0);
                            if (put2 == null) {
                                RemoteXAdLogger.getInstance().i("View init state gets lost.");
                            } else if (put2.intValue() == 1) {
                                postListenerOnUiThread(onViewVisibleChangedListener, false);
                            }
                        }
                    }
                } else {
                    it.remove();
                    this.mViewStateHashMap.remove(key);
                }
            }
            if (this.mTotalViewHashMap.size() > 0) {
                this.mVisibleMonitor.sendEmptyMessageDelayed(1, 500L);
            }
        }
    }

    public static ViewVisibilityUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mInstance == null) {
                synchronized (ViewVisibilityUtil.class) {
                    if (mInstance == null) {
                        ViewVisibilityUtil viewVisibilityUtil = new ViewVisibilityUtil();
                        mInstance = viewVisibilityUtil;
                        viewVisibilityUtil.initMonitor();
                    }
                }
            }
            return mInstance;
        }
        return (ViewVisibilityUtil) invokeV.objValue;
    }

    private void initMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (this.mVisibleMonitor == null) {
                if (!mHandlerThread.isAlive()) {
                    mHandlerThread.start();
                }
                this.mVisibleMonitor = new Handler(mHandlerThread.getLooper(), this);
            }
            if (this.mUiHandler == null) {
                this.mUiHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    public static boolean isVisible(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, view)) == null) {
            if (view == null || !view.isShown()) {
                return false;
            }
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                long height = rect.height() * rect.width();
                long height2 = view.getHeight() * view.getWidth();
                return height2 > 0 && height * 100 >= height2 * 50;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void postListenerOnUiThread(OnViewVisibleChangedListener onViewVisibleChangedListener, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, onViewVisibleChangedListener, z) == null) || onViewVisibleChangedListener == null) {
            return;
        }
        this.mUiHandler.post(new Runnable(this, onViewVisibleChangedListener, z) { // from class: com.baidu.mobads.container.util.ViewVisibilityUtil.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewVisibilityUtil this$0;
            public final /* synthetic */ OnViewVisibleChangedListener val$l;
            public final /* synthetic */ boolean val$value;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, onViewVisibleChangedListener, Boolean.valueOf(z)};
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
                this.val$l = onViewVisibleChangedListener;
                this.val$value = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.val$l.onViewVisibleChange(this.val$value);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message.what == 1) {
                mInstance.checkViewState();
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void registerView(View view, OnViewVisibleChangedListener onViewVisibleChangedListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, onViewVisibleChangedListener) == null) || view == null || onViewVisibleChangedListener == null) {
            return;
        }
        if (this.mVisibleMonitor.hasMessages(1)) {
            this.mVisibleMonitor.removeMessages(1);
        }
        WeakReference<View> weakReference = new WeakReference<>(view);
        this.mTotalViewHashMap.put(weakReference, new WeakReference<>(onViewVisibleChangedListener));
        this.mViewStateHashMap.put(weakReference, 0);
        this.mVisibleMonitor.sendEmptyMessage(1);
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTotalViewHashMap.clear();
            this.mViewStateHashMap.clear();
        }
    }

    public void unregisterView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null) {
            return;
        }
        if (this.mVisibleMonitor.hasMessages(1)) {
            this.mVisibleMonitor.removeMessages(1);
        }
        for (Map.Entry<WeakReference<View>, Integer> entry : this.mViewStateHashMap.entrySet()) {
            WeakReference<View> key = entry.getKey();
            if (key.get() == view) {
                this.mViewStateHashMap.put(key, -1);
            }
        }
        this.mVisibleMonitor.sendEmptyMessage(1);
    }
}
