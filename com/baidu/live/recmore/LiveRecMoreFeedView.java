package com.baidu.live.recmore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.business.LiveTabFeedView;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.listener.LiveFeedFollowListener;
import com.baidu.live.business.listener.TabFeedActionListener;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveFollowWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.recmore.ILiveRecMoreFeedView;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.ib0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bB\u0010*J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010#J\u0019\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010*J#\u0010+\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0010H\u0016¢\u0006\u0004\b-\u0010*J\u0019\u0010/\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b/\u00100J\u0019\u00103\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00102\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0010H\u0016¢\u0006\u0004\b9\u0010*J\u000f\u0010:\u001a\u00020\u0010H\u0016¢\u0006\u0004\b:\u0010*R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/baidu/live/recmore/LiveRecMoreFeedView;", "Lcom/baidu/live/recmore/ILiveRecMoreFeedView;", "Landroid/view/View;", "getErrorView", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "getTabIndicatorView", "()Landroid/view/ViewGroup;", "getView", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "Lcom/baidu/live/business/model/data/LiveFollowWrapData;", "followWrapData", "", "useNewStyle", "", "handleFollowData", "(Lcom/baidu/live/business/model/data/LiveFollowWrapData;Z)V", "", CriusAttrConstants.POSITION, "handleSubTab", "(I)V", "Lcom/baidu/live/business/model/data/LiveFeedData;", "feedData", "handleTabData", "(Lcom/baidu/live/business/model/data/LiveFeedData;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "subTabType", "thirdTabType", "initUiScene", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/String;)V", "isFirstTabIndicatorVisible", "()Z", "isViewPagerInFistPage", "Landroid/content/Context;", "context", "onCreate", "(Landroid/content/Context;)Landroid/view/View;", MissionEvent.MESSAGE_DESTROY, "()V", "onTabSelectedEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "resetView", "roomId", "setCurrentRoom", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/ILiveFeedModel;", "model", "setLiveFeedModel", "(Lcom/baidu/live/business/model/ILiveFeedModel;)V", "Lcom/baidu/live/recmore/ILiveRecMoreFeedView$LiveSubTabPageListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSubTabPageListener", "(Lcom/baidu/live/recmore/ILiveRecMoreFeedView$LiveSubTabPageListener;)V", "showContentView", "showErrorView", "bdUniqueId", "I", "Lcom/baidu/live/business/LiveTabFeedView;", "feedView", "Lcom/baidu/live/business/LiveTabFeedView;", "mListener", "Lcom/baidu/live/recmore/ILiveRecMoreFeedView$LiveSubTabPageListener;", "<init>", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecMoreFeedView implements ILiveRecMoreFeedView {
    public final int bdUniqueId;
    public LiveTabFeedView feedView;
    public ILiveRecMoreFeedView.LiveSubTabPageListener mListener;

    public LiveRecMoreFeedView() {
        ib0 a = ib0.a();
        Intrinsics.checkExpressionValueIsNotNull(a, "BdUniqueId.gen()");
        this.bdUniqueId = a.b();
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public View getErrorView() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            return liveTabFeedView.getMErrorView();
        }
        return null;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public ViewGroup getTabIndicatorView() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            return liveTabFeedView.getMSmartTabLayout();
        }
        return null;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public View getView() {
        return this.feedView;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public ViewPager getViewPager() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            return liveTabFeedView.getMViewPager();
        }
        return null;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public boolean isFirstTabIndicatorVisible() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null && liveTabFeedView.I()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public boolean isViewPagerInFistPage() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null && liveTabFeedView.L()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void onDestroy() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.Q();
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void resetView() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.c0();
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void showContentView() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.g0();
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void showErrorView() {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.h0();
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void handleSubTab(int i) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.A(i);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void handleTabData(LiveFeedData liveFeedData) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.B(liveFeedData);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public View onCreate(Context context) {
        LiveTabFeedView liveTabFeedView = new LiveTabFeedView(context, null, 0, 6, null);
        liveTabFeedView.setFeedActionListener(new TabFeedActionListener() { // from class: com.baidu.live.recmore.LiveRecMoreFeedView$onCreate$$inlined$apply$lambda$1
            @Override // com.baidu.live.business.listener.TabFeedActionListener
            public void onClickSearch() {
            }

            @Override // com.baidu.live.business.listener.TabFeedActionListener
            public void onClickStartLive(View view2, TextView textView) {
            }

            @Override // com.baidu.live.business.listener.TabFeedActionListener
            public void onSearchShowing(boolean z) {
            }

            @Override // com.baidu.live.business.listener.TabFeedActionListener
            public void onClickErrorRefresh() {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onClickErrorRefresh();
                }
            }
        });
        liveTabFeedView.setFeedFollowListener(new LiveFeedFollowListener() { // from class: com.baidu.live.recmore.LiveRecMoreFeedView$onCreate$$inlined$apply$lambda$2
            @Override // com.baidu.live.business.listener.LiveFeedFollowListener
            public void onClickFollow(LiveFollowEntity liveFollowEntity, int i) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onClickFollow(liveFollowEntity, i);
                }
            }

            @Override // com.baidu.live.business.listener.LiveFeedFollowListener
            public void onFollowShow(LiveFollowEntity liveFollowEntity, int i) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onFollowShow(liveFollowEntity, i);
                }
            }
        });
        liveTabFeedView.setSubTabPageListener(new LiveBaseFragment.a() { // from class: com.baidu.live.recmore.LiveRecMoreFeedView$onCreate$$inlined$apply$lambda$3
            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onBannerItemClick(LiveBannerEntity liveBannerEntity) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onFeedReserveHeaderItemClick(String str) {
            }

            public void onFeedReserveHeaderItemShow(String str) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onFeedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onHitCache(String str, String str2, String str3, String str4, String str5, int i, LiveFeedWrapData liveFeedWrapData, LiveFeedWrapData liveFeedWrapData2) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onItemPlayerEnd(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onItemPlayerStart(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onShowToast(String str) {
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onClickFeedItemRoom(LiveRoomEntity liveRoomEntity, int i) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onClickFeedItemRoom(liveRoomEntity, i);
                }
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onFeedItemRoomShow(LiveRoomEntity liveRoomEntity, int i) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onFeedItemRoomShow(liveRoomEntity, i);
                }
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onSlideLoadMore(String str, String str2) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onSlideLoadMore(str, str2);
                }
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onTabPageHideLog(String str, String str2) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onTabPageHideLog(str, str2);
                }
            }

            @Override // com.baidu.live.business.base.LiveBaseFragment.a
            public void onTabPageShowLog(String str, String str2) {
                ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener;
                liveSubTabPageListener = LiveRecMoreFeedView.this.mListener;
                if (liveSubTabPageListener != null) {
                    liveSubTabPageListener.onTabPageShowLog(str, str2);
                }
            }
        });
        this.feedView = liveTabFeedView;
        return liveTabFeedView;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void setCurrentRoom(String str) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.setCurrentRoom(str);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void setLiveFeedModel(ILiveFeedModel iLiveFeedModel) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.setFeedModel(iLiveFeedModel);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void setSubTabPageListener(ILiveRecMoreFeedView.LiveSubTabPageListener liveSubTabPageListener) {
        this.mListener = liveSubTabPageListener;
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void handleFollowData(LiveFollowWrapData liveFollowWrapData, boolean z) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            LiveTabFeedView.z(liveTabFeedView, liveFollowWrapData, z, null, 4, null);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void onTabSelectedEvent(String str, String str2) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.Y(str, str2);
        }
    }

    @Override // com.baidu.live.recmore.ILiveRecMoreFeedView
    public void initUiScene(FragmentManager fragmentManager, String str, String str2) {
        LiveTabFeedView liveTabFeedView = this.feedView;
        if (liveTabFeedView != null) {
            liveTabFeedView.F("recommend", false, this.bdUniqueId, fragmentManager, str, str2);
        }
    }
}
