package com.baidu.live.feed.search.presenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine;", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "getState", "()Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "state", "", "setState", "(Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;)V", "searchState", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "<init>", "()V", "SearchState", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSearchStateMachine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SearchState a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "STATE_INIT", "STATE_INPUT", "STATE_RESULT", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class SearchState {
        public static final /* synthetic */ SearchState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SearchState STATE_INIT;
        public static final SearchState STATE_INPUT;
        public static final SearchState STATE_RESULT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(591189146, "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(591189146, "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine$SearchState;");
                    return;
                }
            }
            SearchState searchState = new SearchState("STATE_INIT", 0);
            STATE_INIT = searchState;
            SearchState searchState2 = new SearchState("STATE_INPUT", 1);
            STATE_INPUT = searchState2;
            SearchState searchState3 = new SearchState("STATE_RESULT", 2);
            STATE_RESULT = searchState3;
            $VALUES = new SearchState[]{searchState, searchState2, searchState3};
        }

        public static SearchState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SearchState) Enum.valueOf(SearchState.class, str) : (SearchState) invokeL.objValue;
        }

        public static SearchState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SearchState[]) $VALUES.clone() : (SearchState[]) invokeV.objValue;
        }

        public SearchState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public LiveSearchStateMachine() {
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
        this.a = SearchState.STATE_INIT;
    }

    public final SearchState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (SearchState) invokeV.objValue;
    }

    public final void b(SearchState searchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchState) == null) {
            this.a = searchState;
        }
    }
}
