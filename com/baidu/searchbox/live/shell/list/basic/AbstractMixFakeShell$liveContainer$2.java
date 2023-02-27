package com.baidu.searchbox.live.shell.list.basic;

import com.baidu.searchbox.live.widget.LiveContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/live/widget/LiveContainer;", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AbstractMixFakeShell$liveContainer$2 extends Lambda implements Function0<LiveContainer> {
    public final /* synthetic */ AbstractMixFakeShell this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMixFakeShell$liveContainer$2(AbstractMixFakeShell abstractMixFakeShell) {
        super(0);
        this.this$0 = abstractMixFakeShell;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LiveContainer invoke() {
        LiveContainer liveContainer = new LiveContainer(this.this$0.getContext(), null, 0, 6, null);
        liveContainer.setAttachListener(new LiveContainer.ViewAttachListener() { // from class: com.baidu.searchbox.live.shell.list.basic.AbstractMixFakeShell$liveContainer$2$$special$$inlined$apply$lambda$1
            @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
            public void onDataChanged(LiveContainer.LiveItemModel liveItemModel) {
                AbstractMixFakeShell$liveContainer$2.this.this$0.onLiveBindData(liveItemModel);
            }

            @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
            public void onAttach() {
                AbstractMixFakeShell$liveContainer$2.this.this$0.onLiveAttach();
            }

            @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
            public void onDetach() {
                AbstractMixFakeShell$liveContainer$2.this.this$0.onLiveDetach();
            }

            @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
            public void onDeselected(int i, LiveContainer.LiveItemModel liveItemModel) {
                AbstractMixFakeShell$liveContainer$2.this.this$0.onLiveDeselected();
            }

            @Override // com.baidu.searchbox.live.widget.LiveContainer.ViewAttachListener
            public void onSelected(int i, LiveContainer.LiveItemModel liveItemModel, boolean z) {
                AbstractMixFakeShell$liveContainer$2.this.this$0.onPageSelected(i, liveItemModel, z);
            }
        });
        return liveContainer;
    }
}
