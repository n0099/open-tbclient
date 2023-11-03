package com.baidu.live.feedfollow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.adapter.LiveFeedPageConcernAdapter;
import com.baidu.live.business.listener.LiveFeedFollowListener;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveFollowWrapData;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.view.recyclerview.InterceptTouchRecyclerView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001#\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u000e¢\u0006\u0004\b8\u00109J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0019\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\rR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/baidu/live/feedfollow/view/LiveFeedFollowView;", "Landroid/widget/FrameLayout;", "", "scene", "", "initUiScene", "(Ljava/lang/String;)V", "", "isVideoMixScene", "()Z", "uiMode", "onDarkModeChange", MissionEvent.MESSAGE_DESTROY, "()V", "", "textSizeLevel", "onFontSizeChanged", "(I)V", "", "Lcom/baidu/live/business/model/data/LiveFollowEntity;", "followList", "Lcom/baidu/live/business/model/data/LiveFollowWrapData$FollowMore;", "followMore", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "config", "setConcernList", "(Ljava/util/List;Lcom/baidu/live/business/model/data/LiveFollowWrapData$FollowMore;Lcom/baidu/live/business/model/data/LiveFeedConfig;)V", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setFollowListener", "(Lcom/baidu/live/business/listener/LiveFeedFollowListener;)V", "useNewStyle", "setUseNewStyle", "(Z)V", "showAllFollow", "com/baidu/live/feedfollow/view/LiveFeedFollowView$actionListener$1", "actionListener", "Lcom/baidu/live/feedfollow/view/LiveFeedFollowView$actionListener$1;", "", "mAllFollowList", "Ljava/util/List;", "Lcom/baidu/live/business/adapter/LiveFeedPageConcernAdapter;", "mConcernListAdapter", "Lcom/baidu/live/business/adapter/LiveFeedPageConcernAdapter;", "Lcom/baidu/live/business/view/recyclerview/InterceptTouchRecyclerView;", "mConcernListRecyclerView", "Lcom/baidu/live/business/view/recyclerview/InterceptTouchRecyclerView;", "mFollowListener", "Lcom/baidu/live/business/listener/LiveFeedFollowListener;", "mScene", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedFollowView extends FrameLayout {
    public InterceptTouchRecyclerView a;
    public LiveFeedPageConcernAdapter b;
    public LiveFeedFollowListener c;
    public String d;
    public List<LiveFollowEntity> e;
    public a f;

    @JvmOverloads
    public LiveFeedFollowView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public LiveFeedFollowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* loaded from: classes3.dex */
    public static final class a implements LiveFeedPageConcernAdapter.d {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.d
        public void a(LiveFollowEntity liveFollowEntity, int i) {
            LiveFeedFollowListener liveFeedFollowListener = LiveFeedFollowView.this.c;
            if (liveFeedFollowListener != null) {
                liveFeedFollowListener.onFollowShow(liveFollowEntity, i);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.d
        public void b(LiveFollowEntity liveFollowEntity, int i) {
            if (LiveFeedFollowView.this.e() && liveFollowEntity.isMore) {
                LiveFeedFollowView.this.i();
            }
            LiveFeedFollowListener liveFeedFollowListener = LiveFeedFollowView.this.c;
            if (liveFeedFollowListener != null) {
                liveFeedFollowListener.onClickFollow(liveFollowEntity, i);
            }
        }
    }

    @JvmOverloads
    public LiveFeedFollowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ArrayList();
        this.f = new a();
        this.a = new InterceptTouchRecyclerView(context);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
        InterceptTouchRecyclerView interceptTouchRecyclerView = this.a;
        if (interceptTouchRecyclerView != null) {
            interceptTouchRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        }
        addView(this.a);
    }

    public /* synthetic */ LiveFeedFollowView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void d(String str) {
        this.d = str;
        InterceptTouchRecyclerView interceptTouchRecyclerView = this.a;
        if (interceptTouchRecyclerView != null) {
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(getContext(), str);
            this.b = liveFeedPageConcernAdapter;
            liveFeedPageConcernAdapter.t(this.f);
            interceptTouchRecyclerView.setAdapter(liveFeedPageConcernAdapter);
        }
    }

    public final void f(String str) {
        LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.b;
        if (liveFeedPageConcernAdapter != null) {
            liveFeedPageConcernAdapter.notifyDataSetChanged();
        }
    }

    public final void h(int i) {
        LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.b;
        if (liveFeedPageConcernAdapter != null) {
            liveFeedPageConcernAdapter.notifyDataSetChanged();
        }
    }

    public final void setFollowListener(LiveFeedFollowListener liveFeedFollowListener) {
        this.c = liveFeedFollowListener;
    }

    public final void setUseNewStyle(boolean z) {
        LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.b;
        if (liveFeedPageConcernAdapter != null) {
            liveFeedPageConcernAdapter.u(z);
        }
    }

    public final boolean e() {
        if (!Intrinsics.areEqual(this.d, LiveFeedPageSdk.FOLLOW_VIDEO) && !Intrinsics.areEqual(this.d, LiveFeedPageSdk.VIDEO_BAR)) {
            return false;
        }
        return true;
    }

    public final void g() {
        LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.b;
        if (liveFeedPageConcernAdapter != null) {
            liveFeedPageConcernAdapter.q();
        }
    }

    public final void i() {
        LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.b;
        if (liveFeedPageConcernAdapter != null) {
            List<LiveFollowEntity> list = this.e;
            liveFeedPageConcernAdapter.s(list, list.size());
        }
    }

    public final void setConcernList(List<? extends LiveFollowEntity> list, LiveFollowWrapData.FollowMore followMore, LiveFeedConfig liveFeedConfig) {
        int i;
        if (e()) {
            if (liveFeedConfig != null) {
                i = liveFeedConfig.getFollowShowNum();
            } else {
                i = 20;
            }
            if (list.size() > i) {
                this.e.clear();
                this.e.addAll(list);
                List<LiveFollowEntity> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list.subList(0, i));
                LiveFollowEntity liveFollowEntity = new LiveFollowEntity();
                liveFollowEntity.isMore = true;
                LiveHostInfo liveHostInfo = new LiveHostInfo();
                liveHostInfo.name = (followMore == null || (r4 = followMore.txt) == null) ? "查看更多" : "查看更多";
                liveFollowEntity.hostInfo = liveHostInfo;
                mutableList.add(liveFollowEntity);
                LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.b;
                if (liveFeedPageConcernAdapter != null) {
                    liveFeedPageConcernAdapter.s(mutableList, list.size());
                    return;
                }
                return;
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter2 = this.b;
            if (liveFeedPageConcernAdapter2 != null) {
                liveFeedPageConcernAdapter2.s(list, list.size());
                return;
            }
            return;
        }
        List<LiveFollowEntity> mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        if (followMore != null) {
            LiveFollowEntity liveFollowEntity2 = new LiveFollowEntity();
            liveFollowEntity2.isMore = true;
            liveFollowEntity2.cmd = followMore.scheme;
            LiveHostInfo liveHostInfo2 = new LiveHostInfo();
            liveHostInfo2.name = followMore.txt;
            liveFollowEntity2.hostInfo = liveHostInfo2;
            mutableList2.add(liveFollowEntity2);
        }
        LiveFeedPageConcernAdapter liveFeedPageConcernAdapter3 = this.b;
        if (liveFeedPageConcernAdapter3 != null) {
            liveFeedPageConcernAdapter3.s(mutableList2, list.size());
        }
    }
}
