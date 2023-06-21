package com.baidu.tbadk.core.view.headViewPendant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.p75;
import com.baidu.tieba.sa5;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class LightEmotionAdapter extends RecyclerView.Adapter<LightEmotionView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ArrayList<LightEmotionData> c;

    public void p(sa5 sa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sa5Var) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class LightEmotionView extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public EMTextView b;
        public Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LightEmotionView(Context context, @NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
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
            this.c = context;
            this.a = (TbImageView) view2.findViewById(R.id.emotion_view);
            this.b = (EMTextView) view2.findViewById(R.id.emotion_name);
            a();
        }

        public void a() {
            EMTextView eMTextView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (eMTextView = this.b) != null) {
                p75 d = p75.d(eMTextView);
                d.x(R.color.CAM_X0101);
                d.D(R.string.F_X01);
                d.o(R.string.J_X07);
                d.f(R.color.CAM_X0607);
            }
        }
    }

    public LightEmotionAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.c = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<LightEmotionData> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(LightEmotionView lightEmotionView, int i) {
        ArrayList<LightEmotionData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lightEmotionView, i) == null) && lightEmotionView != null && (arrayList = this.c) != null) {
            LightEmotionData lightEmotionData = arrayList.get(i);
            n(lightEmotionView, lightEmotionData.getUrl());
            o(lightEmotionView, lightEmotionData.getName());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l */
    public LightEmotionView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            this.b = LayoutInflater.from(this.a).inflate(R.layout.light_emotion_view, viewGroup, false);
            return new LightEmotionView(this.a, this.b);
        }
        return (LightEmotionView) invokeLI.objValue;
    }

    public void n(LightEmotionView lightEmotionView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, lightEmotionView, str) == null) && str != null && lightEmotionView != null && lightEmotionView.a != null) {
            Glide.with(this.a).load(str).placeholder((int) R.drawable.icon_qinghudong_emotion_load_error).into(lightEmotionView.a);
        }
    }

    public void o(LightEmotionView lightEmotionView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, lightEmotionView, str) == null) && lightEmotionView != null && lightEmotionView.b != null && !vi.isEmpty(str)) {
            lightEmotionView.b.setText(str);
        }
    }

    public void m(ArrayList<LightEmotionData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, arrayList) != null) || arrayList == null) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.clear();
        this.c.addAll(arrayList);
    }
}
