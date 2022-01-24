package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.x.b.d.c.d;
import c.a.x.c.a.b;
import c.a.x.c.a.c;
import c.a.x.c.a.e;
import c.a.x.g.g.j;
import c.a.x.k.f;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f34752b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f34753c;

    /* renamed from: d  reason: collision with root package name */
    public Context f34754d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34755e;

    /* renamed from: f  reason: collision with root package name */
    public String f34756f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f34757g;

    /* loaded from: classes10.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public LottieAnimationView f34758b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f34759c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f34760d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f34761e;

        /* renamed from: f  reason: collision with root package name */
        public String f34762f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34762f = "";
        }
    }

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f34763e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f34764f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageConcernAdapter f34765g;

        public a(LiveFeedPageConcernAdapter liveFeedPageConcernAdapter, int i2, ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageConcernAdapter, Integer.valueOf(i2), viewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34765g = liveFeedPageConcernAdapter;
            this.f34763e = i2;
            this.f34764f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveFeedPageSdk.m("FollowItemClick: position: " + this.f34763e);
                int i2 = this.f34763e;
                if (i2 < 0 || i2 >= this.f34765g.f34753c.size() || this.f34765g.f34753c.get(this.f34763e) == null) {
                    return;
                }
                LiveFeedPageSdk.m("FollowItemClick: scheme: " + ((d) this.f34765g.f34753c.get(this.f34763e)).f26621d);
                d dVar = (d) this.f34765g.f34753c.get(this.f34763e);
                String str = this.f34765g.f34755e ? "chenjinshi" : "zhibopindao";
                if (dVar.a) {
                    LiveFeedPageSdk.f().g().invokeScheme(this.f34764f.itemView.getContext(), dVar.f26621d);
                    c.a.x.b.c.a.j(this.f34765g.f34754d, this.f34765g.a, str);
                    return;
                }
                LiveFeedPageSdk.f().g().invokeScheme(this.f34764f.itemView.getContext(), dVar.f26621d);
                LiveHostInfo liveHostInfo = dVar.f26622e;
                c.a.x.b.c.a.h(this.f34765g.f34754d, this.f34765g.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.f34763e + 1, dVar.f26620c, dVar.f26619b, dVar.f26623f);
            }
        }
    }

    public LiveFeedPageConcernAdapter(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34753c = new ArrayList();
        this.f34754d = context;
        this.a = str;
        this.f34755e = z;
        this.f34752b = LayoutInflater.from(context);
        this.f34756f = f.e().o();
        float a2 = c.a.x.b.f.a.a(this.f34754d, 8.0f);
        this.f34757g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    public final void e(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (lottieAnimationView = viewHolder.f34758b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.f34758b.cancelAnimation();
        }
    }

    public final void f(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.f34755e) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else {
            lottieAnimationView.setAnimation("live_feed_page_shinning_night.json");
        }
    }

    public final void g(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || (lottieAnimationView = viewHolder.f34758b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.f34758b.isAnimating()) {
            return;
        }
        viewHolder.f34758b.playAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34753c.size() : invokeV.intValue;
    }

    public void setConcernList(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || c.a.x.g.g.d.c(list)) {
            return;
        }
        List<d> list2 = this.f34753c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f34753c = new ArrayList();
        }
        this.f34753c.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (dVar = (d) c.a.x.g.g.d.b(this.f34753c, i2)) == null) {
            return;
        }
        if (dVar.f26624g) {
            String str = this.f34755e ? "chenjinshi" : "zhibopindao";
            if (dVar.a) {
                c.a.x.b.c.a.k(this.f34754d, this.a, str);
            } else {
                LiveHostInfo liveHostInfo = dVar.f26622e;
                c.a.x.b.c.a.i(this.f34754d, this.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i2 + 1, dVar.f26620c, dVar.f26619b, dVar.f26623f);
            }
            dVar.f26624g = false;
        }
        if (dVar.a) {
            e(viewHolder);
            if (this.f34755e) {
                viewHolder.f34761e.setImageResource(b.live_feed_page_follow_jump_more_imm);
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
                viewHolder.f34761e.setImageResource(b.live_feed_page_follow_jump_more_day);
            } else {
                viewHolder.f34761e.setImageResource(b.live_feed_page_follow_jump_more_night);
            }
            viewHolder.f34761e.setVisibility(0);
            viewHolder.f34758b.setVisibility(8);
            viewHolder.f34760d.setVisibility(8);
            viewHolder.f34759c.setVisibility(8);
        } else {
            viewHolder.f34761e.setVisibility(8);
            viewHolder.f34758b.setVisibility(0);
            viewHolder.f34760d.setVisibility(0);
            viewHolder.f34759c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = dVar.f26622e;
            if (liveHostInfo2 != null) {
                viewHolder.f34759c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.f34760d.setTextColor(f.e().a(this.f34754d, this.f34755e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = dVar.f26622e;
        if (liveHostInfo3 != null) {
            if (j.a(liveHostInfo3.name)) {
                viewHolder.a.setText(e.live_feed_page_follow_jump_more_txt);
            } else {
                viewHolder.a.setText(dVar.f26622e.name);
            }
            viewHolder.a.setTextColor(f.e().a(this.f34754d, this.f34755e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i2, viewHolder));
        viewHolder.f34759c.getHierarchy().setPlaceholderImage(f.e().j(this.f34755e), ScalingUtils.ScaleType.FIT_XY);
        if (this.f34755e) {
            viewHolder.f34759c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f.e().a(this.f34754d, this.f34755e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.f34757g);
        gradientDrawable.setStroke(c.a.x.b.f.a.a(this.f34754d, 1.0f), f.e().a(this.f34754d, this.f34755e, "color_white1"));
        viewHolder.f34760d.setBackgroundDrawable(gradientDrawable);
        this.f34756f = f.e().o();
        if (j.a(viewHolder.f34762f) || viewHolder.f34762f.equals(this.f34756f)) {
            return;
        }
        viewHolder.f34762f = this.f34756f;
        if (viewHolder.f34758b.isAnimating()) {
            viewHolder.f34758b.cancelAnimation();
        }
        f(viewHolder.f34758b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.f34752b.inflate(c.a.x.c.a.d.live_feed_page_follow_list_layout, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(c.tv_item_name);
            viewHolder.f34760d = (TextView) inflate.findViewById(c.avatar_tip);
            viewHolder.f34761e = (ImageView) inflate.findViewById(c.follow_jump_more);
            viewHolder.f34758b = (LottieAnimationView) inflate.findViewById(c.avatar_lottie);
            viewHolder.f34759c = (SimpleDraweeView) inflate.findViewById(c.avatar_iv);
            viewHolder.f34762f = this.f34756f;
            f(viewHolder.f34758b);
            viewHolder.f34758b.loop(true);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewHolder) == null) {
            super.onViewAttachedToWindow((LiveFeedPageConcernAdapter) viewHolder);
            g(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewHolder) == null) {
            super.onViewDetachedFromWindow((LiveFeedPageConcernAdapter) viewHolder);
            e(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewHolder) == null) {
            super.onViewRecycled((LiveFeedPageConcernAdapter) viewHolder);
            e(viewHolder);
        }
    }
}
