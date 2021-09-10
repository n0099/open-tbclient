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
import c.a.w.c.a.c;
import c.a.w.e.g.d;
import c.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f40765a;

    /* renamed from: b  reason: collision with root package name */
    public List<LiveTabEntity.TabLabelInfo> f40766b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40767c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40768d;

    /* renamed from: e  reason: collision with root package name */
    public int f40769e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f40770f;

    /* renamed from: g  reason: collision with root package name */
    public b f40771g;

    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f40772a;

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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f40773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageSubTipAdapter f40774f;

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
            this.f40774f = liveFeedPageSubTipAdapter;
            this.f40773e = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40774f.f40771g.a(this.f40773e.itemView, this.f40773e.getLayoutPosition());
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f40766b = new ArrayList();
        this.f40769e = 0;
        this.f40767c = context;
        this.f40768d = z;
        this.f40765a = LayoutInflater.from(context);
        float a2 = c.a.w.b.f.a.a(this.f40767c, 14.0f);
        this.f40770f = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40766b.size() : invokeV.intValue;
    }

    public int getSelectPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40769e : invokeV.intValue;
    }

    public LiveTabEntity.TabLabelInfo getSelectSubTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (LiveTabEntity.TabLabelInfo) d.b(this.f40766b, this.f40769e) : (LiveTabEntity.TabLabelInfo) invokeV.objValue;
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f40771g = bVar;
        }
    }

    public void setSelectPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f40769e = i2;
        }
    }

    public void setSubTabList(List<LiveTabEntity.TabLabelInfo> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || d.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.f40766b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f40766b = new ArrayList();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f40766b.size()) {
                z = false;
                break;
            }
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.f40766b.get(i2);
            if (tabLabelInfo != null && tabLabelInfo.selected) {
                this.f40769e = i2;
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            this.f40769e = 0;
        }
        this.f40766b.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        LiveTabEntity.TabLabelInfo tabLabelInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i2) == null) || (tabLabelInfo = (LiveTabEntity.TabLabelInfo) d.b(this.f40766b, i2)) == null) {
            return;
        }
        viewHolder.f40772a.setText(tabLabelInfo.name);
        if (this.f40771g != null) {
            viewHolder.itemView.setOnClickListener(new a(this, viewHolder));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(this.f40770f);
        if (i2 == this.f40769e) {
            viewHolder.f40772a.setTextColor(f.e().a(this.f40767c, this.f40768d, "color_FF33551"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f40767c, this.f40768d, "color_FF33552"), f.e().a(this.f40767c, this.f40768d, "color_FF33552")});
            viewHolder.f40772a.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            viewHolder.f40772a.setTextColor(f.e().a(this.f40767c, this.f40768d, "color_525252"));
            gradientDrawable.setColors(new int[]{f.e().a(this.f40767c, this.f40768d, "color_F5F5F53"), f.e().a(this.f40767c, this.f40768d, "color_F5F5F53")});
            viewHolder.f40772a.setTypeface(Typeface.defaultFromStyle(0));
        }
        viewHolder.f40772a.setBackgroundDrawable(gradientDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            View inflate = this.f40765a.inflate(c.a.w.c.a.d.live_feed_page_sub_tag_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.f40772a = (TextView) inflate.findViewById(c.tv_item);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
