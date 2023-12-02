package com.baidu.live.business.view.expandtab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.m60;
import com.baidu.tieba.t80;
import com.baidu.tieba.x80;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0003*+,B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010%R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "Lcom/baidu/live/business/model/data/LiveTabEntity;", "getPositionData", "(I)Lcom/baidu/live/business/model/data/LiveTabEntity;", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ExpandTabViewHolder;", "holder", "", "onBindViewHolder", "(Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ExpandTabViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ExpandTabViewHolder;", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemClickListener", "(Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ItemClickListener;)V", "pos", "setSelect", "(I)V", "", "tabs", "selectPos", "setTabs", "(Ljava/util/List;I)V", "Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ItemClickListener;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "I", "tabList", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", "Companion", "ExpandTabViewHolder", "ItemClickListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveExpandTabAdapter extends RecyclerView.Adapter<ExpandTabViewHolder> {
    public List<? extends LiveTabEntity> a;
    public a b;
    public int c;
    public final String d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(LiveTabEntity liveTabEntity);

        void b();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0016\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/baidu/live/business/view/expandtab/LiveExpandTabAdapter$ExpandTabViewHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "", "adapterFontSize", "()V", "", CriusAttrConstants.POSITION, "selectPos", "Lcom/baidu/live/business/model/data/LiveTabEntity;", "tabEntity", UbcRemoteStat.BIND_SERVICE, "(IILcom/baidu/live/business/model/data/LiveTabEntity;)V", "Landroid/widget/TextView;", "content", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "Landroid/view/View;", "rootView", "Landroid/view/View;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "view", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class ExpandTabViewHolder extends RecyclerView.ViewHolder {
        public View a;
        public ImageView b;
        public TextView c;
        public final View d;
        public final String e;

        public ExpandTabViewHolder(View view2, String str) {
            super(view2);
            this.d = view2;
            this.e = str;
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f091635);
            this.b = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091634);
            this.c = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091636);
            a();
        }

        public final void a() {
            Drawable drawable;
            Context context;
            Resources resources;
            TextView textView = this.c;
            if (textView != null) {
                t80.k(textView, 1, 12.0f, 0, 0, 12, null);
            }
            View view2 = this.a;
            if (view2 != null && (context = view2.getContext()) != null && (resources = context.getResources()) != null) {
                drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f080f7f);
            } else {
                drawable = null;
            }
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setImageDrawable(t80.b(drawable, 0, 0, 6, null));
            }
        }

        public final void b(int i, int i2, LiveTabEntity liveTabEntity) {
            String str;
            a();
            if (i == 3) {
                ImageView imageView = this.b;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                TextView textView2 = this.c;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                ImageView imageView2 = this.b;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                TextView textView3 = this.c;
                if (textView3 != null) {
                    if (liveTabEntity != null) {
                        str = liveTabEntity.name;
                    } else {
                        str = null;
                    }
                    textView3.setText(str);
                }
            }
            if (i2 == i) {
                View view2 = this.a;
                if (view2 != null) {
                    m60 m60Var = m60.a;
                    Context context = this.d.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
                    view2.setBackgroundDrawable(m60Var.e(context, this.e));
                }
                TextView textView4 = this.c;
                if (textView4 != null) {
                    textView4.setTextColor(x80.f().a(this.d.getContext(), this.e, "color_FF33551"));
                    return;
                }
                return;
            }
            View view3 = this.a;
            if (view3 != null) {
                m60 m60Var2 = m60.a;
                Context context2 = this.d.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "view.context");
                view3.setBackgroundDrawable(m60Var2.b(context2, this.e));
            }
            TextView textView5 = this.c;
            if (textView5 != null) {
                textView5.setTextColor(x80.f().a(this.d.getContext(), this.e, "color_525252"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public final /* synthetic */ int b;

        public b(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            if (this.b == 3) {
                a aVar = LiveExpandTabAdapter.this.b;
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            a aVar2 = LiveExpandTabAdapter.this.b;
            if (aVar2 == null) {
                return;
            }
            LiveTabEntity o = LiveExpandTabAdapter.this.o(this.b);
            if (o == null) {
                o = new LiveTabEntity();
            }
            aVar2.a(o);
        }
    }

    public LiveExpandTabAdapter(String str) {
        this.d = str;
    }

    public final LiveTabEntity o(int i) {
        if (i == 3) {
            return null;
        }
        if (i < 3) {
            List<? extends LiveTabEntity> list = this.a;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        List<? extends LiveTabEntity> list2 = this.a;
        if (list2 == null) {
            return null;
        }
        return list2.get(i - 1);
    }

    public final void r(a aVar) {
        this.b = aVar;
    }

    public final void s(int i) {
        if (i >= 3) {
            i++;
        }
        this.c = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(ExpandTabViewHolder expandTabViewHolder, int i) {
        expandTabViewHolder.b(i, this.c, o(i));
        expandTabViewHolder.itemView.setOnClickListener(new b(i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public ExpandTabViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05f9, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…rent, false\n            )");
        return new ExpandTabViewHolder(inflate, this.d);
    }

    public final void t(List<? extends LiveTabEntity> list, int i) {
        this.a = list;
        s(i);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends LiveTabEntity> list = this.a;
        if (list != null) {
            return list.size() + 1;
        }
        return 0;
    }
}
