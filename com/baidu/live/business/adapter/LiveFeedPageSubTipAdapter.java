package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.w.c.a.c;
import b.a.w.e.g.d;
import b.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f39549a;

    /* renamed from: b  reason: collision with root package name */
    public List<LiveTabEntity.TabLabelInfo> f39550b;

    /* renamed from: c  reason: collision with root package name */
    public Context f39551c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39552d;

    /* renamed from: e  reason: collision with root package name */
    public int f39553e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f39554f;

    /* renamed from: g  reason: collision with root package name */
    public b f39555g;

    /* loaded from: classes7.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f39556a;

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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f39557e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageSubTipAdapter f39558f;

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
            this.f39558f = liveFeedPageSubTipAdapter;
            this.f39557e = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f39558f.f39555g.a(this.f39557e.itemView, this.f39557e.getLayoutPosition());
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f39550b = new ArrayList();
        this.f39553e = 0;
        this.f39551c = context;
        this.f39552d = z;
        this.f39549a = LayoutInflater.from(context);
        float a2 = b.a.w.b.f.a.a(this.f39551c, 14.0f);
        this.f39554f = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39550b.size() : invokeV.intValue;
    }

    public int getSelectPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39553e : invokeV.intValue;
    }

    public LiveTabEntity.TabLabelInfo getSelectSubTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (LiveTabEntity.TabLabelInfo) d.b(this.f39550b, this.f39553e) : (LiveTabEntity.TabLabelInfo) invokeV.objValue;
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f39555g = bVar;
        }
    }

    public void setSelectPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f39553e = i2;
        }
    }

    public void setSubTabList(List<LiveTabEntity.TabLabelInfo> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || d.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.f39550b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f39550b = new ArrayList();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f39550b.size()) {
                z = false;
                break;
            }
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.f39550b.get(i2);
            if (tabLabelInfo != null && tabLabelInfo.selected) {
                this.f39553e = i2;
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            this.f39553e = 0;
        }
        this.f39550b.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        LiveTabEntity.TabLabelInfo tabLabelInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i2) == null) || (tabLabelInfo = (LiveTabEntity.TabLabelInfo) d.b(this.f39550b, i2)) == null) {
            return;
        }
        viewHolder.f39556a.setText(tabLabelInfo.name);
        if (this.f39555g != null) {
            viewHolder.itemView.setOnClickListener(new a(this, viewHolder));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.f39554f);
        if (i2 == this.f39553e) {
            viewHolder.f39556a.setTextColor(f.e().a(this.f39551c, this.f39552d, "color_FF33551"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f39551c, this.f39552d, "color_FF33552"), f.e().a(this.f39551c, this.f39552d, "color_FF33552")});
            viewHolder.f39556a.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            viewHolder.f39556a.setTextColor(f.e().a(this.f39551c, this.f39552d, "color_525252"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f39551c, this.f39552d, "color_F5F5F53"), f.e().a(this.f39551c, this.f39552d, "color_F5F5F53")});
            viewHolder.f39556a.setTypeface(Typeface.defaultFromStyle(0));
        }
        viewHolder.f39556a.setBackgroundDrawable(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            View inflate = this.f39549a.inflate(b.a.w.c.a.d.live_feed_page_sub_tag_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.f39556a = (TextView) inflate.findViewById(c.tv_item);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
