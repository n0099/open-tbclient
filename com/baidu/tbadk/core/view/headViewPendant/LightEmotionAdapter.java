package com.baidu.tbadk.core.view.headViewPendant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pw4;
import com.baidu.tieba.uz4;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class LightEmotionAdapter extends RecyclerView.Adapter<LightEmotionView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public ArrayList<LightEmotionData> c;

    public void i(uz4 uz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uz4Var) == null) {
        }
    }

    /* loaded from: classes3.dex */
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
            this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908f4);
            this.b = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0908e3);
            a();
        }

        public void a() {
            EMTextView eMTextView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (eMTextView = this.b) != null) {
                pw4 d = pw4.d(eMTextView);
                d.v(R.color.CAM_X0101);
                d.A(R.string.F_X01);
                d.n(R.string.J_X07);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(LightEmotionView lightEmotionView, int i) {
        ArrayList<LightEmotionData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, lightEmotionView, i) == null) && lightEmotionView != null && (arrayList = this.c) != null) {
            LightEmotionData lightEmotionData = arrayList.get(i);
            g(lightEmotionView, lightEmotionData.getUrl());
            h(lightEmotionView, lightEmotionData.getName());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public LightEmotionView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i)) == null) {
            this.b = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d052f, viewGroup, false);
            return new LightEmotionView(this.a, this.b);
        }
        return (LightEmotionView) invokeLI.objValue;
    }

    public void g(LightEmotionView lightEmotionView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, lightEmotionView, str) == null) && str != null && lightEmotionView != null && lightEmotionView.a != null) {
            Glide.with(this.a).load(str).placeholder((int) R.drawable.obfuscated_res_0x7f080a74).into(lightEmotionView.a);
        }
    }

    public void h(LightEmotionView lightEmotionView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, lightEmotionView, str) == null) && lightEmotionView != null && lightEmotionView.b != null && !xi.isEmpty(str)) {
            lightEmotionView.b.setText(str);
        }
    }

    public void f(ArrayList<LightEmotionData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || arrayList == null) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.clear();
        this.c.addAll(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<LightEmotionData> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }
}
