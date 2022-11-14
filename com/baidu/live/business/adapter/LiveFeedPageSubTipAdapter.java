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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.ea0;
import com.baidu.tieba.gc0;
import com.baidu.tieba.vc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater a;
    public List<LiveTabEntity.TabLabelInfo> b;
    public Context c;
    public String d;
    public int e;
    public float[] f;
    public b g;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, int i);
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

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
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewHolder a;
        public final /* synthetic */ LiveFeedPageSubTipAdapter b;

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
            this.b = liveFeedPageSubTipAdapter;
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.g.a(this.a.itemView, this.a.getLayoutPosition());
            }
        }
    }

    public LiveFeedPageSubTipAdapter(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.e = 0;
        this.c = context;
        this.d = str;
        this.a = LayoutInflater.from(context);
        float b2 = ea0.b(this.c, 14.0f);
        this.f = new float[]{b2, b2, b2, b2, b2, b2, b2, b2};
    }

    public void m(List<LiveTabEntity.TabLabelInfo> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, list, str) != null) || gc0.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.b = new ArrayList();
        }
        this.b.addAll(list);
        this.e = 0;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.b.get(i3);
            if (tabLabelInfo != null) {
                if (!TextUtils.isEmpty(str) && i == 0 && str.equals(tabLabelInfo.type)) {
                    LiveFeedPageSdk.liveLog("Scheme指定找到了三级标签 = " + tabLabelInfo.name);
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
        this.e = i;
        notifyDataSetChanged();
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
        }
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!gc0.c(this.b) && str != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    LiveTabEntity.TabLabelInfo tabLabelInfo = this.b.get(i);
                    if (tabLabelInfo != null && str.equals(tabLabelInfo.type)) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public LiveTabEntity.TabLabelInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (LiveTabEntity.TabLabelInfo) gc0.b(this.b, this.e);
        }
        return (LiveTabEntity.TabLabelInfo) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!gc0.c(this.b)) {
                this.b.clear();
            }
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LiveTabEntity.TabLabelInfo tabLabelInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i) == null) && (tabLabelInfo = (LiveTabEntity.TabLabelInfo) gc0.b(this.b, i)) != null) {
            viewHolder.a.setText(tabLabelInfo.name);
            if (this.g != null) {
                viewHolder.itemView.setOnClickListener(new a(this, viewHolder));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(this.f);
            if (i == this.e) {
                viewHolder.a.setTextColor(vc0.f().a(this.c, this.d, "color_FF33551"));
                gradientDrawable.setColors(new int[]{vc0.f().a(this.c, this.d, "color_FF33552"), vc0.f().a(this.c, this.d, "color_FF33552")});
                viewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                viewHolder.a.setTextColor(vc0.f().a(this.c, this.d, "color_525252"));
                gradientDrawable.setColors(new int[]{vc0.f().a(this.c, this.d, "color_F5F5F53"), vc0.f().a(this.c, this.d, "color_F5F5F53")});
                viewHolder.a.setTypeface(Typeface.defaultFromStyle(0));
            }
            viewHolder.a.setBackgroundDrawable(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            View inflate = this.a.inflate(R.layout.obfuscated_res_0x7f0d055d, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092404);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
