package com.baidu.searchbox.ui.animview.util;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PraiseTouchInterceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "PraiseTouchInterceptor";
    public transient /* synthetic */ FieldHolder $fh;
    public View mHostView;
    public boolean mIntercepted;
    public int mLastPraiseAnimState;
    public boolean mNeedToRestoreClickable;
    public boolean mOriginClickable;
    public int mPraiseAnimState;
    public Object mPraiseAnimeObj;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1530794820, "Lcom/baidu/searchbox/ui/animview/util/PraiseTouchInterceptor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1530794820, "Lcom/baidu/searchbox/ui/animview/util/PraiseTouchInterceptor;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    public PraiseTouchInterceptor() {
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
        this.mPraiseAnimeObj = new Object();
        this.mPraiseAnimState = -1;
        this.mLastPraiseAnimState = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, motionEvent)) == null) ? performIntercept(motionEvent) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleTouchEventForListView(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                if (this.mNeedToRestoreClickable) {
                    this.mHostView.setClickable(this.mOriginClickable);
                    this.mNeedToRestoreClickable = false;
                }
                this.mIntercepted = false;
            }
            return this.mIntercepted;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    private boolean performIntercept(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, motionEvent)) == null) {
            if (this.mHostView == null) {
                return false;
            }
            if (DEBUG) {
                String str = this.mHostView.getClass().getSimpleName() + ": onTouchEvent " + MotionEvent.actionToString(motionEvent.getAction());
            }
            if (this.mPraiseAnimState == 1) {
                if (motionEvent.getAction() == 0) {
                    View view = this.mHostView;
                    if (view instanceof ViewGroup) {
                        ((ViewGroup) view).requestDisallowInterceptTouchEvent(true);
                    }
                    View view2 = this.mHostView;
                    if (view2 instanceof ListView) {
                        this.mOriginClickable = view2.isClickable();
                        this.mNeedToRestoreClickable = true;
                        this.mHostView.setClickable(false);
                    }
                }
                this.mIntercepted = true;
                if (DEBUG) {
                    String str2 = this.mHostView.getClass().getSimpleName() + ": disable 1, onTouchEvent " + MotionEvent.actionToString(motionEvent.getAction());
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void registerPraiseStateEvent() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.mHostView == null) {
            return;
        }
        BdEventBus.Companion.getDefault().register(this.mPraiseAnimeObj, CoolPraiseView.PraiseAnimState.class, 1, new Action<CoolPraiseView.PraiseAnimState>(this) { // from class: com.baidu.searchbox.ui.animview.util.PraiseTouchInterceptor.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PraiseTouchInterceptor this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(CoolPraiseView.PraiseAnimState praiseAnimState) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, praiseAnimState) == null) {
                    PraiseTouchInterceptor praiseTouchInterceptor = this.this$0;
                    praiseTouchInterceptor.mLastPraiseAnimState = praiseTouchInterceptor.mPraiseAnimState;
                    this.this$0.mPraiseAnimState = praiseAnimState.getAnimState();
                    if (PraiseTouchInterceptor.DEBUG) {
                        String str = this.this$0.mHostView.getClass().getSimpleName() + ": mLastPraiseAnimState=" + this.this$0.mLastPraiseAnimState + ", mPraiseAnimState=" + this.this$0.mPraiseAnimState;
                    }
                }
            }
        });
    }

    private void unregisterPraiseStateEvent() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.mHostView == null) {
            return;
        }
        BdEventBus.Companion.getDefault().unregister(this.mPraiseAnimeObj);
    }

    public void attachView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            detachView();
            this.mHostView = view;
            registerPraiseStateEvent();
            View view2 = this.mHostView;
            if (view2 != null) {
                view2.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.searchbox.ui.animview.util.PraiseTouchInterceptor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PraiseTouchInterceptor this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) {
                            if (this.this$0.mHostView instanceof ListView) {
                                return this.this$0.handleTouchEventForListView(motionEvent);
                            }
                            return this.this$0.mHostView instanceof RecyclerView ? this.this$0.handleTouchEvent(motionEvent) : this.this$0.handleTouchEvent(motionEvent);
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
        }
    }

    public void detachView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View view = this.mHostView;
            if (view != null) {
                view.setOnTouchListener(null);
            }
            unregisterPraiseStateEvent();
            this.mNeedToRestoreClickable = false;
            this.mIntercepted = false;
            this.mHostView = null;
            this.mPraiseAnimState = -1;
            this.mLastPraiseAnimState = -1;
        }
    }

    public boolean handleInterceptTouchForListView(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) ? performIntercept(motionEvent) : invokeL.booleanValue;
    }
}
