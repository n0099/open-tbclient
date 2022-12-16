package com.baidu.live.recmore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveFollowWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001;J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000eH&¢\u0006\u0004\b$\u0010#J\u0019\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0010H&¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0010H&¢\u0006\u0004\b-\u0010*J\u0019\u0010/\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b/\u00100J\u0019\u00103\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u000101H&¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00102\u0006\u00106\u001a\u000205H&¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0010H&¢\u0006\u0004\b9\u0010*J\u000f\u0010:\u001a\u00020\u0010H&¢\u0006\u0004\b:\u0010*¨\u0006<"}, d2 = {"Lcom/baidu/live/recmore/ILiveRecMoreFeedView;", "Lkotlin/Any;", "Landroid/view/View;", "getErrorView", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "getTabIndicatorView", "()Landroid/view/ViewGroup;", "getView", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "Lcom/baidu/live/business/model/data/LiveFollowWrapData;", "followWrapData", "", "useNewStyle", "", "handleFollowData", "(Lcom/baidu/live/business/model/data/LiveFollowWrapData;Z)V", "", CriusAttrConstants.POSITION, "handleSubTab", "(I)V", "Lcom/baidu/live/business/model/data/LiveFeedData;", "feedData", "handleTabData", "(Lcom/baidu/live/business/model/data/LiveFeedData;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "subTabType", "thirdTabType", "initUiScene", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "isFirstTabIndicatorVisible", "()Z", "isViewPagerInFistPage", "Landroid/content/Context;", "context", "onCreate", "(Landroid/content/Context;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "()V", "onTabSelectedEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "resetView", "roomId", "setCurrentRoom", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/ILiveFeedModel;", "model", "setLiveFeedModel", "(Lcom/baidu/live/business/model/ILiveFeedModel;)V", "Lcom/baidu/live/recmore/ILiveRecMoreFeedView$LiveSubTabPageListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSubTabPageListener", "(Lcom/baidu/live/recmore/ILiveRecMoreFeedView$LiveSubTabPageListener;)V", "showContentView", "showErrorView", "LiveSubTabPageListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveRecMoreFeedView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u000eJ#\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0016\u0010\u0015J#\u0010\u0017\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/recmore/ILiveRecMoreFeedView$LiveSubTabPageListener;", "Lkotlin/Any;", "", "onClickErrorRefresh", "()V", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "roomEntity", "", CriusAttrConstants.POSITION, "onClickFeedItemRoom", "(Lcom/baidu/live/business/model/data/LiveRoomEntity;I)V", "Lcom/baidu/live/business/model/data/LiveFollowEntity;", "entity", "onClickFollow", "(Lcom/baidu/live/business/model/data/LiveFollowEntity;I)V", "onFeedItemRoomShow", "onFollowShow", "", "tab", "subTab", "onSlideLoadMore", "(Ljava/lang/String;Ljava/lang/String;)V", "onTabPageHideLog", "onTabPageShowLog", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface LiveSubTabPageListener {
        void onClickErrorRefresh();

        void onClickFeedItemRoom(LiveRoomEntity liveRoomEntity, int i);

        void onClickFollow(LiveFollowEntity liveFollowEntity, int i);

        void onFeedItemRoomShow(LiveRoomEntity liveRoomEntity, int i);

        void onFollowShow(LiveFollowEntity liveFollowEntity, int i);

        void onSlideLoadMore(String str, String str2);

        void onTabPageHideLog(String str, String str2);

        void onTabPageShowLog(String str, String str2);
    }

    View getErrorView();

    ViewGroup getTabIndicatorView();

    View getView();

    ViewPager getViewPager();

    void handleFollowData(LiveFollowWrapData liveFollowWrapData, boolean z);

    void handleSubTab(int i);

    void handleTabData(LiveFeedData liveFeedData);

    void initUiScene(FragmentManager fragmentManager, String str, String str2);

    boolean isFirstTabIndicatorVisible();

    boolean isViewPagerInFistPage();

    View onCreate(Context context);

    void onDestroy();

    void onTabSelectedEvent(String str, String str2);

    void resetView();

    void setCurrentRoom(String str);

    void setLiveFeedModel(ILiveFeedModel iLiveFeedModel);

    void setSubTabPageListener(LiveSubTabPageListener liveSubTabPageListener);

    void showContentView();

    void showErrorView();

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void handleFollowData$default(ILiveRecMoreFeedView iLiveRecMoreFeedView, LiveFollowWrapData liveFollowWrapData, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                iLiveRecMoreFeedView.handleFollowData(liveFollowWrapData, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleFollowData");
        }

        public static /* synthetic */ void onTabSelectedEvent$default(ILiveRecMoreFeedView iLiveRecMoreFeedView, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                iLiveRecMoreFeedView.onTabSelectedEvent(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTabSelectedEvent");
        }

        public static /* synthetic */ void initUiScene$default(ILiveRecMoreFeedView iLiveRecMoreFeedView, FragmentManager fragmentManager, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                iLiveRecMoreFeedView.initUiScene(fragmentManager, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initUiScene");
        }
    }
}
