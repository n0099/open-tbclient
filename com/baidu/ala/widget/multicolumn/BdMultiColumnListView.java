package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.i;
import c.a.e.a.j;
import c.a.e.f.a.h;
import c.a.e.l.e.b;
import c.a.e.l.e.c;
import c.a.e.l.e.e;
import c.a.e.l.e.f;
import c.a.e.l.e.o;
import c.a.e.l.e.q;
import c.a.e.l.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public class BdMultiColumnListView extends MultiColumnListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REFRESH_DELAY = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public BdSimplePreLoadListAdapter mBdListAdpter;
    public Runnable mDelayedRunnable;
    public int mFirstVisibleItemIndex;
    public boolean mIsPreLoad;
    public int mLastAddPosition;
    public int mLastLoadCount;
    public b mNextPage;
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
    public q mPreLoadListView;
    public int mPreLoadNum;
    public b mPrePage;
    public PullRefresh mPullRefresh;
    public int mScrollToTopNum;
    public Runnable preLoadRunnable;
    public Runnable refreshRunnable;

    /* loaded from: classes4.dex */
    public interface OnFooterClickListener {
        void onClick(View view);
    }

    /* loaded from: classes4.dex */
    public interface OnHeaderClickListener {
        void onClick(View view);
    }

    /* loaded from: classes4.dex */
    public interface OnItemWillVisibleListener {
        void onItemWillVisible(int i2, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface OnScrollStopDelayedListener {
        void onScrollStop(int i2, int i3);
    }

    /* loaded from: classes4.dex */
    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

    /* loaded from: classes4.dex */
    public interface OnScrollToPullListener {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface OnScrollToTopListener {
        void onScrollToTop();
    }

    /* loaded from: classes4.dex */
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
        public c mBdIListPullView;
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

        public PullRefresh(BdMultiColumnListView bdMultiColumnListView, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdMultiColumnListView, cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdMultiColumnListView != null) {
                this.mBdIListPullView = cVar;
                this.mListView = bdMultiColumnListView;
                View view = cVar.getView();
                view.setPadding(0, -this.mBdIListPullView.l(), 0, 0);
                view.invalidate();
                this.mListView.addPullRefreshView(view);
                return;
            }
            throw new InvalidParameterException("PullRefresh listView is null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void animatePullView() {
            c bdIListPullView;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (bdIListPullView = getBdIListPullView()) == null || (view = bdIListPullView.getView()) == null) {
                return;
            }
            f fVar = new f(view.getContext(), 0, -bdIListPullView.l(), this.mAnimDurationTime);
            fVar.d(new a(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.PullRefresh.1
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

                @Override // c.a.e.l.f.a
                public void onOver() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.done();
                    }
                }
            });
            fVar.f(view);
        }

        public static boolean setRatio(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.AD_TEXT_ID, null, f2)) == null) {
                if (f2 > 0.0f) {
                    sRatio = f2;
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }

        public void done() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mState = 3;
                c cVar = this.mBdIListPullView;
                cVar.y(0, -cVar.l(), 0, 0);
                this.mBdIListPullView.j(true);
                OnScrollToPullListener onScrollToPullListener = this.mOnScrollToPullListener;
                if (onScrollToPullListener != null) {
                    onScrollToPullListener.onScrollToPull(false);
                }
            }
        }

        public c getBdIListPullView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBdIListPullView : (c) invokeV.objValue;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, motionEvent, i2) == null) && motionEvent.getAction() == 0 && getBdIListPullView().m()) {
                this.mIsRecored = false;
                this.mIsBack = Boolean.FALSE;
                if (i2 != 0 || 0 != 0 || this.mListView.getChildAt(0) == null || this.mListView.getChildAt(0).getTop() < 0) {
                    return;
                }
                this.mIsRecored = true;
                this.mStartY = (int) motionEvent.getY();
            }
        }

        public void onTouchEvent(MotionEvent motionEvent, int i2) {
            OnScrollToPullListener onScrollToPullListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048579, this, motionEvent, i2) == null) && getBdIListPullView().m()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) motionEvent.getY();
                        if (!this.mIsRecored && i2 == 0 && this.mListView.getChildAt(0) != null && this.mListView.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        int i3 = this.mState;
                        if (i3 == 2 || !this.mIsRecored) {
                            return;
                        }
                        if (i3 == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / sRatio)) < this.mBdIListPullView.l() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.mBdIListPullView.s(this.mIsBack.booleanValue());
                                this.mIsBack = Boolean.FALSE;
                                OnScrollToPullListener onScrollToPullListener2 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener2 != null) {
                                    onScrollToPullListener2.onScrollToPull(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                c cVar = this.mBdIListPullView;
                                cVar.y(0, -cVar.l(), 0, 0);
                                this.mBdIListPullView.j(false);
                                OnScrollToPullListener onScrollToPullListener3 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener3 != null) {
                                    onScrollToPullListener3.onScrollToPull(true);
                                }
                            }
                        } else if (i3 == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / sRatio)) >= this.mBdIListPullView.l()) {
                                this.mState = 0;
                                this.mIsBack = Boolean.TRUE;
                                this.mBdIListPullView.u();
                                OnScrollToPullListener onScrollToPullListener4 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener4 != null) {
                                    onScrollToPullListener4.onScrollToPull(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                c cVar2 = this.mBdIListPullView;
                                cVar2.y(0, -cVar2.l(), 0, 0);
                                this.mBdIListPullView.j(false);
                                OnScrollToPullListener onScrollToPullListener5 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener5 != null) {
                                    onScrollToPullListener5.onScrollToPull(true);
                                }
                            }
                        } else if (i3 == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.mBdIListPullView.s(this.mIsBack.booleanValue());
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
                        int i4 = this.mState;
                        if (i4 == 1 || i4 == 0) {
                            c cVar3 = this.mBdIListPullView;
                            cVar3.y(0, ((int) ((y - this.mStartY) / sRatio)) - cVar3.l(), 0, 0);
                            return;
                        }
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                int i5 = this.mState;
                if (i5 != 2) {
                    if (i5 == 1) {
                        this.mState = 3;
                        c cVar4 = this.mBdIListPullView;
                        cVar4.y(0, -cVar4.l(), 0, 0);
                        this.mBdIListPullView.j(false);
                        OnScrollToPullListener onScrollToPullListener8 = this.mOnScrollToPullListener;
                        if (onScrollToPullListener8 != null) {
                            onScrollToPullListener8.onScrollToPull(true);
                        }
                    } else if (i5 != 0) {
                        if (i5 != 3 || (onScrollToPullListener = this.mOnScrollToPullListener) == null) {
                            return;
                        }
                        onScrollToPullListener.onScrollToPull(false);
                    } else {
                        startPullRefresh(false);
                        OnScrollToPullListener onScrollToPullListener9 = this.mOnScrollToPullListener;
                        if (onScrollToPullListener9 != null) {
                            onScrollToPullListener9.onScrollToPull(true);
                        }
                    }
                }
            }
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
                this.mBdIListPullView.y(0, 0, 0, 0);
                this.mBdIListPullView.t();
                this.mBdIListPullView.q(z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mOnScrollStopDelayedListener == null) {
                    return;
                }
                int firstVisiblePosition = this.this$0.getFirstVisiblePosition();
                int lastVisiblePosition = this.this$0.getLastVisiblePosition();
                int i4 = 0;
                int i5 = -1;
                if (this.this$0.mAdapter instanceof c.k.a.a.b.a) {
                    int c2 = firstVisiblePosition - ((c.k.a.a.b.a) this.this$0.mAdapter).c();
                    i5 = c2 < 0 ? 0 : c2;
                    int c3 = lastVisiblePosition - ((c.k.a.a.b.a) this.this$0.mAdapter).c();
                    if (c3 >= this.this$0.mAdapter.getCount()) {
                        c3 = this.this$0.mAdapter.getCount() - 1;
                    }
                    if (c3 >= 0) {
                        i4 = c3;
                    }
                } else {
                    i4 = -1;
                }
                this.this$0.mOnScrollStopDelayedListener.onScrollStop(i5, i4);
            }
        };
        this.mPreLoadListView = new q(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.e.l.e.q
            public void cancelRefresh() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BdMultiColumnListView bdMultiColumnListView = this.this$0;
                    bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                }
            }

            @Override // c.a.e.l.e.q
            public o getAdapter() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mBdListAdpter : (o) invokeV.objValue;
            }

            @Override // c.a.e.l.e.q
            public int getFirstVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.getFirstVisiblePosition() : invokeV.intValue;
            }

            @Override // c.a.e.l.e.q
            public int getLastVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.getLastVisiblePosition() : invokeV.intValue;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void refreshImage(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(65537, this, view) == null) || view == null) {
                    return;
                }
                if (view instanceof h) {
                    ((h) view).refresh();
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        refreshImage(viewGroup.getChildAt(i4));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.this$0.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        refreshImage(this.this$0.getChildAt(i4));
                    }
                    i c2 = j.c(this.this$0.getContext());
                    if (c2 != null) {
                        c2.onPreLoad(this.this$0.mPreLoadListView);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                i c2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (c2 = j.c(this.this$0.getContext())) == null) {
                    return;
                }
                c2.onPreLoad(this.this$0.mPreLoadListView);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    private int getHeaderIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            if (this.mPrePage != null) {
                ListAdapter listAdapter = this.mAdapter;
                if (listAdapter instanceof c.k.a.a.b.a) {
                    return ((c.k.a.a.b.a) listAdapter).c() - 1;
                }
                return -1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private void initial() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            setFadingEdgeLength(0);
            BdSimplePreLoadListAdapter bdSimplePreLoadListAdapter = new BdSimplePreLoadListAdapter(getContext());
            this.mBdListAdpter = bdSimplePreLoadListAdapter;
            bdSimplePreLoadListAdapter.setListPreLoad(new e.b(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.5
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

                @Override // c.a.e.l.e.e.b
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

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
                public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                        int c2 = this.this$0.mAdapter instanceof c.k.a.a.b.a ? ((c.k.a.a.b.a) this.this$0.mAdapter).c() : 0;
                        if (i2 < c2) {
                            if (this.this$0.mPrePage == null || view != this.this$0.mPrePage.b()) {
                                if (this.this$0.mOnHeaderClickListener != null) {
                                    this.this$0.mOnHeaderClickListener.onClick(view);
                                    return;
                                }
                                return;
                            }
                            this.this$0.mPrePage.c();
                            return;
                        }
                        int i3 = i2 - c2;
                        ListAdapter wrappedAdapter = this.this$0.mAdapter instanceof c.k.a.a.b.a ? ((c.k.a.a.b.a) this.this$0.mAdapter).getWrappedAdapter() : this.this$0.mAdapter;
                        if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                            if (this.this$0.mNextPage == null || view != this.this$0.mNextPage.b()) {
                                if (this.this$0.mOnFooterClickListener != null) {
                                    this.this$0.mOnFooterClickListener.onClick(view);
                                    return;
                                }
                                return;
                            }
                            this.this$0.mNextPage.c();
                        } else if (this.this$0.mOnItemClickListener != null) {
                            this.this$0.mOnItemClickListener.onItemClick(pLA_AdapterView, view, i3, j2);
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

                @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
                public void onScroll(PLA_AbsListView pLA_AbsListView, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, pLA_AbsListView, i2, i3, i4) == null) {
                        this.this$0.mFirstVisibleItemIndex = i2;
                        if (this.this$0.mOnScrollListener != null) {
                            this.this$0.mOnScrollListener.onScroll(pLA_AbsListView, i2, i3, i4);
                        }
                        if (this.this$0.mOnScrollStopDelayedListener == null || this.this$0.mOnScrollStopDelayedMillis <= 0 || this.this$0.getHandler() == null) {
                            return;
                        }
                        this.this$0.getHandler().removeCallbacks(this.this$0.mDelayedRunnable);
                        this.this$0.getHandler().postDelayed(this.this$0.mDelayedRunnable, this.this$0.mOnScrollStopDelayedMillis);
                    }
                }

                @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
                public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pLA_AbsListView, i2) == null) {
                        i c2 = j.c(this.this$0.getContext());
                        if (c2 != null) {
                            if (i2 == 2) {
                                BdMultiColumnListView bdMultiColumnListView = this.this$0;
                                bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                                c2.setIsScroll(true);
                            } else if (c2.isScroll()) {
                                c2.setIsScroll(false);
                                BdMultiColumnListView bdMultiColumnListView2 = this.this$0;
                                bdMultiColumnListView2.removeCallbacks(bdMultiColumnListView2.refreshRunnable);
                                BdMultiColumnListView bdMultiColumnListView3 = this.this$0;
                                bdMultiColumnListView3.postDelayed(bdMultiColumnListView3.refreshRunnable, 100L);
                            } else if (i2 == 0) {
                                BdMultiColumnListView bdMultiColumnListView4 = this.this$0;
                                bdMultiColumnListView4.removeCallbacks(bdMultiColumnListView4.preLoadRunnable);
                                BdMultiColumnListView bdMultiColumnListView5 = this.this$0;
                                bdMultiColumnListView5.postDelayed(bdMultiColumnListView5.preLoadRunnable, 100L);
                            }
                        }
                        if (this.this$0.mOnScrollListener != null) {
                            this.this$0.mOnScrollListener.onScrollStateChanged(pLA_AbsListView, i2);
                        }
                        if (i2 == 0) {
                            if (this.this$0.mOnScrollToBottomListener != null && pLA_AbsListView.getLastVisiblePosition() == pLA_AbsListView.getCount() - 1 && pLA_AbsListView.getFirstVisiblePosition() != 0) {
                                this.this$0.mOnScrollToBottomListener.onScrollToBottom();
                            }
                            if (this.this$0.mOnScrollToTopListener == null || pLA_AbsListView.getFirstVisiblePosition() > this.this$0.mScrollToTopNum) {
                                return;
                            }
                            this.this$0.mOnScrollToTopListener.onScrollToTop();
                        }
                    }
                }
            });
        }
    }

    public static boolean setPullRefreshRatio(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65576, null, f2)) == null) ? PullRefresh.setRatio(f2) : invokeF.booleanValue;
    }

    public void addPullRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            addHeaderView(view, null, false, 0);
        }
    }

    public void completePullRefresh() {
        PullRefresh pullRefresh;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pullRefresh = this.mPullRefresh) == null) {
            return;
        }
        if (pullRefresh.getBdIListPullView() != null) {
            this.mPullRefresh.mBdIListPullView.p();
        }
        this.mPullRefresh.animatePullView();
    }

    public void completePullRefreshPostDelayed(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null && pullRefresh.getBdIListPullView() != null) {
                this.mPullRefresh.mBdIListPullView.p();
            }
            c.a.e.e.m.e.a().postDelayed(new Runnable(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.10
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mPullRefresh == null) {
                        return;
                    }
                    this.this$0.mPullRefresh.animatePullView();
                }
            }, j2);
        }
    }

    public q getPreLoadHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPreLoadListView : (q) invokeV.objValue;
    }

    public boolean isRefreshDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            return pullRefresh == null || pullRefresh.mState == 3;
        }
        return invokeV.booleanValue;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null) {
                pullRefresh.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        r0 = true;
     */
    @Override // com.huewu.pla.lib.MultiColumnListView, com.huewu.pla.lib.internal.PLA_ListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemAddedToList(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.onItemAddedToList(i2, z);
            if (this.mOnItemWillVisibleListener != null) {
                boolean z2 = z ? false : false;
                if (z2) {
                    this.mOnItemWillVisibleListener.onItemWillVisible(i2 - getHeaderViewsCount(), z);
                    this.mLastAddPosition = i2;
                }
            }
            if (this.mIsPreLoad && z) {
                boolean z3 = getCount() - i2 < this.mPreLoadNum;
                if (this.mOnScrollToBottomListener == null || getFirstVisiblePosition() == 0 || this.mLastLoadCount == getCount() || !z3) {
                    return;
                }
                this.mOnScrollToBottomListener.onScrollToBottom();
                this.mLastLoadCount = getCount();
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null) {
                pullRefresh.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setNextPage(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            b bVar2 = this.mNextPage;
            if (bVar2 != null) {
                removeFooterView(bVar2.b());
                this.mNextPage = null;
            }
            if (bVar != null) {
                addFooterView(bVar.b(), null, true, 0);
                this.mNextPage = bVar;
            }
        }
    }

    public void setNoData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || str == null) {
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        setNoData(textView);
    }

    public void setOnFooterClickListener(OnFooterClickListener onFooterClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onFooterClickListener) == null) {
            this.mOnFooterClickListener = onFooterClickListener;
        }
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onHeaderClickListener) == null) {
            this.mOnHeaderClickListener = onHeaderClickListener;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemClickListener(PLA_AdapterView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.mOnItemClickListener = dVar;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemLongClickListener(PLA_AdapterView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
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

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
                public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                        int c2 = this.this$0.mAdapter instanceof c.k.a.a.b.a ? ((c.k.a.a.b.a) this.this$0.mAdapter).c() : 0;
                        if (i2 < c2) {
                            return true;
                        }
                        int i3 = i2 - c2;
                        ListAdapter listAdapter = this.this$0.mAdapter;
                        if (listAdapter == null || i3 >= listAdapter.getCount()) {
                            return true;
                        }
                        if (this.this$0.mOnItemLongClickListener != null) {
                            return this.this$0.mOnItemLongClickListener.onItemLongClick(pLA_AdapterView, view, i3, j2);
                        }
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }
            });
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemSelectedListener(PLA_AdapterView.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
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

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.f
                public void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                        int c2 = this.this$0.mAdapter instanceof c.k.a.a.b.a ? ((c.k.a.a.b.a) this.this$0.mAdapter).c() : 0;
                        if (i2 < c2) {
                            return;
                        }
                        int i3 = i2 - c2;
                        ListAdapter wrappedAdapter = this.this$0.mBdListAdpter.getWrappedAdapter();
                        if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount() || this.this$0.mOnItemSelectedListener == null) {
                            return;
                        }
                        this.this$0.mOnItemSelectedListener.onItemSelected(pLA_AdapterView, view, i3, j2);
                    }
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.f
                public void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pLA_AdapterView) == null) || this.this$0.mOnItemSelectedListener == null) {
                        return;
                    }
                    this.this$0.mOnItemSelectedListener.onNothingSelected(pLA_AdapterView);
                }
            });
        }
    }

    public void setOnItemWillVisileListener(OnItemWillVisibleListener onItemWillVisibleListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onItemWillVisibleListener) == null) {
            this.mOnItemWillVisibleListener = onItemWillVisibleListener;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setOnScrollListener(PLA_AbsListView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            this.mOnScrollListener = eVar;
        }
    }

    public void setOnScrollStopDelayedListener(OnScrollStopDelayedListener onScrollStopDelayedListener, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, onScrollStopDelayedListener, j2) == null) {
            this.mOnScrollStopDelayedListener = onScrollStopDelayedListener;
            this.mOnScrollStopDelayedMillis = j2;
        }
    }

    public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onScrollToPullListener) == null) {
            this.mOnScrollToPullListener = onScrollToPullListener;
        }
    }

    public void setOnSrollToBottomListener(OnScrollToBottomListener onScrollToBottomListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onScrollToBottomListener) == null) {
            this.mOnScrollToBottomListener = onScrollToBottomListener;
        }
    }

    public void setOnSrollToTopListener(OnScrollToTopListener onScrollToTopListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onScrollToTopListener) == null) {
            this.mOnScrollToTopListener = onScrollToTopListener;
        }
    }

    public void setPreLoad(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.mIsPreLoad = z;
            this.mPreLoadNum = i2;
        }
    }

    public void setPrePage(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            b bVar2 = this.mPrePage;
            if (bVar2 != null) {
                removeHeaderView(bVar2.b());
                this.mPrePage = null;
            }
            if (bVar != null) {
                addHeaderView(bVar.b());
                this.mPrePage = bVar;
            }
        }
    }

    public void setPullRefresh(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            PullRefresh pullRefresh = this.mPullRefresh;
            if (pullRefresh != null) {
                removeHeaderView(pullRefresh.getBdIListPullView().getView());
            }
            this.mPullRefresh = null;
            if (cVar != null) {
                PullRefresh pullRefresh2 = new PullRefresh(this, cVar);
                this.mPullRefresh = pullRefresh2;
                pullRefresh2.setOnScrollToPullListener(this.mOnScrollToPullListener);
            }
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void setSelectionFromTop(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            super.setSelectionFromTop(i2, i3);
        }
    }

    public void startPullRefresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || this.mPullRefresh == null) {
            return;
        }
        setSelection(0);
        this.mPullRefresh.startPullRefresh(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBdListAdpter : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, listAdapter) == null) {
            super.setAdapter(listAdapter);
            this.mBdListAdpter.setAdaper(this.mAdapter);
        }
    }

    public void setOnSrollToTopListener(OnScrollToTopListener onScrollToTopListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, onScrollToTopListener, i2) == null) {
            this.mOnScrollToTopListener = onScrollToTopListener;
            int i3 = i2 - 1;
            if (i3 < 0) {
                i3 = 0;
            }
            this.mScrollToTopNum = i3;
        }
    }

    public void setNoData(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            View view2 = this.mNoDataView;
            if (view2 != null) {
                removeHeaderView(view2);
                this.mNoDataView = null;
            }
            if (view != null) {
                addHeaderView(view, null, false);
                this.mNoDataView = view;
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mOnScrollStopDelayedListener == null) {
                    return;
                }
                int firstVisiblePosition = this.this$0.getFirstVisiblePosition();
                int lastVisiblePosition = this.this$0.getLastVisiblePosition();
                int i4 = 0;
                int i5 = -1;
                if (this.this$0.mAdapter instanceof c.k.a.a.b.a) {
                    int c2 = firstVisiblePosition - ((c.k.a.a.b.a) this.this$0.mAdapter).c();
                    i5 = c2 < 0 ? 0 : c2;
                    int c3 = lastVisiblePosition - ((c.k.a.a.b.a) this.this$0.mAdapter).c();
                    if (c3 >= this.this$0.mAdapter.getCount()) {
                        c3 = this.this$0.mAdapter.getCount() - 1;
                    }
                    if (c3 >= 0) {
                        i4 = c3;
                    }
                } else {
                    i4 = -1;
                }
                this.this$0.mOnScrollStopDelayedListener.onScrollStop(i5, i4);
            }
        };
        this.mPreLoadListView = new q(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.e.l.e.q
            public void cancelRefresh() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BdMultiColumnListView bdMultiColumnListView = this.this$0;
                    bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                }
            }

            @Override // c.a.e.l.e.q
            public o getAdapter() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mBdListAdpter : (o) invokeV.objValue;
            }

            @Override // c.a.e.l.e.q
            public int getFirstVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.getFirstVisiblePosition() : invokeV.intValue;
            }

            @Override // c.a.e.l.e.q
            public int getLastVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.getLastVisiblePosition() : invokeV.intValue;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void refreshImage(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(65537, this, view) == null) || view == null) {
                    return;
                }
                if (view instanceof h) {
                    ((h) view).refresh();
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        refreshImage(viewGroup.getChildAt(i4));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.this$0.getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        refreshImage(this.this$0.getChildAt(i4));
                    }
                    i c2 = j.c(this.this$0.getContext());
                    if (c2 != null) {
                        c2.onPreLoad(this.this$0.mPreLoadListView);
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                i c2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (c2 = j.c(this.this$0.getContext())) == null) {
                    return;
                }
                c2.onPreLoad(this.this$0.mPreLoadListView);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdMultiColumnListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mOnScrollStopDelayedListener == null) {
                    return;
                }
                int firstVisiblePosition = this.this$0.getFirstVisiblePosition();
                int lastVisiblePosition = this.this$0.getLastVisiblePosition();
                int i42 = 0;
                int i5 = -1;
                if (this.this$0.mAdapter instanceof c.k.a.a.b.a) {
                    int c2 = firstVisiblePosition - ((c.k.a.a.b.a) this.this$0.mAdapter).c();
                    i5 = c2 < 0 ? 0 : c2;
                    int c3 = lastVisiblePosition - ((c.k.a.a.b.a) this.this$0.mAdapter).c();
                    if (c3 >= this.this$0.mAdapter.getCount()) {
                        c3 = this.this$0.mAdapter.getCount() - 1;
                    }
                    if (c3 >= 0) {
                        i42 = c3;
                    }
                } else {
                    i42 = -1;
                }
                this.this$0.mOnScrollStopDelayedListener.onScrollStop(i5, i42);
            }
        };
        this.mPreLoadListView = new q(this) { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
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
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // c.a.e.l.e.q
            public void cancelRefresh() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    BdMultiColumnListView bdMultiColumnListView = this.this$0;
                    bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                }
            }

            @Override // c.a.e.l.e.q
            public o getAdapter() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.mBdListAdpter : (o) invokeV.objValue;
            }

            @Override // c.a.e.l.e.q
            public int getFirstVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.getFirstVisiblePosition() : invokeV.intValue;
            }

            @Override // c.a.e.l.e.q
            public int getLastVisiblePosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.getLastVisiblePosition() : invokeV.intValue;
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
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private void refreshImage(View view) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(65537, this, view) == null) || view == null) {
                    return;
                }
                if (view instanceof h) {
                    ((h) view).refresh();
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i42 = 0; i42 < childCount; i42++) {
                        refreshImage(viewGroup.getChildAt(i42));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.this$0.getChildCount();
                    for (int i42 = 0; i42 < childCount; i42++) {
                        refreshImage(this.this$0.getChildAt(i42));
                    }
                    i c2 = j.c(this.this$0.getContext());
                    if (c2 != null) {
                        c2.onPreLoad(this.this$0.mPreLoadListView);
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
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                i c2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (c2 = j.c(this.this$0.getContext())) == null) {
                    return;
                }
                c2.onPreLoad(this.this$0.mPreLoadListView);
            }
        };
        this.mPullRefresh = null;
        initial();
    }
}
