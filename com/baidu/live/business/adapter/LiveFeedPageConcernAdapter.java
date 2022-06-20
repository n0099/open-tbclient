package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.d80;
import com.repackage.ia0;
import com.repackage.j80;
import com.repackage.oa0;
import com.repackage.s80;
import com.repackage.za0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public LayoutInflater b;
    public List<j80> c;
    public Context d;
    public boolean e;
    public String f;
    public float[] g;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public LottieAnimationView b;
        public SimpleDraweeView c;
        public TextView d;
        public ImageView e;
        public String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = "";
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ViewHolder b;
        public final /* synthetic */ LiveFeedPageConcernAdapter c;

        public a(LiveFeedPageConcernAdapter liveFeedPageConcernAdapter, int i, ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageConcernAdapter, Integer.valueOf(i), viewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = liveFeedPageConcernAdapter;
            this.a = i;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                LiveFeedPageSdk.m("FollowItemClick: position: " + this.a);
                int i = this.a;
                if (i < 0 || i >= this.c.c.size() || this.c.c.get(this.a) == null) {
                    return;
                }
                LiveFeedPageSdk.m("FollowItemClick: scheme: " + ((j80) this.c.c.get(this.a)).d);
                j80 j80Var = (j80) this.c.c.get(this.a);
                String str = this.c.e ? "chenjinshi" : "zhibopindao";
                if (j80Var.a) {
                    LiveFeedPageSdk.f().g().invokeScheme(this.b.itemView.getContext(), j80Var.d);
                    d80.j(this.c.d, this.c.a, str);
                    return;
                }
                LiveFeedPageSdk.f().g().invokeScheme(this.b.itemView.getContext(), j80Var.d);
                LiveHostInfo liveHostInfo = j80Var.e;
                d80.h(this.c.d, this.c.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.a + 1, j80Var.c, j80Var.b, j80Var.f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = context;
        this.a = str;
        this.e = z;
        this.b = LayoutInflater.from(context);
        this.f = za0.e().o();
        float a2 = s80.a(this.d, 8.0f);
        this.g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.size() : invokeV.intValue;
    }

    public final void h(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) && (lottieAnimationView = viewHolder.b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.b.cancelAnimation();
        }
    }

    public final void i(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.e) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(za0.e().o()) && !"dark".equals(za0.e().o())) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else {
            lottieAnimationView.setAnimation("live_feed_page_shinning_night.json");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        j80 j80Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) || (j80Var = (j80) ia0.b(this.c, i)) == null) {
            return;
        }
        if (j80Var.g) {
            String str = this.e ? "chenjinshi" : "zhibopindao";
            if (j80Var.a) {
                d80.k(this.d, this.a, str);
            } else {
                LiveHostInfo liveHostInfo = j80Var.e;
                d80.i(this.d, this.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i + 1, j80Var.c, j80Var.b, j80Var.f);
            }
            j80Var.g = false;
        }
        if (j80Var.a) {
            h(viewHolder);
            if (this.e) {
                viewHolder.e.setImageResource(R.drawable.obfuscated_res_0x7f080d2a);
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(za0.e().o()) && !"dark".equals(za0.e().o())) {
                viewHolder.e.setImageResource(R.drawable.obfuscated_res_0x7f080d29);
            } else {
                viewHolder.e.setImageResource(R.drawable.obfuscated_res_0x7f080d2b);
            }
            viewHolder.e.setVisibility(0);
            viewHolder.b.setVisibility(8);
            viewHolder.d.setVisibility(8);
            viewHolder.c.setVisibility(8);
        } else {
            viewHolder.e.setVisibility(8);
            viewHolder.b.setVisibility(0);
            viewHolder.d.setVisibility(0);
            viewHolder.c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = j80Var.e;
            if (liveHostInfo2 != null) {
                viewHolder.c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.d.setTextColor(za0.e().a(this.d, this.e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = j80Var.e;
        if (liveHostInfo3 != null) {
            if (oa0.a(liveHostInfo3.name)) {
                viewHolder.a.setText(R.string.obfuscated_res_0x7f0f0a0b);
            } else {
                viewHolder.a.setText(j80Var.e.name);
            }
            viewHolder.a.setTextColor(za0.e().a(this.d, this.e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i, viewHolder));
        viewHolder.c.getHierarchy().setPlaceholderImage(za0.e().j(this.e), ScalingUtils.ScaleType.FIT_XY);
        if (this.e) {
            viewHolder.c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(za0.e().a(this.d, this.e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.g);
        gradientDrawable.setStroke(s80.a(this.d, 1.0f), za0.e().a(this.d, this.e, "color_white1"));
        viewHolder.d.setBackgroundDrawable(gradientDrawable);
        this.f = za0.e().o();
        if (oa0.a(viewHolder.f) || viewHolder.f.equals(this.f)) {
            return;
        }
        viewHolder.f = this.f;
        if (viewHolder.b.isAnimating()) {
            viewHolder.b.cancelAnimation();
        }
        i(viewHolder.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            View inflate = this.b.inflate(R.layout.obfuscated_res_0x7f0d04f5, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921a4);
            viewHolder.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902f0);
            viewHolder.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909d6);
            viewHolder.b = (LottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f0902eb);
            viewHolder.c = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0902ea);
            viewHolder.f = this.f;
            i(viewHolder.b);
            viewHolder.b.loop(true);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewHolder) == null) {
            super.onViewAttachedToWindow(viewHolder);
            p(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            h(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewHolder) == null) {
            super.onViewRecycled(viewHolder);
            h(viewHolder);
        }
    }

    public void o(List<j80> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || ia0.c(list)) {
            return;
        }
        List<j80> list2 = this.c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.c = new ArrayList();
        }
        this.c.addAll(list);
        notifyDataSetChanged();
    }

    public final void p(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, viewHolder) == null) || (lottieAnimationView = viewHolder.b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.b.isAnimating()) {
            return;
        }
        viewHolder.b.playAnimation();
    }
}
