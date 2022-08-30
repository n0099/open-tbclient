package com.baidu.live.feed.search.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchHotWordListData;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestionsBean;
import com.baidu.live.feed.search.model.data.RequestSearchData;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tieba.a90;
import com.baidu.tieba.b90;
import com.baidu.tieba.c90;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B\u0011\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b2\u00101J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ'\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067²\u0006\u0016\u00106\u001a\n 5*\u0004\u0018\u000104048\n@\nX\u008a\u0084\u0002²\u0006\u0016\u00106\u001a\n 5*\u0004\u0018\u000104048\n@\nX\u008a\u0084\u0002"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveFeedSearchPresenter;", "Lcom/baidu/tieba/c90;", "Landroid/content/Context;", "context", "", "content", "", "addHistoryRecord", "(Landroid/content/Context;Ljava/lang/String;)V", "cancelSearch", "()V", "deleteAllHistoryRecord", "(Landroid/content/Context;)V", "", CriusAttrConstants.POSITION, "deleteHistoryRecord", "(Landroid/content/Context;I)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchBean", "followClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;Landroid/content/Context;I)V", "followRealization", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "loadHotRank", "loadSearchHotWordsList", "words", "matchSuggestionWords", "(Ljava/lang/String;)V", "onDetach", "pn", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "requestData", "searchWord", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/live/feed/search/model/data/RequestSearchData;)V", "showHistoryRecord", "curInputWords", "Ljava/lang/String;", "", "searchIsCancel", "Z", "Lcom/baidu/live/feed/search/model/LiveSearchModel;", "searchModel", "Lcom/baidu/live/feed/search/model/LiveSearchModel;", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "searchPage", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "getSearchPage", "()Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "setSearchPage", "(Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;)V", "<init>", "Companion", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "manager", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedSearchPresenter implements c90 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public a90 a;
    public String b;
    public boolean c;
    public b90 d;

    /* loaded from: classes2.dex */
    public static final class a implements AccountManagerService.LoginResultListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchPresenter a;
        public final /* synthetic */ LiveSearchResultInfo b;
        public final /* synthetic */ int c;

        public a(LiveFeedSearchPresenter liveFeedSearchPresenter, LiveSearchResultInfo liveSearchResultInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchPresenter, liveSearchResultInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchPresenter;
            this.b = liveSearchResultInfo;
            this.c = i;
        }

        @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService.LoginResultListener
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 0) {
                this.a.m(this.b, this.c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements a90.a<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchPresenter a;
        public final /* synthetic */ int b;

        public b(LiveFeedSearchPresenter liveFeedSearchPresenter, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchPresenter, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchPresenter;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a90.a
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    b90 n = this.a.n();
                    if (n != null) {
                        n.showToast("关注成功");
                    }
                    b90 n2 = this.a.n();
                    if (n2 != null) {
                        n2.b(this.b);
                        return;
                    }
                    return;
                }
                b90 n3 = this.a.n();
                if (n3 != null) {
                    n3.showToast("关注失败");
                }
            }
        }

        @Override // com.baidu.tieba.a90.a
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements a90.a<List<? extends LiveRoomEntity>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchPresenter a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c(LiveFeedSearchPresenter liveFeedSearchPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchPresenter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a90.a
        /* renamed from: a */
        public void onSuccess(List<? extends LiveRoomEntity> list) {
            b90 n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || (n = this.a.n()) == null) {
                return;
            }
            n.b0(list);
        }

        @Override // com.baidu.tieba.a90.a
        public void onFail(int i, String str) {
            b90 n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (n = this.a.n()) == null) {
                return;
            }
            n.b0(null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements a90.a<LiveSearchHotWordListData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchPresenter a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d(LiveFeedSearchPresenter liveFeedSearchPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchPresenter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a90.a
        /* renamed from: a */
        public void onSuccess(LiveSearchHotWordListData liveSearchHotWordListData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveSearchHotWordListData) == null) {
                List<String> hotWordList = liveSearchHotWordListData != null ? liveSearchHotWordListData.getHotWordList() : null;
                if (!(hotWordList == null || hotWordList.isEmpty())) {
                    b90 n = this.a.n();
                    if (n != null) {
                        n.o0(liveSearchHotWordListData != null ? liveSearchHotWordListData.getHotWordList() : null);
                        return;
                    }
                    return;
                }
                b90 n2 = this.a.n();
                if (n2 != null) {
                    n2.o0(CollectionsKt__CollectionsKt.mutableListOf("搜索主播和直播内容"));
                }
            }
        }

        @Override // com.baidu.tieba.a90.a
        public void onFail(int i, String str) {
            b90 n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (n = this.a.n()) == null) {
                return;
            }
            n.o0(CollectionsKt__CollectionsKt.mutableListOf("搜索主播和直播内容"));
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements a90.a<LiveSearchSuggestionsBean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchPresenter a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e(LiveFeedSearchPresenter liveFeedSearchPresenter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchPresenter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchPresenter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a90.a
        /* renamed from: a */
        public void onSuccess(LiveSearchSuggestionsBean liveSearchSuggestionsBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveSearchSuggestionsBean) == null) {
                if (liveSearchSuggestionsBean != null) {
                    List<LiveSearchSuggestion> list = liveSearchSuggestionsBean.suggestionList;
                    if (!(list == null || list.isEmpty())) {
                        String str = liveSearchSuggestionsBean.question;
                        if (str != null && !str.equals(this.a.b)) {
                            b90 n = this.a.n();
                            if (n != null) {
                                n.A(liveSearchSuggestionsBean.mSearchResultList, null);
                                return;
                            }
                            return;
                        }
                        b90 n2 = this.a.n();
                        if (n2 != null) {
                            n2.A(liveSearchSuggestionsBean.mSearchResultList, liveSearchSuggestionsBean.suggestionList);
                            return;
                        }
                        return;
                    }
                }
                b90 n3 = this.a.n();
                if (n3 != null) {
                    n3.A(liveSearchSuggestionsBean != null ? liveSearchSuggestionsBean.mSearchResultList : null, null);
                }
            }
        }

        @Override // com.baidu.tieba.a90.a
        public void onFail(int i, String str) {
            b90 n;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (n = this.a.n()) == null) {
                return;
            }
            n.A(null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements a90.a<SearchResultBean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchPresenter a;
        public final /* synthetic */ String b;

        public f(LiveFeedSearchPresenter liveFeedSearchPresenter, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchPresenter, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchPresenter;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a90.a
        /* renamed from: a */
        public void onSuccess(SearchResultBean searchResultBean) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, searchResultBean) == null) || this.a.c) {
                return;
            }
            if (searchResultBean != null) {
                b90 n = this.a.n();
                if (n != null) {
                    n.k(searchResultBean);
                }
            } else if (Intrinsics.areEqual(this.b, "0")) {
                b90 n2 = this.a.n();
                if (n2 != null) {
                    n2.z();
                }
                b90 n3 = this.a.n();
                if (n3 != null) {
                    n3.c();
                }
            }
        }

        @Override // com.baidu.tieba.a90.a
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && !this.a.c && Intrinsics.areEqual(this.b, "0")) {
                b90 n = this.a.n();
                if (n != null) {
                    n.z();
                }
                b90 n2 = this.a.n();
                if (n2 != null) {
                    n2.c();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(307307799, "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchPresenter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(307307799, "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchPresenter;");
                return;
            }
        }
        e = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchPresenter.class), "manager", "<v#0>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchPresenter.class), "manager", "<v#1>"))};
    }

    public LiveFeedSearchPresenter(b90 b90Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b90Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = b90Var;
        if (b90Var != null) {
            b90Var.h(this);
        }
        this.a = new a90();
    }

    @Override // com.baidu.tieba.c90
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            int i = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…rd\",Context.MODE_PRIVATE)");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(edit, "pref.edit()");
            int i2 = 1;
            for (int i3 = 1; i3 < 11; i3++) {
                if (StringsKt__StringsJVMKt.equals$default(sharedPreferences.getString(String.valueOf(i3), ""), str, false, 2, null)) {
                    return;
                }
            }
            int i4 = 1;
            while (true) {
                if (i4 >= 11) {
                    break;
                } else if (Intrinsics.areEqual(sharedPreferences.getString(String.valueOf(i4), ""), "")) {
                    i = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i != 0) {
                edit.putString(String.valueOf(i), str);
                edit.putInt("count", i);
            } else {
                while (i2 < 10) {
                    int i5 = i2 + 1;
                    edit.putString(String.valueOf(i2), sharedPreferences.getString(String.valueOf(i5), ""));
                    i2 = i5;
                }
                edit.putString(String.valueOf(10), str);
                edit.putInt("count", 10);
            }
            edit.commit();
        }
    }

    @Override // com.baidu.tieba.c90
    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…rd\",Context.MODE_PRIVATE)");
            int i = sharedPreferences.getInt("count", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(edit, "pref.edit()");
            for (int i2 = 1; i2 < 11; i2++) {
                edit.putString(String.valueOf(i2), "");
            }
            edit.putString(String.valueOf(i), "");
            edit.putInt("count", 0);
            edit.commit();
        }
    }

    @Override // com.baidu.tieba.c90
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.c(new d(this));
        }
    }

    @Override // com.baidu.tieba.c90
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = true;
            b90 b90Var = this.d;
            if (b90Var != null) {
                b90Var.z();
            }
        }
    }

    @Override // com.baidu.tieba.c90
    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…d\", Context.MODE_PRIVATE)");
            int i = sharedPreferences.getInt("count", 0);
            ArrayList arrayList = new ArrayList();
            if (i > 0) {
                while (i >= 1) {
                    String string = sharedPreferences.getString(String.valueOf(i), "");
                    if (string != null) {
                        arrayList.add(string);
                    }
                    i--;
                }
            } else {
                arrayList.clear();
                b90 b90Var = this.d;
                if (b90Var != null) {
                    b90Var.f0();
                }
            }
            b90 b90Var2 = this.d;
            if (b90Var2 != null) {
                b90Var2.j(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.c90
    public void f(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, context, i) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FeedSearchHistoryRecord", 0);
            Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…rd\",Context.MODE_PRIVATE)");
            int i2 = sharedPreferences.getInt("count", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Intrinsics.checkExpressionValueIsNotNull(edit, "pref.edit()");
            int i3 = i2 - i;
            while (i3 < 10) {
                int i4 = i3 + 1;
                edit.putString(String.valueOf(i3), sharedPreferences.getString(String.valueOf(i4), ""));
                i3 = i4;
            }
            edit.putString(String.valueOf(i2), "");
            edit.putInt("count", i2 - 1);
            edit.commit();
        }
    }

    @Override // com.baidu.tieba.c90
    public void g(String str, String str2, RequestSearchData requestSearchData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, requestSearchData) == null) {
            this.c = false;
            this.a.d(str, str2, new f(this, str2), requestSearchData);
        }
    }

    @Override // com.baidu.tieba.c90
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.b(new c(this));
        }
    }

    @Override // com.baidu.tieba.c90
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
            this.a.e(str, new e(this));
        }
    }

    @Override // com.baidu.tieba.c90
    public void j(LiveSearchResultInfo liveSearchResultInfo, Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, liveSearchResultInfo, context, i) == null) {
            Lazy lazy = LazyKt__LazyJVMKt.lazy(LiveFeedSearchPresenter$followClick$manager$2.INSTANCE);
            KProperty kProperty = e[0];
            if (!((AccountManagerService) lazy.getValue()).isLogin(2)) {
                ((AccountManagerService) lazy.getValue()).login(context, new a(this, liveSearchResultInfo, i));
            } else {
                m(liveSearchResultInfo, i);
            }
        }
    }

    public final void m(LiveSearchResultInfo liveSearchResultInfo, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, liveSearchResultInfo, i) == null) {
            Lazy lazy = LazyKt__LazyJVMKt.lazy(LiveFeedSearchPresenter$followRealization$manager$2.INSTANCE);
            KProperty kProperty = e[1];
            AccountManagerService accountManagerService = (AccountManagerService) lazy.getValue();
            if (accountManagerService != null) {
                String str2 = liveSearchResultInfo.uid;
                Intrinsics.checkExpressionValueIsNotNull(str2, "searchBean.uid");
                str = accountManagerService.getSocialEncryption(str2, "baiduuid_");
            } else {
                str = null;
            }
            String str3 = str;
            a90 a90Var = this.a;
            String str4 = liveSearchResultInfo.thirdId;
            Intrinsics.checkExpressionValueIsNotNull(str4, "searchBean.thirdId");
            if (str3 == null) {
                Intrinsics.throwNpe();
            }
            String str5 = liveSearchResultInfo.type;
            Intrinsics.checkExpressionValueIsNotNull(str5, "searchBean.type");
            String str6 = liveSearchResultInfo.feedId;
            Intrinsics.checkExpressionValueIsNotNull(str6, "searchBean.feedId");
            a90Var.f("", str4, str3, str5, !liveSearchResultInfo.hasFollowed, str6, new b(this, i));
        }
    }

    public final b90 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (b90) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c90
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d = null;
        }
    }
}
