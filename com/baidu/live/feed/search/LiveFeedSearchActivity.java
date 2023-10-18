package com.baidu.live.feed.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.business.util.GrParasmUtil;
import com.baidu.live.business.view.emotion.EmptyView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter;
import com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter;
import com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter;
import com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter;
import com.baidu.live.feed.search.holder.LiveSearchHotRankItemViewHolder;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.RequestSearchData;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import com.baidu.live.feed.search.presenter.LiveFeedSearchPresenter;
import com.baidu.live.feed.search.presenter.LiveSearchStateMachine;
import com.baidu.live.feed.search.view.LiveCustomNestedScrollView;
import com.baidu.live.feed.search.view.LiveSearchPanel;
import com.baidu.live.feed.search.view.LoadRecyclerView;
import com.baidu.live.feed.search.view.decoration.LiveSearchRecordItemDecoration;
import com.baidu.live.feed.search.view.decoration.LiveSearchResultItemDecoration;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.e60;
import com.baidu.tieba.f60;
import com.baidu.tieba.f80;
import com.baidu.tieba.i50;
import com.baidu.tieba.m60;
import com.baidu.tieba.p70;
import com.baidu.tieba.q50;
import com.baidu.tieba.w50;
import com.baidu.ubc.Flow;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ¹\u00012\u00020\u00012\u00020\u0002:\u0002¹\u0001B\b¢\u0006\u0005\b¸\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\r\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u0005J\u001d\u0010!\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u00032\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010\"J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00032\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001fH\u0016¢\u0006\u0004\b,\u0010\"JA\u00104\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020-2\b\b\u0002\u00103\u001a\u00020-¢\u0006\u0004\b4\u00105J/\u0010:\u001a\u00020\u00032\u000e\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010#2\u000e\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010#H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0003H\u0002¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010\u0005J\u000f\u0010>\u001a\u00020\u0003H\u0016¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0003H\u0016¢\u0006\u0004\b?\u0010\u0005J\u0017\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0003H\u0002¢\u0006\u0004\bD\u0010\u0005J\u0017\u0010F\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0016H\u0016¢\u0006\u0004\bF\u0010\u0019J!\u0010I\u001a\u00020\u00032\u0006\u0010G\u001a\u00020-2\b\b\u0002\u0010H\u001a\u00020-H\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0003H\u0002¢\u0006\u0004\bK\u0010\u0005J\u0017\u0010L\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\bL\u0010\u0019R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010YR\u0018\u0010`\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010YR\u0018\u0010a\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010UR\u0018\u0010b\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010UR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010f\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010UR\u0018\u0010g\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010RR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010UR\u0018\u0010l\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010YR\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010YR\u0016\u0010q\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010[R\u0016\u0010r\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010[R\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010\u008e\u0001R!\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008d\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010YR\u001a\u0010\u0099\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010eR\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009d\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010YR*\u0010\u009e\u0001\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0005\b¢\u0001\u0010CR\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001a\u0010¦\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010YR\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010\u00ad\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010eR#\u0010³\u0001\u001a\u00030®\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R#\u0010¶\u0001\u001a\u00030®\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010°\u0001\u001a\u0006\bµ\u0001\u0010²\u0001R\u001a\u0010·\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b·\u0001\u0010R¨\u0006º\u0001"}, d2 = {"Lcom/baidu/live/feed/search/LiveFeedSearchActivity;", "Lcom/baidu/tieba/e60;", "Landroidx/appcompat/app/AppCompatActivity;", "", "attachKeyboard", "()V", "checkFirstScreenDataIntegrity", "clearHistoryList", "", "posotion", "followCallback", "(I)V", "hideIncognitoModeBgView", "hideLoading", "hideSoftInput", "hideSuggestView", "initData", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "uiMode", "onDarkModeChange", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "releaseHotRank", "resetRequestData", "", "historyList", "setHistoryList", "(Ljava/util/List;)V", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "entities", "setHotRank", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;", "presenter", "setPresenter", "(Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;)V", "hintList", "setQueryHintList", "", IAdInterListener.AdProdType.PRODUCT_SUG, "record", "hotrank", "result", "error", SchemeCollecter.CLASSIFY_EMPTY, "setRecyccleVisiable", "(ZZZZZZ)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "setSuggestions", "(Ljava/util/List;Ljava/util/List;)V", "showHistoryRecord", "showIncognitoModeBgView", "showLoading", "showSearchError", "Lcom/baidu/live/feed/search/model/data/SearchResultBean;", "searchBean", "showSearchResult", "(Lcom/baidu/live/feed/search/model/data/SearchResultBean;)V", "showSuggestView", "content", PopItemMethodConstant.showToast, "isEnterIncognito", "isShowToast", "switchIncognitoMode", "(ZZ)V", "ubcLogSearchResultPageShowEnd", "updateIncognitoModeBg", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "adapter", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "Landroid/widget/ImageView;", "backIcon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "completeText", "Landroid/widget/TextView;", "deleteAllText", "Landroid/view/View;", "deleteIcon", "Landroid/view/View;", "firstScreenLoadSuccess", "Z", "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;", "historyRecordAdapter", "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;", "historyRecordHeadDelete", "historyRecordHeadNomal", "historyTitleOne", "historyTitleTwo", "Landroidx/recyclerview/widget/RecyclerView;", "hotRankView", "Landroidx/recyclerview/widget/RecyclerView;", "incognitoModeBgDes", "incognitoModeBgIcon", "Landroid/view/ViewStub;", "incognitoModeBgStub", "Landroid/view/ViewStub;", "incognitoModeBgTip", "incognitoModeBgView", "Landroid/widget/Button;", "incognitoModeBtn", "Landroid/widget/Button;", "incognitoModeView", "isInIncognito", "isRecommend", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManagerHotRank", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManagerRecommend", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManagerRecord", "Lcom/baidu/live/business/view/emotion/EmptyView;", "mEmptyView", "Lcom/baidu/live/business/view/emotion/EmptyView;", "Lcom/baidu/live/business/view/emotion/ErrorView;", "mErrorView", "Lcom/baidu/live/business/view/emotion/ErrorView;", "Lcom/baidu/ubc/Flow;", "mFlow", "Lcom/baidu/ubc/Flow;", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mLoadingView", "Lcom/baidu/live/business/view/emotion/LoadingView;", "Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView;", "nestedScrollView", "Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView;", "pageNum", "I", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;", "recommednList", "Ljava/util/List;", "recommendPn", "Lcom/baidu/live/feed/search/view/LoadRecyclerView;", "recyclerViewRecommend", "Lcom/baidu/live/feed/search/view/LoadRecyclerView;", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "requestSearchData", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "rootContentView", "searchHistoryView", "Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "searchPanel", "Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "searchRecordView", "searchResultBean", "Lcom/baidu/live/feed/search/model/data/SearchResultBean;", "getSearchResultBean", "()Lcom/baidu/live/feed/search/model/data/SearchResultBean;", "setSearchResultBean", "Landroid/view/ViewGroup;", "searchResultContainer", "Landroid/view/ViewGroup;", "searchResultGradientSpace", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine;", "searchStateMachine", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine;", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "searchSuggestionAdapter", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "searchSuggestionsRv", "Landroidx/recyclerview/widget/DividerItemDecoration;", "suggestionListDivider$delegate", "Lkotlin/Lazy;", "getSuggestionListDivider", "()Landroidx/recyclerview/widget/DividerItemDecoration;", "suggestionListDivider", "suggestionListDividerNight$delegate", "getSuggestionListDividerNight", "suggestionListDividerNight", "trashIcon", "<init>", "Companion", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedSearchActivity extends AppCompatActivity implements e60 {
    public static final /* synthetic */ KProperty[] W = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchActivity.class), "suggestionListDivider", "getSuggestionListDivider()Landroidx/recyclerview/widget/DividerItemDecoration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchActivity.class), "suggestionListDividerNight", "getSuggestionListDividerNight()Landroidx/recyclerview/widget/DividerItemDecoration;"))};
    public f60 A;
    public LiveFeedSearchSuggestionAdapter B;
    public LiveSearchHistoryRecordAdapter C;
    public ViewGroup D;
    public View E;
    public LoadRecyclerView F;
    public LiveRecommendMoreAdapter G;
    public StaggeredGridLayoutManager H;
    public StaggeredGridLayoutManager I;
    public LinearLayoutManager J;
    public SearchResultBean K;
    public int L;
    public GridLayoutManager M;
    public List<LiveRoomEntity> N;
    public boolean O;
    public boolean Q;
    public LiveSearchStateMachine R;
    public Flow S;
    public View a;
    public ImageView b;
    public LiveSearchPanel c;
    public RecyclerView d;
    public View e;
    public Button f;
    public ViewStub g;
    public View h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public LiveCustomNestedScrollView l;
    public RecyclerView m;
    public RecyclerView n;
    public View o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public TextView v;
    public TextView w;
    public LoadingView x;
    public ErrorView y;
    public EmptyView z;
    public int P = 1;

    /* renamed from: T  reason: collision with root package name */
    public RequestSearchData f1041T = new RequestSearchData();
    public final Lazy U = LazyKt__LazyJVMKt.lazy(new Function0<DividerItemDecoration>() { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$suggestionListDivider$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DividerItemDecoration invoke() {
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(LiveFeedSearchActivity.this, 1);
            Drawable drawable = ContextCompat.getDrawable(LiveFeedSearchActivity.this.getApplicationContext(), R.drawable.obfuscated_res_0x7f080f71);
            if (drawable != null) {
                dividerItemDecoration.setDrawable(drawable);
            }
            return dividerItemDecoration;
        }
    });
    public final Lazy V = LazyKt__LazyJVMKt.lazy(new Function0<DividerItemDecoration>() { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$suggestionListDividerNight$2
        {
            super(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DividerItemDecoration invoke() {
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(LiveFeedSearchActivity.this, 1);
            Drawable drawable = ContextCompat.getDrawable(LiveFeedSearchActivity.this.getApplicationContext(), R.drawable.obfuscated_res_0x7f080f72);
            if (drawable != null) {
                dividerItemDecoration.setDrawable(drawable);
            }
            return dividerItemDecoration;
        }
    });

    public final DividerItemDecoration e2() {
        Lazy lazy = this.U;
        KProperty kProperty = W[0];
        return (DividerItemDecoration) lazy.getValue();
    }

    public final DividerItemDecoration f2() {
        Lazy lazy = this.V;
        KProperty kProperty = W[1];
        return (DividerItemDecoration) lazy.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements m60.b {
        public a() {
        }

        @Override // com.baidu.tieba.m60.b
        public final void a(boolean z) {
            if (!z || LiveFeedSearchActivity.this.e == null) {
                View view2 = LiveFeedSearchActivity.this.e;
                if (view2 != null) {
                    view2.setTranslationY(0.0f);
                }
                View view3 = LiveFeedSearchActivity.this.e;
                if (view3 != null) {
                    view3.setVisibility(8);
                    return;
                }
                return;
            }
            View view4 = LiveFeedSearchActivity.this.e;
            if (view4 == null) {
                Intrinsics.throwNpe();
            }
            view4.setVisibility(0);
            View view5 = LiveFeedSearchActivity.this.e;
            if (view5 == null) {
                Intrinsics.throwNpe();
            }
            View view6 = LiveFeedSearchActivity.this.e;
            if (view6 == null) {
                Intrinsics.throwNpe();
            }
            view5.setTranslationY(-(view6.getTranslationY() + m60.c(LiveFeedSearchActivity.this)));
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            if (LiveFeedSearchActivity.this.isFinishing()) {
                return;
            }
            LiveFeedSearchActivity.this.h2();
            LiveFeedSearchActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements LiveCustomNestedScrollView.a {
        public c() {
        }

        @Override // com.baidu.live.feed.search.view.LiveCustomNestedScrollView.a
        public void a() {
            View currentFocus = LiveFeedSearchActivity.this.getCurrentFocus();
            if (currentFocus != null) {
                m60.h(currentFocus);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements LiveSearchHistoryRecordAdapter.recordListener {
        public d() {
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter.recordListener
        public void deleteAllRecord() {
            f60 f60Var = LiveFeedSearchActivity.this.A;
            if (f60Var != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                f60Var.b(applicationContext);
            }
            if (!LiveFeedSearchActivity.this.Q) {
                LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, true, true, false, false, false, 48, null);
                LiveFeedSearchActivity.this.p2();
                return;
            }
            LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, false, false, false, false, false, 48, null);
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter.recordListener
        public void deleteClick(int i) {
            f60 f60Var = LiveFeedSearchActivity.this.A;
            if (f60Var != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                f60Var.f(applicationContext, i);
            }
            if (!LiveFeedSearchActivity.this.Q) {
                LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, true, true, false, false, false, 48, null);
                LiveFeedSearchActivity.this.p2();
                View view2 = LiveFeedSearchActivity.this.o;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                View view3 = LiveFeedSearchActivity.this.p;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = LiveFeedSearchActivity.this.C;
                if (liveSearchHistoryRecordAdapter != null) {
                    liveSearchHistoryRecordAdapter.trashClick();
                    return;
                }
                return;
            }
            LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, false, false, false, false, false, 48, null);
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter.recordListener
        public void historyItemClick(String str, String str2, boolean z, int i) {
            f60 f60Var;
            if (!LiveFeedSearchActivity.this.Q && (f60Var = LiveFeedSearchActivity.this.A) != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                f60Var.a(applicationContext, str);
            }
            LiveFeedSearchActivity.this.L = 0;
            LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).resetData();
            LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).setShowMore(false);
            RecyclerView recyclerView = LiveFeedSearchActivity.this.m;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            LoadRecyclerView G1 = LiveFeedSearchActivity.G1(LiveFeedSearchActivity.this);
            if (G1 != null) {
                G1.setVisibility(8);
            }
            ViewGroup viewGroup = LiveFeedSearchActivity.this.D;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
            if (liveSearchPanel != null) {
                liveSearchPanel.k(str);
            }
            i50.F(LiveFeedSearchActivity.this.getApplicationContext(), String.valueOf(i));
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements LiveSearchHotRankAdapter.Callback {
        public e() {
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter.Callback
        public void onItemClick(String str) {
            if (str != null) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.invokeScheme(LiveFeedSearchActivity.this, str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements LiveRecommendMoreAdapter.OnItemClickListener {
        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onItemShow(LiveRoomEntity liveRoomEntity, int i) {
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onUbcResultClick(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i) {
        }

        public f() {
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void jumpAuthorView(String str) {
            LiveFeedSearchActivity.this.u2();
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
            if (invoker != null) {
                invoker.invokeScheme(LiveFeedSearchActivity.this.getApplicationContext(), str);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
            f60 f60Var = LiveFeedSearchActivity.this.A;
            if (f60Var != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                f60Var.j(liveSearchResultInfo, applicationContext, i);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onRecItemClick(LiveRoomEntity liveRoomEntity, int i) {
            LiveFeedSearchActivity.this.u2();
            if (i >= 0) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.invokeScheme(LiveFeedSearchActivity.this.getApplicationContext(), (liveRoomEntity == null || (r2 = liveRoomEntity.cmd) == null) ? "" : "");
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onSearchResultItemClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
            LiveFeedSearchActivity.this.u2();
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
            if (invoker != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                String str = liveSearchResultInfo.cmd;
                if (str == null) {
                    str = "";
                }
                invoker.invokeScheme(applicationContext, str);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onRetryLoadMore() {
            String text;
            f60 f60Var;
            if (LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).getFooterStatus() == 4) {
                LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).setFooterStatus(2);
                LiveFeedSearchActivity.this.L++;
                LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
                if (liveSearchPanel != null && (text = liveSearchPanel.getText()) != null && (f60Var = LiveFeedSearchActivity.this.A) != null) {
                    f60.a.a(f60Var, text, String.valueOf(LiveFeedSearchActivity.this.L), null, 4, null);
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onShowMoreClick() {
            LiveFeedSearchActivity.G1(LiveFeedSearchActivity.this).setLayoutManager(LiveFeedSearchActivity.this.H);
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onUbcResult(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i, String str) {
            if (z) {
                if (i < list2.size() && i >= 0) {
                    i50.Q(LiveFeedSearchActivity.this.getApplicationContext(), null, list2.get(i), Boolean.valueOf(z), i, str);
                }
            } else if (i < list.size() && i >= 0) {
                i50.Q(LiveFeedSearchActivity.this.getApplicationContext(), list.get(i), null, Boolean.valueOf(z), i, str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            View view3 = LiveFeedSearchActivity.this.o;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = LiveFeedSearchActivity.this.p;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = LiveFeedSearchActivity.this.C;
            if (liveSearchHistoryRecordAdapter != null) {
                liveSearchHistoryRecordAdapter.trashClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            View view3 = LiveFeedSearchActivity.this.o;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = LiveFeedSearchActivity.this.p;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = LiveFeedSearchActivity.this.C;
            if (liveSearchHistoryRecordAdapter != null) {
                liveSearchHistoryRecordAdapter.completeClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            f60 f60Var = LiveFeedSearchActivity.this.A;
            if (f60Var != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                f60Var.b(applicationContext);
            }
            if (!LiveFeedSearchActivity.this.Q) {
                LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, true, true, false, false, false, 48, null);
                LiveFeedSearchActivity.this.p2();
                return;
            }
            LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, false, false, false, false, false, 48, null);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j implements LoadRecyclerView.b {
        @Override // com.baidu.live.feed.search.view.LoadRecyclerView.b
        public void b(boolean z) {
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public j() {
        }

        @Override // com.baidu.live.feed.search.view.LoadRecyclerView.b
        public void a(boolean z) {
            Boolean bool;
            String text;
            f60 f60Var;
            if (LiveFeedSearchActivity.this.O) {
                LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).setFooterStatus(2);
                LiveFeedSearchActivity.this.P++;
                RequestSearchData requestSearchData = LiveFeedSearchActivity.this.f1041T;
                if (requestSearchData != null) {
                    requestSearchData.refreshIndex = String.valueOf(LiveFeedSearchActivity.this.P);
                }
                f60 f60Var2 = LiveFeedSearchActivity.this.A;
                if (f60Var2 != null) {
                    f60Var2.g(AdvanceSetting.NETWORK_TYPE, String.valueOf(LiveFeedSearchActivity.this.L), LiveFeedSearchActivity.this.f1041T);
                    return;
                }
                return;
            }
            LiveFeedSearchActivity.this.O = false;
            SearchResultBean d2 = LiveFeedSearchActivity.this.d2();
            if (d2 != null) {
                bool = Boolean.valueOf(d2.hasmore);
            } else {
                bool = null;
            }
            if (bool == null) {
                Intrinsics.throwNpe();
            }
            if (!bool.booleanValue()) {
                LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).setFooterStatus(3);
                return;
            }
            LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).setFooterStatus(2);
            LiveFeedSearchActivity.this.L++;
            LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
            if (liveSearchPanel != null && (text = liveSearchPanel.getText()) != null && (f60Var = LiveFeedSearchActivity.this.A) != null) {
                f60.a.a(f60Var, text, String.valueOf(LiveFeedSearchActivity.this.L), null, 4, null);
            }
            i50.O(LiveFeedSearchActivity.this.getApplicationContext(), String.valueOf(LiveFeedSearchActivity.this.L));
        }
    }

    /* loaded from: classes3.dex */
    public static final class k implements w50 {
        public k() {
        }

        @Override // com.baidu.tieba.w50
        public final void a(View view2) {
            LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
            if (liveSearchPanel != null) {
                liveSearchPanel.k(liveSearchPanel.getText());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class l implements LiveSearchPanel.g {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public l() {
        }

        @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
        public void onCancelClick() {
            LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
            if (liveSearchPanel != null && !liveSearchPanel.h()) {
                LiveSearchPanel liveSearchPanel2 = LiveFeedSearchActivity.this.c;
                if (liveSearchPanel2 != null) {
                    liveSearchPanel2.l();
                }
                LiveSearchPanel liveSearchPanel3 = LiveFeedSearchActivity.this.c;
                if (liveSearchPanel3 != null) {
                    liveSearchPanel3.r();
                }
            }
            if (!LiveFeedSearchActivity.this.Q) {
                LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, true, true, false, false, false, 48, null);
                LiveFeedSearchActivity.this.p2();
                return;
            }
            LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, false, false, false, false, false, 48, null);
        }

        @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
        public void onQueryTextChange(String str) {
            boolean z;
            f60 f60Var = LiveFeedSearchActivity.this.A;
            if (f60Var != null) {
                f60Var.d();
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                LiveSearchStateMachine liveSearchStateMachine = LiveFeedSearchActivity.this.R;
                if (liveSearchStateMachine != null) {
                    liveSearchStateMachine.b(LiveSearchStateMachine.SearchState.STATE_INIT);
                }
                LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = LiveFeedSearchActivity.this.B;
                if (liveFeedSearchSuggestionAdapter != null) {
                    LiveFeedSearchSuggestionAdapter.setSuggestions$default(liveFeedSearchSuggestionAdapter, null, null, null, 4, null);
                }
                if (LiveFeedSearchActivity.this.Q) {
                    LiveFeedSearchActivity.this.q2();
                    return;
                }
                LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, true, true, false, false, false, 48, null);
                LiveFeedSearchActivity.this.p2();
                return;
            }
            LiveSearchStateMachine liveSearchStateMachine2 = LiveFeedSearchActivity.this.R;
            if (liveSearchStateMachine2 != null) {
                liveSearchStateMachine2.b(LiveSearchStateMachine.SearchState.STATE_INPUT);
            }
            f60 f60Var2 = LiveFeedSearchActivity.this.A;
            if (f60Var2 != null) {
                f60Var2.i(str);
            }
            LiveFeedSearchActivity.this.g2();
            LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, true, false, false, false, false, false, 48, null);
        }

        @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
        public void onQueryTextSubmit(String str) {
            f60 f60Var;
            LiveSearchStateMachine liveSearchStateMachine = LiveFeedSearchActivity.this.R;
            if (liveSearchStateMachine != null) {
                liveSearchStateMachine.b(LiveSearchStateMachine.SearchState.STATE_RESULT);
            }
            i50.E(LiveFeedSearchActivity.this.getApplicationContext());
            if (str != null) {
                LiveFeedSearchActivity.this.i2();
                if (!LiveFeedSearchActivity.this.Q && (f60Var = LiveFeedSearchActivity.this.A) != null) {
                    Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                    f60Var.a(applicationContext, str);
                }
                LiveFeedSearchActivity.this.L = 0;
                LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).resetData();
                LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).setShowMore(false);
                LiveFeedSearchActivity.o2(LiveFeedSearchActivity.this, false, false, false, false, false, false, 48, null);
                f60 f60Var2 = LiveFeedSearchActivity.this.A;
                if (f60Var2 != null) {
                    f60.a.a(f60Var2, str, "0", null, 4, null);
                }
                LiveFeedSearchActivity.this.r2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class m implements View.OnClickListener {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            i50.M(LiveFeedSearchActivity.this.getApplicationContext());
        }
    }

    /* loaded from: classes3.dex */
    public static final class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Button button = LiveFeedSearchActivity.this.f;
            LiveSearchStateMachine.SearchState searchState = null;
            if (button == null || !button.isSelected()) {
                Button button2 = LiveFeedSearchActivity.this.f;
                if (button2 != null) {
                    button2.setSelected(true);
                }
                LiveFeedSearchActivity.t2(LiveFeedSearchActivity.this, true, false, 2, null);
                LiveSearchStateMachine liveSearchStateMachine = LiveFeedSearchActivity.this.R;
                if (liveSearchStateMachine != null) {
                    searchState = liveSearchStateMachine.a();
                }
                if (searchState != LiveSearchStateMachine.SearchState.STATE_INIT) {
                    return;
                }
                RecyclerView recyclerView = LiveFeedSearchActivity.this.m;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                View view3 = LiveFeedSearchActivity.this.r;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                RecyclerView recyclerView2 = LiveFeedSearchActivity.this.n;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(8);
                    return;
                }
                return;
            }
            Button button3 = LiveFeedSearchActivity.this.f;
            if (button3 != null) {
                button3.setSelected(false);
            }
            LiveFeedSearchActivity.t2(LiveFeedSearchActivity.this, false, false, 2, null);
            LiveSearchStateMachine liveSearchStateMachine2 = LiveFeedSearchActivity.this.R;
            if (liveSearchStateMachine2 != null) {
                searchState = liveSearchStateMachine2.a();
            }
            if (searchState != LiveSearchStateMachine.SearchState.STATE_INIT) {
                return;
            }
            RecyclerView recyclerView3 = LiveFeedSearchActivity.this.m;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
            View view4 = LiveFeedSearchActivity.this.r;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            RecyclerView recyclerView4 = LiveFeedSearchActivity.this.n;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class o implements LiveFeedSearchSuggestionAdapter.OnSuggestionListener {
        public o() {
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void jumpAuthorView(String str) {
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
            if (invoker != null) {
                invoker.invokeScheme(LiveFeedSearchActivity.this.getApplicationContext(), str);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onResultClick(LiveSearchResultInfo liveSearchResultInfo) {
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
            if (invoker != null) {
                invoker.invokeScheme(LiveFeedSearchActivity.this.getApplicationContext(), liveSearchResultInfo.cmd);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
            f60 f60Var = LiveFeedSearchActivity.this.A;
            if (f60Var != null) {
                Context applicationContext = LiveFeedSearchActivity.this.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                f60Var.j(liveSearchResultInfo, applicationContext, i);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onSuggestionClick(String str, int i) {
            LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
            if (liveSearchPanel != null) {
                liveSearchPanel.k(str);
            }
            LiveFeedSearchActivity.this.i2();
            i50.U(LiveFeedSearchActivity.this.getApplicationContext(), i);
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onSuggestionSelect(String str, int i) {
            LiveSearchPanel liveSearchPanel = LiveFeedSearchActivity.this.c;
            if (liveSearchPanel != null) {
                liveSearchPanel.setText(str);
            }
            i50.T(LiveFeedSearchActivity.this.getApplicationContext(), i);
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str) {
            if (i >= 0 && i < list.size()) {
                i50.D(LiveFeedSearchActivity.this.getApplicationContext(), list.get(i), String.valueOf(i), str);
            }
        }
    }

    public final void a2() {
        m60.b(this, null, new a());
    }

    public final SearchResultBean d2() {
        return this.K;
    }

    public final void g2() {
        View view2 = this.h;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void h2() {
        Object obj;
        Context applicationContext = getApplicationContext();
        IBinder iBinder = null;
        if (applicationContext != null) {
            obj = applicationContext.getSystemService("input_method");
        } else {
            obj = null;
        }
        if (!(obj instanceof InputMethodManager)) {
            obj = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) obj;
        if (inputMethodManager != null) {
            LiveSearchPanel liveSearchPanel = this.c;
            if (liveSearchPanel != null) {
                iBinder = liveSearchPanel.getWindowToken();
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    @Override // com.baidu.tieba.e60
    public void hideLoading() {
        LoadingView loadingView = this.x;
        if (loadingView != null) {
            loadingView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.e60
    public void i() {
        LiveSearchStateMachine.SearchState searchState;
        ErrorView errorView;
        LiveSearchStateMachine liveSearchStateMachine = this.R;
        if (liveSearchStateMachine != null) {
            searchState = liveSearchStateMachine.a();
        } else {
            searchState = null;
        }
        if (searchState == LiveSearchStateMachine.SearchState.STATE_RESULT && (errorView = this.y) != null) {
            errorView.d(0);
        }
    }

    public final void i2() {
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.B;
        if (liveFeedSearchSuggestionAdapter != null) {
            LiveFeedSearchSuggestionAdapter.setSuggestions$default(liveFeedSearchSuggestionAdapter, null, null, null, 4, null);
        }
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    public final void m2() {
        this.P = 1;
        RequestSearchData requestSearchData = this.f1041T;
        requestSearchData.refreshIndex = "1";
        requestSearchData.requestType = "search";
        this.O = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        LoadingView loadingView = this.x;
        if (loadingView != null) {
            loadingView.d();
        }
        ErrorView errorView = this.y;
        if (errorView != null) {
            errorView.d(8);
        }
        EmptyView emptyView = this.z;
        if (emptyView != null) {
            emptyView.b(8);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        f60 f60Var;
        super.onResume();
        i50.L(getApplicationContext());
        LoadingView loadingView = this.x;
        if (loadingView != null) {
            loadingView.e();
        }
        RecyclerView recyclerView = this.n;
        if (recyclerView != null && recyclerView.getVisibility() == 0 && (f60Var = this.A) != null) {
            f60Var.h();
        }
    }

    public void r2() {
        LoadingView loadingView = this.x;
        if (loadingView != null) {
            loadingView.setVisibility(0);
        }
    }

    public final void u2() {
        i50.P(getApplicationContext(), false, this.S);
        this.S = null;
    }

    @Override // com.baidu.tieba.e60
    public void y0() {
        o2(this, false, false, true, false, false, false, 48, null);
    }

    public static final /* synthetic */ GridLayoutManager A1(LiveFeedSearchActivity liveFeedSearchActivity) {
        GridLayoutManager gridLayoutManager = liveFeedSearchActivity.M;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return gridLayoutManager;
    }

    public static final /* synthetic */ LoadRecyclerView G1(LiveFeedSearchActivity liveFeedSearchActivity) {
        LoadRecyclerView loadRecyclerView = liveFeedSearchActivity.F;
        if (loadRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        return loadRecyclerView;
    }

    public static final /* synthetic */ LiveRecommendMoreAdapter o1(LiveFeedSearchActivity liveFeedSearchActivity) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter = liveFeedSearchActivity.G;
        if (liveRecommendMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return liveRecommendMoreAdapter;
    }

    @Override // com.baidu.tieba.e60
    public void V0(List<String> list) {
        LiveSearchPanel liveSearchPanel = this.c;
        if (liveSearchPanel != null) {
            LiveSearchPanel.setQueryHintList$default(liveSearchPanel, null, list, 1, null);
        }
        i50.N(getApplicationContext());
    }

    @Override // com.baidu.tieba.e60
    public void h(int i2) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.G;
        if (liveRecommendMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        liveRecommendMoreAdapter.setFollowStatus(i2);
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.B;
        if (liveFeedSearchSuggestionAdapter != null) {
            liveFeedSearchSuggestionAdapter.setFollowStatus(i2);
        }
    }

    @Override // com.baidu.tieba.e60
    public void m(f60 f60Var) {
        this.A = f60Var;
    }

    @Override // com.baidu.tieba.e60
    public void showToast(String str) {
        LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
        ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
        if (invoker != null) {
            invoker.showToast(getApplicationContext(), str);
        }
    }

    @Override // com.baidu.tieba.e60
    public void u0(List<? extends LiveRoomEntity> list) {
        RecyclerView recyclerView = this.n;
        if (recyclerView != null && (recyclerView.getAdapter() instanceof LiveSearchHotRankAdapter)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                ((LiveSearchHotRankAdapter) adapter).updateData(list);
                if (list != null && (!list.isEmpty())) {
                    i50.K(getApplicationContext());
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter");
        }
    }

    public static /* synthetic */ void o2(LiveFeedSearchActivity liveFeedSearchActivity, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
        boolean z7;
        boolean z8;
        if ((i2 & 16) != 0) {
            z7 = false;
        } else {
            z7 = z5;
        }
        if ((i2 & 32) != 0) {
            z8 = false;
        } else {
            z8 = z6;
        }
        liveFeedSearchActivity.n2(z, z2, z3, z4, z7, z8);
    }

    public static /* synthetic */ void t2(LiveFeedSearchActivity liveFeedSearchActivity, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        liveFeedSearchActivity.s2(z, z2);
    }

    @Override // com.baidu.tieba.e60
    public void Q(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2) {
        String str;
        if (this.B == null) {
            LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = new LiveFeedSearchSuggestionAdapter(this, LiveFeedPageSdk.HOST_LIVE_TAB);
            liveFeedSearchSuggestionAdapter.setSuggestionListener(new o());
            this.B = liveFeedSearchSuggestionAdapter;
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.setAdapter(liveFeedSearchSuggestionAdapter);
            }
            RecyclerView recyclerView2 = this.d;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(this));
            }
        }
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter2 = this.B;
        if (liveFeedSearchSuggestionAdapter2 != null) {
            LiveSearchPanel liveSearchPanel = this.c;
            if (liveSearchPanel != null) {
                str = liveSearchPanel.getText();
            } else {
                str = null;
            }
            liveFeedSearchSuggestionAdapter2.setSuggestions(list, list2, str);
        }
    }

    public final void c2() {
        String str;
        SearchResultBean searchResultBean = this.K;
        if (searchResultBean != null) {
            if (searchResultBean.searchResultVideoList.isEmpty() && searchResultBean.searchResultList.isEmpty()) {
                ArrayList<LiveRoomEntity> arrayList = searchResultBean.recommendList;
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.O = true;
                    this.P = 1;
                    String genUploadJson = GrParasmUtil.genUploadJson();
                    RequestSearchData requestSearchData = this.f1041T;
                    String valueOf = String.valueOf(this.P);
                    String str2 = null;
                    if (searchResultBean != null) {
                        str = searchResultBean.refreshType;
                    } else {
                        str = null;
                    }
                    if (searchResultBean != null) {
                        str2 = searchResultBean.sessionId;
                    }
                    requestSearchData.setData(valueOf, str, str2, genUploadJson, "recommend");
                    n2(false, false, false, true, false, false);
                    LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.G;
                    if (liveRecommendMoreAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    }
                    liveRecommendMoreAdapter.showRecommend(searchResultBean.recommendList, "搜索无结果，猜你想看以下内容", this.O);
                    LiveRecommendMoreAdapter liveRecommendMoreAdapter2 = this.G;
                    if (liveRecommendMoreAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    }
                    liveRecommendMoreAdapter2.setFooterStatus(1);
                    return;
                }
                n2(false, false, false, false, false, true);
            } else if (searchResultBean.searchResultVideoList.isEmpty() && !searchResultBean.searchResultList.isEmpty()) {
                this.O = true;
                this.P = 1;
                n2(false, false, false, true, false, false);
                LiveRecommendMoreAdapter liveRecommendMoreAdapter3 = this.G;
                if (liveRecommendMoreAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                ArrayList<LiveRoomEntity> arrayList2 = searchResultBean.recommendList;
                Intrinsics.checkExpressionValueIsNotNull(arrayList2, "liveRecommendMoreList.recommendList");
                ArrayList<LiveSearchResultInfo> arrayList3 = searchResultBean.searchResultList;
                Intrinsics.checkExpressionValueIsNotNull(arrayList3, "liveRecommendMoreList.searchResultList");
                liveRecommendMoreAdapter3.setData(arrayList2, arrayList3, this.O);
            } else if (!searchResultBean.searchResultVideoList.isEmpty() && searchResultBean.searchResultList.isEmpty()) {
                m2();
                n2(false, false, false, true, false, false);
                LiveRecommendMoreAdapter liveRecommendMoreAdapter4 = this.G;
                if (liveRecommendMoreAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                liveRecommendMoreAdapter4.showRecommend(searchResultBean.searchResultVideoList, "搜索无结果，猜你想看以下内容", this.O);
                LiveRecommendMoreAdapter liveRecommendMoreAdapter5 = this.G;
                if (liveRecommendMoreAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                liveRecommendMoreAdapter5.setFooterStatus(1);
            } else {
                m2();
                n2(false, false, false, true, false, false);
                LiveRecommendMoreAdapter liveRecommendMoreAdapter6 = this.G;
                if (liveRecommendMoreAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                ArrayList<LiveRoomEntity> arrayList4 = searchResultBean.searchResultVideoList;
                Intrinsics.checkExpressionValueIsNotNull(arrayList4, "liveRecommendMoreList.searchResultVideoList");
                ArrayList<LiveSearchResultInfo> arrayList5 = searchResultBean.searchResultList;
                Intrinsics.checkExpressionValueIsNotNull(arrayList5, "liveRecommendMoreList.searchResultList");
                liveRecommendMoreAdapter6.setData(arrayList4, arrayList5, this.O);
            }
        }
    }

    public final void initView() {
        Context context;
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0915b4);
        ((ViewGroup) findViewById).setPadding(0, p70.e(getApplicationContext()), 0, 0);
        this.a = findViewById;
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0915b3);
        imageView.setOnClickListener(new b());
        this.b = imageView;
        this.e = findViewById(R.id.obfuscated_res_0x7f0915b2);
        this.f = (Button) findViewById(R.id.obfuscated_res_0x7f0915b1);
        this.g = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0915af);
        this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0915b7);
        this.l = (LiveCustomNestedScrollView) findViewById(R.id.obfuscated_res_0x7f092114);
        this.m = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0915ad);
        this.n = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0915ae);
        this.c = (LiveSearchPanel) findViewById(R.id.obfuscated_res_0x7f0915b5);
        this.D = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0915da);
        this.E = findViewById(R.id.obfuscated_res_0x7f0915db);
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f09160b);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.livesh…arch_recommend_more_live)");
        this.F = (LoadRecyclerView) findViewById2;
        this.o = findViewById(R.id.obfuscated_res_0x7f0915d1);
        this.p = findViewById(R.id.obfuscated_res_0x7f0915ca);
        this.q = findViewById(R.id.obfuscated_res_0x7f0915c7);
        this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f0915c6);
        this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f0915d8);
        this.r = findViewById(R.id.obfuscated_res_0x7f0915cb);
        this.u = (ImageView) findViewById(R.id.obfuscated_res_0x7f0915ba);
        this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f0915b8);
        this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f0915b9);
        EmptyView emptyView = (EmptyView) findViewById(R.id.obfuscated_res_0x7f0915aa);
        this.z = emptyView;
        if (emptyView != null) {
            emptyView.a(LiveFeedPageSdk.HOST_LIVE_TAB);
        }
        ErrorView errorView = (ErrorView) findViewById(R.id.obfuscated_res_0x7f0915ab);
        this.y = errorView;
        if (errorView != null) {
            errorView.c(LiveFeedPageSdk.HOST_LIVE_TAB);
        }
        ErrorView errorView2 = this.y;
        if (errorView2 != null) {
            errorView2.setActionCallback(new k());
        }
        LoadingView loadingView = (LoadingView) findViewById(R.id.obfuscated_res_0x7f0915ac);
        this.x = loadingView;
        if (loadingView != null) {
            loadingView.c(LiveFeedPageSdk.HOST_LIVE_TAB);
        }
        hideLoading();
        RecyclerView recyclerView = this.d;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(e2());
        }
        LiveSearchPanel liveSearchPanel = this.c;
        if (liveSearchPanel != null) {
            liveSearchPanel.setCanSearchHint(false);
        }
        LiveSearchPanel liveSearchPanel2 = this.c;
        if (liveSearchPanel2 != null) {
            liveSearchPanel2.setEditable(true);
        }
        LiveSearchPanel liveSearchPanel3 = this.c;
        if (liveSearchPanel3 != null) {
            liveSearchPanel3.setQueryListener(new l());
        }
        LiveSearchPanel liveSearchPanel4 = this.c;
        if (liveSearchPanel4 != null) {
            liveSearchPanel4.setOnEditClickListener(new m());
        }
        Button button = this.f;
        if (button != null) {
            button.setOnClickListener(new n());
        }
        LiveCustomNestedScrollView liveCustomNestedScrollView = this.l;
        if (liveCustomNestedScrollView != null) {
            liveCustomNestedScrollView.setCallback(new c());
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = new LiveSearchHistoryRecordAdapter(applicationContext);
        liveSearchHistoryRecordAdapter.setDeleteListener(new d());
        this.C = liveSearchHistoryRecordAdapter;
        this.I = new StaggeredGridLayoutManager(2, 1);
        float f2 = getApplicationContext().getResources().getDisplayMetrics().density;
        RecyclerView recyclerView2 = this.m;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new LiveSearchRecordItemDecoration((int) ((f2 * 9.0f) + 0.5f)));
        }
        RecyclerView recyclerView3 = this.m;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(this.I);
        }
        RecyclerView recyclerView4 = this.n;
        if (recyclerView4 != null) {
            recyclerView4.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView5 = this.n;
        if (recyclerView5 != null) {
            context = recyclerView5.getContext();
        } else {
            context = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.J = linearLayoutManager;
        RecyclerView recyclerView6 = this.n;
        if (recyclerView6 != null) {
            recyclerView6.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView7 = this.n;
        if (recyclerView7 != null) {
            LiveSearchHotRankAdapter liveSearchHotRankAdapter = new LiveSearchHotRankAdapter();
            liveSearchHotRankAdapter.setCallback(new e());
            recyclerView7.setAdapter(liveSearchHotRankAdapter);
        }
        View view2 = this.q;
        if (view2 != null) {
            view2.setOnClickListener(new g());
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setOnClickListener(new h());
        }
        TextView textView2 = this.t;
        if (textView2 != null) {
            textView2.setOnClickListener(new i());
        }
        this.H = new StaggeredGridLayoutManager(2, 1);
        float f3 = getApplicationContext().getResources().getDisplayMetrics().density;
        LoadRecyclerView loadRecyclerView = this.F;
        if (loadRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        loadRecyclerView.addItemDecoration(new LiveSearchResultItemDecoration((int) ((f3 * 8.0f) + 0.5f)));
        LoadRecyclerView loadRecyclerView2 = this.F;
        if (loadRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        loadRecyclerView2.setLayoutManager(this.H);
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "applicationContext");
        LiveRecommendMoreAdapter liveRecommendMoreAdapter = new LiveRecommendMoreAdapter(applicationContext2, LiveFeedPageSdk.HOST_LIVE_TAB);
        liveRecommendMoreAdapter.setListener(new f());
        this.G = liveRecommendMoreAdapter;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        this.M = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$initView$14
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i2) {
                if (LiveFeedSearchActivity.o1(LiveFeedSearchActivity.this).isBottomView(i2)) {
                    return LiveFeedSearchActivity.A1(LiveFeedSearchActivity.this).getSpanCount();
                }
                return 1;
            }
        });
        LoadRecyclerView loadRecyclerView3 = this.F;
        if (loadRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        LiveRecommendMoreAdapter liveRecommendMoreAdapter2 = this.G;
        if (liveRecommendMoreAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        loadRecyclerView3.setAdapter(liveRecommendMoreAdapter2);
        LoadRecyclerView loadRecyclerView4 = this.F;
        if (loadRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        loadRecyclerView4.setOnLoadListener(new j());
        LoadRecyclerView loadRecyclerView5 = this.F;
        if (loadRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        loadRecyclerView5.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$initView$16
            public boolean a;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView8, int i2) {
                super.onScrollStateChanged(recyclerView8, i2);
                if (i2 == 0 && this.a) {
                    this.a = false;
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView8, int i2, int i3) {
                super.onScrolled(recyclerView8, i2, i3);
                if (i2 != 0 || i3 != 0) {
                    this.a = true;
                }
            }
        });
        a2();
    }

    public final void j2() {
        new LiveFeedSearchPresenter(this);
        boolean a2 = q50.a("sp_key_search_incognito_mode", false);
        this.Q = a2;
        Button button = this.f;
        if (button != null) {
            button.setSelected(a2);
        }
        s2(this.Q, false);
        if (!this.Q) {
            o2(this, false, true, true, false, false, false, 48, null);
            p2();
        } else {
            o2(this, false, false, false, false, false, false, 48, null);
        }
        f60 f60Var = this.A;
        if (f60Var != null) {
            f60Var.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LoadingView loadingView = this.x;
        if (loadingView != null) {
            loadingView.a();
        }
        ErrorView errorView = this.y;
        if (errorView != null) {
            errorView.d(8);
        }
        EmptyView emptyView = this.z;
        if (emptyView != null) {
            emptyView.b(8);
        }
        LiveSearchPanel liveSearchPanel = this.c;
        if (liveSearchPanel != null) {
            liveSearchPanel.j();
        }
        f60 f60Var = this.A;
        if (f60Var != null) {
            f60Var.onDetach();
        }
        LiveCustomNestedScrollView liveCustomNestedScrollView = this.l;
        if (liveCustomNestedScrollView != null) {
            liveCustomNestedScrollView.a();
        }
        l2();
    }

    public final void p2() {
        String str;
        LiveSearchPanel liveSearchPanel = this.c;
        if (liveSearchPanel != null) {
            str = liveSearchPanel.getText();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "")) {
            RecyclerView recyclerView = this.m;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
                return;
            }
            return;
        }
        o2(this, false, true, true, false, false, false, 48, null);
        f60 f60Var = this.A;
        if (f60Var != null) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
            f60Var.e(applicationContext);
        }
    }

    public final void k2(String str) {
        RecyclerView recyclerView;
        View view2 = this.a;
        if (view2 != null) {
            view2.setBackgroundColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_white1"));
        }
        LiveSearchPanel liveSearchPanel = this.c;
        if (liveSearchPanel != null) {
            liveSearchPanel.i(str);
        }
        if (Intrinsics.areEqual(str, "day")) {
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080f58);
            }
            Button button = this.f;
            if (button != null) {
                button.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f61);
            }
        } else if (Intrinsics.areEqual(str, "night")) {
            ImageView imageView2 = this.b;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.obfuscated_res_0x7f080f59);
            }
            Button button2 = this.f;
            if (button2 != null) {
                button2.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f62);
            }
        }
        View view3 = this.e;
        if (view3 != null) {
            view3.setBackgroundColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_EEEEEE"));
        }
        v2(str);
        RecyclerView recyclerView2 = this.d;
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(e2());
        }
        RecyclerView recyclerView3 = this.d;
        if (recyclerView3 != null) {
            recyclerView3.removeItemDecoration(f2());
        }
        if (Intrinsics.areEqual(str, "day")) {
            RecyclerView recyclerView4 = this.d;
            if (recyclerView4 != null) {
                recyclerView4.addItemDecoration(e2());
            }
        } else if (Intrinsics.areEqual(str, "night") && (recyclerView = this.d) != null) {
            recyclerView.addItemDecoration(f2());
        }
        ViewGroup viewGroup = this.D;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_F5F5F51"));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{f80.f().a(this, LiveFeedPageSdk.HOST_LIVE_TAB, "color_white1"), f80.f().a(this, LiveFeedPageSdk.HOST_LIVE_TAB, "color_F5F5F51")});
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        View view4 = this.E;
        if (view4 != null) {
            view4.setBackgroundDrawable(gradientDrawable);
        }
        LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = this.C;
        if (liveSearchHistoryRecordAdapter != null) {
            liveSearchHistoryRecordAdapter.notifyDataSetChanged();
        }
        LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.B;
        if (liveFeedSearchSuggestionAdapter != null) {
            liveFeedSearchSuggestionAdapter.notifyDataSetChanged();
        }
        LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.G;
        if (liveRecommendMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        if (liveRecommendMoreAdapter != null) {
            liveRecommendMoreAdapter.notifyDataSetChanged();
        }
    }

    public final void l2() {
        int i2;
        RecyclerView recyclerView = this.n;
        if (recyclerView != null) {
            if (recyclerView.getAdapter() instanceof LiveSearchHotRankAdapter) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    ((LiveSearchHotRankAdapter) adapter).release();
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter");
                }
            }
            LinearLayoutManager linearLayoutManager = this.J;
            if (linearLayoutManager != null) {
                int i3 = -1;
                if (linearLayoutManager != null) {
                    i2 = linearLayoutManager.findFirstVisibleItemPosition();
                } else {
                    i2 = -1;
                }
                LinearLayoutManager linearLayoutManager2 = this.J;
                if (linearLayoutManager2 != null) {
                    i3 = linearLayoutManager2.findLastVisibleItemPosition();
                }
                if (i2 >= 0 && i3 >= 0 && i3 >= i2) {
                    while (i2 < i3) {
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i2);
                        if (findViewHolderForAdapterPosition instanceof LiveSearchHotRankItemViewHolder) {
                            ((LiveSearchHotRankItemViewHolder) findViewHolderForAdapterPosition).c();
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public final void q2() {
        LiveSearchStateMachine.SearchState searchState;
        LiveSearchStateMachine liveSearchStateMachine = this.R;
        View view2 = null;
        if (liveSearchStateMachine != null) {
            searchState = liveSearchStateMachine.a();
        } else {
            searchState = null;
        }
        if (searchState != LiveSearchStateMachine.SearchState.STATE_INIT || !this.Q) {
            return;
        }
        View view3 = this.h;
        if (view3 == null) {
            ViewStub viewStub = this.g;
            if (viewStub != null) {
                view2 = viewStub.inflate();
            }
            this.h = view2;
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f0915ce);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0915d0);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0915cf);
        } else if (view3 != null) {
            view3.setVisibility(0);
        }
        f80 f2 = f80.f();
        Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
        String r = f2.r();
        Intrinsics.checkExpressionValueIsNotNull(r, "UIModeUtils.getInstance().uiMode");
        v2(r);
    }

    public final void n2(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        f60 f60Var;
        if (z) {
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
        } else {
            RecyclerView recyclerView2 = this.d;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
        }
        if (z2) {
            View view2 = this.r;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            RecyclerView recyclerView3 = this.m;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
            i50.R(getApplicationContext());
        } else {
            RecyclerView recyclerView4 = this.m;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(8);
            }
            View view3 = this.r;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        if (z3) {
            RecyclerView recyclerView5 = this.n;
            if ((recyclerView5 == null || recyclerView5.getVisibility() != 0) && (f60Var = this.A) != null) {
                f60Var.h();
            }
            RecyclerView recyclerView6 = this.n;
            if (recyclerView6 != null) {
                recyclerView6.setVisibility(0);
            }
        } else {
            RecyclerView recyclerView7 = this.n;
            if (recyclerView7 != null) {
                recyclerView7.setVisibility(8);
            }
        }
        if (z4) {
            LoadRecyclerView loadRecyclerView = this.F;
            if (loadRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
            }
            loadRecyclerView.setVisibility(0);
            ViewGroup viewGroup = this.D;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
        } else {
            LoadRecyclerView loadRecyclerView2 = this.F;
            if (loadRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
            }
            loadRecyclerView2.setVisibility(8);
            ViewGroup viewGroup2 = this.D;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
        }
        if (z5) {
            ErrorView errorView = this.y;
            if (errorView != null) {
                errorView.d(0);
            }
        } else {
            ErrorView errorView2 = this.y;
            if (errorView2 != null) {
                errorView2.d(8);
            }
        }
        if (z6) {
            EmptyView emptyView = this.z;
            if (emptyView != null) {
                emptyView.b(0);
                return;
            }
            return;
        }
        EmptyView emptyView2 = this.z;
        if (emptyView2 != null) {
            emptyView2.b(8);
        }
    }

    @Override // com.baidu.tieba.e60
    public void o(List<String> list) {
        RecyclerView.Adapter adapter;
        RecyclerView.Adapter adapter2;
        LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = this.C;
        if (liveSearchHistoryRecordAdapter != null) {
            liveSearchHistoryRecordAdapter.setList(list);
        }
        View view2 = this.o;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.p;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter2 = this.C;
        if (liveSearchHistoryRecordAdapter2 != null) {
            RecyclerView recyclerView = this.m;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (Intrinsics.areEqual(liveSearchHistoryRecordAdapter2, adapter)) {
                RecyclerView recyclerView2 = this.m;
                if (recyclerView2 != null && (adapter2 = recyclerView2.getAdapter()) != null) {
                    adapter2.notifyDataSetChanged();
                    return;
                }
                return;
            }
            RecyclerView recyclerView3 = this.m;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(liveSearchHistoryRecordAdapter2);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        p70.h(this, false);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d05e7);
        LiveFeedPageSdk.getInstance().setContext(this);
        if (bundle != null) {
            finish();
        }
        LiveSearchStateMachine liveSearchStateMachine = new LiveSearchStateMachine();
        this.R = liveSearchStateMachine;
        if (liveSearchStateMachine != null) {
            liveSearchStateMachine.b(LiveSearchStateMachine.SearchState.STATE_INIT);
        }
        initView();
        j2();
        f80 f2 = f80.f();
        Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
        String r = f2.r();
        Intrinsics.checkExpressionValueIsNotNull(r, "UIModeUtils.getInstance().uiMode");
        k2(r);
    }

    @Override // com.baidu.tieba.e60
    public void p(SearchResultBean searchResultBean) {
        hideLoading();
        o2(this, false, false, false, true, false, false, 48, null);
        h2();
        this.K = searchResultBean;
        LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.G;
        if (liveRecommendMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        if (liveRecommendMoreAdapter.isEmptyList()) {
            this.N = searchResultBean.searchResultVideoList;
            this.S = i50.P(getApplicationContext(), true, null);
            c2();
            return;
        }
        LoadRecyclerView loadRecyclerView = this.F;
        if (loadRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        loadRecyclerView.f();
        if (this.O) {
            LiveRecommendMoreAdapter liveRecommendMoreAdapter2 = this.G;
            if (liveRecommendMoreAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            liveRecommendMoreAdapter2.setFooterStatus(1);
            if (searchResultBean.recommendList != null) {
                LiveRecommendMoreAdapter liveRecommendMoreAdapter3 = this.G;
                if (liveRecommendMoreAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                }
                ArrayList<LiveRoomEntity> arrayList = searchResultBean.recommendList;
                Intrinsics.checkExpressionValueIsNotNull(arrayList, "searchBean.recommendList");
                liveRecommendMoreAdapter3.addNew(arrayList);
                return;
            }
            return;
        }
        LiveRecommendMoreAdapter liveRecommendMoreAdapter4 = this.G;
        if (liveRecommendMoreAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        liveRecommendMoreAdapter4.setFooterStatus(1);
        LiveRecommendMoreAdapter liveRecommendMoreAdapter5 = this.G;
        if (liveRecommendMoreAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        ArrayList<LiveRoomEntity> arrayList2 = searchResultBean.searchResultVideoList;
        Intrinsics.checkExpressionValueIsNotNull(arrayList2, "searchBean.searchResultVideoList");
        liveRecommendMoreAdapter5.addNew(arrayList2);
    }

    public final void s2(boolean z, boolean z2) {
        this.Q = z;
        if (z) {
            q2();
            if (z2) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.showToast(this, getResources().getString(R.string.obfuscated_res_0x7f0f0bd9));
                }
            }
            q50.d("sp_key_search_incognito_mode", true);
            return;
        }
        g2();
        if (z2) {
            LiveFeedPageSdk liveFeedPageSdk2 = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk2, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker2 = liveFeedPageSdk2.getInvoker();
            if (invoker2 != null) {
                invoker2.showToast(this, getResources().getString(R.string.obfuscated_res_0x7f0f0bda));
            }
        }
        q50.d("sp_key_search_incognito_mode", false);
    }

    public final void v2(String str) {
        if (Intrinsics.areEqual(str, "day")) {
            ImageView imageView = this.i;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080f5f);
            }
            ImageView imageView2 = this.u;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.obfuscated_res_0x7f080f6d);
            }
        } else if (Intrinsics.areEqual(str, "night")) {
            ImageView imageView3 = this.i;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.obfuscated_res_0x7f080f60);
            }
            ImageView imageView4 = this.u;
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.obfuscated_res_0x7f080f6e);
            }
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.setTextColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setTextColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
        }
        TextView textView3 = this.v;
        if (textView3 != null) {
            textView3.setTextColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        }
        TextView textView4 = this.w;
        if (textView4 != null) {
            textView4.setTextColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        }
        TextView textView5 = this.t;
        if (textView5 != null) {
            textView5.setTextColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        }
        TextView textView6 = this.s;
        if (textView6 != null) {
            textView6.setTextColor(f80.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
        }
    }
}
