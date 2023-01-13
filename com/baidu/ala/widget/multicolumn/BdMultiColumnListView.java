package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.co;
import com.baidu.tieba.gl;
import com.baidu.tieba.k3a;
import com.baidu.tieba.lo;
import com.baidu.tieba.mn;
import com.baidu.tieba.nn;
import com.baidu.tieba.pn;
import com.baidu.tieba.qn;
import com.baidu.tieba.x9;
import com.baidu.tieba.y9;
import com.baidu.tieba.zn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdMultiColumnListView extends MultiColumnListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REFRESH_DELAY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSimplePreLoadListAdapter mBdListAdpter;
    public Runnable mDelayedRunnable;
    public int mFirstVisibleItemIndex;
    public int mLastAddPosition;
    public int mLastLoadCount;
    public mn mNextPage;
    public View mNoDataView;
    public OnFooterClickListener mOnFooterClickListener;
    public OnHeaderClickListener mOnHeaderClickListener;
    public PLA_AdapterView.d mOnItemClickListener;
    public PLA_AdapterView.e mOnItemLongClickListener;
    public PLA_AdapterView.f mOnItemSelectedListener;
    public OnItemWillVisibleListener mOnItemWillVisibleListener;
    public PLA_AbsListView.e mOnScrollListener;
    public OnScrollStopDelayedListener mOnScrollStopDelayedListener;
    public long mOnScrollStopDelayedMillis;
    public OnScrollToBottomListener mOnScrollToBottomListener;
    public OnScrollToPullListener mOnScrollToPullListener;
    public OnScrollToTopListener mOnScrollToTopListener;
    public co mPreLoadListView;
    public int mPreLoadNum;
    public mn mPrePage;
    public PullRefresh mPullRefresh;
    public int mScrollToTopNum;
    public Runnable preLoadRunnable;
    public Runnable refreshRunnable;

    /* loaded from: classes.dex */
    public interface OnFooterClickListener {
        void onClick(View view2);
    }

    /* loaded from: classes.dex */
    public interface OnHeaderClickListener {
        void onClick(View view2);
    }

    /* loaded from: classes.dex */
    public interface OnItemWillVisibleListener {
        void onItemWillVisible(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnScrollStopDelayedListener {
        void onScrollStop(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface OnScrollToPullListener {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnScrollToTopListener {
        void onScrollToTop();
    }

    /* loaded from: classes.dex */
    public static class PullRefresh {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_REFRESH_DURATION_TIME = 800;
        public static final int DONE = 3;
        public static final int PULL_TO_REFRESH = 1;
        public static final int REFRESHING = 2;
        public static final int RELEASE_TO_REFRESH = 0;
        public static float sRatio = 3.0f;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAnimDurationTime;
        public nn mBdIListPullView;
        public Boolean mIsBack;
        public boolean mIsRecored;
        public BdMultiColumnListView mListView;
        public OnScrollToPullListener mOnScrollToPullListener;
        public int mStartY;
        public int mState;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-646918371, "Lcom/baidu/ala/widget/multicolumn/BdMultiColumnListView$PullRefresh;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-646918371, "Lcom/baidu/ala/widget/multicolumn/BdMultiColumnListView$PullRefresh;");
            }
        }

        public PullRefresh(BdMultiColumnListView bdMultiColumnListView, nn nnVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMultiColumnListView, nnVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mBdIListPullView = null;
            this.mIsRecored = false;
            this.mStartY = 0;
            this.mState = 3;
            this.mListView = null;
            this.mIsBack = Boolean.FALSE;
            this.mOnScrollToPullListener = null;
            this.mAnimDurationTime = 800;
            if (nnVar != null) {
                if (bdMultiColumnListView != null) {
                    this.mBdIListPullView = nnVar;
                    this.mListView = bdMultiColumnListView;
                    View view2 = nnVar.getView();
                    view2.setPadding(0, -this.mBdIListPullView.p(), 0, 0);
                    view2.invalidate();
                    this.mListView.addPullRefreshView(view2);
                    return;
                }
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            throw new InvalidParameterException("PullRefresh view is null");
        }

        public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, onScrollToPullListener) == null) {
                this.mOnScrollToPullListener = onScrollToPullListener;
            }
        }

        public void startPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.mState = 2;
                this.mBdIListPullView.C(0, 0, 0, 0);
                this.mBdIListPullView.x();
                this.mBdIListPullView.u(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void animatePullView() {
            nn bdIListPullView;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || (bdIListPullView = getBdIListPullView()) == null || (view2 = bdIListPullView.getView()) == null) {
                return;
            }
            qn qnVar = new qn(view2.getContext(), 0, -bdIListPullView.p(), this.mAnimDurationTime);
            qnVar.d(new lo(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.PullRefresh.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PullRefresh this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.lo
                public void onOver() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.done();
                    }
                }
            });
            qnVar.f(view2);
        }

        public void done() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mState = 3;
                nn nnVar = this.mBdIListPullView;
                nnVar.C(0, -nnVar.p(), 0, 0);
                this.mBdIListPullView.o(true);
                OnScrollToPullListener onScrollToPullListener = this.mOnScrollToPullListener;
                if (onScrollToPullListener != null) {
                    onScrollToPullListener.onScrollToPull(false);
                }
            }
        }

        public nn getBdIListPullView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mBdIListPullView;
            }
            return (nn) invokeV.objValue;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, motionEvent, i) == null) && motionEvent.getAction() == 0 && getBdIListPullView().q()) {
                this.mIsRecored = false;
                this.mIsBack = Boolean.FALSE;
                if (i == 0 && 0 == 0 && this.mListView.getChildAt(0) != null && this.mListView.getChildAt(0).getTop() >= 0) {
                    this.mIsRecored = true;
                    this.mStartY = (int) motionEvent.getY();
                }
            }
        }

        public void onTouchEvent(MotionEvent motionEvent, int i) {
            OnScrollToPullListener onScrollToPullListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048579, this, motionEvent, i) == null) && getBdIListPullView().q()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return;
                        }
                    } else {
                        int y = (int) motionEvent.getY();
                        if (!this.mIsRecored && i == 0 && this.mListView.getChildAt(0) != null && this.mListView.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        int i2 = this.mState;
                        if (i2 != 2 && this.mIsRecored) {
                            if (i2 == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) < this.mBdIListPullView.p() && y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.w(this.mIsBack.booleanValue());
                                    this.mIsBack = Boolean.FALSE;
                                    OnScrollToPullListener onScrollToPullListener2 = this.mOnScrollToPullListener;
                                    if (onScrollToPullListener2 != null) {
                                        onScrollToPullListener2.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    nn nnVar = this.mBdIListPullView;
                                    nnVar.C(0, -nnVar.p(), 0, 0);
                                    this.mBdIListPullView.o(false);
                                    OnScrollToPullListener onScrollToPullListener3 = this.mOnScrollToPullListener;
                                    if (onScrollToPullListener3 != null) {
                                        onScrollToPullListener3.onScrollToPull(true);
                                    }
                                }
                            } else if (i2 == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) >= this.mBdIListPullView.p()) {
                                    this.mState = 0;
                                    this.mIsBack = Boolean.TRUE;
                                    this.mBdIListPullView.y();
                                    OnScrollToPullListener onScrollToPullListener4 = this.mOnScrollToPullListener;
                                    if (onScrollToPullListener4 != null) {
                                        onScrollToPullListener4.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    nn nnVar2 = this.mBdIListPullView;
                                    nnVar2.C(0, -nnVar2.p(), 0, 0);
                                    this.mBdIListPullView.o(false);
                                    OnScrollToPullListener onScrollToPullListener5 = this.mOnScrollToPullListener;
                                    if (onScrollToPullListener5 != null) {
                                        onScrollToPullListener5.onScrollToPull(true);
                                    }
                                }
                            } else if (i2 == 3) {
                                if (y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.w(this.mIsBack.booleanValue());
                                    this.mIsBack = Boolean.FALSE;
                                    OnScrollToPullListener onScrollToPullListener6 = this.mOnScrollToPullListener;
                                    if (onScrollToPullListener6 != null) {
                                        onScrollToPullListener6.onScrollToPull(true);
                                    }
                                } else {
                                    OnScrollToPullListener onScrollToPullListener7 = this.mOnScrollToPullListener;
                                    if (onScrollToPullListener7 != null) {
                                        onScrollToPullListener7.onScrollToPull(false);
                                    }
                                }
                            }
                            int i3 = this.mState;
                            if (i3 == 1 || i3 == 0) {
                                nn nnVar3 = this.mBdIListPullView;
                                nnVar3.C(0, ((int) ((y - this.mStartY) / sRatio)) - nnVar3.p(), 0, 0);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                int i4 = this.mState;
                if (i4 != 2) {
                    if (i4 == 1) {
                        this.mState = 3;
                        nn nnVar4 = this.mBdIListPullView;
                        nnVar4.C(0, -nnVar4.p(), 0, 0);
                        this.mBdIListPullView.o(false);
                        OnScrollToPullListener onScrollToPullListener8 = this.mOnScrollToPullListener;
                        if (onScrollToPullListener8 != null) {
                            onScrollToPullListener8.onScrollToPull(true);
                        }
                    } else if (i4 == 0) {
                        startPullRefresh(false);
                        OnScrollToPullListener onScrollToPullListener9 = this.mOnScrollToPullListener;
                        if (onScrollToPullListener9 != null) {
                            onScrollToPullListener9.onScrollToPull(true);
                        }
                    } else if (i4 == 3 && (onScrollToPullListener = this.mOnScrollToPullListener) != null) {
                        onScrollToPullListener.onScrollToPull(false);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiColumnListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBdListAdpter = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollListener = null;
        this.mOnScrollStopDelayedListener = null;
        this.mOnScrollToPullListener = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.mOnScrollToTopListener = null;
        this.mScrollToTopNum = 0;
        this.mOnScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = this.this$0.getFirstVisiblePosition();
                    int lastVisiblePosition = this.this$0.getLastVisiblePosition();
                    int i3 = 0;
                    int i4 = -1;
                    if (this.this$0.mAdapter instanceof k3a) {
                        int c = firstVisiblePosition - ((k3a) this.this$0.mAdapter).c();
                        if (c < 0) {
                            i4 = 0;
                        } else {
                            i4 = c;
                        }
                        int c2 = lastVisiblePosition - ((k3a) this.this$0.mAdapter).c();
                        if (c2 >= this.this$0.mAdapter.getCount()) {
                            c2 = this.this$0.mAdapter.getCount() - 1;
                        }
                        if (c2 >= 0) {
                            i3 = c2;
                        }
                    } else {
                        i3 = -1;
                    }
                    this.this$0.mOnScrollStopDelayedListener.onScrollStop(i4, i3);
                }
            }
        };
        this.mPreLoadListView = new co(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

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

            @Override // com.baidu.tieba.co
            public void cancelRefresh() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BdMultiColumnListView bdMultiColumnListView = this.this$0;
                    bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                }
            }

            @Override // com.baidu.tieba.co
            public zn getAdapter() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                    return (zn) invokeV.objValue;
                }
                return this.this$0.mBdListAdpter;
            }

            @Override // com.baidu.tieba.co
            public int getFirstVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.this$0.getFirstVisiblePosition();
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.tieba.co
            public int getLastVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return this.this$0.getLastVisiblePosition();
                }
                return invokeV.intValue;
            }
        };
        this.refreshRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

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

            private void refreshImage(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(65537, this, view2) != null) || view2 == null) {
                    return;
                }
                if (view2 instanceof gl) {
                    ((gl) view2).refresh();
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        refreshImage(viewGroup.getChildAt(i3));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.this$0.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        refreshImage(this.this$0.getChildAt(i3));
                    }
                    x9 c = y9.c(this.this$0.getContext());
                    if (c != null) {
                        c.onPreLoad(this.this$0.mPreLoadListView);
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                x9 c;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (c = y9.c(this.this$0.getContext())) != null) {
                    c.onPreLoad(this.this$0.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiColumnListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBdListAdpter = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollListener = null;
        this.mOnScrollStopDelayedListener = null;
        this.mOnScrollToPullListener = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.mOnScrollToTopListener = null;
        this.mScrollToTopNum = 0;
        this.mOnScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = this.this$0.getFirstVisiblePosition();
                    int lastVisiblePosition = this.this$0.getLastVisiblePosition();
                    int i3 = 0;
                    int i4 = -1;
                    if (this.this$0.mAdapter instanceof k3a) {
                        int c = firstVisiblePosition - ((k3a) this.this$0.mAdapter).c();
                        if (c < 0) {
                            i4 = 0;
                        } else {
                            i4 = c;
                        }
                        int c2 = lastVisiblePosition - ((k3a) this.this$0.mAdapter).c();
                        if (c2 >= this.this$0.mAdapter.getCount()) {
                            c2 = this.this$0.mAdapter.getCount() - 1;
                        }
                        if (c2 >= 0) {
                            i3 = c2;
                        }
                    } else {
                        i3 = -1;
                    }
                    this.this$0.mOnScrollStopDelayedListener.onScrollStop(i4, i3);
                }
            }
        };
        this.mPreLoadListView = new co(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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

            @Override // com.baidu.tieba.co
            public void cancelRefresh() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BdMultiColumnListView bdMultiColumnListView = this.this$0;
                    bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                }
            }

            @Override // com.baidu.tieba.co
            public zn getAdapter() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                    return (zn) invokeV.objValue;
                }
                return this.this$0.mBdListAdpter;
            }

            @Override // com.baidu.tieba.co
            public int getFirstVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.this$0.getFirstVisiblePosition();
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.tieba.co
            public int getLastVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return this.this$0.getLastVisiblePosition();
                }
                return invokeV.intValue;
            }
        };
        this.refreshRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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

            private void refreshImage(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(65537, this, view2) != null) || view2 == null) {
                    return;
                }
                if (view2 instanceof gl) {
                    ((gl) view2).refresh();
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        refreshImage(viewGroup.getChildAt(i3));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.this$0.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        refreshImage(this.this$0.getChildAt(i3));
                    }
                    x9 c = y9.c(this.this$0.getContext());
                    if (c != null) {
                        c.onPreLoad(this.this$0.mPreLoadListView);
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
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

            @Override // java.lang.Runnable
            public void run() {
                x9 c;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (c = y9.c(this.this$0.getContext())) != null) {
                    c.onPreLoad(this.this$0.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiColumnListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mBdListAdpter = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollListener = null;
        this.mOnScrollStopDelayedListener = null;
        this.mOnScrollToPullListener = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.mOnScrollToTopListener = null;
        this.mScrollToTopNum = 0;
        this.mOnScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = this.this$0.getFirstVisiblePosition();
                    int lastVisiblePosition = this.this$0.getLastVisiblePosition();
                    int i32 = 0;
                    int i4 = -1;
                    if (this.this$0.mAdapter instanceof k3a) {
                        int c = firstVisiblePosition - ((k3a) this.this$0.mAdapter).c();
                        if (c < 0) {
                            i4 = 0;
                        } else {
                            i4 = c;
                        }
                        int c2 = lastVisiblePosition - ((k3a) this.this$0.mAdapter).c();
                        if (c2 >= this.this$0.mAdapter.getCount()) {
                            c2 = this.this$0.mAdapter.getCount() - 1;
                        }
                        if (c2 >= 0) {
                            i32 = c2;
                        }
                    } else {
                        i32 = -1;
                    }
                    this.this$0.mOnScrollStopDelayedListener.onScrollStop(i4, i32);
                }
            }
        };
        this.mPreLoadListView = new co(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.co
            public void cancelRefresh() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BdMultiColumnListView bdMultiColumnListView = this.this$0;
                    bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                }
            }

            @Override // com.baidu.tieba.co
            public zn getAdapter() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                    return (zn) invokeV.objValue;
                }
                return this.this$0.mBdListAdpter;
            }

            @Override // com.baidu.tieba.co
            public int getFirstVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.this$0.getFirstVisiblePosition();
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.tieba.co
            public int getLastVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return this.this$0.getLastVisiblePosition();
                }
                return invokeV.intValue;
            }
        };
        this.refreshRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void refreshImage(View view2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(65537, this, view2) != null) || view2 == null) {
                    return;
                }
                if (view2 instanceof gl) {
                    ((gl) view2).refresh();
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i32 = 0; i32 < childCount; i32++) {
                        refreshImage(viewGroup.getChildAt(i32));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.this$0.getChildCount();
                    for (int i32 = 0; i32 < childCount; i32++) {
                        refreshImage(this.this$0.getChildAt(i32));
                    }
                    x9 c = y9.c(this.this$0.getContext());
                    if (c != null) {
                        c.onPreLoad(this.this$0.mPreLoadListView);
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdMultiColumnListView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                x9 c;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (c = y9.c(this.this$0.getContext())) != null) {
                    c.onPreLoad(this.this$0.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public void addPullRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            addHeaderView(view2, null, false, 0);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null) {
                pullRefresh.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null) {
                pullRefresh.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setNextPage(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mnVar) == null) {
            mn mnVar2 = this.mNextPage;
            if (mnVar2 != null) {
                removeFooterView(mnVar2.c());
                this.mNextPage = null;
            }
            if (mnVar != null) {
                addFooterView(mnVar.c(), null, true, 0);
                this.mNextPage = mnVar;
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemClickListener(PLA_AdapterView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.mOnItemClickListener = dVar;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemLongClickListener(PLA_AdapterView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            if (eVar == null) {
                super.setOnItemLongClickListener(null);
                return;
            }
            this.mOnItemLongClickListener = eVar;
            super.setOnItemLongClickListener(new PLA_AdapterView.e(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
                public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j) {
                    InterceptResult invokeCommon;
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                        if (this.this$0.mAdapter instanceof k3a) {
                            i2 = ((k3a) this.this$0.mAdapter).c();
                        } else {
                            i2 = 0;
                        }
                        if (i < i2) {
                            return true;
                        }
                        int i3 = i - i2;
                        ListAdapter listAdapter = this.this$0.mAdapter;
                        if (listAdapter == null || i3 >= listAdapter.getCount()) {
                            return true;
                        }
                        if (this.this$0.mOnItemLongClickListener == null) {
                            return false;
                        }
                        return this.this$0.mOnItemLongClickListener.onItemLongClick(pLA_AdapterView, view2, i3, j);
                    }
                    return invokeCommon.booleanValue;
                }
            });
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemSelectedListener(PLA_AdapterView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            if (fVar == null) {
                super.setOnItemSelectedListener(null);
                return;
            }
            this.mOnItemSelectedListener = fVar;
            super.setOnItemSelectedListener(new PLA_AdapterView.f(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.f
                public void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pLA_AdapterView) == null) && this.this$0.mOnItemSelectedListener != null) {
                        this.this$0.mOnItemSelectedListener.onNothingSelected(pLA_AdapterView);
                    }
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.f
                public void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j) {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        if (this.this$0.mAdapter instanceof k3a) {
                            i2 = ((k3a) this.this$0.mAdapter).c();
                        } else {
                            i2 = 0;
                        }
                        if (i < i2) {
                            return;
                        }
                        int i3 = i - i2;
                        ListAdapter wrappedAdapter = this.this$0.mBdListAdpter.getWrappedAdapter();
                        if (wrappedAdapter != null && i3 < wrappedAdapter.getCount() && this.this$0.mOnItemSelectedListener != null) {
                            this.this$0.mOnItemSelectedListener.onItemSelected(pLA_AdapterView, view2, i3, j);
                        }
                    }
                }
            });
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setOnScrollListener(PLA_AbsListView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.mOnScrollListener = eVar;
        }
    }

    public void setOnSrollToBottomListener(OnScrollToBottomListener onScrollToBottomListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onScrollToBottomListener) == null) {
            this.mOnScrollToBottomListener = onScrollToBottomListener;
        }
    }

    public void setPullRefresh(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nnVar) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null) {
                removeHeaderView(pullRefresh.getBdIListPullView().getView());
            }
            this.mPullRefresh = null;
            if (nnVar != null) {
                PullRefresh pullRefresh2 = new PullRefresh(this, nnVar);
                this.mPullRefresh = pullRefresh2;
                pullRefresh2.setOnScrollToPullListener(this.mOnScrollToPullListener);
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void setSelectionFromTop(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            super.setSelectionFromTop(i, i2);
        }
    }

    private void initial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            setFadingEdgeLength(0);
            BdSimplePreLoadListAdapter bdSimplePreLoadListAdapter = new BdSimplePreLoadListAdapter();
            this.mBdListAdpter = bdSimplePreLoadListAdapter;
            bdSimplePreLoadListAdapter.setListPreLoad(new pn.b(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.pn.b
                public void onPreLoad() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BdMultiColumnListView bdMultiColumnListView = this.this$0;
                        bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.preLoadRunnable);
                        BdMultiColumnListView bdMultiColumnListView2 = this.this$0;
                        bdMultiColumnListView2.postDelayed(bdMultiColumnListView2.preLoadRunnable, 100L);
                    }
                }
            });
            super.setOnItemClickListener(new PLA_AdapterView.d(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
                public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j) {
                    int i2;
                    ListAdapter listAdapter;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                        if (this.this$0.mAdapter instanceof k3a) {
                            i2 = ((k3a) this.this$0.mAdapter).c();
                        } else {
                            i2 = 0;
                        }
                        if (i < i2) {
                            if (this.this$0.mPrePage != null && view2 == this.this$0.mPrePage.c()) {
                                this.this$0.mPrePage.d();
                                return;
                            } else if (this.this$0.mOnHeaderClickListener != null) {
                                this.this$0.mOnHeaderClickListener.onClick(view2);
                                return;
                            } else {
                                return;
                            }
                        }
                        int i3 = i - i2;
                        if (this.this$0.mAdapter instanceof k3a) {
                            listAdapter = ((k3a) this.this$0.mAdapter).getWrappedAdapter();
                        } else {
                            listAdapter = this.this$0.mAdapter;
                        }
                        if (listAdapter != null && i3 < listAdapter.getCount()) {
                            if (this.this$0.mOnItemClickListener != null) {
                                this.this$0.mOnItemClickListener.onItemClick(pLA_AdapterView, view2, i3, j);
                            }
                        } else if (this.this$0.mNextPage != null && view2 == this.this$0.mNextPage.c()) {
                            this.this$0.mNextPage.d();
                        } else if (this.this$0.mOnFooterClickListener != null) {
                            this.this$0.mOnFooterClickListener.onClick(view2);
                        }
                    }
                }
            });
            super.setOnScrollListener(new PLA_AbsListView.e(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
                public void onScroll(PLA_AbsListView pLA_AbsListView, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLIII(1048576, this, pLA_AbsListView, i, i2, i3) != null) {
                        return;
                    }
                    this.this$0.mFirstVisibleItemIndex = i;
                    if (this.this$0.mOnScrollListener != null) {
                        this.this$0.mOnScrollListener.onScroll(pLA_AbsListView, i, i2, i3);
                    }
                    if (this.this$0.mOnScrollStopDelayedListener != null && this.this$0.mOnScrollStopDelayedMillis > 0 && this.this$0.getHandler() != null) {
                        this.this$0.getHandler().removeCallbacks(this.this$0.mDelayedRunnable);
                        this.this$0.getHandler().postDelayed(this.this$0.mDelayedRunnable, this.this$0.mOnScrollStopDelayedMillis);
                    }
                }

                @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
                public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pLA_AbsListView, i) == null) {
                        x9 c = y9.c(this.this$0.getContext());
                        if (c != null) {
                            if (i == 2) {
                                BdMultiColumnListView bdMultiColumnListView = this.this$0;
                                bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                                c.setIsScroll(true);
                            } else if (c.isScroll()) {
                                c.setIsScroll(false);
                                BdMultiColumnListView bdMultiColumnListView2 = this.this$0;
                                bdMultiColumnListView2.removeCallbacks(bdMultiColumnListView2.refreshRunnable);
                                BdMultiColumnListView bdMultiColumnListView3 = this.this$0;
                                bdMultiColumnListView3.postDelayed(bdMultiColumnListView3.refreshRunnable, 100L);
                            } else if (i == 0) {
                                BdMultiColumnListView bdMultiColumnListView4 = this.this$0;
                                bdMultiColumnListView4.removeCallbacks(bdMultiColumnListView4.preLoadRunnable);
                                BdMultiColumnListView bdMultiColumnListView5 = this.this$0;
                                bdMultiColumnListView5.postDelayed(bdMultiColumnListView5.preLoadRunnable, 100L);
                            }
                        }
                        if (this.this$0.mOnScrollListener != null) {
                            this.this$0.mOnScrollListener.onScrollStateChanged(pLA_AbsListView, i);
                        }
                        if (i == 0) {
                            if (this.this$0.mOnScrollToBottomListener != null && pLA_AbsListView.getLastVisiblePosition() == pLA_AbsListView.getCount() - 1 && pLA_AbsListView.getFirstVisiblePosition() != 0) {
                                this.this$0.mOnScrollToBottomListener.onScrollToBottom();
                            }
                            if (this.this$0.mOnScrollToTopListener != null && pLA_AbsListView.getFirstVisiblePosition() <= this.this$0.mScrollToTopNum) {
                                this.this$0.mOnScrollToTopListener.onScrollToTop();
                            }
                        }
                    }
                }
            });
        }
    }

    public void completePullRefresh() {
        PullRefresh pullRefresh;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pullRefresh = this.mPullRefresh) != null) {
            if (pullRefresh.getBdIListPullView() != null) {
                this.mPullRefresh.mBdIListPullView.t();
            }
            this.mPullRefresh.animatePullView();
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.mPullRefresh != null) {
            setSelection(0);
            this.mPullRefresh.startPullRefresh(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBdListAdpter;
        }
        return (ListAdapter) invokeV.objValue;
    }

    @Override // com.huewu.pla.lib.MultiColumnListView, com.huewu.pla.lib.internal.PLA_ListView
    public void onItemAddedToList(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            super.onItemAddedToList(i, z);
            if (this.mOnItemWillVisibleListener != null) {
                boolean z2 = false;
                if (!z ? i == getFirstVisiblePosition() : !(getFirstVisiblePosition() == 0 || i - getHeaderViewsCount() != getLastVisiblePosition() || i <= this.mLastAddPosition)) {
                    z2 = true;
                }
                if (z2) {
                    this.mOnItemWillVisibleListener.onItemWillVisible(i - getHeaderViewsCount(), z);
                    this.mLastAddPosition = i;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listAdapter) == null) {
            super.setAdapter(listAdapter);
            this.mBdListAdpter.setAdaper(this.mAdapter);
        }
    }
}
