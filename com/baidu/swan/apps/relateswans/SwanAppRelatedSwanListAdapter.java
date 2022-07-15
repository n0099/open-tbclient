package com.baidu.swan.apps.relateswans;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a73;
import com.repackage.ed3;
import com.repackage.el2;
import com.repackage.g03;
import com.repackage.k73;
import com.repackage.oy2;
import com.repackage.q63;
/* loaded from: classes2.dex */
public class SwanAppRelatedSwanListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public oy2 b;

    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0166a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;

            public View$OnClickListenerC0166a(a aVar, Context context, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, context, str};
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
                this.b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    SchemeRouter.invoke(this.a, this.b);
                    SwanAppRelatedSwanListAdapter.d("aboutrelated", "more", "click");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
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

        public void a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
                TextView textView = (TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f0914b7);
                if (TextUtils.isEmpty(str)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setVisibility(0);
                textView.setOnClickListener(new View$OnClickListenerC0166a(this, context, str));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes2.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ oy2.a a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ int c;

            public a(b bVar, oy2.a aVar, Context context, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar, context, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
                this.b = context;
                this.c = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.c)) {
                    return;
                }
                SchemeRouter.invoke(this.b, this.a.c);
                SwanAppRelatedSwanListAdapter.d("aboutrelated", String.valueOf(this.c), "click");
            }
        }

        /* renamed from: com.baidu.swan.apps.relateswans.SwanAppRelatedSwanListAdapter$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0167b implements ed3.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppRoundedImageView a;
            public final /* synthetic */ Context b;

            public C0167b(b bVar, SwanAppRoundedImageView swanAppRoundedImageView, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppRoundedImageView, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = swanAppRoundedImageView;
                this.b = context;
            }

            @Override // com.repackage.ed3.b
            public void a(String str, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                    if (bitmap == null) {
                        this.a.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08013e));
                    } else {
                        this.a.setImageBitmap(bitmap);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view2) {
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

        public void a(Context context, oy2.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, context, aVar, i) == null) || aVar == null) {
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R.id.obfuscated_res_0x7f091ac8)).setOnClickListener(new a(this, aVar, context, i));
            ed3.e(aVar.a, new C0167b(this, (SwanAppRoundedImageView) this.itemView.findViewById(R.id.obfuscated_res_0x7f091e74), context));
            ((TextView) this.itemView.findViewById(R.id.obfuscated_res_0x7f091e76)).setText(aVar.b);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppRelatedSwanListAdapter(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (oy2) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        k73 k73Var = new k73();
        k73Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            k73Var.a("page", str2);
            k73Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            k73Var.b = str3;
        }
        el2.a W = g03.K().q().W();
        k73Var.a = a73.n(g03.K().k());
        k73Var.f = W.H();
        k73Var.c = W.T();
        k73Var.b(a73.k(W.W()));
        k73Var.d(W.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        q63.b(k73Var);
    }

    public void e(oy2 oy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oy2Var) == null) {
            this.b = oy2Var;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            oy2 oy2Var = this.b;
            if (oy2Var == null) {
                return 0;
            }
            return oy2Var.a.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i == 0 ? 0 : 1 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        oy2 oy2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) || (oy2Var = this.b) == null) {
            return;
        }
        if (!(viewHolder instanceof b)) {
            if (viewHolder instanceof a) {
                ((a) viewHolder).a(this.a, oy2Var.b);
                return;
            }
            return;
        }
        int i2 = i - 1;
        if (i2 < 0) {
            return;
        }
        ((b) viewHolder).a(this.a, oy2Var.a.get(i2), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            if (i == 0) {
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07ca, viewGroup, false));
            }
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07cb, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public SwanAppRelatedSwanListAdapter(Context context, oy2 oy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oy2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = oy2Var;
    }
}
