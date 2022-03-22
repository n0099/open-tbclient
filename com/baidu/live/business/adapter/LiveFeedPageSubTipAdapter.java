package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.v.f.g.d;
import c.a.v.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    public List<LiveTabEntity.TabLabelInfo> f25711b;

    /* renamed from: c  reason: collision with root package name */
    public Context f25712c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25713d;

    /* renamed from: e  reason: collision with root package name */
    public int f25714e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f25715f;

    /* renamed from: g  reason: collision with root package name */
    public b f25716g;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewHolder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageSubTipAdapter f25717b;

        public a(LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter, ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageSubTipAdapter, viewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25717b = liveFeedPageSubTipAdapter;
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25717b.f25716g.a(this.a.itemView, this.a.getLayoutPosition());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, int i);
    }

    public LiveFeedPageSubTipAdapter(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25711b = new ArrayList();
        this.f25714e = 0;
        this.f25712c = context;
        this.f25713d = z;
        this.a = LayoutInflater.from(context);
        float a2 = c.a.v.b.f.a.a(this.f25712c, 14.0f);
        this.f25715f = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25714e : invokeV.intValue;
    }

    public LiveTabEntity.TabLabelInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (LiveTabEntity.TabLabelInfo) d.b(this.f25711b, this.f25714e) : (LiveTabEntity.TabLabelInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LiveTabEntity.TabLabelInfo tabLabelInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) || (tabLabelInfo = (LiveTabEntity.TabLabelInfo) d.b(this.f25711b, i)) == null) {
            return;
        }
        viewHolder.a.setText(tabLabelInfo.name);
        if (this.f25716g != null) {
            viewHolder.itemView.setOnClickListener(new a(this, viewHolder));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.f25715f);
        if (i == this.f25714e) {
            viewHolder.a.setTextColor(f.e().a(this.f25712c, this.f25713d, "color_FF33551"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f25712c, this.f25713d, "color_FF33552"), f.e().a(this.f25712c, this.f25713d, "color_FF33552")});
            viewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            viewHolder.a.setTextColor(f.e().a(this.f25712c, this.f25713d, "color_525252"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f25712c, this.f25713d, "color_F5F5F53"), f.e().a(this.f25712c, this.f25713d, "color_F5F5F53")});
            viewHolder.a.setTypeface(Typeface.defaultFromStyle(0));
        }
        viewHolder.a.setBackgroundDrawable(gradientDrawable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25711b.size() : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            View inflate = this.a.inflate(R.layout.obfuscated_res_0x7f0d0522, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921c7);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f25716g = bVar;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f25714e = i;
        }
    }

    public void k(List<LiveTabEntity.TabLabelInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, str) == null) || d.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.f25711b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f25711b = new ArrayList();
        }
        this.f25711b.addAll(list);
        this.f25714e = 0;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f25711b.size(); i3++) {
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.f25711b.get(i3);
            if (tabLabelInfo != null) {
                if (!TextUtils.isEmpty(str) && i == 0 && str.equals(tabLabelInfo.type)) {
                    LiveFeedPageSdk.m("Scheme指定找到了三级标签 = " + tabLabelInfo.name);
                    i = i3;
                }
                if (tabLabelInfo.selected && i2 == 0) {
                    i2 = i3;
                }
            }
        }
        if (i == 0) {
            i = i2;
        }
        this.f25714e = i;
        notifyDataSetChanged();
    }
}
