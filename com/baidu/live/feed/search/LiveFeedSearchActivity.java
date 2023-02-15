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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.eb0;
import com.baidu.tieba.fb0;
import com.baidu.tieba.fd0;
import com.baidu.tieba.ia0;
import com.baidu.tieba.mb0;
import com.baidu.tieba.pc0;
import com.baidu.tieba.qa0;
import com.baidu.tieba.wa0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ¹\u00012\u00020\u00012\u00020\u0002:\u0002¹\u0001B\b¢\u0006\u0005\b¸\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\r\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u0005J\u001d\u0010!\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u00032\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010\"J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00032\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001fH\u0016¢\u0006\u0004\b,\u0010\"JA\u00104\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020-2\b\b\u0002\u00103\u001a\u00020-¢\u0006\u0004\b4\u00105J/\u0010:\u001a\u00020\u00032\u000e\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010#2\u000e\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010#H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0003H\u0002¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010\u0005J\u000f\u0010>\u001a\u00020\u0003H\u0016¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0003H\u0016¢\u0006\u0004\b?\u0010\u0005J\u0017\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0003H\u0002¢\u0006\u0004\bD\u0010\u0005J\u0017\u0010F\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0016H\u0016¢\u0006\u0004\bF\u0010\u0019J!\u0010I\u001a\u00020\u00032\u0006\u0010G\u001a\u00020-2\b\b\u0002\u0010H\u001a\u00020-H\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0003H\u0002¢\u0006\u0004\bK\u0010\u0005J\u0017\u0010L\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\bL\u0010\u0019R\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010YR\u0018\u0010`\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010YR\u0018\u0010a\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010UR\u0018\u0010b\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010UR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010f\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010UR\u0018\u0010g\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010RR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010UR\u0018\u0010l\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010YR\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010YR\u0016\u0010q\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010[R\u0016\u0010r\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010[R\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010\u008e\u0001R!\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008d\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010YR\u001a\u0010\u0099\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010eR\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009d\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010YR*\u0010\u009e\u0001\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0005\b¢\u0001\u0010CR\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001a\u0010¦\u0001\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010YR\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010\u00ad\u0001\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010eR#\u0010³\u0001\u001a\u00030®\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R#\u0010¶\u0001\u001a\u00030®\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b´\u0001\u0010°\u0001\u001a\u0006\bµ\u0001\u0010²\u0001R\u001a\u0010·\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b·\u0001\u0010R¨\u0006º\u0001"}, d2 = {"Lcom/baidu/live/feed/search/LiveFeedSearchActivity;", "Lcom/baidu/tieba/eb0;", "Landroidx/appcompat/app/AppCompatActivity;", "", "attachKeyboard", "()V", "checkFirstScreenDataIntegrity", "clearHistoryList", "", "posotion", "followCallback", "(I)V", "hideIncognitoModeBgView", "hideLoading", "hideSoftInput", "hideSuggestView", "initData", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "uiMode", "onDarkModeChange", "(Ljava/lang/String;)V", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "releaseHotRank", "resetRequestData", "", "historyList", "setHistoryList", "(Ljava/util/List;)V", "", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "entities", "setHotRank", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;", "presenter", "setPresenter", "(Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;)V", "hintList", "setQueryHintList", "", "sug", "record", "hotrank", "result", "error", SchemeCollecter.CLASSIFY_EMPTY, "setRecyccleVisiable", "(ZZZZZZ)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "setSuggestions", "(Ljava/util/List;Ljava/util/List;)V", "showHistoryRecord", "showIncognitoModeBgView", "showLoading", "showSearchError", "Lcom/baidu/live/feed/search/model/data/SearchResultBean;", "searchBean", "showSearchResult", "(Lcom/baidu/live/feed/search/model/data/SearchResultBean;)V", "showSuggestView", "content", "showToast", "isEnterIncognito", "isShowToast", "switchIncognitoMode", "(ZZ)V", "ubcLogSearchResultPageShowEnd", "updateIncognitoModeBg", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "adapter", "Lcom/baidu/live/feed/search/adapter/LiveRecommendMoreAdapter;", "Landroid/widget/ImageView;", "backIcon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "completeText", "Landroid/widget/TextView;", "deleteAllText", "Landroid/view/View;", "deleteIcon", "Landroid/view/View;", "firstScreenLoadSuccess", "Z", "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;", "historyRecordAdapter", "Lcom/baidu/live/feed/search/adapter/LiveSearchHistoryRecordAdapter;", "historyRecordHeadDelete", "historyRecordHeadNomal", "historyTitleOne", "historyTitleTwo", "Landroidx/recyclerview/widget/RecyclerView;", "hotRankView", "Landroidx/recyclerview/widget/RecyclerView;", "incognitoModeBgDes", "incognitoModeBgIcon", "Landroid/view/ViewStub;", "incognitoModeBgStub", "Landroid/view/ViewStub;", "incognitoModeBgTip", "incognitoModeBgView", "Landroid/widget/Button;", "incognitoModeBtn", "Landroid/widget/Button;", "incognitoModeView", "isInIncognito", "isRecommend", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManagerHotRank", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManagerRecommend", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "layoutManagerRecord", "Lcom/baidu/live/business/view/emotion/EmptyView;", "mEmptyView", "Lcom/baidu/live/business/view/emotion/EmptyView;", "Lcom/baidu/live/business/view/emotion/ErrorView;", "mErrorView", "Lcom/baidu/live/business/view/emotion/ErrorView;", "Lcom/baidu/ubc/Flow;", "mFlow", "Lcom/baidu/ubc/Flow;", "Lcom/baidu/live/business/view/emotion/LoadingView;", "mLoadingView", "Lcom/baidu/live/business/view/emotion/LoadingView;", "Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView;", "nestedScrollView", "Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView;", "pageNum", "I", "Lcom/baidu/live/feed/search/presenter/LiveFeedSearchContract$Presenter;", "recommednList", "Ljava/util/List;", "recommendPn", "Lcom/baidu/live/feed/search/view/LoadRecyclerView;", "recyclerViewRecommend", "Lcom/baidu/live/feed/search/view/LoadRecyclerView;", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "requestSearchData", "Lcom/baidu/live/feed/search/model/data/RequestSearchData;", "rootContentView", "searchHistoryView", "Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "searchPanel", "Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "searchRecordView", "searchResultBean", "Lcom/baidu/live/feed/search/model/data/SearchResultBean;", "getSearchResultBean", "()Lcom/baidu/live/feed/search/model/data/SearchResultBean;", "setSearchResultBean", "Landroid/view/ViewGroup;", "searchResultContainer", "Landroid/view/ViewGroup;", "searchResultGradientSpace", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine;", "searchStateMachine", "Lcom/baidu/live/feed/search/presenter/LiveSearchStateMachine;", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "searchSuggestionAdapter", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "searchSuggestionsRv", "Landroidx/recyclerview/widget/DividerItemDecoration;", "suggestionListDivider$delegate", "Lkotlin/Lazy;", "getSuggestionListDivider", "()Landroidx/recyclerview/widget/DividerItemDecoration;", "suggestionListDivider", "suggestionListDividerNight$delegate", "getSuggestionListDividerNight", "suggestionListDividerNight", "trashIcon", "<init>", "Companion", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedSearchActivity extends AppCompatActivity implements eb0 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] W;
    public transient /* synthetic */ FieldHolder $fh;
    public fb0 A;
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
    public int P;
    public boolean Q;
    public LiveSearchStateMachine R;
    public Flow S;
    public RequestSearchData T;
    public final Lazy U;
    public final Lazy V;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1113713839, "Lcom/baidu/live/feed/search/LiveFeedSearchActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1113713839, "Lcom/baidu/live/feed/search/LiveFeedSearchActivity;");
                return;
            }
        }
        W = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchActivity.class), "suggestionListDivider", "getSuggestionListDivider()Landroidx/recyclerview/widget/DividerItemDecoration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedSearchActivity.class), "suggestionListDividerNight", "getSuggestionListDividerNight()Landroidx/recyclerview/widget/DividerItemDecoration;"))};
    }

    public final DividerItemDecoration Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Lazy lazy = this.U;
            KProperty kProperty = W[0];
            return (DividerItemDecoration) lazy.getValue();
        }
        return (DividerItemDecoration) invokeV.objValue;
    }

    public final DividerItemDecoration Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Lazy lazy = this.V;
            KProperty kProperty = W[1];
            return (DividerItemDecoration) lazy.getValue();
        }
        return (DividerItemDecoration) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class a implements mb0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public a(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.tieba.mb0.b
        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z || this.a.e == null) {
                    View view2 = this.a.e;
                    if (view2 != null) {
                        view2.setTranslationY(0.0f);
                    }
                    View view3 = this.a.e;
                    if (view3 != null) {
                        view3.setVisibility(8);
                        return;
                    }
                    return;
                }
                View view4 = this.a.e;
                if (view4 == null) {
                    Intrinsics.throwNpe();
                }
                view4.setVisibility(0);
                View view5 = this.a.e;
                if (view5 == null) {
                    Intrinsics.throwNpe();
                }
                View view6 = this.a.e;
                if (view6 == null) {
                    Intrinsics.throwNpe();
                }
                view5.setTranslationY(-(view6.getTranslationY() + mb0.c(this.a)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public b(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.isFinishing()) {
                return;
            }
            this.a.b2();
            this.a.finish();
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements LiveCustomNestedScrollView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public c(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.view.LiveCustomNestedScrollView.a
        public void a() {
            View currentFocus;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (currentFocus = this.a.getCurrentFocus()) != null) {
                mb0.h(currentFocus);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements LiveSearchHistoryRecordAdapter.recordListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public d(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter.recordListener
        public void deleteAllRecord() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fb0 fb0Var = this.a.A;
                if (fb0Var != null) {
                    Context applicationContext = this.a.getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                    fb0Var.b(applicationContext);
                }
                if (!this.a.Q) {
                    LiveFeedSearchActivity.i2(this.a, false, true, true, false, false, false, 48, null);
                    this.a.j2();
                    return;
                }
                LiveFeedSearchActivity.i2(this.a, false, false, false, false, false, false, 48, null);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter.recordListener
        public void deleteClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                fb0 fb0Var = this.a.A;
                if (fb0Var != null) {
                    Context applicationContext = this.a.getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                    fb0Var.f(applicationContext, i);
                }
                if (!this.a.Q) {
                    LiveFeedSearchActivity.i2(this.a, false, true, true, false, false, false, 48, null);
                    this.a.j2();
                    View view2 = this.a.o;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    View view3 = this.a.p;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = this.a.C;
                    if (liveSearchHistoryRecordAdapter != null) {
                        liveSearchHistoryRecordAdapter.trashClick();
                        return;
                    }
                    return;
                }
                LiveFeedSearchActivity.i2(this.a, false, false, false, false, false, false, 48, null);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHistoryRecordAdapter.recordListener
        public void historyItemClick(String str, String str2, boolean z, int i) {
            fb0 fb0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (!this.a.Q && (fb0Var = this.a.A) != null) {
                    Context applicationContext = this.a.getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                    fb0Var.a(applicationContext, str);
                }
                this.a.L = 0;
                LiveFeedSearchActivity.p1(this.a).resetData();
                LiveFeedSearchActivity.p1(this.a).setShowMore(false);
                RecyclerView recyclerView = this.a.m;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                LoadRecyclerView C1 = LiveFeedSearchActivity.C1(this.a);
                if (C1 != null) {
                    C1.setVisibility(8);
                }
                ViewGroup viewGroup = this.a.D;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                LiveSearchPanel liveSearchPanel = this.a.c;
                if (liveSearchPanel != null) {
                    liveSearchPanel.k(str);
                }
                ia0.F(this.a.getApplicationContext(), String.valueOf(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements LiveSearchHotRankAdapter.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public e(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter.Callback
        public void onItemClick(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.invokeScheme(this.a, str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements LiveRecommendMoreAdapter.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onItemShow(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, liveRoomEntity, i) == null) {
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onUbcResultClick(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) {
            }
        }

        public f(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void jumpAuthorView(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.o2();
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
            if (invoker != null) {
                invoker.invokeScheme(this.a.getApplicationContext(), str);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
            fb0 fb0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveSearchResultInfo, i) == null) && (fb0Var = this.a.A) != null) {
                Context applicationContext = this.a.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                fb0Var.j(liveSearchResultInfo, applicationContext, i);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onRecItemClick(LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, liveRoomEntity, i) == null) {
                this.a.o2();
                if (i >= 0) {
                    LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                    ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                    if (invoker != null) {
                        invoker.invokeScheme(this.a.getApplicationContext(), (liveRoomEntity == null || (r5 = liveRoomEntity.cmd) == null) ? "" : "");
                    }
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onSearchResultItemClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, liveSearchResultInfo, i) == null) {
                this.a.o2();
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    Context applicationContext = this.a.getApplicationContext();
                    String str = liveSearchResultInfo.cmd;
                    if (str == null) {
                        str = "";
                    }
                    invoker.invokeScheme(applicationContext, str);
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onRetryLoadMore() {
            String text;
            fb0 fb0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && LiveFeedSearchActivity.p1(this.a).getFooterStatus() == 4) {
                LiveFeedSearchActivity.p1(this.a).setFooterStatus(2);
                this.a.L++;
                LiveSearchPanel liveSearchPanel = this.a.c;
                if (liveSearchPanel != null && (text = liveSearchPanel.getText()) != null && (fb0Var = this.a.A) != null) {
                    fb0.a.a(fb0Var, text, String.valueOf(this.a.L), null, 4, null);
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onShowMoreClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                LiveFeedSearchActivity.C1(this.a).setLayoutManager(this.a.H);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveRecommendMoreAdapter.OnItemClickListener
        public void onUbcResult(boolean z, List<? extends LiveRoomEntity> list, List<? extends LiveSearchResultInfo> list2, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i), str}) == null) {
                if (z) {
                    if (i < list2.size() && i >= 0) {
                        ia0.Q(this.a.getApplicationContext(), null, list2.get(i), Boolean.valueOf(z), i, str);
                    }
                } else if (i < list.size() && i >= 0) {
                    ia0.Q(this.a.getApplicationContext(), list.get(i), null, Boolean.valueOf(z), i, str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public g(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            View view3 = this.a.o;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.a.p;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = this.a.C;
            if (liveSearchHistoryRecordAdapter != null) {
                liveSearchHistoryRecordAdapter.trashClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public h(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            View view3 = this.a.o;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this.a.p;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = this.a.C;
            if (liveSearchHistoryRecordAdapter != null) {
                liveSearchHistoryRecordAdapter.completeClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public i(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            fb0 fb0Var = this.a.A;
            if (fb0Var != null) {
                Context applicationContext = this.a.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                fb0Var.b(applicationContext);
            }
            if (!this.a.Q) {
                LiveFeedSearchActivity.i2(this.a, false, true, true, false, false, false, 48, null);
                this.a.j2();
                return;
            }
            LiveFeedSearchActivity.i2(this.a, false, false, false, false, false, false, 48, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j implements LoadRecyclerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        @Override // com.baidu.live.feed.search.view.LoadRecyclerView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public j(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.view.LoadRecyclerView.b
        public void a(boolean z) {
            Boolean bool;
            String text;
            fb0 fb0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.O) {
                    LiveFeedSearchActivity.p1(this.a).setFooterStatus(2);
                    this.a.P++;
                    RequestSearchData requestSearchData = this.a.T;
                    if (requestSearchData != null) {
                        requestSearchData.refreshIndex = String.valueOf(this.a.P);
                    }
                    fb0 fb0Var2 = this.a.A;
                    if (fb0Var2 != null) {
                        fb0Var2.g(AdvanceSetting.NETWORK_TYPE, String.valueOf(this.a.L), this.a.T);
                        return;
                    }
                    return;
                }
                this.a.O = false;
                SearchResultBean X1 = this.a.X1();
                if (X1 != null) {
                    bool = Boolean.valueOf(X1.hasmore);
                } else {
                    bool = null;
                }
                if (bool == null) {
                    Intrinsics.throwNpe();
                }
                if (!bool.booleanValue()) {
                    LiveFeedSearchActivity.p1(this.a).setFooterStatus(3);
                    return;
                }
                LiveFeedSearchActivity.p1(this.a).setFooterStatus(2);
                this.a.L++;
                LiveSearchPanel liveSearchPanel = this.a.c;
                if (liveSearchPanel != null && (text = liveSearchPanel.getText()) != null && (fb0Var = this.a.A) != null) {
                    fb0.a.a(fb0Var, text, String.valueOf(this.a.L), null, 4, null);
                }
                ia0.O(this.a.getApplicationContext(), String.valueOf(this.a.L));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class k implements wa0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public k(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.tieba.wa0
        public final void a(View view2) {
            LiveSearchPanel liveSearchPanel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (liveSearchPanel = this.a.c) != null) {
                liveSearchPanel.k(liveSearchPanel.getText());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class l implements LiveSearchPanel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public l(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LiveSearchPanel liveSearchPanel = this.a.c;
                if (liveSearchPanel != null && !liveSearchPanel.h()) {
                    LiveSearchPanel liveSearchPanel2 = this.a.c;
                    if (liveSearchPanel2 != null) {
                        liveSearchPanel2.l();
                    }
                    LiveSearchPanel liveSearchPanel3 = this.a.c;
                    if (liveSearchPanel3 != null) {
                        liveSearchPanel3.r();
                    }
                }
                if (!this.a.Q) {
                    LiveFeedSearchActivity.i2(this.a, false, true, true, false, false, false, 48, null);
                    this.a.j2();
                    return;
                }
                LiveFeedSearchActivity.i2(this.a, false, false, false, false, false, false, 48, null);
            }
        }

        @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
        public void onQueryTextChange(String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                fb0 fb0Var = this.a.A;
                if (fb0Var != null) {
                    fb0Var.d();
                }
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    LiveSearchStateMachine liveSearchStateMachine = this.a.R;
                    if (liveSearchStateMachine != null) {
                        liveSearchStateMachine.b(LiveSearchStateMachine.SearchState.STATE_INIT);
                    }
                    LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.a.B;
                    if (liveFeedSearchSuggestionAdapter != null) {
                        LiveFeedSearchSuggestionAdapter.setSuggestions$default(liveFeedSearchSuggestionAdapter, null, null, null, 4, null);
                    }
                    if (this.a.Q) {
                        this.a.k2();
                        return;
                    }
                    LiveFeedSearchActivity.i2(this.a, false, true, true, false, false, false, 48, null);
                    this.a.j2();
                    return;
                }
                LiveSearchStateMachine liveSearchStateMachine2 = this.a.R;
                if (liveSearchStateMachine2 != null) {
                    liveSearchStateMachine2.b(LiveSearchStateMachine.SearchState.STATE_INPUT);
                }
                fb0 fb0Var2 = this.a.A;
                if (fb0Var2 != null) {
                    fb0Var2.i(str);
                }
                this.a.a2();
                LiveFeedSearchActivity.i2(this.a, true, false, false, false, false, false, 48, null);
            }
        }

        @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
        public void onQueryTextSubmit(String str) {
            fb0 fb0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                LiveSearchStateMachine liveSearchStateMachine = this.a.R;
                if (liveSearchStateMachine != null) {
                    liveSearchStateMachine.b(LiveSearchStateMachine.SearchState.STATE_RESULT);
                }
                ia0.E(this.a.getApplicationContext());
                if (str != null) {
                    this.a.c2();
                    if (!this.a.Q && (fb0Var = this.a.A) != null) {
                        Context applicationContext = this.a.getApplicationContext();
                        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                        fb0Var.a(applicationContext, str);
                    }
                    this.a.L = 0;
                    LiveFeedSearchActivity.p1(this.a).resetData();
                    LiveFeedSearchActivity.p1(this.a).setShowMore(false);
                    LiveFeedSearchActivity.i2(this.a, false, false, false, false, false, false, 48, null);
                    fb0 fb0Var2 = this.a.A;
                    if (fb0Var2 != null) {
                        fb0.a.a(fb0Var2, str, "0", null, 4, null);
                    }
                    this.a.l2();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public m(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ia0.M(this.a.getApplicationContext());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public n(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            Button button = this.a.f;
            LiveSearchStateMachine.SearchState searchState = null;
            if (button == null || !button.isSelected()) {
                Button button2 = this.a.f;
                if (button2 != null) {
                    button2.setSelected(true);
                }
                LiveFeedSearchActivity.n2(this.a, true, false, 2, null);
                LiveSearchStateMachine liveSearchStateMachine = this.a.R;
                if (liveSearchStateMachine != null) {
                    searchState = liveSearchStateMachine.a();
                }
                if (searchState != LiveSearchStateMachine.SearchState.STATE_INIT) {
                    return;
                }
                RecyclerView recyclerView = this.a.m;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
                View view3 = this.a.r;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
                RecyclerView recyclerView2 = this.a.n;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(8);
                    return;
                }
                return;
            }
            Button button3 = this.a.f;
            if (button3 != null) {
                button3.setSelected(false);
            }
            LiveFeedSearchActivity.n2(this.a, false, false, 2, null);
            LiveSearchStateMachine liveSearchStateMachine2 = this.a.R;
            if (liveSearchStateMachine2 != null) {
                searchState = liveSearchStateMachine2.a();
            }
            if (searchState != LiveSearchStateMachine.SearchState.STATE_INIT) {
                return;
            }
            RecyclerView recyclerView3 = this.a.m;
            if (recyclerView3 != null) {
                recyclerView3.setVisibility(0);
            }
            View view4 = this.a.r;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            RecyclerView recyclerView4 = this.a.n;
            if (recyclerView4 != null) {
                recyclerView4.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class o implements LiveFeedSearchSuggestionAdapter.OnSuggestionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedSearchActivity a;

        public o(LiveFeedSearchActivity liveFeedSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedSearchActivity;
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void jumpAuthorView(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.invokeScheme(this.a.getApplicationContext(), str);
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onResultClick(LiveSearchResultInfo liveSearchResultInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, liveSearchResultInfo) == null) {
                LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                if (invoker != null) {
                    invoker.invokeScheme(this.a.getApplicationContext(), liveSearchResultInfo.cmd);
                }
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i) {
            fb0 fb0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveSearchResultInfo, i) == null) && (fb0Var = this.a.A) != null) {
                Context applicationContext = this.a.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                fb0Var.j(liveSearchResultInfo, applicationContext, i);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onSuggestionClick(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
                LiveSearchPanel liveSearchPanel = this.a.c;
                if (liveSearchPanel != null) {
                    liveSearchPanel.k(str);
                }
                this.a.c2();
                ia0.U(this.a.getApplicationContext(), i);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onSuggestionSelect(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, str, i) == null) {
                LiveSearchPanel liveSearchPanel = this.a.c;
                if (liveSearchPanel != null) {
                    liveSearchPanel.setText(str);
                }
                ia0.T(this.a.getApplicationContext(), i);
            }
        }

        @Override // com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter.OnSuggestionListener
        public void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048581, this, list, i, str) == null) && i >= 0 && i < list.size()) {
                ia0.D(this.a.getApplicationContext(), list.get(i), String.valueOf(i), str);
            }
        }
    }

    public LiveFeedSearchActivity() {
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
        this.P = 1;
        this.T = new RequestSearchData();
        this.U = LazyKt__LazyJVMKt.lazy(new Function0<DividerItemDecoration>(this) { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$suggestionListDivider$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LiveFeedSearchActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DividerItemDecoration invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.this$0, 1);
                    Drawable drawable = ContextCompat.getDrawable(this.this$0.getApplicationContext(), R.drawable.obfuscated_res_0x7f080d99);
                    if (drawable != null) {
                        dividerItemDecoration.setDrawable(drawable);
                    }
                    return dividerItemDecoration;
                }
                return (DividerItemDecoration) invokeV.objValue;
            }
        });
        this.V = LazyKt__LazyJVMKt.lazy(new Function0<DividerItemDecoration>(this) { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$suggestionListDividerNight$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LiveFeedSearchActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DividerItemDecoration invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.this$0, 1);
                    Drawable drawable = ContextCompat.getDrawable(this.this$0.getApplicationContext(), R.drawable.obfuscated_res_0x7f080d9a);
                    if (drawable != null) {
                        dividerItemDecoration.setDrawable(drawable);
                    }
                    return dividerItemDecoration;
                }
                return (DividerItemDecoration) invokeV.objValue;
            }
        });
    }

    public final void b2() {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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
            fb0 fb0Var = this.A;
            if (fb0Var != null) {
                fb0Var.onDetach();
            }
            LiveCustomNestedScrollView liveCustomNestedScrollView = this.l;
            if (liveCustomNestedScrollView != null) {
                liveCustomNestedScrollView.a();
            }
            f2();
        }
    }

    public static final /* synthetic */ LoadRecyclerView C1(LiveFeedSearchActivity liveFeedSearchActivity) {
        LoadRecyclerView loadRecyclerView = liveFeedSearchActivity.F;
        if (loadRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
        }
        return loadRecyclerView;
    }

    public static final /* synthetic */ LiveRecommendMoreAdapter p1(LiveFeedSearchActivity liveFeedSearchActivity) {
        LiveRecommendMoreAdapter liveRecommendMoreAdapter = liveFeedSearchActivity.G;
        if (liveRecommendMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return liveRecommendMoreAdapter;
    }

    public static final /* synthetic */ GridLayoutManager w1(LiveFeedSearchActivity liveFeedSearchActivity) {
        GridLayoutManager gridLayoutManager = liveFeedSearchActivity.M;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        }
        return gridLayoutManager;
    }

    @Override // com.baidu.tieba.eb0
    public void X0(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            LiveSearchPanel liveSearchPanel = this.c;
            if (liveSearchPanel != null) {
                LiveSearchPanel.setQueryHintList$default(liveSearchPanel, null, list, 1, null);
            }
            ia0.N(getApplicationContext());
        }
    }

    @Override // com.baidu.tieba.eb0
    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
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
    }

    @Override // com.baidu.tieba.eb0
    public void q(fb0 fb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, fb0Var) == null) {
            this.A = fb0Var;
        }
    }

    @Override // com.baidu.tieba.eb0
    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
            ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
            if (invoker != null) {
                invoker.showToast(getApplicationContext(), str);
            }
        }
    }

    public static /* synthetic */ void i2(LiveFeedSearchActivity liveFeedSearchActivity, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
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
        liveFeedSearchActivity.h2(z, z2, z3, z4, z7, z8);
    }

    public static /* synthetic */ void n2(LiveFeedSearchActivity liveFeedSearchActivity, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        liveFeedSearchActivity.m2(z, z2);
    }

    @Override // com.baidu.tieba.eb0
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i2(this, false, false, true, false, false, false, 48, null);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mb0.b(this, null, new a(this));
        }
    }

    public final SearchResultBean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.K;
        }
        return (SearchResultBean) invokeV.objValue;
    }

    public final void a2() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view2 = this.h) != null) {
            view2.setVisibility(8);
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = this.B;
            if (liveFeedSearchSuggestionAdapter != null) {
                LiveFeedSearchSuggestionAdapter.setSuggestions$default(liveFeedSearchSuggestionAdapter, null, null, null, 4, null);
            }
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.eb0
    public void e0() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (loadingView = this.x) != null) {
            loadingView.setVisibility(8);
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.P = 1;
            RequestSearchData requestSearchData = this.T;
            requestSearchData.refreshIndex = "1";
            requestSearchData.requestType = "search";
            this.O = false;
        }
    }

    @Override // com.baidu.tieba.eb0
    public void l() {
        LiveSearchStateMachine.SearchState searchState;
        ErrorView errorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
    }

    public void l2() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (loadingView = this.x) != null) {
            loadingView.setVisibility(0);
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ia0.P(getApplicationContext(), false, this.S);
            this.S = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        fb0 fb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onResume();
            ia0.L(getApplicationContext());
            LoadingView loadingView = this.x;
            if (loadingView != null) {
                loadingView.e();
            }
            RecyclerView recyclerView = this.n;
            if (recyclerView != null && recyclerView.getVisibility() == 0 && (fb0Var = this.A) != null) {
                fb0Var.h();
            }
        }
    }

    public final void W1() {
        SearchResultBean searchResultBean;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (searchResultBean = this.K) != null) {
            if (searchResultBean.searchResultVideoList.isEmpty() && searchResultBean.searchResultList.isEmpty()) {
                ArrayList<LiveRoomEntity> arrayList = searchResultBean.recommendList;
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.O = true;
                    this.P = 1;
                    String genUploadJson = GrParasmUtil.genUploadJson();
                    RequestSearchData requestSearchData = this.T;
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
                    h2(false, false, false, true, false, false);
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
                h2(false, false, false, false, false, true);
            } else if (searchResultBean.searchResultVideoList.isEmpty() && !searchResultBean.searchResultList.isEmpty()) {
                this.O = true;
                this.P = 1;
                h2(false, false, false, true, false, false);
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
                g2();
                h2(false, false, false, true, false, false);
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
                g2();
                h2(false, false, false, true, false, false);
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

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            new LiveFeedSearchPresenter(this);
            boolean a2 = qa0.a("sp_key_search_incognito_mode", false);
            this.Q = a2;
            Button button = this.f;
            if (button != null) {
                button.setSelected(a2);
            }
            m2(this.Q, false);
            if (!this.Q) {
                i2(this, false, true, true, false, false, false, 48, null);
                j2();
            } else {
                i2(this, false, false, false, false, false, false, 48, null);
            }
            fb0 fb0Var = this.A;
            if (fb0Var != null) {
                fb0Var.c();
            }
        }
    }

    public final void f2() {
        RecyclerView recyclerView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (recyclerView = this.n) != null) {
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

    public final void j2() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
            i2(this, false, true, true, false, false, false, 48, null);
            fb0 fb0Var = this.A;
            if (fb0Var != null) {
                Context applicationContext = getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
                fb0Var.e(applicationContext);
            }
        }
    }

    public final void e2(String str) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            View view2 = this.a;
            if (view2 != null) {
                view2.setBackgroundColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_white1"));
            }
            LiveSearchPanel liveSearchPanel = this.c;
            if (liveSearchPanel != null) {
                liveSearchPanel.i(str);
            }
            if (Intrinsics.areEqual(str, "day")) {
                ImageView imageView = this.b;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080d80);
                }
                Button button = this.f;
                if (button != null) {
                    button.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d89);
                }
            } else if (Intrinsics.areEqual(str, "night")) {
                ImageView imageView2 = this.b;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.obfuscated_res_0x7f080d81);
                }
                Button button2 = this.f;
                if (button2 != null) {
                    button2.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d8a);
                }
            }
            View view3 = this.e;
            if (view3 != null) {
                view3.setBackgroundColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_EEEEEE"));
            }
            p2(str);
            RecyclerView recyclerView2 = this.d;
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(Y1());
            }
            RecyclerView recyclerView3 = this.d;
            if (recyclerView3 != null) {
                recyclerView3.removeItemDecoration(Z1());
            }
            if (Intrinsics.areEqual(str, "day")) {
                RecyclerView recyclerView4 = this.d;
                if (recyclerView4 != null) {
                    recyclerView4.addItemDecoration(Y1());
                }
            } else if (Intrinsics.areEqual(str, "night") && (recyclerView = this.d) != null) {
                recyclerView.addItemDecoration(Z1());
            }
            ViewGroup viewGroup = this.D;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_F5F5F51"));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{fd0.f().a(this, LiveFeedPageSdk.HOST_LIVE_TAB, "color_white1"), fd0.f().a(this, LiveFeedPageSdk.HOST_LIVE_TAB, "color_F5F5F51")});
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
    }

    @Override // com.baidu.tieba.eb0
    public void f0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, list2) == null) {
            if (this.B == null) {
                LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter = new LiveFeedSearchSuggestionAdapter(this, LiveFeedPageSdk.HOST_LIVE_TAB);
                liveFeedSearchSuggestionAdapter.setSuggestionListener(new o(this));
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
    }

    public final void h2(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        fb0 fb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
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
                ia0.R(getApplicationContext());
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
                if ((recyclerView5 == null || recyclerView5.getVisibility() != 0) && (fb0Var = this.A) != null) {
                    fb0Var.h();
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
    }

    public final void initView() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091477);
            ((ViewGroup) findViewById).setPadding(0, pc0.e(getApplicationContext()), 0, 0);
            this.a = findViewById;
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091476);
            imageView.setOnClickListener(new b(this));
            this.b = imageView;
            this.e = findViewById(R.id.obfuscated_res_0x7f091475);
            this.f = (Button) findViewById(R.id.obfuscated_res_0x7f091474);
            this.g = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091472);
            this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f09147a);
            this.l = (LiveCustomNestedScrollView) findViewById(R.id.obfuscated_res_0x7f091f05);
            this.m = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091470);
            this.n = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091471);
            this.c = (LiveSearchPanel) findViewById(R.id.obfuscated_res_0x7f091478);
            this.D = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09149d);
            this.E = findViewById(R.id.obfuscated_res_0x7f09149e);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0914cb);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.livesh…arch_recommend_more_live)");
            this.F = (LoadRecyclerView) findViewById2;
            this.o = findViewById(R.id.obfuscated_res_0x7f091494);
            this.p = findViewById(R.id.obfuscated_res_0x7f09148d);
            this.q = findViewById(R.id.obfuscated_res_0x7f09148a);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f091489);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09149b);
            this.r = findViewById(R.id.obfuscated_res_0x7f09148e);
            this.u = (ImageView) findViewById(R.id.obfuscated_res_0x7f09147d);
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09147b);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f09147c);
            EmptyView emptyView = (EmptyView) findViewById(R.id.obfuscated_res_0x7f09146d);
            this.z = emptyView;
            if (emptyView != null) {
                emptyView.a(LiveFeedPageSdk.HOST_LIVE_TAB);
            }
            ErrorView errorView = (ErrorView) findViewById(R.id.obfuscated_res_0x7f09146e);
            this.y = errorView;
            if (errorView != null) {
                errorView.c(LiveFeedPageSdk.HOST_LIVE_TAB);
            }
            ErrorView errorView2 = this.y;
            if (errorView2 != null) {
                errorView2.setActionCallback(new k(this));
            }
            LoadingView loadingView = (LoadingView) findViewById(R.id.obfuscated_res_0x7f09146f);
            this.x = loadingView;
            if (loadingView != null) {
                loadingView.c(LiveFeedPageSdk.HOST_LIVE_TAB);
            }
            e0();
            RecyclerView recyclerView = this.d;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(Y1());
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
                liveSearchPanel3.setQueryListener(new l(this));
            }
            LiveSearchPanel liveSearchPanel4 = this.c;
            if (liveSearchPanel4 != null) {
                liveSearchPanel4.setOnEditClickListener(new m(this));
            }
            Button button = this.f;
            if (button != null) {
                button.setOnClickListener(new n(this));
            }
            LiveCustomNestedScrollView liveCustomNestedScrollView = this.l;
            if (liveCustomNestedScrollView != null) {
                liveCustomNestedScrollView.setCallback(new c(this));
            }
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
            LiveSearchHistoryRecordAdapter liveSearchHistoryRecordAdapter = new LiveSearchHistoryRecordAdapter(applicationContext);
            liveSearchHistoryRecordAdapter.setDeleteListener(new d(this));
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
                liveSearchHotRankAdapter.setCallback(new e(this));
                recyclerView7.setAdapter(liveSearchHotRankAdapter);
            }
            View view2 = this.q;
            if (view2 != null) {
                view2.setOnClickListener(new g(this));
            }
            TextView textView = this.s;
            if (textView != null) {
                textView.setOnClickListener(new h(this));
            }
            TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setOnClickListener(new i(this));
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
            liveRecommendMoreAdapter.setListener(new f(this));
            this.G = liveRecommendMoreAdapter;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
            this.M = gridLayoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$initView$14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveFeedSearchActivity a;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
                    this.a = this;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i2)) == null) {
                        if (LiveFeedSearchActivity.p1(this.a).isBottomView(i2)) {
                            return LiveFeedSearchActivity.w1(this.a).getSpanCount();
                        }
                        return 1;
                    }
                    return invokeI.intValue;
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
            loadRecyclerView4.setOnLoadListener(new j(this));
            LoadRecyclerView loadRecyclerView5 = this.F;
            if (loadRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
            }
            loadRecyclerView5.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.live.feed.search.LiveFeedSearchActivity$initView$16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView8, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView8, i2) == null) {
                        super.onScrollStateChanged(recyclerView8, i2);
                        if (i2 == 0 && this.a) {
                            this.a = false;
                        }
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView8, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView8, i2, i3) == null) {
                        super.onScrolled(recyclerView8, i2, i3);
                        if (i2 != 0 || i3 != 0) {
                            this.a = true;
                        }
                    }
                }
            });
            V1();
        }
    }

    public final void k2() {
        LiveSearchStateMachine.SearchState searchState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
                this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f091491);
                this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091493);
                this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f091492);
            } else if (view3 != null) {
                view3.setVisibility(0);
            }
            fd0 f2 = fd0.f();
            Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
            String r = f2.r();
            Intrinsics.checkExpressionValueIsNotNull(r, "UIModeUtils.getInstance().uiMode");
            p2(r);
        }
    }

    public final void m2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.Q = z;
            if (z) {
                k2();
                if (z2) {
                    LiveFeedPageSdk liveFeedPageSdk = LiveFeedPageSdk.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk, "LiveFeedPageSdk.getInstance()");
                    ILiveFeedPageInvoke invoker = liveFeedPageSdk.getInvoker();
                    if (invoker != null) {
                        invoker.showToast(this, getResources().getString(R.string.obfuscated_res_0x7f0f0aba));
                    }
                }
                qa0.d("sp_key_search_incognito_mode", true);
                return;
            }
            a2();
            if (z2) {
                LiveFeedPageSdk liveFeedPageSdk2 = LiveFeedPageSdk.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(liveFeedPageSdk2, "LiveFeedPageSdk.getInstance()");
                ILiveFeedPageInvoke invoker2 = liveFeedPageSdk2.getInvoker();
                if (invoker2 != null) {
                    invoker2.showToast(this, getResources().getString(R.string.obfuscated_res_0x7f0f0abb));
                }
            }
            qa0.d("sp_key_search_incognito_mode", false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            pc0.h(this, false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0575);
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
            d2();
            fd0 f2 = fd0.f();
            Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
            String r = f2.r();
            Intrinsics.checkExpressionValueIsNotNull(r, "UIModeUtils.getInstance().uiMode");
            e2(r);
        }
    }

    @Override // com.baidu.tieba.eb0
    public void t(List<String> list) {
        RecyclerView.Adapter adapter;
        RecyclerView.Adapter adapter2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
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
    }

    public final void p2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (Intrinsics.areEqual(str, "day")) {
                ImageView imageView = this.i;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080d87);
                }
                ImageView imageView2 = this.u;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.obfuscated_res_0x7f080d95);
                }
            } else if (Intrinsics.areEqual(str, "night")) {
                ImageView imageView3 = this.i;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.obfuscated_res_0x7f080d88);
                }
                ImageView imageView4 = this.u;
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.obfuscated_res_0x7f080d96);
                }
            }
            TextView textView = this.j;
            if (textView != null) {
                textView.setTextColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                textView2.setTextColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_858585"));
            }
            TextView textView3 = this.v;
            if (textView3 != null) {
                textView3.setTextColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
            }
            TextView textView4 = this.w;
            if (textView4 != null) {
                textView4.setTextColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
            }
            TextView textView5 = this.t;
            if (textView5 != null) {
                textView5.setTextColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
            }
            TextView textView6 = this.s;
            if (textView6 != null) {
                textView6.setTextColor(fd0.f().a(getApplicationContext(), LiveFeedPageSdk.HOST_LIVE_TAB, "color_1F1F1F"));
            }
        }
    }

    @Override // com.baidu.tieba.eb0
    public void u(SearchResultBean searchResultBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, searchResultBean) == null) {
            e0();
            i2(this, false, false, false, true, false, false, 48, null);
            b2();
            this.K = searchResultBean;
            LiveRecommendMoreAdapter liveRecommendMoreAdapter = this.G;
            if (liveRecommendMoreAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            if (liveRecommendMoreAdapter.isEmptyList()) {
                this.N = searchResultBean.searchResultVideoList;
                this.S = ia0.P(getApplicationContext(), true, null);
                W1();
                return;
            }
            LoadRecyclerView loadRecyclerView = this.F;
            if (loadRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewRecommend");
            }
            loadRecyclerView.h();
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
    }

    @Override // com.baidu.tieba.eb0
    public void w0(List<? extends LiveRoomEntity> list) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, list) == null) && (recyclerView = this.n) != null && (recyclerView.getAdapter() instanceof LiveSearchHotRankAdapter)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                ((LiveSearchHotRankAdapter) adapter).updateData(list);
                if (list != null && (!list.isEmpty())) {
                    ia0.K(getApplicationContext());
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.baidu.live.feed.search.adapter.LiveSearchHotRankAdapter");
        }
    }
}
