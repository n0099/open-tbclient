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
import c.a.v.b.d.c.d;
import c.a.v.c.a.b;
import c.a.v.c.a.c;
import c.a.v.c.a.e;
import c.a.v.e.g.j;
import c.a.v.i.f;
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
/* loaded from: classes5.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f40531a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f40532b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f40533c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40534d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40535e;

    /* renamed from: f  reason: collision with root package name */
    public String f40536f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f40537g;

    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f40538a;

        /* renamed from: b  reason: collision with root package name */
        public LottieAnimationView f40539b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f40540c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f40541d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f40542e;

        /* renamed from: f  reason: collision with root package name */
        public String f40543f;

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
            this.f40543f = "";
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f40544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f40545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageConcernAdapter f40546g;

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
            this.f40546g = liveFeedPageConcernAdapter;
            this.f40544e = i2;
            this.f40545f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveFeedPageSdk.l("FollowItemClick: position: " + this.f40544e);
                int i2 = this.f40544e;
                if (i2 < 0 || i2 >= this.f40546g.f40533c.size() || this.f40546g.f40533c.get(this.f40544e) == null) {
                    return;
                }
                LiveFeedPageSdk.l("FollowItemClick: scheme: " + ((d) this.f40546g.f40533c.get(this.f40544e)).f29996d);
                d dVar = (d) this.f40546g.f40533c.get(this.f40544e);
                String str = this.f40546g.f40535e ? "chenjinshi" : "zhibopindao";
                if (dVar.f29993a) {
                    LiveFeedPageSdk.e().f().invokeScheme(this.f40545f.itemView.getContext(), dVar.f29996d);
                    c.a.v.b.c.a.j(this.f40546g.f40534d, this.f40546g.f40531a, str);
                    return;
                }
                LiveFeedPageSdk.e().f().invokeScheme(this.f40545f.itemView.getContext(), dVar.f29996d);
                LiveHostInfo liveHostInfo = dVar.f29997e;
                c.a.v.b.c.a.h(this.f40546g.f40534d, this.f40546g.f40531a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.f40544e + 1, dVar.f29995c, dVar.f29994b, dVar.f29998f);
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
        this.f40533c = new ArrayList();
        this.f40534d = context;
        this.f40531a = str;
        this.f40535e = z;
        this.f40532b = LayoutInflater.from(context);
        this.f40536f = f.e().n();
        float a2 = c.a.v.b.f.a.a(this.f40534d, 8.0f);
        this.f40537g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    public final void e(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (lottieAnimationView = viewHolder.f40539b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.f40539b.cancelAnimation();
        }
    }

    public final void f(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.f40535e) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().n()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().n())) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else {
            lottieAnimationView.setAnimation("live_feed_page_shinning_night.json");
        }
    }

    public final void g(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || (lottieAnimationView = viewHolder.f40539b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.f40539b.isAnimating()) {
            return;
        }
        viewHolder.f40539b.playAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40533c.size() : invokeV.intValue;
    }

    public void setConcernList(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || c.a.v.e.g.d.c(list)) {
            return;
        }
        List<d> list2 = this.f40533c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f40533c = new ArrayList();
        }
        this.f40533c.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (dVar = (d) c.a.v.e.g.d.b(this.f40533c, i2)) == null) {
            return;
        }
        if (dVar.f29999g) {
            String str = this.f40535e ? "chenjinshi" : "zhibopindao";
            if (dVar.f29993a) {
                c.a.v.b.c.a.k(this.f40534d, this.f40531a, str);
            } else {
                LiveHostInfo liveHostInfo = dVar.f29997e;
                c.a.v.b.c.a.i(this.f40534d, this.f40531a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i2 + 1, dVar.f29995c, dVar.f29994b, dVar.f29998f);
            }
            dVar.f29999g = false;
        }
        if (dVar.f29993a) {
            e(viewHolder);
            if (this.f40535e) {
                viewHolder.f40542e.setImageResource(b.live_feed_page_follow_jump_more_imm);
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().n()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().n())) {
                viewHolder.f40542e.setImageResource(b.live_feed_page_follow_jump_more_day);
            } else {
                viewHolder.f40542e.setImageResource(b.live_feed_page_follow_jump_more_night);
            }
            viewHolder.f40542e.setVisibility(0);
            viewHolder.f40539b.setVisibility(8);
            viewHolder.f40541d.setVisibility(8);
            viewHolder.f40540c.setVisibility(8);
        } else {
            viewHolder.f40542e.setVisibility(8);
            viewHolder.f40539b.setVisibility(0);
            viewHolder.f40541d.setVisibility(0);
            viewHolder.f40540c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = dVar.f29997e;
            if (liveHostInfo2 != null) {
                viewHolder.f40540c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.f40541d.setTextColor(f.e().a(this.f40534d, this.f40535e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = dVar.f29997e;
        if (liveHostInfo3 != null) {
            if (j.a(liveHostInfo3.name)) {
                viewHolder.f40538a.setText(e.live_feed_page_follow_jump_more_txt);
            } else {
                viewHolder.f40538a.setText(dVar.f29997e.name);
            }
            viewHolder.f40538a.setTextColor(f.e().a(this.f40534d, this.f40535e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i2, viewHolder));
        viewHolder.f40540c.getHierarchy().setPlaceholderImage(f.e().j(this.f40535e), ScalingUtils.ScaleType.FIT_XY);
        if (this.f40535e) {
            viewHolder.f40540c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f.e().a(this.f40534d, this.f40535e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.f40537g);
        gradientDrawable.setStroke(c.a.v.b.f.a.a(this.f40534d, 1.0f), f.e().a(this.f40534d, this.f40535e, "color_white1"));
        viewHolder.f40541d.setBackgroundDrawable(gradientDrawable);
        this.f40536f = f.e().n();
        if (j.a(viewHolder.f40543f) || viewHolder.f40543f.equals(this.f40536f)) {
            return;
        }
        viewHolder.f40543f = this.f40536f;
        if (viewHolder.f40539b.isAnimating()) {
            viewHolder.f40539b.cancelAnimation();
        }
        f(viewHolder.f40539b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.f40532b.inflate(c.a.v.c.a.d.live_feed_page_follow_list_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.f40538a = (TextView) inflate.findViewById(c.tv_item_name);
            viewHolder.f40541d = (TextView) inflate.findViewById(c.avatar_tip);
            viewHolder.f40542e = (ImageView) inflate.findViewById(c.follow_jump_more);
            viewHolder.f40539b = (LottieAnimationView) inflate.findViewById(c.avatar_lottie);
            viewHolder.f40540c = (SimpleDraweeView) inflate.findViewById(c.avatar_iv);
            viewHolder.f40543f = this.f40536f;
            f(viewHolder.f40539b);
            viewHolder.f40539b.loop(true);
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
