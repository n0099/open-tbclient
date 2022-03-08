package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.w.f.g.d;
import c.a.w.i.f;
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
/* loaded from: classes4.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    public List<LiveTabEntity.TabLabelInfo> f33375b;

    /* renamed from: c  reason: collision with root package name */
    public Context f33376c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33377d;

    /* renamed from: e  reason: collision with root package name */
    public int f33378e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f33379f;

    /* renamed from: g  reason: collision with root package name */
    public b f33380g;

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f33381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageSubTipAdapter f33382f;

        public a(LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter, ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageSubTipAdapter, viewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33382f = liveFeedPageSubTipAdapter;
            this.f33381e = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f33382f.f33380g.a(this.f33381e.itemView, this.f33381e.getLayoutPosition());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2);
    }

    public LiveFeedPageSubTipAdapter(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33375b = new ArrayList();
        this.f33378e = 0;
        this.f33376c = context;
        this.f33377d = z;
        this.a = LayoutInflater.from(context);
        float a2 = c.a.w.b.f.a.a(this.f33376c, 14.0f);
        this.f33379f = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33375b.size() : invokeV.intValue;
    }

    public int getPosByType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.c(this.f33375b)) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f33375b.size(); i2++) {
                LiveTabEntity.TabLabelInfo tabLabelInfo = this.f33375b.get(i2);
                if (tabLabelInfo != null && str.equals(tabLabelInfo.type)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int getSelectPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33378e : invokeV.intValue;
    }

    public LiveTabEntity.TabLabelInfo getSelectSubTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (LiveTabEntity.TabLabelInfo) d.b(this.f33375b, this.f33378e) : (LiveTabEntity.TabLabelInfo) invokeV.objValue;
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f33380g = bVar;
        }
    }

    public void setSelectPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f33378e = i2;
        }
    }

    public void setSubTabList(List<LiveTabEntity.TabLabelInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, list, str) == null) || d.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.f33375b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f33375b = new ArrayList();
        }
        this.f33375b.addAll(list);
        this.f33378e = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f33375b.size(); i4++) {
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.f33375b.get(i4);
            if (tabLabelInfo != null) {
                if (!TextUtils.isEmpty(str) && i2 == 0 && str.equals(tabLabelInfo.type)) {
                    LiveFeedPageSdk.m("Scheme指定找到了三级标签 = " + tabLabelInfo.name);
                    i2 = i4;
                }
                if (tabLabelInfo.selected && i3 == 0) {
                    i3 = i4;
                }
            }
        }
        if (i2 == 0) {
            i2 = i3;
        }
        this.f33378e = i2;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        LiveTabEntity.TabLabelInfo tabLabelInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (tabLabelInfo = (LiveTabEntity.TabLabelInfo) d.b(this.f33375b, i2)) == null) {
            return;
        }
        viewHolder.a.setText(tabLabelInfo.name);
        if (this.f33380g != null) {
            viewHolder.itemView.setOnClickListener(new a(this, viewHolder));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.f33379f);
        if (i2 == this.f33378e) {
            viewHolder.a.setTextColor(f.e().a(this.f33376c, this.f33377d, "color_FF33551"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f33376c, this.f33377d, "color_FF33552"), f.e().a(this.f33376c, this.f33377d, "color_FF33552")});
            viewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            viewHolder.a.setTextColor(f.e().a(this.f33376c, this.f33377d, "color_525252"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f33376c, this.f33377d, "color_F5F5F53"), f.e().a(this.f33376c, this.f33377d, "color_F5F5F53")});
            viewHolder.a.setTypeface(Typeface.defaultFromStyle(0));
        }
        viewHolder.a.setBackgroundDrawable(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.a.inflate(R.layout.live_feed_page_sub_tag_layout, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(R.id.tv_item);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
