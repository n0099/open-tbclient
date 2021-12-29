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
import c.a.x.c.a.c;
import c.a.x.g.g.d;
import c.a.x.k.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    public List<LiveTabEntity.TabLabelInfo> f35905b;

    /* renamed from: c  reason: collision with root package name */
    public Context f35906c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35907d;

    /* renamed from: e  reason: collision with root package name */
    public int f35908e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f35909f;

    /* renamed from: g  reason: collision with root package name */
    public b f35910g;

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f35911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageSubTipAdapter f35912f;

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
            this.f35912f = liveFeedPageSubTipAdapter;
            this.f35911e = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f35912f.f35910g.a(this.f35911e.itemView, this.f35911e.getLayoutPosition());
            }
        }
    }

    /* loaded from: classes10.dex */
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
        this.f35905b = new ArrayList();
        this.f35908e = 0;
        this.f35906c = context;
        this.f35907d = z;
        this.a = LayoutInflater.from(context);
        float a2 = c.a.x.b.f.a.a(this.f35906c, 14.0f);
        this.f35909f = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35905b.size() : invokeV.intValue;
    }

    public int getPosByType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.c(this.f35905b)) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f35905b.size(); i2++) {
                LiveTabEntity.TabLabelInfo tabLabelInfo = this.f35905b.get(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35908e : invokeV.intValue;
    }

    public LiveTabEntity.TabLabelInfo getSelectSubTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (LiveTabEntity.TabLabelInfo) d.b(this.f35905b, this.f35908e) : (LiveTabEntity.TabLabelInfo) invokeV.objValue;
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f35910g = bVar;
        }
    }

    public void setSelectPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f35908e = i2;
        }
    }

    public void setSubTabList(List<LiveTabEntity.TabLabelInfo> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, list, str) == null) || d.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.f35905b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f35905b = new ArrayList();
        }
        this.f35905b.addAll(list);
        this.f35908e = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f35905b.size(); i4++) {
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.f35905b.get(i4);
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
        this.f35908e = i2;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        LiveTabEntity.TabLabelInfo tabLabelInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (tabLabelInfo = (LiveTabEntity.TabLabelInfo) d.b(this.f35905b, i2)) == null) {
            return;
        }
        viewHolder.a.setText(tabLabelInfo.name);
        if (this.f35910g != null) {
            viewHolder.itemView.setOnClickListener(new a(this, viewHolder));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.f35909f);
        if (i2 == this.f35908e) {
            viewHolder.a.setTextColor(f.e().a(this.f35906c, this.f35907d, "color_FF33551"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f35906c, this.f35907d, "color_FF33552"), f.e().a(this.f35906c, this.f35907d, "color_FF33552")});
            viewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            viewHolder.a.setTextColor(f.e().a(this.f35906c, this.f35907d, "color_525252"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f35906c, this.f35907d, "color_F5F5F53"), f.e().a(this.f35906c, this.f35907d, "color_F5F5F53")});
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
            View inflate = this.a.inflate(c.a.x.c.a.d.live_feed_page_sub_tag_layout, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(c.tv_item);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
