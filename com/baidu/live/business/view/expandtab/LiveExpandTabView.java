package com.baidu.live.business.view.expandtab;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.view.expandtab.LiveExpandTabAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.oa0;
import com.baidu.tieba.ua0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002'(B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u0013¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0015\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/baidu/live/business/view/expandtab/LiveExpandTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "dismiss", "()V", "", "scene", "initView", "(Ljava/lang/String;)V", "uiMode", "onDarkModeChange", "onFontSizeChanged", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView$LiveExpandTabViewListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setLiveExpandTabViewListener", "(Lcom/baidu/live/business/view/expandtab/LiveExpandTabView$LiveExpandTabViewListener;)V", "", "Lcom/baidu/live/business/model/data/LiveTabEntity;", "tabs", "", "selectPos", "setTabs", "(Ljava/util/List;I)V", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabView$LiveExpandTabViewListener;", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter;", "mAdapter", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "mScene", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LiveExpandTabItemDecoration", "LiveExpandTabViewListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveExpandTabView extends ConstraintLayout {
    public RecyclerView a;
    public LiveExpandTabAdapter b;
    public b c;
    public String d;

    /* loaded from: classes3.dex */
    public interface b {
        void a(LiveTabEntity liveTabEntity);

        void b();

        void onDismiss();
    }

    @JvmOverloads
    public LiveExpandTabView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public LiveExpandTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/live/business/view/expandtab/LiveExpandTabView$LiveExpandTabItemDecoration;", "androidx/recyclerview/widget/RecyclerView$ItemDecoration", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "columnSpacing", "I", "<init>", "(I)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class LiveExpandTabItemDecoration extends RecyclerView.ItemDecoration {
        public final int a;

        public LiveExpandTabItemDecoration(int i) {
            this.a = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                int spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
                int i = childAdapterPosition % spanCount;
                int i2 = this.a;
                rect.left = (i * i2) / spanCount;
                rect.right = i2 - (((i + 1) * i2) / spanCount);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
    }

    /* loaded from: classes3.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            LiveExpandTabView.this.b();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements LiveExpandTabAdapter.a {
        public c(String str) {
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabAdapter.a
        public void a(LiveTabEntity liveTabEntity) {
            b bVar = LiveExpandTabView.this.c;
            if (bVar != null) {
                bVar.a(liveTabEntity);
            }
        }

        @Override // com.baidu.live.business.view.expandtab.LiveExpandTabAdapter.a
        public void b() {
            b bVar = LiveExpandTabView.this.c;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @JvmOverloads
    public LiveExpandTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05c1, (ViewGroup) this, true);
        setClickable(true);
        setDescendantFocusability(393216);
        this.a = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091562);
        setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0607b8));
        setOnClickListener(new a());
    }

    public /* synthetic */ LiveExpandTabView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void f(String str) {
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            ua0 ua0Var = ua0.a;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            recyclerView.setBackgroundDrawable(ua0Var.c(context, this.d));
        }
    }

    public final void setLiveExpandTabViewListener(b bVar) {
        this.c = bVar;
    }

    public final void b() {
        setVisibility(8);
        b bVar = this.c;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    public final void h() {
        LiveExpandTabAdapter liveExpandTabAdapter = this.b;
        if (liveExpandTabAdapter != null) {
            liveExpandTabAdapter.notifyDataSetChanged();
        }
    }

    public final void e(String str) {
        this.d = str;
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            ua0 ua0Var = ua0.a;
            Context context = recyclerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            recyclerView.setBackgroundDrawable(ua0Var.c(context, str));
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
            recyclerView.addItemDecoration(new LiveExpandTabItemDecoration(oa0.b(recyclerView.getContext(), 14.0f)));
            LiveExpandTabAdapter liveExpandTabAdapter = new LiveExpandTabAdapter(str);
            liveExpandTabAdapter.q(new c(str));
            this.b = liveExpandTabAdapter;
            recyclerView.setAdapter(liveExpandTabAdapter);
        }
    }

    public final void setTabs(List<? extends LiveTabEntity> list, int i) {
        LiveExpandTabAdapter liveExpandTabAdapter = this.b;
        if (liveExpandTabAdapter != null) {
            liveExpandTabAdapter.s(list, i);
        }
    }
}
