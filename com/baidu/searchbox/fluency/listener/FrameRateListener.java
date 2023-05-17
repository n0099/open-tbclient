package com.baidu.searchbox.fluency.listener;

import androidx.annotation.CallSuper;
import com.baidu.searchbox.fluency.listener.FrameRateListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 #:\u0002#$B\u0007¢\u0006\u0004\b!\u0010\"JO\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0017¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJO\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010 ¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener;", "", "topPage", "", "startNs", "endNs", "", "dropFrames", "", "isVsyncFrame", "inputCostNs", "animationCostNs", "traversalCostNs", "", "collect", "(Ljava/lang/String;JJIZJJJ)V", "dropFrame", "doFrameAsync", "doFrameSync", "", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "frameList", "doReplay", "(Ljava/util/List;)V", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "getIntervalFrameReplay", "()I", "executor", "Ljava/util/concurrent/Executor;", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "<init>", "()V", "Companion", "FrameReplay", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class FrameRateListener {
    public static final Companion Companion = new Companion(null);
    public static final LinkedList<FrameReplay> framePool = new LinkedList<>();
    public final Executor executor;
    public final LinkedList<FrameReplay> frameList = new LinkedList<>();

    public void doFrameAsync(String topPage, long j, long j2, int i, boolean z, long j3, long j4, long j5) {
        Intrinsics.checkNotNullParameter(topPage, "topPage");
    }

    public void doFrameSync(String topPage, long j, long j2, int i, boolean z, long j3, long j4, long j5) {
        Intrinsics.checkNotNullParameter(topPage, "topPage");
    }

    public void doReplay(List<FrameReplay> frameList) {
        Intrinsics.checkNotNullParameter(frameList, "frameList");
    }

    public int getIntervalFrameReplay() {
        return 0;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 ,:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "", "recycle", "()V", "", "animationCostNs", "J", "getAnimationCostNs", "()J", "setAnimationCostNs", "(J)V", "", "dropFrame", "I", "getDropFrame", "()I", "setDropFrame", "(I)V", "endNs", "getEndNs", "setEndNs", "inputCostNs", "getInputCostNs", "setInputCostNs", "", "isVsyncFrame", "Z", "()Z", "setVsyncFrame", "(Z)V", "startNs", "getStartNs", "setStartNs", "", "topPage", "Ljava/lang/String;", "getTopPage", "()Ljava/lang/String;", "setTopPage", "(Ljava/lang/String;)V", "traversalCostNs", "getTraversalCostNs", "setTraversalCostNs", "<init>", "Companion", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class FrameReplay {
        public static final Companion Companion = new Companion(null);
        public long animationCostNs;
        public int dropFrame;
        public long endNs;
        public long inputCostNs;
        public boolean isVsyncFrame;
        public long startNs;
        public String topPage = "";
        public long traversalCostNs;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay$Companion;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "create", "()Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
        /* loaded from: classes3.dex */
        public static final class Companion {
            public Companion() {
            }

            public final FrameReplay create() {
                FrameReplay frameReplay;
                synchronized (FrameRateListener.framePool) {
                    frameReplay = (FrameReplay) FrameRateListener.framePool.poll();
                    Unit unit = Unit.INSTANCE;
                }
                if (frameReplay == null) {
                    return new FrameReplay();
                }
                Intrinsics.checkNotNull(frameReplay);
                return frameReplay;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final long getAnimationCostNs() {
            return this.animationCostNs;
        }

        public final int getDropFrame() {
            return this.dropFrame;
        }

        public final long getEndNs() {
            return this.endNs;
        }

        public final long getInputCostNs() {
            return this.inputCostNs;
        }

        public final long getStartNs() {
            return this.startNs;
        }

        public final String getTopPage() {
            return this.topPage;
        }

        public final long getTraversalCostNs() {
            return this.traversalCostNs;
        }

        public final boolean isVsyncFrame() {
            return this.isVsyncFrame;
        }

        public final void recycle() {
            if (FrameRateListener.framePool.size() <= 1000) {
                synchronized (FrameRateListener.framePool) {
                    this.topPage = "";
                    this.startNs = 0L;
                    this.endNs = 0L;
                    this.dropFrame = 0;
                    this.isVsyncFrame = false;
                    this.inputCostNs = 0L;
                    this.animationCostNs = 0L;
                    this.traversalCostNs = 0L;
                    FrameRateListener.framePool.add(this);
                }
            }
        }

        public final void setAnimationCostNs(long j) {
            this.animationCostNs = j;
        }

        public final void setDropFrame(int i) {
            this.dropFrame = i;
        }

        public final void setEndNs(long j) {
            this.endNs = j;
        }

        public final void setInputCostNs(long j) {
            this.inputCostNs = j;
        }

        public final void setStartNs(long j) {
            this.startNs = j;
        }

        public final void setTopPage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.topPage = str;
        }

        public final void setTraversalCostNs(long j) {
            this.traversalCostNs = j;
        }

        public final void setVsyncFrame(boolean z) {
            this.isVsyncFrame = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/fluency/listener/FrameRateListener$Companion;", "Ljava/util/LinkedList;", "Lcom/baidu/searchbox/fluency/listener/FrameRateListener$FrameReplay;", "framePool", "Ljava/util/LinkedList;", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Executor getExecutor() {
        return this.executor;
    }

    @CallSuper
    public void collect(String topPage, long j, long j2, int i, boolean z, long j3, long j4, long j5) {
        Intrinsics.checkNotNullParameter(topPage, "topPage");
        FrameReplay create = FrameReplay.Companion.create();
        create.setTopPage(topPage);
        create.setStartNs(j);
        create.setEndNs(j2);
        create.setDropFrame(i);
        create.setVsyncFrame(z);
        create.setInputCostNs(j3);
        create.setAnimationCostNs(j4);
        create.setTraversalCostNs(j5);
        this.frameList.add(create);
        if (this.frameList.size() >= getIntervalFrameReplay()) {
            final LinkedList linkedList = new LinkedList(this.frameList);
            this.frameList.clear();
            Executor executor = getExecutor();
            Intrinsics.checkNotNull(executor);
            executor.execute(new Runnable() { // from class: com.baidu.searchbox.fluency.listener.FrameRateListener$collect$1
                @Override // java.lang.Runnable
                public final void run() {
                    FrameRateListener.this.doReplay(linkedList);
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((FrameRateListener.FrameReplay) it.next()).recycle();
                    }
                }
            });
        }
    }
}
