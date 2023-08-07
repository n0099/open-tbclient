package com.baidu.live.feed.search.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchHotWordListData;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestionsBean;
import com.baidu.live.feed.search.model.data.RequestSearchData;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tieba.db0;
import com.baidu.tieba.eb0;
import com.baidu.tieba.fb0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B\u0011\u0012\b\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b2\u00101J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\nJ'\u0010 \u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067²\u0006\u0016\u00106\u001a\n 5*\u0004\u0018\u000104048\n@\nX\u008a\u0084\u0002²\u0006\u0016\u00106\u001a\n 5*\u0004\u0018\u000104048\n@\nX\u008a\u0084\u0002"}, d2 = {"Lcom/baidu/live/feed/search/presenter/LiveFeedSearchPresenter;", "Lcom/baidu/tieba/fb0;", "Landroid/content/Context;", "context", "", "content", "", "addHistoryRecord", "(Landroid/content/Context;Ljava/lang/String;)V", "cancelSearch", "()V", "deleteAllHistoryRecord", "(Landroid/content/Context;)V", "", CriusAttrConstants.POSITION, "deleteHistoryRecord", "(Landroid/content/Context;I)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchBean", "followClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;Landroid/content/Context;I)V", "followRealization", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "loadHotRank", "loadSearchHotWordsList", "words", "matchSuggestionWords", "(Ljava/lang/String;)V", "onDetach", "pn", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "requestData", "searchWord", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/live/feed/search/model/data/RequestSearchData;)V", "showHistoryRecord", "curInputWords", "Ljava/lang/String;", "", "searchIsCancel", "Z", "Lcom/baidu/live/feed/search/model/LiveSearchModel;", "searchModel", "Lcom/baidu/live/feed/search/model/LiveSearchModel;", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "searchPage", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "getSearchPage", "()Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;", "setSearchPage", "(Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$ISearchPage;)V", "<init>", "Companion", "Lcom/baidu/searchbox/live/interfaces/service/AccountManagerService;", "kotlin.jvm.PlatformType", "manager", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedSearchPresenter implements fb0 {
    public static final /* synthetic */ KProperty[] e = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchPresenter.class), "manager", "<v#0>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchPresenter.class), "manager", "<v#1>"))};
    public db0 a;
    public String b;
    public boolean c;
    public eb0 d;

    /* loaded from: classes3.dex */
    public static final class a implements AccountManagerService.LoginResultListener {
        public final /* synthetic */ LiveSearchResultInfo b;
        public final /* synthetic */ int c;

        public a(LiveSearchResultInfo liveSearchResultInfo, int i) {
            this.b = liveSearchResultInfo;
            this.c = i;
        }

        @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService.LoginResultListener
        public void onResult(int i) {
            if (i == 0) {
                LiveFeedSearchPresenter.this.m(this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements db0.a<Boolean> {
        public final /* synthetic */ int b;

        @Override // com.baidu.tieba.db0.a
        public void onFail(int i, String str) {
        }

        public b(int i) {
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db0.a
        /* renamed from: a */
        public void onSuccess(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                eb0 n = LiveFeedSearchPresenter.this.n();
                if (n != null) {
                    n.showToast("关注成功");
                }
                eb0 n2 = LiveFeedSearchPresenter.this.n();
                if (n2 != null) {
                    n2.h(this.b);
                    return;
                }
                return;
            }
            eb0 n3 = LiveFeedSearchPresenter.this.n();
            if (n3 != null) {
                n3.showToast("关注失败");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements db0.a<List<? extends LiveRoomEntity>> {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db0.a
        /* renamed from: a */
        public void onSuccess(List<? extends LiveRoomEntity> list) {
            eb0 n = LiveFeedSearchPresenter.this.n();
            if (n != null) {
                n.v0(list);
            }
        }

        @Override // com.baidu.tieba.db0.a
        public void onFail(int i, String str) {
            eb0 n = LiveFeedSearchPresenter.this.n();
            if (n != null) {
                n.v0(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements db0.a<LiveSearchHotWordListData> {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db0.a
        /* renamed from: a */
        public void onSuccess(LiveSearchHotWordListData liveSearchHotWordListData) {
            List<String> list;
            boolean z;
            List<String> list2 = null;
            if (liveSearchHotWordListData != null) {
                list = liveSearchHotWordListData.getHotWordList();
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                eb0 n = LiveFeedSearchPresenter.this.n();
                if (n != null) {
                    if (liveSearchHotWordListData != null) {
                        list2 = liveSearchHotWordListData.getHotWordList();
                    }
                    n.W0(list2);
                    return;
                }
                return;
            }
            eb0 n2 = LiveFeedSearchPresenter.this.n();
            if (n2 != null) {
                n2.W0(CollectionsKt__CollectionsKt.mutableListOf("搜索主播和直播内容"));
            }
        }

        @Override // com.baidu.tieba.db0.a
        public void onFail(int i, String str) {
            eb0 n = LiveFeedSearchPresenter.this.n();
            if (n != null) {
                n.W0(CollectionsKt__CollectionsKt.mutableListOf("搜索主播和直播内容"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements db0.a<LiveSearchSuggestionsBean> {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db0.a
        /* renamed from: a */
        public void onSuccess(LiveSearchSuggestionsBean liveSearchSuggestionsBean) {
            List<LiveSearchResultInfo> list;
            boolean z;
            if (liveSearchSuggestionsBean != null) {
                List<LiveSearchSuggestion> list2 = liveSearchSuggestionsBean.suggestionList;
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    String str = liveSearchSuggestionsBean.question;
                    if (str != null && !str.equals(LiveFeedSearchPresenter.this.b)) {
                        eb0 n = LiveFeedSearchPresenter.this.n();
                        if (n != null) {
                            n.g0(liveSearchSuggestionsBean.mSearchResultList, null);
                            return;
                        }
                        return;
                    }
                    eb0 n2 = LiveFeedSearchPresenter.this.n();
                    if (n2 != null) {
                        n2.g0(liveSearchSuggestionsBean.mSearchResultList, liveSearchSuggestionsBean.suggestionList);
                        return;
                    }
                    return;
                }
            }
            eb0 n3 = LiveFeedSearchPresenter.this.n();
            if (n3 != null) {
                if (liveSearchSuggestionsBean != null) {
                    list = liveSearchSuggestionsBean.mSearchResultList;
                } else {
                    list = null;
                }
                n3.g0(list, null);
            }
        }

        @Override // com.baidu.tieba.db0.a
        public void onFail(int i, String str) {
            eb0 n = LiveFeedSearchPresenter.this.n();
            if (n != null) {
                n.g0(null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements db0.a<SearchResultBean> {
        public final /* synthetic */ String b;

        public f(String str) {
            this.b = str;
        }

        @Override // com.baidu.tieba.db0.a
        public void onFail(int i, String str) {
            if (!LiveFeedSearchPresenter.this.c && Intrinsics.areEqual(this.b, "0")) {
                eb0 n = LiveFeedSearchPresenter.this.n();
                if (n != null) {
                    n.hideLoading();
                }
                eb0 n2 = LiveFeedSearchPresenter.this.n();
                if (n2 != null) {
                    n2.i();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.db0.a
        /* renamed from: a */
        public void onSuccess(SearchResultBean searchResultBean) {
            if (LiveFeedSearchPresenter.this.c) {
                return;
            }
            if (searchResultBean != null) {
                eb0 n = LiveFeedSearchPresenter.this.n();
                if (n != null) {
                    n.q(searchResultBean);
                }
            } else if (Intrinsics.areEqual(this.b, "0")) {
                eb0 n2 = LiveFeedSearchPresenter.this.n();
                if (n2 != null) {
                    n2.hideLoading();
                }
                eb0 n3 = LiveFeedSearchPresenter.this.n();
                if (n3 != null) {
                    n3.i();
                }
            }
        }
    }

    public LiveFeedSearchPresenter(eb0 eb0Var) {
        this.d = eb0Var;
        if (eb0Var != null) {
            eb0Var.l(this);
        }
        this.a = new db0();
    }

    @Override // com.baidu.tieba.fb0
    public void i(String str) {
        this.b = str;
        this.a.e(str, new e());
    }

    @Override // com.baidu.tieba.fb0
    public void a(Context context, String str) {
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

    @Override // com.baidu.tieba.fb0
    public void b(Context context) {
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

    @Override // com.baidu.tieba.fb0
    public void e(Context context) {
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
            eb0 eb0Var = this.d;
            if (eb0Var != null) {
                eb0Var.y0();
            }
        }
        eb0 eb0Var2 = this.d;
        if (eb0Var2 != null) {
            eb0Var2.o(arrayList);
        }
    }

    @Override // com.baidu.tieba.fb0
    public void c() {
        this.a.c(new d());
    }

    @Override // com.baidu.tieba.fb0
    public void d() {
        this.c = true;
        eb0 eb0Var = this.d;
        if (eb0Var != null) {
            eb0Var.hideLoading();
        }
    }

    @Override // com.baidu.tieba.fb0
    public void h() {
        this.a.b(new c());
    }

    public final eb0 n() {
        return this.d;
    }

    @Override // com.baidu.tieba.fb0
    public void onDetach() {
        this.d = null;
    }

    @Override // com.baidu.tieba.fb0
    public void f(Context context, int i) {
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

    @Override // com.baidu.tieba.fb0
    public void g(String str, String str2, RequestSearchData requestSearchData) {
        this.c = false;
        this.a.d(str, str2, new f(str2), requestSearchData);
    }

    @Override // com.baidu.tieba.fb0
    public void j(LiveSearchResultInfo liveSearchResultInfo, Context context, int i) {
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccountManagerService>() { // from class: com.baidu.live.feed.search.presenter.LiveFeedSearchPresenter$followClick$manager$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountManagerService invoke() {
                return (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
            }
        });
        KProperty kProperty = e[0];
        if (!((AccountManagerService) lazy.getValue()).isLogin(2)) {
            ((AccountManagerService) lazy.getValue()).login(context, new a(liveSearchResultInfo, i));
        } else {
            m(liveSearchResultInfo, i);
        }
    }

    public final void m(LiveSearchResultInfo liveSearchResultInfo, int i) {
        String str;
        Lazy lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccountManagerService>() { // from class: com.baidu.live.feed.search.presenter.LiveFeedSearchPresenter$followRealization$manager$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountManagerService invoke() {
                return (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
            }
        });
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
        db0 db0Var = this.a;
        String str4 = liveSearchResultInfo.thirdId;
        Intrinsics.checkExpressionValueIsNotNull(str4, "searchBean.thirdId");
        if (str3 == null) {
            Intrinsics.throwNpe();
        }
        String str5 = liveSearchResultInfo.type;
        Intrinsics.checkExpressionValueIsNotNull(str5, "searchBean.type");
        String str6 = liveSearchResultInfo.feedId;
        Intrinsics.checkExpressionValueIsNotNull(str6, "searchBean.feedId");
        db0Var.f("", str4, str3, str5, !liveSearchResultInfo.hasFollowed, str6, new b(i));
    }
}
