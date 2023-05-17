package com.baidu.live.feed.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;
import com.baidu.mobstat.Config;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/view/MotionEvent;", Config.EVENT_PART, "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "release", "()V", "Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView$Callback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView$Callback;", "getCallback", "()Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView$Callback;", "setCallback", "(Lcom/baidu/live/feed/search/view/LiveCustomNestedScrollView$Callback;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Callback", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveCustomNestedScrollView extends NestedScrollView {
    public a a;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public LiveCustomNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        this.a = null;
    }

    public final a getCallback() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (motionEvent.getAction() == 0 && (aVar = this.a) != null) {
            if (aVar == null) {
                Intrinsics.throwNpe();
            }
            aVar.a();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setCallback(a aVar) {
        this.a = aVar;
    }
}
